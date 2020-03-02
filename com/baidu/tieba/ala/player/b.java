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
import com.baidu.live.data.af;
import com.baidu.live.data.ap;
import com.baidu.live.data.aq;
import com.baidu.live.data.m;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.r;
import com.baidu.live.gift.t;
import com.baidu.live.guardclub.e;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.message.h;
import com.baidu.live.o.f;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
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
    private m ald;
    private String awr;
    private long aws;
    private String eOz;
    private com.baidu.tieba.ala.liveroom.m.c fdL;
    private AlaLiveView fec;
    private long feg;
    private c.a feq;
    private HttpMessageListener ffQ;
    private HttpMessageListener ffR;
    private JSONObject fyA;
    private boolean fyB;
    private com.baidu.tieba.ala.liveroom.task.c fyC;
    private StayTimeBean fyD;
    private boolean fyE;
    private com.baidu.tieba.ala.liveroom.i.a fyF;
    private boolean fyG;
    private String fyH;
    private aq fyI;
    private boolean fyJ;
    private boolean fyK;
    private Runnable fyL;
    private Runnable fyM;
    private Runnable fyN;
    private com.baidu.live.x.c fyO;
    private com.baidu.live.o.a fyP;
    com.baidu.live.liveroom.a.b fyQ;
    ViewPager.OnPageChangeListener fyR;
    HttpMessageListener fyS;
    CustomMessageListener fyT;
    CustomMessageListener fyU;
    CustomMessageListener fyV;
    CustomMessageListener fyW;
    private CustomMessageListener fyX;
    private a fyj;
    private AlaLiveRoomBlurPageLayout fyk;
    private AlaLoopViewPager fyl;
    private AlaLoopViewPagerAdapter fym;
    private com.baidu.tieba.ala.liveroom.d.a fyn;
    private com.baidu.tieba.ala.liveroom.d.b fyo;
    private SdkLivePlayer fyp;
    private boolean fyq;
    private boolean fyr;
    private boolean fys;
    private boolean fyt;
    private ArrayList<AlaBroadcastGiftToastData> fyu;
    private String fyv;
    private com.baidu.tieba.ala.endliveroom.a fyw;
    private com.baidu.tieba.ala.liveroom.c.c fyx;
    private String fyy;
    private long fyz;
    private boolean isBackGround;
    private String mForumName;
    private Handler mHandler;
    private BdAlertDialog mNetChangedDialog;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String mUserName;
    private String otherParams;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.fyq = true;
        this.feg = 0L;
        this.fyr = false;
        this.fys = true;
        this.awr = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.fyt = false;
        this.fyv = "0";
        this.mHandler = new Handler();
        this.fyz = -1L;
        this.otherParams = "";
        this.fyB = false;
        this.fyC = com.baidu.tieba.ala.liveroom.task.c.bqy();
        this.fyE = false;
        this.fyG = false;
        this.fyK = false;
        this.fyL = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bsW();
            }
        };
        this.fyM = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.bsV();
            }
        };
        this.fyN = new Runnable() { // from class: com.baidu.tieba.ala.player.b.14
            @Override // java.lang.Runnable
            public void run() {
                b.this.fdL.bpG();
            }
        };
        this.fyP = new com.baidu.live.o.a() { // from class: com.baidu.tieba.ala.player.b.15
            @Override // com.baidu.live.o.a
            public void bk(int i) {
                if (b.this.fyk != null) {
                    if (ListUtils.getCount(b.this.fyp.getAlaLiveInfoDataList()) < 2) {
                        b.this.fyk.bqU();
                    } else {
                        b.this.fyk.bqV();
                    }
                }
                if (b.this.fyx != null) {
                    b.this.fyx.bk(i);
                }
                if (BdNetTypeUtil.isMobileNet()) {
                    if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && k.Ba()) {
                        b.this.onStop();
                        b.this.bth();
                        return;
                    }
                    b.this.btl();
                }
            }
        };
        this.fyQ = new com.baidu.live.liveroom.a.b() { // from class: com.baidu.tieba.ala.player.b.18
            @Override // com.baidu.live.liveroom.a.b
            public void bb(boolean z) {
                if (z || b.this.fyx == null || b.this.fyx.bjO()) {
                    b.this.jZ(true);
                    b.this.bhc();
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bc(boolean z) {
                b.this.d(b.this.ald, z);
            }

            @Override // com.baidu.live.liveroom.a.b
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.fyp.btm();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.isBackGround) {
                    if (b.this.isBackGround) {
                        b.this.fyp.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.fyp.aa(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void e(boolean z, boolean z2) {
                if (b.this.fyl != null) {
                    b.this.fyl.setIsScrollable(b.this.fyJ && z);
                    b.this.fyl.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bd(boolean z) {
                boolean z2 = true;
                if (!z || b.this.bte()) {
                    if (b.this.fyk != null) {
                        b.this.fyk.bqX();
                        return;
                    }
                    return;
                }
                if (b.this.fdL.yO().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.fyk != null) {
                    b.this.fyk.jO(z2);
                }
            }
        };
        this.fyR = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.fec != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.fyl.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.fys || ListUtils.getCount(b.this.fdL.bpF()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && b.this.fdL.bpI() == 1) {
                            if (!b.this.fdL.bpL() || i2 >= 0) {
                                if (b.this.fdL.bpM() && i2 > 0) {
                                    b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    b.this.fyl.setCurrentItem(b.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                b.this.fyl.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        b.this.fdL.cancelLoadData();
                        b.this.mHandler.removeCallbacksAndMessages(null);
                        b.this.iZ(true);
                        b.this.fyk.bqS();
                        b.this.fyk.blN();
                        b.this.fyk.bqT();
                        if (b.this.fdL.yO() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(b.this.fdL.yO().mLiveInfo.live_id + "", b.this.fdL.yO().mLiveInfo.room_id + "", b.this.fdL.yO().XQ.userId + "", b.this.fdL.yO().XQ.userName, System.currentTimeMillis(), b.this.fdL.yO().mLiveInfo.feed_id, b.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(b.this.fdL.yO().mLiveInfo.live_id + "", b.this.fdL.yO().mLiveInfo.room_id + "", b.this.fdL.yO().XQ.userId + "", b.this.fdL.yO().XQ.userName, System.currentTimeMillis(), b.this.fdL.yO().mLiveInfo.feed_id, b.this.otherParams);
                            }
                        }
                        if (b.this.fyD != null) {
                            long j = b.this.fdL.yO().mLiveInfo.live_id;
                            if (b.this.fyD.liveId == j && b.this.fyD.startTime > 0) {
                                b.this.fyD.endTime = System.currentTimeMillis();
                                long j2 = b.this.fyD.endTime - b.this.fyD.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.fyD.roomId + "", b.this.fyD.vid, j2 / 1000, b.this.otherParams);
                            }
                            b.this.fyD = null;
                        }
                        b.this.btg();
                        if (b.this.fyO != null) {
                            b.this.fyO.release();
                        }
                        b.this.mSelectedPosition = i;
                        b.this.fyk = b.this.fym.qf(b.this.mSelectedPosition);
                        b.this.fyk.bqW();
                        b.this.qS(i2);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.fyl.setCurrentItem(b.this.mSelectedPosition);
                        b.this.fdL.d(b.this.fdL.bpQ());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.pr().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.feq = new c.a() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.z(b.this.fdL.yO());
                } else if (i2 == 2) {
                    b.this.g(b.this.fdL.bdY());
                } else if (i2 == 3) {
                    b.this.aB(i, str);
                } else if (i2 == 4) {
                    b.this.as(obj);
                } else if (i2 == 5) {
                    b.this.bsU();
                }
            }
        };
        this.fyS = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bqw() != null && b.this.mTbPageContext != null) {
                        b.this.fyC.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bqw());
                    }
                }
            }
        };
        this.fyT = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.4
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
        this.fyU = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.fdL != null && b.this.fdL.yO() != null && b.this.fdL.yO().mLiveInfo != null) {
                    long j = b.this.fdL.yO().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.fyO != null) {
                        b.this.fyO.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.ffR = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.fdL.yO().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.awI != null && !eventPollingHttpResponseMessage.awI.isEmpty() && b.this.fdL != null && b.this.fdL.yO() != null && b.this.fdL.yO().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.awI.size()) {
                                break;
                            }
                            af afVar = eventPollingHttpResponseMessage.awI.get(i2);
                            if (j == afVar.liveId && j2 - afVar.createTime <= 60 && !com.baidu.live.utils.m.g(afVar.liveId, afVar.id)) {
                                com.baidu.live.utils.m.a(afVar, b.this.fdL.yO().mLiveInfo);
                                com.baidu.live.utils.m.h(afVar.liveId, afVar.id);
                            }
                            i = i2 + 1;
                        }
                        af afVar2 = eventPollingHttpResponseMessage.awI.get(eventPollingHttpResponseMessage.awI.size() - 1);
                        if (j == afVar2.liveId) {
                            com.baidu.live.utils.m.f(afVar2.liveId, afVar2.id);
                        }
                    }
                    int i3 = eventPollingHttpResponseMessage.awH;
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.fdL != null && b.this.fdL.yO() != null) {
                                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                    com.baidu.live.utils.m.i(b.this.fdL.yO().mLiveInfo.user_id, b.this.fdL.yO().mLiveInfo.live_id);
                                }
                            }
                        }
                    }, i3 * 1000);
                }
            }
        };
        this.ffQ = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h)) {
                        h hVar = (h) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (b.this.fdL != null && b.this.fdL.yO() != null) {
                            long j = b.this.fdL.yO().mLiveInfo.live_id;
                            if (j == hVar.liveId) {
                                getVideoGoodsListHttpResponseMessage.liveId = j;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                                if (!b.this.fyE) {
                                    b.this.fyE = true;
                                    String str = "goods_task_" + j;
                                    ap apVar = com.baidu.live.v.a.zl().axC;
                                    long j2 = (apVar == null || apVar.acW == null) ? 10L : apVar.acW.aeF;
                                    if (j2 <= 0) {
                                        j2 = 10;
                                    }
                                    LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.b.7.1
                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onComplete(boolean z) {
                                            if (b.this.fdL != null && b.this.fdL.yO() != null && b.this.fdL.yO().mLiveInfo.live_id != o.aDQ) {
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, b.this.fdL.yO().mLiveInfo));
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
        this.fyV = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.fdL != null && b.this.fdL.yO() != null && b.this.fdL.yO().Ye != null) {
                        if (l.longValue() == b.this.fdL.yO().Ye.userId) {
                            b.this.fdL.yO().Ye.isNewUser = false;
                            if (b.this.fyF != null) {
                                b.this.fyF.s(b.this.fdL.yO());
                            }
                        }
                    }
                }
            }
        };
        this.fyW = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.q.a)) {
                    com.baidu.tieba.ala.liveroom.q.a aVar2 = (com.baidu.tieba.ala.liveroom.q.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String aXT = aVar2.aXT();
                    if (b.this.mTbPageContext != null && b.this.fdL != null && b.this.fdL.yO() != null && b.this.fdL.yO().Ye != null) {
                        if (valueOf.longValue() == b.this.fdL.yO().Ye.userId && com.baidu.live.v.a.zl().axC != null && com.baidu.live.v.a.zl().axC.acQ != null && com.baidu.live.v.a.zl().axC.acQ.qJ()) {
                            g.pY(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, aXT));
                        }
                    }
                }
            }
        };
        this.fyX = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.fyL != null) {
                    b.this.mHandler.removeCallbacks(b.this.fyL);
                }
                b.this.bsW();
            }
        };
        this.feg = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.fyj = aVar;
        this.fyq = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
        if (runTask != null) {
            this.fyO = (com.baidu.live.x.c) runTask.getData();
        }
        this.fdL = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.fdL.a(this.feq);
        this.fyw = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.fyS);
        MessageManager.getInstance().registerListener(this.fyT);
        MessageManager.getInstance().registerListener(this.fyU);
        MessageManager.getInstance().registerListener(this.ffR);
        MessageManager.getInstance().registerListener(this.ffQ);
        MessageManager.getInstance().registerListener(this.fyV);
        MessageManager.getInstance().registerListener(this.fyW);
        MessageManager.getInstance().registerListener(this.fyX);
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.fyu = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.fyu.add(alaBroadcastGiftToastData);
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
        this.awr = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.awr)) {
            this.awr = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.mUserName = intent.getStringExtra("user_name");
        this.fyy = intent.getStringExtra("room_id");
        this.aws = intent.getLongExtra("live_id", 0L);
        this.fyB = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.fdL.b((AlaLiveInfoCoreData) serializableExtra);
            this.fyB = true;
        }
        ah(intent);
        this.fyJ = this.fyI == null || !this.fyI.adg;
        this.fyw.setOtherParams(this.otherParams);
        this.fyt = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bsI();
        bsH();
    }

    private void ah(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.eOz = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.fyA = new JSONObject(stringExtra);
                if (this.fyA != null) {
                    String optString = this.fyA.optString("enterRoomId");
                    String optString2 = this.fyA.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.fyy, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.aws + "", optString2))) {
                        String optString3 = this.fyA.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.fyA.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.fyB) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.aws;
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString4, alaLiveInfoCoreData);
                            this.fdL.b(alaLiveInfoCoreData);
                            this.fyB = true;
                        }
                    }
                    String optString5 = this.fyA.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.fyI = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.eOz = jSONObject.optString("live_back_scheme");
                        this.fyI = new aq();
                        this.fyI.adg = jSONObject.optInt("is_hot") == 1;
                        if (this.fyI.adg) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.fyI.adh = jSONObject.optString("task_id");
                        this.fyI.adf = !TextUtils.isEmpty(this.fyI.adh);
                        this.fyI.adi = jSONObject.optInt("task_type");
                        this.fyI.adj = jSONObject.optInt("task_im_count");
                        this.fyI.adk = jSONObject.optLong("task_gift_total_price");
                        this.fyI.adl = jSONObject.optLong("task_watch_time");
                        this.fyI.adm = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                        String optString6 = jSONObject.optString("back_app_scheme");
                        String optString7 = jSONObject.optString("back_app_icon");
                        String optString8 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            this.fyo = new com.baidu.tieba.ala.liveroom.d.b();
                            this.fyo.setScheme(optString6);
                            this.fyo.setImageUrl(optString7);
                            this.fyo.setTitle(optString8);
                        }
                    }
                    this.fyv = this.fyA.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fyA.remove("cover");
                    this.fyA.remove("live_url");
                    this.fyA.remove("enterRoomId");
                    this.fyA.remove("enterLiveId");
                    this.fyA.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fyA.remove("extra");
                    this.otherParams = this.fyA.toString();
                    this.fdL.setOtherParams(this.otherParams);
                    this.fyA.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.fyA.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.fyA.optString("source");
                    }
                    this.fyK = "mobilebaidu_subscription".equals(str);
                    int optInt = this.fyA.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.fdL.qx(optInt);
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

    public void bsH() {
        if (!TextUtils.isEmpty(this.mUserName)) {
            this.fdL.ac(this.mUserName, this.awr, this.mForumName);
        } else if (this.fdL.yO() != null && this.fdL.yO().mLiveInfo != null && this.fdL.yO().mLiveInfo.live_id > 0) {
            this.fdL.a(this.fdL.yO().mLiveInfo.live_id, false, this.awr, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uname=")) {
                this.mUserName = WebviewHelper.getMatchStringFromURL(lowerCase, "uname=");
            }
            if (lowerCase.contains("from=")) {
                this.awr = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.mUserName == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                jZ(false);
                return;
            }
            this.fdL.ac(this.mUserName, this.awr, this.mForumName);
        } else if (!TextUtils.isEmpty(this.fyy)) {
            this.fdL.zi(this.fyy);
        } else if (this.aws > 0) {
            this.fdL.a(this.aws, false, this.awr, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            jZ(false);
        }
    }

    private void bsI() {
        this.fys = true;
        this.fyr = false;
        bsJ();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        this.fyx = new com.baidu.tieba.ala.liveroom.c.c();
        this.fyx.a(this.fyQ);
        this.fyx.setOtherParams(this.otherParams);
        this.fyx.iU(this.fyK);
        bsL();
        bsM();
        bsK();
    }

    private void bsJ() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.fyl = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.fyl.setOnPageChangeListener(this.fyR);
        this.fyl.setBoundaryCaching(true);
        this.fyl.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.fym = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.fym.bni();
        this.fyk = this.fym.qe(this.mSelectedPosition);
        this.fym.a(this.mSelectedPosition, this.fdL.yO());
        this.fyl.setAdapter(this.fym);
        this.fyl.setCurrentItem(this.mSelectedPosition);
        this.fyl.setIsScrollable(this.fyJ);
    }

    private void c(Rect rect) {
        this.fyp = SdkLivePlayer.eK(getPageContext().getPageActivity());
        if (this.fyp == null) {
            this.fyl.setIsScrollable(false);
            if (this.fdL != null) {
                this.fdL.cancelLoadData();
            }
            bnl();
            return;
        }
        if (this.fyt) {
            this.fyl.setIsScrollable(false);
        }
        this.fyp.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.fyp.setIPlayerCallBack(this.fyP);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fyk.a(this.fyp, layoutParams, true);
    }

    private void bsK() {
        this.fyn = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext);
    }

    private void bnl() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.16
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.jZ(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.fec = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.fec.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fyk.a(this.fec, layoutParams);
    }

    private void bsL() {
        if (this.fdL != null && this.fdL.yO() != null) {
            this.ald = this.fdL.yO();
            if (this.ald.mLiveInfo != null) {
                a(this.ald.mLiveInfo, this.fyB);
                if (this.ald.mLiveInfo != null && this.ald.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.isBackGround);
                    }
                    if (!this.isBackGround) {
                        this.fyp.g(this.ald.mLiveInfo);
                    } else {
                        this.fyp.setPlayLiveInfo(this.ald.mLiveInfo);
                    }
                    if (this.fyx != null) {
                        this.fyx.a(this.mTbPageContext, this.fec, this.fyp, this.fyk, this.fdL, this.awr, this.fyt, this.feg, this.fyu, this.fyI);
                        j(this.ald.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private void bsM() {
        this.mTbPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (b.this.ald != null && b.this.ald.XQ != null && b.this.ald.XQ.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + b.this.ald.mLiveInfo.live_id);
                        b.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", b.this.ald.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                }
            }
        });
    }

    private void bsN() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.fyt || !this.fyJ) {
                this.fyl.setIsScrollable(false);
            } else {
                this.fyl.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && ((this.fyx == null || !this.fyx.onKeyDown(i, keyEvent)) && (this.fyx == null || !this.fyx.bjN()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bsN();
            } else if (this.fyx == null || this.fyx.bjO()) {
                jZ(true);
                bhc();
            }
        }
        return true;
    }

    public void bhc() {
        if (!TextUtils.isEmpty(this.eOz)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.eOz);
                this.eOz = null;
            }
        }
    }

    public void jZ(boolean z) {
        H(z, false);
    }

    public void H(boolean z, boolean z2) {
        iZ(!z);
        if (this.fyp != null) {
            this.fyp.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        bsP();
        long j = -1;
        if (this.fdL != null && this.fdL.bpQ() != null) {
            j = this.fdL.bpQ().room_id;
        }
        this.fyj.a(z, z2, j);
    }

    public void iZ(boolean z) {
        AlaLiveInfoData bpQ;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        if (aa.sO() != null) {
            aa.sO().sN();
        }
        if (this.fyO != null) {
            this.fyO.release();
        }
        if (this.fyF != null) {
            this.fyF.release();
        }
        this.fyI = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.fdL != null && (bpQ = this.fdL.bpQ()) != null) {
            this.fdL.cY(bpQ.live_id);
        }
        this.fyC.stopRecord();
        LiveTimerManager.getInstance().stop();
        bsO();
        if (this.fyp != null) {
            this.fyp.ka(z);
        }
        if (this.fyx != null) {
            this.fyx.iZ(z);
        }
        this.fyE = false;
        o.aDQ = 0L;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
    }

    private void bsO() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bsP() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(m mVar) {
        if (mVar != null) {
            this.ald = mVar;
            if (this.fyx != null) {
                this.fyx.a(mVar);
            }
        }
    }

    private void d(com.baidu.live.data.h hVar) {
        if (this.fyx != null) {
            this.fyx.d(hVar);
        }
    }

    private void y(m mVar) {
        this.ald = mVar;
    }

    private void bsQ() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.fyl.setIsScrollable(false);
            this.fyJ = false;
        }
        if (this.ald != null) {
            a(this.ald.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.fyk.a(this.fec, null);
            a(this.fyk, this.ald.mLiveInfo, this.fys);
            this.fys = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.fdL != null && this.fdL.yO() != null && this.fdL.yO().mLiveInfo != null) {
                    j = this.fdL.yO().mLiveInfo.live_id;
                    str2 = this.fdL.yO().mLiveInfo.room_id + "";
                    str = this.fdL.yO().mLiveInfo.feed_id;
                } else {
                    if (this.aws > 0) {
                        j2 = this.aws;
                    }
                    if (!TextUtils.isEmpty(this.fyy)) {
                        j = j2;
                        str = "";
                        str2 = this.fyy;
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
                if (this.fdL != null && this.fdL.yO() != null && this.fdL.yO().mLiveInfo != null) {
                    str3 = this.fdL.yO().mLiveInfo.feed_id;
                    str4 = this.fdL.yO().mLiveInfo.live_id + "";
                    str5 = this.fdL.yO().mLiveInfo.room_id + "";
                    str6 = this.fdL.yO().mLiveInfo.user_name;
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

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (this.fyp != null && this.fyp.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.fyp.getVideoPath();
                String b = f.b(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.fyp.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + b);
                }
                if (!f.ai(videoPath, b)) {
                    if (!TbadkCoreApplication.getInst().isTieba() || !z || !f.ah(videoPath, b)) {
                        if (!z && !alaLiveRoomBlurPageLayout.bC(this.fyp)) {
                            ((ViewGroup) this.fyp.getParent()).removeView(this.fyp);
                            alaLiveRoomBlurPageLayout.a(this.fyp, null, false);
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                        }
                        if (!this.isBackGround) {
                            this.fyp.g(alaLiveInfoData);
                            return;
                        } else {
                            this.fyp.setPlayLiveInfo(alaLiveInfoData);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.fyp.btm();
        } else if (this.fyp != null && this.fyp.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.fyp, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.isBackGround) {
                    this.fyp.g(alaLiveInfoData);
                } else {
                    this.fyp.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.fyp != null) {
            this.fyp.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.v(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.w(this.mTbPageContext.getPageActivity());
                int aO = p.aO(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = aO + i;
                } else {
                    dimensionPixelSize = aO + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void bsR() {
        this.fys = true;
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
                this.fyk.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.fyk.setBackgroundColor(0);
            }
        } else {
            this.fyk.setBackgroundColor(0);
        }
        int i2 = this.fyp.getLayoutParams().width;
        int i3 = this.fyp.getLayoutParams().height;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.fec != null) {
            this.fec.setLayoutParams(c);
        }
        if (this.fyk != null) {
            this.fyk.bg(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fyw != null) {
            this.fyw.bg(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fyx != null) {
            this.fyx.j(c.width, c.height, realScreenOrientation);
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

    private void ql(int i) {
        boolean z = true;
        if (this.ald != null && this.ald.mLiveInfo != null) {
            this.fyk.setBgImageUrl(this.ald.mLiveInfo.cover, this.ald.mLiveInfo);
            this.fym.a(this.mSelectedPosition, bsS(), this.ald);
            this.fym.b(this.mSelectedPosition, bsT(), this.ald);
            this.fyk.requestLayout();
            this.fyk.A(i, this.ald.mLiveInfo.screen_direction == 2);
        }
        if (this.ald != null) {
            a(this.ald.mLiveInfo, false);
        }
        boolean bqY = this.fyk.bqY();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.ald == null || this.ald.mLiveInfo == null || this.ald.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!bte()) {
            if (this.fyp != null && this.fyp.getParent() == null) {
                this.fyk.a(this.fyp, null, false);
                if (this.ald != null && this.ald.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.isBackGround) {
                        this.fyp.g(this.ald.mLiveInfo);
                    } else {
                        this.fyp.setPlayLiveInfo(this.ald.mLiveInfo);
                    }
                }
            }
            if (bqY && !bte() && this.fyx != null) {
                this.fyk.jO(z);
                return;
            }
            return;
        }
        this.fyk.bqS();
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

    private void f(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.fdL.a(alaLiveInfoData.live_id, true, this.awr, this.mForumName);
            this.fdL.cX(alaLiveInfoData.live_id);
        }
    }

    public void qS(int i) {
        if (i < 0) {
            this.fdL.qy(this.fdL.bpN() - 1);
        } else if (i > 0) {
            this.fdL.qy(this.fdL.bpN() + 1);
        }
        if (this.fyx != null) {
            this.fyx.a(this.fyk);
        }
        this.fym.a(this.mSelectedPosition, bsS(), this.ald);
        this.fym.b(this.mSelectedPosition, bsT(), this.ald);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.fdL != null) {
            int bpN = this.fdL.bpN();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bpN + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.fdL.bpF() != null && this.fdL.bpF().size() > bpN && this.fdL.bpF().get(bpN) != null) {
                AlaLiveInfoData alaLiveInfoData = this.fdL.bpF().get(bpN);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fdL != null) {
            AlaLiveInfoData bpQ = this.fdL.bpQ();
            if (bpQ != null) {
                bpQ.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.fyk, bpQ, this.fys);
                this.fys = false;
                if (this.fyx != null) {
                    this.fyx.a(this.mTbPageContext, this.fec, this.fyp, this.fyk, this.fdL, this.awr, this.fyt, this.feg, null, this.fyI);
                    short s = 2;
                    if (bpQ.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bpQ, false);
            }
            f(bpQ);
            this.fyk.a(this.fec, null);
            if (this.fyx != null) {
                this.fyx.bjL();
            }
            this.fdL.d(bpQ);
        }
    }

    private AlaLiveInfoData bsS() {
        List<AlaLiveInfoData> bpF = this.fdL.bpF();
        if (bpF == null || bpF.size() == 0) {
            if (this.ald == null) {
                return null;
            }
            return this.ald.mLiveInfo;
        }
        int bpN = this.fdL.bpN();
        int size = bpF.size();
        return bpF.get(((bpN + size) - 1) % size);
    }

    private AlaLiveInfoData bsT() {
        List<AlaLiveInfoData> bpF = this.fdL.bpF();
        if (bpF == null || bpF.size() == 0) {
            if (this.ald == null) {
                return null;
            }
            return this.ald.mLiveInfo;
        }
        return bpF.get((this.fdL.bpN() + 1) % bpF.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(int i, String str) {
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
            jZ(false);
            return;
        }
        m yO = this.fdL.yO();
        y(yO);
        this.fdL.bpG();
        if (this.fys) {
            this.fdL.jI(false);
        }
        this.feg = System.currentTimeMillis() / 1000;
        if (this.fyx != null) {
            this.fyx.a(this.mTbPageContext, this.fec, this.fyp, this.fyk, this.fdL, this.awr, this.fyt, this.feg, this.fyu, this.fyI);
            short s = 2;
            if (yO.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bsQ();
        if (yO != null && yO.mLiveInfo != null && yO.mLiveInfo.live_status == 2) {
            this.fym.a(this.mSelectedPosition, this.fdL.yO());
            d(yO, false);
            this.fys = false;
            return;
        }
        boolean z = (this.fyx == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.fyG || !TextUtils.equals(q.Bh(), this.fyH))) {
            t.b(getPageContext());
            com.baidu.live.v.c.zq().zr();
            this.fyG = true;
            this.fyH = q.Bh();
        }
        this.fyE = false;
        if (this.fdL.yO() != null && this.fdL.yO().mLiveInfo != null) {
            String str2 = this.fdL.yO().mLiveInfo.feed_id;
            long j = this.fdL.yO().mLiveInfo.live_id;
            long j2 = this.fdL.yO().mLiveInfo.user_id;
            this.fdL.cX(j);
            if (z) {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                    com.baidu.live.utils.m.i(j2, j);
                }
                o.g(str2, j);
            }
        }
        if (this.fyx != null) {
            this.fyx.iY(TextUtils.equals(this.fyv, "1"));
            this.fyv = "";
        }
        if (this.fyn != null) {
            this.fyn.a(this.ald, this.fyo);
        }
        a(this.fdL.yO());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.fdL.yO() != null && b.this.fdL.yO().mLiveInfo != null) {
                    b.this.fdL.a(b.this.fdL.yO().mLiveInfo.live_id, b.this.awr, b.this.feg);
                }
            }
        }, this.fdL.yO().XU);
        if (z && this.fdL.yO() != null && this.fdL.yO().XQ != null) {
            ap apVar = com.baidu.live.v.a.zl().axC;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && apVar != null && apVar.acV != null && apVar.acV.aez) {
                c(true, this.fdL.yO().XQ.userId);
            }
        }
        this.fys = false;
        if (z && this.fdL.yO() != null && this.fdL.yO().mLiveInfo != null && this.fdL.yO().XQ != null && this.fyx != null) {
            long j3 = this.fdL.yO().mLiveInfo.live_id;
            long j4 = this.fdL.yO().mLiveInfo.room_id;
            String str3 = this.fdL.yO().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j3;
                if (aa.sO() != null) {
                    aa.sO().a(this.mTbPageContext.getPageActivity(), j3, str4, j4, str3, this.otherParams);
                }
                if (this.fyO != null) {
                    this.fyO.b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
                }
            }
            if (e.vG() != null) {
                e.vG().b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            }
            if (this.fyF == null) {
                this.fyF = new com.baidu.tieba.ala.liveroom.i.a();
            }
            this.fyF.a(this.mTbPageContext.getPageActivity(), this.fdL.yO(), this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsU() {
        if (this.fyq) {
            this.fym.a(this.mSelectedPosition, bsS(), this.ald);
            this.fym.b(this.mSelectedPosition, bsT(), this.ald);
            this.fyq = false;
        }
        if (this.fyw != null && bte()) {
            this.fyw.U(this.fdL.bpH());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.fyN);
            this.mHandler.postDelayed(this.fyN, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.live.data.h hVar) {
        if (hVar == null) {
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fyM);
                this.mHandler.postDelayed(this.fyM, 5000L);
                return;
            }
            return;
        }
        if (!this.fyr) {
            d(hVar);
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.fyM);
            this.mHandler.postDelayed(this.fyM, hVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsV() {
        if (this.fdL.yO() != null && this.fdL.yO().mLiveInfo != null) {
            this.fdL.cX(this.fdL.yO().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.live_status == 2) {
            this.fym.a(this.mSelectedPosition, this.fdL.yO());
            d(mVar, false);
        } else if (mVar != null) {
            if (!this.fyr) {
                a(mVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fyL);
                this.mHandler.postDelayed(this.fyL, mVar.XU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsW() {
        if (this.mTbPageContext != null && this.fdL.yO() != null && this.fdL.yO().mLiveInfo != null) {
            this.fdL.a(this.fdL.yO().mLiveInfo.live_id, this.awr, this.feg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar, boolean z) {
        View view = null;
        iZ(true);
        if (!bte()) {
            this.fdL.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            this.fyk.blN();
            this.fyk.bqS();
            this.fyk.bqZ();
            if (mVar != null && mVar.mLiveInfo != null) {
                this.fyz = mVar.mLiveInfo.live_id;
            }
            bsN();
            bsX();
            bsY();
            if (mVar != null) {
                if (this.fyx != null && this.fyx.bjR() != null) {
                    view = this.fyx.bjR().a(this.fyx.bjI().pageContext.getPageActivity(), mVar, z);
                }
                this.fyw.a(this.fyk, view, mVar, z, this.fdL.bpH());
                if (this.fyx != null) {
                    this.fyx.iZ(false);
                    this.fyx.bjM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                this.fyk.bqW();
                long j = mVar.mLiveInfo.live_id;
                long j2 = mVar.mLiveInfo.room_id;
                String str = mVar.mLiveInfo.feed_id;
                long j3 = mVar.XQ.userId;
                String str2 = mVar.XQ.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.fyD = new StayTimeBean();
                this.fyD.liveId = mVar.mLiveInfo.live_id;
                this.fyD.roomId = mVar.mLiveInfo.room_id;
                this.fyD.vid = mVar.mLiveInfo.feed_id;
                this.fyD.startTime = System.currentTimeMillis();
            }
            btg();
            if (this.fyn != null) {
                this.fyn.a(this.ald, this.fyo);
            }
        }
    }

    private void bsX() {
    }

    private void bsY() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.fyl);
        }
    }

    public void bsZ() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bta();
        } else {
            btb();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.fdL != null && this.fdL.yO() != null) {
            alaLiveInfoData = this.fdL.yO().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bta();
        } else {
            btb();
        }
        this.fyl.setIsScrollable(!z && this.fyJ);
        if (this.fyx != null) {
            this.fyx.onKeyboardVisibilityChanged(z);
        }
        if (this.fec != null) {
            this.fec.onKeyboardVisibilityChanged(z);
        }
    }

    public void bW(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bta();
        } else {
            btb();
        }
        this.fec.bW(realScreenOrientation);
        ql(realScreenOrientation);
        if (aa.sO() != null) {
            aa.sO().sm();
        }
        if (this.fyF != null) {
            this.fyF.sm();
        }
        if (this.fyn != null) {
            this.fyn.bW(realScreenOrientation);
        }
    }

    public void bta() {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.fyl != null) {
            com.baidu.live.utils.h.S(this.fyl);
        }
    }

    public void btb() {
        if (this.fyl != null) {
            com.baidu.live.utils.h.T(this.fyl);
        }
    }

    public void onResume() {
        if (this.fdL != null) {
            this.fdL.bpr();
            this.fdL.bpu();
        }
        if (this.fyx != null) {
            this.fyx.enterForeground();
        }
        if (this.fyF != null) {
            this.fyF.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.t.a.eI(this.mTbPageContext.getPageActivity()) && this.isBackGround) {
            this.isBackGround = false;
            btc();
        }
    }

    public void btc() {
        bsW();
        bsV();
        this.fdL.bpG();
        this.fyp.btn();
        if (this.fyx != null) {
            this.fyx.bjQ();
        }
        if (this.fdL != null && this.fdL.yO() != null && this.fdL.yO().mLiveInfo != null) {
            this.fyC.da(this.fdL.yO().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.ald.mLiveInfo.live_id);
        }
    }

    public void onPause() {
        if (this.fdL != null) {
            this.fdL.bps();
            this.fdL.bpv();
        }
        if (this.fyx != null) {
            this.fyx.enterBackground();
        }
    }

    public void onStop() {
        this.isBackGround = true;
        btd();
    }

    public void btd() {
        this.mHandler.removeCallbacks(this.fyL);
        this.mHandler.removeCallbacks(this.fyM);
        this.mHandler.removeCallbacks(this.fyN);
        this.fyp.pausePlay();
        if (this.fyx != null) {
            this.fyx.bjP();
        }
        this.fyC.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (aa.sO() != null) {
                aa.sO().a(i, i2, intent, this.ald, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.fyx != null) {
            this.fyx.onActivityResult(i, i2, intent);
        }
    }

    public boolean bte() {
        return this.fyw != null && this.fyw.beE();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fyS != null) {
            MessageManager.getInstance().unRegisterListener(this.fyS);
        }
        if (this.fyT != null) {
            MessageManager.getInstance().unRegisterListener(this.fyT);
        }
        MessageManager.getInstance().unRegisterListener(this.fyU);
        MessageManager.getInstance().unRegisterListener(this.ffR);
        MessageManager.getInstance().unRegisterListener(this.ffQ);
        MessageManager.getInstance().unRegisterListener(this.fyV);
        MessageManager.getInstance().unRegisterListener(this.fyW);
        MessageManager.getInstance().unRegisterListener(this.fyX);
        if (this.fyO != null) {
            this.fyO.release();
        }
        if (this.fyp != null) {
            this.fyp.ka(true);
        }
        if (this.fyn != null) {
            this.fyn.onDestory();
        }
        this.fyo = null;
        if (this.fyx != null) {
            this.fyx.onDestroy();
        }
        if (this.fym != null) {
            this.fym.onDestroy();
        }
        this.fyk.blN();
        if (this.fyk != null) {
            this.fyk.release();
            this.fyk = null;
        }
        if (this.fyw != null) {
            this.fyw.onDestroy();
            this.fyw = null;
        }
        if (this.fyD != null && this.fdL != null && this.fdL.yO() != null) {
            long j = this.fdL.yO().mLiveInfo.live_id;
            if (this.fyD.liveId == j && this.fyD.startTime > 0) {
                this.fyD.endTime = System.currentTimeMillis();
                long j2 = this.fyD.endTime - this.fyD.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.fyD.roomId + "", this.fyD.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.fyD = null;
        }
        if (this.fec != null) {
            this.fec.brb();
            this.fec = null;
        }
        if (this.fdL != null) {
            this.fdL.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        com.baidu.live.utils.m.Bc();
        r.sx().release();
    }

    public String xx() {
        return this.otherParams;
    }

    public void btf() {
        if (this.fyA != null) {
            this.otherParams = this.fyA.toString();
            if (this.fdL != null) {
                this.fdL.setOtherParams(this.otherParams);
            }
            if (this.fyx != null) {
                this.fyx.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            this.fyw.setOtherParams(this.otherParams);
        }
    }

    public void btg() {
        if (this.fyA != null) {
            String optString = this.fyA.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.fyA.put("tab", "live_jump");
                        this.fyA.put("tag", "");
                        this.fyA.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.fyA.put("tab", "liveroom");
                        this.fyA.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                btf();
            }
        }
    }

    private void c(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.vE();
        }
        bVar.D(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void bth() {
        if (!btj()) {
            if (this.mNetChangedDialog == null) {
                this.mNetChangedDialog = new BdAlertDialog(getPageContext().getPageActivity());
                this.mNetChangedDialog.setCanceledOnTouchOutside(false);
                this.mNetChangedDialog.setMessage(getPageContext().getResources().getString(a.i.ala_create_not_wifi));
                this.mNetChangedDialog.setPositiveButton(getPageContext().getResources().getString(a.i.sdk_liveroom_attention_guide_btn_text), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.11
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        b.this.btk();
                        b.this.mNetChangedDialog.dismiss();
                    }
                });
                this.mNetChangedDialog = this.mNetChangedDialog.create(this.mTbPageContext);
                this.mNetChangedDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.player.b.13
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getRepeatCount() == 0) {
                            b.this.btk();
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

    public void bti() {
        if (this.mNetChangedDialog != null) {
            this.mNetChangedDialog.dismiss();
        }
    }

    public boolean btj() {
        return this.mNetChangedDialog != null && this.mNetChangedDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btk() {
        onStart();
        btl();
    }

    public void btl() {
        t.sJ();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fyx.d(s);
        } else {
            this.fyx.e(s);
        }
    }
}
