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
    private static int gYo = 1;
    private static WeakReference<b> mRef;
    private r aAj;
    private boolean aXA;
    private String bex;
    private long bey;
    private com.baidu.live.p.b brn;
    private d gBJ;
    private boolean gBQ;
    private AlaLiveView gCd;
    private ViewGroup gCe;
    private LayerRootView gCf;
    private long gCj;
    private d.a gCt;
    private int gDD;
    private Runnable gDW;
    private HttpMessageListener gDZ;
    private Runnable gFo;
    private a gXF;
    private AlaLiveRoomBlurPageLayout gXG;
    private AlaLoopViewPager gXH;
    private AlaLoopViewPagerAdapter gXI;
    private com.baidu.tieba.ala.liveroom.e.a gXJ;
    private com.baidu.tieba.ala.liveroom.e.b gXK;
    private SdkLivePlayer gXL;
    private AlaLastLiveroomInfo gXM;
    private boolean gXN;
    private boolean gXO;
    private boolean gXP;
    private boolean gXQ;
    @Deprecated
    private boolean gXR;
    private ArrayList<AlaBroadcastGiftToastData> gXS;
    private String gXT;
    private com.baidu.tieba.ala.endliveroom.a gXU;
    private com.baidu.tieba.ala.liveroom.d.c gXV;
    private String gXW;
    private long gXX;
    private JSONObject gXY;
    private boolean gXZ;
    private boolean gYA;
    private long gYB;
    private long gYC;
    private CustomMessageListener gYD;
    private com.baidu.live.p.a gYE;
    com.baidu.live.liveroom.a.c gYF;
    ViewPager.OnPageChangeListener gYG;
    HttpMessageListener gYH;
    CustomMessageListener gYI;
    CustomMessageListener gYJ;
    CustomMessageListener gYK;
    CustomMessageListener gYL;
    private CustomMessageListener gYM;
    private com.baidu.tieba.ala.liveroom.task.c gYa;
    private StayTimeBean gYb;
    private boolean gYc;
    private com.baidu.tieba.ala.liveroom.k.a gYd;
    private com.baidu.tieba.ala.liveroom.w.c gYe;
    private boolean gYf;
    private boolean gYg;
    private String gYh;
    private boolean gYi;
    private boolean gYj;
    private bf gYk;
    private boolean gYl;
    private boolean gYm;
    private int gYn;
    private boolean gYp;
    private boolean gYq;
    private Runnable gYr;
    private Runnable gYs;
    private Runnable gYt;
    private boolean gYu;
    private boolean gYv;
    private CustomMessageListener gYw;
    private CustomMessageListener gYx;
    private com.baidu.live.y.c gYy;
    private boolean gYz;
    private String gkv;
    CustomMessageListener goA;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    /* JADX INFO: Access modifiers changed from: private */
    public void bZf() {
        if (this.gYe != null) {
            this.gYe.bm(this.aXA);
        }
        if (this.gYd != null) {
            this.gYd.bm(this.aXA);
        }
        if (ac.Fe() != null) {
            ac.Fe().bm(this.aXA);
        }
    }

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.gXN = true;
        this.gCj = 0L;
        this.gXO = false;
        this.gBQ = true;
        this.bex = "";
        this.mForumName = "";
        this.gXP = false;
        this.gXR = false;
        this.gXT = "0";
        this.mHandler = new Handler();
        this.gXX = -1L;
        this.otherParams = "";
        this.gXZ = false;
        this.gYa = com.baidu.tieba.ala.liveroom.task.c.bWC();
        this.gYc = false;
        this.gYg = false;
        this.gYi = false;
        this.gYj = false;
        this.gYm = false;
        this.gYn = 0;
        this.gYp = false;
        this.gYq = false;
        this.gFo = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bVi();
            }
        };
        this.gYr = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.bZC();
            }
        };
        this.gYs = new Runnable() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.gBJ.bVE();
            }
        };
        this.gYt = new Runnable() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.goA = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.player.b.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.gYu = true;
            }
        };
        this.gYw = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.player.b.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.gYv = true;
            }
        };
        this.gYx = new CustomMessageListener(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.player.b.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        this.gDD = 5000;
        this.gYD = new CustomMessageListener(2913224) { // from class: com.baidu.tieba.ala.player.b.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.aXA = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.bZf();
            }
        };
        this.brn = new com.baidu.live.p.b() { // from class: com.baidu.tieba.ala.player.b.25
            @Override // com.baidu.live.p.b
            public void dD(int i) {
                if (b.this.gXG != null) {
                    if (ListUtils.getCount(b.this.gXL.getAlaLiveInfoDataList()) < 2) {
                        b.this.gXG.bXe();
                    } else {
                        b.this.gXG.bXf();
                    }
                }
                if (b.this.gXV != null) {
                    b.this.gXV.dD(i);
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.bZO();
                }
            }
        };
        this.gYE = new com.baidu.live.p.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.live.p.a
            public void cg(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isTieba() && b.this.gXL != null) {
                    if (z) {
                        Log.d(b.TAG, "onFocus playing = " + b.this.gXL.isPlaying());
                        if (!b.this.gXL.isPlaying()) {
                            b.this.gXL.resume();
                            Log.d(b.TAG, "onFocus stopplay");
                        }
                    } else if (b.this.gXL.isPlaying()) {
                        b.this.gXL.pause();
                    }
                }
            }
        };
        this.gYF = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.5
            @Override // com.baidu.live.liveroom.a.c
            public void bY(boolean z) {
                if (z || b.this.gXV == null || b.this.gXV.bON()) {
                    if (!b.this.bZo() || b.this.a(true, (a.InterfaceC0600a) null)) {
                        b.this.gYq = true;
                        b.this.mV(true);
                        b.this.bLW();
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void bZ(boolean z) {
                b.this.d(b.this.aAj, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void o(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.gXL.bZS();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.gXP) {
                    if (b.this.gXP) {
                        b.this.gXL.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.gXL.ai(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.gXH != null) {
                    b.this.gXH.setIsScrollable(b.this.gYl && z);
                    b.this.gXH.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void ca(boolean z) {
                boolean z2 = true;
                if (!z || b.this.bZL()) {
                    if (b.this.gXG != null) {
                        b.this.gXG.bXh();
                        return;
                    }
                    return;
                }
                if (b.this.gBJ.LC().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.gXG != null) {
                    b.this.gXG.mH(z2);
                }
            }
        };
        this.gYG = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.6
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.gCd != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.gXH.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.gBQ || ListUtils.getCount(b.this.gBJ.bVD()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if (!b.this.gBJ.bVI() || i2 >= 0) {
                            if (b.this.gBJ.bVJ() && i2 > 0) {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                b.this.gXH.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                            if (BdLog.isDebugMode()) {
                                BdLog.e("AlaLivePlayer onPageChanged");
                            }
                            b.this.gBJ.cancelLoadData();
                            b.this.mHandler.removeCallbacksAndMessages(null);
                            b.this.lO(true);
                            b.this.gXG.bXc();
                            b.this.gXG.Qt();
                            b.this.gXG.bXd();
                            if (b.this.gBJ.LC() != null) {
                                if (TbadkCoreApplication.getInst().isHaokan()) {
                                    HKStaticManager.staticEndPlayTime(b.this.gBJ.LC().mLiveInfo.live_id + "", b.this.gBJ.LC().mLiveInfo.room_id + "", b.this.gBJ.LC().aDG.userId + "", b.this.gBJ.LC().aDG.userName, System.currentTimeMillis(), b.this.gBJ.LC().mLiveInfo.feed_id, b.this.otherParams);
                                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                    QMStaticManager.staticEndPlayTime(b.this.gBJ.LC().mLiveInfo.live_id + "", b.this.gBJ.LC().mLiveInfo.room_id + "", b.this.gBJ.LC().aDG.userId + "", b.this.gBJ.LC().aDG.userName, System.currentTimeMillis(), b.this.gBJ.LC().mLiveInfo.feed_id, b.this.otherParams);
                                }
                            }
                            if (b.this.gYb != null) {
                                long j = b.this.gBJ.LC().mLiveInfo.live_id;
                                if (b.this.gYb.liveId == j && b.this.gYb.startTime > 0) {
                                    b.this.gYb.endTime = System.currentTimeMillis();
                                    long j2 = b.this.gYb.endTime - b.this.gYb.startTime;
                                    if (j2 < 0) {
                                        j2 = 0;
                                    }
                                    LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.gYb.roomId + "", b.this.gYb.vid, j2 / 1000, b.this.otherParams);
                                }
                                b.this.gYb = null;
                            }
                            b.this.bZN();
                            if (b.this.gYy != null) {
                                b.this.gYy.release();
                            }
                            b.this.mSelectedPosition = i;
                            b.this.gXG = b.this.gXI.ui(b.this.mSelectedPosition);
                            b.this.gXG.bXg();
                            b.this.uX(i2);
                            b.this.bZq();
                            return;
                        }
                        b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                        b.this.gXH.setCurrentItem(b.this.mSelectedPosition);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.gXH.setCurrentItem(b.this.mSelectedPosition);
                        b.this.gBJ.g(b.this.gBJ.bVN());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.AD().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.gCt = new d.a() { // from class: com.baidu.tieba.ala.player.b.7
            @Override // com.baidu.tieba.ala.liveroom.p.d.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.y(b.this.gBJ.LC());
                } else if (i2 == 2) {
                    b.this.f(b.this.gBJ.bIw());
                } else if (i2 == 3) {
                    b.this.aY(i, str);
                } else if (i2 == 4) {
                    b.this.aB(obj);
                } else if (i2 == 5) {
                    b.this.bZB();
                }
            }
        };
        this.gDW = new Runnable() { // from class: com.baidu.tieba.ala.player.b.9
            @Override // java.lang.Runnable
            public void run() {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                    if (b.this.gBJ != null && b.this.gBJ.LC() != null) {
                        m.k(b.this.gBJ.LC().mLiveInfo.user_id, b.this.gBJ.LC().mLiveInfo.live_id);
                    }
                    if (b.this.mHandler != null) {
                        b.this.mHandler.postDelayed(b.this.gDW, b.this.gDD);
                    }
                }
            }
        };
        this.gYH = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bWA() != null && b.this.mTbPageContext != null) {
                        b.this.gYa.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bWA());
                    }
                }
            }
        };
        this.gYI = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.13
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
        this.gYJ = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.gBJ != null && b.this.gBJ.LC() != null && b.this.gBJ.LC().mLiveInfo != null) {
                    long j = b.this.gBJ.LC().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.gYy != null) {
                        b.this.gYy.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.gDZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.gBJ.LC().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.beQ != null && !eventPollingHttpResponseMessage.beQ.isEmpty() && b.this.gBJ != null && b.this.gBJ.LC() != null && b.this.gBJ.LC().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        for (int i = 0; i < eventPollingHttpResponseMessage.beQ.size(); i++) {
                            au auVar = eventPollingHttpResponseMessage.beQ.get(i);
                            if (j == auVar.liveId && j2 - auVar.createTime <= 60 && !m.i(auVar.liveId, auVar.id)) {
                                m.a(auVar, b.this.gBJ.LC().mLiveInfo, false);
                                if (b.this.gXV != null) {
                                    b.this.gXV.a(auVar);
                                }
                                m.j(auVar.liveId, auVar.id);
                            }
                        }
                        au auVar2 = eventPollingHttpResponseMessage.beQ.get(eventPollingHttpResponseMessage.beQ.size() - 1);
                        if (j == auVar2.liveId) {
                            m.h(auVar2.liveId, auVar2.id);
                        }
                    }
                    int i2 = eventPollingHttpResponseMessage.beP;
                    if (i2 <= 0) {
                        i2 = 5;
                    }
                    b.this.gDD = i2 * 1000;
                }
            }
        };
        this.gYK = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.gBJ != null && b.this.gBJ.LC() != null && b.this.gBJ.LC().aEf != null) {
                        if (l.longValue() == b.this.gBJ.LC().aEf.userId) {
                            b.this.gBJ.LC().aEf.isNewUser = false;
                            if (b.this.gYd != null) {
                                b.this.gYd.o(b.this.gBJ.LC());
                            }
                        }
                    }
                }
            }
        };
        this.gYL = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.t.a)) {
                    com.baidu.tieba.ala.liveroom.t.a aVar2 = (com.baidu.tieba.ala.liveroom.t.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String Cv = aVar2.Cv();
                    if (b.this.mTbPageContext != null && b.this.gBJ != null && b.this.gBJ.LC() != null && b.this.gBJ.LC().aEf != null) {
                        if (valueOf.longValue() == b.this.gBJ.LC().aEf.userId && com.baidu.live.w.a.Nk().bkd != null && com.baidu.live.w.a.Nk().bkd.aJy != null && com.baidu.live.w.a.Nk().bkd.aJy.CX()) {
                            g.ub(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, Cv));
                        }
                    }
                }
            }
        };
        this.gYM = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.gFo != null) {
                    b.this.mHandler.removeCallbacks(b.this.gFo);
                }
                b.this.bVi();
            }
        };
        this.gCj = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.gXF = aVar;
        this.gXN = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.y.c.class);
        if (runTask != null) {
            this.gYy = (com.baidu.live.y.c) runTask.getData();
        }
        this.gBJ = new d(getPageContext());
        this.gBJ.a(this.gCt);
        this.gXU = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.gYH);
        MessageManager.getInstance().registerListener(this.gYI);
        MessageManager.getInstance().registerListener(this.gYJ);
        MessageManager.getInstance().registerListener(this.gDZ);
        MessageManager.getInstance().registerListener(this.gYK);
        MessageManager.getInstance().registerListener(this.gYL);
        MessageManager.getInstance().registerListener(this.gYM);
        MessageManager.getInstance().registerListener(this.gYD);
        MessageManager.getInstance().registerListener(this.goA);
        MessageManager.getInstance().registerListener(this.gYw);
        MessageManager.getInstance().registerListener(this.gYx);
    }

    private void R(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.gXS = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.gXS.add(alaBroadcastGiftToastData);
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
        this.bex = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.bex)) {
            this.bex = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.gXW = intent.getStringExtra("room_id");
        this.bey = intent.getLongExtra("live_id", 0L);
        this.gXZ = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.gBJ.b((AlaLiveInfoCoreData) serializableExtra);
            this.gXZ = true;
        }
        T(intent);
        this.gYl = this.gYk == null || !this.gYk.aJO;
        this.gXU.setOtherParams(this.otherParams);
        bZh();
        bZg();
        this.mHandler.removeCallbacks(this.gYt);
        this.mHandler.postDelayed(this.gYt, 1000L);
    }

    private void T(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            this.gYn = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.gkv = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.gXY = new JSONObject(stringExtra);
                if (this.gXY != null) {
                    String optString2 = this.gXY.optString("enterRoomId");
                    String optString3 = this.gXY.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.gXW, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.bey + "", optString3))) {
                        String optString4 = this.gXY.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString5 = this.gXY.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString5);
                        if (!this.gXZ) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.bey;
                            alaLiveInfoCoreData.screenDirection = this.gXY.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.gBJ.b(alaLiveInfoCoreData);
                            this.gXZ = true;
                        }
                    }
                    String optString6 = this.gXY.optString("extra");
                    try {
                        this.gYB = Long.parseLong(this.gXW);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.gYC = this.bey;
                    if (TextUtils.isEmpty(optString6)) {
                        this.gYk = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.gBJ != null) {
                            this.gBJ.FM(optString7);
                        }
                        this.gYz = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE));
                        this.gYA = "1".equals(jSONObject.optString(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING));
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.gkv = jSONObject.optString("live_back_scheme");
                        this.gYk = new bf();
                        this.gYk.aJO = jSONObject.optInt("is_hot") == 1;
                        if (this.gYk.aJO) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.gYn = AlaLiveSwitchData.isHotLive;
                        this.gYk.aJP = jSONObject.optString("task_id");
                        this.gYk.aJN = !TextUtils.isEmpty(this.gYk.aJP);
                        this.gYk.aJQ = jSONObject.optInt("task_type");
                        this.gYk.aJR = jSONObject.optInt("task_im_count");
                        this.gYk.aJS = jSONObject.optLong("task_gift_total_price");
                        this.gYk.aJT = jSONObject.optLong("task_watch_time");
                        this.gYk.aJU = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.gXY.put("from", optString);
                        }
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.gXK = new com.baidu.tieba.ala.liveroom.e.b();
                            this.gXK.setScheme(optString8);
                            this.gXK.setImageUrl(optString9);
                            this.gXK.setTitle(optString10);
                        }
                    }
                    this.gXT = this.gXY.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gXY.remove("cover");
                    this.gXY.remove("live_url");
                    this.gXY.remove("enterRoomId");
                    this.gXY.remove("enterLiveId");
                    this.gXY.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gXY.remove("extra");
                    this.otherParams = this.gXY.toString();
                    if (this.gBJ != null) {
                        this.gBJ.setOtherParams(this.otherParams);
                    }
                    this.gXY.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.gXY.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.gXY.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.gXY.optString("source");
                    }
                    this.gYm = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.gXY.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    if (this.gBJ != null) {
                        this.gBJ.uA(optInt);
                    }
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra(AlaLiveRoomActivityConfig.LAST_LIVE_INFO);
            if (!StringUtils.isNull(stringExtra2)) {
                this.gXM = new AlaLastLiveroomInfo();
                this.gXM.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.bey), String.valueOf(this.gXW), null, bZw());
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

    public void bZg() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.gBJ.ah(this.uk, this.bex, this.mForumName);
        } else if (this.gBJ.LC() != null && this.gBJ.LC().mLiveInfo != null && this.gBJ.LC().mLiveInfo.live_id > 0) {
            this.gBJ.a(this.gBJ.LC().mLiveInfo.live_id, false, this.bex, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.bex = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                mV(false);
                return;
            }
            this.gBJ.ah(this.uk, this.bex, this.mForumName);
        } else if (!TextUtils.isEmpty(this.gXW)) {
            this.gBJ.Gn(this.gXW);
        } else if (this.bey > 0) {
            this.gBJ.a(this.bey, false, this.bex, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            mV(false);
        }
    }

    private void bZh() {
        this.gBQ = true;
        this.gXO = false;
        bZi();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.Cl().m(this.gCf);
        this.gXV = new com.baidu.tieba.ala.liveroom.d.c();
        this.gXV.a(this.gYF);
        this.gXV.setOtherParams(this.otherParams);
        this.gXV.lJ(this.gYm);
        bZk();
        bZj();
    }

    private void bZi() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.gXH = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.gXH.setOnPageChangeListener(this.gYG);
        this.gXH.setBoundaryCaching(true);
        this.gXH.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.gXI = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.gXI.bSW();
        this.gXG = this.gXI.uh(this.mSelectedPosition);
        this.gXI.a(this.mSelectedPosition, this.gBJ.LC());
        this.gXH.setAdapter(this.gXI);
        this.gXH.setCurrentItem(this.mSelectedPosition);
        this.gXH.setIsScrollable(this.gYl);
        this.gCe = (ViewGroup) inflate.findViewById(a.g.func_view);
        this.gCf = (LayerRootView) inflate.findViewById(a.g.layer_root_view);
    }

    private void c(Rect rect) {
        this.gXL = SdkLivePlayer.eR(getPageContext().getPageActivity());
        if (this.gXL == null) {
            this.gXH.setIsScrollable(false);
            if (this.gBJ != null) {
                this.gBJ.cancelLoadData();
            }
            bSZ();
            return;
        }
        this.gXL.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.gXL.setIPlayerCallBack(this.brn);
        this.gXL.setIPlayerAudioFocusCallBack(this.gYE);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gXG.a(this.gXL, layoutParams, true);
    }

    private void bZj() {
        this.gXJ = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.gCe);
    }

    private void bSZ() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.mV(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.gCd = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.gCd.setSwipeClearEnable(true);
        this.gCd.gMa = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gXG.a(this.gCd, layoutParams);
    }

    private void bZk() {
        if (this.gBJ != null && this.gBJ.LC() != null) {
            this.aAj = this.gBJ.LC();
            if (this.aAj.mLiveInfo != null) {
                a(this.aAj.mLiveInfo, this.gXZ);
                if (this.aAj.mLiveInfo != null && this.aAj.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.gXP);
                    }
                    if (!this.gXP) {
                        this.gXL.c(this.aAj.mLiveInfo);
                    } else {
                        this.gXL.setPlayLiveInfo(this.aAj.mLiveInfo);
                    }
                    if (this.gXV != null) {
                        this.gXV.a(this.mTbPageContext, this.gCd, this.gXL, this.gXG, this.gBJ, this.bex, this.gXR, this.gCj, this.gXS, this.gYk);
                        j(this.aAj.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private boolean bZl() {
        boolean z = (this.aAj == null || this.aAj.mLiveInfo == null || this.aAj.mLiveInfo.mAlaLiveSwitchData == null || this.aAj.mLiveInfo.mAlaLiveSwitchData.isSmallWindowPendantUnabled()) ? false : true;
        Log.d(TAG, "isLiveFloatable " + z);
        return z || bZp();
    }

    private long bZm() {
        if (this.aAj == null || this.aAj.mLiveInfo == null) {
            return 0L;
        }
        return this.aAj.mLiveInfo.room_id;
    }

    private long bZn() {
        if (this.aAj == null || this.aAj.mLiveInfo == null) {
            return 0L;
        }
        return this.aAj.mLiveInfo.live_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZo() {
        boolean z = this.gYz && (this.gYB == bZm() || this.gYC == bZn());
        Log.d(TAG, "isCloseToFloatable " + z);
        return z;
    }

    private boolean bZp() {
        boolean z = this.gYA && (this.gYB == bZm() || this.gYC == bZn());
        Log.d(TAG, "isSchemeBackToFloatable " + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bZq() {
        if (gYo <= 0) {
            return false;
        }
        if (!(bZo() || bZl()) || FloatPermissionUtil.Lo()) {
            return false;
        }
        gYo--;
        FloatPermissionUtil.ah(getPageContext().getPageActivity());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, a.InterfaceC0600a interfaceC0600a) {
        if (!FloatPermissionUtil.Lo()) {
            if (this.gYp) {
                return true;
            }
            this.gYp = true;
            if (z) {
                FloatPermissionUtil.ah(getPageContext().getPageActivity());
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FROM_FLOATING, "1");
            if (bZo()) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_FLOATING_ABLE, "1");
            }
            if (this.gYA) {
                jSONObject.put(AlaLiveRoomActivityConfig.SDK_EXTRA_BACK_FLOATING, "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.floating.a eM = com.baidu.tieba.ala.floating.b.eM(getPageContext().getPageActivity());
        eM.a(interfaceC0600a);
        eM.dj(jSONObject);
        com.baidu.tieba.ala.floating.b.eM(getPageContext().getPageActivity()).a(this.gXL, this.gBJ.LC(), this.bex, this.gCj);
        return true;
    }

    private void bJs() {
        com.baidu.tieba.ala.floating.b.b(new a.InterfaceC0600a() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // com.baidu.tieba.ala.floating.a.InterfaceC0600a
            public boolean a(SdkLivePlayer sdkLivePlayer) {
                if (b.this.gXL != null) {
                    b.this.bZr();
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZr() {
        ArrayList arrayList = (ArrayList) this.gXL.getAlaLiveInfoDataList();
        if (!ListUtils.isEmpty(arrayList)) {
            ArrayList<AlaLiveInfoData> arrayList2 = new ArrayList<>(arrayList);
            this.gXL.bZS();
            this.gXL.ai(arrayList2);
        }
    }

    private boolean isFloatingMode() {
        return com.baidu.tieba.ala.floating.b.bJq();
    }

    private void bZs() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.gYl) {
                this.gXH.setIsScrollable(true);
            } else {
                this.gXH.setIsScrollable(false);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.Cl().onBackPressed() && ((this.gXV == null || !this.gXV.onKeyDown(i, keyEvent)) && (this.gXV == null || !this.gXV.bOM()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bZs();
            } else if ((this.gXV == null || this.gXV.bON()) && (!bZo() || a(true, (a.InterfaceC0600a) null))) {
                this.gYq = true;
                mV(true);
                bLW();
            }
        }
        return true;
    }

    public void bLW() {
        if (!TextUtils.isEmpty(this.gkv)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gkv);
                this.gkv = null;
            }
        }
    }

    public void mV(boolean z) {
        P(z, false);
    }

    public void P(boolean z, boolean z2) {
        lO(!z);
        if (this.gXL != null && !this.gXL.isFloatingMode()) {
            this.gXL.destroy();
        }
        com.baidu.live.core.layer.b.Cl().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        bZu();
        long j = -1;
        if (this.gBJ != null && this.gBJ.bVN() != null) {
            j = this.gBJ.bVN().room_id;
        }
        this.gXF.a(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void lO(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.gXM = null;
        if (ac.Fe() != null) {
            ac.Fe().Fd();
        }
        com.baidu.live.core.layer.b.Cl().Cm();
        if (this.gYy != null) {
            this.gYy.release();
        }
        if (this.gYd != null) {
            this.gYd.release();
        }
        this.gYk = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.gBJ != null) {
            try {
                this.gBJ.FM(null);
                AlaLiveInfoData bVN = this.gBJ.bVN();
                if (bVN != null) {
                    this.gBJ.ei(bVN.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.gYa.stopRecord();
        LiveTimerManager.getInstance().stop();
        bZt();
        if (this.gXL != null && !this.gXL.isFloatingMode()) {
            this.gXL.ch(z);
        }
        if (this.gXV != null) {
            this.gXV.lO(z);
        }
        this.gYc = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.KT().bdQ != null && this.aAj != null) {
            com.baidu.live.liveroom.a.b.KT().bdQ.b(this.aAj.mLiveInfo);
        }
    }

    private void bZt() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bZu() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(r rVar) {
        if (rVar != null) {
            this.aAj = rVar;
            if (this.gXV != null) {
                this.gXV.a(rVar);
            }
            bZq();
        }
    }

    private void c(k kVar) {
        if (this.gXV != null) {
            this.gXV.c(kVar);
        }
    }

    private void B(r rVar) {
        this.aAj = rVar;
        bZq();
    }

    private void bZv() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null) {
            this.gYl = TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled() ? false : true;
        } else {
            this.gYl = true;
        }
        this.gXH.setIsScrollable(this.gYl);
        this.gYn = AlaLiveSwitchData.isHotLive;
        if (this.aAj != null) {
            a(this.aAj.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.gXG.a(this.gCd, null);
            if (!isFloatingMode()) {
                a(this.gXG, this.aAj.mLiveInfo, this.gBQ);
            }
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aAj.mLiveInfo.live_id), String.valueOf(this.aAj.mLiveInfo.room_id), String.valueOf(this.aAj.mLiveInfo.feed_id), bZw());
            if (com.baidu.live.liveroom.a.b.KT().bdQ != null) {
                com.baidu.live.liveroom.a.b.KT().bdQ.a(this.aAj.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.gBQ = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.gBJ != null && this.gBJ.LC() != null && this.gBJ.LC().mLiveInfo != null) {
                    j = this.gBJ.LC().mLiveInfo.live_id;
                    str2 = this.gBJ.LC().mLiveInfo.room_id + "";
                    str = this.gBJ.LC().mLiveInfo.feed_id;
                } else {
                    if (this.bey > 0) {
                        j2 = this.bey;
                    }
                    if (!TextUtils.isEmpty(this.gXW)) {
                        j = j2;
                        str = "";
                        str2 = this.gXW;
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
                if (this.gBJ != null && this.gBJ.LC() != null && this.gBJ.LC().mLiveInfo != null) {
                    str3 = this.gBJ.LC().mLiveInfo.feed_id;
                    str4 = this.gBJ.LC().mLiveInfo.live_id + "";
                    str5 = this.gBJ.LC().mLiveInfo.room_id + "";
                    str6 = this.gBJ.LC().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
            bZq();
        }
    }

    private String bZw() {
        if (this.gXY == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.gXY.optString("source");
            String optString2 = this.gXY.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gXY.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.gXY.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.gXY.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (isFloatingMode()) {
            bJs();
        } else if (this.gXL != null && this.gXL.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.gXL.getVideoPath();
                String d = h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.gXL.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (h.aE(videoPath, d)) {
                    this.gXL.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && h.aD(videoPath, d)) {
                    this.gXL.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.bS(this.gXL)) {
                        ((ViewGroup) this.gXL.getParent()).removeView(this.gXL);
                        alaLiveRoomBlurPageLayout.a(this.gXL, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.gXP) {
                        this.gXL.c(alaLiveInfoData);
                        return;
                    } else {
                        this.gXL.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.gXL.bZS();
        } else if (this.gXL != null && this.gXL.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.gXL, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.gXP) {
                    this.gXL.c(alaLiveInfoData);
                } else {
                    this.gXL.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.gXL != null) {
            this.gXL.setLayoutParams(b);
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

    public void bZx() {
        this.gBQ = true;
    }

    public boolean bZy() {
        return this.gBQ;
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
                this.gXG.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.gXG.setBackgroundColor(0);
            }
        } else {
            this.gXG.setBackgroundColor(0);
        }
        int i3 = this.gXL.getLayoutParams().width;
        int i4 = this.gXL.getLayoutParams().height;
        int i5 = this.gXL.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.gXL.getLayoutParams()).topMargin : 0;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i3 || b.height != i4 || b.topMargin != i5) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.gCd != null) {
            this.gCd.setLayoutParams(c);
        }
        if (this.gXG != null) {
            this.gXG.D(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gXU != null) {
            this.gXU.D(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gXV != null) {
            this.gXV.l(c.width, c.height, realScreenOrientation);
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
        if (this.aAj != null && this.aAj.mLiveInfo != null) {
            this.gXG.setBgImageUrl(this.aAj.mLiveInfo.cover, this.aAj.mLiveInfo);
            this.gXI.a(this.mSelectedPosition, bZz(), this.aAj);
            this.gXI.b(this.mSelectedPosition, bZA(), this.aAj);
            this.gXG.requestLayout();
            this.gXG.K(i, this.aAj.mLiveInfo.screen_direction == 2);
        }
        if (this.aAj != null) {
            a(i, this.aAj.mLiveInfo, false);
        }
        boolean bXi = this.gXG.bXi();
        boolean z2 = i == 1;
        if (this.aAj == null || this.aAj.mLiveInfo == null || this.aAj.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!bZL()) {
            if (this.gXL != null && this.gXL.getParent() == null) {
                this.gXG.a(this.gXL, null, false);
                if (this.aAj != null && this.aAj.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.gXP) {
                        this.gXL.c(this.aAj.mLiveInfo);
                    } else {
                        this.gXL.setPlayLiveInfo(this.aAj.mLiveInfo);
                    }
                }
            }
            if (bXi && !bZL() && this.gXV != null) {
                this.gXG.mH(z);
                return;
            }
            return;
        }
        this.gXG.bXc();
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
            this.gBJ.a(alaLiveInfoData.live_id, true, this.bex, this.mForumName, this.gYn);
        }
    }

    public void uX(int i) {
        if (i < 0) {
            this.gBJ.uB(this.gBJ.bVK() - 1);
        } else if (i > 0) {
            this.gBJ.uB(this.gBJ.bVK() + 1);
        }
        if (this.gXV != null) {
            this.gXV.a(this.gXG);
        }
        this.gXI.a(this.mSelectedPosition, bZz(), this.aAj);
        this.gXI.b(this.mSelectedPosition, bZA(), this.aAj);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.gBJ != null) {
            int bVK = this.gBJ.bVK();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bVK + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.gBJ.bVD() != null && this.gBJ.bVD().size() > bVK && this.gBJ.bVD().get(bVK) != null) {
                AlaLiveInfoData alaLiveInfoData = this.gBJ.bVD().get(bVK);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gBJ != null) {
            AlaLiveInfoData bVN = this.gBJ.bVN();
            if (bVN != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(bVN.live_id), String.valueOf(bVN.room_id), null, bZw());
                bVN.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.gXG, bVN, this.gBQ);
                this.gBQ = false;
                if (this.gXV != null) {
                    this.gXV.a(this.mTbPageContext, this.gCd, this.gXL, this.gXG, this.gBJ, this.bex, this.gXR, this.gCj, null, this.gYk);
                    short s = 2;
                    if (bVN.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bVN, false);
            }
            i(bVN);
            this.gXG.a(this.gCd, null);
            if (this.gXV != null) {
                this.gXV.bOK();
            }
            this.gBJ.g(bVN);
        }
    }

    private AlaLiveInfoData bZz() {
        List<AlaLiveInfoData> bVD = this.gBJ.bVD();
        if (bVD == null || bVD.size() == 0) {
            if (this.aAj == null) {
                return null;
            }
            return this.aAj.mLiveInfo;
        }
        int bVK = this.gBJ.bVK();
        int size = bVD.size();
        return bVD.get(((bVK + size) - 1) % size);
    }

    private AlaLiveInfoData bZA() {
        List<AlaLiveInfoData> bVD = this.gBJ.bVD();
        if (bVD == null || bVD.size() == 0) {
            if (this.aAj == null) {
                return null;
            }
            return this.aAj.mLiveInfo;
        }
        return bVD.get((this.gBJ.bVK() + 1) % bVD.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, String str) {
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.gXP) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.i.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            mV(false);
            return;
        }
        r LC = this.gBJ.LC();
        B(LC);
        this.gBJ.bVE();
        if (this.gBQ) {
            this.gBJ.mA(false);
        }
        this.gCj = System.currentTimeMillis() / 1000;
        if (this.gXV != null) {
            this.gXV.a(this.mTbPageContext, this.gCd, this.gXL, this.gXG, this.gBJ, this.bex, this.gXR, this.gCj, this.gXS, this.gYk);
            short s = 2;
            if (LC.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bZv();
        if (LC != null && LC.mLiveInfo != null && LC.mLiveInfo.live_status == 2) {
            this.gXI.a(this.mSelectedPosition, this.gBJ.LC());
            d(LC, false);
            this.gBQ = false;
            return;
        }
        boolean z = (this.gXV == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.gYg || !TextUtils.equals(p.Pq(), this.gYh))) {
            v.b(getPageContext(), false);
            com.baidu.live.w.c.Np().Nq();
            this.gYg = true;
            this.gYh = p.Pq();
        }
        if (!this.gYi) {
            this.gYi = true;
            com.baidu.live.entereffect.a.Dg().bh(false);
        }
        if (this.gBJ.LC() != null && this.gBJ.LC().mLiveInfo != null) {
            this.gBJ.f(this.gBJ.LC().mLiveInfo.live_id, !this.gYc);
            this.gYc = true;
        }
        if (this.gXV != null) {
            this.gXV.b(this.gXM);
            this.gXV.lN(TextUtils.equals(this.gXT, "1"));
            this.gXT = "";
        }
        if (z && this.gBJ.LC() != null && this.gBJ.LC().mLiveInfo != null) {
            String str2 = this.gBJ.LC().mLiveInfo.feed_id;
            long j = this.gBJ.LC().mLiveInfo.live_id;
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                this.mHandler.post(this.gDW);
            }
        }
        if (this.gXJ != null) {
            this.gXJ.a(this.aAj, this.gXK);
        }
        a(this.gBJ.LC());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.8
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.gBJ.LC() != null && b.this.gBJ.LC().mLiveInfo != null) {
                    b.this.gBJ.a(b.this.gBJ.LC().mLiveInfo.live_id, b.this.bex, b.this.gCj);
                }
            }
        });
        if (z && this.gBJ.LC() != null && this.gBJ.LC().aDG != null) {
            be beVar = com.baidu.live.w.a.Nk().bkd;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && beVar != null && beVar.aJD != null && beVar.aJD.aLr) {
                c(true, this.gBJ.LC().aDG.userId);
            }
        }
        this.gBQ = false;
        if (z && this.gBJ.LC() != null && this.gBJ.LC().mLiveInfo != null && this.gBJ.LC().aDG != null && this.gXV != null) {
            long j2 = this.gBJ.LC().mLiveInfo.live_id;
            long j3 = this.gBJ.LC().mLiveInfo.room_id;
            String str3 = this.gBJ.LC().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j2;
                if (ac.Fe() != null) {
                    ac.Fe().bm(this.aXA);
                    if (!this.aXA) {
                        ac.Fe().a(this.mTbPageContext.getPageActivity(), j2, str4, j3, str3, this.otherParams);
                    }
                }
                if (this.gYy != null) {
                    this.gYy.b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
                }
            }
            if (e.Il() != null) {
                e.Il().b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
            }
            if (this.gYd == null) {
                this.gYd = new com.baidu.tieba.ala.liveroom.k.a();
                this.gYd.bm(this.aXA);
            }
            if (!this.aXA) {
                this.gYd.a(this.mTbPageContext.getPageActivity(), this.gBJ.LC(), this.otherParams);
            }
        }
        if (this.gYe == null) {
            this.gYe = new com.baidu.tieba.ala.liveroom.w.c(this.mTbPageContext);
            this.gYe.bm(this.aXA);
        }
        if (z && this.gBJ.LC() != null && this.gBJ.LC().aEf != null && !this.gYf) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.gYe.a(this.gBJ.LC(), this.gBJ.LC().aEf.userId);
                this.gYf = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZB() {
        if (this.gXN) {
            this.gXI.a(this.mSelectedPosition, bZz(), this.aAj);
            this.gXI.b(this.mSelectedPosition, bZA(), this.aAj);
            this.gXN = false;
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
        if (!this.gXP) {
            this.mHandler.removeCallbacks(this.gYs);
            this.mHandler.postDelayed(this.gYs, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (kVar == null) {
            if (!this.gXP) {
                this.mHandler.removeCallbacks(this.gYr);
                this.mHandler.postDelayed(this.gYr, 5000L);
                return;
            }
            return;
        }
        if (!this.gXO) {
            c(kVar);
        }
        if (!this.gXP) {
            this.mHandler.removeCallbacks(this.gYr);
            this.mHandler.postDelayed(this.gYr, kVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZC() {
        if (this.gBJ.LC() != null && this.gBJ.LC().mLiveInfo != null) {
            this.gBJ.f(this.gBJ.LC().mLiveInfo.live_id, !this.gYc);
            this.gYc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null && rVar.mLiveInfo.live_status == 2) {
            this.gXI.a(this.mSelectedPosition, this.gBJ.LC());
            d(rVar, false);
        } else if (rVar != null) {
            if (!this.gXO) {
                a(rVar);
            }
            if (!this.gXP) {
                this.mHandler.removeCallbacks(this.gFo);
                this.mHandler.postDelayed(this.gFo, rVar.aDK);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVi() {
        if (this.mTbPageContext != null && this.gBJ.LC() != null && this.gBJ.LC().mLiveInfo != null) {
            this.gBJ.a(this.gBJ.LC().mLiveInfo.live_id, this.bex, this.gCj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(r rVar, boolean z) {
        View view = null;
        lO(true);
        if (!bZL()) {
            this.gBJ.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.gXG != null) {
                this.gXG.Qt();
                this.gXG.bXc();
                this.gXG.bXj();
            }
            if (rVar != null && rVar.mLiveInfo != null) {
                this.gXX = rVar.mLiveInfo.live_id;
            }
            bZs();
            bZD();
            bZE();
            if (rVar != null) {
                if (this.gXV != null && this.gXV.bOQ() != null) {
                    view = this.gXV.bOQ().a(this.gXV.bOG().pageContext.getPageActivity(), rVar, z);
                }
                if (this.gXG != null) {
                    this.gXU.a(this.gXG, view, rVar, z, this.gBJ.bVF());
                }
                if (this.gXV != null) {
                    this.gXV.lO(false);
                    this.gXV.bOL();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.gXG != null) {
                    this.gXG.bXg();
                }
                long j = rVar.mLiveInfo.live_id;
                long j2 = rVar.mLiveInfo.room_id;
                String str = rVar.mLiveInfo.feed_id;
                long j3 = rVar.aDG.userId;
                String str2 = rVar.aDG.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.gYb = new StayTimeBean();
                this.gYb.liveId = rVar.mLiveInfo.live_id;
                this.gYb.roomId = rVar.mLiveInfo.room_id;
                this.gYb.vid = rVar.mLiveInfo.feed_id;
                this.gYb.startTime = System.currentTimeMillis();
            }
            bZN();
            if (this.gXJ != null) {
                this.gXJ.a(this.aAj, this.gXK);
            }
        }
    }

    private void bZD() {
    }

    private void bZE() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.gXH);
        }
    }

    public void bZF() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bZG();
        } else {
            bZH();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.gBJ != null && this.gBJ.LC() != null) {
            alaLiveInfoData = this.gBJ.LC().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bZG();
        } else {
            bZH();
        }
        this.gXH.setIsScrollable(!z && this.gYl);
        if (this.gXV != null) {
            this.gXV.onKeyboardVisibilityChanged(z);
        }
        if (this.gCd != null) {
            this.gCd.onKeyboardVisibilityChanged(z);
        }
    }

    public void dz(int i) {
        if (i == 0) {
            i = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        }
        if (i == 2) {
            bZG();
        } else {
            bZH();
        }
        this.gCd.dz(i);
        uW(i);
        if (ac.Fe() != null) {
            ac.Fe().EF();
        }
        if (this.gYd != null) {
            this.gYd.EF();
        }
        if (this.gXJ != null) {
            this.gXJ.dz(i);
        }
    }

    public void bZG() {
        if (this.gXH != null) {
            com.baidu.live.utils.h.Y(this.gXH);
        }
    }

    public void bZH() {
        if (this.gXH != null) {
            com.baidu.live.utils.h.Z(this.gXH);
        }
    }

    private boolean bZI() {
        return this.gYu || this.gYv;
    }

    private void bZJ() {
        this.gYu = false;
        this.gYv = false;
    }

    public void onResume() {
        bZJ();
        if (!this.gXQ || !isFloatingMode()) {
            bJs();
            if (this.gBJ != null) {
                this.gBJ.bVp();
                this.gBJ.bVt();
            }
            if (this.gXV != null) {
                this.gXV.enterForeground();
            }
            if (this.gYd != null) {
                this.gYd.onResume();
            }
            if (this.gYe != null) {
                this.gYe.onResume();
            }
            com.baidu.live.core.layer.b.Cl().onResume();
        }
    }

    public void mT(boolean z) {
        this.gXQ = z;
    }

    public void onStart() {
        mRef = new WeakReference<>(this);
        bZJ();
        if ((!this.gXQ || !isFloatingMode()) && !this.gYj) {
            bJs();
            if (this.gXP) {
                this.gXP = false;
                bZK();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
            bZq();
        }
    }

    public void bZK() {
        bVi();
        bZC();
        this.gBJ.bVE();
        if (this.gXL.isPaused()) {
            this.gXL.resume();
        } else if (!this.gXL.isPlaying()) {
            bZr();
        }
        if (this.gXV != null) {
            this.gXV.bOP();
        }
        if (this.gBJ != null && this.gBJ.LC() != null && this.gBJ.LC().mLiveInfo != null) {
            this.gYa.ek(this.gBJ.LC().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aAj.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (bZI() || !this.gXQ || !isFloatingMode()) {
            if (this.gBJ != null) {
                this.gBJ.bVq();
                this.gBJ.bVu();
            }
            if (this.gXV != null) {
                this.gXV.enterBackground();
            }
            com.baidu.live.core.layer.b.Cl().onPause();
        }
    }

    public void Q(boolean z, boolean z2) {
        if (!bZI() && z && !this.gYq && bZl()) {
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
        this.gXP = true;
        mW(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void mW(boolean z) {
        this.mHandler.removeCallbacks(this.gFo);
        this.mHandler.removeCallbacks(this.gYr);
        this.mHandler.removeCallbacks(this.gYs);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            if (!this.gXL.isFloatingMode()) {
                this.gXL.aHX();
            }
        } else if (!z && !this.gXL.isFloatingMode()) {
            this.gXL.aHX();
        }
        if (this.gXV != null) {
            this.gXV.bOO();
        }
        this.gYa.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ac.Fe() != null) {
                ac.Fe().a(i, i2, intent, this.aAj, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.gXV != null) {
            this.gXV.onActivityResult(i, i2, intent);
        }
    }

    public boolean bZL() {
        return this.gXU != null && this.gXU.bJj();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gYH != null) {
            MessageManager.getInstance().unRegisterListener(this.gYH);
        }
        if (this.gYI != null) {
            MessageManager.getInstance().unRegisterListener(this.gYI);
        }
        MessageManager.getInstance().unRegisterListener(this.gYJ);
        MessageManager.getInstance().unRegisterListener(this.gDZ);
        MessageManager.getInstance().unRegisterListener(this.gYK);
        MessageManager.getInstance().unRegisterListener(this.gYL);
        MessageManager.getInstance().unRegisterListener(this.gYM);
        MessageManager.getInstance().unRegisterListener(this.gYD);
        MessageManager.getInstance().unRegisterListener(this.goA);
        MessageManager.getInstance().unRegisterListener(this.gYw);
        MessageManager.getInstance().unRegisterListener(this.gYx);
        if (this.gYy != null) {
            this.gYy.release();
        }
        if (this.gXL != null && !this.gXL.isFloatingMode()) {
            this.gXL.ch(true);
        }
        if (this.gXJ != null) {
            this.gXJ.onDestory();
        }
        if (this.gXK != null) {
            this.gXK.reset();
        }
        if (this.gXV != null) {
            this.gXV.onDestroy();
        }
        if (this.gXI != null) {
            this.gXI.onDestroy();
        }
        this.gXG.Qt();
        if (this.gXG != null) {
            this.gXG.release();
            this.gXG = null;
        }
        if (this.gXU != null) {
            this.gXU.onDestroy();
        }
        if (this.gYb != null && this.gBJ != null && this.gBJ.LC() != null) {
            long j = this.gBJ.LC().mLiveInfo.live_id;
            if (this.gYb.liveId == j && this.gYb.startTime > 0) {
                this.gYb.endTime = System.currentTimeMillis();
                long j2 = this.gYb.endTime - this.gYb.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.gYb.roomId + "", this.gYb.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.gYb = null;
        }
        if (this.gCd != null) {
            this.gCd.bXl();
            this.gCd = null;
        }
        if (this.gBJ != null) {
            this.gBJ.destory();
        }
        m.Pl();
        com.baidu.live.entereffect.a.Dg().release();
        t.EQ().release();
        if (this.gYe != null) {
            this.gYe.release();
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String JY() {
        return this.otherParams;
    }

    public void mX(boolean z) {
        this.gYj = z;
    }

    public void bZM() {
        if (this.gXY != null) {
            this.otherParams = this.gXY.toString();
            if (this.gBJ != null) {
                this.gBJ.setOtherParams(this.otherParams);
            }
            if (this.gXV != null) {
                this.gXV.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.gXU != null) {
                this.gXU.setOtherParams(this.otherParams);
            }
        }
    }

    public void bZN() {
        if (this.gXY != null) {
            String optString = this.gXY.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gXY.put("tab", "live_jump");
                        this.gXY.put("tag", "");
                        this.gXY.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.gXY.put("tab", "liveroom");
                        this.gXY.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bZM();
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

    public void bZO() {
        v.Fa();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gXV.d(s);
        } else {
            this.gXV.e(s);
        }
    }
}
