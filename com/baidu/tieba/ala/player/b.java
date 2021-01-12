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
/* loaded from: classes10.dex */
public class b extends BdBaseView<TbPageContext> {
    private static String TAG = "AlaLiveViewController";
    private static int hZV = 1;
    private static WeakReference<b> mRef;
    private boolean DEBUG;
    private x aBr;
    private com.baidu.live.v.b bLf;
    private CustomMessageListener bdo;
    private boolean bft;
    private long brk;
    private String brl;
    private boolean bvd;
    private com.baidu.tieba.ala.liveroom.p.d hBO;
    private com.baidu.live.u.d hCK;
    private com.baidu.live.u.c hCL;
    private com.baidu.live.w.c hCM;
    private com.baidu.live.w.b hCN;
    private AlaLiveView hCg;
    private ViewGroup hCh;
    private LayerRootView hCi;
    private long hCm;
    private d.a hCw;
    private Runnable hFy;
    private ArrayList<AlaBroadcastGiftToastData> hZA;
    private String hZB;
    private com.baidu.tieba.ala.endliveroom.a hZC;
    private com.baidu.tieba.ala.liveroom.d.c hZD;
    private String hZE;
    private long hZF;
    private JSONObject hZG;
    private boolean hZH;
    private com.baidu.tieba.ala.liveroom.task.c hZI;
    private StayTimeBean hZJ;
    private boolean hZK;
    private com.baidu.tieba.ala.liveroom.k.a hZL;
    private com.baidu.tieba.ala.liveroom.v.c hZM;
    private boolean hZN;
    private boolean hZO;
    private String hZP;
    private boolean hZQ;
    private br hZR;
    private boolean hZS;
    private boolean hZT;
    private int hZU;
    private boolean hZW;
    private boolean hZX;
    private Runnable hZY;
    private Runnable hZZ;
    private a hZm;
    private SafeFrameLayout hZn;
    private AlaLiveRoomBlurPageLayout hZo;
    private AlaLoopViewPager hZp;
    private AlaLoopViewPagerAdapter hZq;
    private com.baidu.tieba.ala.liveroom.e.a hZr;
    private com.baidu.tieba.ala.liveroom.e.b hZs;
    private SdkLivePlayer hZt;
    private AlaLastLiveroomInfo hZu;
    private boolean hZv;
    private boolean hZw;
    private boolean hZx;
    private boolean hZy;
    @Deprecated
    private boolean hZz;
    private String hkk;
    CustomMessageListener hox;
    private Runnable iaa;
    private boolean iab;
    private boolean iac;
    private CustomMessageListener iad;
    private CustomMessageListener iae;
    private com.baidu.live.ai.c iaf;
    private boolean iag;
    private boolean iah;
    private long iai;
    private long iaj;
    private CustomMessageListener iak;
    private com.baidu.live.v.a ial;
    com.baidu.live.liveroom.a.c iam;
    ViewPager.OnPageChangeListener ian;
    HttpMessageListener iao;
    CustomMessageListener iap;
    CustomMessageListener iaq;
    CustomMessageListener iar;
    CustomMessageListener ias;
    private CustomMessageListener iat;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void cmu() {
        if (this.hZM != null) {
            this.hZM.bz(this.bft);
        }
        if (this.hZL != null) {
            this.hZL.bz(this.bft);
        }
        if (al.El() != null) {
            al.El().bz(this.bft);
        }
    }

