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
import com.baidu.live.data.aw;
import com.baidu.live.data.ax;
import com.baidu.live.data.bg;
import com.baidu.live.data.bh;
import com.baidu.live.data.bk;
import com.baidu.live.data.bt;
import com.baidu.live.data.v;
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
import com.baidu.live.t.e;
import com.baidu.live.t.f;
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
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
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
import com.baidu.live.v.c;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.g.d;
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
/* loaded from: classes11.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String hGJ;
    private BdUniqueId bEx;
    private boolean bEy;
    private boolean bEz;
    private com.baidu.live.an.a bgE;
    private com.baidu.live.guardclub.a biY;
    private boolean bqD;
    private PendantParentView byA;
    private boolean gQr;
    private String gXU;
    private Dialog gYy;
    private boolean hGK;
    private d hGM;
    private com.baidu.tieba.ala.liveroom.m.a hGN;
    private com.baidu.tieba.ala.liveroom.a.a hGO;
    private com.baidu.tieba.ala.liveroom.t.a hGP;
    private com.baidu.tieba.ala.liveroom.v.a hGQ;
    private b hGR;
    private com.baidu.tieba.ala.liveroom.tippop.a hGS;
    private e hGT;
    private com.baidu.live.t.b hGU;
    private com.baidu.live.t.b hGV;
    private f hGW;
    private com.baidu.live.t.d hGX;
    private c hGY;
    private com.baidu.live.v.b hGZ;
    private boolean hGt;
    private com.baidu.live.ag.a hHA;
    private com.baidu.tieba.ala.liveroom.master.panel.b hHB;
    private com.baidu.live.af.a hHC;
    private ImageView hHD;
    private BdAlertDialog hHE;
    private BdAlertDialog hHF;
    private com.baidu.tieba.ala.liveroom.data.d hHG;
    private short hHQ;
    private com.baidu.tieba.ala.liveroom.g.b hHV;
    private com.baidu.tieba.ala.liveroom.challenge.e hHW;
    private com.baidu.live.al.a hHX;
    private com.baidu.live.b.a hHY;
    private com.baidu.live.guess.b hHZ;
    protected com.baidu.live.m.a hHa;
    protected com.baidu.live.guess.d hHb;
    protected com.baidu.live.am.b hHc;
    private AlaLiveCountDownView hHd;
    private AlaLiveStreamStatusView hHe;
    private RelativeLayout hHf;
    private RelativeLayout hHg;
    private RelativeLayout hHh;
    private RelativeLayout hHi;
    private RelativeLayout hHj;
    private FrameLayout hHk;
    private FrameLayout hHl;
    private View hHm;
    private boolean hHn;
    private AlaLiveFaceVerifyView hHo;
    private ImageView hHp;
    private ImageView hHq;
    private ImageView hHr;
    private ImageView hHs;
    private ImageView hHt;
    private ImageView hHu;
    private ImageView hHv;
    private TextView hHw;
    private ax hHx;
    private com.baidu.live.n.b hHz;
    private boolean hIa;
    private boolean hIc;
    private View hId;
    private FrameLayout hIe;
    private boolean hIf;
    private com.baidu.tieba.ala.liveroom.o.a hIg;
    private String hoC;
    private com.baidu.live.i.a hpD;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hqf;
    private com.baidu.tieba.ala.liveroom.m.a hqg;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hqj;
    private com.baidu.tieba.ala.liveroom.activeview.b hql;
    protected com.baidu.live.ad.a hqs;
    protected ag hrF;
    protected com.baidu.live.l.a hrJ;
    protected com.baidu.live.v.a hrK;
    protected com.baidu.live.t.a hrL;
    protected com.baidu.live.a.a hrM;
    protected com.baidu.live.k.a hrN;
    protected com.baidu.live.t.c hrO;
    private com.baidu.live.aa.a hrT;
    protected com.baidu.live.s.a hrX;
    private com.baidu.live.j.b hrc;
    private com.baidu.tieba.ala.liveroom.share.c hre;
    private com.baidu.tieba.ala.liveroom.q.b hrf;
    private m hrq;
    private k hrr;
    private com.baidu.live.im.b.a hrs;
    private ad hrt;
    private ab hru;
    private boolean hsk;
    private com.baidu.tieba.ala.liveroom.data.e huB;
    private ImageView huI;
    private com.baidu.tieba.ala.liveroom.data.f huJ;
    private boolean hGL = false;
    private boolean hsf = false;
    private Handler mHandler = new Handler();
    private Handler hHy = new Handler();
    private boolean hHH = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver hHI = null;
    private boolean hHJ = false;
    private int hHK = 0;
    private int hHL = 0;
    private int hHM = 0;
    private long hHN = 0;
    private long hHO = 0;
    private volatile boolean isBackground = false;
    private Intent hHP = null;
    private int mOrientation = 1;
    private boolean hBH = false;
    private boolean hHR = false;
    private boolean hHS = true;
    private boolean huG = false;
    private boolean hHT = true;
    private boolean hHU = true;
    private int dLp = 0;
    private String otherParams = "";
    private Handler hIb = new Handler();
    private BdUniqueId gOC = BdUniqueId.gen();
    private boolean mIsKeyboardOpen = false;
    private int bqH = 0;
    private Runnable hIh = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.hpD != null) {
                AlaMasterLiveRoomOpearator.this.hpD.CU();
            }
        }
    };
    private com.baidu.live.al.b bOd = new com.baidu.live.al.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.al.b
        public boolean VD() {
            if (AlaMasterLiveRoomOpearator.this.hHW != null) {
                if (AlaMasterLiveRoomOpearator.this.hrL != null) {
                    if (!AlaMasterLiveRoomOpearator.this.hHW.ccG() && !AlaMasterLiveRoomOpearator.this.hHW.ccH() && !AlaMasterLiveRoomOpearator.this.hrL.Pi() && !AlaMasterLiveRoomOpearator.this.hrL.Aq()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.hHW.ccG() && !AlaMasterLiveRoomOpearator.this.hHW.ccH()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.hrL == null || AlaMasterLiveRoomOpearator.this.hrL.Pi() || AlaMasterLiveRoomOpearator.this.hrL.Aq()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.al.b
        public void VE() {
            if (AlaMasterLiveRoomOpearator.this.hHW != null) {
                AlaMasterLiveRoomOpearator.this.hHW.ccJ();
            }
        }

        @Override // com.baidu.live.al.b
        public void VF() {
            AlaMasterLiveRoomOpearator.this.hIc = true;
            AlaMasterLiveRoomOpearator.this.ccE().hBu.hRi = false;
            if (AlaMasterLiveRoomOpearator.this.hrM != null) {
                AlaMasterLiveRoomOpearator.this.hrM.aW(true);
                AlaMasterLiveRoomOpearator.this.hrM.aX(true);
            }
            AlaMasterLiveRoomOpearator.this.cbZ();
        }

        @Override // com.baidu.live.al.b
        public void VG() {
            AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12.1
                @Override // java.lang.Runnable
                public void run() {
                    AlaMasterLiveRoomOpearator.this.hIc = false;
                    AlaMasterLiveRoomOpearator.this.ccE().hBu.hRi = false;
                    if (AlaMasterLiveRoomOpearator.this.hrM != null) {
                        AlaMasterLiveRoomOpearator.this.hrM.aW(false);
                        AlaMasterLiveRoomOpearator.this.hrM.aX(false);
                    }
                    AlaMasterLiveRoomOpearator.this.cbZ();
                }
            }, 1500L);
        }
    };
    private CustomMessageListener brP = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.huB.hBS != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.huB.hBS.f(list, false);
                }
                for (com.baidu.live.im.data.b bVar : list) {
                    if (bVar != null) {
                        AlaMasterLiveRoomOpearator.this.P(bVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener brQ = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.huB.hBS != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.huB.hBS.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener hsE = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.hrf == null) {
                        AlaMasterLiveRoomOpearator.this.hrf = new com.baidu.tieba.ala.liveroom.q.b();
                    }
                    AlaMasterLiveRoomOpearator.this.hrf.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener hsK = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hrJ != null) {
                AlaMasterLiveRoomOpearator.this.hrJ.Jo();
            }
        }
    };
    private CustomMessageListener hIi = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hsC = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.68
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Hy(str);
            }
        }
    };
    private CustomMessageListener gNf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.69
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.buF();
        }
    };
    private CustomMessageListener hqN = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.hru.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hsI = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity(), a.h.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener hIj = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bgE != null) {
                com.baidu.live.data.ab Fm = AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm();
                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                cVar.url = ((String) customResponsedMessage.getData()) + "?anchor_id=" + ExtraParamsManager.getEncryptionUserId(String.valueOf(Fm.mLiveInfo.user_id)) + "&live_id=" + Fm.mLiveInfo.live_id + "&subapp_type=" + TbConfig.getSubappType();
                cVar.bWs = 0.64f;
                AlaMasterLiveRoomOpearator.this.bgE.a(cVar);
            }
        }
    };
    private CustomMessageListener hIk = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccE().hBu);
            if (AlaMasterLiveRoomOpearator.this.hGM == null || AlaMasterLiveRoomOpearator.this.hGM.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.vQ(0);
            }
            if (AlaMasterLiveRoomOpearator.this.hrr != null) {
                AlaMasterLiveRoomOpearator.this.hrr.Kd().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.hrr.Ke().hide();
            }
        }
    };
    private CustomMessageListener hsJ = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.H(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm());
        }
    };
    private CustomMessageListener hsO = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hrF != null) {
                    ((com.baidu.tieba.ala.liveroom.p.a) AlaMasterLiveRoomOpearator.this.hrF).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener bEA = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.hHV != null) {
                        if (!data.aCk || AlaMasterLiveRoomOpearator.this.bEx == null || !AlaMasterLiveRoomOpearator.this.hIa) {
                            if (AlaMasterLiveRoomOpearator.this.bEx != null && AlaMasterLiveRoomOpearator.this.bEx == data.aCj) {
                                if (data.aCd != null && data.aCd.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.hIa || AlaMasterLiveRoomOpearator.this.hGM.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.hHV.c(AlaMasterLiveRoomOpearator.this.ccE().hBK.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.bEz = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.ccE().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.bEx = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.ccE().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.hHV.a(AlaMasterLiveRoomOpearator.this.ccE().hBK.getVideoConfig(), AlaMasterLiveRoomOpearator.this.bEz);
                        if (!AlaMasterLiveRoomOpearator.this.bEz) {
                            AlaMasterLiveRoomOpearator.this.bEz = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.bEy) {
                    AlaMasterLiveRoomOpearator.this.ccE().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.bEy = false;
            }
        }
    };
    private CustomMessageListener bEB = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.ccE().hBK != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.ccE().hBK.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.d.xc().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener boE = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.bqH == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bqH == 6) {
                            AlaMasterLiveRoomOpearator.this.che();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bqH = 0;
            }
        }
    };
    private View.OnClickListener hIl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.hHq) {
                    AlaMasterLiveRoomOpearator.this.chk();
                    AlaMasterLiveRoomOpearator.this.hHB.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.hHp) {
                    if (view == AlaMasterLiveRoomOpearator.this.hHr) {
                        AlaMasterLiveRoomOpearator.this.buF();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.hHs) {
                        if (view != AlaMasterLiveRoomOpearator.this.hHu) {
                            if (view == AlaMasterLiveRoomOpearator.this.huI) {
                                if (AlaMasterLiveRoomOpearator.this.chd()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.hHW != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.hrL != null) && AlaMasterLiveRoomOpearator.this.hrL.Aq()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.hrL.Pi() & (AlaMasterLiveRoomOpearator.this.hrL != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hHW.ccG()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hHW.ccH()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.hHW.ccI();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hHt) {
                                if (AlaMasterLiveRoomOpearator.this.hGQ != null) {
                                    aw cjo = AlaMasterLiveRoomOpearator.this.ccE().hBt.cjo();
                                    if (cjo == null || cjo.mLiveSdkInfo == null) {
                                        str = null;
                                        str2 = null;
                                    } else {
                                        str2 = String.valueOf(cjo.mLiveSdkInfo.mRoomId);
                                        str = cjo.mLiveSdkInfo.mCastIds != null ? cjo.mLiveSdkInfo.mCastIds.chatMCastId : null;
                                    }
                                    AlaMasterLiveRoomOpearator.this.hGQ.ax("", str2, str);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hHv) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.hHW.ccG() || AlaMasterLiveRoomOpearator.this.hHW.ccH() || AlaMasterLiveRoomOpearator.this.hrL.Pi() || AlaMasterLiveRoomOpearator.this.hrL.Aq()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.hHX != null) {
                                    AlaMasterLiveRoomOpearator.this.hHX.Vx();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.hHC != null) {
                            AlaMasterLiveRoomOpearator.this.hHC.QE();
                            AlaMasterLiveRoomOpearator.this.hHC.cV(AlaMasterLiveRoomOpearator.this.chs());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "beauty"));
                        AlaMasterLiveRoomOpearator.this.hIa = false;
                        AlaMasterLiveRoomOpearator.this.oz(true);
                        AlaMasterLiveRoomOpearator.this.hHw.setVisibility(4);
                        com.baidu.live.d.xc().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bqD) {
                        AlaMasterLiveRoomOpearator.this.che();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bqH = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.che();
                }
            }
        }
    };
    private CustomMessageListener hsD = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ax) {
                    AlaMasterLiveRoomOpearator.this.hsf = true;
                    AlaMasterLiveRoomOpearator.this.hHx = (ax) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.hrr != null) {
                        AlaMasterLiveRoomOpearator.this.hrr.Kd().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.hrr != null) {
                        AlaMasterLiveRoomOpearator.this.hrr.Ke().show();
                        String nameShow = aVar.getNameShow();
                        if (aVar.extInfoJson != null) {
                            if (aVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                                str = aVar.extInfoJson.optString("mysterious_man_nickname");
                                if (TextUtils.isEmpty(str)) {
                                    str = "神秘人";
                                }
                                AlaMasterLiveRoomOpearator.this.hrr.Ke().setEditText(" @" + str + " ");
                            }
                        }
                        str = nameShow;
                        AlaMasterLiveRoomOpearator.this.hrr.Ke().setEditText(" @" + str + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.vQ(8);
                }
            }
        }
    };
    private CustomMessageListener hIm = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.ccE() != null && AlaMasterLiveRoomOpearator.this.ccE().hBQ != null) {
                AlaMasterLiveRoomOpearator.this.ccE().hBQ.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener bCb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.cia();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.ccE().hBt.vX(i);
            }
        }
    };
    private CustomMessageListener hoN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.chT();
        }
    };
    private CustomMessageListener hdK = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.an.c)) {
                if (AlaMasterLiveRoomOpearator.this.bgE == null) {
                    AlaMasterLiveRoomOpearator.this.bgE = new com.baidu.live.an.a(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.bgE.a((com.baidu.live.an.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener hIn = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.Os()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.hHB != null) {
                            AlaMasterLiveRoomOpearator.this.hHB.oF(!alaSetPrivateResponseMessage.isSwitchOpen());
                            AlaMasterLiveRoomOpearator.this.hHB.ciB();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.ccE().hBK.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.hHX != null) {
                        AlaMasterLiveRoomOpearator.this.hHX.setMute(AlaMasterLiveRoomOpearator.this.ccE().hBK.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hHc != null) {
                        AlaMasterLiveRoomOpearator.this.hHc.setMute(AlaMasterLiveRoomOpearator.this.ccE().hBK.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hGS != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.hGS.a(AlaMasterLiveRoomOpearator.this.ccE().hBN, AlaMasterLiveRoomOpearator.this.ccE().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, 5000);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.ccE().pageContext.getString(a.h.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.hGS.wg(2);
                        AlaMasterLiveRoomOpearator.this.hGS.c(AlaMasterLiveRoomOpearator.this.ccE().hBN, string, 3);
                    }
                }
            }
        }
    };
    private e.a hIo = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cih() {
            AlaMasterLiveRoomOpearator.this.vP(a.h.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cii() {
            AlaMasterLiveRoomOpearator.this.vP(a.h.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a hIp = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.liveroom.a.a
        public boolean dF(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void dG(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.ccE().bQY() == 1) {
                AlaMasterLiveRoomOpearator.this.ccE().hBK.stopRecord();
            }
        }
    };
    private IShareCallback hIq = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.hHH && AlaMasterLiveRoomOpearator.this.hHG != null) {
                AlaMasterLiveRoomOpearator.this.hHH = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.hHG);
            }
        }
    };
    private View.OnTouchListener hIr = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.ccE().hBQ.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccE().hBu);
            AlaMasterLiveRoomOpearator.this.vQ(0);
            if (AlaMasterLiveRoomOpearator.this.hrr != null) {
                AlaMasterLiveRoomOpearator.this.hrr.Kd().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.hrr.Ke().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b hIs = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cij() {
            AlaMasterLiveRoomOpearator.this.chf();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cik() {
            AlaMasterLiveRoomOpearator.this.hGt = AlaMasterLiveRoomOpearator.this.hGM.ces();
            AlaMasterLiveRoomOpearator.this.ccE().hBQ.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.ccE().hBQ.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.ccE().hBQ.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.hBE = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.ccE().bQY();
            dVar.title = AlaMasterLiveRoomOpearator.this.hGM.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hBF = AlaMasterLiveRoomOpearator.this.hGM.cet();
            dVar.hBI = AlaMasterLiveRoomOpearator.this.hGt;
            dVar.hBH = AlaMasterLiveRoomOpearator.this.hGM.ceq();
            dVar.hBG = AlaMasterLiveRoomOpearator.this.hGM.cev();
            dVar.hBJ = AlaMasterLiveRoomOpearator.this.hGM.cer();
            if (dVar.hBJ) {
                if (AlaMasterLiveRoomOpearator.this.hGM.cew()) {
                    AlaMasterLiveRoomOpearator.this.hHH = true;
                    AlaMasterLiveRoomOpearator.this.hHG = dVar;
                    AlaMasterLiveRoomOpearator.this.hGM.cex();
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
            AlaMasterLiveRoomOpearator.this.ccE().pageContext.showToast(a.h.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.ccE().g((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cil() {
            AlaMasterLiveRoomOpearator.this.hIa = true;
            AlaMasterLiveRoomOpearator.this.oz(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean cim() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cin() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private CustomMessageListener blY = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.cau();
            }
        }
    };
    private com.baidu.live.liveroom.g.c hIt = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void Nd() {
            if (AlaMasterLiveRoomOpearator.this.hGQ != null) {
                AlaMasterLiveRoomOpearator.this.hGQ.oS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.hHC != null) {
                        AlaMasterLiveRoomOpearator.this.hHC.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hHC != null) {
                    AlaMasterLiveRoomOpearator.this.hHC.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.hGQ != null) {
                    AlaMasterLiveRoomOpearator.this.hGQ.oS(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.hrF != null) {
                    AlaMasterLiveRoomOpearator.this.hrF.bD(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a hIu = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void cit() {
            if (AlaMasterLiveRoomOpearator.this.hHo != null && AlaMasterLiveRoomOpearator.this.ccE().hBN.indexOfChild(AlaMasterLiveRoomOpearator.this.hHo) >= 0) {
                AlaMasterLiveRoomOpearator.this.ccE().hBN.removeView(AlaMasterLiveRoomOpearator.this.hHo);
                AlaMasterLiveRoomOpearator.this.hHo.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.hHo = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hqR = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void v(View view, int i) {
            com.baidu.live.data.ab Fm;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.chZ();
            } else if (i == 14 && (Fm = AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm()) != null && Fm.aId != null && Fm.mLiveInfo != null && Fm.aIz != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity(), Fm.aId.userName, Long.toString(Fm.aId.userId), Long.toString(Fm.aId.charmCount), String.valueOf(Fm.mLiveInfo.group_id), String.valueOf(Fm.mLiveInfo.live_id), true, String.valueOf(Fm.aId.userId), Long.toString(Fm.aIz.userId), Fm.aIz.userName, Fm.aIz.portrait, AlaMasterLiveRoomOpearator.this.hqj.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Fm.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.hqj.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a hIv = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
    };
    private g hIw = new g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };
    private Runnable hIx = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        @Override // java.lang.Runnable
        public void run() {
            AlaMasterLiveRoomOpearator.this.cig();
        }
    };
    private HttpMessageListener gXw = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == AlaMasterLiveRoomOpearator.this.gOC && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.biY != null) {
                AlaMasterLiveRoomOpearator.this.biY = guardClubInfoHttpResponseMessage.biY;
            }
        }
    };
    HttpMessageListener gXO = new HttpMessageListener(1021231) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).biY;
                if (aVar == null || AlaMasterLiveRoomOpearator.this.biY == null || AlaMasterLiveRoomOpearator.this.biY.id != aVar.id) {
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
    private ViewTreeObserver.OnGlobalLayoutListener globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.67
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity());
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity());
            if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = true;
                TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                Window window = AlaMasterLiveRoomOpearator.this.gYy.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.x = 0;
                attributes.y = 50;
                window.setAttributes(attributes);
            } else if (screenFullSize[1] - rect.height() <= statusBarHeight && AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = false;
                Window window2 = AlaMasterLiveRoomOpearator.this.gYy.getWindow();
                WindowManager.LayoutParams attributes2 = window2.getAttributes();
                attributes2.gravity = 17;
                attributes2.x = 0;
                attributes2.y = 0;
                window2.setAttributes(attributes2);
            }
        }
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.b.avS);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        hGJ = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    private void HR(String str) {
        if (!TextUtils.isEmpty(str) && this.hHz != null) {
            View KY = this.hHz.KY();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            KY.setLayoutParams(layoutParams);
            if (ccE().hBu.indexOfChild(KY) >= 0) {
                ccE().hBu.removeView(KY);
            }
            ccE().hBu.addView(KY);
            this.hHz.hg(str);
            KY.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.baidu.live.data.ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && com.baidu.live.ae.a.Qj().buX != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(ccE().pageContext.getPageActivity(), String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.mLiveInfo.user_id), com.baidu.live.ae.a.Qj().buX.aNa, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccE().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(ccE().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.Qj().buX.aMs;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? ccE().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt) : ccE().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(ccE().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cau() {
        int i = ccE().hBt.Fm().aId.isUegBlock;
        int i2 = ccE().hBt.Fm().aId.isBlock;
        String str = ccE().hBt.Fm().aId.userName;
        if (i > 0 || i2 > 0) {
            this.bqD = true;
            this.hrr.a(true, i, i2, str);
            return;
        }
        this.bqD = false;
        this.hrr.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.huB.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpt == 1) {
                format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpu);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.huB.pageContext.getPageActivity());
            bdAlertDialog.setMessage(format);
            bdAlertDialog.setPositiveButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
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
            bdAlertDialog.setNegativeButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
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
            bdAlertDialog.create(this.huB.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chd() {
        if (this.hHX != null && this.hHX.Vy()) {
            BdUtilHelper.showToast(this.huB.pageContext.getPageActivity(), this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else if (this.hHc != null && this.hHc.Rm()) {
            BdUtilHelper.showToast(this.huB.pageContext.getPageActivity(), this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void che() {
        if (this.hrr != null) {
            this.hrr.Ke().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.hHW != null) {
            this.hHW.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chf() {
        if (ccE() != null && ccE().hBt != null) {
            ccE().hBt.cjh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bTl() != null && aVar.bTm() != null) {
            ccE().hBt.ey(aVar.bTl().getId(), aVar.bTm().getId());
        }
    }

    public void b(short s) {
        if (this.hHV != null) {
            this.hHV.b(s);
        }
    }

    /* loaded from: classes11.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.hHJ = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.hHJ = false;
                }
                if (AlaMasterLiveRoomOpearator.this.hHK == 0) {
                    AlaMasterLiveRoomOpearator.this.hHK = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.hHL == 0) {
                    AlaMasterLiveRoomOpearator.this.hHL = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.hHM = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (ccE() != null && ccE().hBO != null) {
            ccE().hBO.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.e eVar, String str) {
        this.huB = eVar;
        this.hoC = str;
        this.hIg = new com.baidu.tieba.ala.liveroom.o.a(eVar.pageContext.getPageActivity());
    }

    protected com.baidu.tieba.ala.liveroom.data.e ccE() {
        return this.huB;
    }

    public int a(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.huJ = fVar;
        this.hHI = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.hHI, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.hGS == null) {
            this.hGS = new com.baidu.tieba.ala.liveroom.tippop.a(this.huB.pageContext, null);
        }
        registerListener();
        this.hpD = new com.baidu.live.i.a();
        chB();
        chg();
        chj();
        Long[] lArr = new Long[1];
        this.hHN = lArr[0] == null ? 0L : lArr[0].longValue();
        this.hHO = lArr[0] != null ? lArr[0].longValue() : 0L;
        ccE().hBu.setOnTouchListener(this.hIr);
        this.hGK = SharedPrefHelper.getInstance().getBoolean(hGJ, false);
        this.hHd = new AlaLiveCountDownView(ccE().pageContext.getPageActivity());
        this.hHd.setCount(3);
        this.hHd.setTextColor(ccE().pageContext.getPageActivity().getResources().getColor(a.c.sdk_white_alpha60));
        this.hHd.setTextSize(ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128));
        this.hHd.setTypeface(Typeface.DEFAULT_BOLD);
        this.hHd.setIncludeFontPadding(false);
        this.hHd.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void cio() {
                if (AlaMasterLiveRoomOpearator.this.ccE().hBu != null) {
                    AlaMasterLiveRoomOpearator.this.ccE().hBu.removeView(AlaMasterLiveRoomOpearator.this.hHd);
                }
            }
        });
        return 1;
    }

    private void chg() {
        CustomResponsedMessage runTask;
        if (this.hHa == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.m.a.class, ccE().pageContext)) != null && runTask.getData() != null) {
            this.hHa = (com.baidu.live.m.a) runTask.getData();
            this.hHa.c(ccE().pageContext);
        }
    }

    private void chh() {
        CustomResponsedMessage runTask;
        if (this.hHb == null && (runTask = MessageManager.getInstance().runTask(2913298, com.baidu.live.guess.d.class, ccE().pageContext)) != null && runTask.getData() != null) {
            this.hHb = (com.baidu.live.guess.d) runTask.getData();
            this.hHb.register();
        }
    }

    private void chi() {
        CustomResponsedMessage runTask;
        if (chp() && this.hHc == null && (runTask = MessageManager.getInstance().runTask(2913254, com.baidu.live.am.b.class, ccE().pageContext)) != null && runTask.getData() != null) {
            this.hHc = (com.baidu.live.am.b) runTask.getData();
            if (ccE() != null && ccE().hBt != null && ccE().hBt.Fm() != null) {
                this.hHc.setLiveShowData(ccE().hBt.Fm());
            }
            if (ccE() != null && ccE().hBK != null) {
                this.hHc.H(ccE().hBK);
                this.hHc.setMute(ccE().hBK.isMute());
            }
            if (this.hHc != null && this.hHl != null) {
                this.hHc.a(new com.baidu.live.am.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
                    @Override // com.baidu.live.am.a
                    public boolean Ro() {
                        if ((AlaMasterLiveRoomOpearator.this.hrL != null) && AlaMasterLiveRoomOpearator.this.hrL.Aq()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                            return false;
                        }
                        if ((AlaMasterLiveRoomOpearator.this.hrL != null) & AlaMasterLiveRoomOpearator.this.hrL.Pi()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                            return false;
                        } else if (AlaMasterLiveRoomOpearator.this.hHW == null || !AlaMasterLiveRoomOpearator.this.hHW.ccG()) {
                            if (AlaMasterLiveRoomOpearator.this.hHW == null || !AlaMasterLiveRoomOpearator.this.hHW.ccH()) {
                                return true;
                            }
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        } else {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        }
                    }
                });
                View enterView = this.hHc.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hHl.setVisibility(0);
                    this.hHl.addView(enterView);
                }
            }
            if (this.hHc != null) {
                this.hHc.Y(ccE().hBL);
            }
            if (this.hHc != null && ccE().hBM != null) {
                this.hHc.a(ccE().hBM);
            }
        }
    }

    private void chj() {
        View rootLayout;
        if (this.hHa != null && this.hHk != null && (rootLayout = this.hHa.cB(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hHk.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chk() {
        if (this.hHB == null) {
            this.hHB = new com.baidu.tieba.ala.liveroom.master.panel.b(ccE().pageContext.getPageActivity(), ccE().bQY() == 2);
            this.hHB.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oB(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccE().hBK.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oC(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccE().hBK.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oD(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccE().hBK.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.chY();
                    if (AlaMasterLiveRoomOpearator.this.hGS != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.hGS.c(AlaMasterLiveRoomOpearator.this.ccE().hBN, AlaMasterLiveRoomOpearator.this.ccE().pageContext.getString(a.h.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.hGS.c(AlaMasterLiveRoomOpearator.this.ccE().hBN, AlaMasterLiveRoomOpearator.this.ccE().pageContext.getString(a.h.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oE(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.g(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void cip() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.ccE().hBt != null && AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm() != null && AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hHB != null) {
                        AlaMasterLiveRoomOpearator.this.hHB.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.a(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciq() {
                    if (AlaMasterLiveRoomOpearator.this.hHB != null) {
                        AlaMasterLiveRoomOpearator.this.hHB.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new i(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void cir() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.ccE() != null && AlaMasterLiveRoomOpearator.this.ccE().hBt != null && AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm() != null && AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(AlaMasterLiveRoomOpearator.this.ccE().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.hHB != null) {
                            AlaMasterLiveRoomOpearator.this.hHB.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void cis() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.ccE() == null || AlaMasterLiveRoomOpearator.this.ccE().hBt == null || AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm() == null || AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.ccE() != null && AlaMasterLiveRoomOpearator.this.ccE().hBt != null && AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm() != null && AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.hHB != null) {
                                        AlaMasterLiveRoomOpearator.this.hHB.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.huB.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.hHB != null) {
                        AlaMasterLiveRoomOpearator.this.hHB.dismiss();
                    }
                }
            });
        }
        chl();
    }

    private void chl() {
        if (this.hHB != null) {
            boolean isBackCamera = ccE().hBK.isBackCamera();
            this.hHB.setIsBackCamera(ccE().hBK.isBackCamera());
            this.hHB.S(ccE().hBK.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = ccE().hBK.isPushMirror();
            if (this.hHS) {
                isPushMirror = chX() || isPushMirror;
                this.hHS = false;
            }
            this.hHB.T(isPushMirror, isBackCamera ? false : true);
            this.hHB.oF(ccE().hBK.isMute());
            this.hHB.ciB();
        }
    }

    public void chm() {
        if (this.huJ != null) {
            if (this.huJ.hBT == null || this.huJ.hBT.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.hHm == null) {
                        this.hHm = this.huB.hBS.MD();
                        this.huB.hBN.addView(this.hHm, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.hGM == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (ccE().hBt != null && ccE().hBt.Fm() != null && ccE().hBt.Fm().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", ccE().hBt.Fm().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", ccE().hBt.Fm().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.hGM = new d(ccE().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    ccE().hBQ.prepareTime = System.currentTimeMillis();
                    ccE().hBN.addView(this.hGM.getView(), layoutParams);
                    this.hGM.a(this.hIq);
                }
                this.hGM.oi(this.hBH);
                this.hGM.a(this.hIs);
                this.hGM.a(this.hIo);
                this.hGM.a(ccE().hBK, ccE().bQY());
                this.hGM.a(this.hHa);
                return;
            }
            this.hGt = this.huJ.hBT.mLiveInfo.screen_direction == 2;
            if (this.huJ.hBT.mLiveInfo.isAudioOnPrivate == 1) {
                ccE().hBK.setMute(true);
                if (this.hHX != null) {
                    this.hHX.setMute(ccE().hBK.isMute());
                }
                if (this.hHc != null) {
                    this.hHc.setMute(ccE().hBK.isMute());
                }
                if (this.hGS == null) {
                    this.hGS = new com.baidu.tieba.ala.liveroom.tippop.a(this.huB.pageContext, null);
                }
                if (!this.hGS.wf(2)) {
                    this.hGS.a(ccE().hBN, ccE().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, 5000);
                }
            }
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.hBE = true;
            dVar.forumId = String.valueOf(this.huJ.hBT.mLiveInfo.forum_id);
            dVar.forumName = this.huJ.hBT.mLiveInfo.forum_name;
            dVar.liveType = this.huJ.hBT.mLiveInfo.live_type;
            dVar.title = this.huJ.hBT.mLiveInfo.getLiveTitle();
            dVar.clarity = this.huJ.hBT.mLiveInfo.clarity;
            dVar.gameId = this.huJ.hBT.mLiveInfo.game_id;
            dVar.gameName = this.huJ.hBT.mLiveInfo.game_label;
            dVar.hBI = this.huJ.hBT.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void chn() {
        if (this.hHV != null) {
            this.hHV.a(ccE().hBK.getVideoConfig(), false);
        }
        if (this.hGM != null) {
            this.hGM.oh(true);
        }
        if (ccE().hBK.hasBeauty() >= 0) {
            ccE().hBK.setBeauty(com.baidu.live.d.xc().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            ccE().hBS.E(this.huB.hBK);
        } else if (this.hGM != null) {
            this.hGM.oh(true);
        }
        chA();
    }

    public void d(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.hHm != null && this.hHm.getParent() != null) {
                ((ViewGroup) this.hHm.getParent()).removeView(this.hHm);
                this.hHm = null;
            }
            ccE().hBu.setVisibility(0);
            this.huB.hBS.a(ccE().hBu);
        } else {
            chI();
            chW();
            if (this.hIe != null) {
                this.hIe.setVisibility(0);
            }
            this.hGQ = new com.baidu.tieba.ala.liveroom.v.a(ccE().pageContext, this.hIp);
            this.hGQ.c(ccE().hBu, true);
            this.hGQ.oS(true);
            if (this.hrr != null && this.hrr.Kd() != null) {
                this.hrr.Kd().setNeedTopAlphaShade(true);
            }
        }
        ccE().hBK.setPushMirror(chX());
    }

    public void b(aw awVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.huB.hBS.l(ccE().hBt.Fm());
        }
        if (!ccE().hBK.isBackground() && ccE().hBt.Fm() != null && ccE().hBt.Fm().mLiveInfo != null) {
            int startPush = ccE().hBK.startPush(ccE().hBt.Fm().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.huB.hBS.ME();
            }
            if (startPush != 0 && ccE().hBQ != null) {
                ccE().hBQ.errCode = 4;
                ccE().hBQ.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (awVar != null && !awVar.Cu() && !chU()) {
                oA(true);
                chV();
            }
            if (this.hqg != null) {
                this.hqg.N(ccE().hBt.Fm());
            }
            if (this.hrc != null) {
                this.hrc.a(ccE().hBt.Fm());
            }
            if (this.hHa != null) {
                this.hHa.h(ccE().hBt.Fm());
                this.hHa.hj(this.otherParams);
            }
            if (this.hqg != null) {
                this.hqg.ou(true);
            }
            if (this.hGN != null) {
                this.hGN.N(ccE().hBt.Fm());
            }
            if (awVar == null || awVar.aId == null) {
                z = com.baidu.live.d.xc().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = awVar.aId.canUseChallenge;
                com.baidu.live.d.xc().putBoolean("ala_master_can_use_challenge", z);
            }
            cbr();
            chJ();
            cht();
            oy(z);
            cae();
            chK();
            chQ();
            O(ccE().hBt.Fm());
            f(ccE().hBt.Fm());
            chR();
            cho();
            chN();
            cbm();
            cad();
            cbo();
            cac();
            chO();
            cbh();
            cbi();
            chG();
            chH();
            P(ccE().hBt.Fm());
            chP();
            cbl();
            caY();
            Q(ccE().hBt.Fm());
            chh();
            MessageManager.getInstance().registerListener(this.gXw);
            MessageManager.getInstance().registerListener(this.gXO);
            aw cjo = ccE().hBt.cjo();
            if (cjo != null && cjo.aOk == 1) {
                bVt();
                this.hIb.postDelayed(this.hIx, IMConnection.RETRY_DELAY_TIMES);
            }
            if (this.hrq != null) {
                this.hrq.g(ccE().hBt.Fm());
            }
            if (this.hrr != null) {
                if (ccE().hBt.Fm() != null && ccE().hBt.Fm().aIR != null && ccE().hBt.Fm().aIR.Bf()) {
                    z2 = true;
                }
                this.hrr.a(String.valueOf(ccE().hBt.Fm().mLiveInfo.group_id), String.valueOf(ccE().hBt.Fm().mLiveInfo.last_msg_id), String.valueOf(ccE().hBt.Fm().aId.userId), String.valueOf(ccE().hBt.Fm().mLiveInfo.live_id), ccE().hBt.Fm().aId.appId, z2, ccE().hBt.Fm().getGuardName());
            }
            if (this.hrs != null) {
                this.hrs.a(ccE().hBt.Fm(), true);
            }
            chq();
            chi();
            cbv();
            this.mHandler.post(this.hIh);
            if (this.hIg != null && !this.hIg.hKL) {
                this.hIg.cjF();
            }
        }
    }

    protected void cbv() {
        if (this.hrX == null && ccE() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.s.a.class, ccE().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hrX = (com.baidu.live.s.a) runTask.getData();
                this.hrX.p(ccE().hBu);
            }
        }
    }

    private void cho() {
        if (this.hGO != null && ccE() != null && ccE().hBt != null) {
            if (this.hGO.aG(this.hHh)) {
                this.hGO.C(ccE().hBt.Fm());
            } else {
                this.hGO.d(this.hHh, ccE().hBt.Fm());
            }
        }
    }

    private void cae() {
        if (this.byA == null) {
            this.byA = new PendantParentView(ccE().pageContext.getPageActivity(), cca());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            ccE().hBu.addView(this.byA, layoutParams);
            this.byA.setDefaultItemMargin(ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.byA.setPadding(ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            cbZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbZ() {
        if (this.byA != null) {
            int dimensionPixelSize = ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278);
            int dimensionPixelSize2 = ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.byA.getLayoutParams();
            if (this.gQr) {
                this.byA.setPosition(0, 0, this.hHW.ccl(), dimensionPixelSize2);
            } else {
                this.byA.setPosition(dimensionPixelSize, 0, ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds380), dimensionPixelSize2);
            }
            this.byA.setLayoutParams(layoutParams);
            this.byA.setModel(cca());
        }
    }

    private PendantParentView.Model cca() {
        if (this.gQr) {
            return PendantParentView.Model.VERTICAL_PK;
        }
        if (this.hIc) {
            return PendantParentView.Model.VERTICAL_BB_CHATING;
        }
        return PendantParentView.Model.VERTICAL;
    }

    private void ccb() {
        if (this.hrr != null && this.hrr.Kd() != null && this.hrr.Kd().getView() != null) {
            if (this.gQr && !this.hGL && ccE().hBu != null && ccE().hBu.getHeight() > 0) {
                int bp = this.hHW != null ? this.hHW.bp(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.hrr.Kd().getView().getLayoutParams();
                int height = ccE().hBu.getHeight() - bp;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.hrr.Kd().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int j = com.baidu.live.aj.c.j(false, this.hGL);
            if (ccE().hBu.indexOfChild(this.hrr.Kd().getView()) != -1 && this.hrr.Kd().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrr.Kd().getView().getLayoutParams();
                layoutParams2.height = j;
                this.hrr.Kd().getView().setLayoutParams(layoutParams2);
            }
            this.hrr.Kd().Kc();
        }
    }

    private void ccc() {
        if (this.hrt != null) {
            if (this.gQr && !this.hGL && ccE().hBu != null && ccE().hBu.getHeight() > 0) {
                this.hrt.cH((ccE().hBu.getHeight() - (this.hHW != null ? h.p(ccE().pageContext.getPageActivity(), true) : 0)) + ccE().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height));
            } else {
                this.hrt.cH(com.baidu.live.aj.a.b(ccE().pageContext.getPageActivity(), true, false, this.hGL));
            }
        }
    }

    private void ccd() {
        int i;
        if (this.hrt != null) {
            int i2 = com.baidu.live.aj.a.i(true, false);
            if (!this.gQr || ccE().hBu == null || ccE().hBu.getHeight() <= 0) {
                i = i2;
            } else {
                i = (ccE().hBu.getHeight() - (this.hHW != null ? this.hHW.bp(false) : 0)) + ccE().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
            }
            this.hrt.cI(i);
        }
    }

    private void cce() {
        if (this.hrs != null && this.hrs.zP() != null) {
            ViewGroup.LayoutParams layoutParams = this.hrs.zP().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ccE().pageContext.getResources().getDimensionPixelOffset(this.gQr ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hrs.zP().setLayoutParams(layoutParams);
            }
        }
    }

    private boolean chp() {
        AlaVideoBCChatData alaVideoBCChatData;
        AlaLiveInfoData alaLiveInfoData = ccE().hBt.Fm().mLiveInfo;
        if (alaLiveInfoData == null || (alaVideoBCChatData = alaLiveInfoData.videoBCEnterData) == null) {
            return false;
        }
        return alaVideoBCChatData.isShowEnter();
    }

    private void chq() {
        if (this.hHc == null && !chp()) {
            boolean z = (ccE().hBt == null || ccE().hBt.cjo() == null || ccE().hBt.cjo().mLiveInfo.videoBBChatData == null || !ccE().hBt.cjo().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
            if (!z && ccE().hBt != null && ccE().hBt.Fm() != null && ccE().hBt.Fm().mLiveInfo != null && ccE().hBt.Fm().mLiveInfo.videoBBChatData != null && ccE().hBt.Fm().aIN) {
                z = ccE().hBt.Fm().mLiveInfo.videoBBChatData.videoBBChatSwitch;
            }
            if (this.hHv != null) {
                this.hHv.setVisibility(z ? 0 : 8);
            }
            chr();
        }
    }

    private void chr() {
        CustomResponsedMessage runTask;
        if (this.hHX == null && (runTask = MessageManager.getInstance().runTask(2913249, com.baidu.live.al.a.class, ccE().pageContext)) != null && runTask.getData() != null) {
            this.hHX = (com.baidu.live.al.a) runTask.getData();
        }
        if (this.hHX != null) {
            this.hHX.w((ViewGroup) ccE().rootView.findViewById(a.f.ala_live_video_chat_pendant));
            this.hHX.v(ccE().hBN);
            this.hHX.t(ccE().hBt.Fm());
            this.hHX.H(ccE().hBK);
            this.hHX.a(ccE().hBM);
            this.hHX.a(this.bOd);
            if (ccE().hBK != null) {
                this.hHX.setMute(ccE().hBK.isMute());
            }
        }
    }

    private void oy(boolean z) {
        if (this.hHW == null) {
            this.hHW = new com.baidu.tieba.ala.liveroom.challenge.e(ccE());
        }
        this.hHW.a(this.huI, this.huJ, z);
        this.hHW.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(bg bgVar, bk bkVar, bk bkVar2) {
                AlaMasterLiveRoomOpearator.this.gQr = true;
                AlaMasterLiveRoomOpearator.this.ccE().hBu.hRi = false;
                if (AlaMasterLiveRoomOpearator.this.hHC != null) {
                    AlaMasterLiveRoomOpearator.this.hHC.dY(4);
                    AlaMasterLiveRoomOpearator.this.hHC.cV(true);
                }
                AlaMasterLiveRoomOpearator.this.Xe();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void Aw() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hIh);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void ccC() {
                AlaMasterLiveRoomOpearator.this.gQr = false;
                AlaMasterLiveRoomOpearator.this.ccE().hBu.hRi = false;
                if (AlaMasterLiveRoomOpearator.this.hHC != null) {
                    AlaMasterLiveRoomOpearator.this.hHC.dY(0);
                    AlaMasterLiveRoomOpearator.this.hHC.cV(false);
                }
                AlaMasterLiveRoomOpearator.this.cck();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void ccD() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hIh);
            }
        });
        this.hHW.P(this.hGt, z);
        this.hHW.k(this.hGt, z, (this.huJ == null || this.huJ.hBT == null || this.huJ.hBT.mChallengeData == null) ? false : true);
    }

    public boolean chs() {
        return this.hHW != null && this.hHW.ccL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xe() {
        if (this.hGR != null) {
            this.hGR.setVisible(8);
            this.hGR.setCanVisible(false);
        }
        if (this.hHY != null) {
            this.hHY.setCanVisible(false);
            this.hHY.refreshUI();
        }
        if (this.hGO != null) {
            this.hGO.setVisibility(8);
        }
        if (this.hql != null) {
            this.hql.aW(true);
        }
        if (this.hHe != null) {
            this.hHe.setCanVisible(false);
            this.hHe.setVisibility(8);
        }
        if (this.hGQ != null) {
            this.hHn = this.hGQ.clL();
            this.hGQ.oR(false);
        }
        if (this.hrL != null) {
            this.hrL.setCanVisible(false);
        }
        if (this.hrM != null) {
            this.hrM.aW(true);
            this.hrM.aX(true);
        }
        cbZ();
        ccb();
        ccc();
        ccd();
        cce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cck() {
        if (this.hGR != null) {
            this.hGR.setCanVisible(true);
        }
        if (this.hHY != null) {
            this.hHY.setCanVisible(true);
            this.hHY.refreshUI();
        }
        if (this.hGO != null) {
            this.hGO.setVisibility(0);
        }
        if (this.hql != null) {
            this.hql.aW(false);
        }
        if (this.hHe != null) {
            this.hHe.setCanVisible(true);
            if (this.hHe.cli()) {
                this.hHe.setVisibility(0);
            }
        }
        if (this.hGQ != null) {
            this.hGQ.oR(this.hHn);
        }
        if (this.hrL != null) {
            this.hrL.setCanVisible(true);
        }
        if (this.hrM != null) {
            this.hrM.aW(false);
            this.hrM.aX(false);
        }
        cbZ();
        ccb();
        ccc();
        ccd();
        cce();
    }

    private void cht() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.leftMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        if (this.hHe == null) {
            this.hHe = new AlaLiveStreamStatusView(ccE().pageContext.getPageActivity());
            this.hHe.setVisibility(8);
        }
        this.hHe.setId(a.f.ala_live_room_stream_view);
        this.hHe.setLayoutParams(layoutParams);
        if (this.hHe.getParent() == null && this.hHh != null) {
            this.hHh.addView(this.hHe, layoutParams);
        }
    }

    public void chu() {
        if (this.hGM != null && this.hGM.getVisibility() != 8 && ccE().hBK.getPreview() != null) {
            ccE().hBK.stopRecord();
        }
    }

    public void chv() {
        if (ccE().hBK.getPreview() != null) {
            ccE().hBK.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hHV != null) {
                this.hHV.og(false);
            }
            this.hHV = new com.baidu.tieba.ala.liveroom.g.b(ccE().hBN, ccE(), ccE().hBK);
            this.hHV.a(ccE().hBK.getVideoConfig(), false);
        }
        if (this.hGS != null) {
            this.hGS.ckF();
        }
        this.mHandler.post(this.hIh);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.hGL = z;
        if (z) {
            if (this.hHU) {
                this.hHU = false;
                if (this.hrr != null && this.hrr.Kd() != null) {
                    this.hrr.Kd().getView().setBottom(0);
                }
                if (this.hrr != null && this.hrr.Ke() != null) {
                    this.hrr.Ke().getView().setBottom(0);
                }
            }
            if (this.hrt != null && this.hrt.EJ() != null) {
                this.hrt.EJ().setVisibility(8);
            }
            if (this.hrr != null && this.hrr.Kd() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrr.Kd().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132);
                this.hrr.Kd().getView().setLayoutParams(layoutParams);
            }
            if (this.hrr != null && this.hrr.Ke() != null && this.hrr.Ke().getView() != null && this.hrr.Ke().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrr.Ke().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.hrr.Ke().getView().setLayoutParams(layoutParams2);
                this.hrr.Ke().getView().setVisibility(0);
                this.hrr.Ke().Mg();
            }
            vQ(8);
            vO(8);
            if (this.hru != null && this.hru.Fl() != null) {
                this.hru.Fl().setVisibility(8);
            }
            if (this.hrM != null) {
                this.hrM.setCanVisible(false);
            }
        } else {
            if (this.hrt != null && this.hrt.EJ() != null) {
                this.hrt.EJ().setVisibility(0);
            }
            if (this.hrr != null && this.hrr.Kd() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hrr.Kd().getView().getLayoutParams();
                layoutParams3.bottomMargin = ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132) - ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.hrr.Kd().getView().setLayoutParams(layoutParams3);
            }
            if (this.hrr != null && this.hrr.Ke() != null) {
                this.hrr.Ke().hide();
            }
            vQ(0);
            vO(0);
            if (this.hru != null && this.hru.Fl() != null) {
                this.hru.Fl().setVisibility(0);
            }
            if (this.hHz != null && this.hHz.KY() != null) {
                this.hHz.KY().setVisibility(0);
            }
            if (this.hrM != null) {
                this.hrM.setCanVisible(true);
            }
        }
        if (this.hGM != null) {
            this.hGM.R(false, z);
        }
        if (this.hrs != null) {
            this.hrs.zQ();
        }
        if (this.hHC != null) {
            this.hHC.onKeyboardVisibilityChanged(z);
        }
        if (this.hrX != null) {
            this.hrX.onKeyboardVisibilityChanged(z);
        }
        if (this.hHX != null) {
            this.hHX.onKeyboardVisibilityChanged(z);
        }
        ccb();
        this.mHandler.post(this.hIh);
    }

    private void vO(int i) {
        if (this.hqg != null) {
            this.hqg.vC(i);
        }
        if (this.hHg != null) {
            this.hHg.setVisibility(i);
        }
        if (this.hrc != null) {
            this.hrc.getView().setVisibility(i);
        }
        if (this.hGP != null) {
            this.hGP.setVisible(i);
        }
        if (this.hGO != null) {
            this.hGO.setVisibility(i);
        }
        if (this.hql != null) {
            this.hql.setVisible(i);
        }
        if (this.hrT != null) {
            this.hrT.setCanVisible(i == 0);
        }
        if (this.hrO != null) {
            this.hrO.setVisible(i);
        }
        if (this.hrJ != null) {
            this.hrJ.setCanVisible(i == 0);
        }
        if (this.hrL != null) {
            this.hrL.setCanVisible(i == 0 && !this.gQr);
        }
        if (this.hqs != null) {
            this.hqs.cT(i == 0);
        }
        if (this.hHY != null) {
            this.hHY.setCanVisible(i == 0);
            this.hHY.refreshUI();
        }
        if (this.hHh != null) {
            this.hHh.setVisibility(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            ccE().hBQ.errCode = 1;
            vP(a.h.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            vP(a.h.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            vP(a.h.stream_upload_exception);
        } else if (i == -2) {
            HS(ccE().pageContext.getResources().getString(a.h.preview_init_failed_dialog_msg));
            ccE().hBK.stopRecord();
        } else if (i == -3 && this.hGM != null) {
            this.hGM.oh(false);
        }
        if (i == -4) {
            if (this.hGM == null || this.hGM.getView().getParent() == null) {
                ccE().g((short) 1);
                return;
            }
            this.hGM.ceu();
            this.hHs.setVisibility(0);
            if (this.hGQ != null) {
                this.hGQ.oS(true);
            }
            ccE().hBu.setBackgroundColor(ccE().pageContext.getResources().getColor(17170445));
            cid();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        awo();
        if (i == 12001) {
            if (i2 == -1) {
                HT(P(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            buF();
        }
    }

    public void onResume() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.hGM == null || this.hGM.getView().getParent() == null || this.hGM.getVisibility() != 0 ? "live" : "action");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_ACTION, "").setContentExt(jSONObject));
        if (this.hGM != null) {
            this.hGM.onResume();
        }
        if (this.hHH && this.hHG != null) {
            this.hHH = false;
            c(this.hHG);
        }
        if (this.hrF != null) {
            this.hrF.onResume();
        }
    }

    public void h(short s) {
        if (this.hrq != null) {
            this.hrq.Fy();
        }
        if (this.hrr != null) {
            this.hrr.a(null);
            this.hrr.zR();
        }
        if (this.hrs != null) {
            this.hrs.zR();
        }
        if (this.hHW != null) {
            this.hHW.ccK();
        }
        if (this.hHZ != null) {
            this.hHZ.IZ();
        }
        if (this.hHb != null) {
            this.hHb.unRegister();
        }
    }

    public boolean chw() {
        com.baidu.live.data.ab Fm = ccE().hBt.Fm();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.huB.hBS.k(Fm);
            if (Fm != null && Fm.mLiveInfo.live_status != 1) {
                cib();
                ccE().pageContext.getPageActivity().finish();
                if (ccE().hBt == null || ccE().hBt.Fm() == null) {
                    return true;
                }
                a(Fm, 1, ccE().hBt.cjx() != 1 ? ccE().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                return true;
            }
        } else {
            if (this.hrr != null) {
                this.hrr.Kd().a(String.valueOf(Fm.mLiveInfo.group_id), String.valueOf(Fm.mLiveInfo.live_id), true, String.valueOf(Fm.aId.userId), Fm.getGuardName());
            }
            if (this.hrs != null) {
                this.hrs.a(Fm);
            }
            if (this.hrc != null) {
                this.hrc.a(ccE().hBt.Fm());
            }
            if (this.hqg != null) {
                this.hqg.N(Fm);
            }
            if (Fm != null) {
                if (this.hHW != null) {
                    this.hHW.a(Fm);
                }
                if (this.hru != null && Fm.mLiveInfo != null) {
                    this.hru.a(Fm.mLiveInfo, Fm.aId);
                }
                if (this.hrT != null) {
                    this.hsk = this.hrT.p(Fm);
                }
                if (this.hql != null) {
                    this.hql.nI(this.hsk);
                    this.hql.j(Fm);
                    this.hql.updateView();
                }
                if (this.hrJ != null) {
                    this.hrJ.a(Fm);
                }
                if (this.hrL != null) {
                    this.hrL.a(Fm);
                }
                if (this.hrK != null) {
                    this.hrK.a(Fm);
                }
                if (this.hGZ != null) {
                    this.hGZ.a(Fm);
                }
                if (this.hrM != null) {
                    this.hrM.a(Fm);
                }
                if (this.hrN != null) {
                    this.hrN.a(Fm);
                }
                if (this.hrO != null) {
                    this.hrO.a(Fm);
                }
                if (Fm.mLiveInfo.live_status != 1) {
                    cib();
                    ccE().pageContext.getPageActivity().finish();
                    if (ccE().hBt == null || ccE().hBt.Fm() == null) {
                        return true;
                    }
                    a(Fm, 1, ccE().hBt.cjx() != 1 ? ccE().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                    return true;
                } else if (this.hHa != null) {
                    this.hHa.i(Fm);
                }
            }
        }
        return false;
    }

    public void chx() {
        chl();
    }

    public void chy() {
        if (this.hHV != null) {
            this.hHV.ceo();
        }
        if (this.hHX != null) {
            this.hHX.VA();
        }
    }

    public void chz() {
        if (this.hGM != null && this.hGM.getVisibility() != 8) {
            if (ccE().bQY() == 2) {
                cid();
            } else {
                cic();
            }
        }
        if (this.hGM != null && this.hGM.getVisibility() != 8) {
            if (ccE().bQY() == 1) {
                this.hGM.onResume();
            }
            this.hGM.onRefresh();
        }
        if (this.hHa != null) {
            this.hHa.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.hsf && this.hHx != null) {
            if (this.hrr != null) {
                this.hrr.Kd().getView().setVisibility(0);
            }
            if (this.hrr != null) {
                this.hrr.Ke().show();
                String nameShow = this.hHx.getNameShow();
                if (this.hHx.extInfoJson != null) {
                    if (this.hHx.extInfoJson.optInt("is_mysterious_man") == 1) {
                        nameShow = this.hHx.extInfoJson.optString("mysterious_man_nickname");
                        if (TextUtils.isEmpty(nameShow)) {
                            nameShow = "神秘人";
                        }
                    }
                }
                this.hrr.Ke().setEditText(" @" + nameShow + " ");
            }
            vQ(8);
            this.hsf = false;
        }
        if (this.bgE != null) {
            this.bgE.resume();
        }
        if (this.hHX != null) {
            this.hHX.VB();
        }
    }

    public void onPause() {
        if (this.hHa != null) {
            this.hHa.onPause();
        }
        if (this.hrF != null) {
            this.hrF.onPause();
        }
        if (this.bgE != null) {
            this.bgE.pause();
        }
    }

    private void chA() {
        if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
            this.hHs.setVisibility(0);
            this.hHs.setAlpha(0.2f);
        } else if (ccE().hBK.hasBeauty() < 0) {
            this.hHs.setVisibility(8);
        } else {
            this.hHs.setVisibility(0);
        }
    }

    private void chB() {
        this.hHf = (RelativeLayout) ccE().rootView.findViewById(a.f.ala_live_unremovable_container);
        this.hHi = (RelativeLayout) ccE().rootView.findViewById(a.f.under_live_view_panel);
        this.hHj = (RelativeLayout) ccE().rootView.findViewById(a.f.over_live_view_panel);
        this.hHk = (FrameLayout) ccE().rootView.findViewById(a.f.goods_parent);
        this.hHl = (FrameLayout) ccE().rootView.findViewById(a.f.ala_live_bc_chat_container);
        this.huB.hBu.setOnLiveViewScrollListener(this.hIt);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hHi.setVisibility(8);
            this.hHj.setVisibility(8);
            ccE().hBu.removeAllViews();
            return;
        }
        this.hHg = (RelativeLayout) ccE().rootView.findViewById(a.f.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHg.getLayoutParams();
        layoutParams.topMargin = this.huB.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.hHg.setLayoutParams(layoutParams);
        this.hHh = (RelativeLayout) ccE().rootView.findViewById(a.f.ala_live_top_pendant_container);
        if (this.hqj == null) {
            this.hqj = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.huB.pageContext.getPageActivity(), true);
        }
        this.hqj.a(this.hqR);
        this.hqj.a(this.hHg, a.f.ala_live_room_host_header_stub, 1L);
        this.hqj.setVisible(0);
        chC();
        this.hHs = (ImageView) ccE().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn);
        this.hHw = (TextView) ccE().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn_num);
        this.hHs.setOnClickListener(this.hIl);
        this.hHu = (ImageView) ccE().rootView.findViewById(a.f.ala_liveroom_host_paster);
        this.hHu.setOnClickListener(this.hIl);
        if (com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPK != null && com.baidu.live.ae.a.Qj().bAS.aPK.Cz() && bt.b(com.baidu.live.ae.a.Qj().bAS)) {
            this.hHu.setVisibility(0);
        } else {
            this.hHu.setVisibility(8);
        }
        chA();
        this.hHr = (ImageView) ccE().rootView.findViewById(a.f.ala_liveroom_host_share_btn);
        this.hHr.setOnClickListener(this.hIl);
        this.hHp = (ImageView) ccE().rootView.findViewById(a.f.ala_liveroom_host_message_btn);
        this.hHp.setOnClickListener(this.hIl);
        this.huI = (ImageView) ccE().rootView.findViewById(a.f.ala_liveroom_host_pk_btn);
        this.huI.setOnClickListener(this.hIl);
        this.hHv = (ImageView) ccE().rootView.findViewById(a.f.ala_liveroom_host_vedio_chat);
        this.hHv.setOnClickListener(this.hIl);
        this.hHq = (ImageView) ccE().rootView.findViewById(a.f.ala_liveroom_host_more);
        this.hHq.setOnClickListener(this.hIl);
        this.hHt = (ImageView) ccE().rootView.findViewById(a.f.ala_liveroom_host_zan_btn);
        this.hHt.setOnClickListener(this.hIl);
        chF();
        if (bt.b(com.baidu.live.ae.a.Qj().bAS)) {
            this.hHV = new com.baidu.tieba.ala.liveroom.g.b(ccE().hBN, ccE(), ccE().hBK);
        }
        this.hrq = new m();
        chD();
        chE();
        if (com.baidu.live.d.xc().getInt("beauty_new_bubble", 1) == 1) {
            this.hHw.setVisibility(0);
        }
    }

    private void chC() {
        this.hIe = (FrameLayout) View.inflate(ccE().pageContext.getPageActivity(), a.g.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hIe != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.hIe.setVisibility(8);
            if (this.hIe.getParent() != null && (this.hIe.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hIe.getParent()).removeView(this.hIe);
            }
            this.hHf.addView(this.hIe, layoutParams);
            if (this.hIe != null) {
                this.hIe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.hqR.v(AlaMasterLiveRoomOpearator.this.hIe, 8);
                    }
                });
            }
        }
    }

    private void chD() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, ccE().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hrr = (k) runTask.getData();
            this.hrr.setFromMaster(true);
            this.hrr.Kd().getView().setId(a.f.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(ccE().pageContext.getPageActivity()) * 0.75f), com.baidu.live.aj.c.j(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.aj.c.dr(true);
            ccE().hBu.addView(this.hrr.Kd().getView(), layoutParams);
            this.hrr.Ke().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            ccE().hBu.addView(this.hrr.Ke().getView(), layoutParams2);
            this.hrr.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                @Override // com.baidu.live.im.k.a
                public boolean Kh() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void Ki() {
                }

                @Override // com.baidu.live.im.k.a
                public void hb(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void Kj() {
                }

                @Override // com.baidu.live.im.k.a
                public void Kk() {
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean Km() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int Kn() {
                    return 0;
                }

                @Override // com.baidu.live.im.k.a
                public boolean Ko() {
                    return false;
                }
            });
        }
    }

    private void chE() {
        View zP;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, ccE().pageContext);
        if (runTask != null) {
            this.hrs = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hrs != null && (zP = this.hrs.zP()) != null && this.huB.hBu.indexOfChild(zP) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.huB.pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds98));
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            layoutParams.bottomMargin = ccE().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            ccE().hBu.addView(zP, layoutParams);
        }
    }

    private void chF() {
        CustomResponsedMessage runTask;
        if (this.hHA == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ag.a.class, ccE().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hHA = (com.baidu.live.ag.a) runTask.getData();
        }
    }

    private void chG() {
        View EI;
        ac.e(ccE().hBt.Fm());
        ac.b(ccE().pageContext, true, false);
        ac.Ft();
        if (this.hrt == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVn = true;
            fVar.context = ccE().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrt = (ad) runTask.getData();
                if (this.hrt != null && (EI = this.hrt.EI()) != null && ccE().hBu.indexOfChild(EI) < 0) {
                    if (EI.getParent() instanceof ViewGroup) {
                        ((ViewGroup) EI.getParent()).removeView(EI);
                    }
                    ccE().hBu.addView(EI, ccE().hBu.getLayoutParams());
                }
            }
        }
    }

    private void chH() {
        if (!this.hIf) {
            this.hIf = true;
            com.baidu.live.entereffect.a.CV().by(true);
        }
    }

    protected void cbi() {
        View Fl;
        if (this.hru == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVn = true;
            aVar.context = ccE().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hru = (ab) runTask.getData();
            }
        }
        if (this.hru != null && (Fl = this.hru.Fl()) != null && this.hHh != null) {
            if (this.hHh.indexOfChild(Fl) < 0) {
                if (Fl.getParent() instanceof ViewGroup) {
                    ((ViewGroup) Fl.getParent()).removeView(Fl);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.hGP != null && this.hGP.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
                    layoutParams.topMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hrO != null && this.hrO.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hrN != null && this.hrN.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else {
                    layoutParams.topMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds66);
                }
                this.hHh.addView(Fl, layoutParams);
            }
            Fl.bringToFront();
        }
    }

    protected void cbh() {
        View Fz;
        if (this.hrF == null) {
            ak akVar = new ak();
            akVar.aVn = true;
            akVar.pageContext = ccE().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrF = (ag) runTask.getData();
            }
        }
        if (this.hrF != null && (Fz = this.hrF.Fz()) != null && ccE().hBu.indexOfChild(Fz) < 0) {
            if (Fz.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fz.getParent()).removeView(Fz);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            ccE().hBu.addView(Fz, layoutParams);
        }
    }

    private void chI() {
        chM();
        cbn();
        chL();
        ccE().hBu.setVisibility(0);
        vQ(0);
    }

    private void chJ() {
        if (this.hGP == null) {
            this.hGP = new com.baidu.tieba.ala.liveroom.t.a(ccE().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.hGP.a(ccE().bQY(), j, TbadkCoreApplication.getCurrentAccountName(), true, ccE().hBt.Fm().aId.portrait, this.otherParams, "", -1L);
        this.hGP.aF(this.hHh);
    }

    private void chK() {
        if (this.hHC == null) {
            ccE().hBu.hRi = false;
            com.baidu.live.af.a ga = ga(ccE().pageContext.getPageActivity());
            if (ga != null) {
                this.hHC = ga;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.af.a.class, ccE().pageContext.getPageActivity());
                if (runTask != null) {
                    this.hHC = (com.baidu.live.af.a) runTask.getData();
                }
            }
            if (this.hHC != null) {
                this.hHC.r(this.hHi);
                this.hHC.s(this.hHj);
                this.hHC.dX((ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds330) + ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96)) - ccE().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds300));
                this.hHC.t(ccE().hBu);
                this.hHC.a(this.hpD);
                this.hHC.setLiveShowInfo(ccE().hBt.Fm());
                this.hHC.a(this.hql);
                this.hHC.QF();
                this.hHC.a(new a.InterfaceC0156a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public void QG() {
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public void QH() {
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public void F(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.ccE().hBK != null) {
                            AlaMasterLiveRoomOpearator.this.ccE().hBK.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public int QI() {
                        return AlaMasterLiveRoomOpearator.this.hHg.getBottom();
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public int QJ() {
                        return AlaMasterLiveRoomOpearator.this.huB.hBu.getHeight() - (AlaMasterLiveRoomOpearator.this.hrr.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.hrr.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.hrr.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public int QK() {
                        return AlaMasterLiveRoomOpearator.this.hrr.Kg();
                    }
                });
            }
        }
    }

    private com.baidu.live.af.a ga(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aY(context);
        }
        return null;
    }

    private void chL() {
        if (this.hGR == null) {
            this.hGR = new b(ccE().pageContext, ccE().hBu);
        }
    }

    private void chM() {
        if (this.hqg == null) {
            this.hqg = new com.baidu.tieba.ala.liveroom.m.a(ccE().pageContext, true, this.hIp);
            this.hqg.e(this.hHg, null);
            this.hqg.a(this.hqR);
            this.hqg.ou(false);
        }
        if (this.hGN == null) {
            this.hGN = new com.baidu.tieba.ala.liveroom.m.a(ccE().pageContext, true, null);
            this.hGN.a(this.hHg, null, a.f.ala_live_room_host_header_stub);
            this.hGN.cge();
        }
    }

    protected void caQ() {
        CustomResponsedMessage runTask;
        boolean z = false;
        aw cjo = ccE().hBt.cjo();
        boolean z2 = com.baidu.live.ae.a.Qj().buX.aMZ;
        if (cjo == null || cjo.aIP) {
            z = z2;
        }
        if (z && this.hrc == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.j.b.class, ccE().pageContext)) != null) {
            this.hrc = (com.baidu.live.j.b) runTask.getData();
            if (this.hrc != null) {
                this.hrc.setIsHost(true);
                this.hrc.du(1);
                View view = this.hrc.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(ccE().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(ccE().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.f.ala_live_room_host_header_stub);
                    this.hHg.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(com.baidu.live.data.ab abVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2;
        if (this.hql == null) {
            this.hql = new com.baidu.tieba.ala.liveroom.activeview.b(ccE().pageContext);
        }
        this.hql.setOtherParams(this.otherParams);
        this.hql.c(abVar, false);
        this.hql.setHost(true);
        this.hql.a(1, this.byA);
        this.hql.a(2, this.byA);
        this.hql.nI(this.hsk);
        this.hql.setVisible(this.hGL ? 8 : 0);
        this.hql.a(this.hpD);
        if (this.hpD != null) {
            if (this.hql != null) {
                AlaActiveRootView vi = this.hql.vi(1);
                alaActiveRootView = this.hql.vi(2);
                alaActiveRootView2 = vi;
            } else {
                alaActiveRootView = null;
                alaActiveRootView2 = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.hpD.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.hpD.a(alaActiveRootView);
            }
        }
    }

    private void O(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        if (this.hrT == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, ccE().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hrT = (com.baidu.live.aa.a) runTask.getData();
            if (this.hrT != null) {
                this.hrT.q(this.byA);
            }
        }
        if (this.hrT != null) {
            this.hsk = this.hrT.p(abVar);
            this.hrT.setCanVisible(!this.hGL);
        }
    }

    protected void chN() {
        CustomResponsedMessage runTask;
        if (ccE() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.l.a.class, ccE().pageContext.getPageActivity())) != null && runTask.getData() != null && this.hrJ == null) {
            this.hrJ = (com.baidu.live.l.a) runTask.getData();
            this.hrJ.d(this.hHh, cbB());
            if (ccE().hBt != null) {
                this.hrJ.a(ccE().hBt.Fm());
            }
            this.hrJ.setCanVisible(true);
            this.hrJ.ch(false);
            this.hrJ.a(ccE().hBt.bTK());
        }
    }

    protected void cbm() {
        CustomResponsedMessage runTask;
        if (ccE() != null && this.hrL == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.t.a.class, ccE().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hrL = (com.baidu.live.t.a) runTask.getData();
            this.hrL.setIsHost(true);
            this.hrL.a(this.huB.hBu, ccE().hBt.Fm());
        }
    }

    protected void cad() {
        if (ccE() != null) {
            if (this.hrM == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, ccE().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hrM = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrM.aW(this.gQr);
            this.hrM.setIsHorizontal(false);
            this.hrM.setIsHost(true);
            this.hrM.a(this.byA, ccE().hBt.Fm());
        }
    }

    protected void cbl() {
        if (ccE() != null) {
            if (this.hrK == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.v.a.class, ccE().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrK = (com.baidu.live.v.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (ccE().hBt != null) {
                this.hrK.b(ccE().hBt.Fm(), this.otherParams);
            }
        }
    }

    protected void cac() {
        if (ccE() != null) {
            if (this.hqs == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, ccE().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hqs = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hqs.setIsHost(true);
            this.hqs.a(this.byA, ccE().hBt.Fm().aJc);
        }
    }

    protected void chO() {
        CustomResponsedMessage runTask;
        if (ccE() != null && this.hHz == null && (runTask = MessageManager.getInstance().runTask(2913269, com.baidu.live.n.b.class, ccE().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hHz = (com.baidu.live.n.b) runTask.getData();
        }
    }

    protected void cbo() {
        CustomResponsedMessage runTask;
        if (ccE() != null && this.hrN == null && (runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.k.a.class, ccE().pageContext)) != null && runTask.getData() != null) {
            this.hrN = (com.baidu.live.k.a) runTask.getData();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            this.hrN.a(this.hHh, ccE().hBt.Fm(), layoutParams, this.otherParams);
        }
    }

    private void P(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        CustomResponsedMessage runTask3;
        CustomResponsedMessage runTask4;
        if (ccE() != null) {
            if (this.hGT == null && (runTask4 = MessageManager.getInstance().runTask(2913229, com.baidu.live.t.e.class)) != null) {
                this.hGT = (com.baidu.live.t.e) runTask4.getData();
            }
            if (this.hGT != null) {
                this.hGT.Pj();
            }
            if (this.hGU == null && (runTask3 = MessageManager.getInstance().runTask(2913292, com.baidu.live.t.b.class)) != null) {
                this.hGU = (com.baidu.live.t.b) runTask3.getData();
            }
            if (this.hGU != null) {
                this.hGU.Pj();
            }
            if (this.hGV == null && (runTask2 = MessageManager.getInstance().runTask(2913296, com.baidu.live.t.b.class)) != null) {
                this.hGV = (com.baidu.live.t.b) runTask2.getData();
            }
            if (this.hGV != null) {
                this.hGV.Pj();
            }
            if (this.hGW == null && (runTask = MessageManager.getInstance().runTask(2913293, f.class)) != null) {
                this.hGW = (f) runTask.getData();
            }
            if (this.hGW != null) {
                this.hGW.Pj();
            }
            if (this.hGX == null) {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(2913230, com.baidu.live.t.d.class);
                if (runTask5 != null) {
                    this.hGX = (com.baidu.live.t.d) runTask5.getData();
                }
                if (this.hGX != null) {
                    this.hGX.setParentView(this.huB.hBu);
                    if (abVar != null && abVar.aId != null) {
                        this.hGX.bh(abVar.aId.userId);
                    }
                }
            }
        }
    }

    private void chP() {
        CustomResponsedMessage runTask;
        if (ccE() != null) {
            if (this.hGY == null && (runTask = MessageManager.getInstance().runTask(2913265, c.class)) != null) {
                this.hGY = (c) runTask.getData();
            }
            if (this.hGY != null) {
                this.hGY.Pj();
            }
            if (this.hGZ == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913266, com.baidu.live.v.b.class);
                if (runTask2 != null) {
                    this.hGZ = (com.baidu.live.v.b) runTask2.getData();
                }
                if (this.hGZ != null) {
                    this.hGZ.setParentView(this.huB.hBu);
                    this.hGZ.b(ccE().hBt.Fm(), this.otherParams);
                }
            }
        }
    }

    private ViewGroup.LayoutParams cbB() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(ccE().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(1, a.f.ala_live_room_stream_view);
            layoutParams.leftMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.f.ala_liveroom_charmview);
        }
        if (this.hrO != null && this.hrO.isShowing()) {
            layoutParams.addRule(3, a.f.ala_rank_level_entry);
            layoutParams.topMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        } else if (this.hGP != null && this.hGP.isShowing()) {
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            layoutParams.topMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        }
        return layoutParams;
    }

    private void cbn() {
        if (this.hGO == null) {
            this.hGO = new com.baidu.tieba.ala.liveroom.a.a(ccE().pageContext, true);
        }
    }

    private void chQ() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = ccE().pageContext.getPageActivity();
            if (this.hHD == null) {
                this.hHD = new ImageView(pageActivity);
                this.hHD.setId(a.f.master_close_btn);
                this.hHD.setTag("master_close_btn");
                this.hHD.setImageResource(a.e.sdk_icon_bar_live_close_n);
                this.hHD.setBackgroundResource(a.e.sdk_round_btn_close_bg);
                this.hHD.setPadding(pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0);
            }
            if (this.hHD.getParent() != null) {
                ((ViewGroup) this.hHD.getParent()).removeView(this.hHD);
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
            ccE().hBN.addView(this.hHD, layoutParams);
            this.hHD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.chZ();
                }
            });
            this.hHD.setVisibility(8);
        }
    }

    protected void cbr() {
        if (this.hrO == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.t.c.class, ccE().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrO = (com.baidu.live.t.c) runTask.getData();
            } else {
                return;
            }
        }
        if (ccE().hBt.Fm() != null && ccE().hBt.Fm().aId != null && ccE().hBt.Fm().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.height = BdUtilHelper.getDimens(ccE().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.leftMargin = BdUtilHelper.getDimens(ccE().pageContext.getPageActivity(), a.d.sdk_ds20);
            this.hrO.b(this.hHh, layoutParams, ccE().hBt.Fm());
        }
    }

    private void chR() {
        CustomResponsedMessage runTask;
        if (this.hHY == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, ccE().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.hHY = (com.baidu.live.b.a) runTask.getData();
            if (this.hHY != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.f.ala_head_line_entry_id);
                layoutParams.addRule(11);
                layoutParams.topMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
                layoutParams.rightMargin = ccE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                aw cjo = ccE().hBt.cjo();
                if (cjo != null) {
                    this.hHY.a(this.hHh, layoutParams, ccE().pageContext.getPageActivity(), cjo.aOj);
                } else {
                    return;
                }
            }
        }
        if (this.hHY != null) {
            this.hHY.a(ccE().hBt.Fm());
        }
    }

    private void caY() {
        if (this.bgE == null) {
            this.bgE = new com.baidu.live.an.a(ccE().pageContext.getPageActivity());
        }
    }

    private void Q(com.baidu.live.data.ab abVar) {
        if (this.hHZ == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913299, com.baidu.live.guess.b.class);
            if (runTask.getData() != null) {
                this.hHZ = (com.baidu.live.guess.b) runTask.getData();
                if (this.hHZ != null && this.byA != null) {
                    this.hHZ.init(ccE().pageContext.getPageActivity(), true);
                    this.hHZ.a(abVar, this.byA);
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.hHW != null) {
            this.hHW.onRtcConnected(i);
        }
    }

    private void registerListener() {
        ccE().pageContext.registerListener(this.hsC);
        ccE().pageContext.registerListener(this.hIi);
        ccE().pageContext.registerListener(this.hsD);
        ccE().pageContext.registerListener(this.hsE);
        ccE().pageContext.registerListener(this.hIm);
        ccE().pageContext.registerListener(this.bCb);
        ccE().pageContext.registerListener(this.hoN);
        ccE().pageContext.registerListener(this.hIn);
        ccE().pageContext.registerListener(this.gNf);
        ccE().pageContext.registerListener(this.hqN);
        ccE().pageContext.registerListener(this.hsI);
        ccE().pageContext.registerListener(this.bEA);
        ccE().pageContext.registerListener(this.bEB);
        ccE().pageContext.registerListener(this.hIj);
        ccE().pageContext.registerListener(this.brP);
        ccE().pageContext.registerListener(this.brQ);
        ccE().pageContext.registerListener(this.hIk);
        ccE().pageContext.registerListener(this.hsK);
        ccE().pageContext.registerListener(this.hsJ);
        ccE().pageContext.registerListener(this.hsO);
        ccE().pageContext.registerListener(this.hIk);
        ccE().pageContext.registerListener(this.boE);
        ccE().pageContext.registerListener(this.blY);
        ccE().pageContext.registerListener(this.hdK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(boolean z) {
        if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
            ccE().pageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (ccE().hBP.zB() == null || ListUtils.isEmpty(ccE().hBP.zB().aCd)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ccE().pageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (!this.bEy) {
                this.bEx = BdUniqueId.gen();
                ccE().hBP.a(this.bEx);
                this.bEy = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(ccE().pageContext.getPageActivity(), ccE().rootView);
            vQ(8);
            if (ccE().hBK.hasAdvancedBeauty() && this.hHV != null) {
                if (!this.hIa || this.hGM.getVisibility() == 0) {
                    this.hHV.c(ccE().hBK.getVideoConfig());
                }
                this.hHV.a(ccE().hBK.getVideoConfig(), this.bEz);
                if (!this.bEz) {
                    this.bEz = true;
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
    public void vP(int i) {
        if (this.hHE == null || !this.hHE.isShowing()) {
            this.hHE = new BdAlertDialog(ccE().pageContext.getPageActivity());
            this.hHE.setAutoNight(false);
            this.hHE.setTitle(a.h.sdk_prompt);
            this.hHE.setMessageId(i, currentAppType(ccE().pageContext.getPageActivity()));
            this.hHE.setTitleShowCenter(true);
            this.hHE.setMessageShowCenter(true);
            this.hHE.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    AlaMasterLiveRoomOpearator.this.ccE().g((short) 1);
                }
            });
            this.hHE.create(ccE().pageContext).show();
        }
    }

    private void HS(String str) {
        if (this.hHF == null || !this.hHF.isShowing()) {
            this.hHF = new BdAlertDialog(ccE().pageContext.getPageActivity());
            this.hHF.setAutoNight(false);
            this.hHF.setTitle(a.h.sdk_prompt);
            this.hHF.setMessage(str);
            this.hHF.setTitleShowCenter(true);
            this.hHF.setMessageShowCenter(true);
            this.hHF.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    AlaMasterLiveRoomOpearator.this.ccE().g((short) 1);
                }
            });
            this.hHF.create(ccE().pageContext).show();
        }
    }

    public void chS() {
        caQ();
        v bTK = ccE().hBt.bTK();
        int i = 5;
        if (bTK != null) {
            i = (int) bTK.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm() != null && AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.ccE().hBt.j(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bTK != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.huB.hBS.b(bTK);
                return;
            }
            if (this.hqf == null) {
                this.hqf = new com.baidu.tieba.ala.liveroom.audiencelist.c(ccE().pageContext, this.hIp, true);
            }
            if (this.hHT) {
                this.hHT = false;
                this.hqf.a(String.valueOf(ccE().hBt.Fm().mLiveInfo.group_id), String.valueOf(ccE().hBt.Fm().mLiveInfo.live_id), String.valueOf(ccE().hBt.Fm().aId.userId), ccE().hBt.Fm());
                int i2 = a.f.ala_live_room_host_header_stub;
                if (this.hrc != null) {
                    i2 = a.f.ala_liveroom_guardthrone;
                }
                this.hqf.c(this.hHg, i2, a.f.ala_liveroom_audience_count_layout);
            }
            this.hqf.e(bTK);
            this.hqj.setVisible(0);
            this.hqj.ff(bTK.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chT() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buF() {
        if (ccE().hBt != null) {
            if (this.hre == null) {
                this.hre = new com.baidu.tieba.ala.liveroom.share.c(ccE().pageContext);
            }
            this.hre.d(ccE().hBt.Fm(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (ccE().hBt != null && ccE().hBt.Fm() != null && ccE().hBt.Fm().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", ccE().hBt.Fm().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", ccE().hBt.Fm().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", ccE().hBt.Fm().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (ccE().hBt != null && ccE().hBt.Fm() != null && ccE().hBt.Fm().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", ccE().hBt.Fm().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", ccE().hBt.Fm().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", ccE().hBt.Fm().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean chU() {
        return this.hGK;
    }

    private void oA(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(hGJ, z);
        this.hGK = z;
    }

    private void chV() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccE().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.h.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.n.b(AlaMasterLiveRoomOpearator.this.ccE().pageContext).ciW();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.h.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(ccE().pageContext).show();
    }

    private void chW() {
        if (this.hGt && ccE().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            ccE().hBR.TZ();
        }
        ccE().hBQ.prepareTime = System.currentTimeMillis() - ccE().hBQ.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (ccE().hBt != null && ccE().hBt.Fm() != null && ccE().hBt.Fm().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", ccE().hBt.Fm().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", ccE().hBt.Fm().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", ccE().hBQ.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hGM != null && this.hGM.getView().getParent() != null) {
            this.hGM.setVisibility(8);
            ccE().hBN.removeView(this.hGM.getView());
            this.hGM.release();
        }
        if (this.hHV != null) {
            this.hHV.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (ccE().hBu.indexOfChild(this.hHd) < 0) {
            ccE().hBu.addView(this.hHd, layoutParams);
        }
        this.hHd.wh(1000);
    }

    private void awo() {
        if (ccE().bQY() == 1) {
            ccE().hBK.startRecord();
        }
    }

    private void HT(String str) {
        HU(str);
    }

    private void HU(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) ccE().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.hGM != null) {
            this.hGM.HH(fromJson.getSmallurl());
        }
    }

    private boolean chX() {
        return com.baidu.live.d.xc().getBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chY() {
        com.baidu.live.d.xc().putBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), this.huB.hBK.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chZ() {
        if (this.hHX == null || !this.hHX.Rn()) {
            if (this.hHc == null || !this.hHc.Rn()) {
                int i = a.h.live_close_confirm;
                if (this.hHW != null && this.hHW.ccM()) {
                    i = a.h.ala_pk_pking_close_live_roon_tip;
                } else if (this.hHW != null && this.hHW.ccL()) {
                    i = a.h.ala_challenge_challenging_close_live_room_tip;
                }
                BdAlertDialog bdAlertDialog = new BdAlertDialog(ccE().pageContext.getPageActivity());
                bdAlertDialog.setAutoNight(false);
                bdAlertDialog.setTitle((String) null);
                bdAlertDialog.setMessageId(i);
                bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                        }
                        bdAlertDialog2.dismiss();
                        if (AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm() != null) {
                            AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm(), 0, AlaMasterLiveRoomOpearator.this.ccE().hBt.cjx() != 1 ? AlaMasterLiveRoomOpearator.this.ccE().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                        } else {
                            AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                        }
                    }
                });
                bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.create(ccE().pageContext).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, int i, String str) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        AlaLiveInfoData alaLiveInfoData;
        if (abVar != null) {
            alaLiveInfoData = abVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = abVar.aId;
            if (alaLiveInfoData != null) {
                String str2 = alaLiveInfoData.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                ccE().hBt.eA(Long.toString(alaLiveInfoData.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
        } else {
            alaLiveUserInfoData = null;
            alaLiveInfoData = null;
        }
        if (!this.hHR) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = ccE().hBQ;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = ccE().hBK.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.hHN;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.hHO;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.hHJ;
            if (this.hHK != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.hHL - this.hHM) / this.hHK) * 100.0f;
            }
            Intent intent = new Intent(ccE().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (ccE().hBt != null && ccE().hBt.Fm() != null && ccE().hBt.Fm().aId != null) {
                String str3 = ccE().hBt.Fm().aId.nickName;
                String str4 = ccE().hBt.Fm().aId.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            com.baidu.live.data.ab Fm = ccE().hBt.Fm();
            if (Fm != null && Fm.aId != null && !TextUtils.isEmpty(Fm.aId.portrait)) {
                intent.putExtra("host_portrait", Fm.aId.portrait);
            }
            if (this.hHX != null) {
                this.hHX.Vz();
            }
            if (this.hHc != null) {
                this.hHc.Rl();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.hHP = intent;
                this.hHQ = s;
                ccE().pageContext.showToast(a.h.ala_live_background_close_tip);
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
            if (this.hIg != null) {
                this.hIg.aCV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cia() {
        if (this.hHP != null) {
            a(this.hHP, this.hHQ);
            this.hHP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.hHR = true;
        if (this.hHW != null) {
            this.hHW.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.hoC);
            ccE().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        ccE().g(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cib() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.huB.hBS != null && this.huB.hBS.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hHW != null && this.hHW.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hHX != null && this.hHX.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hHV != null && this.hHV.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hHc != null && this.hHc.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (ccE().hBO.ciF()) {
                chZ();
                return true;
            }
        }
        return false;
    }

    public void VC() {
        if (this.hHX != null) {
            this.hHX.VC();
        }
    }

    public void sendBufferChanged(int i) {
        if (this.hHe != null) {
            this.hHe.ej(i);
        }
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (this.huB != null && this.huB.hBt != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.dLp != i3) {
                this.dLp = i3;
                if (this.hGS == null) {
                    this.hGS = new com.baidu.tieba.ala.liveroom.tippop.a(this.huB.pageContext, null);
                }
                switch (this.dLp) {
                    case 0:
                        this.hGS.c(this.huB.hBN, this.huB.pageContext.getString(a.h.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.hGS.c(this.huB.hBN, this.huB.pageContext.getString(a.h.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.hGS.c(this.huB.hBN, this.huB.pageContext.getString(a.h.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.huB.hBt.x(this.huB.hBt.Fm().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void P(com.baidu.live.im.data.b bVar) {
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
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cib();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm(), 1, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0738, code lost:
        Hu(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: JSONException -> 0x082d, TRY_LEAVE, TryCatch #6 {JSONException -> 0x082d, blocks: (B:14:0x0049, B:16:0x0051, B:263:0x0822), top: B:292:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0822 A[Catch: JSONException -> 0x082d, TRY_ENTER, TRY_LEAVE, TryCatch #6 {JSONException -> 0x082d, blocks: (B:14:0x0049, B:16:0x0051, B:263:0x0822), top: B:292:0x0049 }] */
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
        if (this.hql != null) {
            this.hql.N(bVar);
        }
        if (bVar.getMsgType() == 125) {
            if (this.hGQ != null) {
                this.hGQ.R(bVar);
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
            if (this.hHW != null) {
                this.hHW.fo(str2);
            }
            if ("close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cib();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccE().hBt.Fm(), 1, str3);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (ccE().hBt.Fm() != null && jSONObject5 != null) {
                    long optLong = jSONObject5.optLong("user_id");
                    int optInt = jSONObject5.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ccE().hBt.Fm().aIz.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ccE().hBt.Fm().aIz.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        ccE().hBt.Fm().aIz.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (ccE().hBt.Fm() != null && jSONObject5 != null) {
                    long optLong2 = jSONObject5.optLong("user_id");
                    if (ccE().hBt.Fm() != null && ccE().hBt.Fm().aId != null && ccE().hBt.Fm().aId.userId == optLong2) {
                        ccE().hBt.Fm().aId.isUegBlock = 1;
                        cau();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (ccE().hBt.Fm() != null && jSONObject5 != null) {
                    long optLong3 = jSONObject5.optLong("user_id");
                    if (ccE().hBt.Fm() != null && ccE().hBt.Fm().aId != null && ccE().hBt.Fm().aId.userId == optLong3) {
                        ccE().hBt.Fm().aId.isUegBlock = 0;
                        cau();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.hHA != null) {
                    this.hHA.ab(jSONObject5);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject5 != null) {
                    String optString2 = jSONObject5.optString("share_enter_msg");
                    int optInt2 = jSONObject5.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.hGR.aL(optString2, optInt2);
                    }
                    if (this.hqj.getCount() > 20) {
                        this.hqj.ff(this.hqj.getCount() + 1);
                    } else if (this.hqf != null) {
                        com.baidu.live.data.a KZ = bVar.KZ();
                        com.baidu.live.data.u uVar = new com.baidu.live.data.u();
                        uVar.aIe = new AlaLocationData();
                        uVar.aIf = new AlaRelationData();
                        uVar.aId = new AlaLiveUserInfoData();
                        uVar.aId.userId = JavaTypesHelper.toLong(KZ.userId, 0L);
                        uVar.aId.userName = KZ.userName;
                        uVar.aId.portrait = KZ.portrait;
                        if (this.hqf.c(uVar)) {
                            this.hqj.ff(this.hqj.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject5 != null && ccE() != null && ccE().hBt != null && ccE().hBt.Fm() != null && ccE().hBt.Fm().aIz != null && ccE().hBt.Fm().aIz.userId == jSONObject5.optLong("user_id")) {
                    ccE().hBt.cjn();
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
                    com.baidu.live.data.a KZ2 = bVar.KZ();
                    if (KZ2 != null && ac.gq(str5)) {
                        ac.d(str5, 1L, "", "", KZ2.userId, KZ2.portrait, KZ2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str2)) {
                if (jSONObject5 != null) {
                    bh bhVar = new bh();
                    bhVar.parseJson(jSONObject5);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bhVar));
                }
            } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                if (jSONObject5 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject5));
                }
            } else if ("challenge_direct_new".equals(str2)) {
                if (jSONObject5 != null) {
                    String optString3 = jSONObject5.optString("challenge_im_type");
                    if (TextUtils.equals(optString3, "start")) {
                        HV(jSONObject5.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString3, "cancel")) {
                        BdUtilHelper.showToast(ccE().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
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
                            if (this.hrN != null) {
                            }
                            if (this.hrL != null) {
                            }
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        jSONObject2 = null;
                    }
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_direct_new").setContentExt(null, null, jSONObject2));
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(ccE().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_random_cancel").setContentExt(null, null, null));
            } else if ("connect_apply_show_pub".equals(str2)) {
                if (this.hHc != null) {
                    this.hHc.aa(jSONObject5);
                }
            } else if ("remove_video".equals(str2)) {
                String optString5 = jSONObject5.optString("text");
                if (jSONObject5.optString("poke_msg").isEmpty()) {
                    HR(optString5);
                }
            }
        } else if (bVar.getMsgType() == 24) {
            com.baidu.live.data.a KZ3 = bVar.KZ();
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
                if (ccE().hBt == null || ccE().hBt.Fm() == null || ccE().hBt.Fm().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    z = false;
                } else {
                    long j4 = ccE().hBt.Fm().mLiveInfo.live_id;
                    j3 = ccE().hBt.Fm().mLiveInfo.group_id;
                    long j5 = ccE().hBt.Fm().aId.userId;
                    str8 = ccE().hBt.Fm().mLiveInfo.appId;
                    boolean z5 = ccE().hBt.Fm().mLiveInfo.isPubShow;
                    if (ccE().hBt.Fm().mLiveSdkInfo.mCastIds != null) {
                        str6 = ccE().hBt.Fm().mLiveSdkInfo.mCastIds.chatMCastId;
                        str7 = ccE().hBt.Fm().mLiveSdkInfo.mCastIds.ensureMCastId;
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
                    if (!this.isBackground || ccE().bQY() != 2) {
                        if (!TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                            if (jSONObject3.optInt("flag_show") == 1) {
                                ac.b(cVar, KZ3, String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str8, "", "", bVar.getMsgId());
                                try {
                                    JSONArray jSONArray = new JSONArray(optString11);
                                    if (jSONArray != null && jSONArray.length() > 0) {
                                        int i = 0;
                                        while (true) {
                                            if (i >= jSONArray.length()) {
                                                break;
                                            }
                                            if (com.baidu.live.ae.f.QB().hv(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                            ac.b(cVar, KZ3, String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str8, (z4 || z3) ? false : true, true, str6, str7, bVar.getMsgId());
                        }
                    }
                    Hu(optString7);
                    if (!jSONObject3.optString("content_type").equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) {
                        com.baidu.tieba.ala.liveroom.f.c cVar2 = new com.baidu.tieba.ala.liveroom.f.c();
                        cVar2.bpn = optLong5;
                        cVar2.liveId = j2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.putOpt(LogConfig.LOG_GIFT_ID, optString7);
                        jSONObject6.putOpt("gift_name", optString9);
                        jSONObject6.putOpt("order_id", optString6);
                        com.baidu.live.gift.g gm = ac.gm(optString7);
                        if (gm != null) {
                            jSONObject6.putOpt(LogConfig.LOG_GIFT_VALUE, gm.getPrice());
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
        if (this.hrN != null) {
            this.hrN.l(bVar);
        }
        if ((this.hrL != null || !this.hrL.J(bVar)) && this.hqs != null && this.hqs.Z(jSONObject4)) {
        }
    }

    private void Hu(String str) {
        if (this.hql != null) {
            this.hql.Hu(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ(int i) {
        View findViewById = ccE().rootView.findViewById(a.f.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.hql != null) {
            this.hql.bM(2, i);
        }
    }

    private void cic() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.ccE().hBK != null && AlaMasterLiveRoomOpearator.this.ccE().hBK.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.ccE().hBK.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.ccE().hBK.startRecord();
                }
            }
        });
    }

    private void cid() {
        if (ccE().hBK != null && ccE().hBK.getPreview() != null) {
            ccE().hBK.getPreview().setVisibility(8);
            ccE().hBK.stopRecord();
        }
    }

    public void cie() {
        this.hBH = ccE().hBt.cjy();
        if (this.hGM != null) {
            this.hGM.oi(this.hBH);
        }
    }

    public void cey() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cif();
        } else if (this.hGM != null) {
            this.hGM.cey();
        }
    }

    public void oj(boolean z) {
        if (this.hGM != null) {
            this.hGM.oj(z);
        }
    }

    public void onDestroy() {
        if (this.hHI != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.hHI);
        }
        this.hHI = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hHy.removeCallbacksAndMessages(null);
        if (this.hHV != null) {
            this.hHV.og(true);
        }
        this.hHV = null;
        if (this.hGM != null) {
            this.hGM.destroy();
            ccE().hBN.removeView(this.hGM.getView());
            this.hGM.release();
            this.hGM = null;
        }
        if (this.hHW != null) {
            this.hHW.onDestroy();
        }
        if (this.hre != null) {
            this.hre.onDestroy();
        }
        if (this.hqg != null) {
            this.hqg.onDestroy();
            this.hqg = null;
        }
        if (this.hGN != null) {
            this.hGN.onDestroy();
        }
        if (this.hrF != null) {
            this.hrF.onDestroy();
            this.hrF = null;
        }
        if (this.hHd != null) {
            this.hHd.stopCountDown();
        }
        if (this.hGP != null) {
            this.hGP.onDestroy();
        }
        if (this.hGR != null) {
            this.hGR.onDestroy();
        }
        if (this.hHA != null) {
            this.hHA.onDestroy();
            this.hHA = null;
        }
        if (this.hrt != null) {
            this.hrt.onDestroy();
            this.hrt = null;
        }
        if (this.hGT != null) {
            this.hGT.release();
        }
        if (this.hGU != null) {
            this.hGU.release();
        }
        if (this.hGV != null) {
            this.hGV.release();
        }
        if (this.hGW != null) {
            this.hGW.release();
        }
        if (this.hGY != null) {
            this.hGY.release();
        }
        com.baidu.live.storage.opt.b.Rg().release();
        ac.Fu();
        com.baidu.live.entereffect.a.CV().release();
        this.hIf = false;
        if (this.hru != null) {
            this.hru.onDestroy();
            this.hru = null;
        }
        if (this.hGS != null) {
            this.hGS.onDestroy();
        }
        if (this.hGQ != null) {
            this.hGQ.clK();
            this.hGQ.release();
        }
        if (this.hqj != null) {
            this.hqj = null;
        }
        if (this.hql != null) {
            this.hql.release();
        }
        if (this.hGQ != null) {
            this.hGQ.onDestroy();
        }
        if (this.hrs != null) {
            this.hrs.release();
        }
        if (this.hHa != null) {
            this.hHa.release();
        }
        if (this.hHC != null) {
            this.hHC.onDestroy();
        }
        if (this.hrT != null) {
            this.hrT.release();
        }
        if (this.hHY != null) {
            this.hHY.onDestory();
        }
        if (this.hrJ != null) {
            this.hrJ.onDestroy();
        }
        if (this.hrL != null) {
            this.hrL.onDestroy();
        }
        if (this.hrK != null) {
            this.hrK.onDestroy();
        }
        if (this.hqs != null) {
            this.hqs.onDestroy();
        }
        if (this.hGX != null) {
            this.hGX.release();
            this.hGX = null;
        }
        if (this.hGZ != null) {
            this.hGZ.release();
            this.hGZ = null;
        }
        if (this.bgE != null) {
            this.bgE.release();
        }
        if (this.hrO != null) {
            this.hrO.onDestroy();
        }
        if (this.hHX != null) {
            this.hHX.onDestroy();
        }
        if (this.hHc != null) {
            this.hHc.onDestroy();
        }
        if (this.hrX != null) {
            this.hrX.onDestory();
        }
        if (this.hHE != null) {
            this.hHE.dismiss();
            this.hHE = null;
        }
        if (this.hHF != null) {
            this.hHF.dismiss();
            this.hHF = null;
        }
        this.hIb.removeCallbacksAndMessages(this.hIx);
        MessageManager.getInstance().unRegisterListener(this.hsC);
        MessageManager.getInstance().unRegisterListener(this.hIi);
        MessageManager.getInstance().unRegisterListener(this.hsD);
        MessageManager.getInstance().unRegisterListener(this.hsE);
        MessageManager.getInstance().unRegisterListener(this.hIm);
        MessageManager.getInstance().unRegisterListener(this.bCb);
        MessageManager.getInstance().unRegisterListener(this.hoN);
        MessageManager.getInstance().unRegisterListener(this.hIn);
        MessageManager.getInstance().unRegisterListener(this.gNf);
        MessageManager.getInstance().unRegisterListener(this.hqN);
        MessageManager.getInstance().unRegisterListener(this.hsI);
        MessageManager.getInstance().unRegisterListener(this.bEA);
        MessageManager.getInstance().unRegisterListener(this.bEB);
        MessageManager.getInstance().unRegisterListener(this.hIj);
        MessageManager.getInstance().unRegisterListener(this.brP);
        MessageManager.getInstance().unRegisterListener(this.brQ);
        MessageManager.getInstance().unRegisterListener(this.hIk);
        MessageManager.getInstance().unRegisterListener(this.hsK);
        MessageManager.getInstance().unRegisterListener(this.hsJ);
        MessageManager.getInstance().unRegisterListener(this.hsO);
        MessageManager.getInstance().unRegisterListener(this.hIk);
        MessageManager.getInstance().unRegisterListener(this.boE);
        MessageManager.getInstance().unRegisterListener(this.blY);
        MessageManager.getInstance().unRegisterListener(this.hdK);
        MessageManager.getInstance().unRegisterListener(this.gXw);
        MessageManager.getInstance().unRegisterListener(this.gXO);
        ccE().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.hIg != null) {
            this.hIg.aCV();
        }
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.huB.hBS.a(this.hIw, this.huB.hBM, this.hHf, alaLivePersonData);
        }
    }

    private void cif() {
        if (this.hHG != null) {
            this.huB.hBQ.startTime = System.currentTimeMillis();
            this.huB.hBQ.liveTotalTime = System.currentTimeMillis();
            this.huB.hBQ.sampleMemAndCPU();
            this.huB.hBO.a((short) 4, this.hHG);
        }
    }

    private void HV(String str) {
        String str2;
        int i;
        if (ccE() != null && ccE().pageContext != null) {
            this.hHy.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = ccE().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.hId == null) {
                    this.hId = layoutInflater.inflate(a.g.layout_challenge_entry_toast, (ViewGroup) null);
                    this.hId.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.chd()) {
                                AlaMasterLiveRoomOpearator.this.hHy.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.hId != null) {
                                    AlaMasterLiveRoomOpearator.this.ccE().hBu.removeView(AlaMasterLiveRoomOpearator.this.hId);
                                }
                                if (AlaMasterLiveRoomOpearator.this.hHW != null) {
                                    AlaMasterLiveRoomOpearator.this.hHW.ccI();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.hId.findViewById(a.f.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.h.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.hHy.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.ccE().hBu != null && AlaMasterLiveRoomOpearator.this.huI != null && AlaMasterLiveRoomOpearator.this.hId != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.hId.findViewById(a.f.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.hId.findViewById(a.f.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.v((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.hId.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.huI.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.huI.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.huI.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.huI.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.hId.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.hId.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.hId != null) {
                                AlaMasterLiveRoomOpearator.this.ccE().hBu.removeView(AlaMasterLiveRoomOpearator.this.hId);
                            }
                            AlaMasterLiveRoomOpearator.this.ccE().hBu.addView(AlaMasterLiveRoomOpearator.this.hId, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.ae.a.Qj().buX != null) {
                    i = com.baidu.live.ae.a.Qj().buX.aMc;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.hHy.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.ccE().hBu != null && AlaMasterLiveRoomOpearator.this.hId != null) {
                            AlaMasterLiveRoomOpearator.this.ccE().hBu.removeView(AlaMasterLiveRoomOpearator.this.hId);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bVt() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            com.baidu.live.data.ab Fm = ccE().hBt.Fm();
            if (Fm != null) {
                bVar.setAnchorId(Fm.mLiveInfo.user_id);
                bVar.setParams();
                bVar.setTag(this.gOC);
                MessageManager.getInstance().sendMessage(bVar);
            }
        }
    }

    public void cig() {
        if (ccE().pageContext.getPageActivity() instanceof Activity) {
            Activity pageActivity = ccE().pageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity.isDestroyed() || pageActivity.isFinishing()) {
                    return;
                }
            } else if (pageActivity.isFinishing()) {
                return;
            }
        }
        boolean z = com.baidu.live.d.xc().getBoolean("new_anchor_club_rename", true);
        aw cjo = ccE().hBt.cjo();
        if (cjo != null && this.biY != null && cjo.aOk == 1 && z) {
            ccE().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
            com.baidu.live.d.xc().putBoolean("new_anchor_club_rename", false);
            View inflate = View.inflate(ccE().pageContext.getPageActivity(), a.g.dialog_help_guard_club_rename, null);
            this.gYy = new Dialog(ccE().pageContext.getPageActivity(), a.i.RegimentRenameDiolog);
            final Button button = (Button) inflate.findViewById(a.f.rename_confirm);
            button.setEnabled(false);
            button.setTextColor(ccE().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
            final EditText editText = (EditText) inflate.findViewById(a.f.guard_club_rename_edittext);
            final TextView textView = (TextView) inflate.findViewById(a.f.hint_num);
            ((Button) inflate.findViewById(a.f.rename_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.63
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.gXU = null;
                    AlaMasterLiveRoomOpearator.this.gYy.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.64
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (editText.getText().toString() != null) {
                        AlaMasterLiveRoomOpearator.this.gXU = editText.getText().toString();
                        if (AlaMasterLiveRoomOpearator.this.biY != null && AlaMasterLiveRoomOpearator.this.gXU != null) {
                            if (BdNetTypeUtil.isNetWorkAvailable()) {
                                AlaMasterLiveRoomOpearator.this.k(AlaMasterLiveRoomOpearator.this.biY.id, AlaMasterLiveRoomOpearator.this.gXU, "");
                            } else {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity(), "网络故障，请刷新重试");
                            }
                        } else {
                            return;
                        }
                    }
                    AlaMasterLiveRoomOpearator.this.gYy.dismiss();
                }
            });
            editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.65
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    String obj = editText.getText().toString();
                    if (obj.length() == 0) {
                        textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        textView.setText("0");
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                    }
                    if (obj.length() > 0) {
                        int i4 = 0;
                        int i5 = 0;
                        for (int i6 = 0; i6 < obj.length(); i6++) {
                            String substring = obj.substring(i6, i6 + 1);
                            if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity(), "仅支持中英文及数字");
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
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity(), "不能超过3个字符");
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
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                            } else {
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccE().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                            }
                        }
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gYy.setContentView(inflate);
            this.gYy.setCanceledOnTouchOutside(true);
            inflate.setMinimumHeight((int) (com.baidu.tieba.ala.liveroom.g.f.getScreenHeight(ccE().pageContext.getPageActivity()) * 0.22f));
            Window window = this.gYy.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (com.baidu.tieba.ala.liveroom.g.f.getScreenWidth(ccE().pageContext.getPageActivity()) * 0.74f);
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            this.gYy.show();
        }
    }

    public void k(int i, String str, String str2) {
        com.baidu.tieba.ala.liveroom.messages.e eVar = new com.baidu.tieba.ala.liveroom.messages.e();
        eVar.fq(i);
        eVar.GR(str);
        eVar.GS(str2);
        eVar.setParams();
        MessageManager.getInstance().sendMessage(eVar);
    }
}
