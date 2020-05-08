package com.baidu.tieba.ala.player;

import android.content.Context;
import android.content.DialogInterface;
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
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.base.BdBaseView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ai;
import com.baidu.live.data.as;
import com.baidu.live.data.at;
import com.baidu.live.data.n;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.s;
import com.baidu.live.gift.u;
import com.baidu.live.guardclub.e;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.message.h;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
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
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
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
import com.baidu.live.tbadk.timer.OnLiveTimerListener;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.live.utils.m;
import com.baidu.live.utils.o;
import com.baidu.live.utils.p;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.liveroom.h.g;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.ala.liveroom.m.c;
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
/* loaded from: classes3.dex */
public class b extends BdBaseView<TbPageContext> {
    private n aDK;
    private String aQl;
    private long aQm;
    private com.baidu.live.o.b aYH;
    private com.baidu.tieba.ala.liveroom.m.c fIM;
    private AlaLiveView fJb;
    private long fJf;
    private c.a fJp;
    private Runnable fKQ;
    private HttpMessageListener fKU;
    private HttpMessageListener fKV;
    private int fKz;
    private String ftK;
    private a gdK;
    private AlaLiveRoomBlurPageLayout gdL;
    private AlaLoopViewPager gdM;
    private AlaLoopViewPagerAdapter gdN;
    private com.baidu.tieba.ala.liveroom.d.a gdO;
    private com.baidu.tieba.ala.liveroom.d.b gdP;
    private SdkLivePlayer gdQ;
    private boolean gdR;
    private boolean gdS;
    private boolean gdT;
    private boolean gdU;
    private boolean gdV;
    private ArrayList<AlaBroadcastGiftToastData> gdW;
    private String gdX;
    private com.baidu.tieba.ala.endliveroom.a gdY;
    private com.baidu.tieba.ala.liveroom.c.c gdZ;
    CustomMessageListener geA;
    CustomMessageListener geB;
    CustomMessageListener geC;
    private CustomMessageListener geD;
    private String gea;
    private long geb;
    private JSONObject gec;
    private boolean ged;
    private com.baidu.tieba.ala.liveroom.task.c gee;
    private StayTimeBean gef;
    private boolean geg;
    private com.baidu.tieba.ala.liveroom.i.a geh;
    private com.baidu.tieba.ala.liveroom.t.b gei;
    private boolean gej;
    private boolean gek;
    private String gel;
    private boolean gem;
    private at gen;
    private boolean gep;
    private boolean geq;
    private Runnable ger;
    private Runnable ges;
    private Runnable get;
    private com.baidu.live.x.c geu;
    private com.baidu.live.o.a gev;
    com.baidu.live.liveroom.a.b gew;
    ViewPager.OnPageChangeListener gex;
    HttpMessageListener gey;
    CustomMessageListener gez;
    private String mForumName;
    private Handler mHandler;
    private BdAlertDialog mNetChangedDialog;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.gdR = true;
        this.fJf = 0L;
        this.gdS = false;
        this.gdT = true;
        this.aQl = "";
        this.mForumName = "";
        this.gdU = false;
        this.gdV = false;
        this.gdX = "0";
        this.mHandler = new Handler();
        this.geb = -1L;
        this.otherParams = "";
        this.ged = false;
        this.gee = com.baidu.tieba.ala.liveroom.task.c.bAb();
        this.geg = false;
        this.gek = false;
        this.gem = false;
        this.geq = false;
        this.ger = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bCJ();
            }
        };
        this.ges = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.bCI();
            }
        };
        this.get = new Runnable() { // from class: com.baidu.tieba.ala.player.b.15
            @Override // java.lang.Runnable
            public void run() {
                b.this.fIM.bzf();
            }
        };
        this.fKz = 5000;
        this.aYH = new com.baidu.live.o.b() { // from class: com.baidu.tieba.ala.player.b.16
            @Override // com.baidu.live.o.b
            public void bx(int i) {
                if (b.this.gdL != null) {
                    if (ListUtils.getCount(b.this.gdQ.getAlaLiveInfoDataList()) < 2) {
                        b.this.gdL.bAy();
                    } else {
                        b.this.gdL.bAz();
                    }
                }
                if (b.this.gdZ != null) {
                    b.this.gdZ.bx(i);
                }
                if (BdNetTypeUtil.isMobileNet()) {
                    if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && k.Ge()) {
                        b.this.lh(false);
                        b.this.bCT();
                        return;
                    }
                    b.this.bCX();
                }
            }
        };
        this.gev = new com.baidu.live.o.a() { // from class: com.baidu.tieba.ala.player.b.17
            @Override // com.baidu.live.o.a
            public void bL(boolean z) {
                if (b.this.gdQ != null) {
                    if (!z) {
                        b.this.gdQ.asl();
                        return;
                    }
                    if (!(BdNetTypeUtil.isMobileNet() && k.Ge())) {
                        b.this.gdQ.bCZ();
                    }
                }
            }
        };
        this.gew = new com.baidu.live.liveroom.a.b() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // com.baidu.live.liveroom.a.b
            public void bF(boolean z) {
                if (z || b.this.gdZ == null || b.this.gdZ.btm()) {
                    b.this.lg(true);
                    b.this.bqx();
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bG(boolean z) {
                b.this.d(b.this.aDK, z);
            }

            @Override // com.baidu.live.liveroom.a.b
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.gdQ.bCY();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.gdU) {
                    if (b.this.gdU) {
                        b.this.gdQ.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.gdQ.ab(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void e(boolean z, boolean z2) {
                if (b.this.gdM != null) {
                    b.this.gdM.setIsScrollable(b.this.gep && z);
                    b.this.gdM.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bH(boolean z) {
                boolean z2 = true;
                if (!z || b.this.bCQ()) {
                    if (b.this.gdL != null) {
                        b.this.gdL.bAB();
                        return;
                    }
                    return;
                }
                if (b.this.fIM.DM().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.gdL != null) {
                    b.this.gdL.kU(z2);
                }
            }
        };
        this.gex = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.fJb != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.gdM.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.gdT || ListUtils.getCount(b.this.fIM.bze()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && b.this.fIM.bzh() == 1) {
                            if (!b.this.fIM.bzk() || i2 >= 0) {
                                if (b.this.fIM.bzl() && i2 > 0) {
                                    b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    b.this.gdM.setCurrentItem(b.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                b.this.gdM.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        b.this.fIM.cancelLoadData();
                        b.this.mHandler.removeCallbacksAndMessages(null);
                        b.this.kc(true);
                        b.this.gdL.bAw();
                        b.this.gdL.Ho();
                        b.this.gdL.bAx();
                        if (b.this.fIM.DM() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(b.this.fIM.DM().mLiveInfo.live_id + "", b.this.fIM.DM().mLiveInfo.room_id + "", b.this.fIM.DM().aqk.userId + "", b.this.fIM.DM().aqk.userName, System.currentTimeMillis(), b.this.fIM.DM().mLiveInfo.feed_id, b.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(b.this.fIM.DM().mLiveInfo.live_id + "", b.this.fIM.DM().mLiveInfo.room_id + "", b.this.fIM.DM().aqk.userId + "", b.this.fIM.DM().aqk.userName, System.currentTimeMillis(), b.this.fIM.DM().mLiveInfo.feed_id, b.this.otherParams);
                            }
                        }
                        if (b.this.gef != null) {
                            long j = b.this.fIM.DM().mLiveInfo.live_id;
                            if (b.this.gef.liveId == j && b.this.gef.startTime > 0) {
                                b.this.gef.endTime = System.currentTimeMillis();
                                long j2 = b.this.gef.endTime - b.this.gef.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.gef.roomId + "", b.this.gef.vid, j2 / 1000, b.this.otherParams);
                            }
                            b.this.gef = null;
                        }
                        b.this.bCS();
                        if (b.this.geu != null) {
                            b.this.geu.release();
                        }
                        b.this.mSelectedPosition = i;
                        b.this.gdL = b.this.gdN.qA(b.this.mSelectedPosition);
                        b.this.gdL.bAA();
                        b.this.rn(i2);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.gdM.setCurrentItem(b.this.mSelectedPosition);
                        b.this.fIM.f(b.this.fIM.bzp());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.tG().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.fJp = new c.a() { // from class: com.baidu.tieba.ala.player.b.21
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.y(b.this.fIM.DM());
                } else if (i2 == 2) {
                    b.this.f(b.this.fIM.bnp());
                } else if (i2 == 3) {
                    b.this.aQ(i, str);
                } else if (i2 == 4) {
                    b.this.av(obj);
                } else if (i2 == 5) {
                    b.this.bCH();
                }
            }
        };
        this.fKQ = new Runnable() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                    if (b.this.fIM != null && b.this.fIM.DM() != null) {
                        Log.i("eventpolling", "@@@ polling run live_id=" + b.this.fIM.DM().mLiveInfo.live_id + ", hd=" + b.this.mHandler + ",vc=" + b.this);
                        m.j(b.this.fIM.DM().mLiveInfo.user_id, b.this.fIM.DM().mLiveInfo.live_id);
                    }
                    if (b.this.mHandler != null) {
                        b.this.mHandler.postDelayed(b.this.fKQ, b.this.fKz);
                    }
                }
            }
        };
        this.gey = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bzZ() != null && b.this.mTbPageContext != null) {
                        b.this.gee.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bzZ());
                    }
                }
            }
        };
        this.gez = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.5
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
        this.geA = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.fIM != null && b.this.fIM.DM() != null && b.this.fIM.DM().mLiveInfo != null) {
                    long j = b.this.fIM.DM().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.geu != null) {
                        b.this.geu.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.fKV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.fIM.DM().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aQB != null && !eventPollingHttpResponseMessage.aQB.isEmpty() && b.this.fIM != null && b.this.fIM.DM() != null && b.this.fIM.DM().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.aQB.size()) {
                                break;
                            }
                            ai aiVar = eventPollingHttpResponseMessage.aQB.get(i2);
                            if (j == aiVar.liveId && j2 - aiVar.createTime <= 60 && !m.h(aiVar.liveId, aiVar.id)) {
                                m.a(aiVar, b.this.fIM.DM().mLiveInfo);
                                m.i(aiVar.liveId, aiVar.id);
                            }
                            i = i2 + 1;
                        }
                        ai aiVar2 = eventPollingHttpResponseMessage.aQB.get(eventPollingHttpResponseMessage.aQB.size() - 1);
                        if (j == aiVar2.liveId) {
                            m.g(aiVar2.liveId, aiVar2.id);
                        }
                    }
                    int i3 = eventPollingHttpResponseMessage.aQA;
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    b.this.fKz = i3 * 1000;
                }
            }
        };
        this.fKU = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h)) {
                        h hVar = (h) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError() && b.this.fIM != null && b.this.fIM.DM() != null && b.this.fIM.DM().mLiveInfo != null) {
                            AlaStatsItem alaStatsItem = new AlaStatsItem();
                            alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, Long.valueOf(b.this.fIM.DM().mLiveInfo.live_id));
                            alaStatsItem.addValue("feedid", hVar.azF);
                            alaStatsItem.addValue("err", Integer.valueOf(httpResponsedMessage.getError()));
                            alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, httpResponsedMessage.getErrorString());
                            alaStatsItem.addValue("logid", Long.valueOf(getVideoGoodsListHttpResponseMessage.zk()));
                            AlaStatManager.getInstance().debug("livegoodlist_getfail", alaStatsItem);
                        }
                        if (b.this.fIM != null && b.this.fIM.DM() != null) {
                            long j = b.this.fIM.DM().mLiveInfo.live_id;
                            if (j == hVar.liveId) {
                                getVideoGoodsListHttpResponseMessage.liveId = j;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                                if (!b.this.geg) {
                                    b.this.geg = true;
                                    String str = "goods_task_" + j;
                                    as asVar = com.baidu.live.v.a.En().aRB;
                                    long j2 = (asVar == null || asVar.avE == null) ? 10L : asVar.avE.axl;
                                    if (j2 <= 0) {
                                        j2 = 10;
                                    }
                                    LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.b.8.1
                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onComplete(boolean z) {
                                            if (b.this.fIM != null && b.this.fIM.DM() != null && b.this.fIM.DM().mLiveInfo.live_id != o.aXW) {
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, b.this.fIM.DM().mLiveInfo));
                                            }
                                        }

                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onInterrupt() {
                                        }
                                    }, j2 * 1000, true);
                                }
                            }
                        }
                    }
                }
            }
        };
        this.geB = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.fIM != null && b.this.fIM.DM() != null && b.this.fIM.DM().aqD != null) {
                        if (l.longValue() == b.this.fIM.DM().aqD.userId) {
                            b.this.fIM.DM().aqD.isNewUser = false;
                            if (b.this.geh != null) {
                                b.this.geh.r(b.this.fIM.DM());
                            }
                        }
                    }
                }
            }
        };
        this.geC = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.q.a)) {
                    com.baidu.tieba.ala.liveroom.q.a aVar2 = (com.baidu.tieba.ala.liveroom.q.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String bgb = aVar2.bgb();
                    if (b.this.mTbPageContext != null && b.this.fIM != null && b.this.fIM.DM() != null && b.this.fIM.DM().aqD != null) {
                        if (valueOf.longValue() == b.this.fIM.DM().aqD.userId && com.baidu.live.v.a.En().aRB != null && com.baidu.live.v.a.En().aRB.avy != null && com.baidu.live.v.a.En().aRB.avy.ve()) {
                            g.qt(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, bgb));
                        }
                    }
                }
            }
        };
        this.geD = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.ger != null) {
                    b.this.mHandler.removeCallbacks(b.this.ger);
                }
                b.this.bCJ();
            }
        };
        this.fJf = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.gdK = aVar;
        this.gdR = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
        if (runTask != null) {
            this.geu = (com.baidu.live.x.c) runTask.getData();
        }
        this.fIM = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.fIM.a(this.fJp);
        this.gdY = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.gey);
        MessageManager.getInstance().registerListener(this.gez);
        MessageManager.getInstance().registerListener(this.geA);
        MessageManager.getInstance().registerListener(this.fKV);
        MessageManager.getInstance().registerListener(this.fKU);
        MessageManager.getInstance().registerListener(this.geB);
        MessageManager.getInstance().registerListener(this.geC);
        MessageManager.getInstance().registerListener(this.geD);
        UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem("1397", LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    private void R(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.gdW = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.gdW.add(alaBroadcastGiftToastData);
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
        this.aQl = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.aQl)) {
            this.aQl = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.gea = intent.getStringExtra("room_id");
        this.aQm = intent.getLongExtra("live_id", 0L);
        this.ged = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.fIM.b((AlaLiveInfoCoreData) serializableExtra);
            this.ged = true;
        }
        T(intent);
        this.gep = this.gen == null || !this.gen.avN;
        this.gdY.setOtherParams(this.otherParams);
        this.gdV = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bCv();
        bCu();
    }

    private void T(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.ftK = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.gec = new JSONObject(stringExtra);
                if (this.gec != null) {
                    String optString = this.gec.optString("enterRoomId");
                    String optString2 = this.gec.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.gea, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.aQm + "", optString2))) {
                        String optString3 = this.gec.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.gec.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.ged) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.aQm;
                            alaLiveInfoCoreData.screenDirection = this.gec.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString4, alaLiveInfoCoreData);
                            this.fIM.b(alaLiveInfoCoreData);
                            this.ged = true;
                        }
                    }
                    String optString5 = this.gec.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.gen = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.ftK = jSONObject.optString("live_back_scheme");
                        this.gen = new at();
                        this.gen.avN = jSONObject.optInt("is_hot") == 1;
                        if (this.gen.avN) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.gen.avO = jSONObject.optString("task_id");
                        this.gen.avM = !TextUtils.isEmpty(this.gen.avO);
                        this.gen.avP = jSONObject.optInt("task_type");
                        this.gen.avQ = jSONObject.optInt("task_im_count");
                        this.gen.avR = jSONObject.optLong("task_gift_total_price");
                        this.gen.avS = jSONObject.optLong("task_watch_time");
                        this.gen.avT = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                        String optString6 = jSONObject.optString("back_app_scheme");
                        String optString7 = jSONObject.optString("back_app_icon");
                        String optString8 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            this.gdP = new com.baidu.tieba.ala.liveroom.d.b();
                            this.gdP.setScheme(optString6);
                            this.gdP.setImageUrl(optString7);
                            this.gdP.setTitle(optString8);
                        }
                    }
                    this.gdX = this.gec.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gec.remove("cover");
                    this.gec.remove("live_url");
                    this.gec.remove("enterRoomId");
                    this.gec.remove("enterLiveId");
                    this.gec.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gec.remove("extra");
                    this.otherParams = this.gec.toString();
                    this.fIM.setOtherParams(this.otherParams);
                    this.gec.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.gec.optString("from");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.gec.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.gec.optString("source");
                    }
                    this.geq = "mobilebaidu_subscription".equals(str);
                    int optInt = this.gec.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.fIM.qS(optInt);
                    return;
                }
                return;
            }
            this.otherParams = "";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
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

    public void bCu() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.fIM.ab(this.uk, this.aQl, this.mForumName);
        } else if (this.fIM.DM() != null && this.fIM.DM().mLiveInfo != null && this.fIM.DM().mLiveInfo.live_id > 0) {
            this.fIM.a(this.fIM.DM().mLiveInfo.live_id, false, this.aQl, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.aQl = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                lg(false);
                return;
            }
            this.fIM.ab(this.uk, this.aQl, this.mForumName);
        } else if (!TextUtils.isEmpty(this.gea)) {
            this.fIM.AT(this.gea);
        } else if (this.aQm > 0) {
            this.fIM.a(this.aQm, false, this.aQl, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            lg(false);
        }
    }

    private void bCv() {
        this.gdT = true;
        this.gdS = false;
        bCw();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        this.gdZ = new com.baidu.tieba.ala.liveroom.c.c();
        this.gdZ.a(this.gew);
        this.gdZ.setOtherParams(this.otherParams);
        this.gdZ.jX(this.geq);
        bCy();
        bCx();
    }

    private void bCw() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.gdM = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.gdM.setOnPageChangeListener(this.gex);
        this.gdM.setBoundaryCaching(true);
        this.gdM.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.gdN = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.gdN.bwD();
        this.gdL = this.gdN.qz(this.mSelectedPosition);
        this.gdN.a(this.mSelectedPosition, this.fIM.DM());
        this.gdM.setAdapter(this.gdN);
        this.gdM.setCurrentItem(this.mSelectedPosition);
        this.gdM.setIsScrollable(this.gep);
    }

    private void c(Rect rect) {
        this.gdQ = SdkLivePlayer.en(getPageContext().getPageActivity());
        if (this.gdQ == null) {
            this.gdM.setIsScrollable(false);
            if (this.fIM != null) {
                this.fIM.cancelLoadData();
            }
            bwG();
            return;
        }
        if (this.gdV) {
            this.gdM.setIsScrollable(false);
        }
        this.gdQ.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.gdQ.setIPlayerCallBack(this.aYH);
        this.gdQ.setIPlayerAudioFocusCallBack(this.gev);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gdL.a(this.gdQ, layoutParams, true);
    }

    private void bCx() {
        this.gdO = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext);
    }

    private void bwG() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.lg(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.fJb = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.fJb.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gdL.a(this.fJb, layoutParams);
    }

    private void bCy() {
        if (this.fIM != null && this.fIM.DM() != null) {
            this.aDK = this.fIM.DM();
            if (this.aDK.mLiveInfo != null) {
                a(this.aDK.mLiveInfo, this.ged);
                if (this.aDK.mLiveInfo != null && this.aDK.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.gdU);
                    }
                    if (!this.gdU) {
                        this.gdQ.b(this.aDK.mLiveInfo);
                    } else {
                        this.gdQ.setPlayLiveInfo(this.aDK.mLiveInfo);
                    }
                    if (this.gdZ != null) {
                        this.gdZ.a(this.mTbPageContext, this.fJb, this.gdQ, this.gdL, this.fIM, this.aQl, this.gdV, this.fJf, this.gdW, this.gen);
                        j(this.aDK.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private void bCz() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.gdV || !this.gep) {
                this.gdM.setIsScrollable(false);
            } else {
                this.gdM.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && ((this.gdZ == null || !this.gdZ.onKeyDown(i, keyEvent)) && (this.gdZ == null || !this.gdZ.btl()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bCz();
            } else if (this.gdZ == null || this.gdZ.btm()) {
                lg(true);
                bqx();
            }
        }
        return true;
    }

    public void bqx() {
        if (!TextUtils.isEmpty(this.ftK)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.ftK);
                this.ftK = null;
            }
        }
    }

    public void lg(boolean z) {
        H(z, false);
    }

    public void H(boolean z, boolean z2) {
        long j;
        kc(!z);
        if (this.gdQ != null) {
            this.gdQ.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        bCB();
        if (this.fIM == null || this.fIM.bzp() == null) {
            j = -1;
        } else {
            j = this.fIM.bzp().room_id;
        }
        if (this.gey != null) {
            MessageManager.getInstance().unRegisterListener(this.gey);
        }
        if (this.gez != null) {
            MessageManager.getInstance().unRegisterListener(this.gez);
        }
        MessageManager.getInstance().unRegisterListener(this.geA);
        MessageManager.getInstance().unRegisterListener(this.fKV);
        MessageManager.getInstance().unRegisterListener(this.fKU);
        MessageManager.getInstance().unRegisterListener(this.geB);
        MessageManager.getInstance().unRegisterListener(this.geC);
        MessageManager.getInstance().unRegisterListener(this.geD);
        if (this.geu != null) {
            this.geu.release();
        }
        if (this.gdO != null) {
            this.gdO.onDestory();
        }
        if (this.gdP != null) {
            this.gdP.reset();
        }
        if (this.gdZ != null) {
            this.gdZ.onDestroy();
        }
        if (this.gdY != null) {
            this.gdY.onDestroy();
        }
        if (this.gef != null && this.fIM != null && this.fIM.DM() != null) {
            long j2 = this.fIM.DM().mLiveInfo.live_id;
            if (this.gef.liveId == j2 && this.gef.startTime > 0) {
                this.gef.endTime = System.currentTimeMillis();
                long j3 = this.gef.endTime - this.gef.startTime;
                if (j3 < 0) {
                    j3 = 0;
                }
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j2 + "", this.gef.roomId + "", this.gef.vid, j3 / 1000, this.otherParams);
            }
            this.gef = null;
        }
        if (this.fIM != null) {
            this.fIM.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        m.Gg();
        com.baidu.live.entereffect.a.vn().release();
        s.wU().release();
        if (this.gei != null) {
            this.gei.release();
        }
        this.gdK.a(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem("1397", LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void kc(boolean z) {
        AlaLiveInfoData bzp;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        if (ab.xl() != null) {
            ab.xl().xk();
        }
        if (this.geu != null) {
            this.geu.release();
        }
        if (this.geh != null) {
            this.geh.release();
        }
        this.gen = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.fIM != null && (bzp = this.fIM.bzp()) != null) {
            this.fIM.dG(bzp.live_id);
        }
        this.gee.stopRecord();
        LiveTimerManager.getInstance().stop();
        bCA();
        if (this.gdQ != null) {
            this.gdQ.bM(z);
        }
        if (this.gdZ != null) {
            this.gdZ.kc(z);
        }
        this.geg = false;
        o.aXW = 0L;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
    }

    private void bCA() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bCB() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(n nVar) {
        if (nVar != null) {
            this.aDK = nVar;
            if (this.gdZ != null) {
                this.gdZ.a(nVar);
            }
        }
    }

    private void c(com.baidu.live.data.h hVar) {
        if (this.gdZ != null) {
            this.gdZ.c(hVar);
        }
    }

    private void x(n nVar) {
        this.aDK = nVar;
    }

    private void bCC() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.gdM.setIsScrollable(false);
            this.gep = false;
        }
        if (this.aDK != null) {
            a(this.aDK.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.gdL.a(this.fJb, null);
            a(this.gdL, this.aDK.mLiveInfo, this.gdT);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aDK.mLiveInfo.live_id), String.valueOf(this.aDK.mLiveInfo.feed_id), bCD());
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1391", "read", "liveroom", ""));
            this.gdT = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.fIM != null && this.fIM.DM() != null && this.fIM.DM().mLiveInfo != null) {
                    j = this.fIM.DM().mLiveInfo.live_id;
                    str2 = this.fIM.DM().mLiveInfo.room_id + "";
                    str = this.fIM.DM().mLiveInfo.feed_id;
                } else {
                    if (this.aQm > 0) {
                        j2 = this.aQm;
                    }
                    if (!TextUtils.isEmpty(this.gea)) {
                        j = j2;
                        str = "";
                        str2 = this.gea;
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
                if (this.fIM != null && this.fIM.DM() != null && this.fIM.DM().mLiveInfo != null) {
                    str3 = this.fIM.DM().mLiveInfo.feed_id;
                    str4 = this.fIM.DM().mLiveInfo.live_id + "";
                    str5 = this.fIM.DM().mLiveInfo.room_id + "";
                    str6 = this.fIM.DM().mLiveInfo.user_name;
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

    private String bCD() {
        if (this.gec == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.gec.optString("source");
            String optString2 = this.gec.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gec.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.gec.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.gec.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (this.gdQ != null && this.gdQ.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.gdQ.getVideoPath();
                String c = com.baidu.live.o.h.c(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.gdQ.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + c);
                }
                if (!com.baidu.live.o.h.ak(videoPath, c)) {
                    if (!TbadkCoreApplication.getInst().isTieba() || !z || !com.baidu.live.o.h.aj(videoPath, c)) {
                        if (!z && !alaLiveRoomBlurPageLayout.bH(this.gdQ)) {
                            ((ViewGroup) this.gdQ.getParent()).removeView(this.gdQ);
                            alaLiveRoomBlurPageLayout.a(this.gdQ, null, false);
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                        }
                        if (!this.gdU) {
                            this.gdQ.b(alaLiveInfoData);
                            return;
                        } else {
                            this.gdQ.setPlayLiveInfo(alaLiveInfoData);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.gdQ.bCY();
        } else if (this.gdQ != null && this.gdQ.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.gdQ, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.gdU) {
                    this.gdQ.b(alaLiveInfoData);
                } else {
                    this.gdQ.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.gdQ != null) {
            this.gdQ.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.r(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.s(this.mTbPageContext.getPageActivity());
                int ao = p.ao(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = ao + i;
                } else {
                    dimensionPixelSize = ao + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void bCE() {
        this.gdT = true;
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
                this.gdL.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.gdL.setBackgroundColor(0);
            }
        } else {
            this.gdL.setBackgroundColor(0);
        }
        int i2 = this.gdQ.getLayoutParams().width;
        int i3 = this.gdQ.getLayoutParams().height;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.fJb != null) {
            this.fJb.setLayoutParams(c);
        }
        if (this.gdL != null) {
            this.gdL.bm(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gdY != null) {
            this.gdY.bm(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gdZ != null) {
            this.gdZ.l(c.width, c.height, realScreenOrientation);
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

    private void qG(int i) {
        boolean z = true;
        if (this.aDK != null && this.aDK.mLiveInfo != null) {
            this.gdL.setBgImageUrl(this.aDK.mLiveInfo.cover, this.aDK.mLiveInfo);
            this.gdN.a(this.mSelectedPosition, bCF(), this.aDK);
            this.gdN.b(this.mSelectedPosition, bCG(), this.aDK);
            this.gdL.requestLayout();
            this.gdL.D(i, this.aDK.mLiveInfo.screen_direction == 2);
        }
        if (this.aDK != null) {
            a(this.aDK.mLiveInfo, false);
        }
        boolean bAC = this.gdL.bAC();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.aDK == null || this.aDK.mLiveInfo == null || this.aDK.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!bCQ()) {
            if (this.gdQ != null && this.gdQ.getParent() == null) {
                this.gdL.a(this.gdQ, null, false);
                if (this.aDK != null && this.aDK.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.gdU) {
                        this.gdQ.b(this.aDK.mLiveInfo);
                    } else {
                        this.gdQ.setPlayLiveInfo(this.aDK.mLiveInfo);
                    }
                }
            }
            if (bAC && !bCQ() && this.gdZ != null) {
                this.gdL.kU(z);
                return;
            }
            return;
        }
        this.gdL.bAw();
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

    private void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.fIM.a(alaLiveInfoData.live_id, true, this.aQl, this.mForumName);
            this.fIM.dF(alaLiveInfoData.live_id);
        }
    }

    public void rn(int i) {
        if (i < 0) {
            this.fIM.qT(this.fIM.bzm() - 1);
        } else if (i > 0) {
            this.fIM.qT(this.fIM.bzm() + 1);
        }
        if (this.gdZ != null) {
            this.gdZ.a(this.gdL);
        }
        this.gdN.a(this.mSelectedPosition, bCF(), this.aDK);
        this.gdN.b(this.mSelectedPosition, bCG(), this.aDK);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.fIM != null) {
            int bzm = this.fIM.bzm();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bzm + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.fIM.bze() != null && this.fIM.bze().size() > bzm && this.fIM.bze().get(bzm) != null) {
                AlaLiveInfoData alaLiveInfoData = this.fIM.bze().get(bzm);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fIM != null) {
            AlaLiveInfoData bzp = this.fIM.bzp();
            if (bzp != null) {
                bzp.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.gdL, bzp, this.gdT);
                this.gdT = false;
                if (this.gdZ != null) {
                    this.gdZ.a(this.mTbPageContext, this.fJb, this.gdQ, this.gdL, this.fIM, this.aQl, this.gdV, this.fJf, null, this.gen);
                    short s = 2;
                    if (bzp.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bzp, false);
            }
            h(bzp);
            this.gdL.a(this.fJb, null);
            if (this.gdZ != null) {
                this.gdZ.btj();
            }
            this.fIM.f(bzp);
        }
    }

    private AlaLiveInfoData bCF() {
        List<AlaLiveInfoData> bze = this.fIM.bze();
        if (bze == null || bze.size() == 0) {
            if (this.aDK == null) {
                return null;
            }
            return this.aDK.mLiveInfo;
        }
        int bzm = this.fIM.bzm();
        int size = bze.size();
        return bze.get(((bzm + size) - 1) % size);
    }

    private AlaLiveInfoData bCG() {
        List<AlaLiveInfoData> bze = this.fIM.bze();
        if (bze == null || bze.size() == 0) {
            if (this.aDK == null) {
                return null;
            }
            return this.aDK.mLiveInfo;
        }
        return bze.get((this.fIM.bzm() + 1) % bze.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(int i, String str) {
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.gdU) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.i.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            lg(false);
            return;
        }
        n DM = this.fIM.DM();
        x(DM);
        this.fIM.bzf();
        if (this.gdT) {
            this.fIM.kM(false);
        }
        this.fJf = System.currentTimeMillis() / 1000;
        if (this.gdZ != null) {
            this.gdZ.a(this.mTbPageContext, this.fJb, this.gdQ, this.gdL, this.fIM, this.aQl, this.gdV, this.fJf, this.gdW, this.gen);
            short s = 2;
            if (DM.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bCC();
        if (DM != null && DM.mLiveInfo != null && DM.mLiveInfo.live_status == 2) {
            this.gdN.a(this.mSelectedPosition, this.fIM.DM());
            d(DM, false);
            this.gdT = false;
            return;
        }
        boolean z = (this.gdZ == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.gek || !TextUtils.equals(q.Gl(), this.gel))) {
            u.b(getPageContext());
            com.baidu.live.v.c.Es().Et();
            this.gek = true;
            this.gel = q.Gl();
        }
        if (!this.gem) {
            this.gem = true;
            com.baidu.live.entereffect.a.vn().vo();
        }
        this.geg = false;
        if (this.fIM.DM() != null && this.fIM.DM().mLiveInfo != null) {
            String str2 = this.fIM.DM().mLiveInfo.feed_id;
            long j = this.fIM.DM().mLiveInfo.live_id;
            long j2 = this.fIM.DM().mLiveInfo.user_id;
            this.fIM.dF(j);
            if (z) {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                    Log.i("eventpolling", "@@@ polling init live_id=" + j + ", hd=" + this.mHandler + ",vc=" + this);
                    this.mHandler.post(this.fKQ);
                }
                o.g(str2, j);
            }
        }
        if (this.gdZ != null) {
            this.gdZ.kb(TextUtils.equals(this.gdX, "1"));
            this.gdX = "";
        }
        if (this.gdO != null) {
            this.gdO.a(this.aDK, this.gdP);
        }
        a(this.fIM.DM());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.fIM.DM() != null && b.this.fIM.DM().mLiveInfo != null) {
                    b.this.fIM.a(b.this.fIM.DM().mLiveInfo.live_id, b.this.aQl, b.this.fJf);
                }
            }
        }, this.fIM.DM().aqo);
        if (z && this.fIM.DM() != null && this.fIM.DM().aqk != null) {
            as asVar = com.baidu.live.v.a.En().aRB;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && asVar != null && asVar.avD != null && asVar.avD.axf) {
                c(true, this.fIM.DM().aqk.userId);
            }
        }
        this.gdT = false;
        if (z && this.fIM.DM() != null && this.fIM.DM().mLiveInfo != null && this.fIM.DM().aqk != null && this.gdZ != null) {
            long j3 = this.fIM.DM().mLiveInfo.live_id;
            long j4 = this.fIM.DM().mLiveInfo.room_id;
            String str3 = this.fIM.DM().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j3;
                if (ab.xl() != null) {
                    ab.xl().a(this.mTbPageContext.getPageActivity(), j3, str4, j4, str3, this.otherParams);
                }
                if (this.geu != null) {
                    this.geu.b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
                }
            }
            if (e.Aq() != null) {
                e.Aq().b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            }
            if (this.geh == null) {
                this.geh = new com.baidu.tieba.ala.liveroom.i.a();
            }
            this.geh.a(this.mTbPageContext.getPageActivity(), this.fIM.DM(), this.otherParams);
        }
        if (this.gei == null) {
            this.gei = new com.baidu.tieba.ala.liveroom.t.b(this.mTbPageContext);
        }
        if (z && this.fIM.DM() != null && this.fIM.DM().aqD != null && !this.gej) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.gei.a(this.fIM.DM(), this.fIM.DM().aqD.userId);
                this.gej = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCH() {
        if (this.gdR) {
            this.gdN.a(this.mSelectedPosition, bCF(), this.aDK);
            this.gdN.b(this.mSelectedPosition, bCG(), this.aDK);
            this.gdR = false;
        }
        if (this.gdY != null && bCQ()) {
            this.gdY.V(this.fIM.bzg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.gdU) {
            this.mHandler.removeCallbacks(this.get);
            this.mHandler.postDelayed(this.get, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.h hVar) {
        if (hVar == null) {
            if (!this.gdU) {
                this.mHandler.removeCallbacks(this.ges);
                this.mHandler.postDelayed(this.ges, 5000L);
                return;
            }
            return;
        }
        if (!this.gdS) {
            c(hVar);
        }
        if (!this.gdU) {
            this.mHandler.removeCallbacks(this.ges);
            this.mHandler.postDelayed(this.ges, hVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCI() {
        if (this.fIM.DM() != null && this.fIM.DM().mLiveInfo != null) {
            this.fIM.dF(this.fIM.DM().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null && nVar.mLiveInfo.live_status == 2) {
            this.gdN.a(this.mSelectedPosition, this.fIM.DM());
            d(nVar, false);
        } else if (nVar != null) {
            if (!this.gdS) {
                a(nVar);
            }
            if (!this.gdU) {
                this.mHandler.removeCallbacks(this.ger);
                this.mHandler.postDelayed(this.ger, nVar.aqo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCJ() {
        if (this.mTbPageContext != null && this.fIM.DM() != null && this.fIM.DM().mLiveInfo != null) {
            this.fIM.a(this.fIM.DM().mLiveInfo.live_id, this.aQl, this.fJf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar, boolean z) {
        View view = null;
        kc(true);
        if (!bCQ()) {
            this.fIM.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.gdL != null) {
                this.gdL.Ho();
                this.gdL.bAw();
                this.gdL.bAD();
            }
            if (nVar != null && nVar.mLiveInfo != null) {
                this.geb = nVar.mLiveInfo.live_id;
            }
            bCz();
            bCK();
            bCL();
            if (nVar != null) {
                if (this.gdZ != null && this.gdZ.btp() != null) {
                    view = this.gdZ.btp().a(this.gdZ.btg().pageContext.getPageActivity(), nVar, z);
                }
                this.gdY.a(this.gdL, view, nVar, z, this.fIM.bzg());
                if (this.gdZ != null) {
                    this.gdZ.kc(false);
                    this.gdZ.btk();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                this.gdL.bAA();
                long j = nVar.mLiveInfo.live_id;
                long j2 = nVar.mLiveInfo.room_id;
                String str = nVar.mLiveInfo.feed_id;
                long j3 = nVar.aqk.userId;
                String str2 = nVar.aqk.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.gef = new StayTimeBean();
                this.gef.liveId = nVar.mLiveInfo.live_id;
                this.gef.roomId = nVar.mLiveInfo.room_id;
                this.gef.vid = nVar.mLiveInfo.feed_id;
                this.gef.startTime = System.currentTimeMillis();
            }
            bCS();
            if (this.gdO != null) {
                this.gdO.a(this.aDK, this.gdP);
            }
        }
    }

    private void bCK() {
    }

    private void bCL() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.gdM);
        }
    }

    public void bCM() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bCN();
        } else {
            bCO();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.fIM != null && this.fIM.DM() != null) {
            alaLiveInfoData = this.fIM.DM().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bCN();
        } else {
            bCO();
        }
        this.gdM.setIsScrollable(!z && this.gep);
        if (this.gdZ != null) {
            this.gdZ.onKeyboardVisibilityChanged(z);
        }
        if (this.fJb != null) {
            this.fJb.onKeyboardVisibilityChanged(z);
        }
    }

    public void cl(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bCN();
        } else {
            bCO();
        }
        this.fJb.cl(realScreenOrientation);
        qG(realScreenOrientation);
        if (ab.xl() != null) {
            ab.xl().wJ();
        }
        if (this.geh != null) {
            this.geh.wJ();
        }
        if (this.gdO != null) {
            this.gdO.cl(realScreenOrientation);
        }
    }

    public void bCN() {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.gdM != null) {
            com.baidu.live.utils.h.U(this.gdM);
        }
    }

    public void bCO() {
        if (this.gdM != null) {
            com.baidu.live.utils.h.V(this.gdM);
        }
    }

    public void onResume() {
        if (this.fIM != null) {
            this.fIM.byQ();
            this.fIM.byT();
        }
        if (this.gdZ != null) {
            this.gdZ.enterForeground();
        }
        if (this.geh != null) {
            this.geh.onResume();
        }
        if (this.gei != null) {
            this.gei.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.u.a.el(this.mTbPageContext.getPageActivity())) {
            if (this.gdU) {
                this.gdU = false;
                bCP();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void bCP() {
        bCJ();
        bCI();
        this.fIM.bzf();
        if (!this.gdQ.isPlaying()) {
            this.gdQ.bCZ();
        }
        if (this.gdZ != null) {
            this.gdZ.bto();
        }
        if (this.fIM != null && this.fIM.DM() != null && this.fIM.DM().mLiveInfo != null) {
            this.gee.dI(this.fIM.DM().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aDK.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.fIM != null) {
            this.fIM.byR();
            this.fIM.byU();
        }
        if (this.gdZ != null) {
            this.gdZ.enterBackground();
        }
    }

    public void lh(boolean z) {
        this.gdU = true;
        li(z);
        if (this.mTbPageContext != null) {
            if ((this.mTbPageContext.getPageActivity() != null) & (this.mTbPageContext.getPageActivity().isFinishing() ? false : true)) {
                UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
            }
        }
    }

    public void li(boolean z) {
        this.mHandler.removeCallbacks(this.ger);
        this.mHandler.removeCallbacks(this.ges);
        this.mHandler.removeCallbacks(this.get);
        if (!z) {
            this.gdQ.asl();
        }
        if (this.gdZ != null) {
            this.gdZ.btn();
        }
        this.gee.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ab.xl() != null) {
                ab.xl().a(i, i2, intent, this.aDK, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.gdZ != null) {
            this.gdZ.onActivityResult(i, i2, intent);
        }
    }

    public boolean bCQ() {
        return this.gdY != null && this.gdY.bnY();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gdQ != null) {
            this.gdQ.bM(true);
        }
        if (this.gdN != null) {
            this.gdN.onDestroy();
        }
        this.gdL.Ho();
        if (this.gdL != null) {
            this.gdL.release();
            this.gdL = null;
        }
        if (this.fJb != null) {
            this.fJb.bAF();
            this.fJb = null;
        }
    }

    public String Cq() {
        return this.otherParams;
    }

    public void bCR() {
        if (this.gec != null) {
            this.otherParams = this.gec.toString();
            if (this.fIM != null) {
                this.fIM.setOtherParams(this.otherParams);
            }
            if (this.gdZ != null) {
                this.gdZ.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.gdY != null) {
                this.gdY.setOtherParams(this.otherParams);
            }
        }
    }

    public void bCS() {
        if (this.gec != null) {
            String optString = this.gec.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gec.put("tab", "live_jump");
                        this.gec.put("tag", "");
                        this.gec.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.gec.put("tab", "liveroom");
                        this.gec.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bCR();
            }
        }
    }

    private void c(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.Ao();
        }
        bVar.ab(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void bCT() {
        if (!bCV()) {
            if (this.mNetChangedDialog == null) {
                this.mNetChangedDialog = new BdAlertDialog(getPageContext().getPageActivity());
                this.mNetChangedDialog.setCanceledOnTouchOutside(false);
                this.mNetChangedDialog.setMessage(getPageContext().getResources().getString(a.i.ala_create_not_wifi));
                this.mNetChangedDialog.setPositiveButton(getPageContext().getResources().getString(a.i.sdk_liveroom_attention_guide_btn_text), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.13
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        b.this.bCW();
                        b.this.mNetChangedDialog.dismiss();
                    }
                });
                this.mNetChangedDialog = this.mNetChangedDialog.create(this.mTbPageContext);
                this.mNetChangedDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.player.b.14
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getRepeatCount() == 0) {
                            b.this.bCW();
                            b.this.mNetChangedDialog.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
            }
            if (this.mNetChangedDialog != null && !this.mNetChangedDialog.isShowing()) {
                TbadkCoreApplication.isShownNetChangeDialog = true;
                this.mNetChangedDialog.show();
            }
        }
    }

    public void bCU() {
        if (this.mNetChangedDialog != null) {
            this.mNetChangedDialog.dismiss();
        }
    }

    public boolean bCV() {
        return this.mNetChangedDialog != null && this.mNetChangedDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCW() {
        onStart();
        bCX();
    }

    public void bCX() {
        u.xg();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gdZ.d(s);
        } else {
            this.gdZ.e(s);
        }
    }
}
