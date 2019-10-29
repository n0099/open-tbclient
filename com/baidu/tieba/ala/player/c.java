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
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.af;
import com.baidu.live.data.i;
import com.baidu.live.data.x;
import com.baidu.live.gift.q;
import com.baidu.live.k.a;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.message.f;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
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
import com.baidu.live.tbadk.coreextra.data.AlaLiveSwitchData;
import com.baidu.live.tbadk.log.ILiveGoodsLogger;
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
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.g;
import com.baidu.live.utils.l;
import com.baidu.live.utils.m;
import com.baidu.live.utils.n;
import com.baidu.live.utils.o;
import com.baidu.tieba.ala.liveroom.c.e;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.ala.liveroom.m.c;
import com.baidu.tieba.ala.liveroom.task.ActivityTaskWatchHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.baidu.tieba.ala.player.AlaLivePlayer;
import com.compatible.menukey.MenuKeyUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c extends BdBaseView<TbPageContext> {
    private i aaB;
    private String ajL;
    private long ajM;
    private b eBU;
    private AlaLiveRoomBlurPageLayout eBV;
    private AlaLoopViewPager eBW;
    private AlaLoopViewPagerAdapter eBX;
    private AlaLivePlayer eBY;
    private boolean eBZ;
    CustomMessageListener eCA;
    CustomMessageListener eCB;
    CustomMessageListener eCC;
    private boolean eCa;
    private boolean eCb;
    private boolean eCc;
    private ArrayList<AlaBroadcastGiftToastData> eCd;
    private String eCe;
    private com.baidu.tieba.ala.endliveroom.a eCf;
    private com.baidu.tieba.ala.liveroom.c.c eCg;
    private String eCh;
    private long eCi;
    private JSONObject eCj;
    private boolean eCk;
    private com.baidu.tieba.ala.liveroom.task.c eCl;
    private StayTimeBean eCm;
    private boolean eCn;
    private com.baidu.tieba.ala.liveroom.h.a eCo;
    private boolean eCp;
    private String eCq;
    private com.baidu.tieba.ala.liveroom.data.i eCr;
    private boolean eCs;
    private Runnable eCt;
    private Runnable eCu;
    private Runnable eCv;
    private AlaLivePlayer.a eCw;
    e eCx;
    ViewPager.OnPageChangeListener eCy;
    HttpMessageListener eCz;
    private com.baidu.tieba.ala.liveroom.m.c eiF;
    private AlaLiveView eiU;
    private long eiY;
    private c.a eji;
    private HttpMessageListener eky;
    private HttpMessageListener ekz;
    private boolean isBackGround;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String mUserName;
    private String otherParams;

    public c(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.eBZ = true;
        this.eiY = 0L;
        this.eCa = false;
        this.eCb = true;
        this.ajL = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.eCc = false;
        this.eCe = "0";
        this.mHandler = new Handler();
        this.eCi = -1L;
        this.otherParams = "";
        this.eCk = false;
        this.eCl = com.baidu.tieba.ala.liveroom.task.c.aWd();
        this.eCn = false;
        this.eCp = false;
        this.eCt = new Runnable() { // from class: com.baidu.tieba.ala.player.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aYy();
            }
        };
        this.eCu = new Runnable() { // from class: com.baidu.tieba.ala.player.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.aYx();
            }
        };
        this.eCv = new Runnable() { // from class: com.baidu.tieba.ala.player.c.10
            @Override // java.lang.Runnable
            public void run() {
                c.this.eiF.aVd();
            }
        };
        this.eCw = new AlaLivePlayer.a() { // from class: com.baidu.tieba.ala.player.c.11
            @Override // com.baidu.tieba.ala.player.AlaLivePlayer.a
            public void aS(int i) {
                if (c.this.eBV != null) {
                    if (ListUtils.getCount(c.this.eBY.getAlaLiveInfoDataList()) < 2) {
                        c.this.eBV.aWA();
                    } else {
                        c.this.eBV.aWB();
                    }
                }
                if (c.this.eCg != null) {
                    c.this.eCg.aS(i);
                }
            }
        };
        this.eCx = new e() { // from class: com.baidu.tieba.ala.player.c.14
            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void aPK() {
                if (c.this.eCg == null || c.this.eCg.aPG()) {
                    c.this.iw(true);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void hD(boolean z) {
                c.this.d(c.this.aaB, z);
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void O(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                c.this.eBY.aYh();
                if (arrayList != null && !arrayList.isEmpty()) {
                    c.this.eBY.P(arrayList);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void A(boolean z, boolean z2) {
                if (c.this.eBW != null) {
                    c.this.eBW.setIsScrollable(c.this.eCs && z);
                    c.this.eBW.setEnabled(z2);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void hE(boolean z) {
                boolean z2 = true;
                if (!z || c.this.aYG()) {
                    if (c.this.eBV != null) {
                        c.this.eBV.aWD();
                        return;
                    }
                    return;
                }
                if (c.this.eiF.uj().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(c.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (c.this.eBV != null) {
                    c.this.eBV.ik(z2);
                }
            }
        };
        this.eCy = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.c.15
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.mTbPageContext != null && c.this.mTbPageContext.getPageActivity() != null && !c.this.mTbPageContext.getPageActivity().isFinishing() && c.this.eiU != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        c.this.eBW.setCurrentItem(c.this.mSelectedPosition);
                        return;
                    }
                    com.baidu.live.c.np().putBoolean("ala_live_play_has_up_down_scrolled", true);
                    if (c.this.eCb || ListUtils.getCount(c.this.eiF.aVc()) > 1) {
                        int i2 = (i - c.this.mSelectedPosition == 2 || i - c.this.mSelectedPosition == -1) ? -1 : 1;
                        if (c.this.eiF.aVf() == 1) {
                            if (!c.this.eiF.aVi() || i2 >= 0) {
                                if (c.this.eiF.aVj() && i2 > 0) {
                                    c.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    c.this.eBW.setCurrentItem(c.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                c.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                c.this.eBW.setCurrentItem(c.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        c.this.eiF.cancelLoadData();
                        c.this.mHandler.removeCallbacksAndMessages(null);
                        c.this.hy(true);
                        c.this.eBV.aWy();
                        c.this.eBV.aRM();
                        c.this.eBV.aWz();
                        if (c.this.eiF.uj() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(c.this.eiF.uj().mLiveInfo.live_id + "", c.this.eiF.uj().mLiveInfo.room_id + "", c.this.eiF.uj().Ps.userId + "", c.this.eiF.uj().Ps.userName, System.currentTimeMillis(), c.this.eiF.uj().mLiveInfo.feed_id, c.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(c.this.eiF.uj().mLiveInfo.live_id + "", c.this.eiF.uj().mLiveInfo.room_id + "", c.this.eiF.uj().Ps.userId + "", c.this.eiF.uj().Ps.userName, System.currentTimeMillis(), c.this.eiF.uj().mLiveInfo.feed_id, c.this.otherParams);
                            }
                        }
                        if (c.this.eCm != null) {
                            long j = c.this.eiF.uj().mLiveInfo.live_id;
                            if (c.this.eCm.liveId == j && c.this.eCm.startTime > 0) {
                                c.this.eCm.endTime = System.currentTimeMillis();
                                long j2 = c.this.eCm.endTime - c.this.eCm.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", c.this.eCm.roomId + "", c.this.eCm.vid, j2 / 1000, c.this.otherParams);
                            }
                            c.this.eCm = null;
                        }
                        c.this.aYI();
                        com.baidu.tieba.ala.liveroom.task.b.aWc().release();
                        c.this.mSelectedPosition = i;
                        c.this.eBV = c.this.eBX.nC(c.this.mSelectedPosition);
                        c.this.eBV.aWC();
                        c.this.on(i2);
                        return;
                    }
                    c.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                    c.this.eBW.setCurrentItem(c.this.mSelectedPosition);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.np().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.eji = new c.a() { // from class: com.baidu.tieba.ala.player.c.16
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    c.this.p(c.this.eiF.uj());
                } else if (i2 == 2) {
                    c.this.f(c.this.eiF.aKy());
                } else if (i2 == 3) {
                    c.this.af(i, str);
                } else if (i2 == 4) {
                    c.this.ak(obj);
                } else if (i2 == 5) {
                    c.this.aYw();
                }
            }
        };
        this.eCz = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.aWb() != null && c.this.mTbPageContext != null) {
                        c.this.eCl.a(c.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.aWb());
                    }
                }
            }
        };
        this.eCA = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                BuyTBeanActivityConfig buyTBeanActivityConfig = new BuyTBeanActivityConfig(c.this.mTbPageContext.getPageActivity(), 0L, c.this.otherParams, true, TbadkCoreApplication.getInst().isHaokan() ? "join_guardian" : "guard", true);
                buyTBeanActivityConfig.setIsFromJoinGuardclub(true);
                buyTBeanActivityConfig.setRequestCode(RequestResponseCode.REQUEST_BUY_TBEAN_FROM_JOIN_GUARDCLUB);
                buyTBeanActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, buyTBeanActivityConfig));
            }
        };
        this.eCB = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.mTbPageContext != null && c.this.eiF != null && c.this.eiF.uj() != null && c.this.eiF.uj().mLiveInfo != null) {
                    long j = c.this.eiF.uj().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    com.baidu.tieba.ala.liveroom.task.b.aWc().a(c.this.mTbPageContext.getPageActivity(), j, iArr);
                }
            }
        };
        this.ekz = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = c.this.eiF.uj().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.akf != null && !eventPollingHttpResponseMessage.akf.isEmpty() && c.this.eiF != null && c.this.eiF.uj() != null && c.this.eiF.uj().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.Pp;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.akf.size()) {
                                break;
                            }
                            x xVar = eventPollingHttpResponseMessage.akf.get(i2);
                            if (j == xVar.liveId && j2 - xVar.createTime <= 60 && !l.g(xVar.liveId, xVar.id)) {
                                l.a(xVar, c.this.eiF.uj().mLiveInfo);
                                l.h(xVar.liveId, xVar.id);
                            }
                            i = i2 + 1;
                        }
                        x xVar2 = eventPollingHttpResponseMessage.akf.get(eventPollingHttpResponseMessage.akf.size() - 1);
                        if (j == xVar2.liveId) {
                            l.f(xVar2.liveId, xVar2.id);
                        }
                    }
                    int i3 = eventPollingHttpResponseMessage.ake;
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.c.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.eiF != null && c.this.eiF.uj() != null) {
                                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                    l.i(c.this.eiF.uj().mLiveInfo.user_id, c.this.eiF.uj().mLiveInfo.live_id);
                                }
                            }
                        }
                    }, i3 * 1000);
                }
            }
        };
        this.eky = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof f)) {
                        f fVar = (f) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (c.this.eiF != null && c.this.eiF.uj() != null) {
                            long j = c.this.eiF.uj().mLiveInfo.live_id;
                            if (j == fVar.liveId) {
                                getVideoGoodsListHttpResponseMessage.liveId = j;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                                if (!c.this.eCn) {
                                    c.this.eCn = true;
                                    String str = "goods_task_" + j;
                                    af afVar = com.baidu.live.l.a.uA().akM;
                                    long j2 = (afVar == null || afVar.Ui == null) ? 10L : afVar.Ui.Vp;
                                    if (j2 <= 0) {
                                        j2 = 10;
                                    }
                                    LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.c.7.1
                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onComplete(boolean z) {
                                            if (c.this.eiF != null && c.this.eiF.uj() != null && c.this.eiF.uj().mLiveInfo.live_id != m.arv) {
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, c.this.eiF.uj().mLiveInfo));
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
        this.eCC = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (c.this.mTbPageContext != null && c.this.eiF != null && c.this.eiF.uj() != null && c.this.eiF.uj().PN != null) {
                        if (l.longValue() == c.this.eiF.uj().PN.userId) {
                            c.this.eiF.uj().PN.isNewUser = false;
                            if (c.this.eCo != null) {
                                c.this.eCo.j(c.this.eiF.uj());
                            }
                        }
                    }
                }
            }
        };
        this.eiY = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.eBU = bVar;
        this.eBZ = true;
        this.eiF = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.eiF.a(this.eji);
        this.eCf = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.eCz);
        MessageManager.getInstance().registerListener(this.eCA);
        MessageManager.getInstance().registerListener(this.eCB);
        MessageManager.getInstance().registerListener(this.ekz);
        MessageManager.getInstance().registerListener(this.eky);
        MessageManager.getInstance().registerListener(this.eCC);
    }

    private void am(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.eCd = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.eCd.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void an(Intent intent) {
        am(intent);
        this.ajL = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.ajL)) {
            this.ajL = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.mUserName = intent.getStringExtra("user_name");
        this.eCh = intent.getStringExtra("room_id");
        this.ajM = intent.getLongExtra("live_id", 0L);
        this.eCk = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.eiF.b((AlaLiveInfoCoreData) serializableExtra);
            this.eCk = true;
        }
        ao(intent);
        this.eCs = this.eCr == null || !this.eCr.egj;
        this.eCf.setOtherParams(this.otherParams);
        this.eCc = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        aYl();
        aYk();
    }

    private void ao(Intent intent) {
        try {
            AlaLiveSwitchData.isHotLive = 0;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.eCj = new JSONObject(stringExtra);
                if (this.eCj != null) {
                    String optString = this.eCj.optString("enterRoomId");
                    String optString2 = this.eCj.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.eCh, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.ajM + "", optString2))) {
                        String optString3 = this.eCj.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, HTTP.UTF_8) : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.eCj.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, HTTP.UTF_8);
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.eCk) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.ajM;
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                if (optString4.toLowerCase().endsWith(".flv")) {
                                    alaLiveInfoCoreData.flvUrl = optString4;
                                } else if (optString4.toLowerCase().endsWith(".m3u8")) {
                                    alaLiveInfoCoreData.hlsUrl = optString4;
                                } else if (optString4.toLowerCase().startsWith("rtmp://")) {
                                    alaLiveInfoCoreData.rtmpUrl = optString4;
                                }
                            }
                            this.eiF.b(alaLiveInfoCoreData);
                            this.eCk = true;
                        }
                    }
                    String optString5 = this.eCj.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.eCr = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        this.eCr = new com.baidu.tieba.ala.liveroom.data.i();
                        this.eCr.egj = jSONObject.optInt("is_hot") == 1;
                        if (this.eCr.egj) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.eCr.egk = jSONObject.optString("task_id");
                        this.eCr.egi = TextUtils.isEmpty(this.eCr.egk) ? false : true;
                        this.eCr.egl = jSONObject.optInt("task_type");
                        this.eCr.egm = jSONObject.optInt("task_im_count");
                        this.eCr.egn = jSONObject.optLong("task_gift_total_price");
                        this.eCr.ego = jSONObject.optLong("task_watch_time");
                        this.eCr.egp = jSONObject.optString("task_activity_scheme");
                    }
                    this.eCe = this.eCj.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.eCj.remove("cover");
                    this.eCj.remove("live_url");
                    this.eCj.remove("enterRoomId");
                    this.eCj.remove("enterLiveId");
                    this.eCj.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.eCj.remove("extra");
                    this.otherParams = this.eCj.toString();
                    this.eiF.setOtherParams(this.otherParams);
                    String optString6 = this.eCj.optString("live_enter_type");
                    int optInt = this.eCj.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(optString6)) {
                        TbConfig.setLiveEnterFrom(optString6);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.eiF.nV(optInt);
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

    public void aYk() {
        if (!TextUtils.isEmpty(this.mUserName)) {
            this.eiF.P(this.mUserName, this.ajL, this.mForumName);
        } else if (this.eiF.uj() != null && this.eiF.uj().mLiveInfo != null && this.eiF.uj().mLiveInfo.live_id > 0) {
            this.eiF.a(this.eiF.uj().mLiveInfo.live_id, false, this.ajL, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uname=")) {
                this.mUserName = WebviewHelper.getMatchStringFromURL(lowerCase, "uname=");
            }
            if (lowerCase.contains("from=")) {
                this.ajL = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.mUserName == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                iw(false);
                return;
            }
            this.eiF.P(this.mUserName, this.ajL, this.mForumName);
        } else if (!TextUtils.isEmpty(this.eCh)) {
            this.eiF.tT(this.eCh);
        } else if (this.ajM > 0) {
            this.eiF.a(this.ajM, false, this.ajL, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            iw(false);
        }
    }

    private void aYl() {
        this.eCb = true;
        this.eCa = false;
        aYm();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        e(visibilityRegion);
        f(visibilityRegion);
        this.eCg = new com.baidu.tieba.ala.liveroom.c.c();
        this.eCg.a(this.eCx);
        this.eCg.setOtherParams(this.otherParams);
        aYn();
        aYo();
    }

    private void aYm() {
        TiebaInitialize.log("c11863");
        this.eBW = (AlaLoopViewPager) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.eBW.setOnPageChangeListener(this.eCy);
        this.eBW.setBoundaryCaching(true);
        this.eBW.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(this.eBW, new LinearLayout.LayoutParams(-1, -1));
        this.eBX = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.eBX.aSR();
        this.eBV = this.eBX.nB(this.mSelectedPosition);
        this.eBX.a(this.mSelectedPosition, this.eiF.uj());
        this.eBW.setAdapter(this.eBX);
        this.eBW.setCurrentItem(this.mSelectedPosition);
        this.eBW.setIsScrollable(this.eCs);
    }

    private void e(Rect rect) {
        this.eBY = AlaLivePlayer.m24do(getPageContext().getPageActivity());
        if (this.eBY == null) {
            this.eBW.setIsScrollable(false);
            if (this.eiF != null) {
                this.eiF.cancelLoadData();
            }
            aSU();
            return;
        }
        if (this.eCc) {
            this.eBW.setIsScrollable(false);
        }
        this.eBY.setPageContext(getPageContext());
        this.eBY.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.eBY.setIPlayerCallBack(this.eCw);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.eBV.a(this.eBY, layoutParams, true);
    }

    private void aSU() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.c.12
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                c.this.iw(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void f(Rect rect) {
        this.eiU = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.eiU.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.eBV.a(this.eiU, layoutParams);
    }

    private void aYn() {
        if (this.eiF != null && this.eiF.uj() != null) {
            this.aaB = this.eiF.uj();
            if (this.aaB.mLiveInfo != null) {
                a(this.aaB.mLiveInfo, this.eCk);
                if (this.aaB.mLiveInfo != null && this.aaB.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit");
                    }
                    this.eBY.f(this.aaB.mLiveInfo);
                    if (this.eCg != null) {
                        short s = this.aaB.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2;
                        this.eCg.a(this.mTbPageContext, this.eiU, this.eBY, this.eBV, this.eiF, this.ajL, this.eCc, this.eiY, this.eCd, this.eCr);
                        this.eCg.c(s);
                    }
                }
            }
        }
    }

    private void aYo() {
        this.mTbPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.player.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (c.this.aaB != null && c.this.aaB.Ps != null && c.this.aaB.Ps.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + c.this.aaB.mLiveInfo.live_id);
                        c.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.c.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", c.this.aaB.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                }
            }
        });
    }

    private void aYp() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.eCc || !this.eCs) {
                this.eBW.setIsScrollable(false);
            } else {
                this.eBW.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && (this.eCg == null || !this.eCg.aPF())) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                aYp();
            } else if (this.eCg == null || this.eCg.aPG()) {
                iw(true);
            }
        }
        return true;
    }

    public void iw(boolean z) {
        F(z, false);
    }

    public void F(boolean z, boolean z2) {
        hy(!z);
        if (this.eBY != null) {
            this.eBY.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        aYr();
        long j = -1;
        if (this.eiF != null && this.eiF.aVn() != null) {
            j = this.eiF.aVn().room_id;
        }
        this.eBU.a(z, z2, j);
    }

    public void hy(boolean z) {
        AlaLiveInfoData aVn;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        AlaLiveSwitchData.isHotLive = 0;
        com.baidu.tieba.ala.liveroom.yuangift.a.aWZ().aAm();
        com.baidu.tieba.ala.liveroom.task.b.aWc().release();
        if (this.eCo != null) {
            this.eCo.release();
        }
        this.eCr = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.eiF != null && (aVn = this.eiF.aVn()) != null) {
            this.eiF.cl(aVn.live_id);
        }
        this.eCl.stopRecord();
        LiveTimerManager.getInstance().stop();
        aYq();
        if (this.eBY != null) {
            this.eBY.iv(z);
        }
        if (this.eCg != null) {
            this.eCg.hy(z);
        }
        this.eCn = false;
        m.arv = 0L;
    }

    private void aYq() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void aYr() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void b(i iVar) {
        if (iVar != null) {
            this.aaB = iVar;
            if (this.eCg != null) {
                this.eCg.b(iVar);
            }
        }
    }

    private void c(com.baidu.live.data.e eVar) {
        if (this.eCg != null) {
            this.eCg.c(eVar);
        }
    }

    private void o(i iVar) {
        this.aaB = iVar;
    }

    private void aYs() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.eBW.setIsScrollable(false);
        }
        if (this.aaB != null) {
            a(this.aaB.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.eBV.a(this.eiU, null);
            a(this.eBV, this.aaB.mLiveInfo, this.eCb);
            this.eCb = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.eiF != null && this.eiF.uj() != null && this.eiF.uj().mLiveInfo != null) {
                    j = this.eiF.uj().mLiveInfo.live_id;
                    str2 = this.eiF.uj().mLiveInfo.room_id + "";
                    str = this.eiF.uj().mLiveInfo.feed_id;
                } else {
                    if (this.ajM > 0) {
                        j2 = this.ajM;
                    }
                    if (!TextUtils.isEmpty(this.eCh)) {
                        j = j2;
                        str = "";
                        str2 = this.eCh;
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
                return;
            }
            AlaStaticItem alaStaticItem2 = new AlaStaticItem(SdkStaticKeys.ACTION_PLAYSTART_LIVE);
            String str3 = "";
            String str4 = "";
            String str5 = "";
            String str6 = "";
            if (this.eiF != null && this.eiF.uj() != null && this.eiF.uj().mLiveInfo != null) {
                str3 = this.eiF.uj().mLiveInfo.feed_id;
                str4 = this.eiF.uj().mLiveInfo.live_id + "";
                str5 = this.eiF.uj().mLiveInfo.room_id + "";
                str6 = this.eiF.uj().mLiveInfo.user_name;
            }
            alaStaticItem2.addParams("author", str6);
            alaStaticItem2.addParams("feed_id", str3);
            alaStaticItem2.addParams("live_id", str4);
            alaStaticItem2.addParams("room_id", str5);
            alaStaticItem2.addParams("other_params", this.otherParams);
            AlaStaticsManager.getInst().onStatic(alaStaticItem2);
        }
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (this.eBY != null && this.eBY.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.eBY.getVideoPath();
                String e = a.e(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.eBY.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + e);
                }
                if (!this.eBY.isPlaying() || TextUtils.isEmpty(videoPath) || !videoPath.equals(e)) {
                    if (!z && !alaLiveRoomBlurPageLayout.bA(this.eBY)) {
                        ((ViewGroup) this.eBY.getParent()).removeView(this.eBY);
                        alaLiveRoomBlurPageLayout.a(this.eBY, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    this.eBY.f(alaLiveInfoData);
                    return;
                }
                return;
            }
            this.eBY.aYh();
        } else if (this.eBY != null && this.eBY.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.eBY, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                this.eBY.f(alaLiveInfoData);
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.eBY != null) {
            this.eBY.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = n.r(this.mTbPageContext.getPageActivity());
                layoutParams.height = n.s(this.mTbPageContext.getPageActivity());
                int ay = n.ay(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = ay + i;
                } else {
                    dimensionPixelSize = ay + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void aYt() {
        this.eCb = true;
    }

    private void a(AlaLiveInfoData alaLiveInfoData, boolean z) {
        boolean z2;
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
        if (z2) {
            if (realScreenOrientation == 1) {
                this.eBV.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.eBV.setBackgroundColor(0);
            }
        } else {
            this.eBV.setBackgroundColor(0);
        }
        a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.eiU != null) {
            this.eiU.setLayoutParams(c);
        }
        if (this.eBV != null) {
            this.eBV.aO(screenFullSize[0], screenFullSize[1]);
        }
        if (this.eCf != null) {
            this.eCf.aO(screenFullSize[0], screenFullSize[1]);
        }
        if (this.eCg != null) {
            this.eCg.E(c.width, c.height, realScreenOrientation);
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

    private void nI(int i) {
        boolean z = true;
        if (this.aaB != null && this.aaB.mLiveInfo != null) {
            this.eBV.setBgImageUrl(this.aaB.mLiveInfo.cover, this.aaB.mLiveInfo);
            this.eBX.a(this.mSelectedPosition, aYu(), this.aaB);
            this.eBX.b(this.mSelectedPosition, aYv(), this.aaB);
            this.eBV.requestLayout();
            this.eBV.z(i, this.aaB.mLiveInfo.screen_direction == 2);
        }
        if (this.aaB != null) {
            a(this.aaB.mLiveInfo, false);
        }
        boolean aWE = this.eBV.aWE();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.aaB == null || this.aaB.mLiveInfo == null || this.aaB.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!aYG()) {
            if (this.eBY != null && this.eBY.getParent() == null) {
                this.eBV.a(this.eBY, null, false);
                if (this.aaB.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    this.eBY.f(this.aaB.mLiveInfo);
                }
            }
            if (aWE && !aYG() && this.eCg != null) {
                this.eBV.ik(z);
                return;
            }
            return;
        }
        this.eBV.aWy();
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

    private void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.eiF.a(alaLiveInfoData.live_id, true, this.ajL, this.mForumName);
            this.eiF.ck(alaLiveInfoData.live_id);
        }
    }

    public void on(int i) {
        short s;
        if (i < 0) {
            this.eiF.nW(this.eiF.aVk() - 1);
        } else if (i > 0) {
            this.eiF.nW(this.eiF.aVk() + 1);
        }
        if (this.eCg != null) {
            this.eCg.b(this.eBV);
        }
        this.eBX.a(this.mSelectedPosition, aYu(), this.aaB);
        this.eBX.b(this.mSelectedPosition, aYv(), this.aaB);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.eiF != null) {
            int aVk = this.eiF.aVk();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", aVk + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.eiF.aVc() != null && this.eiF.aVc().size() > aVk && this.eiF.aVc().get(aVk) != null) {
                AlaLiveInfoData alaLiveInfoData = this.eiF.aVc().get(aVk);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.eiF != null) {
            AlaLiveInfoData aVn = this.eiF.aVn();
            if (aVn != null) {
                aVn.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.eBV, aVn, this.eCb);
                this.eCb = false;
                if (this.eCg != null) {
                    if (aVn.screen_direction != 2) {
                        s = 2;
                    } else {
                        s = 1;
                    }
                    this.eCg.a(this.mTbPageContext, this.eiU, this.eBY, this.eBV, this.eiF, this.ajL, this.eCc, this.eiY, null, this.eCr);
                    this.eCg.c(s);
                }
                a(aVn, false);
            }
            g(aVn);
            this.eBV.a(this.eiU, null);
            if (this.eCg != null) {
                this.eCg.aPD();
            }
            this.eiF.c(aVn);
        }
    }

    private AlaLiveInfoData aYu() {
        List<AlaLiveInfoData> aVc = this.eiF.aVc();
        if (aVc == null || aVc.size() == 0) {
            if (this.aaB == null) {
                return null;
            }
            return this.aaB.mLiveInfo;
        }
        int aVk = this.eiF.aVk();
        int size = aVc.size();
        return aVc.get(((aVk + size) - 1) % size);
    }

    private AlaLiveInfoData aYv() {
        List<AlaLiveInfoData> aVc = this.eiF.aVc();
        if (aVc == null || aVc.size() == 0) {
            if (this.aaB == null) {
                return null;
            }
            return this.aaB.mLiveInfo;
        }
        return aVc.get((this.eiF.aVk() + 1) % aVc.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(int i, String str) {
        af afVar;
        short s;
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
            iw(false);
            return;
        }
        i uj = this.eiF.uj();
        o(uj);
        this.eiF.aVd();
        if (this.eCb) {
            this.eiF.ie(false);
        }
        this.eiY = System.currentTimeMillis() / 1000;
        if (this.eCg != null) {
            if (uj.mLiveInfo.screen_direction != 2) {
                s = 2;
            } else {
                s = 1;
            }
            this.eCg.a(this.mTbPageContext, this.eiU, this.eBY, this.eBV, this.eiF, this.ajL, this.eCc, this.eiY, this.eCd, this.eCr);
            this.eCg.c(s);
        }
        aYs();
        if (uj != null && uj.mLiveInfo != null && uj.mLiveInfo.live_status == 2) {
            d(uj, false);
            this.eCb = false;
            return;
        }
        if (!this.eCp || !TextUtils.equals(o.wv(), this.eCq)) {
            q.b(getPageContext());
            com.baidu.live.l.c.uG().uH();
            this.eCp = true;
            this.eCq = o.wv();
        }
        this.eCn = false;
        if (this.eiF.uj() != null && this.eiF.uj().mLiveInfo != null) {
            String str2 = this.eiF.uj().mLiveInfo.feed_id;
            long j = this.eiF.uj().mLiveInfo.live_id;
            long j2 = this.eiF.uj().mLiveInfo.user_id;
            this.eiF.ck(j);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                l.i(j2, j);
            }
            m.i(str2, j);
        }
        if (this.eCg != null) {
            this.eCg.hx(TextUtils.equals(this.eCe, "1"));
            this.eCe = "";
        }
        b(this.eiF.uj());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mTbPageContext != null && c.this.eiF.uj() != null && c.this.eiF.uj().mLiveInfo != null) {
                    c.this.eiF.a(c.this.eiF.uj().mLiveInfo.live_id, c.this.ajL, c.this.eiY);
                }
            }
        }, this.eiF.uj().Pw);
        if (this.eiF.uj() != null && this.eiF.uj().Ps != null && (afVar = com.baidu.live.l.a.uA().akM) != null && afVar.Uh != null && afVar.Uh.Vm) {
            b(true, this.eiF.uj().Ps.userId);
        }
        this.eCb = false;
        if (this.eiF.uj() != null && this.eiF.uj().mLiveInfo != null && this.eiF.uj().Ps != null) {
            long j3 = this.eiF.uj().mLiveInfo.live_id;
            long j4 = this.eiF.uj().mLiveInfo.room_id;
            String str3 = this.eiF.uj().mLiveInfo.feed_id;
            com.baidu.tieba.ala.liveroom.yuangift.a.aWZ().a(this.mTbPageContext.getPageActivity(), j3, "oneYuanGift_" + j3, j4, str3, this.otherParams);
            com.baidu.tieba.ala.liveroom.task.b.aWc().a(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            com.baidu.tieba.ala.guardclub.a.aLg().a(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            if (this.eCo == null) {
                this.eCo = new com.baidu.tieba.ala.liveroom.h.a();
            }
            this.eCo.a(this.mTbPageContext.getPageActivity(), this.eiF.uj(), this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYw() {
        if (this.eBZ) {
            this.eBX.a(this.mSelectedPosition, aYu(), this.aaB);
            this.eBX.b(this.mSelectedPosition, aYv(), this.aaB);
            this.eBZ = false;
        }
        if (this.eCf != null && aYG()) {
            this.eCf.M(this.eiF.aVe());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.eCv);
            this.mHandler.postDelayed(this.eCv, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.e eVar) {
        if (eVar != null) {
            if (!this.eCa) {
                c(eVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.eCu);
                this.mHandler.postDelayed(this.eCu, eVar.getInterval());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYx() {
        if (this.eiF.uj() != null && this.eiF.uj().mLiveInfo != null) {
            this.eiF.ck(this.eiF.uj().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(i iVar) {
        if (iVar != null && iVar.mLiveInfo != null && iVar.mLiveInfo.live_status == 2) {
            this.eBX.a(this.mSelectedPosition, this.eiF.uj());
            d(iVar, false);
        } else if (iVar != null) {
            if (!this.eCa) {
                b(iVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.eCt);
                this.mHandler.postDelayed(this.eCt, iVar.Pw);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYy() {
        if (this.mTbPageContext != null && this.eiF.uj() != null && this.eiF.uj().mLiveInfo != null) {
            this.eiF.a(this.eiF.uj().mLiveInfo.live_id, this.ajL, this.eiY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(i iVar, boolean z) {
        hy(true);
        if (!aYG()) {
            this.eiF.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            this.eBV.aRM();
            this.eBV.aWy();
            this.eBV.aWF();
            if (iVar != null && iVar.mLiveInfo != null) {
                this.eCi = iVar.mLiveInfo.live_id;
            }
            aYp();
            aYz();
            aYA();
            if (iVar != null) {
                this.eCf.a(iVar, this.ajL, this.eiF.aVe(), this.mForumName, z);
                this.eCf.a(this.eBV);
                if (this.eCg != null) {
                    this.eCg.hy(false);
                    this.eCg.aPE();
                }
                this.eBV.aWC();
                long j = iVar.mLiveInfo.live_id;
                long j2 = iVar.mLiveInfo.room_id;
                String str = iVar.mLiveInfo.feed_id;
                long j3 = iVar.Ps.userId;
                String str2 = iVar.Ps.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.eCm = new StayTimeBean();
                this.eCm.liveId = iVar.mLiveInfo.live_id;
                this.eCm.roomId = iVar.mLiveInfo.room_id;
                this.eCm.vid = iVar.mLiveInfo.feed_id;
                this.eCm.startTime = System.currentTimeMillis();
            }
            aYI();
        }
    }

    private void aYz() {
    }

    private void aYA() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.eBW);
        }
    }

    public void aYB() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            aYC();
        } else {
            aYD();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.eiF != null && this.eiF.uj() != null) {
            alaLiveInfoData = this.eiF.uj().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            aYC();
        } else {
            aYD();
        }
        this.eBW.setIsScrollable(!z);
        if (this.eCg != null) {
            this.eCg.onKeyboardVisibilityChanged(z);
        }
        if (this.eiU != null) {
            this.eiU.onKeyboardVisibilityChanged(z);
        }
    }

    public void bw(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            aYC();
        } else {
            aYD();
        }
        this.eiU.bw(realScreenOrientation);
        nI(realScreenOrientation);
        com.baidu.tieba.ala.liveroom.yuangift.a.aWZ().pC();
        if (this.eCo != null) {
            this.eCo.pC();
        }
    }

    public void aYC() {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.eBW != null) {
            g.P(this.eBW);
        }
    }

    public void aYD() {
        if (this.eBW != null) {
            g.Q(this.eBW);
        }
    }

    public void onResume() {
        if (this.eiF != null) {
            this.eiF.aUR();
        }
        if (this.eCg != null) {
            this.eCg.enterForeground();
        }
        if (this.eCo != null) {
            this.eCo.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.r.a.dm(this.mTbPageContext.getPageActivity()) && this.isBackGround) {
            this.isBackGround = false;
            aYE();
        }
    }

    public void aYE() {
        aYy();
        aYx();
        this.eiF.aVd();
        this.eBY.aYi();
        if (this.eCg != null) {
            this.eCg.aPI();
        }
        if (this.eiF != null && this.eiF.uj() != null && this.eiF.uj().mLiveInfo != null) {
            this.eCl.cn(this.eiF.uj().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aaB.mLiveInfo.live_id);
        }
    }

    public void onPause() {
        if (this.eiF != null) {
            this.eiF.aUS();
        }
        if (this.eCg != null) {
            this.eCg.enterBackground();
        }
    }

    public void onStop() {
        this.isBackGround = true;
        aYF();
    }

    public void aYF() {
        this.mHandler.removeCallbacks(this.eCt);
        this.mHandler.removeCallbacks(this.eCu);
        this.mHandler.removeCallbacks(this.eCv);
        this.eBY.pausePlay();
        if (this.eCg != null) {
            this.eCg.aPH();
        }
        this.eCl.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            com.baidu.tieba.ala.liveroom.yuangift.a.aWZ().a(i, i2, intent, this.aaB, this.otherParams);
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.eCg != null) {
            this.eCg.onActivityResult(i, i2, intent);
        }
    }

    public boolean aYG() {
        return this.eCf != null && this.eCf.aKI();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eCz != null) {
            MessageManager.getInstance().unRegisterListener(this.eCz);
        }
        if (this.eCA != null) {
            MessageManager.getInstance().unRegisterListener(this.eCA);
        }
        MessageManager.getInstance().unRegisterListener(this.eCB);
        MessageManager.getInstance().unRegisterListener(this.ekz);
        MessageManager.getInstance().unRegisterListener(this.eky);
        MessageManager.getInstance().unRegisterListener(this.eCC);
        com.baidu.tieba.ala.liveroom.task.b.aWc().release();
        if (this.eBY != null) {
            this.eBY.iv(true);
        }
        if (this.eCg != null) {
            this.eCg.onDestory();
        }
        if (this.eBX != null) {
            this.eBX.onDestroy();
        }
        this.eBV.aRM();
        if (this.eBV != null) {
            this.eBV.release();
            this.eBV = null;
        }
        if (this.eCf != null) {
            this.eCf.onDestroy();
            this.eCf = null;
        }
        if (this.eCm != null && this.eiF != null && this.eiF.uj() != null) {
            long j = this.eiF.uj().mLiveInfo.live_id;
            if (this.eCm.liveId == j && this.eCm.startTime > 0) {
                this.eCm.endTime = System.currentTimeMillis();
                long j2 = this.eCm.endTime - this.eCm.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.eCm.roomId + "", this.eCm.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.eCm = null;
        }
        if (this.eiU != null) {
            this.eiU.aWH();
            this.eiU = null;
        }
        if (this.eiF != null) {
            this.eiF.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        l.ws();
        com.baidu.live.gift.o.pI().release();
    }

    public String tm() {
        return this.otherParams;
    }

    public void aYH() {
        if (this.eCj != null) {
            this.otherParams = this.eCj.toString();
            if (this.eiF != null) {
                this.eiF.setOtherParams(this.otherParams);
            }
            if (this.eCg != null) {
                this.eCg.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            this.eCf.setOtherParams(this.otherParams);
        }
    }

    public void aYI() {
        if (this.eCj != null) {
            String optString = this.eCj.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.eCj.put("tab", "live_jump");
                        this.eCj.put("tag", "");
                        this.eCj.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.eCj.put("tab", "liveroom");
                        this.eCj.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aYH();
            }
        }
    }

    private void b(boolean z, long j) {
        com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
        if (z) {
            dVar.aLC();
        }
        dVar.ca(j);
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }
}