    public b(TbPageContext tbPageContext, a aVar, String str) {
        super(tbPageContext);
        this.DEBUG = false;
        this.mSelectedPosition = 1;
        this.hZv = true;
        this.hCm = 0L;
        this.hZw = false;
        this.bvd = true;
        this.brl = "";
        this.mForumName = "";
        this.hZx = false;
        this.hZz = false;
        this.hZB = "0";
        this.mHandler = new Handler();
        this.hZF = -1L;
        this.otherParams = "";
        this.hZH = false;
        this.hZI = com.baidu.tieba.ala.liveroom.task.c.cjB();
        this.hZK = false;
        this.hZO = false;
        this.hZQ = false;
        this.hZT = false;
        this.hZU = 0;
        this.hZW = false;
        this.hZX = false;
        this.hFy = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.cib();
            }
        };
        this.hZY = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.cmS();
            }
        };
        this.hZZ = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.hBO.cix();
            }
        };
        this.iaa = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.hox = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.iab = true;
            }
        };
        this.iad = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.iac = true;
            }
        };
        this.iae = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.iak = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bft = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.cmu();
            }
        };
        this.bdo = new CustomMessageListener(2501059) { // from class: com.baidu.tieba.ala.player.b.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "close_video_activity")) {
                    b.this.U(false, false);
                }
            }
        };
        this.bLf = new com.baidu.live.v.b() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.v.b
            public void cs(int i) {
                if (b.this.hZD != null) {
                    b.this.hZD.cs(i);
                }
            }
        };
        this.ial = new com.baidu.live.v.a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.live.v.a
            public void cC(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isYinbo() && b.this.hZt != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.hZt.isPlaying());
                        if (b.this.hZt.isPlaying()) {
                            if (b.this.hZt.isPaused()) {
                                b.this.hZt.resume();
                            }
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.hZt.isPlaying()) {
                        b.this.hZt.pause();
                    }
                }
            }
        };
        this.iam = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.live.liveroom.a.c
            public void ct(boolean z) {
                if (z || b.this.hZD == null || b.this.hZD.caW()) {
                    if (!b.this.cmD() || b.this.a(true, (a.InterfaceC0627a) null)) {
                        b.this.hZX = true;
                        b.this.oV(true);
                        b.this.bXW();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cu(boolean z) {
                b.this.e(b.this.aBr, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                String str2;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("isStoped", b.this.hZx);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (arrayList != null && arrayList.size() > 1) {
                    str2 = "one_to_two_start";
                } else {
                    str2 = "two_to_one_start";
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_SCREEN_CHANGE, "liveroom", str2).setContentExt(null, null, jSONObject));
                b.this.hZt.cnj();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.hZx) {
                    if (b.this.hZx) {
                        b.this.hZt.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.hZt.e(arrayList, true);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.hZp != null) {
                    b.this.hZp.setIsScrollable(b.this.hZS && z);
                    b.this.hZp.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void cv(boolean z) {
                boolean z2 = true;
                if (!z || b.this.cnb()) {
                    if (b.this.hZo != null) {
                        b.this.hZo.ckh();
                        return;
                    }
                    return;
                }
                if (b.this.hBO.DW().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.hZo != null) {
                    b.this.hZo.oE(z2);
                }
            }
        };
        this.ian = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (b.this.hZp != null && i == 0) {
                    b.this.cmO();
                    com.baidu.live.d.xf().putBoolean("ala_live_play_has_up_down_scrolled", true);
                }
            }
        };
        this.hCw = new d.a() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // com.baidu.tieba.ala.liveroom.p.d.a
            public void a(int i, String str2, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.P(b.this.hBO.DW());
                } else if (i2 == 2) {
                    b.this.f(b.this.hBO.bTh());
                } else if (i2 == 3) {
                    b.this.bs(i, str2);
                } else if (i2 == 4) {
                    b.this.aI(obj);
                } else if (i2 == 5) {
                    b.this.cmR();
                }
            }
        };
        this.iao = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.cjz() != null && b.this.mTbPageContext != null) {
                        b.this.hZI.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.cjz());
                    }
                }
            }
        };
        this.iap = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.14
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
        this.iaq = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.hBO != null && b.this.hBO.DW() != null && b.this.hBO.DW().mLiveInfo != null) {
                    long j = b.this.hBO.DW().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + "," + iArr[1] + "]");
                    if (b.this.iaf != null) {
                        b.this.iaf.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.iar = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.hBO != null && b.this.hBO.DW() != null && b.this.hBO.DW().aGd != null) {
                        if (l.longValue() == b.this.hBO.DW().aGd.userId) {
                            b.this.hBO.DW().aGd.isNewUser = false;
                            if (b.this.hZL != null) {
                                b.this.hZL.o(b.this.hBO.DW());
                            }
                        }
                    }
                }
            }
        };
        this.ias = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.t.a)) {
                    com.baidu.tieba.ala.liveroom.t.a aVar2 = (com.baidu.tieba.ala.liveroom.t.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String AF = aVar2.AF();
                    if (b.this.mTbPageContext != null && b.this.hBO != null && b.this.hBO.DW() != null && b.this.hBO.DW().aGd != null) {
                        if (valueOf.longValue() == b.this.hBO.DW().aGd.userId && com.baidu.live.af.a.OJ().bxp != null && com.baidu.live.af.a.OJ().bxp.aMM != null && com.baidu.live.af.a.OJ().bxp.aMM.Bn()) {
                            g.vo(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, AF));
                        }
                    }
                }
            }
        };
        this.iat = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.hFy != null) {
                    b.this.mHandler.removeCallbacks(b.this.hFy);
                }
                b.this.cib();
            }
        };
        this.hCm = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.hZm = aVar;
        this.hZv = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.ai.c.class);
        if (runTask != null) {
            this.iaf = (com.baidu.live.ai.c) runTask.getData();
        }
        this.hBO = new com.baidu.tieba.ala.liveroom.p.d(getPageContext());
        this.hBO.a(this.hCw);
        this.hBO.Hu(str);
        this.hZC = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.iao);
        MessageManager.getInstance().registerListener(this.iap);
        MessageManager.getInstance().registerListener(this.iaq);
        MessageManager.getInstance().registerListener(this.iar);
        MessageManager.getInstance().registerListener(this.ias);
        MessageManager.getInstance().registerListener(this.iat);
        MessageManager.getInstance().registerListener(this.iak);
        MessageManager.getInstance().registerListener(this.hox);
        MessageManager.getInstance().registerListener(this.iad);
        MessageManager.getInstance().registerListener(this.iae);
        MessageManager.getInstance().registerListener(this.bdo);
    }

    private void R(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("live_broadcast_gift_toast_queue");
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.hZA = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.hZA.add(alaBroadcastGiftToastData);
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
        this.brl = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.brl)) {
            this.brl = "live_sdk";
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        if (z) {
            this.hZE = intent.getStringExtra(AlaLiveRoomActivityConfig.MIX_ROOM_ID);
        } else {
            this.hZE = intent.getStringExtra("room_id");
        }
        this.brk = intent.getLongExtra("live_id", 0L);
        this.hZH = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.hBO.b((AlaLiveInfoCoreData) serializableExtra);
            this.hZH = true;
        }
        this.hBO.setIsMixLive(z);
        TbConfig.liveScene = 1;
        d(intent, z);
        this.hZS = this.hZR == null || !this.hZR.aNc;
        this.hZC.setOtherParams(this.otherParams);
        oT(z);
        cmv();
        this.mHandler.removeCallbacks(this.iaa);
        this.mHandler.postDelayed(this.iaa, 1000L);
    }

    private void d(Intent intent, boolean z) {
        String stringExtra;
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.hZU = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.hkk = null;
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
                this.hZG = new JSONObject(stringExtra);
                if (this.hZG != null) {
                    String ec = ec(this.hZG);
                    String eb = eb(this.hZG);
                    if ((!TextUtils.isEmpty(ec) && TextUtils.equals(this.hZE, ec)) || (!TextUtils.isEmpty(eb) && TextUtils.equals(this.brk + "", eb))) {
                        String ea = ea(this.hZG);
                        if (!TextUtils.isEmpty(ea)) {
                            ea = URLDecoder.decode(ea, "UTF-8");
                        }
                        if (this.DEBUG) {
                            Log.i("LivePlayerActivity", "@@ coverUrl = " + ea);
                        }
                        String ed = ed(this.hZG);
                        if (this.DEBUG) {
                            Log.i("LivePlayerActivity", "@@ liveUrl = " + ed);
                        }
                        if (!this.hZH) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.brk;
                            alaLiveInfoCoreData.screenDirection = dZ(this.hZG);
                            if (!TextUtils.isEmpty(ea)) {
                                alaLiveInfoCoreData.liveCover = ea;
                            }
                            a(ed, alaLiveInfoCoreData);
                            this.hBO.b(alaLiveInfoCoreData);
                            this.hZH = true;
                        }
                    }
                    String optString2 = this.hZG.optString("extra");
                    try {
                        this.iai = Long.parseLong(this.hZE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.iaj = this.brk;
                    if (TextUtils.isEmpty(optString2)) {
                        this.hZR = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString2);
                        BDxdConfig.getIns().setBdxd(jSONObject.optString(BDxdConfig.EXTRA_BDXD));
                        String optString3 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString3) && this.hBO != null) {
                            this.hBO.GO(optString3);
                        }
                        this.iag = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.iah = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.hkk = jSONObject.optString("live_back_scheme");
                        this.hZR = new br();
                        this.hZR.aNc = jSONObject.optInt("is_hot") == 1;
                        if (this.hZR.aNc) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.hZU = AlaLiveSwitchData.isHotLive;
                        this.hZR.aNd = jSONObject.optString("task_id");
                        this.hZR.aNb = !TextUtils.isEmpty(this.hZR.aNd);
                        this.hZR.aNe = jSONObject.optInt("task_type");
                        this.hZR.aNf = jSONObject.optInt("task_im_count");
                        this.hZR.aNg = jSONObject.optLong("task_gift_total_price");
                        this.hZR.aNh = jSONObject.optLong("task_watch_time");
                        this.hZR.aNi = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.hZG.put("from", optString);
                        }
                        String optString4 = jSONObject.optString("back_app_scheme");
                        String optString5 = jSONObject.optString("back_app_icon");
                        String optString6 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                            this.hZs = new com.baidu.tieba.ala.liveroom.e.b();
                            this.hZs.setScheme(optString4);
                            this.hZs.setImageUrl(optString5);
                            this.hZs.setTitle(optString6);
                        }
                    }
                    this.hZB = this.hZG.optString("open_giftlist");
                    this.hZG.remove("cover");
                    this.hZG.remove("live_url");
                    this.hZG.remove("enterRoomId");
                    this.hZG.remove("enterLiveId");
                    this.hZG.remove("open_giftlist");
                    this.hZG.remove("extra");
                    this.otherParams = this.hZG.toString();
                    if (this.hBO != null) {
                        this.hBO.setOtherParams(this.otherParams);
                    }
                    this.hZG.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hZG.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hZG.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.hZG.optString("source");
                    }
                    this.hZT = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.hZG.optInt("recommend_type");
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom("live_sdk");
                    }
                    if (this.hBO != null) {
                        this.hBO.vN(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra("last_live_info");
            if (!StringUtils.isNull(stringExtra2)) {
                this.hZu = new AlaLastLiveroomInfo();
                this.hZu.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.brk), String.valueOf(this.hZE), null, cmL(), this.hZm != null ? this.hZm.cmr() : false);
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

    public void cmv() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.hBO.av(this.uk, this.brl, this.mForumName);
        } else if (this.hBO.DW() != null && this.hBO.DW().mLiveInfo != null && this.hBO.DW().mLiveInfo.live_id > 0) {
            this.hBO.a(this.hBO.DW().mLiveInfo.live_id, false, this.brl, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.brl = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
                oV(false);
                return;
            }
            this.hBO.av(this.uk, this.brl, this.mForumName);
        } else if (!TextUtils.isEmpty(this.hZE)) {
            this.hBO.Ht(this.hZE);
        } else if (this.brk > 0) {
            this.hBO.a(this.brk, false, this.brl, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_entry_live_failed));
            oV(false);
        }
    }

    private void oT(boolean z) {
        this.bvd = true;
        this.hZw = false;
        oU(z);
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        b(visibilityRegion);
        c(visibilityRegion);
        com.baidu.live.core.layer.b.As().l(this.hCi);
        this.hZD = new com.baidu.tieba.ala.liveroom.d.c();
        this.hZD.a(this.iam);
        this.hZD.setOtherParams(this.otherParams);
        this.hZD.nD(this.hZT);
        this.hZD.a(this.hZm.cms());
        cmz();
        cmw();
        cmy();
        cmx();
    }

    private void oU(boolean z) {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_main_layout, (ViewGroup) null);
        this.hZn = (SafeFrameLayout) inflate.findViewById(a.f.live_root_view);
        this.hZp = (AlaLoopViewPager) inflate.findViewById(a.f.ala_loop_view_pager);
        this.hZp.setOnPageChangeListener(this.ian);
        this.hZp.setCallback(new AlaVerticalViewPagerNew.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.livepager.AlaVerticalViewPagerNew.a
            public void cfM() {
                b.this.cmO();
            }
        });
        this.hZp.setBoundaryCaching(true);
        this.hZp.setDetermineYRatio(1.0f);
        if (!z) {
            this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        }
        this.hZq = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.hZq.cfK();
        this.hZo = this.hZq.vu(this.mSelectedPosition);
        this.hZq.a(this.mSelectedPosition, this.hBO.DW());
        this.hZp.setAdapter(this.hZq);
        this.hZp.setCurrentItem(this.mSelectedPosition);
        this.hZp.setIsScrollable(this.hZS);
        this.hZp.setIsMixLive(z);
        this.hCh = (ViewGroup) inflate.findViewById(a.f.func_view);
        this.hCi = (LayerRootView) inflate.findViewById(a.f.layer_root_view);
    }

    private void b(Rect rect) {
        this.hZt = SdkLivePlayer.gb(getPageContext().getPageActivity());
        if (this.hZt == null) {
            this.hZp.setIsScrollable(false);
            if (this.hBO != null) {
                this.hBO.cancelLoadData();
            }
            cfO();
            return;
        }
        this.hZt.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.c.sdk_transparent));
        this.hZt.setIPlayerCallBack(this.bLf);
        this.hZt.setIPlayerAudioFocusCallBack(this.ial);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hZo.a(this.hZt, layoutParams, true);
    }

    private void cmw() {
        this.hZr = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.hCh);
    }

    private void cmx() {
        CustomResponsedMessage runTask;
        if (this.hCN == null && (runTask = MessageManager.getInstance().runTask(2913266, com.baidu.live.w.b.class)) != null) {
            this.hCN = (com.baidu.live.w.b) runTask.getData();
        }
        if (this.hCN != null) {
            this.hCN.setParentView(this.hCh);
        }
    }

    private void cmy() {
        CustomResponsedMessage runTask;
        if (this.hCL == null && (runTask = MessageManager.getInstance().runTask(2913230, com.baidu.live.u.c.class)) != null) {
            this.hCL = (com.baidu.live.u.c) runTask.getData();
        }
        if (this.hCL != null) {
            this.hCL.setParentView(this.hCh);
        }
    }

    private void cfO() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.oV(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void c(Rect rect) {
        this.hCg = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.g.ala_liveroom_player_layout, null);
        this.hCg.setSwipeClearEnable(true);
        this.hCg.hMO = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.hZo.a(this.hCg, layoutParams);
    }

    private void cmz() {
        if (this.hBO != null && this.hBO.DW() != null) {
            this.aBr = this.hBO.DW();
            if (this.aBr.mLiveInfo != null) {
                a(this.aBr.mLiveInfo, this.hZH);
                if (this.aBr.mLiveInfo != null && this.aBr.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.hZx);
                    }
                    if (!this.hZx) {
                        this.hZt.c(this.aBr.mLiveInfo);
                    } else {
                        this.hZt.setPlayLiveInfo(this.aBr.mLiveInfo);
                    }
                    if (this.hZD != null) {
                        this.hZD.a(this.mTbPageContext, this.hCg, this.hZt, this.hZo, this.hBO, this.brl, this.hZz, this.hCm, this.hZA, this.hZR, this.hZp);
                        k(this.aBr.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean cmA() {
        boolean z;
        AlaLiveInfoData ciG;
        if (this.hZm.cmr()) {
            return false;
        }
        if (this.hBO == null || (ciG = this.hBO.ciG()) == null || ciG.mAlaLiveSwitchData == null) {
            z = false;
        } else {
            z = !ciG.mAlaLiveSwitchData.isSmallWindowPendantUnabled();
        }
        if (isDebug()) {
            Log.d(TAG, "isLiveFloatable " + z + ", mSchemeRoomId:" + this.iai + ", getPlayingRoomID:" + cmB() + ", mSchemeLiveId:" + this.iaj + ", getPlayingLiveID:" + cmC());
        }
        return z || cmE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cmB() {
        AlaLiveInfoData ciG;
        if (this.hBO == null || (ciG = this.hBO.ciG()) == null) {
            return 0L;
        }
        return ciG.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cmC() {
        AlaLiveInfoData ciG;
        if (this.hBO == null || (ciG = this.hBO.ciG()) == null) {
            return 0L;
        }
        return ciG.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cmD() {
        boolean z = false;
        if (!this.hZm.cmr()) {
            if (this.iag && (this.iai == cmB() || this.iaj == cmC())) {
                z = true;
            }
            Log.d(TAG, "isCloseToFloatable " + z);
        }
        return z;
    }

    private boolean cmE() {
        boolean z = this.iah && (this.iai == cmB() || this.iaj == cmC());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    private boolean cmF() {
        if (hZV <= 0) {
            return false;
        }
        if (!(cmD() || cmA()) || FloatPermissionUtil.Lr()) {
            return false;
        }
        hZV--;
        FloatPermissionUtil.an(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0627a interfaceC0627a) {
        if (!FloatPermissionUtil.Lr()) {
            if (this.hZW) {
                return true;
            }
            this.hZW = true;
            if (z) {
                FloatPermissionUtil.an(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (cmD()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.iah) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a fX = com.baidu.tieba.ala.floating.b.fX(getPageContext().getPageActivity());
        fX.a(interfaceC0627a);
        fX.dJ(jSONObject);
        com.baidu.tieba.ala.floating.b.fX(getPageContext().getPageActivity()).a(this.hZt, this.hBO.DW(), this.brl, this.hCm);
        if (h.isDebug()) {
            Log.d(TAG, "switchToFloating");
        }
        return true;
    }

    private void bUj() {
        if (h.isDebug()) {
            Log.d(TAG, "dismissFloating" + this);
        }
        final AlaLiveInfoData bUe = com.baidu.tieba.ala.floating.b.bUe();
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0627a() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0627a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.isDebug()) {
                    Log.d(b.TAG, "onClosePlayer back");
                }
                if (bUe == null || bUe.room_id == b.this.cmB() || bUe.live_id == b.this.cmC()) {
                    if (b.this.hZt != null) {
                        b.this.cmG();
                        if (b.this.isDebug()) {
                            Log.d(b.TAG, "onClosePlayer back isStop:" + b.this.hZx);
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
    public void cmG() {
        ArrayList arrayList = (ArrayList) this.hZt.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.hZt.cni();
            this.hZt.ag(arrayList2);
        }
    }

    public boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bUh();
    }

    public void oR(boolean z) {
        if (h.isDebug()) {
            Log.d(TAG, "setPlay= " + z);
        }
        this.hZy = z;
    }

    private void cmH() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.hZS) {
                this.hZp.setIsScrollable(true);
            } else {
                this.hZp.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.As().onBackPressed() && ((this.hZD == null || !this.hZD.onKeyDown(i, keyEvent)) && (this.hZD == null || !this.hZD.caV()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                cmH();
            } else if ((this.hZD == null || this.hZD.caW()) && (!cmD() || a(true, (a.InterfaceC0627a) null))) {
                this.hZX = true;
                oV(true);
                bXW();
            }
        }
        return true;
    }

    public void bXW() {
        if (!TextUtils.isEmpty(this.hkk)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hkk);
                this.hkk = null;
            }
        }
    }

    public void oV(boolean z) {
        U(z, false);
    }

    public void U(boolean z, boolean z2) {
        nJ(!z);
        if (this.hZt != null && !this.hZt.isFloatingMode()) {
            this.hZt.destroy();
        }
        BDxdConfig.getIns().clearConfig();
        com.baidu.live.core.layer.b.As().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        cmJ();
        long j = -1;
        if (this.hBO != null && this.hBO.ciG() != null) {
            j = this.hBO.ciG().room_id;
        }
        this.hZm.b(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void nJ(boolean z) {
        if (this.hZm.cmr() && this.hZm.cms() != null) {
            this.hZm.cms().z("screen_auto_rotate", false);
        }
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.hZu = null;
        if (al.El() != null) {
            al.El().Ek();
        }
        com.baidu.live.core.layer.b.As().At();
        if (this.iaf != null) {
            this.iaf.release();
        }
        if (this.hZL != null) {
            this.hZL.release();
        }
        this.hZR = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.hBO != null) {
            try {
                this.hBO.GO(null);
                AlaLiveInfoData ciG = this.hBO.ciG();
                if (ciG != null) {
                    this.hBO.fD(ciG.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.hZI.stopRecord();
        LiveTimerManager.getInstance().stop();
        cmI();
        if (this.hZt != null && !this.hZt.isFloatingMode()) {
            this.hZt.cD(z);
        }
        if (this.hZD != null) {
            this.hZD.nJ(z);
        }
        this.hZK = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.KW().bnQ != null && this.aBr != null) {
            com.baidu.live.liveroom.a.b.KW().bnQ.b(this.aBr.mLiveInfo);
        }
        ac.fR("");
        com.baidu.live.gift.x.DM().release();
        if (this.hCL != null) {
            this.hCL.Ei();
        }
        if (this.hCN != null) {
            this.hCN.Ei();
        }
        if (this.hZm != null && this.hZm.cmr()) {
            ac.Eh();
        }
    }

    private void cmI() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void cmJ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(x xVar) {
        if (xVar != null) {
            this.aBr = xVar;
            if (this.hZD != null) {
                this.hZD.a(xVar);
            }
            if (this.hCN != null && this.hBO.DW() != null) {
                this.hCN.b(this.hBO.DW(), this.otherParams);
            }
            cmF();
        }
    }

    private void c(r rVar) {
        if (this.hZD != null) {
            this.hZD.c(rVar);
        }
    }

    private void T(x xVar) {
        this.aBr = xVar;
        cmF();
    }

    private void cmK() {
        long j;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.hZS = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.hZS = true;
        }
        this.hZp.setIsScrollable(this.hZS);
        this.hZU = AlaLiveSwitchData.isHotLive;
        if (this.aBr != null) {
            a(this.aBr.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.hZo.a(this.hCg, null);
            if (!isFloatingMode()) {
                a(this.hZo, this.aBr.mLiveInfo, this.bvd);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aBr.mLiveInfo.live_id), String.valueOf(this.aBr.mLiveInfo.room_id), String.valueOf(this.aBr.mLiveInfo.feed_id), cmL(), this.hZm != null ? this.hZm.cmr() : false);
            if (com.baidu.live.liveroom.a.b.KW().bnQ != null) {
                com.baidu.live.liveroom.a.b.KW().bnQ.a(this.aBr.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.bvd = false;
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                String str = "";
                String str2 = "";
                if (this.hBO != null && this.hBO.DW() != null && this.hBO.DW().mLiveInfo != null) {
                    j = this.hBO.DW().mLiveInfo.live_id;
                    str2 = this.hBO.DW().mLiveInfo.feed_id;
                    str = this.hBO.DW().mLiveInfo.room_id + "";
                } else {
                    if (this.brk > 0) {
                        j2 = this.brk;
                    }
                    if (TextUtils.isEmpty(this.hZE)) {
                        j = j2;
                    } else {
                        str = this.hZE;
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
                if (this.hBO != null && this.hBO.DW() != null && this.hBO.DW().mLiveInfo != null) {
                    str3 = this.hBO.DW().mLiveInfo.feed_id;
                    str4 = this.hBO.DW().mLiveInfo.live_id + "";
                    str5 = this.hBO.DW().mLiveInfo.room_id + "";
                    str6 = this.hBO.DW().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            cmF();
            TbadkCoreApplication.getInst().setIsYuyinRoom(false);
        }
    }

    private String cmL() {
        if (this.hZG == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.hZG.optString("source");
            String optString2 = this.hZG.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.hZG.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.hZG.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.hZG.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bUj();
        } else if (this.hZt != null && this.hZt.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.hZt.getVideoPath();
                String d = com.baidu.live.v.h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.hZt.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (com.baidu.live.v.h.aH(videoPath, d)) {
                    this.hZt.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.v.h.aG(videoPath, d)) {
                    this.hZt.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.cD(this.hZt)) {
                        ((ViewGroup) this.hZt.getParent()).removeView(this.hZt);
                        alaLiveRoomBlurPageLayout.a(this.hZt, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.hZx) {
                        this.hZt.c(alaLiveInfoData);
                        return;
                    } else {
                        this.hZt.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.hZt.cni();
        } else if (this.hZt != null && this.hZt.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.hZt, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.hZx) {
                    this.hZt.c(alaLiveInfoData);
                } else {
                    this.hZt.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b2 = b(iArr, z, i, i2, i3);
        if (this.hZt != null) {
            this.hZt.setLayoutParams(b2);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.t(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.u(this.mTbPageContext.getPageActivity());
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

    public void cmM() {
        this.bvd = true;
    }

    public boolean cmN() {
        return this.bvd;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        a(UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()), alaLiveInfoData, z);
    }

    private void a(int i, AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (this.hZt != null) {
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
            if (this.hZo != null) {
                this.hZo.setBackgroundColor(0);
            }
            int i3 = this.hZt.getLayoutParams().width;
            int i4 = this.hZt.getLayoutParams().height;
            int i5 = this.hZt.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.hZt.getLayoutParams()).topMargin : 0;
            FrameLayout.LayoutParams b2 = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (b2.width != i3 || b2.height != i4 || b2.topMargin != i5) {
                a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            }
            FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
            if (this.hCg != null) {
                this.hCg.setLayoutParams(c);
            }
            if (this.hZo != null) {
                this.hZo.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.hZC != null) {
                this.hZC.C(screenFullSize[0], screenFullSize[1]);
            }
            if (this.hZD != null) {
                this.hZD.l(c.width, c.height, realScreenOrientation);
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

    private void wm(int i) {
        boolean z = true;
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            if (this.hZo != null) {
                this.hZo.setBgImageUrl(this.aBr.mLiveInfo.cover, this.aBr.mLiveInfo);
            }
            this.hZq.a(this.mSelectedPosition, cmP(), this.aBr);
            this.hZq.b(this.mSelectedPosition, cmQ(), this.aBr);
            if (this.hZo != null) {
                this.hZo.requestLayout();
                this.hZo.M(i, this.aBr.mLiveInfo.screen_direction == 2);
            }
        }
        if (this.aBr != null) {
            a(i, this.aBr.mLiveInfo, false);
        }
        boolean cki = this.hZo.cki();
        boolean z2 = i == 1;
        if (this.aBr == null || this.aBr.mLiveInfo == null || this.aBr.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!cnb()) {
            if (this.hZt != null && this.hZt.getParent() == null) {
                this.hZo.a(this.hZt, null, false);
                if (this.aBr != null && this.aBr.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.hZx) {
                        this.hZt.c(this.aBr.mLiveInfo);
                    } else {
                        this.hZt.setPlayLiveInfo(this.aBr.mLiveInfo);
                    }
                }
            }
            if (cki && !cnb() && this.hZD != null) {
                this.hZo.oE(z);
                return;
            }
            return;
        }
        this.hZo.cke();
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
            this.hBO.a(alaLiveInfoData.live_id, true, this.brl, this.mForumName, this.hZU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmO() {
        int currentItem;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && !this.mTbPageContext.getPageActivity().isFinishing() && this.hZp != null && this.hCg != null && this.mSelectedPosition != (currentItem = this.hZp.getCurrentItem())) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                this.mTbPageContext.showToast(a.h.sdk_neterror);
                this.hZp.setCurrentItem(this.mSelectedPosition);
            } else if (!this.bvd && ListUtils.getCount(this.hBO.ciw()) <= 1) {
                this.mTbPageContext.showToast(a.h.ala_live_room_no_more_list);
                this.hZp.setCurrentItem(this.mSelectedPosition);
                this.hBO.g(this.hBO.ciG());
            } else {
                int i = (currentItem - this.mSelectedPosition == 2 || currentItem - this.mSelectedPosition == -1) ? -1 : 1;
                if (this.hBO.ciB() && i < 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_pre_liveroom_tip);
                    this.hZp.setCurrentItem(this.mSelectedPosition);
                } else if (this.hBO.ciC() && i > 0) {
                    this.mTbPageContext.showToast(a.h.ala_live_no_next_liveroom_tip);
                    this.hZp.setCurrentItem(this.mSelectedPosition);
                    this.hBO.g(this.hBO.ciG());
                } else {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChanged");
                    }
                    this.hBO.cancelLoadData();
                    this.mHandler.removeCallbacksAndMessages(null);
                    nJ(true);
                    this.hZo.cke();
                    this.hZo.Vz();
                    this.hZo.ckf();
                    if (this.hBO.DW() != null) {
                        if (TbadkCoreApplication.getInst().isHaokan()) {
                            HKStaticManager.staticEndPlayTime(this.hBO.DW().mLiveInfo.live_id + "", this.hBO.DW().mLiveInfo.room_id + "", this.hBO.DW().aFH.userId + "", this.hBO.DW().aFH.userName, System.currentTimeMillis(), this.hBO.DW().mLiveInfo.feed_id, this.otherParams);
                        } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            QMStaticManager.staticEndPlayTime(this.hBO.DW().mLiveInfo.live_id + "", this.hBO.DW().mLiveInfo.room_id + "", this.hBO.DW().aFH.userId + "", this.hBO.DW().aFH.userName, System.currentTimeMillis(), this.hBO.DW().mLiveInfo.feed_id, this.otherParams);
                        }
                    }
                    if (this.hZJ != null) {
                        long j = this.hBO.DW().mLiveInfo.live_id;
                        if (this.hZJ.liveId == j && this.hZJ.startTime > 0) {
                            this.hZJ.endTime = System.currentTimeMillis();
                            long j2 = this.hZJ.endTime - this.hZJ.startTime;
                            if (j2 < 0) {
                                j2 = 0;
                            }
                            LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hZJ.roomId + "", this.hZJ.vid, j2 / 1000, this.otherParams);
                        }
                        this.hZJ = null;
                    }
                    cnd();
                    if (this.iaf != null) {
                        this.iaf.release();
                    }
                    this.mSelectedPosition = currentItem;
                    this.hZo = this.hZq.vv(this.mSelectedPosition);
                    this.hZo.ckg();
                    wn(i);
                    cmF();
                }
            }
        }
    }

    public void wn(int i) {
        if (i < 0) {
            this.hBO.vO(this.hBO.ciD() - 1);
        } else if (i > 0) {
            this.hBO.vO(this.hBO.ciD() + 1);
        }
        if (this.hZD != null) {
            this.hZD.a(this.hZo);
        }
        this.hZq.a(this.mSelectedPosition, cmP(), this.aBr);
        this.hZq.b(this.mSelectedPosition, cmQ(), this.aBr);
        if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && this.hBO != null) {
            int ciD = this.hBO.ciD();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", ciD + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.hBO.ciw() != null && this.hBO.ciw().size() > ciD && this.hBO.ciw().get(ciD) != null) {
                AlaLiveInfoData alaLiveInfoData = this.hBO.ciw().get(ciD);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hBO != null) {
            AlaLiveInfoData ciG = this.hBO.ciG();
            com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(ciG.live_id)));
            if (ciG != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(ciG.live_id), String.valueOf(ciG.room_id), null, cmL(), this.hZm != null ? this.hZm.cmr() : false);
                l.c(this.hBO.ciD(), ciG.room_id, ciG.live_id);
                ciG.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                if (isFloatingMode()) {
                    bUj();
                }
                a(this.hZo, ciG, this.bvd);
                this.bvd = false;
                if (this.hZD != null) {
                    this.hZD.a(this.mTbPageContext, this.hCg, this.hZt, this.hZo, this.hBO, this.brl, this.hZz, this.hCm, null, this.hZR, this.hZp);
                    short s = 2;
                    if (ciG.screen_direction == 2) {
                        s = 1;
                    }
                    k(s);
                }
                a(ciG, false);
            } else {
                l.hH("currentLiveInfo is null");
            }
            i(ciG);
            this.hZo.a(this.hCg, null);
            if (this.hZD != null) {
                this.hZD.caT();
            }
            this.hBO.g(ciG);
        }
    }

    private AlaLiveInfoData cmP() {
        List<AlaLiveInfoData> ciw = this.hBO.ciw();
        if (ciw == null || ciw.size() == 0) {
            if (this.aBr == null) {
                return null;
            }
            return this.aBr.mLiveInfo;
        }
        int ciD = this.hBO.ciD();
        int size = ciw.size();
        return ciw.get(((ciD + size) - 1) % size);
    }

    private AlaLiveInfoData cmQ() {
        List<AlaLiveInfoData> ciw = this.hBO.ciw();
        if (ciw == null || ciw.size() == 0) {
            if (this.aBr == null) {
                return null;
            }
            return this.aBr.mLiveInfo;
        }
        return ciw.get((this.hBO.ciD() + 1) % ciw.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(int i, String str) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        TbConfig.liveScene = 1;
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.hZx) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.h.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            oV(false);
            return;
        }
        x DW = this.hBO.DW();
        T(DW);
        this.hBO.cix();
        if (this.bvd) {
            this.hBO.ow(false);
        }
        this.hCm = System.currentTimeMillis() / 1000;
        if (this.hZD != null) {
            this.hZD.a(this.mTbPageContext, this.hCg, this.hZt, this.hZo, this.hBO, this.brl, this.hZz, this.hCm, this.hZA, this.hZR, this.hZp);
            short s = 2;
            if (DW.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            k(s);
        }
        if (this.hZm.cms() != null && this.hZm.cmr()) {
            this.hZm.cms().z("load_finish", null);
            if (DW.mLiveInfo.screen_direction == 2) {
                this.hZm.cms().z("screen_auto_rotate", true);
            } else {
                this.hZm.cms().z("screen_auto_rotate", false);
            }
        }
        cmK();
        if (DW != null && DW.mLiveInfo != null && DW.mLiveInfo.live_status == 2) {
            this.hZq.a(this.mSelectedPosition, this.hBO.DW());
            e(DW, false);
            this.bvd = false;
            U(DW);
            return;
        }
        if (this.hCK == null && (runTask2 = MessageManager.getInstance().runTask(2913229, com.baidu.live.u.d.class)) != null) {
            this.hCK = (com.baidu.live.u.d) runTask2.getData();
        }
        if (this.hCK != null) {
            this.hCK.NH();
        }
        if (this.hCM == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.w.c.class)) != null) {
            this.hCM = (com.baidu.live.w.c) runTask.getData();
        }
        if (this.hCM != null) {
            this.hCM.NH();
        }
        boolean z = (this.hZD == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        com.baidu.live.ah.a.b.Pv().cN(com.baidu.live.af.a.OJ().bru != null && com.baidu.live.af.a.OJ().bru.aKF && DW != null && DW.aGC);
        ac.e(DW);
        if (z) {
            if (!this.hZO || !TextUtils.equals(q.TO(), this.hZP)) {
                ac.b(getPageContext(), false, this.hZm != null && this.hZm.cmr());
                e.OY().OZ();
                this.hZO = true;
                this.hZP = q.TO();
            }
            ac.fR("");
            ac.Ed();
        }
        if (this.hBO.DW() != null && this.hBO.DW().mLiveInfo != null) {
            this.hBO.j(this.hBO.DW().mLiveInfo.live_id, !this.hZK);
            this.hZK = true;
        }
        if (this.hZD != null) {
            this.hZD.b(this.hZu);
            this.hZD.nI(TextUtils.equals(this.hZB, "1"));
            this.hZB = "";
        }
        if (this.hZr != null) {
            this.hZr.a(this.aBr, this.hZs);
        }
        a(this.hBO.DW());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.10
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.hBO.DW() != null && b.this.hBO.DW().mLiveInfo != null) {
                    b.this.hBO.a(b.this.hBO.DW().mLiveInfo.live_id, b.this.brl, b.this.hCm);
                }
            }
        });
        if (z && this.hBO.DW() != null && this.hBO.DW().aFH != null) {
            bq bqVar = com.baidu.live.af.a.OJ().bxp;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bqVar != null && bqVar.aMR != null && bqVar.aMR.aPs) {
                m(true, this.hBO.DW().aFH.userId);
            }
        }
        this.bvd = false;
        if (z && this.hBO.DW() != null && this.hBO.DW().mLiveInfo != null && this.hBO.DW().aFH != null && this.hZD != null) {
            long j = this.hBO.DW().mLiveInfo.live_id;
            long j2 = this.hBO.DW().mLiveInfo.room_id;
            String str2 = this.hBO.DW().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str3 = "oneYuanGift_" + j;
                if (al.El() != null) {
                    al.El().bz(this.bft);
                    if (!this.bft) {
                        al.El().a(this.mTbPageContext.getPageActivity(), j, str3, j2, str2, this.otherParams);
                    }
                }
                if (this.iaf != null) {
                    this.iaf.b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
                }
            }
            if (com.baidu.live.guardclub.e.HC() != null) {
                com.baidu.live.guardclub.e.HC().b(this.mTbPageContext.getPageActivity(), j, j2, str2, this.otherParams);
            }
            if (this.hZL == null) {
                this.hZL = new com.baidu.tieba.ala.liveroom.k.a();
                this.hZL.bz(this.bft);
            }
            if (!this.bft) {
                this.hZL.a(this.mTbPageContext.getPageActivity(), this.hBO.DW(), this.otherParams);
            }
        }
        if (this.hZM == null) {
            this.hZM = new com.baidu.tieba.ala.liveroom.v.c(this.mTbPageContext);
            this.hZM.bz(this.bft);
        }
        if (z && this.hBO.DW() != null && this.hBO.DW().aGd != null && !this.hZN) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.hZM.a(this.hBO.DW(), this.hBO.DW().aGd.userId);
                this.hZN = true;
            }
        }
        if (this.hBO.DW() != null && this.hBO.DW().mLiveInfo != null && this.hBO.DW().aGd != null) {
            com.baidu.live.q.a.d(this.hBO.DW().mLiveInfo.live_id, this.hBO.DW().aGd.needRename == 1);
            if (z) {
                com.baidu.live.q.a.c(this.hBO.DW().mLiveInfo.live_id, 0);
            }
        }
        if (this.hCL != null && this.hBO.DW() != null && this.hBO.DW().aFH != null) {
            this.hCL.bd(this.hBO.DW().aFH.userId);
        }
    }

    private void U(x xVar) {
        String str = "";
        if (!TextUtils.isEmpty(this.uk)) {
            str = "uk=" + this.uk;
        } else if (this.brk > 0) {
            str = "live_id=" + this.brk;
        } else if (!TextUtils.isEmpty(this.hZE)) {
            str = "live_room_id=" + this.hZE;
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            str = "url=" + this.mUrl;
        }
        LogManager.getLiveCloseLogger().doEnterLiveCloseGuestLog(xVar.mLiveInfo.live_id + "", xVar.mLiveInfo.room_id + "", xVar.mLiveInfo.feed_id, str, this.otherParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmR() {
        if (this.hZv) {
            this.hZq.a(this.mSelectedPosition, cmP(), this.aBr);
            this.hZq.b(this.mSelectedPosition, cmQ(), this.aBr);
            this.hZv = false;
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
        if (!this.hZx) {
            this.mHandler.removeCallbacks(this.hZZ);
            this.mHandler.postDelayed(this.hZZ, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(r rVar) {
        if (rVar == null) {
            if (!this.hZx) {
                this.mHandler.removeCallbacks(this.hZY);
                this.mHandler.postDelayed(this.hZY, 5000L);
                return;
            }
            return;
        }
        if (!this.hZw) {
            c(rVar);
        }
        if (!this.hZx) {
            this.mHandler.removeCallbacks(this.hZY);
            this.mHandler.postDelayed(this.hZY, rVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmS() {
        if (this.hBO.DW() != null && this.hBO.DW().mLiveInfo != null) {
            this.hBO.j(this.hBO.DW().mLiveInfo.live_id, !this.hZK);
            this.hZK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.live_status == 2) {
            this.hZq.a(this.mSelectedPosition, this.hBO.DW());
            e(xVar, false);
        } else if (xVar != null) {
            if (!this.hZw) {
                ac.e(xVar);
                a(xVar);
            }
            if (!this.hZx) {
                this.mHandler.removeCallbacks(this.hFy);
                this.mHandler.postDelayed(this.hFy, xVar.aFM);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cib() {
        if (this.mTbPageContext != null && this.hBO.DW() != null && this.hBO.DW().mLiveInfo != null) {
            this.hBO.a(this.hBO.DW().mLiveInfo.live_id, this.brl, this.hCm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(x xVar, boolean z) {
        String str;
        nJ(true);
        if (!cnb()) {
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.ciZ().oy(true);
            com.baidu.tieba.ala.liveroom.performancewatchtask.b.ciZ().release();
            this.hBO.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.hZo != null) {
                this.hZo.Vz();
                this.hZo.cke();
                this.hZo.ckj();
            }
            if (xVar == null || xVar.mLiveInfo == null) {
                str = null;
            } else {
                this.hZF = xVar.mLiveInfo.live_id;
                str = String.valueOf(xVar.mLiveInfo.room_id);
            }
            cmH();
            cmT();
            cmU();
            if (this.hZm.cmr() && !StringUtils.isNull(str) && this.hZm.cms() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("source", "end_live");
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(str);
                    jSONObject.put("room_ids", jSONArray);
                    this.hZm.cms().z("mix_room_close", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (xVar != null) {
                View a2 = (this.hZD == null || this.hZD.caZ() == null) ? null : this.hZD.caZ().a(this.hZD.caO().pageContext.getPageActivity(), xVar, z);
                if (this.hZo != null) {
                    this.hZC.a(this.hZo, a2, xVar, z, this.hBO.ciy());
                }
                if (this.hZD != null) {
                    this.hZD.nJ(false);
                    this.hZD.caU();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.hZo != null) {
                    this.hZo.ckg();
                }
                long j = xVar.mLiveInfo.live_id;
                String str2 = xVar.mLiveInfo.feed_id;
                long j2 = xVar.aFH.userId;
                String str3 = xVar.aFH.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    QMStaticManager.staticEndPlayTime(j + "", str + "", j2 + "", str3, System.currentTimeMillis(), str2, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", str + "", str2, this.otherParams);
                this.hZJ = new StayTimeBean();
                this.hZJ.liveId = xVar.mLiveInfo.live_id;
                this.hZJ.roomId = xVar.mLiveInfo.room_id;
                this.hZJ.vid = xVar.mLiveInfo.feed_id;
                this.hZJ.startTime = System.currentTimeMillis();
            }
            cnd();
            if (this.hZr != null) {
                this.hZr.a(this.aBr, this.hZs);
            }
        }
    }

    private void cmT() {
    }

    private void cmU() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.hZp);
        }
    }

    public void cmV() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cmW();
        } else {
            cmX();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.hBO != null && this.hBO.DW() != null) {
            alaLiveInfoData = this.hBO.DW().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            cmW();
        } else {
            cmX();
        }
        this.hZp.setIsScrollable(!z && this.hZS);
        if (this.hZD != null) {
            this.hZD.onKeyboardVisibilityChanged(z);
        }
        if (this.hCg != null) {
            this.hCg.onKeyboardVisibilityChanged(z);
        }
    }

    public void co(int i) {
        if (i == 0) {
            i = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        }
        if (isDebug()) {
            Log.d(TAG, "onScreenOrientationChanged: ");
        }
        if (i == 2) {
            cmW();
        } else {
            cmX();
        }
        this.hCg.co(i);
        wm(i);
        if (al.El() != null) {
            al.El().Du();
        }
        if (this.hZL != null) {
            this.hZL.Du();
        }
        if (this.hZr != null) {
            this.hZr.co(i);
        }
    }

    public void cmW() {
        if (this.hZp != null) {
            i.ae(this.hZp);
        }
    }

    public void cmX() {
        if (this.hZp != null) {
            i.af(this.hZp);
        }
    }

    private boolean cmY() {
        return this.iab || this.iac;
    }

    private void cmZ() {
        this.iab = false;
        this.iac = false;
    }

    public void onResume() {
        if (h.isDebug()) {
            Log.d(TAG, "onResume mAppBackground=" + this.hZQ + " mWebOver=" + this.hZy + ", isFloatingMode=" + isFloatingMode());
        }
        cmZ();
        if (!this.hZy || !isFloatingMode()) {
            bUj();
            if (this.hBO != null) {
                this.hBO.cii();
                this.hBO.cim();
            }
            if (this.hZD != null) {
                this.hZD.enterForeground();
            }
            if (this.hZL != null) {
                this.hZL.onResume();
            }
            if (this.hZM != null) {
                this.hZM.onResume();
            }
            com.baidu.live.core.layer.b.As().onResume();
        }
    }

    public void onStart() {
        if (h.isDebug()) {
            Log.d(TAG, "onStart mAppBackground=" + this.hZQ + " mWebOver=" + this.hZy + ", isFloatingMode=" + isFloatingMode());
        }
        mRef = new WeakReference<>(this);
        cmZ();
        if ((!this.hZy || !isFloatingMode()) && !this.hZQ) {
            bUj();
            if (this.hZx) {
                this.hZx = false;
                cna();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            cmF();
        }
    }

    public void cna() {
        cib();
        cmS();
        this.hBO.cix();
        if (!this.hZt.isPlaying()) {
            cmG();
        } else if (this.hZt.isPaused()) {
            this.hZt.resume();
        }
        if (this.hZD != null) {
            this.hZD.caY();
        }
        if (this.hBO != null && this.hBO.DW() != null && this.hBO.DW().mLiveInfo != null) {
            this.hZI.fG(this.hBO.DW().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aBr.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (h.isDebug()) {
            Log.d(TAG, "onPause mWebOver=" + this.hZy + ", isFloatingMode=" + isFloatingMode());
        }
        if (cmY() || !this.hZy || !isFloatingMode()) {
            if (this.hBO != null) {
                this.hBO.cij();
                this.hBO.cin();
            }
            if (this.hZD != null) {
                this.hZD.enterBackground();
            }
            com.baidu.live.core.layer.b.As().onPause();
        }
    }

    public void V(boolean z, boolean z2) {
        if (h.isDebug()) {
            Log.d(TAG, "onStop isUserClose=" + this.hZX);
        }
        if (!cmY() && z && !this.hZX && cmA()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0627a() { // from class: com.baidu.tieba.ala.player.b.12
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0627a
                    public boolean a(SdkLivePlayer sdkLivePlayer) {
                        if (sdkLivePlayer != null) {
                            sdkLivePlayer.aQJ();
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
        this.hZx = true;
        oW(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void oW(boolean z) {
        this.mHandler.removeCallbacks(this.hFy);
        this.mHandler.removeCallbacks(this.hZY);
        this.mHandler.removeCallbacks(this.hZZ);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            if (!this.hZt.isFloatingMode()) {
                this.hZt.aQJ();
            }
        } else if (!z && !this.hZt.isFloatingMode()) {
            this.hZt.aQJ();
        }
        if (this.hZD != null) {
            this.hZD.caX();
        }
        this.hZI.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (al.El() != null) {
                al.El().a(i, i2, intent, this.aBr, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.hZD != null) {
            this.hZD.onActivityResult(i, i2, intent);
        }
    }

    public boolean cnb() {
        return this.hZC != null && this.hZC.bTZ();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.iao != null) {
            MessageManager.getInstance().unRegisterListener(this.iao);
        }
        if (this.iap != null) {
            MessageManager.getInstance().unRegisterListener(this.iap);
        }
        MessageManager.getInstance().unRegisterListener(this.iaq);
        MessageManager.getInstance().unRegisterListener(this.iar);
        MessageManager.getInstance().unRegisterListener(this.ias);
        MessageManager.getInstance().unRegisterListener(this.iat);
        MessageManager.getInstance().unRegisterListener(this.iak);
        MessageManager.getInstance().unRegisterListener(this.hox);
        MessageManager.getInstance().unRegisterListener(this.iad);
        MessageManager.getInstance().unRegisterListener(this.iae);
        MessageManager.getInstance().unRegisterListener(this.bdo);
        if (this.iaf != null) {
            this.iaf.release();
        }
        if (this.hZt != null && !this.hZt.isFloatingMode()) {
            this.hZt.cD(true);
        }
        if (this.hZr != null) {
            this.hZr.onDestory();
        }
        if (this.hCL != null) {
            this.hCL.release();
            this.hCL = null;
        }
        if (this.hCN != null) {
            this.hCN.release();
            this.hCN = null;
        }
        if (this.hZs != null) {
            this.hZs.reset();
        }
        if (this.hZD != null) {
            this.hZD.onDestroy();
        }
        if (this.hZq != null) {
            this.hZq.onDestroy();
        }
        if (this.hZo != null) {
            this.hZo.Vz();
            this.hZo.release();
            this.hZo = null;
        }
        if (this.hZC != null) {
            this.hZC.onDestroy();
        }
        if (this.hZJ != null && this.hBO != null && this.hBO.DW() != null) {
            long j = this.hBO.DW().mLiveInfo.live_id;
            if (this.hZJ.liveId == j && this.hZJ.startTime > 0) {
                this.hZJ.endTime = System.currentTimeMillis();
                long j2 = this.hZJ.endTime - this.hZJ.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.hZJ.roomId + "", this.hZJ.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.hZJ = null;
        }
        if (this.hCg != null) {
            this.hCg.ckm();
            this.hCg = null;
        }
        if (this.hBO != null) {
            this.hBO.destory();
        }
        if (this.hCK != null) {
            this.hCK.release();
        }
        if (this.hCM != null) {
            this.hCM.release();
        }
        z.DO().release();
        if (this.hZM != null) {
            this.hZM.release();
        }
        com.baidu.live.gift.x.DM().release();
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, "notice", "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String JQ() {
        return this.otherParams;
    }

    public void oX(boolean z) {
        this.hZQ = z;
    }

    public void cnc() {
        if (this.hZG != null) {
            this.otherParams = this.hZG.toString();
            if (this.hBO != null) {
                this.hBO.setOtherParams(this.otherParams);
            }
            if (this.hZD != null) {
                this.hZD.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.hZC != null) {
                this.hZC.setOtherParams(this.otherParams);
            }
        }
    }

    public void cnd() {
        if (this.hZG != null) {
            String optString = this.hZG.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.hZG.put("tab", "live_jump");
                        this.hZG.put("tag", "");
                        this.hZG.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        this.hZG.put("tab", "liveroom");
                        this.hZG.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                cnc();
            }
        }
    }

    private void m(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.HA();
        }
        bVar.setAnchorId(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void cne() {
        ac.Eg();
    }

    private void k(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hZD.e(s);
        } else {
            this.hZD.f(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDebug() {
        return h.isDebug();
    }
}
