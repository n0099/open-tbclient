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
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bm;
import com.baidu.live.data.bn;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ak;
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
import com.baidu.live.z.e;
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
    private static int hCT = 1;
    private static WeakReference<b> mRef;
    private w aEc;
    private com.baidu.live.r.b bBB;
    private CustomMessageListener bcQ;
    private boolean beI;
    private long bmB;
    private String bmC;
    private boolean bql;
    private String gNJ;
    CustomMessageListener gRW;
    private com.baidu.tieba.ala.endliveroom.a hCA;
    private com.baidu.tieba.ala.liveroom.d.c hCB;
    private String hCC;
    private long hCD;
    private JSONObject hCE;
    private boolean hCF;
    private com.baidu.tieba.ala.liveroom.task.c hCG;
    private StayTimeBean hCH;
    private boolean hCI;
    private com.baidu.tieba.ala.liveroom.k.a hCJ;
    private com.baidu.tieba.ala.liveroom.w.c hCK;
    private boolean hCL;
    private boolean hCM;
    private String hCN;
    private boolean hCO;
    private bn hCP;
    private boolean hCQ;
    private boolean hCR;
    private int hCS;
    private boolean hCU;
    private boolean hCV;
    private Runnable hCW;
    private Runnable hCX;
    private Runnable hCY;
    private boolean hCZ;
    private a hCk;
    private SafeFrameLayout hCl;
    private AlaLiveRoomBlurPageLayout hCm;
    private AlaLoopViewPager hCn;
    private AlaLoopViewPagerAdapter hCo;
    private com.baidu.tieba.ala.liveroom.e.a hCp;
    private com.baidu.tieba.ala.liveroom.e.b hCq;
    private SdkLivePlayer hCr;
    private AlaLastLiveroomInfo hCs;
    private boolean hCt;
    private boolean hCu;
    private boolean hCv;
    private boolean hCw;
    @Deprecated
    private boolean hCx;
    private ArrayList<AlaBroadcastGiftToastData> hCy;
    private String hCz;
    private boolean hDa;
    private CustomMessageListener hDb;
    private CustomMessageListener hDc;
    private com.baidu.live.ac.c hDd;
    private boolean hDe;
    private boolean hDf;
    private long hDg;
    private long hDh;
    private CustomMessageListener hDi;
    private com.baidu.live.r.a hDj;
    com.baidu.live.liveroom.a.c hDk;
    ViewPager.OnPageChangeListener hDl;
    HttpMessageListener hDm;
    CustomMessageListener hDn;
    CustomMessageListener hDo;
    CustomMessageListener hDp;
    CustomMessageListener hDq;
    private CustomMessageListener hDr;
    private AlaLiveView hfN;
    private ViewGroup hfO;
    private LayerRootView hfP;
    private long hfT;
    private com.baidu.tieba.ala.liveroom.q.d hfu;
    private d.a hgd;
    private com.baidu.live.q.d hgr;
    private com.baidu.live.q.c hgs;
    private Runnable hjc;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void chD() {
        if (this.hCK != null) {
            this.hCK.bt(this.beI);
        }
        if (this.hCJ != null) {
            this.hCJ.bt(this.beI);
        }
        if (ak.GV() != null) {
            ak.GV().bt(this.beI);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hCt = true;
        this.hfT = 0L;
        this.hCu = false;
        this.bql = true;
        this.bmC = "";
        this.mForumName = "";
        this.hCv = false;
        this.hCx = false;
        this.hCz = "0";
        this.mHandler = new Handler();
        this.hCD = -1L;
        this.otherParams = "";
        this.hCF = false;
        this.hCG = com.baidu.tieba.ala.liveroom.task.c.ceN();
        this.hCI = false;
        this.hCM = false;
        this.hCO = false;
        this.hCR = false;
        this.hCS = 0;
        this.hCU = false;
        this.hCV = false;
        this.hjc = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cdr();
            }
        };
        this.hCW = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.cia();
            }
        };
        this.hCX = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.hfu.cdN();
            }
        };
        this.hCY = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.gRW = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hCZ = true;
            }
        };
        this.hDb = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hDa = true;
            }
        };
        this.hDc = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.hDi = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.beI = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.chD();
            }
        };
        this.bcQ = new CustomMessageListener(2501059) { // from class: com.baidu.tieba.ala.player.b.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_video_activity")) {
                    b.this.S(false, false);
                }
            }
        };
        this.bBB = new com.baidu.live.r.b() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.r.b
            public void dM(int i) {
                if (b.this.hCB != null) {
                    b.this.hCB.dM(i);
                }
            }
        };
        this.hDj = new com.baidu.live.r.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.r.a
            public void cm(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.hCr != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.hCr.isPlaying());
                        if (b.this.hCr.isPlaying()) {
                            if (b.this.hCr.isPaused()) {
                                b.this.hCr.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.hCr.isPlaying()) {
                        b.this.hCr.pause();
                    }
                }
            }
        };
        this.hDk = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void cd(boolean z) {
                if (z || b.this.hCB == null || b.this.hCB.bWq()) {
                    if (!b.this.chL() || b.this.a(true, (a.InterfaceC0628a) null)) {
                        b.this.hCV = true;
                        b.this.nV(true);
                        b.this.bTu();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void ce(boolean z) {
                b.this.d(b.this.aEc, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.hCr.cir();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.hCv) {
                    if (b.this.hCv) {
                        b.this.hCr.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.hCr.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.hCn != null) {
                    b.this.hCn.setIsScrollable(b.this.hCQ && z);
                    b.this.hCn.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cf(boolean z) {
                boolean z2 = true;
                if (!z || b.this.cij()) {
                    if (b.this.hCm != null) {
                        b.this.hCm.cfq();
                        return;
                    }
                    return;
                }
                if (b.this.hfu.GH().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.hCm != null) {
                    b.this.hCm.nE(z2);
                }
            }
        };
        this.hDl = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.hCn != null && i == 0) {
                    b.this.chW();
                    com.baidu.live.d.AZ().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.hgd = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.q.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.F(b.this.hfu.GH());
                } else if (i2 == 2) {
                    b.this.f(b.this.hfu.bOQ());
                } else if (i2 == 3) {
                    b.this.bn(i, str2);
                } else if (i2 == 4) {
                    b.this.aH(obj);
                } else if (i2 == 5) {
                    b.this.chZ();
                }
            }
        };
        this.hDm = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.ceL() != null && b.this.mTbPageContext != null) {
                        b.this.hCG.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.ceL());
                    }
                }
            }
        };
        this.hDn = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
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
        this.hDo = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.hfu != null && b.this.hfu.GH() != null && b.this.hfu.GH().mLiveInfo != null) {
                    long j = b.this.hfu.GH().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.hDd != null) {
                        b.this.hDd.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.hDp = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.hfu != null && b.this.hfu.GH() != null && b.this.hfu.GH().aIA != null) {
                        if (l.longValue() == b.this.hfu.GH().aIA.userId) {
                            b.this.hfu.GH().aIA.isNewUser = false;
                            if (b.this.hCJ != null) {
                                b.this.hCJ.o(b.this.hfu.GH());
                            }
                        }
                    }
                }
            }
        };
        this.hDq = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.u.a)) {
                    com.baidu.tieba.ala.liveroom.u.a aVar2 = (com.baidu.tieba.ala.liveroom.u.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String DP = aVar2.DP();
                    if (b.this.mTbPageContext != null && b.this.hfu != null && b.this.hfu.GH() != null && b.this.hfu.GH().aIA != null) {
                        if (valueOf.longValue() == b.this.hfu.GH().aIA.userId && com.baidu.live.z.a.Pq().bsy != null && com.baidu.live.z.a.Pq().bsy.aOy != null && com.baidu.live.z.a.Pq().bsy.aOy.Et()) {
                            g.vt(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, DP));
                        }
                    }
                }
            }
        };
        this.hDr = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.hjc != null) {
                    b.this.mHandler.removeCallbacks(b.this.hjc);
                }
                b.this.cdr();
            }
        };
        this.hfT = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.hCk = aVar;
        this.hCt = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ac.c.class);
        if (runTask != null) {
            this.hDd = (com.baidu.live.ac.c) runTask.getData();
        }
        this.hfu = new com.baidu.tieba.ala.liveroom.q.d(getPageContext());
        this.hfu.a(this.hgd);
        this.hfu.HX(str);
        this.hCA = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hDm);
        MessageManager.getInstance().registerListener(this.hDn);
        MessageManager.getInstance().registerListener(this.hDo);
        MessageManager.getInstance().registerListener(this.hDp);
        MessageManager.getInstance().registerListener(this.hDq);
        MessageManager.getInstance().registerListener(this.hDr);
        MessageManager.getInstance().registerListener(this.hDi);
        MessageManager.getInstance().registerListener(this.gRW);
        MessageManager.getInstance().registerListener(this.hDb);
        MessageManager.getInstance().registerListener(this.hDc);
        MessageManager.getInstance().registerListener(this.bcQ);
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.hCy = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hCy.add(alaBroadcastGiftToastData);
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
        this.bmC = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bmC)) {
            this.bmC = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        if (z) {
            this.hCC = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.hCC = intent.getStringExtra("room_id");
        }
        this.bmB = intent.getLongExtra("live_id", 0L);
        this.hCF = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.hfu.b((AlaLiveInfoCoreData) serializableExtra);
            this.hCF = true;
        }
        this.hfu.setIsMixLive(z);
        c(intent, z);
        this.hCQ = this.hCP == null || !this.hCP.aOO;
        this.hCA.setOtherParams(this.otherParams);
        nT(z);
        chE();
        this.mHandler.removeCallbacks(this.hCY);
        this.mHandler.postDelayed(this.hCY, 1000L);
    }

    private void c(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.hCS = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.gNJ = null;
            if (z) {
                stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_EXTRA_PARAMS);
            } else {
                stringExtra = intent.getStringExtra("params");
            }
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hCE = new JSONObject(stringExtra);
                if (this.hCE != null) {
                    String optString2 = this.hCE.optString("enterRoomId");
                    String optString3 = this.hCE.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hCC, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bmB + "", optString3))) {
                        String optString4 = this.hCE.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString5 = this.hCE.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString5);
                        if (!this.hCF) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bmB;
                            alaLiveInfoCoreData.screenDirection = this.hCE.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.hfu.b(alaLiveInfoCoreData);
                            this.hCF = true;
                        }
                    }
                    String optString6 = this.hCE.optString("extra");
                    try {
                        this.hDg = Long.parseLong(this.hCC);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.hDh = this.bmB;
                    if (TextUtils.isEmpty(optString6)) {
                        this.hCP = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.hfu != null) {
                            this.hfu.Ht(optString7);
                        }
                        this.hDe = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.hDf = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.gNJ = jSONObject.optString("live_back_scheme");
                        this.hCP = new bn();
                        this.hCP.aOO = jSONObject.optInt("is_hot") == 1;
                        if (this.hCP.aOO) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hCS = AlaLiveSwitchData.isHotLive;
                        this.hCP.aOP = jSONObject.optString("task_id");
                        this.hCP.aON = !TextUtils.isEmpty(this.hCP.aOP);
                        this.hCP.aOQ = jSONObject.optInt("task_type");
                        this.hCP.aOR = jSONObject.optInt("task_im_count");
                        this.hCP.aOS = jSONObject.optLong("task_gift_total_price");
                        this.hCP.aOT = jSONObject.optLong("task_watch_time");
                        this.hCP.aOU = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.hCE.put("from", optString);
                        }
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.hCq = new com.baidu.tieba.ala.liveroom.e.b();
                            this.hCq.setScheme(optString8);
                            this.hCq.setImageUrl(optString9);
                            this.hCq.setTitle(optString10);
                        }
                    }
                    this.hCz = this.hCE.optString("open_giftlist");
                    this.hCE.remove("cover");
                    this.hCE.remove("live_url");
                    this.hCE.remove("enterRoomId");
                    this.hCE.remove("enterLiveId");
                    this.hCE.remove("open_giftlist");
                    this.hCE.remove("extra");
                    this.otherParams = this.hCE.toString();
                    if (this.hfu != null) {
                        this.hfu.setOtherParams(this.otherParams);
                    }
                    this.hCE.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hCE.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hCE.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hCE.optString("source");
                    }
                    this.hCR = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hCE.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.hfu != null) {
                        this.hfu.vS(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hCs = new AlaLastLiveroomInfo();
                this.hCs.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bmB), String.valueOf(this.hCC), null, chT());
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

    public void chE() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.hfu.aq(this.uk, this.bmC, this.mForumName);
        } else if (this.hfu.GH() != null && this.hfu.GH().mLiveInfo != null && this.hfu.GH().mLiveInfo.live_id > 0) {
            this.hfu.a(this.hfu.GH().mLiveInfo.live_id, false, this.bmC, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bmC = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                nV(false);
                return;
            }
            this.hfu.aq(this.uk, this.bmC, this.mForumName);
        } else if (!TextUtils.isEmpty(this.hCC)) {
            this.hfu.HW(this.hCC);
        } else if (this.bmB > 0) {
            this.hfu.a(this.bmB, false, this.bmC, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            nV(false);
        }
    }

    private void nT(boolean z) {
        this.bql = true;
        this.hCu = false;
        nU(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.DE().n(this.hfP);
        this.hCB = new com.baidu.tieba.ala.liveroom.d.c();
        this.hCB.a(this.hDk);
        this.hCB.setOtherParams(this.otherParams);
        this.hCB.mD(this.hCR);
        this.hCB.a(this.hCk.chB());
        chH();
        chF();
        chG();
    }

    private void nU(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.hCl = (SafeFrameLayout) inflate.findViewById(a.g.live_root_view);
        this.hCn = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.hCn.setOnPageChangeListener(this.hDl);
        this.hCn.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void cbc() {
                b.this.chW();
            }
        });
        this.hCn.setBoundaryCaching(true);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.hCo = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.hCo.cba();
        this.hCm = this.hCo.vz(this.mSelectedPosition);
        this.hCo.a(this.mSelectedPosition, this.hfu.GH());
        this.hCn.setAdapter(this.hCo);
        this.hCn.setCurrentItem(this.mSelectedPosition);
        this.hCn.setIsScrollable(this.hCQ);
        this.hCn.setIsMixLive(z);
        this.hfO = (ViewGroup) inflate.findViewById(a.g.func_view);
        this.hfP = (LayerRootView) inflate.findViewById(a.g.layer_root_view);
    }

    private void c(Rect rect) {
        this.hCr = SdkLivePlayer.ff(getPageContext().getPageActivity());
        if (this.hCr == null) {
            this.hCn.setIsScrollable(false);
            if (this.hfu != null) {
                this.hfu.cancelLoadData();
            }
            cbe();
            return;
        }
        this.hCr.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.hCr.setIPlayerCallBack(this.bBB);
        this.hCr.setIPlayerAudioFocusCallBack(this.hDj);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hCm.a(this.hCr, layoutParams, true);
    }

    private void chF() {
        this.hCp = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.hfO);
    }

    private void chG() {
        CustomResponsedMessage runTask;
        if (this.hgs == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.q.c.class)) != null) {
            this.hgs = (com.baidu.live.q.c) runTask.getData();
        }
        if (this.hgs != null) {
            this.hgs.setParentView(this.hfO);
        }
    }

    private void cbe() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.nV(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.hfN = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.hfN.setSwipeClearEnable(true);
        this.hfN.hqj = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hCm.a(this.hfN, layoutParams);
    }

    private void chH() {
        if (this.hfu != null && this.hfu.GH() != null) {
            this.aEc = this.hfu.GH();
            if (this.aEc.mLiveInfo != null) {
                a(this.aEc.mLiveInfo, this.hCF);
                if (this.aEc.mLiveInfo != null && this.aEc.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hCv);
                    }
                    if (!this.hCv) {
                        this.hCr.c(this.aEc.mLiveInfo);
                    } else {
                        this.hCr.setPlayLiveInfo(this.aEc.mLiveInfo);
                    }
                    if (this.hCB != null) {
                        this.hCB.a(this.mTbPageContext, this.hfN, this.hCr, this.hCm, this.hfu, this.bmC, this.hCx, this.hfT, this.hCy, this.hCP);
                        k(this.aEc.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean chI() {
        boolean z;
        AlaLiveInfoData cdW;
        if (this.hCk.chA()) {
            return false;
        }
        if (this.hfu == null || (cdW = this.hfu.cdW()) == null || cdW.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !cdW.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.hDg + ", getPlayingRoomID:" + chJ() + ", mSchemeLiveId:" + this.hDh + ", getPlayingLiveID:" + chK());
        }
        return z || chM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long chJ() {
        AlaLiveInfoData cdW;
        if (this.hfu == null || (cdW = this.hfu.cdW()) == null) {
            return 0L;
        }
        return cdW.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long chK() {
        AlaLiveInfoData cdW;
        if (this.hfu == null || (cdW = this.hfu.cdW()) == null) {
            return 0L;
        }
        return cdW.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chL() {
        boolean z = false;
        if (!this.hCk.chA()) {
            if (this.hDe && (this.hDg == chJ() || this.hDh == chK())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean chM() {
        boolean z = this.hDf && (this.hDg == chJ() || this.hDh == chK());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean chN() {
        if (hCT <= 0) {
            return false;
        }
        if (!(chL() || chI()) || FloatPermissionUtil.Np()) {
            return false;
        }
        hCT--;
        FloatPermissionUtil.al(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0628a interfaceC0628a) {
        if (!FloatPermissionUtil.Np()) {
            if (this.hCU) {
                return true;
            }
            this.hCU = true;
            if (z) {
                FloatPermissionUtil.al(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (chL()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.hDf) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a fa = com.baidu.tieba.ala.floating.b.fa(getPageContext().getPageActivity());
        fa.a(interfaceC0628a);
        fa.dz(jSONObject);
        com.baidu.tieba.ala.floating.b.fa(getPageContext().getPageActivity()).a(this.hCr, this.hfu.GH(), this.bmC, this.hfT);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bPR() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bPM = com.baidu.tieba.ala.floating.b.bPM();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0628a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0628a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bPM == null || bPM.room_id == b.this.chJ() || bPM.live_id == b.this.chK()) {
                    if (b.this.hCr != null) {
                        b.this.chO();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.hCv);
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
    public void chO() {
        ArrayList arrayList = (ArrayList) this.hCr.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.hCr.ciq();
            this.hCr.ak(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bPP();
    }

    public void nR(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.hCw = z;
    }

    private void chP() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hCQ) {
                this.hCn.setIsScrollable(true);
            } else {
                this.hCn.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.DE().onBackPressed() && ((this.hCB == null || !this.hCB.onKeyDown(i, keyEvent)) && (this.hCB == null || !this.hCB.bWp()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                chP();
            } else if ((this.hCB == null || this.hCB.bWq()) && (!chL() || a(true, (a.InterfaceC0628a) null))) {
                this.hCV = true;
                nV(true);
                bTu();
            }
        }
        return true;
    }

    public void bTu() {
        if (!TextUtils.isEmpty(this.gNJ)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gNJ);
                this.gNJ = null;
            }
        }
    }

    public void nV(boolean z) {
        S(z, false);
    }

    public void S(boolean z, boolean z2) {
        mI(!z);
        if (this.hCr != null && !this.hCr.isFloatingMode()) {
            this.hCr.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.DE().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        chR();
        long j = -1;
        if (this.hfu != null && this.hfu.cdW() != null) {
            j = this.hfu.cdW().room_id;
        }
        this.hCk.b(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void mI(boolean z) {
        if (this.hCk.chA() && this.hCk.chB() != null) {
            this.hCk.chB().A("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hCs = null;
        if (ak.GV() != null) {
            ak.GV().GU();
        }
        com.baidu.live.core.layer.b.DE().DF();
        if (this.hDd != null) {
            this.hDd.release();
        }
        if (this.hCJ != null) {
            this.hCJ.release();
        }
        this.hCP = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.hfu != null) {
            try {
                this.hfu.Ht(null);
                AlaLiveInfoData cdW = this.hfu.cdW();
                if (cdW != null) {
                    this.hfu.eD(cdW.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.hCG.stopRecord();
        LiveTimerManager.getInstance().stop();
        chQ();
        if (this.hCr != null && !this.hCr.isFloatingMode()) {
            this.hCr.cn(z);
        }
        if (this.hCB != null) {
            this.hCB.mI(z);
        }
        this.hCI = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.MU().blS != null && this.aEc != null) {
            com.baidu.live.liveroom.a.b.MU().blS.b(this.aEc.mLiveInfo);
        }
        ab.gX("");
        x.Gz().release();
        if (this.hgs != null) {
            this.hgs.GS();
        }
    }

    private void chQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void chR() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(w wVar) {
        if (wVar != null) {
            this.aEc = wVar;
            if (this.hCB != null) {
                this.hCB.a(wVar);
            }
            chN();
        }
    }

    private void c(q qVar) {
        if (this.hCB != null) {
            this.hCB.c(qVar);
        }
    }

    private void I(w wVar) {
        this.aEc = wVar;
        chN();
    }

    private void chS() {
        long j;
        String str;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.hCQ = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.hCQ = true;
        }
        this.hCn.setIsScrollable(this.hCQ);
        this.hCS = AlaLiveSwitchData.isHotLive;
        if (this.aEc != null) {
            a(this.aEc.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.hCm.a(this.hfN, null);
            if (!isFloatingMode()) {
                a(this.hCm, this.aEc.mLiveInfo, this.bql);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aEc.mLiveInfo.live_id), String.valueOf(this.aEc.mLiveInfo.room_id), String.valueOf(this.aEc.mLiveInfo.feed_id), chT());
            if (com.baidu.live.liveroom.a.b.MU().blS != null) {
                com.baidu.live.liveroom.a.b.MU().blS.a(this.aEc.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.bql = false;
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                String str2 = "";
                if (this.hfu != null && this.hfu.GH() != null && this.hfu.GH().mLiveInfo != null) {
                    j = this.hfu.GH().mLiveInfo.live_id;
                    str = this.hfu.GH().mLiveInfo.room_id + "";
                    str2 = this.hfu.GH().mLiveInfo.feed_id;
                } else {
                    if (this.bmB > 0) {
                        j2 = this.bmB;
                    }
                    if (TextUtils.isEmpty(this.hCC)) {
                        j = j2;
                        str = "";
                    } else {
                        j = j2;
                        str = this.hCC;
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
                if (this.hfu != null && this.hfu.GH() != null && this.hfu.GH().mLiveInfo != null) {
                    str3 = this.hfu.GH().mLiveInfo.feed_id;
                    str4 = this.hfu.GH().mLiveInfo.live_id + "";
                    str5 = this.hfu.GH().mLiveInfo.room_id + "";
                    str6 = this.hfu.GH().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            chN();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String chT() {
        if (this.hCE == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hCE.optString("source");
            String optString2 = this.hCE.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hCE.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hCE.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.hCE.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bPR();
        } else if (this.hCr != null && this.hCr.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.hCr.getVideoPath();
                String d = com.baidu.live.r.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.hCr.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.r.h.aJ(videoPath, d)) {
                    this.hCr.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.r.h.aI(videoPath, d)) {
                    this.hCr.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.cf(this.hCr)) {
                        ((ViewGroup) this.hCr.getParent()).removeView(this.hCr);
                        alaLiveRoomBlurPageLayout.a(this.hCr, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.hCv) {
                        this.hCr.c(alaLiveInfoData);
                        return;
                    } else {
                        this.hCr.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.hCr.ciq();
        } else if (this.hCr != null && this.hCr.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.hCr, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.hCv) {
                    this.hCr.c(alaLiveInfoData);
                } else {
                    this.hCr.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.hCr != null) {
            this.hCr.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = o.u(this.mTbPageContext.getPageActivity());
                layoutParams.height = o.v(this.mTbPageContext.getPageActivity());
                int aH = o.aH(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = aH + i;
                } else {
                    dimensionPixelSize = aH + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void chU() {
        this.bql = true;
    }

    public boolean chV() {
        return this.bql;
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
        if (this.hCm != null) {
            this.hCm.setBackgroundColor(0);
        }
        int i3 = this.hCr.getLayoutParams().width;
        int i4 = this.hCr.getLayoutParams().height;
        int i5 = this.hCr.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.hCr.getLayoutParams()).topMargin : 0;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i3 || b.height != i4 || b.topMargin != i5) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.hfN != null) {
            this.hfN.setLayoutParams(c);
        }
        if (this.hCm != null) {
            this.hCm.D(screenFullSize[0], screenFullSize[1]);
        }
        if (this.hCA != null) {
            this.hCA.D(screenFullSize[0], screenFullSize[1]);
        }
        if (this.hCB != null) {
            this.hCB.l(c.width, c.height, realScreenOrientation);
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

    private void wp(int i) {
        boolean z = true;
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            if (this.hCm != null) {
                this.hCm.setBgImageUrl(this.aEc.mLiveInfo.cover, this.aEc.mLiveInfo);
            }
            this.hCo.a(this.mSelectedPosition, chX(), this.aEc);
            this.hCo.b(this.mSelectedPosition, chY(), this.aEc);
            if (this.hCm != null) {
                this.hCm.requestLayout();
                this.hCm.M(i, this.aEc.mLiveInfo.screen_direction == 2);
            }
        }
        if (this.aEc != null) {
            a(i, this.aEc.mLiveInfo, false);
        }
        boolean cfr = this.hCm.cfr();
        boolean z2 = i == 1;
        if (this.aEc == null || this.aEc.mLiveInfo == null || this.aEc.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!cij()) {
            if (this.hCr != null && this.hCr.getParent() == null) {
                this.hCm.a(this.hCr, null, false);
                if (this.aEc != null && this.aEc.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.hCv) {
                        this.hCr.c(this.aEc.mLiveInfo);
                    } else {
                        this.hCr.setPlayLiveInfo(this.aEc.mLiveInfo);
                    }
                }
            }
            if (cfr && !cij() && this.hCB != null) {
                this.hCm.nE(z);
                return;
            }
            return;
        }
        this.hCm.cfn();
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
            this.hfu.a(alaLiveInfoData.live_id, true, this.bmC, this.mForumName, this.hCS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chW() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.hCn != null && this.hfN != null && this.mSelectedPosition != (currentItem = this.hCn.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.i.sdk_neterror);
                this.hCn.setCurrentItem(this.mSelectedPosition);
            } else if (!this.bql && ListUtils.getCount(this.hfu.cdM()) <= 1) {
                this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                this.hCn.setCurrentItem(this.mSelectedPosition);
                this.hfu.g(this.hfu.cdW());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.hfu.cdR() && i < 0) {
                    this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                    this.hCn.setCurrentItem(this.mSelectedPosition);
                } else if (this.hfu.cdS() && i > 0) {
                    this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                    this.hCn.setCurrentItem(this.mSelectedPosition);
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.hfu.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    mI(true);
                    this.hCm.cfn();
                    this.hCm.TS();
                    this.hCm.cfo();
                    if (this.hfu.GH() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.hfu.GH().mLiveInfo.live_id + "", this.hfu.GH().mLiveInfo.room_id + "", this.hfu.GH().aIe.userId + "", this.hfu.GH().aIe.userName, System.currentTimeMillis(), this.hfu.GH().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.hfu.GH().mLiveInfo.live_id + "", this.hfu.GH().mLiveInfo.room_id + "", this.hfu.GH().aIe.userId + "", this.hfu.GH().aIe.userName, System.currentTimeMillis(), this.hfu.GH().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.hCH != null) {
                        long j = this.hfu.GH().mLiveInfo.live_id;
                        if (this.hCH.liveId == j && this.hCH.startTime > 0) {
                            this.hCH.endTime = System.currentTimeMillis();
                            long j2 = this.hCH.endTime - this.hCH.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hCH.roomId + "", this.hCH.vid, j2 / 1000, this.otherParams);
                        }
                        this.hCH = null;
                    }
                    cil();
                    if (this.hDd != null) {
                        this.hDd.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.hCm = this.hCo.vA(this.mSelectedPosition);
                    this.hCm.cfp();
                    wq(i);
                    chN();
                }
            }
        }
    }

    public void wq(int i) {
        if (i < 0) {
            this.hfu.vT(this.hfu.cdT() - 1);
        } else if (i > 0) {
            this.hfu.vT(this.hfu.cdT() + 1);
        }
        if (this.hCB != null) {
            this.hCB.a(this.hCm);
        }
        this.hCo.a(this.mSelectedPosition, chX(), this.aEc);
        this.hCo.b(this.mSelectedPosition, chY(), this.aEc);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.hfu != null) {
            int cdT = this.hfu.cdT();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", cdT + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.hfu.cdM() != null && this.hfu.cdM().size() > cdT && this.hfu.cdM().get(cdT) != null) {
                AlaLiveInfoData alaLiveInfoData = this.hfu.cdM().get(cdT);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hfu != null) {
            AlaLiveInfoData cdW = this.hfu.cdW();
            if (cdW != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(cdW.live_id), String.valueOf(cdW.room_id), null, chT());
                cdW.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bPR();
                }
                a(this.hCm, cdW, this.bql);
                this.bql = false;
                if (this.hCB != null) {
                    this.hCB.a(this.mTbPageContext, this.hfN, this.hCr, this.hCm, this.hfu, this.bmC, this.hCx, this.hfT, null, this.hCP);
                    short s = 2;
                    if (cdW.screen_direction == 2) {
                        s = 1;
                    }
                    k(s);
                }
                a(cdW, false);
            }
            i(cdW);
            this.hCm.a(this.hfN, null);
            if (this.hCB != null) {
                this.hCB.bWn();
            }
            this.hfu.g(cdW);
        }
    }

    private AlaLiveInfoData chX() {
        List<AlaLiveInfoData> cdM = this.hfu.cdM();
        if (cdM == null || cdM.size() == 0) {
            if (this.aEc == null) {
                return null;
            }
            return this.aEc.mLiveInfo;
        }
        int cdT = this.hfu.cdT();
        int size = cdM.size();
        return cdM.get(((cdT + size) - 1) % size);
    }

    private AlaLiveInfoData chY() {
        List<AlaLiveInfoData> cdM = this.hfu.cdM();
        if (cdM == null || cdM.size() == 0) {
            if (this.aEc == null) {
                return null;
            }
            return this.aEc.mLiveInfo;
        }
        return cdM.get((this.hfu.cdT() + 1) % cdM.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(int i, String str) {
        CustomResponsedMessage runTask;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hCv) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.i.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            nV(false);
            return;
        }
        w GH = this.hfu.GH();
        I(GH);
        this.hfu.cdN();
        if (this.bql) {
            this.hfu.nw(false);
        }
        this.hfT = System.currentTimeMillis() / 1000;
        if (this.hCB != null) {
            this.hCB.a(this.mTbPageContext, this.hfN, this.hCr, this.hCm, this.hfu, this.bmC, this.hCx, this.hfT, this.hCy, this.hCP);
            short s = 2;
            if (GH.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            k(s);
        }
        if (this.hCk.chB() != null && this.hCk.chA()) {
            this.hCk.chB().A("load_finish", null);
            if (GH.mLiveInfo.screen_direction == 2) {
                this.hCk.chB().A("screen_auto_rotate", true);
            } else {
                this.hCk.chB().A("screen_auto_rotate", false);
            }
        }
        chS();
        if (GH != null && GH.mLiveInfo != null && GH.mLiveInfo.live_status == 2) {
            this.hCo.a(this.mSelectedPosition, this.hfu.GH());
            d(GH, false);
            this.bql = false;
            return;
        }
        if (this.hgr == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.q.d.class)) != null) {
            this.hgr = (com.baidu.live.q.d) runTask.getData();
        }
        if (this.hgr != null) {
            this.hgr.Oo();
        }
        boolean z = (this.hCB == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ab.c.PX().cx(GH != null && GH.aIV);
        ab.e(GH);
        if (z) {
            if (!this.hCM || !TextUtils.equals(p.Sd(), this.hCN)) {
                ab.b(getPageContext(), false);
                e.PD().PE();
                this.hCM = true;
                this.hCN = p.Sd();
            }
            ab.gX("");
            ab.GO();
        }
        if (this.hfu.GH() != null && this.hfu.GH().mLiveInfo != null) {
            this.hfu.h(this.hfu.GH().mLiveInfo.live_id, !this.hCI);
            this.hCI = true;
        }
        if (this.hCB != null) {
            this.hCB.b(this.hCs);
            this.hCB.mH(TextUtils.equals(this.hCz, "1"));
            this.hCz = "";
        }
        if (this.hCp != null) {
            this.hCp.a(this.aEc, this.hCq);
        }
        a(this.hfu.GH());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.hfu.GH() != null && b.this.hfu.GH().mLiveInfo != null) {
                    b.this.hfu.a(b.this.hfu.GH().mLiveInfo.live_id, b.this.bmC, b.this.hfT);
                }
            }
        });
        if (z && this.hfu.GH() != null && this.hfu.GH().aIe != null) {
            bm bmVar = com.baidu.live.z.a.Pq().bsy;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bmVar != null && bmVar.aOD != null && bmVar.aOD.aQO) {
                f(true, this.hfu.GH().aIe.userId);
            }
        }
        this.bql = false;
        if (z && this.hfu.GH() != null && this.hfu.GH().mLiveInfo != null && this.hfu.GH().aIe != null && this.hCB != null) {
            long j = this.hfu.GH().mLiveInfo.live_id;
            long j2 = this.hfu.GH().mLiveInfo.room_id;
            String str2 = this.hfu.GH().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (ak.GV() != null) {
                    ak.GV().bt(this.beI);
                    if (!this.beI) {
                        ak.GV().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.hDd != null) {
                    this.hDd.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.Ke() != null) {
                com.baidu.live.guardclub.e.Ke().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.hCJ == null) {
                this.hCJ = new com.baidu.tieba.ala.liveroom.k.a();
                this.hCJ.bt(this.beI);
            }
            if (!this.beI) {
                this.hCJ.a(this.mTbPageContext.getPageActivity(), this.hfu.GH(), this.otherParams);
            }
        }
        if (this.hCK == null) {
            this.hCK = new com.baidu.tieba.ala.liveroom.w.c(this.mTbPageContext);
            this.hCK.bt(this.beI);
        }
        if (z && this.hfu.GH() != null && this.hfu.GH().aIA != null && !this.hCL) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.hCK.a(this.hfu.GH(), this.hfu.GH().aIA.userId);
                this.hCL = true;
            }
        }
        if (this.hfu.GH() != null && this.hfu.GH().mLiveInfo != null && this.hfu.GH().aIA != null) {
            com.baidu.live.n.a.b(this.hfu.GH().mLiveInfo.live_id, this.hfu.GH().aIA.needRename == 1);
            if (z) {
                com.baidu.live.n.a.b(this.hfu.GH().mLiveInfo.live_id, 0);
            }
        }
        if (this.hgs != null && this.hfu.GH() != null && this.hfu.GH().aIe != null) {
            this.hgs.at(this.hfu.GH().aIe.userId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chZ() {
        if (this.hCt) {
            this.hCo.a(this.mSelectedPosition, chX(), this.aEc);
            this.hCo.b(this.mSelectedPosition, chY(), this.aEc);
            this.hCt = false;
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
        if (!this.hCv) {
            this.mHandler.removeCallbacks(this.hCX);
            this.mHandler.postDelayed(this.hCX, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (qVar == null) {
            if (!this.hCv) {
                this.mHandler.removeCallbacks(this.hCW);
                this.mHandler.postDelayed(this.hCW, 5000L);
                return;
            }
            return;
        }
        if (!this.hCu) {
            c(qVar);
        }
        if (!this.hCv) {
            this.mHandler.removeCallbacks(this.hCW);
            this.mHandler.postDelayed(this.hCW, qVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cia() {
        if (this.hfu.GH() != null && this.hfu.GH().mLiveInfo != null) {
            this.hfu.h(this.hfu.GH().mLiveInfo.live_id, !this.hCI);
            this.hCI = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_status == 2) {
            this.hCo.a(this.mSelectedPosition, this.hfu.GH());
            d(wVar, false);
        } else if (wVar != null) {
            if (!this.hCu) {
                ab.e(wVar);
                a(wVar);
            }
            if (!this.hCv) {
                this.mHandler.removeCallbacks(this.hjc);
                this.mHandler.postDelayed(this.hjc, wVar.aIj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdr() {
        if (this.mTbPageContext != null && this.hfu.GH() != null && this.hfu.GH().mLiveInfo != null) {
            this.hfu.a(this.hfu.GH().mLiveInfo.live_id, this.bmC, this.hfT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar, boolean z) {
        String str;
        mI(true);
        if (!cij()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cek().ny(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cek().release();
            this.hfu.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.hCm != null) {
                this.hCm.TS();
                this.hCm.cfn();
                this.hCm.cfs();
            }
            if (wVar == null || wVar.mLiveInfo == null) {
                str = null;
            } else {
                this.hCD = wVar.mLiveInfo.live_id;
                str = String.valueOf(wVar.mLiveInfo.room_id);
            }
            chP();
            cib();
            cic();
            if (this.hCk.chA() && !StringUtils.isNull(str) && this.hCk.chB() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.hCk.chB().A("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (wVar != null) {
                View a2 = (this.hCB == null || this.hCB.bWt() == null) ? null : this.hCB.bWt().a(this.hCB.bWj().pageContext.getPageActivity(), wVar, z);
                if (this.hCm != null) {
                    this.hCA.a(this.hCm, a2, wVar, z, this.hfu.cdO());
                }
                if (this.hCB != null) {
                    this.hCB.mI(false);
                    this.hCB.bWo();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.hCm != null) {
                    this.hCm.cfp();
                }
                long j = wVar.mLiveInfo.live_id;
                String str2 = wVar.mLiveInfo.feed_id;
                long j2 = wVar.aIe.userId;
                String str3 = wVar.aIe.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    QMStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", str + "", str2, this.otherParams);
                this.hCH = new StayTimeBean();
                this.hCH.liveId = wVar.mLiveInfo.live_id;
                this.hCH.roomId = wVar.mLiveInfo.room_id;
                this.hCH.vid = wVar.mLiveInfo.feed_id;
                this.hCH.startTime = System.currentTimeMillis();
            }
            cil();
            if (this.hCp != null) {
                this.hCp.a(this.aEc, this.hCq);
            }
        }
    }

    private void cib() {
    }

    private void cic() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.hCn);
        }
    }

    public void cid() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cie();
        } else {
            cif();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.hfu != null && this.hfu.GH() != null) {
            alaLiveInfoData = this.hfu.GH().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cie();
        } else {
            cif();
        }
        this.hCn.setIsScrollable(!z && this.hCQ);
        if (this.hCB != null) {
            this.hCB.onKeyboardVisibilityChanged(z);
        }
        if (this.hfN != null) {
            this.hfN.onKeyboardVisibilityChanged(z);
        }
    }

    public void dI(int i) {
        if (i == 0) {
            i = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        }
        if (isDebug()) {
            Log.d(TAG, "onScreenOrientationChanged: ");
        }
        if (i == 2) {
            cie();
        } else {
            cif();
        }
        this.hfN.dI(i);
        wp(i);
        if (ak.GV() != null) {
            ak.GV().Gh();
        }
        if (this.hCJ != null) {
            this.hCJ.Gh();
        }
        if (this.hCp != null) {
            this.hCp.dI(i);
        }
    }

    public void cie() {
        if (this.hCn != null) {
            i.aa(this.hCn);
        }
    }

    public void cif() {
        if (this.hCn != null) {
            i.ab(this.hCn);
        }
    }

    private boolean cig() {
        return this.hCZ || this.hDa;
    }

    private void cih() {
        this.hCZ = false;
        this.hDa = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.hCO + " mWebOver=" + this.hCw + ", isFloatingMode=" + isFloatingMode());
        }
        cih();
        if (!this.hCw || !isFloatingMode()) {
            bPR();
            if (this.hfu != null) {
                this.hfu.cdy();
                this.hfu.cdC();
            }
            if (this.hCB != null) {
                this.hCB.enterForeground();
            }
            if (this.hCJ != null) {
                this.hCJ.onResume();
            }
            if (this.hCK != null) {
                this.hCK.onResume();
            }
            com.baidu.live.core.layer.b.DE().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.hCO + " mWebOver=" + this.hCw + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        cih();
        if ((!this.hCw || !isFloatingMode()) && !this.hCO) {
            bPR();
            if (this.hCv) {
                this.hCv = false;
                cii();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            chN();
        }
    }

    public void cii() {
        cdr();
        cia();
        this.hfu.cdN();
        if (!this.hCr.isPlaying()) {
            chO();
        } else if (this.hCr.isPaused()) {
            this.hCr.resume();
        }
        if (this.hCB != null) {
            this.hCB.bWs();
        }
        if (this.hfu != null && this.hfu.GH() != null && this.hfu.GH().mLiveInfo != null) {
            this.hCG.eG(this.hfu.GH().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aEc.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.hCw + ", isFloatingMode=" + isFloatingMode());
        }
        if (cig() || !this.hCw || !isFloatingMode()) {
            if (this.hfu != null) {
                this.hfu.cdz();
                this.hfu.cdD();
            }
            if (this.hCB != null) {
                this.hCB.enterBackground();
            }
            com.baidu.live.core.layer.b.DE().onPause();
        }
    }

    public void T(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.hCV);
        }
        if (!cig() && z && !this.hCV && chI()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0628a() { // from class: com.baidu.tieba.ala.player.b.12
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0628a
                    public boolean a(SdkLivePlayer sdkLivePlayer) {
                        if (sdkLivePlayer != null) {
                            sdkLivePlayer.aNl();
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
        this.hCv = true;
        nW(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void nW(boolean z) {
        this.mHandler.removeCallbacks(this.hjc);
        this.mHandler.removeCallbacks(this.hCW);
        this.mHandler.removeCallbacks(this.hCX);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.hCr.isFloatingMode()) {
                this.hCr.aNl();
            }
        } else if (!z && !this.hCr.isFloatingMode()) {
            this.hCr.aNl();
        }
        if (this.hCB != null) {
            this.hCB.bWr();
        }
        this.hCG.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ak.GV() != null) {
                ak.GV().a(i, i2, intent, this.aEc, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.hCB != null) {
            this.hCB.onActivityResult(i, i2, intent);
        }
    }

    public boolean cij() {
        return this.hCA != null && this.hCA.bPH();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hDm != null) {
            MessageManager.getInstance().unRegisterListener(this.hDm);
        }
        if (this.hDn != null) {
            MessageManager.getInstance().unRegisterListener(this.hDn);
        }
        MessageManager.getInstance().unRegisterListener(this.hDo);
        MessageManager.getInstance().unRegisterListener(this.hDp);
        MessageManager.getInstance().unRegisterListener(this.hDq);
        MessageManager.getInstance().unRegisterListener(this.hDr);
        MessageManager.getInstance().unRegisterListener(this.hDi);
        MessageManager.getInstance().unRegisterListener(this.gRW);
        MessageManager.getInstance().unRegisterListener(this.hDb);
        MessageManager.getInstance().unRegisterListener(this.hDc);
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        if (this.hDd != null) {
            this.hDd.release();
        }
        if (this.hCr != null && !this.hCr.isFloatingMode()) {
            this.hCr.cn(true);
        }
        if (this.hCp != null) {
            this.hCp.onDestory();
        }
        if (this.hgs != null) {
            this.hgs.release();
            this.hgs = null;
        }
        if (this.hCq != null) {
            this.hCq.reset();
        }
        if (this.hCB != null) {
            this.hCB.onDestroy();
        }
        if (this.hCo != null) {
            this.hCo.onDestroy();
        }
        if (this.hCm != null) {
            this.hCm.TS();
            this.hCm.release();
            this.hCm = null;
        }
        if (this.hCA != null) {
            this.hCA.onDestroy();
        }
        if (this.hCH != null && this.hfu != null && this.hfu.GH() != null) {
            long j = this.hfu.GH().mLiveInfo.live_id;
            if (this.hCH.liveId == j && this.hCH.startTime > 0) {
                this.hCH.endTime = System.currentTimeMillis();
                long j2 = this.hCH.endTime - this.hCH.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hCH.roomId + "", this.hCH.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.hCH = null;
        }
        if (this.hfN != null) {
            this.hfN.cfu();
            this.hfN = null;
        }
        if (this.hfu != null) {
            this.hfu.destory();
        }
        if (this.hgr != null) {
            this.hgr.release();
        }
        z.GB().release();
        if (this.hCK != null) {
            this.hCK.release();
        }
        x.Gz().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String Md() {
        return this.otherParams;
    }

    public void nX(boolean z) {
        this.hCO = z;
    }

    public void cik() {
        if (this.hCE != null) {
            this.otherParams = this.hCE.toString();
            if (this.hfu != null) {
                this.hfu.setOtherParams(this.otherParams);
            }
            if (this.hCB != null) {
                this.hCB.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.hCA != null) {
                this.hCA.setOtherParams(this.otherParams);
            }
        }
    }

    public void cil() {
        if (this.hCE != null) {
            String optString = this.hCE.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hCE.put("tab", "live_jump");
                        this.hCE.put("tag", "");
                        this.hCE.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.hCE.put("tab", "liveroom");
                        this.hCE.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cik();
            }
        }
    }

    private void f(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.Kc();
        }
        bVar.setAnchorId(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void cim() {
        ab.GR();
    }

    private void k(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hCB.e(s);
        } else {
            this.hCB.f(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
