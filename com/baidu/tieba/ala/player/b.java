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
    private static int hqZ = 1;
    private static WeakReference<b> mRef;
    private u aDU;
    private CustomMessageListener bbC;
    private boolean bds;
    private String blg;
    private long blh;
    private boolean boy;
    private com.baidu.live.q.b byF;
    private String gBV;
    CustomMessageListener gGg;
    private com.baidu.tieba.ala.liveroom.q.d gTH;
    private com.baidu.live.p.d gUE;
    private com.baidu.live.p.c gUF;
    private AlaLiveView gUa;
    private ViewGroup gUb;
    private LayerRootView gUc;
    private long gUg;
    private d.a gUq;
    private Runnable gXm;
    private boolean hqA;
    private boolean hqB;
    @Deprecated
    private boolean hqC;
    private ArrayList<AlaBroadcastGiftToastData> hqD;
    private String hqE;
    private com.baidu.tieba.ala.endliveroom.a hqF;
    private com.baidu.tieba.ala.liveroom.d.c hqG;
    private String hqH;
    private long hqI;
    private JSONObject hqJ;
    private boolean hqK;
    private com.baidu.tieba.ala.liveroom.task.c hqL;
    private StayTimeBean hqM;
    private boolean hqN;
    private com.baidu.tieba.ala.liveroom.k.a hqO;
    private com.baidu.tieba.ala.liveroom.w.c hqP;
    private boolean hqQ;
    private boolean hqR;
    private String hqS;
    private boolean hqT;
    private boolean hqU;
    private bk hqV;
    private boolean hqW;
    private boolean hqX;
    private int hqY;
    private a hqp;
    private SafeFrameLayout hqq;
    private AlaLiveRoomBlurPageLayout hqr;
    private AlaLoopViewPager hqs;
    private AlaLoopViewPagerAdapter hqt;
    private com.baidu.tieba.ala.liveroom.e.a hqu;
    private com.baidu.tieba.ala.liveroom.e.b hqv;
    private SdkLivePlayer hqw;
    private AlaLastLiveroomInfo hqx;
    private boolean hqy;
    private boolean hqz;
    private boolean hra;
    private boolean hrb;
    private Runnable hrc;
    private Runnable hrd;
    private Runnable hre;
    private boolean hrf;
    private boolean hrg;
    private CustomMessageListener hrh;
    private CustomMessageListener hri;
    private com.baidu.live.z.c hrj;
    private boolean hrk;
    private boolean hrl;
    private long hrm;
    private long hrn;
    private CustomMessageListener hro;
    private com.baidu.live.q.a hrp;
    com.baidu.live.liveroom.a.c hrq;
    ViewPager.OnPageChangeListener hrr;
    HttpMessageListener hrs;
    CustomMessageListener hrt;
    CustomMessageListener hru;
    CustomMessageListener hrv;
    CustomMessageListener hrw;
    private CustomMessageListener hrx;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void ceB() {
        if (this.hqP != null) {
            this.hqP.br(this.bds);
        }
        if (this.hqO != null) {
            this.hqO.br(this.bds);
        }
        if (ad.GA() != null) {
            ad.GA().br(this.bds);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.hqy = true;
        this.gUg = 0L;
        this.hqz = false;
        this.boy = true;
        this.blg = "";
        this.mForumName = "";
        this.hqA = false;
        this.hqC = false;
        this.hqE = "0";
        this.mHandler = new Handler();
        this.hqI = -1L;
        this.otherParams = "";
        this.hqK = false;
        this.hqL = com.baidu.tieba.ala.liveroom.task.c.cbJ();
        this.hqN = false;
        this.hqR = false;
        this.hqT = false;
        this.hqU = false;
        this.hqX = false;
        this.hqY = 0;
        this.hra = false;
        this.hrb = false;
        this.gXm = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.can();
            }
        };
        this.hrc = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.ceY();
            }
        };
        this.hrd = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.gTH.caJ();
            }
        };
        this.hre = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.gGg = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hrf = true;
            }
        };
        this.hrh = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.hrg = true;
            }
        };
        this.hri = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.hro = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bds = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.ceB();
            }
        };
        this.bbC = new CustomMessageListener(2501059) { // from class: com.baidu.tieba.ala.player.b.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_video_activity")) {
                    b.this.P(false, false);
                }
            }
        };
        this.byF = new com.baidu.live.q.b() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.q.b
            public void dM(int i) {
                if (b.this.hqG != null) {
                    b.this.hqG.dM(i);
                }
            }
        };
        this.hrp = new com.baidu.live.q.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.q.a
            public void ck(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.hqw != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.hqw.isPlaying());
                        if (b.this.hqw.isPlaying()) {
                            if (b.this.hqw.isPaused()) {
                                b.this.hqw.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.hqw.isPlaying()) {
                        b.this.hqw.pause();
                    }
                }
            }
        };
        this.hrq = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void cb(boolean z) {
                if (z || b.this.hqG == null || b.this.hqG.bTs()) {
                    if (!b.this.ceJ() || b.this.a(true, (a.InterfaceC0612a) null)) {
                        b.this.hrb = true;
                        b.this.nE(true);
                        b.this.bQx();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cc(boolean z) {
                b.this.d(b.this.aDU, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.hqw.cfp();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.hqA) {
                    if (b.this.hqA) {
                        b.this.hqw.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.hqw.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.hqs != null) {
                    b.this.hqs.setIsScrollable(b.this.hqW && z);
                    b.this.hqs.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cd(boolean z) {
                boolean z2 = true;
                if (!z || b.this.cfh()) {
                    if (b.this.hqr != null) {
                        b.this.hqr.ccm();
                        return;
                    }
                    return;
                }
                if (b.this.gTH.Gm().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.hqr != null) {
                    b.this.hqr.no(z2);
                }
            }
        };
        this.hrr = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.hqs != null && i == 0) {
                    b.this.ceU();
                    com.baidu.live.c.AZ().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.gUq = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.q.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.C(b.this.gTH.Gm());
                } else if (i2 == 2) {
                    b.this.f(b.this.gTH.bMo());
                } else if (i2 == 3) {
                    b.this.bm(i, str2);
                } else if (i2 == 4) {
                    b.this.aG(obj);
                } else if (i2 == 5) {
                    b.this.ceX();
                }
            }
        };
        this.hrs = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.cbH() != null && b.this.mTbPageContext != null) {
                        b.this.hqL.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.cbH());
                    }
                }
            }
        };
        this.hrt = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
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
        this.hru = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.gTH != null && b.this.gTH.Gm() != null && b.this.gTH.Gm().mLiveInfo != null) {
                    long j = b.this.gTH.Gm().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.hrj != null) {
                        b.this.hrj.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.hrv = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.gTH != null && b.this.gTH.Gm() != null && b.this.gTH.Gm().aIf != null) {
                        if (l.longValue() == b.this.gTH.Gm().aIf.userId) {
                            b.this.gTH.Gm().aIf.isNewUser = false;
                            if (b.this.hqO != null) {
                                b.this.hqO.p(b.this.gTH.Gm());
                            }
                        }
                    }
                }
            }
        };
        this.hrw = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.u.a)) {
                    com.baidu.tieba.ala.liveroom.u.a aVar2 = (com.baidu.tieba.ala.liveroom.u.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String DH = aVar2.DH();
                    if (b.this.mTbPageContext != null && b.this.gTH != null && b.this.gTH.Gm() != null && b.this.gTH.Gm().aIf != null) {
                        if (valueOf.longValue() == b.this.gTH.Gm().aIf.userId && com.baidu.live.x.a.OS().bqJ != null && com.baidu.live.x.a.OS().bqJ.aNT != null && com.baidu.live.x.a.OS().bqJ.aNT.Ek()) {
                            g.uZ(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, DH));
                        }
                    }
                }
            }
        };
        this.hrx = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.gXm != null) {
                    b.this.mHandler.removeCallbacks(b.this.gXm);
                }
                b.this.can();
            }
        };
        this.gUg = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.hqp = aVar;
        this.hqy = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.z.c.class);
        if (runTask != null) {
            this.hrj = (com.baidu.live.z.c) runTask.getData();
        }
        this.gTH = new com.baidu.tieba.ala.liveroom.q.d(getPageContext());
        this.gTH.a(this.gUq);
        this.gTH.Hy(str);
        this.hqF = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.hrs);
        MessageManager.getInstance().registerListener(this.hrt);
        MessageManager.getInstance().registerListener(this.hru);
        MessageManager.getInstance().registerListener(this.hrv);
        MessageManager.getInstance().registerListener(this.hrw);
        MessageManager.getInstance().registerListener(this.hrx);
        MessageManager.getInstance().registerListener(this.hro);
        MessageManager.getInstance().registerListener(this.gGg);
        MessageManager.getInstance().registerListener(this.hrh);
        MessageManager.getInstance().registerListener(this.hri);
        MessageManager.getInstance().registerListener(this.bbC);
    }

    private void Q(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.hqD = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hqD.add(alaBroadcastGiftToastData);
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
        this.blg = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.blg)) {
            this.blg = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        if (z) {
            this.hqH = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.hqH = intent.getStringExtra("room_id");
        }
        this.blh = intent.getLongExtra("live_id", 0L);
        this.hqK = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.gTH.b((AlaLiveInfoCoreData) serializableExtra);
            this.hqK = true;
        }
        this.gTH.setIsMixLive(z);
        c(intent, z);
        this.hqW = this.hqV == null || !this.hqV.aOj;
        this.hqF.setOtherParams(this.otherParams);
        nC(z);
        ceC();
        this.mHandler.removeCallbacks(this.hre);
        this.mHandler.postDelayed(this.hre, 1000L);
    }

    private void c(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.hqY = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.gBV = null;
            if (z) {
                stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_EXTRA_PARAMS);
            } else {
                stringExtra = intent.getStringExtra("params");
            }
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.hqJ = new JSONObject(stringExtra);
                if (this.hqJ != null) {
                    String optString2 = this.hqJ.optString("enterRoomId");
                    String optString3 = this.hqJ.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.hqH, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.blh + "", optString3))) {
                        String optString4 = this.hqJ.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString5 = this.hqJ.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString5);
                        if (!this.hqK) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.blh;
                            alaLiveInfoCoreData.screenDirection = this.hqJ.optInt("screen_direction", 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.gTH.b(alaLiveInfoCoreData);
                            this.hqK = true;
                        }
                    }
                    String optString6 = this.hqJ.optString("extra");
                    try {
                        this.hrm = Long.parseLong(this.hqH);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.hrn = this.blh;
                    if (TextUtils.isEmpty(optString6)) {
                        this.hqV = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.gTH != null) {
                            this.gTH.GV(optString7);
                        }
                        this.hrk = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.hrl = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.gBV = jSONObject.optString("live_back_scheme");
                        this.hqV = new bk();
                        this.hqV.aOj = jSONObject.optInt("is_hot") == 1;
                        if (this.hqV.aOj) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hqY = AlaLiveSwitchData.isHotLive;
                        this.hqV.aOk = jSONObject.optString("task_id");
                        this.hqV.aOi = !TextUtils.isEmpty(this.hqV.aOk);
                        this.hqV.aOl = jSONObject.optInt("task_type");
                        this.hqV.aOm = jSONObject.optInt("task_im_count");
                        this.hqV.aOn = jSONObject.optLong("task_gift_total_price");
                        this.hqV.aOo = jSONObject.optLong("task_watch_time");
                        this.hqV.aOp = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.hqJ.put("from", optString);
                        }
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.hqv = new com.baidu.tieba.ala.liveroom.e.b();
                            this.hqv.setScheme(optString8);
                            this.hqv.setImageUrl(optString9);
                            this.hqv.setTitle(optString10);
                        }
                    }
                    this.hqE = this.hqJ.optString("open_giftlist");
                    this.hqJ.remove("cover");
                    this.hqJ.remove("live_url");
                    this.hqJ.remove("enterRoomId");
                    this.hqJ.remove("enterLiveId");
                    this.hqJ.remove("open_giftlist");
                    this.hqJ.remove("extra");
                    this.otherParams = this.hqJ.toString();
                    if (this.gTH != null) {
                        this.gTH.setOtherParams(this.otherParams);
                    }
                    this.hqJ.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hqJ.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hqJ.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hqJ.optString("source");
                    }
                    this.hqX = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hqJ.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.gTH != null) {
                        this.gTH.vy(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hqx = new AlaLastLiveroomInfo();
                this.hqx.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.blh), String.valueOf(this.hqH), null, ceR());
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

    public void ceC() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.gTH.aj(this.uk, this.blg, this.mForumName);
        } else if (this.gTH.Gm() != null && this.gTH.Gm().mLiveInfo != null && this.gTH.Gm().mLiveInfo.live_id > 0) {
            this.gTH.a(this.gTH.Gm().mLiveInfo.live_id, false, this.blg, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.blg = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                nE(false);
                return;
            }
            this.gTH.aj(this.uk, this.blg, this.mForumName);
        } else if (!TextUtils.isEmpty(this.hqH)) {
            this.gTH.Hx(this.hqH);
        } else if (this.blh > 0) {
            this.gTH.a(this.blh, false, this.blg, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            nE(false);
        }
    }

    private void nC(boolean z) {
        this.boy = true;
        this.hqz = false;
        nD(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.Dx().n(this.gUc);
        this.hqG = new com.baidu.tieba.ala.liveroom.d.c();
        this.hqG.a(this.hrq);
        this.hqG.setOtherParams(this.otherParams);
        this.hqG.mn(this.hqX);
        this.hqG.a(this.hqp.cez());
        ceF();
        ceD();
        ceE();
    }

    private void nD(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.hqq = (SafeFrameLayout) inflate.findViewById(a.g.live_root_view);
        this.hqs = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.hqs.setOnPageChangeListener(this.hrr);
        this.hqs.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void bYb() {
                b.this.ceU();
            }
        });
        this.hqs.setBoundaryCaching(true);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.hqt = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.hqt.bXZ();
        this.hqr = this.hqt.vf(this.mSelectedPosition);
        this.hqt.a(this.mSelectedPosition, this.gTH.Gm());
        this.hqs.setAdapter(this.hqt);
        this.hqs.setCurrentItem(this.mSelectedPosition);
        this.hqs.setIsScrollable(this.hqW);
        this.hqs.setIsMixLive(z);
        this.gUb = (ViewGroup) inflate.findViewById(a.g.func_view);
        this.gUc = (LayerRootView) inflate.findViewById(a.g.layer_root_view);
    }

    private void c(Rect rect) {
        this.hqw = SdkLivePlayer.fe(getPageContext().getPageActivity());
        if (this.hqw == null) {
            this.hqs.setIsScrollable(false);
            if (this.gTH != null) {
                this.gTH.cancelLoadData();
            }
            bYd();
            return;
        }
        this.hqw.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.hqw.setIPlayerCallBack(this.byF);
        this.hqw.setIPlayerAudioFocusCallBack(this.hrp);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hqr.a(this.hqw, layoutParams, true);
    }

    private void ceD() {
        this.hqu = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.gUb);
    }

    private void ceE() {
        CustomResponsedMessage runTask;
        if (this.gUF == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.p.c.class)) != null) {
            this.gUF = (com.baidu.live.p.c) runTask.getData();
        }
        if (this.gUF != null) {
            this.gUF.setParentView(this.gUb);
        }
    }

    private void bYd() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.nE(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.gUa = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.gUa.setSwipeClearEnable(true);
        this.gUa.hen = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hqr.a(this.gUa, layoutParams);
    }

    private void ceF() {
        if (this.gTH != null && this.gTH.Gm() != null) {
            this.aDU = this.gTH.Gm();
            if (this.aDU.mLiveInfo != null) {
                a(this.aDU.mLiveInfo, this.hqK);
                if (this.aDU.mLiveInfo != null && this.aDU.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hqA);
                    }
                    if (!this.hqA) {
                        this.hqw.c(this.aDU.mLiveInfo);
                    } else {
                        this.hqw.setPlayLiveInfo(this.aDU.mLiveInfo);
                    }
                    if (this.hqG != null) {
                        this.hqG.a(this.mTbPageContext, this.gUa, this.hqw, this.hqr, this.gTH, this.blg, this.hqC, this.gUg, this.hqD, this.hqV);
                        j(this.aDU.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean ceG() {
        boolean z;
        AlaLiveInfoData caS;
        if (this.hqp.cey()) {
            return false;
        }
        if (this.gTH == null || (caS = this.gTH.caS()) == null || caS.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !caS.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.hrm + ", getPlayingRoomID:" + ceH() + ", mSchemeLiveId:" + this.hrn + ", getPlayingLiveID:" + ceI());
        }
        return z || ceK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ceH() {
        AlaLiveInfoData caS;
        if (this.gTH == null || (caS = this.gTH.caS()) == null) {
            return 0L;
        }
        return caS.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long ceI() {
        AlaLiveInfoData caS;
        if (this.gTH == null || (caS = this.gTH.caS()) == null) {
            return 0L;
        }
        return caS.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ceJ() {
        boolean z = false;
        if (!this.hqp.cey()) {
            if (this.hrk && (this.hrm == ceH() || this.hrn == ceI())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean ceK() {
        boolean z = this.hrl && (this.hrm == ceH() || this.hrn == ceI());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean ceL() {
        if (hqZ <= 0) {
            return false;
        }
        if (!(ceJ() || ceG()) || FloatPermissionUtil.MV()) {
            return false;
        }
        hqZ--;
        FloatPermissionUtil.al(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0612a interfaceC0612a) {
        if (!FloatPermissionUtil.MV()) {
            if (this.hra) {
                return true;
            }
            this.hra = true;
            if (z) {
                FloatPermissionUtil.al(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (ceJ()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.hrl) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a eZ = com.baidu.tieba.ala.floating.b.eZ(getPageContext().getPageActivity());
        eZ.a(interfaceC0612a);
        eZ.du(jSONObject);
        com.baidu.tieba.ala.floating.b.eZ(getPageContext().getPageActivity()).a(this.hqw, this.gTH.Gm(), this.blg, this.gUg);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bNm() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bNh = com.baidu.tieba.ala.floating.b.bNh();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0612a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0612a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bNh == null || bNh.room_id == b.this.ceH() || bNh.live_id == b.this.ceI()) {
                    if (b.this.hqw != null) {
                        b.this.ceM();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.hqA);
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
    public void ceM() {
        ArrayList arrayList = (ArrayList) this.hqw.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.hqw.cfo();
            this.hqw.aj(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bNk();
    }

    public void nA(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.hqB = z;
    }

    private void ceN() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hqW) {
                this.hqs.setIsScrollable(true);
            } else {
                this.hqs.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Dx().onBackPressed() && ((this.hqG == null || !this.hqG.onKeyDown(i, keyEvent)) && (this.hqG == null || !this.hqG.bTr()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                ceN();
            } else if ((this.hqG == null || this.hqG.bTs()) && (!ceJ() || a(true, (a.InterfaceC0612a) null))) {
                this.hrb = true;
                nE(true);
                bQx();
            }
        }
        return true;
    }

    public void bQx() {
        if (!TextUtils.isEmpty(this.gBV)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gBV);
                this.gBV = null;
            }
        }
    }

    public void nE(boolean z) {
        P(z, false);
    }

    public void P(boolean z, boolean z2) {
        ms(!z);
        if (this.hqw != null && !this.hqw.isFloatingMode()) {
            this.hqw.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.Dx().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        ceP();
        long j = -1;
        if (this.gTH != null && this.gTH.caS() != null) {
            j = this.gTH.caS().room_id;
        }
        this.hqp.a(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void ms(boolean z) {
        if (this.hqp.cey() && this.hqp.cez() != null) {
            this.hqp.cez().A("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hqx = null;
        if (ad.GA() != null) {
            ad.GA().Gz();
        }
        com.baidu.live.core.layer.b.Dx().Dy();
        if (this.hrj != null) {
            this.hrj.release();
        }
        if (this.hqO != null) {
            this.hqO.release();
        }
        this.hqV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.gTH != null) {
            try {
                this.gTH.GV(null);
                AlaLiveInfoData caS = this.gTH.caS();
                if (caS != null) {
                    this.gTH.eB(caS.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.hqL.stopRecord();
        LiveTimerManager.getInstance().stop();
        ceO();
        if (this.hqw != null && !this.hqw.isFloatingMode()) {
            this.hqw.cl(z);
        }
        if (this.hqG != null) {
            this.hqG.ms(z);
        }
        this.hqN = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.MA().bkx != null && this.aDU != null) {
            com.baidu.live.liveroom.a.b.MA().bkx.b(this.aDU.mLiveInfo);
        }
        w.gN("");
        s.Ge().release();
        if (this.gUF != null) {
            this.gUF.Gx();
        }
    }

    private void ceO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void ceP() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(u uVar) {
        if (uVar != null) {
            this.aDU = uVar;
            if (this.hqG != null) {
                this.hqG.a(uVar);
            }
            ceL();
        }
    }

    private void c(n nVar) {
        if (this.hqG != null) {
            this.hqG.c(nVar);
        }
    }

    private void F(u uVar) {
        this.aDU = uVar;
        ceL();
    }

    private void ceQ() {
        long j;
        String str;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.hqW = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.hqW = true;
        }
        this.hqs.setIsScrollable(this.hqW);
        this.hqY = AlaLiveSwitchData.isHotLive;
        if (this.aDU != null) {
            a(this.aDU.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.hqr.a(this.gUa, null);
            if (!isFloatingMode()) {
                a(this.hqr, this.aDU.mLiveInfo, this.boy);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aDU.mLiveInfo.live_id), String.valueOf(this.aDU.mLiveInfo.room_id), String.valueOf(this.aDU.mLiveInfo.feed_id), ceR());
            if (com.baidu.live.liveroom.a.b.MA().bkx != null) {
                com.baidu.live.liveroom.a.b.MA().bkx.a(this.aDU.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.boy = false;
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                String str2 = "";
                if (this.gTH != null && this.gTH.Gm() != null && this.gTH.Gm().mLiveInfo != null) {
                    j = this.gTH.Gm().mLiveInfo.live_id;
                    str = this.gTH.Gm().mLiveInfo.room_id + "";
                    str2 = this.gTH.Gm().mLiveInfo.feed_id;
                } else {
                    if (this.blh > 0) {
                        j2 = this.blh;
                    }
                    if (TextUtils.isEmpty(this.hqH)) {
                        j = j2;
                        str = "";
                    } else {
                        j = j2;
                        str = this.hqH;
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
                if (this.gTH != null && this.gTH.Gm() != null && this.gTH.Gm().mLiveInfo != null) {
                    str3 = this.gTH.Gm().mLiveInfo.feed_id;
                    str4 = this.gTH.Gm().mLiveInfo.live_id + "";
                    str5 = this.gTH.Gm().mLiveInfo.room_id + "";
                    str6 = this.gTH.Gm().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            ceL();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String ceR() {
        if (this.hqJ == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hqJ.optString("source");
            String optString2 = this.hqJ.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hqJ.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hqJ.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.hqJ.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bNm();
        } else if (this.hqw != null && this.hqw.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.hqw.getVideoPath();
                String d = com.baidu.live.q.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.hqw.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.q.h.aH(videoPath, d)) {
                    this.hqw.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.q.h.aG(videoPath, d)) {
                    this.hqw.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.cb(this.hqw)) {
                        ((ViewGroup) this.hqw.getParent()).removeView(this.hqw);
                        alaLiveRoomBlurPageLayout.a(this.hqw, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.hqA) {
                        this.hqw.c(alaLiveInfoData);
                        return;
                    } else {
                        this.hqw.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.hqw.cfo();
        } else if (this.hqw != null && this.hqw.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.hqw, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.hqA) {
                    this.hqw.c(alaLiveInfoData);
                } else {
                    this.hqw.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.hqw != null) {
            this.hqw.setLayoutParams(b);
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

    public void ceS() {
        this.boy = true;
    }

    public boolean ceT() {
        return this.boy;
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
                this.hqr.setBackgroundColor(0);
            } else {
                this.hqr.setBackgroundColor(0);
            }
        } else {
            this.hqr.setBackgroundColor(0);
        }
        int i3 = this.hqw.getLayoutParams().width;
        int i4 = this.hqw.getLayoutParams().height;
        int i5 = this.hqw.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.hqw.getLayoutParams()).topMargin : 0;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i3 || b.height != i4 || b.topMargin != i5) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.gUa != null) {
            this.gUa.setLayoutParams(c);
        }
        if (this.hqr != null) {
            this.hqr.D(screenFullSize[0], screenFullSize[1]);
        }
        if (this.hqF != null) {
            this.hqF.D(screenFullSize[0], screenFullSize[1]);
        }
        if (this.hqG != null) {
            this.hqG.l(c.width, c.height, realScreenOrientation);
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

    private void vV(int i) {
        boolean z = true;
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            this.hqr.setBgImageUrl(this.aDU.mLiveInfo.cover, this.aDU.mLiveInfo);
            this.hqt.a(this.mSelectedPosition, ceV(), this.aDU);
            this.hqt.b(this.mSelectedPosition, ceW(), this.aDU);
            this.hqr.requestLayout();
            this.hqr.M(i, this.aDU.mLiveInfo.screen_direction == 2);
        }
        if (this.aDU != null) {
            a(i, this.aDU.mLiveInfo, false);
        }
        boolean ccn = this.hqr.ccn();
        boolean z2 = i == 1;
        if (this.aDU == null || this.aDU.mLiveInfo == null || this.aDU.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!cfh()) {
            if (this.hqw != null && this.hqw.getParent() == null) {
                this.hqr.a(this.hqw, null, false);
                if (this.aDU != null && this.aDU.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.hqA) {
                        this.hqw.c(this.aDU.mLiveInfo);
                    } else {
                        this.hqw.setPlayLiveInfo(this.aDU.mLiveInfo);
                    }
                }
            }
            if (ccn && !cfh() && this.hqG != null) {
                this.hqr.no(z);
                return;
            }
            return;
        }
        this.hqr.ccj();
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
            this.gTH.a(alaLiveInfoData.live_id, true, this.blg, this.mForumName, this.hqY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceU() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.hqs != null && this.gUa != null && this.mSelectedPosition != (currentItem = this.hqs.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.i.sdk_neterror);
                this.hqs.setCurrentItem(this.mSelectedPosition);
            } else if (!this.boy && ListUtils.getCount(this.gTH.caI()) <= 1) {
                this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                this.hqs.setCurrentItem(this.mSelectedPosition);
                this.gTH.g(this.gTH.caS());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.gTH.caN() && i < 0) {
                    this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                    this.hqs.setCurrentItem(this.mSelectedPosition);
                } else if (this.gTH.caO() && i > 0) {
                    this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                    this.hqs.setCurrentItem(this.mSelectedPosition);
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.gTH.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    ms(true);
                    this.hqr.ccj();
                    this.hqr.ST();
                    this.hqr.cck();
                    if (this.gTH.Gm() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.gTH.Gm().mLiveInfo.live_id + "", this.gTH.Gm().mLiveInfo.room_id + "", this.gTH.Gm().aHD.userId + "", this.gTH.Gm().aHD.userName, System.currentTimeMillis(), this.gTH.Gm().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.gTH.Gm().mLiveInfo.live_id + "", this.gTH.Gm().mLiveInfo.room_id + "", this.gTH.Gm().aHD.userId + "", this.gTH.Gm().aHD.userName, System.currentTimeMillis(), this.gTH.Gm().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.hqM != null) {
                        long j = this.gTH.Gm().mLiveInfo.live_id;
                        if (this.hqM.liveId == j && this.hqM.startTime > 0) {
                            this.hqM.endTime = System.currentTimeMillis();
                            long j2 = this.hqM.endTime - this.hqM.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hqM.roomId + "", this.hqM.vid, j2 / 1000, this.otherParams);
                        }
                        this.hqM = null;
                    }
                    cfj();
                    if (this.hrj != null) {
                        this.hrj.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.hqr = this.hqt.vg(this.mSelectedPosition);
                    this.hqr.ccl();
                    vW(i);
                    ceL();
                }
            }
        }
    }

    public void vW(int i) {
        if (i < 0) {
            this.gTH.vz(this.gTH.caP() - 1);
        } else if (i > 0) {
            this.gTH.vz(this.gTH.caP() + 1);
        }
        if (this.hqG != null) {
            this.hqG.a(this.hqr);
        }
        this.hqt.a(this.mSelectedPosition, ceV(), this.aDU);
        this.hqt.b(this.mSelectedPosition, ceW(), this.aDU);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.gTH != null) {
            int caP = this.gTH.caP();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", caP + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.gTH.caI() != null && this.gTH.caI().size() > caP && this.gTH.caI().get(caP) != null) {
                AlaLiveInfoData alaLiveInfoData = this.gTH.caI().get(caP);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gTH != null) {
            AlaLiveInfoData caS = this.gTH.caS();
            if (caS != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(caS.live_id), String.valueOf(caS.room_id), null, ceR());
                caS.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bNm();
                }
                a(this.hqr, caS, this.boy);
                this.boy = false;
                if (this.hqG != null) {
                    this.hqG.a(this.mTbPageContext, this.gUa, this.hqw, this.hqr, this.gTH, this.blg, this.hqC, this.gUg, null, this.hqV);
                    short s = 2;
                    if (caS.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(caS, false);
            }
            i(caS);
            this.hqr.a(this.gUa, null);
            if (this.hqG != null) {
                this.hqG.bTp();
            }
            this.gTH.g(caS);
        }
    }

    private AlaLiveInfoData ceV() {
        List<AlaLiveInfoData> caI = this.gTH.caI();
        if (caI == null || caI.size() == 0) {
            if (this.aDU == null) {
                return null;
            }
            return this.aDU.mLiveInfo;
        }
        int caP = this.gTH.caP();
        int size = caI.size();
        return caI.get(((caP + size) - 1) % size);
    }

    private AlaLiveInfoData ceW() {
        List<AlaLiveInfoData> caI = this.gTH.caI();
        if (caI == null || caI.size() == 0) {
            if (this.aDU == null) {
                return null;
            }
            return this.aDU.mLiveInfo;
        }
        return caI.get((this.gTH.caP() + 1) % caI.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(int i, String str) {
        CustomResponsedMessage runTask;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hqA) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.i.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            nE(false);
            return;
        }
        u Gm = this.gTH.Gm();
        F(Gm);
        this.gTH.caJ();
        if (this.boy) {
            this.gTH.ng(false);
        }
        this.gUg = System.currentTimeMillis() / 1000;
        if (this.hqG != null) {
            this.hqG.a(this.mTbPageContext, this.gUa, this.hqw, this.hqr, this.gTH, this.blg, this.hqC, this.gUg, this.hqD, this.hqV);
            short s = 2;
            if (Gm.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        if (this.hqp.cez() != null && this.hqp.cey()) {
            this.hqp.cez().A("load_finish", null);
            if (Gm.mLiveInfo.screen_direction == 2) {
                this.hqp.cez().A("screen_auto_rotate", true);
            } else {
                this.hqp.cez().A("screen_auto_rotate", false);
            }
        }
        ceQ();
        if (Gm != null && Gm.mLiveInfo != null && Gm.mLiveInfo.live_status == 2) {
            this.hqt.a(this.mSelectedPosition, this.gTH.Gm());
            d(Gm, false);
            this.boy = false;
            return;
        }
        if (this.gUE == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.p.d.class)) != null) {
            this.gUE = (com.baidu.live.p.d) runTask.getData();
        }
        if (this.gUE != null) {
            this.gUE.NQ();
        }
        boolean z = (this.hqG == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        w.e(Gm);
        if (z) {
            if (!this.hqR || !TextUtils.equals(p.QX(), this.hqS)) {
                w.b(getPageContext(), false);
                com.baidu.live.x.c.OX().OY();
                this.hqR = true;
                this.hqS = p.QX();
            }
            w.gN("");
            w.Gt();
        }
        if (!this.hqT) {
            this.hqT = true;
            com.baidu.live.entereffect.a.Et().bm(false);
        }
        if (this.gTH.Gm() != null && this.gTH.Gm().mLiveInfo != null) {
            this.gTH.g(this.gTH.Gm().mLiveInfo.live_id, !this.hqN);
            this.hqN = true;
        }
        if (this.hqG != null) {
            this.hqG.b(this.hqx);
            this.hqG.mr(TextUtils.equals(this.hqE, "1"));
            this.hqE = "";
        }
        if (this.hqu != null) {
            this.hqu.a(this.aDU, this.hqv);
        }
        a(this.gTH.Gm());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.gTH.Gm() != null && b.this.gTH.Gm().mLiveInfo != null) {
                    b.this.gTH.a(b.this.gTH.Gm().mLiveInfo.live_id, b.this.blg, b.this.gUg);
                }
            }
        });
        if (z && this.gTH.Gm() != null && this.gTH.Gm().aHD != null) {
            bj bjVar = com.baidu.live.x.a.OS().bqJ;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bjVar != null && bjVar.aNY != null && bjVar.aNY.aQe) {
                f(true, this.gTH.Gm().aHD.userId);
            }
        }
        this.boy = false;
        if (z && this.gTH.Gm() != null && this.gTH.Gm().mLiveInfo != null && this.gTH.Gm().aHD != null && this.hqG != null) {
            long j = this.gTH.Gm().mLiveInfo.live_id;
            long j2 = this.gTH.Gm().mLiveInfo.room_id;
            String str2 = this.gTH.Gm().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (ad.GA() != null) {
                    ad.GA().br(this.bds);
                    if (!this.bds) {
                        ad.GA().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.hrj != null) {
                    this.hrj.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (e.JL() != null) {
                e.JL().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.hqO == null) {
                this.hqO = new com.baidu.tieba.ala.liveroom.k.a();
                this.hqO.br(this.bds);
            }
            if (!this.bds) {
                this.hqO.a(this.mTbPageContext.getPageActivity(), this.gTH.Gm(), this.otherParams);
            }
        }
        if (this.hqP == null) {
            this.hqP = new com.baidu.tieba.ala.liveroom.w.c(this.mTbPageContext);
            this.hqP.br(this.bds);
        }
        if (z && this.gTH.Gm() != null && this.gTH.Gm().aIf != null && !this.hqQ) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.hqP.a(this.gTH.Gm(), this.gTH.Gm().aIf.userId);
                this.hqQ = true;
            }
        }
        if (this.gTH.Gm() != null && this.gTH.Gm().mLiveInfo != null && this.gTH.Gm().aIf != null) {
            com.baidu.live.m.a.b(this.gTH.Gm().mLiveInfo.live_id, this.gTH.Gm().aIf.needRename == 1);
            if (z) {
                com.baidu.live.m.a.b(this.gTH.Gm().mLiveInfo.live_id, 0);
            }
        }
        if (this.gUF != null && this.gTH.Gm() != null && this.gTH.Gm().aHD != null) {
            this.gUF.ar(this.gTH.Gm().aHD.userId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceX() {
        if (this.hqy) {
            this.hqt.a(this.mSelectedPosition, ceV(), this.aDU);
            this.hqt.b(this.mSelectedPosition, ceW(), this.aDU);
            this.hqy = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.hqA) {
            this.mHandler.removeCallbacks(this.hrd);
            this.mHandler.postDelayed(this.hrd, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(n nVar) {
        if (nVar == null) {
            if (!this.hqA) {
                this.mHandler.removeCallbacks(this.hrc);
                this.mHandler.postDelayed(this.hrc, 5000L);
                return;
            }
            return;
        }
        if (!this.hqz) {
            c(nVar);
        }
        if (!this.hqA) {
            this.mHandler.removeCallbacks(this.hrc);
            this.mHandler.postDelayed(this.hrc, nVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceY() {
        if (this.gTH.Gm() != null && this.gTH.Gm().mLiveInfo != null) {
            this.gTH.g(this.gTH.Gm().mLiveInfo.live_id, !this.hqN);
            this.hqN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.live_status == 2) {
            this.hqt.a(this.mSelectedPosition, this.gTH.Gm());
            d(uVar, false);
        } else if (uVar != null) {
            if (!this.hqz) {
                w.e(uVar);
                a(uVar);
            }
            if (!this.hqA) {
                this.mHandler.removeCallbacks(this.gXm);
                this.mHandler.postDelayed(this.gXm, uVar.aHI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void can() {
        if (this.mTbPageContext != null && this.gTH.Gm() != null && this.gTH.Gm().mLiveInfo != null) {
            this.gTH.a(this.gTH.Gm().mLiveInfo.live_id, this.blg, this.gUg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(u uVar, boolean z) {
        String str;
        ms(true);
        if (!cfh()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cbg().ni(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cbg().release();
            this.gTH.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.hqr != null) {
                this.hqr.ST();
                this.hqr.ccj();
                this.hqr.cco();
            }
            if (uVar == null || uVar.mLiveInfo == null) {
                str = null;
            } else {
                this.hqI = uVar.mLiveInfo.live_id;
                str = String.valueOf(uVar.mLiveInfo.room_id);
            }
            ceN();
            ceZ();
            cfa();
            if (this.hqp.cey() && !StringUtils.isNull(str) && this.hqp.cez() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.hqp.cez().A("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (uVar != null) {
                View a2 = (this.hqG == null || this.hqG.bTv() == null) ? null : this.hqG.bTv().a(this.hqG.bTl().pageContext.getPageActivity(), uVar, z);
                if (this.hqr != null) {
                    this.hqF.a(this.hqr, a2, uVar, z, this.gTH.caK());
                }
                if (this.hqG != null) {
                    this.hqG.ms(false);
                    this.hqG.bTq();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.hqr != null) {
                    this.hqr.ccl();
                }
                long j = uVar.mLiveInfo.live_id;
                String str2 = uVar.mLiveInfo.feed_id;
                long j2 = uVar.aHD.userId;
                String str3 = uVar.aHD.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    QMStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", str + "", str2, this.otherParams);
                this.hqM = new StayTimeBean();
                this.hqM.liveId = uVar.mLiveInfo.live_id;
                this.hqM.roomId = uVar.mLiveInfo.room_id;
                this.hqM.vid = uVar.mLiveInfo.feed_id;
                this.hqM.startTime = System.currentTimeMillis();
            }
            cfj();
            if (this.hqu != null) {
                this.hqu.a(this.aDU, this.hqv);
            }
        }
    }

    private void ceZ() {
    }

    private void cfa() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.hqs);
        }
    }

    public void cfb() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cfc();
        } else {
            cfd();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.gTH != null && this.gTH.Gm() != null) {
            alaLiveInfoData = this.gTH.Gm().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cfc();
        } else {
            cfd();
        }
        this.hqs.setIsScrollable(!z && this.hqW);
        if (this.hqG != null) {
            this.hqG.onKeyboardVisibilityChanged(z);
        }
        if (this.gUa != null) {
            this.gUa.onKeyboardVisibilityChanged(z);
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
            cfc();
        } else {
            cfd();
        }
        this.gUa.dI(i);
        vV(i);
        if (ad.GA() != null) {
            ad.GA().FS();
        }
        if (this.hqO != null) {
            this.hqO.FS();
        }
        if (this.hqu != null) {
            this.hqu.dI(i);
        }
    }

    public void cfc() {
        if (this.hqs != null) {
            i.aa(this.hqs);
        }
    }

    public void cfd() {
        if (this.hqs != null) {
            i.ab(this.hqs);
        }
    }

    private boolean cfe() {
        return this.hrf || this.hrg;
    }

    private void cff() {
        this.hrf = false;
        this.hrg = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.hqU + " mWebOver=" + this.hqB + ", isFloatingMode=" + isFloatingMode());
        }
        cff();
        if (!this.hqB || !isFloatingMode()) {
            bNm();
            if (this.gTH != null) {
                this.gTH.cau();
                this.gTH.cay();
            }
            if (this.hqG != null) {
                this.hqG.enterForeground();
            }
            if (this.hqO != null) {
                this.hqO.onResume();
            }
            if (this.hqP != null) {
                this.hqP.onResume();
            }
            com.baidu.live.core.layer.b.Dx().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.hqU + " mWebOver=" + this.hqB + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        cff();
        if ((!this.hqB || !isFloatingMode()) && !this.hqU) {
            bNm();
            if (this.hqA) {
                this.hqA = false;
                cfg();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            ceL();
        }
    }

    public void cfg() {
        can();
        ceY();
        this.gTH.caJ();
        if (!this.hqw.isPlaying()) {
            ceM();
        } else if (this.hqw.isPaused()) {
            this.hqw.resume();
        }
        if (this.hqG != null) {
            this.hqG.bTu();
        }
        if (this.gTH != null && this.gTH.Gm() != null && this.gTH.Gm().mLiveInfo != null) {
            this.hqL.eE(this.gTH.Gm().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aDU.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.hqB + ", isFloatingMode=" + isFloatingMode());
        }
        if (cfe() || !this.hqB || !isFloatingMode()) {
            if (this.gTH != null) {
                this.gTH.cav();
                this.gTH.caz();
            }
            if (this.hqG != null) {
                this.hqG.enterBackground();
            }
            com.baidu.live.core.layer.b.Dx().onPause();
        }
    }

    public void Q(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.hrb);
        }
        if (!cfe() && z && !this.hrb && ceG()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0612a() { // from class: com.baidu.tieba.ala.player.b.12
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0612a
                    public boolean a(SdkLivePlayer sdkLivePlayer) {
                        if (sdkLivePlayer != null) {
                            sdkLivePlayer.aLr();
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
        this.hqA = true;
        nF(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void nF(boolean z) {
        this.mHandler.removeCallbacks(this.gXm);
        this.mHandler.removeCallbacks(this.hrc);
        this.mHandler.removeCallbacks(this.hrd);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.hqw.isFloatingMode()) {
                this.hqw.aLr();
            }
        } else if (!z && !this.hqw.isFloatingMode()) {
            this.hqw.aLr();
        }
        if (this.hqG != null) {
            this.hqG.bTt();
        }
        this.hqL.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ad.GA() != null) {
                ad.GA().a(i, i2, intent, this.aDU, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.hqG != null) {
            this.hqG.onActivityResult(i, i2, intent);
        }
    }

    public boolean cfh() {
        return this.hqF != null && this.hqF.bNc();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hrs != null) {
            MessageManager.getInstance().unRegisterListener(this.hrs);
        }
        if (this.hrt != null) {
            MessageManager.getInstance().unRegisterListener(this.hrt);
        }
        MessageManager.getInstance().unRegisterListener(this.hru);
        MessageManager.getInstance().unRegisterListener(this.hrv);
        MessageManager.getInstance().unRegisterListener(this.hrw);
        MessageManager.getInstance().unRegisterListener(this.hrx);
        MessageManager.getInstance().unRegisterListener(this.hro);
        MessageManager.getInstance().unRegisterListener(this.gGg);
        MessageManager.getInstance().unRegisterListener(this.hrh);
        MessageManager.getInstance().unRegisterListener(this.hri);
        MessageManager.getInstance().unRegisterListener(this.bbC);
        if (this.hrj != null) {
            this.hrj.release();
        }
        if (this.hqw != null && !this.hqw.isFloatingMode()) {
            this.hqw.cl(true);
        }
        if (this.hqu != null) {
            this.hqu.onDestory();
        }
        if (this.gUF != null) {
            this.gUF.release();
            this.gUF = null;
        }
        if (this.hqv != null) {
            this.hqv.reset();
        }
        if (this.hqG != null) {
            this.hqG.onDestroy();
        }
        if (this.hqt != null) {
            this.hqt.onDestroy();
        }
        this.hqr.ST();
        if (this.hqr != null) {
            this.hqr.release();
            this.hqr = null;
        }
        if (this.hqF != null) {
            this.hqF.onDestroy();
        }
        if (this.hqM != null && this.gTH != null && this.gTH.Gm() != null) {
            long j = this.gTH.Gm().mLiveInfo.live_id;
            if (this.hqM.liveId == j && this.hqM.startTime > 0) {
                this.hqM.endTime = System.currentTimeMillis();
                long j2 = this.hqM.endTime - this.hqM.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hqM.roomId + "", this.hqM.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.hqM = null;
        }
        if (this.gUa != null) {
            this.gUa.ccq();
            this.gUa = null;
        }
        if (this.gTH != null) {
            this.gTH.destory();
        }
        if (this.gUE != null) {
            this.gUE.release();
        }
        com.baidu.live.entereffect.a.Et().release();
        com.baidu.live.gift.u.Gg().release();
        if (this.hqP != null) {
            this.hqP.release();
        }
        s.Ge().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String LI() {
        return this.otherParams;
    }

    public void nG(boolean z) {
        this.hqU = z;
    }

    public void cfi() {
        if (this.hqJ != null) {
            this.otherParams = this.hqJ.toString();
            if (this.gTH != null) {
                this.gTH.setOtherParams(this.otherParams);
            }
            if (this.hqG != null) {
                this.hqG.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.hqF != null) {
                this.hqF.setOtherParams(this.otherParams);
            }
        }
    }

    public void cfj() {
        if (this.hqJ != null) {
            String optString = this.hqJ.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hqJ.put("tab", "live_jump");
                        this.hqJ.put("tag", "");
                        this.hqJ.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.hqJ.put("tab", "liveroom");
                        this.hqJ.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cfi();
            }
        }
    }

    private void f(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.JJ();
        }
        bVar.setAnchorId(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void cfk() {
        w.Gw();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hqG.d(s);
        } else {
            this.hqG.e(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
