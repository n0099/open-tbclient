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
import com.baidu.live.af.e;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bq;
import com.baidu.live.data.br;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.al;
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
/* loaded from: classes11.dex */
public class b extends BdBaseView<TbPageContext> {
    private static String TAG = "AlaLiveViewController";
    private static int ieG = 1;
    private static WeakReference<b> mRef;
    private boolean DEBUG;
    private x aGe;
    private com.baidu.live.v.b bPR;
    private CustomMessageListener bih;
    private boolean bkj;
    private long bvY;
    private String bvZ;
    private boolean bzP;
    private AlaLiveView hGM;
    private ViewGroup hGN;
    private LayerRootView hGO;
    private long hGS;
    private com.baidu.tieba.ala.liveroom.p.d hGu;
    private d.a hHc;
    private com.baidu.live.u.d hHq;
    private com.baidu.live.u.c hHr;
    private com.baidu.live.w.c hHs;
    private com.baidu.live.w.b hHt;
    private Runnable hKe;
    private String hoR;
    CustomMessageListener htd;
    private a idX;
    private SafeFrameLayout idY;
    private AlaLiveRoomBlurPageLayout idZ;
    private String ieA;
    private boolean ieB;
    private br ieC;
    private boolean ieD;
    private boolean ieE;
    private int ieF;
    private boolean ieH;
    private boolean ieI;
    private Runnable ieJ;
    private Runnable ieK;
    private Runnable ieL;
    private boolean ieM;
    private boolean ieN;
    private CustomMessageListener ieO;
    private CustomMessageListener ieP;
    private com.baidu.live.ai.c ieQ;
    private boolean ieR;
    private boolean ieS;
    private long ieT;
    private long ieU;
    private CustomMessageListener ieV;
    private com.baidu.live.v.a ieW;
    com.baidu.live.liveroom.a.c ieX;
    ViewPager.OnPageChangeListener ieY;
    HttpMessageListener ieZ;
    private AlaLoopViewPager iea;
    private AlaLoopViewPagerAdapter ieb;
    private com.baidu.tieba.ala.liveroom.e.a iec;
    private com.baidu.tieba.ala.liveroom.e.b ied;
    private SdkLivePlayer iee;
    private AlaLastLiveroomInfo ief;
    private boolean ieg;
    private boolean ieh;
    private boolean iei;
    private boolean iej;
    @Deprecated
    private boolean iek;
    private ArrayList<AlaBroadcastGiftToastData> iel;
    private String iem;
    private com.baidu.tieba.ala.endliveroom.a ien;
    private com.baidu.tieba.ala.liveroom.d.c ieo;
    private String iep;
    private long ieq;
    private JSONObject ier;
    private boolean ies;
    private com.baidu.tieba.ala.liveroom.task.c iet;
    private StayTimeBean ieu;
    private boolean iev;
    private com.baidu.tieba.ala.liveroom.k.a iew;
    private com.baidu.tieba.ala.liveroom.v.c iex;
    private boolean iey;
    private boolean iez;
    CustomMessageListener ifa;
    CustomMessageListener ifb;
    CustomMessageListener ifc;
    CustomMessageListener ifd;
    private CustomMessageListener ife;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void cql() {
        if (this.iex != null) {
            this.iex.bD(this.bkj);
        }
        if (this.iew != null) {
            this.iew.bD(this.bkj);
        }
        if (al.Ig() != null) {
            al.Ig().bD(this.bkj);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.DEBUG = false;
        this.mSelectedPosition = 1;
        this.ieg = true;
        this.hGS = 0L;
        this.ieh = false;
        this.bzP = true;
        this.bvZ = "";
        this.mForumName = "";
        this.iei = false;
        this.iek = false;
        this.iem = "0";
        this.mHandler = new Handler();
        this.ieq = -1L;
        this.otherParams = "";
        this.ies = false;
        this.iet = com.baidu.tieba.ala.liveroom.task.c.cns();
        this.iev = false;
        this.iez = false;
        this.ieB = false;
        this.ieE = false;
        this.ieF = 0;
        this.ieH = false;
        this.ieI = false;
        this.hKe = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.clS();
            }
        };
        this.ieJ = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.cqJ();
            }
        };
        this.ieK = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.hGu.cmo();
            }
        };
        this.ieL = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.htd = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ieM = true;
            }
        };
        this.ieO = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.ieN = true;
            }
        };
        this.ieP = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.ieV = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bkj = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.cql();
            }
        };
        this.bih = new CustomMessageListener(2501059) { // from class: com.baidu.tieba.ala.player.b.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_video_activity")) {
                    b.this.U(false, false);
                }
            }
        };
        this.bPR = new com.baidu.live.v.b() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.v.b
            public void dY(int i) {
                if (b.this.ieo != null) {
                    b.this.ieo.dY(i);
                }
            }
        };
        this.ieW = new com.baidu.live.v.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.v.a
            public void cG(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.iee != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.iee.isPlaying());
                        if (b.this.iee.isPlaying()) {
                            if (b.this.iee.isPaused()) {
                                b.this.iee.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.iee.isPlaying()) {
                        b.this.iee.pause();
                    }
                }
            }
        };
        this.ieX = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void cx(boolean z) {
                if (z || b.this.ieo == null || b.this.ieo.ceN()) {
                    if (!b.this.cqu() || b.this.a(true, (a.InterfaceC0644a) null)) {
                        b.this.ieI = true;
                        b.this.oZ(true);
                        b.this.cbN();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cy(boolean z) {
                b.this.e(b.this.aGe, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                String str2;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isStoped", b.this.iei);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (arrayList != null && arrayList.size() > 1) {
                    str2 = "one_to_two_start";
                } else {
                    str2 = "two_to_one_start";
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", str2).setContentExt(null, null, jSONObject));
                b.this.iee.cra();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.iei) {
                    if (b.this.iei) {
                        b.this.iee.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.iee.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.iea != null) {
                    b.this.iea.setIsScrollable(b.this.ieD && z);
                    b.this.iea.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cz(boolean z) {
                boolean z2 = true;
                if (!z || b.this.cqS()) {
                    if (b.this.idZ != null) {
                        b.this.idZ.cnY();
                        return;
                    }
                    return;
                }
                if (b.this.hGu.HR().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.idZ != null) {
                    b.this.idZ.oI(z2);
                }
            }
        };
        this.ieY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.iea != null && i == 0) {
                    b.this.cqF();
                    com.baidu.live.d.Ba().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.hHc = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.p.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.P(b.this.hGu.HR());
                } else if (i2 == 2) {
                    b.this.f(b.this.hGu.bWY());
                } else if (i2 == 3) {
                    b.this.br(i, str2);
                } else if (i2 == 4) {
                    b.this.aI(obj);
                } else if (i2 == 5) {
                    b.this.cqI();
                }
            }
        };
        this.ieZ = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.cnq() != null && b.this.mTbPageContext != null) {
                        b.this.iet.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.cnq());
                    }
                }
            }
        };
        this.ifa = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
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
        this.ifb = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.hGu != null && b.this.hGu.HR() != null && b.this.hGu.HR().mLiveInfo != null) {
                    long j = b.this.hGu.HR().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + "," + iArr[1] + "]");
                    if (b.this.ieQ != null) {
                        b.this.ieQ.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.ifc = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.hGu != null && b.this.hGu.HR() != null && b.this.hGu.HR().aKQ != null) {
                        if (l.longValue() == b.this.hGu.HR().aKQ.userId) {
                            b.this.hGu.HR().aKQ.isNewUser = false;
                            if (b.this.iew != null) {
                                b.this.iew.o(b.this.hGu.HR());
                            }
                        }
                    }
                }
            }
        };
        this.ifd = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.t.a)) {
                    com.baidu.tieba.ala.liveroom.t.a aVar2 = (com.baidu.tieba.ala.liveroom.t.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String EA = aVar2.EA();
                    if (b.this.mTbPageContext != null && b.this.hGu != null && b.this.hGu.HR() != null && b.this.hGu.HR().aKQ != null) {
                        if (valueOf.longValue() == b.this.hGu.HR().aKQ.userId && com.baidu.live.af.a.SE().bCb != null && com.baidu.live.af.a.SE().bCb.aRz != null && com.baidu.live.af.a.SE().bCb.aRz.Fi()) {
                            g.wU(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, EA));
                        }
                    }
                }
            }
        };
        this.ife = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.hKe != null) {
                    b.this.mHandler.removeCallbacks(b.this.hKe);
                }
                b.this.clS();
            }
        };
        this.hGS = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.idX = aVar;
        this.ieg = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ai.c.class);
        if (runTask != null) {
            this.ieQ = (com.baidu.live.ai.c) runTask.getData();
        }
        this.hGu = new com.baidu.tieba.ala.liveroom.p.d(getPageContext());
        this.hGu.a(this.hHc);
        this.hGu.IG(str);
        this.ien = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.ieZ);
        MessageManager.getInstance().registerListener(this.ifa);
        MessageManager.getInstance().registerListener(this.ifb);
        MessageManager.getInstance().registerListener(this.ifc);
        MessageManager.getInstance().registerListener(this.ifd);
        MessageManager.getInstance().registerListener(this.ife);
        MessageManager.getInstance().registerListener(this.ieV);
        MessageManager.getInstance().registerListener(this.htd);
        MessageManager.getInstance().registerListener(this.ieO);
        MessageManager.getInstance().registerListener(this.ieP);
        MessageManager.getInstance().registerListener(this.bih);
    }

    private void R(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.iel = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.iel.add(alaBroadcastGiftToastData);
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
        this.bvZ = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bvZ)) {
            this.bvZ = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        if (z) {
            this.iep = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.iep = intent.getStringExtra("room_id");
        }
        this.bvY = intent.getLongExtra("live_id", 0L);
        this.ies = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.hGu.b((AlaLiveInfoCoreData) serializableExtra);
            this.ies = true;
        }
        this.hGu.setIsMixLive(z);
        TbConfig.liveScene = 1;
        d(intent, z);
        this.ieD = this.ieC == null || !this.ieC.aRP;
        this.ien.setOtherParams(this.otherParams);
        oX(z);
        cqm();
        this.mHandler.removeCallbacks(this.ieL);
        this.mHandler.postDelayed(this.ieL, 1000L);
    }

    private void d(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.ieF = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hoR = null;
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
                this.ier = new JSONObject(stringExtra);
                if (this.ier != null) {
                    String ec = ec(this.ier);
                    String eb = eb(this.ier);
                    if ((!TextUtils.isEmpty(ec) && TextUtils.equals(this.iep, ec)) || (!TextUtils.isEmpty(eb) && TextUtils.equals(this.bvY + "", eb))) {
                        String ea = ea(this.ier);
                        if (!TextUtils.isEmpty(ea)) {
                            ea = URLDecoder.decode(ea, "UTF-8");
                        }
                        if (this.DEBUG) {
                            Log.i("LivePlayerActivity", "@@ coverUrl = " + ea);
                        }
                        String ed = ed(this.ier);
                        if (this.DEBUG) {
                            Log.i("LivePlayerActivity", "@@ liveUrl = " + ed);
                        }
                        if (!this.ies) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bvY;
                            alaLiveInfoCoreData.screenDirection = dZ(this.ier);
                            if (!TextUtils.isEmpty(ea)) {
                                alaLiveInfoCoreData.liveCover = ea;
                            }
                            a(ed, alaLiveInfoCoreData);
                            this.hGu.b(alaLiveInfoCoreData);
                            this.ies = true;
                        }
                    }
                    String optString2 = this.ier.optString("extra");
                    try {
                        this.ieT = Long.parseLong(this.iep);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.ieU = this.bvY;
                    if (TextUtils.isEmpty(optString2)) {
                        this.ieC = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString2);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString3 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString3) && this.hGu != null) {
                            this.hGu.Ia(optString3);
                        }
                        this.ieR = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.ieS = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hoR = jSONObject.optString("live_back_scheme");
                        this.ieC = new br();
                        this.ieC.aRP = jSONObject.optInt("is_hot") == 1;
                        if (this.ieC.aRP) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.ieF = AlaLiveSwitchData.isHotLive;
                        this.ieC.aRQ = jSONObject.optString("task_id");
                        this.ieC.aRO = !TextUtils.isEmpty(this.ieC.aRQ);
                        this.ieC.aRR = jSONObject.optInt("task_type");
                        this.ieC.aRS = jSONObject.optInt("task_im_count");
                        this.ieC.aRT = jSONObject.optLong("task_gift_total_price");
                        this.ieC.aRU = jSONObject.optLong("task_watch_time");
                        this.ieC.aRV = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.ier.put("from", optString);
                        }
                        String optString4 = jSONObject.optString("back_app_scheme");
                        String optString5 = jSONObject.optString("back_app_icon");
                        String optString6 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            this.ied = new com.baidu.tieba.ala.liveroom.e.b();
                            this.ied.setScheme(optString4);
                            this.ied.setImageUrl(optString5);
                            this.ied.setTitle(optString6);
                        }
                    }
                    this.iem = this.ier.optString("open_giftlist");
                    this.ier.remove("cover");
                    this.ier.remove("live_url");
                    this.ier.remove("enterRoomId");
                    this.ier.remove("enterLiveId");
                    this.ier.remove("open_giftlist");
                    this.ier.remove("extra");
                    this.otherParams = this.ier.toString();
                    if (this.hGu != null) {
                        this.hGu.setOtherParams(this.otherParams);
                    }
                    this.ier.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ier.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ier.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.ier.optString("source");
                    }
                    this.ieE = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.ier.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.hGu != null) {
                        this.hGu.xt(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.ief = new AlaLastLiveroomInfo();
                this.ief.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bvY), String.valueOf(this.iep), null, cqC(), this.idX != null ? this.idX.cqi() : false);
    }

    private int dZ(JSONObject jSONObject) {
        int i = 1;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("extra")) {
                    i = new JSONObject(jSONObject.optString("extra")).optInt("screen_direction", 1);
                } else {
                    i = jSONObject.optInt("screen_direction", 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.DEBUG) {
                Log.i("LivePlayerActivity", "@@ screenDirection = " + i);
            }
        }
        return i;
    }

    private String ea(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        String str = "";
        try {
            if (jSONObject.has("extra")) {
                str = new JSONObject(jSONObject.optString("extra")).optString("cover");
            } else {
                str = jSONObject.optString("cover");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.DEBUG) {
            Log.i("LivePlayerActivity", "@@ coverUrl = " + str);
            return str;
        }
        return str;
    }

    private String eb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "";
        }
        String str = "";
        try {
            if (jSONObject.has("extra")) {
                str = new JSONObject(jSONObject.optString("extra")).optString("enterLiveId");
            } else {
                str = jSONObject.optString("enterLiveId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.DEBUG) {
            Log.i("LivePlayerActivity", "@@ enterLiveId = " + str);
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
                str = new JSONObject(jSONObject.optString("extra")).optString("enterRoomId");
            } else {
                str = jSONObject.optString("enterRoomId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.DEBUG) {
            Log.i("LivePlayerActivity", "@@ enterRoomId = " + str);
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
                str = new JSONObject(jSONObject.optString("extra")).optString("live_url");
            } else {
                str = jSONObject.optString("live_url");
            }
            if (!TextUtils.isEmpty(str)) {
                str = URLDecoder.decode(str, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public void cqm() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.hGu.aw(this.uk, this.bvZ, this.mForumName);
        } else if (this.hGu.HR() != null && this.hGu.HR().mLiveInfo != null && this.hGu.HR().mLiveInfo.live_id > 0) {
            this.hGu.a(this.hGu.HR().mLiveInfo.live_id, false, this.bvZ, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bvZ = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                oZ(false);
                return;
            }
            this.hGu.aw(this.uk, this.bvZ, this.mForumName);
        } else if (!TextUtils.isEmpty(this.iep)) {
            this.hGu.IF(this.iep);
        } else if (this.bvY > 0) {
            this.hGu.a(this.bvY, false, this.bvZ, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            oZ(false);
        }
    }

    private void oX(boolean z) {
        this.bzP = true;
        this.ieh = false;
        oY(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        b(visibilityRegion);
        c(visibilityRegion);
        com.baidu.live.core.layer.b.En().l(this.hGO);
        this.ieo = new com.baidu.tieba.ala.liveroom.d.c();
        this.ieo.a(this.ieX);
        this.ieo.setOtherParams(this.otherParams);
        this.ieo.nH(this.ieE);
        this.ieo.a(this.idX.cqj());
        cqq();
        cqn();
        cqp();
        cqo();
    }

    private void oY(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_main_layout, (ViewGroup) null);
        this.idY = (SafeFrameLayout) inflate.findViewById(a.f.live_root_view);
        this.iea = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.iea.setOnPageChangeListener(this.ieY);
        this.iea.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void cjD() {
                b.this.cqF();
            }
        });
        this.iea.setBoundaryCaching(true);
        this.iea.setDetermineYRatio(1.0f);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.ieb = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.ieb.cjB();
        this.idZ = this.ieb.xa(this.mSelectedPosition);
        this.ieb.a(this.mSelectedPosition, this.hGu.HR());
        this.iea.setAdapter(this.ieb);
        this.iea.setCurrentItem(this.mSelectedPosition);
        this.iea.setIsScrollable(this.ieD);
        this.iea.setIsMixLive(z);
        this.hGN = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hGO = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
    }

    private void b(Rect rect) {
        this.iee = SdkLivePlayer.ge(getPageContext().getPageActivity());
        if (this.iee == null) {
            this.iea.setIsScrollable(false);
            if (this.hGu != null) {
                this.hGu.cancelLoadData();
            }
            cjF();
            return;
        }
        this.iee.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.c.sdk_transparent));
        this.iee.setIPlayerCallBack(this.bPR);
        this.iee.setIPlayerAudioFocusCallBack(this.ieW);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.idZ.a(this.iee, layoutParams, true);
    }

    private void cqn() {
        this.iec = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.hGN);
    }

    private void cqo() {
        CustomResponsedMessage runTask;
        if (this.hHt == null && (runTask = MessageManager.getInstance().runTask(2913266, com.baidu.live.w.b.class)) != null) {
            this.hHt = (com.baidu.live.w.b) runTask.getData();
        }
        if (this.hHt != null) {
            this.hHt.setParentView(this.hGN);
        }
    }

    private void cqp() {
        CustomResponsedMessage runTask;
        if (this.hHr == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.u.c.class)) != null) {
            this.hHr = (com.baidu.live.u.c) runTask.getData();
        }
        if (this.hHr != null) {
            this.hHr.setParentView(this.hGN);
        }
    }

    private void cjF() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.oZ(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void c(Rect rect) {
        this.hGM = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.ala_liveroom_player_layout, null);
        this.hGM.setSwipeClearEnable(true);
        this.hGM.hRu = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.idZ.a(this.hGM, layoutParams);
    }

    private void cqq() {
        if (this.hGu != null && this.hGu.HR() != null) {
            this.aGe = this.hGu.HR();
            if (this.aGe.mLiveInfo != null) {
                a(this.aGe.mLiveInfo, this.ies);
                if (this.aGe.mLiveInfo != null && this.aGe.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.iei);
                    }
                    if (!this.iei) {
                        this.iee.c(this.aGe.mLiveInfo);
                    } else {
                        this.iee.setPlayLiveInfo(this.aGe.mLiveInfo);
                    }
                    if (this.ieo != null) {
                        this.ieo.a(this.mTbPageContext, this.hGM, this.iee, this.idZ, this.hGu, this.bvZ, this.iek, this.hGS, this.iel, this.ieC, this.iea);
                        k(this.aGe.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean cqr() {
        boolean z;
        AlaLiveInfoData cmx;
        if (this.idX.cqi()) {
            return false;
        }
        if (this.hGu == null || (cmx = this.hGu.cmx()) == null || cmx.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !cmx.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.ieT + ", getPlayingRoomID:" + cqs() + ", mSchemeLiveId:" + this.ieU + ", getPlayingLiveID:" + cqt());
        }
        return z || cqv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cqs() {
        AlaLiveInfoData cmx;
        if (this.hGu == null || (cmx = this.hGu.cmx()) == null) {
            return 0L;
        }
        return cmx.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cqt() {
        AlaLiveInfoData cmx;
        if (this.hGu == null || (cmx = this.hGu.cmx()) == null) {
            return 0L;
        }
        return cmx.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqu() {
        boolean z = false;
        if (!this.idX.cqi()) {
            if (this.ieR && (this.ieT == cqs() || this.ieU == cqt())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean cqv() {
        boolean z = this.ieS && (this.ieT == cqs() || this.ieU == cqt());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean cqw() {
        if (ieG <= 0) {
            return false;
        }
        if (!(cqu() || cqr()) || FloatPermissionUtil.Pm()) {
            return false;
        }
        ieG--;
        FloatPermissionUtil.an(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0644a interfaceC0644a) {
        if (!FloatPermissionUtil.Pm()) {
            if (this.ieH) {
                return true;
            }
            this.ieH = true;
            if (z) {
                FloatPermissionUtil.an(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (cqu()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.ieS) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a fZ = com.baidu.tieba.ala.floating.b.fZ(getPageContext().getPageActivity());
        fZ.a(interfaceC0644a);
        fZ.dJ(jSONObject);
        com.baidu.tieba.ala.floating.b.fZ(getPageContext().getPageActivity()).a(this.iee, this.hGu.HR(), this.bvZ, this.hGS);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bYa() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bXV = com.baidu.tieba.ala.floating.b.bXV();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0644a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0644a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bXV == null || bXV.room_id == b.this.cqs() || bXV.live_id == b.this.cqt()) {
                    if (b.this.iee != null) {
                        b.this.cqx();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.iei);
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
    public void cqx() {
        ArrayList arrayList = (ArrayList) this.iee.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.iee.cqZ();
            this.iee.al(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bXY();
    }

    public void oV(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.iej = z;
    }

    private void cqy() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.ieD) {
                this.iea.setIsScrollable(true);
            } else {
                this.iea.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.En().onBackPressed() && ((this.ieo == null || !this.ieo.onKeyDown(i, keyEvent)) && (this.ieo == null || !this.ieo.ceM()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cqy();
            } else if ((this.ieo == null || this.ieo.ceN()) && (!cqu() || a(true, (a.InterfaceC0644a) null))) {
                this.ieI = true;
                oZ(true);
                cbN();
            }
        }
        return true;
    }

    public void cbN() {
        if (!TextUtils.isEmpty(this.hoR)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hoR);
                this.hoR = null;
            }
        }
    }

    public void oZ(boolean z) {
        U(z, false);
    }

    public void U(boolean z, boolean z2) {
        nN(!z);
        if (this.iee != null && !this.iee.isFloatingMode()) {
            this.iee.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.En().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cqA();
        long j = -1;
        if (this.hGu != null && this.hGu.cmx() != null) {
            j = this.hGu.cmx().room_id;
        }
        this.idX.b(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void nN(boolean z) {
        if (this.idX.cqi() && this.idX.cqj() != null) {
            this.idX.cqj().z("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.ief = null;
        if (al.Ig() != null) {
            al.Ig().If();
        }
        com.baidu.live.core.layer.b.En().Eo();
        if (this.ieQ != null) {
            this.ieQ.release();
        }
        if (this.iew != null) {
            this.iew.release();
        }
        this.ieC = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.hGu != null) {
            try {
                this.hGu.Ia(null);
                AlaLiveInfoData cmx = this.hGu.cmx();
                if (cmx != null) {
                    this.hGu.fD(cmx.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.iet.stopRecord();
        LiveTimerManager.getInstance().stop();
        cqz();
        if (this.iee != null && !this.iee.isFloatingMode()) {
            this.iee.cH(z);
        }
        if (this.ieo != null) {
            this.ieo.nN(z);
        }
        this.iev = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.OR().bsC != null && this.aGe != null) {
            com.baidu.live.liveroom.a.b.OR().bsC.b(this.aGe.mLiveInfo);
        }
        ac.hd("");
        com.baidu.live.gift.x.HH().release();
        if (this.hHr != null) {
            this.hHr.Id();
        }
        if (this.hHt != null) {
            this.hHt.Id();
        }
        if (this.idX != null && this.idX.cqi()) {
            ac.Ic();
        }
    }

    private void cqz() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cqA() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(x xVar) {
        if (xVar != null) {
            this.aGe = xVar;
            if (this.ieo != null) {
                this.ieo.a(xVar);
            }
            if (this.hHt != null && this.hGu.HR() != null) {
                this.hHt.b(this.hGu.HR(), this.otherParams);
            }
            cqw();
        }
    }

    private void c(r rVar) {
        if (this.ieo != null) {
            this.ieo.c(rVar);
        }
    }

    private void T(x xVar) {
        this.aGe = xVar;
        cqw();
    }

    private void cqB() {
        long j;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.ieD = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.ieD = true;
        }
        this.iea.setIsScrollable(this.ieD);
        this.ieF = AlaLiveSwitchData.isHotLive;
        if (this.aGe != null) {
            a(this.aGe.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.idZ.a(this.hGM, null);
            if (!isFloatingMode()) {
                a(this.idZ, this.aGe.mLiveInfo, this.bzP);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aGe.mLiveInfo.live_id), String.valueOf(this.aGe.mLiveInfo.room_id), String.valueOf(this.aGe.mLiveInfo.feed_id), cqC(), this.idX != null ? this.idX.cqi() : false);
            if (com.baidu.live.liveroom.a.b.OR().bsC != null) {
                com.baidu.live.liveroom.a.b.OR().bsC.a(this.aGe.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.bzP = false;
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                String str = "";
                String str2 = "";
                if (this.hGu != null && this.hGu.HR() != null && this.hGu.HR().mLiveInfo != null) {
                    j = this.hGu.HR().mLiveInfo.live_id;
                    str2 = this.hGu.HR().mLiveInfo.feed_id;
                    str = this.hGu.HR().mLiveInfo.room_id + "";
                } else {
                    if (this.bvY > 0) {
                        j2 = this.bvY;
                    }
                    if (TextUtils.isEmpty(this.iep)) {
                        j = j2;
                    } else {
                        str = this.iep;
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
                if (this.hGu != null && this.hGu.HR() != null && this.hGu.HR().mLiveInfo != null) {
                    str3 = this.hGu.HR().mLiveInfo.feed_id;
                    str4 = this.hGu.HR().mLiveInfo.live_id + "";
                    str5 = this.hGu.HR().mLiveInfo.room_id + "";
                    str6 = this.hGu.HR().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            cqw();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String cqC() {
        if (this.ier == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.ier.optString("source");
            String optString2 = this.ier.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.ier.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.ier.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.ier.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bYa();
        } else if (this.iee != null && this.iee.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.iee.getVideoPath();
                String d = com.baidu.live.v.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.iee.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.v.h.aI(videoPath, d)) {
                    this.iee.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.v.h.aH(videoPath, d)) {
                    this.iee.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.cD(this.iee)) {
                        ((ViewGroup) this.iee.getParent()).removeView(this.iee);
                        alaLiveRoomBlurPageLayout.a(this.iee, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.iei) {
                        this.iee.c(alaLiveInfoData);
                        return;
                    } else {
                        this.iee.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.iee.cqZ();
        } else if (this.iee != null && this.iee.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.iee, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.iei) {
                    this.iee.c(alaLiveInfoData);
                } else {
                    this.iee.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b2 = b(iArr, z, i, i2, i3);
        if (this.iee != null) {
            this.iee.setLayoutParams(b2);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.t(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.u(this.mTbPageContext.getPageActivity());
                int bs = p.bs(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = bs + i;
                } else {
                    dimensionPixelSize = bs + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
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

    public void cqD() {
        this.bzP = true;
    }

    public boolean cqE() {
        return this.bzP;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        a(UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()), alaLiveInfoData, z);
    }

    private void a(int i, AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (this.iee != null) {
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
            if (this.idZ != null) {
                this.idZ.setBackgroundColor(0);
            }
            int i3 = this.iee.getLayoutParams().width;
            int i4 = this.iee.getLayoutParams().height;
            int i5 = this.iee.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.iee.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b2 = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b2.width != i3 || b2.height != i4 || b2.topMargin != i5) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.hGM != null) {
                this.hGM.setLayoutParams(c);
            }
            if (this.idZ != null) {
                this.idZ.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ien != null) {
                this.ien.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.ieo != null) {
                this.ieo.l(c.width, c.height, realScreenOrientation);
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

    private void xS(int i) {
        boolean z = true;
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            if (this.idZ != null) {
                this.idZ.setBgImageUrl(this.aGe.mLiveInfo.cover, this.aGe.mLiveInfo);
            }
            this.ieb.a(this.mSelectedPosition, cqG(), this.aGe);
            this.ieb.b(this.mSelectedPosition, cqH(), this.aGe);
            if (this.idZ != null) {
                this.idZ.requestLayout();
                this.idZ.M(i, this.aGe.mLiveInfo.screen_direction == 2);
            }
        }
        if (this.aGe != null) {
            a(i, this.aGe.mLiveInfo, false);
        }
        boolean cnZ = this.idZ.cnZ();
        boolean z2 = i == 1;
        if (this.aGe == null || this.aGe.mLiveInfo == null || this.aGe.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!cqS()) {
            if (this.iee != null && this.iee.getParent() == null) {
                this.idZ.a(this.iee, null, false);
                if (this.aGe != null && this.aGe.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.iei) {
                        this.iee.c(this.aGe.mLiveInfo);
                    } else {
                        this.iee.setPlayLiveInfo(this.aGe.mLiveInfo);
                    }
                }
            }
            if (cnZ && !cqS() && this.ieo != null) {
                this.idZ.oI(z);
                return;
            }
            return;
        }
        this.idZ.cnV();
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
            this.hGu.a(alaLiveInfoData.live_id, true, this.bvZ, this.mForumName, this.ieF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqF() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.iea != null && this.hGM != null && this.mSelectedPosition != (currentItem = this.iea.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.h.sdk_neterror);
                this.iea.setCurrentItem(this.mSelectedPosition);
            } else if (!this.bzP && ListUtils.getCount(this.hGu.cmn()) <= 1) {
                this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                this.iea.setCurrentItem(this.mSelectedPosition);
                this.hGu.g(this.hGu.cmx());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.hGu.cms() && i < 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                    this.iea.setCurrentItem(this.mSelectedPosition);
                } else if (this.hGu.cmt() && i > 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                    this.iea.setCurrentItem(this.mSelectedPosition);
                    this.hGu.g(this.hGu.cmx());
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.hGu.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    nN(true);
                    this.idZ.cnV();
                    this.idZ.Zr();
                    this.idZ.cnW();
                    if (this.hGu.HR() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.hGu.HR().mLiveInfo.live_id + "", this.hGu.HR().mLiveInfo.room_id + "", this.hGu.HR().aKu.userId + "", this.hGu.HR().aKu.userName, System.currentTimeMillis(), this.hGu.HR().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.hGu.HR().mLiveInfo.live_id + "", this.hGu.HR().mLiveInfo.room_id + "", this.hGu.HR().aKu.userId + "", this.hGu.HR().aKu.userName, System.currentTimeMillis(), this.hGu.HR().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.ieu != null) {
                        long j = this.hGu.HR().mLiveInfo.live_id;
                        if (this.ieu.liveId == j && this.ieu.startTime > 0) {
                            this.ieu.endTime = System.currentTimeMillis();
                            long j2 = this.ieu.endTime - this.ieu.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.ieu.roomId + "", this.ieu.vid, j2 / 1000, this.otherParams);
                        }
                        this.ieu = null;
                    }
                    cqU();
                    if (this.ieQ != null) {
                        this.ieQ.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.idZ = this.ieb.xb(this.mSelectedPosition);
                    this.idZ.cnX();
                    xT(i);
                    cqw();
                }
            }
        }
    }

    public void xT(int i) {
        if (i < 0) {
            this.hGu.xu(this.hGu.cmu() - 1);
        } else if (i > 0) {
            this.hGu.xu(this.hGu.cmu() + 1);
        }
        if (this.ieo != null) {
            this.ieo.a(this.idZ);
        }
        this.ieb.a(this.mSelectedPosition, cqG(), this.aGe);
        this.ieb.b(this.mSelectedPosition, cqH(), this.aGe);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.hGu != null) {
            int cmu = this.hGu.cmu();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", cmu + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.hGu.cmn() != null && this.hGu.cmn().size() > cmu && this.hGu.cmn().get(cmu) != null) {
                AlaLiveInfoData alaLiveInfoData = this.hGu.cmn().get(cmu);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hGu != null) {
            AlaLiveInfoData cmx = this.hGu.cmx();
            com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(cmx.live_id)));
            if (cmx != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(cmx.live_id), String.valueOf(cmx.room_id), null, cqC(), this.idX != null ? this.idX.cqi() : false);
                l.c(this.hGu.cmu(), cmx.room_id, cmx.live_id);
                cmx.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bYa();
                }
                a(this.idZ, cmx, this.bzP);
                this.bzP = false;
                if (this.ieo != null) {
                    this.ieo.a(this.mTbPageContext, this.hGM, this.iee, this.idZ, this.hGu, this.bvZ, this.iek, this.hGS, null, this.ieC, this.iea);
                    short s = 2;
                    if (cmx.screen_direction == 2) {
                        s = 1;
                    }
                    k(s);
                }
                a(cmx, false);
            } else {
                l.iS("currentLiveInfo is null");
            }
            i(cmx);
            this.idZ.a(this.hGM, null);
            if (this.ieo != null) {
                this.ieo.ceK();
            }
            this.hGu.g(cmx);
        }
    }

    private AlaLiveInfoData cqG() {
        List<AlaLiveInfoData> cmn = this.hGu.cmn();
        if (cmn == null || cmn.size() == 0) {
            if (this.aGe == null) {
                return null;
            }
            return this.aGe.mLiveInfo;
        }
        int cmu = this.hGu.cmu();
        int size = cmn.size();
        return cmn.get(((cmu + size) - 1) % size);
    }

    private AlaLiveInfoData cqH() {
        List<AlaLiveInfoData> cmn = this.hGu.cmn();
        if (cmn == null || cmn.size() == 0) {
            if (this.aGe == null) {
                return null;
            }
            return this.aGe.mLiveInfo;
        }
        return cmn.get((this.hGu.cmu() + 1) % cmn.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(int i, String str) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        TbConfig.liveScene = 1;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.iei) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            oZ(false);
            return;
        }
        x HR = this.hGu.HR();
        T(HR);
        this.hGu.cmo();
        if (this.bzP) {
            this.hGu.oA(false);
        }
        this.hGS = System.currentTimeMillis() / 1000;
        if (this.ieo != null) {
            this.ieo.a(this.mTbPageContext, this.hGM, this.iee, this.idZ, this.hGu, this.bvZ, this.iek, this.hGS, this.iel, this.ieC, this.iea);
            short s = 2;
            if (HR.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            k(s);
        }
        if (this.idX.cqj() != null && this.idX.cqi()) {
            this.idX.cqj().z("load_finish", null);
            if (HR.mLiveInfo.screen_direction == 2) {
                this.idX.cqj().z("screen_auto_rotate", true);
            } else {
                this.idX.cqj().z("screen_auto_rotate", false);
            }
        }
        cqB();
        if (HR != null && HR.mLiveInfo != null && HR.mLiveInfo.live_status == 2) {
            this.ieb.a(this.mSelectedPosition, this.hGu.HR());
            e(HR, false);
            this.bzP = false;
            U(HR);
            return;
        }
        if (this.hHq == null && (runTask2 = MessageManager.getInstance().runTask(2913229, com.baidu.live.u.d.class)) != null) {
            this.hHq = (com.baidu.live.u.d) runTask2.getData();
        }
        if (this.hHq != null) {
            this.hHq.RC();
        }
        if (this.hHs == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.w.c.class)) != null) {
            this.hHs = (com.baidu.live.w.c) runTask.getData();
        }
        if (this.hHs != null) {
            this.hHs.RC();
        }
        boolean z = (this.ieo == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ah.a.b.Tq().cR(com.baidu.live.af.a.SE().bwi != null && com.baidu.live.af.a.SE().bwi.aPs && HR != null && HR.aLp);
        ac.e(HR);
        if (z) {
            if (!this.iez || !TextUtils.equals(q.XG(), this.ieA)) {
                ac.b(getPageContext(), false, this.idX != null && this.idX.cqi());
                e.ST().SU();
                this.iez = true;
                this.ieA = q.XG();
            }
            ac.hd("");
            ac.HY();
        }
        if (this.hGu.HR() != null && this.hGu.HR().mLiveInfo != null) {
            this.hGu.i(this.hGu.HR().mLiveInfo.live_id, !this.iev);
            this.iev = true;
        }
        if (this.ieo != null) {
            this.ieo.b(this.ief);
            this.ieo.nM(TextUtils.equals(this.iem, "1"));
            this.iem = "";
        }
        if (this.iec != null) {
            this.iec.a(this.aGe, this.ied);
        }
        a(this.hGu.HR());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.hGu.HR() != null && b.this.hGu.HR().mLiveInfo != null) {
                    b.this.hGu.a(b.this.hGu.HR().mLiveInfo.live_id, b.this.bvZ, b.this.hGS);
                }
            }
        });
        if (z && this.hGu.HR() != null && this.hGu.HR().aKu != null) {
            bq bqVar = com.baidu.live.af.a.SE().bCb;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bqVar != null && bqVar.aRE != null && bqVar.aRE.aUf) {
                m(true, this.hGu.HR().aKu.userId);
            }
        }
        this.bzP = false;
        if (z && this.hGu.HR() != null && this.hGu.HR().mLiveInfo != null && this.hGu.HR().aKu != null && this.ieo != null) {
            long j = this.hGu.HR().mLiveInfo.live_id;
            long j2 = this.hGu.HR().mLiveInfo.room_id;
            String str2 = this.hGu.HR().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.Ig() != null) {
                    al.Ig().bD(this.bkj);
                    if (!this.bkj) {
                        al.Ig().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.ieQ != null) {
                    this.ieQ.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.Lx() != null) {
                com.baidu.live.guardclub.e.Lx().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.iew == null) {
                this.iew = new com.baidu.tieba.ala.liveroom.k.a();
                this.iew.bD(this.bkj);
            }
            if (!this.bkj) {
                this.iew.a(this.mTbPageContext.getPageActivity(), this.hGu.HR(), this.otherParams);
            }
        }
        if (this.iex == null) {
            this.iex = new com.baidu.tieba.ala.liveroom.v.c(this.mTbPageContext);
            this.iex.bD(this.bkj);
        }
        if (z && this.hGu.HR() != null && this.hGu.HR().aKQ != null && !this.iey) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.iex.a(this.hGu.HR(), this.hGu.HR().aKQ.userId);
                this.iey = true;
            }
        }
        if (this.hGu.HR() != null && this.hGu.HR().mLiveInfo != null && this.hGu.HR().aKQ != null) {
            com.baidu.live.q.a.c(this.hGu.HR().mLiveInfo.live_id, this.hGu.HR().aKQ.needRename == 1);
            if (z) {
                com.baidu.live.q.a.c(this.hGu.HR().mLiveInfo.live_id, 0);
            }
        }
        if (this.hHr != null && this.hGu.HR() != null && this.hGu.HR().aKu != null) {
            this.hHr.bd(this.hGu.HR().aKu.userId);
        }
    }

    private void U(x xVar) {
        String str = "";
        if (!TextUtils.isEmpty(this.uk)) {
            str = "uk=" + this.uk;
        } else if (this.bvY > 0) {
            str = "live_id=" + this.bvY;
        } else if (!TextUtils.isEmpty(this.iep)) {
            str = "live_room_id=" + this.iep;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            str = "url=" + this.mUrl;
        }
        LogManager.getLiveCloseLogger().doEnterLiveCloseGuestLog(xVar.mLiveInfo.live_id + "", xVar.mLiveInfo.room_id + "", xVar.mLiveInfo.feed_id, str, this.otherParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqI() {
        if (this.ieg) {
            this.ieb.a(this.mSelectedPosition, cqG(), this.aGe);
            this.ieb.b(this.mSelectedPosition, cqH(), this.aGe);
            this.ieg = false;
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
        if (!this.iei) {
            this.mHandler.removeCallbacks(this.ieK);
            this.mHandler.postDelayed(this.ieK, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(r rVar) {
        if (rVar == null) {
            if (!this.iei) {
                this.mHandler.removeCallbacks(this.ieJ);
                this.mHandler.postDelayed(this.ieJ, 5000L);
                return;
            }
            return;
        }
        if (!this.ieh) {
            c(rVar);
        }
        if (!this.iei) {
            this.mHandler.removeCallbacks(this.ieJ);
            this.mHandler.postDelayed(this.ieJ, rVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqJ() {
        if (this.hGu.HR() != null && this.hGu.HR().mLiveInfo != null) {
            this.hGu.i(this.hGu.HR().mLiveInfo.live_id, !this.iev);
            this.iev = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.live_status == 2) {
            this.ieb.a(this.mSelectedPosition, this.hGu.HR());
            e(xVar, false);
        } else if (xVar != null) {
            if (!this.ieh) {
                ac.e(xVar);
                a(xVar);
            }
            if (!this.iei) {
                this.mHandler.removeCallbacks(this.hKe);
                this.mHandler.postDelayed(this.hKe, xVar.aKz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clS() {
        if (this.mTbPageContext != null && this.hGu.HR() != null && this.hGu.HR().mLiveInfo != null) {
            this.hGu.a(this.hGu.HR().mLiveInfo.live_id, this.bvZ, this.hGS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(x xVar, boolean z) {
        String str;
        nN(true);
        if (!cqS()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cmQ().oC(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.cmQ().release();
            this.hGu.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.idZ != null) {
                this.idZ.Zr();
                this.idZ.cnV();
                this.idZ.coa();
            }
            if (xVar == null || xVar.mLiveInfo == null) {
                str = null;
            } else {
                this.ieq = xVar.mLiveInfo.live_id;
                str = String.valueOf(xVar.mLiveInfo.room_id);
            }
            cqy();
            cqK();
            cqL();
            if (this.idX.cqi() && !StringUtils.isNull(str) && this.idX.cqj() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.idX.cqj().z("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (xVar != null) {
                View a2 = (this.ieo == null || this.ieo.ceQ() == null) ? null : this.ieo.ceQ().a(this.ieo.ceF().pageContext.getPageActivity(), xVar, z);
                if (this.idZ != null) {
                    this.ien.a(this.idZ, a2, xVar, z, this.hGu.cmp());
                }
                if (this.ieo != null) {
                    this.ieo.nN(false);
                    this.ieo.ceL();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.idZ != null) {
                    this.idZ.cnX();
                }
                long j = xVar.mLiveInfo.live_id;
                String str2 = xVar.mLiveInfo.feed_id;
                long j2 = xVar.aKu.userId;
                String str3 = xVar.aKu.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    QMStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", str + "", str2, this.otherParams);
                this.ieu = new StayTimeBean();
                this.ieu.liveId = xVar.mLiveInfo.live_id;
                this.ieu.roomId = xVar.mLiveInfo.room_id;
                this.ieu.vid = xVar.mLiveInfo.feed_id;
                this.ieu.startTime = System.currentTimeMillis();
            }
            cqU();
            if (this.iec != null) {
                this.iec.a(this.aGe, this.ied);
            }
        }
    }

    private void cqK() {
    }

    private void cqL() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.iea);
        }
    }

    public void cqM() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cqN();
        } else {
            cqO();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.hGu != null && this.hGu.HR() != null) {
            alaLiveInfoData = this.hGu.HR().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cqN();
        } else {
            cqO();
        }
        this.iea.setIsScrollable(!z && this.ieD);
        if (this.ieo != null) {
            this.ieo.onKeyboardVisibilityChanged(z);
        }
        if (this.hGM != null) {
            this.hGM.onKeyboardVisibilityChanged(z);
        }
    }

    public void dU(int i) {
        if (i == 0) {
            i = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        }
        if (isDebug()) {
            Log.d(TAG, "onScreenOrientationChanged: ");
        }
        if (i == 2) {
            cqN();
        } else {
            cqO();
        }
        this.hGM.dU(i);
        xS(i);
        if (al.Ig() != null) {
            al.Ig().Hp();
        }
        if (this.iew != null) {
            this.iew.Hp();
        }
        if (this.iec != null) {
            this.iec.dU(i);
        }
    }

    public void cqN() {
        if (this.iea != null) {
            i.ae(this.iea);
        }
    }

    public void cqO() {
        if (this.iea != null) {
            i.af(this.iea);
        }
    }

    private boolean cqP() {
        return this.ieM || this.ieN;
    }

    private void cqQ() {
        this.ieM = false;
        this.ieN = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.ieB + " mWebOver=" + this.iej + ", isFloatingMode=" + isFloatingMode());
        }
        cqQ();
        if (!this.iej || !isFloatingMode()) {
            bYa();
            if (this.hGu != null) {
                this.hGu.clZ();
                this.hGu.cmd();
            }
            if (this.ieo != null) {
                this.ieo.enterForeground();
            }
            if (this.iew != null) {
                this.iew.onResume();
            }
            if (this.iex != null) {
                this.iex.onResume();
            }
            com.baidu.live.core.layer.b.En().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.ieB + " mWebOver=" + this.iej + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        cqQ();
        if ((!this.iej || !isFloatingMode()) && !this.ieB) {
            bYa();
            if (this.iei) {
                this.iei = false;
                cqR();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            cqw();
        }
    }

    public void cqR() {
        clS();
        cqJ();
        this.hGu.cmo();
        if (!this.iee.isPlaying()) {
            cqx();
        } else if (this.iee.isPaused()) {
            this.iee.resume();
        }
        if (this.ieo != null) {
            this.ieo.ceP();
        }
        if (this.hGu != null && this.hGu.HR() != null && this.hGu.HR().mLiveInfo != null) {
            this.iet.fG(this.hGu.HR().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aGe.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.iej + ", isFloatingMode=" + isFloatingMode());
        }
        if (cqP() || !this.iej || !isFloatingMode()) {
            if (this.hGu != null) {
                this.hGu.cma();
                this.hGu.cme();
            }
            if (this.ieo != null) {
                this.ieo.enterBackground();
            }
            com.baidu.live.core.layer.b.En().onPause();
        }
    }

    public void V(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.ieI);
        }
        if (!cqP() && z && !this.ieI && cqr()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0644a() { // from class: com.baidu.tieba.ala.player.b.12
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0644a
                    public boolean a(SdkLivePlayer sdkLivePlayer) {
                        if (sdkLivePlayer != null) {
                            sdkLivePlayer.aUC();
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
        this.iei = true;
        pa(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void pa(boolean z) {
        this.mHandler.removeCallbacks(this.hKe);
        this.mHandler.removeCallbacks(this.ieJ);
        this.mHandler.removeCallbacks(this.ieK);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.iee.isFloatingMode()) {
                this.iee.aUC();
            }
        } else if (!z && !this.iee.isFloatingMode()) {
            this.iee.aUC();
        }
        if (this.ieo != null) {
            this.ieo.ceO();
        }
        this.iet.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.Ig() != null) {
                al.Ig().a(i, i2, intent, this.aGe, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.ieo != null) {
            this.ieo.onActivityResult(i, i2, intent);
        }
    }

    public boolean cqS() {
        return this.ien != null && this.ien.bXQ();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ieZ != null) {
            MessageManager.getInstance().unRegisterListener(this.ieZ);
        }
        if (this.ifa != null) {
            MessageManager.getInstance().unRegisterListener(this.ifa);
        }
        MessageManager.getInstance().unRegisterListener(this.ifb);
        MessageManager.getInstance().unRegisterListener(this.ifc);
        MessageManager.getInstance().unRegisterListener(this.ifd);
        MessageManager.getInstance().unRegisterListener(this.ife);
        MessageManager.getInstance().unRegisterListener(this.ieV);
        MessageManager.getInstance().unRegisterListener(this.htd);
        MessageManager.getInstance().unRegisterListener(this.ieO);
        MessageManager.getInstance().unRegisterListener(this.ieP);
        MessageManager.getInstance().unRegisterListener(this.bih);
        if (this.ieQ != null) {
            this.ieQ.release();
        }
        if (this.iee != null && !this.iee.isFloatingMode()) {
            this.iee.cH(true);
        }
        if (this.iec != null) {
            this.iec.onDestory();
        }
        if (this.hHr != null) {
            this.hHr.release();
            this.hHr = null;
        }
        if (this.hHt != null) {
            this.hHt.release();
            this.hHt = null;
        }
        if (this.ied != null) {
            this.ied.reset();
        }
        if (this.ieo != null) {
            this.ieo.onDestroy();
        }
        if (this.ieb != null) {
            this.ieb.onDestroy();
        }
        if (this.idZ != null) {
            this.idZ.Zr();
            this.idZ.release();
            this.idZ = null;
        }
        if (this.ien != null) {
            this.ien.onDestroy();
        }
        if (this.ieu != null && this.hGu != null && this.hGu.HR() != null) {
            long j = this.hGu.HR().mLiveInfo.live_id;
            if (this.ieu.liveId == j && this.ieu.startTime > 0) {
                this.ieu.endTime = System.currentTimeMillis();
                long j2 = this.ieu.endTime - this.ieu.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.ieu.roomId + "", this.ieu.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.ieu = null;
        }
        if (this.hGM != null) {
            this.hGM.cod();
            this.hGM = null;
        }
        if (this.hGu != null) {
            this.hGu.destory();
        }
        if (this.hHq != null) {
            this.hHq.release();
        }
        if (this.hHs != null) {
            this.hHs.release();
        }
        z.HJ().release();
        if (this.iex != null) {
            this.iex.release();
        }
        com.baidu.live.gift.x.HH().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String NL() {
        return this.otherParams;
    }

    public void pb(boolean z) {
        this.ieB = z;
    }

    public void cqT() {
        if (this.ier != null) {
            this.otherParams = this.ier.toString();
            if (this.hGu != null) {
                this.hGu.setOtherParams(this.otherParams);
            }
            if (this.ieo != null) {
                this.ieo.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.ien != null) {
                this.ien.setOtherParams(this.otherParams);
            }
        }
    }

    public void cqU() {
        if (this.ier != null) {
            String optString = this.ier.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.ier.put("tab", "live_jump");
                        this.ier.put("tag", "");
                        this.ier.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.ier.put("tab", "liveroom");
                        this.ier.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cqT();
            }
        }
    }

    private void m(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.Lv();
        }
        bVar.setAnchorId(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void cqV() {
        ac.Ib();
    }

    private void k(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.ieo.e(s);
        } else {
            this.ieo.f(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
