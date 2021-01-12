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
import android.os.Build;
import android.os.Handler;
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
import androidx.core.view.ViewCompat;
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
import com.baidu.live.ag.a;
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
import com.baidu.live.data.as;
import com.baidu.live.data.at;
import com.baidu.live.data.bc;
import com.baidu.live.data.bd;
import com.baidu.live.data.bg;
import com.baidu.live.data.bo;
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
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
import com.baidu.live.u.c;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.challenge.e;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
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
/* loaded from: classes10.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String hCA;
    private BdUniqueId bAR;
    private boolean bAS;
    private boolean bAT;
    private com.baidu.live.guardclub.a bfP;
    private boolean bnc;
    private PendantParentView buY;
    private boolean gNL;
    private Dialog gVO;
    private String gVk;
    private boolean hCB;
    private d hCD;
    private com.baidu.tieba.ala.liveroom.o.a hCE;
    private com.baidu.tieba.ala.liveroom.b.a hCF;
    private com.baidu.tieba.ala.liveroom.u.a hCG;
    private com.baidu.tieba.ala.liveroom.w.a hCH;
    private b hCI;
    private com.baidu.tieba.ala.liveroom.tippop.a hCJ;
    private com.baidu.live.u.d hCK;
    private c hCL;
    private com.baidu.live.w.c hCM;
    private com.baidu.live.w.b hCN;
    protected com.baidu.live.n.a hCO;
    protected com.baidu.live.ao.b hCP;
    private AlaLiveCountDownView hCQ;
    private AlaLiveStreamStatusView hCR;
    private RelativeLayout hCS;
    private RelativeLayout hCT;
    private RelativeLayout hCU;
    private RelativeLayout hCV;
    private RelativeLayout hCW;
    private FrameLayout hCX;
    private FrameLayout hCY;
    private View hCZ;
    private boolean hCk;
    private short hDD;
    private com.baidu.tieba.ala.liveroom.h.b hDI;
    private e hDJ;
    private com.baidu.live.an.a hDK;
    private com.baidu.live.b.a hDL;
    private com.baidu.live.b.b hDM;
    private com.baidu.tieba.ala.liveroom.q.a hDN;
    private boolean hDO;
    private boolean hDQ;
    private View hDR;
    private FrameLayout hDS;
    private boolean hDT;
    private boolean hDa;
    private AlaLiveFaceVerifyView hDb;
    private ImageView hDc;
    private ImageView hDd;
    private ImageView hDe;
    private ImageView hDf;
    private ImageView hDg;
    private ImageView hDh;
    private ImageView hDi;
    private TextView hDj;
    private at hDk;
    private com.baidu.live.o.b hDm;
    private com.baidu.live.ai.a hDn;
    private com.baidu.tieba.ala.liveroom.master.panel.b hDo;
    private com.baidu.live.ag.a hDp;
    private ImageView hDq;
    private BdAlertDialog hDr;
    private BdAlertDialog hDs;
    private com.baidu.tieba.ala.liveroom.data.d hDt;
    private com.baidu.live.ap.a hba;
    private String hkk;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hlR;
    private com.baidu.tieba.ala.liveroom.o.a hlS;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hlV;
    private com.baidu.tieba.ala.liveroom.activeview.b hlX;
    private com.baidu.live.j.a hlp;
    private com.baidu.live.k.b hmP;
    private com.baidu.tieba.ala.liveroom.share.c hmR;
    private com.baidu.tieba.ala.liveroom.r.b hmS;
    protected com.baidu.live.ae.a hme;
    protected com.baidu.live.u.a hnA;
    protected com.baidu.live.a.a hnB;
    protected com.baidu.live.l.a hnC;
    protected com.baidu.live.u.b hnD;
    private com.baidu.live.ab.a hnI;
    protected com.baidu.live.t.a hnM;
    private boolean hnZ;
    private m hnd;
    private k hne;
    private com.baidu.live.im.b.a hnf;
    private ad hng;
    private ab hnh;
    protected ag hns;
    protected com.baidu.live.m.a hny;
    protected com.baidu.live.w.a hnz;
    private com.baidu.tieba.ala.liveroom.data.e hqr;
    private ImageView hqy;
    private f hqz;
    private boolean hCC = false;
    private boolean hnU = false;
    private Handler mHandler = new Handler();
    private Handler hDl = new Handler();
    private boolean hDu = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver hDv = null;
    private boolean hDw = false;
    private int hDx = 0;
    private int hDy = 0;
    private int hDz = 0;
    private long hDA = 0;
    private long hDB = 0;
    private volatile boolean isBackground = false;
    private Intent hDC = null;
    private int mOrientation = 1;
    private boolean hxx = false;
    private boolean hDE = false;
    private boolean hDF = true;
    private boolean hqw = false;
    private boolean hDG = true;
    private boolean hDH = true;
    private int dJl = 0;
    private String otherParams = "";
    private Handler hDP = new Handler();
    private BdUniqueId gLW = BdUniqueId.gen();
    private boolean mIsKeyboardOpen = false;
    private int bng = 0;
    private Runnable hDU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.hlp != null) {
                AlaMasterLiveRoomOpearator.this.hlp.BF();
            }
        }
    };
    private com.baidu.live.an.b bKt = new com.baidu.live.an.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.an.b
        public boolean TU() {
            if (AlaMasterLiveRoomOpearator.this.hDJ != null) {
                if (AlaMasterLiveRoomOpearator.this.hnA != null) {
                    if (!AlaMasterLiveRoomOpearator.this.hDJ.cbL() && !AlaMasterLiveRoomOpearator.this.hDJ.cbM() && !AlaMasterLiveRoomOpearator.this.hnA.NG() && !AlaMasterLiveRoomOpearator.this.hnA.zG()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.hDJ.cbL() && !AlaMasterLiveRoomOpearator.this.hDJ.cbM()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.hnA == null || AlaMasterLiveRoomOpearator.this.hnA.NG() || AlaMasterLiveRoomOpearator.this.hnA.zG()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.an.b
        public void TV() {
            if (AlaMasterLiveRoomOpearator.this.hDJ != null) {
                AlaMasterLiveRoomOpearator.this.hDJ.cbO();
            }
        }

        @Override // com.baidu.live.an.b
        public void TW() {
            AlaMasterLiveRoomOpearator.this.hDQ = true;
            AlaMasterLiveRoomOpearator.this.cbJ().hxk.hMO = false;
            if (AlaMasterLiveRoomOpearator.this.hnB != null) {
                AlaMasterLiveRoomOpearator.this.hnB.aW(true);
                AlaMasterLiveRoomOpearator.this.hnB.aX(true);
            }
            AlaMasterLiveRoomOpearator.this.cbf();
        }

        @Override // com.baidu.live.an.b
        public void TX() {
            AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12.1
                @Override // java.lang.Runnable
                public void run() {
                    AlaMasterLiveRoomOpearator.this.hDQ = false;
                    AlaMasterLiveRoomOpearator.this.cbJ().hxk.hMO = false;
                    if (AlaMasterLiveRoomOpearator.this.hnB != null) {
                        AlaMasterLiveRoomOpearator.this.hnB.aW(false);
                        AlaMasterLiveRoomOpearator.this.hnB.aX(false);
                    }
                    AlaMasterLiveRoomOpearator.this.cbf();
                }
            }, 1500L);
        }
    };
    private CustomMessageListener boo = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hqr.hxI != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.hqr.hxI.f(list, false);
                }
                for (com.baidu.live.im.data.b bVar : list) {
                    if (bVar != null) {
                        AlaMasterLiveRoomOpearator.this.K(bVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener bop = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hqr.hxI != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.hqr.hxI.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener hou = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.hmS == null) {
                        AlaMasterLiveRoomOpearator.this.hmS = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    AlaMasterLiveRoomOpearator.this.hmS.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener hoA = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hny != null) {
                AlaMasterLiveRoomOpearator.this.hny.HS();
            }
        }
    };
    private CustomMessageListener hDV = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hor = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.69
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.GU(str);
            }
        }
    };
    private CustomMessageListener gKz = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.70
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.bul();
        }
    };
    private CustomMessageListener hmz = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.hnh.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hoy = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity(), a.h.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener hDW = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hDM != null) {
                x DW = AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW();
                long j = DW.mLiveInfo.live_id;
                long j2 = DW.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.hDM.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener hDX = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.cbJ().hxk);
            if (AlaMasterLiveRoomOpearator.this.hCD == null || AlaMasterLiveRoomOpearator.this.hCD.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.vF(0);
            }
            if (AlaMasterLiveRoomOpearator.this.hne != null) {
                AlaMasterLiveRoomOpearator.this.hne.IF().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.hne.IG().hide();
            }
        }
    };
    private CustomMessageListener hoz = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.H(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW());
        }
    };
    private CustomMessageListener hoE = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hns != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) AlaMasterLiveRoomOpearator.this.hns).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hDY = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hDN != null) {
                    AlaMasterLiveRoomOpearator.this.hDN.gT(str);
                }
            }
        }
    };
    private CustomMessageListener bAU = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.hDI != null) {
                        if (!data.aAF || AlaMasterLiveRoomOpearator.this.bAR == null || !AlaMasterLiveRoomOpearator.this.hDO) {
                            if (AlaMasterLiveRoomOpearator.this.bAR != null && AlaMasterLiveRoomOpearator.this.bAR == data.aAE) {
                                if (data.aAy != null && data.aAy.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.hDO || AlaMasterLiveRoomOpearator.this.hCD.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.hDI.c(AlaMasterLiveRoomOpearator.this.cbJ().hxA.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.bAT = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.cbJ().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.bAR = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.cbJ().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.hDI.a(AlaMasterLiveRoomOpearator.this.cbJ().hxA.getVideoConfig(), AlaMasterLiveRoomOpearator.this.bAT);
                        if (!AlaMasterLiveRoomOpearator.this.bAT) {
                            AlaMasterLiveRoomOpearator.this.bAT = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.bAS) {
                    AlaMasterLiveRoomOpearator.this.cbJ().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.bAS = false;
            }
        }
    };
    private CustomMessageListener bAV = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.cbJ().hxA != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.cbJ().hxA.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.d.xf().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener blj = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.bng == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bng == 6) {
                            AlaMasterLiveRoomOpearator.this.cgl();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bng = 0;
            }
        }
    };
    private View.OnClickListener hDZ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.hDd) {
                    AlaMasterLiveRoomOpearator.this.cgq();
                    AlaMasterLiveRoomOpearator.this.hDo.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.hDc) {
                    if (view == AlaMasterLiveRoomOpearator.this.hDe) {
                        AlaMasterLiveRoomOpearator.this.bul();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.hDf) {
                        if (view != AlaMasterLiveRoomOpearator.this.hDh) {
                            if (view == AlaMasterLiveRoomOpearator.this.hqy) {
                                if (AlaMasterLiveRoomOpearator.this.cgk()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.hDJ != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.hnA != null) && AlaMasterLiveRoomOpearator.this.hnA.zG()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.hnA.NG() & (AlaMasterLiveRoomOpearator.this.hnA != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hDJ.cbL()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hDJ.cbM()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.hDJ.cbN();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hDg) {
                                if (AlaMasterLiveRoomOpearator.this.hCH != null) {
                                    as civ = AlaMasterLiveRoomOpearator.this.cbJ().hxj.civ();
                                    if (civ == null || civ.mLiveSdkInfo == null) {
                                        str = null;
                                        str2 = null;
                                    } else {
                                        str2 = String.valueOf(civ.mLiveSdkInfo.mRoomId);
                                        str = civ.mLiveSdkInfo.mCastIds != null ? civ.mLiveSdkInfo.mCastIds.chatMCastId : null;
                                    }
                                    AlaMasterLiveRoomOpearator.this.hCH.aw("", str2, str);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hDi) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.hDJ.cbL() || AlaMasterLiveRoomOpearator.this.hDJ.cbM() || AlaMasterLiveRoomOpearator.this.hnA.NG() || AlaMasterLiveRoomOpearator.this.hnA.zG()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.hDK != null) {
                                    AlaMasterLiveRoomOpearator.this.hDK.TP();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.hDp != null) {
                            AlaMasterLiveRoomOpearator.this.hDp.Pd();
                            AlaMasterLiveRoomOpearator.this.hDp.cM(AlaMasterLiveRoomOpearator.this.cgy());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "beauty"));
                        AlaMasterLiveRoomOpearator.this.hDO = false;
                        AlaMasterLiveRoomOpearator.this.op(true);
                        AlaMasterLiveRoomOpearator.this.hDj.setVisibility(4);
                        com.baidu.live.d.xf().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.af.a.OJ().bru.aKs == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.OJ().bru.aKr == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bnc) {
                        AlaMasterLiveRoomOpearator.this.cgl();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bng = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.cgl();
                }
            }
        }
    };
    private CustomMessageListener hos = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof at) {
                    AlaMasterLiveRoomOpearator.this.hnU = true;
                    AlaMasterLiveRoomOpearator.this.hDk = (at) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.hne != null) {
                        AlaMasterLiveRoomOpearator.this.hne.IF().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.hne != null) {
                        AlaMasterLiveRoomOpearator.this.hne.IG().show();
                        String nameShow = aVar.getNameShow();
                        if (aVar.extInfoJson != null) {
                            if (aVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                                str = aVar.extInfoJson.optString("mysterious_man_nickname");
                                if (TextUtils.isEmpty(str)) {
                                    str = "神秘人";
                                }
                                AlaMasterLiveRoomOpearator.this.hne.IG().setEditText(" @" + str + " ");
                            }
                        }
                        str = nameShow;
                        AlaMasterLiveRoomOpearator.this.hne.IG().setEditText(" @" + str + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.vF(8);
                }
            }
        }
    };
    private CustomMessageListener hEa = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.cbJ() != null && AlaMasterLiveRoomOpearator.this.cbJ().hxG != null) {
                AlaMasterLiveRoomOpearator.this.cbJ().hxG.sampleMemAndCPU();
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
                    AlaMasterLiveRoomOpearator.this.chh();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.cbJ().hxj.vM(i);
            }
        }
    };
    private CustomMessageListener hkv = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.cha();
        }
    };
    private CustomMessageListener hbb = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.ap.c)) {
                if (AlaMasterLiveRoomOpearator.this.hba == null) {
                    AlaMasterLiveRoomOpearator.this.hba = new com.baidu.live.ap.a(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.hba.a((com.baidu.live.ap.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener hEb = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.MU()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.hDo != null) {
                            AlaMasterLiveRoomOpearator.this.hDo.ov(!alaSetPrivateResponseMessage.isSwitchOpen());
                            AlaMasterLiveRoomOpearator.this.hDo.chI();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.cbJ().hxA.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.hDK != null) {
                        AlaMasterLiveRoomOpearator.this.hDK.setMute(AlaMasterLiveRoomOpearator.this.cbJ().hxA.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hCP != null) {
                        AlaMasterLiveRoomOpearator.this.hCP.setMute(AlaMasterLiveRoomOpearator.this.cbJ().hxA.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hCJ != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.hCJ.a(AlaMasterLiveRoomOpearator.this.cbJ().hxD, AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, 5000);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getString(a.h.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.hCJ.vV(2);
                        AlaMasterLiveRoomOpearator.this.hCJ.c(AlaMasterLiveRoomOpearator.this.cbJ().hxD, string, 3);
                    }
                }
            }
        }
    };
    private e.a hEc = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cho() {
            AlaMasterLiveRoomOpearator.this.vE(a.h.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void chp() {
            AlaMasterLiveRoomOpearator.this.vE(a.h.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a hEd = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.liveroom.a.a
        public boolean dz(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void dA(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.cbJ().bQu() == 1) {
                AlaMasterLiveRoomOpearator.this.cbJ().hxA.stopRecord();
            }
        }
    };
    private IShareCallback hEe = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.hDu && AlaMasterLiveRoomOpearator.this.hDt != null) {
                AlaMasterLiveRoomOpearator.this.hDu = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.hDt);
            }
        }
    };
    private View.OnTouchListener hEf = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.cbJ().hxG.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.cbJ().hxk);
            AlaMasterLiveRoomOpearator.this.vF(0);
            if (AlaMasterLiveRoomOpearator.this.hne != null) {
                AlaMasterLiveRoomOpearator.this.hne.IF().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.hne.IG().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b hEg = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void chq() {
            AlaMasterLiveRoomOpearator.this.cgm();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void chr() {
            AlaMasterLiveRoomOpearator.this.hCk = AlaMasterLiveRoomOpearator.this.hCD.cdx();
            AlaMasterLiveRoomOpearator.this.cbJ().hxG.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.cbJ().hxG.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.cbJ().hxG.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.hxu = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.cbJ().bQu();
            dVar.title = AlaMasterLiveRoomOpearator.this.hCD.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hxv = AlaMasterLiveRoomOpearator.this.hCD.cdy();
            dVar.hxy = AlaMasterLiveRoomOpearator.this.hCk;
            dVar.hxx = AlaMasterLiveRoomOpearator.this.hCD.cdv();
            dVar.hxw = AlaMasterLiveRoomOpearator.this.hCD.cdA();
            dVar.hxz = AlaMasterLiveRoomOpearator.this.hCD.cdw();
            if (dVar.hxz) {
                if (AlaMasterLiveRoomOpearator.this.hCD.cdB()) {
                    AlaMasterLiveRoomOpearator.this.hDu = true;
                    AlaMasterLiveRoomOpearator.this.hDt = dVar;
                    AlaMasterLiveRoomOpearator.this.hCD.cdC();
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
            AlaMasterLiveRoomOpearator.this.cbJ().pageContext.showToast(a.h.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.cbJ().g((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void chs() {
            AlaMasterLiveRoomOpearator.this.hDO = true;
            AlaMasterLiveRoomOpearator.this.op(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean cht() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void chu() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private CustomMessageListener biG = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bZy();
            }
        }
    };
    private com.baidu.live.liveroom.g.c hEh = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void LF() {
            if (AlaMasterLiveRoomOpearator.this.hCH != null) {
                AlaMasterLiveRoomOpearator.this.hCH.oI(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cz(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.hDp != null) {
                        AlaMasterLiveRoomOpearator.this.hDp.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hDp != null) {
                    AlaMasterLiveRoomOpearator.this.hDp.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.hCH != null) {
                    AlaMasterLiveRoomOpearator.this.hCH.oI(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.hns != null) {
                    AlaMasterLiveRoomOpearator.this.hns.by(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a hEi = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void chA() {
            if (AlaMasterLiveRoomOpearator.this.hDb != null && AlaMasterLiveRoomOpearator.this.cbJ().hxD.indexOfChild(AlaMasterLiveRoomOpearator.this.hDb) >= 0) {
                AlaMasterLiveRoomOpearator.this.cbJ().hxD.removeView(AlaMasterLiveRoomOpearator.this.hDb);
                AlaMasterLiveRoomOpearator.this.hDb.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.hDb = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hmE = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void v(View view, int i) {
            x DW;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.chg();
            } else if (i == 14 && (DW = AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW()) != null && DW.aFH != null && DW.mLiveInfo != null && DW.aGd != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity(), DW.aFH.userName, Long.toString(DW.aFH.userId), Long.toString(DW.aFH.charmCount), String.valueOf(DW.mLiveInfo.group_id), String.valueOf(DW.mLiveInfo.live_id), true, String.valueOf(DW.aFH.userId), Long.toString(DW.aGd.userId), DW.aGd.userName, DW.aGd.portrait, AlaMasterLiveRoomOpearator.this.hlV.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(DW.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.hlV.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a hEj = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };
    private g hEk = new g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
    };
    private Runnable hEl = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        @Override // java.lang.Runnable
        public void run() {
            AlaMasterLiveRoomOpearator.this.chn();
        }
    };
    private HttpMessageListener gUM = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == AlaMasterLiveRoomOpearator.this.gLW && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bfP != null) {
                AlaMasterLiveRoomOpearator.this.bfP = guardClubInfoHttpResponseMessage.bfP;
            }
        }
    };
    HttpMessageListener gVe = new HttpMessageListener(1021231) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.63
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bfP;
                if (aVar == null || AlaMasterLiveRoomOpearator.this.bfP == null || AlaMasterLiveRoomOpearator.this.bfP.id != aVar.id) {
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
            AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity());
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity());
            if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = true;
                TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                Window window = AlaMasterLiveRoomOpearator.this.gVO.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.x = 0;
                attributes.y = 50;
                window.setAttributes(attributes);
            } else if (screenFullSize[1] - rect.height() <= statusBarHeight && AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = false;
                Window window2 = AlaMasterLiveRoomOpearator.this.gVO.getWindow();
                WindowManager.LayoutParams attributes2 = window2.getAttributes();
                attributes2.gravity = 17;
                attributes2.x = 0;
                attributes2.y = 0;
                window2.setAttributes(attributes2);
            }
        }
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.b.awd);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        hCA = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    private void Hn(String str) {
        if (!TextUtils.isEmpty(str) && this.hDm != null) {
            View JA = this.hDm.JA();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            JA.setLayoutParams(layoutParams);
            if (cbJ().hxk.indexOfChild(JA) >= 0) {
                cbJ().hxk.removeView(JA);
            }
            cbJ().hxk.addView(JA);
            this.hDm.gH(str);
            JA.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && com.baidu.live.af.a.OJ().bru != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(cbJ().pageContext.getPageActivity(), String.valueOf(xVar.mLiveInfo.live_id), String.valueOf(xVar.mLiveInfo.user_id), com.baidu.live.af.a.OJ().bru.aKn, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(cbJ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(cbJ().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.af.a.OJ().bru.aJI;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? cbJ().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt) : cbJ().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(cbJ().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZy() {
        int i = cbJ().hxj.DW().aFH.isUegBlock;
        int i2 = cbJ().hxj.DW().aFH.isBlock;
        String str = cbJ().hxj.DW().aFH.userName;
        if (i > 0 || i2 > 0) {
            this.bnc = true;
            this.hne.a(true, i, i2, str);
            return;
        }
        this.bnc = false;
        this.hne.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.hqr.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.blY == 1) {
                format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.blZ);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.hqr.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.hqr.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cgk() {
        if (this.hDK != null && this.hDK.TQ()) {
            BdUtilHelper.showToast(this.hqr.pageContext.getPageActivity(), this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else if (this.hCP != null && this.hCP.PC()) {
            BdUtilHelper.showToast(this.hqr.pageContext.getPageActivity(), this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgl() {
        if (this.hne != null) {
            this.hne.IG().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.hDJ != null) {
            this.hDJ.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgm() {
        if (cbJ() != null && cbJ().hxj != null) {
            cbJ().hxj.cio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bSI() != null && aVar.bSJ() != null) {
            cbJ().hxj.ez(aVar.bSI().getId(), aVar.bSJ().getId());
        }
    }

    public void b(short s) {
        if (this.hDI != null) {
            this.hDI.b(s);
        }
    }

    /* loaded from: classes10.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.hDw = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.hDw = false;
                }
                if (AlaMasterLiveRoomOpearator.this.hDx == 0) {
                    AlaMasterLiveRoomOpearator.this.hDx = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.hDy == 0) {
                    AlaMasterLiveRoomOpearator.this.hDy = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.hDz = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (cbJ() != null && cbJ().hxE != null) {
            cbJ().hxE.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.e eVar, String str) {
        this.hqr = eVar;
        this.hkk = str;
    }

    protected com.baidu.tieba.ala.liveroom.data.e cbJ() {
        return this.hqr;
    }

    public int a(f fVar) {
        this.hqz = fVar;
        this.hDv = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.hDv, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.hCJ == null) {
            this.hCJ = new com.baidu.tieba.ala.liveroom.tippop.a(this.hqr.pageContext, null);
        }
        registerListener();
        this.hlp = new com.baidu.live.j.a();
        cgH();
        cgn();
        cgp();
        Long[] lArr = new Long[1];
        this.hDA = lArr[0] == null ? 0L : lArr[0].longValue();
        this.hDB = lArr[0] != null ? lArr[0].longValue() : 0L;
        cbJ().hxk.setOnTouchListener(this.hEf);
        this.hCB = SharedPrefHelper.getInstance().getBoolean(hCA, false);
        this.hCQ = new AlaLiveCountDownView(cbJ().pageContext.getPageActivity());
        this.hCQ.setCount(3);
        this.hCQ.setTextColor(cbJ().pageContext.getPageActivity().getResources().getColor(a.c.sdk_white_alpha60));
        this.hCQ.setTextSize(cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128));
        this.hCQ.setTypeface(Typeface.DEFAULT_BOLD);
        this.hCQ.setIncludeFontPadding(false);
        this.hCQ.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void chv() {
                if (AlaMasterLiveRoomOpearator.this.cbJ().hxk != null) {
                    AlaMasterLiveRoomOpearator.this.cbJ().hxk.removeView(AlaMasterLiveRoomOpearator.this.hCQ);
                }
            }
        });
        return 1;
    }

    private void cgn() {
        CustomResponsedMessage runTask;
        if (this.hCO == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.n.a.class, cbJ().pageContext)) != null && runTask.getData() != null) {
            this.hCO = (com.baidu.live.n.a) runTask.getData();
            this.hCO.c(cbJ().pageContext);
        }
    }

    private void cgo() {
        CustomResponsedMessage runTask;
        if (cgv() && this.hCP == null && (runTask = MessageManager.getInstance().runTask(2913254, com.baidu.live.ao.b.class, cbJ().pageContext)) != null && runTask.getData() != null) {
            this.hCP = (com.baidu.live.ao.b) runTask.getData();
            if (cbJ() != null && cbJ().hxj != null && cbJ().hxj.DW() != null) {
                this.hCP.setLiveShowData(cbJ().hxj.DW());
            }
            if (cbJ() != null && cbJ().hxA != null) {
                this.hCP.H(cbJ().hxA);
                this.hCP.setMute(cbJ().hxA.isMute());
            }
            if (this.hCP != null && this.hCY != null) {
                this.hCP.a(new com.baidu.live.ao.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                    @Override // com.baidu.live.ao.a
                    public boolean PE() {
                        if ((AlaMasterLiveRoomOpearator.this.hnA != null) && AlaMasterLiveRoomOpearator.this.hnA.zG()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                            return false;
                        }
                        if ((AlaMasterLiveRoomOpearator.this.hnA != null) & AlaMasterLiveRoomOpearator.this.hnA.NG()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                            return false;
                        } else if (AlaMasterLiveRoomOpearator.this.hDJ == null || !AlaMasterLiveRoomOpearator.this.hDJ.cbL()) {
                            if (AlaMasterLiveRoomOpearator.this.hDJ == null || !AlaMasterLiveRoomOpearator.this.hDJ.cbM()) {
                                return true;
                            }
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        } else {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        }
                    }
                });
                View enterView = this.hCP.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hCY.setVisibility(0);
                    this.hCY.addView(enterView);
                }
            }
            if (this.hCP != null) {
                this.hCP.Y(cbJ().hxB);
            }
            if (this.hCP != null && cbJ().hxC != null) {
                this.hCP.a(cbJ().hxC);
            }
        }
    }

    private void cgp() {
        View rootLayout;
        if (this.hCO != null && this.hCX != null && (rootLayout = this.hCO.cs(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hCX.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgq() {
        if (this.hDo == null) {
            this.hDo = new com.baidu.tieba.ala.liveroom.master.panel.b(cbJ().pageContext.getPageActivity(), cbJ().bQu() == 2);
            this.hDo.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void or(boolean z) {
                    AlaMasterLiveRoomOpearator.this.cbJ().hxA.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void os(boolean z) {
                    AlaMasterLiveRoomOpearator.this.cbJ().hxA.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ot(boolean z) {
                    AlaMasterLiveRoomOpearator.this.cbJ().hxA.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.chf();
                    if (AlaMasterLiveRoomOpearator.this.hCJ != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.hCJ.c(AlaMasterLiveRoomOpearator.this.cbJ().hxD, AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getString(a.h.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.hCJ.c(AlaMasterLiveRoomOpearator.this.cbJ().hxD, AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getString(a.h.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ou(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.g(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void chw() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.cbJ().hxj != null && AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW() != null && AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hDo != null) {
                        AlaMasterLiveRoomOpearator.this.hDo.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.a(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void chx() {
                    if (AlaMasterLiveRoomOpearator.this.hDo != null) {
                        AlaMasterLiveRoomOpearator.this.hDo.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new i(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void chy() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.cbJ() != null && AlaMasterLiveRoomOpearator.this.cbJ().hxj != null && AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW() != null && AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(AlaMasterLiveRoomOpearator.this.cbJ().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.hDo != null) {
                            AlaMasterLiveRoomOpearator.this.hDo.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void chz() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.cbJ() == null || AlaMasterLiveRoomOpearator.this.cbJ().hxj == null || AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW() == null || AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.cbJ() != null && AlaMasterLiveRoomOpearator.this.cbJ().hxj != null && AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW() != null && AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.hDo != null) {
                                        AlaMasterLiveRoomOpearator.this.hDo.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.hqr.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.hDo != null) {
                        AlaMasterLiveRoomOpearator.this.hDo.dismiss();
                    }
                }
            });
        }
        cgr();
    }

    private void cgr() {
        if (this.hDo != null) {
            boolean isBackCamera = cbJ().hxA.isBackCamera();
            this.hDo.setIsBackCamera(cbJ().hxA.isBackCamera());
            this.hDo.S(cbJ().hxA.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = cbJ().hxA.isPushMirror();
            if (this.hDF) {
                isPushMirror = che() || isPushMirror;
                this.hDF = false;
            }
            this.hDo.T(isPushMirror, isBackCamera ? false : true);
            this.hDo.ov(cbJ().hxA.isMute());
            this.hDo.chI();
        }
    }

    public void cgs() {
        if (this.hqz != null) {
            if (this.hqz.hxJ == null || this.hqz.hxJ.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.hCZ == null) {
                        this.hCZ = this.hqr.hxI.Lf();
                        this.hqr.hxD.addView(this.hCZ, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.hCD == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (cbJ().hxj != null && cbJ().hxj.DW() != null && cbJ().hxj.DW().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", cbJ().hxj.DW().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", cbJ().hxj.DW().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.hCD = new d(cbJ().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    cbJ().hxG.prepareTime = System.currentTimeMillis();
                    cbJ().hxD.addView(this.hCD.getView(), layoutParams);
                    this.hCD.a(this.hEe);
                }
                this.hCD.nX(this.hxx);
                this.hCD.a(this.hEg);
                this.hCD.a(this.hEc);
                this.hCD.a(cbJ().hxA, cbJ().bQu());
                this.hCD.a(this.hCO);
                return;
            }
            this.hCk = this.hqz.hxJ.mLiveInfo.screen_direction == 2;
            if (this.hqz.hxJ.mLiveInfo.isAudioOnPrivate == 1) {
                cbJ().hxA.setMute(true);
                if (this.hDK != null) {
                    this.hDK.setMute(cbJ().hxA.isMute());
                }
                if (this.hCP != null) {
                    this.hCP.setMute(cbJ().hxA.isMute());
                }
                if (this.hCJ == null) {
                    this.hCJ = new com.baidu.tieba.ala.liveroom.tippop.a(this.hqr.pageContext, null);
                }
                if (!this.hCJ.vU(2)) {
                    this.hCJ.a(cbJ().hxD, cbJ().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, 5000);
                }
            }
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.hxu = true;
            dVar.forumId = String.valueOf(this.hqz.hxJ.mLiveInfo.forum_id);
            dVar.forumName = this.hqz.hxJ.mLiveInfo.forum_name;
            dVar.liveType = this.hqz.hxJ.mLiveInfo.live_type;
            dVar.title = this.hqz.hxJ.mLiveInfo.getLiveTitle();
            dVar.clarity = this.hqz.hxJ.mLiveInfo.clarity;
            dVar.gameId = this.hqz.hxJ.mLiveInfo.game_id;
            dVar.gameName = this.hqz.hxJ.mLiveInfo.game_label;
            dVar.hxy = this.hqz.hxJ.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void cgt() {
        if (this.hDI != null) {
            this.hDI.a(cbJ().hxA.getVideoConfig(), false);
        }
        if (this.hCD != null) {
            this.hCD.nW(true);
        }
        if (cbJ().hxA.hasBeauty() >= 0) {
            cbJ().hxA.setBeauty(com.baidu.live.d.xf().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            cbJ().hxI.E(this.hqr.hxA);
        } else if (this.hCD != null) {
            this.hCD.nW(true);
        }
        cgG();
    }

    public void d(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.hCZ != null && this.hCZ.getParent() != null) {
                ((ViewGroup) this.hCZ.getParent()).removeView(this.hCZ);
                this.hCZ = null;
            }
            cbJ().hxk.setVisibility(0);
            this.hqr.hxI.a(cbJ().hxk);
        } else {
            cgO();
            chd();
            if (this.hDS != null) {
                this.hDS.setVisibility(0);
            }
            this.hCH = new com.baidu.tieba.ala.liveroom.w.a(cbJ().pageContext, this.hEd);
            this.hCH.c(cbJ().hxk, true);
            this.hCH.oI(true);
            if (this.hne != null && this.hne.IF() != null) {
                this.hne.IF().setNeedTopAlphaShade(true);
            }
        }
        cbJ().hxA.setPushMirror(che());
    }

    public void b(as asVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hqr.hxI.l(cbJ().hxj.DW());
        }
        if (!cbJ().hxA.isBackground() && cbJ().hxj.DW() != null && cbJ().hxj.DW().mLiveInfo != null) {
            int startPush = cbJ().hxA.startPush(cbJ().hxj.DW().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.hqr.hxI.Lg();
            }
            if (startPush != 0 && cbJ().hxG != null) {
                cbJ().hxG.errCode = 4;
                cbJ().hxG.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (asVar != null && !asVar.Bh() && !chb()) {
                oq(true);
                chc();
            }
            if (this.hlS != null) {
                this.hlS.M(cbJ().hxj.DW());
            }
            if (this.hmP != null) {
                this.hmP.a(cbJ().hxj.DW());
            }
            if (this.hCO != null) {
                this.hCO.f(cbJ().hxj.DW());
                this.hCO.gK(this.otherParams);
            }
            if (this.hlS != null) {
                this.hlS.ok(true);
            }
            if (this.hCE != null) {
                this.hCE.M(cbJ().hxj.DW());
            }
            if (asVar == null || asVar.aFH == null) {
                z = com.baidu.live.d.xf().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = asVar.aFH.canUseChallenge;
                com.baidu.live.d.xf().putBoolean("ala_master_can_use_challenge", z);
            }
            cax();
            cgP();
            cgz();
            oo(z);
            bZi();
            cgQ();
            cgW();
            N(cbJ().hxj.DW());
            g(cbJ().hxj.DW());
            cgX();
            cgY();
            cgu();
            cgT();
            cas();
            bZh();
            cau();
            bZg();
            cgU();
            cad();
            can();
            cao();
            cgM();
            cgN();
            O(cbJ().hxj.DW());
            cgV();
            car();
            cae();
            MessageManager.getInstance().registerListener(this.gUM);
            MessageManager.getInstance().registerListener(this.gVe);
            as civ = cbJ().hxj.civ();
            if (civ != null && civ.aLo == 1) {
                bUO();
                this.hDP.postDelayed(this.hEl, IMConnection.RETRY_DELAY_TIMES);
            }
            if (this.hnd != null) {
                this.hnd.h(cbJ().hxj.DW());
            }
            if (this.hne != null) {
                if (cbJ().hxj.DW() != null && cbJ().hxj.DW().aGv != null && cbJ().hxj.DW().aGv.Av()) {
                    z2 = true;
                }
                this.hne.a(String.valueOf(cbJ().hxj.DW().mLiveInfo.group_id), String.valueOf(cbJ().hxj.DW().mLiveInfo.last_msg_id), String.valueOf(cbJ().hxj.DW().aFH.userId), String.valueOf(cbJ().hxj.DW().mLiveInfo.live_id), cbJ().hxj.DW().aFH.appId, z2, cbJ().hxj.DW().getGuardName());
            }
            if (this.hnf != null) {
                this.hnf.a(cbJ().hxj.DW(), true);
            }
            cgw();
            cgo();
            caB();
            this.mHandler.post(this.hDU);
        }
    }

    protected void caB() {
        if (this.hnM == null && cbJ() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.t.a.class, cbJ().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hnM = (com.baidu.live.t.a) runTask.getData();
                this.hnM.p(cbJ().hxk);
            }
        }
    }

    private void cgu() {
        if (this.hCF != null && cbJ() != null && cbJ().hxj != null) {
            if (this.hCF.aG(this.hCU)) {
                this.hCF.C(cbJ().hxj.DW());
            } else {
                this.hCF.d(this.hCU, cbJ().hxj.DW());
            }
        }
    }

    private void bZi() {
        if (this.buY == null) {
            this.buY = new PendantParentView(cbJ().pageContext.getPageActivity(), cbg());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            cbJ().hxk.addView(this.buY, layoutParams);
            this.buY.setDefaultItemMargin(cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.buY.setPadding(cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            cbf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbf() {
        if (this.buY != null) {
            int dimensionPixelSize = cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278);
            int dimensionPixelSize2 = cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.buY.getLayoutParams();
            if (this.gNL) {
                this.buY.setPosition(0, 0, this.hDJ.cbq(), dimensionPixelSize2);
            } else {
                this.buY.setPosition(dimensionPixelSize, 0, cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds380), dimensionPixelSize2);
            }
            this.buY.setLayoutParams(layoutParams);
            this.buY.setModel(cbg());
        }
    }

    private PendantParentView.Model cbg() {
        if (this.gNL) {
            return PendantParentView.Model.VERTICAL_PK;
        }
        if (this.hDQ) {
            return PendantParentView.Model.VERTICAL_BB_CHATING;
        }
        return PendantParentView.Model.VERTICAL;
    }

    private void cbh() {
        if (this.hne != null && this.hne.IF() != null && this.hne.IF().getView() != null) {
            if (this.gNL && !this.hCC && cbJ().hxk != null && cbJ().hxk.getHeight() > 0) {
                int bn = this.hDJ != null ? this.hDJ.bn(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.hne.IF().getView().getLayoutParams();
                int height = cbJ().hxk.getHeight() - bn;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.hne.IF().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.al.c.i(false, this.hCC);
            if (cbJ().hxk.indexOfChild(this.hne.IF().getView()) != -1 && this.hne.IF().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hne.IF().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.hne.IF().getView().setLayoutParams(layoutParams2);
            }
            this.hne.IF().IE();
        }
    }

    private void cbi() {
        if (this.hng != null) {
            if (this.gNL && !this.hCC && cbJ().hxk != null && cbJ().hxk.getHeight() > 0) {
                this.hng.cC((cbJ().hxk.getHeight() - (this.hDJ != null ? h.o(cbJ().pageContext.getPageActivity(), true) : 0)) + cbJ().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height));
            } else {
                this.hng.cC(com.baidu.live.al.a.b(cbJ().pageContext.getPageActivity(), true, false, this.hCC));
            }
        }
    }

    private void cbj() {
        int i;
        if (this.hng != null) {
            int h = com.baidu.live.al.a.h(true, false);
            if (!this.gNL || cbJ().hxk == null || cbJ().hxk.getHeight() <= 0) {
                i = h;
            } else {
                i = (cbJ().hxk.getHeight() - (this.hDJ != null ? this.hDJ.bn(false) : 0)) + cbJ().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
            }
            this.hng.cD(i);
        }
    }

    private void cbk() {
        if (this.hnf != null && this.hnf.zf() != null) {
            ViewGroup.LayoutParams layoutParams = this.hnf.zf().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = cbJ().pageContext.getResources().getDimensionPixelOffset(this.gNL ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hnf.zf().setLayoutParams(layoutParams);
            }
        }
    }

    private boolean cgv() {
        AlaVideoBCChatData alaVideoBCChatData;
        AlaLiveInfoData alaLiveInfoData = cbJ().hxj.DW().mLiveInfo;
        if (alaLiveInfoData == null || (alaVideoBCChatData = alaLiveInfoData.videoBCEnterData) == null) {
            return false;
        }
        return alaVideoBCChatData.isShowEnter();
    }

    private void cgw() {
        if (this.hCP == null && !cgv()) {
            boolean z = (cbJ().hxj == null || cbJ().hxj.civ() == null || cbJ().hxj.civ().mLiveInfo.videoBBChatData == null || !cbJ().hxj.civ().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
            if (!z && cbJ().hxj != null && cbJ().hxj.DW() != null && cbJ().hxj.DW().mLiveInfo != null && cbJ().hxj.DW().mLiveInfo.videoBBChatData != null && cbJ().hxj.DW().aGr) {
                z = cbJ().hxj.DW().mLiveInfo.videoBBChatData.videoBBChatSwitch;
            }
            if (this.hDi != null) {
                this.hDi.setVisibility(z ? 0 : 8);
            }
            cgx();
        }
    }

    private void cgx() {
        CustomResponsedMessage runTask;
        if (this.hDK == null && (runTask = MessageManager.getInstance().runTask(2913249, com.baidu.live.an.a.class, cbJ().pageContext)) != null && runTask.getData() != null) {
            this.hDK = (com.baidu.live.an.a) runTask.getData();
        }
        if (this.hDK != null) {
            this.hDK.y((ViewGroup) cbJ().rootView.findViewById(a.f.ala_live_video_chat_pendant));
            this.hDK.x(cbJ().hxD);
            this.hDK.t(cbJ().hxj.DW());
            this.hDK.H(cbJ().hxA);
            this.hDK.a(cbJ().hxC);
            this.hDK.a(this.bKt);
            if (cbJ().hxA != null) {
                this.hDK.setMute(cbJ().hxA.isMute());
            }
        }
    }

    private void oo(boolean z) {
        if (this.hDJ == null) {
            this.hDJ = new com.baidu.tieba.ala.liveroom.challenge.e(cbJ());
        }
        this.hDJ.a(this.hqy, this.hqz, z);
        this.hDJ.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(bc bcVar, bg bgVar, bg bgVar2) {
                AlaMasterLiveRoomOpearator.this.gNL = true;
                AlaMasterLiveRoomOpearator.this.cbJ().hxk.hMO = false;
                if (AlaMasterLiveRoomOpearator.this.hDp != null) {
                    AlaMasterLiveRoomOpearator.this.hDp.dU(4);
                    AlaMasterLiveRoomOpearator.this.hDp.cM(true);
                }
                AlaMasterLiveRoomOpearator.this.Vv();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void zM() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hDU);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void cbH() {
                AlaMasterLiveRoomOpearator.this.gNL = false;
                AlaMasterLiveRoomOpearator.this.cbJ().hxk.hMO = false;
                if (AlaMasterLiveRoomOpearator.this.hDp != null) {
                    AlaMasterLiveRoomOpearator.this.hDp.dU(0);
                    AlaMasterLiveRoomOpearator.this.hDp.cM(false);
                }
                AlaMasterLiveRoomOpearator.this.cbp();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void cbI() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hDU);
            }
        });
        this.hDJ.P(this.hCk, z);
        this.hDJ.k(this.hCk, z, (this.hqz == null || this.hqz.hxJ == null || this.hqz.hxJ.mChallengeData == null) ? false : true);
    }

    public boolean cgy() {
        return this.hDJ != null && this.hDJ.cbQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vv() {
        if (this.hCI != null) {
            this.hCI.setVisible(8);
            this.hCI.setCanVisible(false);
        }
        if (this.hlX != null) {
            this.hlX.aW(true);
        }
        if (this.hCR != null) {
            this.hCR.setCanVisible(false);
            this.hCR.setVisibility(4);
        }
        if (this.hCH != null) {
            this.hDa = this.hCH.ckN();
            this.hCH.oH(false);
        }
        if (this.hnA != null) {
            this.hnA.setCanVisible(false);
        }
        if (this.hme != null) {
            this.hme.setCanVisible(false);
        }
        if (this.hnB != null) {
            this.hnB.aW(true);
            this.hnB.aX(true);
        }
        cbf();
        cbh();
        cbi();
        cbj();
        cbk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbp() {
        if (this.hCI != null) {
            this.hCI.setCanVisible(true);
        }
        if (this.hlX != null) {
            this.hlX.aW(false);
        }
        if (this.hCR != null) {
            this.hCR.setCanVisible(true);
            if (this.hCR.ckk()) {
                this.hCR.setVisibility(0);
            }
        }
        if (this.hCH != null) {
            this.hCH.oH(this.hDa);
        }
        if (this.hnA != null) {
            this.hnA.setCanVisible(true);
        }
        if (this.hme != null) {
            this.hme.cK(true);
        }
        if (this.hnB != null) {
            this.hnB.aW(false);
            this.hnB.aX(false);
        }
        cbf();
        cbh();
        cbi();
        cbj();
        cbk();
    }

    private void cgz() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.leftMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        if (this.hCR == null) {
            this.hCR = new AlaLiveStreamStatusView(cbJ().pageContext.getPageActivity());
            this.hCR.setVisibility(4);
        }
        this.hCR.setId(a.f.ala_live_room_stream_view);
        this.hCR.setLayoutParams(layoutParams);
        if (this.hCR.getParent() == null && this.hCU != null) {
            this.hCU.addView(this.hCR, layoutParams);
        }
    }

    public void cgA() {
        if (this.hCD != null && this.hCD.getVisibility() != 8 && cbJ().hxA.getPreview() != null) {
            cbJ().hxA.stopRecord();
        }
    }

    public void cgB() {
        if (cbJ().hxA.getPreview() != null) {
            cbJ().hxA.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hDI != null) {
                this.hDI.nV(false);
            }
            this.hDI = new com.baidu.tieba.ala.liveroom.h.b(cbJ().hxD, cbJ(), cbJ().hxA);
            this.hDI.a(cbJ().hxA.getVideoConfig(), false);
        }
        if (this.hCJ != null) {
            this.hCJ.cjG();
        }
        this.mHandler.post(this.hDU);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.hCC = z;
        if (z) {
            if (this.hDH) {
                this.hDH = false;
                if (this.hne != null && this.hne.IF() != null) {
                    this.hne.IF().getView().setBottom(0);
                }
                if (this.hne != null && this.hne.IG() != null) {
                    this.hne.IG().getView().setBottom(0);
                }
            }
            if (this.hng != null && this.hng.Dt() != null) {
                this.hng.Dt().setVisibility(8);
            }
            if (this.hne != null && this.hne.IF() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hne.IF().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132);
                this.hne.IF().getView().setLayoutParams(layoutParams);
            }
            if (this.hne != null && this.hne.IG() != null && this.hne.IG().getView() != null && this.hne.IG().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hne.IG().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.hne.IG().getView().setLayoutParams(layoutParams2);
                this.hne.IG().getView().setVisibility(0);
                this.hne.IG().KI();
            }
            vF(8);
            vD(8);
            if (this.hnh != null && this.hnh.DV() != null) {
                this.hnh.DV().setVisibility(8);
            }
            if (this.hnB != null) {
                this.hnB.setCanVisible(false);
            }
        } else {
            if (this.hng != null && this.hng.Dt() != null) {
                this.hng.Dt().setVisibility(0);
            }
            if (this.hne != null && this.hne.IF() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hne.IF().getView().getLayoutParams();
                layoutParams3.bottomMargin = cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132) - cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.hne.IF().getView().setLayoutParams(layoutParams3);
            }
            if (this.hne != null && this.hne.IG() != null) {
                this.hne.IG().hide();
            }
            vF(0);
            vD(0);
            if (this.hnh != null && this.hnh.DV() != null) {
                this.hnh.DV().setVisibility(0);
            }
            if (this.hDm != null && this.hDm.JA() != null) {
                this.hDm.JA().setVisibility(0);
            }
            if (this.hnB != null) {
                this.hnB.setCanVisible(true);
            }
        }
        if (this.hCD != null) {
            this.hCD.R(false, z);
        }
        if (this.hnf != null) {
            this.hnf.zg();
        }
        if (this.hDp != null) {
            this.hDp.onKeyboardVisibilityChanged(z);
        }
        if (this.hnM != null) {
            this.hnM.onKeyboardVisibilityChanged(z);
        }
        if (this.hDK != null) {
            this.hDK.onKeyboardVisibilityChanged(z);
        }
        cbh();
        this.mHandler.post(this.hDU);
    }

    private void vD(int i) {
        if (this.hlS != null) {
            this.hlS.vr(i);
        }
        if (this.hCT != null) {
            this.hCT.setVisibility(i);
        }
        if (this.hmP != null) {
            this.hmP.getView().setVisibility(i);
        }
        if (this.hCG != null) {
            this.hCG.setVisible(i);
        }
        if (this.hCF != null) {
            this.hCF.setVisibility(i);
        }
        if (this.hlX != null) {
            this.hlX.setVisible(i);
        }
        if (this.hnI != null) {
            this.hnI.setCanVisible(i == 0);
        }
        if (this.hnD != null) {
            this.hnD.setVisible(i);
        }
        if (this.hny != null) {
            this.hny.setCanVisible(i == 0);
        }
        if (this.hnA != null) {
            this.hnA.setCanVisible(i == 0 && !this.gNL);
        }
        if (this.hme != null) {
            this.hme.cK(i == 0);
        }
        if (this.hDL != null) {
            this.hDL.setCanVisible(i == 0);
            this.hDL.refreshUI();
        }
        if (this.hCU != null) {
            this.hCU.setVisibility(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            cbJ().hxG.errCode = 1;
            vE(a.h.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            vE(a.h.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            vE(a.h.stream_upload_exception);
        } else if (i == -2) {
            Ho(cbJ().pageContext.getResources().getString(a.h.preview_init_failed_dialog_msg));
            cbJ().hxA.stopRecord();
        } else if (i == -3 && this.hCD != null) {
            this.hCD.nW(false);
        }
        if (i == -4) {
            if (this.hCD == null || this.hCD.getView().getParent() == null) {
                cbJ().g((short) 1);
                return;
            }
            this.hCD.cdz();
            this.hDf.setVisibility(0);
            if (this.hCH != null) {
                this.hCH.oI(true);
            }
            cbJ().hxk.setBackgroundColor(cbJ().pageContext.getResources().getColor(17170445));
            chk();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        avQ();
        if (i == 12001) {
            if (i2 == -1) {
                Hp(P(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            bul();
        }
    }

    public void onResume() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.hCD == null || this.hCD.getView().getParent() == null || this.hCD.getVisibility() != 0 ? "live" : "action");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_ACTION, "").setContentExt(jSONObject));
        if (this.hCD != null) {
            this.hCD.onResume();
        }
        if (this.hDu && this.hDt != null) {
            this.hDu = false;
            c(this.hDt);
        }
        if (this.hns != null) {
            this.hns.onResume();
        }
    }

    public void h(short s) {
        if (this.hnd != null) {
            this.hnd.Ei();
        }
        if (this.hne != null) {
            this.hne.a(null);
            this.hne.zh();
        }
        if (this.hnf != null) {
            this.hnf.zh();
        }
        if (this.hDJ != null) {
            this.hDJ.cbP();
        }
    }

    public boolean cgC() {
        x DW = cbJ().hxj.DW();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hqr.hxI.k(DW);
            if (DW != null && DW.mLiveInfo.live_status != 1) {
                chi();
                cbJ().pageContext.getPageActivity().finish();
                if (cbJ().hxj == null || cbJ().hxj.DW() == null) {
                    return true;
                }
                a(DW, 1, cbJ().hxj.ciE() != 1 ? cbJ().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                return true;
            }
        } else {
            if (this.hne != null) {
                this.hne.IF().a(String.valueOf(DW.mLiveInfo.group_id), String.valueOf(DW.mLiveInfo.live_id), true, String.valueOf(DW.aFH.userId), DW.getGuardName());
            }
            if (this.hnf != null) {
                this.hnf.a(DW);
            }
            if (this.hmP != null) {
                this.hmP.a(cbJ().hxj.DW());
            }
            if (this.hlS != null) {
                this.hlS.M(DW);
            }
            if (DW != null) {
                if (this.hDJ != null) {
                    this.hDJ.a(DW);
                }
                if (this.hnh != null && DW.mLiveInfo != null) {
                    this.hnh.a(DW.mLiveInfo, DW.aFH);
                }
                if (this.hnI != null) {
                    this.hnZ = this.hnI.p(DW);
                }
                if (this.hlX != null) {
                    this.hlX.nx(this.hnZ);
                    this.hlX.j(DW);
                    this.hlX.updateView();
                }
                if (this.hny != null) {
                    this.hny.a(DW);
                }
                if (this.hnA != null) {
                    this.hnA.a(DW);
                }
                if (this.hnz != null) {
                    this.hnz.a(DW);
                }
                if (this.hCN != null) {
                    this.hCN.a(DW);
                }
                if (this.hnB != null) {
                    this.hnB.a(DW);
                }
                if (this.hnC != null) {
                    this.hnC.a(DW);
                }
                if (this.hnD != null) {
                    this.hnD.a(DW);
                }
                if (DW.mLiveInfo.live_status != 1) {
                    chi();
                    cbJ().pageContext.getPageActivity().finish();
                    if (cbJ().hxj == null || cbJ().hxj.DW() == null) {
                        return true;
                    }
                    a(DW, 1, cbJ().hxj.ciE() != 1 ? cbJ().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                    return true;
                } else if (this.hCO != null) {
                    this.hCO.i(DW);
                }
            }
        }
        return false;
    }

    public void cgD() {
        cgr();
    }

    public void cgE() {
        if (this.hDI != null) {
            this.hDI.cdt();
        }
        if (this.hDK != null) {
            this.hDK.TS();
        }
    }

    public void cgF() {
        if (this.hCD != null && this.hCD.getVisibility() != 8) {
            if (cbJ().bQu() == 2) {
                chk();
            } else {
                chj();
            }
        }
        if (this.hCD != null && this.hCD.getVisibility() != 8) {
            if (cbJ().bQu() == 1) {
                this.hCD.onResume();
            }
            this.hCD.onRefresh();
        }
        if (this.hCO != null) {
            this.hCO.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.hnU && this.hDk != null) {
            if (this.hne != null) {
                this.hne.IF().getView().setVisibility(0);
            }
            if (this.hne != null) {
                this.hne.IG().show();
                String nameShow = this.hDk.getNameShow();
                if (this.hDk.extInfoJson != null) {
                    if (this.hDk.extInfoJson.optInt("is_mysterious_man") == 1) {
                        nameShow = this.hDk.extInfoJson.optString("mysterious_man_nickname");
                        if (TextUtils.isEmpty(nameShow)) {
                            nameShow = "神秘人";
                        }
                    }
                }
                this.hne.IG().setEditText(" @" + nameShow + " ");
            }
            vF(8);
            this.hnU = false;
        }
        if (this.hDM != null) {
            this.hDM.resume();
        }
        if (this.hDN != null) {
            this.hDN.resume();
        }
        if (this.hba != null) {
            this.hba.resume();
        }
        if (this.hDK != null) {
            this.hDK.TT();
        }
    }

    public void onPause() {
        if (this.hCO != null) {
            this.hCO.onPause();
        }
        if (this.hDM != null) {
            this.hDM.pause();
        }
        if (this.hns != null) {
            this.hns.onPause();
        }
        if (this.hDN != null) {
            this.hDN.pause();
        }
        if (this.hba != null) {
            this.hba.pause();
        }
    }

    private void cgG() {
        if (bo.c(com.baidu.live.af.a.OJ().bxp)) {
            this.hDf.setVisibility(0);
            this.hDf.setAlpha(0.2f);
        } else if (cbJ().hxA.hasBeauty() < 0) {
            this.hDf.setVisibility(8);
        } else {
            this.hDf.setVisibility(0);
        }
    }

    private void cgH() {
        this.hCS = (RelativeLayout) cbJ().rootView.findViewById(a.f.ala_live_unremovable_container);
        this.hCV = (RelativeLayout) cbJ().rootView.findViewById(a.f.under_live_view_panel);
        this.hCW = (RelativeLayout) cbJ().rootView.findViewById(a.f.over_live_view_panel);
        this.hCX = (FrameLayout) cbJ().rootView.findViewById(a.f.goods_parent);
        this.hCY = (FrameLayout) cbJ().rootView.findViewById(a.f.ala_live_bc_chat_container);
        this.hqr.hxk.setOnLiveViewScrollListener(this.hEh);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hCV.setVisibility(8);
            this.hCW.setVisibility(8);
            cbJ().hxk.removeAllViews();
            return;
        }
        this.hCT = (RelativeLayout) cbJ().rootView.findViewById(a.f.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hCT.getLayoutParams();
        layoutParams.topMargin = this.hqr.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.hCT.setLayoutParams(layoutParams);
        this.hCU = (RelativeLayout) cbJ().rootView.findViewById(a.f.ala_live_top_pendant_container);
        if (this.hlV == null) {
            this.hlV = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.hqr.pageContext.getPageActivity(), true);
        }
        this.hlV.a(this.hmE);
        this.hlV.a(this.hCT, a.f.ala_live_room_host_header_stub, 1L);
        this.hlV.setVisible(0);
        cgI();
        this.hDf = (ImageView) cbJ().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn);
        this.hDj = (TextView) cbJ().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn_num);
        this.hDf.setOnClickListener(this.hDZ);
        this.hDh = (ImageView) cbJ().rootView.findViewById(a.f.ala_liveroom_host_paster);
        this.hDh.setOnClickListener(this.hDZ);
        if (com.baidu.live.af.a.OJ().bxp != null && com.baidu.live.af.a.OJ().bxp.aMM != null && com.baidu.live.af.a.OJ().bxp.aMM.Bm() && bo.b(com.baidu.live.af.a.OJ().bxp)) {
            this.hDh.setVisibility(0);
        } else {
            this.hDh.setVisibility(8);
        }
        cgG();
        this.hDe = (ImageView) cbJ().rootView.findViewById(a.f.ala_liveroom_host_share_btn);
        this.hDe.setOnClickListener(this.hDZ);
        this.hDc = (ImageView) cbJ().rootView.findViewById(a.f.ala_liveroom_host_message_btn);
        this.hDc.setOnClickListener(this.hDZ);
        this.hqy = (ImageView) cbJ().rootView.findViewById(a.f.ala_liveroom_host_pk_btn);
        this.hqy.setOnClickListener(this.hDZ);
        this.hDi = (ImageView) cbJ().rootView.findViewById(a.f.ala_liveroom_host_vedio_chat);
        this.hDi.setOnClickListener(this.hDZ);
        this.hDd = (ImageView) cbJ().rootView.findViewById(a.f.ala_liveroom_host_more);
        this.hDd.setOnClickListener(this.hDZ);
        this.hDg = (ImageView) cbJ().rootView.findViewById(a.f.ala_liveroom_host_zan_btn);
        this.hDg.setOnClickListener(this.hDZ);
        cgL();
        if (bo.b(com.baidu.live.af.a.OJ().bxp)) {
            this.hDI = new com.baidu.tieba.ala.liveroom.h.b(cbJ().hxD, cbJ(), cbJ().hxA);
        }
        this.hnd = new m();
        cgJ();
        cgK();
        if (com.baidu.live.d.xf().getInt("beauty_new_bubble", 1) == 1) {
            this.hDj.setVisibility(0);
        }
    }

    private void cgI() {
        this.hDS = (FrameLayout) View.inflate(cbJ().pageContext.getPageActivity(), a.g.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hDS != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.hDS.setVisibility(8);
            if (this.hDS.getParent() != null && (this.hDS.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hDS.getParent()).removeView(this.hDS);
            }
            this.hCS.addView(this.hDS, layoutParams);
            if (this.hDS != null) {
                this.hDS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.hmE.v(AlaMasterLiveRoomOpearator.this.hDS, 8);
                    }
                });
            }
        }
    }

    private void cgJ() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, cbJ().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hne = (k) runTask.getData();
            this.hne.setFromMaster(true);
            this.hne.IF().getView().setId(a.f.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(cbJ().pageContext.getPageActivity()) * 0.75f), com.baidu.live.al.c.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.al.c.dj(true);
            cbJ().hxk.addView(this.hne.IF().getView(), layoutParams);
            this.hne.IG().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            cbJ().hxk.addView(this.hne.IG().getView(), layoutParams2);
            this.hne.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                @Override // com.baidu.live.im.k.a
                public boolean IJ() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void IK() {
                }

                @Override // com.baidu.live.im.k.a
                public void gD(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void IL() {
                }

                @Override // com.baidu.live.im.k.a
                public void IM() {
                }

                @Override // com.baidu.live.im.k.a
                public void IN() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean IO() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int IP() {
                    return 0;
                }

                @Override // com.baidu.live.im.k.a
                public boolean IQ() {
                    return false;
                }
            });
        }
    }

    private void cgK() {
        View zf;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, cbJ().pageContext);
        if (runTask != null) {
            this.hnf = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hnf != null && (zf = this.hnf.zf()) != null && this.hqr.hxk.indexOfChild(zf) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.hqr.pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds98));
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            layoutParams.bottomMargin = cbJ().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            cbJ().hxk.addView(zf, layoutParams);
        }
    }

    private void cgL() {
        CustomResponsedMessage runTask;
        if (this.hDn == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ai.a.class, cbJ().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hDn = (com.baidu.live.ai.a) runTask.getData();
        }
    }

    private void cgM() {
        View Ds;
        ac.e(cbJ().hxj.DW());
        ac.b(cbJ().pageContext, true, false);
        ac.Ed();
        if (this.hng == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aSj = true;
            fVar.context = cbJ().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hng = (ad) runTask.getData();
                if (this.hng != null && (Ds = this.hng.Ds()) != null && cbJ().hxk.indexOfChild(Ds) < 0) {
                    if (Ds.getParent() instanceof ViewGroup) {
                        ((ViewGroup) Ds.getParent()).removeView(Ds);
                    }
                    cbJ().hxk.addView(Ds, cbJ().hxk.getLayoutParams());
                }
            }
        }
    }

    private void cgN() {
        if (!this.hDT) {
            this.hDT = true;
            com.baidu.live.entereffect.a.BG().bt(true);
        }
    }

    protected void cao() {
        View DV;
        if (this.hnh == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aSj = true;
            aVar.context = cbJ().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hnh = (ab) runTask.getData();
            }
        }
        if (this.hnh != null && (DV = this.hnh.DV()) != null && this.hCU != null) {
            if (this.hCU.indexOfChild(DV) < 0) {
                if (DV.getParent() instanceof ViewGroup) {
                    ((ViewGroup) DV.getParent()).removeView(DV);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.hCG != null && this.hCG.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
                    layoutParams.topMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hnD != null && this.hnD.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hnC != null && this.hnC.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else {
                    layoutParams.topMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds66);
                }
                this.hCU.addView(DV, layoutParams);
            }
            DV.bringToFront();
        }
    }

    protected void can() {
        View Ej;
        if (this.hns == null) {
            ak akVar = new ak();
            akVar.aSj = true;
            akVar.pageContext = cbJ().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hns = (ag) runTask.getData();
            }
        }
        if (this.hns != null && (Ej = this.hns.Ej()) != null && cbJ().hxk.indexOfChild(Ej) < 0) {
            if (Ej.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ej.getParent()).removeView(Ej);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            cbJ().hxk.addView(Ej, layoutParams);
        }
    }

    private void cgO() {
        cgS();
        cat();
        cgR();
        cbJ().hxk.setVisibility(0);
        vF(0);
    }

    private void cgP() {
        if (this.hCG == null) {
            this.hCG = new com.baidu.tieba.ala.liveroom.u.a(cbJ().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.hCG.a(cbJ().bQu(), j, TbadkCoreApplication.getCurrentAccountName(), true, cbJ().hxj.DW().aFH.portrait, this.otherParams, "", -1L);
        this.hCG.aF(this.hCU);
    }

    private void cgQ() {
        if (this.hDp == null) {
            cbJ().hxk.hMO = false;
            com.baidu.live.ag.a fZ = fZ(cbJ().pageContext.getPageActivity());
            if (fZ != null) {
                this.hDp = fZ;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.ag.a.class, cbJ().pageContext.getPageActivity());
                if (runTask != null) {
                    this.hDp = (com.baidu.live.ag.a) runTask.getData();
                }
            }
            if (this.hDp != null) {
                this.hDp.t(this.hCV);
                this.hDp.u(this.hCW);
                this.hDp.dT((cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds330) + cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96)) - cbJ().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds300));
                this.hDp.v(cbJ().hxk);
                this.hDp.a(this.hlp);
                this.hDp.setLiveShowInfo(cbJ().hxj.DW());
                this.hDp.a(this.hlX);
                this.hDp.Pe();
                this.hDp.a(new a.InterfaceC0156a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                    @Override // com.baidu.live.ag.a.InterfaceC0156a
                    public void Pf() {
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0156a
                    public void Pg() {
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0156a
                    public void F(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.cbJ().hxA != null) {
                            AlaMasterLiveRoomOpearator.this.cbJ().hxA.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0156a
                    public int Ph() {
                        return AlaMasterLiveRoomOpearator.this.hCT.getBottom();
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0156a
                    public int Pi() {
                        return AlaMasterLiveRoomOpearator.this.hqr.hxk.getHeight() - (AlaMasterLiveRoomOpearator.this.hne.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.hne.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0156a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.hne.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0156a
                    public int Pj() {
                        return AlaMasterLiveRoomOpearator.this.hne.II();
                    }
                });
            }
        }
    }

    private com.baidu.live.ag.a fZ(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aY(context);
        }
        return null;
    }

    private void cgR() {
        if (this.hCI == null) {
            this.hCI = new b(cbJ().pageContext, cbJ().hxk);
        }
    }

    private void cgS() {
        if (this.hlS == null) {
            this.hlS = new com.baidu.tieba.ala.liveroom.o.a(cbJ().pageContext, true, this.hEd);
            this.hlS.e(this.hCT, null);
            this.hlS.a(this.hmE);
            this.hlS.ok(false);
        }
        if (this.hCE == null) {
            this.hCE = new com.baidu.tieba.ala.liveroom.o.a(cbJ().pageContext, true, null);
            this.hCE.a(this.hCT, null, a.f.ala_live_room_host_header_stub);
            this.hCE.cfl();
        }
    }

    protected void bZU() {
        CustomResponsedMessage runTask;
        boolean z = false;
        as civ = cbJ().hxj.civ();
        boolean z2 = com.baidu.live.af.a.OJ().bru.aKm;
        if (civ == null || civ.aGt) {
            z = z2;
        }
        if (z && this.hmP == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.k.b.class, cbJ().pageContext)) != null) {
            this.hmP = (com.baidu.live.k.b) runTask.getData();
            if (this.hmP != null) {
                this.hmP.setIsHost(true);
                this.hmP.dp(1);
                View view = this.hmP.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(cbJ().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(cbJ().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.f.ala_live_room_host_header_stub);
                    this.hCT.addView(view, layoutParams);
                }
            }
        }
    }

    private void g(x xVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2;
        if (this.hlX == null) {
            this.hlX = new com.baidu.tieba.ala.liveroom.activeview.b(cbJ().pageContext);
        }
        this.hlX.setOtherParams(this.otherParams);
        this.hlX.c(xVar, false);
        this.hlX.setHost(true);
        this.hlX.a(1, this.buY);
        this.hlX.a(2, this.buY);
        this.hlX.nx(this.hnZ);
        this.hlX.setVisible(this.hCC ? 8 : 0);
        this.hlX.a(this.hlp);
        if (this.hlp != null) {
            if (this.hlX != null) {
                AlaActiveRootView uX = this.hlX.uX(1);
                alaActiveRootView = this.hlX.uX(2);
                alaActiveRootView2 = uX;
            } else {
                alaActiveRootView = null;
                alaActiveRootView2 = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.hlp.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.hlp.a(alaActiveRootView);
            }
        }
    }

    private void N(x xVar) {
        CustomResponsedMessage runTask;
        if (this.hnI == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, cbJ().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.ab.a)) {
            this.hnI = (com.baidu.live.ab.a) runTask.getData();
            if (this.hnI != null) {
                this.hnI.s(this.buY);
            }
        }
        if (this.hnI != null) {
            this.hnZ = this.hnI.p(xVar);
            this.hnI.setCanVisible(!this.hCC);
        }
    }

    protected void cgT() {
        CustomResponsedMessage runTask;
        if (cbJ() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.m.a.class, cbJ().pageContext.getPageActivity())) != null && runTask.getData() != null && this.hny == null) {
            this.hny = (com.baidu.live.m.a) runTask.getData();
            this.hny.d(this.hCU, caH());
            if (cbJ().hxj != null) {
                this.hny.a(cbJ().hxj.DW());
            }
            this.hny.setCanVisible(true);
            this.hny.bZ(false);
            this.hny.a(cbJ().hxj.bTh());
        }
    }

    protected void cas() {
        CustomResponsedMessage runTask;
        if (cbJ() != null && this.hnA == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.u.a.class, cbJ().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hnA = (com.baidu.live.u.a) runTask.getData();
            this.hnA.setIsHost(true);
            this.hnA.a(this.buY, cbJ().hxj.DW());
        }
    }

    protected void bZh() {
        if (cbJ() != null) {
            if (this.hnB == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, cbJ().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hnB = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hnB.aW(this.gNL);
            this.hnB.aY(false);
            this.hnB.setIsHost(true);
            this.hnB.a(this.buY, cbJ().hxj.DW());
        }
    }

    protected void car() {
        if (cbJ() != null) {
            if (this.hnz == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.w.a.class, cbJ().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hnz = (com.baidu.live.w.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (cbJ().hxj != null) {
                this.hnz.b(cbJ().hxj.DW(), this.otherParams);
            }
        }
    }

    protected void bZg() {
        if (cbJ() != null) {
            if (this.hme == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ae.a.class, cbJ().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hme = (com.baidu.live.ae.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hme.setIsHost(true);
            this.hme.a(this.buY, cbJ().hxj.DW().aGH);
        }
    }

    protected void cgU() {
        CustomResponsedMessage runTask;
        if (cbJ() != null && this.hDm == null && (runTask = MessageManager.getInstance().runTask(2913269, com.baidu.live.o.b.class, cbJ().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hDm = (com.baidu.live.o.b) runTask.getData();
        }
    }

    protected void cau() {
        CustomResponsedMessage runTask;
        if (cbJ() != null && this.hnC == null && (runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.l.a.class, cbJ().pageContext)) != null && runTask.getData() != null) {
            this.hnC = (com.baidu.live.l.a) runTask.getData();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            this.hnC.a(this.hCU, cbJ().hxj.DW(), layoutParams, this.otherParams);
        }
    }

    private void O(x xVar) {
        CustomResponsedMessage runTask;
        if (cbJ() != null) {
            if (this.hCK == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.u.d.class)) != null) {
                this.hCK = (com.baidu.live.u.d) runTask.getData();
            }
            if (this.hCK != null) {
                this.hCK.NH();
            }
            if (this.hCL == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913230, c.class);
                if (runTask2 != null) {
                    this.hCL = (c) runTask2.getData();
                }
                if (this.hCL != null) {
                    this.hCL.setParentView(this.hqr.hxk);
                    if (xVar != null && xVar.aFH != null) {
                        this.hCL.bd(xVar.aFH.userId);
                    }
                }
            }
        }
    }

    private void cgV() {
        CustomResponsedMessage runTask;
        if (cbJ() != null) {
            if (this.hCM == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.w.c.class)) != null) {
                this.hCM = (com.baidu.live.w.c) runTask.getData();
            }
            if (this.hCM != null) {
                this.hCM.NH();
            }
            if (this.hCN == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913266, com.baidu.live.w.b.class);
                if (runTask2 != null) {
                    this.hCN = (com.baidu.live.w.b) runTask2.getData();
                }
                if (this.hCN != null) {
                    this.hCN.setParentView(this.hqr.hxk);
                    this.hCN.b(cbJ().hxj.DW(), this.otherParams);
                }
            }
        }
    }

    private void cad() {
        if (this.hDN == null) {
            this.hDN = new com.baidu.tieba.ala.liveroom.q.c(cbJ().pageContext.getPageActivity());
        }
    }

    private ViewGroup.LayoutParams caH() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(cbJ().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.f.ala_live_room_stream_view);
            layoutParams.leftMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.f.ala_liveroom_charmview);
        }
        if (this.hnD != null && this.hnD.isShowing()) {
            layoutParams.addRule(3, a.f.ala_rank_level_entry);
            layoutParams.topMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        } else if (this.hCG != null && this.hCG.isShowing()) {
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            layoutParams.topMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        }
        return layoutParams;
    }

    private void cat() {
        if (this.hCF == null) {
            this.hCF = new com.baidu.tieba.ala.liveroom.b.a(cbJ().pageContext, true);
        }
    }

    private void cgW() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = cbJ().pageContext.getPageActivity();
            if (this.hDq == null) {
                this.hDq = new ImageView(pageActivity);
                this.hDq.setId(a.f.master_close_btn);
                this.hDq.setTag("master_close_btn");
                this.hDq.setImageResource(a.e.sdk_icon_bar_live_close_n);
                this.hDq.setBackgroundResource(a.e.sdk_round_btn_close_bg);
                this.hDq.setPadding(pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0);
            }
            if (this.hDq.getParent() != null) {
                ((ViewGroup) this.hDq.getParent()).removeView(this.hDq);
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
            cbJ().hxD.addView(this.hDq, layoutParams);
            this.hDq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.chg();
                }
            });
            this.hDq.setVisibility(8);
        }
    }

    protected void cax() {
        if (this.hnD == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.u.b.class, cbJ().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hnD = (com.baidu.live.u.b) runTask.getData();
            } else {
                return;
            }
        }
        if (cbJ().hxj.DW() != null && cbJ().hxj.DW().aFH != null && cbJ().hxj.DW().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.height = BdUtilHelper.getDimens(cbJ().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.leftMargin = BdUtilHelper.getDimens(cbJ().pageContext.getPageActivity(), a.d.sdk_ds20);
            this.hnD.b(this.hCU, layoutParams, cbJ().hxj.DW());
        }
    }

    private void cgX() {
        CustomResponsedMessage runTask;
        if (this.hDL == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, cbJ().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.hDL = (com.baidu.live.b.a) runTask.getData();
            if (this.hDL != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.f.ala_head_line_entry_id);
                layoutParams.addRule(11);
                layoutParams.topMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
                layoutParams.rightMargin = cbJ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                as civ = cbJ().hxj.civ();
                if (civ != null) {
                    this.hDL.a(this.hCU, layoutParams, cbJ().pageContext.getPageActivity(), civ.aLn);
                } else {
                    return;
                }
            }
        }
        if (this.hDL != null) {
            this.hDL.a(cbJ().hxj.DW());
        }
    }

    private void cgY() {
        CustomResponsedMessage runTask;
        if (this.hDM == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, cbJ().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.hDM = (com.baidu.live.b.b) runTask.getData();
        }
    }

    private void cae() {
        if (this.hba == null) {
            this.hba = new com.baidu.live.ap.a(cbJ().pageContext.getPageActivity());
        }
    }

    public void onRtcConnected(int i) {
        if (this.hDJ != null) {
            this.hDJ.onRtcConnected(i);
        }
    }

    private void registerListener() {
        cbJ().pageContext.registerListener(this.hor);
        cbJ().pageContext.registerListener(this.hDV);
        cbJ().pageContext.registerListener(this.hos);
        cbJ().pageContext.registerListener(this.hou);
        cbJ().pageContext.registerListener(this.hEa);
        cbJ().pageContext.registerListener(this.byv);
        cbJ().pageContext.registerListener(this.hkv);
        cbJ().pageContext.registerListener(this.hEb);
        cbJ().pageContext.registerListener(this.gKz);
        cbJ().pageContext.registerListener(this.hmz);
        cbJ().pageContext.registerListener(this.hoy);
        cbJ().pageContext.registerListener(this.bAU);
        cbJ().pageContext.registerListener(this.bAV);
        cbJ().pageContext.registerListener(this.hDW);
        cbJ().pageContext.registerListener(this.boo);
        cbJ().pageContext.registerListener(this.bop);
        cbJ().pageContext.registerListener(this.hDX);
        cbJ().pageContext.registerListener(this.hoA);
        cbJ().pageContext.registerListener(this.hoz);
        cbJ().pageContext.registerListener(this.hoE);
        cbJ().pageContext.registerListener(this.hDY);
        cbJ().pageContext.registerListener(this.hDX);
        cbJ().pageContext.registerListener(this.blj);
        cbJ().pageContext.registerListener(this.biG);
        cbJ().pageContext.registerListener(this.hbb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(boolean z) {
        if (bo.c(com.baidu.live.af.a.OJ().bxp)) {
            cbJ().pageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (cbJ().hxF.yU() == null || ListUtils.isEmpty(cbJ().hxF.yU().aAy)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                cbJ().pageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (!this.bAS) {
                this.bAR = BdUniqueId.gen();
                cbJ().hxF.a(this.bAR);
                this.bAS = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(cbJ().pageContext.getPageActivity(), cbJ().rootView);
            vF(8);
            if (cbJ().hxA.hasAdvancedBeauty() && this.hDI != null) {
                if (!this.hDO || this.hCD.getVisibility() == 0) {
                    this.hDI.c(cbJ().hxA.getVideoConfig());
                }
                this.hDI.a(cbJ().hxA.getVideoConfig(), this.bAT);
                if (!this.bAT) {
                    this.bAT = true;
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
    public void vE(int i) {
        if (this.hDr == null || !this.hDr.isShowing()) {
            this.hDr = new BdAlertDialog(cbJ().pageContext.getPageActivity());
            this.hDr.setAutoNight(false);
            this.hDr.setTitle(a.h.sdk_prompt);
            this.hDr.setMessageId(i, currentAppType(cbJ().pageContext.getPageActivity()));
            this.hDr.setTitleShowCenter(true);
            this.hDr.setMessageShowCenter(true);
            this.hDr.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    AlaMasterLiveRoomOpearator.this.cbJ().g((short) 1);
                }
            });
            this.hDr.create(cbJ().pageContext).show();
        }
    }

    private void Ho(String str) {
        if (this.hDs == null || !this.hDs.isShowing()) {
            this.hDs = new BdAlertDialog(cbJ().pageContext.getPageActivity());
            this.hDs.setAutoNight(false);
            this.hDs.setTitle(a.h.sdk_prompt);
            this.hDs.setMessage(str);
            this.hDs.setTitleShowCenter(true);
            this.hDs.setMessageShowCenter(true);
            this.hDs.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    AlaMasterLiveRoomOpearator.this.cbJ().g((short) 1);
                }
            });
            this.hDs.create(cbJ().pageContext).show();
        }
    }

    public void cgZ() {
        bZU();
        r bTh = cbJ().hxj.bTh();
        int i = 5;
        if (bTh != null) {
            i = (int) bTh.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW() != null && AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.cbJ().hxj.j(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bTh != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.hqr.hxI.b(bTh);
                return;
            }
            if (this.hlR == null) {
                this.hlR = new com.baidu.tieba.ala.liveroom.audiencelist.c(cbJ().pageContext, this.hEd, true);
            }
            if (this.hDG) {
                this.hDG = false;
                this.hlR.a(String.valueOf(cbJ().hxj.DW().mLiveInfo.group_id), String.valueOf(cbJ().hxj.DW().mLiveInfo.live_id), String.valueOf(cbJ().hxj.DW().aFH.userId), cbJ().hxj.DW());
                int i2 = a.f.ala_live_room_host_header_stub;
                if (this.hmP != null) {
                    i2 = a.f.ala_liveroom_guardthrone;
                }
                this.hlR.c(this.hCT, i2, a.f.ala_liveroom_audience_count_layout);
            }
            this.hlR.e(bTh);
            this.hlV.setVisible(0);
            this.hlV.eZ(bTh.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cha() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bul() {
        if (cbJ().hxj != null) {
            if (this.hmR == null) {
                this.hmR = new com.baidu.tieba.ala.liveroom.share.c(cbJ().pageContext);
            }
            this.hmR.d(cbJ().hxj.DW(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (cbJ().hxj != null && cbJ().hxj.DW() != null && cbJ().hxj.DW().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", cbJ().hxj.DW().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", cbJ().hxj.DW().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", cbJ().hxj.DW().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (cbJ().hxj != null && cbJ().hxj.DW() != null && cbJ().hxj.DW().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", cbJ().hxj.DW().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", cbJ().hxj.DW().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", cbJ().hxj.DW().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean chb() {
        return this.hCB;
    }

    private void oq(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(hCA, z);
        this.hCB = z;
    }

    private void chc() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(cbJ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.h.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.p.b(AlaMasterLiveRoomOpearator.this.cbJ().pageContext).cid();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.h.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(cbJ().pageContext).show();
    }

    private void chd() {
        if (this.hCk && cbJ().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            cbJ().hxH.Ss();
        }
        cbJ().hxG.prepareTime = System.currentTimeMillis() - cbJ().hxG.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (cbJ().hxj != null && cbJ().hxj.DW() != null && cbJ().hxj.DW().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", cbJ().hxj.DW().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", cbJ().hxj.DW().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", cbJ().hxG.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hCD != null && this.hCD.getView().getParent() != null) {
            this.hCD.setVisibility(8);
            cbJ().hxD.removeView(this.hCD.getView());
            this.hCD.release();
        }
        if (this.hDI != null) {
            this.hDI.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (cbJ().hxk.indexOfChild(this.hCQ) < 0) {
            cbJ().hxk.addView(this.hCQ, layoutParams);
        }
        this.hCQ.vW(1000);
    }

    private void avQ() {
        if (cbJ().bQu() == 1) {
            cbJ().hxA.startRecord();
        }
    }

    private void Hp(String str) {
        Hq(str);
    }

    private void Hq(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) cbJ().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String P(Intent intent) {
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

    private void Q(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.hCD != null) {
            this.hCD.Hd(fromJson.getSmallurl());
        }
    }

    private boolean che() {
        return com.baidu.live.d.xf().getBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chf() {
        com.baidu.live.d.xf().putBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), this.hqr.hxA.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chg() {
        if (this.hDK == null || !this.hDK.PD()) {
            if (this.hCP == null || !this.hCP.PD()) {
                int i = a.h.live_close_confirm;
                if (this.hDJ != null && this.hDJ.cbR()) {
                    i = a.h.ala_pk_pking_close_live_roon_tip;
                } else if (this.hDJ != null && this.hDJ.cbQ()) {
                    i = a.h.ala_challenge_challenging_close_live_room_tip;
                }
                BdAlertDialog bdAlertDialog = new BdAlertDialog(cbJ().pageContext.getPageActivity());
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
                        if (AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW() != null) {
                            AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW(), 0, AlaMasterLiveRoomOpearator.this.cbJ().hxj.ciE() != 1 ? AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
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
                bdAlertDialog.create(cbJ().pageContext).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, int i, String str) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        AlaLiveInfoData alaLiveInfoData;
        if (xVar != null) {
            alaLiveInfoData = xVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = xVar.aFH;
            if (alaLiveInfoData != null) {
                String str2 = alaLiveInfoData.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                cbJ().hxj.eB(Long.toString(alaLiveInfoData.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
        } else {
            alaLiveUserInfoData = null;
            alaLiveInfoData = null;
        }
        if (!this.hDE) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = cbJ().hxG;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = cbJ().hxA.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.hDA;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.hDB;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.hDw;
            if (this.hDx != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.hDy - this.hDz) / this.hDx) * 100.0f;
            }
            Intent intent = new Intent(cbJ().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (cbJ().hxj != null && cbJ().hxj.DW() != null && cbJ().hxj.DW().aFH != null) {
                String str3 = cbJ().hxj.DW().aFH.nickName;
                String str4 = cbJ().hxj.DW().aFH.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            x DW = cbJ().hxj.DW();
            if (DW != null && DW.aFH != null && !TextUtils.isEmpty(DW.aFH.portrait)) {
                intent.putExtra("host_portrait", DW.aFH.portrait);
            }
            if (this.hDK != null) {
                this.hDK.TR();
            }
            if (this.hCP != null) {
                this.hCP.PB();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.hDC = intent;
                this.hDD = s;
                cbJ().pageContext.showToast(a.h.ala_live_background_close_tip);
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
    public void chh() {
        if (this.hDC != null) {
            a(this.hDC, this.hDD);
            this.hDC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.hDE = true;
        if (this.hDJ != null) {
            this.hDJ.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.hkk);
            cbJ().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        cbJ().g(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chi() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hqr.hxI != null && this.hqr.hxI.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hDJ != null && this.hDJ.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hDK != null && this.hDK.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hDI != null && this.hDI.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hCP != null && this.hCP.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (cbJ().hxE.chM()) {
                chg();
                return true;
            }
        }
        return false;
    }

    public void sendBufferChanged(int i) {
        if (this.hCR != null) {
            this.hCR.ef(i);
        }
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (this.hqr != null && this.hqr.hxj != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.dJl != i3) {
                this.dJl = i3;
                if (this.hCJ == null) {
                    this.hCJ = new com.baidu.tieba.ala.liveroom.tippop.a(this.hqr.pageContext, null);
                }
                switch (this.dJl) {
                    case 0:
                        this.hCJ.c(this.hqr.hxD, this.hqr.pageContext.getString(a.h.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.hCJ.c(this.hqr.hxD, this.hqr.pageContext.getString(a.h.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.hCJ.c(this.hqr.hxD, this.hqr.pageContext.getString(a.h.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.hqr.hxj.z(this.hqr.hxj.DW().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void K(com.baidu.live.im.data.b bVar) {
        String str;
        final String str2;
        JSONObject jSONObject;
        if (bVar.getMsgType() == 13 || bVar.getMsgType() == 12) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                str = jSONObject.optString("content_type");
            } catch (JSONException e) {
                str = null;
            }
            try {
                str2 = jSONObject.optString("text");
            } catch (JSONException e2) {
                str2 = null;
                if (!"close_live".equals(str)) {
                }
            }
            if (!"close_live".equals(str)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.chi();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW(), 1, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0736, code lost:
        GQ(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: JSONException -> 0x082b, TRY_LEAVE, TryCatch #6 {JSONException -> 0x082b, blocks: (B:14:0x0049, B:16:0x0051, B:263:0x0820), top: B:292:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0820 A[Catch: JSONException -> 0x082b, TRY_ENTER, TRY_LEAVE, TryCatch #6 {JSONException -> 0x082b, blocks: (B:14:0x0049, B:16:0x0051, B:263:0x0820), top: B:292:0x0049 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        JSONObject jSONObject3;
        long j;
        long j2;
        boolean z;
        JSONObject jSONObject4;
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ IM消息 接收: liveSingleMessageReceived 消息分发 msgType " + bVar.getMsgType());
        }
        if (this.hlX != null) {
            this.hlX.I(bVar);
        }
        if (bVar.getMsgType() == 125) {
            if (this.hCH != null) {
                this.hCH.M(bVar);
            }
        } else if (bVar.getMsgType() == 13 || bVar.getMsgType() == 12) {
            String str2 = null;
            final String str3 = null;
            JSONObject jSONObject5 = null;
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject5 = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject5 = new JSONObject(bVar.getContent());
                }
                str2 = jSONObject5.optString("content_type");
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: liveSingleMessageReceived 消息分发 contentType: " + str2);
                }
                str3 = jSONObject5.optString("text");
                String optString = jSONObject5.optString("ext");
                if (!TextUtils.isEmpty(optString)) {
                    new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
                }
                jSONObject = jSONObject5.optJSONObject("ext_data");
            } catch (JSONException e) {
                jSONObject = null;
            }
            if (this.hDJ != null) {
                this.hDJ.eV(str2);
            }
            if ("close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.chi();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.cbJ().hxj.DW(), 1, str3);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (cbJ().hxj.DW() != null && jSONObject5 != null) {
                    long optLong = jSONObject5.optLong("user_id");
                    int optInt = jSONObject5.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            cbJ().hxj.DW().aGd.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            cbJ().hxj.DW().aGd.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        cbJ().hxj.DW().aGd.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (cbJ().hxj.DW() != null && jSONObject5 != null) {
                    long optLong2 = jSONObject5.optLong("user_id");
                    if (cbJ().hxj.DW() != null && cbJ().hxj.DW().aFH != null && cbJ().hxj.DW().aFH.userId == optLong2) {
                        cbJ().hxj.DW().aFH.isUegBlock = 1;
                        bZy();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (cbJ().hxj.DW() != null && jSONObject5 != null) {
                    long optLong3 = jSONObject5.optLong("user_id");
                    if (cbJ().hxj.DW() != null && cbJ().hxj.DW().aFH != null && cbJ().hxj.DW().aFH.userId == optLong3) {
                        cbJ().hxj.DW().aFH.isUegBlock = 0;
                        bZy();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.hDn != null) {
                    this.hDn.Z(jSONObject5);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject5 != null) {
                    String optString2 = jSONObject5.optString("share_enter_msg");
                    int optInt2 = jSONObject5.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.hCI.aL(optString2, optInt2);
                    }
                    if (this.hlV.getCount() > 20) {
                        this.hlV.eZ(this.hlV.getCount() + 1);
                    } else if (this.hlR != null) {
                        com.baidu.live.data.a JB = bVar.JB();
                        q qVar = new q();
                        qVar.aFI = new AlaLocationData();
                        qVar.aFJ = new AlaRelationData();
                        qVar.aFH = new AlaLiveUserInfoData();
                        qVar.aFH.userId = JavaTypesHelper.toLong(JB.userId, 0L);
                        qVar.aFH.userName = JB.userName;
                        qVar.aFH.portrait = JB.portrait;
                        if (this.hlR.c(qVar)) {
                            this.hlV.eZ(this.hlV.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject5 != null && cbJ() != null && cbJ().hxj != null && cbJ().hxj.DW() != null && cbJ().hxj.DW().aGd != null && cbJ().hxj.DW().aGd.userId == jSONObject5.optLong("user_id")) {
                    cbJ().hxj.ciu();
                }
            } else if ("official_notice".equals(str2)) {
                if (jSONObject5 != null) {
                    long optLong4 = jSONObject5.optLong("user_id");
                    if (jSONObject != null) {
                        String str4 = optLong4 + "";
                        TbadkCoreApplication.getInst();
                        if (str4.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                }
            } else if ("privilege_award_royal_success".equals(str2)) {
                if (jSONObject5 != null) {
                    String str5 = jSONObject5.optInt("effect_id") + "";
                    com.baidu.live.data.a JB2 = bVar.JB();
                    if (JB2 != null && ac.fU(str5)) {
                        ac.d(str5, 1L, "", "", JB2.userId, JB2.portrait, JB2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str2)) {
                if (jSONObject5 != null) {
                    bd bdVar = new bd();
                    bdVar.parseJson(jSONObject5);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bdVar));
                }
            } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                if (jSONObject5 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject5));
                }
            } else if ("challenge_direct_new".equals(str2)) {
                if (jSONObject5 != null) {
                    String optString3 = jSONObject5.optString("challenge_im_type");
                    if (TextUtils.equals(optString3, "start")) {
                        Hr(jSONObject5.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString3, "cancel")) {
                        BdUtilHelper.showToast(cbJ().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                    }
                }
                if (jSONObject5 == null) {
                    jSONObject2 = null;
                } else {
                    String optString4 = jSONObject5.optString("challenge_im_type");
                    if (!TextUtils.equals(optString4, "start")) {
                        str = "";
                    } else {
                        str = jSONObject5.optString("challenge_user_name");
                    }
                    try {
                        jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("challenge_im_type", optString4);
                            jSONObject2.put("challenge_user_name", str);
                        } catch (JSONException e2) {
                            e = e2;
                            e.printStackTrace();
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_direct_new").setContentExt(null, null, jSONObject2));
                            if (!(bVar.getObjContent() instanceof JSONObject)) {
                            }
                            try {
                                jSONObject4.put("log_id", bVar.getMsgId());
                            } catch (JSONException e3) {
                            }
                            if (this.hnC != null) {
                            }
                            if (this.hnA != null) {
                            }
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        jSONObject2 = null;
                    }
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_direct_new").setContentExt(null, null, jSONObject2));
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(cbJ().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_random_cancel").setContentExt(null, null, null));
            } else if ("connect_apply_show_pub".equals(str2)) {
                if (this.hCP != null) {
                    this.hCP.Y(jSONObject5);
                }
            } else if ("remove_video".equals(str2)) {
                String optString5 = jSONObject5.optString("text");
                if (jSONObject5.optString("poke_msg").isEmpty()) {
                    Hn(optString5);
                }
            }
        } else if (bVar.getMsgType() == 24) {
            com.baidu.live.data.a JB3 = bVar.JB();
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject3 = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject3 = new JSONObject(bVar.getContent());
                }
                com.baidu.live.im.data.c cVar = new com.baidu.live.im.data.c(jSONObject3);
                String optString6 = jSONObject3.optString("order_id");
                String optString7 = jSONObject3.optString(LogConfig.LOG_GIFT_ID);
                String optString8 = jSONObject3.optString("gift_count");
                String optString9 = jSONObject3.optString("gift_name");
                long optLong5 = jSONObject3.optLong("charm_total");
                String optString10 = jSONObject3.optString("attach_new");
                String optString11 = jSONObject3.optString("gift_mul");
                boolean z2 = jSONObject3.optInt("is_dynamic_gift") == 1;
                boolean z3 = jSONObject3.optInt("from_gongyanfang_2") == 1;
                boolean z4 = jSONObject3.optInt("from_gongyanfang_page") == 1;
                String str6 = "";
                String str7 = "";
                long j3 = 0;
                String str8 = null;
                if (cbJ().hxj == null || cbJ().hxj.DW() == null || cbJ().hxj.DW().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    z = false;
                } else {
                    long j4 = cbJ().hxj.DW().mLiveInfo.live_id;
                    j3 = cbJ().hxj.DW().mLiveInfo.group_id;
                    long j5 = cbJ().hxj.DW().aFH.userId;
                    str8 = cbJ().hxj.DW().mLiveInfo.appId;
                    boolean z5 = cbJ().hxj.DW().mLiveInfo.isPubShow;
                    if (cbJ().hxj.DW().mLiveSdkInfo.mCastIds != null) {
                        str6 = cbJ().hxj.DW().mLiveSdkInfo.mCastIds.chatMCastId;
                        str7 = cbJ().hxj.DW().mLiveSdkInfo.mCastIds.ensureMCastId;
                        j = j5;
                        j2 = j4;
                        z = z5;
                    } else {
                        j = j5;
                        j2 = j4;
                        z = z5;
                    }
                }
                if (!z3 || z2) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str6, str7, optString7, "");
                    if (!this.isBackground || cbJ().bQu() != 2) {
                        if (!TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                            if (jSONObject3.optInt("flag_show") == 1) {
                                ac.b(cVar, JB3, String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str8, "", "", bVar.getMsgId());
                                try {
                                    JSONArray jSONArray = new JSONArray(optString11);
                                    if (jSONArray != null && jSONArray.length() > 0) {
                                        int i = 0;
                                        while (true) {
                                            if (i >= jSONArray.length()) {
                                                break;
                                            }
                                            if (com.baidu.live.af.f.Pa().gZ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                            ac.b(cVar, JB3, String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str8, (z4 || z3) ? false : true, true, str6, str7, bVar.getMsgId());
                        }
                    }
                    GQ(optString7);
                    if (!jSONObject3.optString("content_type").equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) {
                        com.baidu.tieba.ala.liveroom.g.c cVar2 = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar2.blS = optLong5;
                        cVar2.liveId = j2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.putOpt(LogConfig.LOG_GIFT_ID, optString7);
                        jSONObject6.putOpt("gift_name", optString9);
                        jSONObject6.putOpt("order_id", optString6);
                        com.baidu.live.gift.g fQ = ac.fQ(optString7);
                        if (fQ != null) {
                            jSONObject6.putOpt(LogConfig.LOG_GIFT_VALUE, fQ.getPrice());
                        }
                        jSONObject6.putOpt("gift_num", optString8);
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "giftsend_succ").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject6));
                } else {
                    return;
                }
            } catch (JSONException e7) {
            }
        }
        try {
            if (!(bVar.getObjContent() instanceof JSONObject)) {
                jSONObject4 = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject4 = new JSONObject(bVar.getContent());
            }
            jSONObject4.put("log_id", bVar.getMsgId());
        } catch (JSONException e8) {
            jSONObject4 = null;
        }
        if (this.hnC != null) {
            this.hnC.l(bVar);
        }
        if ((this.hnA != null || !this.hnA.V(jSONObject4)) && this.hme != null && this.hme.V(jSONObject4)) {
        }
    }

    private void GQ(String str) {
        if (this.hlX != null) {
            this.hlX.GQ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(int i) {
        View findViewById = cbJ().rootView.findViewById(a.f.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.hlX != null) {
            this.hlX.bP(2, i);
        }
    }

    private void chj() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.cbJ().hxA != null && AlaMasterLiveRoomOpearator.this.cbJ().hxA.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.cbJ().hxA.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.cbJ().hxA.startRecord();
                }
            }
        });
    }

    private void chk() {
        if (cbJ().hxA != null && cbJ().hxA.getPreview() != null) {
            cbJ().hxA.getPreview().setVisibility(8);
            cbJ().hxA.stopRecord();
        }
    }

    public void chl() {
        this.hxx = cbJ().hxj.ciF();
        if (this.hCD != null) {
            this.hCD.nX(this.hxx);
        }
    }

    public void cdD() {
        if (TbadkCoreApplication.getInst().isOther()) {
            chm();
        } else if (this.hCD != null) {
            this.hCD.cdD();
        }
    }

    public void nY(boolean z) {
        if (this.hCD != null) {
            this.hCD.nY(z);
        }
    }

    public void onDestroy() {
        if (this.hDv != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.hDv);
        }
        this.hDv = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hDl.removeCallbacksAndMessages(null);
        if (this.hDI != null) {
            this.hDI.nV(true);
        }
        this.hDI = null;
        if (this.hCD != null) {
            this.hCD.destroy();
            cbJ().hxD.removeView(this.hCD.getView());
            this.hCD.release();
            this.hCD = null;
        }
        if (this.hDJ != null) {
            this.hDJ.onDestroy();
        }
        if (this.hmR != null) {
            this.hmR.onDestroy();
        }
        if (this.hlS != null) {
            this.hlS.onDestroy();
            this.hlS = null;
        }
        if (this.hCE != null) {
            this.hCE.onDestroy();
        }
        if (this.hns != null) {
            this.hns.onDestroy();
            this.hns = null;
        }
        if (this.hCQ != null) {
            this.hCQ.stopCountDown();
        }
        if (this.hCG != null) {
            this.hCG.onDestroy();
        }
        if (this.hCI != null) {
            this.hCI.onDestroy();
        }
        if (this.hDn != null) {
            this.hDn.onDestroy();
            this.hDn = null;
        }
        if (this.hng != null) {
            this.hng.onDestroy();
            this.hng = null;
        }
        if (this.hCK != null) {
            this.hCK.release();
        }
        if (this.hCM != null) {
            this.hCM.release();
        }
        com.baidu.live.ah.a.b.Pv().release();
        ac.Ee();
        com.baidu.live.entereffect.a.BG().release();
        this.hDT = false;
        if (this.hnh != null) {
            this.hnh.onDestroy();
            this.hnh = null;
        }
        if (this.hCJ != null) {
            this.hCJ.onDestroy();
        }
        if (this.hCH != null) {
            this.hCH.ckM();
            this.hCH.release();
        }
        if (this.hlV != null) {
            this.hlV = null;
        }
        if (this.hlX != null) {
            this.hlX.release();
        }
        if (this.hCH != null) {
            this.hCH.onDestroy();
        }
        if (this.hnf != null) {
            this.hnf.release();
        }
        if (this.hCO != null) {
            this.hCO.release();
        }
        if (this.hDp != null) {
            this.hDp.onDestroy();
        }
        if (this.hnI != null) {
            this.hnI.release();
        }
        if (this.hDL != null) {
            this.hDL.onDestory();
        }
        if (this.hDM != null) {
            this.hDM.release();
        }
        if (this.hny != null) {
            this.hny.onDestroy();
        }
        if (this.hnA != null) {
            this.hnA.onDestroy();
        }
        if (this.hnz != null) {
            this.hnz.onDestroy();
        }
        if (this.hme != null) {
            this.hme.onDestroy();
        }
        if (this.hCL != null) {
            this.hCL.release();
            this.hCL = null;
        }
        if (this.hCN != null) {
            this.hCN.release();
            this.hCN = null;
        }
        if (this.hDN != null) {
            this.hDN.release();
        }
        if (this.hba != null) {
            this.hba.release();
        }
        if (this.hnD != null) {
            this.hnD.onDestroy();
        }
        if (this.hDK != null) {
            this.hDK.onDestroy();
        }
        if (this.hCP != null) {
            this.hCP.onDestroy();
        }
        if (this.hnM != null) {
            this.hnM.onDestory();
        }
        if (this.hDr != null) {
            this.hDr.dismiss();
            this.hDr = null;
        }
        if (this.hDs != null) {
            this.hDs.dismiss();
            this.hDs = null;
        }
        this.hDP.removeCallbacksAndMessages(this.hEl);
        MessageManager.getInstance().unRegisterListener(this.hor);
        MessageManager.getInstance().unRegisterListener(this.hDV);
        MessageManager.getInstance().unRegisterListener(this.hos);
        MessageManager.getInstance().unRegisterListener(this.hou);
        MessageManager.getInstance().unRegisterListener(this.hEa);
        MessageManager.getInstance().unRegisterListener(this.byv);
        MessageManager.getInstance().unRegisterListener(this.hkv);
        MessageManager.getInstance().unRegisterListener(this.hEb);
        MessageManager.getInstance().unRegisterListener(this.gKz);
        MessageManager.getInstance().unRegisterListener(this.hmz);
        MessageManager.getInstance().unRegisterListener(this.hoy);
        MessageManager.getInstance().unRegisterListener(this.bAU);
        MessageManager.getInstance().unRegisterListener(this.bAV);
        MessageManager.getInstance().unRegisterListener(this.hDW);
        MessageManager.getInstance().unRegisterListener(this.boo);
        MessageManager.getInstance().unRegisterListener(this.bop);
        MessageManager.getInstance().unRegisterListener(this.hDX);
        MessageManager.getInstance().unRegisterListener(this.hoA);
        MessageManager.getInstance().unRegisterListener(this.hoz);
        MessageManager.getInstance().unRegisterListener(this.hoE);
        MessageManager.getInstance().unRegisterListener(this.hDY);
        MessageManager.getInstance().unRegisterListener(this.hDX);
        MessageManager.getInstance().unRegisterListener(this.blj);
        MessageManager.getInstance().unRegisterListener(this.biG);
        MessageManager.getInstance().unRegisterListener(this.hbb);
        MessageManager.getInstance().unRegisterListener(this.gUM);
        MessageManager.getInstance().unRegisterListener(this.gVe);
        cbJ().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hqr.hxI.a(this.hEk, this.hqr.hxC, this.hCS, alaLivePersonData);
        }
    }

    private void chm() {
        if (this.hDt != null) {
            this.hqr.hxG.startTime = System.currentTimeMillis();
            this.hqr.hxG.liveTotalTime = System.currentTimeMillis();
            this.hqr.hxG.sampleMemAndCPU();
            this.hqr.hxE.a((short) 4, this.hDt);
        }
    }

    private void Hr(String str) {
        String str2;
        int i;
        if (cbJ() != null && cbJ().pageContext != null) {
            this.hDl.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = cbJ().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.hDR == null) {
                    this.hDR = layoutInflater.inflate(a.g.layout_challenge_entry_toast, (ViewGroup) null);
                    this.hDR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.cgk()) {
                                AlaMasterLiveRoomOpearator.this.hDl.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.hDR != null) {
                                    AlaMasterLiveRoomOpearator.this.cbJ().hxk.removeView(AlaMasterLiveRoomOpearator.this.hDR);
                                }
                                if (AlaMasterLiveRoomOpearator.this.hDJ != null) {
                                    AlaMasterLiveRoomOpearator.this.hDJ.cbN();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.hDR.findViewById(a.f.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.h.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.hDl.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.cbJ().hxk != null && AlaMasterLiveRoomOpearator.this.hqy != null && AlaMasterLiveRoomOpearator.this.hDR != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.hDR.findViewById(a.f.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.hDR.findViewById(a.f.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.v((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.hDR.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.hqy.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.hqy.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.hqy.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.hqy.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.hDR.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.hDR.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.hDR != null) {
                                AlaMasterLiveRoomOpearator.this.cbJ().hxk.removeView(AlaMasterLiveRoomOpearator.this.hDR);
                            }
                            AlaMasterLiveRoomOpearator.this.cbJ().hxk.addView(AlaMasterLiveRoomOpearator.this.hDR, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.af.a.OJ().bru != null) {
                    i = com.baidu.live.af.a.OJ().bru.aJs;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.hDl.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.cbJ().hxk != null && AlaMasterLiveRoomOpearator.this.hDR != null) {
                            AlaMasterLiveRoomOpearator.this.cbJ().hxk.removeView(AlaMasterLiveRoomOpearator.this.hDR);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bUO() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            x DW = cbJ().hxj.DW();
            if (DW != null) {
                bVar.setAnchorId(DW.mLiveInfo.user_id);
                bVar.setParams();
                bVar.setTag(this.gLW);
                MessageManager.getInstance().sendMessage(bVar);
            }
        }
    }

    public void chn() {
        if (cbJ().pageContext.getPageActivity() instanceof Activity) {
            Activity pageActivity = cbJ().pageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity.isDestroyed() || pageActivity.isFinishing()) {
                    return;
                }
            } else if (pageActivity.isFinishing()) {
                return;
            }
        }
        boolean z = com.baidu.live.d.xf().getBoolean("new_anchor_club_rename", true);
        as civ = cbJ().hxj.civ();
        if (civ != null && this.bfP != null && civ.aLo == 1 && z) {
            cbJ().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
            com.baidu.live.d.xf().putBoolean("new_anchor_club_rename", false);
            View inflate = View.inflate(cbJ().pageContext.getPageActivity(), a.g.dialog_help_guard_club_rename, null);
            this.gVO = new Dialog(cbJ().pageContext.getPageActivity(), a.i.RegimentRenameDiolog);
            final Button button = (Button) inflate.findViewById(a.f.rename_confirm);
            button.setEnabled(false);
            button.setTextColor(cbJ().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
            final EditText editText = (EditText) inflate.findViewById(a.f.guard_club_rename_edittext);
            final TextView textView = (TextView) inflate.findViewById(a.f.hint_num);
            ((Button) inflate.findViewById(a.f.rename_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.64
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.gVk = null;
                    AlaMasterLiveRoomOpearator.this.gVO.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.65
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (editText.getText().toString() != null) {
                        AlaMasterLiveRoomOpearator.this.gVk = editText.getText().toString();
                        if (AlaMasterLiveRoomOpearator.this.bfP != null && AlaMasterLiveRoomOpearator.this.gVk != null) {
                            if (BdNetTypeUtil.isNetWorkAvailable()) {
                                AlaMasterLiveRoomOpearator.this.k(AlaMasterLiveRoomOpearator.this.bfP.id, AlaMasterLiveRoomOpearator.this.gVk, "");
                            } else {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity(), "网络故障，请刷新重试");
                            }
                        } else {
                            return;
                        }
                    }
                    AlaMasterLiveRoomOpearator.this.gVO.dismiss();
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
                        textView.setTextColor(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        textView.setText("0");
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                    }
                    if (obj.length() > 0) {
                        int i4 = 0;
                        int i5 = 0;
                        for (int i6 = 0; i6 < obj.length(); i6++) {
                            String substring = obj.substring(i6, i6 + 1);
                            if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity(), "仅支持中英文及数字");
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
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity(), "不能超过3个字符");
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
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                            } else {
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.cbJ().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                            }
                        }
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gVO.setContentView(inflate);
            this.gVO.setCanceledOnTouchOutside(true);
            inflate.setMinimumHeight((int) (com.baidu.tieba.ala.liveroom.h.f.getScreenHeight(cbJ().pageContext.getPageActivity()) * 0.22f));
            Window window = this.gVO.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (com.baidu.tieba.ala.liveroom.h.f.getScreenWidth(cbJ().pageContext.getPageActivity()) * 0.74f);
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            this.gVO.show();
        }
    }

    public void k(int i, String str, String str2) {
        com.baidu.tieba.ala.liveroom.messages.e eVar = new com.baidu.tieba.ala.liveroom.messages.e();
        eVar.fk(i);
        eVar.Gs(str);
        eVar.Gt(str2);
        eVar.setParams();
        MessageManager.getInstance().sendMessage(eVar);
    }
}
