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
import com.baidu.ala.AlaCmdConfigHttp;
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
import com.baidu.live.data.au;
import com.baidu.live.data.be;
import com.baidu.live.data.bf;
import com.baidu.live.data.k;
import com.baidu.live.data.r;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.t;
import com.baidu.live.gift.v;
import com.baidu.live.guardclub.e;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.p.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
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
import com.baidu.live.utils.m;
import com.baidu.live.utils.o;
import com.baidu.live.utils.p;
import com.baidu.tieba.ala.floating.a;
import com.baidu.tieba.ala.floating.permission.FloatPermissionUtil;
import com.baidu.tieba.ala.liveroom.j.g;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPagerAdapter;
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
/* loaded from: classes7.dex */
public class b extends BdBaseView<TbPageContext> {
    private static String TAG = "AlaLiveViewController";
    private static int gYk = 1;
    private static WeakReference<b> mRef;
    private r aAh;
    private boolean aXy;
    private String bev;
    private long bew;
    private com.baidu.live.p.b brk;
    private d gBF;
    private boolean gBM;
    private AlaLiveView gBZ;
    private ViewGroup gCa;
    private LayerRootView gCb;
    private long gCf;
    private d.a gCp;
    private Runnable gDS;
    private HttpMessageListener gDV;
    private int gDz;
    private Runnable gFk;
    private a gXB;
    private AlaLiveRoomBlurPageLayout gXC;
    private AlaLoopViewPager gXD;
    private AlaLoopViewPagerAdapter gXE;
    private com.baidu.tieba.ala.liveroom.e.a gXF;
    private com.baidu.tieba.ala.liveroom.e.b gXG;
    private SdkLivePlayer gXH;
    private AlaLastLiveroomInfo gXI;
    private boolean gXJ;
    private boolean gXK;
    private boolean gXL;
    private boolean gXM;
    @Deprecated
    private boolean gXN;
    private ArrayList<AlaBroadcastGiftToastData> gXO;
    private String gXP;
    private com.baidu.tieba.ala.endliveroom.a gXQ;
    private com.baidu.tieba.ala.liveroom.d.c gXR;
    private String gXS;
    private long gXT;
    private JSONObject gXU;
    private boolean gXV;
    private com.baidu.tieba.ala.liveroom.task.c gXW;
    private StayTimeBean gXX;
    private boolean gXY;
    private com.baidu.tieba.ala.liveroom.k.a gXZ;
    private com.baidu.live.p.a gYA;
    com.baidu.live.liveroom.a.c gYB;
    ViewPager.OnPageChangeListener gYC;
    HttpMessageListener gYD;
    CustomMessageListener gYE;
    CustomMessageListener gYF;
    CustomMessageListener gYG;
    CustomMessageListener gYH;
    private CustomMessageListener gYI;
    private com.baidu.tieba.ala.liveroom.w.c gYa;
    private boolean gYb;
    private boolean gYc;
    private String gYd;
    private boolean gYe;
    private boolean gYf;
    private bf gYg;
    private boolean gYh;
    private boolean gYi;
    private int gYj;
    private boolean gYl;
    private boolean gYm;
    private Runnable gYn;
    private Runnable gYo;
    private Runnable gYp;
    private boolean gYq;
    private boolean gYr;
    private CustomMessageListener gYs;
    private CustomMessageListener gYt;
    private com.baidu.live.y.c gYu;
    private boolean gYv;
    private boolean gYw;
    private long gYx;
    private long gYy;
    private CustomMessageListener gYz;
    private String gkr;
    CustomMessageListener gow;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void bZe() {
        if (this.gYa != null) {
            this.gYa.bm(this.aXy);
        }
        if (this.gXZ != null) {
            this.gXZ.bm(this.aXy);
        }
        if (ac.Fe() != null) {
            ac.Fe().bm(this.aXy);
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.gXJ = true;
        this.gCf = 0L;
        this.gXK = false;
        this.gBM = true;
        this.bev = "";
        this.mForumName = "";
        this.gXL = false;
        this.gXN = false;
        this.gXP = "0";
        this.mHandler = new Handler();
        this.gXT = -1L;
        this.otherParams = "";
        this.gXV = false;
        this.gXW = com.baidu.tieba.ala.liveroom.task.c.bWB();
        this.gXY = false;
        this.gYc = false;
        this.gYe = false;
        this.gYf = false;
        this.gYi = false;
        this.gYj = 0;
        this.gYl = false;
        this.gYm = false;
        this.gFk = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bVh();
            }
        };
        this.gYn = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.bZB();
            }
        };
        this.gYo = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.gBF.bVD();
            }
        };
        this.gYp = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.gow = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.gYq = true;
            }
        };
        this.gYs = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.gYr = true;
            }
        };
        this.gYt = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.gDz = 5000;
        this.gYz = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.aXy = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.bZe();
            }
        };
        this.brk = new com.baidu.live.p.b() { // from class: com.baidu.tieba.ala.player.b.25
            @Override // com.baidu.live.p.b
            public void dD(int i) {
                if (b.this.gXC != null) {
                    if (ListUtils.getCount(b.this.gXH.getAlaLiveInfoDataList()) < 2) {
                        b.this.gXC.bXd();
                    } else {
                        b.this.gXC.bXe();
                    }
                }
                if (b.this.gXR != null) {
                    b.this.gXR.dD(i);
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.bZN();
                }
            }
        };
        this.gYA = new com.baidu.live.p.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.live.p.a
            public void cg(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && b.this.gXH != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.gXH.isPlaying());
                        if (!b.this.gXH.isPlaying()) {
                            b.this.gXH.resume();
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.gXH.isPlaying()) {
                        b.this.gXH.pause();
                    }
                }
            }
        };
        this.gYB = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.liveroom.a.c
            public void bY(boolean z) {
                if (z || b.this.gXR == null || b.this.gXR.bOM()) {
                    if (!b.this.bZn() || b.this.a(true, (a.InterfaceC0600a) null)) {
                        b.this.gYm = true;
                        b.this.mT(true);
                        b.this.bLV();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void bZ(boolean z) {
                b.this.d(b.this.aAh, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.gXH.bZR();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.gXL) {
                    if (b.this.gXL) {
                        b.this.gXH.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.gXH.ai(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.gXD != null) {
                    b.this.gXD.setIsScrollable(b.this.gYh && z);
                    b.this.gXD.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void ca(boolean z) {
                boolean z2 = true;
                if (!z || b.this.bZK()) {
                    if (b.this.gXC != null) {
                        b.this.gXC.bXg();
                        return;
                    }
                    return;
                }
                if (b.this.gBF.LC().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.gXC != null) {
                    b.this.gXC.mF(z2);
                }
            }
        };
        this.gYC = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.gBZ != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.gXD.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.gBM || ListUtils.getCount(b.this.gBF.bVC()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if (!b.this.gBF.bVH() || i2 >= 0) {
                            if (b.this.gBF.bVI() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                b.this.gXD.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            b.this.gBF.cancelLoadData();
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.lM(true);
                            b.this.gXC.bXb();
                            b.this.gXC.Qt();
                            b.this.gXC.bXc();
                            if (b.this.gBF.LC() != null) {
                                if (TbadkCoreApplication.getInst().isHaokan()) {
                                    HKStaticManager.staticEndPlayTime(b.this.gBF.LC().mLiveInfo.live_id + "", b.this.gBF.LC().mLiveInfo.room_id + "", b.this.gBF.LC().aDE.userId + "", b.this.gBF.LC().aDE.userName, System.currentTimeMillis(), b.this.gBF.LC().mLiveInfo.feed_id, b.this.otherParams);
                                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                    QMStaticManager.staticEndPlayTime(b.this.gBF.LC().mLiveInfo.live_id + "", b.this.gBF.LC().mLiveInfo.room_id + "", b.this.gBF.LC().aDE.userId + "", b.this.gBF.LC().aDE.userName, System.currentTimeMillis(), b.this.gBF.LC().mLiveInfo.feed_id, b.this.otherParams);
                                }
                            }
                            if (b.this.gXX != null) {
                                long j = b.this.gBF.LC().mLiveInfo.live_id;
                                if (b.this.gXX.liveId == j && b.this.gXX.startTime > 0) {
                                    b.this.gXX.endTime = System.currentTimeMillis();
                                    long j2 = b.this.gXX.endTime - b.this.gXX.startTime;
                                    if (j2 < 0) {
                                        j2 = 0;
                                    }
                                    LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.gXX.roomId + "", b.this.gXX.vid, j2 / 1000, b.this.otherParams);
                                }
                                b.this.gXX = null;
                            }
                            b.this.bZM();
                            if (b.this.gYu != null) {
                                b.this.gYu.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.gXC = b.this.gXE.ui(b.this.mSelectedPosition);
                            b.this.gXC.bXf();
                            b.this.uX(i2);
                            b.this.bZp();
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                        b.this.gXD.setCurrentItem(b.this.mSelectedPosition);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.gXD.setCurrentItem(b.this.mSelectedPosition);
                        b.this.gBF.g(b.this.gBF.bVM());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.AD().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.gCp = new d.a() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.tieba.ala.liveroom.p.d.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.y(b.this.gBF.LC());
                } else if (i2 == 2) {
                    b.this.f(b.this.gBF.bIv());
                } else if (i2 == 3) {
                    b.this.aZ(i, str);
                } else if (i2 == 4) {
                    b.this.aB(obj);
                } else if (i2 == 5) {
                    b.this.bZA();
                }
            }
        };
        this.gDS = new Runnable() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // java.lang.Runnable
            public void run() {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                    if (b.this.gBF != null && b.this.gBF.LC() != null) {
                        m.k(b.this.gBF.LC().mLiveInfo.user_id, b.this.gBF.LC().mLiveInfo.live_id);
                    }
                    if (b.this.mHandler != null) {
                        b.this.mHandler.postDelayed(b.this.gDS, b.this.gDz);
                    }
                }
            }
        };
        this.gYD = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bWz() != null && b.this.mTbPageContext != null) {
                        b.this.gXW.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bWz());
                    }
                }
            }
        };
        this.gYE = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.13
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
        this.gYF = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.gBF != null && b.this.gBF.LC() != null && b.this.gBF.LC().mLiveInfo != null) {
                    long j = b.this.gBF.LC().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.gYu != null) {
                        b.this.gYu.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.gDV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.gBF.LC().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.beO != null && !eventPollingHttpResponseMessage.beO.isEmpty() && b.this.gBF != null && b.this.gBF.LC() != null && b.this.gBF.LC().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        for (int i = 0; i < eventPollingHttpResponseMessage.beO.size(); i++) {
                            au auVar = eventPollingHttpResponseMessage.beO.get(i);
                            if (j == auVar.liveId && j2 - auVar.createTime <= 60 && !m.i(auVar.liveId, auVar.id)) {
                                m.a(auVar, b.this.gBF.LC().mLiveInfo, false);
                                if (b.this.gXR != null) {
                                    b.this.gXR.a(auVar);
                                }
                                m.j(auVar.liveId, auVar.id);
                            }
                        }
                        au auVar2 = eventPollingHttpResponseMessage.beO.get(eventPollingHttpResponseMessage.beO.size() - 1);
                        if (j == auVar2.liveId) {
                            m.h(auVar2.liveId, auVar2.id);
                        }
                    }
                    int i2 = eventPollingHttpResponseMessage.beN;
                    if (i2 <= 0) {
                        i2 = 5;
                    }
                    b.this.gDz = i2 * 1000;
                }
            }
        };
        this.gYG = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.gBF != null && b.this.gBF.LC() != null && b.this.gBF.LC().aEd != null) {
                        if (l.longValue() == b.this.gBF.LC().aEd.userId) {
                            b.this.gBF.LC().aEd.isNewUser = false;
                            if (b.this.gXZ != null) {
                                b.this.gXZ.o(b.this.gBF.LC());
                            }
                        }
                    }
                }
            }
        };
        this.gYH = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.t.a)) {
                    com.baidu.tieba.ala.liveroom.t.a aVar2 = (com.baidu.tieba.ala.liveroom.t.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String Cv = aVar2.Cv();
                    if (b.this.mTbPageContext != null && b.this.gBF != null && b.this.gBF.LC() != null && b.this.gBF.LC().aEd != null) {
                        if (valueOf.longValue() == b.this.gBF.LC().aEd.userId && com.baidu.live.w.a.Nk().bka != null && com.baidu.live.w.a.Nk().bka.aJw != null && com.baidu.live.w.a.Nk().bka.aJw.CX()) {
                            g.ub(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, Cv));
                        }
                    }
                }
            }
        };
        this.gYI = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.gFk != null) {
                    b.this.mHandler.removeCallbacks(b.this.gFk);
                }
                b.this.bVh();
            }
        };
        this.gCf = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.gXB = aVar;
        this.gXJ = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.y.c.class);
        if (runTask != null) {
            this.gYu = (com.baidu.live.y.c) runTask.getData();
        }
        this.gBF = new d(getPageContext());
        this.gBF.a(this.gCp);
        this.gXQ = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.gYD);
        MessageManager.getInstance().registerListener(this.gYE);
        MessageManager.getInstance().registerListener(this.gYF);
        MessageManager.getInstance().registerListener(this.gDV);
        MessageManager.getInstance().registerListener(this.gYG);
        MessageManager.getInstance().registerListener(this.gYH);
        MessageManager.getInstance().registerListener(this.gYI);
        MessageManager.getInstance().registerListener(this.gYz);
        MessageManager.getInstance().registerListener(this.gow);
        MessageManager.getInstance().registerListener(this.gYs);
        MessageManager.getInstance().registerListener(this.gYt);
    }

    private void R(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.gXO = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.gXO.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void S(Intent intent) {
        R(intent);
        this.bev = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bev)) {
            this.bev = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.gXS = intent.getStringExtra("room_id");
        this.bew = intent.getLongExtra("live_id", 0L);
        this.gXV = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.gBF.b((AlaLiveInfoCoreData) serializableExtra);
            this.gXV = true;
        }
        T(intent);
        this.gYh = this.gYg == null || !this.gYg.aJM;
        this.gXQ.setOtherParams(this.otherParams);
        bZg();
        bZf();
        this.mHandler.removeCallbacks(this.gYp);
        this.mHandler.postDelayed(this.gYp, 1000L);
    }

    private void T(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.gYj = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.gkr = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.gXU = new JSONObject(stringExtra);
                if (this.gXU != null) {
                    String optString2 = this.gXU.optString("enterRoomId");
                    String optString3 = this.gXU.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.gXS, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bew + "", optString3))) {
                        String optString4 = this.gXU.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString5 = this.gXU.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString5);
                        if (!this.gXV) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bew;
                            alaLiveInfoCoreData.screenDirection = this.gXU.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.gBF.b(alaLiveInfoCoreData);
                            this.gXV = true;
                        }
                    }
                    String optString6 = this.gXU.optString("extra");
                    try {
                        this.gYx = Long.parseLong(this.gXS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.gYy = this.bew;
                    if (TextUtils.isEmpty(optString6)) {
                        this.gYg = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.gBF != null) {
                            this.gBF.FL(optString7);
                        }
                        this.gYv = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.gYw = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.gkr = jSONObject.optString("live_back_scheme");
                        this.gYg = new bf();
                        this.gYg.aJM = jSONObject.optInt("is_hot") == 1;
                        if (this.gYg.aJM) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.gYj = AlaLiveSwitchData.isHotLive;
                        this.gYg.aJN = jSONObject.optString("task_id");
                        this.gYg.aJL = !TextUtils.isEmpty(this.gYg.aJN);
                        this.gYg.aJO = jSONObject.optInt("task_type");
                        this.gYg.aJP = jSONObject.optInt("task_im_count");
                        this.gYg.aJQ = jSONObject.optLong("task_gift_total_price");
                        this.gYg.aJR = jSONObject.optLong("task_watch_time");
                        this.gYg.aJS = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.gXU.put("from", optString);
                        }
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.gXG = new com.baidu.tieba.ala.liveroom.e.b();
                            this.gXG.setScheme(optString8);
                            this.gXG.setImageUrl(optString9);
                            this.gXG.setTitle(optString10);
                        }
                    }
                    this.gXP = this.gXU.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gXU.remove("cover");
                    this.gXU.remove("live_url");
                    this.gXU.remove("enterRoomId");
                    this.gXU.remove("enterLiveId");
                    this.gXU.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gXU.remove("extra");
                    this.otherParams = this.gXU.toString();
                    if (this.gBF != null) {
                        this.gBF.setOtherParams(this.otherParams);
                    }
                    this.gXU.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.gXU.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.gXU.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.gXU.optString("source");
                    }
                    this.gYi = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.gXU.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    if (this.gBF != null) {
                        this.gBF.uA(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra(AlaLiveRoomActivityConfig.LAST_LIVE_INFO);
            if (!StringUtils.isNull(stringExtra2)) {
                this.gXI = new AlaLastLiveroomInfo();
                this.gXI.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bew), String.valueOf(this.gXS), null, bZv());
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

    public void bZf() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.gBF.ah(this.uk, this.bev, this.mForumName);
        } else if (this.gBF.LC() != null && this.gBF.LC().mLiveInfo != null && this.gBF.LC().mLiveInfo.live_id > 0) {
            this.gBF.a(this.gBF.LC().mLiveInfo.live_id, false, this.bev, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bev = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                mT(false);
                return;
            }
            this.gBF.ah(this.uk, this.bev, this.mForumName);
        } else if (!TextUtils.isEmpty(this.gXS)) {
            this.gBF.Gm(this.gXS);
        } else if (this.bew > 0) {
            this.gBF.a(this.bew, false, this.bev, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            mT(false);
        }
    }

    private void bZg() {
        this.gBM = true;
        this.gXK = false;
        bZh();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.Cl().m(this.gCb);
        this.gXR = new com.baidu.tieba.ala.liveroom.d.c();
        this.gXR.a(this.gYB);
        this.gXR.setOtherParams(this.otherParams);
        this.gXR.lH(this.gYi);
        bZj();
        bZi();
    }

    private void bZh() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.gXD = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.gXD.setOnPageChangeListener(this.gYC);
        this.gXD.setBoundaryCaching(true);
        this.gXD.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.gXE = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.gXE.bSV();
        this.gXC = this.gXE.uh(this.mSelectedPosition);
        this.gXE.a(this.mSelectedPosition, this.gBF.LC());
        this.gXD.setAdapter(this.gXE);
        this.gXD.setCurrentItem(this.mSelectedPosition);
        this.gXD.setIsScrollable(this.gYh);
        this.gCa = (ViewGroup) inflate.findViewById(a.g.func_view);
        this.gCb = (LayerRootView) inflate.findViewById(a.g.layer_root_view);
    }

    private void c(Rect rect) {
        this.gXH = SdkLivePlayer.eR(getPageContext().getPageActivity());
        if (this.gXH == null) {
            this.gXD.setIsScrollable(false);
            if (this.gBF != null) {
                this.gBF.cancelLoadData();
            }
            bSY();
            return;
        }
        this.gXH.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.gXH.setIPlayerCallBack(this.brk);
        this.gXH.setIPlayerAudioFocusCallBack(this.gYA);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gXC.a(this.gXH, layoutParams, true);
    }

    private void bZi() {
        this.gXF = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.gCa);
    }

    private void bSY() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.mT(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.gBZ = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.gBZ.setSwipeClearEnable(true);
        this.gBZ.gLW = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gXC.a(this.gBZ, layoutParams);
    }

    private void bZj() {
        if (this.gBF != null && this.gBF.LC() != null) {
            this.aAh = this.gBF.LC();
            if (this.aAh.mLiveInfo != null) {
                a(this.aAh.mLiveInfo, this.gXV);
                if (this.aAh.mLiveInfo != null && this.aAh.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.gXL);
                    }
                    if (!this.gXL) {
                        this.gXH.c(this.aAh.mLiveInfo);
                    } else {
                        this.gXH.setPlayLiveInfo(this.aAh.mLiveInfo);
                    }
                    if (this.gXR != null) {
                        this.gXR.a(this.mTbPageContext, this.gBZ, this.gXH, this.gXC, this.gBF, this.bev, this.gXN, this.gCf, this.gXO, this.gYg);
                        j(this.aAh.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean bZk() {
        boolean z = (this.aAh == null || this.aAh.mLiveInfo == null || this.aAh.mLiveInfo.mAlaLiveSwitchData == null || this.aAh.mLiveInfo.mAlaLiveSwitchData.isSmallWindowPendantUnabled()) ? false : true;
        Log.d(TAG, "isLiveFloatable " + z);
        return z || bZo();
    }

    private long bZl() {
        if (this.aAh == null || this.aAh.mLiveInfo == null) {
            return 0L;
        }
        return this.aAh.mLiveInfo.room_id;
    }

    private long bZm() {
        if (this.aAh == null || this.aAh.mLiveInfo == null) {
            return 0L;
        }
        return this.aAh.mLiveInfo.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZn() {
        boolean z = this.gYv && (this.gYx == bZl() || this.gYy == bZm());
        Log.d(TAG, "isCloseToFloatable " + z);
        return z;
    }

    private boolean bZo() {
        boolean z = this.gYw && (this.gYx == bZl() || this.gYy == bZm());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZp() {
        if (gYk <= 0) {
            return false;
        }
        if (!(bZn() || bZk()) || FloatPermissionUtil.Lo()) {
            return false;
        }
        gYk--;
        FloatPermissionUtil.ah(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0600a interfaceC0600a) {
        if (!FloatPermissionUtil.Lo()) {
            if (this.gYl) {
                return true;
            }
            this.gYl = true;
            if (z) {
                FloatPermissionUtil.ah(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (bZn()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.gYw) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a eM = com.baidu.tieba.ala.floating.b.eM(getPageContext().getPageActivity());
        eM.a(interfaceC0600a);
        eM.dj(jSONObject);
        com.baidu.tieba.ala.floating.b.eM(getPageContext().getPageActivity()).a(this.gXH, this.gBF.LC(), this.bev, this.gCf);
        Log.d(TAG, "switchToFloating");
        return true;
    }

    private void bJr() {
        Log.d(TAG, "dismissFloating" + this);
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0600a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0600a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                Log.d(b.TAG, "onClosePlayer back");
                if (b.this.gXH != null) {
                    b.this.bZq();
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZq() {
        ArrayList arrayList = (ArrayList) this.gXH.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.gXH.bZR();
            this.gXH.ai(arrayList2);
        }
    }

    private boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bJp();
    }

    private void bZr() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.gYh) {
                this.gXD.setIsScrollable(true);
            } else {
                this.gXD.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Cl().onBackPressed() && ((this.gXR == null || !this.gXR.onKeyDown(i, keyEvent)) && (this.gXR == null || !this.gXR.bOL()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bZr();
            } else if ((this.gXR == null || this.gXR.bOM()) && (!bZn() || a(true, (a.InterfaceC0600a) null))) {
                this.gYm = true;
                mT(true);
                bLV();
            }
        }
        return true;
    }

    public void bLV() {
        if (!TextUtils.isEmpty(this.gkr)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gkr);
                this.gkr = null;
            }
        }
    }

    public void mT(boolean z) {
        P(z, false);
    }

    public void P(boolean z, boolean z2) {
        lM(!z);
        if (this.gXH != null && !this.gXH.isFloatingMode()) {
            this.gXH.destroy();
        }
        com.baidu.live.core.layer.b.Cl().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        bZt();
        long j = -1;
        if (this.gBF != null && this.gBF.bVM() != null) {
            j = this.gBF.bVM().room_id;
        }
        this.gXB.a(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void lM(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.gXI = null;
        if (ac.Fe() != null) {
            ac.Fe().Fd();
        }
        com.baidu.live.core.layer.b.Cl().Cm();
        if (this.gYu != null) {
            this.gYu.release();
        }
        if (this.gXZ != null) {
            this.gXZ.release();
        }
        this.gYg = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.gBF != null) {
            try {
                this.gBF.FL(null);
                AlaLiveInfoData bVM = this.gBF.bVM();
                if (bVM != null) {
                    this.gBF.ei(bVM.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.gXW.stopRecord();
        LiveTimerManager.getInstance().stop();
        bZs();
        if (this.gXH != null && !this.gXH.isFloatingMode()) {
            this.gXH.ch(z);
        }
        if (this.gXR != null) {
            this.gXR.lM(z);
        }
        this.gXY = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.KT().bdO != null) {
            com.baidu.live.liveroom.a.b.KT().bdO.b(this.aAh.mLiveInfo);
        }
    }

    private void bZs() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bZt() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(r rVar) {
        if (rVar != null) {
            this.aAh = rVar;
            if (this.gXR != null) {
                this.gXR.a(rVar);
            }
            bZp();
        }
    }

    private void c(k kVar) {
        if (this.gXR != null) {
            this.gXR.c(kVar);
        }
    }

    private void B(r rVar) {
        this.aAh = rVar;
        bZp();
    }

    private void bZu() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.gYh = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.gYh = true;
        }
        this.gXD.setIsScrollable(this.gYh);
        this.gYj = AlaLiveSwitchData.isHotLive;
        if (this.aAh != null) {
            a(this.aAh.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.gXC.a(this.gBZ, null);
            a(this.gXC, this.aAh.mLiveInfo, this.gBM);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aAh.mLiveInfo.live_id), String.valueOf(this.aAh.mLiveInfo.room_id), String.valueOf(this.aAh.mLiveInfo.feed_id), bZv());
            if (com.baidu.live.liveroom.a.b.KT().bdO != null) {
                com.baidu.live.liveroom.a.b.KT().bdO.a(this.aAh.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.gBM = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.gBF != null && this.gBF.LC() != null && this.gBF.LC().mLiveInfo != null) {
                    j = this.gBF.LC().mLiveInfo.live_id;
                    str2 = this.gBF.LC().mLiveInfo.room_id + "";
                    str = this.gBF.LC().mLiveInfo.feed_id;
                } else {
                    if (this.bew > 0) {
                        j2 = this.bew;
                    }
                    if (!TextUtils.isEmpty(this.gXS)) {
                        j = j2;
                        str = "";
                        str2 = this.gXS;
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
                if (this.gBF != null && this.gBF.LC() != null && this.gBF.LC().mLiveInfo != null) {
                    str3 = this.gBF.LC().mLiveInfo.feed_id;
                    str4 = this.gBF.LC().mLiveInfo.live_id + "";
                    str5 = this.gBF.LC().mLiveInfo.room_id + "";
                    str6 = this.gBF.LC().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            bZp();
        }
    }

    private String bZv() {
        if (this.gXU == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.gXU.optString("source");
            String optString2 = this.gXU.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gXU.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.gXU.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.gXU.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bJr();
        } else if (this.gXH != null && this.gXH.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.gXH.getVideoPath();
                String d = h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.gXH.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (h.aE(videoPath, d)) {
                    this.gXH.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && h.aD(videoPath, d)) {
                    this.gXH.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.bS(this.gXH)) {
                        ((ViewGroup) this.gXH.getParent()).removeView(this.gXH);
                        alaLiveRoomBlurPageLayout.a(this.gXH, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.gXL) {
                        this.gXH.c(alaLiveInfoData);
                        return;
                    } else {
                        this.gXH.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.gXH.bZR();
        } else if (this.gXH != null && this.gXH.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.gXH, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.gXL) {
                    this.gXH.c(alaLiveInfoData);
                } else {
                    this.gXH.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.gXH != null) {
            this.gXH.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = o.s(this.mTbPageContext.getPageActivity());
                layoutParams.height = o.t(this.mTbPageContext.getPageActivity());
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

    public void bZw() {
        this.gBM = true;
    }

    public boolean bZx() {
        return this.gBM;
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
                this.gXC.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.gXC.setBackgroundColor(0);
            }
        } else {
            this.gXC.setBackgroundColor(0);
        }
        int i3 = this.gXH.getLayoutParams().width;
        int i4 = this.gXH.getLayoutParams().height;
        int i5 = this.gXH.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.gXH.getLayoutParams()).topMargin : 0;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i3 || b.height != i4 || b.topMargin != i5) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.gBZ != null) {
            this.gBZ.setLayoutParams(c);
        }
        if (this.gXC != null) {
            this.gXC.D(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gXQ != null) {
            this.gXQ.D(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gXR != null) {
            this.gXR.l(c.width, c.height, realScreenOrientation);
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

    private void uW(int i) {
        boolean z = true;
        if (this.aAh != null && this.aAh.mLiveInfo != null) {
            this.gXC.setBgImageUrl(this.aAh.mLiveInfo.cover, this.aAh.mLiveInfo);
            this.gXE.a(this.mSelectedPosition, bZy(), this.aAh);
            this.gXE.b(this.mSelectedPosition, bZz(), this.aAh);
            this.gXC.requestLayout();
            this.gXC.K(i, this.aAh.mLiveInfo.screen_direction == 2);
        }
        if (this.aAh != null) {
            a(i, this.aAh.mLiveInfo, false);
        }
        boolean bXh = this.gXC.bXh();
        boolean z2 = i == 1;
        if (this.aAh == null || this.aAh.mLiveInfo == null || this.aAh.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!bZK()) {
            if (this.gXH != null && this.gXH.getParent() == null) {
                this.gXC.a(this.gXH, null, false);
                if (this.aAh != null && this.aAh.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.gXL) {
                        this.gXH.c(this.aAh.mLiveInfo);
                    } else {
                        this.gXH.setPlayLiveInfo(this.aAh.mLiveInfo);
                    }
                }
            }
            if (bXh && !bZK() && this.gXR != null) {
                this.gXC.mF(z);
                return;
            }
            return;
        }
        this.gXC.bXb();
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
            this.gBF.a(alaLiveInfoData.live_id, true, this.bev, this.mForumName, this.gYj);
        }
    }

    public void uX(int i) {
        if (i < 0) {
            this.gBF.uB(this.gBF.bVJ() - 1);
        } else if (i > 0) {
            this.gBF.uB(this.gBF.bVJ() + 1);
        }
        if (this.gXR != null) {
            this.gXR.a(this.gXC);
        }
        this.gXE.a(this.mSelectedPosition, bZy(), this.aAh);
        this.gXE.b(this.mSelectedPosition, bZz(), this.aAh);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.gBF != null) {
            int bVJ = this.gBF.bVJ();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bVJ + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.gBF.bVC() != null && this.gBF.bVC().size() > bVJ && this.gBF.bVC().get(bVJ) != null) {
                AlaLiveInfoData alaLiveInfoData = this.gBF.bVC().get(bVJ);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gBF != null) {
            AlaLiveInfoData bVM = this.gBF.bVM();
            if (bVM != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(bVM.live_id), String.valueOf(bVM.room_id), null, bZv());
                bVM.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.gXC, bVM, this.gBM);
                this.gBM = false;
                if (this.gXR != null) {
                    this.gXR.a(this.mTbPageContext, this.gBZ, this.gXH, this.gXC, this.gBF, this.bev, this.gXN, this.gCf, null, this.gYg);
                    short s = 2;
                    if (bVM.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bVM, false);
            }
            i(bVM);
            this.gXC.a(this.gBZ, null);
            if (this.gXR != null) {
                this.gXR.bOJ();
            }
            this.gBF.g(bVM);
        }
    }

    private AlaLiveInfoData bZy() {
        List<AlaLiveInfoData> bVC = this.gBF.bVC();
        if (bVC == null || bVC.size() == 0) {
            if (this.aAh == null) {
                return null;
            }
            return this.aAh.mLiveInfo;
        }
        int bVJ = this.gBF.bVJ();
        int size = bVC.size();
        return bVC.get(((bVJ + size) - 1) % size);
    }

    private AlaLiveInfoData bZz() {
        List<AlaLiveInfoData> bVC = this.gBF.bVC();
        if (bVC == null || bVC.size() == 0) {
            if (this.aAh == null) {
                return null;
            }
            return this.aAh.mLiveInfo;
        }
        return bVC.get((this.gBF.bVJ() + 1) % bVC.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(int i, String str) {
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.gXL) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.i.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            mT(false);
            return;
        }
        r LC = this.gBF.LC();
        B(LC);
        this.gBF.bVD();
        if (this.gBM) {
            this.gBF.my(false);
        }
        this.gCf = System.currentTimeMillis() / 1000;
        if (this.gXR != null) {
            this.gXR.a(this.mTbPageContext, this.gBZ, this.gXH, this.gXC, this.gBF, this.bev, this.gXN, this.gCf, this.gXO, this.gYg);
            short s = 2;
            if (LC.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bZu();
        if (LC != null && LC.mLiveInfo != null && LC.mLiveInfo.live_status == 2) {
            this.gXE.a(this.mSelectedPosition, this.gBF.LC());
            d(LC, false);
            this.gBM = false;
            return;
        }
        boolean z = (this.gXR == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.gYc || !TextUtils.equals(p.Pq(), this.gYd))) {
            v.b(getPageContext(), false);
            com.baidu.live.w.c.Np().Nq();
            this.gYc = true;
            this.gYd = p.Pq();
        }
        if (!this.gYe) {
            this.gYe = true;
            com.baidu.live.entereffect.a.Dg().bh(false);
        }
        if (this.gBF.LC() != null && this.gBF.LC().mLiveInfo != null) {
            this.gBF.f(this.gBF.LC().mLiveInfo.live_id, !this.gXY);
            this.gXY = true;
        }
        if (this.gXR != null) {
            this.gXR.b(this.gXI);
            this.gXR.lL(TextUtils.equals(this.gXP, "1"));
            this.gXP = "";
        }
        if (z && this.gBF.LC() != null && this.gBF.LC().mLiveInfo != null) {
            String str2 = this.gBF.LC().mLiveInfo.feed_id;
            long j = this.gBF.LC().mLiveInfo.live_id;
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                this.mHandler.post(this.gDS);
            }
        }
        if (this.gXF != null) {
            this.gXF.a(this.aAh, this.gXG);
        }
        a(this.gBF.LC());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.gBF.LC() != null && b.this.gBF.LC().mLiveInfo != null) {
                    b.this.gBF.a(b.this.gBF.LC().mLiveInfo.live_id, b.this.bev, b.this.gCf);
                }
            }
        });
        if (z && this.gBF.LC() != null && this.gBF.LC().aDE != null) {
            be beVar = com.baidu.live.w.a.Nk().bka;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && beVar != null && beVar.aJB != null && beVar.aJB.aLp) {
                c(true, this.gBF.LC().aDE.userId);
            }
        }
        this.gBM = false;
        if (z && this.gBF.LC() != null && this.gBF.LC().mLiveInfo != null && this.gBF.LC().aDE != null && this.gXR != null) {
            long j2 = this.gBF.LC().mLiveInfo.live_id;
            long j3 = this.gBF.LC().mLiveInfo.room_id;
            String str3 = this.gBF.LC().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j2;
                if (ac.Fe() != null) {
                    ac.Fe().bm(this.aXy);
                    if (!this.aXy) {
                        ac.Fe().a(this.mTbPageContext.getPageActivity(), j2, str4, j3, str3, this.otherParams);
                    }
                }
                if (this.gYu != null) {
                    this.gYu.b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
                }
            }
            if (e.Il() != null) {
                e.Il().b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
            }
            if (this.gXZ == null) {
                this.gXZ = new com.baidu.tieba.ala.liveroom.k.a();
                this.gXZ.bm(this.aXy);
            }
            if (!this.aXy) {
                this.gXZ.a(this.mTbPageContext.getPageActivity(), this.gBF.LC(), this.otherParams);
            }
        }
        if (this.gYa == null) {
            this.gYa = new com.baidu.tieba.ala.liveroom.w.c(this.mTbPageContext);
            this.gYa.bm(this.aXy);
        }
        if (z && this.gBF.LC() != null && this.gBF.LC().aEd != null && !this.gYb) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.gYa.a(this.gBF.LC(), this.gBF.LC().aEd.userId);
                this.gYb = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZA() {
        if (this.gXJ) {
            this.gXE.a(this.mSelectedPosition, bZy(), this.aAh);
            this.gXE.b(this.mSelectedPosition, bZz(), this.aAh);
            this.gXJ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.gXL) {
            this.mHandler.removeCallbacks(this.gYo);
            this.mHandler.postDelayed(this.gYo, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (kVar == null) {
            if (!this.gXL) {
                this.mHandler.removeCallbacks(this.gYn);
                this.mHandler.postDelayed(this.gYn, 5000L);
                return;
            }
            return;
        }
        if (!this.gXK) {
            c(kVar);
        }
        if (!this.gXL) {
            this.mHandler.removeCallbacks(this.gYn);
            this.mHandler.postDelayed(this.gYn, kVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZB() {
        if (this.gBF.LC() != null && this.gBF.LC().mLiveInfo != null) {
            this.gBF.f(this.gBF.LC().mLiveInfo.live_id, !this.gXY);
            this.gXY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null && rVar.mLiveInfo.live_status == 2) {
            this.gXE.a(this.mSelectedPosition, this.gBF.LC());
            d(rVar, false);
        } else if (rVar != null) {
            if (!this.gXK) {
                a(rVar);
            }
            if (!this.gXL) {
                this.mHandler.removeCallbacks(this.gFk);
                this.mHandler.postDelayed(this.gFk, rVar.aDI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVh() {
        if (this.mTbPageContext != null && this.gBF.LC() != null && this.gBF.LC().mLiveInfo != null) {
            this.gBF.a(this.gBF.LC().mLiveInfo.live_id, this.bev, this.gCf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(r rVar, boolean z) {
        View view = null;
        lM(true);
        if (!bZK()) {
            this.gBF.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.gXC != null) {
                this.gXC.Qt();
                this.gXC.bXb();
                this.gXC.bXi();
            }
            if (rVar != null && rVar.mLiveInfo != null) {
                this.gXT = rVar.mLiveInfo.live_id;
            }
            bZr();
            bZC();
            bZD();
            if (rVar != null) {
                if (this.gXR != null && this.gXR.bOP() != null) {
                    view = this.gXR.bOP().a(this.gXR.bOF().pageContext.getPageActivity(), rVar, z);
                }
                if (this.gXC != null) {
                    this.gXQ.a(this.gXC, view, rVar, z, this.gBF.bVE());
                }
                if (this.gXR != null) {
                    this.gXR.lM(false);
                    this.gXR.bOK();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.gXC != null) {
                    this.gXC.bXf();
                }
                long j = rVar.mLiveInfo.live_id;
                long j2 = rVar.mLiveInfo.room_id;
                String str = rVar.mLiveInfo.feed_id;
                long j3 = rVar.aDE.userId;
                String str2 = rVar.aDE.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.gXX = new StayTimeBean();
                this.gXX.liveId = rVar.mLiveInfo.live_id;
                this.gXX.roomId = rVar.mLiveInfo.room_id;
                this.gXX.vid = rVar.mLiveInfo.feed_id;
                this.gXX.startTime = System.currentTimeMillis();
            }
            bZM();
            if (this.gXF != null) {
                this.gXF.a(this.aAh, this.gXG);
            }
        }
    }

    private void bZC() {
    }

    private void bZD() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.gXD);
        }
    }

    public void bZE() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bZF();
        } else {
            bZG();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.gBF != null && this.gBF.LC() != null) {
            alaLiveInfoData = this.gBF.LC().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bZF();
        } else {
            bZG();
        }
        this.gXD.setIsScrollable(!z && this.gYh);
        if (this.gXR != null) {
            this.gXR.onKeyboardVisibilityChanged(z);
        }
        if (this.gBZ != null) {
            this.gBZ.onKeyboardVisibilityChanged(z);
        }
    }

    public void dz(int i) {
        if (i == 0) {
            i = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        }
        if (i == 2) {
            bZF();
        } else {
            bZG();
        }
        this.gBZ.dz(i);
        uW(i);
        if (ac.Fe() != null) {
            ac.Fe().EF();
        }
        if (this.gXZ != null) {
            this.gXZ.EF();
        }
        if (this.gXF != null) {
            this.gXF.dz(i);
        }
    }

    public void bZF() {
        if (this.gXD != null) {
            com.baidu.live.utils.h.Y(this.gXD);
        }
    }

    public void bZG() {
        if (this.gXD != null) {
            com.baidu.live.utils.h.Z(this.gXD);
        }
    }

    private boolean bZH() {
        return this.gYq || this.gYr;
    }

    private void bZI() {
        this.gYq = false;
        this.gYr = false;
    }

    public void onResume() {
        Log.d(TAG, "onResume mAppBackground=" + this.gYf + " mWebOver=" + this.gXM + ", isFloatingMode=" + isFloatingMode());
        bZI();
        if (!this.gXM || !isFloatingMode()) {
            bJr();
            if (this.gBF != null) {
                this.gBF.bVo();
                this.gBF.bVs();
            }
            if (this.gXR != null) {
                this.gXR.enterForeground();
            }
            if (this.gXZ != null) {
                this.gXZ.onResume();
            }
            if (this.gYa != null) {
                this.gYa.onResume();
            }
            com.baidu.live.core.layer.b.Cl().onResume();
        }
    }

    public void mR(boolean z) {
        this.gXM = z;
    }

    public void onStart() {
        Log.d(TAG, "onStart mAppBackground=" + this.gYf + " mWebOver=" + this.gXM + ", isFloatingMode=" + isFloatingMode());
        mRef = new WeakReference<>(this);
        bZI();
        if ((!this.gXM || !isFloatingMode()) && !this.gYf) {
            bJr();
            if (this.gXL) {
                this.gXL = false;
                bZJ();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            bZp();
        }
    }

    public void bZJ() {
        bVh();
        bZB();
        this.gBF.bVD();
        if (this.gXH.isPaused()) {
            this.gXH.resume();
        } else if (!this.gXH.isPlaying()) {
            bZq();
        }
        if (this.gXR != null) {
            this.gXR.bOO();
        }
        if (this.gBF != null && this.gBF.LC() != null && this.gBF.LC().mLiveInfo != null) {
            this.gXW.ek(this.gBF.LC().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aAh.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        Log.d(TAG, "onPause mWebOver=" + this.gXM + ", isFloatingMode=" + isFloatingMode());
        if (bZH() || !this.gXM || !isFloatingMode()) {
            if (this.gBF != null) {
                this.gBF.bVp();
                this.gBF.bVt();
            }
            if (this.gXR != null) {
                this.gXR.enterBackground();
            }
            com.baidu.live.core.layer.b.Cl().onPause();
        }
    }

    public void Q(boolean z, boolean z2) {
        Log.d(TAG, "onStop isUserClose=" + this.gYm);
        if (!bZH() && z && !this.gYm && bZk()) {
            if (mRef == null || mRef.get() == this) {
                a(false, new a.InterfaceC0600a() { // from class: com.baidu.tieba.ala.player.b.10
                    @Override // com.baidu.tieba.ala.floating.a.InterfaceC0600a
                    public boolean a(SdkLivePlayer sdkLivePlayer) {
                        if (sdkLivePlayer != null) {
                            sdkLivePlayer.aHX();
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
        this.gXL = true;
        mU(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void mU(boolean z) {
        this.mHandler.removeCallbacks(this.gFk);
        this.mHandler.removeCallbacks(this.gYn);
        this.mHandler.removeCallbacks(this.gYo);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (!this.gXH.isFloatingMode()) {
                this.gXH.aHX();
            }
        } else if (!z && !this.gXH.isFloatingMode()) {
            this.gXH.aHX();
        }
        if (this.gXR != null) {
            this.gXR.bON();
        }
        this.gXW.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ac.Fe() != null) {
                ac.Fe().a(i, i2, intent, this.aAh, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.gXR != null) {
            this.gXR.onActivityResult(i, i2, intent);
        }
    }

    public boolean bZK() {
        return this.gXQ != null && this.gXQ.bJi();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gYD != null) {
            MessageManager.getInstance().unRegisterListener(this.gYD);
        }
        if (this.gYE != null) {
            MessageManager.getInstance().unRegisterListener(this.gYE);
        }
        MessageManager.getInstance().unRegisterListener(this.gYF);
        MessageManager.getInstance().unRegisterListener(this.gDV);
        MessageManager.getInstance().unRegisterListener(this.gYG);
        MessageManager.getInstance().unRegisterListener(this.gYH);
        MessageManager.getInstance().unRegisterListener(this.gYI);
        MessageManager.getInstance().unRegisterListener(this.gYz);
        MessageManager.getInstance().unRegisterListener(this.gow);
        MessageManager.getInstance().unRegisterListener(this.gYs);
        MessageManager.getInstance().unRegisterListener(this.gYt);
        if (this.gYu != null) {
            this.gYu.release();
        }
        if (this.gXH != null && !this.gXH.isFloatingMode()) {
            this.gXH.ch(true);
        }
        if (this.gXF != null) {
            this.gXF.onDestory();
        }
        if (this.gXG != null) {
            this.gXG.reset();
        }
        if (this.gXR != null) {
            this.gXR.onDestroy();
        }
        if (this.gXE != null) {
            this.gXE.onDestroy();
        }
        this.gXC.Qt();
        if (this.gXC != null) {
            this.gXC.release();
            this.gXC = null;
        }
        if (this.gXQ != null) {
            this.gXQ.onDestroy();
        }
        if (this.gXX != null && this.gBF != null && this.gBF.LC() != null) {
            long j = this.gBF.LC().mLiveInfo.live_id;
            if (this.gXX.liveId == j && this.gXX.startTime > 0) {
                this.gXX.endTime = System.currentTimeMillis();
                long j2 = this.gXX.endTime - this.gXX.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.gXX.roomId + "", this.gXX.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.gXX = null;
        }
        if (this.gBZ != null) {
            this.gBZ.bXk();
            this.gBZ = null;
        }
        if (this.gBF != null) {
            this.gBF.destory();
        }
        m.Pl();
        com.baidu.live.entereffect.a.Dg().release();
        t.EQ().release();
        if (this.gYa != null) {
            this.gYa.release();
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String JY() {
        return this.otherParams;
    }

    public void mV(boolean z) {
        this.gYf = z;
    }

    public void bZL() {
        if (this.gXU != null) {
            this.otherParams = this.gXU.toString();
            if (this.gBF != null) {
                this.gBF.setOtherParams(this.otherParams);
            }
            if (this.gXR != null) {
                this.gXR.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.gXQ != null) {
                this.gXQ.setOtherParams(this.otherParams);
            }
        }
    }

    public void bZM() {
        if (this.gXU != null) {
            String optString = this.gXU.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gXU.put("tab", "live_jump");
                        this.gXU.put("tag", "");
                        this.gXU.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.gXU.put("tab", "liveroom");
                        this.gXU.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bZL();
            }
        }
    }

    private void c(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.Ij();
        }
        bVar.ag(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void bZN() {
        v.Fa();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gXR.d(s);
        } else {
            this.gXR.e(s);
        }
    }
}
