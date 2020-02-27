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
import com.baidu.live.o.d;
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
    private String awq;
    private long awr;
    private String eOy;
    private com.baidu.tieba.ala.liveroom.m.c fdK;
    private AlaLiveView feb;
    private long fef;
    private c.a fep;
    private HttpMessageListener ffP;
    private HttpMessageListener ffQ;
    private boolean fyA;
    private com.baidu.tieba.ala.liveroom.task.c fyB;
    private StayTimeBean fyC;
    private boolean fyD;
    private com.baidu.tieba.ala.liveroom.i.a fyE;
    private boolean fyF;
    private String fyG;
    private aq fyH;
    private boolean fyI;
    private boolean fyJ;
    private Runnable fyK;
    private Runnable fyL;
    private Runnable fyM;
    private com.baidu.live.x.c fyN;
    private com.baidu.live.o.a fyO;
    com.baidu.live.liveroom.a.b fyP;
    ViewPager.OnPageChangeListener fyQ;
    HttpMessageListener fyR;
    CustomMessageListener fyS;
    CustomMessageListener fyT;
    CustomMessageListener fyU;
    CustomMessageListener fyV;
    private CustomMessageListener fyW;
    private a fyi;
    private AlaLiveRoomBlurPageLayout fyj;
    private AlaLoopViewPager fyk;
    private AlaLoopViewPagerAdapter fyl;
    private com.baidu.tieba.ala.liveroom.d.a fym;
    private com.baidu.tieba.ala.liveroom.d.b fyn;
    private SdkLivePlayer fyo;
    private boolean fyp;
    private boolean fyq;
    private boolean fyr;
    private boolean fys;
    private ArrayList<AlaBroadcastGiftToastData> fyt;
    private String fyu;
    private com.baidu.tieba.ala.endliveroom.a fyv;
    private com.baidu.tieba.ala.liveroom.c.c fyw;
    private String fyx;
    private long fyy;
    private JSONObject fyz;
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
        this.fyp = true;
        this.fef = 0L;
        this.fyq = false;
        this.fyr = true;
        this.awq = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.fys = false;
        this.fyu = "0";
        this.mHandler = new Handler();
        this.fyy = -1L;
        this.otherParams = "";
        this.fyA = false;
        this.fyB = com.baidu.tieba.ala.liveroom.task.c.bqw();
        this.fyD = false;
        this.fyF = false;
        this.fyJ = false;
        this.fyK = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bsU();
            }
        };
        this.fyL = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.bsT();
            }
        };
        this.fyM = new Runnable() { // from class: com.baidu.tieba.ala.player.b.14
            @Override // java.lang.Runnable
            public void run() {
                b.this.fdK.bpE();
            }
        };
        this.fyO = new com.baidu.live.o.a() { // from class: com.baidu.tieba.ala.player.b.15
            @Override // com.baidu.live.o.a
            public void bk(int i) {
                if (b.this.fyj != null) {
                    if (ListUtils.getCount(b.this.fyo.getAlaLiveInfoDataList()) < 2) {
                        b.this.fyj.bqS();
                    } else {
                        b.this.fyj.bqT();
                    }
                }
                if (b.this.fyw != null) {
                    b.this.fyw.bk(i);
                }
                if (BdNetTypeUtil.isMobileNet()) {
                    if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && k.AY()) {
                        b.this.onStop();
                        b.this.btf();
                        return;
                    }
                    b.this.btj();
                }
            }
        };
        this.fyP = new com.baidu.live.liveroom.a.b() { // from class: com.baidu.tieba.ala.player.b.18
            @Override // com.baidu.live.liveroom.a.b
            public void bb(boolean z) {
                if (z || b.this.fyw == null || b.this.fyw.bjM()) {
                    b.this.jZ(true);
                    b.this.bha();
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
                b.this.fyo.btk();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.isBackGround) {
                    if (b.this.isBackGround) {
                        b.this.fyo.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.fyo.aa(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void e(boolean z, boolean z2) {
                if (b.this.fyk != null) {
                    b.this.fyk.setIsScrollable(b.this.fyI && z);
                    b.this.fyk.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bd(boolean z) {
                boolean z2 = true;
                if (!z || b.this.btc()) {
                    if (b.this.fyj != null) {
                        b.this.fyj.bqV();
                        return;
                    }
                    return;
                }
                if (b.this.fdK.yN().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.fyj != null) {
                    b.this.fyj.jO(z2);
                }
            }
        };
        this.fyQ = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.feb != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.fyk.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.fyr || ListUtils.getCount(b.this.fdK.bpD()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && b.this.fdK.bpG() == 1) {
                            if (!b.this.fdK.bpJ() || i2 >= 0) {
                                if (b.this.fdK.bpK() && i2 > 0) {
                                    b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    b.this.fyk.setCurrentItem(b.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                b.this.fyk.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        b.this.fdK.cancelLoadData();
                        b.this.mHandler.removeCallbacksAndMessages(null);
                        b.this.iZ(true);
                        b.this.fyj.bqQ();
                        b.this.fyj.blL();
                        b.this.fyj.bqR();
                        if (b.this.fdK.yN() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(b.this.fdK.yN().mLiveInfo.live_id + "", b.this.fdK.yN().mLiveInfo.room_id + "", b.this.fdK.yN().XQ.userId + "", b.this.fdK.yN().XQ.userName, System.currentTimeMillis(), b.this.fdK.yN().mLiveInfo.feed_id, b.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(b.this.fdK.yN().mLiveInfo.live_id + "", b.this.fdK.yN().mLiveInfo.room_id + "", b.this.fdK.yN().XQ.userId + "", b.this.fdK.yN().XQ.userName, System.currentTimeMillis(), b.this.fdK.yN().mLiveInfo.feed_id, b.this.otherParams);
                            }
                        }
                        if (b.this.fyC != null) {
                            long j = b.this.fdK.yN().mLiveInfo.live_id;
                            if (b.this.fyC.liveId == j && b.this.fyC.startTime > 0) {
                                b.this.fyC.endTime = System.currentTimeMillis();
                                long j2 = b.this.fyC.endTime - b.this.fyC.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.fyC.roomId + "", b.this.fyC.vid, j2 / 1000, b.this.otherParams);
                            }
                            b.this.fyC = null;
                        }
                        b.this.bte();
                        if (b.this.fyN != null) {
                            b.this.fyN.release();
                        }
                        b.this.mSelectedPosition = i;
                        b.this.fyj = b.this.fyl.qf(b.this.mSelectedPosition);
                        b.this.fyj.bqU();
                        b.this.qS(i2);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.fyk.setCurrentItem(b.this.mSelectedPosition);
                        b.this.fdK.d(b.this.fdK.bpO());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.pr().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.fep = new c.a() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.z(b.this.fdK.yN());
                } else if (i2 == 2) {
                    b.this.g(b.this.fdK.bdW());
                } else if (i2 == 3) {
                    b.this.aB(i, str);
                } else if (i2 == 4) {
                    b.this.as(obj);
                } else if (i2 == 5) {
                    b.this.bsS();
                }
            }
        };
        this.fyR = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bqu() != null && b.this.mTbPageContext != null) {
                        b.this.fyB.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bqu());
                    }
                }
            }
        };
        this.fyS = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.4
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
        this.fyT = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.fdK != null && b.this.fdK.yN() != null && b.this.fdK.yN().mLiveInfo != null) {
                    long j = b.this.fdK.yN().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.fyN != null) {
                        b.this.fyN.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.ffQ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.fdK.yN().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.awH != null && !eventPollingHttpResponseMessage.awH.isEmpty() && b.this.fdK != null && b.this.fdK.yN() != null && b.this.fdK.yN().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.awH.size()) {
                                break;
                            }
                            af afVar = eventPollingHttpResponseMessage.awH.get(i2);
                            if (j == afVar.liveId && j2 - afVar.createTime <= 60 && !com.baidu.live.utils.m.g(afVar.liveId, afVar.id)) {
                                com.baidu.live.utils.m.a(afVar, b.this.fdK.yN().mLiveInfo);
                                com.baidu.live.utils.m.h(afVar.liveId, afVar.id);
                            }
                            i = i2 + 1;
                        }
                        af afVar2 = eventPollingHttpResponseMessage.awH.get(eventPollingHttpResponseMessage.awH.size() - 1);
                        if (j == afVar2.liveId) {
                            com.baidu.live.utils.m.f(afVar2.liveId, afVar2.id);
                        }
                    }
                    int i3 = eventPollingHttpResponseMessage.awG;
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.fdK != null && b.this.fdK.yN() != null) {
                                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                    com.baidu.live.utils.m.i(b.this.fdK.yN().mLiveInfo.user_id, b.this.fdK.yN().mLiveInfo.live_id);
                                }
                            }
                        }
                    }, i3 * 1000);
                }
            }
        };
        this.ffP = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h)) {
                        h hVar = (h) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (b.this.fdK != null && b.this.fdK.yN() != null) {
                            long j = b.this.fdK.yN().mLiveInfo.live_id;
                            if (j == hVar.liveId) {
                                getVideoGoodsListHttpResponseMessage.liveId = j;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                                if (!b.this.fyD) {
                                    b.this.fyD = true;
                                    String str = "goods_task_" + j;
                                    ap apVar = com.baidu.live.v.a.zj().axB;
                                    long j2 = (apVar == null || apVar.acW == null) ? 10L : apVar.acW.aeF;
                                    if (j2 <= 0) {
                                        j2 = 10;
                                    }
                                    LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.b.7.1
                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onComplete(boolean z) {
                                            if (b.this.fdK != null && b.this.fdK.yN() != null && b.this.fdK.yN().mLiveInfo.live_id != o.aDP) {
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, b.this.fdK.yN().mLiveInfo));
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
        this.fyU = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.fdK != null && b.this.fdK.yN() != null && b.this.fdK.yN().Ye != null) {
                        if (l.longValue() == b.this.fdK.yN().Ye.userId) {
                            b.this.fdK.yN().Ye.isNewUser = false;
                            if (b.this.fyE != null) {
                                b.this.fyE.s(b.this.fdK.yN());
                            }
                        }
                    }
                }
            }
        };
        this.fyV = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.q.a)) {
                    com.baidu.tieba.ala.liveroom.q.a aVar2 = (com.baidu.tieba.ala.liveroom.q.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String aXR = aVar2.aXR();
                    if (b.this.mTbPageContext != null && b.this.fdK != null && b.this.fdK.yN() != null && b.this.fdK.yN().Ye != null) {
                        if (valueOf.longValue() == b.this.fdK.yN().Ye.userId && com.baidu.live.v.a.zj().axB != null && com.baidu.live.v.a.zj().axB.acQ != null && com.baidu.live.v.a.zj().axB.acQ.qJ()) {
                            g.pY(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, aXR));
                        }
                    }
                }
            }
        };
        this.fyW = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.fyK != null) {
                    b.this.mHandler.removeCallbacks(b.this.fyK);
                }
                b.this.bsU();
            }
        };
        this.fef = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.fyi = aVar;
        this.fyp = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
        if (runTask != null) {
            this.fyN = (com.baidu.live.x.c) runTask.getData();
        }
        this.fdK = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.fdK.a(this.fep);
        this.fyv = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.fyR);
        MessageManager.getInstance().registerListener(this.fyS);
        MessageManager.getInstance().registerListener(this.fyT);
        MessageManager.getInstance().registerListener(this.ffQ);
        MessageManager.getInstance().registerListener(this.ffP);
        MessageManager.getInstance().registerListener(this.fyU);
        MessageManager.getInstance().registerListener(this.fyV);
        MessageManager.getInstance().registerListener(this.fyW);
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.fyt = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.fyt.add(alaBroadcastGiftToastData);
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
        this.awq = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.awq)) {
            this.awq = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.mUserName = intent.getStringExtra("user_name");
        this.fyx = intent.getStringExtra("room_id");
        this.awr = intent.getLongExtra("live_id", 0L);
        this.fyA = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.fdK.b((AlaLiveInfoCoreData) serializableExtra);
            this.fyA = true;
        }
        ah(intent);
        this.fyI = this.fyH == null || !this.fyH.adg;
        this.fyv.setOtherParams(this.otherParams);
        this.fys = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bsG();
        bsF();
    }

    private void ah(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.eOy = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.fyz = new JSONObject(stringExtra);
                if (this.fyz != null) {
                    String optString = this.fyz.optString("enterRoomId");
                    String optString2 = this.fyz.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.fyx, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.awr + "", optString2))) {
                        String optString3 = this.fyz.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.fyz.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.fyA) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.awr;
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString4, alaLiveInfoCoreData);
                            this.fdK.b(alaLiveInfoCoreData);
                            this.fyA = true;
                        }
                    }
                    String optString5 = this.fyz.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.fyH = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.eOy = jSONObject.optString("live_back_scheme");
                        this.fyH = new aq();
                        this.fyH.adg = jSONObject.optInt("is_hot") == 1;
                        if (this.fyH.adg) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.fyH.adh = jSONObject.optString("task_id");
                        this.fyH.adf = !TextUtils.isEmpty(this.fyH.adh);
                        this.fyH.adi = jSONObject.optInt("task_type");
                        this.fyH.adj = jSONObject.optInt("task_im_count");
                        this.fyH.adk = jSONObject.optLong("task_gift_total_price");
                        this.fyH.adl = jSONObject.optLong("task_watch_time");
                        this.fyH.adm = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                        String optString6 = jSONObject.optString("back_app_scheme");
                        String optString7 = jSONObject.optString("back_app_icon");
                        String optString8 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            this.fyn = new com.baidu.tieba.ala.liveroom.d.b();
                            this.fyn.setScheme(optString6);
                            this.fyn.setImageUrl(optString7);
                            this.fyn.setTitle(optString8);
                        }
                    }
                    this.fyu = this.fyz.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fyz.remove("cover");
                    this.fyz.remove("live_url");
                    this.fyz.remove("enterRoomId");
                    this.fyz.remove("enterLiveId");
                    this.fyz.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fyz.remove("extra");
                    this.otherParams = this.fyz.toString();
                    this.fdK.setOtherParams(this.otherParams);
                    this.fyz.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.fyz.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.fyz.optString("source");
                    }
                    this.fyJ = "mobilebaidu_subscription".equals(str);
                    int optInt = this.fyz.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.fdK.qx(optInt);
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

    public void bsF() {
        if (!TextUtils.isEmpty(this.mUserName)) {
            this.fdK.ac(this.mUserName, this.awq, this.mForumName);
        } else if (this.fdK.yN() != null && this.fdK.yN().mLiveInfo != null && this.fdK.yN().mLiveInfo.live_id > 0) {
            this.fdK.a(this.fdK.yN().mLiveInfo.live_id, false, this.awq, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uname=")) {
                this.mUserName = WebviewHelper.getMatchStringFromURL(lowerCase, "uname=");
            }
            if (lowerCase.contains("from=")) {
                this.awq = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.mUserName == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                jZ(false);
                return;
            }
            this.fdK.ac(this.mUserName, this.awq, this.mForumName);
        } else if (!TextUtils.isEmpty(this.fyx)) {
            this.fdK.zi(this.fyx);
        } else if (this.awr > 0) {
            this.fdK.a(this.awr, false, this.awq, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            jZ(false);
        }
    }

    private void bsG() {
        this.fyr = true;
        this.fyq = false;
        bsH();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        this.fyw = new com.baidu.tieba.ala.liveroom.c.c();
        this.fyw.a(this.fyP);
        this.fyw.setOtherParams(this.otherParams);
        this.fyw.iU(this.fyJ);
        bsJ();
        bsK();
        bsI();
    }

    private void bsH() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.fyk = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.fyk.setOnPageChangeListener(this.fyQ);
        this.fyk.setBoundaryCaching(true);
        this.fyk.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.fyl = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.fyl.bng();
        this.fyj = this.fyl.qe(this.mSelectedPosition);
        this.fyl.a(this.mSelectedPosition, this.fdK.yN());
        this.fyk.setAdapter(this.fyl);
        this.fyk.setCurrentItem(this.mSelectedPosition);
        this.fyk.setIsScrollable(this.fyI);
    }

    private void c(Rect rect) {
        this.fyo = SdkLivePlayer.eK(getPageContext().getPageActivity());
        if (this.fyo == null) {
            this.fyk.setIsScrollable(false);
            if (this.fdK != null) {
                this.fdK.cancelLoadData();
            }
            bnj();
            return;
        }
        if (this.fys) {
            this.fyk.setIsScrollable(false);
        }
        this.fyo.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.fyo.setIPlayerCallBack(this.fyO);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fyj.a(this.fyo, layoutParams, true);
    }

    private void bsI() {
        this.fym = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext);
    }

    private void bnj() {
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
        this.feb = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.feb.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fyj.a(this.feb, layoutParams);
    }

    private void bsJ() {
        if (this.fdK != null && this.fdK.yN() != null) {
            this.ald = this.fdK.yN();
            if (this.ald.mLiveInfo != null) {
                a(this.ald.mLiveInfo, this.fyA);
                if (this.ald.mLiveInfo != null && this.ald.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.isBackGround);
                    }
                    if (!this.isBackGround) {
                        this.fyo.g(this.ald.mLiveInfo);
                    } else {
                        this.fyo.setPlayLiveInfo(this.ald.mLiveInfo);
                    }
                    if (this.fyw != null) {
                        this.fyw.a(this.mTbPageContext, this.feb, this.fyo, this.fyj, this.fdK, this.awq, this.fys, this.fef, this.fyt, this.fyH);
                        j(this.ald.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private void bsK() {
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

    private void bsL() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.fys || !this.fyI) {
                this.fyk.setIsScrollable(false);
            } else {
                this.fyk.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && ((this.fyw == null || !this.fyw.onKeyDown(i, keyEvent)) && (this.fyw == null || !this.fyw.bjL()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bsL();
            } else if (this.fyw == null || this.fyw.bjM()) {
                jZ(true);
                bha();
            }
        }
        return true;
    }

    public void bha() {
        if (!TextUtils.isEmpty(this.eOy)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.eOy);
                this.eOy = null;
            }
        }
    }

    public void jZ(boolean z) {
        H(z, false);
    }

    public void H(boolean z, boolean z2) {
        iZ(!z);
        if (this.fyo != null) {
            this.fyo.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        bsN();
        long j = -1;
        if (this.fdK != null && this.fdK.bpO() != null) {
            j = this.fdK.bpO().room_id;
        }
        this.fyi.a(z, z2, j);
    }

    public void iZ(boolean z) {
        AlaLiveInfoData bpO;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        if (aa.sO() != null) {
            aa.sO().sN();
        }
        if (this.fyN != null) {
            this.fyN.release();
        }
        if (this.fyE != null) {
            this.fyE.release();
        }
        this.fyH = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.fdK != null && (bpO = this.fdK.bpO()) != null) {
            this.fdK.cY(bpO.live_id);
        }
        this.fyB.stopRecord();
        LiveTimerManager.getInstance().stop();
        bsM();
        if (this.fyo != null) {
            this.fyo.ka(z);
        }
        if (this.fyw != null) {
            this.fyw.iZ(z);
        }
        this.fyD = false;
        o.aDP = 0L;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
    }

    private void bsM() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bsN() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(m mVar) {
        if (mVar != null) {
            this.ald = mVar;
            if (this.fyw != null) {
                this.fyw.a(mVar);
            }
        }
    }

    private void d(com.baidu.live.data.h hVar) {
        if (this.fyw != null) {
            this.fyw.d(hVar);
        }
    }

    private void y(m mVar) {
        this.ald = mVar;
    }

    private void bsO() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.fyk.setIsScrollable(false);
            this.fyI = false;
        }
        if (this.ald != null) {
            a(this.ald.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.fyj.a(this.feb, null);
            a(this.fyj, this.ald.mLiveInfo, this.fyr);
            this.fyr = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.fdK != null && this.fdK.yN() != null && this.fdK.yN().mLiveInfo != null) {
                    j = this.fdK.yN().mLiveInfo.live_id;
                    str2 = this.fdK.yN().mLiveInfo.room_id + "";
                    str = this.fdK.yN().mLiveInfo.feed_id;
                } else {
                    if (this.awr > 0) {
                        j2 = this.awr;
                    }
                    if (!TextUtils.isEmpty(this.fyx)) {
                        j = j2;
                        str = "";
                        str2 = this.fyx;
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
                if (this.fdK != null && this.fdK.yN() != null && this.fdK.yN().mLiveInfo != null) {
                    str3 = this.fdK.yN().mLiveInfo.feed_id;
                    str4 = this.fdK.yN().mLiveInfo.live_id + "";
                    str5 = this.fdK.yN().mLiveInfo.room_id + "";
                    str6 = this.fdK.yN().mLiveInfo.user_name;
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
        if (this.fyo != null && this.fyo.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.fyo.getVideoPath();
                String b = d.b(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.fyo.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + b);
                }
                if (!d.ai(videoPath, b)) {
                    if (!TbadkCoreApplication.getInst().isTieba() || !z || !d.ah(videoPath, b)) {
                        if (!z && !alaLiveRoomBlurPageLayout.bC(this.fyo)) {
                            ((ViewGroup) this.fyo.getParent()).removeView(this.fyo);
                            alaLiveRoomBlurPageLayout.a(this.fyo, null, false);
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                        }
                        if (!this.isBackGround) {
                            this.fyo.g(alaLiveInfoData);
                            return;
                        } else {
                            this.fyo.setPlayLiveInfo(alaLiveInfoData);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.fyo.btk();
        } else if (this.fyo != null && this.fyo.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.fyo, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.isBackGround) {
                    this.fyo.g(alaLiveInfoData);
                } else {
                    this.fyo.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.fyo != null) {
            this.fyo.setLayoutParams(b);
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

    public void bsP() {
        this.fyr = true;
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
                this.fyj.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.fyj.setBackgroundColor(0);
            }
        } else {
            this.fyj.setBackgroundColor(0);
        }
        int i2 = this.fyo.getLayoutParams().width;
        int i3 = this.fyo.getLayoutParams().height;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.feb != null) {
            this.feb.setLayoutParams(c);
        }
        if (this.fyj != null) {
            this.fyj.bg(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fyv != null) {
            this.fyv.bg(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fyw != null) {
            this.fyw.j(c.width, c.height, realScreenOrientation);
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
            this.fyj.setBgImageUrl(this.ald.mLiveInfo.cover, this.ald.mLiveInfo);
            this.fyl.a(this.mSelectedPosition, bsQ(), this.ald);
            this.fyl.b(this.mSelectedPosition, bsR(), this.ald);
            this.fyj.requestLayout();
            this.fyj.A(i, this.ald.mLiveInfo.screen_direction == 2);
        }
        if (this.ald != null) {
            a(this.ald.mLiveInfo, false);
        }
        boolean bqW = this.fyj.bqW();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.ald == null || this.ald.mLiveInfo == null || this.ald.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!btc()) {
            if (this.fyo != null && this.fyo.getParent() == null) {
                this.fyj.a(this.fyo, null, false);
                if (this.ald != null && this.ald.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.isBackGround) {
                        this.fyo.g(this.ald.mLiveInfo);
                    } else {
                        this.fyo.setPlayLiveInfo(this.ald.mLiveInfo);
                    }
                }
            }
            if (bqW && !btc() && this.fyw != null) {
                this.fyj.jO(z);
                return;
            }
            return;
        }
        this.fyj.bqQ();
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
            this.fdK.a(alaLiveInfoData.live_id, true, this.awq, this.mForumName);
            this.fdK.cX(alaLiveInfoData.live_id);
        }
    }

    public void qS(int i) {
        if (i < 0) {
            this.fdK.qy(this.fdK.bpL() - 1);
        } else if (i > 0) {
            this.fdK.qy(this.fdK.bpL() + 1);
        }
        if (this.fyw != null) {
            this.fyw.a(this.fyj);
        }
        this.fyl.a(this.mSelectedPosition, bsQ(), this.ald);
        this.fyl.b(this.mSelectedPosition, bsR(), this.ald);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.fdK != null) {
            int bpL = this.fdK.bpL();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bpL + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.fdK.bpD() != null && this.fdK.bpD().size() > bpL && this.fdK.bpD().get(bpL) != null) {
                AlaLiveInfoData alaLiveInfoData = this.fdK.bpD().get(bpL);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fdK != null) {
            AlaLiveInfoData bpO = this.fdK.bpO();
            if (bpO != null) {
                bpO.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.fyj, bpO, this.fyr);
                this.fyr = false;
                if (this.fyw != null) {
                    this.fyw.a(this.mTbPageContext, this.feb, this.fyo, this.fyj, this.fdK, this.awq, this.fys, this.fef, null, this.fyH);
                    short s = 2;
                    if (bpO.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bpO, false);
            }
            f(bpO);
            this.fyj.a(this.feb, null);
            if (this.fyw != null) {
                this.fyw.bjJ();
            }
            this.fdK.d(bpO);
        }
    }

    private AlaLiveInfoData bsQ() {
        List<AlaLiveInfoData> bpD = this.fdK.bpD();
        if (bpD == null || bpD.size() == 0) {
            if (this.ald == null) {
                return null;
            }
            return this.ald.mLiveInfo;
        }
        int bpL = this.fdK.bpL();
        int size = bpD.size();
        return bpD.get(((bpL + size) - 1) % size);
    }

    private AlaLiveInfoData bsR() {
        List<AlaLiveInfoData> bpD = this.fdK.bpD();
        if (bpD == null || bpD.size() == 0) {
            if (this.ald == null) {
                return null;
            }
            return this.ald.mLiveInfo;
        }
        return bpD.get((this.fdK.bpL() + 1) % bpD.size());
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
        m yN = this.fdK.yN();
        y(yN);
        this.fdK.bpE();
        if (this.fyr) {
            this.fdK.jI(false);
        }
        this.fef = System.currentTimeMillis() / 1000;
        if (this.fyw != null) {
            this.fyw.a(this.mTbPageContext, this.feb, this.fyo, this.fyj, this.fdK, this.awq, this.fys, this.fef, this.fyt, this.fyH);
            short s = 2;
            if (yN.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bsO();
        if (yN != null && yN.mLiveInfo != null && yN.mLiveInfo.live_status == 2) {
            this.fyl.a(this.mSelectedPosition, this.fdK.yN());
            d(yN, false);
            this.fyr = false;
            return;
        }
        boolean z = (this.fyw == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.fyF || !TextUtils.equals(q.Bf(), this.fyG))) {
            t.b(getPageContext());
            com.baidu.live.v.c.zo().zp();
            this.fyF = true;
            this.fyG = q.Bf();
        }
        this.fyD = false;
        if (this.fdK.yN() != null && this.fdK.yN().mLiveInfo != null) {
            String str2 = this.fdK.yN().mLiveInfo.feed_id;
            long j = this.fdK.yN().mLiveInfo.live_id;
            long j2 = this.fdK.yN().mLiveInfo.user_id;
            this.fdK.cX(j);
            if (z) {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                    com.baidu.live.utils.m.i(j2, j);
                }
                o.g(str2, j);
            }
        }
        if (this.fyw != null) {
            this.fyw.iY(TextUtils.equals(this.fyu, "1"));
            this.fyu = "";
        }
        if (this.fym != null) {
            this.fym.a(this.ald, this.fyn);
        }
        a(this.fdK.yN());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.fdK.yN() != null && b.this.fdK.yN().mLiveInfo != null) {
                    b.this.fdK.a(b.this.fdK.yN().mLiveInfo.live_id, b.this.awq, b.this.fef);
                }
            }
        }, this.fdK.yN().XU);
        if (z && this.fdK.yN() != null && this.fdK.yN().XQ != null) {
            ap apVar = com.baidu.live.v.a.zj().axB;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && apVar != null && apVar.acV != null && apVar.acV.aez) {
                c(true, this.fdK.yN().XQ.userId);
            }
        }
        this.fyr = false;
        if (z && this.fdK.yN() != null && this.fdK.yN().mLiveInfo != null && this.fdK.yN().XQ != null && this.fyw != null) {
            long j3 = this.fdK.yN().mLiveInfo.live_id;
            long j4 = this.fdK.yN().mLiveInfo.room_id;
            String str3 = this.fdK.yN().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j3;
                if (aa.sO() != null) {
                    aa.sO().a(this.mTbPageContext.getPageActivity(), j3, str4, j4, str3, this.otherParams);
                }
                if (this.fyN != null) {
                    this.fyN.b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
                }
            }
            if (e.vG() != null) {
                e.vG().b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            }
            if (this.fyE == null) {
                this.fyE = new com.baidu.tieba.ala.liveroom.i.a();
            }
            this.fyE.a(this.mTbPageContext.getPageActivity(), this.fdK.yN(), this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsS() {
        if (this.fyp) {
            this.fyl.a(this.mSelectedPosition, bsQ(), this.ald);
            this.fyl.b(this.mSelectedPosition, bsR(), this.ald);
            this.fyp = false;
        }
        if (this.fyv != null && btc()) {
            this.fyv.U(this.fdK.bpF());
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
            this.mHandler.removeCallbacks(this.fyM);
            this.mHandler.postDelayed(this.fyM, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.live.data.h hVar) {
        if (hVar == null) {
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fyL);
                this.mHandler.postDelayed(this.fyL, 5000L);
                return;
            }
            return;
        }
        if (!this.fyq) {
            d(hVar);
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.fyL);
            this.mHandler.postDelayed(this.fyL, hVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsT() {
        if (this.fdK.yN() != null && this.fdK.yN().mLiveInfo != null) {
            this.fdK.cX(this.fdK.yN().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.live_status == 2) {
            this.fyl.a(this.mSelectedPosition, this.fdK.yN());
            d(mVar, false);
        } else if (mVar != null) {
            if (!this.fyq) {
                a(mVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fyK);
                this.mHandler.postDelayed(this.fyK, mVar.XU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsU() {
        if (this.mTbPageContext != null && this.fdK.yN() != null && this.fdK.yN().mLiveInfo != null) {
            this.fdK.a(this.fdK.yN().mLiveInfo.live_id, this.awq, this.fef);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar, boolean z) {
        View view = null;
        iZ(true);
        if (!btc()) {
            this.fdK.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            this.fyj.blL();
            this.fyj.bqQ();
            this.fyj.bqX();
            if (mVar != null && mVar.mLiveInfo != null) {
                this.fyy = mVar.mLiveInfo.live_id;
            }
            bsL();
            bsV();
            bsW();
            if (mVar != null) {
                if (this.fyw != null && this.fyw.bjP() != null) {
                    view = this.fyw.bjP().a(this.fyw.bjG().pageContext.getPageActivity(), mVar, z);
                }
                this.fyv.a(this.fyj, view, mVar, z, this.fdK.bpF());
                if (this.fyw != null) {
                    this.fyw.iZ(false);
                    this.fyw.bjK();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                this.fyj.bqU();
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
                this.fyC = new StayTimeBean();
                this.fyC.liveId = mVar.mLiveInfo.live_id;
                this.fyC.roomId = mVar.mLiveInfo.room_id;
                this.fyC.vid = mVar.mLiveInfo.feed_id;
                this.fyC.startTime = System.currentTimeMillis();
            }
            bte();
            if (this.fym != null) {
                this.fym.a(this.ald, this.fyn);
            }
        }
    }

    private void bsV() {
    }

    private void bsW() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.fyk);
        }
    }

    public void bsX() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bsY();
        } else {
            bsZ();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.fdK != null && this.fdK.yN() != null) {
            alaLiveInfoData = this.fdK.yN().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bsY();
        } else {
            bsZ();
        }
        this.fyk.setIsScrollable(!z && this.fyI);
        if (this.fyw != null) {
            this.fyw.onKeyboardVisibilityChanged(z);
        }
        if (this.feb != null) {
            this.feb.onKeyboardVisibilityChanged(z);
        }
    }

    public void bW(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bsY();
        } else {
            bsZ();
        }
        this.feb.bW(realScreenOrientation);
        ql(realScreenOrientation);
        if (aa.sO() != null) {
            aa.sO().sm();
        }
        if (this.fyE != null) {
            this.fyE.sm();
        }
        if (this.fym != null) {
            this.fym.bW(realScreenOrientation);
        }
    }

    public void bsY() {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.fyk != null) {
            com.baidu.live.utils.h.S(this.fyk);
        }
    }

    public void bsZ() {
        if (this.fyk != null) {
            com.baidu.live.utils.h.T(this.fyk);
        }
    }

    public void onResume() {
        if (this.fdK != null) {
            this.fdK.bpp();
            this.fdK.bps();
        }
        if (this.fyw != null) {
            this.fyw.enterForeground();
        }
        if (this.fyE != null) {
            this.fyE.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.t.a.eI(this.mTbPageContext.getPageActivity()) && this.isBackGround) {
            this.isBackGround = false;
            bta();
        }
    }

    public void bta() {
        bsU();
        bsT();
        this.fdK.bpE();
        this.fyo.btl();
        if (this.fyw != null) {
            this.fyw.bjO();
        }
        if (this.fdK != null && this.fdK.yN() != null && this.fdK.yN().mLiveInfo != null) {
            this.fyB.da(this.fdK.yN().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.ald.mLiveInfo.live_id);
        }
    }

    public void onPause() {
        if (this.fdK != null) {
            this.fdK.bpq();
            this.fdK.bpt();
        }
        if (this.fyw != null) {
            this.fyw.enterBackground();
        }
    }

    public void onStop() {
        this.isBackGround = true;
        btb();
    }

    public void btb() {
        this.mHandler.removeCallbacks(this.fyK);
        this.mHandler.removeCallbacks(this.fyL);
        this.mHandler.removeCallbacks(this.fyM);
        this.fyo.pausePlay();
        if (this.fyw != null) {
            this.fyw.bjN();
        }
        this.fyB.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (aa.sO() != null) {
                aa.sO().a(i, i2, intent, this.ald, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.fyw != null) {
            this.fyw.onActivityResult(i, i2, intent);
        }
    }

    public boolean btc() {
        return this.fyv != null && this.fyv.beC();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fyR != null) {
            MessageManager.getInstance().unRegisterListener(this.fyR);
        }
        if (this.fyS != null) {
            MessageManager.getInstance().unRegisterListener(this.fyS);
        }
        MessageManager.getInstance().unRegisterListener(this.fyT);
        MessageManager.getInstance().unRegisterListener(this.ffQ);
        MessageManager.getInstance().unRegisterListener(this.ffP);
        MessageManager.getInstance().unRegisterListener(this.fyU);
        MessageManager.getInstance().unRegisterListener(this.fyV);
        MessageManager.getInstance().unRegisterListener(this.fyW);
        if (this.fyN != null) {
            this.fyN.release();
        }
        if (this.fyo != null) {
            this.fyo.ka(true);
        }
        if (this.fym != null) {
            this.fym.onDestory();
        }
        this.fyn = null;
        if (this.fyw != null) {
            this.fyw.onDestroy();
        }
        if (this.fyl != null) {
            this.fyl.onDestroy();
        }
        this.fyj.blL();
        if (this.fyj != null) {
            this.fyj.release();
            this.fyj = null;
        }
        if (this.fyv != null) {
            this.fyv.onDestroy();
            this.fyv = null;
        }
        if (this.fyC != null && this.fdK != null && this.fdK.yN() != null) {
            long j = this.fdK.yN().mLiveInfo.live_id;
            if (this.fyC.liveId == j && this.fyC.startTime > 0) {
                this.fyC.endTime = System.currentTimeMillis();
                long j2 = this.fyC.endTime - this.fyC.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.fyC.roomId + "", this.fyC.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.fyC = null;
        }
        if (this.feb != null) {
            this.feb.bqZ();
            this.feb = null;
        }
        if (this.fdK != null) {
            this.fdK.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        com.baidu.live.utils.m.Ba();
        r.sx().release();
    }

    public String xx() {
        return this.otherParams;
    }

    public void btd() {
        if (this.fyz != null) {
            this.otherParams = this.fyz.toString();
            if (this.fdK != null) {
                this.fdK.setOtherParams(this.otherParams);
            }
            if (this.fyw != null) {
                this.fyw.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            this.fyv.setOtherParams(this.otherParams);
        }
    }

    public void bte() {
        if (this.fyz != null) {
            String optString = this.fyz.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.fyz.put("tab", "live_jump");
                        this.fyz.put("tag", "");
                        this.fyz.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.fyz.put("tab", "liveroom");
                        this.fyz.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                btd();
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

    public void btf() {
        if (!bth()) {
            if (this.mNetChangedDialog == null) {
                this.mNetChangedDialog = new BdAlertDialog(getPageContext().getPageActivity());
                this.mNetChangedDialog.setCanceledOnTouchOutside(false);
                this.mNetChangedDialog.setMessage(getPageContext().getResources().getString(a.i.ala_create_not_wifi));
                this.mNetChangedDialog.setPositiveButton(getPageContext().getResources().getString(a.i.sdk_liveroom_attention_guide_btn_text), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.11
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        b.this.bti();
                        b.this.mNetChangedDialog.dismiss();
                    }
                });
                this.mNetChangedDialog = this.mNetChangedDialog.create(this.mTbPageContext);
                this.mNetChangedDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.player.b.13
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getRepeatCount() == 0) {
                            b.this.bti();
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

    public void btg() {
        if (this.mNetChangedDialog != null) {
            this.mNetChangedDialog.dismiss();
        }
    }

    public boolean bth() {
        return this.mNetChangedDialog != null && this.mNetChangedDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bti() {
        onStart();
        btj();
    }

    public void btj() {
        t.sJ();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fyw.d(s);
        } else {
            this.fyw.e(s);
        }
    }
}
