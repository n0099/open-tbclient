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
import com.baidu.live.data.aa;
import com.baidu.live.data.ak;
import com.baidu.live.data.g;
import com.baidu.live.data.k;
import com.baidu.live.gift.q;
import com.baidu.live.gift.s;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.message.h;
import com.baidu.live.q.a;
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
import com.baidu.live.utils.m;
import com.baidu.live.utils.n;
import com.baidu.live.utils.o;
import com.baidu.live.utils.p;
import com.baidu.tieba.ala.liveroom.c.e;
import com.baidu.tieba.ala.liveroom.data.i;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends BdBaseView<TbPageContext> {
    private k aio;
    private String aru;
    private long arv;
    private com.baidu.tieba.ala.liveroom.m.c eXZ;
    private c.a eYC;
    private AlaLiveView eYo;
    private long eYs;
    private HttpMessageListener eZU;
    private HttpMessageListener eZV;
    private b fsE;
    private AlaLiveRoomBlurPageLayout fsF;
    private AlaLoopViewPager fsG;
    private AlaLoopViewPagerAdapter fsH;
    private AlaLivePlayer fsI;
    private boolean fsJ;
    private boolean fsK;
    private boolean fsL;
    private boolean fsM;
    private ArrayList<AlaBroadcastGiftToastData> fsN;
    private String fsO;
    private com.baidu.tieba.ala.endliveroom.a fsP;
    private com.baidu.tieba.ala.liveroom.c.c fsQ;
    private String fsR;
    private long fsS;
    private JSONObject fsT;
    private boolean fsU;
    private com.baidu.tieba.ala.liveroom.task.c fsV;
    private StayTimeBean fsW;
    private boolean fsX;
    private com.baidu.tieba.ala.liveroom.h.a fsY;
    private boolean fsZ;
    private String fta;
    private i ftb;
    private boolean ftc;
    private boolean ftd;
    private Runnable fte;
    private Runnable ftf;
    private Runnable ftg;
    private com.baidu.live.s.c fth;
    private AlaLivePlayer.a fti;
    e ftj;
    ViewPager.OnPageChangeListener ftk;
    HttpMessageListener ftl;
    CustomMessageListener ftm;
    CustomMessageListener ftn;
    CustomMessageListener fto;
    CustomMessageListener ftp;
    private CustomMessageListener ftq;
    private boolean isBackGround;
    private String mForumName;
    private Handler mHandler;
    private BdAlertDialog mNetChangedDialog;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String mUserName;
    private String otherParams;

    public c(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.fsJ = true;
        this.eYs = 0L;
        this.fsK = false;
        this.fsL = true;
        this.aru = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.fsM = false;
        this.fsO = "0";
        this.mHandler = new Handler();
        this.fsS = -1L;
        this.otherParams = "";
        this.fsU = false;
        this.fsV = com.baidu.tieba.ala.liveroom.task.c.bnQ();
        this.fsX = false;
        this.fsZ = false;
        this.ftd = false;
        this.fte = new Runnable() { // from class: com.baidu.tieba.ala.player.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.bqs();
            }
        };
        this.ftf = new Runnable() { // from class: com.baidu.tieba.ala.player.c.12
            @Override // java.lang.Runnable
            public void run() {
                c.this.bqr();
            }
        };
        this.ftg = new Runnable() { // from class: com.baidu.tieba.ala.player.c.14
            @Override // java.lang.Runnable
            public void run() {
                c.this.eXZ.bmT();
            }
        };
        this.fti = new AlaLivePlayer.a() { // from class: com.baidu.tieba.ala.player.c.15
            @Override // com.baidu.tieba.ala.player.AlaLivePlayer.a
            public void bd(int i) {
                if (c.this.fsF != null) {
                    if (ListUtils.getCount(c.this.fsI.getAlaLiveInfoDataList()) < 2) {
                        c.this.fsF.bom();
                    } else {
                        c.this.fsF.bon();
                    }
                }
                if (c.this.fsQ != null) {
                    c.this.fsQ.bd(i);
                }
                if (BdNetTypeUtil.isMobileNet()) {
                    if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && com.baidu.live.utils.k.yr()) {
                        c.this.onStop();
                        c.this.bqD();
                        return;
                    }
                    c.this.bqH();
                }
            }
        };
        this.ftj = new e() { // from class: com.baidu.tieba.ala.player.c.18
            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void iR(boolean z) {
                if (z || c.this.fsQ == null || c.this.fsQ.bhg()) {
                    c.this.jN(true);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void iS(boolean z) {
                c.this.d(c.this.aio, z);
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void U(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                c.this.fsI.bqb();
                if (arrayList != null && !arrayList.isEmpty() && !c.this.isBackGround) {
                    if (c.this.isBackGround) {
                        c.this.fsI.setPlayLiveInfo(arrayList);
                    } else {
                        c.this.fsI.Z(arrayList);
                    }
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void A(boolean z, boolean z2) {
                if (c.this.fsG != null) {
                    c.this.fsG.setIsScrollable(c.this.ftc && z);
                    c.this.fsG.setEnabled(z2);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void iT(boolean z) {
                boolean z2 = true;
                if (!z || c.this.bqA()) {
                    if (c.this.fsF != null) {
                        c.this.fsF.bop();
                        return;
                    }
                    return;
                }
                if (c.this.eXZ.wf().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(c.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (c.this.fsF != null) {
                    c.this.fsF.jB(z2);
                }
            }
        };
        this.ftk = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.c.19
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.mTbPageContext != null && c.this.mTbPageContext.getPageActivity() != null && !c.this.mTbPageContext.getPageActivity().isFinishing() && c.this.eYo != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        c.this.fsG.setCurrentItem(c.this.mSelectedPosition);
                    } else if (c.this.fsL || ListUtils.getCount(c.this.eXZ.bmS()) > 1) {
                        int i2 = (i - c.this.mSelectedPosition == 2 || i - c.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && c.this.eXZ.bmV() == 1) {
                            if (!c.this.eXZ.bmY() || i2 >= 0) {
                                if (c.this.eXZ.bmZ() && i2 > 0) {
                                    c.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    c.this.fsG.setCurrentItem(c.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                c.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                c.this.fsG.setCurrentItem(c.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        c.this.eXZ.cancelLoadData();
                        c.this.mHandler.removeCallbacksAndMessages(null);
                        c.this.iM(true);
                        c.this.fsF.bok();
                        c.this.fsF.bjl();
                        c.this.fsF.bol();
                        if (c.this.eXZ.wf() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(c.this.eXZ.wf().mLiveInfo.live_id + "", c.this.eXZ.wf().mLiveInfo.room_id + "", c.this.eXZ.wf().VP.userId + "", c.this.eXZ.wf().VP.userName, System.currentTimeMillis(), c.this.eXZ.wf().mLiveInfo.feed_id, c.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(c.this.eXZ.wf().mLiveInfo.live_id + "", c.this.eXZ.wf().mLiveInfo.room_id + "", c.this.eXZ.wf().VP.userId + "", c.this.eXZ.wf().VP.userName, System.currentTimeMillis(), c.this.eXZ.wf().mLiveInfo.feed_id, c.this.otherParams);
                            }
                        }
                        if (c.this.fsW != null) {
                            long j = c.this.eXZ.wf().mLiveInfo.live_id;
                            if (c.this.fsW.liveId == j && c.this.fsW.startTime > 0) {
                                c.this.fsW.endTime = System.currentTimeMillis();
                                long j2 = c.this.fsW.endTime - c.this.fsW.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", c.this.fsW.roomId + "", c.this.fsW.vid, j2 / 1000, c.this.otherParams);
                            }
                            c.this.fsW = null;
                        }
                        c.this.bqC();
                        if (c.this.fth != null) {
                            c.this.fth.release();
                        }
                        c.this.mSelectedPosition = i;
                        c.this.fsF = c.this.fsH.pS(c.this.mSelectedPosition);
                        c.this.fsF.boo();
                        c.this.qG(i2);
                    } else {
                        c.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        c.this.fsG.setCurrentItem(c.this.mSelectedPosition);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.oI().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.eYC = new c.a() { // from class: com.baidu.tieba.ala.player.c.20
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    c.this.s(c.this.eXZ.wf());
                } else if (i2 == 2) {
                    c.this.g(c.this.eXZ.bbm());
                } else if (i2 == 3) {
                    c.this.au(i, str);
                } else if (i2 == 4) {
                    c.this.aq(obj);
                } else if (i2 == 5) {
                    c.this.bqq();
                }
            }
        };
        this.ftl = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bnO() != null && c.this.mTbPageContext != null) {
                        c.this.fsV.a(c.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bnO());
                    }
                }
            }
        };
        this.ftm = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.c.4
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
        this.ftn = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.mTbPageContext != null && c.this.eXZ != null && c.this.eXZ.wf() != null && c.this.eXZ.wf().mLiveInfo != null) {
                    long j = c.this.eXZ.wf().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (c.this.fth != null) {
                        c.this.fth.a(c.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.eZV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = c.this.eXZ.wf().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.arL != null && !eventPollingHttpResponseMessage.arL.isEmpty() && c.this.eXZ != null && c.this.eXZ.wf() != null && c.this.eXZ.wf().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.VM;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.arL.size()) {
                                break;
                            }
                            aa aaVar = eventPollingHttpResponseMessage.arL.get(i2);
                            if (j == aaVar.liveId && j2 - aaVar.createTime <= 60 && !m.g(aaVar.liveId, aaVar.id)) {
                                m.a(aaVar, c.this.eXZ.wf().mLiveInfo);
                                m.h(aaVar.liveId, aaVar.id);
                            }
                            i = i2 + 1;
                        }
                        aa aaVar2 = eventPollingHttpResponseMessage.arL.get(eventPollingHttpResponseMessage.arL.size() - 1);
                        if (j == aaVar2.liveId) {
                            m.f(aaVar2.liveId, aaVar2.id);
                        }
                    }
                    int i3 = eventPollingHttpResponseMessage.arK;
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.c.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.eXZ != null && c.this.eXZ.wf() != null) {
                                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                    m.i(c.this.eXZ.wf().mLiveInfo.user_id, c.this.eXZ.wf().mLiveInfo.live_id);
                                }
                            }
                        }
                    }, i3 * 1000);
                }
            }
        };
        this.eZU = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h)) {
                        h hVar = (h) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (c.this.eXZ != null && c.this.eXZ.wf() != null) {
                            long j = c.this.eXZ.wf().mLiveInfo.live_id;
                            if (j == hVar.liveId) {
                                getVideoGoodsListHttpResponseMessage.liveId = j;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                                if (!c.this.fsX) {
                                    c.this.fsX = true;
                                    String str = "goods_task_" + j;
                                    ak akVar = com.baidu.live.r.a.wA().asy;
                                    long j2 = (akVar == null || akVar.aaL == null) ? 10L : akVar.aaL.acq;
                                    if (j2 <= 0) {
                                        j2 = 10;
                                    }
                                    LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.c.7.1
                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onComplete(boolean z) {
                                            if (c.this.eXZ != null && c.this.eXZ.wf() != null && c.this.eXZ.wf().mLiveInfo.live_id != n.ayO) {
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, c.this.eXZ.wf().mLiveInfo));
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
        this.fto = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (c.this.mTbPageContext != null && c.this.eXZ != null && c.this.eXZ.wf() != null && c.this.eXZ.wf().Wc != null) {
                        if (l.longValue() == c.this.eXZ.wf().Wc.userId) {
                            c.this.eXZ.wf().Wc.isNewUser = false;
                            if (c.this.fsY != null) {
                                c.this.fsY.l(c.this.eXZ.wf());
                            }
                        }
                    }
                }
            }
        };
        this.ftp = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.p.a)) {
                    com.baidu.tieba.ala.liveroom.p.a aVar = (com.baidu.tieba.ala.liveroom.p.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar.getUserId());
                    String aVj = aVar.aVj();
                    if (c.this.mTbPageContext != null && c.this.eXZ != null && c.this.eXZ.wf() != null && c.this.eXZ.wf().Wc != null) {
                        if (valueOf.longValue() == c.this.eXZ.wf().Wc.userId && com.baidu.live.r.a.wA().asy != null && com.baidu.live.r.a.wA().asy.aaF != null && com.baidu.live.r.a.wA().asy.aaF.pS()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, aVj));
                        }
                    }
                }
            }
        };
        this.ftq = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.player.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.mHandler != null && c.this.fte != null) {
                    c.this.mHandler.removeCallbacks(c.this.fte);
                }
                c.this.bqs();
            }
        };
        this.eYs = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.fsE = bVar;
        this.fsJ = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.s.c.class);
        if (runTask != null) {
            this.fth = (com.baidu.live.s.c) runTask.getData();
        }
        this.eXZ = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.eXZ.a(this.eYC);
        this.fsP = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.ftl);
        MessageManager.getInstance().registerListener(this.ftm);
        MessageManager.getInstance().registerListener(this.ftn);
        MessageManager.getInstance().registerListener(this.eZV);
        MessageManager.getInstance().registerListener(this.eZU);
        MessageManager.getInstance().registerListener(this.fto);
        MessageManager.getInstance().registerListener(this.ftp);
        MessageManager.getInstance().registerListener(this.ftq);
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.fsN = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.fsN.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void ag(Intent intent) {
        af(intent);
        this.aru = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.aru)) {
            this.aru = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.mUserName = intent.getStringExtra("user_name");
        this.fsR = intent.getStringExtra("room_id");
        this.arv = intent.getLongExtra("live_id", 0L);
        this.fsU = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.eXZ.b((AlaLiveInfoCoreData) serializableExtra);
            this.fsU = true;
        }
        ah(intent);
        this.ftc = this.ftb == null || !this.ftb.eVm;
        this.fsP.setOtherParams(this.otherParams);
        this.fsM = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bqf();
        bqe();
    }

    private void ah(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.fsT = new JSONObject(stringExtra);
                if (this.fsT != null) {
                    String optString = this.fsT.optString("enterRoomId");
                    String optString2 = this.fsT.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.fsR, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.arv + "", optString2))) {
                        String optString3 = this.fsT.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.fsT.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.fsU) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.arv;
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
                            this.eXZ.b(alaLiveInfoCoreData);
                            this.fsU = true;
                        }
                    }
                    String optString5 = this.fsT.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.ftb = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        this.ftb = new i();
                        this.ftb.eVm = jSONObject.optInt("is_hot") == 1;
                        if (this.ftb.eVm) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.ftb.eVn = jSONObject.optString("task_id");
                        this.ftb.eVl = !TextUtils.isEmpty(this.ftb.eVn);
                        this.ftb.eVo = jSONObject.optInt("task_type");
                        this.ftb.eVp = jSONObject.optInt("task_im_count");
                        this.ftb.eVq = jSONObject.optLong("task_gift_total_price");
                        this.ftb.eVr = jSONObject.optLong("task_watch_time");
                        this.ftb.eVs = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                    }
                    this.fsO = this.fsT.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fsT.remove("cover");
                    this.fsT.remove("live_url");
                    this.fsT.remove("enterRoomId");
                    this.fsT.remove("enterLiveId");
                    this.fsT.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fsT.remove("extra");
                    this.otherParams = this.fsT.toString();
                    this.eXZ.setOtherParams(this.otherParams);
                    this.fsT.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.fsT.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.fsT.optString("source");
                    }
                    this.ftd = "mobilebaidu_subscription".equals(str);
                    int optInt = this.fsT.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.eXZ.ql(optInt);
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

    public void bqe() {
        if (!TextUtils.isEmpty(this.mUserName)) {
            this.eXZ.aa(this.mUserName, this.aru, this.mForumName);
        } else if (this.eXZ.wf() != null && this.eXZ.wf().mLiveInfo != null && this.eXZ.wf().mLiveInfo.live_id > 0) {
            this.eXZ.a(this.eXZ.wf().mLiveInfo.live_id, false, this.aru, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uname=")) {
                this.mUserName = WebviewHelper.getMatchStringFromURL(lowerCase, "uname=");
            }
            if (lowerCase.contains("from=")) {
                this.aru = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.mUserName == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                jN(false);
                return;
            }
            this.eXZ.aa(this.mUserName, this.aru, this.mForumName);
        } else if (!TextUtils.isEmpty(this.fsR)) {
            this.eXZ.yH(this.fsR);
        } else if (this.arv > 0) {
            this.eXZ.a(this.arv, false, this.aru, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            jN(false);
        }
    }

    private void bqf() {
        this.fsL = true;
        this.fsK = false;
        bqg();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        this.fsQ = new com.baidu.tieba.ala.liveroom.c.c();
        this.fsQ.a(this.ftj);
        this.fsQ.setOtherParams(this.otherParams);
        this.fsQ.iE(this.ftd);
        bqh();
        bqi();
    }

    private void bqg() {
        TiebaInitialize.log("c11863");
        this.fsG = (AlaLoopViewPager) LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.fsG.setOnPageChangeListener(this.ftk);
        this.fsG.setBoundaryCaching(true);
        this.fsG.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(this.fsG, new LinearLayout.LayoutParams(-1, -1));
        this.fsH = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.fsH.bkC();
        this.fsF = this.fsH.pR(this.mSelectedPosition);
        this.fsH.a(this.mSelectedPosition, this.eXZ.wf());
        this.fsG.setAdapter(this.fsH);
        this.fsG.setCurrentItem(this.mSelectedPosition);
        this.fsG.setIsScrollable(this.ftc);
    }

    private void c(Rect rect) {
        this.fsI = AlaLivePlayer.eH(getPageContext().getPageActivity());
        if (this.fsI == null) {
            this.fsG.setIsScrollable(false);
            if (this.eXZ != null) {
                this.eXZ.cancelLoadData();
            }
            bkF();
            return;
        }
        if (this.fsM) {
            this.fsG.setIsScrollable(false);
        }
        this.fsI.setPageContext(getPageContext());
        this.fsI.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.fsI.setIPlayerCallBack(this.fti);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fsF.a(this.fsI, layoutParams, true);
    }

    private void bkF() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.c.16
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                c.this.jN(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.eYo = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.eYo.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fsF.a(this.eYo, layoutParams);
    }

    private void bqh() {
        if (this.eXZ != null && this.eXZ.wf() != null) {
            this.aio = this.eXZ.wf();
            if (this.aio.mLiveInfo != null) {
                a(this.aio.mLiveInfo, this.fsU);
                if (this.aio.mLiveInfo != null && this.aio.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit");
                    }
                    if (!this.isBackGround) {
                        this.fsI.f(this.aio.mLiveInfo);
                    } else {
                        this.fsI.setPlayLiveInfo(this.aio.mLiveInfo);
                    }
                    if (this.fsQ != null) {
                        short s = this.aio.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2;
                        this.fsQ.a(this.mTbPageContext, this.eYo, this.fsI, this.fsF, this.eXZ, this.aru, this.fsM, this.eYs, this.fsN, this.ftb);
                        this.fsQ.c(s);
                    }
                }
            }
        }
    }

    private void bqi() {
        this.mTbPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.player.c.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (c.this.aio != null && c.this.aio.VP != null && c.this.aio.VP.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + c.this.aio.mLiveInfo.live_id);
                        c.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.c.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", c.this.aio.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                }
            }
        });
    }

    private void bqj() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.fsM || !this.ftc) {
                this.fsG.setIsScrollable(false);
            } else {
                this.fsG.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && (this.fsQ == null || !this.fsQ.bhf())) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bqj();
            } else if (this.fsQ == null || this.fsQ.bhg()) {
                jN(true);
            }
        }
        return true;
    }

    public void jN(boolean z) {
        F(z, false);
    }

    public void F(boolean z, boolean z2) {
        iM(!z);
        if (this.fsI != null) {
            this.fsI.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        bql();
        long j = -1;
        if (this.eXZ != null && this.eXZ.bnd() != null) {
            j = this.eXZ.bnd().room_id;
        }
        this.fsE.a(z, z2, j);
    }

    public void iM(boolean z) {
        AlaLiveInfoData bnd;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        AlaLiveSwitchData.isHotLive = 0;
        com.baidu.tieba.ala.liveroom.yuangift.a.boL().wN();
        if (this.fth != null) {
            this.fth.release();
        }
        if (this.fsY != null) {
            this.fsY.release();
        }
        this.ftb = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.eXZ != null && (bnd = this.eXZ.bnd()) != null) {
            this.eXZ.cQ(bnd.live_id);
        }
        this.fsV.stopRecord();
        LiveTimerManager.getInstance().stop();
        bqk();
        if (this.fsI != null) {
            this.fsI.jM(z);
        }
        if (this.fsQ != null) {
            this.fsQ.iM(z);
        }
        this.fsX = false;
        n.ayO = 0L;
    }

    private void bqk() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bql() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(k kVar) {
        if (kVar != null) {
            this.aio = kVar;
            if (this.fsQ != null) {
                this.fsQ.a(kVar);
            }
        }
    }

    private void d(g gVar) {
        if (this.fsQ != null) {
            this.fsQ.d(gVar);
        }
    }

    private void r(k kVar) {
        this.aio = kVar;
    }

    private void bqm() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.fsG.setIsScrollable(false);
            this.ftc = false;
        }
        if (this.aio != null) {
            a(this.aio.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.fsF.a(this.eYo, null);
            a(this.fsF, this.aio.mLiveInfo, this.fsL);
            this.fsL = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.eXZ != null && this.eXZ.wf() != null && this.eXZ.wf().mLiveInfo != null) {
                    j = this.eXZ.wf().mLiveInfo.live_id;
                    str2 = this.eXZ.wf().mLiveInfo.room_id + "";
                    str = this.eXZ.wf().mLiveInfo.feed_id;
                } else {
                    if (this.arv > 0) {
                        j2 = this.arv;
                    }
                    if (!TextUtils.isEmpty(this.fsR)) {
                        j = j2;
                        str = "";
                        str2 = this.fsR;
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
            if (this.eXZ != null && this.eXZ.wf() != null && this.eXZ.wf().mLiveInfo != null) {
                str3 = this.eXZ.wf().mLiveInfo.feed_id;
                str4 = this.eXZ.wf().mLiveInfo.live_id + "";
                str5 = this.eXZ.wf().mLiveInfo.room_id + "";
                str6 = this.eXZ.wf().mLiveInfo.user_name;
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
        if (this.fsI != null && this.fsI.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.fsI.getVideoPath();
                String e = a.e(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.fsI.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + e);
                }
                if (!this.fsI.isPlaying() || TextUtils.isEmpty(videoPath) || !videoPath.equals(e)) {
                    if (!z && !alaLiveRoomBlurPageLayout.bx(this.fsI)) {
                        ((ViewGroup) this.fsI.getParent()).removeView(this.fsI);
                        alaLiveRoomBlurPageLayout.a(this.fsI, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.isBackGround) {
                        this.fsI.f(alaLiveInfoData);
                        return;
                    } else {
                        this.fsI.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
                return;
            }
            this.fsI.bqb();
        } else if (this.fsI != null && this.fsI.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.fsI, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.isBackGround) {
                    this.fsI.f(alaLiveInfoData);
                } else {
                    this.fsI.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.fsI != null) {
            this.fsI.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = o.u(this.mTbPageContext.getPageActivity());
                layoutParams.height = o.v(this.mTbPageContext.getPageActivity());
                int aK = o.aK(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = aK + i;
                } else {
                    dimensionPixelSize = aK + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void bqn() {
        this.fsL = true;
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
                this.fsF.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.fsF.setBackgroundColor(0);
            }
        } else {
            this.fsF.setBackgroundColor(0);
        }
        int i2 = this.fsI.getLayoutParams().width;
        int i3 = this.fsI.getLayoutParams().height;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.eYo != null) {
            this.eYo.setLayoutParams(c);
        }
        if (this.fsF != null) {
            this.fsF.bc(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fsP != null) {
            this.fsP.bc(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fsQ != null) {
            this.fsQ.E(c.width, c.height, realScreenOrientation);
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

    private void pY(int i) {
        boolean z = true;
        if (this.aio != null && this.aio.mLiveInfo != null) {
            this.fsF.setBgImageUrl(this.aio.mLiveInfo.cover, this.aio.mLiveInfo);
            this.fsH.a(this.mSelectedPosition, bqo(), this.aio);
            this.fsH.b(this.mSelectedPosition, bqp(), this.aio);
            this.fsF.requestLayout();
            this.fsF.B(i, this.aio.mLiveInfo.screen_direction == 2);
        }
        if (this.aio != null) {
            a(this.aio.mLiveInfo, false);
        }
        boolean boq = this.fsF.boq();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.aio == null || this.aio.mLiveInfo == null || this.aio.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!bqA()) {
            if (this.fsI != null && this.fsI.getParent() == null) {
                this.fsF.a(this.fsI, null, false);
                if (this.aio.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.isBackGround) {
                        this.fsI.f(this.aio.mLiveInfo);
                    } else {
                        this.fsI.setPlayLiveInfo(this.aio.mLiveInfo);
                    }
                }
            }
            if (boq && !bqA() && this.fsQ != null) {
                this.fsF.jB(z);
                return;
            }
            return;
        }
        this.fsF.bok();
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
            this.eXZ.a(alaLiveInfoData.live_id, true, this.aru, this.mForumName);
            this.eXZ.cP(alaLiveInfoData.live_id);
        }
    }

    public void qG(int i) {
        short s;
        if (i < 0) {
            this.eXZ.qm(this.eXZ.bna() - 1);
        } else if (i > 0) {
            this.eXZ.qm(this.eXZ.bna() + 1);
        }
        if (this.fsQ != null) {
            this.fsQ.b(this.fsF);
        }
        this.fsH.a(this.mSelectedPosition, bqo(), this.aio);
        this.fsH.b(this.mSelectedPosition, bqp(), this.aio);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.eXZ != null) {
            int bna = this.eXZ.bna();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bna + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.eXZ.bmS() != null && this.eXZ.bmS().size() > bna && this.eXZ.bmS().get(bna) != null) {
                AlaLiveInfoData alaLiveInfoData = this.eXZ.bmS().get(bna);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.eXZ != null) {
            AlaLiveInfoData bnd = this.eXZ.bnd();
            if (bnd != null) {
                bnd.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.fsF, bnd, this.fsL);
                this.fsL = false;
                if (this.fsQ != null) {
                    if (bnd.screen_direction != 2) {
                        s = 2;
                    } else {
                        s = 1;
                    }
                    this.fsQ.a(this.mTbPageContext, this.eYo, this.fsI, this.fsF, this.eXZ, this.aru, this.fsM, this.eYs, null, this.ftb);
                    this.fsQ.c(s);
                }
                a(bnd, false);
            }
            g(bnd);
            this.fsF.a(this.eYo, null);
            if (this.fsQ != null) {
                this.fsQ.bhd();
            }
            this.eXZ.c(bnd);
        }
    }

    private AlaLiveInfoData bqo() {
        List<AlaLiveInfoData> bmS = this.eXZ.bmS();
        if (bmS == null || bmS.size() == 0) {
            if (this.aio == null) {
                return null;
            }
            return this.aio.mLiveInfo;
        }
        int bna = this.eXZ.bna();
        int size = bmS.size();
        return bmS.get(((bna + size) - 1) % size);
    }

    private AlaLiveInfoData bqp() {
        List<AlaLiveInfoData> bmS = this.eXZ.bmS();
        if (bmS == null || bmS.size() == 0) {
            if (this.aio == null) {
                return null;
            }
            return this.aio.mLiveInfo;
        }
        return bmS.get((this.eXZ.bna() + 1) % bmS.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(int i, String str) {
        ak akVar;
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
            jN(false);
            return;
        }
        k wf = this.eXZ.wf();
        r(wf);
        this.eXZ.bmT();
        if (this.fsL) {
            this.eXZ.jv(false);
        }
        this.eYs = System.currentTimeMillis() / 1000;
        if (this.fsQ != null) {
            if (wf.mLiveInfo.screen_direction != 2) {
                s = 2;
            } else {
                s = 1;
            }
            this.fsQ.a(this.mTbPageContext, this.eYo, this.fsI, this.fsF, this.eXZ, this.aru, this.fsM, this.eYs, this.fsN, this.ftb);
            this.fsQ.c(s);
        }
        bqm();
        if (wf != null && wf.mLiveInfo != null && wf.mLiveInfo.live_status == 2) {
            d(wf, false);
            this.fsL = false;
            return;
        }
        if (!this.fsZ || !TextUtils.equals(p.yw(), this.fta)) {
            s.b(getPageContext());
            com.baidu.live.r.c.wF().wG();
            this.fsZ = true;
            this.fta = p.yw();
        }
        this.fsX = false;
        if (this.eXZ.wf() != null && this.eXZ.wf().mLiveInfo != null) {
            String str2 = this.eXZ.wf().mLiveInfo.feed_id;
            long j = this.eXZ.wf().mLiveInfo.live_id;
            long j2 = this.eXZ.wf().mLiveInfo.user_id;
            this.eXZ.cP(j);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                m.i(j2, j);
            }
            n.g(str2, j);
        }
        if (this.fsQ != null) {
            this.fsQ.iL(TextUtils.equals(this.fsO, "1"));
            this.fsO = "";
        }
        a(this.eXZ.wf());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mTbPageContext != null && c.this.eXZ.wf() != null && c.this.eXZ.wf().mLiveInfo != null) {
                    c.this.eXZ.a(c.this.eXZ.wf().mLiveInfo.live_id, c.this.aru, c.this.eYs);
                }
            }
        }, this.eXZ.wf().VT);
        if (this.eXZ.wf() != null && this.eXZ.wf().VP != null && (akVar = com.baidu.live.r.a.wA().asy) != null && akVar.aaK != null && akVar.aaK.acj) {
            c(true, this.eXZ.wf().VP.userId);
        }
        this.fsL = false;
        if (this.eXZ.wf() != null && this.eXZ.wf().mLiveInfo != null && this.eXZ.wf().VP != null) {
            long j3 = this.eXZ.wf().mLiveInfo.live_id;
            long j4 = this.eXZ.wf().mLiveInfo.room_id;
            String str3 = this.eXZ.wf().mLiveInfo.feed_id;
            com.baidu.tieba.ala.liveroom.yuangift.a.boL().a(this.mTbPageContext.getPageActivity(), j3, "oneYuanGift_" + j3, j4, str3, this.otherParams);
            if (this.fth != null) {
                this.fth.a(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            }
            com.baidu.tieba.ala.guardclub.a.bcp().a(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            if (this.fsY == null) {
                this.fsY = new com.baidu.tieba.ala.liveroom.h.a();
            }
            this.fsY.a(this.mTbPageContext.getPageActivity(), this.eXZ.wf(), this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqq() {
        if (this.fsJ) {
            this.fsH.a(this.mSelectedPosition, bqo(), this.aio);
            this.fsH.b(this.mSelectedPosition, bqp(), this.aio);
            this.fsJ = false;
        }
        if (this.fsP != null && bqA()) {
            this.fsP.S(this.eXZ.bmU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.ftg);
            this.mHandler.postDelayed(this.ftg, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(g gVar) {
        if (gVar == null) {
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.ftf);
                this.mHandler.postDelayed(this.ftf, 5000L);
                return;
            }
            return;
        }
        if (!this.fsK) {
            d(gVar);
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.ftf);
            this.mHandler.postDelayed(this.ftf, gVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqr() {
        if (this.eXZ.wf() != null && this.eXZ.wf().mLiveInfo != null) {
            this.eXZ.cP(this.eXZ.wf().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(k kVar) {
        if (kVar != null && kVar.mLiveInfo != null && kVar.mLiveInfo.live_status == 2) {
            this.fsH.a(this.mSelectedPosition, this.eXZ.wf());
            d(kVar, false);
        } else if (kVar != null) {
            if (!this.fsK) {
                a(kVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fte);
                this.mHandler.postDelayed(this.fte, kVar.VT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqs() {
        if (this.mTbPageContext != null && this.eXZ.wf() != null && this.eXZ.wf().mLiveInfo != null) {
            this.eXZ.a(this.eXZ.wf().mLiveInfo.live_id, this.aru, this.eYs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(k kVar, boolean z) {
        iM(true);
        if (!bqA()) {
            this.eXZ.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            this.fsF.bjl();
            this.fsF.bok();
            this.fsF.bor();
            if (kVar != null && kVar.mLiveInfo != null) {
                this.fsS = kVar.mLiveInfo.live_id;
            }
            bqj();
            bqt();
            bqu();
            if (kVar != null) {
                this.fsP.a(kVar, this.aru, this.eXZ.bmU(), this.mForumName, z);
                this.fsP.a(this.fsF);
                if (this.fsQ != null) {
                    this.fsQ.iM(false);
                    this.fsQ.bhe();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                this.fsF.boo();
                long j = kVar.mLiveInfo.live_id;
                long j2 = kVar.mLiveInfo.room_id;
                String str = kVar.mLiveInfo.feed_id;
                long j3 = kVar.VP.userId;
                String str2 = kVar.VP.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.fsW = new StayTimeBean();
                this.fsW.liveId = kVar.mLiveInfo.live_id;
                this.fsW.roomId = kVar.mLiveInfo.room_id;
                this.fsW.vid = kVar.mLiveInfo.feed_id;
                this.fsW.startTime = System.currentTimeMillis();
            }
            bqC();
        }
    }

    private void bqt() {
    }

    private void bqu() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.fsG);
        }
    }

    public void bqv() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bqw();
        } else {
            bqx();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.eXZ != null && this.eXZ.wf() != null) {
            alaLiveInfoData = this.eXZ.wf().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bqw();
        } else {
            bqx();
        }
        this.fsG.setIsScrollable(!z && this.ftc);
        if (this.fsQ != null) {
            this.fsQ.onKeyboardVisibilityChanged(z);
        }
        if (this.eYo != null) {
            this.eYo.onKeyboardVisibilityChanged(z);
        }
    }

    public void bN(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bqw();
        } else {
            bqx();
        }
        this.eYo.bN(realScreenOrientation);
        pY(realScreenOrientation);
        com.baidu.tieba.ala.liveroom.yuangift.a.boL().qZ();
        if (this.fsY != null) {
            this.fsY.qZ();
        }
    }

    public void bqw() {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.fsG != null) {
            com.baidu.live.utils.h.Q(this.fsG);
        }
    }

    public void bqx() {
        if (this.fsG != null) {
            com.baidu.live.utils.h.R(this.fsG);
        }
    }

    public void onResume() {
        if (this.eXZ != null) {
            this.eXZ.bmG();
        }
        if (this.fsQ != null) {
            this.fsQ.enterForeground();
        }
        if (this.fsY != null) {
            this.fsY.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.t.a.eF(this.mTbPageContext.getPageActivity()) && this.isBackGround) {
            this.isBackGround = false;
            bqy();
        }
    }

    public void bqy() {
        bqs();
        bqr();
        this.eXZ.bmT();
        this.fsI.bqc();
        if (this.fsQ != null) {
            this.fsQ.bhi();
        }
        if (this.eXZ != null && this.eXZ.wf() != null && this.eXZ.wf().mLiveInfo != null) {
            this.fsV.cS(this.eXZ.wf().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aio.mLiveInfo.live_id);
        }
    }

    public void onPause() {
        if (this.eXZ != null) {
            this.eXZ.bmH();
        }
        if (this.fsQ != null) {
            this.fsQ.enterBackground();
        }
    }

    public void onStop() {
        this.isBackGround = true;
        bqz();
    }

    public void bqz() {
        this.mHandler.removeCallbacks(this.fte);
        this.mHandler.removeCallbacks(this.ftf);
        this.mHandler.removeCallbacks(this.ftg);
        this.fsI.pausePlay();
        if (this.fsQ != null) {
            this.fsQ.bhh();
        }
        this.fsV.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            com.baidu.tieba.ala.liveroom.yuangift.a.boL().a(i, i2, intent, this.aio, this.otherParams);
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.fsQ != null) {
            this.fsQ.onActivityResult(i, i2, intent);
        }
    }

    public boolean bqA() {
        return this.fsP != null && this.fsP.bbS();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ftl != null) {
            MessageManager.getInstance().unRegisterListener(this.ftl);
        }
        if (this.ftm != null) {
            MessageManager.getInstance().unRegisterListener(this.ftm);
        }
        MessageManager.getInstance().unRegisterListener(this.ftn);
        MessageManager.getInstance().unRegisterListener(this.eZV);
        MessageManager.getInstance().unRegisterListener(this.eZU);
        MessageManager.getInstance().unRegisterListener(this.fto);
        MessageManager.getInstance().unRegisterListener(this.ftp);
        MessageManager.getInstance().unRegisterListener(this.ftq);
        if (this.fth != null) {
            this.fth.release();
        }
        if (this.fsI != null) {
            this.fsI.jM(true);
        }
        if (this.fsQ != null) {
            this.fsQ.onDestory();
        }
        if (this.fsH != null) {
            this.fsH.onDestroy();
        }
        this.fsF.bjl();
        if (this.fsF != null) {
            this.fsF.release();
            this.fsF = null;
        }
        if (this.fsP != null) {
            this.fsP.onDestroy();
            this.fsP = null;
        }
        if (this.fsW != null && this.eXZ != null && this.eXZ.wf() != null) {
            long j = this.eXZ.wf().mLiveInfo.live_id;
            if (this.fsW.liveId == j && this.fsW.startTime > 0) {
                this.fsW.endTime = System.currentTimeMillis();
                long j2 = this.fsW.endTime - this.fsW.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.fsW.roomId + "", this.fsW.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.fsW = null;
        }
        if (this.eYo != null) {
            this.eYo.bot();
            this.eYo = null;
        }
        if (this.eXZ != null) {
            this.eXZ.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        m.yt();
        q.rk().release();
    }

    public String vi() {
        return this.otherParams;
    }

    public void bqB() {
        if (this.fsT != null) {
            this.otherParams = this.fsT.toString();
            if (this.eXZ != null) {
                this.eXZ.setOtherParams(this.otherParams);
            }
            if (this.fsQ != null) {
                this.fsQ.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            this.fsP.setOtherParams(this.otherParams);
        }
    }

    public void bqC() {
        if (this.fsT != null) {
            String optString = this.fsT.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.fsT.put("tab", "live_jump");
                        this.fsT.put("tag", "");
                        this.fsT.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.fsT.put("tab", "liveroom");
                        this.fsT.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bqB();
            }
        }
    }

    private void c(boolean z, long j) {
        com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
        if (z) {
            dVar.bcJ();
        }
        dVar.cu(j);
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    public void bqD() {
        if (!bqF()) {
            if (this.mNetChangedDialog == null) {
                this.mNetChangedDialog = new BdAlertDialog(getPageContext().getPageActivity());
                this.mNetChangedDialog.setCanceledOnTouchOutside(false);
                this.mNetChangedDialog.setMessage(getPageContext().getResources().getString(a.i.ala_create_not_wifi));
                this.mNetChangedDialog.setPositiveButton(getPageContext().getResources().getString(a.i.sdk_liveroom_attention_guide_btn_text), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.c.11
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        c.this.bqG();
                        c.this.mNetChangedDialog.dismiss();
                    }
                });
                this.mNetChangedDialog = this.mNetChangedDialog.create(this.mTbPageContext);
                this.mNetChangedDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.player.c.13
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getRepeatCount() == 0) {
                            c.this.bqG();
                            c.this.mNetChangedDialog.dismiss();
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

    public void bqE() {
        if (this.mNetChangedDialog != null) {
            this.mNetChangedDialog.dismiss();
        }
    }

    public boolean bqF() {
        return this.mNetChangedDialog != null && this.mNetChangedDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqG() {
        onStart();
        bqH();
    }

    public void bqH() {
        com.baidu.live.gift.b.b.sK().sO();
    }
}
