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
import com.baidu.tieba.ala.liveroom.data.d;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
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
    private static final String hvi;
    private BdUniqueId bAQ;
    private boolean bAR;
    private boolean bAS;
    private com.baidu.live.guardclub.a bja;
    private boolean bqg;
    private PendantParentView buZ;
    private boolean gGE;
    private Dialog gOF;
    private String gOb;
    private View gOc;
    private com.baidu.live.ao.a gTR;
    private String hdc;
    private c heJ;
    private com.baidu.tieba.ala.liveroom.o.a heK;
    private com.baidu.tieba.ala.liveroom.audiencelist.b heN;
    private com.baidu.tieba.ala.liveroom.activeview.b heP;
    protected com.baidu.live.ad.a heW;
    private com.baidu.live.i.a heh;
    private com.baidu.live.j.b hfF;
    private com.baidu.tieba.ala.liveroom.share.c hfH;
    private com.baidu.tieba.ala.liveroom.r.b hfI;
    private m hfT;
    private k hfU;
    private com.baidu.live.im.b.a hfV;
    private ad hfW;
    private ab hfX;
    protected com.baidu.live.s.a hgB;
    private boolean hgO;
    protected ag hgi;
    protected com.baidu.live.l.a hgo;
    protected com.baidu.live.v.a hgp;
    protected com.baidu.live.t.a hgq;
    protected com.baidu.live.a.a hgr;
    protected com.baidu.live.k.a hgs;
    protected com.baidu.live.t.b hgt;
    private com.baidu.live.aa.a hgx;
    private e hja;
    private ImageView hjh;
    private f hji;
    private boolean huS;
    private RelativeLayout hvA;
    private RelativeLayout hvB;
    private RelativeLayout hvC;
    private RelativeLayout hvD;
    private RelativeLayout hvE;
    private FrameLayout hvF;
    private FrameLayout hvG;
    private View hvH;
    private boolean hvI;
    private AlaLiveFaceVerifyView hvJ;
    private ImageView hvK;
    private ImageView hvL;
    private ImageView hvM;
    private ImageView hvN;
    private ImageView hvO;
    private ImageView hvP;
    private ImageView hvQ;
    private TextView hvR;
    private ar hvS;
    private com.baidu.live.n.b hvU;
    private com.baidu.live.ah.a hvV;
    private com.baidu.tieba.ala.liveroom.master.panel.b hvW;
    private com.baidu.live.af.a hvX;
    private ImageView hvY;
    private d hvZ;
    private boolean hvj;
    private com.baidu.tieba.ala.liveroom.h.d hvl;
    private com.baidu.tieba.ala.liveroom.o.a hvm;
    private com.baidu.tieba.ala.liveroom.b.a hvn;
    private com.baidu.tieba.ala.liveroom.u.a hvo;
    private com.baidu.tieba.ala.liveroom.w.a hvp;
    private b hvq;
    private com.baidu.tieba.ala.liveroom.tippop.a hvr;
    private com.baidu.live.t.d hvs;
    private com.baidu.live.t.c hvt;
    private com.baidu.live.v.c hvu;
    private com.baidu.live.v.b hvv;
    protected com.baidu.live.m.a hvw;
    protected com.baidu.live.an.b hvx;
    private AlaLiveCountDownView hvy;
    private AlaLiveStreamStatusView hvz;
    private boolean hwA;
    private short hwj;
    private com.baidu.tieba.ala.liveroom.h.b hwo;
    private com.baidu.tieba.ala.liveroom.challenge.e hwp;
    private com.baidu.live.am.a hwq;
    private com.baidu.live.b.a hwr;
    private com.baidu.live.b.b hws;
    private com.baidu.tieba.ala.liveroom.q.a hwt;
    private boolean hwu;
    private WindowManager.LayoutParams hww;
    private Window hwx;
    private View hwy;
    private FrameLayout hwz;
    private boolean hvk = false;
    private boolean hgJ = false;
    private Handler mHandler = new Handler();
    private Handler hvT = new Handler();
    private boolean hwa = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver hwb = null;
    private boolean hwc = false;
    private int hwd = 0;
    private int hwe = 0;
    private int hwf = 0;
    private long hwg = 0;
    private long hwh = 0;
    private volatile boolean isBackground = false;
    private Intent hwi = null;
    private int mOrientation = 1;
    private boolean hqf = false;
    private boolean hwk = false;
    private boolean hwl = true;
    private boolean hjf = false;
    private boolean hwm = true;
    private boolean hwn = true;
    private int dFt = 0;
    private String otherParams = "";
    private Handler hwv = new Handler();
    private BdUniqueId gEP = BdUniqueId.gen();
    private boolean mIsKeyboardOpen = false;
    private int bqj = 0;
    private Runnable hwB = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.heh != null) {
                AlaMasterLiveRoomOpearator.this.heh.Gh();
            }
        }
    };
    private com.baidu.live.am.b bKs = new com.baidu.live.am.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.am.b
        public boolean WI() {
            if (AlaMasterLiveRoomOpearator.this.hwp != null) {
                if (AlaMasterLiveRoomOpearator.this.hgq != null) {
                    if (!AlaMasterLiveRoomOpearator.this.hwp.ccL() && !AlaMasterLiveRoomOpearator.this.hwp.ccM() && !AlaMasterLiveRoomOpearator.this.hgq.Qx() && !AlaMasterLiveRoomOpearator.this.hgq.Em()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.hwp.ccL() && !AlaMasterLiveRoomOpearator.this.hwp.ccM()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.hgq == null || AlaMasterLiveRoomOpearator.this.hgq.Qx() || AlaMasterLiveRoomOpearator.this.hgq.Em()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.am.b
        public void WJ() {
            if (AlaMasterLiveRoomOpearator.this.hwp != null) {
                AlaMasterLiveRoomOpearator.this.hwp.ccO();
            }
        }
    };
    private CustomMessageListener brg = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hja.hqq != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.hja.hqq.f(list, false);
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
                if (AlaMasterLiveRoomOpearator.this.hja.hqq != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.hja.hqq.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener hhi = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.hfI == null) {
                        AlaMasterLiveRoomOpearator.this.hfI = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    AlaMasterLiveRoomOpearator.this.hfI.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener hho = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hgo != null) {
                AlaMasterLiveRoomOpearator.this.hgo.Mq();
            }
        }
    };
    private CustomMessageListener hwC = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hhg = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.69
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Ig(str);
            }
        }
    };
    private CustomMessageListener gDr = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.70
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.bvJ();
        }
    };
    private CustomMessageListener hfp = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.hfX.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hhm = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity(), a.h.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener hwD = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hws != null) {
                w Iq = AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq();
                long j = Iq.mLiveInfo.live_id;
                long j2 = Iq.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.hws.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener hwE = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccJ().hpS);
            if (AlaMasterLiveRoomOpearator.this.hvl == null || AlaMasterLiveRoomOpearator.this.hvl.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.xa(0);
            }
            if (AlaMasterLiveRoomOpearator.this.hfU != null) {
                AlaMasterLiveRoomOpearator.this.hfU.Nd().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.hfU.Ne().hide();
            }
        }
    };
    private CustomMessageListener hhn = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.H(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq());
        }
    };
    private CustomMessageListener hhr = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hgi != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) AlaMasterLiveRoomOpearator.this.hgi).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hwF = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hwt != null) {
                    AlaMasterLiveRoomOpearator.this.hwt.ir(str);
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
                    if (AlaMasterLiveRoomOpearator.this.hwo != null) {
                        if (!data.aFa || AlaMasterLiveRoomOpearator.this.bAQ == null || !AlaMasterLiveRoomOpearator.this.hwu) {
                            if (AlaMasterLiveRoomOpearator.this.bAQ != null && AlaMasterLiveRoomOpearator.this.bAQ == data.aEZ) {
                                if (data.aET != null && data.aET.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.hwu || AlaMasterLiveRoomOpearator.this.hvl.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.hwo.c(AlaMasterLiveRoomOpearator.this.ccJ().hqi.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.bAS = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.ccJ().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.bAQ = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.ccJ().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.hwo.a(AlaMasterLiveRoomOpearator.this.ccJ().hqi.getVideoConfig(), AlaMasterLiveRoomOpearator.this.bAS);
                        if (!AlaMasterLiveRoomOpearator.this.bAS) {
                            AlaMasterLiveRoomOpearator.this.bAS = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.bAR) {
                    AlaMasterLiveRoomOpearator.this.ccJ().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
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
                if (AlaMasterLiveRoomOpearator.this.ccJ().hqi != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.ccJ().hqi.setBeautyJsonPath(str);
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
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bqj == 6) {
                            AlaMasterLiveRoomOpearator.this.chn();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bqj = 0;
            }
        }
    };
    private View.OnClickListener hwG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.hvL) {
                    AlaMasterLiveRoomOpearator.this.chs();
                    AlaMasterLiveRoomOpearator.this.hvW.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.hvK) {
                    if (view == AlaMasterLiveRoomOpearator.this.hvM) {
                        AlaMasterLiveRoomOpearator.this.bvJ();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.hvN) {
                        if (view != AlaMasterLiveRoomOpearator.this.hvP) {
                            if (view == AlaMasterLiveRoomOpearator.this.hjh) {
                                if (AlaMasterLiveRoomOpearator.this.chm()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.hwp != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.hgq != null) && AlaMasterLiveRoomOpearator.this.hgq.Em()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.hgq.Qx() & (AlaMasterLiveRoomOpearator.this.hgq != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hwp.ccL()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hwp.ccM()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.hwp.ccN();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hvO) {
                                if (AlaMasterLiveRoomOpearator.this.hvp != null) {
                                    aq cjz = AlaMasterLiveRoomOpearator.this.ccJ().hpR.cjz();
                                    if (cjz == null || cjz.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(cjz.mLiveSdkInfo.mRoomId);
                                        if (cjz.mLiveSdkInfo.mCastIds != null) {
                                            str2 = cjz.mLiveSdkInfo.mCastIds.chatMCastId;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.hvp.au("", str, str2);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hvQ) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.hwp.ccL() || AlaMasterLiveRoomOpearator.this.hwp.ccM() || AlaMasterLiveRoomOpearator.this.hgq.Qx() || AlaMasterLiveRoomOpearator.this.hgq.Em()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.hwq != null) {
                                    AlaMasterLiveRoomOpearator.this.hwq.WD();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.hvX != null) {
                            AlaMasterLiveRoomOpearator.this.hvX.RU();
                            AlaMasterLiveRoomOpearator.this.hvX.cN(AlaMasterLiveRoomOpearator.this.chA());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "beauty"));
                        AlaMasterLiveRoomOpearator.this.hwu = false;
                        AlaMasterLiveRoomOpearator.this.nT(true);
                        AlaMasterLiveRoomOpearator.this.hvR.setVisibility(4);
                        com.baidu.live.d.BM().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.ae.a.RB().brA.aOy == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.RB().brA.aOx == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bqg) {
                        AlaMasterLiveRoomOpearator.this.chn();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bqj = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.chn();
                }
            }
        }
    };
    private CustomMessageListener hhh = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ar) {
                    AlaMasterLiveRoomOpearator.this.hgJ = true;
                    AlaMasterLiveRoomOpearator.this.hvS = (ar) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.hfU != null) {
                        AlaMasterLiveRoomOpearator.this.hfU.Nd().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.hfU != null) {
                        AlaMasterLiveRoomOpearator.this.hfU.Ne().show();
                        AlaMasterLiveRoomOpearator.this.hfU.Ne().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.xa(8);
                }
            }
        }
    };
    private CustomMessageListener hwH = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.ccJ() != null && AlaMasterLiveRoomOpearator.this.ccJ().hqo != null) {
                AlaMasterLiveRoomOpearator.this.ccJ().hqo.sampleMemAndCPU();
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
                    AlaMasterLiveRoomOpearator.this.cik();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.ccJ().hpR.xh(i);
            }
        }
    };
    private CustomMessageListener hdn = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.cid();
        }
    };
    private CustomMessageListener gTS = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.ao.c)) {
                if (AlaMasterLiveRoomOpearator.this.gTR == null) {
                    AlaMasterLiveRoomOpearator.this.gTR = new com.baidu.live.ao.a(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.gTR.a((com.baidu.live.ao.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener hwI = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.PQ()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.hvW != null) {
                            AlaMasterLiveRoomOpearator.this.hvW.oa(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.hvW.ciK();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.ccJ().hqi.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.hwq != null) {
                        AlaMasterLiveRoomOpearator.this.hwq.setMute(AlaMasterLiveRoomOpearator.this.ccJ().hqi.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hvx != null) {
                        AlaMasterLiveRoomOpearator.this.hvx.setMute(AlaMasterLiveRoomOpearator.this.ccJ().hqi.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hvr != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.hvr.a(AlaMasterLiveRoomOpearator.this.ccJ().hql, AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getString(a.h.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.hvr.xp(2);
                        AlaMasterLiveRoomOpearator.this.hvr.a(AlaMasterLiveRoomOpearator.this.ccJ().hql, string, 3);
                    }
                }
            }
        }
    };
    private e.a hwJ = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cir() {
            AlaMasterLiveRoomOpearator.this.wZ(a.h.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cis() {
            AlaMasterLiveRoomOpearator.this.wZ(a.h.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a hwK = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.liveroom.a.a
        public boolean fh(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void fi(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.ccJ().ceF() == 1) {
                AlaMasterLiveRoomOpearator.this.ccJ().hqi.stopRecord();
            }
        }
    };
    private IShareCallback hwL = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.hwa && AlaMasterLiveRoomOpearator.this.hvZ != null) {
                AlaMasterLiveRoomOpearator.this.hwa = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.hvZ);
            }
        }
    };
    private View.OnTouchListener hwM = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.ccJ().hqo.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccJ().hpS);
            AlaMasterLiveRoomOpearator.this.xa(0);
            if (AlaMasterLiveRoomOpearator.this.hfU != null) {
                AlaMasterLiveRoomOpearator.this.hfU.Nd().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.hfU.Ne().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b hwN = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cit() {
            AlaMasterLiveRoomOpearator.this.cho();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ciu() {
            AlaMasterLiveRoomOpearator.this.huS = AlaMasterLiveRoomOpearator.this.hvl.cex();
            AlaMasterLiveRoomOpearator.this.ccJ().hqo.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.ccJ().hqo.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.ccJ().hqo.sampleMemAndCPU();
            d dVar = new d();
            dVar.hqc = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.ccJ().ceF();
            dVar.title = AlaMasterLiveRoomOpearator.this.hvl.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hqd = AlaMasterLiveRoomOpearator.this.hvl.cey();
            dVar.hqg = AlaMasterLiveRoomOpearator.this.huS;
            dVar.hqf = AlaMasterLiveRoomOpearator.this.hvl.cev();
            dVar.hqe = AlaMasterLiveRoomOpearator.this.hvl.ceA();
            dVar.hqh = AlaMasterLiveRoomOpearator.this.hvl.cew();
            if (dVar.hqh) {
                if (AlaMasterLiveRoomOpearator.this.hvl.ceB()) {
                    AlaMasterLiveRoomOpearator.this.hwa = true;
                    AlaMasterLiveRoomOpearator.this.hvZ = dVar;
                    AlaMasterLiveRoomOpearator.this.hvl.ceC();
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
            AlaMasterLiveRoomOpearator.this.ccJ().pageContext.showToast(a.h.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.ccJ().g((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void civ() {
            AlaMasterLiveRoomOpearator.this.hwu = true;
            AlaMasterLiveRoomOpearator.this.nT(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean ciw() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cix() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
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
                AlaMasterLiveRoomOpearator.this.caI();
            }
        }
    };
    private com.baidu.live.liveroom.g.c hwO = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void PL() {
            if (AlaMasterLiveRoomOpearator.this.hvp != null) {
                AlaMasterLiveRoomOpearator.this.hvp.on(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cA(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.hvX != null) {
                        AlaMasterLiveRoomOpearator.this.hvX.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hvX != null) {
                    AlaMasterLiveRoomOpearator.this.hvX.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.hvp != null) {
                    AlaMasterLiveRoomOpearator.this.hvp.on(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.hgi != null) {
                    AlaMasterLiveRoomOpearator.this.hgi.bE(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a hwP = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void aia() {
            if (AlaMasterLiveRoomOpearator.this.hvJ != null && AlaMasterLiveRoomOpearator.this.ccJ().hql.indexOfChild(AlaMasterLiveRoomOpearator.this.hvJ) >= 0) {
                AlaMasterLiveRoomOpearator.this.ccJ().hql.removeView(AlaMasterLiveRoomOpearator.this.hvJ);
                AlaMasterLiveRoomOpearator.this.hvJ.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.hvJ = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hfu = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void s(View view, int i) {
            w Iq;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.cij();
            } else if (i == 14 && (Iq = AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq()) != null && Iq.aJV != null && Iq.mLiveInfo != null && Iq.aKr != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity(), Iq.aJV.userName, Long.toString(Iq.aJV.userId), Long.toString(Iq.aJV.charmCount), String.valueOf(Iq.mLiveInfo.group_id), String.valueOf(Iq.mLiveInfo.live_id), true, String.valueOf(Iq.aJV.userId), Long.toString(Iq.aKr.userId), Iq.aKr.userName, Iq.aKr.portrait, AlaMasterLiveRoomOpearator.this.heN.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Iq.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.heN.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a hwQ = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };
    private g hwR = new g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
    };
    private Runnable hwS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        @Override // java.lang.Runnable
        public void run() {
            AlaMasterLiveRoomOpearator.this.ciq();
        }
    };
    private HttpMessageListener gND = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == AlaMasterLiveRoomOpearator.this.gEP && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bja != null) {
                AlaMasterLiveRoomOpearator.this.bja = guardClubInfoHttpResponseMessage.bja;
            }
        }
    };
    HttpMessageListener gNV = new HttpMessageListener(1021231) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.63
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
            AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity());
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity());
            if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = true;
                TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                AlaMasterLiveRoomOpearator.this.hww.gravity = 80;
                AlaMasterLiveRoomOpearator.this.hww.x = 0;
                AlaMasterLiveRoomOpearator.this.hww.y = 50;
                AlaMasterLiveRoomOpearator.this.hwx.setAttributes(AlaMasterLiveRoomOpearator.this.hww);
            } else if (screenFullSize[1] - rect.height() <= statusBarHeight && AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = false;
                AlaMasterLiveRoomOpearator.this.hww.gravity = 17;
                AlaMasterLiveRoomOpearator.this.hww.x = 0;
                AlaMasterLiveRoomOpearator.this.hww.y = 0;
                AlaMasterLiveRoomOpearator.this.hwx.setAttributes(AlaMasterLiveRoomOpearator.this.hww);
            }
        }
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.b.aAz);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        hvi = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    private void Ix(String str) {
        if (!TextUtils.isEmpty(str) && this.hvU != null) {
            View NT = this.hvU.NT();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            NT.setLayoutParams(layoutParams);
            if (ccJ().hpS.indexOfChild(NT) >= 0) {
                ccJ().hpS.removeView(NT);
            }
            ccJ().hpS.addView(NT);
            this.hvU.ih(str);
            NT.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.ae.a.RB().brA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(ccJ().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.ae.a.RB().brA.aOt, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ig(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccJ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(ccJ().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.RB().brA.aNR;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? ccJ().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt) : ccJ().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(ccJ().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caI() {
        int i = ccJ().hpR.Iq().aJV.isUegBlock;
        int i2 = ccJ().hpR.Iq().aJV.isBlock;
        String str = ccJ().hpR.Iq().aJV.userName;
        if (i > 0 || i2 > 0) {
            this.bqg = true;
            this.hfU.a(true, i, i2, str);
            return;
        }
        this.bqg = false;
        this.hfU.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.hja.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpe == 1) {
                format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpf);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.hja.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.hja.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chm() {
        if (this.hwq != null && this.hwq.WE()) {
            BdUtilHelper.showToast(this.hja.pageContext.getPageActivity(), this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else if (this.hvx != null && this.hvx.St()) {
            BdUtilHelper.showToast(this.hja.pageContext.getPageActivity(), this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chn() {
        if (this.hfU != null) {
            this.hfU.Ne().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.hwp != null) {
            this.hwp.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cho() {
        if (ccJ() != null && ccJ().hpR != null) {
            ccJ().hpR.cjs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bTT() != null && aVar.bTU() != null) {
            ccJ().hpR.eB(aVar.bTT().getId(), aVar.bTU().getId());
        }
    }

    public void b(short s) {
        if (this.hwo != null) {
            this.hwo.b(s);
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
                    AlaMasterLiveRoomOpearator.this.hwc = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.hwc = false;
                }
                if (AlaMasterLiveRoomOpearator.this.hwd == 0) {
                    AlaMasterLiveRoomOpearator.this.hwd = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.hwe == 0) {
                    AlaMasterLiveRoomOpearator.this.hwe = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.hwf = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d dVar) {
        if (ccJ() != null && ccJ().hqm != null) {
            ccJ().hqm.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.e eVar, String str) {
        this.hja = eVar;
        this.hdc = str;
    }

    protected com.baidu.tieba.ala.liveroom.data.e ccJ() {
        return this.hja;
    }

    public int a(f fVar) {
        this.hji = fVar;
        this.hwb = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.hwb, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.hvr == null) {
            this.hvr = new com.baidu.tieba.ala.liveroom.tippop.a(this.hja.pageContext, null);
        }
        registerListener();
        this.heh = new com.baidu.live.i.a();
        chK();
        chp();
        chr();
        Long[] lArr = new Long[1];
        this.hwg = lArr[0] == null ? 0L : lArr[0].longValue();
        this.hwh = lArr[0] != null ? lArr[0].longValue() : 0L;
        ccJ().hpS.setOnTouchListener(this.hwM);
        this.hvj = SharedPrefHelper.getInstance().getBoolean(hvi, false);
        this.hvy = new AlaLiveCountDownView(ccJ().pageContext.getPageActivity());
        this.hvy.setCount(3);
        this.hvy.setTextColor(ccJ().pageContext.getPageActivity().getResources().getColor(a.c.sdk_white_alpha60));
        this.hvy.setTextSize(ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128));
        this.hvy.setTypeface(Typeface.DEFAULT_BOLD);
        this.hvy.setIncludeFontPadding(false);
        this.hvy.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void ciy() {
                if (AlaMasterLiveRoomOpearator.this.ccJ().hpS != null) {
                    AlaMasterLiveRoomOpearator.this.ccJ().hpS.removeView(AlaMasterLiveRoomOpearator.this.hvy);
                }
            }
        });
        return 1;
    }

    private void chp() {
        CustomResponsedMessage runTask;
        if (this.hvw == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.m.a.class, ccJ().pageContext)) != null && runTask.getData() != null) {
            this.hvw = (com.baidu.live.m.a) runTask.getData();
            this.hvw.c(ccJ().pageContext);
        }
    }

    private void chq() {
        CustomResponsedMessage runTask;
        if (chx() && this.hvx == null && (runTask = MessageManager.getInstance().runTask(2913254, com.baidu.live.an.b.class, ccJ().pageContext)) != null && runTask.getData() != null) {
            this.hvx = (com.baidu.live.an.b) runTask.getData();
            if (ccJ() != null && ccJ().hpR != null && ccJ().hpR.Iq() != null) {
                this.hvx.setLiveShowData(ccJ().hpR.Iq());
            }
            if (ccJ() != null && ccJ().hqi != null) {
                this.hvx.L(ccJ().hqi);
                this.hvx.setMute(ccJ().hqi.isMute());
            }
            if (this.hvx != null && this.hvG != null) {
                this.hvx.a(new com.baidu.live.an.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                    @Override // com.baidu.live.an.a
                    public boolean Sv() {
                        if ((AlaMasterLiveRoomOpearator.this.hgq != null) && AlaMasterLiveRoomOpearator.this.hgq.Em()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                            return false;
                        }
                        if ((AlaMasterLiveRoomOpearator.this.hgq != null) & AlaMasterLiveRoomOpearator.this.hgq.Qx()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                            return false;
                        } else if (AlaMasterLiveRoomOpearator.this.hwp == null || !AlaMasterLiveRoomOpearator.this.hwp.ccL()) {
                            if (AlaMasterLiveRoomOpearator.this.hwp == null || !AlaMasterLiveRoomOpearator.this.hwp.ccM()) {
                                return true;
                            }
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        } else {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        }
                    }
                });
                View enterView = this.hvx.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hvG.setVisibility(0);
                    this.hvG.addView(enterView);
                }
            }
            if (this.hvx != null) {
                this.hvx.Y(ccJ().hqj);
            }
            if (this.hvx != null && ccJ().hqk != null) {
                this.hvx.a(ccJ().hqk);
            }
        }
    }

    private void chr() {
        View rootLayout;
        if (this.hvw != null && this.hvF != null && (rootLayout = this.hvw.ct(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hvF.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chs() {
        if (this.hvW == null) {
            this.hvW = new com.baidu.tieba.ala.liveroom.master.panel.b(ccJ().pageContext.getPageActivity(), ccJ().ceF() == 2);
            this.hvW.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nV(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccJ().hqi.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nW(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccJ().hqi.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nX(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccJ().hqi.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.cii();
                    if (AlaMasterLiveRoomOpearator.this.hvr != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.hvr.a(AlaMasterLiveRoomOpearator.this.ccJ().hql, AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getString(a.h.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.hvr.a(AlaMasterLiveRoomOpearator.this.ccJ().hql, AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getString(a.h.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nY(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.g(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciz() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.ccJ().hpR != null && AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq() != null && AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hvW != null) {
                        AlaMasterLiveRoomOpearator.this.hvW.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.a(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciA() {
                    if (AlaMasterLiveRoomOpearator.this.hvW != null) {
                        AlaMasterLiveRoomOpearator.this.hvW.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new i(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciB() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.ccJ() != null && AlaMasterLiveRoomOpearator.this.ccJ().hpR != null && AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq() != null && AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(AlaMasterLiveRoomOpearator.this.ccJ().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.hvW != null) {
                            AlaMasterLiveRoomOpearator.this.hvW.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciC() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.ccJ() == null || AlaMasterLiveRoomOpearator.this.ccJ().hpR == null || AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq() == null || AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.ccJ() != null && AlaMasterLiveRoomOpearator.this.ccJ().hpR != null && AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq() != null && AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.hvW != null) {
                                        AlaMasterLiveRoomOpearator.this.hvW.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.hja.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.hvW != null) {
                        AlaMasterLiveRoomOpearator.this.hvW.dismiss();
                    }
                }
            });
        }
        cht();
    }

    private void cht() {
        if (this.hvW != null) {
            boolean isBackCamera = ccJ().hqi.isBackCamera();
            this.hvW.nZ(ccJ().hqi.isBackCamera());
            this.hvW.Q(ccJ().hqi.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = ccJ().hqi.isPushMirror();
            if (this.hwl) {
                isPushMirror = cih() || isPushMirror;
                this.hwl = false;
            }
            this.hvW.R(isPushMirror, isBackCamera ? false : true);
            this.hvW.oa(ccJ().hqi.isMute());
            this.hvW.ciK();
        }
    }

    public void chu() {
        if (this.hji != null) {
            if (this.hji.hqr == null || this.hji.hqr.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.hvH == null) {
                        this.hvH = this.hja.hqq.Pm();
                        this.hja.hql.addView(this.hvH, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.hvl == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (ccJ().hpR != null && ccJ().hpR.Iq() != null && ccJ().hpR.Iq().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", ccJ().hpR.Iq().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", ccJ().hpR.Iq().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.hvl = new com.baidu.tieba.ala.liveroom.h.d(ccJ().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    ccJ().hqo.prepareTime = System.currentTimeMillis();
                    ccJ().hql.addView(this.hvl.getView(), layoutParams);
                    this.hvl.a(this.hwL);
                }
                this.hvl.nB(this.hqf);
                this.hvl.a(this.hwN);
                this.hvl.a(this.hwJ);
                this.hvl.a(ccJ().hqi, ccJ().ceF());
                this.hvl.a(this.hvw);
                return;
            }
            this.huS = this.hji.hqr.mLiveInfo.screen_direction == 2;
            if (this.hji.hqr.mLiveInfo.isAudioOnPrivate == 1) {
                ccJ().hqi.setMute(true);
                if (this.hwq != null) {
                    this.hwq.setMute(ccJ().hqi.isMute());
                }
                if (this.hvx != null) {
                    this.hvx.setMute(ccJ().hqi.isMute());
                }
                if (this.hvr == null) {
                    this.hvr = new com.baidu.tieba.ala.liveroom.tippop.a(this.hja.pageContext, null);
                }
                if (!this.hvr.xo(2)) {
                    this.hvr.a(ccJ().hql, ccJ().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, true);
                }
            }
            d dVar = new d();
            dVar.hqc = true;
            dVar.forumId = String.valueOf(this.hji.hqr.mLiveInfo.forum_id);
            dVar.forumName = this.hji.hqr.mLiveInfo.forum_name;
            dVar.liveType = this.hji.hqr.mLiveInfo.live_type;
            dVar.title = this.hji.hqr.mLiveInfo.getLiveTitle();
            dVar.clarity = this.hji.hqr.mLiveInfo.clarity;
            dVar.gameId = this.hji.hqr.mLiveInfo.game_id;
            dVar.gameName = this.hji.hqr.mLiveInfo.game_label;
            dVar.hqg = this.hji.hqr.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void chv() {
        if (this.hwo != null) {
            this.hwo.a(ccJ().hqi.getVideoConfig(), false);
        }
        if (this.hvl != null) {
            this.hvl.nA(true);
        }
        if (ccJ().hqi.hasBeauty() >= 0) {
            ccJ().hqi.setBeauty(com.baidu.live.d.BM().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            ccJ().hqq.I(this.hja.hqi);
        } else if (this.hvl != null) {
            this.hvl.nA(true);
        }
        chJ();
    }

    public void d(d dVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.hvH != null && this.hvH.getParent() != null) {
                ((ViewGroup) this.hvH.getParent()).removeView(this.hvH);
                this.hvH = null;
            }
            ccJ().hpS.setVisibility(0);
            this.hja.hqq.a(ccJ().hpS);
        } else {
            chR();
            cig();
            if (this.hwz != null) {
                this.hwz.setVisibility(0);
            }
            this.hvp = new com.baidu.tieba.ala.liveroom.w.a(ccJ().pageContext, this.hwK);
            this.hvp.c(ccJ().hpS, true);
            this.hvp.on(true);
            if (this.hfU != null && this.hfU.Nd() != null) {
                this.hfU.Nd().setNeedTopAlphaShade(true);
            }
        }
        ccJ().hqi.setPushMirror(cih());
    }

    public void b(aq aqVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hja.hqq.k(ccJ().hpR.Iq());
        }
        if (!ccJ().hqi.isBackground() && ccJ().hpR.Iq() != null && ccJ().hpR.Iq().mLiveInfo != null) {
            int startPush = ccJ().hqi.startPush(ccJ().hpR.Iq().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.hja.hqq.Pn();
            }
            if (startPush != 0 && ccJ().hqo != null) {
                ccJ().hqo.errCode = 4;
                ccJ().hqo.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (aqVar != null && !aqVar.FM() && !cie()) {
                nU(true);
                cif();
            }
            if (this.heK != null) {
                this.heK.M(ccJ().hpR.Iq());
            }
            if (this.hfF != null) {
                this.hfF.a(ccJ().hpR.Iq());
            }
            if (this.hvw != null) {
                this.hvw.e(ccJ().hpR.Iq());
                this.hvw.ik(this.otherParams);
            }
            if (this.heK != null) {
                this.heK.nO(true);
            }
            if (this.hvm != null) {
                this.hvm.M(ccJ().hpR.Iq());
            }
            if (aqVar == null || aqVar.aJV == null) {
                z = com.baidu.live.d.BM().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = aqVar.aJV.canUseChallenge;
                com.baidu.live.d.BM().putBoolean("ala_master_can_use_challenge", z);
            }
            cbF();
            chS();
            chC();
            nS(z);
            cas();
            chT();
            chZ();
            N(ccJ().hpR.Iq());
            f(ccJ().hpR.Iq());
            cia();
            cib();
            chw();
            chW();
            cbB();
            car();
            cbD();
            caq();
            chX();
            cbn();
            cbw();
            cbx();
            chP();
            chQ();
            O(ccJ().hpR.Iq());
            chY();
            cbA();
            cbo();
            MessageManager.getInstance().registerListener(this.gND);
            MessageManager.getInstance().registerListener(this.gNV);
            bVZ();
            this.hwv.postDelayed(this.hwS, IMConnection.RETRY_DELAY_TIMES);
            if (this.hfT != null) {
                this.hfT.g(ccJ().hpR.Iq());
            }
            if (this.hfU != null) {
                if (ccJ().hpR.Iq() != null && ccJ().hpR.Iq().aKI != null && ccJ().hpR.Iq().aKI.Fb()) {
                    z2 = true;
                }
                this.hfU.a(String.valueOf(ccJ().hpR.Iq().mLiveInfo.group_id), String.valueOf(ccJ().hpR.Iq().mLiveInfo.last_msg_id), String.valueOf(ccJ().hpR.Iq().aJV.userId), String.valueOf(ccJ().hpR.Iq().mLiveInfo.live_id), ccJ().hpR.Iq().aJV.appId, z2, ccJ().hpR.Iq().getGuardName());
            }
            if (this.hfV != null) {
                this.hfV.a(ccJ().hpR.Iq(), true);
            }
            chy();
            chq();
            cbJ();
            this.mHandler.post(this.hwB);
        }
    }

    protected void cbJ() {
        if (this.hgB == null && ccJ() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.s.a.class, ccJ().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hgB = (com.baidu.live.s.a) runTask.getData();
                this.hgB.m(ccJ().hpS);
            }
        }
    }

    private void chw() {
        if (this.hvn != null && ccJ() != null && ccJ().hpR != null) {
            if (this.hvn.au(this.hvC)) {
                this.hvn.C(ccJ().hpR.Iq());
            } else {
                this.hvn.d(this.hvC, ccJ().hpR.Iq());
            }
        }
    }

    private void cas() {
        if (this.buZ == null) {
            this.buZ = new PendantParentView(ccJ().pageContext.getPageActivity(), this.gGE ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            ccJ().hpS.addView(this.buZ, layoutParams);
            this.buZ.setDefaultItemMargin(ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.buZ.setPadding(ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            ccl();
        }
    }

    private void ccl() {
        if (this.buZ != null) {
            int dimensionPixelSize = ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278);
            int dimensionPixelSize2 = ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buZ.getLayoutParams();
            if (this.gGE) {
                this.buZ.setPosition(0, 0, this.hwp.ccr(), dimensionPixelSize2);
            } else {
                this.buZ.setPosition(dimensionPixelSize, 0, ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278), dimensionPixelSize2);
            }
            this.buZ.setLayoutParams(layoutParams);
            this.buZ.setModel(this.gGE ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void ccm() {
        if (this.hfU != null && this.hfU.Nd() != null && this.hfU.Nd().getView() != null) {
            if (this.gGE && !this.hvk && ccJ().hpS != null && ccJ().hpS.getHeight() > 0) {
                int bu = this.hwp != null ? this.hwp.bu(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.hfU.Nd().getView().getLayoutParams();
                int height = ccJ().hpS.getHeight() - bu;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.hfU.Nd().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.ak.c.i(false, this.hvk);
            if (ccJ().hpS.indexOfChild(this.hfU.Nd().getView()) != -1 && this.hfU.Nd().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hfU.Nd().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.hfU.Nd().getView().setLayoutParams(layoutParams2);
            }
            this.hfU.Nd().Nc();
        }
    }

    private void ccn() {
        if (this.hfW != null) {
            if (this.gGE && !this.hvk && ccJ().hpS != null && ccJ().hpS.getHeight() > 0) {
                this.hfW.ek((ccJ().hpS.getHeight() - (this.hwp != null ? h.o(ccJ().pageContext.getPageActivity(), true) : 0)) + ccJ().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height));
            } else {
                this.hfW.ek(com.baidu.live.ak.a.a(ccJ().pageContext.getPageActivity(), true, false, this.hvk));
            }
        }
    }

    private void cco() {
        int i;
        if (this.hfW != null) {
            int h = com.baidu.live.ak.a.h(true, false);
            if (!this.gGE || ccJ().hpS == null || ccJ().hpS.getHeight() <= 0) {
                i = h;
            } else {
                i = (ccJ().hpS.getHeight() - (this.hwp != null ? this.hwp.bu(false) : 0)) + ccJ().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
            }
            this.hfW.el(i);
        }
    }

    private void ccp() {
        if (this.hfV != null && this.hfV.DL() != null) {
            ViewGroup.LayoutParams layoutParams = this.hfV.DL().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ccJ().pageContext.getResources().getDimensionPixelOffset(this.gGE ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hfV.DL().setLayoutParams(layoutParams);
            }
        }
    }

    private boolean chx() {
        AlaVideoBCChatData alaVideoBCChatData;
        AlaLiveInfoData alaLiveInfoData = ccJ().hpR.Iq().mLiveInfo;
        if (alaLiveInfoData == null || (alaVideoBCChatData = alaLiveInfoData.videoBCEnterData) == null) {
            return false;
        }
        return alaVideoBCChatData.isShowEnter();
    }

    private void chy() {
        if (this.hvx == null && !chx()) {
            boolean z = (ccJ().hpR == null || ccJ().hpR.cjz() == null || ccJ().hpR.cjz().mLiveInfo.videoBBChatData == null || !ccJ().hpR.cjz().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
            if (!z && ccJ().hpR != null && ccJ().hpR.Iq() != null && ccJ().hpR.Iq().mLiveInfo != null && ccJ().hpR.Iq().mLiveInfo.videoBBChatData != null && ccJ().hpR.Iq().aKE) {
                z = ccJ().hpR.Iq().mLiveInfo.videoBBChatData.videoBBChatSwitch;
            }
            if (this.hvQ != null) {
                this.hvQ.setVisibility(z ? 0 : 8);
            }
            chz();
        }
    }

    private void chz() {
        CustomResponsedMessage runTask;
        if (this.hwq == null && (runTask = MessageManager.getInstance().runTask(2913249, com.baidu.live.am.a.class, ccJ().pageContext)) != null && runTask.getData() != null) {
            this.hwq = (com.baidu.live.am.a) runTask.getData();
        }
        if (this.hwq != null) {
            this.hwq.v((ViewGroup) ccJ().rootView.findViewById(a.f.ala_live_video_chat_pendant));
            this.hwq.u(ccJ().hql);
            this.hwq.s(ccJ().hpR.Iq());
            this.hwq.L(ccJ().hqi);
            this.hwq.a(ccJ().hqk);
            this.hwq.a(this.bKs);
            if (ccJ().hqi != null) {
                this.hwq.setMute(ccJ().hqi.isMute());
            }
        }
    }

    private void nS(boolean z) {
        if (this.hwp == null) {
            this.hwp = new com.baidu.tieba.ala.liveroom.challenge.e(ccJ());
        }
        this.hwp.a(this.hjh, this.hji, z);
        this.hwp.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(ba baVar, be beVar, be beVar2) {
                AlaMasterLiveRoomOpearator.this.gGE = true;
                AlaMasterLiveRoomOpearator.this.ccJ().hpS.hFs = false;
                if (AlaMasterLiveRoomOpearator.this.hvX != null) {
                    AlaMasterLiveRoomOpearator.this.hvX.fz(4);
                    AlaMasterLiveRoomOpearator.this.hvX.cN(true);
                }
                AlaMasterLiveRoomOpearator.this.Yg();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void Es() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hwB);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void ccH() {
                AlaMasterLiveRoomOpearator.this.gGE = false;
                AlaMasterLiveRoomOpearator.this.ccJ().hpS.hFs = false;
                if (AlaMasterLiveRoomOpearator.this.hvX != null) {
                    AlaMasterLiveRoomOpearator.this.hvX.fz(0);
                    AlaMasterLiveRoomOpearator.this.hvX.cN(false);
                }
                AlaMasterLiveRoomOpearator.this.chB();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void ccI() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hwB);
            }
        });
        this.hwp.N(this.huS, z);
        this.hwp.j(this.huS, z, (this.hji == null || this.hji.hqr == null || this.hji.hqr.mChallengeData == null) ? false : true);
    }

    public boolean chA() {
        return this.hwp != null && this.hwp.ccQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yg() {
        if (this.hvq != null) {
            this.hvq.setVisible(8);
            this.hvq.setCanVisible(false);
        }
        if (this.heP != null) {
            this.heP.bd(true);
        }
        if (this.hvz != null) {
            this.hvz.setCanVisible(false);
            this.hvz.setVisibility(4);
        }
        if (this.hvp != null) {
            this.hvI = this.hvp.clM();
            this.hvp.om(false);
        }
        if (this.hgq != null) {
            this.hgq.setCanVisible(false);
        }
        if (this.heW != null) {
            this.heW.setCanVisible(false);
        }
        if (this.hgr != null) {
            this.hgr.bd(true);
            this.hgr.be(true);
        }
        ccl();
        ccm();
        ccn();
        cco();
        ccp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chB() {
        if (this.hvq != null) {
            this.hvq.setCanVisible(true);
        }
        if (this.heP != null) {
            this.heP.bd(false);
        }
        if (this.hvz != null) {
            this.hvz.setCanVisible(true);
            if (this.hvz.clj()) {
                this.hvz.setVisibility(0);
            }
        }
        if (this.hvp != null) {
            this.hvp.om(this.hvI);
        }
        if (this.hgq != null) {
            this.hgq.setCanVisible(true);
        }
        if (this.heW != null) {
            this.heW.cL(true);
        }
        if (this.hgr != null) {
            this.hgr.bd(false);
            this.hgr.be(false);
        }
        ccl();
        ccm();
        ccn();
        cco();
        ccp();
    }

    private void chC() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.leftMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        if (this.hvz == null) {
            this.hvz = new AlaLiveStreamStatusView(ccJ().pageContext.getPageActivity());
            this.hvz.setVisibility(4);
        }
        this.hvz.setId(a.f.ala_live_room_stream_view);
        this.hvz.setLayoutParams(layoutParams);
        if (this.hvz.getParent() == null && this.hvC != null) {
            this.hvC.addView(this.hvz, layoutParams);
        }
    }

    public void chD() {
        if (this.hvl != null && this.hvl.getVisibility() != 8 && ccJ().hqi.getPreview() != null) {
            ccJ().hqi.stopRecord();
        }
    }

    public void chE() {
        if (ccJ().hqi.getPreview() != null) {
            ccJ().hqi.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hwo != null) {
                this.hwo.nz(false);
            }
            this.hwo = new com.baidu.tieba.ala.liveroom.h.b(ccJ().hql, ccJ(), ccJ().hqi);
            this.hwo.a(ccJ().hqi.getVideoConfig(), false);
        }
        if (this.hvr != null) {
            this.hvr.ckF();
        }
        this.mHandler.post(this.hwB);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.hvk = z;
        if (z) {
            if (this.hwn) {
                this.hwn = false;
                if (this.hfU != null && this.hfU.Nd() != null) {
                    this.hfU.Nd().getView().setBottom(0);
                }
                if (this.hfU != null && this.hfU.Ne() != null) {
                    this.hfU.Ne().getView().setBottom(0);
                }
            }
            if (this.hfW != null && this.hfW.HN() != null) {
                this.hfW.HN().setVisibility(8);
            }
            if (this.hfU != null && this.hfU.Nd() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hfU.Nd().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132);
                this.hfU.Nd().getView().setLayoutParams(layoutParams);
            }
            if (this.hfU != null && this.hfU.Ne() != null && this.hfU.Ne().getView() != null && this.hfU.Ne().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hfU.Ne().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.hfU.Ne().getView().setLayoutParams(layoutParams2);
                this.hfU.Ne().getView().setVisibility(0);
                this.hfU.Ne().OX();
            }
            xa(8);
            wY(8);
            if (this.hfX != null && this.hfX.Ip() != null) {
                this.hfX.Ip().setVisibility(8);
            }
            if (this.hvU != null && this.hvU.NT() != null) {
                this.hvU.NT().setVisibility(8);
            }
            if (this.hgr != null) {
                this.hgr.setCanVisible(false);
            }
        } else {
            if (this.hfW != null && this.hfW.HN() != null) {
                this.hfW.HN().setVisibility(0);
            }
            if (this.hfU != null && this.hfU.Nd() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hfU.Nd().getView().getLayoutParams();
                layoutParams3.bottomMargin = ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132) - ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.hfU.Nd().getView().setLayoutParams(layoutParams3);
            }
            if (this.hfU != null && this.hfU.Ne() != null) {
                this.hfU.Ne().hide();
            }
            xa(0);
            wY(0);
            if (this.hfX != null && this.hfX.Ip() != null) {
                this.hfX.Ip().setVisibility(0);
            }
            if (this.hvU != null && this.hvU.NT() != null) {
                this.hvU.NT().setVisibility(0);
            }
            if (this.hgr != null) {
                this.hgr.setCanVisible(true);
            }
        }
        if (this.hvl != null) {
            this.hvl.P(false, z);
        }
        if (this.hfV != null) {
            this.hfV.DM();
        }
        if (this.hvX != null) {
            this.hvX.onKeyboardVisibilityChanged(z);
        }
        if (this.hgB != null) {
            this.hgB.onKeyboardVisibilityChanged(z);
        }
        ccm();
        this.mHandler.post(this.hwB);
    }

    private void wY(int i) {
        if (this.heK != null) {
            this.heK.wM(i);
        }
        if (this.hvB != null) {
            this.hvB.setVisibility(i);
        }
        if (this.hfF != null) {
            this.hfF.getView().setVisibility(i);
        }
        if (this.hvo != null) {
            this.hvo.setVisible(i);
        }
        if (this.hvn != null) {
            this.hvn.setVisibility(i);
        }
        if (this.heP != null) {
            this.heP.setVisible(i);
        }
        if (this.hgx != null) {
            this.hgx.setCanVisible(i == 0);
        }
        if (this.hgt != null) {
            this.hgt.setVisible(i);
        }
        if (this.hgo != null) {
            this.hgo.setCanVisible(i == 0);
        }
        if (this.hgq != null) {
            this.hgq.setCanVisible(i == 0 && !this.gGE);
        }
        if (this.heW != null) {
            this.heW.cL(i == 0);
        }
        if (this.hwr != null) {
            this.hwr.setCanVisible(i == 0);
            this.hwr.refreshUI();
        }
        if (this.hvC != null) {
            this.hvC.setVisibility(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            ccJ().hqo.errCode = 1;
            wZ(a.h.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            wZ(a.h.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            wZ(a.h.stream_upload_exception);
        } else if (i == -2) {
            Iy(ccJ().pageContext.getResources().getString(a.h.preview_init_failed_dialog_msg));
            ccJ().hqi.stopRecord();
        } else if (i == -3 && this.hvl != null) {
            this.hvl.nA(false);
        }
        if (i == -4) {
            if (this.hvl == null || this.hvl.getView().getParent() == null) {
                ccJ().g((short) 1);
                return;
            }
            this.hvl.cez();
            this.hvN.setVisibility(0);
            if (this.hvp != null) {
                this.hvp.on(true);
            }
            ccJ().hpS.setBackgroundColor(ccJ().pageContext.getResources().getColor(17170445));
            cin();
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
            jSONObject.put("status", this.hvl == null || this.hvl.getView().getParent() == null || this.hvl.getVisibility() != 0 ? "live" : "action");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_ACTION, "").setContentExt(jSONObject));
        if (this.hvl != null) {
            this.hvl.onResume();
        }
        if (this.hwa && this.hvZ != null) {
            this.hwa = false;
            c(this.hvZ);
        }
        if (this.hgi != null) {
            this.hgi.onResume();
        }
    }

    public void h(short s) {
        if (this.hfT != null) {
            this.hfT.IB();
        }
        if (this.hfU != null) {
            this.hfU.a(null);
            this.hfU.DN();
        }
        if (this.hfV != null) {
            this.hfV.DN();
        }
        if (this.hwp != null) {
            this.hwp.ccP();
        }
    }

    public boolean chF() {
        w Iq = ccJ().hpR.Iq();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hja.hqq.j(Iq);
            if (Iq != null && Iq.mLiveInfo.live_status != 1) {
                cil();
                ccJ().pageContext.getPageActivity().finish();
                if (ccJ().hpR == null || ccJ().hpR.Iq() == null) {
                    return true;
                }
                a(Iq, 1, ccJ().hpR.cjI() != 1 ? ccJ().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                return true;
            }
        } else {
            if (this.hfU != null) {
                this.hfU.Nd().a(String.valueOf(Iq.mLiveInfo.group_id), String.valueOf(Iq.mLiveInfo.live_id), true, String.valueOf(Iq.aJV.userId), Iq.getGuardName());
            }
            if (this.hfV != null) {
                this.hfV.a(Iq);
            }
            if (this.hfF != null) {
                this.hfF.a(ccJ().hpR.Iq());
            }
            if (this.heK != null) {
                this.heK.M(Iq);
            }
            if (Iq != null) {
                if (this.hwp != null) {
                    this.hwp.a(Iq);
                }
                if (this.hfX != null && Iq.mLiveInfo != null) {
                    this.hfX.a(Iq.mLiveInfo, Iq.aJV);
                }
                if (this.hgx != null) {
                    this.hgO = this.hgx.o(Iq);
                }
                if (this.heP != null) {
                    this.heP.nc(this.hgO);
                    this.heP.i(Iq);
                    this.heP.updateView();
                }
                if (this.hgo != null) {
                    this.hgo.a(Iq);
                }
                if (this.hgq != null) {
                    this.hgq.a(Iq);
                }
                if (this.hgp != null) {
                    this.hgp.a(Iq);
                }
                if (this.hvv != null) {
                    this.hvv.a(Iq);
                }
                if (this.hgr != null) {
                    this.hgr.a(Iq);
                }
                if (this.hgs != null) {
                    this.hgs.a(Iq);
                }
                if (this.hgt != null) {
                    this.hgt.a(Iq);
                }
                if (Iq.mLiveInfo.live_status != 1) {
                    cil();
                    ccJ().pageContext.getPageActivity().finish();
                    if (ccJ().hpR == null || ccJ().hpR.Iq() == null) {
                        return true;
                    }
                    a(Iq, 1, ccJ().hpR.cjI() != 1 ? ccJ().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                    return true;
                } else if (this.hvw != null) {
                    this.hvw.h(Iq);
                }
            }
        }
        return false;
    }

    public void chG() {
        cht();
    }

    public void chH() {
        if (this.hwo != null) {
            this.hwo.cet();
        }
        if (this.hwq != null) {
            this.hwq.WG();
        }
    }

    public void chI() {
        if (this.hvl != null && this.hvl.getVisibility() != 8) {
            if (ccJ().ceF() == 2) {
                cin();
            } else {
                cim();
            }
        }
        if (this.hvl != null && this.hvl.getVisibility() != 8) {
            if (ccJ().ceF() == 1) {
                this.hvl.onResume();
            }
            this.hvl.onRefresh();
        }
        if (this.hvw != null) {
            this.hvw.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.hgJ && this.hvS != null) {
            if (this.hfU != null) {
                this.hfU.Nd().getView().setVisibility(0);
            }
            if (this.hfU != null) {
                this.hfU.Ne().show();
                this.hfU.Ne().setEditText(" @" + this.hvS.getNameShow() + " ");
            }
            xa(8);
            this.hgJ = false;
        }
        if (this.hws != null) {
            this.hws.resume();
        }
        if (this.hwt != null) {
            this.hwt.resume();
        }
        if (this.gTR != null) {
            this.gTR.resume();
        }
        if (this.hwq != null) {
            this.hwq.WH();
        }
    }

    public void onPause() {
        if (this.hvw != null) {
            this.hvw.onPause();
        }
        if (this.hws != null) {
            this.hws.pause();
        }
        if (this.hgi != null) {
            this.hgi.onPause();
        }
        if (this.hwt != null) {
            this.hwt.pause();
        }
        if (this.gTR != null) {
            this.gTR.pause();
        }
    }

    private void chJ() {
        if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
            this.hvN.setVisibility(0);
            this.hvN.setAlpha(0.2f);
        } else if (ccJ().hqi.hasBeauty() < 0) {
            this.hvN.setVisibility(8);
        } else {
            this.hvN.setVisibility(0);
        }
    }

    private void chK() {
        this.hvA = (RelativeLayout) ccJ().rootView.findViewById(a.f.ala_live_unremovable_container);
        this.hvD = (RelativeLayout) ccJ().rootView.findViewById(a.f.under_live_view_panel);
        this.hvE = (RelativeLayout) ccJ().rootView.findViewById(a.f.over_live_view_panel);
        this.hvF = (FrameLayout) ccJ().rootView.findViewById(a.f.goods_parent);
        this.hvG = (FrameLayout) ccJ().rootView.findViewById(a.f.ala_live_bc_chat_container);
        this.hja.hpS.setOnLiveViewScrollListener(this.hwO);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hvD.setVisibility(8);
            this.hvE.setVisibility(8);
            ccJ().hpS.removeAllViews();
            return;
        }
        this.hvB = (RelativeLayout) ccJ().rootView.findViewById(a.f.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hvB.getLayoutParams();
        layoutParams.topMargin = this.hja.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.hvB.setLayoutParams(layoutParams);
        this.hvC = (RelativeLayout) ccJ().rootView.findViewById(a.f.ala_live_top_pendant_container);
        if (this.heN == null) {
            this.heN = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.hja.pageContext.getPageActivity(), true);
        }
        this.heN.a(this.hfu);
        this.heN.a(this.hvB, a.f.ala_live_room_host_header_stub, 1L);
        this.heN.setVisible(0);
        chL();
        this.hvN = (ImageView) ccJ().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn);
        this.hvR = (TextView) ccJ().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn_num);
        this.hvN.setOnClickListener(this.hwG);
        this.hvP = (ImageView) ccJ().rootView.findViewById(a.f.ala_liveroom_host_paster);
        this.hvP.setOnClickListener(this.hwG);
        if (com.baidu.live.ae.a.RB().bxq != null && com.baidu.live.ae.a.RB().bxq.aQK != null && com.baidu.live.ae.a.RB().bxq.aQK.FR() && bm.b(com.baidu.live.ae.a.RB().bxq)) {
            this.hvP.setVisibility(0);
        } else {
            this.hvP.setVisibility(8);
        }
        chJ();
        this.hvM = (ImageView) ccJ().rootView.findViewById(a.f.ala_liveroom_host_share_btn);
        this.hvM.setOnClickListener(this.hwG);
        this.hvK = (ImageView) ccJ().rootView.findViewById(a.f.ala_liveroom_host_message_btn);
        this.hvK.setOnClickListener(this.hwG);
        this.hjh = (ImageView) ccJ().rootView.findViewById(a.f.ala_liveroom_host_pk_btn);
        this.hjh.setOnClickListener(this.hwG);
        this.hvQ = (ImageView) ccJ().rootView.findViewById(a.f.ala_liveroom_host_vedio_chat);
        this.hvQ.setOnClickListener(this.hwG);
        this.hvL = (ImageView) ccJ().rootView.findViewById(a.f.ala_liveroom_host_more);
        this.hvL.setOnClickListener(this.hwG);
        this.hvO = (ImageView) ccJ().rootView.findViewById(a.f.ala_liveroom_host_zan_btn);
        this.hvO.setOnClickListener(this.hwG);
        chO();
        if (bm.b(com.baidu.live.ae.a.RB().bxq)) {
            this.hwo = new com.baidu.tieba.ala.liveroom.h.b(ccJ().hql, ccJ(), ccJ().hqi);
        }
        this.hfT = new m();
        chM();
        chN();
        if (com.baidu.live.d.BM().getInt("beauty_new_bubble", 1) == 1) {
            this.hvR.setVisibility(0);
        }
    }

    private void chL() {
        this.hwz = (FrameLayout) View.inflate(ccJ().pageContext.getPageActivity(), a.g.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hwz != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.hwz.setVisibility(8);
            if (this.hwz.getParent() != null && (this.hwz.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hwz.getParent()).removeView(this.hwz);
            }
            this.hvA.addView(this.hwz, layoutParams);
            if (this.hwz != null) {
                this.hwz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.hfu.s(AlaMasterLiveRoomOpearator.this.hwz, 8);
                    }
                });
            }
        }
    }

    private void chM() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, ccJ().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hfU = (k) runTask.getData();
            this.hfU.setFromMaster(true);
            this.hfU.Nd().getView().setId(a.f.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(ccJ().pageContext.getPageActivity()) * 0.75f), com.baidu.live.ak.c.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.ak.c.dk(true);
            ccJ().hpS.addView(this.hfU.Nd().getView(), layoutParams);
            this.hfU.Ne().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            ccJ().hpS.addView(this.hfU.Ne().getView(), layoutParams2);
            this.hfU.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
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

    private void chN() {
        View DL;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, ccJ().pageContext);
        if (runTask != null) {
            this.hfV = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hfV != null && (DL = this.hfV.DL()) != null && this.hja.hpS.indexOfChild(DL) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.hja.pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds98));
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            layoutParams.bottomMargin = ccJ().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            ccJ().hpS.addView(DL, layoutParams);
        }
    }

    private void chO() {
        CustomResponsedMessage runTask;
        if (this.hvV == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ah.a.class, ccJ().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hvV = (com.baidu.live.ah.a) runTask.getData();
        }
    }

    private void chP() {
        View HM;
        ac.d(ccJ().hpR.Iq());
        ac.b(ccJ().pageContext, true);
        ac.Ix();
        if (this.hfW == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVr = true;
            fVar.context = ccJ().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfW = (ad) runTask.getData();
                if (this.hfW != null && (HM = this.hfW.HM()) != null && ccJ().hpS.indexOfChild(HM) < 0) {
                    if (HM.getParent() instanceof ViewGroup) {
                        ((ViewGroup) HM.getParent()).removeView(HM);
                    }
                    ccJ().hpS.addView(HM, ccJ().hpS.getLayoutParams());
                }
            }
        }
    }

    private void chQ() {
        if (!this.hwA) {
            this.hwA = true;
            com.baidu.live.entereffect.a.Gi().bA(true);
        }
    }

    protected void cbx() {
        View Ip;
        if (this.hfX == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVr = true;
            aVar.context = ccJ().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfX = (ab) runTask.getData();
            }
        }
        if (this.hfX != null && (Ip = this.hfX.Ip()) != null && this.hvC != null) {
            if (this.hvC.indexOfChild(Ip) < 0) {
                if (Ip.getParent() instanceof ViewGroup) {
                    ((ViewGroup) Ip.getParent()).removeView(Ip);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.hvo != null && this.hvo.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
                    layoutParams.topMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hgt != null && this.hgt.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hgs != null && this.hgs.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else {
                    layoutParams.topMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds66);
                }
                this.hvC.addView(Ip, layoutParams);
            }
            Ip.bringToFront();
        }
    }

    protected void cbw() {
        View IC;
        if (this.hgi == null) {
            ak akVar = new ak();
            akVar.aVr = true;
            akVar.pageContext = ccJ().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hgi = (ag) runTask.getData();
            }
        }
        if (this.hgi != null && (IC = this.hgi.IC()) != null && ccJ().hpS.indexOfChild(IC) < 0) {
            if (IC.getParent() instanceof ViewGroup) {
                ((ViewGroup) IC.getParent()).removeView(IC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            ccJ().hpS.addView(IC, layoutParams);
        }
    }

    private void chR() {
        chV();
        cbC();
        chU();
        ccJ().hpS.setVisibility(0);
        xa(0);
    }

    private void chS() {
        if (this.hvo == null) {
            this.hvo = new com.baidu.tieba.ala.liveroom.u.a(ccJ().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.hvo.a(ccJ().ceF(), j, TbadkCoreApplication.getCurrentAccountName(), true, ccJ().hpR.Iq().aJV.portrait, this.otherParams, "", -1L);
        this.hvo.at(this.hvC);
    }

    private void chT() {
        if (this.hvX == null) {
            ccJ().hpS.hFs = false;
            com.baidu.live.af.a fI = fI(ccJ().pageContext.getPageActivity());
            if (fI != null) {
                this.hvX = fI;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.af.a.class, ccJ().pageContext.getPageActivity());
                if (runTask != null) {
                    this.hvX = (com.baidu.live.af.a) runTask.getData();
                }
            }
            if (this.hvX != null) {
                this.hvX.q(this.hvD);
                this.hvX.r(this.hvE);
                this.hvX.fy((ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds330) + ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96)) - ccJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds300));
                this.hvX.s(ccJ().hpS);
                this.hvX.a(this.heh);
                this.hvX.setLiveShowInfo(ccJ().hpR.Iq());
                this.hvX.a(this.heP);
                this.hvX.RV();
                this.hvX.a(new a.InterfaceC0172a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public void RW() {
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public void RX() {
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public void J(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.ccJ().hqi != null) {
                            AlaMasterLiveRoomOpearator.this.ccJ().hqi.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public int RY() {
                        return AlaMasterLiveRoomOpearator.this.hvB.getBottom();
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public int RZ() {
                        return AlaMasterLiveRoomOpearator.this.hja.hpS.getHeight() - (AlaMasterLiveRoomOpearator.this.hfU.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.hfU.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.hfU.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0172a
                    public int Sa() {
                        return AlaMasterLiveRoomOpearator.this.hfU.Ng();
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

    private void chU() {
        if (this.hvq == null) {
            this.hvq = new b(ccJ().pageContext, ccJ().hpS);
        }
    }

    private void chV() {
        if (this.heK == null) {
            this.heK = new com.baidu.tieba.ala.liveroom.o.a(ccJ().pageContext, true, this.hwK);
            this.heK.e(this.hvB, null);
            this.heK.a(this.hfu);
            this.heK.nO(false);
        }
        if (this.hvm == null) {
            this.hvm = new com.baidu.tieba.ala.liveroom.o.a(ccJ().pageContext, true, null);
            this.hvm.a(this.hvB, null, a.f.ala_live_room_host_header_stub);
            this.hvm.cgn();
        }
    }

    protected void cbe() {
        CustomResponsedMessage runTask;
        boolean z = false;
        aq cjz = ccJ().hpR.cjz();
        boolean z2 = com.baidu.live.ae.a.RB().brA.aOs;
        if (cjz == null || cjz.aKG) {
            z = z2;
        }
        if (z && this.hfF == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.j.b.class, ccJ().pageContext)) != null) {
            this.hfF = (com.baidu.live.j.b) runTask.getData();
            if (this.hfF != null) {
                this.hfF.setIsHost(true);
                this.hfF.eX(1);
                View view = this.hfF.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(ccJ().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(ccJ().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.f.ala_live_room_host_header_stub);
                    this.hvB.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(w wVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.heP == null) {
            this.heP = new com.baidu.tieba.ala.liveroom.activeview.b(ccJ().pageContext);
        }
        this.heP.setOtherParams(this.otherParams);
        this.heP.b(wVar, false);
        this.heP.setHost(true);
        this.heP.a(1, this.buZ);
        this.heP.a(2, this.buZ);
        this.heP.nc(this.hgO);
        this.heP.setVisible(this.hvk ? 8 : 0);
        this.heP.a(this.heh);
        if (this.heh != null) {
            if (this.heP != null) {
                alaActiveRootView2 = this.heP.ws(1);
                alaActiveRootView = this.heP.ws(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.heh.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.heh.a(alaActiveRootView);
            }
        }
    }

    private void N(w wVar) {
        CustomResponsedMessage runTask;
        if (this.hgx == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, ccJ().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hgx = (com.baidu.live.aa.a) runTask.getData();
            if (this.hgx != null) {
                this.hgx.p(this.buZ);
            }
        }
        if (this.hgx != null) {
            this.hgO = this.hgx.o(wVar);
            this.hgx.setCanVisible(!this.hvk);
        }
    }

    protected void chW() {
        CustomResponsedMessage runTask;
        if (ccJ() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.l.a.class, ccJ().pageContext.getPageActivity())) != null && runTask.getData() != null && this.hgo == null) {
            this.hgo = (com.baidu.live.l.a) runTask.getData();
            this.hgo.c(this.hvC, cbP());
            if (ccJ().hpR != null) {
                this.hgo.a(ccJ().hpR.Iq());
            }
            this.hgo.setCanVisible(true);
            this.hgo.cd(false);
            this.hgo.a(ccJ().hpR.bUt());
        }
    }

    protected void cbB() {
        CustomResponsedMessage runTask;
        if (ccJ() != null && this.hgq == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.t.a.class, ccJ().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hgq = (com.baidu.live.t.a) runTask.getData();
            this.hgq.setIsHost(true);
            this.hgq.a(this.buZ, ccJ().hpR.Iq());
        }
    }

    protected void car() {
        if (ccJ() != null) {
            if (this.hgr == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, ccJ().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hgr = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgr.bd(this.gGE);
            this.hgr.bf(false);
            this.hgr.a(this.buZ, ccJ().hpR.Iq());
        }
    }

    protected void cbA() {
        if (ccJ() != null) {
            if (this.hgp == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.v.a.class, ccJ().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgp = (com.baidu.live.v.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (ccJ().hpR != null) {
                this.hgp.b(ccJ().hpR.Iq(), this.otherParams);
            }
        }
    }

    protected void caq() {
        if (ccJ() != null) {
            if (this.heW == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, ccJ().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.heW = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.heW.setIsHost(true);
            this.heW.a(this.buZ, ccJ().hpR.Iq().aKU);
        }
    }

    protected void chX() {
        CustomResponsedMessage runTask;
        if (ccJ() != null && this.hvU == null && (runTask = MessageManager.getInstance().runTask(2913269, com.baidu.live.n.b.class, ccJ().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hvU = (com.baidu.live.n.b) runTask.getData();
        }
    }

    protected void cbD() {
        CustomResponsedMessage runTask;
        if (ccJ() != null && this.hgs == null && (runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.k.a.class, ccJ().pageContext)) != null && runTask.getData() != null) {
            this.hgs = (com.baidu.live.k.a) runTask.getData();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            this.hgs.a(this.hvC, ccJ().hpR.Iq(), layoutParams, this.otherParams);
        }
    }

    private void O(w wVar) {
        CustomResponsedMessage runTask;
        if (ccJ() != null) {
            if (this.hvs == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.t.d.class)) != null) {
                this.hvs = (com.baidu.live.t.d) runTask.getData();
            }
            if (this.hvs != null) {
                this.hvs.Qy();
            }
            if (this.hvt == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913230, com.baidu.live.t.c.class);
                if (runTask2 != null) {
                    this.hvt = (com.baidu.live.t.c) runTask2.getData();
                }
                if (this.hvt != null) {
                    this.hvt.setParentView(this.hja.hpS);
                    if (wVar != null && wVar.aJV != null) {
                        this.hvt.bd(wVar.aJV.userId);
                    }
                }
            }
        }
    }

    private void chY() {
        CustomResponsedMessage runTask;
        if (ccJ() != null) {
            if (this.hvu == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.v.c.class)) != null) {
                this.hvu = (com.baidu.live.v.c) runTask.getData();
            }
            if (this.hvu != null) {
                this.hvu.Qy();
            }
            if (this.hvv == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913266, com.baidu.live.v.b.class);
                if (runTask2 != null) {
                    this.hvv = (com.baidu.live.v.b) runTask2.getData();
                }
                if (this.hvv != null) {
                    this.hvv.setParentView(this.hja.hpS);
                    this.hvv.b(ccJ().hpR.Iq(), this.otherParams);
                }
            }
        }
    }

    private void cbn() {
        if (this.hwt == null) {
            this.hwt = new com.baidu.tieba.ala.liveroom.q.c(ccJ().pageContext.getPageActivity());
        }
    }

    private ViewGroup.LayoutParams cbP() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(ccJ().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.f.ala_live_room_stream_view);
            layoutParams.leftMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.f.ala_liveroom_charmview);
        }
        if (this.hgt != null && this.hgt.isShowing()) {
            layoutParams.addRule(3, a.f.ala_rank_level_entry);
            layoutParams.topMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        } else if (this.hvo != null && this.hvo.isShowing()) {
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            layoutParams.topMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        }
        return layoutParams;
    }

    private void cbC() {
        if (this.hvn == null) {
            this.hvn = new com.baidu.tieba.ala.liveroom.b.a(ccJ().pageContext, true);
        }
    }

    private void chZ() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = ccJ().pageContext.getPageActivity();
            if (this.hvY == null) {
                this.hvY = new ImageView(pageActivity);
                this.hvY.setId(a.f.master_close_btn);
                this.hvY.setTag("master_close_btn");
                this.hvY.setImageResource(a.e.sdk_icon_bar_live_close_n);
                this.hvY.setBackgroundResource(a.e.sdk_round_btn_close_bg);
                this.hvY.setPadding(pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0);
            }
            if (this.hvY.getParent() != null) {
                ((ViewGroup) this.hvY.getParent()).removeView(this.hvY);
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
            ccJ().hql.addView(this.hvY, layoutParams);
            this.hvY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.cij();
                }
            });
            this.hvY.setVisibility(8);
        }
    }

    protected void cbF() {
        if (this.hgt == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.t.b.class, ccJ().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgt = (com.baidu.live.t.b) runTask.getData();
            } else {
                return;
            }
        }
        if (ccJ().hpR.Iq() != null && ccJ().hpR.Iq().aJV != null && ccJ().hpR.Iq().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.height = BdUtilHelper.getDimens(ccJ().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.leftMargin = BdUtilHelper.getDimens(ccJ().pageContext.getPageActivity(), a.d.sdk_ds20);
            this.hgt.b(this.hvC, layoutParams, ccJ().hpR.Iq());
        }
    }

    private void cia() {
        CustomResponsedMessage runTask;
        if (this.hwr == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, ccJ().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.hwr = (com.baidu.live.b.a) runTask.getData();
            if (this.hwr != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.f.ala_head_line_entry_id);
                layoutParams.addRule(11);
                layoutParams.topMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
                layoutParams.rightMargin = ccJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                aq cjz = ccJ().hpR.cjz();
                if (cjz != null) {
                    this.hwr.a(this.hvC, layoutParams, ccJ().pageContext.getPageActivity(), cjz.aPl);
                } else {
                    return;
                }
            }
        }
        if (this.hwr != null) {
            this.hwr.a(ccJ().hpR.Iq());
        }
    }

    private void cib() {
        CustomResponsedMessage runTask;
        if (this.hws == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, ccJ().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.hws = (com.baidu.live.b.b) runTask.getData();
        }
    }

    private void cbo() {
        if (this.gTR == null) {
            this.gTR = new com.baidu.live.ao.a(ccJ().pageContext.getPageActivity());
        }
    }

    public void onRtcConnected(int i) {
        if (this.hwp != null) {
            this.hwp.onRtcConnected(i);
        }
    }

    private void registerListener() {
        ccJ().pageContext.registerListener(this.hhg);
        ccJ().pageContext.registerListener(this.hwC);
        ccJ().pageContext.registerListener(this.hhh);
        ccJ().pageContext.registerListener(this.hhi);
        ccJ().pageContext.registerListener(this.hwH);
        ccJ().pageContext.registerListener(this.byv);
        ccJ().pageContext.registerListener(this.hdn);
        ccJ().pageContext.registerListener(this.hwI);
        ccJ().pageContext.registerListener(this.gDr);
        ccJ().pageContext.registerListener(this.hfp);
        ccJ().pageContext.registerListener(this.hhm);
        ccJ().pageContext.registerListener(this.bAT);
        ccJ().pageContext.registerListener(this.bAU);
        ccJ().pageContext.registerListener(this.hwD);
        ccJ().pageContext.registerListener(this.brg);
        ccJ().pageContext.registerListener(this.brh);
        ccJ().pageContext.registerListener(this.hwE);
        ccJ().pageContext.registerListener(this.hho);
        ccJ().pageContext.registerListener(this.hhn);
        ccJ().pageContext.registerListener(this.hhr);
        ccJ().pageContext.registerListener(this.hwF);
        ccJ().pageContext.registerListener(this.hwE);
        ccJ().pageContext.registerListener(this.bon);
        ccJ().pageContext.registerListener(this.blO);
        ccJ().pageContext.registerListener(this.gTS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nT(boolean z) {
        if (bm.c(com.baidu.live.ae.a.RB().bxq)) {
            ccJ().pageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (ccJ().hqn.Dz() == null || ListUtils.isEmpty(ccJ().hqn.Dz().aET)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ccJ().pageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (!this.bAR) {
                this.bAQ = BdUniqueId.gen();
                ccJ().hqn.a(this.bAQ);
                this.bAR = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(ccJ().pageContext.getPageActivity(), ccJ().rootView);
            xa(8);
            if (ccJ().hqi.hasAdvancedBeauty() && this.hwo != null) {
                if (!this.hwu || this.hvl.getVisibility() == 0) {
                    this.hwo.c(ccJ().hqi.getVideoConfig());
                }
                this.hwo.a(ccJ().hqi.getVideoConfig(), this.bAS);
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
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccJ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.h.sdk_prompt);
        bdAlertDialog.setMessageId(i, currentAppType(ccJ().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.ccJ().g((short) 1);
            }
        });
        bdAlertDialog.create(ccJ().pageContext).show();
    }

    private void Iy(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccJ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.h.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.ccJ().g((short) 1);
            }
        });
        bdAlertDialog.create(ccJ().pageContext).show();
    }

    public void cic() {
        cbe();
        q bUt = ccJ().hpR.bUt();
        int i = 5;
        if (bUt != null) {
            i = (int) bUt.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq() != null && AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.ccJ().hpR.h(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bUt != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.hja.hqq.b(bUt);
                return;
            }
            if (this.heJ == null) {
                this.heJ = new c(ccJ().pageContext, this.hwK, true);
            }
            if (this.hwm) {
                this.hwm = false;
                this.heJ.a(String.valueOf(ccJ().hpR.Iq().mLiveInfo.group_id), String.valueOf(ccJ().hpR.Iq().mLiveInfo.live_id), String.valueOf(ccJ().hpR.Iq().aJV.userId), ccJ().hpR.Iq());
                int i2 = a.f.ala_live_room_host_header_stub;
                if (this.hfF != null) {
                    i2 = a.f.ala_liveroom_guardthrone;
                }
                this.heJ.c(this.hvB, i2, a.f.ala_liveroom_audience_count_layout);
            }
            this.heJ.e(bUt);
            this.heN.setVisible(0);
            this.heN.eZ(bUt.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cid() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvJ() {
        if (ccJ().hpR != null) {
            if (this.hfH == null) {
                this.hfH = new com.baidu.tieba.ala.liveroom.share.c(ccJ().pageContext);
            }
            this.hfH.c(ccJ().hpR.Iq(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (ccJ().hpR != null && ccJ().hpR.Iq() != null && ccJ().hpR.Iq().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", ccJ().hpR.Iq().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", ccJ().hpR.Iq().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", ccJ().hpR.Iq().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (ccJ().hpR != null && ccJ().hpR.Iq() != null && ccJ().hpR.Iq().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", ccJ().hpR.Iq().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", ccJ().hpR.Iq().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", ccJ().hpR.Iq().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean cie() {
        return this.hvj;
    }

    private void nU(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(hvi, z);
        this.hvj = z;
    }

    private void cif() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccJ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.h.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.p.b(AlaMasterLiveRoomOpearator.this.ccJ().pageContext).cjh();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.h.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(ccJ().pageContext).show();
    }

    private void cig() {
        if (this.huS && ccJ().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            ccJ().hqp.Vh();
        }
        ccJ().hqo.prepareTime = System.currentTimeMillis() - ccJ().hqo.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (ccJ().hpR != null && ccJ().hpR.Iq() != null && ccJ().hpR.Iq().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", ccJ().hpR.Iq().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", ccJ().hpR.Iq().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", ccJ().hqo.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hvl != null && this.hvl.getView().getParent() != null) {
            this.hvl.setVisibility(8);
            ccJ().hql.removeView(this.hvl.getView());
            this.hvl.release();
        }
        if (this.hwo != null) {
            this.hwo.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (ccJ().hpS.indexOfChild(this.hvy) < 0) {
            ccJ().hpS.addView(this.hvy, layoutParams);
        }
        this.hvy.xq(1000);
    }

    private void ays() {
        if (ccJ().ceF() == 1) {
            ccJ().hqi.startRecord();
        }
    }

    private void Iz(String str) {
        IA(str);
    }

    private void IA(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) ccJ().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.hvl != null) {
            this.hvl.In(fromJson.getSmallurl());
        }
    }

    private boolean cih() {
        return com.baidu.live.d.BM().getBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cii() {
        com.baidu.live.d.BM().putBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), this.hja.hqi.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cij() {
        if (this.hwq == null || !this.hwq.Su()) {
            if (this.hvx == null || !this.hvx.Su()) {
                int i = a.h.live_close_confirm;
                if (this.hwp != null && this.hwp.ccR()) {
                    i = a.h.ala_pk_pking_close_live_roon_tip;
                } else if (this.hwp != null && this.hwp.ccQ()) {
                    i = a.h.ala_challenge_challenging_close_live_room_tip;
                }
                BdAlertDialog bdAlertDialog = new BdAlertDialog(ccJ().pageContext.getPageActivity());
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
                        if (AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq() != null) {
                            AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq(), 0, AlaMasterLiveRoomOpearator.this.ccJ().hpR.cjI() != 1 ? AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
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
                bdAlertDialog.create(ccJ().pageContext).show();
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
                ccJ().hpR.eD(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.hwk) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = ccJ().hqo;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = ccJ().hqi.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.hwg;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.hwh;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.hwc;
            if (this.hwd != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.hwe - this.hwf) / this.hwd) * 100.0f;
            }
            Intent intent = new Intent(ccJ().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (ccJ().hpR != null && ccJ().hpR.Iq() != null && ccJ().hpR.Iq().aJV != null) {
                String str3 = ccJ().hpR.Iq().aJV.nickName;
                String str4 = ccJ().hpR.Iq().aJV.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            w Iq = ccJ().hpR.Iq();
            if (Iq != null && Iq.aJV != null && !TextUtils.isEmpty(Iq.aJV.portrait)) {
                intent.putExtra("host_portrait", Iq.aJV.portrait);
            }
            if (this.hwq != null) {
                this.hwq.WF();
            }
            if (this.hvx != null) {
                this.hvx.Ss();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.hwi = intent;
                this.hwj = s;
                ccJ().pageContext.showToast(a.h.ala_live_background_close_tip);
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
    public void cik() {
        if (this.hwi != null) {
            a(this.hwi, this.hwj);
            this.hwi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.hwk = true;
        if (this.hwp != null) {
            this.hwp.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.hdc);
            ccJ().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        ccJ().g(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cil() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hja.hqq != null && this.hja.hqq.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hwp != null && this.hwp.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hwq != null && this.hwq.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hwo != null && this.hwo.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hvx != null && this.hvx.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (ccJ().hqm.ciQ()) {
                cij();
                return true;
            }
        }
        return false;
    }

    public void sendBufferChanged(int i) {
        if (this.hvz != null) {
            this.hvz.fK(i);
        }
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (this.hja != null && this.hja.hpR != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.dFt != i3) {
                this.dFt = i3;
                if (this.hvr == null) {
                    this.hvr = new com.baidu.tieba.ala.liveroom.tippop.a(this.hja.pageContext, null);
                }
                switch (this.dFt) {
                    case 0:
                        this.hvr.a(this.hja.hql, this.hja.pageContext.getString(a.h.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.hvr.a(this.hja.hql, this.hja.pageContext.getString(a.h.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.hvr.a(this.hja.hql, this.hja.pageContext.getString(a.h.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.hja.hpR.x(this.hja.hpR.Iq().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.cil();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq(), 1, str3);
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
        if (this.heP != null) {
            this.heP.G(bVar);
        }
        if (bVar.getMsgType() == 125) {
            if (this.hvp != null) {
                this.hvp.K(bVar);
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
                        if (this.hwp != null) {
                        }
                        if (!"close_live".equals(str2)) {
                        }
                        if (!(bVar.getObjContent() instanceof JSONObject)) {
                        }
                        jSONObject6.put("log_id", bVar.getMsgId());
                        if (this.hgs != null) {
                        }
                        if (this.hgq != null) {
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
            if (this.hwp != null) {
                this.hwp.gx(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cil();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccJ().hpR.Iq(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (ccJ().hpR.Iq() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ccJ().hpR.Iq().aKr.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ccJ().hpR.Iq().aKr.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        ccJ().hpR.Iq().aKr.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (ccJ().hpR.Iq() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (ccJ().hpR.Iq() != null && ccJ().hpR.Iq().aJV != null && ccJ().hpR.Iq().aJV.userId == optLong2) {
                        ccJ().hpR.Iq().aJV.isUegBlock = 1;
                        caI();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (ccJ().hpR.Iq() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (ccJ().hpR.Iq() != null && ccJ().hpR.Iq().aJV != null && ccJ().hpR.Iq().aJV.userId == optLong3) {
                        ccJ().hpR.Iq().aJV.isUegBlock = 0;
                        caI();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.hvV != null) {
                    this.hvV.R(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.hvq.aJ(optString4, optInt2);
                    }
                    if (this.heN.getCount() > 20) {
                        this.heN.eZ(this.heN.getCount() + 1);
                    } else if (this.heJ != null) {
                        com.baidu.live.data.a NU = bVar.NU();
                        com.baidu.live.data.p pVar = new com.baidu.live.data.p();
                        pVar.aJW = new AlaLocationData();
                        pVar.aJX = new AlaRelationData();
                        pVar.aJV = new AlaLiveUserInfoData();
                        pVar.aJV.userId = JavaTypesHelper.toLong(NU.userId, 0L);
                        pVar.aJV.userName = NU.userName;
                        pVar.aJV.portrait = NU.portrait;
                        if (this.heJ.c(pVar)) {
                            this.heN.eZ(this.heN.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && ccJ() != null && ccJ().hpR != null && ccJ().hpR.Iq() != null && ccJ().hpR.Iq().aKr != null && ccJ().hpR.Iq().aKr.userId == jSONObject2.optLong("user_id")) {
                    ccJ().hpR.cjy();
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
                        BdUtilHelper.showToast(ccJ().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(ccJ().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
            } else if ("connect_apply_show_pub".equals(str2)) {
                if (this.hvx != null) {
                    this.hvx.Q(jSONObject2);
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
                if (ccJ().hpR == null || ccJ().hpR.Iq() == null || ccJ().hpR.Iq().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                    str3 = "";
                    str4 = "";
                    z = false;
                } else {
                    long j4 = ccJ().hpR.Iq().mLiveInfo.live_id;
                    long j5 = ccJ().hpR.Iq().mLiveInfo.group_id;
                    long j6 = ccJ().hpR.Iq().aJV.userId;
                    str7 = ccJ().hpR.Iq().mLiveInfo.appId;
                    boolean z5 = ccJ().hpR.Iq().mLiveInfo.isPubShow;
                    if (ccJ().hpR.Iq().mLiveSdkInfo.mCastIds == null) {
                        j = j6;
                        j2 = j4;
                        j3 = j5;
                        str3 = "";
                        str4 = "";
                        z = z5;
                    } else {
                        String str8 = ccJ().hpR.Iq().mLiveSdkInfo.mCastIds.chatMCastId;
                        j = j6;
                        j2 = j4;
                        j3 = j5;
                        str3 = ccJ().hpR.Iq().mLiveSdkInfo.mCastIds.ensureMCastId;
                        str4 = str8;
                        z = z5;
                    }
                }
                if (!z3 || z2) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString8, "");
                    if (!this.isBackground || ccJ().ceF() != 2) {
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
        if (this.hgs != null) {
            this.hgs.l(bVar);
        }
        if ((this.hgq != null || !this.hgq.N(jSONObject6)) && this.heW != null && this.heW.N(jSONObject6)) {
        }
    }

    private void Ic(String str) {
        if (this.heP != null) {
            this.heP.Ic(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa(int i) {
        View findViewById = ccJ().rootView.findViewById(a.f.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.heP != null) {
            this.heP.bQ(2, i);
        }
    }

    private void cim() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.ccJ().hqi != null && AlaMasterLiveRoomOpearator.this.ccJ().hqi.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.ccJ().hqi.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.ccJ().hqi.startRecord();
                }
            }
        });
    }

    private void cin() {
        if (ccJ().hqi != null && ccJ().hqi.getPreview() != null) {
            ccJ().hqi.getPreview().setVisibility(8);
            ccJ().hqi.stopRecord();
        }
    }

    public void cio() {
        this.hqf = ccJ().hpR.cjJ();
        if (this.hvl != null) {
            this.hvl.nB(this.hqf);
        }
    }

    public void ceD() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cip();
        } else if (this.hvl != null) {
            this.hvl.ceD();
        }
    }

    public void nC(boolean z) {
        if (this.hvl != null) {
            this.hvl.nC(z);
        }
    }

    public void onDestroy() {
        if (this.hwb != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.hwb);
        }
        this.hwb = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hvT.removeCallbacksAndMessages(null);
        if (this.hwo != null) {
            this.hwo.nz(true);
        }
        this.hwo = null;
        if (this.hvl != null) {
            this.hvl.destroy();
            ccJ().hql.removeView(this.hvl.getView());
            this.hvl.release();
            this.hvl = null;
        }
        if (this.hwp != null) {
            this.hwp.onDestroy();
        }
        if (this.hfH != null) {
            this.hfH.onDestroy();
        }
        if (this.heK != null) {
            this.heK.onDestroy();
            this.heK = null;
        }
        if (this.hvm != null) {
            this.hvm.onDestroy();
        }
        if (this.hgi != null) {
            this.hgi.onDestroy();
            this.hgi = null;
        }
        if (this.hvy != null) {
            this.hvy.stopCountDown();
        }
        if (this.hvo != null) {
            this.hvo.onDestroy();
        }
        if (this.hvq != null) {
            this.hvq.onDestroy();
        }
        if (this.hvV != null) {
            this.hvV.onDestroy();
            this.hvV = null;
        }
        if (this.hfW != null) {
            this.hfW.onDestroy();
            this.hfW = null;
        }
        if (this.hvs != null) {
            this.hvs.release();
        }
        if (this.hvu != null) {
            this.hvu.release();
        }
        com.baidu.live.ag.a.b.Sm().release();
        ac.Iy();
        com.baidu.live.entereffect.a.Gi().release();
        this.hwA = false;
        if (this.hfX != null) {
            this.hfX.onDestroy();
            this.hfX = null;
        }
        if (this.hvr != null) {
            this.hvr.onDestroy();
        }
        if (this.hvp != null) {
            this.hvp.clL();
            this.hvp.release();
        }
        if (this.heN != null) {
            this.heN = null;
        }
        if (this.heP != null) {
            this.heP.release();
        }
        if (this.hvp != null) {
            this.hvp.onDestroy();
        }
        if (this.hfV != null) {
            this.hfV.release();
        }
        if (this.hvw != null) {
            this.hvw.release();
        }
        if (this.hvX != null) {
            this.hvX.onDestroy();
        }
        if (this.hgx != null) {
            this.hgx.release();
        }
        if (this.hwr != null) {
            this.hwr.onDestory();
        }
        if (this.hws != null) {
            this.hws.release();
        }
        if (this.hgo != null) {
            this.hgo.onDestroy();
        }
        if (this.hgq != null) {
            this.hgq.onDestroy();
        }
        if (this.hgp != null) {
            this.hgp.onDestroy();
        }
        if (this.heW != null) {
            this.heW.onDestroy();
        }
        if (this.hvt != null) {
            this.hvt.release();
            this.hvt = null;
        }
        if (this.hvv != null) {
            this.hvv.release();
            this.hvv = null;
        }
        if (this.hwt != null) {
            this.hwt.release();
        }
        if (this.gTR != null) {
            this.gTR.release();
        }
        if (this.hgt != null) {
            this.hgt.onDestroy();
        }
        if (this.hwq != null) {
            this.hwq.onDestroy();
        }
        if (this.hvx != null) {
            this.hvx.onDestroy();
        }
        this.hwv.removeCallbacksAndMessages(this.hwS);
        MessageManager.getInstance().unRegisterListener(this.hhg);
        MessageManager.getInstance().unRegisterListener(this.hwC);
        MessageManager.getInstance().unRegisterListener(this.hhh);
        MessageManager.getInstance().unRegisterListener(this.hhi);
        MessageManager.getInstance().unRegisterListener(this.hwH);
        MessageManager.getInstance().unRegisterListener(this.byv);
        MessageManager.getInstance().unRegisterListener(this.hdn);
        MessageManager.getInstance().unRegisterListener(this.hwI);
        MessageManager.getInstance().unRegisterListener(this.gDr);
        MessageManager.getInstance().unRegisterListener(this.hfp);
        MessageManager.getInstance().unRegisterListener(this.hhm);
        MessageManager.getInstance().unRegisterListener(this.bAT);
        MessageManager.getInstance().unRegisterListener(this.bAU);
        MessageManager.getInstance().unRegisterListener(this.hwD);
        MessageManager.getInstance().unRegisterListener(this.brg);
        MessageManager.getInstance().unRegisterListener(this.brh);
        MessageManager.getInstance().unRegisterListener(this.hwE);
        MessageManager.getInstance().unRegisterListener(this.hho);
        MessageManager.getInstance().unRegisterListener(this.hhn);
        MessageManager.getInstance().unRegisterListener(this.hhr);
        MessageManager.getInstance().unRegisterListener(this.hwF);
        MessageManager.getInstance().unRegisterListener(this.hwE);
        MessageManager.getInstance().unRegisterListener(this.bon);
        MessageManager.getInstance().unRegisterListener(this.blO);
        MessageManager.getInstance().unRegisterListener(this.gTS);
        MessageManager.getInstance().unRegisterListener(this.gND);
        MessageManager.getInstance().unRegisterListener(this.gNV);
        ccJ().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hja.hqq.a(this.hwR, this.hja.hqk, this.hvA, alaLivePersonData);
        }
    }

    private void cip() {
        if (this.hvZ != null) {
            this.hja.hqo.startTime = System.currentTimeMillis();
            this.hja.hqo.liveTotalTime = System.currentTimeMillis();
            this.hja.hqo.sampleMemAndCPU();
            this.hja.hqm.a((short) 4, this.hvZ);
        }
    }

    private void IB(String str) {
        String str2;
        int i;
        if (ccJ() != null && ccJ().pageContext != null) {
            this.hvT.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = ccJ().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.hwy == null) {
                    this.hwy = layoutInflater.inflate(a.g.layout_challenge_entry_toast, (ViewGroup) null);
                    this.hwy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.chm()) {
                                AlaMasterLiveRoomOpearator.this.hvT.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.hwy != null) {
                                    AlaMasterLiveRoomOpearator.this.ccJ().hpS.removeView(AlaMasterLiveRoomOpearator.this.hwy);
                                }
                                if (AlaMasterLiveRoomOpearator.this.hwp != null) {
                                    AlaMasterLiveRoomOpearator.this.hwp.ccN();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.hwy.findViewById(a.f.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.h.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.hvT.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.ccJ().hpS != null && AlaMasterLiveRoomOpearator.this.hjh != null && AlaMasterLiveRoomOpearator.this.hwy != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.hwy.findViewById(a.f.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.hwy.findViewById(a.f.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.v((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.hwy.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.hjh.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.hjh.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.hjh.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.hjh.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.hwy.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.hwy.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.hwy != null) {
                                AlaMasterLiveRoomOpearator.this.ccJ().hpS.removeView(AlaMasterLiveRoomOpearator.this.hwy);
                            }
                            AlaMasterLiveRoomOpearator.this.ccJ().hpS.addView(AlaMasterLiveRoomOpearator.this.hwy, layoutParams);
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
                this.hvT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.ccJ().hpS != null && AlaMasterLiveRoomOpearator.this.hwy != null) {
                            AlaMasterLiveRoomOpearator.this.ccJ().hpS.removeView(AlaMasterLiveRoomOpearator.this.hwy);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bVZ() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            w Iq = ccJ().hpR.Iq();
            if (Iq != null) {
                bVar.setAnchorId(Iq.mLiveInfo.user_id);
                bVar.setParams();
                bVar.setTag(this.gEP);
                MessageManager.getInstance().sendMessage(bVar);
            }
        }
    }

    public void ciq() {
        boolean z = com.baidu.live.d.BM().getBoolean("new_anchor_club_rename", true);
        aq cjz = ccJ().hpR.cjz();
        if (cjz != null && this.bja != null && cjz.aPm == 1 && z) {
            ccJ().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
            com.baidu.live.d.BM().putBoolean("new_anchor_club_rename", false);
            this.gOc = View.inflate(ccJ().pageContext.getPageActivity(), a.g.dialog_help_guard_club_rename, null);
            this.gOF = new Dialog(ccJ().pageContext.getPageActivity(), a.i.RegimentRenameDiolog);
            final Button button = (Button) this.gOc.findViewById(a.f.rename_confirm);
            button.setEnabled(false);
            button.setTextColor(ccJ().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
            final EditText editText = (EditText) this.gOc.findViewById(a.f.guard_club_rename_edittext);
            final TextView textView = (TextView) this.gOc.findViewById(a.f.hint_num);
            ((Button) this.gOc.findViewById(a.f.rename_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.64
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.gOb = null;
                    AlaMasterLiveRoomOpearator.this.gOF.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.65
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (editText.getText().toString() != null) {
                        AlaMasterLiveRoomOpearator.this.gOb = editText.getText().toString();
                        if (AlaMasterLiveRoomOpearator.this.bja != null && AlaMasterLiveRoomOpearator.this.gOb != null) {
                            if (BdNetTypeUtil.isNetWorkAvailable()) {
                                AlaMasterLiveRoomOpearator.this.k(AlaMasterLiveRoomOpearator.this.bja.id, AlaMasterLiveRoomOpearator.this.gOb, "");
                            } else {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity(), "网络故障，请刷新重试");
                            }
                        } else {
                            return;
                        }
                    }
                    AlaMasterLiveRoomOpearator.this.gOF.dismiss();
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
                        textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        textView.setText("0");
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                    }
                    if (obj.length() > 0) {
                        int i4 = 0;
                        int i5 = 0;
                        for (int i6 = 0; i6 < obj.length(); i6++) {
                            String substring = obj.substring(i6, i6 + 1);
                            if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity(), "仅支持中英文及数字");
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
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity(), "不能超过3个字符");
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
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                            } else {
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccJ().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                            }
                        }
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gOF.setContentView(this.gOc);
            this.gOF.setCanceledOnTouchOutside(true);
            this.gOc.setMinimumHeight((int) (com.baidu.tieba.ala.liveroom.h.f.getScreenHeight(ccJ().pageContext.getPageActivity()) * 0.22f));
            this.hwx = this.gOF.getWindow();
            this.hww = this.hwx.getAttributes();
            this.hww.width = (int) (com.baidu.tieba.ala.liveroom.h.f.getScreenWidth(ccJ().pageContext.getPageActivity()) * 0.74f);
            this.hww.height = -2;
            this.hww.gravity = 17;
            this.hwx.setAttributes(this.hww);
            this.gOF.show();
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
