package com.baidu.tieba.ala.player;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
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
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bj;
import com.baidu.live.data.bk;
import com.baidu.live.data.n;
import com.baidu.live.data.u;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.s;
import com.baidu.live.gift.w;
import com.baidu.live.guardclub.e;
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
import com.baidu.tieba.ala.floating.a;
import com.baidu.tieba.ala.floating.permission.FloatPermissionUtil;
import com.baidu.tieba.ala.liveroom.j.g;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew;
import com.baidu.tieba.ala.liveroom.q.d;
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
    private static int hbV = 1;
    private static WeakReference<b> mRef;
    private u aAP;
    private CustomMessageListener aYi;
    private boolean aZX;
    private String bhq;
    private long bhr;
    private boolean bkL;
    private com.baidu.live.q.b buC;
    private AlaLiveView gFC;
    private ViewGroup gFD;
    private LayerRootView gFE;
    private long gFI;
    private d.a gFS;
    private d gFj;
    private com.baidu.live.p.d gGg;
    private com.baidu.live.p.c gGh;
    private Runnable gIM;
    private String gnC;
    CustomMessageListener grL;
    private String hbA;
    private com.baidu.tieba.ala.endliveroom.a hbB;
    private com.baidu.tieba.ala.liveroom.d.c hbC;
    private String hbD;
    private long hbE;
    private JSONObject hbF;
    private boolean hbG;
    private com.baidu.tieba.ala.liveroom.task.c hbH;
    private StayTimeBean hbI;
    private boolean hbJ;
    private com.baidu.tieba.ala.liveroom.k.a hbK;
    private com.baidu.tieba.ala.liveroom.w.c hbL;
    private boolean hbM;
    private boolean hbN;
    private String hbO;
    private boolean hbP;
    private boolean hbQ;
    private bk hbR;
    private boolean hbS;
    private boolean hbT;
    private int hbU;
    private boolean hbW;
    private boolean hbX;
    private Boolean hbY;
    private Runnable hbZ;
    private a hbm;
    private AlaLiveRoomBlurPageLayout hbn;
    private AlaLoopViewPager hbo;
    private AlaLoopViewPagerAdapter hbp;
    private com.baidu.tieba.ala.liveroom.e.a hbq;
    private com.baidu.tieba.ala.liveroom.e.b hbr;
    private SdkLivePlayer hbs;
    private AlaLastLiveroomInfo hbt;
    private boolean hbu;
    private boolean hbv;
    private boolean hbw;
    private boolean hbx;
    @Deprecated
    private boolean hby;
    private ArrayList<AlaBroadcastGiftToastData> hbz;
    private Runnable hca;
    private Runnable hcb;
    private boolean hcc;
    private boolean hcd;
    private CustomMessageListener hce;
    private CustomMessageListener hcf;
    private com.baidu.live.z.c hcg;
    private boolean hch;
    private boolean hci;
    private long hcj;
    private long hck;
    private CustomMessageListener hcl;
    private com.baidu.live.q.a hcm;
    com.baidu.live.liveroom.a.c hcn;
    ViewPager.OnPageChangeListener hco;
    HttpMessageListener hcp;
    CustomMessageListener hcq;
    CustomMessageListener hcr;
    CustomMessageListener hcs;
    CustomMessageListener hct;
    private CustomMessageListener hcu;
    private boolean isLandscape;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void cbb() {
        if (this.hbL != null) {
            this.hbL.bn(this.aZX);
        }
        if (this.hbK != null) {
            this.hbK.bn(this.aZX);
        }
        if (ad.FE() != null) {
            ad.FE().bn(this.aZX);
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hbu = true;
        this.gFI = 0L;
        this.hbv = false;
        this.bkL = true;
        this.bhq = "";
        this.mForumName = "";
        this.hbw = false;
        this.hby = false;
        this.hbA = "0";
        this.mHandler = new Handler();
        this.hbE = -1L;
        this.otherParams = "";
        this.hbG = false;
        this.hbH = com.baidu.tieba.ala.liveroom.task.c.bYj();
        this.hbJ = false;
        this.hbN = false;
        this.hbP = false;
        this.hbQ = false;
        this.hbT = false;
        this.hbU = 0;
        this.hbW = false;
        this.hbX = false;
        this.gIM = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bWS();
            }
        };
        this.hbZ = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.cbC();
            }
        };
        this.hca = new Runnable() { // from class: com.baidu.tieba.ala.player.b.21
            @Override // java.lang.Runnable
            public void run() {
                b.this.gFj.bXo();
            }
        };
        this.hcb = new Runnable() { // from class: com.baidu.tieba.ala.player.b.22
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.grL = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hcc = true;
            }
        };
        this.hce = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hcd = true;
            }
        };
        this.hcf = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.hcl = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.aZX = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.cbb();
            }
        };
        this.aYi = new CustomMessageListener(2501059) { // from class: com.baidu.tieba.ala.player.b.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_video_activity")) {
                    b.this.P(false, false);
                }
            }
        };
        this.buC = new com.baidu.live.q.b() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.q.b
            public void dH(int i) {
                if (b.this.hbn != null) {
                    if (ListUtils.getCount(b.this.hbs.getAlaLiveInfoDataList()) < 2) {
                        b.this.hbn.bYL();
                    } else {
                        b.this.hbn.bYM();
                    }
                }
                if (b.this.hbC != null) {
                    b.this.hbC.dH(i);
                }
            }
        };
        this.hcm = new com.baidu.live.q.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.q.a
            public void ch(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && b.this.hbs != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.hbs.isPlaying());
                        if (!b.this.hbs.isPlaying()) {
                            b.this.hbs.resume();
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.hbs.isPlaying()) {
                        b.this.hbs.pause();
                    }
                }
            }
        };
        this.hcn = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // com.baidu.live.liveroom.a.c
            public void bY(boolean z) {
                if (z || b.this.hbC == null || b.this.hbC.bPZ()) {
                    if (!b.this.cbm() || b.this.a(true, (a.InterfaceC0595a) null)) {
                        b.this.hbX = true;
                        b.this.mZ(true);
                        b.this.bNg();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void bZ(boolean z) {
                b.this.d(b.this.aAP, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.hbs.cbT();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.hbw) {
                    if (b.this.hbw) {
                        b.this.hbs.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.hbs.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.hbo != null) {
                    b.this.hbo.setIsScrollable(b.this.hbS && z);
                    b.this.hbo.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void ca(boolean z) {
                boolean z2 = true;
                if (!z || b.this.cbM()) {
                    if (b.this.hbn != null) {
                        b.this.hbn.bYO();
                        return;
                    }
                    return;
                }
                if (b.this.gFj.Fq().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.hbn != null) {
                    b.this.hbn.mL(z2);
                }
            }
        };
        this.hco = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.hbo != null && i == 0) {
                    b.this.cby();
                    com.baidu.live.c.AR().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.gFS = new d.a() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // com.baidu.tieba.ala.liveroom.q.d.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.B(b.this.gFj.Fq());
                } else if (i2 == 2) {
                    b.this.f(b.this.gFj.bJE());
                } else if (i2 == 3) {
                    b.this.bc(i, str);
                } else if (i2 == 4) {
                    b.this.aD(obj);
                } else if (i2 == 5) {
                    b.this.cbB();
                }
            }
        };
        this.hcp = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bYh() != null && b.this.mTbPageContext != null) {
                        b.this.hbH.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bYh());
                    }
                }
            }
        };
        this.hcq = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.16
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
        this.hcr = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.gFj != null && b.this.gFj.Fq() != null && b.this.gFj.Fq().mLiveInfo != null) {
                    long j = b.this.gFj.Fq().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.hcg != null) {
                        b.this.hcg.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.hcs = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.gFj != null && b.this.gFj.Fq() != null && b.this.gFj.Fq().aFb != null) {
                        if (l.longValue() == b.this.gFj.Fq().aFb.userId) {
                            b.this.gFj.Fq().aFb.isNewUser = false;
                            if (b.this.hbK != null) {
                                b.this.hbK.p(b.this.gFj.Fq());
                            }
                        }
                    }
                }
            }
        };
        this.hct = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.u.a)) {
                    com.baidu.tieba.ala.liveroom.u.a aVar2 = (com.baidu.tieba.ala.liveroom.u.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String CK = aVar2.CK();
                    if (b.this.mTbPageContext != null && b.this.gFj != null && b.this.gFj.Fq() != null && b.this.gFj.Fq().aFb != null) {
                        if (valueOf.longValue() == b.this.gFj.Fq().aFb.userId && com.baidu.live.x.a.NN().bmW != null && com.baidu.live.x.a.NN().bmW.aKO != null && com.baidu.live.x.a.NN().bmW.aKO.Dn()) {
                            g.uu(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, CK));
                        }
                    }
                }
            }
        };
        this.hcu = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.gIM != null) {
                    b.this.mHandler.removeCallbacks(b.this.gIM);
                }
                b.this.bWS();
            }
        };
        this.gFI = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.hbm = aVar;
        this.hbu = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.z.c.class);
        if (runTask != null) {
            this.hcg = (com.baidu.live.z.c) runTask.getData();
        }
        this.gFj = new d(getPageContext());
        this.gFj.a(this.gFS);
        this.hbB = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hcp);
        MessageManager.getInstance().registerListener(this.hcq);
        MessageManager.getInstance().registerListener(this.hcr);
        MessageManager.getInstance().registerListener(this.hcs);
        MessageManager.getInstance().registerListener(this.hct);
        MessageManager.getInstance().registerListener(this.hcu);
        MessageManager.getInstance().registerListener(this.hcl);
        MessageManager.getInstance().registerListener(this.grL);
        MessageManager.getInstance().registerListener(this.hce);
        MessageManager.getInstance().registerListener(this.hcf);
        MessageManager.getInstance().registerListener(this.aYi);
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.hbz = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hbz.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void R(Intent intent) {
        Q(intent);
        this.bhq = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bhq)) {
            this.bhq = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.hbD = intent.getStringExtra("room_id");
        this.bhr = intent.getLongExtra("live_id", 0L);
        this.hbG = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.gFj.b((AlaLiveInfoCoreData) serializableExtra);
            this.hbG = true;
        }
        S(intent);
        this.hbS = this.hbR == null || !this.hbR.aLe;
        this.hbB.setOtherParams(this.otherParams);
        cbd();
        cbc();
        this.mHandler.removeCallbacks(this.hcb);
        this.mHandler.postDelayed(this.hcb, 1000L);
    }

    private void S(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.hbU = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.gnC = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hbF = new JSONObject(stringExtra);
                if (this.hbF != null) {
                    String optString2 = this.hbF.optString("enterRoomId");
                    String optString3 = this.hbF.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hbD, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bhr + "", optString3))) {
                        String optString4 = this.hbF.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString5 = this.hbF.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString5);
                        if (!this.hbG) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bhr;
                            alaLiveInfoCoreData.screenDirection = this.hbF.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.gFj.b(alaLiveInfoCoreData);
                            this.hbG = true;
                        }
                    }
                    String optString6 = this.hbF.optString("extra");
                    try {
                        this.hcj = Long.parseLong(this.hbD);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.hck = this.bhr;
                    if (TextUtils.isEmpty(optString6)) {
                        this.hbR = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.gFj != null) {
                            this.gFj.Gj(optString7);
                        }
                        this.hch = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.hci = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.gnC = jSONObject.optString("live_back_scheme");
                        this.hbR = new bk();
                        this.hbR.aLe = jSONObject.optInt("is_hot") == 1;
                        if (this.hbR.aLe) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hbU = AlaLiveSwitchData.isHotLive;
                        this.hbR.aLf = jSONObject.optString("task_id");
                        this.hbR.aLd = !TextUtils.isEmpty(this.hbR.aLf);
                        this.hbR.aLg = jSONObject.optInt("task_type");
                        this.hbR.aLh = jSONObject.optInt("task_im_count");
                        this.hbR.aLi = jSONObject.optLong("task_gift_total_price");
                        this.hbR.aLj = jSONObject.optLong("task_watch_time");
                        this.hbR.aLk = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.hbF.put("from", optString);
                        }
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.hbr = new com.baidu.tieba.ala.liveroom.e.b();
                            this.hbr.setScheme(optString8);
                            this.hbr.setImageUrl(optString9);
                            this.hbr.setTitle(optString10);
                        }
                    }
                    this.hbA = this.hbF.optString("open_giftlist");
                    this.hbF.remove("cover");
                    this.hbF.remove("live_url");
                    this.hbF.remove("enterRoomId");
                    this.hbF.remove("enterLiveId");
                    this.hbF.remove("open_giftlist");
                    this.hbF.remove("extra");
                    this.otherParams = this.hbF.toString();
                    if (this.gFj != null) {
                        this.gFj.setOtherParams(this.otherParams);
                    }
                    this.hbF.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hbF.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hbF.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hbF.optString("source");
                    }
                    this.hbT = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hbF.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.gFj != null) {
                        this.gFj.uT(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hbt = new AlaLastLiveroomInfo();
                this.hbt.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bhr), String.valueOf(this.hbD), null, cbv());
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

    public void cbc() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.gFj.ah(this.uk, this.bhq, this.mForumName);
        } else if (this.gFj.Fq() != null && this.gFj.Fq().mLiveInfo != null && this.gFj.Fq().mLiveInfo.live_id > 0) {
            this.gFj.a(this.gFj.Fq().mLiveInfo.live_id, false, this.bhq, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bhq = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                mZ(false);
                return;
            }
            this.gFj.ah(this.uk, this.bhq, this.mForumName);
        } else if (!TextUtils.isEmpty(this.hbD)) {
            this.gFj.GL(this.hbD);
        } else if (this.bhr > 0) {
            this.gFj.a(this.bhr, false, this.bhq, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            mZ(false);
        }
    }

    private void cbd() {
        this.bkL = true;
        this.hbv = false;
        cbe();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.CA().n(this.gFE);
        this.hbC = new com.baidu.tieba.ala.liveroom.d.c();
        this.hbC.a(this.hcn);
        this.hbC.setOtherParams(this.otherParams);
        this.hbC.lL(this.hbT);
        cbh();
        cbf();
        cbg();
    }

    private void cbe() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.hbo = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.hbo.setOnPageChangeListener(this.hco);
        this.hbo.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void bUI() {
                b.this.cby();
            }
        });
        this.hbo.setBoundaryCaching(true);
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.hbp = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.hbp.bUG();
        this.hbn = this.hbp.uA(this.mSelectedPosition);
        this.hbp.a(this.mSelectedPosition, this.gFj.Fq());
        this.hbo.setAdapter(this.hbp);
        this.hbo.setCurrentItem(this.mSelectedPosition);
        this.hbo.setIsScrollable(this.hbS);
        this.gFD = (ViewGroup) inflate.findViewById(a.g.func_view);
        this.gFE = (LayerRootView) inflate.findViewById(a.g.layer_root_view);
    }

    private void c(Rect rect) {
        this.hbs = SdkLivePlayer.eX(getPageContext().getPageActivity());
        if (this.hbs == null) {
            this.hbo.setIsScrollable(false);
            if (this.gFj != null) {
                this.gFj.cancelLoadData();
            }
            bUK();
            return;
        }
        this.hbs.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.hbs.setIPlayerCallBack(this.buC);
        this.hbs.setIPlayerAudioFocusCallBack(this.hcm);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hbn.a(this.hbs, layoutParams, true);
    }

    private void cbf() {
        this.hbq = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.gFD);
    }

    private void cbg() {
        CustomResponsedMessage runTask;
        if (this.gGh == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.p.c.class)) != null) {
            this.gGh = (com.baidu.live.p.c) runTask.getData();
        }
        if (this.gGh != null) {
            this.gGh.setParentView(this.gFD);
        }
    }

    private void bUK() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.mZ(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.gFC = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.gFC.setSwipeClearEnable(true);
        this.gFC.gPq = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hbn.a(this.gFC, layoutParams);
    }

    private void cbh() {
        if (this.gFj != null && this.gFj.Fq() != null) {
            this.aAP = this.gFj.Fq();
            if (this.aAP.mLiveInfo != null) {
                a(this.aAP.mLiveInfo, this.hbG);
                if (this.aAP.mLiveInfo != null && this.aAP.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hbw);
                    }
                    if (!this.hbw) {
                        this.hbs.c(this.aAP.mLiveInfo);
                    } else {
                        this.hbs.setPlayLiveInfo(this.aAP.mLiveInfo);
                    }
                    if (this.hbC != null) {
                        this.hbC.a(this.mTbPageContext, this.gFC, this.hbs, this.hbn, this.gFj, this.bhq, this.hby, this.gFI, this.hbz, this.hbR);
                        j(this.aAP.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean cbi() {
        boolean z;
        AlaLiveInfoData bXx;
        if (this.gFj == null || (bXx = this.gFj.bXx()) == null || bXx.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !bXx.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.hcj + ", getPlayingRoomID:" + cbk() + ", mSchemeLiveId:" + this.hck + ", getPlayingLiveID:" + cbl());
        }
        return z || cbn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbj() {
        if (this.hbY == null) {
            this.hbY = Boolean.valueOf(Build.MODEL.contains("Mi9 Pro"));
        }
        return this.hbY.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cbk() {
        AlaLiveInfoData bXx;
        if (this.gFj == null || (bXx = this.gFj.bXx()) == null) {
            return 0L;
        }
        return bXx.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cbl() {
        AlaLiveInfoData bXx;
        if (this.gFj == null || (bXx = this.gFj.bXx()) == null) {
            return 0L;
        }
        return bXx.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbm() {
        boolean z = this.hch && (this.hcj == cbk() || this.hck == cbl());
        Log.d(TAG, "isCloseToFloatable " + z);
        return z;
    }

    private boolean cbn() {
        boolean z = this.hci && (this.hcj == cbk() || this.hck == cbl());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean cbo() {
        if (hbV <= 0) {
            return false;
        }
        if (!(cbm() || cbi()) || FloatPermissionUtil.LQ()) {
            return false;
        }
        hbV--;
        FloatPermissionUtil.al(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0595a interfaceC0595a) {
        if (!FloatPermissionUtil.LQ()) {
            if (this.hbW) {
                return true;
            }
            this.hbW = true;
            if (z) {
                FloatPermissionUtil.al(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (cbm()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.hci) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a eS = com.baidu.tieba.ala.floating.b.eS(getPageContext().getPageActivity());
        eS.a(interfaceC0595a);
        eS.dn(jSONObject);
        com.baidu.tieba.ala.floating.b.eS(getPageContext().getPageActivity()).a(this.hbs, this.gFj.Fq(), this.bhq, this.gFI);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    public void cbp() {
        if (!cbI() && cbi()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0595a() { // from class: com.baidu.tieba.ala.player.b.6
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0595a
                    public boolean a(SdkLivePlayer sdkLivePlayer, JSONObject jSONObject) {
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer3 back isStop:" + b.this.hbw);
                        }
                        if (sdkLivePlayer != null) {
                            sdkLivePlayer.aII();
                            return true;
                        }
                        return true;
                    }
                });
            }
        }
    }

    private void bKC() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bKx = com.baidu.tieba.ala.floating.b.bKx();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0595a() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0595a
            public boolean a(SdkLivePlayer sdkLivePlayer, JSONObject jSONObject) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bKx == null || bKx.room_id == b.this.cbk() || bKx.live_id == b.this.cbl()) {
                    if (b.this.hbs != null) {
                        b.this.cbq();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.hbw);
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
    public void cbq() {
        ArrayList arrayList = (ArrayList) this.hbs.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.hbs.cbS();
            this.hbs.aj(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bKA();
    }

    public void mX(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.hbx = z;
    }

    private void cbr() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hbS) {
                this.hbo.setIsScrollable(true);
            } else {
                this.hbo.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.CA().onBackPressed() && ((this.hbC == null || !this.hbC.onKeyDown(i, keyEvent)) && (this.hbC == null || !this.hbC.bPY()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cbr();
            } else if ((this.hbC == null || this.hbC.bPZ()) && (!cbm() || a(true, (a.InterfaceC0595a) null))) {
                this.hbX = true;
                mZ(true);
                bNg();
            }
        }
        return true;
    }

    public void bNg() {
        if (!TextUtils.isEmpty(this.gnC)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gnC);
                this.gnC = null;
            }
        }
    }

    public void mZ(boolean z) {
        P(z, false);
    }

    public void P(boolean z, boolean z2) {
        lQ(!z);
        if (this.hbs != null && !this.hbs.isFloatingMode()) {
            this.hbs.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.CA().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cbt();
        long j = -1;
        if (this.gFj != null && this.gFj.bXx() != null) {
            j = this.gFj.bXx().room_id;
        }
        this.hbm.a(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void lQ(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hbt = null;
        if (ad.FE() != null) {
            ad.FE().FD();
        }
        com.baidu.live.core.layer.b.CA().CB();
        if (this.hcg != null) {
            this.hcg.release();
        }
        if (this.hbK != null) {
            this.hbK.release();
        }
        this.hbR = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.gFj != null) {
            try {
                this.gFj.Gj(null);
                AlaLiveInfoData bXx = this.gFj.bXx();
                if (bXx != null) {
                    this.gFj.el(bXx.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.hbH.stopRecord();
        LiveTimerManager.getInstance().stop();
        cbs();
        if (this.hbs != null && !this.hbs.isFloatingMode()) {
            this.hbs.ci(z);
        }
        if (this.hbC != null) {
            this.hbC.lQ(z);
        }
        this.hbJ = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Lw().bgH != null && this.aAP != null) {
            com.baidu.live.liveroom.a.b.Lw().bgH.b(this.aAP.mLiveInfo);
        }
        w.gz("");
        s.Fi().release();
        if (this.gGh != null) {
            this.gGh.FB();
        }
    }

    private void cbs() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cbt() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(u uVar) {
        if (uVar != null) {
            this.aAP = uVar;
            if (this.hbC != null) {
                this.hbC.a(uVar);
            }
            cbo();
        }
    }

    private void c(n nVar) {
        if (this.hbC != null) {
            this.hbC.c(nVar);
        }
    }

    private void E(u uVar) {
        this.aAP = uVar;
        cbo();
    }

    private void cbu() {
        long j;
        String str;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.hbS = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.hbS = true;
        }
        this.hbo.setIsScrollable(this.hbS);
        this.hbU = AlaLiveSwitchData.isHotLive;
        if (this.aAP != null) {
            a(this.aAP.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.hbn.a(this.gFC, null);
            if (!isFloatingMode()) {
                a(this.hbn, this.aAP.mLiveInfo, this.bkL);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aAP.mLiveInfo.live_id), String.valueOf(this.aAP.mLiveInfo.room_id), String.valueOf(this.aAP.mLiveInfo.feed_id), cbv());
            if (com.baidu.live.liveroom.a.b.Lw().bgH != null) {
                com.baidu.live.liveroom.a.b.Lw().bgH.a(this.aAP.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.bkL = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                String str2 = "";
                if (this.gFj != null && this.gFj.Fq() != null && this.gFj.Fq().mLiveInfo != null) {
                    j = this.gFj.Fq().mLiveInfo.live_id;
                    str = this.gFj.Fq().mLiveInfo.room_id + "";
                    str2 = this.gFj.Fq().mLiveInfo.feed_id;
                } else {
                    if (this.bhr > 0) {
                        j2 = this.bhr;
                    }
                    if (TextUtils.isEmpty(this.hbD)) {
                        j = j2;
                        str = "";
                    } else {
                        j = j2;
                        str = this.hbD;
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
                if (this.gFj != null && this.gFj.Fq() != null && this.gFj.Fq().mLiveInfo != null) {
                    str3 = this.gFj.Fq().mLiveInfo.feed_id;
                    str4 = this.gFj.Fq().mLiveInfo.live_id + "";
                    str5 = this.gFj.Fq().mLiveInfo.room_id + "";
                    str6 = this.gFj.Fq().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            cbo();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String cbv() {
        if (this.hbF == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hbF.optString("source");
            String optString2 = this.hbF.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hbF.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hbF.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.hbF.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bKC();
        } else if (this.hbs != null && this.hbs.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.hbs.getVideoPath();
                String d = com.baidu.live.q.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.hbs.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.q.h.aE(videoPath, d)) {
                    this.hbs.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.q.h.aD(videoPath, d)) {
                    this.hbs.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.bX(this.hbs)) {
                        ((ViewGroup) this.hbs.getParent()).removeView(this.hbs);
                        alaLiveRoomBlurPageLayout.a(this.hbs, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.hbw) {
                        this.hbs.c(alaLiveInfoData);
                        return;
                    } else {
                        this.hbs.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.hbs.cbS();
        } else if (this.hbs != null && this.hbs.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.hbs, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.hbw) {
                    this.hbs.c(alaLiveInfoData);
                } else {
                    this.hbs.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.hbs != null) {
            this.hbs.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = o.t(this.mTbPageContext.getPageActivity());
                layoutParams.height = o.u(this.mTbPageContext.getPageActivity());
                int aE = o.aE(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = aE + i;
                } else {
                    dimensionPixelSize = aE + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void cbw() {
        this.bkL = true;
    }

    public boolean cbx() {
        return this.bkL;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        a(UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()), alaLiveInfoData, z);
    }

    private void a(int i, AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
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
        if (z2) {
            if (realScreenOrientation == 1) {
                this.hbn.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.hbn.setBackgroundColor(0);
            }
        } else {
            this.hbn.setBackgroundColor(0);
        }
        int i3 = this.hbs.getLayoutParams().width;
        int i4 = this.hbs.getLayoutParams().height;
        int i5 = this.hbs.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.hbs.getLayoutParams()).topMargin : 0;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i3 || b.height != i4 || b.topMargin != i5) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.gFC != null) {
            this.gFC.setLayoutParams(c);
        }
        if (this.hbn != null) {
            this.hbn.D(screenFullSize[0], screenFullSize[1]);
        }
        if (this.hbB != null) {
            this.hbB.D(screenFullSize[0], screenFullSize[1]);
        }
        if (this.hbC != null) {
            this.hbC.l(c.width, c.height, realScreenOrientation);
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

    private void vp(int i) {
        boolean z = true;
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            this.hbn.setBgImageUrl(this.aAP.mLiveInfo.cover, this.aAP.mLiveInfo);
            this.hbp.a(this.mSelectedPosition, cbz(), this.aAP);
            this.hbp.b(this.mSelectedPosition, cbA(), this.aAP);
            this.hbn.requestLayout();
            this.hbn.K(i, this.aAP.mLiveInfo.screen_direction == 2);
        }
        if (this.aAP != null) {
            a(i, this.aAP.mLiveInfo, false);
        }
        boolean bYP = this.hbn.bYP();
        boolean z2 = i == 1;
        if (this.aAP == null || this.aAP.mLiveInfo == null || this.aAP.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!cbM()) {
            if (this.hbs != null && this.hbs.getParent() == null) {
                this.hbn.a(this.hbs, null, false);
                if (this.aAP != null && this.aAP.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.hbw) {
                        this.hbs.c(this.aAP.mLiveInfo);
                    } else {
                        this.hbs.setPlayLiveInfo(this.aAP.mLiveInfo);
                    }
                }
            }
            if (bYP && !cbM() && this.hbC != null) {
                this.hbn.mL(z);
                return;
            }
            return;
        }
        this.hbn.bYJ();
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
            this.gFj.a(alaLiveInfoData.live_id, true, this.bhq, this.mForumName, this.hbU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cby() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.hbo != null && this.gFC != null && this.mSelectedPosition != (currentItem = this.hbo.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.i.sdk_neterror);
                this.hbo.setCurrentItem(this.mSelectedPosition);
            } else if (!this.bkL && ListUtils.getCount(this.gFj.bXn()) <= 1) {
                this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                this.hbo.setCurrentItem(this.mSelectedPosition);
                this.gFj.g(this.gFj.bXx());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.gFj.bXs() && i < 0) {
                    this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                    this.hbo.setCurrentItem(this.mSelectedPosition);
                } else if (this.gFj.bXt() && i > 0) {
                    this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                    this.hbo.setCurrentItem(this.mSelectedPosition);
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.gFj.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    lQ(true);
                    this.hbn.bYJ();
                    this.hbn.Rb();
                    this.hbn.bYK();
                    if (this.gFj.Fq() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.gFj.Fq().mLiveInfo.live_id + "", this.gFj.Fq().mLiveInfo.room_id + "", this.gFj.Fq().aEz.userId + "", this.gFj.Fq().aEz.userName, System.currentTimeMillis(), this.gFj.Fq().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                            QMStaticManager.staticEndPlayTime(this.gFj.Fq().mLiveInfo.live_id + "", this.gFj.Fq().mLiveInfo.room_id + "", this.gFj.Fq().aEz.userId + "", this.gFj.Fq().aEz.userName, System.currentTimeMillis(), this.gFj.Fq().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.hbI != null) {
                        long j = this.gFj.Fq().mLiveInfo.live_id;
                        if (this.hbI.liveId == j && this.hbI.startTime > 0) {
                            this.hbI.endTime = System.currentTimeMillis();
                            long j2 = this.hbI.endTime - this.hbI.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hbI.roomId + "", this.hbI.vid, j2 / 1000, this.otherParams);
                        }
                        this.hbI = null;
                    }
                    cbO();
                    if (this.hcg != null) {
                        this.hcg.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.hbn = this.hbp.uB(this.mSelectedPosition);
                    this.hbn.bYN();
                    vq(i);
                    cbo();
                }
            }
        }
    }

    public void vq(int i) {
        if (i < 0) {
            this.gFj.uU(this.gFj.bXu() - 1);
        } else if (i > 0) {
            this.gFj.uU(this.gFj.bXu() + 1);
        }
        if (this.hbC != null) {
            this.hbC.a(this.hbn);
        }
        this.hbp.a(this.mSelectedPosition, cbz(), this.aAP);
        this.hbp.b(this.mSelectedPosition, cbA(), this.aAP);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.gFj != null) {
            int bXu = this.gFj.bXu();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bXu + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.gFj.bXn() != null && this.gFj.bXn().size() > bXu && this.gFj.bXn().get(bXu) != null) {
                AlaLiveInfoData alaLiveInfoData = this.gFj.bXn().get(bXu);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gFj != null) {
            AlaLiveInfoData bXx = this.gFj.bXx();
            if (bXx != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(bXx.live_id), String.valueOf(bXx.room_id), null, cbv());
                bXx.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bKC();
                }
                a(this.hbn, bXx, this.bkL);
                this.bkL = false;
                if (this.hbC != null) {
                    this.hbC.a(this.mTbPageContext, this.gFC, this.hbs, this.hbn, this.gFj, this.bhq, this.hby, this.gFI, null, this.hbR);
                    short s = 2;
                    if (bXx.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bXx, false);
            }
            i(bXx);
            this.hbn.a(this.gFC, null);
            if (this.hbC != null) {
                this.hbC.bPW();
            }
            this.gFj.g(bXx);
        }
    }

    private AlaLiveInfoData cbz() {
        List<AlaLiveInfoData> bXn = this.gFj.bXn();
        if (bXn == null || bXn.size() == 0) {
            if (this.aAP == null) {
                return null;
            }
            return this.aAP.mLiveInfo;
        }
        int bXu = this.gFj.bXu();
        int size = bXn.size();
        return bXn.get(((bXu + size) - 1) % size);
    }

    private AlaLiveInfoData cbA() {
        List<AlaLiveInfoData> bXn = this.gFj.bXn();
        if (bXn == null || bXn.size() == 0) {
            if (this.aAP == null) {
                return null;
            }
            return this.aAP.mLiveInfo;
        }
        return bXn.get((this.gFj.bXu() + 1) % bXn.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(int i, String str) {
        CustomResponsedMessage runTask;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hbw) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.i.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            mZ(false);
            return;
        }
        u Fq = this.gFj.Fq();
        E(Fq);
        this.gFj.bXo();
        if (this.bkL) {
            this.gFj.mE(false);
        }
        this.gFI = System.currentTimeMillis() / 1000;
        if (this.hbC != null) {
            this.hbC.a(this.mTbPageContext, this.gFC, this.hbs, this.hbn, this.gFj, this.bhq, this.hby, this.gFI, this.hbz, this.hbR);
            short s = 2;
            if (Fq.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        cbu();
        if (Fq != null && Fq.mLiveInfo != null && Fq.mLiveInfo.live_status == 2) {
            this.hbp.a(this.mSelectedPosition, this.gFj.Fq());
            d(Fq, false);
            this.bkL = false;
            return;
        }
        if (this.gGg == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.p.d.class)) != null) {
            this.gGg = (com.baidu.live.p.d) runTask.getData();
        }
        if (this.gGg != null) {
            this.gGg.ML();
        }
        boolean z = (this.hbC == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        w.e(Fq);
        if (z) {
            if (!this.hbN || !TextUtils.equals(p.PS(), this.hbO)) {
                w.b(getPageContext(), false);
                com.baidu.live.x.c.NS().NT();
                this.hbN = true;
                this.hbO = p.PS();
            }
            w.gz("");
            w.Fx();
        }
        if (!this.hbP) {
            this.hbP = true;
            com.baidu.live.entereffect.a.Dw().bi(false);
        }
        if (this.gFj.Fq() != null && this.gFj.Fq().mLiveInfo != null) {
            this.gFj.g(this.gFj.Fq().mLiveInfo.live_id, !this.hbJ);
            this.hbJ = true;
        }
        if (this.hbC != null) {
            this.hbC.b(this.hbt);
            this.hbC.lP(TextUtils.equals(this.hbA, "1"));
            this.hbA = "";
        }
        if (this.hbq != null) {
            this.hbq.a(this.aAP, this.hbr);
        }
        a(this.gFj.Fq());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.gFj.Fq() != null && b.this.gFj.Fq().mLiveInfo != null) {
                    b.this.gFj.a(b.this.gFj.Fq().mLiveInfo.live_id, b.this.bhq, b.this.gFI);
                }
            }
        });
        if (z && this.gFj.Fq() != null && this.gFj.Fq().aEz != null) {
            bj bjVar = com.baidu.live.x.a.NN().bmW;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bjVar != null && bjVar.aKT != null && bjVar.aKT.aMZ) {
                d(true, this.gFj.Fq().aEz.userId);
            }
        }
        this.bkL = false;
        if (z && this.gFj.Fq() != null && this.gFj.Fq().mLiveInfo != null && this.gFj.Fq().aEz != null && this.hbC != null) {
            long j = this.gFj.Fq().mLiveInfo.live_id;
            long j2 = this.gFj.Fq().mLiveInfo.room_id;
            String str2 = this.gFj.Fq().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (ad.FE() != null) {
                    ad.FE().bn(this.aZX);
                    if (!this.aZX) {
                        ad.FE().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.hcg != null) {
                    this.hcg.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (e.IO() != null) {
                e.IO().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.hbK == null) {
                this.hbK = new com.baidu.tieba.ala.liveroom.k.a();
                this.hbK.bn(this.aZX);
            }
            if (!this.aZX) {
                this.hbK.a(this.mTbPageContext.getPageActivity(), this.gFj.Fq(), this.otherParams);
            }
        }
        if (this.hbL == null) {
            this.hbL = new com.baidu.tieba.ala.liveroom.w.c(this.mTbPageContext);
            this.hbL.bn(this.aZX);
        }
        if (z && this.gFj.Fq() != null && this.gFj.Fq().aFb != null && !this.hbM) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.hbL.a(this.gFj.Fq(), this.gFj.Fq().aFb.userId);
                this.hbM = true;
            }
        }
        if (this.gFj.Fq() != null && this.gFj.Fq().mLiveInfo != null && this.gFj.Fq().aFb != null) {
            com.baidu.live.m.a.b(this.gFj.Fq().mLiveInfo.live_id, this.gFj.Fq().aFb.needRename == 1);
            if (z) {
                com.baidu.live.m.a.b(this.gFj.Fq().mLiveInfo.live_id, 0);
            }
        }
        if (this.gGh != null && this.gFj.Fq() != null && this.gFj.Fq().aEz != null) {
            this.gGh.aq(this.gFj.Fq().aEz.userId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbB() {
        if (this.hbu) {
            this.hbp.a(this.mSelectedPosition, cbz(), this.aAP);
            this.hbp.b(this.mSelectedPosition, cbA(), this.aAP);
            this.hbu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.hbw) {
            this.mHandler.removeCallbacks(this.hca);
            this.mHandler.postDelayed(this.hca, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(n nVar) {
        if (nVar == null) {
            if (!this.hbw) {
                this.mHandler.removeCallbacks(this.hbZ);
                this.mHandler.postDelayed(this.hbZ, 5000L);
                return;
            }
            return;
        }
        if (!this.hbv) {
            c(nVar);
        }
        if (!this.hbw) {
            this.mHandler.removeCallbacks(this.hbZ);
            this.mHandler.postDelayed(this.hbZ, nVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbC() {
        if (this.gFj.Fq() != null && this.gFj.Fq().mLiveInfo != null) {
            this.gFj.g(this.gFj.Fq().mLiveInfo.live_id, !this.hbJ);
            this.hbJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.live_status == 2) {
            this.hbp.a(this.mSelectedPosition, this.gFj.Fq());
            d(uVar, false);
        } else if (uVar != null) {
            if (!this.hbv) {
                w.e(uVar);
                a(uVar);
            }
            if (!this.hbw) {
                this.mHandler.removeCallbacks(this.gIM);
                this.mHandler.postDelayed(this.gIM, uVar.aEE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWS() {
        if (this.mTbPageContext != null && this.gFj.Fq() != null && this.gFj.Fq().mLiveInfo != null) {
            this.gFj.a(this.gFj.Fq().mLiveInfo.live_id, this.bhq, this.gFI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(u uVar, boolean z) {
        View view = null;
        lQ(true);
        if (!cbM()) {
            this.gFj.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.hbn != null) {
                this.hbn.Rb();
                this.hbn.bYJ();
                this.hbn.bYQ();
            }
            if (uVar != null && uVar.mLiveInfo != null) {
                this.hbE = uVar.mLiveInfo.live_id;
            }
            cbr();
            cbD();
            cbE();
            if (uVar != null) {
                if (this.hbC != null && this.hbC.bQc() != null) {
                    view = this.hbC.bQc().a(this.hbC.bPS().pageContext.getPageActivity(), uVar, z);
                }
                if (this.hbn != null) {
                    this.hbB.a(this.hbn, view, uVar, z, this.gFj.bXp());
                }
                if (this.hbC != null) {
                    this.hbC.lQ(false);
                    this.hbC.bPX();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.hbn != null) {
                    this.hbn.bYN();
                }
                long j = uVar.mLiveInfo.live_id;
                long j2 = uVar.mLiveInfo.room_id;
                String str = uVar.mLiveInfo.feed_id;
                long j3 = uVar.aEz.userId;
                String str2 = uVar.aEz.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.hbI = new StayTimeBean();
                this.hbI.liveId = uVar.mLiveInfo.live_id;
                this.hbI.roomId = uVar.mLiveInfo.room_id;
                this.hbI.vid = uVar.mLiveInfo.feed_id;
                this.hbI.startTime = System.currentTimeMillis();
            }
            cbO();
            if (this.hbq != null) {
                this.hbq.a(this.aAP, this.hbr);
            }
        }
    }

    private void cbD() {
    }

    private void cbE() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.hbo);
        }
    }

    public void cbF() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cbG();
        } else {
            cbH();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.gFj != null && this.gFj.Fq() != null) {
            alaLiveInfoData = this.gFj.Fq().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cbG();
        } else {
            cbH();
        }
        this.hbo.setIsScrollable(!z && this.hbS);
        if (this.hbC != null) {
            this.hbC.onKeyboardVisibilityChanged(z);
        }
        if (this.gFC != null) {
            this.gFC.onKeyboardVisibilityChanged(z);
        }
    }

    public void dD(int i) {
        if (i == 0) {
            i = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        }
        this.isLandscape = i == 2;
        if (isDebug()) {
            Log.d(TAG, "onScreenOrientationChanged: " + this.isLandscape);
        }
        this.isLandscape = i == 2;
        if (i == 2) {
            cbG();
        } else {
            cbH();
        }
        this.gFC.dD(i);
        vp(i);
        if (ad.FE() != null) {
            ad.FE().EW();
        }
        if (this.hbK != null) {
            this.hbK.EW();
        }
        if (this.hbq != null) {
            this.hbq.dD(i);
        }
    }

    public void cbG() {
        if (this.hbo != null) {
            i.aa(this.hbo);
        }
    }

    public void cbH() {
        if (this.hbo != null) {
            i.ab(this.hbo);
        }
    }

    private boolean cbI() {
        return this.hcc || this.hcd;
    }

    private void cbJ() {
        this.hcc = false;
        this.hcd = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.hbQ + " mWebOver=" + this.hbx + ", isFloatingMode=" + isFloatingMode());
        }
        cbJ();
        if (!this.hbx || !isFloatingMode()) {
            bKC();
            if (this.gFj != null) {
                this.gFj.bWZ();
                this.gFj.bXd();
            }
            if (this.hbC != null) {
                this.hbC.enterForeground();
            }
            if (this.hbK != null) {
                this.hbK.onResume();
            }
            if (this.hbL != null) {
                this.hbL.onResume();
            }
            com.baidu.live.core.layer.b.CA().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.hbQ + " mWebOver=" + this.hbx + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        cbJ();
        if ((!this.hbx || !isFloatingMode()) && !this.hbQ) {
            bKC();
            if (this.hbw) {
                this.hbw = false;
                cbK();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            cbo();
        }
    }

    public void cbK() {
        bWS();
        cbC();
        this.gFj.bXo();
        if (this.hbs.isPaused()) {
            this.hbs.resume();
        } else if (!this.hbs.isPlaying()) {
            cbq();
        }
        if (this.hbC != null) {
            this.hbC.bQb();
        }
        if (this.gFj != null && this.gFj.Fq() != null && this.gFj.Fq().mLiveInfo != null) {
            this.hbH.en(this.gFj.Fq().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aAP.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.hbx + ", isFloatingMode=" + isFloatingMode());
        }
        if (cbI() || !this.hbx || !isFloatingMode()) {
            if (this.gFj != null) {
                this.gFj.bXa();
                this.gFj.bXe();
            }
            if (this.hbC != null) {
                this.hbC.enterBackground();
            }
            com.baidu.live.core.layer.b.CA().onPause();
        }
    }

    public void Q(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.hbX);
        }
        if (!cbI() && z && !this.hbX && cbi()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0595a() { // from class: com.baidu.tieba.ala.player.b.13
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0595a
                    public boolean a(SdkLivePlayer sdkLivePlayer, JSONObject jSONObject) {
                        boolean z3;
                        boolean z4 = false;
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer2 back isStop:" + b.this.hbw);
                        }
                        if (b.this.cbj()) {
                            if (jSONObject != null) {
                                z3 = jSONObject.optInt("initiativeClose", 0) == 1;
                            } else {
                                z3 = true;
                            }
                            if (z3 || !b.this.hbw) {
                                z4 = true;
                            }
                            if (sdkLivePlayer != null && z4) {
                                sdkLivePlayer.aII();
                            }
                            if (!z4) {
                                b.this.cbL();
                            }
                        } else if (sdkLivePlayer != null) {
                            sdkLivePlayer.aII();
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
        this.hbw = true;
        na(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbL() {
        new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.14
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "restart floating:" + b.this.hbw);
                }
                if (b.this.hbw) {
                    b.this.cbp();
                }
            }
        }, 500L);
    }

    public void na(boolean z) {
        this.mHandler.removeCallbacks(this.gIM);
        this.mHandler.removeCallbacks(this.hbZ);
        this.mHandler.removeCallbacks(this.hca);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (!this.hbs.isFloatingMode()) {
                this.hbs.aII();
            }
        } else if (!z && !this.hbs.isFloatingMode()) {
            this.hbs.aII();
        }
        if (this.hbC != null) {
            this.hbC.bQa();
        }
        this.hbH.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ad.FE() != null) {
                ad.FE().a(i, i2, intent, this.aAP, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.hbC != null) {
            this.hbC.onActivityResult(i, i2, intent);
        }
    }

    public boolean cbM() {
        return this.hbB != null && this.hbB.bKs();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hcp != null) {
            MessageManager.getInstance().unRegisterListener(this.hcp);
        }
        if (this.hcq != null) {
            MessageManager.getInstance().unRegisterListener(this.hcq);
        }
        MessageManager.getInstance().unRegisterListener(this.hcr);
        MessageManager.getInstance().unRegisterListener(this.hcs);
        MessageManager.getInstance().unRegisterListener(this.hct);
        MessageManager.getInstance().unRegisterListener(this.hcu);
        MessageManager.getInstance().unRegisterListener(this.hcl);
        MessageManager.getInstance().unRegisterListener(this.grL);
        MessageManager.getInstance().unRegisterListener(this.hce);
        MessageManager.getInstance().unRegisterListener(this.hcf);
        MessageManager.getInstance().unRegisterListener(this.aYi);
        if (this.hcg != null) {
            this.hcg.release();
        }
        if (this.hbs != null && !this.hbs.isFloatingMode()) {
            this.hbs.ci(true);
        }
        if (this.hbq != null) {
            this.hbq.onDestory();
        }
        if (this.gGh != null) {
            this.gGh.release();
            this.gGh = null;
        }
        if (this.hbr != null) {
            this.hbr.reset();
        }
        if (this.hbC != null) {
            this.hbC.onDestroy();
        }
        if (this.hbp != null) {
            this.hbp.onDestroy();
        }
        this.hbn.Rb();
        if (this.hbn != null) {
            this.hbn.release();
            this.hbn = null;
        }
        if (this.hbB != null) {
            this.hbB.onDestroy();
        }
        if (this.hbI != null && this.gFj != null && this.gFj.Fq() != null) {
            long j = this.gFj.Fq().mLiveInfo.live_id;
            if (this.hbI.liveId == j && this.hbI.startTime > 0) {
                this.hbI.endTime = System.currentTimeMillis();
                long j2 = this.hbI.endTime - this.hbI.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hbI.roomId + "", this.hbI.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.hbI = null;
        }
        if (this.gFC != null) {
            this.gFC.bYS();
            this.gFC = null;
        }
        if (this.gFj != null) {
            this.gFj.destory();
        }
        if (this.gGg != null) {
            this.gGg.release();
        }
        com.baidu.live.entereffect.a.Dw().release();
        com.baidu.live.gift.u.Fk().release();
        if (this.hbL != null) {
            this.hbL.release();
        }
        s.Fi().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String KD() {
        return this.otherParams;
    }

    public void nb(boolean z) {
        this.hbQ = z;
    }

    public void cbN() {
        if (this.hbF != null) {
            this.otherParams = this.hbF.toString();
            if (this.gFj != null) {
                this.gFj.setOtherParams(this.otherParams);
            }
            if (this.hbC != null) {
                this.hbC.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.hbB != null) {
                this.hbB.setOtherParams(this.otherParams);
            }
        }
    }

    public void cbO() {
        if (this.hbF != null) {
            String optString = this.hbF.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hbF.put("tab", "live_jump");
                        this.hbF.put("tag", "");
                        this.hbF.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.hbF.put("tab", "liveroom");
                        this.hbF.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cbN();
            }
        }
    }

    private void d(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.IM();
        }
        bVar.af(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void cbP() {
        w.FA();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hbC.d(s);
        } else {
            this.hbC.e(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
