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
import com.baidu.live.aa.e;
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
import com.baidu.live.data.bn;
import com.baidu.live.data.bo;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.aj;
import com.baidu.live.gift.y;
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
    private static int hIx = 1;
    private static WeakReference<b> mRef;
    private w aDh;
    private com.baidu.live.s.b bFW;
    private CustomMessageListener bcy;
    private boolean bep;
    private long bmk;
    private String bml;
    private boolean bpT;
    private String gTP;
    CustomMessageListener gXI;
    private a hHO;
    private SafeFrameLayout hHP;
    private AlaLiveRoomBlurPageLayout hHQ;
    private AlaLoopViewPager hHR;
    private AlaLoopViewPagerAdapter hHS;
    private com.baidu.tieba.ala.liveroom.e.a hHT;
    private com.baidu.tieba.ala.liveroom.e.b hHU;
    private SdkLivePlayer hHV;
    private AlaLastLiveroomInfo hHW;
    private boolean hHX;
    private boolean hHY;
    private boolean hHZ;
    private Runnable hIA;
    private Runnable hIB;
    private Runnable hIC;
    private boolean hID;
    private boolean hIE;
    private CustomMessageListener hIF;
    private CustomMessageListener hIG;
    private com.baidu.live.ad.c hIH;
    private boolean hII;
    private boolean hIJ;
    private long hIK;
    private long hIL;
    private CustomMessageListener hIM;
    private com.baidu.live.s.a hIN;
    com.baidu.live.liveroom.a.c hIO;
    ViewPager.OnPageChangeListener hIP;
    HttpMessageListener hIQ;
    CustomMessageListener hIR;
    CustomMessageListener hIS;
    CustomMessageListener hIT;
    CustomMessageListener hIU;
    private CustomMessageListener hIV;
    private boolean hIa;
    @Deprecated
    private boolean hIb;
    private ArrayList<AlaBroadcastGiftToastData> hIc;
    private String hId;
    private com.baidu.tieba.ala.endliveroom.a hIe;
    private com.baidu.tieba.ala.liveroom.d.c hIf;
    private String hIg;
    private long hIh;
    private JSONObject hIi;
    private boolean hIj;
    private com.baidu.tieba.ala.liveroom.task.c hIk;
    private StayTimeBean hIl;
    private boolean hIm;
    private com.baidu.tieba.ala.liveroom.k.a hIn;
    private com.baidu.tieba.ala.liveroom.w.c hIo;
    private boolean hIp;
    private boolean hIq;
    private String hIr;
    private boolean hIs;
    private bo hIt;
    private boolean hIu;
    private boolean hIv;
    private int hIw;
    private boolean hIy;
    private boolean hIz;
    private com.baidu.tieba.ala.liveroom.q.d hkX;
    private d.a hlF;
    private com.baidu.live.r.d hlT;
    private com.baidu.live.r.c hlU;
    private AlaLiveView hlp;
    private ViewGroup hlq;
    private LayerRootView hlr;
    private long hlv;
    private Runnable hoA;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void cjy() {
        if (this.hIo != null) {
            this.hIo.bw(this.bep);
        }
        if (this.hIn != null) {
            this.hIn.bw(this.bep);
        }
        if (aj.GN() != null) {
            aj.GN().bw(this.bep);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hHX = true;
        this.hlv = 0L;
        this.hHY = false;
        this.bpT = true;
        this.bml = "";
        this.mForumName = "";
        this.hHZ = false;
        this.hIb = false;
        this.hId = "0";
        this.mHandler = new Handler();
        this.hIh = -1L;
        this.otherParams = "";
        this.hIj = false;
        this.hIk = com.baidu.tieba.ala.liveroom.task.c.cgJ();
        this.hIm = false;
        this.hIq = false;
        this.hIs = false;
        this.hIv = false;
        this.hIw = 0;
        this.hIy = false;
        this.hIz = false;
        this.hoA = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cfl();
            }
        };
        this.hIA = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjV();
            }
        };
        this.hIB = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.hkX.cfH();
            }
        };
        this.hIC = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.gXI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hID = true;
            }
        };
        this.hIF = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hIE = true;
            }
        };
        this.hIG = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.hIM = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bep = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.cjy();
            }
        };
        this.bcy = new CustomMessageListener(2501059) { // from class: com.baidu.tieba.ala.player.b.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_video_activity")) {
                    b.this.S(false, false);
                }
            }
        };
        this.bFW = new com.baidu.live.s.b() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.s.b
            public void dI(int i) {
                if (b.this.hIf != null) {
                    b.this.hIf.dI(i);
                }
            }
        };
        this.hIN = new com.baidu.live.s.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.s.a
            public void cp(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.hHV != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.hHV.isPlaying());
                        if (b.this.hHV.isPlaying()) {
                            if (b.this.hHV.isPaused()) {
                                b.this.hHV.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.hHV.isPlaying()) {
                        b.this.hHV.pause();
                    }
                }
            }
        };
        this.hIO = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void cg(boolean z) {
                if (z || b.this.hIf == null || b.this.hIf.bYk()) {
                    if (!b.this.cjG() || b.this.a(true, (a.InterfaceC0640a) null)) {
                        b.this.hIz = true;
                        b.this.of(true);
                        b.this.bVv();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void ch(boolean z) {
                b.this.d(b.this.aDh, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.hHV.ckm();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.hHZ) {
                    if (b.this.hHZ) {
                        b.this.hHV.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.hHV.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.hHR != null) {
                    b.this.hHR.setIsScrollable(b.this.hIu && z);
                    b.this.hHR.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void ci(boolean z) {
                boolean z2 = true;
                if (!z || b.this.cke()) {
                    if (b.this.hHQ != null) {
                        b.this.hHQ.chm();
                        return;
                    }
                    return;
                }
                if (b.this.hkX.Gz().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.hHQ != null) {
                    b.this.hHQ.nO(z2);
                }
            }
        };
        this.hIP = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.hHR != null && i == 0) {
                    b.this.cjR();
                    com.baidu.live.d.Aq().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.hlF = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.q.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.K(b.this.hkX.Gz());
                } else if (i2 == 2) {
                    b.this.f(b.this.hkX.bQJ());
                } else if (i2 == 3) {
                    b.this.bp(i, str2);
                } else if (i2 == 4) {
                    b.this.aH(obj);
                } else if (i2 == 5) {
                    b.this.cjU();
                }
            }
        };
        this.hIQ = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.cgH() != null && b.this.mTbPageContext != null) {
                        b.this.hIk.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.cgH());
                    }
                }
            }
        };
        this.hIR = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
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
        this.hIS = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.hkX != null && b.this.hkX.Gz() != null && b.this.hkX.Gz().mLiveInfo != null) {
                    long j = b.this.hkX.Gz().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.hIH != null) {
                        b.this.hIH.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.hIT = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.hkX != null && b.this.hkX.Gz() != null && b.this.hkX.Gz().aHG != null) {
                        if (l.longValue() == b.this.hkX.Gz().aHG.userId) {
                            b.this.hkX.Gz().aHG.isNewUser = false;
                            if (b.this.hIn != null) {
                                b.this.hIn.n(b.this.hkX.Gz());
                            }
                        }
                    }
                }
            }
        };
        this.hIU = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.u.a)) {
                    com.baidu.tieba.ala.liveroom.u.a aVar2 = (com.baidu.tieba.ala.liveroom.u.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String Dz = aVar2.Dz();
                    if (b.this.mTbPageContext != null && b.this.hkX != null && b.this.hkX.Gz() != null && b.this.hkX.Gz().aHG != null) {
                        if (valueOf.longValue() == b.this.hkX.Gz().aHG.userId && com.baidu.live.aa.a.Ph().bsh != null && com.baidu.live.aa.a.Ph().bsh.aNK != null && com.baidu.live.aa.a.Ph().bsh.aNK.Eh()) {
                            g.we(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, Dz));
                        }
                    }
                }
            }
        };
        this.hIV = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.hoA != null) {
                    b.this.mHandler.removeCallbacks(b.this.hoA);
                }
                b.this.cfl();
            }
        };
        this.hlv = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.hHO = aVar;
        this.hHX = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ad.c.class);
        if (runTask != null) {
            this.hIH = (com.baidu.live.ad.c) runTask.getData();
        }
        this.hkX = new com.baidu.tieba.ala.liveroom.q.d(getPageContext());
        this.hkX.a(this.hlF);
        this.hkX.HP(str);
        this.hIe = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hIQ);
        MessageManager.getInstance().registerListener(this.hIR);
        MessageManager.getInstance().registerListener(this.hIS);
        MessageManager.getInstance().registerListener(this.hIT);
        MessageManager.getInstance().registerListener(this.hIU);
        MessageManager.getInstance().registerListener(this.hIV);
        MessageManager.getInstance().registerListener(this.hIM);
        MessageManager.getInstance().registerListener(this.gXI);
        MessageManager.getInstance().registerListener(this.hIF);
        MessageManager.getInstance().registerListener(this.hIG);
        MessageManager.getInstance().registerListener(this.bcy);
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.hIc = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hIc.add(alaBroadcastGiftToastData);
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
        this.bml = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bml)) {
            this.bml = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        if (z) {
            this.hIg = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.hIg = intent.getStringExtra("room_id");
        }
        this.bmk = intent.getLongExtra("live_id", 0L);
        this.hIj = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.hkX.b((AlaLiveInfoCoreData) serializableExtra);
            this.hIj = true;
        }
        this.hkX.setIsMixLive(z);
        TbConfig.liveScene = 1;
        c(intent, z);
        this.hIu = this.hIt == null || !this.hIt.aOa;
        this.hIe.setOtherParams(this.otherParams);
        od(z);
        cjz();
        this.mHandler.removeCallbacks(this.hIC);
        this.mHandler.postDelayed(this.hIC, 1000L);
    }

    private void c(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.hIw = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.gTP = null;
            if (z) {
                stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_EXTRA_PARAMS);
            } else {
                stringExtra = intent.getStringExtra("params");
            }
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hIi = new JSONObject(stringExtra);
                if (this.hIi != null) {
                    String optString2 = this.hIi.optString("enterRoomId");
                    String optString3 = this.hIi.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hIg, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bmk + "", optString3))) {
                        String optString4 = this.hIi.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString5 = this.hIi.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString5);
                        if (!this.hIj) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bmk;
                            alaLiveInfoCoreData.screenDirection = this.hIi.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.hkX.b(alaLiveInfoCoreData);
                            this.hIj = true;
                        }
                    }
                    String optString6 = this.hIi.optString("extra");
                    try {
                        this.hIK = Long.parseLong(this.hIg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.hIL = this.bmk;
                    if (TextUtils.isEmpty(optString6)) {
                        this.hIt = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.hkX != null) {
                            this.hkX.Hm(optString7);
                        }
                        this.hII = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.hIJ = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.gTP = jSONObject.optString("live_back_scheme");
                        this.hIt = new bo();
                        this.hIt.aOa = jSONObject.optInt("is_hot") == 1;
                        if (this.hIt.aOa) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hIw = AlaLiveSwitchData.isHotLive;
                        this.hIt.aOb = jSONObject.optString("task_id");
                        this.hIt.aNZ = !TextUtils.isEmpty(this.hIt.aOb);
                        this.hIt.aOc = jSONObject.optInt("task_type");
                        this.hIt.aOd = jSONObject.optInt("task_im_count");
                        this.hIt.aOe = jSONObject.optLong("task_gift_total_price");
                        this.hIt.aOf = jSONObject.optLong("task_watch_time");
                        this.hIt.aOg = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.hIi.put("from", optString);
                        }
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.hHU = new com.baidu.tieba.ala.liveroom.e.b();
                            this.hHU.setScheme(optString8);
                            this.hHU.setImageUrl(optString9);
                            this.hHU.setTitle(optString10);
                        }
                    }
                    this.hId = this.hIi.optString("open_giftlist");
                    this.hIi.remove("cover");
                    this.hIi.remove("live_url");
                    this.hIi.remove("enterRoomId");
                    this.hIi.remove("enterLiveId");
                    this.hIi.remove("open_giftlist");
                    this.hIi.remove("extra");
                    this.otherParams = this.hIi.toString();
                    if (this.hkX != null) {
                        this.hkX.setOtherParams(this.otherParams);
                    }
                    this.hIi.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIi.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIi.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIi.optString("source");
                    }
                    this.hIv = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hIi.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.hkX != null) {
                        this.hkX.wD(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hHW = new AlaLastLiveroomInfo();
                this.hHW.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bmk), String.valueOf(this.hIg), null, cjO(), this.hHO != null ? this.hHO.cjv() : false);
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

    public void cjz() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.hkX.ar(this.uk, this.bml, this.mForumName);
        } else if (this.hkX.Gz() != null && this.hkX.Gz().mLiveInfo != null && this.hkX.Gz().mLiveInfo.live_id > 0) {
            this.hkX.a(this.hkX.Gz().mLiveInfo.live_id, false, this.bml, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bml = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                of(false);
                return;
            }
            this.hkX.ar(this.uk, this.bml, this.mForumName);
        } else if (!TextUtils.isEmpty(this.hIg)) {
            this.hkX.HO(this.hIg);
        } else if (this.bmk > 0) {
            this.hkX.a(this.bmk, false, this.bml, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            of(false);
        }
    }

    private void od(boolean z) {
        this.bpT = true;
        this.hHY = false;
        oe(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.Do().j(this.hlr);
        this.hIf = new com.baidu.tieba.ala.liveroom.d.c();
        this.hIf.a(this.hIO);
        this.hIf.setOtherParams(this.otherParams);
        this.hIf.mN(this.hIv);
        this.hIf.a(this.hHO.cjw());
        cjC();
        cjA();
        cjB();
    }

    private void oe(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_main_layout, (ViewGroup) null);
        this.hHP = (SafeFrameLayout) inflate.findViewById(a.f.live_root_view);
        this.hHR = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.hHR.setOnPageChangeListener(this.hIP);
        this.hHR.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void ccW() {
                b.this.cjR();
            }
        });
        this.hHR.setBoundaryCaching(true);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.hHS = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.hHS.ccU();
        this.hHQ = this.hHS.wk(this.mSelectedPosition);
        this.hHS.a(this.mSelectedPosition, this.hkX.Gz());
        this.hHR.setAdapter(this.hHS);
        this.hHR.setCurrentItem(this.mSelectedPosition);
        this.hHR.setIsScrollable(this.hIu);
        this.hHR.setIsMixLive(z);
        this.hlq = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hlr = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
    }

    private void c(Rect rect) {
        this.hHV = SdkLivePlayer.ff(getPageContext().getPageActivity());
        if (this.hHV == null) {
            this.hHR.setIsScrollable(false);
            if (this.hkX != null) {
                this.hkX.cancelLoadData();
            }
            ccY();
            return;
        }
        this.hHV.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.c.sdk_transparent));
        this.hHV.setIPlayerCallBack(this.bFW);
        this.hHV.setIPlayerAudioFocusCallBack(this.hIN);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hHQ.a(this.hHV, layoutParams, true);
    }

    private void cjA() {
        this.hHT = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.hlq);
    }

    private void cjB() {
        CustomResponsedMessage runTask;
        if (this.hlU == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.r.c.class)) != null) {
            this.hlU = (com.baidu.live.r.c) runTask.getData();
        }
        if (this.hlU != null) {
            this.hlU.setParentView(this.hlq);
        }
    }

    private void ccY() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.of(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.hlp = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.ala_liveroom_player_layout, null);
        this.hlp.setSwipeClearEnable(true);
        this.hlp.hvO = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hHQ.a(this.hlp, layoutParams);
    }

    private void cjC() {
        if (this.hkX != null && this.hkX.Gz() != null) {
            this.aDh = this.hkX.Gz();
            if (this.aDh.mLiveInfo != null) {
                a(this.aDh.mLiveInfo, this.hIj);
                if (this.aDh.mLiveInfo != null && this.aDh.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hHZ);
                    }
                    if (!this.hHZ) {
                        this.hHV.c(this.aDh.mLiveInfo);
                    } else {
                        this.hHV.setPlayLiveInfo(this.aDh.mLiveInfo);
                    }
                    if (this.hIf != null) {
                        this.hIf.a(this.mTbPageContext, this.hlp, this.hHV, this.hHQ, this.hkX, this.bml, this.hIb, this.hlv, this.hIc, this.hIt, this.hHR);
                        k(this.aDh.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean cjD() {
        boolean z;
        AlaLiveInfoData cfQ;
        if (this.hHO.cjv()) {
            return false;
        }
        if (this.hkX == null || (cfQ = this.hkX.cfQ()) == null || cfQ.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !cfQ.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.hIK + ", getPlayingRoomID:" + cjE() + ", mSchemeLiveId:" + this.hIL + ", getPlayingLiveID:" + cjF());
        }
        return z || cjH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cjE() {
        AlaLiveInfoData cfQ;
        if (this.hkX == null || (cfQ = this.hkX.cfQ()) == null) {
            return 0L;
        }
        return cfQ.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cjF() {
        AlaLiveInfoData cfQ;
        if (this.hkX == null || (cfQ = this.hkX.cfQ()) == null) {
            return 0L;
        }
        return cfQ.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cjG() {
        boolean z = false;
        if (!this.hHO.cjv()) {
            if (this.hII && (this.hIK == cjE() || this.hIL == cjF())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean cjH() {
        boolean z = this.hIJ && (this.hIK == cjE() || this.hIL == cjF());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean cjI() {
        if (hIx <= 0) {
            return false;
        }
        if (!(cjG() || cjD()) || FloatPermissionUtil.Ng()) {
            return false;
        }
        hIx--;
        FloatPermissionUtil.ak(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0640a interfaceC0640a) {
        if (!FloatPermissionUtil.Ng()) {
            if (this.hIy) {
                return true;
            }
            this.hIy = true;
            if (z) {
                FloatPermissionUtil.ak(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (cjG()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.hIJ) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a fa = com.baidu.tieba.ala.floating.b.fa(getPageContext().getPageActivity());
        fa.a(interfaceC0640a);
        fa.dz(jSONObject);
        com.baidu.tieba.ala.floating.b.fa(getPageContext().getPageActivity()).a(this.hHV, this.hkX.Gz(), this.bml, this.hlv);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bRK() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bRF = com.baidu.tieba.ala.floating.b.bRF();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0640a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0640a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bRF == null || bRF.room_id == b.this.cjE() || bRF.live_id == b.this.cjF()) {
                    if (b.this.hHV != null) {
                        b.this.cjJ();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.hHZ);
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
    public void cjJ() {
        ArrayList arrayList = (ArrayList) this.hHV.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.hHV.ckl();
            this.hHV.ak(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bRI();
    }

    public void ob(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.hIa = z;
    }

    private void cjK() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hIu) {
                this.hHR.setIsScrollable(true);
            } else {
                this.hHR.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Do().onBackPressed() && ((this.hIf == null || !this.hIf.onKeyDown(i, keyEvent)) && (this.hIf == null || !this.hIf.bYj()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cjK();
            } else if ((this.hIf == null || this.hIf.bYk()) && (!cjG() || a(true, (a.InterfaceC0640a) null))) {
                this.hIz = true;
                of(true);
                bVv();
            }
        }
        return true;
    }

    public void bVv() {
        if (!TextUtils.isEmpty(this.gTP)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gTP);
                this.gTP = null;
            }
        }
    }

    public void of(boolean z) {
        S(z, false);
    }

    public void S(boolean z, boolean z2) {
        mS(!z);
        if (this.hHV != null && !this.hHV.isFloatingMode()) {
            this.hHV.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.Do().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cjM();
        long j = -1;
        if (this.hkX != null && this.hkX.cfQ() != null) {
            j = this.hkX.cfQ().room_id;
        }
        this.hHO.b(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void mS(boolean z) {
        if (this.hHO.cjv() && this.hHO.cjw() != null) {
            this.hHO.cjw().A("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hHW = null;
        if (aj.GN() != null) {
            aj.GN().GM();
        }
        com.baidu.live.core.layer.b.Do().Dp();
        if (this.hIH != null) {
            this.hIH.release();
        }
        if (this.hIn != null) {
            this.hIn.release();
        }
        this.hIt = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.hkX != null) {
            try {
                this.hkX.Hm(null);
                AlaLiveInfoData cfQ = this.hkX.cfQ();
                if (cfQ != null) {
                    this.hkX.eZ(cfQ.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.hIk.stopRecord();
        LiveTimerManager.getInstance().stop();
        cjL();
        if (this.hHV != null && !this.hHV.isFloatingMode()) {
            this.hHV.cq(z);
        }
        if (this.hIf != null) {
            this.hIf.mS(z);
        }
        this.hIm = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.ML().blB != null && this.aDh != null) {
            com.baidu.live.liveroom.a.b.ML().blB.b(this.aDh.mLiveInfo);
        }
        aa.gX("");
        com.baidu.live.gift.w.Gr().release();
        if (this.hlU != null) {
            this.hlU.GK();
        }
    }

    private void cjL() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cjM() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(w wVar) {
        if (wVar != null) {
            this.aDh = wVar;
            if (this.hIf != null) {
                this.hIf.a(wVar);
            }
            cjI();
        }
    }

    private void c(q qVar) {
        if (this.hIf != null) {
            this.hIf.c(qVar);
        }
    }

    private void N(w wVar) {
        this.aDh = wVar;
        cjI();
    }

    private void cjN() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.hIu = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.hIu = true;
        }
        this.hHR.setIsScrollable(this.hIu);
        this.hIw = AlaLiveSwitchData.isHotLive;
        if (this.aDh != null) {
            a(this.aDh.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.hHQ.a(this.hlp, null);
            if (!isFloatingMode()) {
                a(this.hHQ, this.aDh.mLiveInfo, this.bpT);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aDh.mLiveInfo.live_id), String.valueOf(this.aDh.mLiveInfo.room_id), String.valueOf(this.aDh.mLiveInfo.feed_id), cjO(), this.hHO != null ? this.hHO.cjv() : false);
            if (com.baidu.live.liveroom.a.b.ML().blB != null) {
                com.baidu.live.liveroom.a.b.ML().blB.a(this.aDh.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.bpT = false;
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.hkX != null && this.hkX.Gz() != null && this.hkX.Gz().mLiveInfo != null) {
                    j = this.hkX.Gz().mLiveInfo.live_id;
                    str2 = this.hkX.Gz().mLiveInfo.room_id + "";
                    str = this.hkX.Gz().mLiveInfo.feed_id;
                } else {
                    if (this.bmk > 0) {
                        j2 = this.bmk;
                    }
                    if (!TextUtils.isEmpty(this.hIg)) {
                        j = j2;
                        str = "";
                        str2 = this.hIg;
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
                if (this.hkX != null && this.hkX.Gz() != null && this.hkX.Gz().mLiveInfo != null) {
                    str3 = this.hkX.Gz().mLiveInfo.feed_id;
                    str4 = this.hkX.Gz().mLiveInfo.live_id + "";
                    str5 = this.hkX.Gz().mLiveInfo.room_id + "";
                    str6 = this.hkX.Gz().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            cjI();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String cjO() {
        if (this.hIi == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hIi.optString("source");
            String optString2 = this.hIi.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hIi.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hIi.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.hIi.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bRK();
        } else if (this.hHV != null && this.hHV.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.hHV.getVideoPath();
                String d = com.baidu.live.s.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.hHV.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.s.h.aJ(videoPath, d)) {
                    this.hHV.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.s.h.aI(videoPath, d)) {
                    this.hHV.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.cn(this.hHV)) {
                        ((ViewGroup) this.hHV.getParent()).removeView(this.hHV);
                        alaLiveRoomBlurPageLayout.a(this.hHV, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.hHZ) {
                        this.hHV.c(alaLiveInfoData);
                        return;
                    } else {
                        this.hHV.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.hHV.ckl();
        } else if (this.hHV != null && this.hHV.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.hHV, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.hHZ) {
                    this.hHV.c(alaLiveInfoData);
                } else {
                    this.hHV.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.hHV != null) {
            this.hHV.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = o.u(this.mTbPageContext.getPageActivity());
                layoutParams.height = o.v(this.mTbPageContext.getPageActivity());
                int aI = o.aI(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = aI + i;
                } else {
                    dimensionPixelSize = aI + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
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

    public void cjP() {
        this.bpT = true;
    }

    public boolean cjQ() {
        return this.bpT;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        a(UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()), alaLiveInfoData, z);
    }

    private void a(int i, AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (this.hHV != null) {
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
            if (this.hHQ != null) {
                this.hHQ.setBackgroundColor(0);
            }
            int i3 = this.hHV.getLayoutParams().width;
            int i4 = this.hHV.getLayoutParams().height;
            int i5 = this.hHV.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.hHV.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i3 || b.height != i4 || b.topMargin != i5) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.hlp != null) {
                this.hlp.setLayoutParams(c);
            }
            if (this.hHQ != null) {
                this.hHQ.D(screenFullSize[0], screenFullSize[1]);
            }
            if (this.hIe != null) {
                this.hIe.D(screenFullSize[0], screenFullSize[1]);
            }
            if (this.hIf != null) {
                this.hIf.l(c.width, c.height, realScreenOrientation);
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

    private void xa(int i) {
        boolean z = true;
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            if (this.hHQ != null) {
                this.hHQ.setBgImageUrl(this.aDh.mLiveInfo.cover, this.aDh.mLiveInfo);
            }
            this.hHS.a(this.mSelectedPosition, cjS(), this.aDh);
            this.hHS.b(this.mSelectedPosition, cjT(), this.aDh);
            if (this.hHQ != null) {
                this.hHQ.requestLayout();
                this.hHQ.M(i, this.aDh.mLiveInfo.screen_direction == 2);
            }
        }
        if (this.aDh != null) {
            a(i, this.aDh.mLiveInfo, false);
        }
        boolean chn = this.hHQ.chn();
        boolean z2 = i == 1;
        if (this.aDh == null || this.aDh.mLiveInfo == null || this.aDh.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!cke()) {
            if (this.hHV != null && this.hHV.getParent() == null) {
                this.hHQ.a(this.hHV, null, false);
                if (this.aDh != null && this.aDh.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.hHZ) {
                        this.hHV.c(this.aDh.mLiveInfo);
                    } else {
                        this.hHV.setPlayLiveInfo(this.aDh.mLiveInfo);
                    }
                }
            }
            if (chn && !cke() && this.hIf != null) {
                this.hHQ.nO(z);
                return;
            }
            return;
        }
        this.hHQ.chj();
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
            this.hkX.a(alaLiveInfoData.live_id, true, this.bml, this.mForumName, this.hIw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjR() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.hHR != null && this.hlp != null && this.mSelectedPosition != (currentItem = this.hHR.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.h.sdk_neterror);
                this.hHR.setCurrentItem(this.mSelectedPosition);
            } else if (!this.bpT && ListUtils.getCount(this.hkX.cfG()) <= 1) {
                this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                this.hHR.setCurrentItem(this.mSelectedPosition);
                this.hkX.g(this.hkX.cfQ());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.hkX.cfL() && i < 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                    this.hHR.setCurrentItem(this.mSelectedPosition);
                } else if (this.hkX.cfM() && i > 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                    this.hHR.setCurrentItem(this.mSelectedPosition);
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.hkX.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    mS(true);
                    this.hHQ.chj();
                    this.hHQ.VJ();
                    this.hHQ.chk();
                    if (this.hkX.Gz() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.hkX.Gz().mLiveInfo.live_id + "", this.hkX.Gz().mLiveInfo.room_id + "", this.hkX.Gz().aHk.userId + "", this.hkX.Gz().aHk.userName, System.currentTimeMillis(), this.hkX.Gz().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.hkX.Gz().mLiveInfo.live_id + "", this.hkX.Gz().mLiveInfo.room_id + "", this.hkX.Gz().aHk.userId + "", this.hkX.Gz().aHk.userName, System.currentTimeMillis(), this.hkX.Gz().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.hIl != null) {
                        long j = this.hkX.Gz().mLiveInfo.live_id;
                        if (this.hIl.liveId == j && this.hIl.startTime > 0) {
                            this.hIl.endTime = System.currentTimeMillis();
                            long j2 = this.hIl.endTime - this.hIl.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hIl.roomId + "", this.hIl.vid, j2 / 1000, this.otherParams);
                        }
                        this.hIl = null;
                    }
                    ckg();
                    if (this.hIH != null) {
                        this.hIH.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.hHQ = this.hHS.wl(this.mSelectedPosition);
                    this.hHQ.chl();
                    xb(i);
                    cjI();
                }
            }
        }
    }

    public void xb(int i) {
        if (i < 0) {
            this.hkX.wE(this.hkX.cfN() - 1);
        } else if (i > 0) {
            this.hkX.wE(this.hkX.cfN() + 1);
        }
        if (this.hIf != null) {
            this.hIf.a(this.hHQ);
        }
        this.hHS.a(this.mSelectedPosition, cjS(), this.aDh);
        this.hHS.b(this.mSelectedPosition, cjT(), this.aDh);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.hkX != null) {
            int cfN = this.hkX.cfN();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", cfN + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.hkX.cfG() != null && this.hkX.cfG().size() > cfN && this.hkX.cfG().get(cfN) != null) {
                AlaLiveInfoData alaLiveInfoData = this.hkX.cfG().get(cfN);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hkX != null) {
            AlaLiveInfoData cfQ = this.hkX.cfQ();
            if (cfQ != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(cfQ.live_id), String.valueOf(cfQ.room_id), null, cjO(), this.hHO != null ? this.hHO.cjv() : false);
                cfQ.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bRK();
                }
                a(this.hHQ, cfQ, this.bpT);
                this.bpT = false;
                if (this.hIf != null) {
                    this.hIf.a(this.mTbPageContext, this.hlp, this.hHV, this.hHQ, this.hkX, this.bml, this.hIb, this.hlv, null, this.hIt, this.hHR);
                    short s = 2;
                    if (cfQ.screen_direction == 2) {
                        s = 1;
                    }
                    k(s);
                }
                a(cfQ, false);
            }
            i(cfQ);
            this.hHQ.a(this.hlp, null);
            if (this.hIf != null) {
                this.hIf.bYh();
            }
            this.hkX.g(cfQ);
        }
    }

    private AlaLiveInfoData cjS() {
        List<AlaLiveInfoData> cfG = this.hkX.cfG();
        if (cfG == null || cfG.size() == 0) {
            if (this.aDh == null) {
                return null;
            }
            return this.aDh.mLiveInfo;
        }
        int cfN = this.hkX.cfN();
        int size = cfG.size();
        return cfG.get(((cfN + size) - 1) % size);
    }

    private AlaLiveInfoData cjT() {
        List<AlaLiveInfoData> cfG = this.hkX.cfG();
        if (cfG == null || cfG.size() == 0) {
            if (this.aDh == null) {
                return null;
            }
            return this.aDh.mLiveInfo;
        }
        return cfG.get((this.hkX.cfN() + 1) % cfG.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i, String str) {
        CustomResponsedMessage runTask;
        TbConfig.liveScene = 1;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hHZ) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            of(false);
            return;
        }
        w Gz = this.hkX.Gz();
        N(Gz);
        this.hkX.cfH();
        if (this.bpT) {
            this.hkX.nG(false);
        }
        this.hlv = System.currentTimeMillis() / 1000;
        if (this.hIf != null) {
            this.hIf.a(this.mTbPageContext, this.hlp, this.hHV, this.hHQ, this.hkX, this.bml, this.hIb, this.hlv, this.hIc, this.hIt, this.hHR);
            short s = 2;
            if (Gz.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            k(s);
        }
        if (this.hHO.cjw() != null && this.hHO.cjv()) {
            this.hHO.cjw().A("load_finish", null);
            if (Gz.mLiveInfo.screen_direction == 2) {
                this.hHO.cjw().A("screen_auto_rotate", true);
            } else {
                this.hHO.cjw().A("screen_auto_rotate", false);
            }
        }
        cjN();
        if (Gz != null && Gz.mLiveInfo != null && Gz.mLiveInfo.live_status == 2) {
            this.hHS.a(this.mSelectedPosition, this.hkX.Gz());
            d(Gz, false);
            this.bpT = false;
            return;
        }
        if (this.hlT == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.r.d.class)) != null) {
            this.hlT = (com.baidu.live.r.d) runTask.getData();
        }
        if (this.hlT != null) {
            this.hlT.Of();
        }
        boolean z = (this.hIf == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ac.a.b.PO().cA(com.baidu.live.aa.a.Ph().bms != null && com.baidu.live.aa.a.Ph().bms.aLO && Gz != null && Gz.aId);
        aa.d(Gz);
        if (z) {
            if (!this.hIq || !TextUtils.equals(p.Uc(), this.hIr)) {
                aa.b(getPageContext(), false);
                e.Pv().Pw();
                this.hIq = true;
                this.hIr = p.Uc();
            }
            aa.gX("");
            aa.GG();
        }
        if (this.hkX.Gz() != null && this.hkX.Gz().mLiveInfo != null) {
            this.hkX.h(this.hkX.Gz().mLiveInfo.live_id, !this.hIm);
            this.hIm = true;
        }
        if (this.hIf != null) {
            this.hIf.b(this.hHW);
            this.hIf.mR(TextUtils.equals(this.hId, "1"));
            this.hId = "";
        }
        if (this.hHT != null) {
            this.hHT.a(this.aDh, this.hHU);
        }
        a(this.hkX.Gz());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.hkX.Gz() != null && b.this.hkX.Gz().mLiveInfo != null) {
                    b.this.hkX.a(b.this.hkX.Gz().mLiveInfo.live_id, b.this.bml, b.this.hlv);
                }
            }
        });
        if (z && this.hkX.Gz() != null && this.hkX.Gz().aHk != null) {
            bn bnVar = com.baidu.live.aa.a.Ph().bsh;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bnVar != null && bnVar.aNP != null && bnVar.aNP.aQf) {
                f(true, this.hkX.Gz().aHk.userId);
            }
        }
        this.bpT = false;
        if (z && this.hkX.Gz() != null && this.hkX.Gz().mLiveInfo != null && this.hkX.Gz().aHk != null && this.hIf != null) {
            long j = this.hkX.Gz().mLiveInfo.live_id;
            long j2 = this.hkX.Gz().mLiveInfo.room_id;
            String str2 = this.hkX.Gz().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (aj.GN() != null) {
                    aj.GN().bw(this.bep);
                    if (!this.bep) {
                        aj.GN().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.hIH != null) {
                    this.hIH.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.JV() != null) {
                com.baidu.live.guardclub.e.JV().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.hIn == null) {
                this.hIn = new com.baidu.tieba.ala.liveroom.k.a();
                this.hIn.bw(this.bep);
            }
            if (!this.bep) {
                this.hIn.a(this.mTbPageContext.getPageActivity(), this.hkX.Gz(), this.otherParams);
            }
        }
        if (this.hIo == null) {
            this.hIo = new com.baidu.tieba.ala.liveroom.w.c(this.mTbPageContext);
            this.hIo.bw(this.bep);
        }
        if (z && this.hkX.Gz() != null && this.hkX.Gz().aHG != null && !this.hIp) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.hIo.a(this.hkX.Gz(), this.hkX.Gz().aHG.userId);
                this.hIp = true;
            }
        }
        if (this.hkX.Gz() != null && this.hkX.Gz().mLiveInfo != null && this.hkX.Gz().aHG != null) {
            com.baidu.live.n.a.b(this.hkX.Gz().mLiveInfo.live_id, this.hkX.Gz().aHG.needRename == 1);
            if (z) {
                com.baidu.live.n.a.b(this.hkX.Gz().mLiveInfo.live_id, 0);
            }
        }
        if (this.hlU != null && this.hkX.Gz() != null && this.hkX.Gz().aHk != null) {
            this.hlU.aF(this.hkX.Gz().aHk.userId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjU() {
        if (this.hHX) {
            this.hHS.a(this.mSelectedPosition, cjS(), this.aDh);
            this.hHS.b(this.mSelectedPosition, cjT(), this.aDh);
            this.hHX = false;
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
        if (!this.hHZ) {
            this.mHandler.removeCallbacks(this.hIB);
            this.mHandler.postDelayed(this.hIB, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (qVar == null) {
            if (!this.hHZ) {
                this.mHandler.removeCallbacks(this.hIA);
                this.mHandler.postDelayed(this.hIA, 5000L);
                return;
            }
            return;
        }
        if (!this.hHY) {
            c(qVar);
        }
        if (!this.hHZ) {
            this.mHandler.removeCallbacks(this.hIA);
            this.mHandler.postDelayed(this.hIA, qVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjV() {
        if (this.hkX.Gz() != null && this.hkX.Gz().mLiveInfo != null) {
            this.hkX.h(this.hkX.Gz().mLiveInfo.live_id, !this.hIm);
            this.hIm = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_status == 2) {
            this.hHS.a(this.mSelectedPosition, this.hkX.Gz());
            d(wVar, false);
        } else if (wVar != null) {
            if (!this.hHY) {
                aa.d(wVar);
                a(wVar);
            }
            if (!this.hHZ) {
                this.mHandler.removeCallbacks(this.hoA);
                this.mHandler.postDelayed(this.hoA, wVar.aHp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfl() {
        if (this.mTbPageContext != null && this.hkX.Gz() != null && this.hkX.Gz().mLiveInfo != null) {
            this.hkX.a(this.hkX.Gz().mLiveInfo.live_id, this.bml, this.hlv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar, boolean z) {
        String str;
        mS(true);
        if (!cke()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cgg().nI(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cgg().release();
            this.hkX.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.hHQ != null) {
                this.hHQ.VJ();
                this.hHQ.chj();
                this.hHQ.cho();
            }
            if (wVar == null || wVar.mLiveInfo == null) {
                str = null;
            } else {
                this.hIh = wVar.mLiveInfo.live_id;
                str = String.valueOf(wVar.mLiveInfo.room_id);
            }
            cjK();
            cjW();
            cjX();
            if (this.hHO.cjv() && !StringUtils.isNull(str) && this.hHO.cjw() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.hHO.cjw().A("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (wVar != null) {
                View a2 = (this.hIf == null || this.hIf.bYn() == null) ? null : this.hIf.bYn().a(this.hIf.bYd().pageContext.getPageActivity(), wVar, z);
                if (this.hHQ != null) {
                    this.hIe.a(this.hHQ, a2, wVar, z, this.hkX.cfI());
                }
                if (this.hIf != null) {
                    this.hIf.mS(false);
                    this.hIf.bYi();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.hHQ != null) {
                    this.hHQ.chl();
                }
                long j = wVar.mLiveInfo.live_id;
                String str2 = wVar.mLiveInfo.feed_id;
                long j2 = wVar.aHk.userId;
                String str3 = wVar.aHk.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    QMStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", str + "", str2, this.otherParams);
                this.hIl = new StayTimeBean();
                this.hIl.liveId = wVar.mLiveInfo.live_id;
                this.hIl.roomId = wVar.mLiveInfo.room_id;
                this.hIl.vid = wVar.mLiveInfo.feed_id;
                this.hIl.startTime = System.currentTimeMillis();
            }
            ckg();
            if (this.hHT != null) {
                this.hHT.a(this.aDh, this.hHU);
            }
        }
    }

    private void cjW() {
    }

    private void cjX() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.hHR);
        }
    }

    public void cjY() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cjZ();
        } else {
            cka();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.hkX != null && this.hkX.Gz() != null) {
            alaLiveInfoData = this.hkX.Gz().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cjZ();
        } else {
            cka();
        }
        this.hHR.setIsScrollable(!z && this.hIu);
        if (this.hIf != null) {
            this.hIf.onKeyboardVisibilityChanged(z);
        }
        if (this.hlp != null) {
            this.hlp.onKeyboardVisibilityChanged(z);
        }
    }

    public void dE(int i) {
        if (i == 0) {
            i = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        }
        if (isDebug()) {
            Log.d(TAG, "onScreenOrientationChanged: ");
        }
        if (i == 2) {
            cjZ();
        } else {
            cka();
        }
        this.hlp.dE(i);
        xa(i);
        if (aj.GN() != null) {
            aj.GN().FZ();
        }
        if (this.hIn != null) {
            this.hIn.FZ();
        }
        if (this.hHT != null) {
            this.hHT.dE(i);
        }
    }

    public void cjZ() {
        if (this.hHR != null) {
            i.ae(this.hHR);
        }
    }

    public void cka() {
        if (this.hHR != null) {
            i.af(this.hHR);
        }
    }

    private boolean ckb() {
        return this.hID || this.hIE;
    }

    private void ckc() {
        this.hID = false;
        this.hIE = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.hIs + " mWebOver=" + this.hIa + ", isFloatingMode=" + isFloatingMode());
        }
        ckc();
        if (!this.hIa || !isFloatingMode()) {
            bRK();
            if (this.hkX != null) {
                this.hkX.cfs();
                this.hkX.cfw();
            }
            if (this.hIf != null) {
                this.hIf.enterForeground();
            }
            if (this.hIn != null) {
                this.hIn.onResume();
            }
            if (this.hIo != null) {
                this.hIo.onResume();
            }
            com.baidu.live.core.layer.b.Do().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.hIs + " mWebOver=" + this.hIa + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        ckc();
        if ((!this.hIa || !isFloatingMode()) && !this.hIs) {
            bRK();
            if (this.hHZ) {
                this.hHZ = false;
                ckd();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            cjI();
        }
    }

    public void ckd() {
        cfl();
        cjV();
        this.hkX.cfH();
        if (!this.hHV.isPlaying()) {
            cjJ();
        } else if (this.hHV.isPaused()) {
            this.hHV.resume();
        }
        if (this.hIf != null) {
            this.hIf.bYm();
        }
        if (this.hkX != null && this.hkX.Gz() != null && this.hkX.Gz().mLiveInfo != null) {
            this.hIk.fc(this.hkX.Gz().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aDh.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.hIa + ", isFloatingMode=" + isFloatingMode());
        }
        if (ckb() || !this.hIa || !isFloatingMode()) {
            if (this.hkX != null) {
                this.hkX.cft();
                this.hkX.cfx();
            }
            if (this.hIf != null) {
                this.hIf.enterBackground();
            }
            com.baidu.live.core.layer.b.Do().onPause();
        }
    }

    public void T(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.hIz);
        }
        if (!ckb() && z && !this.hIz && cjD()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0640a() { // from class: com.baidu.tieba.ala.player.b.12
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0640a
                    public boolean a(SdkLivePlayer sdkLivePlayer) {
                        if (sdkLivePlayer != null) {
                            sdkLivePlayer.aPd();
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
        this.hHZ = true;
        og(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void og(boolean z) {
        this.mHandler.removeCallbacks(this.hoA);
        this.mHandler.removeCallbacks(this.hIA);
        this.mHandler.removeCallbacks(this.hIB);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.hHV.isFloatingMode()) {
                this.hHV.aPd();
            }
        } else if (!z && !this.hHV.isFloatingMode()) {
            this.hHV.aPd();
        }
        if (this.hIf != null) {
            this.hIf.bYl();
        }
        this.hIk.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (aj.GN() != null) {
                aj.GN().a(i, i2, intent, this.aDh, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.hIf != null) {
            this.hIf.onActivityResult(i, i2, intent);
        }
    }

    public boolean cke() {
        return this.hIe != null && this.hIe.bRA();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hIQ != null) {
            MessageManager.getInstance().unRegisterListener(this.hIQ);
        }
        if (this.hIR != null) {
            MessageManager.getInstance().unRegisterListener(this.hIR);
        }
        MessageManager.getInstance().unRegisterListener(this.hIS);
        MessageManager.getInstance().unRegisterListener(this.hIT);
        MessageManager.getInstance().unRegisterListener(this.hIU);
        MessageManager.getInstance().unRegisterListener(this.hIV);
        MessageManager.getInstance().unRegisterListener(this.hIM);
        MessageManager.getInstance().unRegisterListener(this.gXI);
        MessageManager.getInstance().unRegisterListener(this.hIF);
        MessageManager.getInstance().unRegisterListener(this.hIG);
        MessageManager.getInstance().unRegisterListener(this.bcy);
        if (this.hIH != null) {
            this.hIH.release();
        }
        if (this.hHV != null && !this.hHV.isFloatingMode()) {
            this.hHV.cq(true);
        }
        if (this.hHT != null) {
            this.hHT.onDestory();
        }
        if (this.hlU != null) {
            this.hlU.release();
            this.hlU = null;
        }
        if (this.hHU != null) {
            this.hHU.reset();
        }
        if (this.hIf != null) {
            this.hIf.onDestroy();
        }
        if (this.hHS != null) {
            this.hHS.onDestroy();
        }
        if (this.hHQ != null) {
            this.hHQ.VJ();
            this.hHQ.release();
            this.hHQ = null;
        }
        if (this.hIe != null) {
            this.hIe.onDestroy();
        }
        if (this.hIl != null && this.hkX != null && this.hkX.Gz() != null) {
            long j = this.hkX.Gz().mLiveInfo.live_id;
            if (this.hIl.liveId == j && this.hIl.startTime > 0) {
                this.hIl.endTime = System.currentTimeMillis();
                long j2 = this.hIl.endTime - this.hIl.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hIl.roomId + "", this.hIl.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.hIl = null;
        }
        if (this.hlp != null) {
            this.hlp.chq();
            this.hlp = null;
        }
        if (this.hkX != null) {
            this.hkX.destory();
        }
        if (this.hlT != null) {
            this.hlT.release();
        }
        y.Gt().release();
        if (this.hIo != null) {
            this.hIo.release();
        }
        com.baidu.live.gift.w.Gr().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String LU() {
        return this.otherParams;
    }

    public void oh(boolean z) {
        this.hIs = z;
    }

    public void ckf() {
        if (this.hIi != null) {
            this.otherParams = this.hIi.toString();
            if (this.hkX != null) {
                this.hkX.setOtherParams(this.otherParams);
            }
            if (this.hIf != null) {
                this.hIf.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.hIe != null) {
                this.hIe.setOtherParams(this.otherParams);
            }
        }
    }

    public void ckg() {
        if (this.hIi != null) {
            String optString = this.hIi.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hIi.put("tab", "live_jump");
                        this.hIi.put("tag", "");
                        this.hIi.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hIi.put("tab", "liveroom");
                        this.hIi.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ckf();
            }
        }
    }

    private void f(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.JT();
        }
        bVar.setAnchorId(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void ckh() {
        aa.GJ();
    }

    private void k(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hIf.e(s);
        } else {
            this.hIf.f(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
