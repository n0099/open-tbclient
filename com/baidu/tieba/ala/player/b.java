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
import com.baidu.live.data.as;
import com.baidu.live.data.bc;
import com.baidu.live.data.bd;
import com.baidu.live.data.k;
import com.baidu.live.data.q;
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
import com.baidu.tieba.ala.liveroom.j.g;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.ala.liveroom.o.c;
import com.baidu.tieba.ala.liveroom.task.ActivityTaskWatchHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.compatible.menukey.MenuKeyUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends BdBaseView<TbPageContext> {
    private String aZb;
    private long aZc;
    private q avf;
    private com.baidu.live.p.b blE;
    private String fYt;
    private a gKZ;
    private String gLA;
    private boolean gLB;
    private boolean gLC;
    private bd gLD;
    private boolean gLE;
    private boolean gLF;
    private Runnable gLG;
    private Runnable gLH;
    private Runnable gLI;
    private Runnable gLJ;
    private com.baidu.live.x.c gLK;
    private com.baidu.live.p.a gLL;
    com.baidu.live.liveroom.a.c gLM;
    ViewPager.OnPageChangeListener gLN;
    HttpMessageListener gLO;
    CustomMessageListener gLP;
    CustomMessageListener gLQ;
    CustomMessageListener gLR;
    CustomMessageListener gLS;
    private CustomMessageListener gLT;
    private AlaLiveRoomBlurPageLayout gLa;
    private AlaLoopViewPager gLb;
    private AlaLoopViewPagerAdapter gLc;
    private com.baidu.tieba.ala.liveroom.e.a gLd;
    private com.baidu.tieba.ala.liveroom.e.b gLe;
    private SdkLivePlayer gLf;
    private AlaLastLiveroomInfo gLg;
    private boolean gLh;
    private boolean gLi;
    private boolean gLj;
    private boolean gLk;
    private ArrayList<AlaBroadcastGiftToastData> gLl;
    private String gLm;
    private com.baidu.tieba.ala.endliveroom.a gLn;
    private com.baidu.tieba.ala.liveroom.d.c gLo;
    private String gLp;
    private long gLq;
    private JSONObject gLr;
    private boolean gLs;
    private com.baidu.tieba.ala.liveroom.task.c gLt;
    private StayTimeBean gLu;
    private boolean gLv;
    private com.baidu.tieba.ala.liveroom.k.a gLw;
    private com.baidu.tieba.ala.liveroom.v.c gLx;
    private boolean gLy;
    private boolean gLz;
    private com.baidu.tieba.ala.liveroom.o.c goP;
    private boolean goW;
    private AlaLiveView gpi;
    private ViewGroup gpj;
    private LayerRootView gpk;
    private long gpo;
    private c.a gpy;
    private int gqG;
    private Runnable gqY;
    private HttpMessageListener grb;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.gLh = true;
        this.gpo = 0L;
        this.gLi = false;
        this.goW = true;
        this.aZb = "";
        this.mForumName = "";
        this.gLj = false;
        this.gLk = false;
        this.gLm = "0";
        this.mHandler = new Handler();
        this.gLq = -1L;
        this.otherParams = "";
        this.gLs = false;
        this.gLt = com.baidu.tieba.ala.liveroom.task.c.bME();
        this.gLv = false;
        this.gLz = false;
        this.gLB = false;
        this.gLC = false;
        this.gLF = false;
        this.gLG = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bPu();
            }
        };
        this.gLH = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.bPt();
            }
        };
        this.gLI = new Runnable() { // from class: com.baidu.tieba.ala.player.b.13
            @Override // java.lang.Runnable
            public void run() {
                b.this.goP.bLz();
            }
        };
        this.gLJ = new Runnable() { // from class: com.baidu.tieba.ala.player.b.14
            @Override // java.lang.Runnable
            public void run() {
                UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
            }
        };
        this.gqG = 5000;
        this.blE = new com.baidu.live.p.b() { // from class: com.baidu.tieba.ala.player.b.15
            @Override // com.baidu.live.p.b
            public void bR(int i) {
                if (b.this.gLa != null) {
                    if (ListUtils.getCount(b.this.gLf.getAlaLiveInfoDataList()) < 2) {
                        b.this.gLa.bNd();
                    } else {
                        b.this.gLa.bNe();
                    }
                }
                if (b.this.gLo != null) {
                    b.this.gLo.bR(i);
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.bPE();
                }
            }
        };
        this.gLL = new com.baidu.live.p.a() { // from class: com.baidu.tieba.ala.player.b.16
            @Override // com.baidu.live.p.a
            public void bY(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && b.this.gLf != null) {
                    if (z) {
                        if (!b.this.gLf.isPlaying()) {
                            b.this.gLf.bPG();
                        }
                    } else if (b.this.gLf.isPlaying()) {
                        b.this.gLf.azN();
                    }
                }
            }
        };
        this.gLM = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.18
            @Override // com.baidu.live.liveroom.a.c
            public void bR(boolean z) {
                if (z || b.this.gLo == null || b.this.gLo.bFk()) {
                    b.this.mp(true);
                    b.this.bCB();
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void bS(boolean z) {
                b.this.d(b.this.avf, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.gLf.bPF();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.gLj) {
                    if (b.this.gLj) {
                        b.this.gLf.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.gLf.ac(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.gLb != null) {
                    b.this.gLb.setIsScrollable(b.this.gLE && z);
                    b.this.gLb.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void bT(boolean z) {
                boolean z2 = true;
                if (!z || b.this.bPB()) {
                    if (b.this.gLa != null) {
                        b.this.gLa.bNg();
                        return;
                    }
                    return;
                }
                if (b.this.goP.FO().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.gLa != null) {
                    b.this.gLa.md(z2);
                }
            }
        };
        this.gLN = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.gpi != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.gLb.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.goW || ListUtils.getCount(b.this.goP.bLy()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && b.this.goP.bLB() == 1) {
                            if (!b.this.goP.bLE() || i2 >= 0) {
                                if (b.this.goP.bLF() && i2 > 0) {
                                    b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    b.this.gLb.setCurrentItem(b.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                b.this.gLb.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        b.this.goP.cancelLoadData();
                        b.this.mHandler.removeCallbacksAndMessages(null);
                        b.this.ll(true);
                        b.this.gLa.bNb();
                        b.this.gLa.KB();
                        b.this.gLa.bNc();
                        if (b.this.goP.FO() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(b.this.goP.FO().mLiveInfo.live_id + "", b.this.goP.FO().mLiveInfo.room_id + "", b.this.goP.FO().ayC.userId + "", b.this.goP.FO().ayC.userName, System.currentTimeMillis(), b.this.goP.FO().mLiveInfo.feed_id, b.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(b.this.goP.FO().mLiveInfo.live_id + "", b.this.goP.FO().mLiveInfo.room_id + "", b.this.goP.FO().ayC.userId + "", b.this.goP.FO().ayC.userName, System.currentTimeMillis(), b.this.goP.FO().mLiveInfo.feed_id, b.this.otherParams);
                            }
                        }
                        if (b.this.gLu != null) {
                            long j = b.this.goP.FO().mLiveInfo.live_id;
                            if (b.this.gLu.liveId == j && b.this.gLu.startTime > 0) {
                                b.this.gLu.endTime = System.currentTimeMillis();
                                long j2 = b.this.gLu.endTime - b.this.gLu.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.gLu.roomId + "", b.this.gLu.vid, j2 / 1000, b.this.otherParams);
                            }
                            b.this.gLu = null;
                        }
                        b.this.bPD();
                        if (b.this.gLK != null) {
                            b.this.gLK.release();
                        }
                        b.this.mSelectedPosition = i;
                        b.this.gLa = b.this.gLc.rS(b.this.mSelectedPosition);
                        b.this.gLa.bNf();
                        b.this.sJ(i2);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.gLb.setCurrentItem(b.this.mSelectedPosition);
                        b.this.goP.g(b.this.goP.bLJ());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.vf().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.gpy = new c.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.o.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.A(b.this.goP.FO());
                } else if (i2 == 2) {
                    b.this.f(b.this.goP.bzs());
                } else if (i2 == 3) {
                    b.this.bb(i, str);
                } else if (i2 == 4) {
                    b.this.az(obj);
                } else if (i2 == 5) {
                    b.this.bPs();
                }
            }
        };
        this.gqY = new Runnable() { // from class: com.baidu.tieba.ala.player.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                    if (b.this.goP != null && b.this.goP.FO() != null) {
                        Log.i("eventpolling", "@@@ polling run live_id=" + b.this.goP.FO().mLiveInfo.live_id + ", hd=" + b.this.mHandler + ",vc=" + b.this);
                        m.k(b.this.goP.FO().mLiveInfo.user_id, b.this.goP.FO().mLiveInfo.live_id);
                    }
                    if (b.this.mHandler != null) {
                        b.this.mHandler.postDelayed(b.this.gqY, b.this.gqG);
                    }
                }
            }
        };
        this.gLO = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bMC() != null && b.this.mTbPageContext != null) {
                        b.this.gLt.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bMC());
                    }
                }
            }
        };
        this.gLP = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.6
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
        this.gLQ = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.goP != null && b.this.goP.FO() != null && b.this.goP.FO().mLiveInfo != null) {
                    long j = b.this.goP.FO().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.gLK != null) {
                        b.this.gLK.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.grb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.goP.FO().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aZu != null && !eventPollingHttpResponseMessage.aZu.isEmpty() && b.this.goP != null && b.this.goP.FO() != null && b.this.goP.FO().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        for (int i = 0; i < eventPollingHttpResponseMessage.aZu.size(); i++) {
                            as asVar = eventPollingHttpResponseMessage.aZu.get(i);
                            if (j == asVar.liveId && j2 - asVar.createTime <= 60 && !m.i(asVar.liveId, asVar.id)) {
                                m.a(asVar, b.this.goP.FO().mLiveInfo, false);
                                if (b.this.gLo != null) {
                                    b.this.gLo.a(asVar, b.this.goP.FO().mLiveInfo);
                                }
                                m.j(asVar.liveId, asVar.id);
                            }
                        }
                        as asVar2 = eventPollingHttpResponseMessage.aZu.get(eventPollingHttpResponseMessage.aZu.size() - 1);
                        if (j == asVar2.liveId) {
                            m.h(asVar2.liveId, asVar2.id);
                        }
                    }
                    int i2 = eventPollingHttpResponseMessage.aZt;
                    if (i2 <= 0) {
                        i2 = 5;
                    }
                    b.this.gqG = i2 * 1000;
                }
            }
        };
        this.gLR = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.goP != null && b.this.goP.FO() != null && b.this.goP.FO().ayV != null) {
                        if (l.longValue() == b.this.goP.FO().ayV.userId) {
                            b.this.goP.FO().ayV.isNewUser = false;
                            if (b.this.gLw != null) {
                                b.this.gLw.t(b.this.goP.FO());
                            }
                        }
                    }
                }
            }
        };
        this.gLS = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.s.a)) {
                    com.baidu.tieba.ala.liveroom.s.a aVar2 = (com.baidu.tieba.ala.liveroom.s.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String wX = aVar2.wX();
                    if (b.this.mTbPageContext != null && b.this.goP != null && b.this.goP.FO() != null && b.this.goP.FO().ayV != null) {
                        if (valueOf.longValue() == b.this.goP.FO().ayV.userId && com.baidu.live.v.a.Hs().beo != null && com.baidu.live.v.a.Hs().beo.aEm != null && com.baidu.live.v.a.Hs().beo.aEm.xu()) {
                            g.rL(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, wX));
                        }
                    }
                }
            }
        };
        this.gLT = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.gLG != null) {
                    b.this.mHandler.removeCallbacks(b.this.gLG);
                }
                b.this.bPu();
            }
        };
        this.gpo = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.gKZ = aVar;
        this.gLh = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
        if (runTask != null) {
            this.gLK = (com.baidu.live.x.c) runTask.getData();
        }
        this.goP = new com.baidu.tieba.ala.liveroom.o.c(getPageContext());
        this.goP.a(this.gpy);
        this.gLn = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.gLO);
        MessageManager.getInstance().registerListener(this.gLP);
        MessageManager.getInstance().registerListener(this.gLQ);
        MessageManager.getInstance().registerListener(this.grb);
        MessageManager.getInstance().registerListener(this.gLR);
        MessageManager.getInstance().registerListener(this.gLS);
        MessageManager.getInstance().registerListener(this.gLT);
    }

    private void P(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.gLl = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.gLl.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Q(Intent intent) {
        P(intent);
        this.aZb = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.aZb)) {
            this.aZb = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.gLp = intent.getStringExtra("room_id");
        this.aZc = intent.getLongExtra("live_id", 0L);
        this.gLs = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.goP.b((AlaLiveInfoCoreData) serializableExtra);
            this.gLs = true;
        }
        R(intent);
        this.gLE = this.gLD == null || !this.gLD.aEC;
        this.gLn.setOtherParams(this.otherParams);
        this.gLk = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bPf();
        bPe();
        this.mHandler.removeCallbacks(this.gLJ);
        this.mHandler.postDelayed(this.gLJ, 1000L);
    }

    private void R(Intent intent) {
        String optString;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.fYt = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.gLr = new JSONObject(stringExtra);
                if (this.gLr != null) {
                    String optString2 = this.gLr.optString("enterRoomId");
                    String optString3 = this.gLr.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString2) && TextUtils.equals(this.gLp, optString2)) || (!TextUtils.isEmpty(optString3) && TextUtils.equals(this.aZc + "", optString3))) {
                        String optString4 = this.gLr.optString("cover");
                        String decode = !TextUtils.isEmpty(optString4) ? URLDecoder.decode(optString4, "UTF-8") : optString4;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString5 = this.gLr.optString("live_url");
                        if (!TextUtils.isEmpty(optString5)) {
                            optString5 = URLDecoder.decode(optString5, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString5);
                        if (!this.gLs) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.aZc;
                            alaLiveInfoCoreData.screenDirection = this.gLr.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString5, alaLiveInfoCoreData);
                            this.goP.b(alaLiveInfoCoreData);
                            this.gLs = true;
                        }
                    }
                    String optString6 = this.gLr.optString("extra");
                    if (TextUtils.isEmpty(optString6)) {
                        this.gLD = null;
                        optString = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString6);
                        String optString7 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString7) && this.goP != null) {
                            this.goP.Dp(optString7);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.fYt = jSONObject.optString("live_back_scheme");
                        this.gLD = new bd();
                        this.gLD.aEC = jSONObject.optInt("is_hot") == 1;
                        if (this.gLD.aEC) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.gLD.aED = jSONObject.optString("task_id");
                        this.gLD.aEB = TextUtils.isEmpty(this.gLD.aED) ? false : true;
                        this.gLD.aEE = jSONObject.optInt("task_type");
                        this.gLD.aEF = jSONObject.optInt("task_im_count");
                        this.gLD.aEG = jSONObject.optLong("task_gift_total_price");
                        this.gLD.aEH = jSONObject.optLong("task_watch_time");
                        this.gLD.aEI = jSONObject.optString("task_activity_scheme");
                        optString = jSONObject.optString("from");
                        if (!TextUtils.isEmpty(optString)) {
                            this.gLr.put("from", optString);
                        }
                        String optString8 = jSONObject.optString("back_app_scheme");
                        String optString9 = jSONObject.optString("back_app_icon");
                        String optString10 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9) && !TextUtils.isEmpty(optString10)) {
                            this.gLe = new com.baidu.tieba.ala.liveroom.e.b();
                            this.gLe.setScheme(optString8);
                            this.gLe.setImageUrl(optString9);
                            this.gLe.setTitle(optString10);
                        }
                    }
                    this.gLm = this.gLr.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gLr.remove("cover");
                    this.gLr.remove("live_url");
                    this.gLr.remove("enterRoomId");
                    this.gLr.remove("enterLiveId");
                    this.gLr.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gLr.remove("extra");
                    this.otherParams = this.gLr.toString();
                    this.goP.setOtherParams(this.otherParams);
                    this.gLr.optString("live_enter_type");
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.gLr.optString("from");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.gLr.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(optString)) {
                        optString = this.gLr.optString("source");
                    }
                    this.gLF = "mobilebaidu_subscription".equals(optString);
                    int optInt = this.gLr.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(optString)) {
                        TbConfig.setLiveEnterFrom(optString);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.goP.sk(optInt);
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra(AlaLiveRoomActivityConfig.LAST_LIVE_INFO);
            if (!StringUtils.isNull(stringExtra2)) {
                this.gLg = new AlaLastLiveroomInfo();
                this.gLg.parseJson(stringExtra2);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aZc), String.valueOf(this.gLp), null, bPn());
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

    public void bPe() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.goP.ah(this.uk, this.aZb, this.mForumName);
        } else if (this.goP.FO() != null && this.goP.FO().mLiveInfo != null && this.goP.FO().mLiveInfo.live_id > 0) {
            this.goP.a(this.goP.FO().mLiveInfo.live_id, false, this.aZb, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.aZb = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                mp(false);
                return;
            }
            this.goP.ah(this.uk, this.aZb, this.mForumName);
        } else if (!TextUtils.isEmpty(this.gLp)) {
            this.goP.DN(this.gLp);
        } else if (this.aZc > 0) {
            this.goP.a(this.aZc, false, this.aZb, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            mp(false);
        }
    }

    private void bPf() {
        this.goW = true;
        this.gLi = false;
        bPg();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.wN().l(this.gpk);
        this.gLo = new com.baidu.tieba.ala.liveroom.d.c();
        this.gLo.a(this.gLM);
        this.gLo.setOtherParams(this.otherParams);
        this.gLo.lh(this.gLF);
        bPi();
        bPh();
    }

    private void bPg() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.gLb = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.gLb.setOnPageChangeListener(this.gLN);
        this.gLb.setBoundaryCaching(true);
        this.gLb.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.gLc = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.gLc.bIU();
        this.gLa = this.gLc.rR(this.mSelectedPosition);
        this.gLc.a(this.mSelectedPosition, this.goP.FO());
        this.gLb.setAdapter(this.gLc);
        this.gLb.setCurrentItem(this.mSelectedPosition);
        this.gLb.setIsScrollable(this.gLE);
        this.gpj = (ViewGroup) inflate.findViewById(a.g.func_view);
        this.gpk = (LayerRootView) inflate.findViewById(a.g.layer_root_view);
    }

    private void c(Rect rect) {
        this.gLf = SdkLivePlayer.eH(getPageContext().getPageActivity());
        if (this.gLf == null) {
            this.gLb.setIsScrollable(false);
            if (this.goP != null) {
                this.goP.cancelLoadData();
            }
            bIX();
            return;
        }
        if (this.gLk) {
            this.gLb.setIsScrollable(false);
        }
        this.gLf.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.gLf.setIPlayerCallBack(this.blE);
        this.gLf.setIPlayerAudioFocusCallBack(this.gLL);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gLa.a(this.gLf, layoutParams, true);
    }

    private void bPh() {
        this.gLd = new com.baidu.tieba.ala.liveroom.e.a(this.mTbPageContext, this.gpj);
    }

    private void bIX() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.17
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.mp(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.gpi = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.gpi.setSwipeClearEnable(true);
        this.gpi.gzz = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gLa.a(this.gpi, layoutParams);
    }

    private void bPi() {
        if (this.goP != null && this.goP.FO() != null) {
            this.avf = this.goP.FO();
            if (this.avf.mLiveInfo != null) {
                a(this.avf.mLiveInfo, this.gLs);
                if (this.avf.mLiveInfo != null && this.avf.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.gLj);
                    }
                    if (!this.gLj) {
                        this.gLf.c(this.avf.mLiveInfo);
                    } else {
                        this.gLf.setPlayLiveInfo(this.avf.mLiveInfo);
                    }
                    if (this.gLo != null) {
                        this.gLo.a(this.mTbPageContext, this.gpi, this.gLf, this.gLa, this.goP, this.aZb, this.gLk, this.gpo, this.gLl, this.gLD);
                        j(this.avf.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private void bPj() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.gLk || !this.gLE) {
                this.gLb.setIsScrollable(false);
            } else {
                this.gLb.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.wN().onBackPressed() && ((this.gLo == null || !this.gLo.onKeyDown(i, keyEvent)) && (this.gLo == null || !this.gLo.bFj()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bPj();
            } else if (this.gLo == null || this.gLo.bFk()) {
                mp(true);
                bCB();
            }
        }
        return true;
    }

    public void bCB() {
        if (!TextUtils.isEmpty(this.fYt)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.fYt);
                this.fYt = null;
            }
        }
    }

    public void mp(boolean z) {
        M(z, false);
    }

    public void M(boolean z, boolean z2) {
        ll(!z);
        if (this.gLf != null) {
            this.gLf.destroy();
        }
        com.baidu.live.core.layer.b.wN().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        bPl();
        long j = -1;
        if (this.goP != null && this.goP.bLJ() != null) {
            j = this.goP.bLJ().room_id;
        }
        this.gKZ.a(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void ll(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.gLg = null;
        if (ac.zB() != null) {
            ac.zB().zA();
        }
        com.baidu.live.core.layer.b.wN().wO();
        if (this.gLK != null) {
            this.gLK.release();
        }
        if (this.gLw != null) {
            this.gLw.release();
        }
        this.gLD = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.goP != null) {
            try {
                this.goP.Dp(null);
                AlaLiveInfoData bLJ = this.goP.bLJ();
                if (bLJ != null) {
                    this.goP.dX(bLJ.live_id);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.gLt.stopRecord();
        LiveTimerManager.getInstance().stop();
        bPk();
        if (this.gLf != null) {
            this.gLf.bZ(z);
        }
        if (this.gLo != null) {
            this.gLo.ll(z);
        }
        this.gLv = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Fm().aYx != null) {
            com.baidu.live.liveroom.a.b.Fm().aYx.b(this.avf.mLiveInfo);
        }
    }

    private void bPk() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bPl() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(q qVar) {
        if (qVar != null) {
            this.avf = qVar;
            if (this.gLo != null) {
                this.gLo.a(qVar);
            }
        }
    }

    private void c(k kVar) {
        if (this.gLo != null) {
            this.gLo.c(kVar);
        }
    }

    private void z(q qVar) {
        this.avf = qVar;
    }

    private void bPm() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.gLb.setIsScrollable(false);
            this.gLE = false;
        }
        if (this.avf != null) {
            a(this.avf.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.gLa.a(this.gpi, null);
            a(this.gLa, this.avf.mLiveInfo, this.goW);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.avf.mLiveInfo.live_id), String.valueOf(this.avf.mLiveInfo.room_id), String.valueOf(this.avf.mLiveInfo.feed_id), bPn());
            if (com.baidu.live.liveroom.a.b.Fm().aYx != null) {
                com.baidu.live.liveroom.a.b.Fm().aYx.a(this.avf.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.goW = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.goP != null && this.goP.FO() != null && this.goP.FO().mLiveInfo != null) {
                    j = this.goP.FO().mLiveInfo.live_id;
                    str2 = this.goP.FO().mLiveInfo.room_id + "";
                    str = this.goP.FO().mLiveInfo.feed_id;
                } else {
                    if (this.aZc > 0) {
                        j2 = this.aZc;
                    }
                    if (!TextUtils.isEmpty(this.gLp)) {
                        j = j2;
                        str = "";
                        str2 = this.gLp;
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
                if (this.goP != null && this.goP.FO() != null && this.goP.FO().mLiveInfo != null) {
                    str3 = this.goP.FO().mLiveInfo.feed_id;
                    str4 = this.goP.FO().mLiveInfo.live_id + "";
                    str5 = this.goP.FO().mLiveInfo.room_id + "";
                    str6 = this.goP.FO().mLiveInfo.user_name;
                }
                alaStaticItem2.addParams("author", str6);
                alaStaticItem2.addParams("feed_id", str3);
                alaStaticItem2.addParams("live_id", str4);
                alaStaticItem2.addParams("room_id", str5);
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private String bPn() {
        if (this.gLr == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.gLr.optString("source");
            String optString2 = this.gLr.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gLr.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.gLr.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            return this.gLr.optString("from");
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (this.gLf != null && this.gLf.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.gLf.getVideoPath();
                String d = h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.gLf.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (h.aA(videoPath, d)) {
                    this.gLf.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && h.az(videoPath, d)) {
                    this.gLf.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.bQ(this.gLf)) {
                        ((ViewGroup) this.gLf.getParent()).removeView(this.gLf);
                        alaLiveRoomBlurPageLayout.a(this.gLf, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.gLj) {
                        this.gLf.c(alaLiveInfoData);
                        return;
                    } else {
                        this.gLf.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.gLf.bPF();
        } else if (this.gLf != null && this.gLf.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.gLf, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.gLj) {
                    this.gLf.c(alaLiveInfoData);
                } else {
                    this.gLf.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.gLf != null) {
            this.gLf.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = o.s(this.mTbPageContext.getPageActivity());
                layoutParams.height = o.t(this.mTbPageContext.getPageActivity());
                int az = o.az(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = az + i;
                } else {
                    dimensionPixelSize = az + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void bPo() {
        this.goW = true;
    }

    public boolean bPp() {
        return this.goW;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
        boolean z3;
        if (alaLiveInfoData != null) {
            z2 = alaLiveInfoData.screen_direction == 2;
        } else {
            z2 = false;
        }
        int statusBarHeight = UtilHelper.getStatusBarHeight();
        int dip2px = MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(this.mTbPageContext.getPageActivity(), 48.0f) : 0;
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
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
            int i = screenFullSize[0];
            screenFullSize[0] = screenFullSize[1];
            screenFullSize[1] = i;
        }
        if (z2) {
            if (realScreenOrientation == 1) {
                this.gLa.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.gLa.setBackgroundColor(0);
            }
        } else {
            this.gLa.setBackgroundColor(0);
        }
        int i2 = this.gLf.getLayoutParams().width;
        int i3 = this.gLf.getLayoutParams().height;
        int i4 = this.gLf.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.gLf.getLayoutParams()).topMargin : 0;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3 || b.topMargin != i4) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.gpi != null) {
            this.gpi.setLayoutParams(c);
        }
        if (this.gLa != null) {
            this.gLa.bw(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gLn != null) {
            this.gLn.bw(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gLo != null) {
            this.gLo.l(c.width, c.height, realScreenOrientation);
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

    private void sI(int i) {
        boolean z = true;
        if (this.avf != null && this.avf.mLiveInfo != null) {
            this.gLa.setBgImageUrl(this.avf.mLiveInfo.cover, this.avf.mLiveInfo);
            this.gLc.a(this.mSelectedPosition, bPq(), this.avf);
            this.gLc.b(this.mSelectedPosition, bPr(), this.avf);
            this.gLa.requestLayout();
            this.gLa.I(i, this.avf.mLiveInfo.screen_direction == 2);
        }
        if (this.avf != null) {
            a(this.avf.mLiveInfo, false);
        }
        boolean bNh = this.gLa.bNh();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.avf == null || this.avf.mLiveInfo == null || this.avf.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!bPB()) {
            if (this.gLf != null && this.gLf.getParent() == null) {
                this.gLa.a(this.gLf, null, false);
                if (this.avf != null && this.avf.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.gLj) {
                        this.gLf.c(this.avf.mLiveInfo);
                    } else {
                        this.gLf.setPlayLiveInfo(this.avf.mLiveInfo);
                    }
                }
            }
            if (bNh && !bPB() && this.gLo != null) {
                this.gLa.md(z);
                return;
            }
            return;
        }
        this.gLa.bNb();
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
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    layoutParams.height = iArr[1] - i;
                }
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
            this.goP.a(alaLiveInfoData.live_id, true, this.aZb, this.mForumName);
        }
    }

    public void sJ(int i) {
        if (i < 0) {
            this.goP.sl(this.goP.bLG() - 1);
        } else if (i > 0) {
            this.goP.sl(this.goP.bLG() + 1);
        }
        if (this.gLo != null) {
            this.gLo.a(this.gLa);
        }
        this.gLc.a(this.mSelectedPosition, bPq(), this.avf);
        this.gLc.b(this.mSelectedPosition, bPr(), this.avf);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.goP != null) {
            int bLG = this.goP.bLG();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bLG + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.goP.bLy() != null && this.goP.bLy().size() > bLG && this.goP.bLy().get(bLG) != null) {
                AlaLiveInfoData alaLiveInfoData = this.goP.bLy().get(bLG);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.goP != null) {
            AlaLiveInfoData bLJ = this.goP.bLJ();
            if (bLJ != null) {
                UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(bLJ.live_id), String.valueOf(bLJ.room_id), null, bPn());
                bLJ.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.gLa, bLJ, this.goW);
                this.goW = false;
                if (this.gLo != null) {
                    this.gLo.a(this.mTbPageContext, this.gpi, this.gLf, this.gLa, this.goP, this.aZb, this.gLk, this.gpo, null, this.gLD);
                    short s = 2;
                    if (bLJ.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bLJ, false);
            }
            i(bLJ);
            this.gLa.a(this.gpi, null);
            if (this.gLo != null) {
                this.gLo.bFh();
            }
            this.goP.g(bLJ);
        }
    }

    private AlaLiveInfoData bPq() {
        List<AlaLiveInfoData> bLy = this.goP.bLy();
        if (bLy == null || bLy.size() == 0) {
            if (this.avf == null) {
                return null;
            }
            return this.avf.mLiveInfo;
        }
        int bLG = this.goP.bLG();
        int size = bLy.size();
        return bLy.get(((bLG + size) - 1) % size);
    }

    private AlaLiveInfoData bPr() {
        List<AlaLiveInfoData> bLy = this.goP.bLy();
        if (bLy == null || bLy.size() == 0) {
            if (this.avf == null) {
                return null;
            }
            return this.avf.mLiveInfo;
        }
        return bLy.get((this.goP.bLG() + 1) % bLy.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(int i, String str) {
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.gLj) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.i.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            mp(false);
            return;
        }
        q FO = this.goP.FO();
        z(FO);
        this.goP.bLz();
        if (this.goW) {
            this.goP.lU(false);
        }
        this.gpo = System.currentTimeMillis() / 1000;
        if (this.gLo != null) {
            this.gLo.a(this.mTbPageContext, this.gpi, this.gLf, this.gLa, this.goP, this.aZb, this.gLk, this.gpo, this.gLl, this.gLD);
            short s = 2;
            if (FO.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bPm();
        if (FO != null && FO.mLiveInfo != null && FO.mLiveInfo.live_status == 2) {
            this.gLc.a(this.mSelectedPosition, this.goP.FO());
            d(FO, false);
            this.goW = false;
            return;
        }
        boolean z = (this.gLo == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.gLz || !TextUtils.equals(p.Jy(), this.gLA))) {
            v.b(getPageContext(), false);
            com.baidu.live.v.c.Hx().Hy();
            this.gLz = true;
            this.gLA = p.Jy();
        }
        if (!this.gLB) {
            this.gLB = true;
            com.baidu.live.entereffect.a.xD().bc(false);
        }
        if (this.goP.FO() != null && this.goP.FO().mLiveInfo != null) {
            this.goP.f(this.goP.FO().mLiveInfo.live_id, !this.gLv);
            this.gLv = true;
        }
        if (this.gLo != null) {
            this.gLo.b(this.gLg);
            this.gLo.lk(TextUtils.equals(this.gLm, "1"));
            this.gLm = "";
        }
        if (z && this.goP.FO() != null && this.goP.FO().mLiveInfo != null) {
            String str2 = this.goP.FO().mLiveInfo.feed_id;
            long j = this.goP.FO().mLiveInfo.live_id;
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                Log.i("eventpolling", "@@@ polling init live_id=" + j + ", hd=" + this.mHandler + ",vc=" + this);
                this.mHandler.post(this.gqY);
            }
        }
        if (this.gLd != null) {
            this.gLd.a(this.avf, this.gLe);
        }
        a(this.goP.FO());
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.goP.FO() != null && b.this.goP.FO().mLiveInfo != null) {
                    b.this.goP.a(b.this.goP.FO().mLiveInfo.live_id, b.this.aZb, b.this.gpo);
                }
            }
        });
        if (z && this.goP.FO() != null && this.goP.FO().ayC != null) {
            bc bcVar = com.baidu.live.v.a.Hs().beo;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bcVar != null && bcVar.aEr != null && bcVar.aEr.aGf) {
                c(true, this.goP.FO().ayC.userId);
            }
        }
        this.goW = false;
        if (z && this.goP.FO() != null && this.goP.FO().mLiveInfo != null && this.goP.FO().ayC != null && this.gLo != null) {
            long j2 = this.goP.FO().mLiveInfo.live_id;
            long j3 = this.goP.FO().mLiveInfo.room_id;
            String str3 = this.goP.FO().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j2;
                if (ac.zB() != null) {
                    ac.zB().a(this.mTbPageContext.getPageActivity(), j2, str4, j3, str3, this.otherParams);
                }
                if (this.gLK != null) {
                    this.gLK.b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
                }
            }
            if (e.CI() != null) {
                e.CI().b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
            }
            if (this.gLw == null) {
                this.gLw = new com.baidu.tieba.ala.liveroom.k.a();
            }
            this.gLw.a(this.mTbPageContext.getPageActivity(), this.goP.FO(), this.otherParams);
        }
        if (this.gLx == null) {
            this.gLx = new com.baidu.tieba.ala.liveroom.v.c(this.mTbPageContext);
        }
        if (z && this.goP.FO() != null && this.goP.FO().ayV != null && !this.gLy) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.gLx.a(this.goP.FO(), this.goP.FO().ayV.userId);
                this.gLy = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPs() {
        if (this.gLh) {
            this.gLc.a(this.mSelectedPosition, bPq(), this.avf);
            this.gLc.b(this.mSelectedPosition, bPr(), this.avf);
            this.gLh = false;
        }
        if (this.gLn != null && bPB()) {
            this.gLn.W(this.goP.bLA());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.gLj) {
            this.mHandler.removeCallbacks(this.gLI);
            this.mHandler.postDelayed(this.gLI, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (kVar == null) {
            if (!this.gLj) {
                this.mHandler.removeCallbacks(this.gLH);
                this.mHandler.postDelayed(this.gLH, 5000L);
                return;
            }
            return;
        }
        if (!this.gLi) {
            c(kVar);
        }
        if (!this.gLj) {
            this.mHandler.removeCallbacks(this.gLH);
            this.mHandler.postDelayed(this.gLH, kVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPt() {
        if (this.goP.FO() != null && this.goP.FO().mLiveInfo != null) {
            this.goP.f(this.goP.FO().mLiveInfo.live_id, !this.gLv);
            this.gLv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.live_status == 2) {
            this.gLc.a(this.mSelectedPosition, this.goP.FO());
            d(qVar, false);
        } else if (qVar != null) {
            if (!this.gLi) {
                a(qVar);
            }
            if (!this.gLj) {
                this.mHandler.removeCallbacks(this.gLG);
                this.mHandler.postDelayed(this.gLG, qVar.ayG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPu() {
        if (this.mTbPageContext != null && this.goP.FO() != null && this.goP.FO().mLiveInfo != null) {
            this.goP.a(this.goP.FO().mLiveInfo.live_id, this.aZb, this.gpo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(q qVar, boolean z) {
        View view = null;
        ll(true);
        if (!bPB()) {
            this.goP.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.gLa != null) {
                this.gLa.KB();
                this.gLa.bNb();
                this.gLa.bNi();
            }
            if (qVar != null && qVar.mLiveInfo != null) {
                this.gLq = qVar.mLiveInfo.live_id;
            }
            bPj();
            bPv();
            bPw();
            if (qVar != null) {
                if (this.gLo != null && this.gLo.bFn() != null) {
                    view = this.gLo.bFn().a(this.gLo.bFe().pageContext.getPageActivity(), qVar, z);
                }
                if (this.gLa != null) {
                    this.gLn.a(this.gLa, view, qVar, z, this.goP.bLA());
                }
                if (this.gLo != null) {
                    this.gLo.ll(false);
                    this.gLo.bFi();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.gLa != null) {
                    this.gLa.bNf();
                }
                long j = qVar.mLiveInfo.live_id;
                long j2 = qVar.mLiveInfo.room_id;
                String str = qVar.mLiveInfo.feed_id;
                long j3 = qVar.ayC.userId;
                String str2 = qVar.ayC.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.gLu = new StayTimeBean();
                this.gLu.liveId = qVar.mLiveInfo.live_id;
                this.gLu.roomId = qVar.mLiveInfo.room_id;
                this.gLu.vid = qVar.mLiveInfo.feed_id;
                this.gLu.startTime = System.currentTimeMillis();
            }
            bPD();
            if (this.gLd != null) {
                this.gLd.a(this.avf, this.gLe);
            }
        }
    }

    private void bPv() {
    }

    private void bPw() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.gLb);
        }
    }

    public void bPx() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bPy();
        } else {
            bPz();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.goP != null && this.goP.FO() != null) {
            alaLiveInfoData = this.goP.FO().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bPy();
        } else {
            bPz();
        }
        this.gLb.setIsScrollable(!z && this.gLE);
        if (this.gLo != null) {
            this.gLo.onKeyboardVisibilityChanged(z);
        }
        if (this.gpi != null) {
            this.gpi.onKeyboardVisibilityChanged(z);
        }
    }

    public void bN(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bPy();
        } else {
            bPz();
        }
        this.gpi.bN(realScreenOrientation);
        sI(realScreenOrientation);
        if (ac.zB() != null) {
            ac.zB().zc();
        }
        if (this.gLw != null) {
            this.gLw.zc();
        }
        if (this.gLd != null) {
            this.gLd.bN(realScreenOrientation);
        }
    }

    public void bPy() {
        if (this.gLb != null) {
            com.baidu.live.utils.h.X(this.gLb);
        }
    }

    public void bPz() {
        if (this.gLb != null) {
            com.baidu.live.utils.h.Y(this.gLb);
        }
    }

    public void onResume() {
        if (this.goP != null) {
            this.goP.bLj();
            this.goP.bLn();
        }
        if (this.gLo != null) {
            this.gLo.enterForeground();
        }
        if (this.gLw != null) {
            this.gLw.onResume();
        }
        if (this.gLx != null) {
            this.gLx.onResume();
        }
        com.baidu.live.core.layer.b.wN().onResume();
    }

    public void onStart() {
        if (!this.gLC) {
            if (this.gLj) {
                this.gLj = false;
                bPA();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void bPA() {
        bPu();
        bPt();
        this.goP.bLz();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            this.gLf.bPG();
        } else if (!this.gLf.isPlaying()) {
            this.gLf.bPG();
        }
        if (this.gLo != null) {
            this.gLo.bFm();
        }
        if (this.goP != null && this.goP.FO() != null && this.goP.FO().mLiveInfo != null) {
            this.gLt.dZ(this.goP.FO().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.avf.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.goP != null) {
            this.goP.bLk();
            this.goP.bLo();
        }
        if (this.gLo != null) {
            this.gLo.enterBackground();
        }
        com.baidu.live.core.layer.b.wN().onPause();
    }

    public void mq(boolean z) {
        this.gLj = true;
        mr(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void mr(boolean z) {
        this.mHandler.removeCallbacks(this.gLG);
        this.mHandler.removeCallbacks(this.gLH);
        this.mHandler.removeCallbacks(this.gLI);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            this.gLf.azN();
        } else if (!z) {
            this.gLf.azN();
        }
        if (this.gLo != null) {
            this.gLo.bFl();
        }
        this.gLt.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ac.zB() != null) {
                ac.zB().a(i, i2, intent, this.avf, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.gLo != null) {
            this.gLo.onActivityResult(i, i2, intent);
        }
    }

    public boolean bPB() {
        return this.gLn != null && this.gLn.bAe();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gLO != null) {
            MessageManager.getInstance().unRegisterListener(this.gLO);
        }
        if (this.gLP != null) {
            MessageManager.getInstance().unRegisterListener(this.gLP);
        }
        MessageManager.getInstance().unRegisterListener(this.gLQ);
        MessageManager.getInstance().unRegisterListener(this.grb);
        MessageManager.getInstance().unRegisterListener(this.gLR);
        MessageManager.getInstance().unRegisterListener(this.gLS);
        MessageManager.getInstance().unRegisterListener(this.gLT);
        if (this.gLK != null) {
            this.gLK.release();
        }
        if (this.gLf != null) {
            this.gLf.bZ(true);
        }
        if (this.gLd != null) {
            this.gLd.onDestory();
        }
        if (this.gLe != null) {
            this.gLe.reset();
        }
        if (this.gLo != null) {
            this.gLo.onDestroy();
        }
        if (this.gLc != null) {
            this.gLc.onDestroy();
        }
        this.gLa.KB();
        if (this.gLa != null) {
            this.gLa.release();
            this.gLa = null;
        }
        if (this.gLn != null) {
            this.gLn.onDestroy();
        }
        if (this.gLu != null && this.goP != null && this.goP.FO() != null) {
            long j = this.goP.FO().mLiveInfo.live_id;
            if (this.gLu.liveId == j && this.gLu.startTime > 0) {
                this.gLu.endTime = System.currentTimeMillis();
                long j2 = this.gLu.endTime - this.gLu.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.gLu.roomId + "", this.gLu.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.gLu = null;
        }
        if (this.gpi != null) {
            this.gpi.bNk();
            this.gpi = null;
        }
        if (this.goP != null) {
            this.goP.destory();
        }
        m.Jt();
        com.baidu.live.entereffect.a.xD().release();
        t.zn().release();
        if (this.gLx != null) {
            this.gLx.release();
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String Et() {
        return this.otherParams;
    }

    public void ms(boolean z) {
        this.gLC = z;
    }

    public void bPC() {
        if (this.gLr != null) {
            this.otherParams = this.gLr.toString();
            if (this.goP != null) {
                this.goP.setOtherParams(this.otherParams);
            }
            if (this.gLo != null) {
                this.gLo.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.gLn != null) {
                this.gLn.setOtherParams(this.otherParams);
            }
        }
    }

    public void bPD() {
        if (this.gLr != null) {
            String optString = this.gLr.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gLr.put("tab", "live_jump");
                        this.gLr.put("tag", "");
                        this.gLr.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.gLr.put("tab", "liveroom");
                        this.gLr.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bPC();
            }
        }
    }

    private void c(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.CG();
        }
        bVar.af(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void bPE() {
        v.zx();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gLo.d(s);
        } else {
            this.gLo.e(s);
        }
    }
}
