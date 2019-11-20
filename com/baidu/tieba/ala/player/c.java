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
    private i aaj;
    private String ajt;
    private long aju;
    private com.baidu.tieba.ala.liveroom.data.i eBA;
    private boolean eBB;
    private Runnable eBC;
    private Runnable eBD;
    private Runnable eBE;
    private AlaLivePlayer.a eBF;
    e eBG;
    ViewPager.OnPageChangeListener eBH;
    HttpMessageListener eBI;
    CustomMessageListener eBJ;
    CustomMessageListener eBK;
    CustomMessageListener eBL;
    private b eBd;
    private AlaLiveRoomBlurPageLayout eBe;
    private AlaLoopViewPager eBf;
    private AlaLoopViewPagerAdapter eBg;
    private AlaLivePlayer eBh;
    private boolean eBi;
    private boolean eBj;
    private boolean eBk;
    private boolean eBl;
    private ArrayList<AlaBroadcastGiftToastData> eBm;
    private String eBn;
    private com.baidu.tieba.ala.endliveroom.a eBo;
    private com.baidu.tieba.ala.liveroom.c.c eBp;
    private String eBq;
    private long eBr;
    private JSONObject eBs;
    private boolean eBt;
    private com.baidu.tieba.ala.liveroom.task.c eBu;
    private StayTimeBean eBv;
    private boolean eBw;
    private com.baidu.tieba.ala.liveroom.h.a eBx;
    private boolean eBy;
    private String eBz;
    private com.baidu.tieba.ala.liveroom.m.c ehO;
    private AlaLiveView eid;
    private long eih;
    private c.a eir;
    private HttpMessageListener ejH;
    private HttpMessageListener ejI;
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
        this.eBi = true;
        this.eih = 0L;
        this.eBj = false;
        this.eBk = true;
        this.ajt = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.eBl = false;
        this.eBn = "0";
        this.mHandler = new Handler();
        this.eBr = -1L;
        this.otherParams = "";
        this.eBt = false;
        this.eBu = com.baidu.tieba.ala.liveroom.task.c.aWb();
        this.eBw = false;
        this.eBy = false;
        this.eBC = new Runnable() { // from class: com.baidu.tieba.ala.player.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aYw();
            }
        };
        this.eBD = new Runnable() { // from class: com.baidu.tieba.ala.player.c.9
            @Override // java.lang.Runnable
            public void run() {
                c.this.aYv();
            }
        };
        this.eBE = new Runnable() { // from class: com.baidu.tieba.ala.player.c.10
            @Override // java.lang.Runnable
            public void run() {
                c.this.ehO.aVb();
            }
        };
        this.eBF = new AlaLivePlayer.a() { // from class: com.baidu.tieba.ala.player.c.11
            @Override // com.baidu.tieba.ala.player.AlaLivePlayer.a
            public void aS(int i) {
                if (c.this.eBe != null) {
                    if (ListUtils.getCount(c.this.eBh.getAlaLiveInfoDataList()) < 2) {
                        c.this.eBe.aWy();
                    } else {
                        c.this.eBe.aWz();
                    }
                }
                if (c.this.eBp != null) {
                    c.this.eBp.aS(i);
                }
            }
        };
        this.eBG = new e() { // from class: com.baidu.tieba.ala.player.c.14
            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void aPI() {
                if (c.this.eBp == null || c.this.eBp.aPE()) {
                    c.this.iw(true);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void hD(boolean z) {
                c.this.d(c.this.aaj, z);
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void O(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                c.this.eBh.aYf();
                if (arrayList != null && !arrayList.isEmpty()) {
                    c.this.eBh.P(arrayList);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void A(boolean z, boolean z2) {
                if (c.this.eBf != null) {
                    c.this.eBf.setIsScrollable(c.this.eBB && z);
                    c.this.eBf.setEnabled(z2);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void hE(boolean z) {
                boolean z2 = true;
                if (!z || c.this.aYE()) {
                    if (c.this.eBe != null) {
                        c.this.eBe.aWB();
                        return;
                    }
                    return;
                }
                if (c.this.ehO.uk().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(c.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (c.this.eBe != null) {
                    c.this.eBe.ik(z2);
                }
            }
        };
        this.eBH = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.c.15
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.mTbPageContext != null && c.this.mTbPageContext.getPageActivity() != null && !c.this.mTbPageContext.getPageActivity().isFinishing() && c.this.eid != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        c.this.eBf.setCurrentItem(c.this.mSelectedPosition);
                        return;
                    }
                    com.baidu.live.c.np().putBoolean("ala_live_play_has_up_down_scrolled", true);
                    if (c.this.eBk || ListUtils.getCount(c.this.ehO.aVa()) > 1) {
                        int i2 = (i - c.this.mSelectedPosition == 2 || i - c.this.mSelectedPosition == -1) ? -1 : 1;
                        if (c.this.ehO.aVd() == 1) {
                            if (!c.this.ehO.aVg() || i2 >= 0) {
                                if (c.this.ehO.aVh() && i2 > 0) {
                                    c.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    c.this.eBf.setCurrentItem(c.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                c.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                c.this.eBf.setCurrentItem(c.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        c.this.ehO.cancelLoadData();
                        c.this.mHandler.removeCallbacksAndMessages(null);
                        c.this.hy(true);
                        c.this.eBe.aWw();
                        c.this.eBe.aRK();
                        c.this.eBe.aWx();
                        if (c.this.ehO.uk() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(c.this.ehO.uk().mLiveInfo.live_id + "", c.this.ehO.uk().mLiveInfo.room_id + "", c.this.ehO.uk().OR.userId + "", c.this.ehO.uk().OR.userName, System.currentTimeMillis(), c.this.ehO.uk().mLiveInfo.feed_id, c.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(c.this.ehO.uk().mLiveInfo.live_id + "", c.this.ehO.uk().mLiveInfo.room_id + "", c.this.ehO.uk().OR.userId + "", c.this.ehO.uk().OR.userName, System.currentTimeMillis(), c.this.ehO.uk().mLiveInfo.feed_id, c.this.otherParams);
                            }
                        }
                        if (c.this.eBv != null) {
                            long j = c.this.ehO.uk().mLiveInfo.live_id;
                            if (c.this.eBv.liveId == j && c.this.eBv.startTime > 0) {
                                c.this.eBv.endTime = System.currentTimeMillis();
                                long j2 = c.this.eBv.endTime - c.this.eBv.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", c.this.eBv.roomId + "", c.this.eBv.vid, j2 / 1000, c.this.otherParams);
                            }
                            c.this.eBv = null;
                        }
                        c.this.aYG();
                        com.baidu.tieba.ala.liveroom.task.b.aWa().release();
                        c.this.mSelectedPosition = i;
                        c.this.eBe = c.this.eBg.nB(c.this.mSelectedPosition);
                        c.this.eBe.aWA();
                        c.this.om(i2);
                        return;
                    }
                    c.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                    c.this.eBf.setCurrentItem(c.this.mSelectedPosition);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.np().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.eir = new c.a() { // from class: com.baidu.tieba.ala.player.c.16
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    c.this.p(c.this.ehO.uk());
                } else if (i2 == 2) {
                    c.this.f(c.this.ehO.aKw());
                } else if (i2 == 3) {
                    c.this.ae(i, str);
                } else if (i2 == 4) {
                    c.this.ak(obj);
                } else if (i2 == 5) {
                    c.this.aYu();
                }
            }
        };
        this.eBI = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.aVZ() != null && c.this.mTbPageContext != null) {
                        c.this.eBu.a(c.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.aVZ());
                    }
                }
            }
        };
        this.eBJ = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.c.4
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
        this.eBK = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.mTbPageContext != null && c.this.ehO != null && c.this.ehO.uk() != null && c.this.ehO.uk().mLiveInfo != null) {
                    long j = c.this.ehO.uk().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    com.baidu.tieba.ala.liveroom.task.b.aWa().a(c.this.mTbPageContext.getPageActivity(), j, iArr);
                }
            }
        };
        this.ejI = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = c.this.ehO.uk().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.ajN != null && !eventPollingHttpResponseMessage.ajN.isEmpty() && c.this.ehO != null && c.this.ehO.uk() != null && c.this.ehO.uk().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.OO;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.ajN.size()) {
                                break;
                            }
                            x xVar = eventPollingHttpResponseMessage.ajN.get(i2);
                            if (j == xVar.liveId && j2 - xVar.createTime <= 60 && !l.g(xVar.liveId, xVar.id)) {
                                l.a(xVar, c.this.ehO.uk().mLiveInfo);
                                l.h(xVar.liveId, xVar.id);
                            }
                            i = i2 + 1;
                        }
                        x xVar2 = eventPollingHttpResponseMessage.ajN.get(eventPollingHttpResponseMessage.ajN.size() - 1);
                        if (j == xVar2.liveId) {
                            l.f(xVar2.liveId, xVar2.id);
                        }
                    }
                    int i3 = eventPollingHttpResponseMessage.ajM;
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.c.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.ehO != null && c.this.ehO.uk() != null) {
                                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                    l.i(c.this.ehO.uk().mLiveInfo.user_id, c.this.ehO.uk().mLiveInfo.live_id);
                                }
                            }
                        }
                    }, i3 * 1000);
                }
            }
        };
        this.ejH = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof f)) {
                        f fVar = (f) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (c.this.ehO != null && c.this.ehO.uk() != null) {
                            long j = c.this.ehO.uk().mLiveInfo.live_id;
                            if (j == fVar.liveId) {
                                getVideoGoodsListHttpResponseMessage.liveId = j;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                                if (!c.this.eBw) {
                                    c.this.eBw = true;
                                    String str = "goods_task_" + j;
                                    af afVar = com.baidu.live.l.a.uB().aku;
                                    long j2 = (afVar == null || afVar.TP == null) ? 10L : afVar.TP.UW;
                                    if (j2 <= 0) {
                                        j2 = 10;
                                    }
                                    LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.c.7.1
                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onComplete(boolean z) {
                                            if (c.this.ehO != null && c.this.ehO.uk() != null && c.this.ehO.uk().mLiveInfo.live_id != m.ard) {
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, c.this.ehO.uk().mLiveInfo));
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
        this.eBL = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (c.this.mTbPageContext != null && c.this.ehO != null && c.this.ehO.uk() != null && c.this.ehO.uk().Pj != null) {
                        if (l.longValue() == c.this.ehO.uk().Pj.userId) {
                            c.this.ehO.uk().Pj.isNewUser = false;
                            if (c.this.eBx != null) {
                                c.this.eBx.j(c.this.ehO.uk());
                            }
                        }
                    }
                }
            }
        };
        this.eih = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.eBd = bVar;
        this.eBi = true;
        this.ehO = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.ehO.a(this.eir);
        this.eBo = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.eBI);
        MessageManager.getInstance().registerListener(this.eBJ);
        MessageManager.getInstance().registerListener(this.eBK);
        MessageManager.getInstance().registerListener(this.ejI);
        MessageManager.getInstance().registerListener(this.ejH);
        MessageManager.getInstance().registerListener(this.eBL);
    }

    private void am(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.eBm = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.eBm.add(alaBroadcastGiftToastData);
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
        this.ajt = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.ajt)) {
            this.ajt = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.mUserName = intent.getStringExtra("user_name");
        this.eBq = intent.getStringExtra("room_id");
        this.aju = intent.getLongExtra("live_id", 0L);
        this.eBt = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.ehO.b((AlaLiveInfoCoreData) serializableExtra);
            this.eBt = true;
        }
        ao(intent);
        this.eBB = this.eBA == null || !this.eBA.efs;
        this.eBo.setOtherParams(this.otherParams);
        this.eBl = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        aYj();
        aYi();
    }

    private void ao(Intent intent) {
        try {
            AlaLiveSwitchData.isHotLive = 0;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.eBs = new JSONObject(stringExtra);
                if (this.eBs != null) {
                    String optString = this.eBs.optString("enterRoomId");
                    String optString2 = this.eBs.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.eBq, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.aju + "", optString2))) {
                        String optString3 = this.eBs.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, HTTP.UTF_8) : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.eBs.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, HTTP.UTF_8);
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.eBt) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.aju;
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
                            this.ehO.b(alaLiveInfoCoreData);
                            this.eBt = true;
                        }
                    }
                    String optString5 = this.eBs.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.eBA = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        this.eBA = new com.baidu.tieba.ala.liveroom.data.i();
                        this.eBA.efs = jSONObject.optInt("is_hot") == 1;
                        if (this.eBA.efs) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.eBA.eft = jSONObject.optString("task_id");
                        this.eBA.efr = TextUtils.isEmpty(this.eBA.eft) ? false : true;
                        this.eBA.efu = jSONObject.optInt("task_type");
                        this.eBA.efv = jSONObject.optInt("task_im_count");
                        this.eBA.efw = jSONObject.optLong("task_gift_total_price");
                        this.eBA.efx = jSONObject.optLong("task_watch_time");
                        this.eBA.efy = jSONObject.optString("task_activity_scheme");
                    }
                    this.eBn = this.eBs.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.eBs.remove("cover");
                    this.eBs.remove("live_url");
                    this.eBs.remove("enterRoomId");
                    this.eBs.remove("enterLiveId");
                    this.eBs.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.eBs.remove("extra");
                    this.otherParams = this.eBs.toString();
                    this.ehO.setOtherParams(this.otherParams);
                    String optString6 = this.eBs.optString("live_enter_type");
                    int optInt = this.eBs.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(optString6)) {
                        TbConfig.setLiveEnterFrom(optString6);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.ehO.nU(optInt);
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

    public void aYi() {
        if (!TextUtils.isEmpty(this.mUserName)) {
            this.ehO.P(this.mUserName, this.ajt, this.mForumName);
        } else if (this.ehO.uk() != null && this.ehO.uk().mLiveInfo != null && this.ehO.uk().mLiveInfo.live_id > 0) {
            this.ehO.a(this.ehO.uk().mLiveInfo.live_id, false, this.ajt, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uname=")) {
                this.mUserName = WebviewHelper.getMatchStringFromURL(lowerCase, "uname=");
            }
            if (lowerCase.contains("from=")) {
                this.ajt = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.mUserName == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                iw(false);
                return;
            }
            this.ehO.P(this.mUserName, this.ajt, this.mForumName);
        } else if (!TextUtils.isEmpty(this.eBq)) {
            this.ehO.tT(this.eBq);
        } else if (this.aju > 0) {
            this.ehO.a(this.aju, false, this.ajt, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            iw(false);
        }
    }

    private void aYj() {
        this.eBk = true;
        this.eBj = false;
        aYk();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        e(visibilityRegion);
        f(visibilityRegion);
        this.eBp = new com.baidu.tieba.ala.liveroom.c.c();
        this.eBp.a(this.eBG);
        this.eBp.setOtherParams(this.otherParams);
        aYl();
        aYm();
    }

    private void aYk() {
        TiebaInitialize.log("c11863");
        this.eBf = (AlaLoopViewPager) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.eBf.setOnPageChangeListener(this.eBH);
        this.eBf.setBoundaryCaching(true);
        this.eBf.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(this.eBf, new LinearLayout.LayoutParams(-1, -1));
        this.eBg = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.eBg.aSP();
        this.eBe = this.eBg.nA(this.mSelectedPosition);
        this.eBg.a(this.mSelectedPosition, this.ehO.uk());
        this.eBf.setAdapter(this.eBg);
        this.eBf.setCurrentItem(this.mSelectedPosition);
        this.eBf.setIsScrollable(this.eBB);
    }

    private void e(Rect rect) {
        this.eBh = AlaLivePlayer.m24do(getPageContext().getPageActivity());
        if (this.eBh == null) {
            this.eBf.setIsScrollable(false);
            if (this.ehO != null) {
                this.ehO.cancelLoadData();
            }
            aSS();
            return;
        }
        if (this.eBl) {
            this.eBf.setIsScrollable(false);
        }
        this.eBh.setPageContext(getPageContext());
        this.eBh.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.eBh.setIPlayerCallBack(this.eBF);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.eBe.a(this.eBh, layoutParams, true);
    }

    private void aSS() {
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
        this.eid = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.eid.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.eBe.a(this.eid, layoutParams);
    }

    private void aYl() {
        if (this.ehO != null && this.ehO.uk() != null) {
            this.aaj = this.ehO.uk();
            if (this.aaj.mLiveInfo != null) {
                a(this.aaj.mLiveInfo, this.eBt);
                if (this.aaj.mLiveInfo != null && this.aaj.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit");
                    }
                    this.eBh.f(this.aaj.mLiveInfo);
                    if (this.eBp != null) {
                        short s = this.aaj.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2;
                        this.eBp.a(this.mTbPageContext, this.eid, this.eBh, this.eBe, this.ehO, this.ajt, this.eBl, this.eih, this.eBm, this.eBA);
                        this.eBp.b(s);
                    }
                }
            }
        }
    }

    private void aYm() {
        this.mTbPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.player.c.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (c.this.aaj != null && c.this.aaj.OR != null && c.this.aaj.OR.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + c.this.aaj.mLiveInfo.live_id);
                        c.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.c.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", c.this.aaj.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                }
            }
        });
    }

    private void aYn() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.eBl || !this.eBB) {
                this.eBf.setIsScrollable(false);
            } else {
                this.eBf.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && (this.eBp == null || !this.eBp.aPD())) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                aYn();
            } else if (this.eBp == null || this.eBp.aPE()) {
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
        if (this.eBh != null) {
            this.eBh.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        aYp();
        long j = -1;
        if (this.ehO != null && this.ehO.aVl() != null) {
            j = this.ehO.aVl().room_id;
        }
        this.eBd.a(z, z2, j);
    }

    public void hy(boolean z) {
        AlaLiveInfoData aVl;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        AlaLiveSwitchData.isHotLive = 0;
        com.baidu.tieba.ala.liveroom.yuangift.a.aWX().aAk();
        com.baidu.tieba.ala.liveroom.task.b.aWa().release();
        if (this.eBx != null) {
            this.eBx.release();
        }
        this.eBA = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.ehO != null && (aVl = this.ehO.aVl()) != null) {
            this.ehO.ck(aVl.live_id);
        }
        this.eBu.stopRecord();
        LiveTimerManager.getInstance().stop();
        aYo();
        if (this.eBh != null) {
            this.eBh.iv(z);
        }
        if (this.eBp != null) {
            this.eBp.hy(z);
        }
        this.eBw = false;
        m.ard = 0L;
    }

    private void aYo() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void aYp() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void b(i iVar) {
        if (iVar != null) {
            this.aaj = iVar;
            if (this.eBp != null) {
                this.eBp.b(iVar);
            }
        }
    }

    private void c(com.baidu.live.data.e eVar) {
        if (this.eBp != null) {
            this.eBp.c(eVar);
        }
    }

    private void o(i iVar) {
        this.aaj = iVar;
    }

    private void aYq() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.eBf.setIsScrollable(false);
        }
        if (this.aaj != null) {
            a(this.aaj.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.eBe.a(this.eid, null);
            a(this.eBe, this.aaj.mLiveInfo, this.eBk);
            this.eBk = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.ehO != null && this.ehO.uk() != null && this.ehO.uk().mLiveInfo != null) {
                    j = this.ehO.uk().mLiveInfo.live_id;
                    str2 = this.ehO.uk().mLiveInfo.room_id + "";
                    str = this.ehO.uk().mLiveInfo.feed_id;
                } else {
                    if (this.aju > 0) {
                        j2 = this.aju;
                    }
                    if (!TextUtils.isEmpty(this.eBq)) {
                        j = j2;
                        str = "";
                        str2 = this.eBq;
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
            if (this.ehO != null && this.ehO.uk() != null && this.ehO.uk().mLiveInfo != null) {
                str3 = this.ehO.uk().mLiveInfo.feed_id;
                str4 = this.ehO.uk().mLiveInfo.live_id + "";
                str5 = this.ehO.uk().mLiveInfo.room_id + "";
                str6 = this.ehO.uk().mLiveInfo.user_name;
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
        if (this.eBh != null && this.eBh.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.eBh.getVideoPath();
                String e = a.e(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.eBh.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + e);
                }
                if (!this.eBh.isPlaying() || TextUtils.isEmpty(videoPath) || !videoPath.equals(e)) {
                    if (!z && !alaLiveRoomBlurPageLayout.bA(this.eBh)) {
                        ((ViewGroup) this.eBh.getParent()).removeView(this.eBh);
                        alaLiveRoomBlurPageLayout.a(this.eBh, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    this.eBh.f(alaLiveInfoData);
                    return;
                }
                return;
            }
            this.eBh.aYf();
        } else if (this.eBh != null && this.eBh.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.eBh, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                this.eBh.f(alaLiveInfoData);
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.eBh != null) {
            this.eBh.setLayoutParams(b);
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

    public void aYr() {
        this.eBk = true;
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
                this.eBe.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.eBe.setBackgroundColor(0);
            }
        } else {
            this.eBe.setBackgroundColor(0);
        }
        a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.eid != null) {
            this.eid.setLayoutParams(c);
        }
        if (this.eBe != null) {
            this.eBe.aM(screenFullSize[0], screenFullSize[1]);
        }
        if (this.eBo != null) {
            this.eBo.aM(screenFullSize[0], screenFullSize[1]);
        }
        if (this.eBp != null) {
            this.eBp.E(c.width, c.height, realScreenOrientation);
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

    private void nH(int i) {
        boolean z = true;
        if (this.aaj != null && this.aaj.mLiveInfo != null) {
            this.eBe.setBgImageUrl(this.aaj.mLiveInfo.cover, this.aaj.mLiveInfo);
            this.eBg.a(this.mSelectedPosition, aYs(), this.aaj);
            this.eBg.b(this.mSelectedPosition, aYt(), this.aaj);
            this.eBe.requestLayout();
            this.eBe.z(i, this.aaj.mLiveInfo.screen_direction == 2);
        }
        if (this.aaj != null) {
            a(this.aaj.mLiveInfo, false);
        }
        boolean aWC = this.eBe.aWC();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.aaj == null || this.aaj.mLiveInfo == null || this.aaj.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!aYE()) {
            if (this.eBh != null && this.eBh.getParent() == null) {
                this.eBe.a(this.eBh, null, false);
                if (this.aaj.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    this.eBh.f(this.aaj.mLiveInfo);
                }
            }
            if (aWC && !aYE() && this.eBp != null) {
                this.eBe.ik(z);
                return;
            }
            return;
        }
        this.eBe.aWw();
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
            this.ehO.a(alaLiveInfoData.live_id, true, this.ajt, this.mForumName);
            this.ehO.cj(alaLiveInfoData.live_id);
        }
    }

    public void om(int i) {
        short s;
        if (i < 0) {
            this.ehO.nV(this.ehO.aVi() - 1);
        } else if (i > 0) {
            this.ehO.nV(this.ehO.aVi() + 1);
        }
        if (this.eBp != null) {
            this.eBp.b(this.eBe);
        }
        this.eBg.a(this.mSelectedPosition, aYs(), this.aaj);
        this.eBg.b(this.mSelectedPosition, aYt(), this.aaj);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.ehO != null) {
            int aVi = this.ehO.aVi();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", aVi + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.ehO.aVa() != null && this.ehO.aVa().size() > aVi && this.ehO.aVa().get(aVi) != null) {
                AlaLiveInfoData alaLiveInfoData = this.ehO.aVa().get(aVi);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.ehO != null) {
            AlaLiveInfoData aVl = this.ehO.aVl();
            if (aVl != null) {
                aVl.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.eBe, aVl, this.eBk);
                this.eBk = false;
                if (this.eBp != null) {
                    if (aVl.screen_direction != 2) {
                        s = 2;
                    } else {
                        s = 1;
                    }
                    this.eBp.a(this.mTbPageContext, this.eid, this.eBh, this.eBe, this.ehO, this.ajt, this.eBl, this.eih, null, this.eBA);
                    this.eBp.b(s);
                }
                a(aVl, false);
            }
            g(aVl);
            this.eBe.a(this.eid, null);
            if (this.eBp != null) {
                this.eBp.aPB();
            }
            this.ehO.c(aVl);
        }
    }

    private AlaLiveInfoData aYs() {
        List<AlaLiveInfoData> aVa = this.ehO.aVa();
        if (aVa == null || aVa.size() == 0) {
            if (this.aaj == null) {
                return null;
            }
            return this.aaj.mLiveInfo;
        }
        int aVi = this.ehO.aVi();
        int size = aVa.size();
        return aVa.get(((aVi + size) - 1) % size);
    }

    private AlaLiveInfoData aYt() {
        List<AlaLiveInfoData> aVa = this.ehO.aVa();
        if (aVa == null || aVa.size() == 0) {
            if (this.aaj == null) {
                return null;
            }
            return this.aaj.mLiveInfo;
        }
        return aVa.get((this.ehO.aVi() + 1) % aVa.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(int i, String str) {
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
        i uk = this.ehO.uk();
        o(uk);
        this.ehO.aVb();
        if (this.eBk) {
            this.ehO.ie(false);
        }
        this.eih = System.currentTimeMillis() / 1000;
        if (this.eBp != null) {
            if (uk.mLiveInfo.screen_direction != 2) {
                s = 2;
            } else {
                s = 1;
            }
            this.eBp.a(this.mTbPageContext, this.eid, this.eBh, this.eBe, this.ehO, this.ajt, this.eBl, this.eih, this.eBm, this.eBA);
            this.eBp.b(s);
        }
        aYq();
        if (uk != null && uk.mLiveInfo != null && uk.mLiveInfo.live_status == 2) {
            d(uk, false);
            this.eBk = false;
            return;
        }
        if (!this.eBy || !TextUtils.equals(o.ww(), this.eBz)) {
            q.b(getPageContext());
            com.baidu.live.l.c.uH().uI();
            this.eBy = true;
            this.eBz = o.ww();
        }
        this.eBw = false;
        if (this.ehO.uk() != null && this.ehO.uk().mLiveInfo != null) {
            String str2 = this.ehO.uk().mLiveInfo.feed_id;
            long j = this.ehO.uk().mLiveInfo.live_id;
            long j2 = this.ehO.uk().mLiveInfo.user_id;
            this.ehO.cj(j);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                l.i(j2, j);
            }
            m.i(str2, j);
        }
        if (this.eBp != null) {
            this.eBp.hx(TextUtils.equals(this.eBn, "1"));
            this.eBn = "";
        }
        b(this.ehO.uk());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mTbPageContext != null && c.this.ehO.uk() != null && c.this.ehO.uk().mLiveInfo != null) {
                    c.this.ehO.a(c.this.ehO.uk().mLiveInfo.live_id, c.this.ajt, c.this.eih);
                }
            }
        }, this.ehO.uk().OW);
        if (this.ehO.uk() != null && this.ehO.uk().OR != null && (afVar = com.baidu.live.l.a.uB().aku) != null && afVar.TO != null && afVar.TO.UT) {
            b(true, this.ehO.uk().OR.userId);
        }
        this.eBk = false;
        if (this.ehO.uk() != null && this.ehO.uk().mLiveInfo != null && this.ehO.uk().OR != null) {
            long j3 = this.ehO.uk().mLiveInfo.live_id;
            long j4 = this.ehO.uk().mLiveInfo.room_id;
            String str3 = this.ehO.uk().mLiveInfo.feed_id;
            com.baidu.tieba.ala.liveroom.yuangift.a.aWX().a(this.mTbPageContext.getPageActivity(), j3, "oneYuanGift_" + j3, j4, str3, this.otherParams);
            com.baidu.tieba.ala.liveroom.task.b.aWa().a(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            com.baidu.tieba.ala.guardclub.a.aLe().a(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            if (this.eBx == null) {
                this.eBx = new com.baidu.tieba.ala.liveroom.h.a();
            }
            this.eBx.a(this.mTbPageContext.getPageActivity(), this.ehO.uk(), this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYu() {
        if (this.eBi) {
            this.eBg.a(this.mSelectedPosition, aYs(), this.aaj);
            this.eBg.b(this.mSelectedPosition, aYt(), this.aaj);
            this.eBi = false;
        }
        if (this.eBo != null && aYE()) {
            this.eBo.M(this.ehO.aVc());
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
            this.mHandler.removeCallbacks(this.eBE);
            this.mHandler.postDelayed(this.eBE, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.e eVar) {
        if (eVar != null) {
            if (!this.eBj) {
                c(eVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.eBD);
                this.mHandler.postDelayed(this.eBD, eVar.getInterval());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYv() {
        if (this.ehO.uk() != null && this.ehO.uk().mLiveInfo != null) {
            this.ehO.cj(this.ehO.uk().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(i iVar) {
        if (iVar != null && iVar.mLiveInfo != null && iVar.mLiveInfo.live_status == 2) {
            this.eBg.a(this.mSelectedPosition, this.ehO.uk());
            d(iVar, false);
        } else if (iVar != null) {
            if (!this.eBj) {
                b(iVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.eBC);
                this.mHandler.postDelayed(this.eBC, iVar.OW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYw() {
        if (this.mTbPageContext != null && this.ehO.uk() != null && this.ehO.uk().mLiveInfo != null) {
            this.ehO.a(this.ehO.uk().mLiveInfo.live_id, this.ajt, this.eih);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(i iVar, boolean z) {
        hy(true);
        if (!aYE()) {
            this.ehO.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            this.eBe.aRK();
            this.eBe.aWw();
            this.eBe.aWD();
            if (iVar != null && iVar.mLiveInfo != null) {
                this.eBr = iVar.mLiveInfo.live_id;
            }
            aYn();
            aYx();
            aYy();
            if (iVar != null) {
                this.eBo.a(iVar, this.ajt, this.ehO.aVc(), this.mForumName, z);
                this.eBo.a(this.eBe);
                if (this.eBp != null) {
                    this.eBp.hy(false);
                    this.eBp.aPC();
                }
                this.eBe.aWA();
                long j = iVar.mLiveInfo.live_id;
                long j2 = iVar.mLiveInfo.room_id;
                String str = iVar.mLiveInfo.feed_id;
                long j3 = iVar.OR.userId;
                String str2 = iVar.OR.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.eBv = new StayTimeBean();
                this.eBv.liveId = iVar.mLiveInfo.live_id;
                this.eBv.roomId = iVar.mLiveInfo.room_id;
                this.eBv.vid = iVar.mLiveInfo.feed_id;
                this.eBv.startTime = System.currentTimeMillis();
            }
            aYG();
        }
    }

    private void aYx() {
    }

    private void aYy() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.eBf);
        }
    }

    public void aYz() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            aYA();
        } else {
            aYB();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.ehO != null && this.ehO.uk() != null) {
            alaLiveInfoData = this.ehO.uk().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            aYA();
        } else {
            aYB();
        }
        this.eBf.setIsScrollable(!z);
        if (this.eBp != null) {
            this.eBp.onKeyboardVisibilityChanged(z);
        }
        if (this.eid != null) {
            this.eid.onKeyboardVisibilityChanged(z);
        }
    }

    public void bw(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            aYA();
        } else {
            aYB();
        }
        this.eid.bw(realScreenOrientation);
        nH(realScreenOrientation);
        com.baidu.tieba.ala.liveroom.yuangift.a.aWX().pC();
        if (this.eBx != null) {
            this.eBx.pC();
        }
    }

    public void aYA() {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.eBf != null) {
            g.P(this.eBf);
        }
    }

    public void aYB() {
        if (this.eBf != null) {
            g.Q(this.eBf);
        }
    }

    public void onResume() {
        if (this.ehO != null) {
            this.ehO.aUP();
        }
        if (this.eBp != null) {
            this.eBp.enterForeground();
        }
        if (this.eBx != null) {
            this.eBx.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.r.a.dm(this.mTbPageContext.getPageActivity()) && this.isBackGround) {
            this.isBackGround = false;
            aYC();
        }
    }

    public void aYC() {
        aYw();
        aYv();
        this.ehO.aVb();
        this.eBh.aYg();
        if (this.eBp != null) {
            this.eBp.aPG();
        }
        if (this.ehO != null && this.ehO.uk() != null && this.ehO.uk().mLiveInfo != null) {
            this.eBu.cm(this.ehO.uk().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aaj.mLiveInfo.live_id);
        }
    }

    public void onPause() {
        if (this.ehO != null) {
            this.ehO.aUQ();
        }
        if (this.eBp != null) {
            this.eBp.enterBackground();
        }
    }

    public void onStop() {
        this.isBackGround = true;
        aYD();
    }

    public void aYD() {
        this.mHandler.removeCallbacks(this.eBC);
        this.mHandler.removeCallbacks(this.eBD);
        this.mHandler.removeCallbacks(this.eBE);
        this.eBh.pausePlay();
        if (this.eBp != null) {
            this.eBp.aPF();
        }
        this.eBu.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            com.baidu.tieba.ala.liveroom.yuangift.a.aWX().a(i, i2, intent, this.aaj, this.otherParams);
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.eBp != null) {
            this.eBp.onActivityResult(i, i2, intent);
        }
    }

    public boolean aYE() {
        return this.eBo != null && this.eBo.aKG();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eBI != null) {
            MessageManager.getInstance().unRegisterListener(this.eBI);
        }
        if (this.eBJ != null) {
            MessageManager.getInstance().unRegisterListener(this.eBJ);
        }
        MessageManager.getInstance().unRegisterListener(this.eBK);
        MessageManager.getInstance().unRegisterListener(this.ejI);
        MessageManager.getInstance().unRegisterListener(this.ejH);
        MessageManager.getInstance().unRegisterListener(this.eBL);
        com.baidu.tieba.ala.liveroom.task.b.aWa().release();
        if (this.eBh != null) {
            this.eBh.iv(true);
        }
        if (this.eBp != null) {
            this.eBp.onDestory();
        }
        if (this.eBg != null) {
            this.eBg.onDestroy();
        }
        this.eBe.aRK();
        if (this.eBe != null) {
            this.eBe.release();
            this.eBe = null;
        }
        if (this.eBo != null) {
            this.eBo.onDestroy();
            this.eBo = null;
        }
        if (this.eBv != null && this.ehO != null && this.ehO.uk() != null) {
            long j = this.ehO.uk().mLiveInfo.live_id;
            if (this.eBv.liveId == j && this.eBv.startTime > 0) {
                this.eBv.endTime = System.currentTimeMillis();
                long j2 = this.eBv.endTime - this.eBv.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.eBv.roomId + "", this.eBv.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.eBv = null;
        }
        if (this.eid != null) {
            this.eid.aWF();
            this.eid = null;
        }
        if (this.ehO != null) {
            this.ehO.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        l.wt();
        com.baidu.live.gift.o.pI().release();
    }

    public String tn() {
        return this.otherParams;
    }

    public void aYF() {
        if (this.eBs != null) {
            this.otherParams = this.eBs.toString();
            if (this.ehO != null) {
                this.ehO.setOtherParams(this.otherParams);
            }
            if (this.eBp != null) {
                this.eBp.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            this.eBo.setOtherParams(this.otherParams);
        }
    }

    public void aYG() {
        if (this.eBs != null) {
            String optString = this.eBs.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.eBs.put("tab", "live_jump");
                        this.eBs.put("tag", "");
                        this.eBs.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.eBs.put("tab", "liveroom");
                        this.eBs.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                aYF();
            }
        }
    }

    private void b(boolean z, long j) {
        com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
        if (z) {
            dVar.aLA();
        }
        dVar.bZ(j);
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }
}
