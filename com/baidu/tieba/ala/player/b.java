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
    private m ale;
    private String aws;
    private long awt;
    private String eOM;
    private com.baidu.tieba.ala.liveroom.m.c fdY;
    private c.a feD;
    private AlaLiveView fep;
    private long fet;
    private HttpMessageListener fgd;
    private HttpMessageListener fge;
    private com.baidu.tieba.ala.liveroom.d.a fyA;
    private com.baidu.tieba.ala.liveroom.d.b fyB;
    private SdkLivePlayer fyC;
    private boolean fyD;
    private boolean fyE;
    private boolean fyF;
    private boolean fyG;
    private ArrayList<AlaBroadcastGiftToastData> fyH;
    private String fyI;
    private com.baidu.tieba.ala.endliveroom.a fyJ;
    private com.baidu.tieba.ala.liveroom.c.c fyK;
    private String fyL;
    private long fyM;
    private JSONObject fyN;
    private boolean fyO;
    private com.baidu.tieba.ala.liveroom.task.c fyP;
    private StayTimeBean fyQ;
    private boolean fyR;
    private com.baidu.tieba.ala.liveroom.i.a fyS;
    private boolean fyT;
    private String fyU;
    private aq fyV;
    private boolean fyW;
    private boolean fyX;
    private Runnable fyY;
    private Runnable fyZ;
    private a fyw;
    private AlaLiveRoomBlurPageLayout fyx;
    private AlaLoopViewPager fyy;
    private AlaLoopViewPagerAdapter fyz;
    private Runnable fza;
    private com.baidu.live.x.c fzb;
    private com.baidu.live.o.a fzc;
    com.baidu.live.liveroom.a.b fzd;
    ViewPager.OnPageChangeListener fze;
    HttpMessageListener fzf;
    CustomMessageListener fzg;
    CustomMessageListener fzh;
    CustomMessageListener fzi;
    CustomMessageListener fzj;
    private CustomMessageListener fzk;
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
        this.fyD = true;
        this.fet = 0L;
        this.fyE = false;
        this.fyF = true;
        this.aws = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.fyG = false;
        this.fyI = "0";
        this.mHandler = new Handler();
        this.fyM = -1L;
        this.otherParams = "";
        this.fyO = false;
        this.fyP = com.baidu.tieba.ala.liveroom.task.c.bqz();
        this.fyR = false;
        this.fyT = false;
        this.fyX = false;
        this.fyY = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bsX();
            }
        };
        this.fyZ = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.bsW();
            }
        };
        this.fza = new Runnable() { // from class: com.baidu.tieba.ala.player.b.14
            @Override // java.lang.Runnable
            public void run() {
                b.this.fdY.bpH();
            }
        };
        this.fzc = new com.baidu.live.o.a() { // from class: com.baidu.tieba.ala.player.b.15
            @Override // com.baidu.live.o.a
            public void bk(int i) {
                if (b.this.fyx != null) {
                    if (ListUtils.getCount(b.this.fyC.getAlaLiveInfoDataList()) < 2) {
                        b.this.fyx.bqV();
                    } else {
                        b.this.fyx.bqW();
                    }
                }
                if (b.this.fyK != null) {
                    b.this.fyK.bk(i);
                }
                if (BdNetTypeUtil.isMobileNet()) {
                    if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && k.Ba()) {
                        b.this.onStop();
                        b.this.bti();
                        return;
                    }
                    b.this.btm();
                }
            }
        };
        this.fzd = new com.baidu.live.liveroom.a.b() { // from class: com.baidu.tieba.ala.player.b.18
            @Override // com.baidu.live.liveroom.a.b
            public void bb(boolean z) {
                if (z || b.this.fyK == null || b.this.fyK.bjP()) {
                    b.this.jZ(true);
                    b.this.bhd();
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bc(boolean z) {
                b.this.d(b.this.ale, z);
            }

            @Override // com.baidu.live.liveroom.a.b
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.fyC.btn();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.isBackGround) {
                    if (b.this.isBackGround) {
                        b.this.fyC.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.fyC.aa(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void f(boolean z, boolean z2) {
                if (b.this.fyy != null) {
                    b.this.fyy.setIsScrollable(b.this.fyW && z);
                    b.this.fyy.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bd(boolean z) {
                boolean z2 = true;
                if (!z || b.this.btf()) {
                    if (b.this.fyx != null) {
                        b.this.fyx.bqY();
                        return;
                    }
                    return;
                }
                if (b.this.fdY.yO().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.fyx != null) {
                    b.this.fyx.jO(z2);
                }
            }
        };
        this.fze = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.fep != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.fyy.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.fyF || ListUtils.getCount(b.this.fdY.bpG()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && b.this.fdY.bpJ() == 1) {
                            if (!b.this.fdY.bpM() || i2 >= 0) {
                                if (b.this.fdY.bpN() && i2 > 0) {
                                    b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    b.this.fyy.setCurrentItem(b.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                b.this.fyy.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        b.this.fdY.cancelLoadData();
                        b.this.mHandler.removeCallbacksAndMessages(null);
                        b.this.iZ(true);
                        b.this.fyx.bqT();
                        b.this.fyx.blO();
                        b.this.fyx.bqU();
                        if (b.this.fdY.yO() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(b.this.fdY.yO().mLiveInfo.live_id + "", b.this.fdY.yO().mLiveInfo.room_id + "", b.this.fdY.yO().XQ.userId + "", b.this.fdY.yO().XQ.userName, System.currentTimeMillis(), b.this.fdY.yO().mLiveInfo.feed_id, b.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(b.this.fdY.yO().mLiveInfo.live_id + "", b.this.fdY.yO().mLiveInfo.room_id + "", b.this.fdY.yO().XQ.userId + "", b.this.fdY.yO().XQ.userName, System.currentTimeMillis(), b.this.fdY.yO().mLiveInfo.feed_id, b.this.otherParams);
                            }
                        }
                        if (b.this.fyQ != null) {
                            long j = b.this.fdY.yO().mLiveInfo.live_id;
                            if (b.this.fyQ.liveId == j && b.this.fyQ.startTime > 0) {
                                b.this.fyQ.endTime = System.currentTimeMillis();
                                long j2 = b.this.fyQ.endTime - b.this.fyQ.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.fyQ.roomId + "", b.this.fyQ.vid, j2 / 1000, b.this.otherParams);
                            }
                            b.this.fyQ = null;
                        }
                        b.this.bth();
                        if (b.this.fzb != null) {
                            b.this.fzb.release();
                        }
                        b.this.mSelectedPosition = i;
                        b.this.fyx = b.this.fyz.qf(b.this.mSelectedPosition);
                        b.this.fyx.bqX();
                        b.this.qS(i2);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.fyy.setCurrentItem(b.this.mSelectedPosition);
                        b.this.fdY.d(b.this.fdY.bpR());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.pr().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.feD = new c.a() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.z(b.this.fdY.yO());
                } else if (i2 == 2) {
                    b.this.g(b.this.fdY.bdZ());
                } else if (i2 == 3) {
                    b.this.aB(i, str);
                } else if (i2 == 4) {
                    b.this.as(obj);
                } else if (i2 == 5) {
                    b.this.bsV();
                }
            }
        };
        this.fzf = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bqx() != null && b.this.mTbPageContext != null) {
                        b.this.fyP.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bqx());
                    }
                }
            }
        };
        this.fzg = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.4
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
        this.fzh = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.fdY != null && b.this.fdY.yO() != null && b.this.fdY.yO().mLiveInfo != null) {
                    long j = b.this.fdY.yO().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.fzb != null) {
                        b.this.fzb.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.fge = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.fdY.yO().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.awJ != null && !eventPollingHttpResponseMessage.awJ.isEmpty() && b.this.fdY != null && b.this.fdY.yO() != null && b.this.fdY.yO().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.awJ.size()) {
                                break;
                            }
                            af afVar = eventPollingHttpResponseMessage.awJ.get(i2);
                            if (j == afVar.liveId && j2 - afVar.createTime <= 60 && !com.baidu.live.utils.m.g(afVar.liveId, afVar.id)) {
                                com.baidu.live.utils.m.a(afVar, b.this.fdY.yO().mLiveInfo);
                                com.baidu.live.utils.m.h(afVar.liveId, afVar.id);
                            }
                            i = i2 + 1;
                        }
                        af afVar2 = eventPollingHttpResponseMessage.awJ.get(eventPollingHttpResponseMessage.awJ.size() - 1);
                        if (j == afVar2.liveId) {
                            com.baidu.live.utils.m.f(afVar2.liveId, afVar2.id);
                        }
                    }
                    int i3 = eventPollingHttpResponseMessage.awI;
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.fdY != null && b.this.fdY.yO() != null) {
                                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                    com.baidu.live.utils.m.i(b.this.fdY.yO().mLiveInfo.user_id, b.this.fdY.yO().mLiveInfo.live_id);
                                }
                            }
                        }
                    }, i3 * 1000);
                }
            }
        };
        this.fgd = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h)) {
                        h hVar = (h) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (b.this.fdY != null && b.this.fdY.yO() != null) {
                            long j = b.this.fdY.yO().mLiveInfo.live_id;
                            if (j == hVar.liveId) {
                                getVideoGoodsListHttpResponseMessage.liveId = j;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                                if (!b.this.fyR) {
                                    b.this.fyR = true;
                                    String str = "goods_task_" + j;
                                    ap apVar = com.baidu.live.v.a.zl().axD;
                                    long j2 = (apVar == null || apVar.acW == null) ? 10L : apVar.acW.aeF;
                                    if (j2 <= 0) {
                                        j2 = 10;
                                    }
                                    LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.b.7.1
                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onComplete(boolean z) {
                                            if (b.this.fdY != null && b.this.fdY.yO() != null && b.this.fdY.yO().mLiveInfo.live_id != o.aDR) {
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, b.this.fdY.yO().mLiveInfo));
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
        this.fzi = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.fdY != null && b.this.fdY.yO() != null && b.this.fdY.yO().Ye != null) {
                        if (l.longValue() == b.this.fdY.yO().Ye.userId) {
                            b.this.fdY.yO().Ye.isNewUser = false;
                            if (b.this.fyS != null) {
                                b.this.fyS.s(b.this.fdY.yO());
                            }
                        }
                    }
                }
            }
        };
        this.fzj = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.q.a)) {
                    com.baidu.tieba.ala.liveroom.q.a aVar2 = (com.baidu.tieba.ala.liveroom.q.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String aXU = aVar2.aXU();
                    if (b.this.mTbPageContext != null && b.this.fdY != null && b.this.fdY.yO() != null && b.this.fdY.yO().Ye != null) {
                        if (valueOf.longValue() == b.this.fdY.yO().Ye.userId && com.baidu.live.v.a.zl().axD != null && com.baidu.live.v.a.zl().axD.acQ != null && com.baidu.live.v.a.zl().axD.acQ.qJ()) {
                            g.pY(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, aXU));
                        }
                    }
                }
            }
        };
        this.fzk = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.fyY != null) {
                    b.this.mHandler.removeCallbacks(b.this.fyY);
                }
                b.this.bsX();
            }
        };
        this.fet = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.fyw = aVar;
        this.fyD = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
        if (runTask != null) {
            this.fzb = (com.baidu.live.x.c) runTask.getData();
        }
        this.fdY = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.fdY.a(this.feD);
        this.fyJ = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.fzf);
        MessageManager.getInstance().registerListener(this.fzg);
        MessageManager.getInstance().registerListener(this.fzh);
        MessageManager.getInstance().registerListener(this.fge);
        MessageManager.getInstance().registerListener(this.fgd);
        MessageManager.getInstance().registerListener(this.fzi);
        MessageManager.getInstance().registerListener(this.fzj);
        MessageManager.getInstance().registerListener(this.fzk);
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.fyH = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.fyH.add(alaBroadcastGiftToastData);
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
        this.aws = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.aws)) {
            this.aws = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.mUserName = intent.getStringExtra("user_name");
        this.fyL = intent.getStringExtra("room_id");
        this.awt = intent.getLongExtra("live_id", 0L);
        this.fyO = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.fdY.b((AlaLiveInfoCoreData) serializableExtra);
            this.fyO = true;
        }
        ah(intent);
        this.fyW = this.fyV == null || !this.fyV.adg;
        this.fyJ.setOtherParams(this.otherParams);
        this.fyG = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bsJ();
        bsI();
    }

    private void ah(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.eOM = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.fyN = new JSONObject(stringExtra);
                if (this.fyN != null) {
                    String optString = this.fyN.optString("enterRoomId");
                    String optString2 = this.fyN.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.fyL, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.awt + "", optString2))) {
                        String optString3 = this.fyN.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.fyN.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.fyO) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.awt;
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString4, alaLiveInfoCoreData);
                            this.fdY.b(alaLiveInfoCoreData);
                            this.fyO = true;
                        }
                    }
                    String optString5 = this.fyN.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.fyV = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.eOM = jSONObject.optString("live_back_scheme");
                        this.fyV = new aq();
                        this.fyV.adg = jSONObject.optInt("is_hot") == 1;
                        if (this.fyV.adg) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.fyV.adh = jSONObject.optString("task_id");
                        this.fyV.adf = !TextUtils.isEmpty(this.fyV.adh);
                        this.fyV.adi = jSONObject.optInt("task_type");
                        this.fyV.adj = jSONObject.optInt("task_im_count");
                        this.fyV.adk = jSONObject.optLong("task_gift_total_price");
                        this.fyV.adl = jSONObject.optLong("task_watch_time");
                        this.fyV.adm = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                        String optString6 = jSONObject.optString("back_app_scheme");
                        String optString7 = jSONObject.optString("back_app_icon");
                        String optString8 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            this.fyB = new com.baidu.tieba.ala.liveroom.d.b();
                            this.fyB.setScheme(optString6);
                            this.fyB.setImageUrl(optString7);
                            this.fyB.setTitle(optString8);
                        }
                    }
                    this.fyI = this.fyN.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fyN.remove("cover");
                    this.fyN.remove("live_url");
                    this.fyN.remove("enterRoomId");
                    this.fyN.remove("enterLiveId");
                    this.fyN.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fyN.remove("extra");
                    this.otherParams = this.fyN.toString();
                    this.fdY.setOtherParams(this.otherParams);
                    this.fyN.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.fyN.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.fyN.optString("source");
                    }
                    this.fyX = "mobilebaidu_subscription".equals(str);
                    int optInt = this.fyN.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.fdY.qx(optInt);
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

    public void bsI() {
        if (!TextUtils.isEmpty(this.mUserName)) {
            this.fdY.ac(this.mUserName, this.aws, this.mForumName);
        } else if (this.fdY.yO() != null && this.fdY.yO().mLiveInfo != null && this.fdY.yO().mLiveInfo.live_id > 0) {
            this.fdY.a(this.fdY.yO().mLiveInfo.live_id, false, this.aws, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uname=")) {
                this.mUserName = WebviewHelper.getMatchStringFromURL(lowerCase, "uname=");
            }
            if (lowerCase.contains("from=")) {
                this.aws = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.mUserName == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                jZ(false);
                return;
            }
            this.fdY.ac(this.mUserName, this.aws, this.mForumName);
        } else if (!TextUtils.isEmpty(this.fyL)) {
            this.fdY.zj(this.fyL);
        } else if (this.awt > 0) {
            this.fdY.a(this.awt, false, this.aws, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            jZ(false);
        }
    }

    private void bsJ() {
        this.fyF = true;
        this.fyE = false;
        bsK();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        this.fyK = new com.baidu.tieba.ala.liveroom.c.c();
        this.fyK.a(this.fzd);
        this.fyK.setOtherParams(this.otherParams);
        this.fyK.iU(this.fyX);
        bsM();
        bsN();
        bsL();
    }

    private void bsK() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.fyy = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.fyy.setOnPageChangeListener(this.fze);
        this.fyy.setBoundaryCaching(true);
        this.fyy.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.fyz = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.fyz.bnj();
        this.fyx = this.fyz.qe(this.mSelectedPosition);
        this.fyz.a(this.mSelectedPosition, this.fdY.yO());
        this.fyy.setAdapter(this.fyz);
        this.fyy.setCurrentItem(this.mSelectedPosition);
        this.fyy.setIsScrollable(this.fyW);
    }

    private void c(Rect rect) {
        this.fyC = SdkLivePlayer.eK(getPageContext().getPageActivity());
        if (this.fyC == null) {
            this.fyy.setIsScrollable(false);
            if (this.fdY != null) {
                this.fdY.cancelLoadData();
            }
            bnm();
            return;
        }
        if (this.fyG) {
            this.fyy.setIsScrollable(false);
        }
        this.fyC.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.fyC.setIPlayerCallBack(this.fzc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fyx.a(this.fyC, layoutParams, true);
    }

    private void bsL() {
        this.fyA = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext);
    }

    private void bnm() {
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
        this.fep = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.fep.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fyx.a(this.fep, layoutParams);
    }

    private void bsM() {
        if (this.fdY != null && this.fdY.yO() != null) {
            this.ale = this.fdY.yO();
            if (this.ale.mLiveInfo != null) {
                a(this.ale.mLiveInfo, this.fyO);
                if (this.ale.mLiveInfo != null && this.ale.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.isBackGround);
                    }
                    if (!this.isBackGround) {
                        this.fyC.g(this.ale.mLiveInfo);
                    } else {
                        this.fyC.setPlayLiveInfo(this.ale.mLiveInfo);
                    }
                    if (this.fyK != null) {
                        this.fyK.a(this.mTbPageContext, this.fep, this.fyC, this.fyx, this.fdY, this.aws, this.fyG, this.fet, this.fyH, this.fyV);
                        j(this.ale.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private void bsN() {
        this.mTbPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.player.b.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (b.this.ale != null && b.this.ale.XQ != null && b.this.ale.XQ.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + b.this.ale.mLiveInfo.live_id);
                        b.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", b.this.ale.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                }
            }
        });
    }

    private void bsO() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.fyG || !this.fyW) {
                this.fyy.setIsScrollable(false);
            } else {
                this.fyy.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && ((this.fyK == null || !this.fyK.onKeyDown(i, keyEvent)) && (this.fyK == null || !this.fyK.bjO()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bsO();
            } else if (this.fyK == null || this.fyK.bjP()) {
                jZ(true);
                bhd();
            }
        }
        return true;
    }

    public void bhd() {
        if (!TextUtils.isEmpty(this.eOM)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.eOM);
                this.eOM = null;
            }
        }
    }

    public void jZ(boolean z) {
        H(z, false);
    }

    public void H(boolean z, boolean z2) {
        iZ(!z);
        if (this.fyC != null) {
            this.fyC.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        bsQ();
        long j = -1;
        if (this.fdY != null && this.fdY.bpR() != null) {
            j = this.fdY.bpR().room_id;
        }
        this.fyw.a(z, z2, j);
    }

    public void iZ(boolean z) {
        AlaLiveInfoData bpR;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        if (aa.sO() != null) {
            aa.sO().sN();
        }
        if (this.fzb != null) {
            this.fzb.release();
        }
        if (this.fyS != null) {
            this.fyS.release();
        }
        this.fyV = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.fdY != null && (bpR = this.fdY.bpR()) != null) {
            this.fdY.cY(bpR.live_id);
        }
        this.fyP.stopRecord();
        LiveTimerManager.getInstance().stop();
        bsP();
        if (this.fyC != null) {
            this.fyC.ka(z);
        }
        if (this.fyK != null) {
            this.fyK.iZ(z);
        }
        this.fyR = false;
        o.aDR = 0L;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
    }

    private void bsP() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bsQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(m mVar) {
        if (mVar != null) {
            this.ale = mVar;
            if (this.fyK != null) {
                this.fyK.a(mVar);
            }
        }
    }

    private void d(com.baidu.live.data.h hVar) {
        if (this.fyK != null) {
            this.fyK.d(hVar);
        }
    }

    private void y(m mVar) {
        this.ale = mVar;
    }

    private void bsR() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.fyy.setIsScrollable(false);
            this.fyW = false;
        }
        if (this.ale != null) {
            a(this.ale.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.fyx.a(this.fep, null);
            a(this.fyx, this.ale.mLiveInfo, this.fyF);
            this.fyF = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.fdY != null && this.fdY.yO() != null && this.fdY.yO().mLiveInfo != null) {
                    j = this.fdY.yO().mLiveInfo.live_id;
                    str2 = this.fdY.yO().mLiveInfo.room_id + "";
                    str = this.fdY.yO().mLiveInfo.feed_id;
                } else {
                    if (this.awt > 0) {
                        j2 = this.awt;
                    }
                    if (!TextUtils.isEmpty(this.fyL)) {
                        j = j2;
                        str = "";
                        str2 = this.fyL;
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
                if (this.fdY != null && this.fdY.yO() != null && this.fdY.yO().mLiveInfo != null) {
                    str3 = this.fdY.yO().mLiveInfo.feed_id;
                    str4 = this.fdY.yO().mLiveInfo.live_id + "";
                    str5 = this.fdY.yO().mLiveInfo.room_id + "";
                    str6 = this.fdY.yO().mLiveInfo.user_name;
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
        if (this.fyC != null && this.fyC.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.fyC.getVideoPath();
                String b = f.b(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.fyC.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + b);
                }
                if (!f.ai(videoPath, b)) {
                    if (!TbadkCoreApplication.getInst().isTieba() || !z || !f.ah(videoPath, b)) {
                        if (!z && !alaLiveRoomBlurPageLayout.bC(this.fyC)) {
                            ((ViewGroup) this.fyC.getParent()).removeView(this.fyC);
                            alaLiveRoomBlurPageLayout.a(this.fyC, null, false);
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                        }
                        if (!this.isBackGround) {
                            this.fyC.g(alaLiveInfoData);
                            return;
                        } else {
                            this.fyC.setPlayLiveInfo(alaLiveInfoData);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.fyC.btn();
        } else if (this.fyC != null && this.fyC.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.fyC, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.isBackGround) {
                    this.fyC.g(alaLiveInfoData);
                } else {
                    this.fyC.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.fyC != null) {
            this.fyC.setLayoutParams(b);
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

    public void bsS() {
        this.fyF = true;
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
                this.fyx.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.fyx.setBackgroundColor(0);
            }
        } else {
            this.fyx.setBackgroundColor(0);
        }
        int i2 = this.fyC.getLayoutParams().width;
        int i3 = this.fyC.getLayoutParams().height;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.fep != null) {
            this.fep.setLayoutParams(c);
        }
        if (this.fyx != null) {
            this.fyx.bg(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fyJ != null) {
            this.fyJ.bg(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fyK != null) {
            this.fyK.j(c.width, c.height, realScreenOrientation);
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
        if (this.ale != null && this.ale.mLiveInfo != null) {
            this.fyx.setBgImageUrl(this.ale.mLiveInfo.cover, this.ale.mLiveInfo);
            this.fyz.a(this.mSelectedPosition, bsT(), this.ale);
            this.fyz.b(this.mSelectedPosition, bsU(), this.ale);
            this.fyx.requestLayout();
            this.fyx.A(i, this.ale.mLiveInfo.screen_direction == 2);
        }
        if (this.ale != null) {
            a(this.ale.mLiveInfo, false);
        }
        boolean bqZ = this.fyx.bqZ();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.ale == null || this.ale.mLiveInfo == null || this.ale.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!btf()) {
            if (this.fyC != null && this.fyC.getParent() == null) {
                this.fyx.a(this.fyC, null, false);
                if (this.ale != null && this.ale.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.isBackGround) {
                        this.fyC.g(this.ale.mLiveInfo);
                    } else {
                        this.fyC.setPlayLiveInfo(this.ale.mLiveInfo);
                    }
                }
            }
            if (bqZ && !btf() && this.fyK != null) {
                this.fyx.jO(z);
                return;
            }
            return;
        }
        this.fyx.bqT();
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
            this.fdY.a(alaLiveInfoData.live_id, true, this.aws, this.mForumName);
            this.fdY.cX(alaLiveInfoData.live_id);
        }
    }

    public void qS(int i) {
        if (i < 0) {
            this.fdY.qy(this.fdY.bpO() - 1);
        } else if (i > 0) {
            this.fdY.qy(this.fdY.bpO() + 1);
        }
        if (this.fyK != null) {
            this.fyK.a(this.fyx);
        }
        this.fyz.a(this.mSelectedPosition, bsT(), this.ale);
        this.fyz.b(this.mSelectedPosition, bsU(), this.ale);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.fdY != null) {
            int bpO = this.fdY.bpO();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bpO + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.fdY.bpG() != null && this.fdY.bpG().size() > bpO && this.fdY.bpG().get(bpO) != null) {
                AlaLiveInfoData alaLiveInfoData = this.fdY.bpG().get(bpO);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fdY != null) {
            AlaLiveInfoData bpR = this.fdY.bpR();
            if (bpR != null) {
                bpR.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.fyx, bpR, this.fyF);
                this.fyF = false;
                if (this.fyK != null) {
                    this.fyK.a(this.mTbPageContext, this.fep, this.fyC, this.fyx, this.fdY, this.aws, this.fyG, this.fet, null, this.fyV);
                    short s = 2;
                    if (bpR.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bpR, false);
            }
            f(bpR);
            this.fyx.a(this.fep, null);
            if (this.fyK != null) {
                this.fyK.bjM();
            }
            this.fdY.d(bpR);
        }
    }

    private AlaLiveInfoData bsT() {
        List<AlaLiveInfoData> bpG = this.fdY.bpG();
        if (bpG == null || bpG.size() == 0) {
            if (this.ale == null) {
                return null;
            }
            return this.ale.mLiveInfo;
        }
        int bpO = this.fdY.bpO();
        int size = bpG.size();
        return bpG.get(((bpO + size) - 1) % size);
    }

    private AlaLiveInfoData bsU() {
        List<AlaLiveInfoData> bpG = this.fdY.bpG();
        if (bpG == null || bpG.size() == 0) {
            if (this.ale == null) {
                return null;
            }
            return this.ale.mLiveInfo;
        }
        return bpG.get((this.fdY.bpO() + 1) % bpG.size());
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
        m yO = this.fdY.yO();
        y(yO);
        this.fdY.bpH();
        if (this.fyF) {
            this.fdY.jI(false);
        }
        this.fet = System.currentTimeMillis() / 1000;
        if (this.fyK != null) {
            this.fyK.a(this.mTbPageContext, this.fep, this.fyC, this.fyx, this.fdY, this.aws, this.fyG, this.fet, this.fyH, this.fyV);
            short s = 2;
            if (yO.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bsR();
        if (yO != null && yO.mLiveInfo != null && yO.mLiveInfo.live_status == 2) {
            this.fyz.a(this.mSelectedPosition, this.fdY.yO());
            d(yO, false);
            this.fyF = false;
            return;
        }
        boolean z = (this.fyK == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.fyT || !TextUtils.equals(q.Bh(), this.fyU))) {
            t.b(getPageContext());
            com.baidu.live.v.c.zq().zr();
            this.fyT = true;
            this.fyU = q.Bh();
        }
        this.fyR = false;
        if (this.fdY.yO() != null && this.fdY.yO().mLiveInfo != null) {
            String str2 = this.fdY.yO().mLiveInfo.feed_id;
            long j = this.fdY.yO().mLiveInfo.live_id;
            long j2 = this.fdY.yO().mLiveInfo.user_id;
            this.fdY.cX(j);
            if (z) {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                    com.baidu.live.utils.m.i(j2, j);
                }
                o.g(str2, j);
            }
        }
        if (this.fyK != null) {
            this.fyK.iY(TextUtils.equals(this.fyI, "1"));
            this.fyI = "";
        }
        if (this.fyA != null) {
            this.fyA.a(this.ale, this.fyB);
        }
        a(this.fdY.yO());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.fdY.yO() != null && b.this.fdY.yO().mLiveInfo != null) {
                    b.this.fdY.a(b.this.fdY.yO().mLiveInfo.live_id, b.this.aws, b.this.fet);
                }
            }
        }, this.fdY.yO().XU);
        if (z && this.fdY.yO() != null && this.fdY.yO().XQ != null) {
            ap apVar = com.baidu.live.v.a.zl().axD;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && apVar != null && apVar.acV != null && apVar.acV.aez) {
                c(true, this.fdY.yO().XQ.userId);
            }
        }
        this.fyF = false;
        if (z && this.fdY.yO() != null && this.fdY.yO().mLiveInfo != null && this.fdY.yO().XQ != null && this.fyK != null) {
            long j3 = this.fdY.yO().mLiveInfo.live_id;
            long j4 = this.fdY.yO().mLiveInfo.room_id;
            String str3 = this.fdY.yO().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j3;
                if (aa.sO() != null) {
                    aa.sO().a(this.mTbPageContext.getPageActivity(), j3, str4, j4, str3, this.otherParams);
                }
                if (this.fzb != null) {
                    this.fzb.b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
                }
            }
            if (e.vG() != null) {
                e.vG().b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            }
            if (this.fyS == null) {
                this.fyS = new com.baidu.tieba.ala.liveroom.i.a();
            }
            this.fyS.a(this.mTbPageContext.getPageActivity(), this.fdY.yO(), this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsV() {
        if (this.fyD) {
            this.fyz.a(this.mSelectedPosition, bsT(), this.ale);
            this.fyz.b(this.mSelectedPosition, bsU(), this.ale);
            this.fyD = false;
        }
        if (this.fyJ != null && btf()) {
            this.fyJ.U(this.fdY.bpI());
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
            this.mHandler.removeCallbacks(this.fza);
            this.mHandler.postDelayed(this.fza, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.live.data.h hVar) {
        if (hVar == null) {
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fyZ);
                this.mHandler.postDelayed(this.fyZ, 5000L);
                return;
            }
            return;
        }
        if (!this.fyE) {
            d(hVar);
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.fyZ);
            this.mHandler.postDelayed(this.fyZ, hVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsW() {
        if (this.fdY.yO() != null && this.fdY.yO().mLiveInfo != null) {
            this.fdY.cX(this.fdY.yO().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.live_status == 2) {
            this.fyz.a(this.mSelectedPosition, this.fdY.yO());
            d(mVar, false);
        } else if (mVar != null) {
            if (!this.fyE) {
                a(mVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fyY);
                this.mHandler.postDelayed(this.fyY, mVar.XU);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsX() {
        if (this.mTbPageContext != null && this.fdY.yO() != null && this.fdY.yO().mLiveInfo != null) {
            this.fdY.a(this.fdY.yO().mLiveInfo.live_id, this.aws, this.fet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar, boolean z) {
        View view = null;
        iZ(true);
        if (!btf()) {
            this.fdY.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            this.fyx.blO();
            this.fyx.bqT();
            this.fyx.bra();
            if (mVar != null && mVar.mLiveInfo != null) {
                this.fyM = mVar.mLiveInfo.live_id;
            }
            bsO();
            bsY();
            bsZ();
            if (mVar != null) {
                if (this.fyK != null && this.fyK.bjS() != null) {
                    view = this.fyK.bjS().a(this.fyK.bjJ().pageContext.getPageActivity(), mVar, z);
                }
                this.fyJ.a(this.fyx, view, mVar, z, this.fdY.bpI());
                if (this.fyK != null) {
                    this.fyK.iZ(false);
                    this.fyK.bjN();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                this.fyx.bqX();
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
                this.fyQ = new StayTimeBean();
                this.fyQ.liveId = mVar.mLiveInfo.live_id;
                this.fyQ.roomId = mVar.mLiveInfo.room_id;
                this.fyQ.vid = mVar.mLiveInfo.feed_id;
                this.fyQ.startTime = System.currentTimeMillis();
            }
            bth();
            if (this.fyA != null) {
                this.fyA.a(this.ale, this.fyB);
            }
        }
    }

    private void bsY() {
    }

    private void bsZ() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.fyy);
        }
    }

    public void bta() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            btb();
        } else {
            btc();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.fdY != null && this.fdY.yO() != null) {
            alaLiveInfoData = this.fdY.yO().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            btb();
        } else {
            btc();
        }
        this.fyy.setIsScrollable(!z && this.fyW);
        if (this.fyK != null) {
            this.fyK.onKeyboardVisibilityChanged(z);
        }
        if (this.fep != null) {
            this.fep.onKeyboardVisibilityChanged(z);
        }
    }

    public void bW(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            btb();
        } else {
            btc();
        }
        this.fep.bW(realScreenOrientation);
        ql(realScreenOrientation);
        if (aa.sO() != null) {
            aa.sO().sm();
        }
        if (this.fyS != null) {
            this.fyS.sm();
        }
        if (this.fyA != null) {
            this.fyA.bW(realScreenOrientation);
        }
    }

    public void btb() {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.fyy != null) {
            com.baidu.live.utils.h.S(this.fyy);
        }
    }

    public void btc() {
        if (this.fyy != null) {
            com.baidu.live.utils.h.T(this.fyy);
        }
    }

    public void onResume() {
        if (this.fdY != null) {
            this.fdY.bps();
            this.fdY.bpv();
        }
        if (this.fyK != null) {
            this.fyK.enterForeground();
        }
        if (this.fyS != null) {
            this.fyS.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.t.a.eI(this.mTbPageContext.getPageActivity()) && this.isBackGround) {
            this.isBackGround = false;
            btd();
        }
    }

    public void btd() {
        bsX();
        bsW();
        this.fdY.bpH();
        this.fyC.bto();
        if (this.fyK != null) {
            this.fyK.bjR();
        }
        if (this.fdY != null && this.fdY.yO() != null && this.fdY.yO().mLiveInfo != null) {
            this.fyP.da(this.fdY.yO().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.ale.mLiveInfo.live_id);
        }
    }

    public void onPause() {
        if (this.fdY != null) {
            this.fdY.bpt();
            this.fdY.bpw();
        }
        if (this.fyK != null) {
            this.fyK.enterBackground();
        }
    }

    public void onStop() {
        this.isBackGround = true;
        bte();
    }

    public void bte() {
        this.mHandler.removeCallbacks(this.fyY);
        this.mHandler.removeCallbacks(this.fyZ);
        this.mHandler.removeCallbacks(this.fza);
        this.fyC.pausePlay();
        if (this.fyK != null) {
            this.fyK.bjQ();
        }
        this.fyP.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (aa.sO() != null) {
                aa.sO().a(i, i2, intent, this.ale, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.fyK != null) {
            this.fyK.onActivityResult(i, i2, intent);
        }
    }

    public boolean btf() {
        return this.fyJ != null && this.fyJ.beF();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fzf != null) {
            MessageManager.getInstance().unRegisterListener(this.fzf);
        }
        if (this.fzg != null) {
            MessageManager.getInstance().unRegisterListener(this.fzg);
        }
        MessageManager.getInstance().unRegisterListener(this.fzh);
        MessageManager.getInstance().unRegisterListener(this.fge);
        MessageManager.getInstance().unRegisterListener(this.fgd);
        MessageManager.getInstance().unRegisterListener(this.fzi);
        MessageManager.getInstance().unRegisterListener(this.fzj);
        MessageManager.getInstance().unRegisterListener(this.fzk);
        if (this.fzb != null) {
            this.fzb.release();
        }
        if (this.fyC != null) {
            this.fyC.ka(true);
        }
        if (this.fyA != null) {
            this.fyA.onDestory();
        }
        this.fyB = null;
        if (this.fyK != null) {
            this.fyK.onDestroy();
        }
        if (this.fyz != null) {
            this.fyz.onDestroy();
        }
        this.fyx.blO();
        if (this.fyx != null) {
            this.fyx.release();
            this.fyx = null;
        }
        if (this.fyJ != null) {
            this.fyJ.onDestroy();
            this.fyJ = null;
        }
        if (this.fyQ != null && this.fdY != null && this.fdY.yO() != null) {
            long j = this.fdY.yO().mLiveInfo.live_id;
            if (this.fyQ.liveId == j && this.fyQ.startTime > 0) {
                this.fyQ.endTime = System.currentTimeMillis();
                long j2 = this.fyQ.endTime - this.fyQ.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.fyQ.roomId + "", this.fyQ.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.fyQ = null;
        }
        if (this.fep != null) {
            this.fep.brc();
            this.fep = null;
        }
        if (this.fdY != null) {
            this.fdY.destory();
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

    public void btg() {
        if (this.fyN != null) {
            this.otherParams = this.fyN.toString();
            if (this.fdY != null) {
                this.fdY.setOtherParams(this.otherParams);
            }
            if (this.fyK != null) {
                this.fyK.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            this.fyJ.setOtherParams(this.otherParams);
        }
    }

    public void bth() {
        if (this.fyN != null) {
            String optString = this.fyN.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.fyN.put("tab", "live_jump");
                        this.fyN.put("tag", "");
                        this.fyN.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.fyN.put("tab", "liveroom");
                        this.fyN.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                btg();
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

    public void bti() {
        if (!btk()) {
            if (this.mNetChangedDialog == null) {
                this.mNetChangedDialog = new BdAlertDialog(getPageContext().getPageActivity());
                this.mNetChangedDialog.setCanceledOnTouchOutside(false);
                this.mNetChangedDialog.setMessage(getPageContext().getResources().getString(a.i.ala_create_not_wifi));
                this.mNetChangedDialog.setPositiveButton(getPageContext().getResources().getString(a.i.sdk_liveroom_attention_guide_btn_text), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.11
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        b.this.btl();
                        b.this.mNetChangedDialog.dismiss();
                    }
                });
                this.mNetChangedDialog = this.mNetChangedDialog.create(this.mTbPageContext);
                this.mNetChangedDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.player.b.13
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getRepeatCount() == 0) {
                            b.this.btl();
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

    public void btj() {
        if (this.mNetChangedDialog != null) {
            this.mNetChangedDialog.dismiss();
        }
    }

    public boolean btk() {
        return this.mNetChangedDialog != null && this.mNetChangedDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btl() {
        onStart();
        btm();
    }

    public void btm() {
        t.sJ();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fyK.d(s);
        } else {
            this.fyK.e(s);
        }
    }
}
