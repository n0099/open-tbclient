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
    private static int hIQ = 1;
    private static WeakReference<b> mRef;
    private w aES;
    private com.baidu.live.s.b bHH;
    private CustomMessageListener bek;
    private boolean bgd;
    private long bnV;
    private String bnW;
    private boolean brE;
    private String gUi;
    CustomMessageListener gYb;
    private long hIA;
    private JSONObject hIB;
    private boolean hIC;
    private com.baidu.tieba.ala.liveroom.task.c hID;
    private StayTimeBean hIE;
    private boolean hIF;
    private com.baidu.tieba.ala.liveroom.k.a hIG;
    private com.baidu.tieba.ala.liveroom.w.c hIH;
    private boolean hII;
    private boolean hIJ;
    private String hIK;
    private boolean hIL;
    private bo hIM;
    private boolean hIN;
    private boolean hIO;
    private int hIP;
    private boolean hIR;
    private boolean hIS;
    private Runnable hIT;
    private Runnable hIU;
    private Runnable hIV;
    private boolean hIW;
    private boolean hIX;
    private CustomMessageListener hIY;
    private CustomMessageListener hIZ;
    private a hIh;
    private SafeFrameLayout hIi;
    private AlaLiveRoomBlurPageLayout hIj;
    private AlaLoopViewPager hIk;
    private AlaLoopViewPagerAdapter hIl;
    private com.baidu.tieba.ala.liveroom.e.a hIm;
    private com.baidu.tieba.ala.liveroom.e.b hIn;
    private SdkLivePlayer hIo;
    private AlaLastLiveroomInfo hIp;
    private boolean hIq;
    private boolean hIr;
    private boolean hIs;
    private boolean hIt;
    @Deprecated
    private boolean hIu;
    private ArrayList<AlaBroadcastGiftToastData> hIv;
    private String hIw;
    private com.baidu.tieba.ala.endliveroom.a hIx;
    private com.baidu.tieba.ala.liveroom.d.c hIy;
    private String hIz;
    private com.baidu.live.ad.c hJa;
    private boolean hJb;
    private boolean hJc;
    private long hJd;
    private long hJe;
    private CustomMessageListener hJf;
    private com.baidu.live.s.a hJg;
    com.baidu.live.liveroom.a.c hJh;
    ViewPager.OnPageChangeListener hJi;
    HttpMessageListener hJj;
    CustomMessageListener hJk;
    CustomMessageListener hJl;
    CustomMessageListener hJm;
    CustomMessageListener hJn;
    private CustomMessageListener hJo;
    private AlaLiveView hlI;
    private ViewGroup hlJ;
    private LayerRootView hlK;
    private long hlO;
    private d.a hlY;
    private com.baidu.tieba.ala.liveroom.q.d hlq;
    private com.baidu.live.r.d hmm;
    private com.baidu.live.r.c hmn;
    private Runnable hoT;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void ckf() {
        if (this.hIH != null) {
            this.hIH.bu(this.bgd);
        }
        if (this.hIG != null) {
            this.hIG.bu(this.bgd);
        }
        if (aj.Hw() != null) {
            aj.Hw().bu(this.bgd);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hIq = true;
        this.hlO = 0L;
        this.hIr = false;
        this.brE = true;
        this.bnW = "";
        this.mForumName = "";
        this.hIs = false;
        this.hIu = false;
        this.hIw = "0";
        this.mHandler = new Handler();
        this.hIA = -1L;
        this.otherParams = "";
        this.hIC = false;
        this.hID = com.baidu.tieba.ala.liveroom.task.c.chq();
        this.hIF = false;
        this.hIJ = false;
        this.hIL = false;
        this.hIO = false;
        this.hIP = 0;
        this.hIR = false;
        this.hIS = false;
        this.hoT = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cfS();
            }
        };
        this.hIT = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.ckC();
            }
        };
        this.hIU = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.hlq.cgo();
            }
        };
        this.hIV = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.gYb = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hIW = true;
            }
        };
        this.hIY = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hIX = true;
            }
        };
        this.hIZ = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.hJf = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bgd = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.ckf();
            }
        };
        this.bek = new CustomMessageListener(2501059) { // from class: com.baidu.tieba.ala.player.b.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_video_activity")) {
                    b.this.S(false, false);
                }
            }
        };
        this.bHH = new com.baidu.live.s.b() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.s.b
            public void dM(int i) {
                if (b.this.hIy != null) {
                    b.this.hIy.dM(i);
                }
            }
        };
        this.hJg = new com.baidu.live.s.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.s.a
            public void cn(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.hIo != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.hIo.isPlaying());
                        if (b.this.hIo.isPlaying()) {
                            if (b.this.hIo.isPaused()) {
                                b.this.hIo.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.hIo.isPlaying()) {
                        b.this.hIo.pause();
                    }
                }
            }
        };
        this.hJh = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void ce(boolean z) {
                if (z || b.this.hIy == null || b.this.hIy.bYR()) {
                    if (!b.this.ckn() || b.this.a(true, (a.InterfaceC0640a) null)) {
                        b.this.hIS = true;
                        b.this.oe(true);
                        b.this.bWc();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cf(boolean z) {
                b.this.d(b.this.aES, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.hIo.ckT();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.hIs) {
                    if (b.this.hIs) {
                        b.this.hIo.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.hIo.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.hIk != null) {
                    b.this.hIk.setIsScrollable(b.this.hIN && z);
                    b.this.hIk.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cg(boolean z) {
                boolean z2 = true;
                if (!z || b.this.ckL()) {
                    if (b.this.hIj != null) {
                        b.this.hIj.chT();
                        return;
                    }
                    return;
                }
                if (b.this.hlq.Hi().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.hIj != null) {
                    b.this.hIj.nN(z2);
                }
            }
        };
        this.hJi = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.hIk != null && i == 0) {
                    b.this.cky();
                    com.baidu.live.d.AZ().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.hlY = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.q.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.K(b.this.hlq.Hi());
                } else if (i2 == 2) {
                    b.this.f(b.this.hlq.bRq());
                } else if (i2 == 3) {
                    b.this.br(i, str2);
                } else if (i2 == 4) {
                    b.this.aH(obj);
                } else if (i2 == 5) {
                    b.this.ckB();
                }
            }
        };
        this.hJj = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.cho() != null && b.this.mTbPageContext != null) {
                        b.this.hID.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.cho());
                    }
                }
            }
        };
        this.hJk = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
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
        this.hJl = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.hlq != null && b.this.hlq.Hi() != null && b.this.hlq.Hi().mLiveInfo != null) {
                    long j = b.this.hlq.Hi().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.hJa != null) {
                        b.this.hJa.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.hJm = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.hlq != null && b.this.hlq.Hi() != null && b.this.hlq.Hi().aJr != null) {
                        if (l.longValue() == b.this.hlq.Hi().aJr.userId) {
                            b.this.hlq.Hi().aJr.isNewUser = false;
                            if (b.this.hIG != null) {
                                b.this.hIG.n(b.this.hlq.Hi());
                            }
                        }
                    }
                }
            }
        };
        this.hJn = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.u.a)) {
                    com.baidu.tieba.ala.liveroom.u.a aVar2 = (com.baidu.tieba.ala.liveroom.u.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String Ei = aVar2.Ei();
                    if (b.this.mTbPageContext != null && b.this.hlq != null && b.this.hlq.Hi() != null && b.this.hlq.Hi().aJr != null) {
                        if (valueOf.longValue() == b.this.hlq.Hi().aJr.userId && com.baidu.live.aa.a.PQ().btT != null && com.baidu.live.aa.a.PQ().btT.aPv != null && com.baidu.live.aa.a.PQ().btT.aPv.EQ()) {
                            g.vG(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, Ei));
                        }
                    }
                }
            }
        };
        this.hJo = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.hoT != null) {
                    b.this.mHandler.removeCallbacks(b.this.hoT);
                }
                b.this.cfS();
            }
        };
        this.hlO = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.hIh = aVar;
        this.hIq = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ad.c.class);
        if (runTask != null) {
            this.hJa = (com.baidu.live.ad.c) runTask.getData();
        }
        this.hlq = new com.baidu.tieba.ala.liveroom.q.d(getPageContext());
        this.hlq.a(this.hlY);
        this.hlq.Io(str);
        this.hIx = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hJj);
        MessageManager.getInstance().registerListener(this.hJk);
        MessageManager.getInstance().registerListener(this.hJl);
        MessageManager.getInstance().registerListener(this.hJm);
        MessageManager.getInstance().registerListener(this.hJn);
        MessageManager.getInstance().registerListener(this.hJo);
        MessageManager.getInstance().registerListener(this.hJf);
        MessageManager.getInstance().registerListener(this.gYb);
        MessageManager.getInstance().registerListener(this.hIY);
        MessageManager.getInstance().registerListener(this.hIZ);
        MessageManager.getInstance().registerListener(this.bek);
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.hIv = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hIv.add(alaBroadcastGiftToastData);
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
        this.bnW = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bnW)) {
            this.bnW = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        if (z) {
            this.hIz = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.hIz = intent.getStringExtra("room_id");
        }
        this.bnV = intent.getLongExtra("live_id", 0L);
        this.hIC = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.hlq.b((AlaLiveInfoCoreData) serializableExtra);
            this.hIC = true;
        }
        this.hlq.setIsMixLive(z);
        TbConfig.liveScene = 1;
        c(intent, z);
        this.hIN = this.hIM == null || !this.hIM.aPL;
        this.hIx.setOtherParams(this.otherParams);
        oc(z);
        ckg();
        this.mHandler.removeCallbacks(this.hIV);
        this.mHandler.postDelayed(this.hIV, 1000L);
    }

    private void c(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.hIP = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.gUi = null;
            if (z) {
                stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_EXTRA_PARAMS);
            } else {
                stringExtra = intent.getStringExtra("params");
            }
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hIB = new JSONObject(stringExtra);
                if (this.hIB != null) {
                    String optString2 = this.hIB.optString("enterRoomId");
                    String optString3 = this.hIB.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hIz, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bnV + "", optString3))) {
                        String optString4 = this.hIB.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString5 = this.hIB.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString5);
                        if (!this.hIC) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bnV;
                            alaLiveInfoCoreData.screenDirection = this.hIB.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.hlq.b(alaLiveInfoCoreData);
                            this.hIC = true;
                        }
                    }
                    String optString6 = this.hIB.optString("extra");
                    try {
                        this.hJd = Long.parseLong(this.hIz);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.hJe = this.bnV;
                    if (TextUtils.isEmpty(optString6)) {
                        this.hIM = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.hlq != null) {
                            this.hlq.HL(optString7);
                        }
                        this.hJb = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.hJc = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.gUi = jSONObject.optString("live_back_scheme");
                        this.hIM = new bo();
                        this.hIM.aPL = jSONObject.optInt("is_hot") == 1;
                        if (this.hIM.aPL) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hIP = AlaLiveSwitchData.isHotLive;
                        this.hIM.aPM = jSONObject.optString("task_id");
                        this.hIM.aPK = !TextUtils.isEmpty(this.hIM.aPM);
                        this.hIM.aPN = jSONObject.optInt("task_type");
                        this.hIM.aPO = jSONObject.optInt("task_im_count");
                        this.hIM.aPP = jSONObject.optLong("task_gift_total_price");
                        this.hIM.aPQ = jSONObject.optLong("task_watch_time");
                        this.hIM.aPR = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.hIB.put("from", optString);
                        }
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.hIn = new com.baidu.tieba.ala.liveroom.e.b();
                            this.hIn.setScheme(optString8);
                            this.hIn.setImageUrl(optString9);
                            this.hIn.setTitle(optString10);
                        }
                    }
                    this.hIw = this.hIB.optString("open_giftlist");
                    this.hIB.remove("cover");
                    this.hIB.remove("live_url");
                    this.hIB.remove("enterRoomId");
                    this.hIB.remove("enterLiveId");
                    this.hIB.remove("open_giftlist");
                    this.hIB.remove("extra");
                    this.otherParams = this.hIB.toString();
                    if (this.hlq != null) {
                        this.hlq.setOtherParams(this.otherParams);
                    }
                    this.hIB.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIB.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIB.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hIB.optString("source");
                    }
                    this.hIO = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hIB.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.hlq != null) {
                        this.hlq.wf(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hIp = new AlaLastLiveroomInfo();
                this.hIp.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bnV), String.valueOf(this.hIz), null, ckv());
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

    public void ckg() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.hlq.ar(this.uk, this.bnW, this.mForumName);
        } else if (this.hlq.Hi() != null && this.hlq.Hi().mLiveInfo != null && this.hlq.Hi().mLiveInfo.live_id > 0) {
            this.hlq.a(this.hlq.Hi().mLiveInfo.live_id, false, this.bnW, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bnW = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                oe(false);
                return;
            }
            this.hlq.ar(this.uk, this.bnW, this.mForumName);
        } else if (!TextUtils.isEmpty(this.hIz)) {
            this.hlq.In(this.hIz);
        } else if (this.bnV > 0) {
            this.hlq.a(this.bnV, false, this.bnW, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            oe(false);
        }
    }

    private void oc(boolean z) {
        this.brE = true;
        this.hIr = false;
        od(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.DX().n(this.hlK);
        this.hIy = new com.baidu.tieba.ala.liveroom.d.c();
        this.hIy.a(this.hJh);
        this.hIy.setOtherParams(this.otherParams);
        this.hIy.mM(this.hIO);
        this.hIy.a(this.hIh.ckd());
        ckj();
        ckh();
        cki();
    }

    private void od(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_main_layout, (ViewGroup) null);
        this.hIi = (SafeFrameLayout) inflate.findViewById(a.f.live_root_view);
        this.hIk = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.hIk.setOnPageChangeListener(this.hJi);
        this.hIk.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void cdD() {
                b.this.cky();
            }
        });
        this.hIk.setBoundaryCaching(true);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.hIl = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.hIl.cdB();
        this.hIj = this.hIl.vM(this.mSelectedPosition);
        this.hIl.a(this.mSelectedPosition, this.hlq.Hi());
        this.hIk.setAdapter(this.hIl);
        this.hIk.setCurrentItem(this.mSelectedPosition);
        this.hIk.setIsScrollable(this.hIN);
        this.hIk.setIsMixLive(z);
        this.hlJ = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hlK = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
    }

    private void c(Rect rect) {
        this.hIo = SdkLivePlayer.ff(getPageContext().getPageActivity());
        if (this.hIo == null) {
            this.hIk.setIsScrollable(false);
            if (this.hlq != null) {
                this.hlq.cancelLoadData();
            }
            cdF();
            return;
        }
        this.hIo.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.c.sdk_transparent));
        this.hIo.setIPlayerCallBack(this.bHH);
        this.hIo.setIPlayerAudioFocusCallBack(this.hJg);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hIj.a(this.hIo, layoutParams, true);
    }

    private void ckh() {
        this.hIm = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.hlJ);
    }

    private void cki() {
        CustomResponsedMessage runTask;
        if (this.hmn == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.r.c.class)) != null) {
            this.hmn = (com.baidu.live.r.c) runTask.getData();
        }
        if (this.hmn != null) {
            this.hmn.setParentView(this.hlJ);
        }
    }

    private void cdF() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.oe(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.hlI = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.ala_liveroom_player_layout, null);
        this.hlI.setSwipeClearEnable(true);
        this.hlI.hwh = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hIj.a(this.hlI, layoutParams);
    }

    private void ckj() {
        if (this.hlq != null && this.hlq.Hi() != null) {
            this.aES = this.hlq.Hi();
            if (this.aES.mLiveInfo != null) {
                a(this.aES.mLiveInfo, this.hIC);
                if (this.aES.mLiveInfo != null && this.aES.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hIs);
                    }
                    if (!this.hIs) {
                        this.hIo.c(this.aES.mLiveInfo);
                    } else {
                        this.hIo.setPlayLiveInfo(this.aES.mLiveInfo);
                    }
                    if (this.hIy != null) {
                        this.hIy.a(this.mTbPageContext, this.hlI, this.hIo, this.hIj, this.hlq, this.bnW, this.hIu, this.hlO, this.hIv, this.hIM, this.hIk);
                        k(this.aES.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean ckk() {
        boolean z;
        AlaLiveInfoData cgx;
        if (this.hIh.ckc()) {
            return false;
        }
        if (this.hlq == null || (cgx = this.hlq.cgx()) == null || cgx.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !cgx.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.hJd + ", getPlayingRoomID:" + ckl() + ", mSchemeLiveId:" + this.hJe + ", getPlayingLiveID:" + ckm());
        }
        return z || cko();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ckl() {
        AlaLiveInfoData cgx;
        if (this.hlq == null || (cgx = this.hlq.cgx()) == null) {
            return 0L;
        }
        return cgx.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ckm() {
        AlaLiveInfoData cgx;
        if (this.hlq == null || (cgx = this.hlq.cgx()) == null) {
            return 0L;
        }
        return cgx.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ckn() {
        boolean z = false;
        if (!this.hIh.ckc()) {
            if (this.hJb && (this.hJd == ckl() || this.hJe == ckm())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean cko() {
        boolean z = this.hJc && (this.hJd == ckl() || this.hJe == ckm());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean ckp() {
        if (hIQ <= 0) {
            return false;
        }
        if (!(ckn() || ckk()) || FloatPermissionUtil.NP()) {
            return false;
        }
        hIQ--;
        FloatPermissionUtil.al(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0640a interfaceC0640a) {
        if (!FloatPermissionUtil.NP()) {
            if (this.hIR) {
                return true;
            }
            this.hIR = true;
            if (z) {
                FloatPermissionUtil.al(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (ckn()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.hJc) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a fa = com.baidu.tieba.ala.floating.b.fa(getPageContext().getPageActivity());
        fa.a(interfaceC0640a);
        fa.dF(jSONObject);
        com.baidu.tieba.ala.floating.b.fa(getPageContext().getPageActivity()).a(this.hIo, this.hlq.Hi(), this.bnW, this.hlO);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bSr() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bSm = com.baidu.tieba.ala.floating.b.bSm();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0640a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0640a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bSm == null || bSm.room_id == b.this.ckl() || bSm.live_id == b.this.ckm()) {
                    if (b.this.hIo != null) {
                        b.this.ckq();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.hIs);
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
    public void ckq() {
        ArrayList arrayList = (ArrayList) this.hIo.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.hIo.ckS();
            this.hIo.ak(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bSp();
    }

    public void oa(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.hIt = z;
    }

    private void ckr() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hIN) {
                this.hIk.setIsScrollable(true);
            } else {
                this.hIk.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.DX().onBackPressed() && ((this.hIy == null || !this.hIy.onKeyDown(i, keyEvent)) && (this.hIy == null || !this.hIy.bYQ()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                ckr();
            } else if ((this.hIy == null || this.hIy.bYR()) && (!ckn() || a(true, (a.InterfaceC0640a) null))) {
                this.hIS = true;
                oe(true);
                bWc();
            }
        }
        return true;
    }

    public void bWc() {
        if (!TextUtils.isEmpty(this.gUi)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gUi);
                this.gUi = null;
            }
        }
    }

    public void oe(boolean z) {
        S(z, false);
    }

    public void S(boolean z, boolean z2) {
        mR(!z);
        if (this.hIo != null && !this.hIo.isFloatingMode()) {
            this.hIo.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.DX().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        ckt();
        long j = -1;
        if (this.hlq != null && this.hlq.cgx() != null) {
            j = this.hlq.cgx().room_id;
        }
        this.hIh.b(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void mR(boolean z) {
        if (this.hIh.ckc() && this.hIh.ckd() != null) {
            this.hIh.ckd().A("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hIp = null;
        if (aj.Hw() != null) {
            aj.Hw().Hv();
        }
        com.baidu.live.core.layer.b.DX().DY();
        if (this.hJa != null) {
            this.hJa.release();
        }
        if (this.hIG != null) {
            this.hIG.release();
        }
        this.hIM = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.hlq != null) {
            try {
                this.hlq.HL(null);
                AlaLiveInfoData cgx = this.hlq.cgx();
                if (cgx != null) {
                    this.hlq.eZ(cgx.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.hID.stopRecord();
        LiveTimerManager.getInstance().stop();
        cks();
        if (this.hIo != null && !this.hIo.isFloatingMode()) {
            this.hIo.co(z);
        }
        if (this.hIy != null) {
            this.hIy.mR(z);
        }
        this.hIF = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Nu().bnm != null && this.aES != null) {
            com.baidu.live.liveroom.a.b.Nu().bnm.b(this.aES.mLiveInfo);
        }
        aa.hd("");
        com.baidu.live.gift.w.Ha().release();
        if (this.hmn != null) {
            this.hmn.Ht();
        }
    }

    private void cks() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void ckt() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(w wVar) {
        if (wVar != null) {
            this.aES = wVar;
            if (this.hIy != null) {
                this.hIy.a(wVar);
            }
            ckp();
        }
    }

    private void c(q qVar) {
        if (this.hIy != null) {
            this.hIy.c(qVar);
        }
    }

    private void N(w wVar) {
        this.aES = wVar;
        ckp();
    }

    private void cku() {
        long j;
        String str;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.hIN = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.hIN = true;
        }
        this.hIk.setIsScrollable(this.hIN);
        this.hIP = AlaLiveSwitchData.isHotLive;
        if (this.aES != null) {
            a(this.aES.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.hIj.a(this.hlI, null);
            if (!isFloatingMode()) {
                a(this.hIj, this.aES.mLiveInfo, this.brE);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aES.mLiveInfo.live_id), String.valueOf(this.aES.mLiveInfo.room_id), String.valueOf(this.aES.mLiveInfo.feed_id), ckv());
            if (com.baidu.live.liveroom.a.b.Nu().bnm != null) {
                com.baidu.live.liveroom.a.b.Nu().bnm.a(this.aES.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.brE = false;
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                String str2 = "";
                if (this.hlq != null && this.hlq.Hi() != null && this.hlq.Hi().mLiveInfo != null) {
                    j = this.hlq.Hi().mLiveInfo.live_id;
                    str = this.hlq.Hi().mLiveInfo.room_id + "";
                    str2 = this.hlq.Hi().mLiveInfo.feed_id;
                } else {
                    if (this.bnV > 0) {
                        j2 = this.bnV;
                    }
                    if (TextUtils.isEmpty(this.hIz)) {
                        j = j2;
                        str = "";
                    } else {
                        j = j2;
                        str = this.hIz;
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
                if (this.hlq != null && this.hlq.Hi() != null && this.hlq.Hi().mLiveInfo != null) {
                    str3 = this.hlq.Hi().mLiveInfo.feed_id;
                    str4 = this.hlq.Hi().mLiveInfo.live_id + "";
                    str5 = this.hlq.Hi().mLiveInfo.room_id + "";
                    str6 = this.hlq.Hi().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            ckp();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String ckv() {
        if (this.hIB == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hIB.optString("source");
            String optString2 = this.hIB.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hIB.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hIB.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.hIB.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bSr();
        } else if (this.hIo != null && this.hIo.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.hIo.getVideoPath();
                String d = com.baidu.live.s.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.hIo.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.s.h.aK(videoPath, d)) {
                    this.hIo.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.s.h.aJ(videoPath, d)) {
                    this.hIo.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.ck(this.hIo)) {
                        ((ViewGroup) this.hIo.getParent()).removeView(this.hIo);
                        alaLiveRoomBlurPageLayout.a(this.hIo, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.hIs) {
                        this.hIo.c(alaLiveInfoData);
                        return;
                    } else {
                        this.hIo.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.hIo.ckS();
        } else if (this.hIo != null && this.hIo.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.hIo, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.hIs) {
                    this.hIo.c(alaLiveInfoData);
                } else {
                    this.hIo.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.hIo != null) {
            this.hIo.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = o.v(this.mTbPageContext.getPageActivity());
                layoutParams.height = o.w(this.mTbPageContext.getPageActivity());
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

    public void ckw() {
        this.brE = true;
    }

    public boolean ckx() {
        return this.brE;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        a(UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()), alaLiveInfoData, z);
    }

    private void a(int i, AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (this.hIo != null) {
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
            if (this.hIj != null) {
                this.hIj.setBackgroundColor(0);
            }
            int i3 = this.hIo.getLayoutParams().width;
            int i4 = this.hIo.getLayoutParams().height;
            int i5 = this.hIo.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.hIo.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i3 || b.height != i4 || b.topMargin != i5) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.hlI != null) {
                this.hlI.setLayoutParams(c);
            }
            if (this.hIj != null) {
                this.hIj.D(screenFullSize[0], screenFullSize[1]);
            }
            if (this.hIx != null) {
                this.hIx.D(screenFullSize[0], screenFullSize[1]);
            }
            if (this.hIy != null) {
                this.hIy.l(c.width, c.height, realScreenOrientation);
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

    private void wC(int i) {
        boolean z = true;
        if (this.aES != null && this.aES.mLiveInfo != null) {
            if (this.hIj != null) {
                this.hIj.setBgImageUrl(this.aES.mLiveInfo.cover, this.aES.mLiveInfo);
            }
            this.hIl.a(this.mSelectedPosition, ckz(), this.aES);
            this.hIl.b(this.mSelectedPosition, ckA(), this.aES);
            if (this.hIj != null) {
                this.hIj.requestLayout();
                this.hIj.M(i, this.aES.mLiveInfo.screen_direction == 2);
            }
        }
        if (this.aES != null) {
            a(i, this.aES.mLiveInfo, false);
        }
        boolean chU = this.hIj.chU();
        boolean z2 = i == 1;
        if (this.aES == null || this.aES.mLiveInfo == null || this.aES.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!ckL()) {
            if (this.hIo != null && this.hIo.getParent() == null) {
                this.hIj.a(this.hIo, null, false);
                if (this.aES != null && this.aES.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.hIs) {
                        this.hIo.c(this.aES.mLiveInfo);
                    } else {
                        this.hIo.setPlayLiveInfo(this.aES.mLiveInfo);
                    }
                }
            }
            if (chU && !ckL() && this.hIy != null) {
                this.hIj.nN(z);
                return;
            }
            return;
        }
        this.hIj.chQ();
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
            this.hlq.a(alaLiveInfoData.live_id, true, this.bnW, this.mForumName, this.hIP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cky() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.hIk != null && this.hlI != null && this.mSelectedPosition != (currentItem = this.hIk.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.h.sdk_neterror);
                this.hIk.setCurrentItem(this.mSelectedPosition);
            } else if (!this.brE && ListUtils.getCount(this.hlq.cgn()) <= 1) {
                this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                this.hIk.setCurrentItem(this.mSelectedPosition);
                this.hlq.g(this.hlq.cgx());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.hlq.cgs() && i < 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                    this.hIk.setCurrentItem(this.mSelectedPosition);
                } else if (this.hlq.cgt() && i > 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                    this.hIk.setCurrentItem(this.mSelectedPosition);
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.hlq.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    mR(true);
                    this.hIj.chQ();
                    this.hIj.Ws();
                    this.hIj.chR();
                    if (this.hlq.Hi() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.hlq.Hi().mLiveInfo.live_id + "", this.hlq.Hi().mLiveInfo.room_id + "", this.hlq.Hi().aIV.userId + "", this.hlq.Hi().aIV.userName, System.currentTimeMillis(), this.hlq.Hi().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.hlq.Hi().mLiveInfo.live_id + "", this.hlq.Hi().mLiveInfo.room_id + "", this.hlq.Hi().aIV.userId + "", this.hlq.Hi().aIV.userName, System.currentTimeMillis(), this.hlq.Hi().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.hIE != null) {
                        long j = this.hlq.Hi().mLiveInfo.live_id;
                        if (this.hIE.liveId == j && this.hIE.startTime > 0) {
                            this.hIE.endTime = System.currentTimeMillis();
                            long j2 = this.hIE.endTime - this.hIE.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hIE.roomId + "", this.hIE.vid, j2 / 1000, this.otherParams);
                        }
                        this.hIE = null;
                    }
                    ckN();
                    if (this.hJa != null) {
                        this.hJa.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.hIj = this.hIl.vN(this.mSelectedPosition);
                    this.hIj.chS();
                    wD(i);
                    ckp();
                }
            }
        }
    }

    public void wD(int i) {
        if (i < 0) {
            this.hlq.wg(this.hlq.cgu() - 1);
        } else if (i > 0) {
            this.hlq.wg(this.hlq.cgu() + 1);
        }
        if (this.hIy != null) {
            this.hIy.a(this.hIj);
        }
        this.hIl.a(this.mSelectedPosition, ckz(), this.aES);
        this.hIl.b(this.mSelectedPosition, ckA(), this.aES);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.hlq != null) {
            int cgu = this.hlq.cgu();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", cgu + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.hlq.cgn() != null && this.hlq.cgn().size() > cgu && this.hlq.cgn().get(cgu) != null) {
                AlaLiveInfoData alaLiveInfoData = this.hlq.cgn().get(cgu);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hlq != null) {
            AlaLiveInfoData cgx = this.hlq.cgx();
            if (cgx != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(cgx.live_id), String.valueOf(cgx.room_id), null, ckv());
                cgx.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bSr();
                }
                a(this.hIj, cgx, this.brE);
                this.brE = false;
                if (this.hIy != null) {
                    this.hIy.a(this.mTbPageContext, this.hlI, this.hIo, this.hIj, this.hlq, this.bnW, this.hIu, this.hlO, null, this.hIM, this.hIk);
                    short s = 2;
                    if (cgx.screen_direction == 2) {
                        s = 1;
                    }
                    k(s);
                }
                a(cgx, false);
            }
            i(cgx);
            this.hIj.a(this.hlI, null);
            if (this.hIy != null) {
                this.hIy.bYO();
            }
            this.hlq.g(cgx);
        }
    }

    private AlaLiveInfoData ckz() {
        List<AlaLiveInfoData> cgn = this.hlq.cgn();
        if (cgn == null || cgn.size() == 0) {
            if (this.aES == null) {
                return null;
            }
            return this.aES.mLiveInfo;
        }
        int cgu = this.hlq.cgu();
        int size = cgn.size();
        return cgn.get(((cgu + size) - 1) % size);
    }

    private AlaLiveInfoData ckA() {
        List<AlaLiveInfoData> cgn = this.hlq.cgn();
        if (cgn == null || cgn.size() == 0) {
            if (this.aES == null) {
                return null;
            }
            return this.aES.mLiveInfo;
        }
        return cgn.get((this.hlq.cgu() + 1) % cgn.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(int i, String str) {
        CustomResponsedMessage runTask;
        TbConfig.liveScene = 1;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hIs) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            oe(false);
            return;
        }
        w Hi = this.hlq.Hi();
        N(Hi);
        this.hlq.cgo();
        if (this.brE) {
            this.hlq.nF(false);
        }
        this.hlO = System.currentTimeMillis() / 1000;
        if (this.hIy != null) {
            this.hIy.a(this.mTbPageContext, this.hlI, this.hIo, this.hIj, this.hlq, this.bnW, this.hIu, this.hlO, this.hIv, this.hIM, this.hIk);
            short s = 2;
            if (Hi.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            k(s);
        }
        if (this.hIh.ckd() != null && this.hIh.ckc()) {
            this.hIh.ckd().A("load_finish", null);
            if (Hi.mLiveInfo.screen_direction == 2) {
                this.hIh.ckd().A("screen_auto_rotate", true);
            } else {
                this.hIh.ckd().A("screen_auto_rotate", false);
            }
        }
        cku();
        if (Hi != null && Hi.mLiveInfo != null && Hi.mLiveInfo.live_status == 2) {
            this.hIl.a(this.mSelectedPosition, this.hlq.Hi());
            d(Hi, false);
            this.brE = false;
            return;
        }
        if (this.hmm == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.r.d.class)) != null) {
            this.hmm = (com.baidu.live.r.d) runTask.getData();
        }
        if (this.hmm != null) {
            this.hmm.OO();
        }
        boolean z = (this.hIy == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ac.a.b.Qx().cy(com.baidu.live.aa.a.PQ().bod != null && com.baidu.live.aa.a.PQ().bod.aNz && Hi != null && Hi.aJO);
        aa.d(Hi);
        if (z) {
            if (!this.hIJ || !TextUtils.equals(p.UL(), this.hIK)) {
                aa.b(getPageContext(), false);
                e.Qe().Qf();
                this.hIJ = true;
                this.hIK = p.UL();
            }
            aa.hd("");
            aa.Hp();
        }
        if (this.hlq.Hi() != null && this.hlq.Hi().mLiveInfo != null) {
            this.hlq.h(this.hlq.Hi().mLiveInfo.live_id, !this.hIF);
            this.hIF = true;
        }
        if (this.hIy != null) {
            this.hIy.b(this.hIp);
            this.hIy.mQ(TextUtils.equals(this.hIw, "1"));
            this.hIw = "";
        }
        if (this.hIm != null) {
            this.hIm.a(this.aES, this.hIn);
        }
        a(this.hlq.Hi());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.hlq.Hi() != null && b.this.hlq.Hi().mLiveInfo != null) {
                    b.this.hlq.a(b.this.hlq.Hi().mLiveInfo.live_id, b.this.bnW, b.this.hlO);
                }
            }
        });
        if (z && this.hlq.Hi() != null && this.hlq.Hi().aIV != null) {
            bn bnVar = com.baidu.live.aa.a.PQ().btT;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bnVar != null && bnVar.aPA != null && bnVar.aPA.aRQ) {
                f(true, this.hlq.Hi().aIV.userId);
            }
        }
        this.brE = false;
        if (z && this.hlq.Hi() != null && this.hlq.Hi().mLiveInfo != null && this.hlq.Hi().aIV != null && this.hIy != null) {
            long j = this.hlq.Hi().mLiveInfo.live_id;
            long j2 = this.hlq.Hi().mLiveInfo.room_id;
            String str2 = this.hlq.Hi().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (aj.Hw() != null) {
                    aj.Hw().bu(this.bgd);
                    if (!this.bgd) {
                        aj.Hw().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.hJa != null) {
                    this.hJa.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.KE() != null) {
                com.baidu.live.guardclub.e.KE().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.hIG == null) {
                this.hIG = new com.baidu.tieba.ala.liveroom.k.a();
                this.hIG.bu(this.bgd);
            }
            if (!this.bgd) {
                this.hIG.a(this.mTbPageContext.getPageActivity(), this.hlq.Hi(), this.otherParams);
            }
        }
        if (this.hIH == null) {
            this.hIH = new com.baidu.tieba.ala.liveroom.w.c(this.mTbPageContext);
            this.hIH.bu(this.bgd);
        }
        if (z && this.hlq.Hi() != null && this.hlq.Hi().aJr != null && !this.hII) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.hIH.a(this.hlq.Hi(), this.hlq.Hi().aJr.userId);
                this.hII = true;
            }
        }
        if (this.hlq.Hi() != null && this.hlq.Hi().mLiveInfo != null && this.hlq.Hi().aJr != null) {
            com.baidu.live.n.a.b(this.hlq.Hi().mLiveInfo.live_id, this.hlq.Hi().aJr.needRename == 1);
            if (z) {
                com.baidu.live.n.a.b(this.hlq.Hi().mLiveInfo.live_id, 0);
            }
        }
        if (this.hmn != null && this.hlq.Hi() != null && this.hlq.Hi().aIV != null) {
            this.hmn.aF(this.hlq.Hi().aIV.userId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckB() {
        if (this.hIq) {
            this.hIl.a(this.mSelectedPosition, ckz(), this.aES);
            this.hIl.b(this.mSelectedPosition, ckA(), this.aES);
            this.hIq = false;
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
        if (!this.hIs) {
            this.mHandler.removeCallbacks(this.hIU);
            this.mHandler.postDelayed(this.hIU, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (qVar == null) {
            if (!this.hIs) {
                this.mHandler.removeCallbacks(this.hIT);
                this.mHandler.postDelayed(this.hIT, 5000L);
                return;
            }
            return;
        }
        if (!this.hIr) {
            c(qVar);
        }
        if (!this.hIs) {
            this.mHandler.removeCallbacks(this.hIT);
            this.mHandler.postDelayed(this.hIT, qVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckC() {
        if (this.hlq.Hi() != null && this.hlq.Hi().mLiveInfo != null) {
            this.hlq.h(this.hlq.Hi().mLiveInfo.live_id, !this.hIF);
            this.hIF = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.live_status == 2) {
            this.hIl.a(this.mSelectedPosition, this.hlq.Hi());
            d(wVar, false);
        } else if (wVar != null) {
            if (!this.hIr) {
                aa.d(wVar);
                a(wVar);
            }
            if (!this.hIs) {
                this.mHandler.removeCallbacks(this.hoT);
                this.mHandler.postDelayed(this.hoT, wVar.aJa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfS() {
        if (this.mTbPageContext != null && this.hlq.Hi() != null && this.hlq.Hi().mLiveInfo != null) {
            this.hlq.a(this.hlq.Hi().mLiveInfo.live_id, this.bnW, this.hlO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(w wVar, boolean z) {
        String str;
        mR(true);
        if (!ckL()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cgN().nH(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cgN().release();
            this.hlq.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.hIj != null) {
                this.hIj.Ws();
                this.hIj.chQ();
                this.hIj.chV();
            }
            if (wVar == null || wVar.mLiveInfo == null) {
                str = null;
            } else {
                this.hIA = wVar.mLiveInfo.live_id;
                str = String.valueOf(wVar.mLiveInfo.room_id);
            }
            ckr();
            ckD();
            ckE();
            if (this.hIh.ckc() && !StringUtils.isNull(str) && this.hIh.ckd() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.hIh.ckd().A("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (wVar != null) {
                View a2 = (this.hIy == null || this.hIy.bYU() == null) ? null : this.hIy.bYU().a(this.hIy.bYK().pageContext.getPageActivity(), wVar, z);
                if (this.hIj != null) {
                    this.hIx.a(this.hIj, a2, wVar, z, this.hlq.cgp());
                }
                if (this.hIy != null) {
                    this.hIy.mR(false);
                    this.hIy.bYP();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.hIj != null) {
                    this.hIj.chS();
                }
                long j = wVar.mLiveInfo.live_id;
                String str2 = wVar.mLiveInfo.feed_id;
                long j2 = wVar.aIV.userId;
                String str3 = wVar.aIV.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    QMStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", str + "", str2, this.otherParams);
                this.hIE = new StayTimeBean();
                this.hIE.liveId = wVar.mLiveInfo.live_id;
                this.hIE.roomId = wVar.mLiveInfo.room_id;
                this.hIE.vid = wVar.mLiveInfo.feed_id;
                this.hIE.startTime = System.currentTimeMillis();
            }
            ckN();
            if (this.hIm != null) {
                this.hIm.a(this.aES, this.hIn);
            }
        }
    }

    private void ckD() {
    }

    private void ckE() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.hIk);
        }
    }

    public void ckF() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            ckG();
        } else {
            ckH();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.hlq != null && this.hlq.Hi() != null) {
            alaLiveInfoData = this.hlq.Hi().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            ckG();
        } else {
            ckH();
        }
        this.hIk.setIsScrollable(!z && this.hIN);
        if (this.hIy != null) {
            this.hIy.onKeyboardVisibilityChanged(z);
        }
        if (this.hlI != null) {
            this.hlI.onKeyboardVisibilityChanged(z);
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
            ckG();
        } else {
            ckH();
        }
        this.hlI.dI(i);
        wC(i);
        if (aj.Hw() != null) {
            aj.Hw().GI();
        }
        if (this.hIG != null) {
            this.hIG.GI();
        }
        if (this.hIm != null) {
            this.hIm.dI(i);
        }
    }

    public void ckG() {
        if (this.hIk != null) {
            i.ae(this.hIk);
        }
    }

    public void ckH() {
        if (this.hIk != null) {
            i.af(this.hIk);
        }
    }

    private boolean ckI() {
        return this.hIW || this.hIX;
    }

    private void ckJ() {
        this.hIW = false;
        this.hIX = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.hIL + " mWebOver=" + this.hIt + ", isFloatingMode=" + isFloatingMode());
        }
        ckJ();
        if (!this.hIt || !isFloatingMode()) {
            bSr();
            if (this.hlq != null) {
                this.hlq.cfZ();
                this.hlq.cgd();
            }
            if (this.hIy != null) {
                this.hIy.enterForeground();
            }
            if (this.hIG != null) {
                this.hIG.onResume();
            }
            if (this.hIH != null) {
                this.hIH.onResume();
            }
            com.baidu.live.core.layer.b.DX().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.hIL + " mWebOver=" + this.hIt + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        ckJ();
        if ((!this.hIt || !isFloatingMode()) && !this.hIL) {
            bSr();
            if (this.hIs) {
                this.hIs = false;
                ckK();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            ckp();
        }
    }

    public void ckK() {
        cfS();
        ckC();
        this.hlq.cgo();
        if (!this.hIo.isPlaying()) {
            ckq();
        } else if (this.hIo.isPaused()) {
            this.hIo.resume();
        }
        if (this.hIy != null) {
            this.hIy.bYT();
        }
        if (this.hlq != null && this.hlq.Hi() != null && this.hlq.Hi().mLiveInfo != null) {
            this.hID.fc(this.hlq.Hi().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aES.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.hIt + ", isFloatingMode=" + isFloatingMode());
        }
        if (ckI() || !this.hIt || !isFloatingMode()) {
            if (this.hlq != null) {
                this.hlq.cga();
                this.hlq.cge();
            }
            if (this.hIy != null) {
                this.hIy.enterBackground();
            }
            com.baidu.live.core.layer.b.DX().onPause();
        }
    }

    public void T(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.hIS);
        }
        if (!ckI() && z && !this.hIS && ckk()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0640a() { // from class: com.baidu.tieba.ala.player.b.12
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0640a
                    public boolean a(SdkLivePlayer sdkLivePlayer) {
                        if (sdkLivePlayer != null) {
                            sdkLivePlayer.aPL();
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
        this.hIs = true;
        of(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void of(boolean z) {
        this.mHandler.removeCallbacks(this.hoT);
        this.mHandler.removeCallbacks(this.hIT);
        this.mHandler.removeCallbacks(this.hIU);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.hIo.isFloatingMode()) {
                this.hIo.aPL();
            }
        } else if (!z && !this.hIo.isFloatingMode()) {
            this.hIo.aPL();
        }
        if (this.hIy != null) {
            this.hIy.bYS();
        }
        this.hID.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (aj.Hw() != null) {
                aj.Hw().a(i, i2, intent, this.aES, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.hIy != null) {
            this.hIy.onActivityResult(i, i2, intent);
        }
    }

    public boolean ckL() {
        return this.hIx != null && this.hIx.bSh();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hJj != null) {
            MessageManager.getInstance().unRegisterListener(this.hJj);
        }
        if (this.hJk != null) {
            MessageManager.getInstance().unRegisterListener(this.hJk);
        }
        MessageManager.getInstance().unRegisterListener(this.hJl);
        MessageManager.getInstance().unRegisterListener(this.hJm);
        MessageManager.getInstance().unRegisterListener(this.hJn);
        MessageManager.getInstance().unRegisterListener(this.hJo);
        MessageManager.getInstance().unRegisterListener(this.hJf);
        MessageManager.getInstance().unRegisterListener(this.gYb);
        MessageManager.getInstance().unRegisterListener(this.hIY);
        MessageManager.getInstance().unRegisterListener(this.hIZ);
        MessageManager.getInstance().unRegisterListener(this.bek);
        if (this.hJa != null) {
            this.hJa.release();
        }
        if (this.hIo != null && !this.hIo.isFloatingMode()) {
            this.hIo.co(true);
        }
        if (this.hIm != null) {
            this.hIm.onDestory();
        }
        if (this.hmn != null) {
            this.hmn.release();
            this.hmn = null;
        }
        if (this.hIn != null) {
            this.hIn.reset();
        }
        if (this.hIy != null) {
            this.hIy.onDestroy();
        }
        if (this.hIl != null) {
            this.hIl.onDestroy();
        }
        if (this.hIj != null) {
            this.hIj.Ws();
            this.hIj.release();
            this.hIj = null;
        }
        if (this.hIx != null) {
            this.hIx.onDestroy();
        }
        if (this.hIE != null && this.hlq != null && this.hlq.Hi() != null) {
            long j = this.hlq.Hi().mLiveInfo.live_id;
            if (this.hIE.liveId == j && this.hIE.startTime > 0) {
                this.hIE.endTime = System.currentTimeMillis();
                long j2 = this.hIE.endTime - this.hIE.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hIE.roomId + "", this.hIE.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.hIE = null;
        }
        if (this.hlI != null) {
            this.hlI.chX();
            this.hlI = null;
        }
        if (this.hlq != null) {
            this.hlq.destory();
        }
        if (this.hmm != null) {
            this.hmm.release();
        }
        y.Hc().release();
        if (this.hIH != null) {
            this.hIH.release();
        }
        com.baidu.live.gift.w.Ha().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String MD() {
        return this.otherParams;
    }

    public void og(boolean z) {
        this.hIL = z;
    }

    public void ckM() {
        if (this.hIB != null) {
            this.otherParams = this.hIB.toString();
            if (this.hlq != null) {
                this.hlq.setOtherParams(this.otherParams);
            }
            if (this.hIy != null) {
                this.hIy.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.hIx != null) {
                this.hIx.setOtherParams(this.otherParams);
            }
        }
    }

    public void ckN() {
        if (this.hIB != null) {
            String optString = this.hIB.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hIB.put("tab", "live_jump");
                        this.hIB.put("tag", "");
                        this.hIB.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hIB.put("tab", "liveroom");
                        this.hIB.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ckM();
            }
        }
    }

    private void f(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.KC();
        }
        bVar.setAnchorId(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void ckO() {
        aa.Hs();
    }

    private void k(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hIy.e(s);
        } else {
            this.hIy.f(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
