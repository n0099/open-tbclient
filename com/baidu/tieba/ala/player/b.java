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
    private n aDE;
    private String aQf;
    private long aQg;
    private com.baidu.live.o.b aYC;
    private com.baidu.tieba.ala.liveroom.m.c fIH;
    private AlaLiveView fIW;
    private long fJa;
    private c.a fJk;
    private Runnable fKL;
    private HttpMessageListener fKP;
    private HttpMessageListener fKQ;
    private int fKu;
    private String ftF;
    private a gdF;
    private AlaLiveRoomBlurPageLayout gdG;
    private AlaLoopViewPager gdH;
    private AlaLoopViewPagerAdapter gdI;
    private com.baidu.tieba.ala.liveroom.d.a gdJ;
    private com.baidu.tieba.ala.liveroom.d.b gdK;
    private SdkLivePlayer gdL;
    private boolean gdM;
    private boolean gdN;
    private boolean gdO;
    private boolean gdP;
    private ArrayList<AlaBroadcastGiftToastData> gdQ;
    private String gdR;
    private com.baidu.tieba.ala.endliveroom.a gdS;
    private com.baidu.tieba.ala.liveroom.c.c gdT;
    private String gdU;
    private long gdV;
    private JSONObject gdW;
    private boolean gdX;
    private com.baidu.tieba.ala.liveroom.task.c gdY;
    private StayTimeBean gdZ;
    private boolean gea;
    private com.baidu.tieba.ala.liveroom.i.a geb;
    private com.baidu.tieba.ala.liveroom.t.b gec;
    private boolean ged;
    private boolean gee;
    private String gef;
    private boolean geg;
    private at geh;
    private boolean gei;
    private boolean gej;
    private Runnable gek;
    private Runnable gel;
    private Runnable gem;
    private com.baidu.live.x.c gen;
    private com.baidu.live.o.a gep;
    com.baidu.live.liveroom.a.b geq;
    ViewPager.OnPageChangeListener ger;
    HttpMessageListener ges;
    CustomMessageListener get;
    CustomMessageListener geu;
    CustomMessageListener gev;
    CustomMessageListener gew;
    private CustomMessageListener gex;
    private boolean isBackGround;
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
        this.gdM = true;
        this.fJa = 0L;
        this.gdN = false;
        this.gdO = true;
        this.aQf = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.gdP = false;
        this.gdR = "0";
        this.mHandler = new Handler();
        this.gdV = -1L;
        this.otherParams = "";
        this.gdX = false;
        this.gdY = com.baidu.tieba.ala.liveroom.task.c.bAd();
        this.gea = false;
        this.gee = false;
        this.geg = false;
        this.gej = false;
        this.gek = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bCL();
            }
        };
        this.gel = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.bCK();
            }
        };
        this.gem = new Runnable() { // from class: com.baidu.tieba.ala.player.b.15
            @Override // java.lang.Runnable
            public void run() {
                b.this.fIH.bzh();
            }
        };
        this.fKu = 5000;
        this.aYC = new com.baidu.live.o.b() { // from class: com.baidu.tieba.ala.player.b.16
            @Override // com.baidu.live.o.b
            public void bx(int i) {
                if (b.this.gdG != null) {
                    if (ListUtils.getCount(b.this.gdL.getAlaLiveInfoDataList()) < 2) {
                        b.this.gdG.bAA();
                    } else {
                        b.this.gdG.bAB();
                    }
                }
                if (b.this.gdT != null) {
                    b.this.gdT.bx(i);
                }
                if (BdNetTypeUtil.isMobileNet()) {
                    if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && k.Gf()) {
                        b.this.lh(false);
                        b.this.bCV();
                        return;
                    }
                    b.this.bCZ();
                }
            }
        };
        this.gep = new com.baidu.live.o.a() { // from class: com.baidu.tieba.ala.player.b.17
            @Override // com.baidu.live.o.a
            public void bL(boolean z) {
                if (b.this.gdL != null) {
                    if (!z) {
                        b.this.gdL.asn();
                        return;
                    }
                    if (!(BdNetTypeUtil.isMobileNet() && k.Gf())) {
                        b.this.gdL.bDb();
                    }
                }
            }
        };
        this.geq = new com.baidu.live.liveroom.a.b() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // com.baidu.live.liveroom.a.b
            public void bF(boolean z) {
                if (z || b.this.gdT == null || b.this.gdT.bto()) {
                    b.this.lg(true);
                    b.this.bqz();
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bG(boolean z) {
                b.this.d(b.this.aDE, z);
            }

            @Override // com.baidu.live.liveroom.a.b
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.gdL.bDa();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.isBackGround) {
                    if (b.this.isBackGround) {
                        b.this.gdL.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.gdL.ab(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void e(boolean z, boolean z2) {
                if (b.this.gdH != null) {
                    b.this.gdH.setIsScrollable(b.this.gei && z);
                    b.this.gdH.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bH(boolean z) {
                boolean z2 = true;
                if (!z || b.this.bCS()) {
                    if (b.this.gdG != null) {
                        b.this.gdG.bAD();
                        return;
                    }
                    return;
                }
                if (b.this.fIH.DN().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.gdG != null) {
                    b.this.gdG.kU(z2);
                }
            }
        };
        this.ger = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.fIW != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.gdH.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.gdO || ListUtils.getCount(b.this.fIH.bzg()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && b.this.fIH.bzj() == 1) {
                            if (!b.this.fIH.bzm() || i2 >= 0) {
                                if (b.this.fIH.bzn() && i2 > 0) {
                                    b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    b.this.gdH.setCurrentItem(b.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                b.this.gdH.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        b.this.fIH.cancelLoadData();
                        b.this.mHandler.removeCallbacksAndMessages(null);
                        b.this.kc(true);
                        b.this.gdG.bAy();
                        b.this.gdG.Hp();
                        b.this.gdG.bAz();
                        if (b.this.fIH.DN() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(b.this.fIH.DN().mLiveInfo.live_id + "", b.this.fIH.DN().mLiveInfo.room_id + "", b.this.fIH.DN().aqe.userId + "", b.this.fIH.DN().aqe.userName, System.currentTimeMillis(), b.this.fIH.DN().mLiveInfo.feed_id, b.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(b.this.fIH.DN().mLiveInfo.live_id + "", b.this.fIH.DN().mLiveInfo.room_id + "", b.this.fIH.DN().aqe.userId + "", b.this.fIH.DN().aqe.userName, System.currentTimeMillis(), b.this.fIH.DN().mLiveInfo.feed_id, b.this.otherParams);
                            }
                        }
                        if (b.this.gdZ != null) {
                            long j = b.this.fIH.DN().mLiveInfo.live_id;
                            if (b.this.gdZ.liveId == j && b.this.gdZ.startTime > 0) {
                                b.this.gdZ.endTime = System.currentTimeMillis();
                                long j2 = b.this.gdZ.endTime - b.this.gdZ.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.gdZ.roomId + "", b.this.gdZ.vid, j2 / 1000, b.this.otherParams);
                            }
                            b.this.gdZ = null;
                        }
                        b.this.bCU();
                        if (b.this.gen != null) {
                            b.this.gen.release();
                        }
                        b.this.mSelectedPosition = i;
                        b.this.gdG = b.this.gdI.qA(b.this.mSelectedPosition);
                        b.this.gdG.bAC();
                        b.this.rn(i2);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.gdH.setCurrentItem(b.this.mSelectedPosition);
                        b.this.fIH.f(b.this.fIH.bzr());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.tH().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.fJk = new c.a() { // from class: com.baidu.tieba.ala.player.b.21
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.y(b.this.fIH.DN());
                } else if (i2 == 2) {
                    b.this.f(b.this.fIH.bnr());
                } else if (i2 == 3) {
                    b.this.aQ(i, str);
                } else if (i2 == 4) {
                    b.this.au(obj);
                } else if (i2 == 5) {
                    b.this.bCJ();
                }
            }
        };
        this.fKL = new Runnable() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                    if (b.this.fIH != null && b.this.fIH.DN() != null) {
                        Log.i("eventpolling", "@@@ polling run live_id=" + b.this.fIH.DN().mLiveInfo.live_id + ", hd=" + b.this.mHandler + ",vc=" + b.this);
                        m.j(b.this.fIH.DN().mLiveInfo.user_id, b.this.fIH.DN().mLiveInfo.live_id);
                    }
                    if (b.this.mHandler != null) {
                        b.this.mHandler.postDelayed(b.this.fKL, b.this.fKu);
                    }
                }
            }
        };
        this.ges = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bAb() != null && b.this.mTbPageContext != null) {
                        b.this.gdY.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bAb());
                    }
                }
            }
        };
        this.get = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.5
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
        this.geu = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.fIH != null && b.this.fIH.DN() != null && b.this.fIH.DN().mLiveInfo != null) {
                    long j = b.this.fIH.DN().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.gen != null) {
                        b.this.gen.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.fKQ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.fIH.DN().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aQw != null && !eventPollingHttpResponseMessage.aQw.isEmpty() && b.this.fIH != null && b.this.fIH.DN() != null && b.this.fIH.DN().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.aQw.size()) {
                                break;
                            }
                            ai aiVar = eventPollingHttpResponseMessage.aQw.get(i2);
                            if (j == aiVar.liveId && j2 - aiVar.createTime <= 60 && !m.h(aiVar.liveId, aiVar.id)) {
                                m.a(aiVar, b.this.fIH.DN().mLiveInfo);
                                m.i(aiVar.liveId, aiVar.id);
                            }
                            i = i2 + 1;
                        }
                        ai aiVar2 = eventPollingHttpResponseMessage.aQw.get(eventPollingHttpResponseMessage.aQw.size() - 1);
                        if (j == aiVar2.liveId) {
                            m.g(aiVar2.liveId, aiVar2.id);
                        }
                    }
                    int i3 = eventPollingHttpResponseMessage.aQv;
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    b.this.fKu = i3 * 1000;
                }
            }
        };
        this.fKP = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h)) {
                        h hVar = (h) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError() && b.this.fIH != null && b.this.fIH.DN() != null && b.this.fIH.DN().mLiveInfo != null) {
                            AlaStatsItem alaStatsItem = new AlaStatsItem();
                            alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, Long.valueOf(b.this.fIH.DN().mLiveInfo.live_id));
                            alaStatsItem.addValue("feedid", hVar.azz);
                            alaStatsItem.addValue("err", Integer.valueOf(httpResponsedMessage.getError()));
                            alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, httpResponsedMessage.getErrorString());
                            alaStatsItem.addValue("logid", Long.valueOf(getVideoGoodsListHttpResponseMessage.zl()));
                            AlaStatManager.getInstance().debug("livegoodlist_getfail", alaStatsItem);
                        }
                        if (b.this.fIH != null && b.this.fIH.DN() != null) {
                            long j = b.this.fIH.DN().mLiveInfo.live_id;
                            if (j == hVar.liveId) {
                                getVideoGoodsListHttpResponseMessage.liveId = j;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                                if (!b.this.gea) {
                                    b.this.gea = true;
                                    String str = "goods_task_" + j;
                                    as asVar = com.baidu.live.v.a.Eo().aRw;
                                    long j2 = (asVar == null || asVar.avy == null) ? 10L : asVar.avy.axf;
                                    if (j2 <= 0) {
                                        j2 = 10;
                                    }
                                    LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.b.8.1
                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onComplete(boolean z) {
                                            if (b.this.fIH != null && b.this.fIH.DN() != null && b.this.fIH.DN().mLiveInfo.live_id != o.aXR) {
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, b.this.fIH.DN().mLiveInfo));
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
        this.gev = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.fIH != null && b.this.fIH.DN() != null && b.this.fIH.DN().aqx != null) {
                        if (l.longValue() == b.this.fIH.DN().aqx.userId) {
                            b.this.fIH.DN().aqx.isNewUser = false;
                            if (b.this.geb != null) {
                                b.this.geb.r(b.this.fIH.DN());
                            }
                        }
                    }
                }
            }
        };
        this.gew = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.q.a)) {
                    com.baidu.tieba.ala.liveroom.q.a aVar2 = (com.baidu.tieba.ala.liveroom.q.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String bgd = aVar2.bgd();
                    if (b.this.mTbPageContext != null && b.this.fIH != null && b.this.fIH.DN() != null && b.this.fIH.DN().aqx != null) {
                        if (valueOf.longValue() == b.this.fIH.DN().aqx.userId && com.baidu.live.v.a.Eo().aRw != null && com.baidu.live.v.a.Eo().aRw.avs != null && com.baidu.live.v.a.Eo().aRw.avs.vf()) {
                            g.qt(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, bgd));
                        }
                    }
                }
            }
        };
        this.gex = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.gek != null) {
                    b.this.mHandler.removeCallbacks(b.this.gek);
                }
                b.this.bCL();
            }
        };
        this.fJa = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.gdF = aVar;
        this.gdM = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
        if (runTask != null) {
            this.gen = (com.baidu.live.x.c) runTask.getData();
        }
        this.fIH = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.fIH.a(this.fJk);
        this.gdS = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.ges);
        MessageManager.getInstance().registerListener(this.get);
        MessageManager.getInstance().registerListener(this.geu);
        MessageManager.getInstance().registerListener(this.fKQ);
        MessageManager.getInstance().registerListener(this.fKP);
        MessageManager.getInstance().registerListener(this.gev);
        MessageManager.getInstance().registerListener(this.gew);
        MessageManager.getInstance().registerListener(this.gex);
        UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem("1397", LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    private void ae(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.gdQ = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.gdQ.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void af(Intent intent) {
        ae(intent);
        this.aQf = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.aQf)) {
            this.aQf = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.gdU = intent.getStringExtra("room_id");
        this.aQg = intent.getLongExtra("live_id", 0L);
        this.gdX = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.fIH.b((AlaLiveInfoCoreData) serializableExtra);
            this.gdX = true;
        }
        ag(intent);
        this.gei = this.geh == null || !this.geh.avH;
        this.gdS.setOtherParams(this.otherParams);
        this.gdP = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bCx();
        bCw();
    }

    private void ag(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.ftF = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.gdW = new JSONObject(stringExtra);
                if (this.gdW != null) {
                    String optString = this.gdW.optString("enterRoomId");
                    String optString2 = this.gdW.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.gdU, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.aQg + "", optString2))) {
                        String optString3 = this.gdW.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.gdW.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.gdX) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.aQg;
                            alaLiveInfoCoreData.screenDirection = this.gdW.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString4, alaLiveInfoCoreData);
                            this.fIH.b(alaLiveInfoCoreData);
                            this.gdX = true;
                        }
                    }
                    String optString5 = this.gdW.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.geh = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.ftF = jSONObject.optString("live_back_scheme");
                        this.geh = new at();
                        this.geh.avH = jSONObject.optInt("is_hot") == 1;
                        if (this.geh.avH) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.geh.avI = jSONObject.optString("task_id");
                        this.geh.avG = !TextUtils.isEmpty(this.geh.avI);
                        this.geh.avJ = jSONObject.optInt("task_type");
                        this.geh.avK = jSONObject.optInt("task_im_count");
                        this.geh.avL = jSONObject.optLong("task_gift_total_price");
                        this.geh.avM = jSONObject.optLong("task_watch_time");
                        this.geh.avN = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                        String optString6 = jSONObject.optString("back_app_scheme");
                        String optString7 = jSONObject.optString("back_app_icon");
                        String optString8 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            this.gdK = new com.baidu.tieba.ala.liveroom.d.b();
                            this.gdK.setScheme(optString6);
                            this.gdK.setImageUrl(optString7);
                            this.gdK.setTitle(optString8);
                        }
                    }
                    this.gdR = this.gdW.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gdW.remove("cover");
                    this.gdW.remove("live_url");
                    this.gdW.remove("enterRoomId");
                    this.gdW.remove("enterLiveId");
                    this.gdW.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gdW.remove("extra");
                    this.otherParams = this.gdW.toString();
                    this.fIH.setOtherParams(this.otherParams);
                    this.gdW.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.gdW.optString("from");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.gdW.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.gdW.optString("source");
                    }
                    this.gej = "mobilebaidu_subscription".equals(str);
                    int optInt = this.gdW.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.fIH.qS(optInt);
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

    public void bCw() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.fIH.ab(this.uk, this.aQf, this.mForumName);
        } else if (this.fIH.DN() != null && this.fIH.DN().mLiveInfo != null && this.fIH.DN().mLiveInfo.live_id > 0) {
            this.fIH.a(this.fIH.DN().mLiveInfo.live_id, false, this.aQf, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.aQf = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                lg(false);
                return;
            }
            this.fIH.ab(this.uk, this.aQf, this.mForumName);
        } else if (!TextUtils.isEmpty(this.gdU)) {
            this.fIH.AQ(this.gdU);
        } else if (this.aQg > 0) {
            this.fIH.a(this.aQg, false, this.aQf, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            lg(false);
        }
    }

    private void bCx() {
        this.gdO = true;
        this.gdN = false;
        bCy();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        this.gdT = new com.baidu.tieba.ala.liveroom.c.c();
        this.gdT.a(this.geq);
        this.gdT.setOtherParams(this.otherParams);
        this.gdT.jX(this.gej);
        bCA();
        bCz();
    }

    private void bCy() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.gdH = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.gdH.setOnPageChangeListener(this.ger);
        this.gdH.setBoundaryCaching(true);
        this.gdH.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.gdI = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.gdI.bwF();
        this.gdG = this.gdI.qz(this.mSelectedPosition);
        this.gdI.a(this.mSelectedPosition, this.fIH.DN());
        this.gdH.setAdapter(this.gdI);
        this.gdH.setCurrentItem(this.mSelectedPosition);
        this.gdH.setIsScrollable(this.gei);
    }

    private void c(Rect rect) {
        this.gdL = SdkLivePlayer.ez(getPageContext().getPageActivity());
        if (this.gdL == null) {
            this.gdH.setIsScrollable(false);
            if (this.fIH != null) {
                this.fIH.cancelLoadData();
            }
            bwI();
            return;
        }
        if (this.gdP) {
            this.gdH.setIsScrollable(false);
        }
        this.gdL.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.gdL.setIPlayerCallBack(this.aYC);
        this.gdL.setIPlayerAudioFocusCallBack(this.gep);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gdG.a(this.gdL, layoutParams, true);
    }

    private void bCz() {
        this.gdJ = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext);
    }

    private void bwI() {
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
        this.fIW = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.fIW.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gdG.a(this.fIW, layoutParams);
    }

    private void bCA() {
        if (this.fIH != null && this.fIH.DN() != null) {
            this.aDE = this.fIH.DN();
            if (this.aDE.mLiveInfo != null) {
                a(this.aDE.mLiveInfo, this.gdX);
                if (this.aDE.mLiveInfo != null && this.aDE.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.isBackGround);
                    }
                    if (!this.isBackGround) {
                        this.gdL.b(this.aDE.mLiveInfo);
                    } else {
                        this.gdL.setPlayLiveInfo(this.aDE.mLiveInfo);
                    }
                    if (this.gdT != null) {
                        this.gdT.a(this.mTbPageContext, this.fIW, this.gdL, this.gdG, this.fIH, this.aQf, this.gdP, this.fJa, this.gdQ, this.geh);
                        j(this.aDE.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private void bCB() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.gdP || !this.gei) {
                this.gdH.setIsScrollable(false);
            } else {
                this.gdH.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && ((this.gdT == null || !this.gdT.onKeyDown(i, keyEvent)) && (this.gdT == null || !this.gdT.btn()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bCB();
            } else if (this.gdT == null || this.gdT.bto()) {
                lg(true);
                bqz();
            }
        }
        return true;
    }

    public void bqz() {
        if (!TextUtils.isEmpty(this.ftF)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.ftF);
                this.ftF = null;
            }
        }
    }

    public void lg(boolean z) {
        H(z, false);
    }

    public void H(boolean z, boolean z2) {
        long j;
        kc(!z);
        if (this.gdL != null) {
            this.gdL.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        bCD();
        if (this.fIH == null || this.fIH.bzr() == null) {
            j = -1;
        } else {
            j = this.fIH.bzr().room_id;
        }
        if (this.ges != null) {
            MessageManager.getInstance().unRegisterListener(this.ges);
        }
        if (this.get != null) {
            MessageManager.getInstance().unRegisterListener(this.get);
        }
        MessageManager.getInstance().unRegisterListener(this.geu);
        MessageManager.getInstance().unRegisterListener(this.fKQ);
        MessageManager.getInstance().unRegisterListener(this.fKP);
        MessageManager.getInstance().unRegisterListener(this.gev);
        MessageManager.getInstance().unRegisterListener(this.gew);
        MessageManager.getInstance().unRegisterListener(this.gex);
        if (this.gen != null) {
            this.gen.release();
        }
        if (this.gdJ != null) {
            this.gdJ.onDestory();
        }
        if (this.gdK != null) {
            this.gdK.reset();
        }
        if (this.gdT != null) {
            this.gdT.onDestroy();
        }
        if (this.gdS != null) {
            this.gdS.onDestroy();
        }
        if (this.gdZ != null && this.fIH != null && this.fIH.DN() != null) {
            long j2 = this.fIH.DN().mLiveInfo.live_id;
            if (this.gdZ.liveId == j2 && this.gdZ.startTime > 0) {
                this.gdZ.endTime = System.currentTimeMillis();
                long j3 = this.gdZ.endTime - this.gdZ.startTime;
                if (j3 < 0) {
                    j3 = 0;
                }
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j2 + "", this.gdZ.roomId + "", this.gdZ.vid, j3 / 1000, this.otherParams);
            }
            this.gdZ = null;
        }
        if (this.fIH != null) {
            this.fIH.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        m.Gh();
        com.baidu.live.entereffect.a.vo().release();
        s.wV().release();
        if (this.gec != null) {
            this.gec.release();
        }
        this.gdF.a(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem("1397", LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void kc(boolean z) {
        AlaLiveInfoData bzr;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        if (ab.xm() != null) {
            ab.xm().xl();
        }
        if (this.gen != null) {
            this.gen.release();
        }
        if (this.geb != null) {
            this.geb.release();
        }
        this.geh = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.fIH != null && (bzr = this.fIH.bzr()) != null) {
            this.fIH.dG(bzr.live_id);
        }
        this.gdY.stopRecord();
        LiveTimerManager.getInstance().stop();
        bCC();
        if (this.gdL != null) {
            this.gdL.bM(z);
        }
        if (this.gdT != null) {
            this.gdT.kc(z);
        }
        this.gea = false;
        o.aXR = 0L;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
    }

    private void bCC() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bCD() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(n nVar) {
        if (nVar != null) {
            this.aDE = nVar;
            if (this.gdT != null) {
                this.gdT.a(nVar);
            }
        }
    }

    private void c(com.baidu.live.data.h hVar) {
        if (this.gdT != null) {
            this.gdT.c(hVar);
        }
    }

    private void x(n nVar) {
        this.aDE = nVar;
    }

    private void bCE() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.gdH.setIsScrollable(false);
            this.gei = false;
        }
        if (this.aDE != null) {
            a(this.aDE.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.gdG.a(this.fIW, null);
            a(this.gdG, this.aDE.mLiveInfo, this.gdO);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aDE.mLiveInfo.live_id), String.valueOf(this.aDE.mLiveInfo.feed_id), bCF());
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1391", "read", "liveroom", ""));
            this.gdO = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.fIH != null && this.fIH.DN() != null && this.fIH.DN().mLiveInfo != null) {
                    j = this.fIH.DN().mLiveInfo.live_id;
                    str2 = this.fIH.DN().mLiveInfo.room_id + "";
                    str = this.fIH.DN().mLiveInfo.feed_id;
                } else {
                    if (this.aQg > 0) {
                        j2 = this.aQg;
                    }
                    if (!TextUtils.isEmpty(this.gdU)) {
                        j = j2;
                        str = "";
                        str2 = this.gdU;
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
                if (this.fIH != null && this.fIH.DN() != null && this.fIH.DN().mLiveInfo != null) {
                    str3 = this.fIH.DN().mLiveInfo.feed_id;
                    str4 = this.fIH.DN().mLiveInfo.live_id + "";
                    str5 = this.fIH.DN().mLiveInfo.room_id + "";
                    str6 = this.fIH.DN().mLiveInfo.user_name;
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

    private String bCF() {
        if (this.gdW == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.gdW.optString("source");
            String optString2 = this.gdW.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gdW.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.gdW.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.gdW.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (this.gdL != null && this.gdL.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.gdL.getVideoPath();
                String c = com.baidu.live.o.h.c(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.gdL.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + c);
                }
                if (!com.baidu.live.o.h.ak(videoPath, c)) {
                    if (!TbadkCoreApplication.getInst().isTieba() || !z || !com.baidu.live.o.h.aj(videoPath, c)) {
                        if (!z && !alaLiveRoomBlurPageLayout.bH(this.gdL)) {
                            ((ViewGroup) this.gdL.getParent()).removeView(this.gdL);
                            alaLiveRoomBlurPageLayout.a(this.gdL, null, false);
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                        }
                        if (!this.isBackGround) {
                            this.gdL.b(alaLiveInfoData);
                            return;
                        } else {
                            this.gdL.setPlayLiveInfo(alaLiveInfoData);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.gdL.bDa();
        } else if (this.gdL != null && this.gdL.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.gdL, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.isBackGround) {
                    this.gdL.b(alaLiveInfoData);
                } else {
                    this.gdL.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.gdL != null) {
            this.gdL.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.r(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.s(this.mTbPageContext.getPageActivity());
                int aA = p.aA(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = aA + i;
                } else {
                    dimensionPixelSize = aA + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void bCG() {
        this.gdO = true;
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
                this.gdG.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.gdG.setBackgroundColor(0);
            }
        } else {
            this.gdG.setBackgroundColor(0);
        }
        int i2 = this.gdL.getLayoutParams().width;
        int i3 = this.gdL.getLayoutParams().height;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.fIW != null) {
            this.fIW.setLayoutParams(c);
        }
        if (this.gdG != null) {
            this.gdG.bm(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gdS != null) {
            this.gdS.bm(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gdT != null) {
            this.gdT.l(c.width, c.height, realScreenOrientation);
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
        if (this.aDE != null && this.aDE.mLiveInfo != null) {
            this.gdG.setBgImageUrl(this.aDE.mLiveInfo.cover, this.aDE.mLiveInfo);
            this.gdI.a(this.mSelectedPosition, bCH(), this.aDE);
            this.gdI.b(this.mSelectedPosition, bCI(), this.aDE);
            this.gdG.requestLayout();
            this.gdG.D(i, this.aDE.mLiveInfo.screen_direction == 2);
        }
        if (this.aDE != null) {
            a(this.aDE.mLiveInfo, false);
        }
        boolean bAE = this.gdG.bAE();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.aDE == null || this.aDE.mLiveInfo == null || this.aDE.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!bCS()) {
            if (this.gdL != null && this.gdL.getParent() == null) {
                this.gdG.a(this.gdL, null, false);
                if (this.aDE != null && this.aDE.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.isBackGround) {
                        this.gdL.b(this.aDE.mLiveInfo);
                    } else {
                        this.gdL.setPlayLiveInfo(this.aDE.mLiveInfo);
                    }
                }
            }
            if (bAE && !bCS() && this.gdT != null) {
                this.gdG.kU(z);
                return;
            }
            return;
        }
        this.gdG.bAy();
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
            this.fIH.a(alaLiveInfoData.live_id, true, this.aQf, this.mForumName);
            this.fIH.dF(alaLiveInfoData.live_id);
        }
    }

    public void rn(int i) {
        if (i < 0) {
            this.fIH.qT(this.fIH.bzo() - 1);
        } else if (i > 0) {
            this.fIH.qT(this.fIH.bzo() + 1);
        }
        if (this.gdT != null) {
            this.gdT.a(this.gdG);
        }
        this.gdI.a(this.mSelectedPosition, bCH(), this.aDE);
        this.gdI.b(this.mSelectedPosition, bCI(), this.aDE);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.fIH != null) {
            int bzo = this.fIH.bzo();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bzo + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.fIH.bzg() != null && this.fIH.bzg().size() > bzo && this.fIH.bzg().get(bzo) != null) {
                AlaLiveInfoData alaLiveInfoData = this.fIH.bzg().get(bzo);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fIH != null) {
            AlaLiveInfoData bzr = this.fIH.bzr();
            if (bzr != null) {
                bzr.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.gdG, bzr, this.gdO);
                this.gdO = false;
                if (this.gdT != null) {
                    this.gdT.a(this.mTbPageContext, this.fIW, this.gdL, this.gdG, this.fIH, this.aQf, this.gdP, this.fJa, null, this.geh);
                    short s = 2;
                    if (bzr.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bzr, false);
            }
            h(bzr);
            this.gdG.a(this.fIW, null);
            if (this.gdT != null) {
                this.gdT.btl();
            }
            this.fIH.f(bzr);
        }
    }

    private AlaLiveInfoData bCH() {
        List<AlaLiveInfoData> bzg = this.fIH.bzg();
        if (bzg == null || bzg.size() == 0) {
            if (this.aDE == null) {
                return null;
            }
            return this.aDE.mLiveInfo;
        }
        int bzo = this.fIH.bzo();
        int size = bzg.size();
        return bzg.get(((bzo + size) - 1) % size);
    }

    private AlaLiveInfoData bCI() {
        List<AlaLiveInfoData> bzg = this.fIH.bzg();
        if (bzg == null || bzg.size() == 0) {
            if (this.aDE == null) {
                return null;
            }
            return this.aDE.mLiveInfo;
        }
        return bzg.get((this.fIH.bzo() + 1) % bzg.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(int i, String str) {
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.isBackGround) {
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
        n DN = this.fIH.DN();
        x(DN);
        this.fIH.bzh();
        if (this.gdO) {
            this.fIH.kM(false);
        }
        this.fJa = System.currentTimeMillis() / 1000;
        if (this.gdT != null) {
            this.gdT.a(this.mTbPageContext, this.fIW, this.gdL, this.gdG, this.fIH, this.aQf, this.gdP, this.fJa, this.gdQ, this.geh);
            short s = 2;
            if (DN.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bCE();
        if (DN != null && DN.mLiveInfo != null && DN.mLiveInfo.live_status == 2) {
            this.gdI.a(this.mSelectedPosition, this.fIH.DN());
            d(DN, false);
            this.gdO = false;
            return;
        }
        boolean z = (this.gdT == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.gee || !TextUtils.equals(q.Gm(), this.gef))) {
            u.b(getPageContext());
            com.baidu.live.v.c.Et().Eu();
            this.gee = true;
            this.gef = q.Gm();
        }
        if (!this.geg) {
            this.geg = true;
            com.baidu.live.entereffect.a.vo().vp();
        }
        this.gea = false;
        if (this.fIH.DN() != null && this.fIH.DN().mLiveInfo != null) {
            String str2 = this.fIH.DN().mLiveInfo.feed_id;
            long j = this.fIH.DN().mLiveInfo.live_id;
            long j2 = this.fIH.DN().mLiveInfo.user_id;
            this.fIH.dF(j);
            if (z) {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                    Log.i("eventpolling", "@@@ polling init live_id=" + j + ", hd=" + this.mHandler + ",vc=" + this);
                    this.mHandler.post(this.fKL);
                }
                o.g(str2, j);
            }
        }
        if (this.gdT != null) {
            this.gdT.kb(TextUtils.equals(this.gdR, "1"));
            this.gdR = "";
        }
        if (this.gdJ != null) {
            this.gdJ.a(this.aDE, this.gdK);
        }
        a(this.fIH.DN());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.fIH.DN() != null && b.this.fIH.DN().mLiveInfo != null) {
                    b.this.fIH.a(b.this.fIH.DN().mLiveInfo.live_id, b.this.aQf, b.this.fJa);
                }
            }
        }, this.fIH.DN().aqi);
        if (z && this.fIH.DN() != null && this.fIH.DN().aqe != null) {
            as asVar = com.baidu.live.v.a.Eo().aRw;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && asVar != null && asVar.avx != null && asVar.avx.awZ) {
                c(true, this.fIH.DN().aqe.userId);
            }
        }
        this.gdO = false;
        if (z && this.fIH.DN() != null && this.fIH.DN().mLiveInfo != null && this.fIH.DN().aqe != null && this.gdT != null) {
            long j3 = this.fIH.DN().mLiveInfo.live_id;
            long j4 = this.fIH.DN().mLiveInfo.room_id;
            String str3 = this.fIH.DN().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j3;
                if (ab.xm() != null) {
                    ab.xm().a(this.mTbPageContext.getPageActivity(), j3, str4, j4, str3, this.otherParams);
                }
                if (this.gen != null) {
                    this.gen.b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
                }
            }
            if (e.Ar() != null) {
                e.Ar().b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            }
            if (this.geb == null) {
                this.geb = new com.baidu.tieba.ala.liveroom.i.a();
            }
            this.geb.a(this.mTbPageContext.getPageActivity(), this.fIH.DN(), this.otherParams);
        }
        if (this.gec == null) {
            this.gec = new com.baidu.tieba.ala.liveroom.t.b(this.mTbPageContext);
        }
        if (z && this.fIH.DN() != null && this.fIH.DN().aqx != null && !this.ged) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.gec.a(this.fIH.DN(), this.fIH.DN().aqx.userId);
                this.ged = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCJ() {
        if (this.gdM) {
            this.gdI.a(this.mSelectedPosition, bCH(), this.aDE);
            this.gdI.b(this.mSelectedPosition, bCI(), this.aDE);
            this.gdM = false;
        }
        if (this.gdS != null && bCS()) {
            this.gdS.V(this.fIH.bzi());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.gem);
            this.mHandler.postDelayed(this.gem, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.h hVar) {
        if (hVar == null) {
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.gel);
                this.mHandler.postDelayed(this.gel, 5000L);
                return;
            }
            return;
        }
        if (!this.gdN) {
            c(hVar);
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.gel);
            this.mHandler.postDelayed(this.gel, hVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCK() {
        if (this.fIH.DN() != null && this.fIH.DN().mLiveInfo != null) {
            this.fIH.dF(this.fIH.DN().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null && nVar.mLiveInfo.live_status == 2) {
            this.gdI.a(this.mSelectedPosition, this.fIH.DN());
            d(nVar, false);
        } else if (nVar != null) {
            if (!this.gdN) {
                a(nVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.gek);
                this.mHandler.postDelayed(this.gek, nVar.aqi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCL() {
        if (this.mTbPageContext != null && this.fIH.DN() != null && this.fIH.DN().mLiveInfo != null) {
            this.fIH.a(this.fIH.DN().mLiveInfo.live_id, this.aQf, this.fJa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar, boolean z) {
        View view = null;
        kc(true);
        if (!bCS()) {
            this.fIH.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.gdG != null) {
                this.gdG.Hp();
                this.gdG.bAy();
                this.gdG.bAF();
            }
            if (nVar != null && nVar.mLiveInfo != null) {
                this.gdV = nVar.mLiveInfo.live_id;
            }
            bCB();
            bCM();
            bCN();
            if (nVar != null) {
                if (this.gdT != null && this.gdT.btr() != null) {
                    view = this.gdT.btr().a(this.gdT.bti().pageContext.getPageActivity(), nVar, z);
                }
                this.gdS.a(this.gdG, view, nVar, z, this.fIH.bzi());
                if (this.gdT != null) {
                    this.gdT.kc(false);
                    this.gdT.btm();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                this.gdG.bAC();
                long j = nVar.mLiveInfo.live_id;
                long j2 = nVar.mLiveInfo.room_id;
                String str = nVar.mLiveInfo.feed_id;
                long j3 = nVar.aqe.userId;
                String str2 = nVar.aqe.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.gdZ = new StayTimeBean();
                this.gdZ.liveId = nVar.mLiveInfo.live_id;
                this.gdZ.roomId = nVar.mLiveInfo.room_id;
                this.gdZ.vid = nVar.mLiveInfo.feed_id;
                this.gdZ.startTime = System.currentTimeMillis();
            }
            bCU();
            if (this.gdJ != null) {
                this.gdJ.a(this.aDE, this.gdK);
            }
        }
    }

    private void bCM() {
    }

    private void bCN() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.gdH);
        }
    }

    public void bCO() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bCP();
        } else {
            bCQ();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.fIH != null && this.fIH.DN() != null) {
            alaLiveInfoData = this.fIH.DN().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bCP();
        } else {
            bCQ();
        }
        this.gdH.setIsScrollable(!z && this.gei);
        if (this.gdT != null) {
            this.gdT.onKeyboardVisibilityChanged(z);
        }
        if (this.fIW != null) {
            this.fIW.onKeyboardVisibilityChanged(z);
        }
    }

    public void cl(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bCP();
        } else {
            bCQ();
        }
        this.fIW.cl(realScreenOrientation);
        qG(realScreenOrientation);
        if (ab.xm() != null) {
            ab.xm().wK();
        }
        if (this.geb != null) {
            this.geb.wK();
        }
        if (this.gdJ != null) {
            this.gdJ.cl(realScreenOrientation);
        }
    }

    public void bCP() {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.gdH != null) {
            com.baidu.live.utils.h.U(this.gdH);
        }
    }

    public void bCQ() {
        if (this.gdH != null) {
            com.baidu.live.utils.h.V(this.gdH);
        }
    }

    public void onResume() {
        if (this.fIH != null) {
            this.fIH.byS();
            this.fIH.byV();
        }
        if (this.gdT != null) {
            this.gdT.enterForeground();
        }
        if (this.geb != null) {
            this.geb.onResume();
        }
        if (this.gec != null) {
            this.gec.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.u.a.ex(this.mTbPageContext.getPageActivity())) {
            if (this.isBackGround) {
                this.isBackGround = false;
                bCR();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void bCR() {
        bCL();
        bCK();
        this.fIH.bzh();
        if (!this.gdL.isPlaying()) {
            this.gdL.bDb();
        }
        if (this.gdT != null) {
            this.gdT.btq();
        }
        if (this.fIH != null && this.fIH.DN() != null && this.fIH.DN().mLiveInfo != null) {
            this.gdY.dI(this.fIH.DN().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aDE.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.fIH != null) {
            this.fIH.byT();
            this.fIH.byW();
        }
        if (this.gdT != null) {
            this.gdT.enterBackground();
        }
    }

    public void lh(boolean z) {
        this.isBackGround = true;
        li(z);
        if (this.mTbPageContext != null) {
            if ((this.mTbPageContext.getPageActivity() != null) & (this.mTbPageContext.getPageActivity().isFinishing() ? false : true)) {
                UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
            }
        }
    }

    public void li(boolean z) {
        this.mHandler.removeCallbacks(this.gek);
        this.mHandler.removeCallbacks(this.gel);
        this.mHandler.removeCallbacks(this.gem);
        if (!z) {
            this.gdL.asn();
        }
        if (this.gdT != null) {
            this.gdT.btp();
        }
        this.gdY.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ab.xm() != null) {
                ab.xm().a(i, i2, intent, this.aDE, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.gdT != null) {
            this.gdT.onActivityResult(i, i2, intent);
        }
    }

    public boolean bCS() {
        return this.gdS != null && this.gdS.boa();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gdL != null) {
            this.gdL.bM(true);
        }
        if (this.gdI != null) {
            this.gdI.onDestroy();
        }
        this.gdG.Hp();
        if (this.gdG != null) {
            this.gdG.release();
            this.gdG = null;
        }
        if (this.fIW != null) {
            this.fIW.bAH();
            this.fIW = null;
        }
    }

    public String Cr() {
        return this.otherParams;
    }

    public void bCT() {
        if (this.gdW != null) {
            this.otherParams = this.gdW.toString();
            if (this.fIH != null) {
                this.fIH.setOtherParams(this.otherParams);
            }
            if (this.gdT != null) {
                this.gdT.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.gdS != null) {
                this.gdS.setOtherParams(this.otherParams);
            }
        }
    }

    public void bCU() {
        if (this.gdW != null) {
            String optString = this.gdW.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gdW.put("tab", "live_jump");
                        this.gdW.put("tag", "");
                        this.gdW.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.gdW.put("tab", "liveroom");
                        this.gdW.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bCT();
            }
        }
    }

    private void c(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.Ap();
        }
        bVar.ab(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void bCV() {
        if (!bCX()) {
            if (this.mNetChangedDialog == null) {
                this.mNetChangedDialog = new BdAlertDialog(getPageContext().getPageActivity());
                this.mNetChangedDialog.setCanceledOnTouchOutside(false);
                this.mNetChangedDialog.setMessage(getPageContext().getResources().getString(a.i.ala_create_not_wifi));
                this.mNetChangedDialog.setPositiveButton(getPageContext().getResources().getString(a.i.sdk_liveroom_attention_guide_btn_text), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.13
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        b.this.bCY();
                        b.this.mNetChangedDialog.dismiss();
                    }
                });
                this.mNetChangedDialog = this.mNetChangedDialog.create(this.mTbPageContext);
                this.mNetChangedDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.player.b.14
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getRepeatCount() == 0) {
                            b.this.bCY();
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

    public void bCW() {
        if (this.mNetChangedDialog != null) {
            this.mNetChangedDialog.dismiss();
        }
    }

    public boolean bCX() {
        return this.mNetChangedDialog != null && this.mNetChangedDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCY() {
        onStart();
        bCZ();
    }

    public void bCZ() {
        u.xh();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gdT.d(s);
        } else {
            this.gdT.e(s);
        }
    }
}
