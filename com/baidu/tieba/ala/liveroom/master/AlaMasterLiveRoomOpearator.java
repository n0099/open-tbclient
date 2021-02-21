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
import com.baidu.tieba.ala.liveroom.data.d;
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
    private static final String hGX;
    private BdUniqueId bEx;
    private boolean bEy;
    private boolean bEz;
    private com.baidu.live.an.a bgE;
    private com.baidu.live.guardclub.a biY;
    private boolean bqD;
    private PendantParentView byA;
    private boolean gQF;
    private Dialog gYM;
    private String gYi;
    private boolean hGH;
    private boolean hGY;
    private View hHA;
    private boolean hHB;
    private AlaLiveFaceVerifyView hHC;
    private ImageView hHD;
    private ImageView hHE;
    private ImageView hHF;
    private ImageView hHG;
    private ImageView hHH;
    private ImageView hHI;
    private ImageView hHJ;
    private TextView hHK;
    private ax hHL;
    private com.baidu.live.n.b hHN;
    private com.baidu.live.ag.a hHO;
    private com.baidu.tieba.ala.liveroom.master.panel.b hHP;
    private com.baidu.live.af.a hHQ;
    private ImageView hHR;
    private BdAlertDialog hHS;
    private BdAlertDialog hHT;
    private d hHU;
    private com.baidu.tieba.ala.liveroom.g.d hHa;
    private com.baidu.tieba.ala.liveroom.m.a hHb;
    private com.baidu.tieba.ala.liveroom.a.a hHc;
    private com.baidu.tieba.ala.liveroom.t.a hHd;
    private com.baidu.tieba.ala.liveroom.v.a hHe;
    private b hHf;
    private com.baidu.tieba.ala.liveroom.tippop.a hHg;
    private e hHh;
    private com.baidu.live.t.b hHi;
    private com.baidu.live.t.b hHj;
    private f hHk;
    private com.baidu.live.t.d hHl;
    private c hHm;
    private com.baidu.live.v.b hHn;
    protected com.baidu.live.m.a hHo;
    protected com.baidu.live.guess.d hHp;
    protected com.baidu.live.am.b hHq;
    private AlaLiveCountDownView hHr;
    private AlaLiveStreamStatusView hHs;
    private RelativeLayout hHt;
    private RelativeLayout hHu;
    private RelativeLayout hHv;
    private RelativeLayout hHw;
    private RelativeLayout hHx;
    private FrameLayout hHy;
    private FrameLayout hHz;
    private short hIe;
    private com.baidu.tieba.ala.liveroom.g.b hIj;
    private com.baidu.tieba.ala.liveroom.challenge.e hIk;
    private com.baidu.live.al.a hIl;
    private com.baidu.live.b.a hIm;
    private com.baidu.live.guess.b hIn;
    private boolean hIo;
    private boolean hIq;
    private View hIr;
    private FrameLayout hIs;
    private boolean hIt;
    private com.baidu.tieba.ala.liveroom.o.a hIu;
    private String hoQ;
    private com.baidu.live.i.a hpR;
    protected com.baidu.live.ad.a hqG;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hqt;
    private com.baidu.tieba.ala.liveroom.m.a hqu;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hqx;
    private com.baidu.tieba.ala.liveroom.activeview.b hqz;
    private m hrE;
    private k hrF;
    private com.baidu.live.im.b.a hrG;
    private ad hrH;
    private ab hrI;
    protected ag hrT;
    protected com.baidu.live.l.a hrX;
    protected com.baidu.live.v.a hrY;
    protected com.baidu.live.t.a hrZ;
    private com.baidu.live.j.b hrq;
    private com.baidu.tieba.ala.liveroom.share.c hrs;
    private com.baidu.tieba.ala.liveroom.q.b hrt;
    protected com.baidu.live.a.a hsa;
    protected com.baidu.live.k.a hsb;
    protected com.baidu.live.t.c hsc;
    private com.baidu.live.aa.a hsh;
    protected com.baidu.live.s.a hsl;
    private boolean hsy;
    private com.baidu.tieba.ala.liveroom.data.e huP;
    private ImageView huW;
    private com.baidu.tieba.ala.liveroom.data.f huX;
    private boolean hGZ = false;
    private boolean hst = false;
    private Handler mHandler = new Handler();
    private Handler hHM = new Handler();
    private boolean hHV = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver hHW = null;
    private boolean hHX = false;
    private int hHY = 0;
    private int hHZ = 0;
    private int hIa = 0;
    private long hIb = 0;
    private long hIc = 0;
    private volatile boolean isBackground = false;
    private Intent hId = null;
    private int mOrientation = 1;
    private boolean hBV = false;
    private boolean hIf = false;
    private boolean hIg = true;
    private boolean huU = false;
    private boolean hIh = true;
    private boolean hIi = true;
    private int dLp = 0;
    private String otherParams = "";
    private Handler hIp = new Handler();
    private BdUniqueId gOQ = BdUniqueId.gen();
    private boolean mIsKeyboardOpen = false;
    private int bqH = 0;
    private Runnable hIv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.hpR != null) {
                AlaMasterLiveRoomOpearator.this.hpR.CU();
            }
        }
    };
    private com.baidu.live.al.b bOd = new com.baidu.live.al.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.al.b
        public boolean VD() {
            if (AlaMasterLiveRoomOpearator.this.hIk != null) {
                if (AlaMasterLiveRoomOpearator.this.hrZ != null) {
                    if (!AlaMasterLiveRoomOpearator.this.hIk.ccN() && !AlaMasterLiveRoomOpearator.this.hIk.ccO() && !AlaMasterLiveRoomOpearator.this.hrZ.Pi() && !AlaMasterLiveRoomOpearator.this.hrZ.Aq()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.hIk.ccN() && !AlaMasterLiveRoomOpearator.this.hIk.ccO()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.hrZ == null || AlaMasterLiveRoomOpearator.this.hrZ.Pi() || AlaMasterLiveRoomOpearator.this.hrZ.Aq()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.al.b
        public void VE() {
            if (AlaMasterLiveRoomOpearator.this.hIk != null) {
                AlaMasterLiveRoomOpearator.this.hIk.ccQ();
            }
        }

        @Override // com.baidu.live.al.b
        public void VF() {
            AlaMasterLiveRoomOpearator.this.hIq = true;
            AlaMasterLiveRoomOpearator.this.ccL().hBI.hRw = false;
            if (AlaMasterLiveRoomOpearator.this.hsa != null) {
                AlaMasterLiveRoomOpearator.this.hsa.aW(true);
                AlaMasterLiveRoomOpearator.this.hsa.aX(true);
            }
            AlaMasterLiveRoomOpearator.this.ccg();
        }

        @Override // com.baidu.live.al.b
        public void VG() {
            AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12.1
                @Override // java.lang.Runnable
                public void run() {
                    AlaMasterLiveRoomOpearator.this.hIq = false;
                    AlaMasterLiveRoomOpearator.this.ccL().hBI.hRw = false;
                    if (AlaMasterLiveRoomOpearator.this.hsa != null) {
                        AlaMasterLiveRoomOpearator.this.hsa.aW(false);
                        AlaMasterLiveRoomOpearator.this.hsa.aX(false);
                    }
                    AlaMasterLiveRoomOpearator.this.ccg();
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
                if (AlaMasterLiveRoomOpearator.this.huP.hCg != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.huP.hCg.f(list, false);
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
                if (AlaMasterLiveRoomOpearator.this.huP.hCg != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.huP.hCg.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener hsS = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.hrt == null) {
                        AlaMasterLiveRoomOpearator.this.hrt = new com.baidu.tieba.ala.liveroom.q.b();
                    }
                    AlaMasterLiveRoomOpearator.this.hrt.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener hsY = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hrX != null) {
                AlaMasterLiveRoomOpearator.this.hrX.Jo();
            }
        }
    };
    private CustomMessageListener hIw = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hsQ = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.68
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Hz(str);
            }
        }
    };
    private CustomMessageListener gNt = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.69
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.buF();
        }
    };
    private CustomMessageListener hrb = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.hrI.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hsW = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity(), a.h.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener hIx = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bgE != null) {
                com.baidu.live.data.ab Fm = AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm();
                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                cVar.url = ((String) customResponsedMessage.getData()) + "?anchor_id=" + ExtraParamsManager.getEncryptionUserId(String.valueOf(Fm.mLiveInfo.user_id)) + "&live_id=" + Fm.mLiveInfo.live_id + "&subapp_type=" + TbConfig.getSubappType();
                cVar.bWs = 0.64f;
                AlaMasterLiveRoomOpearator.this.bgE.a(cVar);
            }
        }
    };
    private CustomMessageListener hIy = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccL().hBI);
            if (AlaMasterLiveRoomOpearator.this.hHa == null || AlaMasterLiveRoomOpearator.this.hHa.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.vQ(0);
            }
            if (AlaMasterLiveRoomOpearator.this.hrF != null) {
                AlaMasterLiveRoomOpearator.this.hrF.Kd().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.hrF.Ke().hide();
            }
        }
    };
    private CustomMessageListener hsX = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.H(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm());
        }
    };
    private CustomMessageListener htc = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hrT != null) {
                    ((com.baidu.tieba.ala.liveroom.p.a) AlaMasterLiveRoomOpearator.this.hrT).a(officialNoticeData);
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
                    if (AlaMasterLiveRoomOpearator.this.hIj != null) {
                        if (!data.aCk || AlaMasterLiveRoomOpearator.this.bEx == null || !AlaMasterLiveRoomOpearator.this.hIo) {
                            if (AlaMasterLiveRoomOpearator.this.bEx != null && AlaMasterLiveRoomOpearator.this.bEx == data.aCj) {
                                if (data.aCd != null && data.aCd.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.hIo || AlaMasterLiveRoomOpearator.this.hHa.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.hIj.c(AlaMasterLiveRoomOpearator.this.ccL().hBY.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.bEz = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.ccL().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.bEx = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.ccL().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.hIj.a(AlaMasterLiveRoomOpearator.this.ccL().hBY.getVideoConfig(), AlaMasterLiveRoomOpearator.this.bEz);
                        if (!AlaMasterLiveRoomOpearator.this.bEz) {
                            AlaMasterLiveRoomOpearator.this.bEz = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.bEy) {
                    AlaMasterLiveRoomOpearator.this.ccL().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
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
                if (AlaMasterLiveRoomOpearator.this.ccL().hBY != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.ccL().hBY.setBeautyJsonPath(str);
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
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bqH == 6) {
                            AlaMasterLiveRoomOpearator.this.chl();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bqH = 0;
            }
        }
    };
    private View.OnClickListener hIz = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.hHE) {
                    AlaMasterLiveRoomOpearator.this.chr();
                    AlaMasterLiveRoomOpearator.this.hHP.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.hHD) {
                    if (view == AlaMasterLiveRoomOpearator.this.hHF) {
                        AlaMasterLiveRoomOpearator.this.buF();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.hHG) {
                        if (view != AlaMasterLiveRoomOpearator.this.hHI) {
                            if (view == AlaMasterLiveRoomOpearator.this.huW) {
                                if (AlaMasterLiveRoomOpearator.this.chk()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.hIk != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.hrZ != null) && AlaMasterLiveRoomOpearator.this.hrZ.Aq()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.hrZ.Pi() & (AlaMasterLiveRoomOpearator.this.hrZ != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hIk.ccN()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hIk.ccO()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.hIk.ccP();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hHH) {
                                if (AlaMasterLiveRoomOpearator.this.hHe != null) {
                                    aw cjv = AlaMasterLiveRoomOpearator.this.ccL().hBH.cjv();
                                    if (cjv == null || cjv.mLiveSdkInfo == null) {
                                        str = null;
                                        str2 = null;
                                    } else {
                                        str2 = String.valueOf(cjv.mLiveSdkInfo.mRoomId);
                                        str = cjv.mLiveSdkInfo.mCastIds != null ? cjv.mLiveSdkInfo.mCastIds.chatMCastId : null;
                                    }
                                    AlaMasterLiveRoomOpearator.this.hHe.ax("", str2, str);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hHJ) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.hIk.ccN() || AlaMasterLiveRoomOpearator.this.hIk.ccO() || AlaMasterLiveRoomOpearator.this.hrZ.Pi() || AlaMasterLiveRoomOpearator.this.hrZ.Aq()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.hIl != null) {
                                    AlaMasterLiveRoomOpearator.this.hIl.Vx();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.hHQ != null) {
                            AlaMasterLiveRoomOpearator.this.hHQ.QE();
                            AlaMasterLiveRoomOpearator.this.hHQ.cV(AlaMasterLiveRoomOpearator.this.chz());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "beauty"));
                        AlaMasterLiveRoomOpearator.this.hIo = false;
                        AlaMasterLiveRoomOpearator.this.oz(true);
                        AlaMasterLiveRoomOpearator.this.hHK.setVisibility(4);
                        com.baidu.live.d.xc().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.ae.a.Qj().buX.aNf == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qj().buX.aNe == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bqD) {
                        AlaMasterLiveRoomOpearator.this.chl();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bqH = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.chl();
                }
            }
        }
    };
    private CustomMessageListener hsR = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ax) {
                    AlaMasterLiveRoomOpearator.this.hst = true;
                    AlaMasterLiveRoomOpearator.this.hHL = (ax) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.hrF != null) {
                        AlaMasterLiveRoomOpearator.this.hrF.Kd().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.hrF != null) {
                        AlaMasterLiveRoomOpearator.this.hrF.Ke().show();
                        String nameShow = aVar.getNameShow();
                        if (aVar.extInfoJson != null) {
                            if (aVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                                str = aVar.extInfoJson.optString("mysterious_man_nickname");
                                if (TextUtils.isEmpty(str)) {
                                    str = "神秘人";
                                }
                                AlaMasterLiveRoomOpearator.this.hrF.Ke().setEditText(" @" + str + " ");
                            }
                        }
                        str = nameShow;
                        AlaMasterLiveRoomOpearator.this.hrF.Ke().setEditText(" @" + str + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.vQ(8);
                }
            }
        }
    };
    private CustomMessageListener hIA = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.ccL() != null && AlaMasterLiveRoomOpearator.this.ccL().hCe != null) {
                AlaMasterLiveRoomOpearator.this.ccL().hCe.sampleMemAndCPU();
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
                    AlaMasterLiveRoomOpearator.this.cih();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.ccL().hBH.vX(i);
            }
        }
    };
    private CustomMessageListener hpb = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.cia();
        }
    };
    private CustomMessageListener hdY = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.an.c)) {
                if (AlaMasterLiveRoomOpearator.this.bgE == null) {
                    AlaMasterLiveRoomOpearator.this.bgE = new com.baidu.live.an.a(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.bgE.a((com.baidu.live.an.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener hIB = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.Os()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.hHP != null) {
                            AlaMasterLiveRoomOpearator.this.hHP.oF(!alaSetPrivateResponseMessage.isSwitchOpen());
                            AlaMasterLiveRoomOpearator.this.hHP.ciI();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.ccL().hBY.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.hIl != null) {
                        AlaMasterLiveRoomOpearator.this.hIl.setMute(AlaMasterLiveRoomOpearator.this.ccL().hBY.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hHq != null) {
                        AlaMasterLiveRoomOpearator.this.hHq.setMute(AlaMasterLiveRoomOpearator.this.ccL().hBY.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hHg != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.hHg.a(AlaMasterLiveRoomOpearator.this.ccL().hCb, AlaMasterLiveRoomOpearator.this.ccL().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, 5000);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.ccL().pageContext.getString(a.h.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.hHg.wg(2);
                        AlaMasterLiveRoomOpearator.this.hHg.c(AlaMasterLiveRoomOpearator.this.ccL().hCb, string, 3);
                    }
                }
            }
        }
    };
    private e.a hIC = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cio() {
            AlaMasterLiveRoomOpearator.this.vP(a.h.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cip() {
            AlaMasterLiveRoomOpearator.this.vP(a.h.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a hID = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.liveroom.a.a
        public boolean dF(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void dG(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.ccL().bRf() == 1) {
                AlaMasterLiveRoomOpearator.this.ccL().hBY.stopRecord();
            }
        }
    };
    private IShareCallback hIE = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.hHV && AlaMasterLiveRoomOpearator.this.hHU != null) {
                AlaMasterLiveRoomOpearator.this.hHV = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.hHU);
            }
        }
    };
    private View.OnTouchListener hIF = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.ccL().hCe.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccL().hBI);
            AlaMasterLiveRoomOpearator.this.vQ(0);
            if (AlaMasterLiveRoomOpearator.this.hrF != null) {
                AlaMasterLiveRoomOpearator.this.hrF.Kd().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.hrF.Ke().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b hIG = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ciq() {
            AlaMasterLiveRoomOpearator.this.chm();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cir() {
            AlaMasterLiveRoomOpearator.this.hGH = AlaMasterLiveRoomOpearator.this.hHa.cez();
            AlaMasterLiveRoomOpearator.this.ccL().hCe.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.ccL().hCe.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.ccL().hCe.sampleMemAndCPU();
            d dVar = new d();
            dVar.hBS = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.ccL().bRf();
            dVar.title = AlaMasterLiveRoomOpearator.this.hHa.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hBT = AlaMasterLiveRoomOpearator.this.hHa.ceA();
            dVar.hBW = AlaMasterLiveRoomOpearator.this.hGH;
            dVar.hBV = AlaMasterLiveRoomOpearator.this.hHa.cex();
            dVar.hBU = AlaMasterLiveRoomOpearator.this.hHa.ceC();
            dVar.hBX = AlaMasterLiveRoomOpearator.this.hHa.cey();
            if (dVar.hBX) {
                if (AlaMasterLiveRoomOpearator.this.hHa.ceD()) {
                    AlaMasterLiveRoomOpearator.this.hHV = true;
                    AlaMasterLiveRoomOpearator.this.hHU = dVar;
                    AlaMasterLiveRoomOpearator.this.hHa.ceE();
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
            AlaMasterLiveRoomOpearator.this.ccL().pageContext.showToast(a.h.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.ccL().g((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cis() {
            AlaMasterLiveRoomOpearator.this.hIo = true;
            AlaMasterLiveRoomOpearator.this.oz(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean cit() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ciu() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
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
                AlaMasterLiveRoomOpearator.this.caB();
            }
        }
    };
    private com.baidu.live.liveroom.g.c hIH = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void Nd() {
            if (AlaMasterLiveRoomOpearator.this.hHe != null) {
                AlaMasterLiveRoomOpearator.this.hHe.oS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.hHQ != null) {
                        AlaMasterLiveRoomOpearator.this.hHQ.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hHQ != null) {
                    AlaMasterLiveRoomOpearator.this.hHQ.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.hHe != null) {
                    AlaMasterLiveRoomOpearator.this.hHe.oS(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.hrT != null) {
                    AlaMasterLiveRoomOpearator.this.hrT.bD(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a hII = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void ciA() {
            if (AlaMasterLiveRoomOpearator.this.hHC != null && AlaMasterLiveRoomOpearator.this.ccL().hCb.indexOfChild(AlaMasterLiveRoomOpearator.this.hHC) >= 0) {
                AlaMasterLiveRoomOpearator.this.ccL().hCb.removeView(AlaMasterLiveRoomOpearator.this.hHC);
                AlaMasterLiveRoomOpearator.this.hHC.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.hHC = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hrf = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void v(View view, int i) {
            com.baidu.live.data.ab Fm;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.cig();
            } else if (i == 14 && (Fm = AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm()) != null && Fm.aId != null && Fm.mLiveInfo != null && Fm.aIz != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity(), Fm.aId.userName, Long.toString(Fm.aId.userId), Long.toString(Fm.aId.charmCount), String.valueOf(Fm.mLiveInfo.group_id), String.valueOf(Fm.mLiveInfo.live_id), true, String.valueOf(Fm.aId.userId), Long.toString(Fm.aIz.userId), Fm.aIz.userName, Fm.aIz.portrait, AlaMasterLiveRoomOpearator.this.hqx.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Fm.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.hqx.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a hIJ = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
    };
    private g hIK = new g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };
    private Runnable hIL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        @Override // java.lang.Runnable
        public void run() {
            AlaMasterLiveRoomOpearator.this.cin();
        }
    };
    private HttpMessageListener gXK = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == AlaMasterLiveRoomOpearator.this.gOQ && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.biY != null) {
                AlaMasterLiveRoomOpearator.this.biY = guardClubInfoHttpResponseMessage.biY;
            }
        }
    };
    HttpMessageListener gYc = new HttpMessageListener(1021231) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
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
            AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity());
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity());
            if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = true;
                TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                Window window = AlaMasterLiveRoomOpearator.this.gYM.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.x = 0;
                attributes.y = 50;
                window.setAttributes(attributes);
            } else if (screenFullSize[1] - rect.height() <= statusBarHeight && AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = false;
                Window window2 = AlaMasterLiveRoomOpearator.this.gYM.getWindow();
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
        hGX = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    private void HS(String str) {
        if (!TextUtils.isEmpty(str) && this.hHN != null) {
            View KY = this.hHN.KY();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            KY.setLayoutParams(layoutParams);
            if (ccL().hBI.indexOfChild(KY) >= 0) {
                ccL().hBI.removeView(KY);
            }
            ccL().hBI.addView(KY);
            this.hHN.hg(str);
            KY.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.baidu.live.data.ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && com.baidu.live.ae.a.Qj().buX != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(ccL().pageContext.getPageActivity(), String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.mLiveInfo.user_id), com.baidu.live.ae.a.Qj().buX.aNa, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hz(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccL().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(ccL().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.Qj().buX.aMs;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? ccL().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt) : ccL().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(ccL().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caB() {
        int i = ccL().hBH.Fm().aId.isUegBlock;
        int i2 = ccL().hBH.Fm().aId.isBlock;
        String str = ccL().hBH.Fm().aId.userName;
        if (i > 0 || i2 > 0) {
            this.bqD = true;
            this.hrF.a(true, i, i2, str);
            return;
        }
        this.bqD = false;
        this.hrF.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.huP.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bpt == 1) {
                format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bpu);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.huP.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.huP.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chk() {
        if (this.hIl != null && this.hIl.Vy()) {
            BdUtilHelper.showToast(this.huP.pageContext.getPageActivity(), this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else if (this.hHq != null && this.hHq.Rm()) {
            BdUtilHelper.showToast(this.huP.pageContext.getPageActivity(), this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chl() {
        if (this.hrF != null) {
            this.hrF.Ke().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.hIk != null) {
            this.hIk.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chm() {
        if (ccL() != null && ccL().hBH != null) {
            ccL().hBH.cjo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bTs() != null && aVar.bTt() != null) {
            ccL().hBH.ey(aVar.bTs().getId(), aVar.bTt().getId());
        }
    }

    public void b(short s) {
        if (this.hIj != null) {
            this.hIj.b(s);
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
                    AlaMasterLiveRoomOpearator.this.hHX = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.hHX = false;
                }
                if (AlaMasterLiveRoomOpearator.this.hHY == 0) {
                    AlaMasterLiveRoomOpearator.this.hHY = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.hHZ == 0) {
                    AlaMasterLiveRoomOpearator.this.hHZ = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.hIa = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d dVar) {
        if (ccL() != null && ccL().hCc != null) {
            ccL().hCc.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.e eVar, String str) {
        this.huP = eVar;
        this.hoQ = str;
        this.hIu = new com.baidu.tieba.ala.liveroom.o.a(eVar.pageContext.getPageActivity());
    }

    protected com.baidu.tieba.ala.liveroom.data.e ccL() {
        return this.huP;
    }

    public int a(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.huX = fVar;
        this.hHW = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.hHW, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.hHg == null) {
            this.hHg = new com.baidu.tieba.ala.liveroom.tippop.a(this.huP.pageContext, null);
        }
        registerListener();
        this.hpR = new com.baidu.live.i.a();
        chI();
        chn();
        chq();
        Long[] lArr = new Long[1];
        this.hIb = lArr[0] == null ? 0L : lArr[0].longValue();
        this.hIc = lArr[0] != null ? lArr[0].longValue() : 0L;
        ccL().hBI.setOnTouchListener(this.hIF);
        this.hGY = SharedPrefHelper.getInstance().getBoolean(hGX, false);
        this.hHr = new AlaLiveCountDownView(ccL().pageContext.getPageActivity());
        this.hHr.setCount(3);
        this.hHr.setTextColor(ccL().pageContext.getPageActivity().getResources().getColor(a.c.sdk_white_alpha60));
        this.hHr.setTextSize(ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128));
        this.hHr.setTypeface(Typeface.DEFAULT_BOLD);
        this.hHr.setIncludeFontPadding(false);
        this.hHr.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void civ() {
                if (AlaMasterLiveRoomOpearator.this.ccL().hBI != null) {
                    AlaMasterLiveRoomOpearator.this.ccL().hBI.removeView(AlaMasterLiveRoomOpearator.this.hHr);
                }
            }
        });
        return 1;
    }

    private void chn() {
        CustomResponsedMessage runTask;
        if (this.hHo == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.m.a.class, ccL().pageContext)) != null && runTask.getData() != null) {
            this.hHo = (com.baidu.live.m.a) runTask.getData();
            this.hHo.c(ccL().pageContext);
        }
    }

    private void cho() {
        CustomResponsedMessage runTask;
        if (this.hHp == null && (runTask = MessageManager.getInstance().runTask(2913298, com.baidu.live.guess.d.class, ccL().pageContext)) != null && runTask.getData() != null) {
            this.hHp = (com.baidu.live.guess.d) runTask.getData();
            this.hHp.register();
        }
    }

    private void chp() {
        CustomResponsedMessage runTask;
        if (chw() && this.hHq == null && (runTask = MessageManager.getInstance().runTask(2913254, com.baidu.live.am.b.class, ccL().pageContext)) != null && runTask.getData() != null) {
            this.hHq = (com.baidu.live.am.b) runTask.getData();
            if (ccL() != null && ccL().hBH != null && ccL().hBH.Fm() != null) {
                this.hHq.setLiveShowData(ccL().hBH.Fm());
            }
            if (ccL() != null && ccL().hBY != null) {
                this.hHq.H(ccL().hBY);
                this.hHq.setMute(ccL().hBY.isMute());
            }
            if (this.hHq != null && this.hHz != null) {
                this.hHq.a(new com.baidu.live.am.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
                    @Override // com.baidu.live.am.a
                    public boolean Ro() {
                        if ((AlaMasterLiveRoomOpearator.this.hrZ != null) && AlaMasterLiveRoomOpearator.this.hrZ.Aq()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                            return false;
                        }
                        if ((AlaMasterLiveRoomOpearator.this.hrZ != null) & AlaMasterLiveRoomOpearator.this.hrZ.Pi()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                            return false;
                        } else if (AlaMasterLiveRoomOpearator.this.hIk == null || !AlaMasterLiveRoomOpearator.this.hIk.ccN()) {
                            if (AlaMasterLiveRoomOpearator.this.hIk == null || !AlaMasterLiveRoomOpearator.this.hIk.ccO()) {
                                return true;
                            }
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        } else {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        }
                    }
                });
                View enterView = this.hHq.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hHz.setVisibility(0);
                    this.hHz.addView(enterView);
                }
            }
            if (this.hHq != null) {
                this.hHq.Y(ccL().hBZ);
            }
            if (this.hHq != null && ccL().hCa != null) {
                this.hHq.a(ccL().hCa);
            }
        }
    }

    private void chq() {
        View rootLayout;
        if (this.hHo != null && this.hHy != null && (rootLayout = this.hHo.cB(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hHy.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chr() {
        if (this.hHP == null) {
            this.hHP = new com.baidu.tieba.ala.liveroom.master.panel.b(ccL().pageContext.getPageActivity(), ccL().bRf() == 2);
            this.hHP.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oB(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccL().hBY.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oC(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccL().hBY.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oD(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccL().hBY.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.cif();
                    if (AlaMasterLiveRoomOpearator.this.hHg != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.hHg.c(AlaMasterLiveRoomOpearator.this.ccL().hCb, AlaMasterLiveRoomOpearator.this.ccL().pageContext.getString(a.h.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.hHg.c(AlaMasterLiveRoomOpearator.this.ccL().hCb, AlaMasterLiveRoomOpearator.this.ccL().pageContext.getString(a.h.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oE(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.g(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciw() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.ccL().hBH != null && AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm() != null && AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hHP != null) {
                        AlaMasterLiveRoomOpearator.this.hHP.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.a(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void cix() {
                    if (AlaMasterLiveRoomOpearator.this.hHP != null) {
                        AlaMasterLiveRoomOpearator.this.hHP.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new i(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciy() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.ccL() != null && AlaMasterLiveRoomOpearator.this.ccL().hBH != null && AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm() != null && AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(AlaMasterLiveRoomOpearator.this.ccL().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.hHP != null) {
                            AlaMasterLiveRoomOpearator.this.hHP.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciz() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.ccL() == null || AlaMasterLiveRoomOpearator.this.ccL().hBH == null || AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm() == null || AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.ccL() != null && AlaMasterLiveRoomOpearator.this.ccL().hBH != null && AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm() != null && AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.hHP != null) {
                                        AlaMasterLiveRoomOpearator.this.hHP.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.huP.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.hHP != null) {
                        AlaMasterLiveRoomOpearator.this.hHP.dismiss();
                    }
                }
            });
        }
        chs();
    }

    private void chs() {
        if (this.hHP != null) {
            boolean isBackCamera = ccL().hBY.isBackCamera();
            this.hHP.setIsBackCamera(ccL().hBY.isBackCamera());
            this.hHP.S(ccL().hBY.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = ccL().hBY.isPushMirror();
            if (this.hIg) {
                isPushMirror = cie() || isPushMirror;
                this.hIg = false;
            }
            this.hHP.T(isPushMirror, isBackCamera ? false : true);
            this.hHP.oF(ccL().hBY.isMute());
            this.hHP.ciI();
        }
    }

    public void cht() {
        if (this.huX != null) {
            if (this.huX.hCh == null || this.huX.hCh.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.hHA == null) {
                        this.hHA = this.huP.hCg.MD();
                        this.huP.hCb.addView(this.hHA, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.hHa == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (ccL().hBH != null && ccL().hBH.Fm() != null && ccL().hBH.Fm().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", ccL().hBH.Fm().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", ccL().hBH.Fm().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.hHa = new com.baidu.tieba.ala.liveroom.g.d(ccL().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    ccL().hCe.prepareTime = System.currentTimeMillis();
                    ccL().hCb.addView(this.hHa.getView(), layoutParams);
                    this.hHa.a(this.hIE);
                }
                this.hHa.oi(this.hBV);
                this.hHa.a(this.hIG);
                this.hHa.a(this.hIC);
                this.hHa.a(ccL().hBY, ccL().bRf());
                this.hHa.a(this.hHo);
                return;
            }
            this.hGH = this.huX.hCh.mLiveInfo.screen_direction == 2;
            if (this.huX.hCh.mLiveInfo.isAudioOnPrivate == 1) {
                ccL().hBY.setMute(true);
                if (this.hIl != null) {
                    this.hIl.setMute(ccL().hBY.isMute());
                }
                if (this.hHq != null) {
                    this.hHq.setMute(ccL().hBY.isMute());
                }
                if (this.hHg == null) {
                    this.hHg = new com.baidu.tieba.ala.liveroom.tippop.a(this.huP.pageContext, null);
                }
                if (!this.hHg.wf(2)) {
                    this.hHg.a(ccL().hCb, ccL().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, 5000);
                }
            }
            d dVar = new d();
            dVar.hBS = true;
            dVar.forumId = String.valueOf(this.huX.hCh.mLiveInfo.forum_id);
            dVar.forumName = this.huX.hCh.mLiveInfo.forum_name;
            dVar.liveType = this.huX.hCh.mLiveInfo.live_type;
            dVar.title = this.huX.hCh.mLiveInfo.getLiveTitle();
            dVar.clarity = this.huX.hCh.mLiveInfo.clarity;
            dVar.gameId = this.huX.hCh.mLiveInfo.game_id;
            dVar.gameName = this.huX.hCh.mLiveInfo.game_label;
            dVar.hBW = this.huX.hCh.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void chu() {
        if (this.hIj != null) {
            this.hIj.a(ccL().hBY.getVideoConfig(), false);
        }
        if (this.hHa != null) {
            this.hHa.oh(true);
        }
        if (ccL().hBY.hasBeauty() >= 0) {
            ccL().hBY.setBeauty(com.baidu.live.d.xc().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            ccL().hCg.E(this.huP.hBY);
        } else if (this.hHa != null) {
            this.hHa.oh(true);
        }
        chH();
    }

    public void d(d dVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.hHA != null && this.hHA.getParent() != null) {
                ((ViewGroup) this.hHA.getParent()).removeView(this.hHA);
                this.hHA = null;
            }
            ccL().hBI.setVisibility(0);
            this.huP.hCg.a(ccL().hBI);
        } else {
            chP();
            cid();
            if (this.hIs != null) {
                this.hIs.setVisibility(0);
            }
            this.hHe = new com.baidu.tieba.ala.liveroom.v.a(ccL().pageContext, this.hID);
            this.hHe.c(ccL().hBI, true);
            this.hHe.oS(true);
            if (this.hrF != null && this.hrF.Kd() != null) {
                this.hrF.Kd().setNeedTopAlphaShade(true);
            }
        }
        ccL().hBY.setPushMirror(cie());
    }

    public void b(aw awVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.huP.hCg.l(ccL().hBH.Fm());
        }
        if (!ccL().hBY.isBackground() && ccL().hBH.Fm() != null && ccL().hBH.Fm().mLiveInfo != null) {
            int startPush = ccL().hBY.startPush(ccL().hBH.Fm().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.huP.hCg.ME();
            }
            if (startPush != 0 && ccL().hCe != null) {
                ccL().hCe.errCode = 4;
                ccL().hCe.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (awVar != null && !awVar.Cu() && !cib()) {
                oA(true);
                cic();
            }
            if (this.hqu != null) {
                this.hqu.N(ccL().hBH.Fm());
            }
            if (this.hrq != null) {
                this.hrq.a(ccL().hBH.Fm());
            }
            if (this.hHo != null) {
                this.hHo.h(ccL().hBH.Fm());
                this.hHo.hj(this.otherParams);
            }
            if (this.hqu != null) {
                this.hqu.ou(true);
            }
            if (this.hHb != null) {
                this.hHb.N(ccL().hBH.Fm());
            }
            if (awVar == null || awVar.aId == null) {
                z = com.baidu.live.d.xc().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = awVar.aId.canUseChallenge;
                com.baidu.live.d.xc().putBoolean("ala_master_can_use_challenge", z);
            }
            cby();
            chQ();
            chA();
            oy(z);
            cal();
            chR();
            chX();
            O(ccL().hBH.Fm());
            f(ccL().hBH.Fm());
            chY();
            chv();
            chU();
            cbt();
            cak();
            cbv();
            caj();
            chV();
            cbo();
            cbp();
            chN();
            chO();
            P(ccL().hBH.Fm());
            chW();
            cbs();
            cbf();
            Q(ccL().hBH.Fm());
            cho();
            MessageManager.getInstance().registerListener(this.gXK);
            MessageManager.getInstance().registerListener(this.gYc);
            aw cjv = ccL().hBH.cjv();
            if (cjv != null && cjv.aOk == 1) {
                bVA();
                this.hIp.postDelayed(this.hIL, IMConnection.RETRY_DELAY_TIMES);
            }
            if (this.hrE != null) {
                this.hrE.g(ccL().hBH.Fm());
            }
            if (this.hrF != null) {
                if (ccL().hBH.Fm() != null && ccL().hBH.Fm().aIR != null && ccL().hBH.Fm().aIR.Bf()) {
                    z2 = true;
                }
                this.hrF.a(String.valueOf(ccL().hBH.Fm().mLiveInfo.group_id), String.valueOf(ccL().hBH.Fm().mLiveInfo.last_msg_id), String.valueOf(ccL().hBH.Fm().aId.userId), String.valueOf(ccL().hBH.Fm().mLiveInfo.live_id), ccL().hBH.Fm().aId.appId, z2, ccL().hBH.Fm().getGuardName());
            }
            if (this.hrG != null) {
                this.hrG.a(ccL().hBH.Fm(), true);
            }
            chx();
            chp();
            cbC();
            this.mHandler.post(this.hIv);
            if (this.hIu != null && !this.hIu.hKZ) {
                this.hIu.cjM();
            }
        }
    }

    protected void cbC() {
        if (this.hsl == null && ccL() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.s.a.class, ccL().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hsl = (com.baidu.live.s.a) runTask.getData();
                this.hsl.p(ccL().hBI);
            }
        }
    }

    private void chv() {
        if (this.hHc != null && ccL() != null && ccL().hBH != null) {
            if (this.hHc.aG(this.hHv)) {
                this.hHc.C(ccL().hBH.Fm());
            } else {
                this.hHc.d(this.hHv, ccL().hBH.Fm());
            }
        }
    }

    private void cal() {
        if (this.byA == null) {
            this.byA = new PendantParentView(ccL().pageContext.getPageActivity(), cch());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            ccL().hBI.addView(this.byA, layoutParams);
            this.byA.setDefaultItemMargin(ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.byA.setPadding(ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            ccg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccg() {
        if (this.byA != null) {
            int dimensionPixelSize = ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278);
            int dimensionPixelSize2 = ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.byA.getLayoutParams();
            if (this.gQF) {
                this.byA.setPosition(0, 0, this.hIk.ccs(), dimensionPixelSize2);
            } else {
                this.byA.setPosition(dimensionPixelSize, 0, ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds380), dimensionPixelSize2);
            }
            this.byA.setLayoutParams(layoutParams);
            this.byA.setModel(cch());
        }
    }

    private PendantParentView.Model cch() {
        if (this.gQF) {
            return PendantParentView.Model.VERTICAL_PK;
        }
        if (this.hIq) {
            return PendantParentView.Model.VERTICAL_BB_CHATING;
        }
        return PendantParentView.Model.VERTICAL;
    }

    private void cci() {
        if (this.hrF != null && this.hrF.Kd() != null && this.hrF.Kd().getView() != null) {
            if (this.gQF && !this.hGZ && ccL().hBI != null && ccL().hBI.getHeight() > 0) {
                int bp = this.hIk != null ? this.hIk.bp(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.hrF.Kd().getView().getLayoutParams();
                int height = ccL().hBI.getHeight() - bp;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.hrF.Kd().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int j = com.baidu.live.aj.c.j(false, this.hGZ);
            if (ccL().hBI.indexOfChild(this.hrF.Kd().getView()) != -1 && this.hrF.Kd().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrF.Kd().getView().getLayoutParams();
                layoutParams2.height = j;
                this.hrF.Kd().getView().setLayoutParams(layoutParams2);
            }
            this.hrF.Kd().Kc();
        }
    }

    private void ccj() {
        if (this.hrH != null) {
            if (this.gQF && !this.hGZ && ccL().hBI != null && ccL().hBI.getHeight() > 0) {
                this.hrH.cH((ccL().hBI.getHeight() - (this.hIk != null ? h.p(ccL().pageContext.getPageActivity(), true) : 0)) + ccL().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height));
            } else {
                this.hrH.cH(com.baidu.live.aj.a.b(ccL().pageContext.getPageActivity(), true, false, this.hGZ));
            }
        }
    }

    private void cck() {
        int i;
        if (this.hrH != null) {
            int i2 = com.baidu.live.aj.a.i(true, false);
            if (!this.gQF || ccL().hBI == null || ccL().hBI.getHeight() <= 0) {
                i = i2;
            } else {
                i = (ccL().hBI.getHeight() - (this.hIk != null ? this.hIk.bp(false) : 0)) + ccL().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
            }
            this.hrH.cI(i);
        }
    }

    private void ccl() {
        if (this.hrG != null && this.hrG.zP() != null) {
            ViewGroup.LayoutParams layoutParams = this.hrG.zP().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ccL().pageContext.getResources().getDimensionPixelOffset(this.gQF ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hrG.zP().setLayoutParams(layoutParams);
            }
        }
    }

    private boolean chw() {
        AlaVideoBCChatData alaVideoBCChatData;
        AlaLiveInfoData alaLiveInfoData = ccL().hBH.Fm().mLiveInfo;
        if (alaLiveInfoData == null || (alaVideoBCChatData = alaLiveInfoData.videoBCEnterData) == null) {
            return false;
        }
        return alaVideoBCChatData.isShowEnter();
    }

    private void chx() {
        if (this.hHq == null && !chw()) {
            boolean z = (ccL().hBH == null || ccL().hBH.cjv() == null || ccL().hBH.cjv().mLiveInfo.videoBBChatData == null || !ccL().hBH.cjv().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
            if (!z && ccL().hBH != null && ccL().hBH.Fm() != null && ccL().hBH.Fm().mLiveInfo != null && ccL().hBH.Fm().mLiveInfo.videoBBChatData != null && ccL().hBH.Fm().aIN) {
                z = ccL().hBH.Fm().mLiveInfo.videoBBChatData.videoBBChatSwitch;
            }
            if (this.hHJ != null) {
                this.hHJ.setVisibility(z ? 0 : 8);
            }
            chy();
        }
    }

    private void chy() {
        CustomResponsedMessage runTask;
        if (this.hIl == null && (runTask = MessageManager.getInstance().runTask(2913249, com.baidu.live.al.a.class, ccL().pageContext)) != null && runTask.getData() != null) {
            this.hIl = (com.baidu.live.al.a) runTask.getData();
        }
        if (this.hIl != null) {
            this.hIl.w((ViewGroup) ccL().rootView.findViewById(a.f.ala_live_video_chat_pendant));
            this.hIl.v(ccL().hCb);
            this.hIl.t(ccL().hBH.Fm());
            this.hIl.H(ccL().hBY);
            this.hIl.a(ccL().hCa);
            this.hIl.a(this.bOd);
            if (ccL().hBY != null) {
                this.hIl.setMute(ccL().hBY.isMute());
            }
        }
    }

    private void oy(boolean z) {
        if (this.hIk == null) {
            this.hIk = new com.baidu.tieba.ala.liveroom.challenge.e(ccL());
        }
        this.hIk.a(this.huW, this.huX, z);
        this.hIk.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(bg bgVar, bk bkVar, bk bkVar2) {
                AlaMasterLiveRoomOpearator.this.gQF = true;
                AlaMasterLiveRoomOpearator.this.ccL().hBI.hRw = false;
                if (AlaMasterLiveRoomOpearator.this.hHQ != null) {
                    AlaMasterLiveRoomOpearator.this.hHQ.dY(4);
                    AlaMasterLiveRoomOpearator.this.hHQ.cV(true);
                }
                AlaMasterLiveRoomOpearator.this.Xe();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void Aw() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hIv);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void ccJ() {
                AlaMasterLiveRoomOpearator.this.gQF = false;
                AlaMasterLiveRoomOpearator.this.ccL().hBI.hRw = false;
                if (AlaMasterLiveRoomOpearator.this.hHQ != null) {
                    AlaMasterLiveRoomOpearator.this.hHQ.dY(0);
                    AlaMasterLiveRoomOpearator.this.hHQ.cV(false);
                }
                AlaMasterLiveRoomOpearator.this.ccr();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void ccK() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hIv);
            }
        });
        this.hIk.P(this.hGH, z);
        this.hIk.k(this.hGH, z, (this.huX == null || this.huX.hCh == null || this.huX.hCh.mChallengeData == null) ? false : true);
    }

    public boolean chz() {
        return this.hIk != null && this.hIk.ccS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xe() {
        if (this.hHf != null) {
            this.hHf.setVisible(8);
            this.hHf.setCanVisible(false);
        }
        if (this.hIm != null) {
            this.hIm.setCanVisible(false);
            this.hIm.refreshUI();
        }
        if (this.hHc != null) {
            this.hHc.setVisibility(8);
        }
        if (this.hqz != null) {
            this.hqz.aW(true);
        }
        if (this.hHs != null) {
            this.hHs.setCanVisible(false);
            this.hHs.setVisibility(8);
        }
        if (this.hHe != null) {
            this.hHB = this.hHe.clS();
            this.hHe.oR(false);
        }
        if (this.hrZ != null) {
            this.hrZ.setCanVisible(false);
        }
        if (this.hsa != null) {
            this.hsa.aW(true);
            this.hsa.aX(true);
        }
        ccg();
        cci();
        ccj();
        cck();
        ccl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccr() {
        if (this.hHf != null) {
            this.hHf.setCanVisible(true);
        }
        if (this.hIm != null) {
            this.hIm.setCanVisible(true);
            this.hIm.refreshUI();
        }
        if (this.hHc != null) {
            this.hHc.setVisibility(0);
        }
        if (this.hqz != null) {
            this.hqz.aW(false);
        }
        if (this.hHs != null) {
            this.hHs.setCanVisible(true);
            if (this.hHs.clp()) {
                this.hHs.setVisibility(0);
            }
        }
        if (this.hHe != null) {
            this.hHe.oR(this.hHB);
        }
        if (this.hrZ != null) {
            this.hrZ.setCanVisible(true);
        }
        if (this.hsa != null) {
            this.hsa.aW(false);
            this.hsa.aX(false);
        }
        ccg();
        cci();
        ccj();
        cck();
        ccl();
    }

    private void chA() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.leftMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        if (this.hHs == null) {
            this.hHs = new AlaLiveStreamStatusView(ccL().pageContext.getPageActivity());
            this.hHs.setVisibility(8);
        }
        this.hHs.setId(a.f.ala_live_room_stream_view);
        this.hHs.setLayoutParams(layoutParams);
        if (this.hHs.getParent() == null && this.hHv != null) {
            this.hHv.addView(this.hHs, layoutParams);
        }
    }

    public void chB() {
        if (this.hHa != null && this.hHa.getVisibility() != 8 && ccL().hBY.getPreview() != null) {
            ccL().hBY.stopRecord();
        }
    }

    public void chC() {
        if (ccL().hBY.getPreview() != null) {
            ccL().hBY.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hIj != null) {
                this.hIj.og(false);
            }
            this.hIj = new com.baidu.tieba.ala.liveroom.g.b(ccL().hCb, ccL(), ccL().hBY);
            this.hIj.a(ccL().hBY.getVideoConfig(), false);
        }
        if (this.hHg != null) {
            this.hHg.ckM();
        }
        this.mHandler.post(this.hIv);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.hGZ = z;
        if (z) {
            if (this.hIi) {
                this.hIi = false;
                if (this.hrF != null && this.hrF.Kd() != null) {
                    this.hrF.Kd().getView().setBottom(0);
                }
                if (this.hrF != null && this.hrF.Ke() != null) {
                    this.hrF.Ke().getView().setBottom(0);
                }
            }
            if (this.hrH != null && this.hrH.EJ() != null) {
                this.hrH.EJ().setVisibility(8);
            }
            if (this.hrF != null && this.hrF.Kd() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrF.Kd().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132);
                this.hrF.Kd().getView().setLayoutParams(layoutParams);
            }
            if (this.hrF != null && this.hrF.Ke() != null && this.hrF.Ke().getView() != null && this.hrF.Ke().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrF.Ke().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.hrF.Ke().getView().setLayoutParams(layoutParams2);
                this.hrF.Ke().getView().setVisibility(0);
                this.hrF.Ke().Mg();
            }
            vQ(8);
            vO(8);
            if (this.hrI != null && this.hrI.Fl() != null) {
                this.hrI.Fl().setVisibility(8);
            }
            if (this.hsa != null) {
                this.hsa.setCanVisible(false);
            }
        } else {
            if (this.hrH != null && this.hrH.EJ() != null) {
                this.hrH.EJ().setVisibility(0);
            }
            if (this.hrF != null && this.hrF.Kd() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hrF.Kd().getView().getLayoutParams();
                layoutParams3.bottomMargin = ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132) - ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.hrF.Kd().getView().setLayoutParams(layoutParams3);
            }
            if (this.hrF != null && this.hrF.Ke() != null) {
                this.hrF.Ke().hide();
            }
            vQ(0);
            vO(0);
            if (this.hrI != null && this.hrI.Fl() != null) {
                this.hrI.Fl().setVisibility(0);
            }
            if (this.hHN != null && this.hHN.KY() != null) {
                this.hHN.KY().setVisibility(0);
            }
            if (this.hsa != null) {
                this.hsa.setCanVisible(true);
            }
        }
        if (this.hHa != null) {
            this.hHa.R(false, z);
        }
        if (this.hrG != null) {
            this.hrG.zQ();
        }
        if (this.hHQ != null) {
            this.hHQ.onKeyboardVisibilityChanged(z);
        }
        if (this.hsl != null) {
            this.hsl.onKeyboardVisibilityChanged(z);
        }
        if (this.hIl != null) {
            this.hIl.onKeyboardVisibilityChanged(z);
        }
        cci();
        this.mHandler.post(this.hIv);
    }

    private void vO(int i) {
        if (this.hqu != null) {
            this.hqu.vC(i);
        }
        if (this.hHu != null) {
            this.hHu.setVisibility(i);
        }
        if (this.hrq != null) {
            this.hrq.getView().setVisibility(i);
        }
        if (this.hHd != null) {
            this.hHd.setVisible(i);
        }
        if (this.hHc != null) {
            this.hHc.setVisibility(i);
        }
        if (this.hqz != null) {
            this.hqz.setVisible(i);
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(i == 0);
        }
        if (this.hsc != null) {
            this.hsc.setVisible(i);
        }
        if (this.hrX != null) {
            this.hrX.setCanVisible(i == 0);
        }
        if (this.hrZ != null) {
            this.hrZ.setCanVisible(i == 0 && !this.gQF);
        }
        if (this.hqG != null) {
            this.hqG.cT(i == 0);
        }
        if (this.hIm != null) {
            this.hIm.setCanVisible(i == 0);
            this.hIm.refreshUI();
        }
        if (this.hHv != null) {
            this.hHv.setVisibility(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            ccL().hCe.errCode = 1;
            vP(a.h.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            vP(a.h.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            vP(a.h.stream_upload_exception);
        } else if (i == -2) {
            HT(ccL().pageContext.getResources().getString(a.h.preview_init_failed_dialog_msg));
            ccL().hBY.stopRecord();
        } else if (i == -3 && this.hHa != null) {
            this.hHa.oh(false);
        }
        if (i == -4) {
            if (this.hHa == null || this.hHa.getView().getParent() == null) {
                ccL().g((short) 1);
                return;
            }
            this.hHa.ceB();
            this.hHG.setVisibility(0);
            if (this.hHe != null) {
                this.hHe.oS(true);
            }
            ccL().hBI.setBackgroundColor(ccL().pageContext.getResources().getColor(17170445));
            cik();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        awo();
        if (i == 12001) {
            if (i2 == -1) {
                HU(P(intent));
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
            jSONObject.put("status", this.hHa == null || this.hHa.getView().getParent() == null || this.hHa.getVisibility() != 0 ? "live" : "action");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_ACTION, "").setContentExt(jSONObject));
        if (this.hHa != null) {
            this.hHa.onResume();
        }
        if (this.hHV && this.hHU != null) {
            this.hHV = false;
            c(this.hHU);
        }
        if (this.hrT != null) {
            this.hrT.onResume();
        }
    }

    public void h(short s) {
        if (this.hrE != null) {
            this.hrE.Fy();
        }
        if (this.hrF != null) {
            this.hrF.a(null);
            this.hrF.zR();
        }
        if (this.hrG != null) {
            this.hrG.zR();
        }
        if (this.hIk != null) {
            this.hIk.ccR();
        }
        if (this.hIn != null) {
            this.hIn.IZ();
        }
        if (this.hHp != null) {
            this.hHp.unRegister();
        }
    }

    public boolean chD() {
        com.baidu.live.data.ab Fm = ccL().hBH.Fm();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.huP.hCg.k(Fm);
            if (Fm != null && Fm.mLiveInfo.live_status != 1) {
                cii();
                ccL().pageContext.getPageActivity().finish();
                if (ccL().hBH == null || ccL().hBH.Fm() == null) {
                    return true;
                }
                a(Fm, 1, ccL().hBH.cjE() != 1 ? ccL().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                return true;
            }
        } else {
            if (this.hrF != null) {
                this.hrF.Kd().a(String.valueOf(Fm.mLiveInfo.group_id), String.valueOf(Fm.mLiveInfo.live_id), true, String.valueOf(Fm.aId.userId), Fm.getGuardName());
            }
            if (this.hrG != null) {
                this.hrG.a(Fm);
            }
            if (this.hrq != null) {
                this.hrq.a(ccL().hBH.Fm());
            }
            if (this.hqu != null) {
                this.hqu.N(Fm);
            }
            if (Fm != null) {
                if (this.hIk != null) {
                    this.hIk.a(Fm);
                }
                if (this.hrI != null && Fm.mLiveInfo != null) {
                    this.hrI.a(Fm.mLiveInfo, Fm.aId);
                }
                if (this.hsh != null) {
                    this.hsy = this.hsh.p(Fm);
                }
                if (this.hqz != null) {
                    this.hqz.nI(this.hsy);
                    this.hqz.j(Fm);
                    this.hqz.updateView();
                }
                if (this.hrX != null) {
                    this.hrX.a(Fm);
                }
                if (this.hrZ != null) {
                    this.hrZ.a(Fm);
                }
                if (this.hrY != null) {
                    this.hrY.a(Fm);
                }
                if (this.hHn != null) {
                    this.hHn.a(Fm);
                }
                if (this.hsa != null) {
                    this.hsa.a(Fm);
                }
                if (this.hsb != null) {
                    this.hsb.a(Fm);
                }
                if (this.hsc != null) {
                    this.hsc.a(Fm);
                }
                if (Fm.mLiveInfo.live_status != 1) {
                    cii();
                    ccL().pageContext.getPageActivity().finish();
                    if (ccL().hBH == null || ccL().hBH.Fm() == null) {
                        return true;
                    }
                    a(Fm, 1, ccL().hBH.cjE() != 1 ? ccL().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                    return true;
                } else if (this.hHo != null) {
                    this.hHo.i(Fm);
                }
            }
        }
        return false;
    }

    public void chE() {
        chs();
    }

    public void chF() {
        if (this.hIj != null) {
            this.hIj.cev();
        }
        if (this.hIl != null) {
            this.hIl.VA();
        }
    }

    public void chG() {
        if (this.hHa != null && this.hHa.getVisibility() != 8) {
            if (ccL().bRf() == 2) {
                cik();
            } else {
                cij();
            }
        }
        if (this.hHa != null && this.hHa.getVisibility() != 8) {
            if (ccL().bRf() == 1) {
                this.hHa.onResume();
            }
            this.hHa.onRefresh();
        }
        if (this.hHo != null) {
            this.hHo.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.hst && this.hHL != null) {
            if (this.hrF != null) {
                this.hrF.Kd().getView().setVisibility(0);
            }
            if (this.hrF != null) {
                this.hrF.Ke().show();
                String nameShow = this.hHL.getNameShow();
                if (this.hHL.extInfoJson != null) {
                    if (this.hHL.extInfoJson.optInt("is_mysterious_man") == 1) {
                        nameShow = this.hHL.extInfoJson.optString("mysterious_man_nickname");
                        if (TextUtils.isEmpty(nameShow)) {
                            nameShow = "神秘人";
                        }
                    }
                }
                this.hrF.Ke().setEditText(" @" + nameShow + " ");
            }
            vQ(8);
            this.hst = false;
        }
        if (this.bgE != null) {
            this.bgE.resume();
        }
        if (this.hIl != null) {
            this.hIl.VB();
        }
    }

    public void onPause() {
        if (this.hHo != null) {
            this.hHo.onPause();
        }
        if (this.hrT != null) {
            this.hrT.onPause();
        }
        if (this.bgE != null) {
            this.bgE.pause();
        }
    }

    private void chH() {
        if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
            this.hHG.setVisibility(0);
            this.hHG.setAlpha(0.2f);
        } else if (ccL().hBY.hasBeauty() < 0) {
            this.hHG.setVisibility(8);
        } else {
            this.hHG.setVisibility(0);
        }
    }

    private void chI() {
        this.hHt = (RelativeLayout) ccL().rootView.findViewById(a.f.ala_live_unremovable_container);
        this.hHw = (RelativeLayout) ccL().rootView.findViewById(a.f.under_live_view_panel);
        this.hHx = (RelativeLayout) ccL().rootView.findViewById(a.f.over_live_view_panel);
        this.hHy = (FrameLayout) ccL().rootView.findViewById(a.f.goods_parent);
        this.hHz = (FrameLayout) ccL().rootView.findViewById(a.f.ala_live_bc_chat_container);
        this.huP.hBI.setOnLiveViewScrollListener(this.hIH);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hHw.setVisibility(8);
            this.hHx.setVisibility(8);
            ccL().hBI.removeAllViews();
            return;
        }
        this.hHu = (RelativeLayout) ccL().rootView.findViewById(a.f.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHu.getLayoutParams();
        layoutParams.topMargin = this.huP.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.hHu.setLayoutParams(layoutParams);
        this.hHv = (RelativeLayout) ccL().rootView.findViewById(a.f.ala_live_top_pendant_container);
        if (this.hqx == null) {
            this.hqx = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.huP.pageContext.getPageActivity(), true);
        }
        this.hqx.a(this.hrf);
        this.hqx.a(this.hHu, a.f.ala_live_room_host_header_stub, 1L);
        this.hqx.setVisible(0);
        chJ();
        this.hHG = (ImageView) ccL().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn);
        this.hHK = (TextView) ccL().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn_num);
        this.hHG.setOnClickListener(this.hIz);
        this.hHI = (ImageView) ccL().rootView.findViewById(a.f.ala_liveroom_host_paster);
        this.hHI.setOnClickListener(this.hIz);
        if (com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPK != null && com.baidu.live.ae.a.Qj().bAS.aPK.Cz() && bt.b(com.baidu.live.ae.a.Qj().bAS)) {
            this.hHI.setVisibility(0);
        } else {
            this.hHI.setVisibility(8);
        }
        chH();
        this.hHF = (ImageView) ccL().rootView.findViewById(a.f.ala_liveroom_host_share_btn);
        this.hHF.setOnClickListener(this.hIz);
        this.hHD = (ImageView) ccL().rootView.findViewById(a.f.ala_liveroom_host_message_btn);
        this.hHD.setOnClickListener(this.hIz);
        this.huW = (ImageView) ccL().rootView.findViewById(a.f.ala_liveroom_host_pk_btn);
        this.huW.setOnClickListener(this.hIz);
        this.hHJ = (ImageView) ccL().rootView.findViewById(a.f.ala_liveroom_host_vedio_chat);
        this.hHJ.setOnClickListener(this.hIz);
        this.hHE = (ImageView) ccL().rootView.findViewById(a.f.ala_liveroom_host_more);
        this.hHE.setOnClickListener(this.hIz);
        this.hHH = (ImageView) ccL().rootView.findViewById(a.f.ala_liveroom_host_zan_btn);
        this.hHH.setOnClickListener(this.hIz);
        chM();
        if (bt.b(com.baidu.live.ae.a.Qj().bAS)) {
            this.hIj = new com.baidu.tieba.ala.liveroom.g.b(ccL().hCb, ccL(), ccL().hBY);
        }
        this.hrE = new m();
        chK();
        chL();
        if (com.baidu.live.d.xc().getInt("beauty_new_bubble", 1) == 1) {
            this.hHK.setVisibility(0);
        }
    }

    private void chJ() {
        this.hIs = (FrameLayout) View.inflate(ccL().pageContext.getPageActivity(), a.g.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hIs != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.hIs.setVisibility(8);
            if (this.hIs.getParent() != null && (this.hIs.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hIs.getParent()).removeView(this.hIs);
            }
            this.hHt.addView(this.hIs, layoutParams);
            if (this.hIs != null) {
                this.hIs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.hrf.v(AlaMasterLiveRoomOpearator.this.hIs, 8);
                    }
                });
            }
        }
    }

    private void chK() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, ccL().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hrF = (k) runTask.getData();
            this.hrF.setFromMaster(true);
            this.hrF.Kd().getView().setId(a.f.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(ccL().pageContext.getPageActivity()) * 0.75f), com.baidu.live.aj.c.j(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.aj.c.dr(true);
            ccL().hBI.addView(this.hrF.Kd().getView(), layoutParams);
            this.hrF.Ke().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            ccL().hBI.addView(this.hrF.Ke().getView(), layoutParams2);
            this.hrF.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
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

    private void chL() {
        View zP;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, ccL().pageContext);
        if (runTask != null) {
            this.hrG = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hrG != null && (zP = this.hrG.zP()) != null && this.huP.hBI.indexOfChild(zP) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.huP.pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds98));
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            layoutParams.bottomMargin = ccL().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            ccL().hBI.addView(zP, layoutParams);
        }
    }

    private void chM() {
        CustomResponsedMessage runTask;
        if (this.hHO == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ag.a.class, ccL().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hHO = (com.baidu.live.ag.a) runTask.getData();
        }
    }

    private void chN() {
        View EI;
        ac.e(ccL().hBH.Fm());
        ac.b(ccL().pageContext, true, false);
        ac.Ft();
        if (this.hrH == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVn = true;
            fVar.context = ccL().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrH = (ad) runTask.getData();
                if (this.hrH != null && (EI = this.hrH.EI()) != null && ccL().hBI.indexOfChild(EI) < 0) {
                    if (EI.getParent() instanceof ViewGroup) {
                        ((ViewGroup) EI.getParent()).removeView(EI);
                    }
                    ccL().hBI.addView(EI, ccL().hBI.getLayoutParams());
                }
            }
        }
    }

    private void chO() {
        if (!this.hIt) {
            this.hIt = true;
            com.baidu.live.entereffect.a.CV().by(true);
        }
    }

    protected void cbp() {
        View Fl;
        if (this.hrI == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVn = true;
            aVar.context = ccL().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrI = (ab) runTask.getData();
            }
        }
        if (this.hrI != null && (Fl = this.hrI.Fl()) != null && this.hHv != null) {
            if (this.hHv.indexOfChild(Fl) < 0) {
                if (Fl.getParent() instanceof ViewGroup) {
                    ((ViewGroup) Fl.getParent()).removeView(Fl);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.hHd != null && this.hHd.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
                    layoutParams.topMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hsc != null && this.hsc.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hsb != null && this.hsb.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else {
                    layoutParams.topMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds66);
                }
                this.hHv.addView(Fl, layoutParams);
            }
            Fl.bringToFront();
        }
    }

    protected void cbo() {
        View Fz;
        if (this.hrT == null) {
            ak akVar = new ak();
            akVar.aVn = true;
            akVar.pageContext = ccL().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrT = (ag) runTask.getData();
            }
        }
        if (this.hrT != null && (Fz = this.hrT.Fz()) != null && ccL().hBI.indexOfChild(Fz) < 0) {
            if (Fz.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fz.getParent()).removeView(Fz);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            ccL().hBI.addView(Fz, layoutParams);
        }
    }

    private void chP() {
        chT();
        cbu();
        chS();
        ccL().hBI.setVisibility(0);
        vQ(0);
    }

    private void chQ() {
        if (this.hHd == null) {
            this.hHd = new com.baidu.tieba.ala.liveroom.t.a(ccL().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.hHd.a(ccL().bRf(), j, TbadkCoreApplication.getCurrentAccountName(), true, ccL().hBH.Fm().aId.portrait, this.otherParams, "", -1L);
        this.hHd.aF(this.hHv);
    }

    private void chR() {
        if (this.hHQ == null) {
            ccL().hBI.hRw = false;
            com.baidu.live.af.a ga = ga(ccL().pageContext.getPageActivity());
            if (ga != null) {
                this.hHQ = ga;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.af.a.class, ccL().pageContext.getPageActivity());
                if (runTask != null) {
                    this.hHQ = (com.baidu.live.af.a) runTask.getData();
                }
            }
            if (this.hHQ != null) {
                this.hHQ.r(this.hHw);
                this.hHQ.s(this.hHx);
                this.hHQ.dX((ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds330) + ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96)) - ccL().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds300));
                this.hHQ.t(ccL().hBI);
                this.hHQ.a(this.hpR);
                this.hHQ.setLiveShowInfo(ccL().hBH.Fm());
                this.hHQ.a(this.hqz);
                this.hHQ.QF();
                this.hHQ.a(new a.InterfaceC0156a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public void QG() {
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public void QH() {
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public void F(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.ccL().hBY != null) {
                            AlaMasterLiveRoomOpearator.this.ccL().hBY.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public int QI() {
                        return AlaMasterLiveRoomOpearator.this.hHu.getBottom();
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public int QJ() {
                        return AlaMasterLiveRoomOpearator.this.huP.hBI.getHeight() - (AlaMasterLiveRoomOpearator.this.hrF.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.hrF.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.hrF.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0156a
                    public int QK() {
                        return AlaMasterLiveRoomOpearator.this.hrF.Kg();
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

    private void chS() {
        if (this.hHf == null) {
            this.hHf = new b(ccL().pageContext, ccL().hBI);
        }
    }

    private void chT() {
        if (this.hqu == null) {
            this.hqu = new com.baidu.tieba.ala.liveroom.m.a(ccL().pageContext, true, this.hID);
            this.hqu.e(this.hHu, null);
            this.hqu.a(this.hrf);
            this.hqu.ou(false);
        }
        if (this.hHb == null) {
            this.hHb = new com.baidu.tieba.ala.liveroom.m.a(ccL().pageContext, true, null);
            this.hHb.a(this.hHu, null, a.f.ala_live_room_host_header_stub);
            this.hHb.cgl();
        }
    }

    protected void caX() {
        CustomResponsedMessage runTask;
        boolean z = false;
        aw cjv = ccL().hBH.cjv();
        boolean z2 = com.baidu.live.ae.a.Qj().buX.aMZ;
        if (cjv == null || cjv.aIP) {
            z = z2;
        }
        if (z && this.hrq == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.j.b.class, ccL().pageContext)) != null) {
            this.hrq = (com.baidu.live.j.b) runTask.getData();
            if (this.hrq != null) {
                this.hrq.setIsHost(true);
                this.hrq.du(1);
                View view = this.hrq.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(ccL().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(ccL().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.f.ala_live_room_host_header_stub);
                    this.hHu.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(com.baidu.live.data.ab abVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2;
        if (this.hqz == null) {
            this.hqz = new com.baidu.tieba.ala.liveroom.activeview.b(ccL().pageContext);
        }
        this.hqz.setOtherParams(this.otherParams);
        this.hqz.c(abVar, false);
        this.hqz.setHost(true);
        this.hqz.a(1, this.byA);
        this.hqz.a(2, this.byA);
        this.hqz.nI(this.hsy);
        this.hqz.setVisible(this.hGZ ? 8 : 0);
        this.hqz.a(this.hpR);
        if (this.hpR != null) {
            if (this.hqz != null) {
                AlaActiveRootView vi = this.hqz.vi(1);
                alaActiveRootView = this.hqz.vi(2);
                alaActiveRootView2 = vi;
            } else {
                alaActiveRootView = null;
                alaActiveRootView2 = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.hpR.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.hpR.a(alaActiveRootView);
            }
        }
    }

    private void O(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        if (this.hsh == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, ccL().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hsh = (com.baidu.live.aa.a) runTask.getData();
            if (this.hsh != null) {
                this.hsh.q(this.byA);
            }
        }
        if (this.hsh != null) {
            this.hsy = this.hsh.p(abVar);
            this.hsh.setCanVisible(!this.hGZ);
        }
    }

    protected void chU() {
        CustomResponsedMessage runTask;
        if (ccL() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.l.a.class, ccL().pageContext.getPageActivity())) != null && runTask.getData() != null && this.hrX == null) {
            this.hrX = (com.baidu.live.l.a) runTask.getData();
            this.hrX.d(this.hHv, cbI());
            if (ccL().hBH != null) {
                this.hrX.a(ccL().hBH.Fm());
            }
            this.hrX.setCanVisible(true);
            this.hrX.ch(false);
            this.hrX.a(ccL().hBH.bTR());
        }
    }

    protected void cbt() {
        CustomResponsedMessage runTask;
        if (ccL() != null && this.hrZ == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.t.a.class, ccL().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hrZ = (com.baidu.live.t.a) runTask.getData();
            this.hrZ.setIsHost(true);
            this.hrZ.a(this.huP.hBI, ccL().hBH.Fm());
        }
    }

    protected void cak() {
        if (ccL() != null) {
            if (this.hsa == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, ccL().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hsa = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsa.aW(this.gQF);
            this.hsa.setIsHorizontal(false);
            this.hsa.setIsHost(true);
            this.hsa.a(this.byA, ccL().hBH.Fm());
        }
    }

    protected void cbs() {
        if (ccL() != null) {
            if (this.hrY == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.v.a.class, ccL().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrY = (com.baidu.live.v.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (ccL().hBH != null) {
                this.hrY.b(ccL().hBH.Fm(), this.otherParams);
            }
        }
    }

    protected void caj() {
        if (ccL() != null) {
            if (this.hqG == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, ccL().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hqG = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hqG.setIsHost(true);
            this.hqG.a(this.byA, ccL().hBH.Fm().aJc);
        }
    }

    protected void chV() {
        CustomResponsedMessage runTask;
        if (ccL() != null && this.hHN == null && (runTask = MessageManager.getInstance().runTask(2913269, com.baidu.live.n.b.class, ccL().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hHN = (com.baidu.live.n.b) runTask.getData();
        }
    }

    protected void cbv() {
        CustomResponsedMessage runTask;
        if (ccL() != null && this.hsb == null && (runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.k.a.class, ccL().pageContext)) != null && runTask.getData() != null) {
            this.hsb = (com.baidu.live.k.a) runTask.getData();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            this.hsb.a(this.hHv, ccL().hBH.Fm(), layoutParams, this.otherParams);
        }
    }

    private void P(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        CustomResponsedMessage runTask3;
        CustomResponsedMessage runTask4;
        if (ccL() != null) {
            if (this.hHh == null && (runTask4 = MessageManager.getInstance().runTask(2913229, com.baidu.live.t.e.class)) != null) {
                this.hHh = (com.baidu.live.t.e) runTask4.getData();
            }
            if (this.hHh != null) {
                this.hHh.Pj();
            }
            if (this.hHi == null && (runTask3 = MessageManager.getInstance().runTask(2913292, com.baidu.live.t.b.class)) != null) {
                this.hHi = (com.baidu.live.t.b) runTask3.getData();
            }
            if (this.hHi != null) {
                this.hHi.Pj();
            }
            if (this.hHj == null && (runTask2 = MessageManager.getInstance().runTask(2913296, com.baidu.live.t.b.class)) != null) {
                this.hHj = (com.baidu.live.t.b) runTask2.getData();
            }
            if (this.hHj != null) {
                this.hHj.Pj();
            }
            if (this.hHk == null && (runTask = MessageManager.getInstance().runTask(2913293, f.class)) != null) {
                this.hHk = (f) runTask.getData();
            }
            if (this.hHk != null) {
                this.hHk.Pj();
            }
            if (this.hHl == null) {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(2913230, com.baidu.live.t.d.class);
                if (runTask5 != null) {
                    this.hHl = (com.baidu.live.t.d) runTask5.getData();
                }
                if (this.hHl != null) {
                    this.hHl.setParentView(this.huP.hBI);
                    if (abVar != null && abVar.aId != null) {
                        this.hHl.bh(abVar.aId.userId);
                    }
                }
            }
        }
    }

    private void chW() {
        CustomResponsedMessage runTask;
        if (ccL() != null) {
            if (this.hHm == null && (runTask = MessageManager.getInstance().runTask(2913265, c.class)) != null) {
                this.hHm = (c) runTask.getData();
            }
            if (this.hHm != null) {
                this.hHm.Pj();
            }
            if (this.hHn == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913266, com.baidu.live.v.b.class);
                if (runTask2 != null) {
                    this.hHn = (com.baidu.live.v.b) runTask2.getData();
                }
                if (this.hHn != null) {
                    this.hHn.setParentView(this.huP.hBI);
                    this.hHn.b(ccL().hBH.Fm(), this.otherParams);
                }
            }
        }
    }

    private ViewGroup.LayoutParams cbI() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(ccL().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(1, a.f.ala_live_room_stream_view);
            layoutParams.leftMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.f.ala_liveroom_charmview);
        }
        if (this.hsc != null && this.hsc.isShowing()) {
            layoutParams.addRule(3, a.f.ala_rank_level_entry);
            layoutParams.topMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        } else if (this.hHd != null && this.hHd.isShowing()) {
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            layoutParams.topMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        }
        return layoutParams;
    }

    private void cbu() {
        if (this.hHc == null) {
            this.hHc = new com.baidu.tieba.ala.liveroom.a.a(ccL().pageContext, true);
        }
    }

    private void chX() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = ccL().pageContext.getPageActivity();
            if (this.hHR == null) {
                this.hHR = new ImageView(pageActivity);
                this.hHR.setId(a.f.master_close_btn);
                this.hHR.setTag("master_close_btn");
                this.hHR.setImageResource(a.e.sdk_icon_bar_live_close_n);
                this.hHR.setBackgroundResource(a.e.sdk_round_btn_close_bg);
                this.hHR.setPadding(pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0);
            }
            if (this.hHR.getParent() != null) {
                ((ViewGroup) this.hHR.getParent()).removeView(this.hHR);
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
            ccL().hCb.addView(this.hHR, layoutParams);
            this.hHR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.cig();
                }
            });
            this.hHR.setVisibility(8);
        }
    }

    protected void cby() {
        if (this.hsc == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.t.c.class, ccL().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hsc = (com.baidu.live.t.c) runTask.getData();
            } else {
                return;
            }
        }
        if (ccL().hBH.Fm() != null && ccL().hBH.Fm().aId != null && ccL().hBH.Fm().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.height = BdUtilHelper.getDimens(ccL().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.leftMargin = BdUtilHelper.getDimens(ccL().pageContext.getPageActivity(), a.d.sdk_ds20);
            this.hsc.b(this.hHv, layoutParams, ccL().hBH.Fm());
        }
    }

    private void chY() {
        CustomResponsedMessage runTask;
        if (this.hIm == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, ccL().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.hIm = (com.baidu.live.b.a) runTask.getData();
            if (this.hIm != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.f.ala_head_line_entry_id);
                layoutParams.addRule(11);
                layoutParams.topMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
                layoutParams.rightMargin = ccL().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                aw cjv = ccL().hBH.cjv();
                if (cjv != null) {
                    this.hIm.a(this.hHv, layoutParams, ccL().pageContext.getPageActivity(), cjv.aOj);
                } else {
                    return;
                }
            }
        }
        if (this.hIm != null) {
            this.hIm.a(ccL().hBH.Fm());
        }
    }

    private void cbf() {
        if (this.bgE == null) {
            this.bgE = new com.baidu.live.an.a(ccL().pageContext.getPageActivity());
        }
    }

    private void Q(com.baidu.live.data.ab abVar) {
        if (this.hIn == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913299, com.baidu.live.guess.b.class);
            if (runTask.getData() != null) {
                this.hIn = (com.baidu.live.guess.b) runTask.getData();
                if (this.hIn != null && this.byA != null) {
                    this.hIn.init(ccL().pageContext.getPageActivity(), true);
                    this.hIn.a(abVar, this.byA);
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.hIk != null) {
            this.hIk.onRtcConnected(i);
        }
    }

    private void registerListener() {
        ccL().pageContext.registerListener(this.hsQ);
        ccL().pageContext.registerListener(this.hIw);
        ccL().pageContext.registerListener(this.hsR);
        ccL().pageContext.registerListener(this.hsS);
        ccL().pageContext.registerListener(this.hIA);
        ccL().pageContext.registerListener(this.bCb);
        ccL().pageContext.registerListener(this.hpb);
        ccL().pageContext.registerListener(this.hIB);
        ccL().pageContext.registerListener(this.gNt);
        ccL().pageContext.registerListener(this.hrb);
        ccL().pageContext.registerListener(this.hsW);
        ccL().pageContext.registerListener(this.bEA);
        ccL().pageContext.registerListener(this.bEB);
        ccL().pageContext.registerListener(this.hIx);
        ccL().pageContext.registerListener(this.brP);
        ccL().pageContext.registerListener(this.brQ);
        ccL().pageContext.registerListener(this.hIy);
        ccL().pageContext.registerListener(this.hsY);
        ccL().pageContext.registerListener(this.hsX);
        ccL().pageContext.registerListener(this.htc);
        ccL().pageContext.registerListener(this.hIy);
        ccL().pageContext.registerListener(this.boE);
        ccL().pageContext.registerListener(this.blY);
        ccL().pageContext.registerListener(this.hdY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(boolean z) {
        if (bt.c(com.baidu.live.ae.a.Qj().bAS)) {
            ccL().pageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (ccL().hCd.zB() == null || ListUtils.isEmpty(ccL().hCd.zB().aCd)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ccL().pageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (!this.bEy) {
                this.bEx = BdUniqueId.gen();
                ccL().hCd.a(this.bEx);
                this.bEy = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(ccL().pageContext.getPageActivity(), ccL().rootView);
            vQ(8);
            if (ccL().hBY.hasAdvancedBeauty() && this.hIj != null) {
                if (!this.hIo || this.hHa.getVisibility() == 0) {
                    this.hIj.c(ccL().hBY.getVideoConfig());
                }
                this.hIj.a(ccL().hBY.getVideoConfig(), this.bEz);
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
        if (this.hHS == null || !this.hHS.isShowing()) {
            this.hHS = new BdAlertDialog(ccL().pageContext.getPageActivity());
            this.hHS.setAutoNight(false);
            this.hHS.setTitle(a.h.sdk_prompt);
            this.hHS.setMessageId(i, currentAppType(ccL().pageContext.getPageActivity()));
            this.hHS.setTitleShowCenter(true);
            this.hHS.setMessageShowCenter(true);
            this.hHS.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    AlaMasterLiveRoomOpearator.this.ccL().g((short) 1);
                }
            });
            this.hHS.create(ccL().pageContext).show();
        }
    }

    private void HT(String str) {
        if (this.hHT == null || !this.hHT.isShowing()) {
            this.hHT = new BdAlertDialog(ccL().pageContext.getPageActivity());
            this.hHT.setAutoNight(false);
            this.hHT.setTitle(a.h.sdk_prompt);
            this.hHT.setMessage(str);
            this.hHT.setTitleShowCenter(true);
            this.hHT.setMessageShowCenter(true);
            this.hHT.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    AlaMasterLiveRoomOpearator.this.ccL().g((short) 1);
                }
            });
            this.hHT.create(ccL().pageContext).show();
        }
    }

    public void chZ() {
        caX();
        v bTR = ccL().hBH.bTR();
        int i = 5;
        if (bTR != null) {
            i = (int) bTR.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm() != null && AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.ccL().hBH.j(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bTR != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.huP.hCg.b(bTR);
                return;
            }
            if (this.hqt == null) {
                this.hqt = new com.baidu.tieba.ala.liveroom.audiencelist.c(ccL().pageContext, this.hID, true);
            }
            if (this.hIh) {
                this.hIh = false;
                this.hqt.a(String.valueOf(ccL().hBH.Fm().mLiveInfo.group_id), String.valueOf(ccL().hBH.Fm().mLiveInfo.live_id), String.valueOf(ccL().hBH.Fm().aId.userId), ccL().hBH.Fm());
                int i2 = a.f.ala_live_room_host_header_stub;
                if (this.hrq != null) {
                    i2 = a.f.ala_liveroom_guardthrone;
                }
                this.hqt.c(this.hHu, i2, a.f.ala_liveroom_audience_count_layout);
            }
            this.hqt.e(bTR);
            this.hqx.setVisible(0);
            this.hqx.ff(bTR.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cia() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buF() {
        if (ccL().hBH != null) {
            if (this.hrs == null) {
                this.hrs = new com.baidu.tieba.ala.liveroom.share.c(ccL().pageContext);
            }
            this.hrs.d(ccL().hBH.Fm(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (ccL().hBH != null && ccL().hBH.Fm() != null && ccL().hBH.Fm().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", ccL().hBH.Fm().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", ccL().hBH.Fm().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", ccL().hBH.Fm().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (ccL().hBH != null && ccL().hBH.Fm() != null && ccL().hBH.Fm().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", ccL().hBH.Fm().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", ccL().hBH.Fm().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", ccL().hBH.Fm().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean cib() {
        return this.hGY;
    }

    private void oA(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(hGX, z);
        this.hGY = z;
    }

    private void cic() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccL().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.h.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.n.b(AlaMasterLiveRoomOpearator.this.ccL().pageContext).cjd();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.h.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(ccL().pageContext).show();
    }

    private void cid() {
        if (this.hGH && ccL().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            ccL().hCf.TZ();
        }
        ccL().hCe.prepareTime = System.currentTimeMillis() - ccL().hCe.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (ccL().hBH != null && ccL().hBH.Fm() != null && ccL().hBH.Fm().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", ccL().hBH.Fm().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", ccL().hBH.Fm().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", ccL().hCe.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hHa != null && this.hHa.getView().getParent() != null) {
            this.hHa.setVisibility(8);
            ccL().hCb.removeView(this.hHa.getView());
            this.hHa.release();
        }
        if (this.hIj != null) {
            this.hIj.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (ccL().hBI.indexOfChild(this.hHr) < 0) {
            ccL().hBI.addView(this.hHr, layoutParams);
        }
        this.hHr.wh(1000);
    }

    private void awo() {
        if (ccL().bRf() == 1) {
            ccL().hBY.startRecord();
        }
    }

    private void HU(String str) {
        HV(str);
    }

    private void HV(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) ccL().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.hHa != null) {
            this.hHa.HI(fromJson.getSmallurl());
        }
    }

    private boolean cie() {
        return com.baidu.live.d.xc().getBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cif() {
        com.baidu.live.d.xc().putBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), this.huP.hBY.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cig() {
        if (this.hIl == null || !this.hIl.Rn()) {
            if (this.hHq == null || !this.hHq.Rn()) {
                int i = a.h.live_close_confirm;
                if (this.hIk != null && this.hIk.ccT()) {
                    i = a.h.ala_pk_pking_close_live_roon_tip;
                } else if (this.hIk != null && this.hIk.ccS()) {
                    i = a.h.ala_challenge_challenging_close_live_room_tip;
                }
                BdAlertDialog bdAlertDialog = new BdAlertDialog(ccL().pageContext.getPageActivity());
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
                        if (AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm() != null) {
                            AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm(), 0, AlaMasterLiveRoomOpearator.this.ccL().hBH.cjE() != 1 ? AlaMasterLiveRoomOpearator.this.ccL().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
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
                bdAlertDialog.create(ccL().pageContext).show();
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
                ccL().hBH.eA(Long.toString(alaLiveInfoData.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
        } else {
            alaLiveUserInfoData = null;
            alaLiveInfoData = null;
        }
        if (!this.hIf) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = ccL().hCe;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = ccL().hBY.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.hIb;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.hIc;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.hHX;
            if (this.hHY != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.hHZ - this.hIa) / this.hHY) * 100.0f;
            }
            Intent intent = new Intent(ccL().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (ccL().hBH != null && ccL().hBH.Fm() != null && ccL().hBH.Fm().aId != null) {
                String str3 = ccL().hBH.Fm().aId.nickName;
                String str4 = ccL().hBH.Fm().aId.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            com.baidu.live.data.ab Fm = ccL().hBH.Fm();
            if (Fm != null && Fm.aId != null && !TextUtils.isEmpty(Fm.aId.portrait)) {
                intent.putExtra("host_portrait", Fm.aId.portrait);
            }
            if (this.hIl != null) {
                this.hIl.Vz();
            }
            if (this.hHq != null) {
                this.hHq.Rl();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.hId = intent;
                this.hIe = s;
                ccL().pageContext.showToast(a.h.ala_live_background_close_tip);
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
            if (this.hIu != null) {
                this.hIu.aCV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cih() {
        if (this.hId != null) {
            a(this.hId, this.hIe);
            this.hId = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.hIf = true;
        if (this.hIk != null) {
            this.hIk.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.hoQ);
            ccL().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        ccL().g(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cii() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.huP.hCg != null && this.huP.hCg.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hIk != null && this.hIk.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hIl != null && this.hIl.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hIj != null && this.hIj.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hHq != null && this.hHq.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (ccL().hCc.ciM()) {
                cig();
                return true;
            }
        }
        return false;
    }

    public void VC() {
        if (this.hIl != null) {
            this.hIl.VC();
        }
    }

    public void sendBufferChanged(int i) {
        if (this.hHs != null) {
            this.hHs.ej(i);
        }
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (this.huP != null && this.huP.hBH != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.dLp != i3) {
                this.dLp = i3;
                if (this.hHg == null) {
                    this.hHg = new com.baidu.tieba.ala.liveroom.tippop.a(this.huP.pageContext, null);
                }
                switch (this.dLp) {
                    case 0:
                        this.hHg.c(this.huP.hCb, this.huP.pageContext.getString(a.h.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.hHg.c(this.huP.hCb, this.huP.pageContext.getString(a.h.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.hHg.c(this.huP.hCb, this.huP.pageContext.getString(a.h.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.huP.hBH.x(this.huP.hBH.Fm().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.cii();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm(), 1, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0738, code lost:
        Hv(r6);
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
        if (this.hqz != null) {
            this.hqz.N(bVar);
        }
        if (bVar.getMsgType() == 125) {
            if (this.hHe != null) {
                this.hHe.R(bVar);
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
            if (this.hIk != null) {
                this.hIk.fo(str2);
            }
            if ("close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cii();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccL().hBH.Fm(), 1, str3);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (ccL().hBH.Fm() != null && jSONObject5 != null) {
                    long optLong = jSONObject5.optLong("user_id");
                    int optInt = jSONObject5.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ccL().hBH.Fm().aIz.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ccL().hBH.Fm().aIz.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        ccL().hBH.Fm().aIz.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (ccL().hBH.Fm() != null && jSONObject5 != null) {
                    long optLong2 = jSONObject5.optLong("user_id");
                    if (ccL().hBH.Fm() != null && ccL().hBH.Fm().aId != null && ccL().hBH.Fm().aId.userId == optLong2) {
                        ccL().hBH.Fm().aId.isUegBlock = 1;
                        caB();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (ccL().hBH.Fm() != null && jSONObject5 != null) {
                    long optLong3 = jSONObject5.optLong("user_id");
                    if (ccL().hBH.Fm() != null && ccL().hBH.Fm().aId != null && ccL().hBH.Fm().aId.userId == optLong3) {
                        ccL().hBH.Fm().aId.isUegBlock = 0;
                        caB();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.hHO != null) {
                    this.hHO.ab(jSONObject5);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject5 != null) {
                    String optString2 = jSONObject5.optString("share_enter_msg");
                    int optInt2 = jSONObject5.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.hHf.aL(optString2, optInt2);
                    }
                    if (this.hqx.getCount() > 20) {
                        this.hqx.ff(this.hqx.getCount() + 1);
                    } else if (this.hqt != null) {
                        com.baidu.live.data.a KZ = bVar.KZ();
                        com.baidu.live.data.u uVar = new com.baidu.live.data.u();
                        uVar.aIe = new AlaLocationData();
                        uVar.aIf = new AlaRelationData();
                        uVar.aId = new AlaLiveUserInfoData();
                        uVar.aId.userId = JavaTypesHelper.toLong(KZ.userId, 0L);
                        uVar.aId.userName = KZ.userName;
                        uVar.aId.portrait = KZ.portrait;
                        if (this.hqt.c(uVar)) {
                            this.hqx.ff(this.hqx.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject5 != null && ccL() != null && ccL().hBH != null && ccL().hBH.Fm() != null && ccL().hBH.Fm().aIz != null && ccL().hBH.Fm().aIz.userId == jSONObject5.optLong("user_id")) {
                    ccL().hBH.cju();
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
                        HW(jSONObject5.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString3, "cancel")) {
                        BdUtilHelper.showToast(ccL().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
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
                            if (this.hsb != null) {
                            }
                            if (this.hrZ != null) {
                            }
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        jSONObject2 = null;
                    }
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_direct_new").setContentExt(null, null, jSONObject2));
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(ccL().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_random_cancel").setContentExt(null, null, null));
            } else if ("connect_apply_show_pub".equals(str2)) {
                if (this.hHq != null) {
                    this.hHq.aa(jSONObject5);
                }
            } else if ("remove_video".equals(str2)) {
                String optString5 = jSONObject5.optString("text");
                if (jSONObject5.optString("poke_msg").isEmpty()) {
                    HS(optString5);
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
                if (ccL().hBH == null || ccL().hBH.Fm() == null || ccL().hBH.Fm().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    z = false;
                } else {
                    long j4 = ccL().hBH.Fm().mLiveInfo.live_id;
                    j3 = ccL().hBH.Fm().mLiveInfo.group_id;
                    long j5 = ccL().hBH.Fm().aId.userId;
                    str8 = ccL().hBH.Fm().mLiveInfo.appId;
                    boolean z5 = ccL().hBH.Fm().mLiveInfo.isPubShow;
                    if (ccL().hBH.Fm().mLiveSdkInfo.mCastIds != null) {
                        str6 = ccL().hBH.Fm().mLiveSdkInfo.mCastIds.chatMCastId;
                        str7 = ccL().hBH.Fm().mLiveSdkInfo.mCastIds.ensureMCastId;
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
                    if (!this.isBackground || ccL().bRf() != 2) {
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
                    Hv(optString7);
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
        if (this.hsb != null) {
            this.hsb.l(bVar);
        }
        if ((this.hrZ != null || !this.hrZ.J(bVar)) && this.hqG != null && this.hqG.Z(jSONObject4)) {
        }
    }

    private void Hv(String str) {
        if (this.hqz != null) {
            this.hqz.Hv(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vQ(int i) {
        View findViewById = ccL().rootView.findViewById(a.f.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.hqz != null) {
            this.hqz.bN(2, i);
        }
    }

    private void cij() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.ccL().hBY != null && AlaMasterLiveRoomOpearator.this.ccL().hBY.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.ccL().hBY.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.ccL().hBY.startRecord();
                }
            }
        });
    }

    private void cik() {
        if (ccL().hBY != null && ccL().hBY.getPreview() != null) {
            ccL().hBY.getPreview().setVisibility(8);
            ccL().hBY.stopRecord();
        }
    }

    public void cil() {
        this.hBV = ccL().hBH.cjF();
        if (this.hHa != null) {
            this.hHa.oi(this.hBV);
        }
    }

    public void ceF() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cim();
        } else if (this.hHa != null) {
            this.hHa.ceF();
        }
    }

    public void oj(boolean z) {
        if (this.hHa != null) {
            this.hHa.oj(z);
        }
    }

    public void onDestroy() {
        if (this.hHW != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.hHW);
        }
        this.hHW = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hHM.removeCallbacksAndMessages(null);
        if (this.hIj != null) {
            this.hIj.og(true);
        }
        this.hIj = null;
        if (this.hHa != null) {
            this.hHa.destroy();
            ccL().hCb.removeView(this.hHa.getView());
            this.hHa.release();
            this.hHa = null;
        }
        if (this.hIk != null) {
            this.hIk.onDestroy();
        }
        if (this.hrs != null) {
            this.hrs.onDestroy();
        }
        if (this.hqu != null) {
            this.hqu.onDestroy();
            this.hqu = null;
        }
        if (this.hHb != null) {
            this.hHb.onDestroy();
        }
        if (this.hrT != null) {
            this.hrT.onDestroy();
            this.hrT = null;
        }
        if (this.hHr != null) {
            this.hHr.stopCountDown();
        }
        if (this.hHd != null) {
            this.hHd.onDestroy();
        }
        if (this.hHf != null) {
            this.hHf.onDestroy();
        }
        if (this.hHO != null) {
            this.hHO.onDestroy();
            this.hHO = null;
        }
        if (this.hrH != null) {
            this.hrH.onDestroy();
            this.hrH = null;
        }
        if (this.hHh != null) {
            this.hHh.release();
        }
        if (this.hHi != null) {
            this.hHi.release();
        }
        if (this.hHj != null) {
            this.hHj.release();
        }
        if (this.hHk != null) {
            this.hHk.release();
        }
        if (this.hHm != null) {
            this.hHm.release();
        }
        com.baidu.live.storage.opt.b.Rg().release();
        ac.Fu();
        com.baidu.live.entereffect.a.CV().release();
        this.hIt = false;
        if (this.hrI != null) {
            this.hrI.onDestroy();
            this.hrI = null;
        }
        if (this.hHg != null) {
            this.hHg.onDestroy();
        }
        if (this.hHe != null) {
            this.hHe.clR();
            this.hHe.release();
        }
        if (this.hqx != null) {
            this.hqx = null;
        }
        if (this.hqz != null) {
            this.hqz.release();
        }
        if (this.hHe != null) {
            this.hHe.onDestroy();
        }
        if (this.hrG != null) {
            this.hrG.release();
        }
        if (this.hHo != null) {
            this.hHo.release();
        }
        if (this.hHQ != null) {
            this.hHQ.onDestroy();
        }
        if (this.hsh != null) {
            this.hsh.release();
        }
        if (this.hIm != null) {
            this.hIm.onDestory();
        }
        if (this.hrX != null) {
            this.hrX.onDestroy();
        }
        if (this.hrZ != null) {
            this.hrZ.onDestroy();
        }
        if (this.hrY != null) {
            this.hrY.onDestroy();
        }
        if (this.hqG != null) {
            this.hqG.onDestroy();
        }
        if (this.hHl != null) {
            this.hHl.release();
            this.hHl = null;
        }
        if (this.hHn != null) {
            this.hHn.release();
            this.hHn = null;
        }
        if (this.bgE != null) {
            this.bgE.release();
        }
        if (this.hsc != null) {
            this.hsc.onDestroy();
        }
        if (this.hIl != null) {
            this.hIl.onDestroy();
        }
        if (this.hHq != null) {
            this.hHq.onDestroy();
        }
        if (this.hsl != null) {
            this.hsl.onDestory();
        }
        if (this.hHS != null) {
            this.hHS.dismiss();
            this.hHS = null;
        }
        if (this.hHT != null) {
            this.hHT.dismiss();
            this.hHT = null;
        }
        this.hIp.removeCallbacksAndMessages(this.hIL);
        MessageManager.getInstance().unRegisterListener(this.hsQ);
        MessageManager.getInstance().unRegisterListener(this.hIw);
        MessageManager.getInstance().unRegisterListener(this.hsR);
        MessageManager.getInstance().unRegisterListener(this.hsS);
        MessageManager.getInstance().unRegisterListener(this.hIA);
        MessageManager.getInstance().unRegisterListener(this.bCb);
        MessageManager.getInstance().unRegisterListener(this.hpb);
        MessageManager.getInstance().unRegisterListener(this.hIB);
        MessageManager.getInstance().unRegisterListener(this.gNt);
        MessageManager.getInstance().unRegisterListener(this.hrb);
        MessageManager.getInstance().unRegisterListener(this.hsW);
        MessageManager.getInstance().unRegisterListener(this.bEA);
        MessageManager.getInstance().unRegisterListener(this.bEB);
        MessageManager.getInstance().unRegisterListener(this.hIx);
        MessageManager.getInstance().unRegisterListener(this.brP);
        MessageManager.getInstance().unRegisterListener(this.brQ);
        MessageManager.getInstance().unRegisterListener(this.hIy);
        MessageManager.getInstance().unRegisterListener(this.hsY);
        MessageManager.getInstance().unRegisterListener(this.hsX);
        MessageManager.getInstance().unRegisterListener(this.htc);
        MessageManager.getInstance().unRegisterListener(this.hIy);
        MessageManager.getInstance().unRegisterListener(this.boE);
        MessageManager.getInstance().unRegisterListener(this.blY);
        MessageManager.getInstance().unRegisterListener(this.hdY);
        MessageManager.getInstance().unRegisterListener(this.gXK);
        MessageManager.getInstance().unRegisterListener(this.gYc);
        ccL().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.hIu != null) {
            this.hIu.aCV();
        }
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.huP.hCg.a(this.hIK, this.huP.hCa, this.hHt, alaLivePersonData);
        }
    }

    private void cim() {
        if (this.hHU != null) {
            this.huP.hCe.startTime = System.currentTimeMillis();
            this.huP.hCe.liveTotalTime = System.currentTimeMillis();
            this.huP.hCe.sampleMemAndCPU();
            this.huP.hCc.a((short) 4, this.hHU);
        }
    }

    private void HW(String str) {
        String str2;
        int i;
        if (ccL() != null && ccL().pageContext != null) {
            this.hHM.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = ccL().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.hIr == null) {
                    this.hIr = layoutInflater.inflate(a.g.layout_challenge_entry_toast, (ViewGroup) null);
                    this.hIr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.chk()) {
                                AlaMasterLiveRoomOpearator.this.hHM.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.hIr != null) {
                                    AlaMasterLiveRoomOpearator.this.ccL().hBI.removeView(AlaMasterLiveRoomOpearator.this.hIr);
                                }
                                if (AlaMasterLiveRoomOpearator.this.hIk != null) {
                                    AlaMasterLiveRoomOpearator.this.hIk.ccP();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.hIr.findViewById(a.f.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.h.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.hHM.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.ccL().hBI != null && AlaMasterLiveRoomOpearator.this.huW != null && AlaMasterLiveRoomOpearator.this.hIr != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.hIr.findViewById(a.f.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.hIr.findViewById(a.f.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.v((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.hIr.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.huW.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.huW.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.huW.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.huW.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.hIr.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.hIr.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.hIr != null) {
                                AlaMasterLiveRoomOpearator.this.ccL().hBI.removeView(AlaMasterLiveRoomOpearator.this.hIr);
                            }
                            AlaMasterLiveRoomOpearator.this.ccL().hBI.addView(AlaMasterLiveRoomOpearator.this.hIr, layoutParams);
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
                this.hHM.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.ccL().hBI != null && AlaMasterLiveRoomOpearator.this.hIr != null) {
                            AlaMasterLiveRoomOpearator.this.ccL().hBI.removeView(AlaMasterLiveRoomOpearator.this.hIr);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bVA() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            com.baidu.live.data.ab Fm = ccL().hBH.Fm();
            if (Fm != null) {
                bVar.setAnchorId(Fm.mLiveInfo.user_id);
                bVar.setParams();
                bVar.setTag(this.gOQ);
                MessageManager.getInstance().sendMessage(bVar);
            }
        }
    }

    public void cin() {
        if (ccL().pageContext.getPageActivity() instanceof Activity) {
            Activity pageActivity = ccL().pageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity.isDestroyed() || pageActivity.isFinishing()) {
                    return;
                }
            } else if (pageActivity.isFinishing()) {
                return;
            }
        }
        boolean z = com.baidu.live.d.xc().getBoolean("new_anchor_club_rename", true);
        aw cjv = ccL().hBH.cjv();
        if (cjv != null && this.biY != null && cjv.aOk == 1 && z) {
            ccL().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
            com.baidu.live.d.xc().putBoolean("new_anchor_club_rename", false);
            View inflate = View.inflate(ccL().pageContext.getPageActivity(), a.g.dialog_help_guard_club_rename, null);
            this.gYM = new Dialog(ccL().pageContext.getPageActivity(), a.i.RegimentRenameDiolog);
            final Button button = (Button) inflate.findViewById(a.f.rename_confirm);
            button.setEnabled(false);
            button.setTextColor(ccL().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
            final EditText editText = (EditText) inflate.findViewById(a.f.guard_club_rename_edittext);
            final TextView textView = (TextView) inflate.findViewById(a.f.hint_num);
            ((Button) inflate.findViewById(a.f.rename_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.63
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.gYi = null;
                    AlaMasterLiveRoomOpearator.this.gYM.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.64
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (editText.getText().toString() != null) {
                        AlaMasterLiveRoomOpearator.this.gYi = editText.getText().toString();
                        if (AlaMasterLiveRoomOpearator.this.biY != null && AlaMasterLiveRoomOpearator.this.gYi != null) {
                            if (BdNetTypeUtil.isNetWorkAvailable()) {
                                AlaMasterLiveRoomOpearator.this.k(AlaMasterLiveRoomOpearator.this.biY.id, AlaMasterLiveRoomOpearator.this.gYi, "");
                            } else {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity(), "网络故障，请刷新重试");
                            }
                        } else {
                            return;
                        }
                    }
                    AlaMasterLiveRoomOpearator.this.gYM.dismiss();
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
                        textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        textView.setText("0");
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                    }
                    if (obj.length() > 0) {
                        int i4 = 0;
                        int i5 = 0;
                        for (int i6 = 0; i6 < obj.length(); i6++) {
                            String substring = obj.substring(i6, i6 + 1);
                            if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity(), "仅支持中英文及数字");
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
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity(), "不能超过3个字符");
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
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                            } else {
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccL().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                            }
                        }
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.gYM.setContentView(inflate);
            this.gYM.setCanceledOnTouchOutside(true);
            inflate.setMinimumHeight((int) (com.baidu.tieba.ala.liveroom.g.f.getScreenHeight(ccL().pageContext.getPageActivity()) * 0.22f));
            Window window = this.gYM.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (com.baidu.tieba.ala.liveroom.g.f.getScreenWidth(ccL().pageContext.getPageActivity()) * 0.74f);
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            this.gYM.show();
        }
    }

    public void k(int i, String str, String str2) {
        com.baidu.tieba.ala.liveroom.messages.e eVar = new com.baidu.tieba.ala.liveroom.messages.e();
        eVar.fq(i);
        eVar.GS(str);
        eVar.GT(str2);
        eVar.setParams();
        MessageManager.getInstance().sendMessage(eVar);
    }
}
