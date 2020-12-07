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
    private static int hSe = 1;
    private static WeakReference<b> mRef;
    private w aFN;
    private com.baidu.live.u.b bLe;
    private CustomMessageListener bgy;
    private boolean biE;
    private long brr;
    private String brs;
    private boolean bve;
    private com.baidu.tieba.ala.liveroom.e.a hRA;
    private com.baidu.tieba.ala.liveroom.e.b hRB;
    private SdkLivePlayer hRC;
    private AlaLastLiveroomInfo hRD;
    private boolean hRE;
    private boolean hRF;
    private boolean hRG;
    private boolean hRH;
    @Deprecated
    private boolean hRI;
    private ArrayList<AlaBroadcastGiftToastData> hRJ;
    private String hRK;
    private com.baidu.tieba.ala.endliveroom.a hRL;
    private com.baidu.tieba.ala.liveroom.d.c hRM;
    private String hRN;
    private long hRO;
    private JSONObject hRP;
    private boolean hRQ;
    private com.baidu.tieba.ala.liveroom.task.c hRR;
    private StayTimeBean hRS;
    private boolean hRT;
    private com.baidu.tieba.ala.liveroom.k.a hRU;
    private com.baidu.tieba.ala.liveroom.v.c hRV;
    private boolean hRW;
    private boolean hRX;
    private String hRY;
    private boolean hRZ;
    private a hRv;
    private SafeFrameLayout hRw;
    private AlaLiveRoomBlurPageLayout hRx;
    private AlaLoopViewPager hRy;
    private AlaLoopViewPagerAdapter hRz;
    CustomMessageListener hSA;
    CustomMessageListener hSB;
    private CustomMessageListener hSC;
    private bp hSa;
    private boolean hSb;
    private boolean hSc;
    private int hSd;
    private boolean hSf;
    private boolean hSg;
    private Runnable hSh;
    private Runnable hSi;
    private Runnable hSj;
    private boolean hSk;
    private boolean hSl;
    private CustomMessageListener hSm;
    private CustomMessageListener hSn;
    private com.baidu.live.ah.c hSo;
    private boolean hSp;
    private boolean hSq;
    private long hSr;
    private long hSs;
    private CustomMessageListener hSt;
    private com.baidu.live.u.a hSu;
    com.baidu.live.liveroom.a.c hSv;
    ViewPager.OnPageChangeListener hSw;
    HttpMessageListener hSx;
    CustomMessageListener hSy;
    CustomMessageListener hSz;
    private String hdc;
    CustomMessageListener hhl;
    private AlaLiveView huO;
    private ViewGroup huP;
    private LayerRootView huQ;
    private long huU;
    private com.baidu.tieba.ala.liveroom.p.d huw;
    private d.a hve;
    private com.baidu.live.t.d hvs;
    private com.baidu.live.t.c hvt;
    private com.baidu.live.v.c hvu;
    private com.baidu.live.v.b hvv;
    private Runnable hye;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void cns() {
        if (this.hRV != null) {
            this.hRV.bF(this.biE);
        }
        if (this.hRU != null) {
            this.hRU.bF(this.biE);
        }
        if (al.IE() != null) {
            al.IE().bF(this.biE);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hRE = true;
        this.huU = 0L;
        this.hRF = false;
        this.bve = true;
        this.brs = "";
        this.mForumName = "";
        this.hRG = false;
        this.hRI = false;
        this.hRK = "0";
        this.mHandler = new Handler();
        this.hRO = -1L;
        this.otherParams = "";
        this.hRQ = false;
        this.hRR = com.baidu.tieba.ala.liveroom.task.c.ckD();
        this.hRT = false;
        this.hRX = false;
        this.hRZ = false;
        this.hSc = false;
        this.hSd = 0;
        this.hSf = false;
        this.hSg = false;
        this.hye = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjf();
            }
        };
        this.hSh = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.cnQ();
            }
        };
        this.hSi = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.huw.cjB();
            }
        };
        this.hSj = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.hhl = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hSk = true;
            }
        };
        this.hSm = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hSl = true;
            }
        };
        this.hSn = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.hSt = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.biE = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.cns();
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
                if (b.this.hRM != null) {
                    b.this.hRM.eb(i);
                }
            }
        };
        this.hSu = new com.baidu.live.u.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.u.a
            public void cD(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.hRC != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.hRC.isPlaying());
                        if (b.this.hRC.isPlaying()) {
                            if (b.this.hRC.isPaused()) {
                                b.this.hRC.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.hRC.isPlaying()) {
                        b.this.hRC.pause();
                    }
                }
            }
        };
        this.hSv = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void cu(boolean z) {
                if (z || b.this.hRM == null || b.this.hRM.ccd()) {
                    if (!b.this.cnB() || b.this.a(true, (a.InterfaceC0653a) null)) {
                        b.this.hSg = true;
                        b.this.oA(true);
                        b.this.bZf();
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
                b.this.hRC.coh();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.hRG) {
                    if (b.this.hRG) {
                        b.this.hRC.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.hRC.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.hRy != null) {
                    b.this.hRy.setIsScrollable(b.this.hSb && z);
                    b.this.hRy.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cw(boolean z) {
                boolean z2 = true;
                if (!z || b.this.cnZ()) {
                    if (b.this.hRx != null) {
                        b.this.hRx.clg();
                        return;
                    }
                    return;
                }
                if (b.this.huw.Iq().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.hRx != null) {
                    b.this.hRx.oj(z2);
                }
            }
        };
        this.hSw = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.hRy != null && i == 0) {
                    b.this.cnM();
                    com.baidu.live.d.BM().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.hve = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.p.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.P(b.this.huw.Iq());
                } else if (i2 == 2) {
                    b.this.f(b.this.huw.bUt());
                } else if (i2 == 3) {
                    b.this.bp(i, str2);
                } else if (i2 == 4) {
                    b.this.aH(obj);
                } else if (i2 == 5) {
                    b.this.cnP();
                }
            }
        };
        this.hSx = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.ckB() != null && b.this.mTbPageContext != null) {
                        b.this.hRR.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.ckB());
                    }
                }
            }
        };
        this.hSy = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
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
        this.hSz = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.huw != null && b.this.huw.Iq() != null && b.this.huw.Iq().mLiveInfo != null) {
                    long j = b.this.huw.Iq().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + "," + iArr[1] + "]");
                    if (b.this.hSo != null) {
                        b.this.hSo.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.hSA = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.huw != null && b.this.huw.Iq() != null && b.this.huw.Iq().aKr != null) {
                        if (l.longValue() == b.this.huw.Iq().aKr.userId) {
                            b.this.huw.Iq().aKr.isNewUser = false;
                            if (b.this.hRU != null) {
                                b.this.hRU.n(b.this.huw.Iq());
                            }
                        }
                    }
                }
            }
        };
        this.hSB = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.t.a)) {
                    com.baidu.tieba.ala.liveroom.t.a aVar2 = (com.baidu.tieba.ala.liveroom.t.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String Fk = aVar2.Fk();
                    if (b.this.mTbPageContext != null && b.this.huw != null && b.this.huw.Iq() != null && b.this.huw.Iq().aKr != null) {
                        if (valueOf.longValue() == b.this.huw.Iq().aKr.userId && com.baidu.live.ae.a.RB().bxq != null && com.baidu.live.ae.a.RB().bxq.aQK != null && com.baidu.live.ae.a.RB().bxq.aQK.FS()) {
                            g.wJ(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, Fk));
                        }
                    }
                }
            }
        };
        this.hSC = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.hye != null) {
                    b.this.mHandler.removeCallbacks(b.this.hye);
                }
                b.this.cjf();
            }
        };
        this.huU = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.hRv = aVar;
        this.hRE = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ah.c.class);
        if (runTask != null) {
            this.hSo = (com.baidu.live.ah.c) runTask.getData();
        }
        this.huw = new com.baidu.tieba.ala.liveroom.p.d(getPageContext());
        this.huw.a(this.hve);
        this.huw.IE(str);
        this.hRL = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hSx);
        MessageManager.getInstance().registerListener(this.hSy);
        MessageManager.getInstance().registerListener(this.hSz);
        MessageManager.getInstance().registerListener(this.hSA);
        MessageManager.getInstance().registerListener(this.hSB);
        MessageManager.getInstance().registerListener(this.hSC);
        MessageManager.getInstance().registerListener(this.hSt);
        MessageManager.getInstance().registerListener(this.hhl);
        MessageManager.getInstance().registerListener(this.hSm);
        MessageManager.getInstance().registerListener(this.hSn);
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
                        this.hRJ = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hRJ.add(alaBroadcastGiftToastData);
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
            this.hRN = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.hRN = intent.getStringExtra("room_id");
        }
        this.brr = intent.getLongExtra("live_id", 0L);
        this.hRQ = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.huw.b((AlaLiveInfoCoreData) serializableExtra);
            this.hRQ = true;
        }
        this.huw.setIsMixLive(z);
        TbConfig.liveScene = 1;
        c(intent, z);
        this.hSb = this.hSa == null || !this.hSa.aRa;
        this.hRL.setOtherParams(this.otherParams);
        oy(z);
        cnt();
        this.mHandler.removeCallbacks(this.hSj);
        this.mHandler.postDelayed(this.hSj, 1000L);
    }

    private void c(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.hSd = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hdc = null;
            if (z) {
                stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_EXTRA_PARAMS);
            } else {
                stringExtra = intent.getStringExtra("params");
            }
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hRP = new JSONObject(stringExtra);
                if (this.hRP != null) {
                    String optString2 = this.hRP.optString("enterRoomId");
                    String optString3 = this.hRP.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hRN, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.brr + "", optString3))) {
                        String optString4 = this.hRP.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString5 = this.hRP.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString5);
                        if (!this.hRQ) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.brr;
                            alaLiveInfoCoreData.screenDirection = this.hRP.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.huw.b(alaLiveInfoCoreData);
                            this.hRQ = true;
                        }
                    }
                    String optString6 = this.hRP.optString("extra");
                    try {
                        this.hSr = Long.parseLong(this.hRN);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.hSs = this.brr;
                    if (TextUtils.isEmpty(optString6)) {
                        this.hSa = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.huw != null) {
                            this.huw.Ia(optString7);
                        }
                        this.hSp = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.hSq = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hdc = jSONObject.optString("live_back_scheme");
                        this.hSa = new bp();
                        this.hSa.aRa = jSONObject.optInt("is_hot") == 1;
                        if (this.hSa.aRa) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hSd = AlaLiveSwitchData.isHotLive;
                        this.hSa.aRb = jSONObject.optString("task_id");
                        this.hSa.aQZ = !TextUtils.isEmpty(this.hSa.aRb);
                        this.hSa.aRc = jSONObject.optInt("task_type");
                        this.hSa.aRd = jSONObject.optInt("task_im_count");
                        this.hSa.aRe = jSONObject.optLong("task_gift_total_price");
                        this.hSa.aRf = jSONObject.optLong("task_watch_time");
                        this.hSa.aRg = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.hRP.put("from", optString);
                        }
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.hRB = new com.baidu.tieba.ala.liveroom.e.b();
                            this.hRB.setScheme(optString8);
                            this.hRB.setImageUrl(optString9);
                            this.hRB.setTitle(optString10);
                        }
                    }
                    this.hRK = this.hRP.optString("open_giftlist");
                    this.hRP.remove("cover");
                    this.hRP.remove("live_url");
                    this.hRP.remove("enterRoomId");
                    this.hRP.remove("enterLiveId");
                    this.hRP.remove("open_giftlist");
                    this.hRP.remove("extra");
                    this.otherParams = this.hRP.toString();
                    if (this.huw != null) {
                        this.huw.setOtherParams(this.otherParams);
                    }
                    this.hRP.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRP.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRP.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hRP.optString("source");
                    }
                    this.hSc = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hRP.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.huw != null) {
                        this.huw.xi(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hRD = new AlaLastLiveroomInfo();
                this.hRD.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.brr), String.valueOf(this.hRN), null, cnJ(), this.hRv != null ? this.hRv.cnp() : false);
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
            this.huw.at(this.uk, this.brs, this.mForumName);
        } else if (this.huw.Iq() != null && this.huw.Iq().mLiveInfo != null && this.huw.Iq().mLiveInfo.live_id > 0) {
            this.huw.a(this.huw.Iq().mLiveInfo.live_id, false, this.brs, this.mForumName);
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
            this.huw.at(this.uk, this.brs, this.mForumName);
        } else if (!TextUtils.isEmpty(this.hRN)) {
            this.huw.ID(this.hRN);
        } else if (this.brr > 0) {
            this.huw.a(this.brr, false, this.brs, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            oA(false);
        }
    }

    private void oy(boolean z) {
        this.bve = true;
        this.hRF = false;
        oz(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.EY().j(this.huQ);
        this.hRM = new com.baidu.tieba.ala.liveroom.d.c();
        this.hRM.a(this.hSv);
        this.hRM.setOtherParams(this.otherParams);
        this.hRM.nh(this.hSc);
        this.hRM.a(this.hRv.cnq());
        cnx();
        cnu();
        cnw();
        cnv();
    }

    private void oz(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_main_layout, (ViewGroup) null);
        this.hRw = (SafeFrameLayout) inflate.findViewById(a.f.live_root_view);
        this.hRy = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.hRy.setOnPageChangeListener(this.hSw);
        this.hRy.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void cgO() {
                b.this.cnM();
            }
        });
        this.hRy.setBoundaryCaching(true);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.hRz = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.hRz.cgM();
        this.hRx = this.hRz.wP(this.mSelectedPosition);
        this.hRz.a(this.mSelectedPosition, this.huw.Iq());
        this.hRy.setAdapter(this.hRz);
        this.hRy.setCurrentItem(this.mSelectedPosition);
        this.hRy.setIsScrollable(this.hSb);
        this.hRy.setIsMixLive(z);
        this.huP = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.huQ = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
    }

    private void c(Rect rect) {
        this.hRC = SdkLivePlayer.fL(getPageContext().getPageActivity());
        if (this.hRC == null) {
            this.hRy.setIsScrollable(false);
            if (this.huw != null) {
                this.huw.cancelLoadData();
            }
            cgQ();
            return;
        }
        this.hRC.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.c.sdk_transparent));
        this.hRC.setIPlayerCallBack(this.bLe);
        this.hRC.setIPlayerAudioFocusCallBack(this.hSu);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hRx.a(this.hRC, layoutParams, true);
    }

    private void cnu() {
        this.hRA = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.huP);
    }

    private void cnv() {
        CustomResponsedMessage runTask;
        if (this.hvv == null && (runTask = MessageManager.getInstance().runTask(2913266, com.baidu.live.v.b.class)) != null) {
            this.hvv = (com.baidu.live.v.b) runTask.getData();
        }
        if (this.hvv != null) {
            this.hvv.setParentView(this.huP);
        }
    }

    private void cnw() {
        CustomResponsedMessage runTask;
        if (this.hvt == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.t.c.class)) != null) {
            this.hvt = (com.baidu.live.t.c) runTask.getData();
        }
        if (this.hvt != null) {
            this.hvt.setParentView(this.huP);
        }
    }

    private void cgQ() {
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
        this.huO = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.ala_liveroom_player_layout, null);
        this.huO.setSwipeClearEnable(true);
        this.huO.hFs = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hRx.a(this.huO, layoutParams);
    }

    private void cnx() {
        if (this.huw != null && this.huw.Iq() != null) {
            this.aFN = this.huw.Iq();
            if (this.aFN.mLiveInfo != null) {
                a(this.aFN.mLiveInfo, this.hRQ);
                if (this.aFN.mLiveInfo != null && this.aFN.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hRG);
                    }
                    if (!this.hRG) {
                        this.hRC.c(this.aFN.mLiveInfo);
                    } else {
                        this.hRC.setPlayLiveInfo(this.aFN.mLiveInfo);
                    }
                    if (this.hRM != null) {
                        this.hRM.a(this.mTbPageContext, this.huO, this.hRC, this.hRx, this.huw, this.brs, this.hRI, this.huU, this.hRJ, this.hSa, this.hRy);
                        k(this.aFN.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean cny() {
        boolean z;
        AlaLiveInfoData cjK;
        if (this.hRv.cnp()) {
            return false;
        }
        if (this.huw == null || (cjK = this.huw.cjK()) == null || cjK.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !cjK.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.hSr + ", getPlayingRoomID:" + cnz() + ", mSchemeLiveId:" + this.hSs + ", getPlayingLiveID:" + cnA());
        }
        return z || cnC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cnz() {
        AlaLiveInfoData cjK;
        if (this.huw == null || (cjK = this.huw.cjK()) == null) {
            return 0L;
        }
        return cjK.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cnA() {
        AlaLiveInfoData cjK;
        if (this.huw == null || (cjK = this.huw.cjK()) == null) {
            return 0L;
        }
        return cjK.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnB() {
        boolean z = false;
        if (!this.hRv.cnp()) {
            if (this.hSp && (this.hSr == cnz() || this.hSs == cnA())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean cnC() {
        boolean z = this.hSq && (this.hSr == cnz() || this.hSs == cnA());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean cnD() {
        if (hSe <= 0) {
            return false;
        }
        if (!(cnB() || cny()) || FloatPermissionUtil.Py()) {
            return false;
        }
        hSe--;
        FloatPermissionUtil.al(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0653a interfaceC0653a) {
        if (!FloatPermissionUtil.Py()) {
            if (this.hSf) {
                return true;
            }
            this.hSf = true;
            if (z) {
                FloatPermissionUtil.al(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (cnB()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.hSq) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a fG = com.baidu.tieba.ala.floating.b.fG(getPageContext().getPageActivity());
        fG.a(interfaceC0653a);
        fG.dA(jSONObject);
        com.baidu.tieba.ala.floating.b.fG(getPageContext().getPageActivity()).a(this.hRC, this.huw.Iq(), this.brs, this.huU);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bVu() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bVp = com.baidu.tieba.ala.floating.b.bVp();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0653a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0653a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bVp == null || bVp.room_id == b.this.cnz() || bVp.live_id == b.this.cnA()) {
                    if (b.this.hRC != null) {
                        b.this.cnE();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.hRG);
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
        ArrayList arrayList = (ArrayList) this.hRC.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.hRC.cog();
            this.hRC.al(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bVs();
    }

    public void ow(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.hRH = z;
    }

    private void cnF() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hSb) {
                this.hRy.setIsScrollable(true);
            } else {
                this.hRy.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.EY().onBackPressed() && ((this.hRM == null || !this.hRM.onKeyDown(i, keyEvent)) && (this.hRM == null || !this.hRM.ccc()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cnF();
            } else if ((this.hRM == null || this.hRM.ccd()) && (!cnB() || a(true, (a.InterfaceC0653a) null))) {
                this.hSg = true;
                oA(true);
                bZf();
            }
        }
        return true;
    }

    public void bZf() {
        if (!TextUtils.isEmpty(this.hdc)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hdc);
                this.hdc = null;
            }
        }
    }

    public void oA(boolean z) {
        S(z, false);
    }

    public void S(boolean z, boolean z2) {
        nn(!z);
        if (this.hRC != null && !this.hRC.isFloatingMode()) {
            this.hRC.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.EY().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cnH();
        long j = -1;
        if (this.huw != null && this.huw.cjK() != null) {
            j = this.huw.cjK().room_id;
        }
        this.hRv.b(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void nn(boolean z) {
        if (this.hRv.cnp() && this.hRv.cnq() != null) {
            this.hRv.cnq().z("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hRD = null;
        if (al.IE() != null) {
            al.IE().ID();
        }
        com.baidu.live.core.layer.b.EY().EZ();
        if (this.hSo != null) {
            this.hSo.release();
        }
        if (this.hRU != null) {
            this.hRU.release();
        }
        this.hSa = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.huw != null) {
            try {
                this.huw.Ia(null);
                AlaLiveInfoData cjK = this.huw.cjK();
                if (cjK != null) {
                    this.huw.fD(cjK.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.hRR.stopRecord();
        LiveTimerManager.getInstance().stop();
        cnG();
        if (this.hRC != null && !this.hRC.isFloatingMode()) {
            this.hRC.cE(z);
        }
        if (this.hRM != null) {
            this.hRM.nn(z);
        }
        this.hRT = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Pd().bqI != null && this.aFN != null) {
            com.baidu.live.liveroom.a.b.Pd().bqI.b(this.aFN.mLiveInfo);
        }
        ac.hs("");
        x.Ig().release();
        if (this.hvt != null) {
            this.hvt.IB();
        }
        if (this.hvv != null) {
            this.hvv.IB();
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

    private void a(w wVar) {
        if (wVar != null) {
            this.aFN = wVar;
            if (this.hRM != null) {
                this.hRM.a(wVar);
            }
            if (this.hvv != null && this.huw.Iq() != null) {
                this.hvv.b(this.huw.Iq(), this.otherParams);
            }
            cnD();
        }
    }

    private void c(q qVar) {
        if (this.hRM != null) {
            this.hRM.c(qVar);
        }
    }

    private void S(w wVar) {
        this.aFN = wVar;
        cnD();
    }

    private void cnI() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.hSb = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.hSb = true;
        }
        this.hRy.setIsScrollable(this.hSb);
        this.hSd = AlaLiveSwitchData.isHotLive;
        if (this.aFN != null) {
            a(this.aFN.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.hRx.a(this.huO, null);
            if (!isFloatingMode()) {
                a(this.hRx, this.aFN.mLiveInfo, this.bve);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aFN.mLiveInfo.live_id), String.valueOf(this.aFN.mLiveInfo.room_id), String.valueOf(this.aFN.mLiveInfo.feed_id), cnJ(), this.hRv != null ? this.hRv.cnp() : false);
            if (com.baidu.live.liveroom.a.b.Pd().bqI != null) {
                com.baidu.live.liveroom.a.b.Pd().bqI.a(this.aFN.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.bve = false;
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.huw != null && this.huw.Iq() != null && this.huw.Iq().mLiveInfo != null) {
                    j = this.huw.Iq().mLiveInfo.live_id;
                    str2 = this.huw.Iq().mLiveInfo.room_id + "";
                    str = this.huw.Iq().mLiveInfo.feed_id;
                } else {
                    if (this.brr > 0) {
                        j2 = this.brr;
                    }
                    if (!TextUtils.isEmpty(this.hRN)) {
                        j = j2;
                        str = "";
                        str2 = this.hRN;
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
                if (this.huw != null && this.huw.Iq() != null && this.huw.Iq().mLiveInfo != null) {
                    str3 = this.huw.Iq().mLiveInfo.feed_id;
                    str4 = this.huw.Iq().mLiveInfo.live_id + "";
                    str5 = this.huw.Iq().mLiveInfo.room_id + "";
                    str6 = this.huw.Iq().mLiveInfo.user_name;
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
        if (this.hRP == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hRP.optString("source");
            String optString2 = this.hRP.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hRP.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hRP.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.hRP.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bVu();
        } else if (this.hRC != null && this.hRC.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.hRC.getVideoPath();
                String d = com.baidu.live.u.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.hRC.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.u.h.aN(videoPath, d)) {
                    this.hRC.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.u.h.aM(videoPath, d)) {
                    this.hRC.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.cu(this.hRC)) {
                        ((ViewGroup) this.hRC.getParent()).removeView(this.hRC);
                        alaLiveRoomBlurPageLayout.a(this.hRC, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.hRG) {
                        this.hRC.c(alaLiveInfoData);
                        return;
                    } else {
                        this.hRC.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.hRC.cog();
        } else if (this.hRC != null && this.hRC.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.hRC, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.hRG) {
                    this.hRC.c(alaLiveInfoData);
                } else {
                    this.hRC.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.hRC != null) {
            this.hRC.setLayoutParams(b);
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

    public void cnK() {
        this.bve = true;
    }

    public boolean cnL() {
        return this.bve;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        a(UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()), alaLiveInfoData, z);
    }

    private void a(int i, AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (this.hRC != null) {
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
            if (this.hRx != null) {
                this.hRx.setBackgroundColor(0);
            }
            int i3 = this.hRC.getLayoutParams().width;
            int i4 = this.hRC.getLayoutParams().height;
            int i5 = this.hRC.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.hRC.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i3 || b.height != i4 || b.topMargin != i5) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.huO != null) {
                this.huO.setLayoutParams(c);
            }
            if (this.hRx != null) {
                this.hRx.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.hRL != null) {
                this.hRL.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.hRM != null) {
                this.hRM.l(c.width, c.height, realScreenOrientation);
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
            if (this.hRx != null) {
                this.hRx.setBgImageUrl(this.aFN.mLiveInfo.cover, this.aFN.mLiveInfo);
            }
            this.hRz.a(this.mSelectedPosition, cnN(), this.aFN);
            this.hRz.b(this.mSelectedPosition, cnO(), this.aFN);
            if (this.hRx != null) {
                this.hRx.requestLayout();
                this.hRx.M(i, this.aFN.mLiveInfo.screen_direction == 2);
            }
        }
        if (this.aFN != null) {
            a(i, this.aFN.mLiveInfo, false);
        }
        boolean clh = this.hRx.clh();
        boolean z2 = i == 1;
        if (this.aFN == null || this.aFN.mLiveInfo == null || this.aFN.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!cnZ()) {
            if (this.hRC != null && this.hRC.getParent() == null) {
                this.hRx.a(this.hRC, null, false);
                if (this.aFN != null && this.aFN.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.hRG) {
                        this.hRC.c(this.aFN.mLiveInfo);
                    } else {
                        this.hRC.setPlayLiveInfo(this.aFN.mLiveInfo);
                    }
                }
            }
            if (clh && !cnZ() && this.hRM != null) {
                this.hRx.oj(z);
                return;
            }
            return;
        }
        this.hRx.cld();
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
            this.huw.a(alaLiveInfoData.live_id, true, this.brs, this.mForumName, this.hSd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnM() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.hRy != null && this.huO != null && this.mSelectedPosition != (currentItem = this.hRy.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.h.sdk_neterror);
                this.hRy.setCurrentItem(this.mSelectedPosition);
            } else if (!this.bve && ListUtils.getCount(this.huw.cjA()) <= 1) {
                this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                this.hRy.setCurrentItem(this.mSelectedPosition);
                this.huw.g(this.huw.cjK());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.huw.cjF() && i < 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                    this.hRy.setCurrentItem(this.mSelectedPosition);
                } else if (this.huw.cjG() && i > 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                    this.hRy.setCurrentItem(this.mSelectedPosition);
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.huw.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    nn(true);
                    this.hRx.cld();
                    this.hRx.Yj();
                    this.hRx.cle();
                    if (this.huw.Iq() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.huw.Iq().mLiveInfo.live_id + "", this.huw.Iq().mLiveInfo.room_id + "", this.huw.Iq().aJV.userId + "", this.huw.Iq().aJV.userName, System.currentTimeMillis(), this.huw.Iq().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.huw.Iq().mLiveInfo.live_id + "", this.huw.Iq().mLiveInfo.room_id + "", this.huw.Iq().aJV.userId + "", this.huw.Iq().aJV.userName, System.currentTimeMillis(), this.huw.Iq().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.hRS != null) {
                        long j = this.huw.Iq().mLiveInfo.live_id;
                        if (this.hRS.liveId == j && this.hRS.startTime > 0) {
                            this.hRS.endTime = System.currentTimeMillis();
                            long j2 = this.hRS.endTime - this.hRS.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hRS.roomId + "", this.hRS.vid, j2 / 1000, this.otherParams);
                        }
                        this.hRS = null;
                    }
                    cob();
                    if (this.hSo != null) {
                        this.hSo.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.hRx = this.hRz.wQ(this.mSelectedPosition);
                    this.hRx.clf();
                    xG(i);
                    cnD();
                }
            }
        }
    }

    public void xG(int i) {
        if (i < 0) {
            this.huw.xj(this.huw.cjH() - 1);
        } else if (i > 0) {
            this.huw.xj(this.huw.cjH() + 1);
        }
        if (this.hRM != null) {
            this.hRM.a(this.hRx);
        }
        this.hRz.a(this.mSelectedPosition, cnN(), this.aFN);
        this.hRz.b(this.mSelectedPosition, cnO(), this.aFN);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.huw != null) {
            int cjH = this.huw.cjH();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", cjH + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.huw.cjA() != null && this.huw.cjA().size() > cjH && this.huw.cjA().get(cjH) != null) {
                AlaLiveInfoData alaLiveInfoData = this.huw.cjA().get(cjH);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.huw != null) {
            AlaLiveInfoData cjK = this.huw.cjK();
            if (cjK != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(cjK.live_id), String.valueOf(cjK.room_id), null, cnJ(), this.hRv != null ? this.hRv.cnp() : false);
                cjK.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bVu();
                }
                a(this.hRx, cjK, this.bve);
                this.bve = false;
                if (this.hRM != null) {
                    this.hRM.a(this.mTbPageContext, this.huO, this.hRC, this.hRx, this.huw, this.brs, this.hRI, this.huU, null, this.hSa, this.hRy);
                    short s = 2;
                    if (cjK.screen_direction == 2) {
                        s = 1;
                    }
                    k(s);
                }
                a(cjK, false);
            }
            i(cjK);
            this.hRx.a(this.huO, null);
            if (this.hRM != null) {
                this.hRM.cca();
            }
            this.huw.g(cjK);
        }
    }

    private AlaLiveInfoData cnN() {
        List<AlaLiveInfoData> cjA = this.huw.cjA();
        if (cjA == null || cjA.size() == 0) {
            if (this.aFN == null) {
                return null;
            }
            return this.aFN.mLiveInfo;
        }
        int cjH = this.huw.cjH();
        int size = cjA.size();
        return cjA.get(((cjH + size) - 1) % size);
    }

    private AlaLiveInfoData cnO() {
        List<AlaLiveInfoData> cjA = this.huw.cjA();
        if (cjA == null || cjA.size() == 0) {
            if (this.aFN == null) {
                return null;
            }
            return this.aFN.mLiveInfo;
        }
        return cjA.get((this.huw.cjH() + 1) % cjA.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i, String str) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        TbConfig.liveScene = 1;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hRG) {
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
        w Iq = this.huw.Iq();
        S(Iq);
        this.huw.cjB();
        if (this.bve) {
            this.huw.ob(false);
        }
        this.huU = System.currentTimeMillis() / 1000;
        if (this.hRM != null) {
            this.hRM.a(this.mTbPageContext, this.huO, this.hRC, this.hRx, this.huw, this.brs, this.hRI, this.huU, this.hRJ, this.hSa, this.hRy);
            short s = 2;
            if (Iq.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            k(s);
        }
        if (this.hRv.cnq() != null && this.hRv.cnp()) {
            this.hRv.cnq().z("load_finish", null);
            if (Iq.mLiveInfo.screen_direction == 2) {
                this.hRv.cnq().z("screen_auto_rotate", true);
            } else {
                this.hRv.cnq().z("screen_auto_rotate", false);
            }
        }
        cnI();
        if (Iq != null && Iq.mLiveInfo != null && Iq.mLiveInfo.live_status == 2) {
            this.hRz.a(this.mSelectedPosition, this.huw.Iq());
            d(Iq, false);
            this.bve = false;
            return;
        }
        if (this.hvs == null && (runTask2 = MessageManager.getInstance().runTask(2913229, com.baidu.live.t.d.class)) != null) {
            this.hvs = (com.baidu.live.t.d) runTask2.getData();
        }
        if (this.hvs != null) {
            this.hvs.Qy();
        }
        if (this.hvu == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.v.c.class)) != null) {
            this.hvu = (com.baidu.live.v.c) runTask.getData();
        }
        if (this.hvu != null) {
            this.hvu.Qy();
        }
        boolean z = (this.hRM == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ag.a.b.Sm().cO(com.baidu.live.ae.a.RB().brA != null && com.baidu.live.ae.a.RB().brA.aOL && Iq != null && Iq.aKP);
        ac.d(Iq);
        if (z) {
            if (!this.hRX || !TextUtils.equals(p.WC(), this.hRY)) {
                ac.b(getPageContext(), false);
                e.RP().RQ();
                this.hRX = true;
                this.hRY = p.WC();
            }
            ac.hs("");
            ac.Ix();
        }
        if (this.huw.Iq() != null && this.huw.Iq().mLiveInfo != null) {
            this.huw.h(this.huw.Iq().mLiveInfo.live_id, !this.hRT);
            this.hRT = true;
        }
        if (this.hRM != null) {
            this.hRM.b(this.hRD);
            this.hRM.nm(TextUtils.equals(this.hRK, "1"));
            this.hRK = "";
        }
        if (this.hRA != null) {
            this.hRA.a(this.aFN, this.hRB);
        }
        a(this.huw.Iq());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.huw.Iq() != null && b.this.huw.Iq().mLiveInfo != null) {
                    b.this.huw.a(b.this.huw.Iq().mLiveInfo.live_id, b.this.brs, b.this.huU);
                }
            }
        });
        if (z && this.huw.Iq() != null && this.huw.Iq().aJV != null) {
            bo boVar = com.baidu.live.ae.a.RB().bxq;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && boVar != null && boVar.aQP != null && boVar.aQP.aTh) {
                f(true, this.huw.Iq().aJV.userId);
            }
        }
        this.bve = false;
        if (z && this.huw.Iq() != null && this.huw.Iq().mLiveInfo != null && this.huw.Iq().aJV != null && this.hRM != null) {
            long j = this.huw.Iq().mLiveInfo.live_id;
            long j2 = this.huw.Iq().mLiveInfo.room_id;
            String str2 = this.huw.Iq().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.IE() != null) {
                    al.IE().bF(this.biE);
                    if (!this.biE) {
                        al.IE().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.hSo != null) {
                    this.hSo.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.LY() != null) {
                com.baidu.live.guardclub.e.LY().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.hRU == null) {
                this.hRU = new com.baidu.tieba.ala.liveroom.k.a();
                this.hRU.bF(this.biE);
            }
            if (!this.biE) {
                this.hRU.a(this.mTbPageContext.getPageActivity(), this.huw.Iq(), this.otherParams);
            }
        }
        if (this.hRV == null) {
            this.hRV = new com.baidu.tieba.ala.liveroom.v.c(this.mTbPageContext);
            this.hRV.bF(this.biE);
        }
        if (z && this.huw.Iq() != null && this.huw.Iq().aKr != null && !this.hRW) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.hRV.a(this.huw.Iq(), this.huw.Iq().aKr.userId);
                this.hRW = true;
            }
        }
        if (this.huw.Iq() != null && this.huw.Iq().mLiveInfo != null && this.huw.Iq().aKr != null) {
            com.baidu.live.p.a.b(this.huw.Iq().mLiveInfo.live_id, this.huw.Iq().aKr.needRename == 1);
            if (z) {
                com.baidu.live.p.a.b(this.huw.Iq().mLiveInfo.live_id, 0);
            }
        }
        if (this.hvt != null && this.huw.Iq() != null && this.huw.Iq().aJV != null) {
            this.hvt.bd(this.huw.Iq().aJV.userId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnP() {
        if (this.hRE) {
            this.hRz.a(this.mSelectedPosition, cnN(), this.aFN);
            this.hRz.b(this.mSelectedPosition, cnO(), this.aFN);
            this.hRE = false;
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
        if (!this.hRG) {
            this.mHandler.removeCallbacks(this.hSi);
            this.mHandler.postDelayed(this.hSi, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (qVar == null) {
            if (!this.hRG) {
                this.mHandler.removeCallbacks(this.hSh);
                this.mHandler.postDelayed(this.hSh, 5000L);
                return;
            }
            return;
        }
        if (!this.hRF) {
            c(qVar);
        }
        if (!this.hRG) {
            this.mHandler.removeCallbacks(this.hSh);
            this.mHandler.postDelayed(this.hSh, qVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnQ() {
        if (this.huw.Iq() != null && this.huw.Iq().mLiveInfo != null) {
            this.huw.h(this.huw.Iq().mLiveInfo.live_id, !this.hRT);
            this.hRT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_status == 2) {
            this.hRz.a(this.mSelectedPosition, this.huw.Iq());
            d(wVar, false);
        } else if (wVar != null) {
            if (!this.hRF) {
                ac.d(wVar);
                a(wVar);
            }
            if (!this.hRG) {
                this.mHandler.removeCallbacks(this.hye);
                this.mHandler.postDelayed(this.hye, wVar.aKa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjf() {
        if (this.mTbPageContext != null && this.huw.Iq() != null && this.huw.Iq().mLiveInfo != null) {
            this.huw.a(this.huw.Iq().mLiveInfo.live_id, this.brs, this.huU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar, boolean z) {
        String str;
        nn(true);
        if (!cnZ()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cka().od(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cka().release();
            this.huw.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.hRx != null) {
                this.hRx.Yj();
                this.hRx.cld();
                this.hRx.cli();
            }
            if (wVar == null || wVar.mLiveInfo == null) {
                str = null;
            } else {
                this.hRO = wVar.mLiveInfo.live_id;
                str = String.valueOf(wVar.mLiveInfo.room_id);
            }
            cnF();
            cnR();
            cnS();
            if (this.hRv.cnp() && !StringUtils.isNull(str) && this.hRv.cnq() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.hRv.cnq().z("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (wVar != null) {
                View a2 = (this.hRM == null || this.hRM.ccg() == null) ? null : this.hRM.ccg().a(this.hRM.cbW().pageContext.getPageActivity(), wVar, z);
                if (this.hRx != null) {
                    this.hRL.a(this.hRx, a2, wVar, z, this.huw.cjC());
                }
                if (this.hRM != null) {
                    this.hRM.nn(false);
                    this.hRM.ccb();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.hRx != null) {
                    this.hRx.clf();
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
                this.hRS = new StayTimeBean();
                this.hRS.liveId = wVar.mLiveInfo.live_id;
                this.hRS.roomId = wVar.mLiveInfo.room_id;
                this.hRS.vid = wVar.mLiveInfo.feed_id;
                this.hRS.startTime = System.currentTimeMillis();
            }
            cob();
            if (this.hRA != null) {
                this.hRA.a(this.aFN, this.hRB);
            }
        }
    }

    private void cnR() {
    }

    private void cnS() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.hRy);
        }
    }

    public void cnT() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnU();
        } else {
            cnV();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.huw != null && this.huw.Iq() != null) {
            alaLiveInfoData = this.huw.Iq().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cnU();
        } else {
            cnV();
        }
        this.hRy.setIsScrollable(!z && this.hSb);
        if (this.hRM != null) {
            this.hRM.onKeyboardVisibilityChanged(z);
        }
        if (this.huO != null) {
            this.huO.onKeyboardVisibilityChanged(z);
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
            cnU();
        } else {
            cnV();
        }
        this.huO.dX(i);
        xF(i);
        if (al.IE() != null) {
            al.IE().HO();
        }
        if (this.hRU != null) {
            this.hRU.HO();
        }
        if (this.hRA != null) {
            this.hRA.dX(i);
        }
    }

    public void cnU() {
        if (this.hRy != null) {
            i.ae(this.hRy);
        }
    }

    public void cnV() {
        if (this.hRy != null) {
            i.af(this.hRy);
        }
    }

    private boolean cnW() {
        return this.hSk || this.hSl;
    }

    private void cnX() {
        this.hSk = false;
        this.hSl = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.hRZ + " mWebOver=" + this.hRH + ", isFloatingMode=" + isFloatingMode());
        }
        cnX();
        if (!this.hRH || !isFloatingMode()) {
            bVu();
            if (this.huw != null) {
                this.huw.cjm();
                this.huw.cjq();
            }
            if (this.hRM != null) {
                this.hRM.enterForeground();
            }
            if (this.hRU != null) {
                this.hRU.onResume();
            }
            if (this.hRV != null) {
                this.hRV.onResume();
            }
            com.baidu.live.core.layer.b.EY().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.hRZ + " mWebOver=" + this.hRH + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        cnX();
        if ((!this.hRH || !isFloatingMode()) && !this.hRZ) {
            bVu();
            if (this.hRG) {
                this.hRG = false;
                cnY();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            cnD();
        }
    }

    public void cnY() {
        cjf();
        cnQ();
        this.huw.cjB();
        if (!this.hRC.isPlaying()) {
            cnE();
        } else if (this.hRC.isPaused()) {
            this.hRC.resume();
        }
        if (this.hRM != null) {
            this.hRM.ccf();
        }
        if (this.huw != null && this.huw.Iq() != null && this.huw.Iq().mLiveInfo != null) {
            this.hRR.fG(this.huw.Iq().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aFN.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.hRH + ", isFloatingMode=" + isFloatingMode());
        }
        if (cnW() || !this.hRH || !isFloatingMode()) {
            if (this.huw != null) {
                this.huw.cjn();
                this.huw.cjr();
            }
            if (this.hRM != null) {
                this.hRM.enterBackground();
            }
            com.baidu.live.core.layer.b.EY().onPause();
        }
    }

    public void T(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.hSg);
        }
        if (!cnW() && z && !this.hSg && cny()) {
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
        this.hRG = true;
        oB(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void oB(boolean z) {
        this.mHandler.removeCallbacks(this.hye);
        this.mHandler.removeCallbacks(this.hSh);
        this.mHandler.removeCallbacks(this.hSi);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.hRC.isFloatingMode()) {
                this.hRC.aSi();
            }
        } else if (!z && !this.hRC.isFloatingMode()) {
            this.hRC.aSi();
        }
        if (this.hRM != null) {
            this.hRM.cce();
        }
        this.hRR.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.IE() != null) {
                al.IE().a(i, i2, intent, this.aFN, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.hRM != null) {
            this.hRM.onActivityResult(i, i2, intent);
        }
    }

    public boolean cnZ() {
        return this.hRL != null && this.hRL.bVk();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hSx != null) {
            MessageManager.getInstance().unRegisterListener(this.hSx);
        }
        if (this.hSy != null) {
            MessageManager.getInstance().unRegisterListener(this.hSy);
        }
        MessageManager.getInstance().unRegisterListener(this.hSz);
        MessageManager.getInstance().unRegisterListener(this.hSA);
        MessageManager.getInstance().unRegisterListener(this.hSB);
        MessageManager.getInstance().unRegisterListener(this.hSC);
        MessageManager.getInstance().unRegisterListener(this.hSt);
        MessageManager.getInstance().unRegisterListener(this.hhl);
        MessageManager.getInstance().unRegisterListener(this.hSm);
        MessageManager.getInstance().unRegisterListener(this.hSn);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        if (this.hSo != null) {
            this.hSo.release();
        }
        if (this.hRC != null && !this.hRC.isFloatingMode()) {
            this.hRC.cE(true);
        }
        if (this.hRA != null) {
            this.hRA.onDestory();
        }
        if (this.hvt != null) {
            this.hvt.release();
            this.hvt = null;
        }
        if (this.hvv != null) {
            this.hvv.release();
            this.hvv = null;
        }
        if (this.hRB != null) {
            this.hRB.reset();
        }
        if (this.hRM != null) {
            this.hRM.onDestroy();
        }
        if (this.hRz != null) {
            this.hRz.onDestroy();
        }
        if (this.hRx != null) {
            this.hRx.Yj();
            this.hRx.release();
            this.hRx = null;
        }
        if (this.hRL != null) {
            this.hRL.onDestroy();
        }
        if (this.hRS != null && this.huw != null && this.huw.Iq() != null) {
            long j = this.huw.Iq().mLiveInfo.live_id;
            if (this.hRS.liveId == j && this.hRS.startTime > 0) {
                this.hRS.endTime = System.currentTimeMillis();
                long j2 = this.hRS.endTime - this.hRS.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hRS.roomId + "", this.hRS.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.hRS = null;
        }
        if (this.huO != null) {
            this.huO.cll();
            this.huO = null;
        }
        if (this.huw != null) {
            this.huw.destory();
        }
        if (this.hvs != null) {
            this.hvs.release();
        }
        if (this.hvu != null) {
            this.hvu.release();
        }
        z.Ii().release();
        if (this.hRV != null) {
            this.hRV.release();
        }
        x.Ig().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String Oj() {
        return this.otherParams;
    }

    public void oC(boolean z) {
        this.hRZ = z;
    }

    public void coa() {
        if (this.hRP != null) {
            this.otherParams = this.hRP.toString();
            if (this.huw != null) {
                this.huw.setOtherParams(this.otherParams);
            }
            if (this.hRM != null) {
                this.hRM.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.hRL != null) {
                this.hRL.setOtherParams(this.otherParams);
            }
        }
    }

    public void cob() {
        if (this.hRP != null) {
            String optString = this.hRP.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hRP.put("tab", "live_jump");
                        this.hRP.put("tag", "");
                        this.hRP.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hRP.put("tab", "liveroom");
                        this.hRP.put("tag", "");
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

    private void f(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.LW();
        }
        bVar.setAnchorId(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void coc() {
        ac.IA();
    }

    private void k(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hRM.e(s);
        } else {
            this.hRM.f(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
