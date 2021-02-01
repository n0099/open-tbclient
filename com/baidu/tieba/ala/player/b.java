package com.baidu.tieba.ala.player;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.data.bv;
import com.baidu.live.data.bw;
import com.baidu.live.data.v;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.al;
import com.baidu.live.gift.x;
import com.baidu.live.gift.z;
import com.baidu.live.liveroom.e.h;
import com.baidu.live.sdk.a;
import com.baidu.live.t.e;
import com.baidu.live.t.f;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BDxdConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.IntentAction;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.log.StayTimeBean;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.i;
import com.baidu.live.utils.l;
import com.baidu.live.utils.p;
import com.baidu.live.utils.q;
import com.baidu.live.view.SafeFrameLayout;
import com.baidu.tieba.ala.floating.a;
import com.baidu.tieba.ala.floating.permission.FloatPermissionUtil;
import com.baidu.tieba.ala.liveroom.i.g;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew;
import com.baidu.tieba.ala.liveroom.n.d;
import com.baidu.tieba.ala.liveroom.task.ActivityTaskWatchHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends BdBaseView<TbPageContext> {
    private static String TAG = "AlaLiveViewController";
    private static int iet = 1;
    private static WeakReference<b> mRef;
    private boolean DEBUG;
    private ab aDd;
    private com.baidu.live.u.b bOP;
    private CustomMessageListener bgy;
    private boolean biC;
    private long buN;
    private String buO;
    private boolean byF;
    private com.baidu.tieba.ala.liveroom.n.d hFX;
    private d.a hGF;
    private e hGT;
    private com.baidu.live.t.b hGU;
    private com.baidu.live.t.b hGV;
    private f hGW;
    private com.baidu.live.t.d hGX;
    private com.baidu.live.v.c hGY;
    private com.baidu.live.v.b hGZ;
    private AlaLiveView hGp;
    private ViewGroup hGq;
    private LayerRootView hGr;
    private long hGv;
    private Runnable hJK;
    private String hoC;
    CustomMessageListener hsH;
    private a idK;
    private SafeFrameLayout idL;
    private AlaLiveRoomBlurPageLayout idM;
    private AlaLoopViewPager idN;
    private AlaLoopViewPagerAdapter idO;
    private com.baidu.tieba.ala.liveroom.d.a idP;
    private com.baidu.tieba.ala.liveroom.d.b idQ;
    private SdkLivePlayer idR;
    private AlaLastLiveroomInfo idS;
    private boolean idT;
    private boolean idU;
    private boolean idV;
    private boolean idW;
    @Deprecated
    private boolean idX;
    private ArrayList<AlaBroadcastGiftToastData> idY;
    private String idZ;
    private boolean ieA;
    private CustomMessageListener ieB;
    private CustomMessageListener ieC;
    private com.baidu.live.ag.c ieD;
    private boolean ieE;
    private boolean ieF;
    private long ieG;
    private long ieH;
    private CustomMessageListener ieI;
    private com.baidu.live.u.a ieJ;
    com.baidu.live.liveroom.a.c ieK;
    ViewPager.OnPageChangeListener ieL;
    HttpMessageListener ieM;
    CustomMessageListener ieN;
    CustomMessageListener ieO;
    CustomMessageListener ieP;
    CustomMessageListener ieQ;
    private CustomMessageListener ieR;
    private com.baidu.tieba.ala.endliveroom.a iea;
    private com.baidu.tieba.ala.liveroom.c.c ieb;
    private String iec;
    private long ied;
    private JSONObject iee;
    private boolean ief;
    private com.baidu.tieba.ala.liveroom.task.c ieg;
    private StayTimeBean ieh;
    private boolean iei;
    private com.baidu.tieba.ala.liveroom.j.a iej;
    private com.baidu.tieba.ala.liveroom.u.c iek;
    private boolean iel;
    private boolean iem;
    private String ien;
    private boolean ieo;
    private bw iep;
    private boolean ieq;
    private boolean ier;
    private int ies;
    private boolean ieu;
    private boolean iev;
    private Runnable iew;
    private Runnable iex;
    private Runnable iey;
    private boolean iez;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void cns() {
        if (this.iek != null) {
            this.iek.bE(this.biC);
        }
        if (this.iej != null) {
            this.iej.bE(this.biC);
        }
        if (al.FB() != null) {
            al.FB().bE(this.biC);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.DEBUG = false;
        this.mSelectedPosition = 1;
        this.idT = true;
        this.hGv = 0L;
        this.idU = false;
        this.byF = true;
        this.buO = "";
        this.mForumName = "";
        this.idV = false;
        this.idX = false;
        this.idZ = "0";
        this.mHandler = new Handler();
        this.ied = -1L;
        this.otherParams = "";
        this.ief = false;
        this.ieg = com.baidu.tieba.ala.liveroom.task.c.ckA();
        this.iei = false;
        this.iem = false;
        this.ieo = false;
        this.ier = false;
        this.ies = 0;
        this.ieu = false;
        this.iev = false;
        this.hJK = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.ciU();
            }
        };
        this.iew = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.cnQ();
            }
        };
        this.iex = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.hFX.cjq();
            }
        };
        this.iey = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.hsH = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.iez = true;
            }
        };
        this.ieB = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ieA = true;
            }
        };
        this.ieC = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.ieI = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.biC = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.cns();
            }
        };
        this.bgy = new CustomMessageListener(2501059) { // from class: com.baidu.tieba.ala.player.b.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_video_activity")) {
                    b.this.U(false, false);
                }
            }
        };
        this.bOP = new com.baidu.live.u.b() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.u.b
            public void cv(int i) {
                if (b.this.ieb != null) {
                    b.this.ieb.cv(i);
                }
            }
        };
        this.ieJ = new com.baidu.live.u.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.u.a
            public void cL(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.idR != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.idR.isPlaying());
                        if (b.this.idR.isPlaying()) {
                            if (b.this.idR.isPaused()) {
                                b.this.idR.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.idR.isPlaying()) {
                        b.this.idR.pause();
                    }
                }
            }
        };
        this.ieK = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void cC(boolean z) {
                if (z || b.this.ieb == null || b.this.ieb.cbQ()) {
                    if (!b.this.cnB() || b.this.a(true, (a.InterfaceC0626a) null)) {
                        b.this.iev = true;
                        b.this.pf(true);
                        b.this.bYU();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cD(boolean z) {
                b.this.e(b.this.aDd, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                String str2;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isStoped", b.this.idV);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (arrayList != null && arrayList.size() > 1) {
                    str2 = "one_to_two_start";
                } else {
                    str2 = "two_to_one_start";
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", str2).setContentExt(null, null, jSONObject));
                b.this.idR.coh();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.idV) {
                    if (b.this.idV) {
                        b.this.idR.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.idR.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.idN != null) {
                    b.this.idN.setIsScrollable(b.this.ieq && z);
                    b.this.idN.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cE(boolean z) {
                boolean z2 = true;
                if (!z || b.this.cnZ()) {
                    if (b.this.idM != null) {
                        b.this.idM.clf();
                        return;
                    }
                    return;
                }
                if (b.this.hFX.Fm().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.idM != null) {
                    b.this.idM.oO(z2);
                }
            }
        };
        this.ieL = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.idN != null && i == 0) {
                    b.this.cnM();
                    com.baidu.live.d.xc().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.hGF = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.n.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.R(b.this.hFX.Fm());
                } else if (i2 == 2) {
                    b.this.f(b.this.hFX.bTK());
                } else if (i2 == 3) {
                    b.this.bx(i, str2);
                } else if (i2 == 4) {
                    b.this.aI(obj);
                } else if (i2 == 5) {
                    b.this.cnP();
                }
            }
        };
        this.ieM = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.cky() != null && b.this.mTbPageContext != null) {
                        b.this.ieg.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.cky());
                    }
                }
            }
        };
        this.ieN = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(b.this.mTbPageContext.getPageActivity(), 0L, b.this.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "join_guardian" : "guard", true);
                buyTBeanActivityConfig.setIsFromJoinGuardclub(true);
                buyTBeanActivityConfig.setRequestCode(RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB);
                buyTBeanActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
            }
        };
        this.ieO = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.hFX != null && b.this.hFX.Fm() != null && b.this.hFX.Fm().mLiveInfo != null) {
                    long j = b.this.hFX.Fm().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + "," + iArr[1] + "]");
                    if (b.this.ieD != null) {
                        b.this.ieD.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.ieP = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.hFX != null && b.this.hFX.Fm() != null && b.this.hFX.Fm().aIz != null) {
                        if (l.longValue() == b.this.hFX.Fm().aIz.userId) {
                            b.this.hFX.Fm().aIz.isNewUser = false;
                            if (b.this.iej != null) {
                                b.this.iej.o(b.this.hFX.Fm());
                            }
                        }
                    }
                }
            }
        };
        this.ieQ = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.s.a)) {
                    com.baidu.tieba.ala.liveroom.s.a aVar2 = (com.baidu.tieba.ala.liveroom.s.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String BS = aVar2.BS();
                    if (b.this.mTbPageContext != null && b.this.hFX != null && b.this.hFX.Fm() != null && b.this.hFX.Fm().aIz != null) {
                        if (valueOf.longValue() == b.this.hFX.Fm().aIz.userId && com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPK != null && com.baidu.live.ae.a.Qj().bAS.aPK.CA()) {
                            g.vz(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, BS));
                        }
                    }
                }
            }
        };
        this.ieR = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.hJK != null) {
                    b.this.mHandler.removeCallbacks(b.this.hJK);
                }
                b.this.ciU();
            }
        };
        this.hGv = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.idK = aVar;
        this.idT = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ag.c.class);
        if (runTask != null) {
            this.ieD = (com.baidu.live.ag.c) runTask.getData();
        }
        this.hFX = new com.baidu.tieba.ala.liveroom.n.d(getPageContext());
        this.hFX.a(this.hGF);
        this.hFX.HY(str);
        this.iea = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.ieM);
        MessageManager.getInstance().registerListener(this.ieN);
        MessageManager.getInstance().registerListener(this.ieO);
        MessageManager.getInstance().registerListener(this.ieP);
        MessageManager.getInstance().registerListener(this.ieQ);
        MessageManager.getInstance().registerListener(this.ieR);
        MessageManager.getInstance().registerListener(this.ieI);
        MessageManager.getInstance().registerListener(this.hsH);
        MessageManager.getInstance().registerListener(this.ieB);
        MessageManager.getInstance().registerListener(this.ieC);
        MessageManager.getInstance().registerListener(this.bgy);
    }

    private void R(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.idY = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.idY.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void c(Intent intent, boolean z) {
        R(intent);
        this.buO = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.buO)) {
            this.buO = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        if (z) {
            this.iec = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.iec = intent.getStringExtra("room_id");
        }
        this.buN = intent.getLongExtra("live_id", 0L);
        this.ief = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.hFX.b((AlaLiveInfoCoreData) serializableExtra);
            this.ief = true;
        }
        this.hFX.setIsMixLive(z);
        TbConfig.liveScene = 1;
        d(intent, z);
        this.ieq = this.iep == null || !this.iep.aQd;
        this.iea.setOtherParams(this.otherParams);
        pd(z);
        cnt();
        this.mHandler.removeCallbacks(this.iey);
        this.mHandler.postDelayed(this.iey, 1000L);
    }

    private void d(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.ies = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hoC = null;
            if (z) {
                stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_EXTRA_PARAMS);
            } else {
                stringExtra = intent.getStringExtra("params");
            }
            if (this.DEBUG) {
                Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.iee = new JSONObject(stringExtra);
                if (this.iee != null) {
                    String ed = ed(this.iee);
                    String ec = ec(this.iee);
                    if ((!TextUtils.isEmpty(ed) && TextUtils.equals(this.iec, ed)) || (!TextUtils.isEmpty(ec) && TextUtils.equals(this.buN + "", ec))) {
                        String eb = eb(this.iee);
                        if (!TextUtils.isEmpty(eb)) {
                            eb = URLDecoder.decode(eb, "UTF-8");
                        }
                        if (this.DEBUG) {
                            Log.i("LivePlayerActivity", "@@ coverUrl = " + eb);
                        }
                        String ee = ee(this.iee);
                        if (this.DEBUG) {
                            Log.i("LivePlayerActivity", "@@ liveUrl = " + ee);
                        }
                        if (!this.ief) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.buN;
                            alaLiveInfoCoreData.screenDirection = ea(this.iee);
                            if (!TextUtils.isEmpty(eb)) {
                                alaLiveInfoCoreData.liveCover = eb;
                            }
                            a(ee, alaLiveInfoCoreData);
                            this.hFX.b(alaLiveInfoCoreData);
                            this.ief = true;
                        }
                    }
                    String optString2 = this.iee.optString("extra");
                    try {
                        this.ieG = Long.parseLong(this.iec);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.ieH = this.buN;
                    if (TextUtils.isEmpty(optString2)) {
                        this.iep = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString2);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString3 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString3) && this.hFX != null) {
                            this.hFX.Hs(optString3);
                        }
                        this.ieE = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.ieF = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hoC = jSONObject.optString("live_back_scheme");
                        this.iep = new bw();
                        this.iep.aQd = jSONObject.optInt("is_hot") == 1;
                        if (this.iep.aQd) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.ies = AlaLiveSwitchData.isHotLive;
                        this.iep.aQe = jSONObject.optString("task_id");
                        this.iep.aQc = !TextUtils.isEmpty(this.iep.aQe);
                        this.iep.aQf = jSONObject.optInt("task_type");
                        this.iep.aQg = jSONObject.optInt("task_im_count");
                        this.iep.aQh = jSONObject.optLong("task_gift_total_price");
                        this.iep.aQi = jSONObject.optLong("task_watch_time");
                        this.iep.aQj = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.iee.put("from", optString);
                        }
                        String optString4 = jSONObject.optString("back_app_scheme");
                        String optString5 = jSONObject.optString("back_app_icon");
                        String optString6 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            this.idQ = new com.baidu.tieba.ala.liveroom.d.b();
                            this.idQ.setScheme(optString4);
                            this.idQ.setImageUrl(optString5);
                            this.idQ.setTitle(optString6);
                        }
                    }
                    this.idZ = this.iee.optString("open_giftlist");
                    this.iee.remove("cover");
                    this.iee.remove("live_url");
                    this.iee.remove("enterRoomId");
                    this.iee.remove("enterLiveId");
                    this.iee.remove("open_giftlist");
                    this.iee.remove("extra");
                    this.otherParams = this.iee.toString();
                    if (this.hFX != null) {
                        this.hFX.setOtherParams(this.otherParams);
                    }
                    this.iee.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.iee.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.iee.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.iee.optString("source");
                    }
                    this.ier = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.iee.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.hFX != null) {
                        this.hFX.vY(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.idS = new AlaLastLiveroomInfo();
                this.idS.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.buN), String.valueOf(this.iec), null, cnJ(), this.idK != null ? this.idK.cnp() : false);
    }

    private int ea(JSONObject jSONObject) {
        int i = 1;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("extra")) {
                    try {
                        i = new JSONObject(jSONObject.optString("extra")).optInt("screen_direction", 1);
                    } catch (JSONException e) {
                        i = jSONObject.optInt("screen_direction", 1);
                    }
                } else {
                    i = jSONObject.optInt("screen_direction", 1);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.DEBUG) {
                Log.i("LivePlayerActivity", "@@ screenDirection = " + i);
            }
        }
        return i;
    }

    private String eb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        String str = "";
        try {
            if (jSONObject.has("extra")) {
                try {
                    str = new JSONObject(jSONObject.optString("extra")).optString("cover");
                } catch (JSONException e) {
                    str = jSONObject.optString("cover");
                }
            } else {
                str = jSONObject.optString("cover");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.DEBUG) {
            Log.i("LivePlayerActivity", "@@ coverUrl = " + str);
            return str;
        }
        return str;
    }

    private String ec(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        String str = "";
        try {
            if (jSONObject.has("extra")) {
                try {
                    str = new JSONObject(jSONObject.optString("extra")).optString("enterLiveId");
                } catch (JSONException e) {
                    str = jSONObject.optString("enterLiveId");
                }
            } else {
                str = jSONObject.optString("enterLiveId");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.DEBUG) {
            Log.i("LivePlayerActivity", "@@ enterLiveId = " + str);
            return str;
        }
        return str;
    }

    private String ed(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        String str = "";
        try {
            if (jSONObject.has("extra")) {
                try {
                    str = new JSONObject(jSONObject.optString("extra")).optString("enterRoomId");
                } catch (JSONException e) {
                    str = jSONObject.optString("enterRoomId");
                }
            } else {
                str = jSONObject.optString("enterRoomId");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.DEBUG) {
            Log.i("LivePlayerActivity", "@@ enterRoomId = " + str);
            return str;
        }
        return str;
    }

    private String ee(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        String str = "";
        try {
            if (jSONObject.has("extra")) {
                try {
                    str = new JSONObject(jSONObject.optString("extra")).optString("live_url");
                } catch (JSONException e) {
                    str = jSONObject.optString("live_url");
                }
            } else {
                str = jSONObject.optString("live_url");
            }
            if (!TextUtils.isEmpty(str)) {
                str = URLDecoder.decode(str, "UTF-8");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.DEBUG) {
            Log.i("LivePlayerActivity", "@@ liveUrl = " + str);
            return str;
        }
        return str;
    }

    private void a(String str, AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (!TextUtils.isEmpty(str) && alaLiveInfoCoreData != null) {
            if (str.toLowerCase().endsWith(".flv")) {
                alaLiveInfoCoreData.flvUrl = str;
            } else if (str.toLowerCase().endsWith(".m3u8")) {
                alaLiveInfoCoreData.hlsUrl = str;
            } else if (str.toLowerCase().startsWith("rtmp://")) {
                alaLiveInfoCoreData.rtmpUrl = str;
            }
        }
    }

    public void cnt() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.hFX.aw(this.uk, this.buO, this.mForumName);
        } else if (this.hFX.Fm() != null && this.hFX.Fm().mLiveInfo != null && this.hFX.Fm().mLiveInfo.live_id > 0) {
            this.hFX.a(this.hFX.Fm().mLiveInfo.live_id, false, this.buO, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.buO = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                pf(false);
                return;
            }
            this.hFX.aw(this.uk, this.buO, this.mForumName);
        } else if (!TextUtils.isEmpty(this.iec)) {
            this.hFX.HX(this.iec);
        } else if (this.buN > 0) {
            this.hFX.a(this.buN, false, this.buO, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            pf(false);
        }
    }

    private void pd(boolean z) {
        this.byF = true;
        this.idU = false;
        pe(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        b(visibilityRegion);
        c(visibilityRegion);
        com.baidu.live.core.layer.b.Bc().l(this.hGr);
        this.ieb = new com.baidu.tieba.ala.liveroom.c.c();
        this.ieb.a(this.ieK);
        this.ieb.setOtherParams(this.otherParams);
        this.ieb.nO(this.ier);
        this.ieb.a(this.idK.cnq());
        cnx();
        cnu();
        cnw();
        cnv();
    }

    private void pe(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_main_layout, (ViewGroup) null);
        this.idL = (SafeFrameLayout) inflate.findViewById(a.f.live_root_view);
        ViewCommonUtil.setForceDarkAllowed(this.idL, false);
        this.idN = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.idN.setOnPageChangeListener(this.ieL);
        this.idN.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void cgF() {
                b.this.cnM();
            }
        });
        this.idN.setBoundaryCaching(true);
        this.idN.setDetermineYRatio(1.0f);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.idO = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.idO.cgD();
        this.idM = this.idO.vF(this.mSelectedPosition);
        this.idO.a(this.mSelectedPosition, this.hFX.Fm());
        this.idN.setAdapter(this.idO);
        this.idN.setCurrentItem(this.mSelectedPosition);
        this.idN.setIsScrollable(this.ieq);
        this.idN.setIsMixLive(z);
        this.hGq = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hGr = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
    }

    private void b(Rect rect) {
        this.idR = SdkLivePlayer.gc(getPageContext().getPageActivity());
        if (this.idR == null) {
            this.idN.setIsScrollable(false);
            if (this.hFX != null) {
                this.hFX.cancelLoadData();
            }
            cgH();
            return;
        }
        this.idR.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.c.sdk_transparent));
        this.idR.setIPlayerCallBack(this.bOP);
        this.idR.setIPlayerAudioFocusCallBack(this.ieJ);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.idM.a(this.idR, layoutParams, true);
    }

    private void cnu() {
        this.idP = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext, this.hGq);
    }

    private void cnv() {
        CustomResponsedMessage runTask;
        if (this.hGZ == null && (runTask = MessageManager.getInstance().runTask(2913266, com.baidu.live.v.b.class)) != null) {
            this.hGZ = (com.baidu.live.v.b) runTask.getData();
        }
        if (this.hGZ != null) {
            this.hGZ.setParentView(this.hGq);
        }
    }

    private void cnw() {
        CustomResponsedMessage runTask;
        if (this.hGX == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.t.d.class)) != null) {
            this.hGX = (com.baidu.live.t.d) runTask.getData();
        }
        if (this.hGX != null) {
            this.hGX.setParentView(this.hGq);
        }
    }

    private void cgH() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.pf(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void c(Rect rect) {
        this.hGp = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.ala_liveroom_player_layout, null);
        this.hGp.setSwipeClearEnable(true);
        this.hGp.hRi = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.idM.a(this.hGp, layoutParams);
    }

    private void cnx() {
        if (this.hFX != null && this.hFX.Fm() != null) {
            this.aDd = this.hFX.Fm();
            if (this.aDd.mLiveInfo != null) {
                a(this.aDd.mLiveInfo, this.ief);
                if (this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.idV);
                    }
                    if (!this.idV) {
                        this.idR.c(this.aDd.mLiveInfo);
                    } else {
                        this.idR.setPlayLiveInfo(this.aDd.mLiveInfo);
                    }
                    if (this.ieb != null) {
                        this.ieb.a(this.mTbPageContext, this.hGp, this.idR, this.idM, this.hFX, this.buO, this.idX, this.hGv, this.idY, this.iep, this.idN);
                        k(this.aDd.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean cny() {
        boolean z;
        AlaLiveInfoData cjz;
        if (this.idK.cnp()) {
            return false;
        }
        if (this.hFX == null || (cjz = this.hFX.cjz()) == null || cjz.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !cjz.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.ieG + ", getPlayingRoomID:" + cnz() + ", mSchemeLiveId:" + this.ieH + ", getPlayingLiveID:" + cnA());
        }
        return z || cnC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cnz() {
        AlaLiveInfoData cjz;
        if (this.hFX == null || (cjz = this.hFX.cjz()) == null) {
            return 0L;
        }
        return cjz.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cnA() {
        AlaLiveInfoData cjz;
        if (this.hFX == null || (cjz = this.hFX.cjz()) == null) {
            return 0L;
        }
        return cjz.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnB() {
        boolean z = false;
        if (!this.idK.cnp()) {
            if (this.ieE && (this.ieG == cnz() || this.ieH == cnA())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean cnC() {
        boolean z = this.ieF && (this.ieG == cnz() || this.ieH == cnA());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean cnD() {
        if (iet <= 0) {
            return false;
        }
        if (!(cnB() || cny()) || FloatPermissionUtil.MP()) {
            return false;
        }
        iet--;
        FloatPermissionUtil.ah(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0626a interfaceC0626a) {
        if (!FloatPermissionUtil.MP()) {
            if (this.ieu) {
                return true;
            }
            this.ieu = true;
            if (z) {
                FloatPermissionUtil.ah(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (cnB()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.ieF) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a fW = com.baidu.tieba.ala.floating.b.fW(getPageContext().getPageActivity());
        fW.a(interfaceC0626a);
        fW.dK(jSONObject);
        com.baidu.tieba.ala.floating.b.fW(getPageContext().getPageActivity()).a(this.idR, this.hFX.Fm(), this.buO, this.hGv);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bUO() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bUJ = com.baidu.tieba.ala.floating.b.bUJ();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0626a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0626a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bUJ == null || bUJ.room_id == b.this.cnz() || bUJ.live_id == b.this.cnA()) {
                    if (b.this.idR != null) {
                        b.this.cnE();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.idV);
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnE() {
        ArrayList arrayList = (ArrayList) this.idR.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.idR.cog();
            this.idR.af(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bUM();
    }

    public void pb(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.idW = z;
    }

    private void cnF() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.ieq) {
                this.idN.setIsScrollable(true);
            } else {
                this.idN.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Bc().onBackPressed() && ((this.ieb == null || !this.ieb.onKeyDown(i, keyEvent)) && (this.ieb == null || !this.ieb.cbP()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cnF();
            } else if ((this.ieb == null || this.ieb.cbQ()) && (!cnB() || a(true, (a.InterfaceC0626a) null))) {
                this.iev = true;
                pf(true);
                bYU();
            }
        }
        return true;
    }

    public void bYU() {
        if (!TextUtils.isEmpty(this.hoC)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hoC);
                this.hoC = null;
            }
        }
    }

    public void pf(boolean z) {
        U(z, false);
    }

    public void U(boolean z, boolean z2) {
        nU(!z);
        if (this.idR != null && !this.idR.isFloatingMode()) {
            this.idR.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.Bc().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cnH();
        long j = -1;
        if (this.hFX != null && this.hFX.cjz() != null) {
            j = this.hFX.cjz().room_id;
        }
        this.idK.b(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void nU(boolean z) {
        if (this.idK.cnp() && this.idK.cnq() != null) {
            this.idK.cnq().x("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.idS = null;
        if (al.FB() != null) {
            al.FB().FA();
        }
        com.baidu.live.core.layer.b.Bc().Bd();
        if (this.ieD != null) {
            this.ieD.release();
        }
        if (this.iej != null) {
            this.iej.release();
        }
        this.iep = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.hFX != null) {
            try {
                this.hFX.Hs(null);
                AlaLiveInfoData cjz = this.hFX.cjz();
                if (cjz != null) {
                    this.hFX.fI(cjz.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.ieg.stopRecord();
        LiveTimerManager.getInstance().stop();
        cnG();
        if (this.idR != null && !this.idR.isFloatingMode()) {
            this.idR.cM(z);
        }
        if (this.ieb != null) {
            this.ieb.nU(z);
        }
        this.iei = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Mu().brr != null && this.aDd != null) {
            com.baidu.live.liveroom.a.b.Mu().brr.b(this.aDd.mLiveInfo);
        }
        ac.gn("");
        x.Fc().release();
        if (this.hGX != null) {
            this.hGX.Fy();
        }
        if (this.hGZ != null) {
            this.hGZ.Fy();
        }
        if (this.idK != null && this.idK.cnp()) {
            ac.Fx();
        }
    }

    private void cnG() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cnH() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(ab abVar) {
        if (abVar != null) {
            this.aDd = abVar;
            if (this.ieb != null) {
                this.ieb.a(abVar);
            }
            if (this.hGZ != null && this.hFX.Fm() != null) {
                this.hGZ.b(this.hFX.Fm(), this.otherParams);
            }
            cnD();
        }
    }

    private void c(v vVar) {
        if (this.ieb != null) {
            this.ieb.c(vVar);
        }
    }

    private void V(ab abVar) {
        this.aDd = abVar;
        cnD();
    }

    private void cnI() {
        long j;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.ieq = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.ieq = true;
        }
        this.idN.setIsScrollable(this.ieq);
        this.ies = AlaLiveSwitchData.isHotLive;
        if (this.aDd != null) {
            a(this.aDd.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.idM.a(this.hGp, null);
            if (!isFloatingMode()) {
                a(this.idM, this.aDd.mLiveInfo, this.byF);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aDd.mLiveInfo.live_id), String.valueOf(this.aDd.mLiveInfo.room_id), String.valueOf(this.aDd.mLiveInfo.feed_id), cnJ(), this.idK != null ? this.idK.cnp() : false);
            if (com.baidu.live.liveroom.a.b.Mu().brr != null) {
                com.baidu.live.liveroom.a.b.Mu().brr.a(this.aDd.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.byF = false;
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                String str = "";
                String str2 = "";
                if (this.hFX != null && this.hFX.Fm() != null && this.hFX.Fm().mLiveInfo != null) {
                    j = this.hFX.Fm().mLiveInfo.live_id;
                    str2 = this.hFX.Fm().mLiveInfo.feed_id;
                    str = this.hFX.Fm().mLiveInfo.room_id + "";
                } else {
                    if (this.buN > 0) {
                        j2 = this.buN;
                    }
                    if (TextUtils.isEmpty(this.iec)) {
                        j = j2;
                    } else {
                        str = this.iec;
                        j = j2;
                    }
                }
                alaStaticItem.addParams("live_id", j + "");
                alaStaticItem.addParams("room_id", str);
                alaStaticItem.addParams("feed_id", str2);
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.ACTION_PLAYSTART_LIVE);
                String str3 = "";
                String str4 = "";
                String str5 = "";
                String str6 = "";
                if (this.hFX != null && this.hFX.Fm() != null && this.hFX.Fm().mLiveInfo != null) {
                    str3 = this.hFX.Fm().mLiveInfo.feed_id;
                    str4 = this.hFX.Fm().mLiveInfo.live_id + "";
                    str5 = this.hFX.Fm().mLiveInfo.room_id + "";
                    str6 = this.hFX.Fm().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            cnD();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String cnJ() {
        if (this.iee == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.iee.optString("source");
            String optString2 = this.iee.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.iee.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.iee.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.iee.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bUO();
        } else if (this.idR != null && this.idR.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.idR.getVideoPath();
                String d = com.baidu.live.u.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.idR.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.u.h.aH(videoPath, d)) {
                    this.idR.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.u.h.aG(videoPath, d)) {
                    this.idR.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.cz(this.idR)) {
                        ((ViewGroup) this.idR.getParent()).removeView(this.idR);
                        alaLiveRoomBlurPageLayout.a(this.idR, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.idV) {
                        this.idR.c(alaLiveInfoData);
                        return;
                    } else {
                        this.idR.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.idR.cog();
        } else if (this.idR != null && this.idR.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.idR, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.idV) {
                    this.idR.c(alaLiveInfoData);
                } else {
                    this.idR.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b2 = b(iArr, z, i, i2, i3);
        if (this.idR != null) {
            this.idR.setLayoutParams(b2);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.bs(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.bt(this.mTbPageContext.getPageActivity());
                int br = p.br(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = br + i;
                } else {
                    dimensionPixelSize = br + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
                }
                layoutParams.topMargin = dimensionPixelSize;
            } else {
                layoutParams.width = iArr[0];
                layoutParams.height = iArr[1];
                layoutParams.topMargin = 0;
            }
        } else {
            layoutParams.width = iArr[0];
            layoutParams.height = iArr[1] - i3;
            layoutParams.topMargin = 0;
        }
        return layoutParams;
    }

    public void cnK() {
        this.byF = true;
    }

    public boolean cnL() {
        return this.byF;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        a(UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()), alaLiveInfoData, z);
    }

    private void a(int i, AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (this.idR != null) {
            int realScreenOrientation = i == 0 ? UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) : i;
            if (alaLiveInfoData != null) {
                z2 = alaLiveInfoData.screen_direction == 2;
            } else {
                z2 = false;
            }
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.mTbPageContext.getPageActivity(), 48.0f) : 0;
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
            if (z && (screenFullSize[0] <= 0 || screenFullSize[1] <= 0)) {
                screenFullSize[0] = getScreenWidth(this.mTbPageContext.getPageActivity());
                screenFullSize[1] = getScreenHeight(this.mTbPageContext.getPageActivity());
            }
            if (realScreenOrientation == 1) {
                z3 = screenFullSize[1] < screenFullSize[0];
            } else {
                z3 = screenFullSize[1] > screenFullSize[0];
            }
            if (z3) {
                int i2 = screenFullSize[0];
                screenFullSize[0] = screenFullSize[1];
                screenFullSize[1] = i2;
            }
            if (this.idM != null) {
                this.idM.setBackgroundColor(0);
            }
            int i3 = this.idR.getLayoutParams().width;
            int i4 = this.idR.getLayoutParams().height;
            int i5 = this.idR.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.idR.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b2 = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b2.width != i3 || b2.height != i4 || b2.topMargin != i5) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.hGp != null) {
                this.hGp.setLayoutParams(c);
            }
            if (this.idM != null) {
                this.idM.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.iea != null) {
                this.iea.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ieb != null) {
                this.ieb.l(c.width, c.height, realScreenOrientation);
            }
        }
    }

    public int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private void wx(int i) {
        boolean z = true;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            if (this.idM != null) {
                this.idM.setBgImageUrl(this.aDd.mLiveInfo.cover, this.aDd.mLiveInfo);
            }
            this.idO.a(this.mSelectedPosition, cnN(), this.aDd);
            this.idO.b(this.mSelectedPosition, cnO(), this.aDd);
            if (this.idM != null) {
                this.idM.requestLayout();
                this.idM.M(i, this.aDd.mLiveInfo.screen_direction == 2);
            }
        }
        if (this.aDd != null) {
            a(i, this.aDd.mLiveInfo, false);
        }
        boolean clg = this.idM.clg();
        boolean z2 = i == 1;
        if (this.aDd == null || this.aDd.mLiveInfo == null || this.aDd.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!cnZ()) {
            if (this.idR != null && this.idR.getParent() == null) {
                this.idM.a(this.idR, null, false);
                if (this.aDd != null && this.aDd.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.idV) {
                        this.idR.c(this.aDd.mLiveInfo);
                    } else {
                        this.idR.setPlayLiveInfo(this.aDd.mLiveInfo);
                    }
                }
            }
            if (clg && !cnZ() && this.ieb != null) {
                this.idM.oO(z);
                return;
            }
            return;
        }
        this.idM.clc();
    }

    private FrameLayout.LayoutParams c(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = iArr[0];
                layoutParams.height = (iArr[1] - i) - i3;
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    layoutParams.topMargin = i;
                } else {
                    layoutParams.topMargin = 0;
                }
            } else {
                layoutParams.width = iArr[0];
                layoutParams.height = iArr[1];
                layoutParams.gravity = 3;
                layoutParams.topMargin = 0;
            }
        } else {
            layoutParams.width = iArr[0];
            layoutParams.height = (iArr[1] - i) - i3;
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = i;
            } else {
                layoutParams.topMargin = 0;
            }
        }
        layoutParams.bottomMargin = 0;
        return layoutParams;
    }

    private void i(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hFX.a(alaLiveInfoData.live_id, true, this.buO, this.mForumName, this.ies);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnM() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.idN != null && this.hGp != null && this.mSelectedPosition != (currentItem = this.idN.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.h.sdk_neterror);
                this.idN.setCurrentItem(this.mSelectedPosition);
            } else if (!this.byF && ListUtils.getCount(this.hFX.cjp()) <= 1) {
                this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                this.idN.setCurrentItem(this.mSelectedPosition);
                this.hFX.g(this.hFX.cjz());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.hFX.cju() && i < 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                    this.idN.setCurrentItem(this.mSelectedPosition);
                } else if (this.hFX.cjv() && i > 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                    this.idN.setCurrentItem(this.mSelectedPosition);
                    this.hFX.g(this.hFX.cjz());
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.hFX.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    nU(true);
                    this.idM.clc();
                    this.idM.Xi();
                    this.idM.cld();
                    if (this.hFX.Fm() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.hFX.Fm().mLiveInfo.live_id + "", this.hFX.Fm().mLiveInfo.room_id + "", this.hFX.Fm().aId.userId + "", this.hFX.Fm().aId.userName, System.currentTimeMillis(), this.hFX.Fm().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.hFX.Fm().mLiveInfo.live_id + "", this.hFX.Fm().mLiveInfo.room_id + "", this.hFX.Fm().aId.userId + "", this.hFX.Fm().aId.userName, System.currentTimeMillis(), this.hFX.Fm().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.ieh != null) {
                        long j = this.hFX.Fm().mLiveInfo.live_id;
                        if (this.ieh.liveId == j && this.ieh.startTime > 0) {
                            this.ieh.endTime = System.currentTimeMillis();
                            long j2 = this.ieh.endTime - this.ieh.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.ieh.roomId + "", this.ieh.vid, j2 / 1000, this.otherParams);
                        }
                        this.ieh = null;
                    }
                    cob();
                    if (this.ieD != null) {
                        this.ieD.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.idM = this.idO.vG(this.mSelectedPosition);
                    this.idM.cle();
                    wy(i);
                    cnD();
                }
            }
        }
    }

    public void wy(int i) {
        if (i < 0) {
            this.hFX.vZ(this.hFX.cjw() - 1);
        } else if (i > 0) {
            this.hFX.vZ(this.hFX.cjw() + 1);
        }
        if (this.ieb != null) {
            this.ieb.a(this.idM);
        }
        this.idO.a(this.mSelectedPosition, cnN(), this.aDd);
        this.idO.b(this.mSelectedPosition, cnO(), this.aDd);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.hFX != null) {
            int cjw = this.hFX.cjw();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", cjw + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.hFX.cjp() != null && this.hFX.cjp().size() > cjw && this.hFX.cjp().get(cjw) != null) {
                AlaLiveInfoData alaLiveInfoData = this.hFX.cjp().get(cjw);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hFX != null) {
            AlaLiveInfoData cjz = this.hFX.cjz();
            com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(cjz.live_id)));
            if (cjz != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(cjz.live_id), String.valueOf(cjz.room_id), null, cnJ(), this.idK != null ? this.idK.cnp() : false);
                l.c(this.hFX.cjw(), cjz.room_id, cjz.live_id);
                cjz.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bUO();
                }
                a(this.idM, cjz, this.byF);
                this.byF = false;
                if (this.ieb != null) {
                    this.ieb.a(this.mTbPageContext, this.hGp, this.idR, this.idM, this.hFX, this.buO, this.idX, this.hGv, null, this.iep, this.idN);
                    short s = 2;
                    if (cjz.screen_direction == 2) {
                        s = 1;
                    }
                    k(s);
                }
                a(cjz, false);
            } else {
                l.ic("currentLiveInfo is null");
            }
            i(cjz);
            this.idM.a(this.hGp, null);
            if (this.ieb != null) {
                this.ieb.cbN();
            }
            this.hFX.g(cjz);
        }
    }

    private AlaLiveInfoData cnN() {
        List<AlaLiveInfoData> cjp = this.hFX.cjp();
        if (cjp == null || cjp.size() == 0) {
            if (this.aDd == null) {
                return null;
            }
            return this.aDd.mLiveInfo;
        }
        int cjw = this.hFX.cjw();
        int size = cjp.size();
        return cjp.get(((cjw + size) - 1) % size);
    }

    private AlaLiveInfoData cnO() {
        List<AlaLiveInfoData> cjp = this.hFX.cjp();
        if (cjp == null || cjp.size() == 0) {
            if (this.aDd == null) {
                return null;
            }
            return this.aDd.mLiveInfo;
        }
        return cjp.get((this.hFX.cjw() + 1) % cjp.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(int i, String str) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        CustomResponsedMessage runTask3;
        CustomResponsedMessage runTask4;
        CustomResponsedMessage runTask5;
        TbConfig.liveScene = 1;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.idV) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            pf(false);
            return;
        }
        ab Fm = this.hFX.Fm();
        V(Fm);
        this.hFX.cjq();
        if (this.byF) {
            this.hFX.oG(false);
        }
        this.hGv = System.currentTimeMillis() / 1000;
        if (this.ieb != null) {
            this.ieb.a(this.mTbPageContext, this.hGp, this.idR, this.idM, this.hFX, this.buO, this.idX, this.hGv, this.idY, this.iep, this.idN);
            short s = 2;
            if (Fm.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            k(s);
        }
        if (this.idK.cnq() != null && this.idK.cnp()) {
            this.idK.cnq().x("load_finish", null);
            if (Fm.mLiveInfo.screen_direction == 2) {
                this.idK.cnq().x("screen_auto_rotate", true);
            } else {
                this.idK.cnq().x("screen_auto_rotate", false);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
                this.idK.cnq().x("mix_room_scroll", Boolean.valueOf(!TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()));
            }
        }
        cnI();
        if (Fm != null && Fm.mLiveInfo != null && Fm.mLiveInfo.live_status == 2) {
            this.idO.a(this.mSelectedPosition, this.hFX.Fm());
            e(Fm, false);
            this.byF = false;
            W(Fm);
            return;
        }
        if (this.hGT == null && (runTask5 = MessageManager.getInstance().runTask(2913229, e.class)) != null) {
            this.hGT = (e) runTask5.getData();
        }
        if (this.hGT != null) {
            this.hGT.Pj();
        }
        if (this.hGU == null && (runTask4 = MessageManager.getInstance().runTask(2913292, com.baidu.live.t.b.class)) != null) {
            this.hGU = (com.baidu.live.t.b) runTask4.getData();
        }
        if (this.hGU != null) {
            this.hGU.Pj();
        }
        if (this.hGV == null && (runTask3 = MessageManager.getInstance().runTask(2913296, com.baidu.live.t.b.class)) != null) {
            this.hGV = (com.baidu.live.t.b) runTask3.getData();
        }
        if (this.hGV != null) {
            this.hGV.Pj();
        }
        if (this.hGW == null && (runTask2 = MessageManager.getInstance().runTask(2913293, f.class)) != null) {
            this.hGW = (f) runTask2.getData();
        }
        if (this.hGW != null) {
            this.hGW.Pj();
        }
        if (this.hGY == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.v.c.class)) != null) {
            this.hGY = (com.baidu.live.v.c) runTask.getData();
        }
        if (this.hGY != null) {
            this.hGY.Pj();
        }
        boolean z = (this.ieb == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        ac.e(Fm);
        if (z) {
            if (!this.iem || !TextUtils.equals(q.Vv(), this.ien)) {
                ac.b(getPageContext(), false, this.idK != null && this.idK.cnp());
                com.baidu.live.ae.e.Qz().QA();
                this.iem = true;
                this.ien = q.Vv();
            }
            ac.gn("");
            ac.Ft();
        }
        if (this.hFX.Fm() != null && this.hFX.Fm().mLiveInfo != null) {
            this.hFX.j(this.hFX.Fm().mLiveInfo.live_id, !this.iei);
            this.iei = true;
        }
        if (this.ieb != null) {
            this.ieb.b(this.idS);
            this.ieb.nT(TextUtils.equals(this.idZ, "1"));
            this.idZ = "";
        }
        if (this.idP != null) {
            this.idP.a(this.aDd, this.idQ);
        }
        a(this.hFX.Fm());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.hFX.Fm() != null && b.this.hFX.Fm().mLiveInfo != null) {
                    b.this.hFX.a(b.this.hFX.Fm().mLiveInfo.live_id, b.this.buO, b.this.hGv);
                }
            }
        });
        if (z && this.hFX.Fm() != null && this.hFX.Fm().aId != null) {
            bv bvVar = com.baidu.live.ae.a.Qj().bAS;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bvVar != null && bvVar.aPP != null && bvVar.aPP.aSu) {
                m(true, this.hFX.Fm().aId.userId);
            }
        }
        this.byF = false;
        if (z && this.hFX.Fm() != null && this.hFX.Fm().mLiveInfo != null && this.hFX.Fm().aId != null && this.ieb != null) {
            long j = this.hFX.Fm().mLiveInfo.live_id;
            long j2 = this.hFX.Fm().mLiveInfo.room_id;
            String str2 = this.hFX.Fm().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.FB() != null) {
                    al.FB().bE(this.biC);
                    if (!this.biC) {
                        al.FB().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.ieD != null) {
                    this.ieD.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.IS() != null) {
                com.baidu.live.guardclub.e.IS().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.iej == null) {
                this.iej = new com.baidu.tieba.ala.liveroom.j.a();
                this.iej.bE(this.biC);
            }
            if (!this.biC) {
                this.iej.a(this.mTbPageContext.getPageActivity(), this.hFX.Fm(), this.otherParams);
            }
        }
        if (this.iek == null) {
            this.iek = new com.baidu.tieba.ala.liveroom.u.c(this.mTbPageContext);
            this.iek.bE(this.biC);
        }
        if (z && this.hFX.Fm() != null && this.hFX.Fm().aIz != null && !this.iel) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.iek.a(this.hFX.Fm(), this.hFX.Fm().aIz.userId);
                this.iel = true;
            }
        }
        if (this.hFX.Fm() != null && this.hFX.Fm().mLiveInfo != null && this.hFX.Fm().aIz != null) {
            com.baidu.live.p.a.e(this.hFX.Fm().mLiveInfo.live_id, this.hFX.Fm().aIz.needRename == 1);
            if (z) {
                com.baidu.live.p.a.c(this.hFX.Fm().mLiveInfo.live_id, 0);
            }
        }
        if (this.hGX != null && this.hFX.Fm() != null && this.hFX.Fm().aId != null) {
            this.hGX.bh(this.hFX.Fm().aId.userId);
        }
    }

    private void W(ab abVar) {
        String str = "";
        if (!TextUtils.isEmpty(this.uk)) {
            str = "uk=" + this.uk;
        } else if (this.buN > 0) {
            str = "live_id=" + this.buN;
        } else if (!TextUtils.isEmpty(this.iec)) {
            str = "live_room_id=" + this.iec;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            str = "url=" + this.mUrl;
        }
        LogManager.getLiveCloseLogger().doEnterLiveCloseGuestLog(abVar.mLiveInfo.live_id + "", abVar.mLiveInfo.room_id + "", abVar.mLiveInfo.feed_id, str, this.otherParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnP() {
        if (this.idT) {
            this.idO.a(this.mSelectedPosition, cnN(), this.aDd);
            this.idO.b(this.mSelectedPosition, cnO(), this.aDd);
            this.idT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.idV) {
            this.mHandler.removeCallbacks(this.iex);
            this.mHandler.postDelayed(this.iex, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(v vVar) {
        if (vVar == null) {
            if (!this.idV) {
                this.mHandler.removeCallbacks(this.iew);
                this.mHandler.postDelayed(this.iew, 5000L);
                return;
            }
            return;
        }
        if (!this.idU) {
            c(vVar);
        }
        if (!this.idV) {
            this.mHandler.removeCallbacks(this.iew);
            this.mHandler.postDelayed(this.iew, vVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnQ() {
        if (this.hFX.Fm() != null && this.hFX.Fm().mLiveInfo != null) {
            this.hFX.j(this.hFX.Fm().mLiveInfo.live_id, !this.iei);
            this.iei = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.live_status == 2) {
            this.idO.a(this.mSelectedPosition, this.hFX.Fm());
            e(abVar, false);
        } else if (abVar != null) {
            if (!this.idU) {
                ac.e(abVar);
                a(abVar);
            }
            if (!this.idV) {
                this.mHandler.removeCallbacks(this.hJK);
                this.mHandler.postDelayed(this.hJK, abVar.aIi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciU() {
        if (this.mTbPageContext != null && this.hFX.Fm() != null && this.hFX.Fm().mLiveInfo != null) {
            this.hFX.a(this.hFX.Fm().mLiveInfo.live_id, this.buO, this.hGv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ab abVar, boolean z) {
        String str;
        nU(true);
        if (!cnZ()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cjY().oI(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cjY().release();
            this.hFX.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.idM != null) {
                this.idM.Xi();
                this.idM.clc();
                this.idM.clh();
            }
            if (abVar == null || abVar.mLiveInfo == null) {
                str = null;
            } else {
                this.ied = abVar.mLiveInfo.live_id;
                str = String.valueOf(abVar.mLiveInfo.room_id);
            }
            cnF();
            cnR();
            cnS();
            if (this.idK.cnp() && !StringUtils.isNull(str) && this.idK.cnq() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.idK.cnq().x("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (abVar != null) {
                View a2 = (this.ieb == null || this.ieb.cbT() == null) ? null : this.ieb.cbT().a(this.ieb.cbI().pageContext.getPageActivity(), abVar, z);
                if (this.idM != null) {
                    this.iea.a(this.idM, a2, abVar, z, this.hFX.cjr());
                }
                if (this.ieb != null) {
                    this.ieb.nU(false);
                    this.ieb.cbO();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.idM != null) {
                    this.idM.cle();
                }
                long j = abVar.mLiveInfo.live_id;
                String str2 = abVar.mLiveInfo.feed_id;
                long j2 = abVar.aId.userId;
                String str3 = abVar.aId.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    QMStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", str + "", str2, this.otherParams);
                this.ieh = new StayTimeBean();
                this.ieh.liveId = abVar.mLiveInfo.live_id;
                this.ieh.roomId = abVar.mLiveInfo.room_id;
                this.ieh.vid = abVar.mLiveInfo.feed_id;
                this.ieh.startTime = System.currentTimeMillis();
            }
            cob();
            if (this.idP != null) {
                this.idP.a(this.aDd, this.idQ);
            }
        }
    }

    private void cnR() {
    }

    private void cnS() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.idN);
        }
    }

    public void cnT() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnU();
        } else {
            cnV();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.hFX != null && this.hFX.Fm() != null) {
            alaLiveInfoData = this.hFX.Fm().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnU();
        } else {
            cnV();
        }
        this.idN.setIsScrollable(!z && this.ieq);
        if (this.ieb != null) {
            this.ieb.onKeyboardVisibilityChanged(z);
        }
        if (this.hGp != null) {
            this.hGp.onKeyboardVisibilityChanged(z);
        }
    }

    public void cr(int i) {
        if (i == 0) {
            i = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        }
        if (isDebug()) {
            Log.d(TAG, "onScreenOrientationChanged: ");
        }
        if (i == 2) {
            cnU();
        } else {
            cnV();
        }
        this.hGp.cr(i);
        wx(i);
        if (al.FB() != null) {
            al.FB().EK();
        }
        if (this.iej != null) {
            this.iej.EK();
        }
        if (this.idP != null) {
            this.idP.cr(i);
        }
    }

    public void cnU() {
        if (this.idN != null) {
            i.ae(this.idN);
        }
    }

    public void cnV() {
        if (this.idN != null) {
            i.af(this.idN);
        }
    }

    private boolean cnW() {
        return this.iez || this.ieA;
    }

    private void cnX() {
        this.iez = false;
        this.ieA = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.ieo + " mWebOver=" + this.idW + ", isFloatingMode=" + isFloatingMode());
        }
        cnX();
        if (!this.idW || !isFloatingMode()) {
            bUO();
            if (this.hFX != null) {
                this.hFX.cjb();
                this.hFX.cjf();
            }
            if (this.ieb != null) {
                this.ieb.enterForeground();
            }
            if (this.iej != null) {
                this.iej.onResume();
            }
            if (this.iek != null) {
                this.iek.onResume();
            }
            com.baidu.live.core.layer.b.Bc().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.ieo + " mWebOver=" + this.idW + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        cnX();
        if ((!this.idW || !isFloatingMode()) && !this.ieo) {
            bUO();
            if (this.idV) {
                this.idV = false;
                cnY();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            cnD();
        }
    }

    public void cnY() {
        ciU();
        cnQ();
        this.hFX.cjq();
        if (!this.idR.isPlaying()) {
            cnE();
        } else if (this.idR.isPaused()) {
            this.idR.resume();
        }
        if (this.ieb != null) {
            this.ieb.cbS();
        }
        if (this.hFX != null && this.hFX.Fm() != null && this.hFX.Fm().mLiveInfo != null) {
            this.ieg.fL(this.hFX.Fm().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aDd.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.idW + ", isFloatingMode=" + isFloatingMode());
        }
        if (cnW() || !this.idW || !isFloatingMode()) {
            if (this.hFX != null) {
                this.hFX.cjc();
                this.hFX.cjg();
            }
            if (this.ieb != null) {
                this.ieb.enterBackground();
            }
            com.baidu.live.core.layer.b.Bc().onPause();
        }
    }

    public void V(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.iev);
        }
        if (!cnW() && z && !this.iev && cny()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0626a() { // from class: com.baidu.tieba.ala.player.b.12
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0626a
                    public boolean a(SdkLivePlayer sdkLivePlayer) {
                        if (sdkLivePlayer != null) {
                            sdkLivePlayer.pausePlay();
                            return true;
                        }
                        return true;
                    }
                });
            } else {
                return;
            }
        } else if (z2) {
            return;
        }
        this.idV = true;
        pg(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void pg(boolean z) {
        this.mHandler.removeCallbacks(this.hJK);
        this.mHandler.removeCallbacks(this.iew);
        this.mHandler.removeCallbacks(this.iex);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.idR.isFloatingMode()) {
                this.idR.pausePlay();
            }
        } else if (!z && !this.idR.isFloatingMode()) {
            this.idR.pausePlay();
        }
        if (this.ieb != null) {
            this.ieb.cbR();
        }
        this.ieg.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.FB() != null) {
                al.FB().a(i, i2, intent, this.aDd, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.ieb != null) {
            this.ieb.onActivityResult(i, i2, intent);
        }
    }

    public boolean cnZ() {
        return this.iea != null && this.iea.bUE();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ieM != null) {
            MessageManager.getInstance().unRegisterListener(this.ieM);
        }
        if (this.ieN != null) {
            MessageManager.getInstance().unRegisterListener(this.ieN);
        }
        MessageManager.getInstance().unRegisterListener(this.ieO);
        MessageManager.getInstance().unRegisterListener(this.ieP);
        MessageManager.getInstance().unRegisterListener(this.ieQ);
        MessageManager.getInstance().unRegisterListener(this.ieR);
        MessageManager.getInstance().unRegisterListener(this.ieI);
        MessageManager.getInstance().unRegisterListener(this.hsH);
        MessageManager.getInstance().unRegisterListener(this.ieB);
        MessageManager.getInstance().unRegisterListener(this.ieC);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        if (this.ieD != null) {
            this.ieD.release();
        }
        if (this.idR != null && !this.idR.isFloatingMode()) {
            this.idR.cM(true);
        }
        if (this.idP != null) {
            this.idP.onDestory();
        }
        if (this.hGX != null) {
            this.hGX.release();
            this.hGX = null;
        }
        if (this.hGZ != null) {
            this.hGZ.release();
            this.hGZ = null;
        }
        if (this.idQ != null) {
            this.idQ.reset();
        }
        if (this.ieb != null) {
            this.ieb.onDestroy();
        }
        if (this.idO != null) {
            this.idO.onDestroy();
        }
        if (this.idM != null) {
            this.idM.Xi();
            this.idM.release();
            this.idM = null;
        }
        if (this.iea != null) {
            this.iea.onDestroy();
        }
        if (this.ieh != null && this.hFX != null && this.hFX.Fm() != null) {
            long j = this.hFX.Fm().mLiveInfo.live_id;
            if (this.ieh.liveId == j && this.ieh.startTime > 0) {
                this.ieh.endTime = System.currentTimeMillis();
                long j2 = this.ieh.endTime - this.ieh.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.ieh.roomId + "", this.ieh.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.ieh = null;
        }
        if (this.hGp != null) {
            this.hGp.clk();
            this.hGp = null;
        }
        if (this.hFX != null) {
            this.hFX.destory();
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
        z.Fe().release();
        if (this.iek != null) {
            this.iek.release();
        }
        x.Fc().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String Lo() {
        return this.otherParams;
    }

    public void ph(boolean z) {
        this.ieo = z;
    }

    public void coa() {
        if (this.iee != null) {
            this.otherParams = this.iee.toString();
            if (this.hFX != null) {
                this.hFX.setOtherParams(this.otherParams);
            }
            if (this.ieb != null) {
                this.ieb.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.iea != null) {
                this.iea.setOtherParams(this.otherParams);
            }
        }
    }

    public void cob() {
        if (this.iee != null) {
            String optString = this.iee.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.iee.put("tab", "live_jump");
                        this.iee.put("tag", "");
                        this.iee.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.iee.put("tab", "liveroom");
                        this.iee.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                coa();
            }
        }
    }

    private void m(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.IQ();
        }
        bVar.setAnchorId(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void coc() {
        ac.Fw();
    }

    private void k(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.ieb.e(s);
        } else {
            this.ieb.f(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
