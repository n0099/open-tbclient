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
    private static int ieH = 1;
    private static WeakReference<b> mRef;
    private boolean DEBUG;
    private ab aDd;
    private com.baidu.live.u.b bOP;
    private CustomMessageListener bgy;
    private boolean biC;
    private long buN;
    private String buO;
    private boolean byF;
    private AlaLiveView hGD;
    private ViewGroup hGE;
    private LayerRootView hGF;
    private long hGJ;
    private d.a hGT;
    private com.baidu.tieba.ala.liveroom.n.d hGl;
    private e hHh;
    private com.baidu.live.t.b hHi;
    private com.baidu.live.t.b hHj;
    private f hHk;
    private com.baidu.live.t.d hHl;
    private com.baidu.live.v.c hHm;
    private com.baidu.live.v.b hHn;
    private Runnable hJY;
    private String hoQ;
    CustomMessageListener hsV;
    private a idY;
    private SafeFrameLayout idZ;
    private boolean ieA;
    private String ieB;
    private boolean ieC;
    private bw ieD;
    private boolean ieE;
    private boolean ieF;
    private int ieG;
    private boolean ieI;
    private boolean ieJ;
    private Runnable ieK;
    private Runnable ieL;
    private Runnable ieM;
    private boolean ieN;
    private boolean ieO;
    private CustomMessageListener ieP;
    private CustomMessageListener ieQ;
    private com.baidu.live.ag.c ieR;
    private boolean ieS;
    private boolean ieT;
    private long ieU;
    private long ieV;
    private CustomMessageListener ieW;
    private com.baidu.live.u.a ieX;
    com.baidu.live.liveroom.a.c ieY;
    ViewPager.OnPageChangeListener ieZ;
    private AlaLiveRoomBlurPageLayout iea;
    private AlaLoopViewPager ieb;
    private AlaLoopViewPagerAdapter iec;
    private com.baidu.tieba.ala.liveroom.d.a ied;
    private com.baidu.tieba.ala.liveroom.d.b iee;
    private SdkLivePlayer ief;
    private AlaLastLiveroomInfo ieg;
    private boolean ieh;
    private boolean iei;
    private boolean iej;
    private boolean iek;
    @Deprecated
    private boolean iel;
    private ArrayList<AlaBroadcastGiftToastData> iem;
    private String ien;
    private com.baidu.tieba.ala.endliveroom.a ieo;
    private com.baidu.tieba.ala.liveroom.c.c iep;
    private String ieq;
    private long ier;
    private JSONObject ies;
    private boolean iet;
    private com.baidu.tieba.ala.liveroom.task.c ieu;
    private StayTimeBean iev;
    private boolean iew;
    private com.baidu.tieba.ala.liveroom.j.a iex;
    private com.baidu.tieba.ala.liveroom.u.c iey;
    private boolean iez;
    HttpMessageListener ifa;
    CustomMessageListener ifb;
    CustomMessageListener ifc;
    CustomMessageListener ifd;
    CustomMessageListener ife;
    private CustomMessageListener iff;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void cnz() {
        if (this.iey != null) {
            this.iey.bE(this.biC);
        }
        if (this.iex != null) {
            this.iex.bE(this.biC);
        }
        if (al.FB() != null) {
            al.FB().bE(this.biC);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.DEBUG = false;
        this.mSelectedPosition = 1;
        this.ieh = true;
        this.hGJ = 0L;
        this.iei = false;
        this.byF = true;
        this.buO = "";
        this.mForumName = "";
        this.iej = false;
        this.iel = false;
        this.ien = "0";
        this.mHandler = new Handler();
        this.ier = -1L;
        this.otherParams = "";
        this.iet = false;
        this.ieu = com.baidu.tieba.ala.liveroom.task.c.ckH();
        this.iew = false;
        this.ieA = false;
        this.ieC = false;
        this.ieF = false;
        this.ieG = 0;
        this.ieI = false;
        this.ieJ = false;
        this.hJY = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cjb();
            }
        };
        this.ieK = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.cnX();
            }
        };
        this.ieL = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.hGl.cjx();
            }
        };
        this.ieM = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.hsV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ieN = true;
            }
        };
        this.ieP = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ieO = true;
            }
        };
        this.ieQ = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.ieW = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.biC = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.cnz();
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
                if (b.this.iep != null) {
                    b.this.iep.cv(i);
                }
            }
        };
        this.ieX = new com.baidu.live.u.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.u.a
            public void cL(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.ief != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.ief.isPlaying());
                        if (b.this.ief.isPlaying()) {
                            if (b.this.ief.isPaused()) {
                                b.this.ief.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.ief.isPlaying()) {
                        b.this.ief.pause();
                    }
                }
            }
        };
        this.ieY = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void cC(boolean z) {
                if (z || b.this.iep == null || b.this.iep.cbX()) {
                    if (!b.this.cnI() || b.this.a(true, (a.InterfaceC0627a) null)) {
                        b.this.ieJ = true;
                        b.this.pf(true);
                        b.this.bZb();
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
                    jSONObject.put("isStoped", b.this.iej);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (arrayList != null && arrayList.size() > 1) {
                    str2 = "one_to_two_start";
                } else {
                    str2 = "two_to_one_start";
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", str2).setContentExt(null, null, jSONObject));
                b.this.ief.coo();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.iej) {
                    if (b.this.iej) {
                        b.this.ief.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.ief.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.ieb != null) {
                    b.this.ieb.setIsScrollable(b.this.ieE && z);
                    b.this.ieb.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cE(boolean z) {
                boolean z2 = true;
                if (!z || b.this.cog()) {
                    if (b.this.iea != null) {
                        b.this.iea.clm();
                        return;
                    }
                    return;
                }
                if (b.this.hGl.Fm().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.iea != null) {
                    b.this.iea.oO(z2);
                }
            }
        };
        this.ieZ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.ieb != null && i == 0) {
                    b.this.cnT();
                    com.baidu.live.d.xc().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.hGT = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.n.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.R(b.this.hGl.Fm());
                } else if (i2 == 2) {
                    b.this.f(b.this.hGl.bTR());
                } else if (i2 == 3) {
                    b.this.bx(i, str2);
                } else if (i2 == 4) {
                    b.this.aI(obj);
                } else if (i2 == 5) {
                    b.this.cnW();
                }
            }
        };
        this.ifa = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.ckF() != null && b.this.mTbPageContext != null) {
                        b.this.ieu.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.ckF());
                    }
                }
            }
        };
        this.ifb = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
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
        this.ifc = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.hGl != null && b.this.hGl.Fm() != null && b.this.hGl.Fm().mLiveInfo != null) {
                    long j = b.this.hGl.Fm().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + "," + iArr[1] + "]");
                    if (b.this.ieR != null) {
                        b.this.ieR.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.ifd = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.hGl != null && b.this.hGl.Fm() != null && b.this.hGl.Fm().aIz != null) {
                        if (l.longValue() == b.this.hGl.Fm().aIz.userId) {
                            b.this.hGl.Fm().aIz.isNewUser = false;
                            if (b.this.iex != null) {
                                b.this.iex.o(b.this.hGl.Fm());
                            }
                        }
                    }
                }
            }
        };
        this.ife = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.s.a)) {
                    com.baidu.tieba.ala.liveroom.s.a aVar2 = (com.baidu.tieba.ala.liveroom.s.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String BS = aVar2.BS();
                    if (b.this.mTbPageContext != null && b.this.hGl != null && b.this.hGl.Fm() != null && b.this.hGl.Fm().aIz != null) {
                        if (valueOf.longValue() == b.this.hGl.Fm().aIz.userId && com.baidu.live.ae.a.Qj().bAS != null && com.baidu.live.ae.a.Qj().bAS.aPK != null && com.baidu.live.ae.a.Qj().bAS.aPK.CA()) {
                            g.vz(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, BS));
                        }
                    }
                }
            }
        };
        this.iff = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.hJY != null) {
                    b.this.mHandler.removeCallbacks(b.this.hJY);
                }
                b.this.cjb();
            }
        };
        this.hGJ = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.idY = aVar;
        this.ieh = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ag.c.class);
        if (runTask != null) {
            this.ieR = (com.baidu.live.ag.c) runTask.getData();
        }
        this.hGl = new com.baidu.tieba.ala.liveroom.n.d(getPageContext());
        this.hGl.a(this.hGT);
        this.hGl.HZ(str);
        this.ieo = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.ifa);
        MessageManager.getInstance().registerListener(this.ifb);
        MessageManager.getInstance().registerListener(this.ifc);
        MessageManager.getInstance().registerListener(this.ifd);
        MessageManager.getInstance().registerListener(this.ife);
        MessageManager.getInstance().registerListener(this.iff);
        MessageManager.getInstance().registerListener(this.ieW);
        MessageManager.getInstance().registerListener(this.hsV);
        MessageManager.getInstance().registerListener(this.ieP);
        MessageManager.getInstance().registerListener(this.ieQ);
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
                        this.iem = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.iem.add(alaBroadcastGiftToastData);
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
            this.ieq = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.ieq = intent.getStringExtra("room_id");
        }
        this.buN = intent.getLongExtra("live_id", 0L);
        this.iet = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.hGl.b((AlaLiveInfoCoreData) serializableExtra);
            this.iet = true;
        }
        this.hGl.setIsMixLive(z);
        TbConfig.liveScene = 1;
        d(intent, z);
        this.ieE = this.ieD == null || !this.ieD.aQd;
        this.ieo.setOtherParams(this.otherParams);
        pd(z);
        cnA();
        this.mHandler.removeCallbacks(this.ieM);
        this.mHandler.postDelayed(this.ieM, 1000L);
    }

    private void d(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.ieG = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hoQ = null;
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
                this.ies = new JSONObject(stringExtra);
                if (this.ies != null) {
                    String ed = ed(this.ies);
                    String ec = ec(this.ies);
                    if ((!TextUtils.isEmpty(ed) && TextUtils.equals(this.ieq, ed)) || (!TextUtils.isEmpty(ec) && TextUtils.equals(this.buN + "", ec))) {
                        String eb = eb(this.ies);
                        if (!TextUtils.isEmpty(eb)) {
                            eb = URLDecoder.decode(eb, "UTF-8");
                        }
                        if (this.DEBUG) {
                            Log.i("LivePlayerActivity", "@@ coverUrl = " + eb);
                        }
                        String ee = ee(this.ies);
                        if (this.DEBUG) {
                            Log.i("LivePlayerActivity", "@@ liveUrl = " + ee);
                        }
                        if (!this.iet) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.buN;
                            alaLiveInfoCoreData.screenDirection = ea(this.ies);
                            if (!TextUtils.isEmpty(eb)) {
                                alaLiveInfoCoreData.liveCover = eb;
                            }
                            a(ee, alaLiveInfoCoreData);
                            this.hGl.b(alaLiveInfoCoreData);
                            this.iet = true;
                        }
                    }
                    String optString2 = this.ies.optString("extra");
                    try {
                        this.ieU = Long.parseLong(this.ieq);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.ieV = this.buN;
                    if (TextUtils.isEmpty(optString2)) {
                        this.ieD = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString2);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString3 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString3) && this.hGl != null) {
                            this.hGl.Ht(optString3);
                        }
                        this.ieS = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.ieT = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hoQ = jSONObject.optString("live_back_scheme");
                        this.ieD = new bw();
                        this.ieD.aQd = jSONObject.optInt("is_hot") == 1;
                        if (this.ieD.aQd) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.ieG = AlaLiveSwitchData.isHotLive;
                        this.ieD.aQe = jSONObject.optString("task_id");
                        this.ieD.aQc = !TextUtils.isEmpty(this.ieD.aQe);
                        this.ieD.aQf = jSONObject.optInt("task_type");
                        this.ieD.aQg = jSONObject.optInt("task_im_count");
                        this.ieD.aQh = jSONObject.optLong("task_gift_total_price");
                        this.ieD.aQi = jSONObject.optLong("task_watch_time");
                        this.ieD.aQj = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.ies.put("from", optString);
                        }
                        String optString4 = jSONObject.optString("back_app_scheme");
                        String optString5 = jSONObject.optString("back_app_icon");
                        String optString6 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            this.iee = new com.baidu.tieba.ala.liveroom.d.b();
                            this.iee.setScheme(optString4);
                            this.iee.setImageUrl(optString5);
                            this.iee.setTitle(optString6);
                        }
                    }
                    this.ien = this.ies.optString("open_giftlist");
                    this.ies.remove("cover");
                    this.ies.remove("live_url");
                    this.ies.remove("enterRoomId");
                    this.ies.remove("enterLiveId");
                    this.ies.remove("open_giftlist");
                    this.ies.remove("extra");
                    this.otherParams = this.ies.toString();
                    if (this.hGl != null) {
                        this.hGl.setOtherParams(this.otherParams);
                    }
                    this.ies.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ies.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ies.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ies.optString("source");
                    }
                    this.ieF = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.ies.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.hGl != null) {
                        this.hGl.vY(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.ieg = new AlaLastLiveroomInfo();
                this.ieg.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.buN), String.valueOf(this.ieq), null, cnQ(), this.idY != null ? this.idY.cnw() : false);
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

    public void cnA() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.hGl.aw(this.uk, this.buO, this.mForumName);
        } else if (this.hGl.Fm() != null && this.hGl.Fm().mLiveInfo != null && this.hGl.Fm().mLiveInfo.live_id > 0) {
            this.hGl.a(this.hGl.Fm().mLiveInfo.live_id, false, this.buO, this.mForumName);
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
            this.hGl.aw(this.uk, this.buO, this.mForumName);
        } else if (!TextUtils.isEmpty(this.ieq)) {
            this.hGl.HY(this.ieq);
        } else if (this.buN > 0) {
            this.hGl.a(this.buN, false, this.buO, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            pf(false);
        }
    }

    private void pd(boolean z) {
        this.byF = true;
        this.iei = false;
        pe(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        b(visibilityRegion);
        c(visibilityRegion);
        com.baidu.live.core.layer.b.Bc().l(this.hGF);
        this.iep = new com.baidu.tieba.ala.liveroom.c.c();
        this.iep.a(this.ieY);
        this.iep.setOtherParams(this.otherParams);
        this.iep.nO(this.ieF);
        this.iep.a(this.idY.cnx());
        cnE();
        cnB();
        cnD();
        cnC();
    }

    private void pe(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_main_layout, (ViewGroup) null);
        this.idZ = (SafeFrameLayout) inflate.findViewById(a.f.live_root_view);
        ViewCommonUtil.setForceDarkAllowed(this.idZ, false);
        this.ieb = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.ieb.setOnPageChangeListener(this.ieZ);
        this.ieb.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void cgM() {
                b.this.cnT();
            }
        });
        this.ieb.setBoundaryCaching(true);
        this.ieb.setDetermineYRatio(1.0f);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.iec = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.iec.cgK();
        this.iea = this.iec.vF(this.mSelectedPosition);
        this.iec.a(this.mSelectedPosition, this.hGl.Fm());
        this.ieb.setAdapter(this.iec);
        this.ieb.setCurrentItem(this.mSelectedPosition);
        this.ieb.setIsScrollable(this.ieE);
        this.ieb.setIsMixLive(z);
        this.hGE = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hGF = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
    }

    private void b(Rect rect) {
        this.ief = SdkLivePlayer.gc(getPageContext().getPageActivity());
        if (this.ief == null) {
            this.ieb.setIsScrollable(false);
            if (this.hGl != null) {
                this.hGl.cancelLoadData();
            }
            cgO();
            return;
        }
        this.ief.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.c.sdk_transparent));
        this.ief.setIPlayerCallBack(this.bOP);
        this.ief.setIPlayerAudioFocusCallBack(this.ieX);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.iea.a(this.ief, layoutParams, true);
    }

    private void cnB() {
        this.ied = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext, this.hGE);
    }

    private void cnC() {
        CustomResponsedMessage runTask;
        if (this.hHn == null && (runTask = MessageManager.getInstance().runTask(2913266, com.baidu.live.v.b.class)) != null) {
            this.hHn = (com.baidu.live.v.b) runTask.getData();
        }
        if (this.hHn != null) {
            this.hHn.setParentView(this.hGE);
        }
    }

    private void cnD() {
        CustomResponsedMessage runTask;
        if (this.hHl == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.t.d.class)) != null) {
            this.hHl = (com.baidu.live.t.d) runTask.getData();
        }
        if (this.hHl != null) {
            this.hHl.setParentView(this.hGE);
        }
    }

    private void cgO() {
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
        this.hGD = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.ala_liveroom_player_layout, null);
        this.hGD.setSwipeClearEnable(true);
        this.hGD.hRw = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.iea.a(this.hGD, layoutParams);
    }

    private void cnE() {
        if (this.hGl != null && this.hGl.Fm() != null) {
            this.aDd = this.hGl.Fm();
            if (this.aDd.mLiveInfo != null) {
                a(this.aDd.mLiveInfo, this.iet);
                if (this.aDd.mLiveInfo != null && this.aDd.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.iej);
                    }
                    if (!this.iej) {
                        this.ief.c(this.aDd.mLiveInfo);
                    } else {
                        this.ief.setPlayLiveInfo(this.aDd.mLiveInfo);
                    }
                    if (this.iep != null) {
                        this.iep.a(this.mTbPageContext, this.hGD, this.ief, this.iea, this.hGl, this.buO, this.iel, this.hGJ, this.iem, this.ieD, this.ieb);
                        k(this.aDd.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean cnF() {
        boolean z;
        AlaLiveInfoData cjG;
        if (this.idY.cnw()) {
            return false;
        }
        if (this.hGl == null || (cjG = this.hGl.cjG()) == null || cjG.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !cjG.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.ieU + ", getPlayingRoomID:" + cnG() + ", mSchemeLiveId:" + this.ieV + ", getPlayingLiveID:" + cnH());
        }
        return z || cnJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cnG() {
        AlaLiveInfoData cjG;
        if (this.hGl == null || (cjG = this.hGl.cjG()) == null) {
            return 0L;
        }
        return cjG.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cnH() {
        AlaLiveInfoData cjG;
        if (this.hGl == null || (cjG = this.hGl.cjG()) == null) {
            return 0L;
        }
        return cjG.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cnI() {
        boolean z = false;
        if (!this.idY.cnw()) {
            if (this.ieS && (this.ieU == cnG() || this.ieV == cnH())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean cnJ() {
        boolean z = this.ieT && (this.ieU == cnG() || this.ieV == cnH());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean cnK() {
        if (ieH <= 0) {
            return false;
        }
        if (!(cnI() || cnF()) || FloatPermissionUtil.MP()) {
            return false;
        }
        ieH--;
        FloatPermissionUtil.ah(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0627a interfaceC0627a) {
        if (!FloatPermissionUtil.MP()) {
            if (this.ieI) {
                return true;
            }
            this.ieI = true;
            if (z) {
                FloatPermissionUtil.ah(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (cnI()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.ieT) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a fW = com.baidu.tieba.ala.floating.b.fW(getPageContext().getPageActivity());
        fW.a(interfaceC0627a);
        fW.dK(jSONObject);
        com.baidu.tieba.ala.floating.b.fW(getPageContext().getPageActivity()).a(this.ief, this.hGl.Fm(), this.buO, this.hGJ);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bUV() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bUQ = com.baidu.tieba.ala.floating.b.bUQ();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0627a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0627a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bUQ == null || bUQ.room_id == b.this.cnG() || bUQ.live_id == b.this.cnH()) {
                    if (b.this.ief != null) {
                        b.this.cnL();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.iej);
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
    public void cnL() {
        ArrayList arrayList = (ArrayList) this.ief.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.ief.con();
            this.ief.af(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bUT();
    }

    public void pb(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.iek = z;
    }

    private void cnM() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.ieE) {
                this.ieb.setIsScrollable(true);
            } else {
                this.ieb.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Bc().onBackPressed() && ((this.iep == null || !this.iep.onKeyDown(i, keyEvent)) && (this.iep == null || !this.iep.cbW()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cnM();
            } else if ((this.iep == null || this.iep.cbX()) && (!cnI() || a(true, (a.InterfaceC0627a) null))) {
                this.ieJ = true;
                pf(true);
                bZb();
            }
        }
        return true;
    }

    public void bZb() {
        if (!TextUtils.isEmpty(this.hoQ)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hoQ);
                this.hoQ = null;
            }
        }
    }

    public void pf(boolean z) {
        U(z, false);
    }

    public void U(boolean z, boolean z2) {
        nU(!z);
        if (this.ief != null && !this.ief.isFloatingMode()) {
            this.ief.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.Bc().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cnO();
        long j = -1;
        if (this.hGl != null && this.hGl.cjG() != null) {
            j = this.hGl.cjG().room_id;
        }
        this.idY.b(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void nU(boolean z) {
        if (this.idY.cnw() && this.idY.cnx() != null) {
            this.idY.cnx().x("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.ieg = null;
        if (al.FB() != null) {
            al.FB().FA();
        }
        com.baidu.live.core.layer.b.Bc().Bd();
        if (this.ieR != null) {
            this.ieR.release();
        }
        if (this.iex != null) {
            this.iex.release();
        }
        this.ieD = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.hGl != null) {
            try {
                this.hGl.Ht(null);
                AlaLiveInfoData cjG = this.hGl.cjG();
                if (cjG != null) {
                    this.hGl.fI(cjG.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.ieu.stopRecord();
        LiveTimerManager.getInstance().stop();
        cnN();
        if (this.ief != null && !this.ief.isFloatingMode()) {
            this.ief.cM(z);
        }
        if (this.iep != null) {
            this.iep.nU(z);
        }
        this.iew = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Mu().brr != null && this.aDd != null) {
            com.baidu.live.liveroom.a.b.Mu().brr.b(this.aDd.mLiveInfo);
        }
        ac.gn("");
        x.Fc().release();
        if (this.hHl != null) {
            this.hHl.Fy();
        }
        if (this.hHn != null) {
            this.hHn.Fy();
        }
        if (this.idY != null && this.idY.cnw()) {
            ac.Fx();
        }
    }

    private void cnN() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cnO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(ab abVar) {
        if (abVar != null) {
            this.aDd = abVar;
            if (this.iep != null) {
                this.iep.a(abVar);
            }
            if (this.hHn != null && this.hGl.Fm() != null) {
                this.hHn.b(this.hGl.Fm(), this.otherParams);
            }
            cnK();
        }
    }

    private void c(v vVar) {
        if (this.iep != null) {
            this.iep.c(vVar);
        }
    }

    private void V(ab abVar) {
        this.aDd = abVar;
        cnK();
    }

    private void cnP() {
        long j;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.ieE = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.ieE = true;
        }
        this.ieb.setIsScrollable(this.ieE);
        this.ieG = AlaLiveSwitchData.isHotLive;
        if (this.aDd != null) {
            a(this.aDd.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.iea.a(this.hGD, null);
            if (!isFloatingMode()) {
                a(this.iea, this.aDd.mLiveInfo, this.byF);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aDd.mLiveInfo.live_id), String.valueOf(this.aDd.mLiveInfo.room_id), String.valueOf(this.aDd.mLiveInfo.feed_id), cnQ(), this.idY != null ? this.idY.cnw() : false);
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
                if (this.hGl != null && this.hGl.Fm() != null && this.hGl.Fm().mLiveInfo != null) {
                    j = this.hGl.Fm().mLiveInfo.live_id;
                    str2 = this.hGl.Fm().mLiveInfo.feed_id;
                    str = this.hGl.Fm().mLiveInfo.room_id + "";
                } else {
                    if (this.buN > 0) {
                        j2 = this.buN;
                    }
                    if (TextUtils.isEmpty(this.ieq)) {
                        j = j2;
                    } else {
                        str = this.ieq;
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
                if (this.hGl != null && this.hGl.Fm() != null && this.hGl.Fm().mLiveInfo != null) {
                    str3 = this.hGl.Fm().mLiveInfo.feed_id;
                    str4 = this.hGl.Fm().mLiveInfo.live_id + "";
                    str5 = this.hGl.Fm().mLiveInfo.room_id + "";
                    str6 = this.hGl.Fm().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            cnK();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String cnQ() {
        if (this.ies == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.ies.optString("source");
            String optString2 = this.ies.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ies.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.ies.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.ies.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bUV();
        } else if (this.ief != null && this.ief.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.ief.getVideoPath();
                String d = com.baidu.live.u.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.ief.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.u.h.aH(videoPath, d)) {
                    this.ief.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.u.h.aG(videoPath, d)) {
                    this.ief.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.cz(this.ief)) {
                        ((ViewGroup) this.ief.getParent()).removeView(this.ief);
                        alaLiveRoomBlurPageLayout.a(this.ief, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.iej) {
                        this.ief.c(alaLiveInfoData);
                        return;
                    } else {
                        this.ief.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.ief.con();
        } else if (this.ief != null && this.ief.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.ief, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.iej) {
                    this.ief.c(alaLiveInfoData);
                } else {
                    this.ief.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b2 = b(iArr, z, i, i2, i3);
        if (this.ief != null) {
            this.ief.setLayoutParams(b2);
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

    public void cnR() {
        this.byF = true;
    }

    public boolean cnS() {
        return this.byF;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        a(UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()), alaLiveInfoData, z);
    }

    private void a(int i, AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (this.ief != null) {
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
            if (this.iea != null) {
                this.iea.setBackgroundColor(0);
            }
            int i3 = this.ief.getLayoutParams().width;
            int i4 = this.ief.getLayoutParams().height;
            int i5 = this.ief.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.ief.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b2 = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b2.width != i3 || b2.height != i4 || b2.topMargin != i5) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.hGD != null) {
                this.hGD.setLayoutParams(c);
            }
            if (this.iea != null) {
                this.iea.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ieo != null) {
                this.ieo.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.iep != null) {
                this.iep.l(c.width, c.height, realScreenOrientation);
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
            if (this.iea != null) {
                this.iea.setBgImageUrl(this.aDd.mLiveInfo.cover, this.aDd.mLiveInfo);
            }
            this.iec.a(this.mSelectedPosition, cnU(), this.aDd);
            this.iec.b(this.mSelectedPosition, cnV(), this.aDd);
            if (this.iea != null) {
                this.iea.requestLayout();
                this.iea.M(i, this.aDd.mLiveInfo.screen_direction == 2);
            }
        }
        if (this.aDd != null) {
            a(i, this.aDd.mLiveInfo, false);
        }
        boolean cln = this.iea.cln();
        boolean z2 = i == 1;
        if (this.aDd == null || this.aDd.mLiveInfo == null || this.aDd.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!cog()) {
            if (this.ief != null && this.ief.getParent() == null) {
                this.iea.a(this.ief, null, false);
                if (this.aDd != null && this.aDd.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.iej) {
                        this.ief.c(this.aDd.mLiveInfo);
                    } else {
                        this.ief.setPlayLiveInfo(this.aDd.mLiveInfo);
                    }
                }
            }
            if (cln && !cog() && this.iep != null) {
                this.iea.oO(z);
                return;
            }
            return;
        }
        this.iea.clj();
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
            this.hGl.a(alaLiveInfoData.live_id, true, this.buO, this.mForumName, this.ieG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnT() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.ieb != null && this.hGD != null && this.mSelectedPosition != (currentItem = this.ieb.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.h.sdk_neterror);
                this.ieb.setCurrentItem(this.mSelectedPosition);
            } else if (!this.byF && ListUtils.getCount(this.hGl.cjw()) <= 1) {
                this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                this.ieb.setCurrentItem(this.mSelectedPosition);
                this.hGl.g(this.hGl.cjG());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.hGl.cjB() && i < 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                    this.ieb.setCurrentItem(this.mSelectedPosition);
                } else if (this.hGl.cjC() && i > 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                    this.ieb.setCurrentItem(this.mSelectedPosition);
                    this.hGl.g(this.hGl.cjG());
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.hGl.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    nU(true);
                    this.iea.clj();
                    this.iea.Xi();
                    this.iea.clk();
                    if (this.hGl.Fm() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.hGl.Fm().mLiveInfo.live_id + "", this.hGl.Fm().mLiveInfo.room_id + "", this.hGl.Fm().aId.userId + "", this.hGl.Fm().aId.userName, System.currentTimeMillis(), this.hGl.Fm().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.hGl.Fm().mLiveInfo.live_id + "", this.hGl.Fm().mLiveInfo.room_id + "", this.hGl.Fm().aId.userId + "", this.hGl.Fm().aId.userName, System.currentTimeMillis(), this.hGl.Fm().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.iev != null) {
                        long j = this.hGl.Fm().mLiveInfo.live_id;
                        if (this.iev.liveId == j && this.iev.startTime > 0) {
                            this.iev.endTime = System.currentTimeMillis();
                            long j2 = this.iev.endTime - this.iev.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.iev.roomId + "", this.iev.vid, j2 / 1000, this.otherParams);
                        }
                        this.iev = null;
                    }
                    coi();
                    if (this.ieR != null) {
                        this.ieR.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.iea = this.iec.vG(this.mSelectedPosition);
                    this.iea.cll();
                    wy(i);
                    cnK();
                }
            }
        }
    }

    public void wy(int i) {
        if (i < 0) {
            this.hGl.vZ(this.hGl.cjD() - 1);
        } else if (i > 0) {
            this.hGl.vZ(this.hGl.cjD() + 1);
        }
        if (this.iep != null) {
            this.iep.a(this.iea);
        }
        this.iec.a(this.mSelectedPosition, cnU(), this.aDd);
        this.iec.b(this.mSelectedPosition, cnV(), this.aDd);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.hGl != null) {
            int cjD = this.hGl.cjD();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", cjD + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.hGl.cjw() != null && this.hGl.cjw().size() > cjD && this.hGl.cjw().get(cjD) != null) {
                AlaLiveInfoData alaLiveInfoData = this.hGl.cjw().get(cjD);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hGl != null) {
            AlaLiveInfoData cjG = this.hGl.cjG();
            com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(cjG.live_id)));
            if (cjG != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(cjG.live_id), String.valueOf(cjG.room_id), null, cnQ(), this.idY != null ? this.idY.cnw() : false);
                l.c(this.hGl.cjD(), cjG.room_id, cjG.live_id);
                cjG.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bUV();
                }
                a(this.iea, cjG, this.byF);
                this.byF = false;
                if (this.iep != null) {
                    this.iep.a(this.mTbPageContext, this.hGD, this.ief, this.iea, this.hGl, this.buO, this.iel, this.hGJ, null, this.ieD, this.ieb);
                    short s = 2;
                    if (cjG.screen_direction == 2) {
                        s = 1;
                    }
                    k(s);
                }
                a(cjG, false);
            } else {
                l.ic("currentLiveInfo is null");
            }
            i(cjG);
            this.iea.a(this.hGD, null);
            if (this.iep != null) {
                this.iep.cbU();
            }
            this.hGl.g(cjG);
        }
    }

    private AlaLiveInfoData cnU() {
        List<AlaLiveInfoData> cjw = this.hGl.cjw();
        if (cjw == null || cjw.size() == 0) {
            if (this.aDd == null) {
                return null;
            }
            return this.aDd.mLiveInfo;
        }
        int cjD = this.hGl.cjD();
        int size = cjw.size();
        return cjw.get(((cjD + size) - 1) % size);
    }

    private AlaLiveInfoData cnV() {
        List<AlaLiveInfoData> cjw = this.hGl.cjw();
        if (cjw == null || cjw.size() == 0) {
            if (this.aDd == null) {
                return null;
            }
            return this.aDd.mLiveInfo;
        }
        return cjw.get((this.hGl.cjD() + 1) % cjw.size());
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
            if (!this.iej) {
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
        ab Fm = this.hGl.Fm();
        V(Fm);
        this.hGl.cjx();
        if (this.byF) {
            this.hGl.oG(false);
        }
        this.hGJ = System.currentTimeMillis() / 1000;
        if (this.iep != null) {
            this.iep.a(this.mTbPageContext, this.hGD, this.ief, this.iea, this.hGl, this.buO, this.iel, this.hGJ, this.iem, this.ieD, this.ieb);
            short s = 2;
            if (Fm.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            k(s);
        }
        if (this.idY.cnx() != null && this.idY.cnw()) {
            this.idY.cnx().x("load_finish", null);
            if (Fm.mLiveInfo.screen_direction == 2) {
                this.idY.cnx().x("screen_auto_rotate", true);
            } else {
                this.idY.cnx().x("screen_auto_rotate", false);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
                this.idY.cnx().x("mix_room_scroll", Boolean.valueOf(!TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()));
            }
        }
        cnP();
        if (Fm != null && Fm.mLiveInfo != null && Fm.mLiveInfo.live_status == 2) {
            this.iec.a(this.mSelectedPosition, this.hGl.Fm());
            e(Fm, false);
            this.byF = false;
            W(Fm);
            return;
        }
        if (this.hHh == null && (runTask5 = MessageManager.getInstance().runTask(2913229, e.class)) != null) {
            this.hHh = (e) runTask5.getData();
        }
        if (this.hHh != null) {
            this.hHh.Pj();
        }
        if (this.hHi == null && (runTask4 = MessageManager.getInstance().runTask(2913292, com.baidu.live.t.b.class)) != null) {
            this.hHi = (com.baidu.live.t.b) runTask4.getData();
        }
        if (this.hHi != null) {
            this.hHi.Pj();
        }
        if (this.hHj == null && (runTask3 = MessageManager.getInstance().runTask(2913296, com.baidu.live.t.b.class)) != null) {
            this.hHj = (com.baidu.live.t.b) runTask3.getData();
        }
        if (this.hHj != null) {
            this.hHj.Pj();
        }
        if (this.hHk == null && (runTask2 = MessageManager.getInstance().runTask(2913293, f.class)) != null) {
            this.hHk = (f) runTask2.getData();
        }
        if (this.hHk != null) {
            this.hHk.Pj();
        }
        if (this.hHm == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.v.c.class)) != null) {
            this.hHm = (com.baidu.live.v.c) runTask.getData();
        }
        if (this.hHm != null) {
            this.hHm.Pj();
        }
        boolean z = (this.iep == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        ac.e(Fm);
        if (z) {
            if (!this.ieA || !TextUtils.equals(q.Vv(), this.ieB)) {
                ac.b(getPageContext(), false, this.idY != null && this.idY.cnw());
                com.baidu.live.ae.e.Qz().QA();
                this.ieA = true;
                this.ieB = q.Vv();
            }
            ac.gn("");
            ac.Ft();
        }
        if (this.hGl.Fm() != null && this.hGl.Fm().mLiveInfo != null) {
            this.hGl.j(this.hGl.Fm().mLiveInfo.live_id, !this.iew);
            this.iew = true;
        }
        if (this.iep != null) {
            this.iep.b(this.ieg);
            this.iep.nT(TextUtils.equals(this.ien, "1"));
            this.ien = "";
        }
        if (this.ied != null) {
            this.ied.a(this.aDd, this.iee);
        }
        a(this.hGl.Fm());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.hGl.Fm() != null && b.this.hGl.Fm().mLiveInfo != null) {
                    b.this.hGl.a(b.this.hGl.Fm().mLiveInfo.live_id, b.this.buO, b.this.hGJ);
                }
            }
        });
        if (z && this.hGl.Fm() != null && this.hGl.Fm().aId != null) {
            bv bvVar = com.baidu.live.ae.a.Qj().bAS;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bvVar != null && bvVar.aPP != null && bvVar.aPP.aSu) {
                m(true, this.hGl.Fm().aId.userId);
            }
        }
        this.byF = false;
        if (z && this.hGl.Fm() != null && this.hGl.Fm().mLiveInfo != null && this.hGl.Fm().aId != null && this.iep != null) {
            long j = this.hGl.Fm().mLiveInfo.live_id;
            long j2 = this.hGl.Fm().mLiveInfo.room_id;
            String str2 = this.hGl.Fm().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.FB() != null) {
                    al.FB().bE(this.biC);
                    if (!this.biC) {
                        al.FB().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.ieR != null) {
                    this.ieR.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.IS() != null) {
                com.baidu.live.guardclub.e.IS().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.iex == null) {
                this.iex = new com.baidu.tieba.ala.liveroom.j.a();
                this.iex.bE(this.biC);
            }
            if (!this.biC) {
                this.iex.a(this.mTbPageContext.getPageActivity(), this.hGl.Fm(), this.otherParams);
            }
        }
        if (this.iey == null) {
            this.iey = new com.baidu.tieba.ala.liveroom.u.c(this.mTbPageContext);
            this.iey.bE(this.biC);
        }
        if (z && this.hGl.Fm() != null && this.hGl.Fm().aIz != null && !this.iez) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.iey.a(this.hGl.Fm(), this.hGl.Fm().aIz.userId);
                this.iez = true;
            }
        }
        if (this.hGl.Fm() != null && this.hGl.Fm().mLiveInfo != null && this.hGl.Fm().aIz != null) {
            com.baidu.live.p.a.e(this.hGl.Fm().mLiveInfo.live_id, this.hGl.Fm().aIz.needRename == 1);
            if (z) {
                com.baidu.live.p.a.c(this.hGl.Fm().mLiveInfo.live_id, 0);
            }
        }
        if (this.hHl != null && this.hGl.Fm() != null && this.hGl.Fm().aId != null) {
            this.hHl.bh(this.hGl.Fm().aId.userId);
        }
    }

    private void W(ab abVar) {
        String str = "";
        if (!TextUtils.isEmpty(this.uk)) {
            str = "uk=" + this.uk;
        } else if (this.buN > 0) {
            str = "live_id=" + this.buN;
        } else if (!TextUtils.isEmpty(this.ieq)) {
            str = "live_room_id=" + this.ieq;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            str = "url=" + this.mUrl;
        }
        LogManager.getLiveCloseLogger().doEnterLiveCloseGuestLog(abVar.mLiveInfo.live_id + "", abVar.mLiveInfo.room_id + "", abVar.mLiveInfo.feed_id, str, this.otherParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnW() {
        if (this.ieh) {
            this.iec.a(this.mSelectedPosition, cnU(), this.aDd);
            this.iec.b(this.mSelectedPosition, cnV(), this.aDd);
            this.ieh = false;
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
        if (!this.iej) {
            this.mHandler.removeCallbacks(this.ieL);
            this.mHandler.postDelayed(this.ieL, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(v vVar) {
        if (vVar == null) {
            if (!this.iej) {
                this.mHandler.removeCallbacks(this.ieK);
                this.mHandler.postDelayed(this.ieK, 5000L);
                return;
            }
            return;
        }
        if (!this.iei) {
            c(vVar);
        }
        if (!this.iej) {
            this.mHandler.removeCallbacks(this.ieK);
            this.mHandler.postDelayed(this.ieK, vVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnX() {
        if (this.hGl.Fm() != null && this.hGl.Fm().mLiveInfo != null) {
            this.hGl.j(this.hGl.Fm().mLiveInfo.live_id, !this.iew);
            this.iew = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.live_status == 2) {
            this.iec.a(this.mSelectedPosition, this.hGl.Fm());
            e(abVar, false);
        } else if (abVar != null) {
            if (!this.iei) {
                ac.e(abVar);
                a(abVar);
            }
            if (!this.iej) {
                this.mHandler.removeCallbacks(this.hJY);
                this.mHandler.postDelayed(this.hJY, abVar.aIi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjb() {
        if (this.mTbPageContext != null && this.hGl.Fm() != null && this.hGl.Fm().mLiveInfo != null) {
            this.hGl.a(this.hGl.Fm().mLiveInfo.live_id, this.buO, this.hGJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ab abVar, boolean z) {
        String str;
        nU(true);
        if (!cog()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckf().oI(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckf().release();
            this.hGl.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.iea != null) {
                this.iea.Xi();
                this.iea.clj();
                this.iea.clo();
            }
            if (abVar == null || abVar.mLiveInfo == null) {
                str = null;
            } else {
                this.ier = abVar.mLiveInfo.live_id;
                str = String.valueOf(abVar.mLiveInfo.room_id);
            }
            cnM();
            cnY();
            cnZ();
            if (this.idY.cnw() && !StringUtils.isNull(str) && this.idY.cnx() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.idY.cnx().x("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (abVar != null) {
                View a2 = (this.iep == null || this.iep.cca() == null) ? null : this.iep.cca().a(this.iep.cbP().pageContext.getPageActivity(), abVar, z);
                if (this.iea != null) {
                    this.ieo.a(this.iea, a2, abVar, z, this.hGl.cjy());
                }
                if (this.iep != null) {
                    this.iep.nU(false);
                    this.iep.cbV();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.iea != null) {
                    this.iea.cll();
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
                this.iev = new StayTimeBean();
                this.iev.liveId = abVar.mLiveInfo.live_id;
                this.iev.roomId = abVar.mLiveInfo.room_id;
                this.iev.vid = abVar.mLiveInfo.feed_id;
                this.iev.startTime = System.currentTimeMillis();
            }
            coi();
            if (this.ied != null) {
                this.ied.a(this.aDd, this.iee);
            }
        }
    }

    private void cnY() {
    }

    private void cnZ() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.ieb);
        }
    }

    public void coa() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cob();
        } else {
            coc();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.hGl != null && this.hGl.Fm() != null) {
            alaLiveInfoData = this.hGl.Fm().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cob();
        } else {
            coc();
        }
        this.ieb.setIsScrollable(!z && this.ieE);
        if (this.iep != null) {
            this.iep.onKeyboardVisibilityChanged(z);
        }
        if (this.hGD != null) {
            this.hGD.onKeyboardVisibilityChanged(z);
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
            cob();
        } else {
            coc();
        }
        this.hGD.cr(i);
        wx(i);
        if (al.FB() != null) {
            al.FB().EK();
        }
        if (this.iex != null) {
            this.iex.EK();
        }
        if (this.ied != null) {
            this.ied.cr(i);
        }
    }

    public void cob() {
        if (this.ieb != null) {
            i.ae(this.ieb);
        }
    }

    public void coc() {
        if (this.ieb != null) {
            i.af(this.ieb);
        }
    }

    private boolean cod() {
        return this.ieN || this.ieO;
    }

    private void coe() {
        this.ieN = false;
        this.ieO = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.ieC + " mWebOver=" + this.iek + ", isFloatingMode=" + isFloatingMode());
        }
        coe();
        if (!this.iek || !isFloatingMode()) {
            bUV();
            if (this.hGl != null) {
                this.hGl.cji();
                this.hGl.cjm();
            }
            if (this.iep != null) {
                this.iep.enterForeground();
            }
            if (this.iex != null) {
                this.iex.onResume();
            }
            if (this.iey != null) {
                this.iey.onResume();
            }
            com.baidu.live.core.layer.b.Bc().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.ieC + " mWebOver=" + this.iek + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        coe();
        if ((!this.iek || !isFloatingMode()) && !this.ieC) {
            bUV();
            if (this.iej) {
                this.iej = false;
                cof();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            cnK();
        }
    }

    public void cof() {
        cjb();
        cnX();
        this.hGl.cjx();
        if (!this.ief.isPlaying()) {
            cnL();
        } else if (this.ief.isPaused()) {
            this.ief.resume();
        }
        if (this.iep != null) {
            this.iep.cbZ();
        }
        if (this.hGl != null && this.hGl.Fm() != null && this.hGl.Fm().mLiveInfo != null) {
            this.ieu.fL(this.hGl.Fm().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aDd.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.iek + ", isFloatingMode=" + isFloatingMode());
        }
        if (cod() || !this.iek || !isFloatingMode()) {
            if (this.hGl != null) {
                this.hGl.cjj();
                this.hGl.cjn();
            }
            if (this.iep != null) {
                this.iep.enterBackground();
            }
            com.baidu.live.core.layer.b.Bc().onPause();
        }
    }

    public void V(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.ieJ);
        }
        if (!cod() && z && !this.ieJ && cnF()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0627a() { // from class: com.baidu.tieba.ala.player.b.12
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0627a
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
        this.iej = true;
        pg(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void pg(boolean z) {
        this.mHandler.removeCallbacks(this.hJY);
        this.mHandler.removeCallbacks(this.ieK);
        this.mHandler.removeCallbacks(this.ieL);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.ief.isFloatingMode()) {
                this.ief.pausePlay();
            }
        } else if (!z && !this.ief.isFloatingMode()) {
            this.ief.pausePlay();
        }
        if (this.iep != null) {
            this.iep.cbY();
        }
        this.ieu.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.FB() != null) {
                al.FB().a(i, i2, intent, this.aDd, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.iep != null) {
            this.iep.onActivityResult(i, i2, intent);
        }
    }

    public boolean cog() {
        return this.ieo != null && this.ieo.bUL();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ifa != null) {
            MessageManager.getInstance().unRegisterListener(this.ifa);
        }
        if (this.ifb != null) {
            MessageManager.getInstance().unRegisterListener(this.ifb);
        }
        MessageManager.getInstance().unRegisterListener(this.ifc);
        MessageManager.getInstance().unRegisterListener(this.ifd);
        MessageManager.getInstance().unRegisterListener(this.ife);
        MessageManager.getInstance().unRegisterListener(this.iff);
        MessageManager.getInstance().unRegisterListener(this.ieW);
        MessageManager.getInstance().unRegisterListener(this.hsV);
        MessageManager.getInstance().unRegisterListener(this.ieP);
        MessageManager.getInstance().unRegisterListener(this.ieQ);
        MessageManager.getInstance().unRegisterListener(this.bgy);
        if (this.ieR != null) {
            this.ieR.release();
        }
        if (this.ief != null && !this.ief.isFloatingMode()) {
            this.ief.cM(true);
        }
        if (this.ied != null) {
            this.ied.onDestory();
        }
        if (this.hHl != null) {
            this.hHl.release();
            this.hHl = null;
        }
        if (this.hHn != null) {
            this.hHn.release();
            this.hHn = null;
        }
        if (this.iee != null) {
            this.iee.reset();
        }
        if (this.iep != null) {
            this.iep.onDestroy();
        }
        if (this.iec != null) {
            this.iec.onDestroy();
        }
        if (this.iea != null) {
            this.iea.Xi();
            this.iea.release();
            this.iea = null;
        }
        if (this.ieo != null) {
            this.ieo.onDestroy();
        }
        if (this.iev != null && this.hGl != null && this.hGl.Fm() != null) {
            long j = this.hGl.Fm().mLiveInfo.live_id;
            if (this.iev.liveId == j && this.iev.startTime > 0) {
                this.iev.endTime = System.currentTimeMillis();
                long j2 = this.iev.endTime - this.iev.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.iev.roomId + "", this.iev.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.iev = null;
        }
        if (this.hGD != null) {
            this.hGD.clr();
            this.hGD = null;
        }
        if (this.hGl != null) {
            this.hGl.destory();
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
        z.Fe().release();
        if (this.iey != null) {
            this.iey.release();
        }
        x.Fc().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String Lo() {
        return this.otherParams;
    }

    public void ph(boolean z) {
        this.ieC = z;
    }

    public void coh() {
        if (this.ies != null) {
            this.otherParams = this.ies.toString();
            if (this.hGl != null) {
                this.hGl.setOtherParams(this.otherParams);
            }
            if (this.iep != null) {
                this.iep.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.ieo != null) {
                this.ieo.setOtherParams(this.otherParams);
            }
        }
    }

    public void coi() {
        if (this.ies != null) {
            String optString = this.ies.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.ies.put("tab", "live_jump");
                        this.ies.put("tag", "");
                        this.ies.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.ies.put("tab", "liveroom");
                        this.ies.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                coh();
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

    public void coj() {
        ac.Fw();
    }

    private void k(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.iep.e(s);
        } else {
            this.iep.f(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
