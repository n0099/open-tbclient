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
import com.baidu.live.data.ae;
import com.baidu.live.data.ao;
import com.baidu.live.data.l;
import com.baidu.live.gift.s;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.message.h;
import com.baidu.live.r.a;
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
import com.baidu.live.utils.k;
import com.baidu.live.utils.m;
import com.baidu.live.utils.o;
import com.baidu.live.utils.p;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.liveroom.c.e;
import com.baidu.tieba.ala.liveroom.data.j;
import com.baidu.tieba.ala.liveroom.i.g;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.ala.liveroom.o.c;
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
    private l aiW;
    private String asg;
    private long ash;
    private String eKA;
    private AlaLiveView faQ;
    private long faU;
    private com.baidu.tieba.ala.liveroom.o.c fay;
    private c.a fbe;
    private HttpMessageListener fcI;
    private HttpMessageListener fcJ;
    private b fvN;
    private AlaLiveRoomBlurPageLayout fvO;
    private AlaLoopViewPager fvP;
    private AlaLoopViewPagerAdapter fvQ;
    private com.baidu.tieba.ala.liveroom.d.a fvR;
    private com.baidu.tieba.ala.liveroom.d.b fvS;
    private AlaLivePlayer fvT;
    private boolean fvU;
    private boolean fvV;
    private boolean fvW;
    private boolean fvX;
    private ArrayList<AlaBroadcastGiftToastData> fvY;
    private String fvZ;
    CustomMessageListener fwA;
    private CustomMessageListener fwB;
    private com.baidu.tieba.ala.endliveroom.a fwa;
    private com.baidu.tieba.ala.liveroom.c.c fwb;
    private String fwc;
    private long fwd;
    private JSONObject fwe;
    private boolean fwf;
    private com.baidu.tieba.ala.liveroom.task.c fwg;
    private StayTimeBean fwh;
    private boolean fwi;
    private com.baidu.tieba.ala.liveroom.j.a fwj;
    private boolean fwk;
    private String fwl;
    private j fwm;
    private boolean fwn;
    private boolean fwo;
    private Runnable fwp;
    private Runnable fwq;
    private Runnable fwr;
    private com.baidu.live.u.c fws;
    private AlaLivePlayer.a fwt;
    e fwu;
    ViewPager.OnPageChangeListener fwv;
    HttpMessageListener fww;
    CustomMessageListener fwx;
    CustomMessageListener fwy;
    CustomMessageListener fwz;
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
        this.fvU = true;
        this.faU = 0L;
        this.fvV = false;
        this.fvW = true;
        this.asg = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.fvX = false;
        this.fvZ = "0";
        this.mHandler = new Handler();
        this.fwd = -1L;
        this.otherParams = "";
        this.fwf = false;
        this.fwg = com.baidu.tieba.ala.liveroom.task.c.boQ();
        this.fwi = false;
        this.fwk = false;
        this.fwo = false;
        this.fwp = new Runnable() { // from class: com.baidu.tieba.ala.player.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.bru();
            }
        };
        this.fwq = new Runnable() { // from class: com.baidu.tieba.ala.player.c.12
            @Override // java.lang.Runnable
            public void run() {
                c.this.brt();
            }
        };
        this.fwr = new Runnable() { // from class: com.baidu.tieba.ala.player.c.14
            @Override // java.lang.Runnable
            public void run() {
                c.this.fay.bnS();
            }
        };
        this.fwt = new AlaLivePlayer.a() { // from class: com.baidu.tieba.ala.player.c.15
            @Override // com.baidu.tieba.ala.player.AlaLivePlayer.a
            public void bd(int i) {
                if (c.this.fvO != null) {
                    if (ListUtils.getCount(c.this.fvT.getAlaLiveInfoDataList()) < 2) {
                        c.this.fvO.bpm();
                    } else {
                        c.this.fvO.bpn();
                    }
                }
                if (c.this.fwb != null) {
                    c.this.fwb.bd(i);
                }
                if (BdNetTypeUtil.isMobileNet()) {
                    if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && k.yH()) {
                        c.this.onStop();
                        c.this.brF();
                        return;
                    }
                    c.this.brJ();
                }
            }
        };
        this.fwu = new e() { // from class: com.baidu.tieba.ala.player.c.18
            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void ja(boolean z) {
                if (z || c.this.fwb == null || c.this.fwb.bhN()) {
                    c.this.jY(true);
                    c.this.beQ();
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void jb(boolean z) {
                c.this.d(c.this.aiW, z);
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void U(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                c.this.fvT.brc();
                if (arrayList != null && !arrayList.isEmpty() && !c.this.isBackGround) {
                    if (c.this.isBackGround) {
                        c.this.fvT.setPlayLiveInfo(arrayList);
                    } else {
                        c.this.fvT.Z(arrayList);
                    }
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void z(boolean z, boolean z2) {
                if (c.this.fvP != null) {
                    c.this.fvP.setIsScrollable(c.this.fwn && z);
                    c.this.fvP.setEnabled(z2);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.c.e
            public void jc(boolean z) {
                boolean z2 = true;
                if (!z || c.this.brC()) {
                    if (c.this.fvO != null) {
                        c.this.fvO.bpp();
                        return;
                    }
                    return;
                }
                if (c.this.fay.ww().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(c.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (c.this.fvO != null) {
                    c.this.fvO.jM(z2);
                }
            }
        };
        this.fwv = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.c.19
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (c.this.mTbPageContext != null && c.this.mTbPageContext.getPageActivity() != null && !c.this.mTbPageContext.getPageActivity().isFinishing() && c.this.faQ != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        c.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        c.this.fvP.setCurrentItem(c.this.mSelectedPosition);
                    } else if (c.this.fvW || ListUtils.getCount(c.this.fay.bnR()) > 1) {
                        int i2 = (i - c.this.mSelectedPosition == 2 || i - c.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && c.this.fay.bnU() == 1) {
                            if (!c.this.fay.bnX() || i2 >= 0) {
                                if (c.this.fay.bnY() && i2 > 0) {
                                    c.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    c.this.fvP.setCurrentItem(c.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                c.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                c.this.fvP.setCurrentItem(c.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        c.this.fay.cancelLoadData();
                        c.this.mHandler.removeCallbacksAndMessages(null);
                        c.this.iT(true);
                        c.this.fvO.bpk();
                        c.this.fvO.bjX();
                        c.this.fvO.bpl();
                        if (c.this.fay.ww() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(c.this.fay.ww().mLiveInfo.live_id + "", c.this.fay.ww().mLiveInfo.room_id + "", c.this.fay.ww().Wf.userId + "", c.this.fay.ww().Wf.userName, System.currentTimeMillis(), c.this.fay.ww().mLiveInfo.feed_id, c.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(c.this.fay.ww().mLiveInfo.live_id + "", c.this.fay.ww().mLiveInfo.room_id + "", c.this.fay.ww().Wf.userId + "", c.this.fay.ww().Wf.userName, System.currentTimeMillis(), c.this.fay.ww().mLiveInfo.feed_id, c.this.otherParams);
                            }
                        }
                        if (c.this.fwh != null) {
                            long j = c.this.fay.ww().mLiveInfo.live_id;
                            if (c.this.fwh.liveId == j && c.this.fwh.startTime > 0) {
                                c.this.fwh.endTime = System.currentTimeMillis();
                                long j2 = c.this.fwh.endTime - c.this.fwh.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", c.this.fwh.roomId + "", c.this.fwh.vid, j2 / 1000, c.this.otherParams);
                            }
                            c.this.fwh = null;
                        }
                        c.this.brE();
                        if (c.this.fws != null) {
                            c.this.fws.release();
                        }
                        c.this.mSelectedPosition = i;
                        c.this.fvO = c.this.fvQ.pX(c.this.mSelectedPosition);
                        c.this.fvO.bpo();
                        c.this.qL(i2);
                    } else {
                        c.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        c.this.fvP.setCurrentItem(c.this.mSelectedPosition);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.oJ().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.fbe = new c.a() { // from class: com.baidu.tieba.ala.player.c.20
            @Override // com.baidu.tieba.ala.liveroom.o.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    c.this.u(c.this.fay.ww());
                } else if (i2 == 2) {
                    c.this.g(c.this.fay.bbH());
                } else if (i2 == 3) {
                    c.this.aA(i, str);
                } else if (i2 == 4) {
                    c.this.aq(obj);
                } else if (i2 == 5) {
                    c.this.brs();
                }
            }
        };
        this.fww = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.boO() != null && c.this.mTbPageContext != null) {
                        c.this.fwg.a(c.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.boO());
                    }
                }
            }
        };
        this.fwx = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.c.4
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
        this.fwy = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.mTbPageContext != null && c.this.fay != null && c.this.fay.ww() != null && c.this.fay.ww().mLiveInfo != null) {
                    long j = c.this.fay.ww().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (c.this.fws != null) {
                        c.this.fws.a(c.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.fcJ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = c.this.fay.ww().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.asx != null && !eventPollingHttpResponseMessage.asx.isEmpty() && c.this.fay != null && c.this.fay.ww() != null && c.this.fay.ww().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.asx.size()) {
                                break;
                            }
                            ae aeVar = eventPollingHttpResponseMessage.asx.get(i2);
                            if (j == aeVar.liveId && j2 - aeVar.createTime <= 60 && !m.g(aeVar.liveId, aeVar.id)) {
                                m.a(aeVar, c.this.fay.ww().mLiveInfo);
                                m.h(aeVar.liveId, aeVar.id);
                            }
                            i = i2 + 1;
                        }
                        ae aeVar2 = eventPollingHttpResponseMessage.asx.get(eventPollingHttpResponseMessage.asx.size() - 1);
                        if (j == aeVar2.liveId) {
                            m.f(aeVar2.liveId, aeVar2.id);
                        }
                    }
                    int i3 = eventPollingHttpResponseMessage.asw;
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    c.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.c.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.fay != null && c.this.fay.ww() != null) {
                                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                    m.i(c.this.fay.ww().mLiveInfo.user_id, c.this.fay.ww().mLiveInfo.live_id);
                                }
                            }
                        }
                    }, i3 * 1000);
                }
            }
        };
        this.fcI = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h)) {
                        h hVar = (h) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (c.this.fay != null && c.this.fay.ww() != null) {
                            long j = c.this.fay.ww().mLiveInfo.live_id;
                            if (j == hVar.liveId) {
                                getVideoGoodsListHttpResponseMessage.liveId = j;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                                if (!c.this.fwi) {
                                    c.this.fwi = true;
                                    String str = "goods_task_" + j;
                                    ao aoVar = com.baidu.live.s.a.wR().atk;
                                    long j2 = (aoVar == null || aoVar.aaY == null) ? 10L : aoVar.aaY.acD;
                                    if (j2 <= 0) {
                                        j2 = 10;
                                    }
                                    LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.c.7.1
                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onComplete(boolean z) {
                                            if (c.this.fay != null && c.this.fay.ww() != null && c.this.fay.ww().mLiveInfo.live_id != o.azz) {
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, c.this.fay.ww().mLiveInfo));
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
        this.fwz = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (c.this.mTbPageContext != null && c.this.fay != null && c.this.fay.ww() != null && c.this.fay.ww().Wt != null) {
                        if (l.longValue() == c.this.fay.ww().Wt.userId) {
                            c.this.fay.ww().Wt.isNewUser = false;
                            if (c.this.fwj != null) {
                                c.this.fwj.n(c.this.fay.ww());
                            }
                        }
                    }
                }
            }
        };
        this.fwA = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.s.a)) {
                    com.baidu.tieba.ala.liveroom.s.a aVar = (com.baidu.tieba.ala.liveroom.s.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar.getUserId());
                    String aVC = aVar.aVC();
                    if (c.this.mTbPageContext != null && c.this.fay != null && c.this.fay.ww() != null && c.this.fay.ww().Wt != null) {
                        if (valueOf.longValue() == c.this.fay.ww().Wt.userId && com.baidu.live.s.a.wR().atk != null && com.baidu.live.s.a.wR().atk.aaS != null && com.baidu.live.s.a.wR().atk.aaS.pY()) {
                            g.pQ(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, aVC));
                        }
                    }
                }
            }
        };
        this.fwB = new CustomMessageListener(2913151) { // from class: com.baidu.tieba.ala.player.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (c.this.mHandler != null && c.this.fwp != null) {
                    c.this.mHandler.removeCallbacks(c.this.fwp);
                }
                c.this.bru();
            }
        };
        this.faU = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.fvN = bVar;
        this.fvU = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.u.c.class);
        if (runTask != null) {
            this.fws = (com.baidu.live.u.c) runTask.getData();
        }
        this.fay = new com.baidu.tieba.ala.liveroom.o.c(getPageContext());
        this.fay.a(this.fbe);
        this.fwa = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.fww);
        MessageManager.getInstance().registerListener(this.fwx);
        MessageManager.getInstance().registerListener(this.fwy);
        MessageManager.getInstance().registerListener(this.fcJ);
        MessageManager.getInstance().registerListener(this.fcI);
        MessageManager.getInstance().registerListener(this.fwz);
        MessageManager.getInstance().registerListener(this.fwA);
        MessageManager.getInstance().registerListener(this.fwB);
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.fvY = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.fvY.add(alaBroadcastGiftToastData);
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
        this.asg = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.asg)) {
            this.asg = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.mUserName = intent.getStringExtra("user_name");
        this.fwc = intent.getStringExtra("room_id");
        this.ash = intent.getLongExtra("live_id", 0L);
        this.fwf = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.fay.b((AlaLiveInfoCoreData) serializableExtra);
            this.fwf = true;
        }
        ah(intent);
        this.fwn = this.fwm == null || !this.fwm.eXh;
        this.fwa.setOtherParams(this.otherParams);
        this.fvX = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        brg();
        brf();
    }

    private void ah(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.eKA = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.fwe = new JSONObject(stringExtra);
                if (this.fwe != null) {
                    String optString = this.fwe.optString("enterRoomId");
                    String optString2 = this.fwe.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.fwc, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.ash + "", optString2))) {
                        String optString3 = this.fwe.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.fwe.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.fwf) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.ash;
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
                            this.fay.b(alaLiveInfoCoreData);
                            this.fwf = true;
                        }
                    }
                    String optString5 = this.fwe.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.fwm = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.eKA = jSONObject.optString("live_back_scheme");
                        this.fwm = new j();
                        this.fwm.eXh = jSONObject.optInt("is_hot") == 1;
                        if (this.fwm.eXh) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.fwm.eXi = jSONObject.optString("task_id");
                        this.fwm.eXg = !TextUtils.isEmpty(this.fwm.eXi);
                        this.fwm.eXj = jSONObject.optInt("task_type");
                        this.fwm.eXk = jSONObject.optInt("task_im_count");
                        this.fwm.eXl = jSONObject.optLong("task_gift_total_price");
                        this.fwm.eXm = jSONObject.optLong("task_watch_time");
                        this.fwm.eXn = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                        String optString6 = jSONObject.optString("back_app_scheme");
                        String optString7 = jSONObject.optString("back_app_icon");
                        String optString8 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString6)) {
                            this.fvS = new com.baidu.tieba.ala.liveroom.d.b();
                            this.fvS.setScheme(optString6);
                            this.fvS.setImageUrl(optString7);
                            this.fvS.setTitle(optString8);
                        }
                    }
                    this.fvZ = this.fwe.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fwe.remove("cover");
                    this.fwe.remove("live_url");
                    this.fwe.remove("enterRoomId");
                    this.fwe.remove("enterLiveId");
                    this.fwe.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fwe.remove("extra");
                    this.otherParams = this.fwe.toString();
                    this.fay.setOtherParams(this.otherParams);
                    this.fwe.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.fwe.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.fwe.optString("source");
                    }
                    this.fwo = "mobilebaidu_subscription".equals(str);
                    int optInt = this.fwe.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.fay.qq(optInt);
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

    public void brf() {
        if (!TextUtils.isEmpty(this.mUserName)) {
            this.fay.ab(this.mUserName, this.asg, this.mForumName);
        } else if (this.fay.ww() != null && this.fay.ww().mLiveInfo != null && this.fay.ww().mLiveInfo.live_id > 0) {
            this.fay.a(this.fay.ww().mLiveInfo.live_id, false, this.asg, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uname=")) {
                this.mUserName = WebviewHelper.getMatchStringFromURL(lowerCase, "uname=");
            }
            if (lowerCase.contains("from=")) {
                this.asg = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.mUserName == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                jY(false);
                return;
            }
            this.fay.ab(this.mUserName, this.asg, this.mForumName);
        } else if (!TextUtils.isEmpty(this.fwc)) {
            this.fay.yQ(this.fwc);
        } else if (this.ash > 0) {
            this.fay.a(this.ash, false, this.asg, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            jY(false);
        }
    }

    private void brg() {
        this.fvW = true;
        this.fvV = false;
        brh();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        this.fwb = new com.baidu.tieba.ala.liveroom.c.c();
        this.fwb.a(this.fwu);
        this.fwb.setOtherParams(this.otherParams);
        this.fwb.iO(this.fwo);
        brj();
        brk();
        bri();
    }

    private void brh() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.fvP = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.fvP.setOnPageChangeListener(this.fwv);
        this.fvP.setBoundaryCaching(true);
        this.fvP.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.fvQ = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.fvQ.bly();
        this.fvO = this.fvQ.pW(this.mSelectedPosition);
        this.fvQ.a(this.mSelectedPosition, this.fay.ww());
        this.fvP.setAdapter(this.fvQ);
        this.fvP.setCurrentItem(this.mSelectedPosition);
        this.fvP.setIsScrollable(this.fwn);
    }

    private void c(Rect rect) {
        this.fvT = AlaLivePlayer.eH(getPageContext().getPageActivity());
        if (this.fvT == null) {
            this.fvP.setIsScrollable(false);
            if (this.fay != null) {
                this.fay.cancelLoadData();
            }
            blB();
            return;
        }
        if (this.fvX) {
            this.fvP.setIsScrollable(false);
        }
        this.fvT.setPageContext(getPageContext());
        this.fvT.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.fvT.setIPlayerCallBack(this.fwt);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fvO.a(this.fvT, layoutParams, true);
    }

    private void bri() {
        this.fvR = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext);
    }

    private void blB() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.c.16
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                c.this.jY(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.faQ = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.faQ.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fvO.a(this.faQ, layoutParams);
    }

    private void brj() {
        if (this.fay != null && this.fay.ww() != null) {
            this.aiW = this.fay.ww();
            if (this.aiW.mLiveInfo != null) {
                a(this.aiW.mLiveInfo, this.fwf);
                if (this.aiW.mLiveInfo != null && this.aiW.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.isBackGround);
                    }
                    if (!this.isBackGround) {
                        this.fvT.f(this.aiW.mLiveInfo);
                    } else {
                        this.fvT.setPlayLiveInfo(this.aiW.mLiveInfo);
                    }
                    if (this.fwb != null) {
                        short s = this.aiW.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2;
                        this.fwb.a(this.mTbPageContext, this.faQ, this.fvT, this.fvO, this.fay, this.asg, this.fvX, this.faU, this.fvY, this.fwm);
                        this.fwb.c(s);
                    }
                }
            }
        }
    }

    private void brk() {
        this.mTbPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.player.c.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (c.this.aiW != null && c.this.aiW.Wf != null && c.this.aiW.Wf.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + c.this.aiW.mLiveInfo.live_id);
                        c.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.c.17.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", c.this.aiW.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                }
            }
        });
    }

    private void brl() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.fvX || !this.fwn) {
                this.fvP.setIsScrollable(false);
            } else {
                this.fvP.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && (this.fwb == null || !this.fwb.bhM())) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                brl();
            } else if (this.fwb == null || this.fwb.bhN()) {
                jY(true);
                beQ();
            }
        }
        return true;
    }

    public void beQ() {
        if (!TextUtils.isEmpty(this.eKA)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.eKA);
                this.eKA = null;
            }
        }
    }

    public void jY(boolean z) {
        F(z, false);
    }

    public void F(boolean z, boolean z2) {
        iT(!z);
        if (this.fvT != null) {
            this.fvT.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        brn();
        long j = -1;
        if (this.fay != null && this.fay.boc() != null) {
            j = this.fay.boc().room_id;
        }
        this.fvN.a(z, z2, j);
    }

    public void iT(boolean z) {
        AlaLiveInfoData boc;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        com.baidu.tieba.ala.liveroom.yuangift.a.bpM().xe();
        if (this.fws != null) {
            this.fws.release();
        }
        if (this.fwj != null) {
            this.fwj.release();
        }
        this.fwm = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.fay != null && (boc = this.fay.boc()) != null) {
            this.fay.cV(boc.live_id);
        }
        this.fwg.stopRecord();
        LiveTimerManager.getInstance().stop();
        brm();
        if (this.fvT != null) {
            this.fvT.jX(z);
        }
        if (this.fwb != null) {
            this.fwb.iT(z);
        }
        this.fwi = false;
        o.azz = 0L;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
    }

    private void brm() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void brn() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(l lVar) {
        if (lVar != null) {
            this.aiW = lVar;
            if (this.fwb != null) {
                this.fwb.a(lVar);
            }
        }
    }

    private void d(com.baidu.live.data.g gVar) {
        if (this.fwb != null) {
            this.fwb.d(gVar);
        }
    }

    private void t(l lVar) {
        this.aiW = lVar;
    }

    private void bro() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.fvP.setIsScrollable(false);
            this.fwn = false;
        }
        if (this.aiW != null) {
            a(this.aiW.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.fvO.a(this.faQ, null);
            a(this.fvO, this.aiW.mLiveInfo, this.fvW);
            this.fvW = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.fay != null && this.fay.ww() != null && this.fay.ww().mLiveInfo != null) {
                    j = this.fay.ww().mLiveInfo.live_id;
                    str2 = this.fay.ww().mLiveInfo.room_id + "";
                    str = this.fay.ww().mLiveInfo.feed_id;
                } else {
                    if (this.ash > 0) {
                        j2 = this.ash;
                    }
                    if (!TextUtils.isEmpty(this.fwc)) {
                        j = j2;
                        str = "";
                        str2 = this.fwc;
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
                if (this.fay != null && this.fay.ww() != null && this.fay.ww().mLiveInfo != null) {
                    str3 = this.fay.ww().mLiveInfo.feed_id;
                    str4 = this.fay.ww().mLiveInfo.live_id + "";
                    str5 = this.fay.ww().mLiveInfo.room_id + "";
                    str6 = this.fay.ww().mLiveInfo.user_name;
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
        if (this.fvT != null && this.fvT.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.fvT.getVideoPath();
                String e = a.e(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.fvT.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + e);
                }
                if (!a.cQ(videoPath, e)) {
                    if (!z && !alaLiveRoomBlurPageLayout.bC(this.fvT)) {
                        ((ViewGroup) this.fvT.getParent()).removeView(this.fvT);
                        alaLiveRoomBlurPageLayout.a(this.fvT, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.isBackGround) {
                        this.fvT.f(alaLiveInfoData);
                        return;
                    } else {
                        this.fvT.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
                return;
            }
            this.fvT.brc();
        } else if (this.fvT != null && this.fvT.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.fvT, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.isBackGround) {
                    this.fvT.f(alaLiveInfoData);
                } else {
                    this.fvT.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.fvT != null) {
            this.fvT.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.u(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.v(this.mTbPageContext.getPageActivity());
                int aK = p.aK(this.mTbPageContext.getPageActivity());
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

    public void brp() {
        this.fvW = true;
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
                this.fvO.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.fvO.setBackgroundColor(0);
            }
        } else {
            this.fvO.setBackgroundColor(0);
        }
        int i2 = this.fvT.getLayoutParams().width;
        int i3 = this.fvT.getLayoutParams().height;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.faQ != null) {
            this.faQ.setLayoutParams(c);
        }
        if (this.fvO != null) {
            this.fvO.bg(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fwa != null) {
            this.fwa.bg(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fwb != null) {
            this.fwb.E(c.width, c.height, realScreenOrientation);
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

    private void qd(int i) {
        boolean z = true;
        if (this.aiW != null && this.aiW.mLiveInfo != null) {
            this.fvO.setBgImageUrl(this.aiW.mLiveInfo.cover, this.aiW.mLiveInfo);
            this.fvQ.a(this.mSelectedPosition, brq(), this.aiW);
            this.fvQ.b(this.mSelectedPosition, brr(), this.aiW);
            this.fvO.requestLayout();
            this.fvO.B(i, this.aiW.mLiveInfo.screen_direction == 2);
        }
        if (this.aiW != null) {
            a(this.aiW.mLiveInfo, false);
        }
        boolean bpq = this.fvO.bpq();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.aiW == null || this.aiW.mLiveInfo == null || this.aiW.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!brC()) {
            if (this.fvT != null && this.fvT.getParent() == null) {
                this.fvO.a(this.fvT, null, false);
                if (this.aiW != null && this.aiW.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.isBackGround) {
                        this.fvT.f(this.aiW.mLiveInfo);
                    } else {
                        this.fvT.setPlayLiveInfo(this.aiW.mLiveInfo);
                    }
                }
            }
            if (bpq && !brC() && this.fwb != null) {
                this.fvO.jM(z);
                return;
            }
            return;
        }
        this.fvO.bpk();
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
            this.fay.a(alaLiveInfoData.live_id, true, this.asg, this.mForumName);
            this.fay.cU(alaLiveInfoData.live_id);
        }
    }

    public void qL(int i) {
        short s;
        if (i < 0) {
            this.fay.qr(this.fay.bnZ() - 1);
        } else if (i > 0) {
            this.fay.qr(this.fay.bnZ() + 1);
        }
        if (this.fwb != null) {
            this.fwb.b(this.fvO);
        }
        this.fvQ.a(this.mSelectedPosition, brq(), this.aiW);
        this.fvQ.b(this.mSelectedPosition, brr(), this.aiW);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.fay != null) {
            int bnZ = this.fay.bnZ();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bnZ + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.fay.bnR() != null && this.fay.bnR().size() > bnZ && this.fay.bnR().get(bnZ) != null) {
                AlaLiveInfoData alaLiveInfoData = this.fay.bnR().get(bnZ);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fay != null) {
            AlaLiveInfoData boc = this.fay.boc();
            if (boc != null) {
                boc.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.fvO, boc, this.fvW);
                this.fvW = false;
                if (this.fwb != null) {
                    if (boc.screen_direction != 2) {
                        s = 2;
                    } else {
                        s = 1;
                    }
                    this.fwb.a(this.mTbPageContext, this.faQ, this.fvT, this.fvO, this.fay, this.asg, this.fvX, this.faU, null, this.fwm);
                    this.fwb.c(s);
                }
                a(boc, false);
            }
            g(boc);
            this.fvO.a(this.faQ, null);
            if (this.fwb != null) {
                this.fwb.bhK();
            }
            this.fay.c(boc);
        }
    }

    private AlaLiveInfoData brq() {
        List<AlaLiveInfoData> bnR = this.fay.bnR();
        if (bnR == null || bnR.size() == 0) {
            if (this.aiW == null) {
                return null;
            }
            return this.aiW.mLiveInfo;
        }
        int bnZ = this.fay.bnZ();
        int size = bnR.size();
        return bnR.get(((bnZ + size) - 1) % size);
    }

    private AlaLiveInfoData brr() {
        List<AlaLiveInfoData> bnR = this.fay.bnR();
        if (bnR == null || bnR.size() == 0) {
            if (this.aiW == null) {
                return null;
            }
            return this.aiW.mLiveInfo;
        }
        return bnR.get((this.fay.bnZ() + 1) % bnR.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(int i, String str) {
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
            jY(false);
            return;
        }
        l ww = this.fay.ww();
        t(ww);
        this.fay.bnS();
        if (this.fvW) {
            this.fay.jG(false);
        }
        this.faU = System.currentTimeMillis() / 1000;
        if (this.fwb != null) {
            if (ww.mLiveInfo.screen_direction != 2) {
                s = 2;
            } else {
                s = 1;
            }
            this.fwb.a(this.mTbPageContext, this.faQ, this.fvT, this.fvO, this.fay, this.asg, this.fvX, this.faU, this.fvY, this.fwm);
            this.fwb.c(s);
        }
        bro();
        if (ww != null && ww.mLiveInfo != null && ww.mLiveInfo.live_status == 2) {
            d(ww, false);
            this.fvW = false;
            return;
        }
        if (!this.fwk || !TextUtils.equals(q.yP(), this.fwl)) {
            s.b(getPageContext());
            com.baidu.live.s.c.wW().wX();
            this.fwk = true;
            this.fwl = q.yP();
        }
        this.fwi = false;
        if (this.fay.ww() != null && this.fay.ww().mLiveInfo != null) {
            String str2 = this.fay.ww().mLiveInfo.feed_id;
            long j = this.fay.ww().mLiveInfo.live_id;
            long j2 = this.fay.ww().mLiveInfo.user_id;
            this.fay.cU(j);
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                m.i(j2, j);
            }
            o.g(str2, j);
        }
        if (this.fwb != null) {
            this.fwb.iS(TextUtils.equals(this.fvZ, "1"));
            this.fvZ = "";
        }
        if (this.fvR != null) {
            this.fvR.a(this.aiW, this.fvS);
        }
        a(this.fay.ww());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.mTbPageContext != null && c.this.fay.ww() != null && c.this.fay.ww().mLiveInfo != null) {
                    c.this.fay.a(c.this.fay.ww().mLiveInfo.live_id, c.this.asg, c.this.faU);
                }
            }
        }, this.fay.ww().Wj);
        if (this.fay.ww() != null && this.fay.ww().Wf != null) {
            ao aoVar = com.baidu.live.s.a.wR().atk;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && aoVar != null && aoVar.aaX != null && aoVar.aaX.acy) {
                c(true, this.fay.ww().Wf.userId);
            }
        }
        this.fvW = false;
        if (this.fay.ww() != null && this.fay.ww().mLiveInfo != null && this.fay.ww().Wf != null) {
            long j3 = this.fay.ww().mLiveInfo.live_id;
            long j4 = this.fay.ww().mLiveInfo.room_id;
            String str3 = this.fay.ww().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                com.baidu.tieba.ala.liveroom.yuangift.a.bpM().a(this.mTbPageContext.getPageActivity(), j3, "oneYuanGift_" + j3, j4, str3, this.otherParams);
                if (this.fws != null) {
                    this.fws.a(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
                }
            }
            com.baidu.tieba.ala.guardclub.a.bcK().a(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            if (this.fwj == null) {
                this.fwj = new com.baidu.tieba.ala.liveroom.j.a();
            }
            this.fwj.a(this.mTbPageContext.getPageActivity(), this.fay.ww(), this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brs() {
        if (this.fvU) {
            this.fvQ.a(this.mSelectedPosition, brq(), this.aiW);
            this.fvQ.b(this.mSelectedPosition, brr(), this.aiW);
            this.fvU = false;
        }
        if (this.fwa != null && brC()) {
            this.fwa.S(this.fay.bnT());
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
            this.mHandler.removeCallbacks(this.fwr);
            this.mHandler.postDelayed(this.fwr, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.live.data.g gVar) {
        if (gVar == null) {
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fwq);
                this.mHandler.postDelayed(this.fwq, 5000L);
                return;
            }
            return;
        }
        if (!this.fvV) {
            d(gVar);
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.fwq);
            this.mHandler.postDelayed(this.fwq, gVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brt() {
        if (this.fay.ww() != null && this.fay.ww().mLiveInfo != null) {
            this.fay.cU(this.fay.ww().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(l lVar) {
        if (lVar != null && lVar.mLiveInfo != null && lVar.mLiveInfo.live_status == 2) {
            this.fvQ.a(this.mSelectedPosition, this.fay.ww());
            d(lVar, false);
        } else if (lVar != null) {
            if (!this.fvV) {
                a(lVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fwp);
                this.mHandler.postDelayed(this.fwp, lVar.Wj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bru() {
        if (this.mTbPageContext != null && this.fay.ww() != null && this.fay.ww().mLiveInfo != null) {
            this.fay.a(this.fay.ww().mLiveInfo.live_id, this.asg, this.faU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(l lVar, boolean z) {
        iT(true);
        if (!brC()) {
            this.fay.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            this.fvO.bjX();
            this.fvO.bpk();
            this.fvO.bpr();
            if (lVar != null && lVar.mLiveInfo != null) {
                this.fwd = lVar.mLiveInfo.live_id;
            }
            brl();
            brv();
            brw();
            if (lVar != null) {
                this.fwa.a(lVar, this.asg, this.fay.bnT(), this.mForumName, z);
                this.fwa.a(this.fvO);
                if (this.fwb != null) {
                    this.fwb.iT(false);
                    this.fwb.bhL();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                this.fvO.bpo();
                long j = lVar.mLiveInfo.live_id;
                long j2 = lVar.mLiveInfo.room_id;
                String str = lVar.mLiveInfo.feed_id;
                long j3 = lVar.Wf.userId;
                String str2 = lVar.Wf.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.fwh = new StayTimeBean();
                this.fwh.liveId = lVar.mLiveInfo.live_id;
                this.fwh.roomId = lVar.mLiveInfo.room_id;
                this.fwh.vid = lVar.mLiveInfo.feed_id;
                this.fwh.startTime = System.currentTimeMillis();
            }
            brE();
            if (this.fvR != null) {
                this.fvR.a(this.aiW, this.fvS);
            }
        }
    }

    private void brv() {
    }

    private void brw() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.fvP);
        }
    }

    public void brx() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bry();
        } else {
            brz();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.fay != null && this.fay.ww() != null) {
            alaLiveInfoData = this.fay.ww().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bry();
        } else {
            brz();
        }
        this.fvP.setIsScrollable(!z && this.fwn);
        if (this.fwb != null) {
            this.fwb.onKeyboardVisibilityChanged(z);
        }
        if (this.faQ != null) {
            this.faQ.onKeyboardVisibilityChanged(z);
        }
    }

    public void bN(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bry();
        } else {
            brz();
        }
        this.faQ.bN(realScreenOrientation);
        qd(realScreenOrientation);
        com.baidu.tieba.ala.liveroom.yuangift.a.bpM().rl();
        if (this.fwj != null) {
            this.fwj.rl();
        }
        if (this.fvR != null) {
            this.fvR.bN(realScreenOrientation);
        }
    }

    public void bry() {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.fvP != null) {
            com.baidu.live.utils.h.S(this.fvP);
        }
    }

    public void brz() {
        if (this.fvP != null) {
            com.baidu.live.utils.h.T(this.fvP);
        }
    }

    public void onResume() {
        if (this.fay != null) {
            this.fay.bnF();
        }
        if (this.fwb != null) {
            this.fwb.enterForeground();
        }
        if (this.fwj != null) {
            this.fwj.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.w.a.eF(this.mTbPageContext.getPageActivity()) && this.isBackGround) {
            this.isBackGround = false;
            brA();
        }
    }

    public void brA() {
        bru();
        brt();
        this.fay.bnS();
        this.fvT.brd();
        if (this.fwb != null) {
            this.fwb.bhP();
        }
        if (this.fay != null && this.fay.ww() != null && this.fay.ww().mLiveInfo != null) {
            this.fwg.cX(this.fay.ww().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aiW.mLiveInfo.live_id);
        }
    }

    public void onPause() {
        if (this.fay != null) {
            this.fay.bnG();
        }
        if (this.fwb != null) {
            this.fwb.enterBackground();
        }
    }

    public void onStop() {
        this.isBackGround = true;
        brB();
    }

    public void brB() {
        this.mHandler.removeCallbacks(this.fwp);
        this.mHandler.removeCallbacks(this.fwq);
        this.mHandler.removeCallbacks(this.fwr);
        this.fvT.pausePlay();
        if (this.fwb != null) {
            this.fwb.bhO();
        }
        this.fwg.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            com.baidu.tieba.ala.liveroom.yuangift.a.bpM().a(i, i2, intent, this.aiW, this.otherParams);
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.fwb != null) {
            this.fwb.onActivityResult(i, i2, intent);
        }
    }

    public boolean brC() {
        return this.fwa != null && this.fwa.bcn();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fww != null) {
            MessageManager.getInstance().unRegisterListener(this.fww);
        }
        if (this.fwx != null) {
            MessageManager.getInstance().unRegisterListener(this.fwx);
        }
        MessageManager.getInstance().unRegisterListener(this.fwy);
        MessageManager.getInstance().unRegisterListener(this.fcJ);
        MessageManager.getInstance().unRegisterListener(this.fcI);
        MessageManager.getInstance().unRegisterListener(this.fwz);
        MessageManager.getInstance().unRegisterListener(this.fwA);
        MessageManager.getInstance().unRegisterListener(this.fwB);
        if (this.fws != null) {
            this.fws.release();
        }
        if (this.fvT != null) {
            this.fvT.jX(true);
        }
        if (this.fvR != null) {
            this.fvR.onDestory();
        }
        this.fvS = null;
        if (this.fwb != null) {
            this.fwb.onDestory();
        }
        if (this.fvQ != null) {
            this.fvQ.onDestroy();
        }
        this.fvO.bjX();
        if (this.fvO != null) {
            this.fvO.release();
            this.fvO = null;
        }
        if (this.fwa != null) {
            this.fwa.onDestroy();
            this.fwa = null;
        }
        if (this.fwh != null && this.fay != null && this.fay.ww() != null) {
            long j = this.fay.ww().mLiveInfo.live_id;
            if (this.fwh.liveId == j && this.fwh.startTime > 0) {
                this.fwh.endTime = System.currentTimeMillis();
                long j2 = this.fwh.endTime - this.fwh.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.fwh.roomId + "", this.fwh.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.fwh = null;
        }
        if (this.faQ != null) {
            this.faQ.bpt();
            this.faQ = null;
        }
        if (this.fay != null) {
            this.fay.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        m.yJ();
        com.baidu.live.gift.q.rw().release();
    }

    public String vz() {
        return this.otherParams;
    }

    public void brD() {
        if (this.fwe != null) {
            this.otherParams = this.fwe.toString();
            if (this.fay != null) {
                this.fay.setOtherParams(this.otherParams);
            }
            if (this.fwb != null) {
                this.fwb.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            this.fwa.setOtherParams(this.otherParams);
        }
    }

    public void brE() {
        if (this.fwe != null) {
            String optString = this.fwe.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.fwe.put("tab", "live_jump");
                        this.fwe.put("tag", "");
                        this.fwe.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.fwe.put("tab", "liveroom");
                        this.fwe.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                brD();
            }
        }
    }

    private void c(boolean z, long j) {
        com.baidu.tieba.ala.guardclub.model.d dVar = new com.baidu.tieba.ala.guardclub.model.d();
        if (z) {
            dVar.bde();
        }
        dVar.cz(j);
        dVar.setParams();
        MessageManager.getInstance().sendMessage(dVar);
    }

    public void brF() {
        if (!brH()) {
            if (this.mNetChangedDialog == null) {
                this.mNetChangedDialog = new BdAlertDialog(getPageContext().getPageActivity());
                this.mNetChangedDialog.setCanceledOnTouchOutside(false);
                this.mNetChangedDialog.setMessage(getPageContext().getResources().getString(a.i.ala_create_not_wifi));
                this.mNetChangedDialog.setPositiveButton(getPageContext().getResources().getString(a.i.sdk_liveroom_attention_guide_btn_text), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.c.11
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        c.this.brI();
                        c.this.mNetChangedDialog.dismiss();
                    }
                });
                this.mNetChangedDialog = this.mNetChangedDialog.create(this.mTbPageContext);
                this.mNetChangedDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.player.c.13
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getRepeatCount() == 0) {
                            c.this.brI();
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

    public void brG() {
        if (this.mNetChangedDialog != null) {
            this.mNetChangedDialog.dismiss();
        }
    }

    public boolean brH() {
        return this.mNetChangedDialog != null && this.mNetChangedDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brI() {
        onStart();
        brJ();
    }

    public void brJ() {
        com.baidu.live.gift.b.b.ta().te();
    }
}
