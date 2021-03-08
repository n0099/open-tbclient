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
/* loaded from: classes10.dex */
public class b extends BdBaseView<TbPageContext> {
    private static String TAG = "AlaLiveViewController";
    private static int igq = 1;
    private static WeakReference<b> mRef;
    private boolean DEBUG;
    private ab aED;
    private boolean bAf;
    private com.baidu.live.u.b bQp;
    private CustomMessageListener bhY;
    private boolean bkc;
    private long bwn;
    private String bwo;
    private com.baidu.tieba.ala.liveroom.n.d hHU;
    private d.a hIC;
    private e hIQ;
    private com.baidu.live.t.b hIR;
    private com.baidu.live.t.b hIS;
    private f hIT;
    private com.baidu.live.t.d hIU;
    private com.baidu.live.v.c hIV;
    private com.baidu.live.v.b hIW;
    private AlaLiveView hIm;
    private ViewGroup hIn;
    private LayerRootView hIo;
    private long hIs;
    private Runnable hLH;
    private String hqz;
    CustomMessageListener huE;
    private a ifH;
    private SafeFrameLayout ifI;
    private AlaLiveRoomBlurPageLayout ifJ;
    private AlaLoopViewPager ifK;
    private AlaLoopViewPagerAdapter ifL;
    private com.baidu.tieba.ala.liveroom.d.a ifM;
    private com.baidu.tieba.ala.liveroom.d.b ifN;
    private SdkLivePlayer ifO;
    private AlaLastLiveroomInfo ifP;
    private boolean ifQ;
    private boolean ifR;
    private boolean ifS;
    private boolean ifT;
    @Deprecated
    private boolean ifU;
    private ArrayList<AlaBroadcastGiftToastData> ifV;
    private String ifW;
    private com.baidu.tieba.ala.endliveroom.a ifX;
    private com.baidu.tieba.ala.liveroom.c.c ifY;
    private String ifZ;
    private com.baidu.live.ag.c igA;
    private boolean igB;
    private boolean igC;
    private long igD;
    private long igE;
    private CustomMessageListener igF;
    private com.baidu.live.u.a igG;
    com.baidu.live.liveroom.a.c igH;
    ViewPager.OnPageChangeListener igI;
    HttpMessageListener igJ;
    CustomMessageListener igK;
    CustomMessageListener igL;
    CustomMessageListener igM;
    CustomMessageListener igN;
    private CustomMessageListener igO;
    private long iga;
    private JSONObject igb;
    private boolean igc;
    private com.baidu.tieba.ala.liveroom.task.c igd;
    private StayTimeBean ige;
    private boolean igf;
    private com.baidu.tieba.ala.liveroom.j.a igg;
    private com.baidu.tieba.ala.liveroom.u.c igh;
    private boolean igi;
    private boolean igj;
    private String igk;
    private boolean igl;
    private bw igm;
    private boolean ign;
    private boolean igo;
    private int igp;
    private boolean igr;
    private boolean igs;
    private Runnable igt;
    private Runnable igu;
    private Runnable igv;
    private boolean igw;
    private boolean igx;
    private CustomMessageListener igy;
    private CustomMessageListener igz;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void cnF() {
        if (this.igh != null) {
            this.igh.bE(this.bkc);
        }
        if (this.igg != null) {
            this.igg.bE(this.bkc);
        }
        if (al.FE() != null) {
            al.FE().bE(this.bkc);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.DEBUG = false;
        this.mSelectedPosition = 1;
        this.ifQ = true;
        this.hIs = 0L;
        this.ifR = false;
        this.bAf = true;
        this.bwo = "";
        this.mForumName = "";
        this.ifS = false;
        this.ifU = false;
        this.ifW = "0";
        this.mHandler = new Handler();
        this.iga = -1L;
        this.otherParams = "";
        this.igc = false;
        this.igd = com.baidu.tieba.ala.liveroom.task.c.ckN();
        this.igf = false;
        this.igj = false;
        this.igl = false;
        this.igo = false;
        this.igp = 0;
        this.igr = false;
        this.igs = false;
        this.hLH = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjh();
            }
        };
        this.igt = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.cod();
            }
        };
        this.igu = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.hHU.cjD();
            }
        };
        this.igv = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.huE = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.igw = true;
            }
        };
        this.igy = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.igx = true;
            }
        };
        this.igz = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.igF = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bkc = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.cnF();
            }
        };
        this.bhY = new CustomMessageListener(2501059) { // from class: com.baidu.tieba.ala.player.b.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_video_activity")) {
                    b.this.U(false, false);
                }
            }
        };
        this.bQp = new com.baidu.live.u.b() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.u.b
            public void cw(int i) {
                if (b.this.ifY != null) {
                    b.this.ifY.cw(i);
                }
            }
        };
        this.igG = new com.baidu.live.u.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.u.a
            public void cL(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.ifO != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.ifO.isPlaying());
                        if (b.this.ifO.isPlaying()) {
                            if (b.this.ifO.isPaused()) {
                                b.this.ifO.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.ifO.isPlaying()) {
                        b.this.ifO.pause();
                    }
                }
            }
        };
        this.igH = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void cC(boolean z) {
                if (z || b.this.ifY == null || b.this.ifY.ccd()) {
                    if (!b.this.cnO() || b.this.a(true, (a.InterfaceC0633a) null)) {
                        b.this.igs = true;
                        b.this.pf(true);
                        b.this.bZh();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cD(boolean z) {
                b.this.e(b.this.aED, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                String str2;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isStoped", b.this.ifS);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (arrayList != null && arrayList.size() > 1) {
                    str2 = "one_to_two_start";
                } else {
                    str2 = "two_to_one_start";
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", str2).setContentExt(null, null, jSONObject));
                b.this.ifO.cou();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.ifS) {
                    if (b.this.ifS) {
                        b.this.ifO.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.ifO.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.ifK != null) {
                    b.this.ifK.setIsScrollable(b.this.ign && z);
                    b.this.ifK.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cE(boolean z) {
                boolean z2 = true;
                if (!z || b.this.com()) {
                    if (b.this.ifJ != null) {
                        b.this.ifJ.cls();
                        return;
                    }
                    return;
                }
                if (b.this.hHU.Fp().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.ifJ != null) {
                    b.this.ifJ.oO(z2);
                }
            }
        };
        this.igI = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.ifK != null && i == 0) {
                    b.this.cnZ();
                    com.baidu.live.d.xf().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.hIC = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.n.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.R(b.this.hHU.Fp());
                } else if (i2 == 2) {
                    b.this.f(b.this.hHU.bTX());
                } else if (i2 == 3) {
                    b.this.bx(i, str2);
                } else if (i2 == 4) {
                    b.this.aK(obj);
                } else if (i2 == 5) {
                    b.this.coc();
                }
            }
        };
        this.igJ = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.ckL() != null && b.this.mTbPageContext != null) {
                        b.this.igd.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.ckL());
                    }
                }
            }
        };
        this.igK = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
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
        this.igL = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.hHU != null && b.this.hHU.Fp() != null && b.this.hHU.Fp().mLiveInfo != null) {
                    long j = b.this.hHU.Fp().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + "," + iArr[1] + "]");
                    if (b.this.igA != null) {
                        b.this.igA.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.igM = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.hHU != null && b.this.hHU.Fp() != null && b.this.hHU.Fp().aJZ != null) {
                        if (l.longValue() == b.this.hHU.Fp().aJZ.userId) {
                            b.this.hHU.Fp().aJZ.isNewUser = false;
                            if (b.this.igg != null) {
                                b.this.igg.o(b.this.hHU.Fp());
                            }
                        }
                    }
                }
            }
        };
        this.igN = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.s.a)) {
                    com.baidu.tieba.ala.liveroom.s.a aVar2 = (com.baidu.tieba.ala.liveroom.s.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String BV = aVar2.BV();
                    if (b.this.mTbPageContext != null && b.this.hHU != null && b.this.hHU.Fp() != null && b.this.hHU.Fp().aJZ != null) {
                        if (valueOf.longValue() == b.this.hHU.Fp().aJZ.userId && com.baidu.live.ae.a.Qm().bCs != null && com.baidu.live.ae.a.Qm().bCs.aRk != null && com.baidu.live.ae.a.Qm().bCs.aRk.CD()) {
                            g.vB(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, BV));
                        }
                    }
                }
            }
        };
        this.igO = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.hLH != null) {
                    b.this.mHandler.removeCallbacks(b.this.hLH);
                }
                b.this.cjh();
            }
        };
        this.hIs = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.ifH = aVar;
        this.ifQ = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ag.c.class);
        if (runTask != null) {
            this.igA = (com.baidu.live.ag.c) runTask.getData();
        }
        this.hHU = new com.baidu.tieba.ala.liveroom.n.d(getPageContext());
        this.hHU.a(this.hIC);
        this.hHU.Ii(str);
        this.ifX = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.igJ);
        MessageManager.getInstance().registerListener(this.igK);
        MessageManager.getInstance().registerListener(this.igL);
        MessageManager.getInstance().registerListener(this.igM);
        MessageManager.getInstance().registerListener(this.igN);
        MessageManager.getInstance().registerListener(this.igO);
        MessageManager.getInstance().registerListener(this.igF);
        MessageManager.getInstance().registerListener(this.huE);
        MessageManager.getInstance().registerListener(this.igy);
        MessageManager.getInstance().registerListener(this.igz);
        MessageManager.getInstance().registerListener(this.bhY);
    }

    private void R(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.ifV = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.ifV.add(alaBroadcastGiftToastData);
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
        this.bwo = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bwo)) {
            this.bwo = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        if (z) {
            this.ifZ = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.ifZ = intent.getStringExtra("room_id");
        }
        this.bwn = intent.getLongExtra("live_id", 0L);
        this.igc = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.hHU.b((AlaLiveInfoCoreData) serializableExtra);
            this.igc = true;
        }
        this.hHU.setIsMixLive(z);
        TbConfig.liveScene = 1;
        d(intent, z);
        this.ign = this.igm == null || !this.igm.aRD;
        this.ifX.setOtherParams(this.otherParams);
        pd(z);
        cnG();
        this.mHandler.removeCallbacks(this.igv);
        this.mHandler.postDelayed(this.igv, 1000L);
    }

    private void d(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.igp = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hqz = null;
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
                this.igb = new JSONObject(stringExtra);
                if (this.igb != null) {
                    String ef = ef(this.igb);
                    String ee = ee(this.igb);
                    if ((!TextUtils.isEmpty(ef) && TextUtils.equals(this.ifZ, ef)) || (!TextUtils.isEmpty(ee) && TextUtils.equals(this.bwn + "", ee))) {
                        String ed = ed(this.igb);
                        if (!TextUtils.isEmpty(ed)) {
                            ed = URLDecoder.decode(ed, "UTF-8");
                        }
                        if (this.DEBUG) {
                            Log.i("LivePlayerActivity", "@@ coverUrl = " + ed);
                        }
                        String eg = eg(this.igb);
                        if (this.DEBUG) {
                            Log.i("LivePlayerActivity", "@@ liveUrl = " + eg);
                        }
                        if (!this.igc) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bwn;
                            alaLiveInfoCoreData.screenDirection = ec(this.igb);
                            if (!TextUtils.isEmpty(ed)) {
                                alaLiveInfoCoreData.liveCover = ed;
                            }
                            a(eg, alaLiveInfoCoreData);
                            this.hHU.b(alaLiveInfoCoreData);
                            this.igc = true;
                        }
                    }
                    String optString2 = this.igb.optString("extra");
                    try {
                        this.igD = Long.parseLong(this.ifZ);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.igE = this.bwn;
                    if (TextUtils.isEmpty(optString2)) {
                        this.igm = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString2);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString3 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString3) && this.hHU != null) {
                            this.hHU.HC(optString3);
                        }
                        this.igB = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.igC = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hqz = jSONObject.optString("live_back_scheme");
                        this.igm = new bw();
                        this.igm.aRD = jSONObject.optInt("is_hot") == 1;
                        if (this.igm.aRD) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.igp = AlaLiveSwitchData.isHotLive;
                        this.igm.aRE = jSONObject.optString("task_id");
                        this.igm.aRC = !TextUtils.isEmpty(this.igm.aRE);
                        this.igm.aRF = jSONObject.optInt("task_type");
                        this.igm.aRG = jSONObject.optInt("task_im_count");
                        this.igm.aRH = jSONObject.optLong("task_gift_total_price");
                        this.igm.aRI = jSONObject.optLong("task_watch_time");
                        this.igm.aRJ = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.igb.put("from", optString);
                        }
                        String optString4 = jSONObject.optString("back_app_scheme");
                        String optString5 = jSONObject.optString("back_app_icon");
                        String optString6 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            this.ifN = new com.baidu.tieba.ala.liveroom.d.b();
                            this.ifN.setScheme(optString4);
                            this.ifN.setImageUrl(optString5);
                            this.ifN.setTitle(optString6);
                        }
                    }
                    this.ifW = this.igb.optString("open_giftlist");
                    this.igb.remove("cover");
                    this.igb.remove("live_url");
                    this.igb.remove("enterRoomId");
                    this.igb.remove("enterLiveId");
                    this.igb.remove("open_giftlist");
                    this.igb.remove("extra");
                    this.otherParams = this.igb.toString();
                    if (this.hHU != null) {
                        this.hHU.setOtherParams(this.otherParams);
                    }
                    this.igb.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.igb.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.igb.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.igb.optString("source");
                    }
                    this.igo = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.igb.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.hHU != null) {
                        this.hHU.wa(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.ifP = new AlaLastLiveroomInfo();
                this.ifP.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bwn), String.valueOf(this.ifZ), null, cnW(), this.ifH != null ? this.ifH.cnC() : false);
    }

    private int ec(JSONObject jSONObject) {
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

    private String ed(JSONObject jSONObject) {
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

    private String ee(JSONObject jSONObject) {
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

    private String ef(JSONObject jSONObject) {
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

    private String eg(JSONObject jSONObject) {
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

    public void cnG() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.hHU.aw(this.uk, this.bwo, this.mForumName);
        } else if (this.hHU.Fp() != null && this.hHU.Fp().mLiveInfo != null && this.hHU.Fp().mLiveInfo.live_id > 0) {
            this.hHU.a(this.hHU.Fp().mLiveInfo.live_id, false, this.bwo, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bwo = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                pf(false);
                return;
            }
            this.hHU.aw(this.uk, this.bwo, this.mForumName);
        } else if (!TextUtils.isEmpty(this.ifZ)) {
            this.hHU.Ih(this.ifZ);
        } else if (this.bwn > 0) {
            this.hHU.a(this.bwn, false, this.bwo, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            pf(false);
        }
    }

    private void pd(boolean z) {
        this.bAf = true;
        this.ifR = false;
        pe(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        b(visibilityRegion);
        c(visibilityRegion);
        com.baidu.live.core.layer.b.Bf().l(this.hIo);
        this.ifY = new com.baidu.tieba.ala.liveroom.c.c();
        this.ifY.a(this.igH);
        this.ifY.setOtherParams(this.otherParams);
        this.ifY.nO(this.igo);
        this.ifY.a(this.ifH.cnD());
        cnK();
        cnH();
        cnJ();
        cnI();
    }

    private void pe(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_main_layout, (ViewGroup) null);
        this.ifI = (SafeFrameLayout) inflate.findViewById(a.f.live_root_view);
        ViewCommonUtil.setForceDarkAllowed(this.ifI, false);
        this.ifK = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.ifK.setOnPageChangeListener(this.igI);
        this.ifK.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void cgS() {
                b.this.cnZ();
            }
        });
        this.ifK.setBoundaryCaching(true);
        this.ifK.setDetermineYRatio(1.0f);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.ifL = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.ifL.cgQ();
        this.ifJ = this.ifL.vH(this.mSelectedPosition);
        this.ifL.a(this.mSelectedPosition, this.hHU.Fp());
        this.ifK.setAdapter(this.ifL);
        this.ifK.setCurrentItem(this.mSelectedPosition);
        this.ifK.setIsScrollable(this.ign);
        this.ifK.setIsMixLive(z);
        this.hIn = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hIo = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
    }

    private void b(Rect rect) {
        this.ifO = SdkLivePlayer.gb(getPageContext().getPageActivity());
        if (this.ifO == null) {
            this.ifK.setIsScrollable(false);
            if (this.hHU != null) {
                this.hHU.cancelLoadData();
            }
            cgU();
            return;
        }
        this.ifO.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.c.sdk_transparent));
        this.ifO.setIPlayerCallBack(this.bQp);
        this.ifO.setIPlayerAudioFocusCallBack(this.igG);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.ifJ.a(this.ifO, layoutParams, true);
    }

    private void cnH() {
        this.ifM = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext, this.hIn);
    }

    private void cnI() {
        CustomResponsedMessage runTask;
        if (this.hIW == null && (runTask = MessageManager.getInstance().runTask(2913266, com.baidu.live.v.b.class)) != null) {
            this.hIW = (com.baidu.live.v.b) runTask.getData();
        }
        if (this.hIW != null) {
            this.hIW.setParentView(this.hIn);
        }
    }

    private void cnJ() {
        CustomResponsedMessage runTask;
        if (this.hIU == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.t.d.class)) != null) {
            this.hIU = (com.baidu.live.t.d) runTask.getData();
        }
        if (this.hIU != null) {
            this.hIU.setParentView(this.hIn);
        }
    }

    private void cgU() {
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
        this.hIm = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.ala_liveroom_player_layout, null);
        this.hIm.setSwipeClearEnable(true);
        this.hIm.hTf = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.ifJ.a(this.hIm, layoutParams);
    }

    private void cnK() {
        if (this.hHU != null && this.hHU.Fp() != null) {
            this.aED = this.hHU.Fp();
            if (this.aED.mLiveInfo != null) {
                a(this.aED.mLiveInfo, this.igc);
                if (this.aED.mLiveInfo != null && this.aED.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.ifS);
                    }
                    if (!this.ifS) {
                        this.ifO.c(this.aED.mLiveInfo);
                    } else {
                        this.ifO.setPlayLiveInfo(this.aED.mLiveInfo);
                    }
                    if (this.ifY != null) {
                        this.ifY.a(this.mTbPageContext, this.hIm, this.ifO, this.ifJ, this.hHU, this.bwo, this.ifU, this.hIs, this.ifV, this.igm, this.ifK);
                        k(this.aED.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean cnL() {
        boolean z;
        AlaLiveInfoData cjM;
        if (this.ifH.cnC()) {
            return false;
        }
        if (this.hHU == null || (cjM = this.hHU.cjM()) == null || cjM.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !cjM.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.igD + ", getPlayingRoomID:" + cnM() + ", mSchemeLiveId:" + this.igE + ", getPlayingLiveID:" + cnN());
        }
        return z || cnP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cnM() {
        AlaLiveInfoData cjM;
        if (this.hHU == null || (cjM = this.hHU.cjM()) == null) {
            return 0L;
        }
        return cjM.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cnN() {
        AlaLiveInfoData cjM;
        if (this.hHU == null || (cjM = this.hHU.cjM()) == null) {
            return 0L;
        }
        return cjM.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnO() {
        boolean z = false;
        if (!this.ifH.cnC()) {
            if (this.igB && (this.igD == cnM() || this.igE == cnN())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean cnP() {
        boolean z = this.igC && (this.igD == cnM() || this.igE == cnN());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean cnQ() {
        if (igq <= 0) {
            return false;
        }
        if (!(cnO() || cnL()) || FloatPermissionUtil.MS()) {
            return false;
        }
        igq--;
        FloatPermissionUtil.ah(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0633a interfaceC0633a) {
        if (!FloatPermissionUtil.MS()) {
            if (this.igr) {
                return true;
            }
            this.igr = true;
            if (z) {
                FloatPermissionUtil.ah(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (cnO()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.igC) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a fV = com.baidu.tieba.ala.floating.b.fV(getPageContext().getPageActivity());
        fV.a(interfaceC0633a);
        fV.dM(jSONObject);
        com.baidu.tieba.ala.floating.b.fV(getPageContext().getPageActivity()).a(this.ifO, this.hHU.Fp(), this.bwo, this.hIs);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bVb() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bUW = com.baidu.tieba.ala.floating.b.bUW();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0633a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0633a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bUW == null || bUW.room_id == b.this.cnM() || bUW.live_id == b.this.cnN()) {
                    if (b.this.ifO != null) {
                        b.this.cnR();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.ifS);
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
    public void cnR() {
        ArrayList arrayList = (ArrayList) this.ifO.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.ifO.cot();
            this.ifO.af(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bUZ();
    }

    public void pb(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.ifT = z;
    }

    private void cnS() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.ign) {
                this.ifK.setIsScrollable(true);
            } else {
                this.ifK.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Bf().onBackPressed() && ((this.ifY == null || !this.ifY.onKeyDown(i, keyEvent)) && (this.ifY == null || !this.ifY.ccc()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cnS();
            } else if ((this.ifY == null || this.ifY.ccd()) && (!cnO() || a(true, (a.InterfaceC0633a) null))) {
                this.igs = true;
                pf(true);
                bZh();
            }
        }
        return true;
    }

    public void bZh() {
        if (!TextUtils.isEmpty(this.hqz)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hqz);
                this.hqz = null;
            }
        }
    }

    public void pf(boolean z) {
        U(z, false);
    }

    public void U(boolean z, boolean z2) {
        nU(!z);
        if (this.ifO != null && !this.ifO.isFloatingMode()) {
            this.ifO.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.Bf().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cnU();
        long j = -1;
        if (this.hHU != null && this.hHU.cjM() != null) {
            j = this.hHU.cjM().room_id;
        }
        this.ifH.b(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void nU(boolean z) {
        if (this.ifH.cnC() && this.ifH.cnD() != null) {
            this.ifH.cnD().y("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.ifP = null;
        if (al.FE() != null) {
            al.FE().FD();
        }
        com.baidu.live.core.layer.b.Bf().Bg();
        if (this.igA != null) {
            this.igA.release();
        }
        if (this.igg != null) {
            this.igg.release();
        }
        this.igm = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.hHU != null) {
            try {
                this.hHU.HC(null);
                AlaLiveInfoData cjM = this.hHU.cjM();
                if (cjM != null) {
                    this.hHU.fI(cjM.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.igd.stopRecord();
        LiveTimerManager.getInstance().stop();
        cnT();
        if (this.ifO != null && !this.ifO.isFloatingMode()) {
            this.ifO.cM(z);
        }
        if (this.ifY != null) {
            this.ifY.nU(z);
        }
        this.igf = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Mx().bsR != null && this.aED != null) {
            com.baidu.live.liveroom.a.b.Mx().bsR.b(this.aED.mLiveInfo);
        }
        ac.gu("");
        x.Ff().release();
        if (this.hIU != null) {
            this.hIU.FB();
        }
        if (this.hIW != null) {
            this.hIW.FB();
        }
        if (this.ifH != null && this.ifH.cnC()) {
            ac.FA();
        }
    }

    private void cnT() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cnU() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(ab abVar) {
        if (abVar != null) {
            this.aED = abVar;
            if (this.ifY != null) {
                this.ifY.a(abVar);
            }
            if (this.hIW != null && this.hHU.Fp() != null) {
                this.hIW.b(this.hHU.Fp(), this.otherParams);
            }
            cnQ();
        }
    }

    private void c(v vVar) {
        if (this.ifY != null) {
            this.ifY.c(vVar);
        }
    }

    private void V(ab abVar) {
        this.aED = abVar;
        cnQ();
    }

    private void cnV() {
        long j;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.ign = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.ign = true;
        }
        this.ifK.setIsScrollable(this.ign);
        this.igp = AlaLiveSwitchData.isHotLive;
        if (this.aED != null) {
            a(this.aED.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.ifJ.a(this.hIm, null);
            if (!isFloatingMode()) {
                a(this.ifJ, this.aED.mLiveInfo, this.bAf);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aED.mLiveInfo.live_id), String.valueOf(this.aED.mLiveInfo.room_id), String.valueOf(this.aED.mLiveInfo.feed_id), cnW(), this.ifH != null ? this.ifH.cnC() : false);
            if (com.baidu.live.liveroom.a.b.Mx().bsR != null) {
                com.baidu.live.liveroom.a.b.Mx().bsR.a(this.aED.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.bAf = false;
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                String str = "";
                String str2 = "";
                if (this.hHU != null && this.hHU.Fp() != null && this.hHU.Fp().mLiveInfo != null) {
                    j = this.hHU.Fp().mLiveInfo.live_id;
                    str2 = this.hHU.Fp().mLiveInfo.feed_id;
                    str = this.hHU.Fp().mLiveInfo.room_id + "";
                } else {
                    if (this.bwn > 0) {
                        j2 = this.bwn;
                    }
                    if (TextUtils.isEmpty(this.ifZ)) {
                        j = j2;
                    } else {
                        str = this.ifZ;
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
                if (this.hHU != null && this.hHU.Fp() != null && this.hHU.Fp().mLiveInfo != null) {
                    str3 = this.hHU.Fp().mLiveInfo.feed_id;
                    str4 = this.hHU.Fp().mLiveInfo.live_id + "";
                    str5 = this.hHU.Fp().mLiveInfo.room_id + "";
                    str6 = this.hHU.Fp().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            cnQ();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String cnW() {
        if (this.igb == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.igb.optString("source");
            String optString2 = this.igb.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.igb.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.igb.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.igb.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bVb();
        } else if (this.ifO != null && this.ifO.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.ifO.getVideoPath();
                String d = com.baidu.live.u.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.ifO.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.u.h.aH(videoPath, d)) {
                    this.ifO.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.u.h.aG(videoPath, d)) {
                    this.ifO.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.cz(this.ifO)) {
                        ((ViewGroup) this.ifO.getParent()).removeView(this.ifO);
                        alaLiveRoomBlurPageLayout.a(this.ifO, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.ifS) {
                        this.ifO.c(alaLiveInfoData);
                        return;
                    } else {
                        this.ifO.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.ifO.cot();
        } else if (this.ifO != null && this.ifO.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.ifO, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.ifS) {
                    this.ifO.c(alaLiveInfoData);
                } else {
                    this.ifO.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.ifO != null) {
            this.ifO.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.br(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.bs(this.mTbPageContext.getPageActivity());
                int bq = p.bq(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = bq + i;
                } else {
                    dimensionPixelSize = bq + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
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

    public void cnX() {
        this.bAf = true;
    }

    public boolean cnY() {
        return this.bAf;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        a(UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()), alaLiveInfoData, z);
    }

    private void a(int i, AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (this.ifO != null) {
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
            if (this.ifJ != null) {
                this.ifJ.setBackgroundColor(0);
            }
            int i3 = this.ifO.getLayoutParams().width;
            int i4 = this.ifO.getLayoutParams().height;
            int i5 = this.ifO.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.ifO.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b.width != i3 || b.height != i4 || b.topMargin != i5) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.hIm != null) {
                this.hIm.setLayoutParams(c);
            }
            if (this.ifJ != null) {
                this.ifJ.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ifX != null) {
                this.ifX.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ifY != null) {
                this.ifY.l(c.width, c.height, realScreenOrientation);
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

    private void wy(int i) {
        boolean z = true;
        if (this.aED != null && this.aED.mLiveInfo != null) {
            if (this.ifJ != null) {
                this.ifJ.setBgImageUrl(this.aED.mLiveInfo.cover, this.aED.mLiveInfo);
            }
            this.ifL.a(this.mSelectedPosition, coa(), this.aED);
            this.ifL.b(this.mSelectedPosition, cob(), this.aED);
            if (this.ifJ != null) {
                this.ifJ.requestLayout();
                this.ifJ.M(i, this.aED.mLiveInfo.screen_direction == 2);
            }
        }
        if (this.aED != null) {
            a(i, this.aED.mLiveInfo, false);
        }
        boolean clt = this.ifJ.clt();
        boolean z2 = i == 1;
        if (this.aED == null || this.aED.mLiveInfo == null || this.aED.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!com()) {
            if (this.ifO != null && this.ifO.getParent() == null) {
                this.ifJ.a(this.ifO, null, false);
                if (this.aED != null && this.aED.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.ifS) {
                        this.ifO.c(this.aED.mLiveInfo);
                    } else {
                        this.ifO.setPlayLiveInfo(this.aED.mLiveInfo);
                    }
                }
            }
            if (clt && !com() && this.ifY != null) {
                this.ifJ.oO(z);
                return;
            }
            return;
        }
        this.ifJ.clp();
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
            this.hHU.a(alaLiveInfoData.live_id, true, this.bwo, this.mForumName, this.igp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnZ() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.ifK != null && this.hIm != null && this.mSelectedPosition != (currentItem = this.ifK.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.h.sdk_neterror);
                this.ifK.setCurrentItem(this.mSelectedPosition);
            } else if (!this.bAf && ListUtils.getCount(this.hHU.cjC()) <= 1) {
                this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                this.ifK.setCurrentItem(this.mSelectedPosition);
                this.hHU.g(this.hHU.cjM());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.hHU.cjH() && i < 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                    this.ifK.setCurrentItem(this.mSelectedPosition);
                } else if (this.hHU.cjI() && i > 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                    this.ifK.setCurrentItem(this.mSelectedPosition);
                    this.hHU.g(this.hHU.cjM());
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.hHU.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    nU(true);
                    this.ifJ.clp();
                    this.ifJ.Xl();
                    this.ifJ.clq();
                    if (this.hHU.Fp() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.hHU.Fp().mLiveInfo.live_id + "", this.hHU.Fp().mLiveInfo.room_id + "", this.hHU.Fp().aJD.userId + "", this.hHU.Fp().aJD.userName, System.currentTimeMillis(), this.hHU.Fp().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.hHU.Fp().mLiveInfo.live_id + "", this.hHU.Fp().mLiveInfo.room_id + "", this.hHU.Fp().aJD.userId + "", this.hHU.Fp().aJD.userName, System.currentTimeMillis(), this.hHU.Fp().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.ige != null) {
                        long j = this.hHU.Fp().mLiveInfo.live_id;
                        if (this.ige.liveId == j && this.ige.startTime > 0) {
                            this.ige.endTime = System.currentTimeMillis();
                            long j2 = this.ige.endTime - this.ige.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.ige.roomId + "", this.ige.vid, j2 / 1000, this.otherParams);
                        }
                        this.ige = null;
                    }
                    coo();
                    if (this.igA != null) {
                        this.igA.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.ifJ = this.ifL.vI(this.mSelectedPosition);
                    this.ifJ.clr();
                    wz(i);
                    cnQ();
                }
            }
        }
    }

    public void wz(int i) {
        if (i < 0) {
            this.hHU.wb(this.hHU.cjJ() - 1);
        } else if (i > 0) {
            this.hHU.wb(this.hHU.cjJ() + 1);
        }
        if (this.ifY != null) {
            this.ifY.a(this.ifJ);
        }
        this.ifL.a(this.mSelectedPosition, coa(), this.aED);
        this.ifL.b(this.mSelectedPosition, cob(), this.aED);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.hHU != null) {
            int cjJ = this.hHU.cjJ();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", cjJ + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.hHU.cjC() != null && this.hHU.cjC().size() > cjJ && this.hHU.cjC().get(cjJ) != null) {
                AlaLiveInfoData alaLiveInfoData = this.hHU.cjC().get(cjJ);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hHU != null) {
            AlaLiveInfoData cjM = this.hHU.cjM();
            com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(cjM.live_id)));
            if (cjM != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(cjM.live_id), String.valueOf(cjM.room_id), null, cnW(), this.ifH != null ? this.ifH.cnC() : false);
                l.c(this.hHU.cjJ(), cjM.room_id, cjM.live_id);
                cjM.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bVb();
                }
                a(this.ifJ, cjM, this.bAf);
                this.bAf = false;
                if (this.ifY != null) {
                    this.ifY.a(this.mTbPageContext, this.hIm, this.ifO, this.ifJ, this.hHU, this.bwo, this.ifU, this.hIs, null, this.igm, this.ifK);
                    short s = 2;
                    if (cjM.screen_direction == 2) {
                        s = 1;
                    }
                    k(s);
                }
                a(cjM, false);
            } else {
                l.ii("currentLiveInfo is null");
            }
            i(cjM);
            this.ifJ.a(this.hIm, null);
            if (this.ifY != null) {
                this.ifY.cca();
            }
            this.hHU.g(cjM);
        }
    }

    private AlaLiveInfoData coa() {
        List<AlaLiveInfoData> cjC = this.hHU.cjC();
        if (cjC == null || cjC.size() == 0) {
            if (this.aED == null) {
                return null;
            }
            return this.aED.mLiveInfo;
        }
        int cjJ = this.hHU.cjJ();
        int size = cjC.size();
        return cjC.get(((cjJ + size) - 1) % size);
    }

    private AlaLiveInfoData cob() {
        List<AlaLiveInfoData> cjC = this.hHU.cjC();
        if (cjC == null || cjC.size() == 0) {
            if (this.aED == null) {
                return null;
            }
            return this.aED.mLiveInfo;
        }
        return cjC.get((this.hHU.cjJ() + 1) % cjC.size());
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
            if (!this.ifS) {
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
        ab Fp = this.hHU.Fp();
        V(Fp);
        this.hHU.cjD();
        if (this.bAf) {
            this.hHU.oG(false);
        }
        this.hIs = System.currentTimeMillis() / 1000;
        if (this.ifY != null) {
            this.ifY.a(this.mTbPageContext, this.hIm, this.ifO, this.ifJ, this.hHU, this.bwo, this.ifU, this.hIs, this.ifV, this.igm, this.ifK);
            short s = 2;
            if (Fp.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            k(s);
        }
        if (this.ifH.cnD() != null && this.ifH.cnC()) {
            this.ifH.cnD().y("load_finish", null);
            if (Fp.mLiveInfo.screen_direction == 2) {
                this.ifH.cnD().y("screen_auto_rotate", true);
            } else {
                this.ifH.cnD().y("screen_auto_rotate", false);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
                this.ifH.cnD().y("mix_room_scroll", Boolean.valueOf(!TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()));
            }
        }
        cnV();
        if (Fp != null && Fp.mLiveInfo != null && Fp.mLiveInfo.live_status == 2) {
            this.ifL.a(this.mSelectedPosition, this.hHU.Fp());
            e(Fp, false);
            this.bAf = false;
            W(Fp);
            return;
        }
        if (this.hIQ == null && (runTask5 = MessageManager.getInstance().runTask(2913229, e.class)) != null) {
            this.hIQ = (e) runTask5.getData();
        }
        if (this.hIQ != null) {
            this.hIQ.Pm();
        }
        if (this.hIR == null && (runTask4 = MessageManager.getInstance().runTask(2913292, com.baidu.live.t.b.class)) != null) {
            this.hIR = (com.baidu.live.t.b) runTask4.getData();
        }
        if (this.hIR != null) {
            this.hIR.Pm();
        }
        if (this.hIS == null && (runTask3 = MessageManager.getInstance().runTask(2913296, com.baidu.live.t.b.class)) != null) {
            this.hIS = (com.baidu.live.t.b) runTask3.getData();
        }
        if (this.hIS != null) {
            this.hIS.Pm();
        }
        if (this.hIT == null && (runTask2 = MessageManager.getInstance().runTask(2913293, f.class)) != null) {
            this.hIT = (f) runTask2.getData();
        }
        if (this.hIT != null) {
            this.hIT.Pm();
        }
        if (this.hIV == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.v.c.class)) != null) {
            this.hIV = (com.baidu.live.v.c) runTask.getData();
        }
        if (this.hIV != null) {
            this.hIV.Pm();
        }
        boolean z = (this.ifY == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        ac.e(Fp);
        if (z) {
            if (!this.igj || !TextUtils.equals(q.Vy(), this.igk)) {
                ac.b(getPageContext(), false, this.ifH != null && this.ifH.cnC());
                com.baidu.live.ae.e.QC().QD();
                this.igj = true;
                this.igk = q.Vy();
            }
            ac.gu("");
            ac.Fw();
        }
        if (this.hHU.Fp() != null && this.hHU.Fp().mLiveInfo != null) {
            this.hHU.j(this.hHU.Fp().mLiveInfo.live_id, !this.igf);
            this.igf = true;
        }
        if (this.ifY != null) {
            this.ifY.b(this.ifP);
            this.ifY.nT(TextUtils.equals(this.ifW, "1"));
            this.ifW = "";
        }
        if (this.ifM != null) {
            this.ifM.a(this.aED, this.ifN);
        }
        a(this.hHU.Fp());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.hHU.Fp() != null && b.this.hHU.Fp().mLiveInfo != null) {
                    b.this.hHU.a(b.this.hHU.Fp().mLiveInfo.live_id, b.this.bwo, b.this.hIs);
                }
            }
        });
        if (z && this.hHU.Fp() != null && this.hHU.Fp().aJD != null) {
            bv bvVar = com.baidu.live.ae.a.Qm().bCs;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bvVar != null && bvVar.aRp != null && bvVar.aRp.aTU) {
                n(true, this.hHU.Fp().aJD.userId);
            }
        }
        this.bAf = false;
        if (z && this.hHU.Fp() != null && this.hHU.Fp().mLiveInfo != null && this.hHU.Fp().aJD != null && this.ifY != null) {
            long j = this.hHU.Fp().mLiveInfo.live_id;
            long j2 = this.hHU.Fp().mLiveInfo.room_id;
            String str2 = this.hHU.Fp().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.FE() != null) {
                    al.FE().bE(this.bkc);
                    if (!this.bkc) {
                        al.FE().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.igA != null) {
                    this.igA.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.IV() != null) {
                com.baidu.live.guardclub.e.IV().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.igg == null) {
                this.igg = new com.baidu.tieba.ala.liveroom.j.a();
                this.igg.bE(this.bkc);
            }
            if (!this.bkc) {
                this.igg.a(this.mTbPageContext.getPageActivity(), this.hHU.Fp(), this.otherParams);
            }
        }
        if (this.igh == null) {
            this.igh = new com.baidu.tieba.ala.liveroom.u.c(this.mTbPageContext);
            this.igh.bE(this.bkc);
        }
        if (z && this.hHU.Fp() != null && this.hHU.Fp().aJZ != null && !this.igi) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.igh.a(this.hHU.Fp(), this.hHU.Fp().aJZ.userId);
                this.igi = true;
            }
        }
        if (this.hHU.Fp() != null && this.hHU.Fp().mLiveInfo != null && this.hHU.Fp().aJZ != null) {
            com.baidu.live.p.a.e(this.hHU.Fp().mLiveInfo.live_id, this.hHU.Fp().aJZ.needRename == 1);
            if (z) {
                com.baidu.live.p.a.c(this.hHU.Fp().mLiveInfo.live_id, 0);
            }
        }
        if (this.hIU != null && this.hHU.Fp() != null && this.hHU.Fp().aJD != null) {
            this.hIU.bh(this.hHU.Fp().aJD.userId);
        }
    }

    private void W(ab abVar) {
        String str = "";
        if (!TextUtils.isEmpty(this.uk)) {
            str = "uk=" + this.uk;
        } else if (this.bwn > 0) {
            str = "live_id=" + this.bwn;
        } else if (!TextUtils.isEmpty(this.ifZ)) {
            str = "live_room_id=" + this.ifZ;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            str = "url=" + this.mUrl;
        }
        LogManager.getLiveCloseLogger().doEnterLiveCloseGuestLog(abVar.mLiveInfo.live_id + "", abVar.mLiveInfo.room_id + "", abVar.mLiveInfo.feed_id, str, this.otherParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coc() {
        if (this.ifQ) {
            this.ifL.a(this.mSelectedPosition, coa(), this.aED);
            this.ifL.b(this.mSelectedPosition, cob(), this.aED);
            this.ifQ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.ifS) {
            this.mHandler.removeCallbacks(this.igu);
            this.mHandler.postDelayed(this.igu, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(v vVar) {
        if (vVar == null) {
            if (!this.ifS) {
                this.mHandler.removeCallbacks(this.igt);
                this.mHandler.postDelayed(this.igt, 5000L);
                return;
            }
            return;
        }
        if (!this.ifR) {
            c(vVar);
        }
        if (!this.ifS) {
            this.mHandler.removeCallbacks(this.igt);
            this.mHandler.postDelayed(this.igt, vVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cod() {
        if (this.hHU.Fp() != null && this.hHU.Fp().mLiveInfo != null) {
            this.hHU.j(this.hHU.Fp().mLiveInfo.live_id, !this.igf);
            this.igf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.live_status == 2) {
            this.ifL.a(this.mSelectedPosition, this.hHU.Fp());
            e(abVar, false);
        } else if (abVar != null) {
            if (!this.ifR) {
                ac.e(abVar);
                a(abVar);
            }
            if (!this.ifS) {
                this.mHandler.removeCallbacks(this.hLH);
                this.mHandler.postDelayed(this.hLH, abVar.aJI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjh() {
        if (this.mTbPageContext != null && this.hHU.Fp() != null && this.hHU.Fp().mLiveInfo != null) {
            this.hHU.a(this.hHU.Fp().mLiveInfo.live_id, this.bwo, this.hIs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ab abVar, boolean z) {
        String str;
        nU(true);
        if (!com()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckl().oI(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckl().release();
            this.hHU.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.ifJ != null) {
                this.ifJ.Xl();
                this.ifJ.clp();
                this.ifJ.clu();
            }
            if (abVar == null || abVar.mLiveInfo == null) {
                str = null;
            } else {
                this.iga = abVar.mLiveInfo.live_id;
                str = String.valueOf(abVar.mLiveInfo.room_id);
            }
            cnS();
            coe();
            cof();
            if (this.ifH.cnC() && !StringUtils.isNull(str) && this.ifH.cnD() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.ifH.cnD().y("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (abVar != null) {
                View a2 = (this.ifY == null || this.ifY.ccg() == null) ? null : this.ifY.ccg().a(this.ifY.cbV().pageContext.getPageActivity(), abVar, z);
                if (this.ifJ != null) {
                    this.ifX.a(this.ifJ, a2, abVar, z, this.hHU.cjE());
                }
                if (this.ifY != null) {
                    this.ifY.nU(false);
                    this.ifY.ccb();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.ifJ != null) {
                    this.ifJ.clr();
                }
                long j = abVar.mLiveInfo.live_id;
                String str2 = abVar.mLiveInfo.feed_id;
                long j2 = abVar.aJD.userId;
                String str3 = abVar.aJD.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    QMStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", str + "", str2, this.otherParams);
                this.ige = new StayTimeBean();
                this.ige.liveId = abVar.mLiveInfo.live_id;
                this.ige.roomId = abVar.mLiveInfo.room_id;
                this.ige.vid = abVar.mLiveInfo.feed_id;
                this.ige.startTime = System.currentTimeMillis();
            }
            coo();
            if (this.ifM != null) {
                this.ifM.a(this.aED, this.ifN);
            }
        }
    }

    private void coe() {
    }

    private void cof() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.ifK);
        }
    }

    public void cog() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            coh();
        } else {
            coi();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.hHU != null && this.hHU.Fp() != null) {
            alaLiveInfoData = this.hHU.Fp().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            coh();
        } else {
            coi();
        }
        this.ifK.setIsScrollable(!z && this.ign);
        if (this.ifY != null) {
            this.ifY.onKeyboardVisibilityChanged(z);
        }
        if (this.hIm != null) {
            this.hIm.onKeyboardVisibilityChanged(z);
        }
    }

    public void cs(int i) {
        if (i == 0) {
            i = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        }
        if (isDebug()) {
            Log.d(TAG, "onScreenOrientationChanged: ");
        }
        if (i == 2) {
            coh();
        } else {
            coi();
        }
        this.hIm.cs(i);
        wy(i);
        if (al.FE() != null) {
            al.FE().EN();
        }
        if (this.igg != null) {
            this.igg.EN();
        }
        if (this.ifM != null) {
            this.ifM.cs(i);
        }
    }

    public void coh() {
        if (this.ifK != null) {
            i.ae(this.ifK);
        }
    }

    public void coi() {
        if (this.ifK != null) {
            i.af(this.ifK);
        }
    }

    private boolean coj() {
        return this.igw || this.igx;
    }

    private void cok() {
        this.igw = false;
        this.igx = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.igl + " mWebOver=" + this.ifT + ", isFloatingMode=" + isFloatingMode());
        }
        cok();
        if (!this.ifT || !isFloatingMode()) {
            bVb();
            if (this.hHU != null) {
                this.hHU.cjo();
                this.hHU.cjs();
            }
            if (this.ifY != null) {
                this.ifY.enterForeground();
            }
            if (this.igg != null) {
                this.igg.onResume();
            }
            if (this.igh != null) {
                this.igh.onResume();
            }
            com.baidu.live.core.layer.b.Bf().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.igl + " mWebOver=" + this.ifT + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        cok();
        if ((!this.ifT || !isFloatingMode()) && !this.igl) {
            bVb();
            if (this.ifS) {
                this.ifS = false;
                col();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            cnQ();
        }
    }

    public void col() {
        cjh();
        cod();
        this.hHU.cjD();
        if (!this.ifO.isPlaying()) {
            cnR();
        } else if (this.ifO.isPaused()) {
            this.ifO.resume();
        }
        if (this.ifY != null) {
            this.ifY.ccf();
        }
        if (this.hHU != null && this.hHU.Fp() != null && this.hHU.Fp().mLiveInfo != null) {
            this.igd.fL(this.hHU.Fp().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aED.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.ifT + ", isFloatingMode=" + isFloatingMode());
        }
        if (coj() || !this.ifT || !isFloatingMode()) {
            if (this.hHU != null) {
                this.hHU.cjp();
                this.hHU.cjt();
            }
            if (this.ifY != null) {
                this.ifY.enterBackground();
            }
            com.baidu.live.core.layer.b.Bf().onPause();
        }
    }

    public void V(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.igs);
        }
        if (!coj() && z && !this.igs && cnL()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0633a() { // from class: com.baidu.tieba.ala.player.b.12
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0633a
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
        this.ifS = true;
        pg(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void pg(boolean z) {
        this.mHandler.removeCallbacks(this.hLH);
        this.mHandler.removeCallbacks(this.igt);
        this.mHandler.removeCallbacks(this.igu);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.ifO.isFloatingMode()) {
                this.ifO.pausePlay();
            }
        } else if (!z && !this.ifO.isFloatingMode()) {
            this.ifO.pausePlay();
        }
        if (this.ifY != null) {
            this.ifY.cce();
        }
        this.igd.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.FE() != null) {
                al.FE().a(i, i2, intent, this.aED, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.ifY != null) {
            this.ifY.onActivityResult(i, i2, intent);
        }
    }

    public boolean com() {
        return this.ifX != null && this.ifX.bUR();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.igJ != null) {
            MessageManager.getInstance().unRegisterListener(this.igJ);
        }
        if (this.igK != null) {
            MessageManager.getInstance().unRegisterListener(this.igK);
        }
        MessageManager.getInstance().unRegisterListener(this.igL);
        MessageManager.getInstance().unRegisterListener(this.igM);
        MessageManager.getInstance().unRegisterListener(this.igN);
        MessageManager.getInstance().unRegisterListener(this.igO);
        MessageManager.getInstance().unRegisterListener(this.igF);
        MessageManager.getInstance().unRegisterListener(this.huE);
        MessageManager.getInstance().unRegisterListener(this.igy);
        MessageManager.getInstance().unRegisterListener(this.igz);
        MessageManager.getInstance().unRegisterListener(this.bhY);
        if (this.igA != null) {
            this.igA.release();
        }
        if (this.ifO != null && !this.ifO.isFloatingMode()) {
            this.ifO.cM(true);
        }
        if (this.ifM != null) {
            this.ifM.onDestory();
        }
        if (this.hIU != null) {
            this.hIU.release();
            this.hIU = null;
        }
        if (this.hIW != null) {
            this.hIW.release();
            this.hIW = null;
        }
        if (this.ifN != null) {
            this.ifN.reset();
        }
        if (this.ifY != null) {
            this.ifY.onDestroy();
        }
        if (this.ifL != null) {
            this.ifL.onDestroy();
        }
        if (this.ifJ != null) {
            this.ifJ.Xl();
            this.ifJ.release();
            this.ifJ = null;
        }
        if (this.ifX != null) {
            this.ifX.onDestroy();
        }
        if (this.ige != null && this.hHU != null && this.hHU.Fp() != null) {
            long j = this.hHU.Fp().mLiveInfo.live_id;
            if (this.ige.liveId == j && this.ige.startTime > 0) {
                this.ige.endTime = System.currentTimeMillis();
                long j2 = this.ige.endTime - this.ige.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.ige.roomId + "", this.ige.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.ige = null;
        }
        if (this.hIm != null) {
            this.hIm.clx();
            this.hIm = null;
        }
        if (this.hHU != null) {
            this.hHU.destory();
        }
        if (this.hIQ != null) {
            this.hIQ.release();
        }
        if (this.hIR != null) {
            this.hIR.release();
        }
        if (this.hIS != null) {
            this.hIS.release();
        }
        if (this.hIT != null) {
            this.hIT.release();
        }
        if (this.hIV != null) {
            this.hIV.release();
        }
        z.Fh().release();
        if (this.igh != null) {
            this.igh.release();
        }
        x.Ff().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String Lr() {
        return this.otherParams;
    }

    public void ph(boolean z) {
        this.igl = z;
    }

    public void con() {
        if (this.igb != null) {
            this.otherParams = this.igb.toString();
            if (this.hHU != null) {
                this.hHU.setOtherParams(this.otherParams);
            }
            if (this.ifY != null) {
                this.ifY.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.ifX != null) {
                this.ifX.setOtherParams(this.otherParams);
            }
        }
    }

    public void coo() {
        if (this.igb != null) {
            String optString = this.igb.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.igb.put("tab", "live_jump");
                        this.igb.put("tag", "");
                        this.igb.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.igb.put("tab", "liveroom");
                        this.igb.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                con();
            }
        }
    }

    private void n(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.IT();
        }
        bVar.setAnchorId(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void cop() {
        ac.Fz();
    }

    private void k(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.ifY.e(s);
        } else {
            this.ifY.f(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
