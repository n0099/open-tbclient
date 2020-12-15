package com.baidu.tieba.ala.player;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.view.ViewPager;
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
import com.baidu.live.ae.e;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bo;
import com.baidu.live.data.bp;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.al;
import com.baidu.live.gift.x;
import com.baidu.live.gift.z;
import com.baidu.live.liveroom.e.h;
import com.baidu.live.sdk.a;
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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.i;
import com.baidu.live.utils.o;
import com.baidu.live.utils.p;
import com.baidu.live.view.SafeFrameLayout;
import com.baidu.tieba.ala.floating.a;
import com.baidu.tieba.ala.floating.permission.FloatPermissionUtil;
import com.baidu.tieba.ala.liveroom.j.g;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew;
import com.baidu.tieba.ala.liveroom.p.d;
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
/* loaded from: classes4.dex */
public class b extends BdBaseView<TbPageContext> {
    private static String TAG = "AlaLiveViewController";
    private static int hSg = 1;
    private static WeakReference<b> mRef;
    private w aFN;
    private com.baidu.live.u.b bLe;
    private CustomMessageListener bgy;
    private boolean biE;
    private long brr;
    private String brs;
    private boolean bve;
    private AlaLoopViewPager hRA;
    private AlaLoopViewPagerAdapter hRB;
    private com.baidu.tieba.ala.liveroom.e.a hRC;
    private com.baidu.tieba.ala.liveroom.e.b hRD;
    private SdkLivePlayer hRE;
    private AlaLastLiveroomInfo hRF;
    private boolean hRG;
    private boolean hRH;
    private boolean hRI;
    private boolean hRJ;
    @Deprecated
    private boolean hRK;
    private ArrayList<AlaBroadcastGiftToastData> hRL;
    private String hRM;
    private com.baidu.tieba.ala.endliveroom.a hRN;
    private com.baidu.tieba.ala.liveroom.d.c hRO;
    private String hRP;
    private long hRQ;
    private JSONObject hRR;
    private boolean hRS;
    private com.baidu.tieba.ala.liveroom.task.c hRT;
    private StayTimeBean hRU;
    private boolean hRV;
    private com.baidu.tieba.ala.liveroom.k.a hRW;
    private com.baidu.tieba.ala.liveroom.v.c hRX;
    private boolean hRY;
    private boolean hRZ;
    private a hRx;
    private SafeFrameLayout hRy;
    private AlaLiveRoomBlurPageLayout hRz;
    CustomMessageListener hSA;
    CustomMessageListener hSB;
    CustomMessageListener hSC;
    CustomMessageListener hSD;
    private CustomMessageListener hSE;
    private String hSa;
    private boolean hSb;
    private bp hSc;
    private boolean hSd;
    private boolean hSe;
    private int hSf;
    private boolean hSh;
    private boolean hSi;
    private Runnable hSj;
    private Runnable hSk;
    private Runnable hSl;
    private boolean hSm;
    private boolean hSn;
    private CustomMessageListener hSo;
    private CustomMessageListener hSp;
    private com.baidu.live.ah.c hSq;
    private boolean hSr;
    private boolean hSs;
    private long hSt;
    private long hSu;
    private CustomMessageListener hSv;
    private com.baidu.live.u.a hSw;
    com.baidu.live.liveroom.a.c hSx;
    ViewPager.OnPageChangeListener hSy;
    HttpMessageListener hSz;
    private String hde;
    CustomMessageListener hhn;
    private AlaLiveView huQ;
    private ViewGroup huR;
    private LayerRootView huS;
    private long huW;
    private com.baidu.tieba.ala.liveroom.p.d huy;
    private d.a hvg;
    private com.baidu.live.t.d hvu;
    private com.baidu.live.t.c hvv;
    private com.baidu.live.v.c hvw;
    private com.baidu.live.v.b hvx;
    private Runnable hyg;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void cnt() {
        if (this.hRX != null) {
            this.hRX.bF(this.biE);
        }
        if (this.hRW != null) {
            this.hRW.bF(this.biE);
        }
        if (al.IE() != null) {
            al.IE().bF(this.biE);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hRG = true;
        this.huW = 0L;
        this.hRH = false;
        this.bve = true;
        this.brs = "";
        this.mForumName = "";
        this.hRI = false;
        this.hRK = false;
        this.hRM = "0";
        this.mHandler = new Handler();
        this.hRQ = -1L;
        this.otherParams = "";
        this.hRS = false;
        this.hRT = com.baidu.tieba.ala.liveroom.task.c.ckE();
        this.hRV = false;
        this.hRZ = false;
        this.hSb = false;
        this.hSe = false;
        this.hSf = 0;
        this.hSh = false;
        this.hSi = false;
        this.hyg = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjg();
            }
        };
        this.hSj = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.cnR();
            }
        };
        this.hSk = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.huy.cjC();
            }
        };
        this.hSl = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.hhn = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hSm = true;
            }
        };
        this.hSo = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hSn = true;
            }
        };
        this.hSp = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.hSv = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.biE = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.cnt();
            }
        };
        this.bgy = new CustomMessageListener(2501059) { // from class: com.baidu.tieba.ala.player.b.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_video_activity")) {
                    b.this.S(false, false);
                }
            }
        };
        this.bLe = new com.baidu.live.u.b() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.u.b
            public void eb(int i) {
                if (b.this.hRO != null) {
                    b.this.hRO.eb(i);
                }
            }
        };
        this.hSw = new com.baidu.live.u.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.u.a
            public void cD(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.hRE != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.hRE.isPlaying());
                        if (b.this.hRE.isPlaying()) {
                            if (b.this.hRE.isPaused()) {
                                b.this.hRE.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.hRE.isPlaying()) {
                        b.this.hRE.pause();
                    }
                }
            }
        };
        this.hSx = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void cu(boolean z) {
                if (z || b.this.hRO == null || b.this.hRO.cce()) {
                    if (!b.this.cnC() || b.this.a(true, (a.InterfaceC0653a) null)) {
                        b.this.hSi = true;
                        b.this.oA(true);
                        b.this.bZg();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cv(boolean z) {
                b.this.d(b.this.aFN, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.hRE.coi();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.hRI) {
                    if (b.this.hRI) {
                        b.this.hRE.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.hRE.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.hRA != null) {
                    b.this.hRA.setIsScrollable(b.this.hSd && z);
                    b.this.hRA.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cw(boolean z) {
                boolean z2 = true;
                if (!z || b.this.coa()) {
                    if (b.this.hRz != null) {
                        b.this.hRz.clh();
                        return;
                    }
                    return;
                }
                if (b.this.huy.Iq().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.hRz != null) {
                    b.this.hRz.oj(z2);
                }
            }
        };
        this.hSy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.hRA != null && i == 0) {
                    b.this.cnN();
                    com.baidu.live.d.BM().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.hvg = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.p.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.P(b.this.huy.Iq());
                } else if (i2 == 2) {
                    b.this.f(b.this.huy.bUu());
                } else if (i2 == 3) {
                    b.this.bp(i, str2);
                } else if (i2 == 4) {
                    b.this.aH(obj);
                } else if (i2 == 5) {
                    b.this.cnQ();
                }
            }
        };
        this.hSz = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.ckC() != null && b.this.mTbPageContext != null) {
                        b.this.hRT.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.ckC());
                    }
                }
            }
        };
        this.hSA = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
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
        this.hSB = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.huy != null && b.this.huy.Iq() != null && b.this.huy.Iq().mLiveInfo != null) {
                    long j = b.this.huy.Iq().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + "," + iArr[1] + "]");
                    if (b.this.hSq != null) {
                        b.this.hSq.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.hSC = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.huy != null && b.this.huy.Iq() != null && b.this.huy.Iq().aKr != null) {
                        if (l.longValue() == b.this.huy.Iq().aKr.userId) {
                            b.this.huy.Iq().aKr.isNewUser = false;
                            if (b.this.hRW != null) {
                                b.this.hRW.n(b.this.huy.Iq());
                            }
                        }
                    }
                }
            }
        };
        this.hSD = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.t.a)) {
                    com.baidu.tieba.ala.liveroom.t.a aVar2 = (com.baidu.tieba.ala.liveroom.t.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String Fk = aVar2.Fk();
                    if (b.this.mTbPageContext != null && b.this.huy != null && b.this.huy.Iq() != null && b.this.huy.Iq().aKr != null) {
                        if (valueOf.longValue() == b.this.huy.Iq().aKr.userId && com.baidu.live.ae.a.RB().bxq != null && com.baidu.live.ae.a.RB().bxq.aQK != null && com.baidu.live.ae.a.RB().bxq.aQK.FS()) {
                            g.wJ(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, Fk));
                        }
                    }
                }
            }
        };
        this.hSE = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.hyg != null) {
                    b.this.mHandler.removeCallbacks(b.this.hyg);
                }
                b.this.cjg();
            }
        };
        this.huW = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.hRx = aVar;
        this.hRG = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ah.c.class);
        if (runTask != null) {
            this.hSq = (com.baidu.live.ah.c) runTask.getData();
        }
        this.huy = new com.baidu.tieba.ala.liveroom.p.d(getPageContext());
        this.huy.a(this.hvg);
        this.huy.IE(str);
        this.hRN = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hSz);
        MessageManager.getInstance().registerListener(this.hSA);
        MessageManager.getInstance().registerListener(this.hSB);
        MessageManager.getInstance().registerListener(this.hSC);
        MessageManager.getInstance().registerListener(this.hSD);
        MessageManager.getInstance().registerListener(this.hSE);
        MessageManager.getInstance().registerListener(this.hSv);
        MessageManager.getInstance().registerListener(this.hhn);
        MessageManager.getInstance().registerListener(this.hSo);
        MessageManager.getInstance().registerListener(this.hSp);
        MessageManager.getInstance().registerListener(this.bgy);
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.hRL = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hRL.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void b(Intent intent, boolean z) {
        Q(intent);
        this.brs = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.brs)) {
            this.brs = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        if (z) {
            this.hRP = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.hRP = intent.getStringExtra("room_id");
        }
        this.brr = intent.getLongExtra("live_id", 0L);
        this.hRS = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.huy.b((AlaLiveInfoCoreData) serializableExtra);
            this.hRS = true;
        }
        this.huy.setIsMixLive(z);
        TbConfig.liveScene = 1;
        c(intent, z);
        this.hSd = this.hSc == null || !this.hSc.aRa;
        this.hRN.setOtherParams(this.otherParams);
        oy(z);
        cnu();
        this.mHandler.removeCallbacks(this.hSl);
        this.mHandler.postDelayed(this.hSl, 1000L);
    }

    private void c(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.hSf = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hde = null;
            if (z) {
                stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_EXTRA_PARAMS);
            } else {
                stringExtra = intent.getStringExtra("params");
            }
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hRR = new JSONObject(stringExtra);
                if (this.hRR != null) {
                    String optString2 = this.hRR.optString("enterRoomId");
                    String optString3 = this.hRR.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hRP, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.brr + "", optString3))) {
                        String optString4 = this.hRR.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString5 = this.hRR.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString5);
                        if (!this.hRS) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.brr;
                            alaLiveInfoCoreData.screenDirection = this.hRR.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.huy.b(alaLiveInfoCoreData);
                            this.hRS = true;
                        }
                    }
                    String optString6 = this.hRR.optString("extra");
                    try {
                        this.hSt = Long.parseLong(this.hRP);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.hSu = this.brr;
                    if (TextUtils.isEmpty(optString6)) {
                        this.hSc = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.huy != null) {
                            this.huy.Ia(optString7);
                        }
                        this.hSr = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.hSs = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hde = jSONObject.optString("live_back_scheme");
                        this.hSc = new bp();
                        this.hSc.aRa = jSONObject.optInt("is_hot") == 1;
                        if (this.hSc.aRa) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hSf = AlaLiveSwitchData.isHotLive;
                        this.hSc.aRb = jSONObject.optString("task_id");
                        this.hSc.aQZ = !TextUtils.isEmpty(this.hSc.aRb);
                        this.hSc.aRc = jSONObject.optInt("task_type");
                        this.hSc.aRd = jSONObject.optInt("task_im_count");
                        this.hSc.aRe = jSONObject.optLong("task_gift_total_price");
                        this.hSc.aRf = jSONObject.optLong("task_watch_time");
                        this.hSc.aRg = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.hRR.put("from", optString);
                        }
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.hRD = new com.baidu.tieba.ala.liveroom.e.b();
                            this.hRD.setScheme(optString8);
                            this.hRD.setImageUrl(optString9);
                            this.hRD.setTitle(optString10);
                        }
                    }
                    this.hRM = this.hRR.optString("open_giftlist");
                    this.hRR.remove("cover");
                    this.hRR.remove("live_url");
                    this.hRR.remove("enterRoomId");
                    this.hRR.remove("enterLiveId");
                    this.hRR.remove("open_giftlist");
                    this.hRR.remove("extra");
                    this.otherParams = this.hRR.toString();
                    if (this.huy != null) {
                        this.huy.setOtherParams(this.otherParams);
                    }
                    this.hRR.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRR.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRR.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRR.optString("source");
                    }
                    this.hSe = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hRR.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.huy != null) {
                        this.huy.xi(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hRF = new AlaLastLiveroomInfo();
                this.hRF.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.brr), String.valueOf(this.hRP), null, cnK(), this.hRx != null ? this.hRx.cnq() : false);
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

    public void cnu() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.huy.at(this.uk, this.brs, this.mForumName);
        } else if (this.huy.Iq() != null && this.huy.Iq().mLiveInfo != null && this.huy.Iq().mLiveInfo.live_id > 0) {
            this.huy.a(this.huy.Iq().mLiveInfo.live_id, false, this.brs, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.brs = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                oA(false);
                return;
            }
            this.huy.at(this.uk, this.brs, this.mForumName);
        } else if (!TextUtils.isEmpty(this.hRP)) {
            this.huy.ID(this.hRP);
        } else if (this.brr > 0) {
            this.huy.a(this.brr, false, this.brs, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            oA(false);
        }
    }

    private void oy(boolean z) {
        this.bve = true;
        this.hRH = false;
        oz(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.EY().j(this.huS);
        this.hRO = new com.baidu.tieba.ala.liveroom.d.c();
        this.hRO.a(this.hSx);
        this.hRO.setOtherParams(this.otherParams);
        this.hRO.nh(this.hSe);
        this.hRO.a(this.hRx.cnr());
        cny();
        cnv();
        cnx();
        cnw();
    }

    private void oz(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_main_layout, (ViewGroup) null);
        this.hRy = (SafeFrameLayout) inflate.findViewById(a.f.live_root_view);
        this.hRA = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.hRA.setOnPageChangeListener(this.hSy);
        this.hRA.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void cgP() {
                b.this.cnN();
            }
        });
        this.hRA.setBoundaryCaching(true);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.hRB = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.hRB.cgN();
        this.hRz = this.hRB.wP(this.mSelectedPosition);
        this.hRB.a(this.mSelectedPosition, this.huy.Iq());
        this.hRA.setAdapter(this.hRB);
        this.hRA.setCurrentItem(this.mSelectedPosition);
        this.hRA.setIsScrollable(this.hSd);
        this.hRA.setIsMixLive(z);
        this.huR = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.huS = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
    }

    private void c(Rect rect) {
        this.hRE = SdkLivePlayer.fL(getPageContext().getPageActivity());
        if (this.hRE == null) {
            this.hRA.setIsScrollable(false);
            if (this.huy != null) {
                this.huy.cancelLoadData();
            }
            cgR();
            return;
        }
        this.hRE.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.c.sdk_transparent));
        this.hRE.setIPlayerCallBack(this.bLe);
        this.hRE.setIPlayerAudioFocusCallBack(this.hSw);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hRz.a(this.hRE, layoutParams, true);
    }

    private void cnv() {
        this.hRC = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.huR);
    }

    private void cnw() {
        CustomResponsedMessage runTask;
        if (this.hvx == null && (runTask = MessageManager.getInstance().runTask(2913266, com.baidu.live.v.b.class)) != null) {
            this.hvx = (com.baidu.live.v.b) runTask.getData();
        }
        if (this.hvx != null) {
            this.hvx.setParentView(this.huR);
        }
    }

    private void cnx() {
        CustomResponsedMessage runTask;
        if (this.hvv == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.t.c.class)) != null) {
            this.hvv = (com.baidu.live.t.c) runTask.getData();
        }
        if (this.hvv != null) {
            this.hvv.setParentView(this.huR);
        }
    }

    private void cgR() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.oA(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.huQ = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.ala_liveroom_player_layout, null);
        this.huQ.setSwipeClearEnable(true);
        this.huQ.hFu = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hRz.a(this.huQ, layoutParams);
    }

    private void cny() {
        if (this.huy != null && this.huy.Iq() != null) {
            this.aFN = this.huy.Iq();
            if (this.aFN.mLiveInfo != null) {
                a(this.aFN.mLiveInfo, this.hRS);
                if (this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hRI);
                    }
                    if (!this.hRI) {
                        this.hRE.c(this.aFN.mLiveInfo);
                    } else {
                        this.hRE.setPlayLiveInfo(this.aFN.mLiveInfo);
                    }
                    if (this.hRO != null) {
                        this.hRO.a(this.mTbPageContext, this.huQ, this.hRE, this.hRz, this.huy, this.brs, this.hRK, this.huW, this.hRL, this.hSc, this.hRA);
                        k(this.aFN.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean cnz() {
        boolean z;
        AlaLiveInfoData cjL;
        if (this.hRx.cnq()) {
            return false;
        }
        if (this.huy == null || (cjL = this.huy.cjL()) == null || cjL.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !cjL.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.hSt + ", getPlayingRoomID:" + cnA() + ", mSchemeLiveId:" + this.hSu + ", getPlayingLiveID:" + cnB());
        }
        return z || cnD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cnA() {
        AlaLiveInfoData cjL;
        if (this.huy == null || (cjL = this.huy.cjL()) == null) {
            return 0L;
        }
        return cjL.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cnB() {
        AlaLiveInfoData cjL;
        if (this.huy == null || (cjL = this.huy.cjL()) == null) {
            return 0L;
        }
        return cjL.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnC() {
        boolean z = false;
        if (!this.hRx.cnq()) {
            if (this.hSr && (this.hSt == cnA() || this.hSu == cnB())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean cnD() {
        boolean z = this.hSs && (this.hSt == cnA() || this.hSu == cnB());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean cnE() {
        if (hSg <= 0) {
            return false;
        }
        if (!(cnC() || cnz()) || FloatPermissionUtil.Py()) {
            return false;
        }
        hSg--;
        FloatPermissionUtil.al(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0653a interfaceC0653a) {
        if (!FloatPermissionUtil.Py()) {
            if (this.hSh) {
                return true;
            }
            this.hSh = true;
            if (z) {
                FloatPermissionUtil.al(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (cnC()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.hSs) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a fG = com.baidu.tieba.ala.floating.b.fG(getPageContext().getPageActivity());
        fG.a(interfaceC0653a);
        fG.dA(jSONObject);
        com.baidu.tieba.ala.floating.b.fG(getPageContext().getPageActivity()).a(this.hRE, this.huy.Iq(), this.brs, this.huW);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bVv() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bVq = com.baidu.tieba.ala.floating.b.bVq();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0653a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0653a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bVq == null || bVq.room_id == b.this.cnA() || bVq.live_id == b.this.cnB()) {
                    if (b.this.hRE != null) {
                        b.this.cnF();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.hRI);
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
    public void cnF() {
        ArrayList arrayList = (ArrayList) this.hRE.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.hRE.coh();
            this.hRE.al(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bVt();
    }

    public void ow(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.hRJ = z;
    }

    private void cnG() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hSd) {
                this.hRA.setIsScrollable(true);
            } else {
                this.hRA.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.EY().onBackPressed() && ((this.hRO == null || !this.hRO.onKeyDown(i, keyEvent)) && (this.hRO == null || !this.hRO.ccd()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cnG();
            } else if ((this.hRO == null || this.hRO.cce()) && (!cnC() || a(true, (a.InterfaceC0653a) null))) {
                this.hSi = true;
                oA(true);
                bZg();
            }
        }
        return true;
    }

    public void bZg() {
        if (!TextUtils.isEmpty(this.hde)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hde);
                this.hde = null;
            }
        }
    }

    public void oA(boolean z) {
        S(z, false);
    }

    public void S(boolean z, boolean z2) {
        nn(!z);
        if (this.hRE != null && !this.hRE.isFloatingMode()) {
            this.hRE.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.EY().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cnI();
        long j = -1;
        if (this.huy != null && this.huy.cjL() != null) {
            j = this.huy.cjL().room_id;
        }
        this.hRx.b(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void nn(boolean z) {
        if (this.hRx.cnq() && this.hRx.cnr() != null) {
            this.hRx.cnr().z("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hRF = null;
        if (al.IE() != null) {
            al.IE().ID();
        }
        com.baidu.live.core.layer.b.EY().EZ();
        if (this.hSq != null) {
            this.hSq.release();
        }
        if (this.hRW != null) {
            this.hRW.release();
        }
        this.hSc = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.huy != null) {
            try {
                this.huy.Ia(null);
                AlaLiveInfoData cjL = this.huy.cjL();
                if (cjL != null) {
                    this.huy.fD(cjL.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.hRT.stopRecord();
        LiveTimerManager.getInstance().stop();
        cnH();
        if (this.hRE != null && !this.hRE.isFloatingMode()) {
            this.hRE.cE(z);
        }
        if (this.hRO != null) {
            this.hRO.nn(z);
        }
        this.hRV = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Pd().bqI != null && this.aFN != null) {
            com.baidu.live.liveroom.a.b.Pd().bqI.b(this.aFN.mLiveInfo);
        }
        ac.hs("");
        x.Ig().release();
        if (this.hvv != null) {
            this.hvv.IB();
        }
        if (this.hvx != null) {
            this.hvx.IB();
        }
    }

    private void cnH() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cnI() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(w wVar) {
        if (wVar != null) {
            this.aFN = wVar;
            if (this.hRO != null) {
                this.hRO.a(wVar);
            }
            if (this.hvx != null && this.huy.Iq() != null) {
                this.hvx.b(this.huy.Iq(), this.otherParams);
            }
            cnE();
        }
    }

    private void c(q qVar) {
        if (this.hRO != null) {
            this.hRO.c(qVar);
        }
    }

    private void S(w wVar) {
        this.aFN = wVar;
        cnE();
    }

    private void cnJ() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.hSd = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.hSd = true;
        }
        this.hRA.setIsScrollable(this.hSd);
        this.hSf = AlaLiveSwitchData.isHotLive;
        if (this.aFN != null) {
            a(this.aFN.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.hRz.a(this.huQ, null);
            if (!isFloatingMode()) {
                a(this.hRz, this.aFN.mLiveInfo, this.bve);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aFN.mLiveInfo.live_id), String.valueOf(this.aFN.mLiveInfo.room_id), String.valueOf(this.aFN.mLiveInfo.feed_id), cnK(), this.hRx != null ? this.hRx.cnq() : false);
            if (com.baidu.live.liveroom.a.b.Pd().bqI != null) {
                com.baidu.live.liveroom.a.b.Pd().bqI.a(this.aFN.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.bve = false;
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.huy != null && this.huy.Iq() != null && this.huy.Iq().mLiveInfo != null) {
                    j = this.huy.Iq().mLiveInfo.live_id;
                    str2 = this.huy.Iq().mLiveInfo.room_id + "";
                    str = this.huy.Iq().mLiveInfo.feed_id;
                } else {
                    if (this.brr > 0) {
                        j2 = this.brr;
                    }
                    if (!TextUtils.isEmpty(this.hRP)) {
                        j = j2;
                        str = "";
                        str2 = this.hRP;
                    } else {
                        j = j2;
                        str = "";
                        str2 = "";
                    }
                }
                alaStaticItem.addParams("live_id", j + "");
                alaStaticItem.addParams("room_id", str2);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.ACTION_PLAYSTART_LIVE);
                String str3 = "";
                String str4 = "";
                String str5 = "";
                String str6 = "";
                if (this.huy != null && this.huy.Iq() != null && this.huy.Iq().mLiveInfo != null) {
                    str3 = this.huy.Iq().mLiveInfo.feed_id;
                    str4 = this.huy.Iq().mLiveInfo.live_id + "";
                    str5 = this.huy.Iq().mLiveInfo.room_id + "";
                    str6 = this.huy.Iq().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            cnE();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String cnK() {
        if (this.hRR == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hRR.optString("source");
            String optString2 = this.hRR.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hRR.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hRR.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.hRR.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bVv();
        } else if (this.hRE != null && this.hRE.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.hRE.getVideoPath();
                String d = com.baidu.live.u.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.hRE.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.u.h.aN(videoPath, d)) {
                    this.hRE.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.u.h.aM(videoPath, d)) {
                    this.hRE.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.cu(this.hRE)) {
                        ((ViewGroup) this.hRE.getParent()).removeView(this.hRE);
                        alaLiveRoomBlurPageLayout.a(this.hRE, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.hRI) {
                        this.hRE.c(alaLiveInfoData);
                        return;
                    } else {
                        this.hRE.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.hRE.coh();
        } else if (this.hRE != null && this.hRE.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.hRE, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.hRI) {
                    this.hRE.c(alaLiveInfoData);
                } else {
                    this.hRE.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.hRE != null) {
            this.hRE.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = o.u(this.mTbPageContext.getPageActivity());
                layoutParams.height = o.v(this.mTbPageContext.getPageActivity());
                int bm = o.bm(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = bm + i;
                } else {
                    dimensionPixelSize = bm + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
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

    public void cnL() {
        this.bve = true;
    }

    public boolean cnM() {
        return this.bve;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        a(UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()), alaLiveInfoData, z);
    }

    private void a(int i, AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (this.hRE != null) {
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
            if (this.hRz != null) {
                this.hRz.setBackgroundColor(0);
            }
            int i3 = this.hRE.getLayoutParams().width;
            int i4 = this.hRE.getLayoutParams().height;
            int i5 = this.hRE.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.hRE.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i3 || b.height != i4 || b.topMargin != i5) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.huQ != null) {
                this.huQ.setLayoutParams(c);
            }
            if (this.hRz != null) {
                this.hRz.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.hRN != null) {
                this.hRN.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.hRO != null) {
                this.hRO.l(c.width, c.height, realScreenOrientation);
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

    private void xF(int i) {
        boolean z = true;
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            if (this.hRz != null) {
                this.hRz.setBgImageUrl(this.aFN.mLiveInfo.cover, this.aFN.mLiveInfo);
            }
            this.hRB.a(this.mSelectedPosition, cnO(), this.aFN);
            this.hRB.b(this.mSelectedPosition, cnP(), this.aFN);
            if (this.hRz != null) {
                this.hRz.requestLayout();
                this.hRz.M(i, this.aFN.mLiveInfo.screen_direction == 2);
            }
        }
        if (this.aFN != null) {
            a(i, this.aFN.mLiveInfo, false);
        }
        boolean cli = this.hRz.cli();
        boolean z2 = i == 1;
        if (this.aFN == null || this.aFN.mLiveInfo == null || this.aFN.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!coa()) {
            if (this.hRE != null && this.hRE.getParent() == null) {
                this.hRz.a(this.hRE, null, false);
                if (this.aFN != null && this.aFN.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.hRI) {
                        this.hRE.c(this.aFN.mLiveInfo);
                    } else {
                        this.hRE.setPlayLiveInfo(this.aFN.mLiveInfo);
                    }
                }
            }
            if (cli && !coa() && this.hRO != null) {
                this.hRz.oj(z);
                return;
            }
            return;
        }
        this.hRz.cle();
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
            this.huy.a(alaLiveInfoData.live_id, true, this.brs, this.mForumName, this.hSf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnN() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.hRA != null && this.huQ != null && this.mSelectedPosition != (currentItem = this.hRA.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.h.sdk_neterror);
                this.hRA.setCurrentItem(this.mSelectedPosition);
            } else if (!this.bve && ListUtils.getCount(this.huy.cjB()) <= 1) {
                this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                this.hRA.setCurrentItem(this.mSelectedPosition);
                this.huy.g(this.huy.cjL());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.huy.cjG() && i < 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                    this.hRA.setCurrentItem(this.mSelectedPosition);
                } else if (this.huy.cjH() && i > 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                    this.hRA.setCurrentItem(this.mSelectedPosition);
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.huy.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    nn(true);
                    this.hRz.cle();
                    this.hRz.Yj();
                    this.hRz.clf();
                    if (this.huy.Iq() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.huy.Iq().mLiveInfo.live_id + "", this.huy.Iq().mLiveInfo.room_id + "", this.huy.Iq().aJV.userId + "", this.huy.Iq().aJV.userName, System.currentTimeMillis(), this.huy.Iq().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.huy.Iq().mLiveInfo.live_id + "", this.huy.Iq().mLiveInfo.room_id + "", this.huy.Iq().aJV.userId + "", this.huy.Iq().aJV.userName, System.currentTimeMillis(), this.huy.Iq().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.hRU != null) {
                        long j = this.huy.Iq().mLiveInfo.live_id;
                        if (this.hRU.liveId == j && this.hRU.startTime > 0) {
                            this.hRU.endTime = System.currentTimeMillis();
                            long j2 = this.hRU.endTime - this.hRU.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hRU.roomId + "", this.hRU.vid, j2 / 1000, this.otherParams);
                        }
                        this.hRU = null;
                    }
                    coc();
                    if (this.hSq != null) {
                        this.hSq.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.hRz = this.hRB.wQ(this.mSelectedPosition);
                    this.hRz.clg();
                    xG(i);
                    cnE();
                }
            }
        }
    }

    public void xG(int i) {
        if (i < 0) {
            this.huy.xj(this.huy.cjI() - 1);
        } else if (i > 0) {
            this.huy.xj(this.huy.cjI() + 1);
        }
        if (this.hRO != null) {
            this.hRO.a(this.hRz);
        }
        this.hRB.a(this.mSelectedPosition, cnO(), this.aFN);
        this.hRB.b(this.mSelectedPosition, cnP(), this.aFN);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.huy != null) {
            int cjI = this.huy.cjI();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", cjI + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.huy.cjB() != null && this.huy.cjB().size() > cjI && this.huy.cjB().get(cjI) != null) {
                AlaLiveInfoData alaLiveInfoData = this.huy.cjB().get(cjI);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.huy != null) {
            AlaLiveInfoData cjL = this.huy.cjL();
            if (cjL != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(cjL.live_id), String.valueOf(cjL.room_id), null, cnK(), this.hRx != null ? this.hRx.cnq() : false);
                cjL.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bVv();
                }
                a(this.hRz, cjL, this.bve);
                this.bve = false;
                if (this.hRO != null) {
                    this.hRO.a(this.mTbPageContext, this.huQ, this.hRE, this.hRz, this.huy, this.brs, this.hRK, this.huW, null, this.hSc, this.hRA);
                    short s = 2;
                    if (cjL.screen_direction == 2) {
                        s = 1;
                    }
                    k(s);
                }
                a(cjL, false);
            }
            i(cjL);
            this.hRz.a(this.huQ, null);
            if (this.hRO != null) {
                this.hRO.ccb();
            }
            this.huy.g(cjL);
        }
    }

    private AlaLiveInfoData cnO() {
        List<AlaLiveInfoData> cjB = this.huy.cjB();
        if (cjB == null || cjB.size() == 0) {
            if (this.aFN == null) {
                return null;
            }
            return this.aFN.mLiveInfo;
        }
        int cjI = this.huy.cjI();
        int size = cjB.size();
        return cjB.get(((cjI + size) - 1) % size);
    }

    private AlaLiveInfoData cnP() {
        List<AlaLiveInfoData> cjB = this.huy.cjB();
        if (cjB == null || cjB.size() == 0) {
            if (this.aFN == null) {
                return null;
            }
            return this.aFN.mLiveInfo;
        }
        return cjB.get((this.huy.cjI() + 1) % cjB.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i, String str) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        TbConfig.liveScene = 1;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hRI) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            oA(false);
            return;
        }
        w Iq = this.huy.Iq();
        S(Iq);
        this.huy.cjC();
        if (this.bve) {
            this.huy.ob(false);
        }
        this.huW = System.currentTimeMillis() / 1000;
        if (this.hRO != null) {
            this.hRO.a(this.mTbPageContext, this.huQ, this.hRE, this.hRz, this.huy, this.brs, this.hRK, this.huW, this.hRL, this.hSc, this.hRA);
            short s = 2;
            if (Iq.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            k(s);
        }
        if (this.hRx.cnr() != null && this.hRx.cnq()) {
            this.hRx.cnr().z("load_finish", null);
            if (Iq.mLiveInfo.screen_direction == 2) {
                this.hRx.cnr().z("screen_auto_rotate", true);
            } else {
                this.hRx.cnr().z("screen_auto_rotate", false);
            }
        }
        cnJ();
        if (Iq != null && Iq.mLiveInfo != null && Iq.mLiveInfo.live_status == 2) {
            this.hRB.a(this.mSelectedPosition, this.huy.Iq());
            d(Iq, false);
            this.bve = false;
            return;
        }
        if (this.hvu == null && (runTask2 = MessageManager.getInstance().runTask(2913229, com.baidu.live.t.d.class)) != null) {
            this.hvu = (com.baidu.live.t.d) runTask2.getData();
        }
        if (this.hvu != null) {
            this.hvu.Qy();
        }
        if (this.hvw == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.v.c.class)) != null) {
            this.hvw = (com.baidu.live.v.c) runTask.getData();
        }
        if (this.hvw != null) {
            this.hvw.Qy();
        }
        boolean z = (this.hRO == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ag.a.b.Sm().cO(com.baidu.live.ae.a.RB().brA != null && com.baidu.live.ae.a.RB().brA.aOL && Iq != null && Iq.aKP);
        ac.d(Iq);
        if (z) {
            if (!this.hRZ || !TextUtils.equals(p.WC(), this.hSa)) {
                ac.b(getPageContext(), false);
                e.RP().RQ();
                this.hRZ = true;
                this.hSa = p.WC();
            }
            ac.hs("");
            ac.Ix();
        }
        if (this.huy.Iq() != null && this.huy.Iq().mLiveInfo != null) {
            this.huy.h(this.huy.Iq().mLiveInfo.live_id, !this.hRV);
            this.hRV = true;
        }
        if (this.hRO != null) {
            this.hRO.b(this.hRF);
            this.hRO.nm(TextUtils.equals(this.hRM, "1"));
            this.hRM = "";
        }
        if (this.hRC != null) {
            this.hRC.a(this.aFN, this.hRD);
        }
        a(this.huy.Iq());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.huy.Iq() != null && b.this.huy.Iq().mLiveInfo != null) {
                    b.this.huy.a(b.this.huy.Iq().mLiveInfo.live_id, b.this.brs, b.this.huW);
                }
            }
        });
        if (z && this.huy.Iq() != null && this.huy.Iq().aJV != null) {
            bo boVar = com.baidu.live.ae.a.RB().bxq;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && boVar != null && boVar.aQP != null && boVar.aQP.aTh) {
                f(true, this.huy.Iq().aJV.userId);
            }
        }
        this.bve = false;
        if (z && this.huy.Iq() != null && this.huy.Iq().mLiveInfo != null && this.huy.Iq().aJV != null && this.hRO != null) {
            long j = this.huy.Iq().mLiveInfo.live_id;
            long j2 = this.huy.Iq().mLiveInfo.room_id;
            String str2 = this.huy.Iq().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.IE() != null) {
                    al.IE().bF(this.biE);
                    if (!this.biE) {
                        al.IE().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.hSq != null) {
                    this.hSq.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.LY() != null) {
                com.baidu.live.guardclub.e.LY().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.hRW == null) {
                this.hRW = new com.baidu.tieba.ala.liveroom.k.a();
                this.hRW.bF(this.biE);
            }
            if (!this.biE) {
                this.hRW.a(this.mTbPageContext.getPageActivity(), this.huy.Iq(), this.otherParams);
            }
        }
        if (this.hRX == null) {
            this.hRX = new com.baidu.tieba.ala.liveroom.v.c(this.mTbPageContext);
            this.hRX.bF(this.biE);
        }
        if (z && this.huy.Iq() != null && this.huy.Iq().aKr != null && !this.hRY) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.hRX.a(this.huy.Iq(), this.huy.Iq().aKr.userId);
                this.hRY = true;
            }
        }
        if (this.huy.Iq() != null && this.huy.Iq().mLiveInfo != null && this.huy.Iq().aKr != null) {
            com.baidu.live.p.a.b(this.huy.Iq().mLiveInfo.live_id, this.huy.Iq().aKr.needRename == 1);
            if (z) {
                com.baidu.live.p.a.b(this.huy.Iq().mLiveInfo.live_id, 0);
            }
        }
        if (this.hvv != null && this.huy.Iq() != null && this.huy.Iq().aJV != null) {
            this.hvv.bd(this.huy.Iq().aJV.userId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnQ() {
        if (this.hRG) {
            this.hRB.a(this.mSelectedPosition, cnO(), this.aFN);
            this.hRB.b(this.mSelectedPosition, cnP(), this.aFN);
            this.hRG = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.hRI) {
            this.mHandler.removeCallbacks(this.hSk);
            this.mHandler.postDelayed(this.hSk, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (qVar == null) {
            if (!this.hRI) {
                this.mHandler.removeCallbacks(this.hSj);
                this.mHandler.postDelayed(this.hSj, 5000L);
                return;
            }
            return;
        }
        if (!this.hRH) {
            c(qVar);
        }
        if (!this.hRI) {
            this.mHandler.removeCallbacks(this.hSj);
            this.mHandler.postDelayed(this.hSj, qVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnR() {
        if (this.huy.Iq() != null && this.huy.Iq().mLiveInfo != null) {
            this.huy.h(this.huy.Iq().mLiveInfo.live_id, !this.hRV);
            this.hRV = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_status == 2) {
            this.hRB.a(this.mSelectedPosition, this.huy.Iq());
            d(wVar, false);
        } else if (wVar != null) {
            if (!this.hRH) {
                ac.d(wVar);
                a(wVar);
            }
            if (!this.hRI) {
                this.mHandler.removeCallbacks(this.hyg);
                this.mHandler.postDelayed(this.hyg, wVar.aKa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjg() {
        if (this.mTbPageContext != null && this.huy.Iq() != null && this.huy.Iq().mLiveInfo != null) {
            this.huy.a(this.huy.Iq().mLiveInfo.live_id, this.brs, this.huW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar, boolean z) {
        String str;
        nn(true);
        if (!coa()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckb().od(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckb().release();
            this.huy.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.hRz != null) {
                this.hRz.Yj();
                this.hRz.cle();
                this.hRz.clj();
            }
            if (wVar == null || wVar.mLiveInfo == null) {
                str = null;
            } else {
                this.hRQ = wVar.mLiveInfo.live_id;
                str = String.valueOf(wVar.mLiveInfo.room_id);
            }
            cnG();
            cnS();
            cnT();
            if (this.hRx.cnq() && !StringUtils.isNull(str) && this.hRx.cnr() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.hRx.cnr().z("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (wVar != null) {
                View a2 = (this.hRO == null || this.hRO.cch() == null) ? null : this.hRO.cch().a(this.hRO.cbX().pageContext.getPageActivity(), wVar, z);
                if (this.hRz != null) {
                    this.hRN.a(this.hRz, a2, wVar, z, this.huy.cjD());
                }
                if (this.hRO != null) {
                    this.hRO.nn(false);
                    this.hRO.ccc();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.hRz != null) {
                    this.hRz.clg();
                }
                long j = wVar.mLiveInfo.live_id;
                String str2 = wVar.mLiveInfo.feed_id;
                long j2 = wVar.aJV.userId;
                String str3 = wVar.aJV.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    QMStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", str + "", str2, this.otherParams);
                this.hRU = new StayTimeBean();
                this.hRU.liveId = wVar.mLiveInfo.live_id;
                this.hRU.roomId = wVar.mLiveInfo.room_id;
                this.hRU.vid = wVar.mLiveInfo.feed_id;
                this.hRU.startTime = System.currentTimeMillis();
            }
            coc();
            if (this.hRC != null) {
                this.hRC.a(this.aFN, this.hRD);
            }
        }
    }

    private void cnS() {
    }

    private void cnT() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.hRA);
        }
    }

    public void cnU() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnV();
        } else {
            cnW();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.huy != null && this.huy.Iq() != null) {
            alaLiveInfoData = this.huy.Iq().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnV();
        } else {
            cnW();
        }
        this.hRA.setIsScrollable(!z && this.hSd);
        if (this.hRO != null) {
            this.hRO.onKeyboardVisibilityChanged(z);
        }
        if (this.huQ != null) {
            this.huQ.onKeyboardVisibilityChanged(z);
        }
    }

    public void dX(int i) {
        if (i == 0) {
            i = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        }
        if (isDebug()) {
            Log.d(TAG, "onScreenOrientationChanged: ");
        }
        if (i == 2) {
            cnV();
        } else {
            cnW();
        }
        this.huQ.dX(i);
        xF(i);
        if (al.IE() != null) {
            al.IE().HO();
        }
        if (this.hRW != null) {
            this.hRW.HO();
        }
        if (this.hRC != null) {
            this.hRC.dX(i);
        }
    }

    public void cnV() {
        if (this.hRA != null) {
            i.ae(this.hRA);
        }
    }

    public void cnW() {
        if (this.hRA != null) {
            i.af(this.hRA);
        }
    }

    private boolean cnX() {
        return this.hSm || this.hSn;
    }

    private void cnY() {
        this.hSm = false;
        this.hSn = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.hSb + " mWebOver=" + this.hRJ + ", isFloatingMode=" + isFloatingMode());
        }
        cnY();
        if (!this.hRJ || !isFloatingMode()) {
            bVv();
            if (this.huy != null) {
                this.huy.cjn();
                this.huy.cjr();
            }
            if (this.hRO != null) {
                this.hRO.enterForeground();
            }
            if (this.hRW != null) {
                this.hRW.onResume();
            }
            if (this.hRX != null) {
                this.hRX.onResume();
            }
            com.baidu.live.core.layer.b.EY().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.hSb + " mWebOver=" + this.hRJ + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        cnY();
        if ((!this.hRJ || !isFloatingMode()) && !this.hSb) {
            bVv();
            if (this.hRI) {
                this.hRI = false;
                cnZ();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            cnE();
        }
    }

    public void cnZ() {
        cjg();
        cnR();
        this.huy.cjC();
        if (!this.hRE.isPlaying()) {
            cnF();
        } else if (this.hRE.isPaused()) {
            this.hRE.resume();
        }
        if (this.hRO != null) {
            this.hRO.ccg();
        }
        if (this.huy != null && this.huy.Iq() != null && this.huy.Iq().mLiveInfo != null) {
            this.hRT.fG(this.huy.Iq().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aFN.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.hRJ + ", isFloatingMode=" + isFloatingMode());
        }
        if (cnX() || !this.hRJ || !isFloatingMode()) {
            if (this.huy != null) {
                this.huy.cjo();
                this.huy.cjs();
            }
            if (this.hRO != null) {
                this.hRO.enterBackground();
            }
            com.baidu.live.core.layer.b.EY().onPause();
        }
    }

    public void T(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.hSi);
        }
        if (!cnX() && z && !this.hSi && cnz()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0653a() { // from class: com.baidu.tieba.ala.player.b.12
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0653a
                    public boolean a(SdkLivePlayer sdkLivePlayer) {
                        if (sdkLivePlayer != null) {
                            sdkLivePlayer.aSi();
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
        this.hRI = true;
        oB(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void oB(boolean z) {
        this.mHandler.removeCallbacks(this.hyg);
        this.mHandler.removeCallbacks(this.hSj);
        this.mHandler.removeCallbacks(this.hSk);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.hRE.isFloatingMode()) {
                this.hRE.aSi();
            }
        } else if (!z && !this.hRE.isFloatingMode()) {
            this.hRE.aSi();
        }
        if (this.hRO != null) {
            this.hRO.ccf();
        }
        this.hRT.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.IE() != null) {
                al.IE().a(i, i2, intent, this.aFN, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.hRO != null) {
            this.hRO.onActivityResult(i, i2, intent);
        }
    }

    public boolean coa() {
        return this.hRN != null && this.hRN.bVl();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hSz != null) {
            MessageManager.getInstance().unRegisterListener(this.hSz);
        }
        if (this.hSA != null) {
            MessageManager.getInstance().unRegisterListener(this.hSA);
        }
        MessageManager.getInstance().unRegisterListener(this.hSB);
        MessageManager.getInstance().unRegisterListener(this.hSC);
        MessageManager.getInstance().unRegisterListener(this.hSD);
        MessageManager.getInstance().unRegisterListener(this.hSE);
        MessageManager.getInstance().unRegisterListener(this.hSv);
        MessageManager.getInstance().unRegisterListener(this.hhn);
        MessageManager.getInstance().unRegisterListener(this.hSo);
        MessageManager.getInstance().unRegisterListener(this.hSp);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        if (this.hSq != null) {
            this.hSq.release();
        }
        if (this.hRE != null && !this.hRE.isFloatingMode()) {
            this.hRE.cE(true);
        }
        if (this.hRC != null) {
            this.hRC.onDestory();
        }
        if (this.hvv != null) {
            this.hvv.release();
            this.hvv = null;
        }
        if (this.hvx != null) {
            this.hvx.release();
            this.hvx = null;
        }
        if (this.hRD != null) {
            this.hRD.reset();
        }
        if (this.hRO != null) {
            this.hRO.onDestroy();
        }
        if (this.hRB != null) {
            this.hRB.onDestroy();
        }
        if (this.hRz != null) {
            this.hRz.Yj();
            this.hRz.release();
            this.hRz = null;
        }
        if (this.hRN != null) {
            this.hRN.onDestroy();
        }
        if (this.hRU != null && this.huy != null && this.huy.Iq() != null) {
            long j = this.huy.Iq().mLiveInfo.live_id;
            if (this.hRU.liveId == j && this.hRU.startTime > 0) {
                this.hRU.endTime = System.currentTimeMillis();
                long j2 = this.hRU.endTime - this.hRU.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hRU.roomId + "", this.hRU.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.hRU = null;
        }
        if (this.huQ != null) {
            this.huQ.clm();
            this.huQ = null;
        }
        if (this.huy != null) {
            this.huy.destory();
        }
        if (this.hvu != null) {
            this.hvu.release();
        }
        if (this.hvw != null) {
            this.hvw.release();
        }
        z.Ii().release();
        if (this.hRX != null) {
            this.hRX.release();
        }
        x.Ig().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String Oj() {
        return this.otherParams;
    }

    public void oC(boolean z) {
        this.hSb = z;
    }

    public void cob() {
        if (this.hRR != null) {
            this.otherParams = this.hRR.toString();
            if (this.huy != null) {
                this.huy.setOtherParams(this.otherParams);
            }
            if (this.hRO != null) {
                this.hRO.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.hRN != null) {
                this.hRN.setOtherParams(this.otherParams);
            }
        }
    }

    public void coc() {
        if (this.hRR != null) {
            String optString = this.hRR.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hRR.put("tab", "live_jump");
                        this.hRR.put("tag", "");
                        this.hRR.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hRR.put("tab", "liveroom");
                        this.hRR.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cob();
            }
        }
    }

    private void f(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.LW();
        }
        bVar.setAnchorId(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void cod() {
        ac.IA();
    }

    private void k(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hRO.e(s);
        } else {
            this.hRO.f(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
