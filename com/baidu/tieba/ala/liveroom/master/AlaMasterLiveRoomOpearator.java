package com.baidu.tieba.ala.liveroom.master;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.af.a;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.d.i;
import com.baidu.live.d.p;
import com.baidu.live.d.u;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.aq;
import com.baidu.live.data.ar;
import com.baidu.live.data.ba;
import com.baidu.live.data.bb;
import com.baidu.live.data.be;
import com.baidu.live.data.bm;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.ag;
import com.baidu.live.gift.ak;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.k;
import com.baidu.live.im.m;
import com.baidu.live.liveroom.middleware.g;
import com.baidu.live.message.AlaSetPrivateResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.atomdata.EditHeadActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.data.AlaVideoBCChatData;
import com.baidu.live.tbadk.coreextra.data.PhotoUrlData;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.img.WriteImagesInfo;
import com.baidu.live.tbadk.live.finish.FinishLiveManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tieba.view.bubbleview.BubbleLayout;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.audiencelist.c;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.h.d;
import com.baidu.tieba.ala.liveroom.master.panel.b;
import com.baidu.tieba.ala.liveroom.messages.GuardClubInfoRenameResponseMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView;
import com.baidu.tieba.ala.liveroom.views.e;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String hvk;
    private BdUniqueId bAQ;
    private boolean bAR;
    private boolean bAS;
    private com.baidu.live.guardclub.a bja;
    private boolean bqg;
    private PendantParentView buZ;
    private boolean gGG;
    private Dialog gOH;
    private String gOd;
    private View gOe;
    private com.baidu.live.ao.a gTT;
    private String hde;
    private c heL;
    private com.baidu.tieba.ala.liveroom.o.a heM;
    private com.baidu.tieba.ala.liveroom.audiencelist.b heP;
    private com.baidu.tieba.ala.liveroom.activeview.b heR;
    protected com.baidu.live.ad.a heY;
    private com.baidu.live.i.a hej;
    private com.baidu.live.j.b hfH;
    private com.baidu.tieba.ala.liveroom.share.c hfJ;
    private com.baidu.tieba.ala.liveroom.r.b hfK;
    private m hfV;
    private k hfW;
    private com.baidu.live.im.b.a hfX;
    private ad hfY;
    private ab hfZ;
    protected com.baidu.live.s.a hgD;
    private boolean hgQ;
    protected ag hgk;
    protected com.baidu.live.l.a hgq;
    protected com.baidu.live.v.a hgr;
    protected com.baidu.live.t.a hgs;
    protected com.baidu.live.a.a hgt;
    protected com.baidu.live.k.a hgu;
    protected com.baidu.live.t.b hgv;
    private com.baidu.live.aa.a hgz;
    private e hjc;
    private ImageView hjj;
    private f hjk;
    private boolean huU;
    private AlaLiveCountDownView hvA;
    private AlaLiveStreamStatusView hvB;
    private RelativeLayout hvC;
    private RelativeLayout hvD;
    private RelativeLayout hvE;
    private RelativeLayout hvF;
    private RelativeLayout hvG;
    private FrameLayout hvH;
    private FrameLayout hvI;
    private View hvJ;
    private boolean hvK;
    private AlaLiveFaceVerifyView hvL;
    private ImageView hvM;
    private ImageView hvN;
    private ImageView hvO;
    private ImageView hvP;
    private ImageView hvQ;
    private ImageView hvR;
    private ImageView hvS;
    private TextView hvT;
    private ar hvU;
    private com.baidu.live.n.b hvW;
    private com.baidu.live.ah.a hvX;
    private com.baidu.tieba.ala.liveroom.master.panel.b hvY;
    private com.baidu.live.af.a hvZ;
    private boolean hvl;
    private d hvn;
    private com.baidu.tieba.ala.liveroom.o.a hvo;
    private com.baidu.tieba.ala.liveroom.b.a hvp;
    private com.baidu.tieba.ala.liveroom.u.a hvq;
    private com.baidu.tieba.ala.liveroom.w.a hvr;
    private b hvs;
    private com.baidu.tieba.ala.liveroom.tippop.a hvt;
    private com.baidu.live.t.d hvu;
    private com.baidu.live.t.c hvv;
    private com.baidu.live.v.c hvw;
    private com.baidu.live.v.b hvx;
    protected com.baidu.live.m.a hvy;
    protected com.baidu.live.an.b hvz;
    private View hwA;
    private FrameLayout hwB;
    private boolean hwC;
    private ImageView hwa;
    private com.baidu.tieba.ala.liveroom.data.d hwb;
    private short hwl;
    private com.baidu.tieba.ala.liveroom.h.b hwq;
    private com.baidu.tieba.ala.liveroom.challenge.e hwr;
    private com.baidu.live.am.a hws;
    private com.baidu.live.b.a hwt;
    private com.baidu.live.b.b hwu;
    private com.baidu.tieba.ala.liveroom.q.a hwv;
    private boolean hww;
    private WindowManager.LayoutParams hwy;
    private Window hwz;
    private boolean hvm = false;
    private boolean hgL = false;
    private Handler mHandler = new Handler();
    private Handler hvV = new Handler();
    private boolean hwc = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver hwd = null;
    private boolean hwe = false;
    private int hwf = 0;
    private int hwg = 0;
    private int hwh = 0;
    private long hwi = 0;
    private long hwj = 0;
    private volatile boolean isBackground = false;
    private Intent hwk = null;
    private int mOrientation = 1;
    private boolean hqh = false;
    private boolean hwm = false;
    private boolean hwn = true;
    private boolean hjh = false;
    private boolean hwo = true;
    private boolean hwp = true;
    private int dFt = 0;
    private String otherParams = "";
    private Handler hwx = new Handler();
    private BdUniqueId gER = BdUniqueId.gen();
    private boolean mIsKeyboardOpen = false;
    private int bqj = 0;
    private Runnable hwD = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.hej != null) {
                AlaMasterLiveRoomOpearator.this.hej.Gh();
            }
        }
    };
    private com.baidu.live.am.b bKs = new com.baidu.live.am.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.am.b
        public boolean WI() {
            if (AlaMasterLiveRoomOpearator.this.hwr != null) {
                if (AlaMasterLiveRoomOpearator.this.hgs != null) {
                    if (!AlaMasterLiveRoomOpearator.this.hwr.ccM() && !AlaMasterLiveRoomOpearator.this.hwr.ccN() && !AlaMasterLiveRoomOpearator.this.hgs.Qx() && !AlaMasterLiveRoomOpearator.this.hgs.Em()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.hwr.ccM() && !AlaMasterLiveRoomOpearator.this.hwr.ccN()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.hgs == null || AlaMasterLiveRoomOpearator.this.hgs.Qx() || AlaMasterLiveRoomOpearator.this.hgs.Em()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.am.b
        public void WJ() {
            if (AlaMasterLiveRoomOpearator.this.hwr != null) {
                AlaMasterLiveRoomOpearator.this.hwr.ccP();
            }
        }
    };
    private CustomMessageListener brg = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hjc.hqs != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.hjc.hqs.f(list, false);
                }
                for (com.baidu.live.im.data.b bVar : list) {
                    if (bVar != null) {
                        AlaMasterLiveRoomOpearator.this.I(bVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener brh = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hjc.hqs != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.hjc.hqs.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener hhk = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.hfK == null) {
                        AlaMasterLiveRoomOpearator.this.hfK = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    AlaMasterLiveRoomOpearator.this.hfK.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener hhq = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hgq != null) {
                AlaMasterLiveRoomOpearator.this.hgq.Mq();
            }
        }
    };
    private CustomMessageListener hwE = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hhi = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.69
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Ig(str);
            }
        }
    };
    private CustomMessageListener gDt = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.70
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.bvJ();
        }
    };
    private CustomMessageListener hfr = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.hfZ.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hho = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity(), a.h.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener hwF = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hwu != null) {
                w Iq = AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq();
                long j = Iq.mLiveInfo.live_id;
                long j2 = Iq.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.hwu.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener hwG = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccK().hpU);
            if (AlaMasterLiveRoomOpearator.this.hvn == null || AlaMasterLiveRoomOpearator.this.hvn.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.xa(0);
            }
            if (AlaMasterLiveRoomOpearator.this.hfW != null) {
                AlaMasterLiveRoomOpearator.this.hfW.Nd().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.hfW.Ne().hide();
            }
        }
    };
    private CustomMessageListener hhp = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.H(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq());
        }
    };
    private CustomMessageListener hht = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hgk != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) AlaMasterLiveRoomOpearator.this.hgk).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hwH = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hwv != null) {
                    AlaMasterLiveRoomOpearator.this.hwv.ir(str);
                }
            }
        }
    };
    private CustomMessageListener bAT = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.hwq != null) {
                        if (!data.aFa || AlaMasterLiveRoomOpearator.this.bAQ == null || !AlaMasterLiveRoomOpearator.this.hww) {
                            if (AlaMasterLiveRoomOpearator.this.bAQ != null && AlaMasterLiveRoomOpearator.this.bAQ == data.aEZ) {
                                if (data.aET != null && data.aET.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.hww || AlaMasterLiveRoomOpearator.this.hvn.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.hwq.c(AlaMasterLiveRoomOpearator.this.ccK().hqk.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.bAS = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.ccK().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.bAQ = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.ccK().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.hwq.a(AlaMasterLiveRoomOpearator.this.ccK().hqk.getVideoConfig(), AlaMasterLiveRoomOpearator.this.bAS);
                        if (!AlaMasterLiveRoomOpearator.this.bAS) {
                            AlaMasterLiveRoomOpearator.this.bAS = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.bAR) {
                    AlaMasterLiveRoomOpearator.this.ccK().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.bAR = false;
            }
        }
    };
    private CustomMessageListener bAU = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.ccK().hqk != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.ccK().hqk.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.d.BM().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener bon = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.bqj == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bqj == 6) {
                            AlaMasterLiveRoomOpearator.this.cho();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bqj = 0;
            }
        }
    };
    private View.OnClickListener hwI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.hvN) {
                    AlaMasterLiveRoomOpearator.this.cht();
                    AlaMasterLiveRoomOpearator.this.hvY.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.hvM) {
                    if (view == AlaMasterLiveRoomOpearator.this.hvO) {
                        AlaMasterLiveRoomOpearator.this.bvJ();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.hvP) {
                        if (view != AlaMasterLiveRoomOpearator.this.hvR) {
                            if (view == AlaMasterLiveRoomOpearator.this.hjj) {
                                if (AlaMasterLiveRoomOpearator.this.chn()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.hwr != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.hgs != null) && AlaMasterLiveRoomOpearator.this.hgs.Em()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.hgs.Qx() & (AlaMasterLiveRoomOpearator.this.hgs != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hwr.ccM()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hwr.ccN()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.hwr.ccO();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hvQ) {
                                if (AlaMasterLiveRoomOpearator.this.hvr != null) {
                                    aq cjA = AlaMasterLiveRoomOpearator.this.ccK().hpT.cjA();
                                    if (cjA == null || cjA.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(cjA.mLiveSdkInfo.mRoomId);
                                        if (cjA.mLiveSdkInfo.mCastIds != null) {
                                            str2 = cjA.mLiveSdkInfo.mCastIds.chatMCastId;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.hvr.au("", str, str2);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hvS) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.hwr.ccM() || AlaMasterLiveRoomOpearator.this.hwr.ccN() || AlaMasterLiveRoomOpearator.this.hgs.Qx() || AlaMasterLiveRoomOpearator.this.hgs.Em()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.hws != null) {
                                    AlaMasterLiveRoomOpearator.this.hws.WD();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.hvZ != null) {
                            AlaMasterLiveRoomOpearator.this.hvZ.RU();
                            AlaMasterLiveRoomOpearator.this.hvZ.cN(AlaMasterLiveRoomOpearator.this.chB());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "beauty"));
                        AlaMasterLiveRoomOpearator.this.hww = false;
                        AlaMasterLiveRoomOpearator.this.nT(true);
                        AlaMasterLiveRoomOpearator.this.hvT.setVisibility(4);
                        com.baidu.live.d.BM().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bqg) {
                        AlaMasterLiveRoomOpearator.this.cho();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bqj = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.cho();
                }
            }
        }
    };
    private CustomMessageListener hhj = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ar) {
                    AlaMasterLiveRoomOpearator.this.hgL = true;
                    AlaMasterLiveRoomOpearator.this.hvU = (ar) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.hfW != null) {
                        AlaMasterLiveRoomOpearator.this.hfW.Nd().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.hfW != null) {
                        AlaMasterLiveRoomOpearator.this.hfW.Ne().show();
                        AlaMasterLiveRoomOpearator.this.hfW.Ne().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.xa(8);
                }
            }
        }
    };
    private CustomMessageListener hwJ = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.ccK() != null && AlaMasterLiveRoomOpearator.this.ccK().hqq != null) {
                AlaMasterLiveRoomOpearator.this.ccK().hqq.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener byv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.cil();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.ccK().hpT.xh(i);
            }
        }
    };
    private CustomMessageListener hdp = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.cie();
        }
    };
    private CustomMessageListener gTU = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.ao.c)) {
                if (AlaMasterLiveRoomOpearator.this.gTT == null) {
                    AlaMasterLiveRoomOpearator.this.gTT = new com.baidu.live.ao.a(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.gTT.a((com.baidu.live.ao.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener hwK = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.PQ()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.hvY != null) {
                            AlaMasterLiveRoomOpearator.this.hvY.oa(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.hvY.ciL();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.ccK().hqk.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.hws != null) {
                        AlaMasterLiveRoomOpearator.this.hws.setMute(AlaMasterLiveRoomOpearator.this.ccK().hqk.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hvz != null) {
                        AlaMasterLiveRoomOpearator.this.hvz.setMute(AlaMasterLiveRoomOpearator.this.ccK().hqk.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hvt != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.hvt.a(AlaMasterLiveRoomOpearator.this.ccK().hqn, AlaMasterLiveRoomOpearator.this.ccK().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.ccK().pageContext.getString(a.h.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.hvt.xp(2);
                        AlaMasterLiveRoomOpearator.this.hvt.a(AlaMasterLiveRoomOpearator.this.ccK().hqn, string, 3);
                    }
                }
            }
        }
    };
    private e.a hwL = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cis() {
            AlaMasterLiveRoomOpearator.this.wZ(a.h.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cit() {
            AlaMasterLiveRoomOpearator.this.wZ(a.h.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a hwM = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.liveroom.a.a
        public boolean fh(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void fi(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.ccK().ceG() == 1) {
                AlaMasterLiveRoomOpearator.this.ccK().hqk.stopRecord();
            }
        }
    };
    private IShareCallback hwN = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.hwc && AlaMasterLiveRoomOpearator.this.hwb != null) {
                AlaMasterLiveRoomOpearator.this.hwc = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.hwb);
            }
        }
    };
    private View.OnTouchListener hwO = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.ccK().hqq.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccK().hpU);
            AlaMasterLiveRoomOpearator.this.xa(0);
            if (AlaMasterLiveRoomOpearator.this.hfW != null) {
                AlaMasterLiveRoomOpearator.this.hfW.Nd().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.hfW.Ne().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b hwP = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ciu() {
            AlaMasterLiveRoomOpearator.this.chp();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void civ() {
            AlaMasterLiveRoomOpearator.this.huU = AlaMasterLiveRoomOpearator.this.hvn.cey();
            AlaMasterLiveRoomOpearator.this.ccK().hqq.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.ccK().hqq.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.ccK().hqq.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.hqe = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.ccK().ceG();
            dVar.title = AlaMasterLiveRoomOpearator.this.hvn.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hqf = AlaMasterLiveRoomOpearator.this.hvn.cez();
            dVar.hqi = AlaMasterLiveRoomOpearator.this.huU;
            dVar.hqh = AlaMasterLiveRoomOpearator.this.hvn.cew();
            dVar.hqg = AlaMasterLiveRoomOpearator.this.hvn.ceB();
            dVar.hqj = AlaMasterLiveRoomOpearator.this.hvn.cex();
            if (dVar.hqj) {
                if (AlaMasterLiveRoomOpearator.this.hvn.ceC()) {
                    AlaMasterLiveRoomOpearator.this.hwc = true;
                    AlaMasterLiveRoomOpearator.this.hwb = dVar;
                    AlaMasterLiveRoomOpearator.this.hvn.ceD();
                } else {
                    AlaMasterLiveRoomOpearator.this.c(dVar);
                }
                if (FinishLiveManager.getInstance().getFinishListener() != null) {
                    FinishLiveManager.getInstance().getFinishListener().onStartLive();
                }
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_END);
                    alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    return;
                }
                return;
            }
            AlaMasterLiveRoomOpearator.this.ccK().pageContext.showToast(a.h.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.ccK().g((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ciw() {
            AlaMasterLiveRoomOpearator.this.hww = true;
            AlaMasterLiveRoomOpearator.this.nT(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean cix() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ciy() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private CustomMessageListener blO = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.caJ();
            }
        }
    };
    private com.baidu.live.liveroom.g.c hwQ = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void PL() {
            if (AlaMasterLiveRoomOpearator.this.hvr != null) {
                AlaMasterLiveRoomOpearator.this.hvr.on(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cA(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.hvZ != null) {
                        AlaMasterLiveRoomOpearator.this.hvZ.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hvZ != null) {
                    AlaMasterLiveRoomOpearator.this.hvZ.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.hvr != null) {
                    AlaMasterLiveRoomOpearator.this.hvr.on(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.hgk != null) {
                    AlaMasterLiveRoomOpearator.this.hgk.bE(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a hwR = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void aia() {
            if (AlaMasterLiveRoomOpearator.this.hvL != null && AlaMasterLiveRoomOpearator.this.ccK().hqn.indexOfChild(AlaMasterLiveRoomOpearator.this.hvL) >= 0) {
                AlaMasterLiveRoomOpearator.this.ccK().hqn.removeView(AlaMasterLiveRoomOpearator.this.hvL);
                AlaMasterLiveRoomOpearator.this.hvL.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.hvL = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hfw = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void s(View view, int i) {
            w Iq;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.cik();
            } else if (i == 14 && (Iq = AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq()) != null && Iq.aJV != null && Iq.mLiveInfo != null && Iq.aKr != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity(), Iq.aJV.userName, Long.toString(Iq.aJV.userId), Long.toString(Iq.aJV.charmCount), String.valueOf(Iq.mLiveInfo.group_id), String.valueOf(Iq.mLiveInfo.live_id), true, String.valueOf(Iq.aJV.userId), Long.toString(Iq.aKr.userId), Iq.aKr.userName, Iq.aKr.portrait, AlaMasterLiveRoomOpearator.this.heP.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Iq.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.heP.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a hwS = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };
    private g hwT = new g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
    };
    private Runnable hwU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        @Override // java.lang.Runnable
        public void run() {
            AlaMasterLiveRoomOpearator.this.cir();
        }
    };
    private HttpMessageListener gNF = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == AlaMasterLiveRoomOpearator.this.gER && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bja != null) {
                AlaMasterLiveRoomOpearator.this.bja = guardClubInfoHttpResponseMessage.bja;
            }
        }
    };
    HttpMessageListener gNX = new HttpMessageListener(1021231) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021231) {
                if (!(httpResponsedMessage instanceof GuardClubInfoRenameResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = "修改真爱团名称失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString, 0);
                    return;
                }
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bja;
                if (aVar == null || AlaMasterLiveRoomOpearator.this.bja == null || AlaMasterLiveRoomOpearator.this.bja.id != aVar.id) {
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "修改真爱团名称失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                    return;
                }
                BdUtilHelper.getCustomToast().showToast("修改成功", 0);
            }
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.68
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity());
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity());
            if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = true;
                TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                AlaMasterLiveRoomOpearator.this.hwy.gravity = 80;
                AlaMasterLiveRoomOpearator.this.hwy.x = 0;
                AlaMasterLiveRoomOpearator.this.hwy.y = 50;
                AlaMasterLiveRoomOpearator.this.hwz.setAttributes(AlaMasterLiveRoomOpearator.this.hwy);
            } else if (screenFullSize[1] - rect.height() <= statusBarHeight && AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = false;
                AlaMasterLiveRoomOpearator.this.hwy.gravity = 17;
                AlaMasterLiveRoomOpearator.this.hwy.x = 0;
                AlaMasterLiveRoomOpearator.this.hwy.y = 0;
                AlaMasterLiveRoomOpearator.this.hwz.setAttributes(AlaMasterLiveRoomOpearator.this.hwy);
            }
        }
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.b.aAz);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        hvk = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    private void Ix(String str) {
        if (!TextUtils.isEmpty(str) && this.hvW != null) {
            View NT = this.hvW.NT();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            NT.setLayoutParams(layoutParams);
            if (ccK().hpU.indexOfChild(NT) >= 0) {
                ccK().hpU.removeView(NT);
            }
            ccK().hpU.addView(NT);
            this.hvW.ih(str);
            NT.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.ae.a.RB().brA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(ccK().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.ae.a.RB().brA.aOt, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ig(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccK().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(ccK().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.RB().brA.aNR;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? ccK().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt) : ccK().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(ccK().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caJ() {
        int i = ccK().hpT.Iq().aJV.isUegBlock;
        int i2 = ccK().hpT.Iq().aJV.isBlock;
        String str = ccK().hpT.Iq().aJV.userName;
        if (i > 0 || i2 > 0) {
            this.bqg = true;
            this.hfW.a(true, i, i2, str);
            return;
        }
        this.bqg = false;
        this.hfW.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.hjc.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpe == 1) {
                format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpf);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.hjc.pageContext.getPageActivity());
            bdAlertDialog.setMessage(format);
            bdAlertDialog.setPositiveButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                        BrowserHelper.startInternalWebActivity(pageActivity, "https%3A%2F%2Fufosdk.baidu.com%2F%3Fm%3DClient%26a%3DpostViewNew%26appid%3D238780%26needFbtype%3Dtrue%26hasRt%3Dfalse%26hasTitleBar%3Dfalse%26fbtnPlace%3Dbr%26channelId%3D90953");
                    } else {
                        BrowserHelper.startInternalWebActivity(pageActivity, "https://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=238780&needFbtype=true&hasRt=false&hasTitleBar=false&fbtnPlace=br&channelId=90953");
                    }
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(pageActivity.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(pageActivity.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                bdAlertDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                bdAlertDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            bdAlertDialog.create(this.hjc.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chn() {
        if (this.hws != null && this.hws.WE()) {
            BdUtilHelper.showToast(this.hjc.pageContext.getPageActivity(), this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else if (this.hvz != null && this.hvz.St()) {
            BdUtilHelper.showToast(this.hjc.pageContext.getPageActivity(), this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cho() {
        if (this.hfW != null) {
            this.hfW.Ne().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.hwr != null) {
            this.hwr.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chp() {
        if (ccK() != null && ccK().hpT != null) {
            ccK().hpT.cjt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bTU() != null && aVar.bTV() != null) {
            ccK().hpT.eB(aVar.bTU().getId(), aVar.bTV().getId());
        }
    }

    public void b(short s) {
        if (this.hwq != null) {
            this.hwq.b(s);
        }
    }

    /* loaded from: classes4.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.hwe = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.hwe = false;
                }
                if (AlaMasterLiveRoomOpearator.this.hwf == 0) {
                    AlaMasterLiveRoomOpearator.this.hwf = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.hwg == 0) {
                    AlaMasterLiveRoomOpearator.this.hwg = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.hwh = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (ccK() != null && ccK().hqo != null) {
            ccK().hqo.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.e eVar, String str) {
        this.hjc = eVar;
        this.hde = str;
    }

    protected com.baidu.tieba.ala.liveroom.data.e ccK() {
        return this.hjc;
    }

    public int a(f fVar) {
        this.hjk = fVar;
        this.hwd = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.hwd, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.hvt == null) {
            this.hvt = new com.baidu.tieba.ala.liveroom.tippop.a(this.hjc.pageContext, null);
        }
        registerListener();
        this.hej = new com.baidu.live.i.a();
        chL();
        chq();
        chs();
        Long[] lArr = new Long[1];
        this.hwi = lArr[0] == null ? 0L : lArr[0].longValue();
        this.hwj = lArr[0] != null ? lArr[0].longValue() : 0L;
        ccK().hpU.setOnTouchListener(this.hwO);
        this.hvl = SharedPrefHelper.getInstance().getBoolean(hvk, false);
        this.hvA = new AlaLiveCountDownView(ccK().pageContext.getPageActivity());
        this.hvA.setCount(3);
        this.hvA.setTextColor(ccK().pageContext.getPageActivity().getResources().getColor(a.c.sdk_white_alpha60));
        this.hvA.setTextSize(ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128));
        this.hvA.setTypeface(Typeface.DEFAULT_BOLD);
        this.hvA.setIncludeFontPadding(false);
        this.hvA.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void ciz() {
                if (AlaMasterLiveRoomOpearator.this.ccK().hpU != null) {
                    AlaMasterLiveRoomOpearator.this.ccK().hpU.removeView(AlaMasterLiveRoomOpearator.this.hvA);
                }
            }
        });
        return 1;
    }

    private void chq() {
        CustomResponsedMessage runTask;
        if (this.hvy == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.m.a.class, ccK().pageContext)) != null && runTask.getData() != null) {
            this.hvy = (com.baidu.live.m.a) runTask.getData();
            this.hvy.c(ccK().pageContext);
        }
    }

    private void chr() {
        CustomResponsedMessage runTask;
        if (chy() && this.hvz == null && (runTask = MessageManager.getInstance().runTask(2913254, com.baidu.live.an.b.class, ccK().pageContext)) != null && runTask.getData() != null) {
            this.hvz = (com.baidu.live.an.b) runTask.getData();
            if (ccK() != null && ccK().hpT != null && ccK().hpT.Iq() != null) {
                this.hvz.setLiveShowData(ccK().hpT.Iq());
            }
            if (ccK() != null && ccK().hqk != null) {
                this.hvz.L(ccK().hqk);
                this.hvz.setMute(ccK().hqk.isMute());
            }
            if (this.hvz != null && this.hvI != null) {
                this.hvz.a(new com.baidu.live.an.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                    @Override // com.baidu.live.an.a
                    public boolean Sv() {
                        if ((AlaMasterLiveRoomOpearator.this.hgs != null) && AlaMasterLiveRoomOpearator.this.hgs.Em()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                            return false;
                        }
                        if ((AlaMasterLiveRoomOpearator.this.hgs != null) & AlaMasterLiveRoomOpearator.this.hgs.Qx()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                            return false;
                        } else if (AlaMasterLiveRoomOpearator.this.hwr == null || !AlaMasterLiveRoomOpearator.this.hwr.ccM()) {
                            if (AlaMasterLiveRoomOpearator.this.hwr == null || !AlaMasterLiveRoomOpearator.this.hwr.ccN()) {
                                return true;
                            }
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        } else {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        }
                    }
                });
                View enterView = this.hvz.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hvI.setVisibility(0);
                    this.hvI.addView(enterView);
                }
            }
            if (this.hvz != null) {
                this.hvz.Y(ccK().hql);
            }
            if (this.hvz != null && ccK().hqm != null) {
                this.hvz.a(ccK().hqm);
            }
        }
    }

    private void chs() {
        View rootLayout;
        if (this.hvy != null && this.hvH != null && (rootLayout = this.hvy.ct(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hvH.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cht() {
        if (this.hvY == null) {
            this.hvY = new com.baidu.tieba.ala.liveroom.master.panel.b(ccK().pageContext.getPageActivity(), ccK().ceG() == 2);
            this.hvY.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nV(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccK().hqk.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nW(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccK().hqk.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nX(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccK().hqk.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.cij();
                    if (AlaMasterLiveRoomOpearator.this.hvt != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.hvt.a(AlaMasterLiveRoomOpearator.this.ccK().hqn, AlaMasterLiveRoomOpearator.this.ccK().pageContext.getString(a.h.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.hvt.a(AlaMasterLiveRoomOpearator.this.ccK().hqn, AlaMasterLiveRoomOpearator.this.ccK().pageContext.getString(a.h.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nY(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.g(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciA() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.ccK().hpT != null && AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq() != null && AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hvY != null) {
                        AlaMasterLiveRoomOpearator.this.hvY.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.a(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciB() {
                    if (AlaMasterLiveRoomOpearator.this.hvY != null) {
                        AlaMasterLiveRoomOpearator.this.hvY.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new i(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciC() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.ccK() != null && AlaMasterLiveRoomOpearator.this.ccK().hpT != null && AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq() != null && AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(AlaMasterLiveRoomOpearator.this.ccK().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.hvY != null) {
                            AlaMasterLiveRoomOpearator.this.hvY.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciD() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.ccK() == null || AlaMasterLiveRoomOpearator.this.ccK().hpT == null || AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq() == null || AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.ccK() != null && AlaMasterLiveRoomOpearator.this.ccK().hpT != null && AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq() != null && AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.hvY != null) {
                                        AlaMasterLiveRoomOpearator.this.hvY.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.hjc.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.hvY != null) {
                        AlaMasterLiveRoomOpearator.this.hvY.dismiss();
                    }
                }
            });
        }
        chu();
    }

    private void chu() {
        if (this.hvY != null) {
            boolean isBackCamera = ccK().hqk.isBackCamera();
            this.hvY.nZ(ccK().hqk.isBackCamera());
            this.hvY.Q(ccK().hqk.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = ccK().hqk.isPushMirror();
            if (this.hwn) {
                isPushMirror = cii() || isPushMirror;
                this.hwn = false;
            }
            this.hvY.R(isPushMirror, isBackCamera ? false : true);
            this.hvY.oa(ccK().hqk.isMute());
            this.hvY.ciL();
        }
    }

    public void chv() {
        if (this.hjk != null) {
            if (this.hjk.hqt == null || this.hjk.hqt.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.hvJ == null) {
                        this.hvJ = this.hjc.hqs.Pm();
                        this.hjc.hqn.addView(this.hvJ, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.hvn == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (ccK().hpT != null && ccK().hpT.Iq() != null && ccK().hpT.Iq().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", ccK().hpT.Iq().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", ccK().hpT.Iq().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.hvn = new d(ccK().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    ccK().hqq.prepareTime = System.currentTimeMillis();
                    ccK().hqn.addView(this.hvn.getView(), layoutParams);
                    this.hvn.a(this.hwN);
                }
                this.hvn.nB(this.hqh);
                this.hvn.a(this.hwP);
                this.hvn.a(this.hwL);
                this.hvn.a(ccK().hqk, ccK().ceG());
                this.hvn.a(this.hvy);
                return;
            }
            this.huU = this.hjk.hqt.mLiveInfo.screen_direction == 2;
            if (this.hjk.hqt.mLiveInfo.isAudioOnPrivate == 1) {
                ccK().hqk.setMute(true);
                if (this.hws != null) {
                    this.hws.setMute(ccK().hqk.isMute());
                }
                if (this.hvz != null) {
                    this.hvz.setMute(ccK().hqk.isMute());
                }
                if (this.hvt == null) {
                    this.hvt = new com.baidu.tieba.ala.liveroom.tippop.a(this.hjc.pageContext, null);
                }
                if (!this.hvt.xo(2)) {
                    this.hvt.a(ccK().hqn, ccK().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.hqe = true;
            dVar.forumId = String.valueOf(this.hjk.hqt.mLiveInfo.forum_id);
            dVar.forumName = this.hjk.hqt.mLiveInfo.forum_name;
            dVar.liveType = this.hjk.hqt.mLiveInfo.live_type;
            dVar.title = this.hjk.hqt.mLiveInfo.getLiveTitle();
            dVar.clarity = this.hjk.hqt.mLiveInfo.clarity;
            dVar.gameId = this.hjk.hqt.mLiveInfo.game_id;
            dVar.gameName = this.hjk.hqt.mLiveInfo.game_label;
            dVar.hqi = this.hjk.hqt.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void chw() {
        if (this.hwq != null) {
            this.hwq.a(ccK().hqk.getVideoConfig(), false);
        }
        if (this.hvn != null) {
            this.hvn.nA(true);
        }
        if (ccK().hqk.hasBeauty() >= 0) {
            ccK().hqk.setBeauty(com.baidu.live.d.BM().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            ccK().hqs.I(this.hjc.hqk);
        } else if (this.hvn != null) {
            this.hvn.nA(true);
        }
        chK();
    }

    public void d(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.hvJ != null && this.hvJ.getParent() != null) {
                ((ViewGroup) this.hvJ.getParent()).removeView(this.hvJ);
                this.hvJ = null;
            }
            ccK().hpU.setVisibility(0);
            this.hjc.hqs.a(ccK().hpU);
        } else {
            chS();
            cih();
            if (this.hwB != null) {
                this.hwB.setVisibility(0);
            }
            this.hvr = new com.baidu.tieba.ala.liveroom.w.a(ccK().pageContext, this.hwM);
            this.hvr.c(ccK().hpU, true);
            this.hvr.on(true);
            if (this.hfW != null && this.hfW.Nd() != null) {
                this.hfW.Nd().setNeedTopAlphaShade(true);
            }
        }
        ccK().hqk.setPushMirror(cii());
    }

    public void b(aq aqVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hjc.hqs.k(ccK().hpT.Iq());
        }
        if (!ccK().hqk.isBackground() && ccK().hpT.Iq() != null && ccK().hpT.Iq().mLiveInfo != null) {
            int startPush = ccK().hqk.startPush(ccK().hpT.Iq().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.hjc.hqs.Pn();
            }
            if (startPush != 0 && ccK().hqq != null) {
                ccK().hqq.errCode = 4;
                ccK().hqq.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (aqVar != null && !aqVar.FM() && !cif()) {
                nU(true);
                cig();
            }
            if (this.heM != null) {
                this.heM.M(ccK().hpT.Iq());
            }
            if (this.hfH != null) {
                this.hfH.a(ccK().hpT.Iq());
            }
            if (this.hvy != null) {
                this.hvy.e(ccK().hpT.Iq());
                this.hvy.ik(this.otherParams);
            }
            if (this.heM != null) {
                this.heM.nO(true);
            }
            if (this.hvo != null) {
                this.hvo.M(ccK().hpT.Iq());
            }
            if (aqVar == null || aqVar.aJV == null) {
                z = com.baidu.live.d.BM().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = aqVar.aJV.canUseChallenge;
                com.baidu.live.d.BM().putBoolean("ala_master_can_use_challenge", z);
            }
            cbG();
            chT();
            chD();
            nS(z);
            cat();
            chU();
            cia();
            N(ccK().hpT.Iq());
            f(ccK().hpT.Iq());
            cib();
            cic();
            chx();
            chX();
            cbC();
            cas();
            cbE();
            car();
            chY();
            cbo();
            cbx();
            cby();
            chQ();
            chR();
            O(ccK().hpT.Iq());
            chZ();
            cbB();
            cbp();
            MessageManager.getInstance().registerListener(this.gNF);
            MessageManager.getInstance().registerListener(this.gNX);
            bWa();
            this.hwx.postDelayed(this.hwU, IMConnection.RETRY_DELAY_TIMES);
            if (this.hfV != null) {
                this.hfV.g(ccK().hpT.Iq());
            }
            if (this.hfW != null) {
                if (ccK().hpT.Iq() != null && ccK().hpT.Iq().aKI != null && ccK().hpT.Iq().aKI.Fb()) {
                    z2 = true;
                }
                this.hfW.a(String.valueOf(ccK().hpT.Iq().mLiveInfo.group_id), String.valueOf(ccK().hpT.Iq().mLiveInfo.last_msg_id), String.valueOf(ccK().hpT.Iq().aJV.userId), String.valueOf(ccK().hpT.Iq().mLiveInfo.live_id), ccK().hpT.Iq().aJV.appId, z2, ccK().hpT.Iq().getGuardName());
            }
            if (this.hfX != null) {
                this.hfX.a(ccK().hpT.Iq(), true);
            }
            chz();
            chr();
            cbK();
            this.mHandler.post(this.hwD);
        }
    }

    protected void cbK() {
        if (this.hgD == null && ccK() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.s.a.class, ccK().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hgD = (com.baidu.live.s.a) runTask.getData();
                this.hgD.m(ccK().hpU);
            }
        }
    }

    private void chx() {
        if (this.hvp != null && ccK() != null && ccK().hpT != null) {
            if (this.hvp.au(this.hvE)) {
                this.hvp.C(ccK().hpT.Iq());
            } else {
                this.hvp.d(this.hvE, ccK().hpT.Iq());
            }
        }
    }

    private void cat() {
        if (this.buZ == null) {
            this.buZ = new PendantParentView(ccK().pageContext.getPageActivity(), this.gGG ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            ccK().hpU.addView(this.buZ, layoutParams);
            this.buZ.setDefaultItemMargin(ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.buZ.setPadding(ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            ccm();
        }
    }

    private void ccm() {
        if (this.buZ != null) {
            int dimensionPixelSize = ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278);
            int dimensionPixelSize2 = ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buZ.getLayoutParams();
            if (this.gGG) {
                this.buZ.setPosition(0, 0, this.hwr.ccs(), dimensionPixelSize2);
            } else {
                this.buZ.setPosition(dimensionPixelSize, 0, ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278), dimensionPixelSize2);
            }
            this.buZ.setLayoutParams(layoutParams);
            this.buZ.setModel(this.gGG ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void ccn() {
        if (this.hfW != null && this.hfW.Nd() != null && this.hfW.Nd().getView() != null) {
            if (this.gGG && !this.hvm && ccK().hpU != null && ccK().hpU.getHeight() > 0) {
                int bu = this.hwr != null ? this.hwr.bu(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.hfW.Nd().getView().getLayoutParams();
                int height = ccK().hpU.getHeight() - bu;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.hfW.Nd().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.ak.c.i(false, this.hvm);
            if (ccK().hpU.indexOfChild(this.hfW.Nd().getView()) != -1 && this.hfW.Nd().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hfW.Nd().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.hfW.Nd().getView().setLayoutParams(layoutParams2);
            }
            this.hfW.Nd().Nc();
        }
    }

    private void cco() {
        if (this.hfY != null) {
            if (this.gGG && !this.hvm && ccK().hpU != null && ccK().hpU.getHeight() > 0) {
                this.hfY.ek((ccK().hpU.getHeight() - (this.hwr != null ? h.o(ccK().pageContext.getPageActivity(), true) : 0)) + ccK().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height));
            } else {
                this.hfY.ek(com.baidu.live.ak.a.a(ccK().pageContext.getPageActivity(), true, false, this.hvm));
            }
        }
    }

    private void ccp() {
        int i;
        if (this.hfY != null) {
            int h = com.baidu.live.ak.a.h(true, false);
            if (!this.gGG || ccK().hpU == null || ccK().hpU.getHeight() <= 0) {
                i = h;
            } else {
                i = (ccK().hpU.getHeight() - (this.hwr != null ? this.hwr.bu(false) : 0)) + ccK().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
            }
            this.hfY.el(i);
        }
    }

    private void ccq() {
        if (this.hfX != null && this.hfX.DL() != null) {
            ViewGroup.LayoutParams layoutParams = this.hfX.DL().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ccK().pageContext.getResources().getDimensionPixelOffset(this.gGG ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hfX.DL().setLayoutParams(layoutParams);
            }
        }
    }

    private boolean chy() {
        AlaVideoBCChatData alaVideoBCChatData;
        AlaLiveInfoData alaLiveInfoData = ccK().hpT.Iq().mLiveInfo;
        if (alaLiveInfoData == null || (alaVideoBCChatData = alaLiveInfoData.videoBCEnterData) == null) {
            return false;
        }
        return alaVideoBCChatData.isShowEnter();
    }

    private void chz() {
        if (this.hvz == null && !chy()) {
            boolean z = (ccK().hpT == null || ccK().hpT.cjA() == null || ccK().hpT.cjA().mLiveInfo.videoBBChatData == null || !ccK().hpT.cjA().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
            if (!z && ccK().hpT != null && ccK().hpT.Iq() != null && ccK().hpT.Iq().mLiveInfo != null && ccK().hpT.Iq().mLiveInfo.videoBBChatData != null && ccK().hpT.Iq().aKE) {
                z = ccK().hpT.Iq().mLiveInfo.videoBBChatData.videoBBChatSwitch;
            }
            if (this.hvS != null) {
                this.hvS.setVisibility(z ? 0 : 8);
            }
            chA();
        }
    }

    private void chA() {
        CustomResponsedMessage runTask;
        if (this.hws == null && (runTask = MessageManager.getInstance().runTask(2913249, com.baidu.live.am.a.class, ccK().pageContext)) != null && runTask.getData() != null) {
            this.hws = (com.baidu.live.am.a) runTask.getData();
        }
        if (this.hws != null) {
            this.hws.v((ViewGroup) ccK().rootView.findViewById(a.f.ala_live_video_chat_pendant));
            this.hws.u(ccK().hqn);
            this.hws.s(ccK().hpT.Iq());
            this.hws.L(ccK().hqk);
            this.hws.a(ccK().hqm);
            this.hws.a(this.bKs);
            if (ccK().hqk != null) {
                this.hws.setMute(ccK().hqk.isMute());
            }
        }
    }

    private void nS(boolean z) {
        if (this.hwr == null) {
            this.hwr = new com.baidu.tieba.ala.liveroom.challenge.e(ccK());
        }
        this.hwr.a(this.hjj, this.hjk, z);
        this.hwr.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(ba baVar, be beVar, be beVar2) {
                AlaMasterLiveRoomOpearator.this.gGG = true;
                AlaMasterLiveRoomOpearator.this.ccK().hpU.hFu = false;
                if (AlaMasterLiveRoomOpearator.this.hvZ != null) {
                    AlaMasterLiveRoomOpearator.this.hvZ.fz(4);
                    AlaMasterLiveRoomOpearator.this.hvZ.cN(true);
                }
                AlaMasterLiveRoomOpearator.this.Yg();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void Es() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hwD);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void ccI() {
                AlaMasterLiveRoomOpearator.this.gGG = false;
                AlaMasterLiveRoomOpearator.this.ccK().hpU.hFu = false;
                if (AlaMasterLiveRoomOpearator.this.hvZ != null) {
                    AlaMasterLiveRoomOpearator.this.hvZ.fz(0);
                    AlaMasterLiveRoomOpearator.this.hvZ.cN(false);
                }
                AlaMasterLiveRoomOpearator.this.chC();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void ccJ() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hwD);
            }
        });
        this.hwr.N(this.huU, z);
        this.hwr.j(this.huU, z, (this.hjk == null || this.hjk.hqt == null || this.hjk.hqt.mChallengeData == null) ? false : true);
    }

    public boolean chB() {
        return this.hwr != null && this.hwr.ccR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yg() {
        if (this.hvs != null) {
            this.hvs.setVisible(8);
            this.hvs.setCanVisible(false);
        }
        if (this.heR != null) {
            this.heR.bd(true);
        }
        if (this.hvB != null) {
            this.hvB.setCanVisible(false);
            this.hvB.setVisibility(4);
        }
        if (this.hvr != null) {
            this.hvK = this.hvr.clN();
            this.hvr.om(false);
        }
        if (this.hgs != null) {
            this.hgs.setCanVisible(false);
        }
        if (this.heY != null) {
            this.heY.setCanVisible(false);
        }
        if (this.hgt != null) {
            this.hgt.bd(true);
            this.hgt.be(true);
        }
        ccm();
        ccn();
        cco();
        ccp();
        ccq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chC() {
        if (this.hvs != null) {
            this.hvs.setCanVisible(true);
        }
        if (this.heR != null) {
            this.heR.bd(false);
        }
        if (this.hvB != null) {
            this.hvB.setCanVisible(true);
            if (this.hvB.clk()) {
                this.hvB.setVisibility(0);
            }
        }
        if (this.hvr != null) {
            this.hvr.om(this.hvK);
        }
        if (this.hgs != null) {
            this.hgs.setCanVisible(true);
        }
        if (this.heY != null) {
            this.heY.cL(true);
        }
        if (this.hgt != null) {
            this.hgt.bd(false);
            this.hgt.be(false);
        }
        ccm();
        ccn();
        cco();
        ccp();
        ccq();
    }

    private void chD() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.leftMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        if (this.hvB == null) {
            this.hvB = new AlaLiveStreamStatusView(ccK().pageContext.getPageActivity());
            this.hvB.setVisibility(4);
        }
        this.hvB.setId(a.f.ala_live_room_stream_view);
        this.hvB.setLayoutParams(layoutParams);
        if (this.hvB.getParent() == null && this.hvE != null) {
            this.hvE.addView(this.hvB, layoutParams);
        }
    }

    public void chE() {
        if (this.hvn != null && this.hvn.getVisibility() != 8 && ccK().hqk.getPreview() != null) {
            ccK().hqk.stopRecord();
        }
    }

    public void chF() {
        if (ccK().hqk.getPreview() != null) {
            ccK().hqk.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hwq != null) {
                this.hwq.nz(false);
            }
            this.hwq = new com.baidu.tieba.ala.liveroom.h.b(ccK().hqn, ccK(), ccK().hqk);
            this.hwq.a(ccK().hqk.getVideoConfig(), false);
        }
        if (this.hvt != null) {
            this.hvt.ckG();
        }
        this.mHandler.post(this.hwD);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.hvm = z;
        if (z) {
            if (this.hwp) {
                this.hwp = false;
                if (this.hfW != null && this.hfW.Nd() != null) {
                    this.hfW.Nd().getView().setBottom(0);
                }
                if (this.hfW != null && this.hfW.Ne() != null) {
                    this.hfW.Ne().getView().setBottom(0);
                }
            }
            if (this.hfY != null && this.hfY.HN() != null) {
                this.hfY.HN().setVisibility(8);
            }
            if (this.hfW != null && this.hfW.Nd() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfW.Nd().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132);
                this.hfW.Nd().getView().setLayoutParams(layoutParams);
            }
            if (this.hfW != null && this.hfW.Ne() != null && this.hfW.Ne().getView() != null && this.hfW.Ne().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hfW.Ne().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.hfW.Ne().getView().setLayoutParams(layoutParams2);
                this.hfW.Ne().getView().setVisibility(0);
                this.hfW.Ne().OX();
            }
            xa(8);
            wY(8);
            if (this.hfZ != null && this.hfZ.Ip() != null) {
                this.hfZ.Ip().setVisibility(8);
            }
            if (this.hvW != null && this.hvW.NT() != null) {
                this.hvW.NT().setVisibility(8);
            }
            if (this.hgt != null) {
                this.hgt.setCanVisible(false);
            }
        } else {
            if (this.hfY != null && this.hfY.HN() != null) {
                this.hfY.HN().setVisibility(0);
            }
            if (this.hfW != null && this.hfW.Nd() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hfW.Nd().getView().getLayoutParams();
                layoutParams3.bottomMargin = ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132) - ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.hfW.Nd().getView().setLayoutParams(layoutParams3);
            }
            if (this.hfW != null && this.hfW.Ne() != null) {
                this.hfW.Ne().hide();
            }
            xa(0);
            wY(0);
            if (this.hfZ != null && this.hfZ.Ip() != null) {
                this.hfZ.Ip().setVisibility(0);
            }
            if (this.hvW != null && this.hvW.NT() != null) {
                this.hvW.NT().setVisibility(0);
            }
            if (this.hgt != null) {
                this.hgt.setCanVisible(true);
            }
        }
        if (this.hvn != null) {
            this.hvn.P(false, z);
        }
        if (this.hfX != null) {
            this.hfX.DM();
        }
        if (this.hvZ != null) {
            this.hvZ.onKeyboardVisibilityChanged(z);
        }
        if (this.hgD != null) {
            this.hgD.onKeyboardVisibilityChanged(z);
        }
        ccn();
        this.mHandler.post(this.hwD);
    }

    private void wY(int i) {
        if (this.heM != null) {
            this.heM.wM(i);
        }
        if (this.hvD != null) {
            this.hvD.setVisibility(i);
        }
        if (this.hfH != null) {
            this.hfH.getView().setVisibility(i);
        }
        if (this.hvq != null) {
            this.hvq.setVisible(i);
        }
        if (this.hvp != null) {
            this.hvp.setVisibility(i);
        }
        if (this.heR != null) {
            this.heR.setVisible(i);
        }
        if (this.hgz != null) {
            this.hgz.setCanVisible(i == 0);
        }
        if (this.hgv != null) {
            this.hgv.setVisible(i);
        }
        if (this.hgq != null) {
            this.hgq.setCanVisible(i == 0);
        }
        if (this.hgs != null) {
            this.hgs.setCanVisible(i == 0 && !this.gGG);
        }
        if (this.heY != null) {
            this.heY.cL(i == 0);
        }
        if (this.hwt != null) {
            this.hwt.setCanVisible(i == 0);
            this.hwt.refreshUI();
        }
        if (this.hvE != null) {
            this.hvE.setVisibility(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            ccK().hqq.errCode = 1;
            wZ(a.h.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            wZ(a.h.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            wZ(a.h.stream_upload_exception);
        } else if (i == -2) {
            Iy(ccK().pageContext.getResources().getString(a.h.preview_init_failed_dialog_msg));
            ccK().hqk.stopRecord();
        } else if (i == -3 && this.hvn != null) {
            this.hvn.nA(false);
        }
        if (i == -4) {
            if (this.hvn == null || this.hvn.getView().getParent() == null) {
                ccK().g((short) 1);
                return;
            }
            this.hvn.ceA();
            this.hvP.setVisibility(0);
            if (this.hvr != null) {
                this.hvr.on(true);
            }
            ccK().hpU.setBackgroundColor(ccK().pageContext.getResources().getColor(17170445));
            cio();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ays();
        if (i == 12001) {
            if (i2 == -1) {
                Iz(O(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            bvJ();
        }
    }

    public void onResume() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.hvn == null || this.hvn.getView().getParent() == null || this.hvn.getVisibility() != 0 ? "live" : "action");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_ACTION, "").setContentExt(jSONObject));
        if (this.hvn != null) {
            this.hvn.onResume();
        }
        if (this.hwc && this.hwb != null) {
            this.hwc = false;
            c(this.hwb);
        }
        if (this.hgk != null) {
            this.hgk.onResume();
        }
    }

    public void h(short s) {
        if (this.hfV != null) {
            this.hfV.IB();
        }
        if (this.hfW != null) {
            this.hfW.a(null);
            this.hfW.DN();
        }
        if (this.hfX != null) {
            this.hfX.DN();
        }
        if (this.hwr != null) {
            this.hwr.ccQ();
        }
    }

    public boolean chG() {
        w Iq = ccK().hpT.Iq();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hjc.hqs.j(Iq);
            if (Iq != null && Iq.mLiveInfo.live_status != 1) {
                cim();
                ccK().pageContext.getPageActivity().finish();
                if (ccK().hpT == null || ccK().hpT.Iq() == null) {
                    return true;
                }
                a(Iq, 1, ccK().hpT.cjJ() != 1 ? ccK().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                return true;
            }
        } else {
            if (this.hfW != null) {
                this.hfW.Nd().a(String.valueOf(Iq.mLiveInfo.group_id), String.valueOf(Iq.mLiveInfo.live_id), true, String.valueOf(Iq.aJV.userId), Iq.getGuardName());
            }
            if (this.hfX != null) {
                this.hfX.a(Iq);
            }
            if (this.hfH != null) {
                this.hfH.a(ccK().hpT.Iq());
            }
            if (this.heM != null) {
                this.heM.M(Iq);
            }
            if (Iq != null) {
                if (this.hwr != null) {
                    this.hwr.a(Iq);
                }
                if (this.hfZ != null && Iq.mLiveInfo != null) {
                    this.hfZ.a(Iq.mLiveInfo, Iq.aJV);
                }
                if (this.hgz != null) {
                    this.hgQ = this.hgz.o(Iq);
                }
                if (this.heR != null) {
                    this.heR.nc(this.hgQ);
                    this.heR.i(Iq);
                    this.heR.updateView();
                }
                if (this.hgq != null) {
                    this.hgq.a(Iq);
                }
                if (this.hgs != null) {
                    this.hgs.a(Iq);
                }
                if (this.hgr != null) {
                    this.hgr.a(Iq);
                }
                if (this.hvx != null) {
                    this.hvx.a(Iq);
                }
                if (this.hgt != null) {
                    this.hgt.a(Iq);
                }
                if (this.hgu != null) {
                    this.hgu.a(Iq);
                }
                if (this.hgv != null) {
                    this.hgv.a(Iq);
                }
                if (Iq.mLiveInfo.live_status != 1) {
                    cim();
                    ccK().pageContext.getPageActivity().finish();
                    if (ccK().hpT == null || ccK().hpT.Iq() == null) {
                        return true;
                    }
                    a(Iq, 1, ccK().hpT.cjJ() != 1 ? ccK().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                    return true;
                } else if (this.hvy != null) {
                    this.hvy.h(Iq);
                }
            }
        }
        return false;
    }

    public void chH() {
        chu();
    }

    public void chI() {
        if (this.hwq != null) {
            this.hwq.ceu();
        }
        if (this.hws != null) {
            this.hws.WG();
        }
    }

    public void chJ() {
        if (this.hvn != null && this.hvn.getVisibility() != 8) {
            if (ccK().ceG() == 2) {
                cio();
            } else {
                cin();
            }
        }
        if (this.hvn != null && this.hvn.getVisibility() != 8) {
            if (ccK().ceG() == 1) {
                this.hvn.onResume();
            }
            this.hvn.onRefresh();
        }
        if (this.hvy != null) {
            this.hvy.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.hgL && this.hvU != null) {
            if (this.hfW != null) {
                this.hfW.Nd().getView().setVisibility(0);
            }
            if (this.hfW != null) {
                this.hfW.Ne().show();
                this.hfW.Ne().setEditText(" @" + this.hvU.getNameShow() + " ");
            }
            xa(8);
            this.hgL = false;
        }
        if (this.hwu != null) {
            this.hwu.resume();
        }
        if (this.hwv != null) {
            this.hwv.resume();
        }
        if (this.gTT != null) {
            this.gTT.resume();
        }
        if (this.hws != null) {
            this.hws.WH();
        }
    }

    public void onPause() {
        if (this.hvy != null) {
            this.hvy.onPause();
        }
        if (this.hwu != null) {
            this.hwu.pause();
        }
        if (this.hgk != null) {
            this.hgk.onPause();
        }
        if (this.hwv != null) {
            this.hwv.pause();
        }
        if (this.gTT != null) {
            this.gTT.pause();
        }
    }

    private void chK() {
        if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
            this.hvP.setVisibility(0);
            this.hvP.setAlpha(0.2f);
        } else if (ccK().hqk.hasBeauty() < 0) {
            this.hvP.setVisibility(8);
        } else {
            this.hvP.setVisibility(0);
        }
    }

    private void chL() {
        this.hvC = (RelativeLayout) ccK().rootView.findViewById(a.f.ala_live_unremovable_container);
        this.hvF = (RelativeLayout) ccK().rootView.findViewById(a.f.under_live_view_panel);
        this.hvG = (RelativeLayout) ccK().rootView.findViewById(a.f.over_live_view_panel);
        this.hvH = (FrameLayout) ccK().rootView.findViewById(a.f.goods_parent);
        this.hvI = (FrameLayout) ccK().rootView.findViewById(a.f.ala_live_bc_chat_container);
        this.hjc.hpU.setOnLiveViewScrollListener(this.hwQ);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hvF.setVisibility(8);
            this.hvG.setVisibility(8);
            ccK().hpU.removeAllViews();
            return;
        }
        this.hvD = (RelativeLayout) ccK().rootView.findViewById(a.f.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hvD.getLayoutParams();
        layoutParams.topMargin = this.hjc.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.hvD.setLayoutParams(layoutParams);
        this.hvE = (RelativeLayout) ccK().rootView.findViewById(a.f.ala_live_top_pendant_container);
        if (this.heP == null) {
            this.heP = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.hjc.pageContext.getPageActivity(), true);
        }
        this.heP.a(this.hfw);
        this.heP.a(this.hvD, a.f.ala_live_room_host_header_stub, 1L);
        this.heP.setVisible(0);
        chM();
        this.hvP = (ImageView) ccK().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn);
        this.hvT = (TextView) ccK().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn_num);
        this.hvP.setOnClickListener(this.hwI);
        this.hvR = (ImageView) ccK().rootView.findViewById(a.f.ala_liveroom_host_paster);
        this.hvR.setOnClickListener(this.hwI);
        if (com.baidu.live.ae.a.RB().bxq != null && com.baidu.live.ae.a.RB().bxq.aQK != null && com.baidu.live.ae.a.RB().bxq.aQK.FR() && bm.b(com.baidu.live.ae.a.RB().bxq)) {
            this.hvR.setVisibility(0);
        } else {
            this.hvR.setVisibility(8);
        }
        chK();
        this.hvO = (ImageView) ccK().rootView.findViewById(a.f.ala_liveroom_host_share_btn);
        this.hvO.setOnClickListener(this.hwI);
        this.hvM = (ImageView) ccK().rootView.findViewById(a.f.ala_liveroom_host_message_btn);
        this.hvM.setOnClickListener(this.hwI);
        this.hjj = (ImageView) ccK().rootView.findViewById(a.f.ala_liveroom_host_pk_btn);
        this.hjj.setOnClickListener(this.hwI);
        this.hvS = (ImageView) ccK().rootView.findViewById(a.f.ala_liveroom_host_vedio_chat);
        this.hvS.setOnClickListener(this.hwI);
        this.hvN = (ImageView) ccK().rootView.findViewById(a.f.ala_liveroom_host_more);
        this.hvN.setOnClickListener(this.hwI);
        this.hvQ = (ImageView) ccK().rootView.findViewById(a.f.ala_liveroom_host_zan_btn);
        this.hvQ.setOnClickListener(this.hwI);
        chP();
        if (bm.b(com.baidu.live.ae.a.RB().bxq)) {
            this.hwq = new com.baidu.tieba.ala.liveroom.h.b(ccK().hqn, ccK(), ccK().hqk);
        }
        this.hfV = new m();
        chN();
        chO();
        if (com.baidu.live.d.BM().getInt("beauty_new_bubble", 1) == 1) {
            this.hvT.setVisibility(0);
        }
    }

    private void chM() {
        this.hwB = (FrameLayout) View.inflate(ccK().pageContext.getPageActivity(), a.g.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hwB != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.hwB.setVisibility(8);
            if (this.hwB.getParent() != null && (this.hwB.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hwB.getParent()).removeView(this.hwB);
            }
            this.hvC.addView(this.hwB, layoutParams);
            if (this.hwB != null) {
                this.hwB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.hfw.s(AlaMasterLiveRoomOpearator.this.hwB, 8);
                    }
                });
            }
        }
    }

    private void chN() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, ccK().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hfW = (k) runTask.getData();
            this.hfW.setFromMaster(true);
            this.hfW.Nd().getView().setId(a.f.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(ccK().pageContext.getPageActivity()) * 0.75f), com.baidu.live.ak.c.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.ak.c.dk(true);
            ccK().hpU.addView(this.hfW.Nd().getView(), layoutParams);
            this.hfW.Ne().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            ccK().hpU.addView(this.hfW.Ne().getView(), layoutParams2);
            this.hfW.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                @Override // com.baidu.live.im.k.a
                public boolean Nh() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void Ni() {
                }

                @Override // com.baidu.live.im.k.a
                public void id(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void Nj() {
                }

                @Override // com.baidu.live.im.k.a
                public void Nk() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean Nl() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int Nm() {
                    return 0;
                }
            });
        }
    }

    private void chO() {
        View DL;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, ccK().pageContext);
        if (runTask != null) {
            this.hfX = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hfX != null && (DL = this.hfX.DL()) != null && this.hjc.hpU.indexOfChild(DL) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.hjc.pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds98));
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            layoutParams.bottomMargin = ccK().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            ccK().hpU.addView(DL, layoutParams);
        }
    }

    private void chP() {
        CustomResponsedMessage runTask;
        if (this.hvX == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ah.a.class, ccK().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hvX = (com.baidu.live.ah.a) runTask.getData();
        }
    }

    private void chQ() {
        View HM;
        ac.d(ccK().hpT.Iq());
        ac.b(ccK().pageContext, true);
        ac.Ix();
        if (this.hfY == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVr = true;
            fVar.context = ccK().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfY = (ad) runTask.getData();
                if (this.hfY != null && (HM = this.hfY.HM()) != null && ccK().hpU.indexOfChild(HM) < 0) {
                    if (HM.getParent() instanceof ViewGroup) {
                        ((ViewGroup) HM.getParent()).removeView(HM);
                    }
                    ccK().hpU.addView(HM, ccK().hpU.getLayoutParams());
                }
            }
        }
    }

    private void chR() {
        if (!this.hwC) {
            this.hwC = true;
            com.baidu.live.entereffect.a.Gi().bA(true);
        }
    }

    protected void cby() {
        View Ip;
        if (this.hfZ == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVr = true;
            aVar.context = ccK().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfZ = (ab) runTask.getData();
            }
        }
        if (this.hfZ != null && (Ip = this.hfZ.Ip()) != null && this.hvE != null) {
            if (this.hvE.indexOfChild(Ip) < 0) {
                if (Ip.getParent() instanceof ViewGroup) {
                    ((ViewGroup) Ip.getParent()).removeView(Ip);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.hvq != null && this.hvq.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
                    layoutParams.topMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hgv != null && this.hgv.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hgu != null && this.hgu.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else {
                    layoutParams.topMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds66);
                }
                this.hvE.addView(Ip, layoutParams);
            }
            Ip.bringToFront();
        }
    }

    protected void cbx() {
        View IC;
        if (this.hgk == null) {
            ak akVar = new ak();
            akVar.aVr = true;
            akVar.pageContext = ccK().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hgk = (ag) runTask.getData();
            }
        }
        if (this.hgk != null && (IC = this.hgk.IC()) != null && ccK().hpU.indexOfChild(IC) < 0) {
            if (IC.getParent() instanceof ViewGroup) {
                ((ViewGroup) IC.getParent()).removeView(IC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            ccK().hpU.addView(IC, layoutParams);
        }
    }

    private void chS() {
        chW();
        cbD();
        chV();
        ccK().hpU.setVisibility(0);
        xa(0);
    }

    private void chT() {
        if (this.hvq == null) {
            this.hvq = new com.baidu.tieba.ala.liveroom.u.a(ccK().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.hvq.a(ccK().ceG(), j, TbadkCoreApplication.getCurrentAccountName(), true, ccK().hpT.Iq().aJV.portrait, this.otherParams, "", -1L);
        this.hvq.at(this.hvE);
    }

    private void chU() {
        if (this.hvZ == null) {
            ccK().hpU.hFu = false;
            com.baidu.live.af.a fI = fI(ccK().pageContext.getPageActivity());
            if (fI != null) {
                this.hvZ = fI;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.af.a.class, ccK().pageContext.getPageActivity());
                if (runTask != null) {
                    this.hvZ = (com.baidu.live.af.a) runTask.getData();
                }
            }
            if (this.hvZ != null) {
                this.hvZ.q(this.hvF);
                this.hvZ.r(this.hvG);
                this.hvZ.fy((ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds330) + ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96)) - ccK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds300));
                this.hvZ.s(ccK().hpU);
                this.hvZ.a(this.hej);
                this.hvZ.setLiveShowInfo(ccK().hpT.Iq());
                this.hvZ.a(this.heR);
                this.hvZ.RV();
                this.hvZ.a(new a.InterfaceC0172a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public void RW() {
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public void RX() {
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public void J(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.ccK().hqk != null) {
                            AlaMasterLiveRoomOpearator.this.ccK().hqk.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public int RY() {
                        return AlaMasterLiveRoomOpearator.this.hvD.getBottom();
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public int RZ() {
                        return AlaMasterLiveRoomOpearator.this.hjc.hpU.getHeight() - (AlaMasterLiveRoomOpearator.this.hfW.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.hfW.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.hfW.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public int Sa() {
                        return AlaMasterLiveRoomOpearator.this.hfW.Ng();
                    }
                });
            }
        }
    }

    private com.baidu.live.af.a fI(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).ba(context);
        }
        return null;
    }

    private void chV() {
        if (this.hvs == null) {
            this.hvs = new b(ccK().pageContext, ccK().hpU);
        }
    }

    private void chW() {
        if (this.heM == null) {
            this.heM = new com.baidu.tieba.ala.liveroom.o.a(ccK().pageContext, true, this.hwM);
            this.heM.e(this.hvD, null);
            this.heM.a(this.hfw);
            this.heM.nO(false);
        }
        if (this.hvo == null) {
            this.hvo = new com.baidu.tieba.ala.liveroom.o.a(ccK().pageContext, true, null);
            this.hvo.a(this.hvD, null, a.f.ala_live_room_host_header_stub);
            this.hvo.cgo();
        }
    }

    protected void cbf() {
        CustomResponsedMessage runTask;
        boolean z = false;
        aq cjA = ccK().hpT.cjA();
        boolean z2 = com.baidu.live.ae.a.RB().brA.aOs;
        if (cjA == null || cjA.aKG) {
            z = z2;
        }
        if (z && this.hfH == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.j.b.class, ccK().pageContext)) != null) {
            this.hfH = (com.baidu.live.j.b) runTask.getData();
            if (this.hfH != null) {
                this.hfH.setIsHost(true);
                this.hfH.eX(1);
                View view = this.hfH.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(ccK().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(ccK().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.f.ala_live_room_host_header_stub);
                    this.hvD.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(w wVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.heR == null) {
            this.heR = new com.baidu.tieba.ala.liveroom.activeview.b(ccK().pageContext);
        }
        this.heR.setOtherParams(this.otherParams);
        this.heR.b(wVar, false);
        this.heR.setHost(true);
        this.heR.a(1, this.buZ);
        this.heR.a(2, this.buZ);
        this.heR.nc(this.hgQ);
        this.heR.setVisible(this.hvm ? 8 : 0);
        this.heR.a(this.hej);
        if (this.hej != null) {
            if (this.heR != null) {
                alaActiveRootView2 = this.heR.ws(1);
                alaActiveRootView = this.heR.ws(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.hej.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.hej.a(alaActiveRootView);
            }
        }
    }

    private void N(w wVar) {
        CustomResponsedMessage runTask;
        if (this.hgz == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, ccK().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hgz = (com.baidu.live.aa.a) runTask.getData();
            if (this.hgz != null) {
                this.hgz.p(this.buZ);
            }
        }
        if (this.hgz != null) {
            this.hgQ = this.hgz.o(wVar);
            this.hgz.setCanVisible(!this.hvm);
        }
    }

    protected void chX() {
        CustomResponsedMessage runTask;
        if (ccK() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.l.a.class, ccK().pageContext.getPageActivity())) != null && runTask.getData() != null && this.hgq == null) {
            this.hgq = (com.baidu.live.l.a) runTask.getData();
            this.hgq.c(this.hvE, cbQ());
            if (ccK().hpT != null) {
                this.hgq.a(ccK().hpT.Iq());
            }
            this.hgq.setCanVisible(true);
            this.hgq.cd(false);
            this.hgq.a(ccK().hpT.bUu());
        }
    }

    protected void cbC() {
        CustomResponsedMessage runTask;
        if (ccK() != null && this.hgs == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.t.a.class, ccK().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hgs = (com.baidu.live.t.a) runTask.getData();
            this.hgs.setIsHost(true);
            this.hgs.a(this.buZ, ccK().hpT.Iq());
        }
    }

    protected void cas() {
        if (ccK() != null) {
            if (this.hgt == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, ccK().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hgt = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgt.bd(this.gGG);
            this.hgt.bf(false);
            this.hgt.a(this.buZ, ccK().hpT.Iq());
        }
    }

    protected void cbB() {
        if (ccK() != null) {
            if (this.hgr == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.v.a.class, ccK().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgr = (com.baidu.live.v.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (ccK().hpT != null) {
                this.hgr.b(ccK().hpT.Iq(), this.otherParams);
            }
        }
    }

    protected void car() {
        if (ccK() != null) {
            if (this.heY == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, ccK().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.heY = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.heY.setIsHost(true);
            this.heY.a(this.buZ, ccK().hpT.Iq().aKU);
        }
    }

    protected void chY() {
        CustomResponsedMessage runTask;
        if (ccK() != null && this.hvW == null && (runTask = MessageManager.getInstance().runTask(2913269, com.baidu.live.n.b.class, ccK().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hvW = (com.baidu.live.n.b) runTask.getData();
        }
    }

    protected void cbE() {
        CustomResponsedMessage runTask;
        if (ccK() != null && this.hgu == null && (runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.k.a.class, ccK().pageContext)) != null && runTask.getData() != null) {
            this.hgu = (com.baidu.live.k.a) runTask.getData();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            this.hgu.a(this.hvE, ccK().hpT.Iq(), layoutParams, this.otherParams);
        }
    }

    private void O(w wVar) {
        CustomResponsedMessage runTask;
        if (ccK() != null) {
            if (this.hvu == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.t.d.class)) != null) {
                this.hvu = (com.baidu.live.t.d) runTask.getData();
            }
            if (this.hvu != null) {
                this.hvu.Qy();
            }
            if (this.hvv == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913230, com.baidu.live.t.c.class);
                if (runTask2 != null) {
                    this.hvv = (com.baidu.live.t.c) runTask2.getData();
                }
                if (this.hvv != null) {
                    this.hvv.setParentView(this.hjc.hpU);
                    if (wVar != null && wVar.aJV != null) {
                        this.hvv.bd(wVar.aJV.userId);
                    }
                }
            }
        }
    }

    private void chZ() {
        CustomResponsedMessage runTask;
        if (ccK() != null) {
            if (this.hvw == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.v.c.class)) != null) {
                this.hvw = (com.baidu.live.v.c) runTask.getData();
            }
            if (this.hvw != null) {
                this.hvw.Qy();
            }
            if (this.hvx == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913266, com.baidu.live.v.b.class);
                if (runTask2 != null) {
                    this.hvx = (com.baidu.live.v.b) runTask2.getData();
                }
                if (this.hvx != null) {
                    this.hvx.setParentView(this.hjc.hpU);
                    this.hvx.b(ccK().hpT.Iq(), this.otherParams);
                }
            }
        }
    }

    private void cbo() {
        if (this.hwv == null) {
            this.hwv = new com.baidu.tieba.ala.liveroom.q.c(ccK().pageContext.getPageActivity());
        }
    }

    private ViewGroup.LayoutParams cbQ() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(ccK().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.f.ala_live_room_stream_view);
            layoutParams.leftMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.f.ala_liveroom_charmview);
        }
        if (this.hgv != null && this.hgv.isShowing()) {
            layoutParams.addRule(3, a.f.ala_rank_level_entry);
            layoutParams.topMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        } else if (this.hvq != null && this.hvq.isShowing()) {
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            layoutParams.topMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        }
        return layoutParams;
    }

    private void cbD() {
        if (this.hvp == null) {
            this.hvp = new com.baidu.tieba.ala.liveroom.b.a(ccK().pageContext, true);
        }
    }

    private void cia() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = ccK().pageContext.getPageActivity();
            if (this.hwa == null) {
                this.hwa = new ImageView(pageActivity);
                this.hwa.setId(a.f.master_close_btn);
                this.hwa.setTag("master_close_btn");
                this.hwa.setImageResource(a.e.sdk_icon_bar_live_close_n);
                this.hwa.setBackgroundResource(a.e.sdk_round_btn_close_bg);
                this.hwa.setPadding(pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0);
            }
            if (this.hwa.getParent() != null) {
                ((ViewGroup) this.hwa.getParent()).removeView(this.hwa);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            ccK().hqn.addView(this.hwa, layoutParams);
            this.hwa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.cik();
                }
            });
            this.hwa.setVisibility(8);
        }
    }

    protected void cbG() {
        if (this.hgv == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.t.b.class, ccK().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgv = (com.baidu.live.t.b) runTask.getData();
            } else {
                return;
            }
        }
        if (ccK().hpT.Iq() != null && ccK().hpT.Iq().aJV != null && ccK().hpT.Iq().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.height = BdUtilHelper.getDimens(ccK().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.leftMargin = BdUtilHelper.getDimens(ccK().pageContext.getPageActivity(), a.d.sdk_ds20);
            this.hgv.b(this.hvE, layoutParams, ccK().hpT.Iq());
        }
    }

    private void cib() {
        CustomResponsedMessage runTask;
        if (this.hwt == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, ccK().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.hwt = (com.baidu.live.b.a) runTask.getData();
            if (this.hwt != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.f.ala_head_line_entry_id);
                layoutParams.addRule(11);
                layoutParams.topMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
                layoutParams.rightMargin = ccK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                aq cjA = ccK().hpT.cjA();
                if (cjA != null) {
                    this.hwt.a(this.hvE, layoutParams, ccK().pageContext.getPageActivity(), cjA.aPl);
                } else {
                    return;
                }
            }
        }
        if (this.hwt != null) {
            this.hwt.a(ccK().hpT.Iq());
        }
    }

    private void cic() {
        CustomResponsedMessage runTask;
        if (this.hwu == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, ccK().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.hwu = (com.baidu.live.b.b) runTask.getData();
        }
    }

    private void cbp() {
        if (this.gTT == null) {
            this.gTT = new com.baidu.live.ao.a(ccK().pageContext.getPageActivity());
        }
    }

    public void onRtcConnected(int i) {
        if (this.hwr != null) {
            this.hwr.onRtcConnected(i);
        }
    }

    private void registerListener() {
        ccK().pageContext.registerListener(this.hhi);
        ccK().pageContext.registerListener(this.hwE);
        ccK().pageContext.registerListener(this.hhj);
        ccK().pageContext.registerListener(this.hhk);
        ccK().pageContext.registerListener(this.hwJ);
        ccK().pageContext.registerListener(this.byv);
        ccK().pageContext.registerListener(this.hdp);
        ccK().pageContext.registerListener(this.hwK);
        ccK().pageContext.registerListener(this.gDt);
        ccK().pageContext.registerListener(this.hfr);
        ccK().pageContext.registerListener(this.hho);
        ccK().pageContext.registerListener(this.bAT);
        ccK().pageContext.registerListener(this.bAU);
        ccK().pageContext.registerListener(this.hwF);
        ccK().pageContext.registerListener(this.brg);
        ccK().pageContext.registerListener(this.brh);
        ccK().pageContext.registerListener(this.hwG);
        ccK().pageContext.registerListener(this.hhq);
        ccK().pageContext.registerListener(this.hhp);
        ccK().pageContext.registerListener(this.hht);
        ccK().pageContext.registerListener(this.hwH);
        ccK().pageContext.registerListener(this.hwG);
        ccK().pageContext.registerListener(this.bon);
        ccK().pageContext.registerListener(this.blO);
        ccK().pageContext.registerListener(this.gTU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nT(boolean z) {
        if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
            ccK().pageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (ccK().hqp.Dz() == null || ListUtils.isEmpty(ccK().hqp.Dz().aET)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ccK().pageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (!this.bAR) {
                this.bAQ = BdUniqueId.gen();
                ccK().hqp.a(this.bAQ);
                this.bAR = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(ccK().pageContext.getPageActivity(), ccK().rootView);
            xa(8);
            if (ccK().hqk.hasAdvancedBeauty() && this.hwq != null) {
                if (!this.hww || this.hvn.getVisibility() == 0) {
                    this.hwq.c(ccK().hqk.getVideoConfig());
                }
                this.hwq.a(ccK().hqk.getVideoConfig(), this.bAS);
                if (!this.bAS) {
                    this.bAS = true;
                }
            }
        }
    }

    private String currentAppType(Activity activity) {
        if (activity != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                return activity.getResources().getString(a.h.sdk_permission_app_type_hk_text);
            }
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                return activity.getResources().getString(a.h.sdk_permission_app_type_qm_text);
            }
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                return activity.getResources().getString(a.h.sdk_permission_app_type_bd_text);
            }
            if (TbadkCoreApplication.getInst().isYinbo()) {
                return activity.getResources().getString(a.h.sdk_permission_app_type_yb_text);
            }
            if (TbadkCoreApplication.getInst().isOther() && !TextUtils.isEmpty(TbConfig.getSubappName())) {
                return TbConfig.getSubappName();
            }
            return activity.getResources().getString(a.h.sdk_permission_app_type_tb_text);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wZ(int i) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccK().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.h.sdk_prompt);
        bdAlertDialog.setMessageId(i, currentAppType(ccK().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.ccK().g((short) 1);
            }
        });
        bdAlertDialog.create(ccK().pageContext).show();
    }

    private void Iy(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccK().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.h.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.ccK().g((short) 1);
            }
        });
        bdAlertDialog.create(ccK().pageContext).show();
    }

    public void cid() {
        cbf();
        q bUu = ccK().hpT.bUu();
        int i = 5;
        if (bUu != null) {
            i = (int) bUu.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq() != null && AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.ccK().hpT.h(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bUu != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.hjc.hqs.b(bUu);
                return;
            }
            if (this.heL == null) {
                this.heL = new c(ccK().pageContext, this.hwM, true);
            }
            if (this.hwo) {
                this.hwo = false;
                this.heL.a(String.valueOf(ccK().hpT.Iq().mLiveInfo.group_id), String.valueOf(ccK().hpT.Iq().mLiveInfo.live_id), String.valueOf(ccK().hpT.Iq().aJV.userId), ccK().hpT.Iq());
                int i2 = a.f.ala_live_room_host_header_stub;
                if (this.hfH != null) {
                    i2 = a.f.ala_liveroom_guardthrone;
                }
                this.heL.c(this.hvD, i2, a.f.ala_liveroom_audience_count_layout);
            }
            this.heL.e(bUu);
            this.heP.setVisible(0);
            this.heP.eZ(bUu.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cie() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvJ() {
        if (ccK().hpT != null) {
            if (this.hfJ == null) {
                this.hfJ = new com.baidu.tieba.ala.liveroom.share.c(ccK().pageContext);
            }
            this.hfJ.c(ccK().hpT.Iq(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (ccK().hpT != null && ccK().hpT.Iq() != null && ccK().hpT.Iq().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", ccK().hpT.Iq().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", ccK().hpT.Iq().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", ccK().hpT.Iq().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (ccK().hpT != null && ccK().hpT.Iq() != null && ccK().hpT.Iq().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", ccK().hpT.Iq().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", ccK().hpT.Iq().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", ccK().hpT.Iq().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean cif() {
        return this.hvl;
    }

    private void nU(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(hvk, z);
        this.hvl = z;
    }

    private void cig() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccK().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.h.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.p.b(AlaMasterLiveRoomOpearator.this.ccK().pageContext).cji();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.h.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(ccK().pageContext).show();
    }

    private void cih() {
        if (this.huU && ccK().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            ccK().hqr.Vh();
        }
        ccK().hqq.prepareTime = System.currentTimeMillis() - ccK().hqq.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (ccK().hpT != null && ccK().hpT.Iq() != null && ccK().hpT.Iq().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", ccK().hpT.Iq().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", ccK().hpT.Iq().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", ccK().hqq.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hvn != null && this.hvn.getView().getParent() != null) {
            this.hvn.setVisibility(8);
            ccK().hqn.removeView(this.hvn.getView());
            this.hvn.release();
        }
        if (this.hwq != null) {
            this.hwq.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (ccK().hpU.indexOfChild(this.hvA) < 0) {
            ccK().hpU.addView(this.hvA, layoutParams);
        }
        this.hvA.xq(1000);
    }

    private void ays() {
        if (ccK().ceG() == 1) {
            ccK().hqk.startRecord();
        }
    }

    private void Iz(String str) {
        IA(str);
    }

    private void IA(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) ccK().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String O(Intent intent) {
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("album_result");
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        if (stringExtra != null) {
            writeImagesInfo.parseJson(stringExtra);
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (ListUtils.isEmpty(chosedFiles) || chosedFiles.get(0) == null) {
                return null;
            }
            return chosedFiles.get(0).getFilePath();
        }
        return null;
    }

    private void P(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.hvn != null) {
            this.hvn.In(fromJson.getSmallurl());
        }
    }

    private boolean cii() {
        return com.baidu.live.d.BM().getBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cij() {
        com.baidu.live.d.BM().putBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), this.hjc.hqk.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cik() {
        if (this.hws == null || !this.hws.Su()) {
            if (this.hvz == null || !this.hvz.Su()) {
                int i = a.h.live_close_confirm;
                if (this.hwr != null && this.hwr.ccS()) {
                    i = a.h.ala_pk_pking_close_live_roon_tip;
                } else if (this.hwr != null && this.hwr.ccR()) {
                    i = a.h.ala_challenge_challenging_close_live_room_tip;
                }
                BdAlertDialog bdAlertDialog = new BdAlertDialog(ccK().pageContext.getPageActivity());
                bdAlertDialog.setAutoNight(false);
                bdAlertDialog.setTitle((String) null);
                bdAlertDialog.setMessageId(i);
                bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                        }
                        bdAlertDialog2.dismiss();
                        if (AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq() != null) {
                            AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq(), 0, AlaMasterLiveRoomOpearator.this.ccK().hpT.cjJ() != 1 ? AlaMasterLiveRoomOpearator.this.ccK().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                        } else {
                            AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                        }
                    }
                });
                bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.create(ccK().pageContext).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (wVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = wVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = wVar.aJV;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                ccK().hpT.eD(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.hwm) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = ccK().hqq;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = ccK().hqk.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.hwi;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.hwj;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.hwe;
            if (this.hwf != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.hwg - this.hwh) / this.hwf) * 100.0f;
            }
            Intent intent = new Intent(ccK().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (ccK().hpT != null && ccK().hpT.Iq() != null && ccK().hpT.Iq().aJV != null) {
                String str3 = ccK().hpT.Iq().aJV.nickName;
                String str4 = ccK().hpT.Iq().aJV.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            w Iq = ccK().hpT.Iq();
            if (Iq != null && Iq.aJV != null && !TextUtils.isEmpty(Iq.aJV.portrait)) {
                intent.putExtra("host_portrait", Iq.aJV.portrait);
            }
            if (this.hws != null) {
                this.hws.WF();
            }
            if (this.hvz != null) {
                this.hvz.Ss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.hwk = intent;
                this.hwl = s;
                ccK().pageContext.showToast(a.h.ala_live_background_close_tip);
            } else {
                a(intent, s);
            }
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_TIME);
                if (alaLiveInfoData != null) {
                    alaStaticItem.addParams("live_id", alaLiveInfoData.live_id + "");
                    alaStaticItem.addParams("room_id", alaLiveInfoData.room_id + "");
                    alaStaticItem.addParams("time", alaLiveInfoData.getLiveDuration() + "");
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cil() {
        if (this.hwk != null) {
            a(this.hwk, this.hwl);
            this.hwk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.hwm = true;
        if (this.hwr != null) {
            this.hwr.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.hde);
            ccK().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        ccK().g(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cim() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hjc.hqs != null && this.hjc.hqs.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hwr != null && this.hwr.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hws != null && this.hws.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hwq != null && this.hwq.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hvz != null && this.hvz.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (ccK().hqo.ciR()) {
                cik();
                return true;
            }
        }
        return false;
    }

    public void sendBufferChanged(int i) {
        if (this.hvB != null) {
            this.hvB.fK(i);
        }
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (this.hjc != null && this.hjc.hpT != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.dFt != i3) {
                this.dFt = i3;
                if (this.hvt == null) {
                    this.hvt = new com.baidu.tieba.ala.liveroom.tippop.a(this.hjc.pageContext, null);
                }
                switch (this.dFt) {
                    case 0:
                        this.hvt.a(this.hjc.hqn, this.hjc.pageContext.getString(a.h.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.hvt.a(this.hjc.hqn, this.hjc.pageContext.getString(a.h.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.hvt.a(this.hjc.hqn, this.hjc.pageContext.getString(a.h.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.hjc.hpT.x(this.hjc.hpT.Iq().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I(com.baidu.live.im.data.b bVar) {
        String str;
        String str2;
        final String str3;
        JSONObject jSONObject;
        if (bVar.getMsgType() == 13 || bVar.getMsgType() == 12) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                String optString = jSONObject.optString("content_type");
                try {
                    str3 = jSONObject.optString("text");
                    str2 = optString;
                } catch (JSONException e) {
                    str = optString;
                    str2 = str;
                    str3 = null;
                    if (!"close_live".equals(str2)) {
                    }
                }
            } catch (JSONException e2) {
                str = null;
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cim();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x06d1, code lost:
        Ic(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: JSONException -> 0x07c7, TRY_LEAVE, TryCatch #3 {JSONException -> 0x07c7, blocks: (B:14:0x0049, B:16:0x0051, B:257:0x07bc), top: B:282:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x07bc A[Catch: JSONException -> 0x07c7, TRY_ENTER, TRY_LEAVE, TryCatch #3 {JSONException -> 0x07c7, blocks: (B:14:0x0049, B:16:0x0051, B:257:0x07bc), top: B:282:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        final String str;
        String str2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String optString;
        JSONObject jSONObject5;
        long j;
        long j2;
        long j3;
        String str3;
        String str4;
        boolean z;
        JSONObject jSONObject6;
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ IM消息 接收: liveSingleMessageReceived 消息分发 msgType " + bVar.getMsgType());
        }
        if (this.heR != null) {
            this.heR.G(bVar);
        }
        if (bVar.getMsgType() == 125) {
            if (this.hvr != null) {
                this.hvr.K(bVar);
            }
        } else if (bVar.getMsgType() == 13 || bVar.getMsgType() == 12) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject4 = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject4 = new JSONObject(bVar.getContent());
                }
                try {
                    String optString2 = jSONObject4.optString("content_type");
                    try {
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ IM消息 接收: liveSingleMessageReceived 消息分发 contentType: " + optString2);
                        }
                        optString = jSONObject4.optString("text");
                    } catch (JSONException e) {
                        jSONObject = jSONObject4;
                        str = null;
                        str2 = optString2;
                    }
                    try {
                        String optString3 = jSONObject4.optString("ext");
                        if (!TextUtils.isEmpty(optString3)) {
                            new JSONObject(new String(Base64.decode(optString3.getBytes(), 0)));
                        }
                        jSONObject3 = jSONObject4.optJSONObject("ext_data");
                        jSONObject2 = jSONObject4;
                        str = optString;
                        str2 = optString2;
                    } catch (JSONException e2) {
                        jSONObject = jSONObject4;
                        str = optString;
                        str2 = optString2;
                        jSONObject2 = jSONObject;
                        jSONObject3 = null;
                        if (this.hwr != null) {
                        }
                        if (!"close_live".equals(str2)) {
                        }
                        if (!(bVar.getObjContent() instanceof JSONObject)) {
                        }
                        jSONObject6.put("log_id", bVar.getMsgId());
                        if (this.hgu != null) {
                        }
                        if (this.hgs != null) {
                        }
                    }
                } catch (JSONException e3) {
                    jSONObject = jSONObject4;
                    str = null;
                    str2 = null;
                }
            } catch (JSONException e4) {
                jSONObject = null;
                str = null;
                str2 = null;
            }
            if (this.hwr != null) {
                this.hwr.gx(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cim();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccK().hpT.Iq(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (ccK().hpT.Iq() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ccK().hpT.Iq().aKr.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ccK().hpT.Iq().aKr.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        ccK().hpT.Iq().aKr.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (ccK().hpT.Iq() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (ccK().hpT.Iq() != null && ccK().hpT.Iq().aJV != null && ccK().hpT.Iq().aJV.userId == optLong2) {
                        ccK().hpT.Iq().aJV.isUegBlock = 1;
                        caJ();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (ccK().hpT.Iq() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (ccK().hpT.Iq() != null && ccK().hpT.Iq().aJV != null && ccK().hpT.Iq().aJV.userId == optLong3) {
                        ccK().hpT.Iq().aJV.isUegBlock = 0;
                        caJ();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.hvX != null) {
                    this.hvX.R(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.hvs.aJ(optString4, optInt2);
                    }
                    if (this.heP.getCount() > 20) {
                        this.heP.eZ(this.heP.getCount() + 1);
                    } else if (this.heL != null) {
                        com.baidu.live.data.a NU = bVar.NU();
                        com.baidu.live.data.p pVar = new com.baidu.live.data.p();
                        pVar.aJW = new AlaLocationData();
                        pVar.aJX = new AlaRelationData();
                        pVar.aJV = new AlaLiveUserInfoData();
                        pVar.aJV.userId = JavaTypesHelper.toLong(NU.userId, 0L);
                        pVar.aJV.userName = NU.userName;
                        pVar.aJV.portrait = NU.portrait;
                        if (this.heL.c(pVar)) {
                            this.heP.eZ(this.heP.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && ccK() != null && ccK().hpT != null && ccK().hpT.Iq() != null && ccK().hpT.Iq().aKr != null && ccK().hpT.Iq().aKr.userId == jSONObject2.optLong("user_id")) {
                    ccK().hpT.cjz();
                }
            } else if ("official_notice".equals(str2)) {
                if (jSONObject2 != null) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str5 = optLong4 + "";
                        TbadkCoreApplication.getInst();
                        if (str5.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                }
            } else if ("privilege_award_royal_success".equals(str2)) {
                if (jSONObject2 != null) {
                    String str6 = jSONObject2.optInt("effect_id") + "";
                    com.baidu.live.data.a NU2 = bVar.NU();
                    if (NU2 != null && ac.hv(str6)) {
                        ac.d(str6, 1L, "", "", NU2.userId, NU2.portrait, NU2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str2)) {
                if (jSONObject2 != null) {
                    bb bbVar = new bb();
                    bbVar.parseJson(jSONObject2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bbVar));
                }
            } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                if (jSONObject2 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                }
            } else if ("challenge_direct_new".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString5 = jSONObject2.optString("challenge_im_type");
                    if (TextUtils.equals(optString5, "start")) {
                        IB(jSONObject2.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString5, "cancel")) {
                        BdUtilHelper.showToast(ccK().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(ccK().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
            } else if ("connect_apply_show_pub".equals(str2)) {
                if (this.hvz != null) {
                    this.hvz.Q(jSONObject2);
                }
            } else if ("remove_video".equals(str2)) {
                String optString6 = jSONObject2.optString("text");
                if (jSONObject2.optString("poke_msg").isEmpty()) {
                    Ix(optString6);
                }
            }
        } else if (bVar.getMsgType() == 24) {
            com.baidu.live.data.a NU3 = bVar.NU();
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject5 = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject5 = new JSONObject(bVar.getContent());
                }
                com.baidu.live.im.data.c cVar = new com.baidu.live.im.data.c(jSONObject5);
                String optString7 = jSONObject5.optString("order_id");
                String optString8 = jSONObject5.optString(LogConfig.LOG_GIFT_ID);
                String optString9 = jSONObject5.optString("gift_count");
                String optString10 = jSONObject5.optString("gift_name");
                long optLong5 = jSONObject5.optLong("charm_total");
                String optString11 = jSONObject5.optString("attach_new");
                String optString12 = jSONObject5.optString("gift_mul");
                boolean z2 = jSONObject5.optInt("is_dynamic_gift") == 1;
                boolean z3 = jSONObject5.optInt("from_gongyanfang_2") == 1;
                boolean z4 = jSONObject5.optInt("from_gongyanfang_page") == 1;
                String str7 = null;
                if (ccK().hpT == null || ccK().hpT.Iq() == null || ccK().hpT.Iq().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                    str3 = "";
                    str4 = "";
                    z = false;
                } else {
                    long j4 = ccK().hpT.Iq().mLiveInfo.live_id;
                    long j5 = ccK().hpT.Iq().mLiveInfo.group_id;
                    long j6 = ccK().hpT.Iq().aJV.userId;
                    str7 = ccK().hpT.Iq().mLiveInfo.appId;
                    boolean z5 = ccK().hpT.Iq().mLiveInfo.isPubShow;
                    if (ccK().hpT.Iq().mLiveSdkInfo.mCastIds == null) {
                        j = j6;
                        j2 = j4;
                        j3 = j5;
                        str3 = "";
                        str4 = "";
                        z = z5;
                    } else {
                        String str8 = ccK().hpT.Iq().mLiveSdkInfo.mCastIds.chatMCastId;
                        j = j6;
                        j2 = j4;
                        j3 = j5;
                        str3 = ccK().hpT.Iq().mLiveSdkInfo.mCastIds.ensureMCastId;
                        str4 = str8;
                        z = z5;
                    }
                }
                if (!z3 || z2) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString8, "");
                    if (!this.isBackground || ccK().ceG() != 2) {
                        if (!TextUtils.isEmpty(optString11) && !TextUtils.isEmpty(optString12)) {
                            if (jSONObject5.optInt("flag_show") == 1) {
                                ac.b(cVar, NU3, String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str7, "", "", bVar.getMsgId());
                                try {
                                    JSONArray jSONArray = new JSONArray(optString12);
                                    if (jSONArray != null && jSONArray.length() > 0) {
                                        int i = 0;
                                        while (true) {
                                            if (i >= jSONArray.length()) {
                                                break;
                                            }
                                            if (com.baidu.live.ae.f.RR().ix(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                                break;
                                            }
                                            i++;
                                        }
                                    }
                                } catch (JSONException e5) {
                                    e5.printStackTrace();
                                }
                            }
                        } else {
                            bVar.setHost(z && z4);
                            ac.b(cVar, NU3, String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str7, (z4 || z3) ? false : true, true, str4, str3, bVar.getMsgId());
                        }
                    }
                    Ic(optString8);
                    if (!jSONObject5.optString("content_type").equals("tying_gift")) {
                        com.baidu.tieba.ala.liveroom.g.c cVar2 = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar2.boX = optLong5;
                        cVar2.liveId = j2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                    }
                    JSONObject jSONObject7 = new JSONObject();
                    try {
                        jSONObject7.putOpt(LogConfig.LOG_GIFT_ID, optString8);
                        jSONObject7.putOpt("gift_name", optString10);
                        jSONObject7.putOpt("order_id", optString7);
                        com.baidu.live.gift.g hr = ac.hr(optString8);
                        if (hr != null) {
                            jSONObject7.putOpt(LogConfig.LOG_GIFT_VALUE, hr.getPrice());
                        }
                        jSONObject7.putOpt("gift_num", optString9);
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "giftsend_succ").setContentExt(null, "popup", jSONObject7));
                } else {
                    return;
                }
            } catch (JSONException e7) {
            }
        }
        try {
            if (!(bVar.getObjContent() instanceof JSONObject)) {
                jSONObject6 = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject6 = new JSONObject(bVar.getContent());
            }
            try {
                jSONObject6.put("log_id", bVar.getMsgId());
            } catch (JSONException e8) {
            }
        } catch (JSONException e9) {
            jSONObject6 = null;
        }
        if (this.hgu != null) {
            this.hgu.l(bVar);
        }
        if ((this.hgs != null || !this.hgs.N(jSONObject6)) && this.heY != null && this.heY.N(jSONObject6)) {
        }
    }

    private void Ic(String str) {
        if (this.heR != null) {
            this.heR.Ic(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(int i) {
        View findViewById = ccK().rootView.findViewById(a.f.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.heR != null) {
            this.heR.bQ(2, i);
        }
    }

    private void cin() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.ccK().hqk != null && AlaMasterLiveRoomOpearator.this.ccK().hqk.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.ccK().hqk.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.ccK().hqk.startRecord();
                }
            }
        });
    }

    private void cio() {
        if (ccK().hqk != null && ccK().hqk.getPreview() != null) {
            ccK().hqk.getPreview().setVisibility(8);
            ccK().hqk.stopRecord();
        }
    }

    public void cip() {
        this.hqh = ccK().hpT.cjK();
        if (this.hvn != null) {
            this.hvn.nB(this.hqh);
        }
    }

    public void ceE() {
        if (TbadkCoreApplication.getInst().isOther()) {
            ciq();
        } else if (this.hvn != null) {
            this.hvn.ceE();
        }
    }

    public void nC(boolean z) {
        if (this.hvn != null) {
            this.hvn.nC(z);
        }
    }

    public void onDestroy() {
        if (this.hwd != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.hwd);
        }
        this.hwd = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hvV.removeCallbacksAndMessages(null);
        if (this.hwq != null) {
            this.hwq.nz(true);
        }
        this.hwq = null;
        if (this.hvn != null) {
            this.hvn.destroy();
            ccK().hqn.removeView(this.hvn.getView());
            this.hvn.release();
            this.hvn = null;
        }
        if (this.hwr != null) {
            this.hwr.onDestroy();
        }
        if (this.hfJ != null) {
            this.hfJ.onDestroy();
        }
        if (this.heM != null) {
            this.heM.onDestroy();
            this.heM = null;
        }
        if (this.hvo != null) {
            this.hvo.onDestroy();
        }
        if (this.hgk != null) {
            this.hgk.onDestroy();
            this.hgk = null;
        }
        if (this.hvA != null) {
            this.hvA.stopCountDown();
        }
        if (this.hvq != null) {
            this.hvq.onDestroy();
        }
        if (this.hvs != null) {
            this.hvs.onDestroy();
        }
        if (this.hvX != null) {
            this.hvX.onDestroy();
            this.hvX = null;
        }
        if (this.hfY != null) {
            this.hfY.onDestroy();
            this.hfY = null;
        }
        if (this.hvu != null) {
            this.hvu.release();
        }
        if (this.hvw != null) {
            this.hvw.release();
        }
        com.baidu.live.ag.a.b.Sm().release();
        ac.Iy();
        com.baidu.live.entereffect.a.Gi().release();
        this.hwC = false;
        if (this.hfZ != null) {
            this.hfZ.onDestroy();
            this.hfZ = null;
        }
        if (this.hvt != null) {
            this.hvt.onDestroy();
        }
        if (this.hvr != null) {
            this.hvr.clM();
            this.hvr.release();
        }
        if (this.heP != null) {
            this.heP = null;
        }
        if (this.heR != null) {
            this.heR.release();
        }
        if (this.hvr != null) {
            this.hvr.onDestroy();
        }
        if (this.hfX != null) {
            this.hfX.release();
        }
        if (this.hvy != null) {
            this.hvy.release();
        }
        if (this.hvZ != null) {
            this.hvZ.onDestroy();
        }
        if (this.hgz != null) {
            this.hgz.release();
        }
        if (this.hwt != null) {
            this.hwt.onDestory();
        }
        if (this.hwu != null) {
            this.hwu.release();
        }
        if (this.hgq != null) {
            this.hgq.onDestroy();
        }
        if (this.hgs != null) {
            this.hgs.onDestroy();
        }
        if (this.hgr != null) {
            this.hgr.onDestroy();
        }
        if (this.heY != null) {
            this.heY.onDestroy();
        }
        if (this.hvv != null) {
            this.hvv.release();
            this.hvv = null;
        }
        if (this.hvx != null) {
            this.hvx.release();
            this.hvx = null;
        }
        if (this.hwv != null) {
            this.hwv.release();
        }
        if (this.gTT != null) {
            this.gTT.release();
        }
        if (this.hgv != null) {
            this.hgv.onDestroy();
        }
        if (this.hws != null) {
            this.hws.onDestroy();
        }
        if (this.hvz != null) {
            this.hvz.onDestroy();
        }
        this.hwx.removeCallbacksAndMessages(this.hwU);
        MessageManager.getInstance().unRegisterListener(this.hhi);
        MessageManager.getInstance().unRegisterListener(this.hwE);
        MessageManager.getInstance().unRegisterListener(this.hhj);
        MessageManager.getInstance().unRegisterListener(this.hhk);
        MessageManager.getInstance().unRegisterListener(this.hwJ);
        MessageManager.getInstance().unRegisterListener(this.byv);
        MessageManager.getInstance().unRegisterListener(this.hdp);
        MessageManager.getInstance().unRegisterListener(this.hwK);
        MessageManager.getInstance().unRegisterListener(this.gDt);
        MessageManager.getInstance().unRegisterListener(this.hfr);
        MessageManager.getInstance().unRegisterListener(this.hho);
        MessageManager.getInstance().unRegisterListener(this.bAT);
        MessageManager.getInstance().unRegisterListener(this.bAU);
        MessageManager.getInstance().unRegisterListener(this.hwF);
        MessageManager.getInstance().unRegisterListener(this.brg);
        MessageManager.getInstance().unRegisterListener(this.brh);
        MessageManager.getInstance().unRegisterListener(this.hwG);
        MessageManager.getInstance().unRegisterListener(this.hhq);
        MessageManager.getInstance().unRegisterListener(this.hhp);
        MessageManager.getInstance().unRegisterListener(this.hht);
        MessageManager.getInstance().unRegisterListener(this.hwH);
        MessageManager.getInstance().unRegisterListener(this.hwG);
        MessageManager.getInstance().unRegisterListener(this.bon);
        MessageManager.getInstance().unRegisterListener(this.blO);
        MessageManager.getInstance().unRegisterListener(this.gTU);
        MessageManager.getInstance().unRegisterListener(this.gNF);
        MessageManager.getInstance().unRegisterListener(this.gNX);
        ccK().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hjc.hqs.a(this.hwT, this.hjc.hqm, this.hvC, alaLivePersonData);
        }
    }

    private void ciq() {
        if (this.hwb != null) {
            this.hjc.hqq.startTime = System.currentTimeMillis();
            this.hjc.hqq.liveTotalTime = System.currentTimeMillis();
            this.hjc.hqq.sampleMemAndCPU();
            this.hjc.hqo.a((short) 4, this.hwb);
        }
    }

    private void IB(String str) {
        String str2;
        int i;
        if (ccK() != null && ccK().pageContext != null) {
            this.hvV.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = ccK().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.hwA == null) {
                    this.hwA = layoutInflater.inflate(a.g.layout_challenge_entry_toast, (ViewGroup) null);
                    this.hwA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.chn()) {
                                AlaMasterLiveRoomOpearator.this.hvV.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.hwA != null) {
                                    AlaMasterLiveRoomOpearator.this.ccK().hpU.removeView(AlaMasterLiveRoomOpearator.this.hwA);
                                }
                                if (AlaMasterLiveRoomOpearator.this.hwr != null) {
                                    AlaMasterLiveRoomOpearator.this.hwr.ccO();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.hwA.findViewById(a.f.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.h.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.hvV.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.ccK().hpU != null && AlaMasterLiveRoomOpearator.this.hjj != null && AlaMasterLiveRoomOpearator.this.hwA != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.hwA.findViewById(a.f.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.hwA.findViewById(a.f.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.v((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.hwA.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.hjj.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.hjj.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.hjj.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.hjj.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.hwA.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.hwA.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.hwA != null) {
                                AlaMasterLiveRoomOpearator.this.ccK().hpU.removeView(AlaMasterLiveRoomOpearator.this.hwA);
                            }
                            AlaMasterLiveRoomOpearator.this.ccK().hpU.addView(AlaMasterLiveRoomOpearator.this.hwA, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.ae.a.RB().brA != null) {
                    i = com.baidu.live.ae.a.RB().brA.aNB;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.hvV.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.ccK().hpU != null && AlaMasterLiveRoomOpearator.this.hwA != null) {
                            AlaMasterLiveRoomOpearator.this.ccK().hpU.removeView(AlaMasterLiveRoomOpearator.this.hwA);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bWa() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            w Iq = ccK().hpT.Iq();
            if (Iq != null) {
                bVar.setAnchorId(Iq.mLiveInfo.user_id);
                bVar.setParams();
                bVar.setTag(this.gER);
                MessageManager.getInstance().sendMessage(bVar);
            }
        }
    }

    public void cir() {
        boolean z = com.baidu.live.d.BM().getBoolean("new_anchor_club_rename", true);
        aq cjA = ccK().hpT.cjA();
        if (cjA != null && this.bja != null && cjA.aPm == 1 && z) {
            ccK().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
            com.baidu.live.d.BM().putBoolean("new_anchor_club_rename", false);
            this.gOe = View.inflate(ccK().pageContext.getPageActivity(), a.g.dialog_help_guard_club_rename, null);
            this.gOH = new Dialog(ccK().pageContext.getPageActivity(), a.i.RegimentRenameDiolog);
            final Button button = (Button) this.gOe.findViewById(a.f.rename_confirm);
            button.setEnabled(false);
            button.setTextColor(ccK().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
            final EditText editText = (EditText) this.gOe.findViewById(a.f.guard_club_rename_edittext);
            final TextView textView = (TextView) this.gOe.findViewById(a.f.hint_num);
            ((Button) this.gOe.findViewById(a.f.rename_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.64
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.gOd = null;
                    AlaMasterLiveRoomOpearator.this.gOH.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.65
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (editText.getText().toString() != null) {
                        AlaMasterLiveRoomOpearator.this.gOd = editText.getText().toString();
                        if (AlaMasterLiveRoomOpearator.this.bja != null && AlaMasterLiveRoomOpearator.this.gOd != null) {
                            if (BdNetTypeUtil.isNetWorkAvailable()) {
                                AlaMasterLiveRoomOpearator.this.k(AlaMasterLiveRoomOpearator.this.bja.id, AlaMasterLiveRoomOpearator.this.gOd, "");
                            } else {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity(), "网络故障，请刷新重试");
                            }
                        } else {
                            return;
                        }
                    }
                    AlaMasterLiveRoomOpearator.this.gOH.dismiss();
                }
            });
            editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.67
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    String obj = editText.getText().toString();
                    if (obj.length() == 0) {
                        textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        textView.setText("0");
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                    }
                    if (obj.length() > 0) {
                        int i4 = 0;
                        int i5 = 0;
                        for (int i6 = 0; i6 < obj.length(); i6++) {
                            String substring = obj.substring(i6, i6 + 1);
                            if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity(), "仅支持中英文及数字");
                                editText.setText(editText.getText().subSequence(0, i6));
                                editText.setSelection(editText.getText().length());
                                textView.setText((i4 + i5) + "");
                                return;
                            }
                            if (Pattern.compile("[0-9]*").matcher(substring).matches()) {
                                i5++;
                            }
                            if (Pattern.compile("[a-zA-Z]").matcher(substring).matches()) {
                                i5++;
                            }
                            if (Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                i4++;
                            }
                            if (i5 + i4 > 3) {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity(), "不能超过3个字符");
                                editText.setText(editText.getText().subSequence(0, (i4 + i5) - 1));
                                editText.setSelection(editText.getText().length());
                                if (Pattern.compile("[0-9]*").matcher(substring).matches()) {
                                    i5--;
                                }
                                if (Pattern.compile("[a-zA-Z]").matcher(substring).matches()) {
                                    i5--;
                                }
                                if (Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                    i4--;
                                }
                                textView.setText((i4 + i5) + "");
                                return;
                            }
                            int i7 = i4 + i5;
                            textView.setText(i7 + "");
                            if (i7 == 3) {
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                            } else {
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccK().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                            }
                        }
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gOH.setContentView(this.gOe);
            this.gOH.setCanceledOnTouchOutside(true);
            this.gOe.setMinimumHeight((int) (com.baidu.tieba.ala.liveroom.h.f.getScreenHeight(ccK().pageContext.getPageActivity()) * 0.22f));
            this.hwz = this.gOH.getWindow();
            this.hwy = this.hwz.getAttributes();
            this.hwy.width = (int) (com.baidu.tieba.ala.liveroom.h.f.getScreenWidth(ccK().pageContext.getPageActivity()) * 0.74f);
            this.hwy.height = -2;
            this.hwy.gravity = 17;
            this.hwz.setAttributes(this.hwy);
            this.gOH.show();
        }
    }

    public void k(int i, String str, String str2) {
        com.baidu.tieba.ala.liveroom.messages.e eVar = new com.baidu.tieba.ala.liveroom.messages.e();
        eVar.fk(i);
        eVar.HE(str);
        eVar.HF(str2);
        eVar.setParams();
        MessageManager.getInstance().sendMessage(eVar);
    }
}
