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
    private m alp;
    private String awC;
    private long awD;
    private String ePk;
    private AlaLiveView feO;
    private long feS;
    private com.baidu.tieba.ala.liveroom.m.c fex;
    private c.a ffc;
    private HttpMessageListener fgC;
    private HttpMessageListener fgD;
    private String fzA;
    private aq fzB;
    private boolean fzC;
    private boolean fzD;
    private Runnable fzE;
    private Runnable fzF;
    private Runnable fzG;
    private com.baidu.live.x.c fzH;
    private com.baidu.live.o.b fzI;
    private com.baidu.live.o.a fzJ;
    com.baidu.live.liveroom.a.b fzK;
    ViewPager.OnPageChangeListener fzL;
    HttpMessageListener fzM;
    CustomMessageListener fzN;
    CustomMessageListener fzO;
    CustomMessageListener fzP;
    CustomMessageListener fzQ;
    private CustomMessageListener fzR;
    private a fzc;
    private AlaLiveRoomBlurPageLayout fzd;
    private AlaLoopViewPager fze;
    private AlaLoopViewPagerAdapter fzf;
    private com.baidu.tieba.ala.liveroom.d.a fzg;
    private com.baidu.tieba.ala.liveroom.d.b fzh;
    private SdkLivePlayer fzi;
    private boolean fzj;
    private boolean fzk;
    private boolean fzl;
    private boolean fzm;
    private ArrayList<AlaBroadcastGiftToastData> fzn;
    private String fzo;
    private com.baidu.tieba.ala.endliveroom.a fzp;
    private com.baidu.tieba.ala.liveroom.c.c fzq;
    private String fzr;
    private long fzs;
    private JSONObject fzt;
    private boolean fzu;
    private com.baidu.tieba.ala.liveroom.task.c fzv;
    private StayTimeBean fzw;
    private boolean fzx;
    private com.baidu.tieba.ala.liveroom.i.a fzy;
    private boolean fzz;
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
        this.fzj = true;
        this.feS = 0L;
        this.fzk = false;
        this.fzl = true;
        this.awC = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.fzm = false;
        this.fzo = "0";
        this.mHandler = new Handler();
        this.fzs = -1L;
        this.otherParams = "";
        this.fzu = false;
        this.fzv = com.baidu.tieba.ala.liveroom.task.c.bqE();
        this.fzx = false;
        this.fzz = false;
        this.fzD = false;
        this.fzE = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.btd();
            }
        };
        this.fzF = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.btc();
            }
        };
        this.fzG = new Runnable() { // from class: com.baidu.tieba.ala.player.b.15
            @Override // java.lang.Runnable
            public void run() {
                b.this.fex.bpM();
            }
        };
        this.fzI = new com.baidu.live.o.b() { // from class: com.baidu.tieba.ala.player.b.16
            @Override // com.baidu.live.o.b
            public void bk(int i) {
                if (b.this.fzd != null) {
                    if (ListUtils.getCount(b.this.fzi.getAlaLiveInfoDataList()) < 2) {
                        b.this.fzd.bra();
                    } else {
                        b.this.fzd.brb();
                    }
                }
                if (b.this.fzq != null) {
                    b.this.fzq.bk(i);
                }
                if (BdNetTypeUtil.isMobileNet()) {
                    if (!TbadkCoreApplication.isShownNetChangeDialog.booleanValue() && k.Bh()) {
                        b.this.kd(false);
                        b.this.btn();
                        return;
                    }
                    b.this.btr();
                }
            }
        };
        this.fzJ = new com.baidu.live.o.a() { // from class: com.baidu.tieba.ala.player.b.17
            @Override // com.baidu.live.o.a
            public void bh(boolean z) {
                if (b.this.fzi != null) {
                    if (!z) {
                        b.this.fzi.pausePlay();
                        return;
                    }
                    if (!(BdNetTypeUtil.isMobileNet() && k.Bh())) {
                        b.this.fzi.btt();
                    }
                }
            }
        };
        this.fzK = new com.baidu.live.liveroom.a.b() { // from class: com.baidu.tieba.ala.player.b.20
            @Override // com.baidu.live.liveroom.a.b
            public void bb(boolean z) {
                if (z || b.this.fzq == null || b.this.fzq.bjU()) {
                    b.this.kc(true);
                    b.this.bhi();
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bc(boolean z) {
                b.this.d(b.this.alp, z);
            }

            @Override // com.baidu.live.liveroom.a.b
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.fzi.bts();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.isBackGround) {
                    if (b.this.isBackGround) {
                        b.this.fzi.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.fzi.aa(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void f(boolean z, boolean z2) {
                if (b.this.fze != null) {
                    b.this.fze.setIsScrollable(b.this.fzC && z);
                    b.this.fze.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bd(boolean z) {
                boolean z2 = true;
                if (!z || b.this.btk()) {
                    if (b.this.fzd != null) {
                        b.this.fzd.brd();
                        return;
                    }
                    return;
                }
                if (b.this.fex.yT().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.fzd != null) {
                    b.this.fzd.jQ(z2);
                }
            }
        };
        this.fzL = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.21
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.feO != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.fze.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.fzl || ListUtils.getCount(b.this.fex.bpL()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && b.this.fex.bpO() == 1) {
                            if (!b.this.fex.bpR() || i2 >= 0) {
                                if (b.this.fex.bpS() && i2 > 0) {
                                    b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    b.this.fze.setCurrentItem(b.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                b.this.fze.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        b.this.fex.cancelLoadData();
                        b.this.mHandler.removeCallbacksAndMessages(null);
                        b.this.jb(true);
                        b.this.fzd.bqY();
                        b.this.fzd.blT();
                        b.this.fzd.bqZ();
                        if (b.this.fex.yT() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(b.this.fex.yT().mLiveInfo.live_id + "", b.this.fex.yT().mLiveInfo.room_id + "", b.this.fex.yT().Ya.userId + "", b.this.fex.yT().Ya.userName, System.currentTimeMillis(), b.this.fex.yT().mLiveInfo.feed_id, b.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(b.this.fex.yT().mLiveInfo.live_id + "", b.this.fex.yT().mLiveInfo.room_id + "", b.this.fex.yT().Ya.userId + "", b.this.fex.yT().Ya.userName, System.currentTimeMillis(), b.this.fex.yT().mLiveInfo.feed_id, b.this.otherParams);
                            }
                        }
                        if (b.this.fzw != null) {
                            long j = b.this.fex.yT().mLiveInfo.live_id;
                            if (b.this.fzw.liveId == j && b.this.fzw.startTime > 0) {
                                b.this.fzw.endTime = System.currentTimeMillis();
                                long j2 = b.this.fzw.endTime - b.this.fzw.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.fzw.roomId + "", b.this.fzw.vid, j2 / 1000, b.this.otherParams);
                            }
                            b.this.fzw = null;
                        }
                        b.this.btm();
                        if (b.this.fzH != null) {
                            b.this.fzH.release();
                        }
                        b.this.mSelectedPosition = i;
                        b.this.fzd = b.this.fzf.qh(b.this.mSelectedPosition);
                        b.this.fzd.brc();
                        b.this.qU(i2);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.fze.setCurrentItem(b.this.mSelectedPosition);
                        b.this.fex.d(b.this.fex.bpW());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.pw().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.ffc = new c.a() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.z(b.this.fex.yT());
                } else if (i2 == 2) {
                    b.this.g(b.this.fex.bee());
                } else if (i2 == 3) {
                    b.this.aB(i, str);
                } else if (i2 == 4) {
                    b.this.as(obj);
                } else if (i2 == 5) {
                    b.this.btb();
                }
            }
        };
        this.fzM = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bqC() != null && b.this.mTbPageContext != null) {
                        b.this.fzv.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bqC());
                    }
                }
            }
        };
        this.fzN = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.5
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
        this.fzO = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.fex != null && b.this.fex.yT() != null && b.this.fex.yT().mLiveInfo != null) {
                    long j = b.this.fex.yT().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.fzH != null) {
                        b.this.fzH.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.fgD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.fex.yT().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.awT != null && !eventPollingHttpResponseMessage.awT.isEmpty() && b.this.fex != null && b.this.fex.yT() != null && b.this.fex.yT().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.awT.size()) {
                                break;
                            }
                            af afVar = eventPollingHttpResponseMessage.awT.get(i2);
                            if (j == afVar.liveId && j2 - afVar.createTime <= 60 && !com.baidu.live.utils.m.g(afVar.liveId, afVar.id)) {
                                com.baidu.live.utils.m.a(afVar, b.this.fex.yT().mLiveInfo);
                                com.baidu.live.utils.m.h(afVar.liveId, afVar.id);
                            }
                            i = i2 + 1;
                        }
                        af afVar2 = eventPollingHttpResponseMessage.awT.get(eventPollingHttpResponseMessage.awT.size() - 1);
                        if (j == afVar2.liveId) {
                            com.baidu.live.utils.m.f(afVar2.liveId, afVar2.id);
                        }
                    }
                    int i3 = eventPollingHttpResponseMessage.awS;
                    if (i3 <= 0) {
                        i3 = 5;
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.fex != null && b.this.fex.yT() != null) {
                                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                    com.baidu.live.utils.m.i(b.this.fex.yT().mLiveInfo.user_id, b.this.fex.yT().mLiveInfo.live_id);
                                }
                            }
                        }
                    }, i3 * 1000);
                }
            }
        };
        this.fgC = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h)) {
                        h hVar = (h) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (b.this.fex != null && b.this.fex.yT() != null) {
                            long j = b.this.fex.yT().mLiveInfo.live_id;
                            if (j == hVar.liveId) {
                                getVideoGoodsListHttpResponseMessage.liveId = j;
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                                if (!b.this.fzx) {
                                    b.this.fzx = true;
                                    String str = "goods_task_" + j;
                                    ap apVar = com.baidu.live.v.a.zs().axR;
                                    long j2 = (apVar == null || apVar.adh == null) ? 10L : apVar.adh.aeP;
                                    if (j2 <= 0) {
                                        j2 = 10;
                                    }
                                    LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.b.8.1
                                        @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                        public void onComplete(boolean z) {
                                            if (b.this.fex != null && b.this.fex.yT() != null && b.this.fex.yT().mLiveInfo.live_id != o.aEf) {
                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, b.this.fex.yT().mLiveInfo));
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
        this.fzP = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.fex != null && b.this.fex.yT() != null && b.this.fex.yT().Yo != null) {
                        if (l.longValue() == b.this.fex.yT().Yo.userId) {
                            b.this.fex.yT().Yo.isNewUser = false;
                            if (b.this.fzy != null) {
                                b.this.fzy.s(b.this.fex.yT());
                            }
                        }
                    }
                }
            }
        };
        this.fzQ = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.q.a)) {
                    com.baidu.tieba.ala.liveroom.q.a aVar2 = (com.baidu.tieba.ala.liveroom.q.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String aXY = aVar2.aXY();
                    if (b.this.mTbPageContext != null && b.this.fex != null && b.this.fex.yT() != null && b.this.fex.yT().Yo != null) {
                        if (valueOf.longValue() == b.this.fex.yT().Yo.userId && com.baidu.live.v.a.zs().axR != null && com.baidu.live.v.a.zs().axR.ada != null && com.baidu.live.v.a.zs().axR.ada.qO()) {
                            g.qa(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, aXY));
                        }
                    }
                }
            }
        };
        this.fzR = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.fzE != null) {
                    b.this.mHandler.removeCallbacks(b.this.fzE);
                }
                b.this.btd();
            }
        };
        this.feS = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.fzc = aVar;
        this.fzj = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
        if (runTask != null) {
            this.fzH = (com.baidu.live.x.c) runTask.getData();
        }
        this.fex = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.fex.a(this.ffc);
        this.fzp = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.fzM);
        MessageManager.getInstance().registerListener(this.fzN);
        MessageManager.getInstance().registerListener(this.fzO);
        MessageManager.getInstance().registerListener(this.fgD);
        MessageManager.getInstance().registerListener(this.fgC);
        MessageManager.getInstance().registerListener(this.fzP);
        MessageManager.getInstance().registerListener(this.fzQ);
        MessageManager.getInstance().registerListener(this.fzR);
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.fzn = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.fzn.add(alaBroadcastGiftToastData);
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
        this.awC = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.awC)) {
            this.awC = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.mUserName = intent.getStringExtra("user_name");
        this.fzr = intent.getStringExtra("room_id");
        this.awD = intent.getLongExtra("live_id", 0L);
        this.fzu = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.fex.b((AlaLiveInfoCoreData) serializableExtra);
            this.fzu = true;
        }
        ah(intent);
        this.fzC = this.fzB == null || !this.fzB.adq;
        this.fzp.setOtherParams(this.otherParams);
        this.fzm = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bsP();
        bsO();
    }

    private void ah(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.ePk = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.fzt = new JSONObject(stringExtra);
                if (this.fzt != null) {
                    String optString = this.fzt.optString("enterRoomId");
                    String optString2 = this.fzt.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.fzr, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.awD + "", optString2))) {
                        String optString3 = this.fzt.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.fzt.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.fzu) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.awD;
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString4, alaLiveInfoCoreData);
                            this.fex.b(alaLiveInfoCoreData);
                            this.fzu = true;
                        }
                    }
                    String optString5 = this.fzt.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.fzB = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.ePk = jSONObject.optString("live_back_scheme");
                        this.fzB = new aq();
                        this.fzB.adq = jSONObject.optInt("is_hot") == 1;
                        if (this.fzB.adq) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.fzB.adr = jSONObject.optString("task_id");
                        this.fzB.adp = !TextUtils.isEmpty(this.fzB.adr);
                        this.fzB.ads = jSONObject.optInt("task_type");
                        this.fzB.adt = jSONObject.optInt("task_im_count");
                        this.fzB.adu = jSONObject.optLong("task_gift_total_price");
                        this.fzB.adv = jSONObject.optLong("task_watch_time");
                        this.fzB.adw = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                        String optString6 = jSONObject.optString("back_app_scheme");
                        String optString7 = jSONObject.optString("back_app_icon");
                        String optString8 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            this.fzh = new com.baidu.tieba.ala.liveroom.d.b();
                            this.fzh.setScheme(optString6);
                            this.fzh.setImageUrl(optString7);
                            this.fzh.setTitle(optString8);
                        }
                    }
                    this.fzo = this.fzt.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fzt.remove("cover");
                    this.fzt.remove("live_url");
                    this.fzt.remove("enterRoomId");
                    this.fzt.remove("enterLiveId");
                    this.fzt.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.fzt.remove("extra");
                    this.otherParams = this.fzt.toString();
                    this.fex.setOtherParams(this.otherParams);
                    this.fzt.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.fzt.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.fzt.optString("source");
                    }
                    this.fzD = "mobilebaidu_subscription".equals(str);
                    int optInt = this.fzt.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.fex.qz(optInt);
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

    public void bsO() {
        if (!TextUtils.isEmpty(this.mUserName)) {
            this.fex.ac(this.mUserName, this.awC, this.mForumName);
        } else if (this.fex.yT() != null && this.fex.yT().mLiveInfo != null && this.fex.yT().mLiveInfo.live_id > 0) {
            this.fex.a(this.fex.yT().mLiveInfo.live_id, false, this.awC, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uname=")) {
                this.mUserName = WebviewHelper.getMatchStringFromURL(lowerCase, "uname=");
            }
            if (lowerCase.contains("from=")) {
                this.awC = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.mUserName == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                kc(false);
                return;
            }
            this.fex.ac(this.mUserName, this.awC, this.mForumName);
        } else if (!TextUtils.isEmpty(this.fzr)) {
            this.fex.zk(this.fzr);
        } else if (this.awD > 0) {
            this.fex.a(this.awD, false, this.awC, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            kc(false);
        }
    }

    private void bsP() {
        this.fzl = true;
        this.fzk = false;
        bsQ();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        this.fzq = new com.baidu.tieba.ala.liveroom.c.c();
        this.fzq.a(this.fzK);
        this.fzq.setOtherParams(this.otherParams);
        this.fzq.iW(this.fzD);
        bsS();
        bsT();
        bsR();
    }

    private void bsQ() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.fze = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.fze.setOnPageChangeListener(this.fzL);
        this.fze.setBoundaryCaching(true);
        this.fze.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.fzf = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.fzf.bno();
        this.fzd = this.fzf.qg(this.mSelectedPosition);
        this.fzf.a(this.mSelectedPosition, this.fex.yT());
        this.fze.setAdapter(this.fzf);
        this.fze.setCurrentItem(this.mSelectedPosition);
        this.fze.setIsScrollable(this.fzC);
    }

    private void c(Rect rect) {
        this.fzi = SdkLivePlayer.eJ(getPageContext().getPageActivity());
        if (this.fzi == null) {
            this.fze.setIsScrollable(false);
            if (this.fex != null) {
                this.fex.cancelLoadData();
            }
            bnr();
            return;
        }
        if (this.fzm) {
            this.fze.setIsScrollable(false);
        }
        this.fzi.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.fzi.setIPlayerCallBack(this.fzI);
        this.fzi.setIPlayerAudioFocusCallBack(this.fzJ);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fzd.a(this.fzi, layoutParams, true);
    }

    private void bsR() {
        this.fzg = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext);
    }

    private void bnr() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.kc(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.feO = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.feO.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.fzd.a(this.feO, layoutParams);
    }

    private void bsS() {
        if (this.fex != null && this.fex.yT() != null) {
            this.alp = this.fex.yT();
            if (this.alp.mLiveInfo != null) {
                a(this.alp.mLiveInfo, this.fzu);
                if (this.alp.mLiveInfo != null && this.alp.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.isBackGround);
                    }
                    if (!this.isBackGround) {
                        this.fzi.g(this.alp.mLiveInfo);
                    } else {
                        this.fzi.setPlayLiveInfo(this.alp.mLiveInfo);
                    }
                    if (this.fzq != null) {
                        this.fzq.a(this.mTbPageContext, this.feO, this.fzi, this.fzd, this.fex, this.awC, this.fzm, this.feS, this.fzn, this.fzB);
                        j(this.alp.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private void bsT() {
        this.mTbPageContext.registerListener(new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_RES_ZIP_DOWNLOADED_STATUS) { // from class: com.baidu.tieba.ala.player.b.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    Log.i("AlaLiveViewController", "@@ initShareInterface.onMessage liveOwnerUid = " + longValue);
                    if (b.this.alp != null && b.this.alp.Ya != null && b.this.alp.Ya.userId == longValue) {
                        Log.i("AlaLiveViewController", "@@ initShareInterface live_id = " + b.this.alp.mLiveInfo.live_id);
                        b.this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.player.b.19.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HttpMessage httpMessage = new HttpMessage(1021045);
                                httpMessage.addParam("live_id", b.this.alp.mLiveInfo.live_id);
                                MessageManager.getInstance().sendMessage(httpMessage);
                            }
                        });
                    }
                }
            }
        });
    }

    private void bsU() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.fzm || !this.fzC) {
                this.fze.setIsScrollable(false);
            } else {
                this.fze.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && ((this.fzq == null || !this.fzq.onKeyDown(i, keyEvent)) && (this.fzq == null || !this.fzq.bjT()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bsU();
            } else if (this.fzq == null || this.fzq.bjU()) {
                kc(true);
                bhi();
            }
        }
        return true;
    }

    public void bhi() {
        if (!TextUtils.isEmpty(this.ePk)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.ePk);
                this.ePk = null;
            }
        }
    }

    public void kc(boolean z) {
        H(z, false);
    }

    public void H(boolean z, boolean z2) {
        jb(!z);
        if (this.fzi != null) {
            this.fzi.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        bsW();
        long j = -1;
        if (this.fex != null && this.fex.bpW() != null) {
            j = this.fex.bpW().room_id;
        }
        this.fzc.a(z, z2, j);
    }

    public void jb(boolean z) {
        AlaLiveInfoData bpW;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        if (aa.sT() != null) {
            aa.sT().sS();
        }
        if (this.fzH != null) {
            this.fzH.release();
        }
        if (this.fzy != null) {
            this.fzy.release();
        }
        this.fzB = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.fex != null && (bpW = this.fex.bpW()) != null) {
            this.fex.cY(bpW.live_id);
        }
        this.fzv.stopRecord();
        LiveTimerManager.getInstance().stop();
        bsV();
        if (this.fzi != null) {
            this.fzi.kf(z);
        }
        if (this.fzq != null) {
            this.fzq.jb(z);
        }
        this.fzx = false;
        o.aEf = 0L;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
    }

    private void bsV() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bsW() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(m mVar) {
        if (mVar != null) {
            this.alp = mVar;
            if (this.fzq != null) {
                this.fzq.a(mVar);
            }
        }
    }

    private void d(com.baidu.live.data.h hVar) {
        if (this.fzq != null) {
            this.fzq.d(hVar);
        }
    }

    private void y(m mVar) {
        this.alp = mVar;
    }

    private void bsX() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.fze.setIsScrollable(false);
            this.fzC = false;
        }
        if (this.alp != null) {
            a(this.alp.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.fzd.a(this.feO, null);
            a(this.fzd, this.alp.mLiveInfo, this.fzl);
            this.fzl = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.fex != null && this.fex.yT() != null && this.fex.yT().mLiveInfo != null) {
                    j = this.fex.yT().mLiveInfo.live_id;
                    str2 = this.fex.yT().mLiveInfo.room_id + "";
                    str = this.fex.yT().mLiveInfo.feed_id;
                } else {
                    if (this.awD > 0) {
                        j2 = this.awD;
                    }
                    if (!TextUtils.isEmpty(this.fzr)) {
                        j = j2;
                        str = "";
                        str2 = this.fzr;
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
                if (this.fex != null && this.fex.yT() != null && this.fex.yT().mLiveInfo != null) {
                    str3 = this.fex.yT().mLiveInfo.feed_id;
                    str4 = this.fex.yT().mLiveInfo.live_id + "";
                    str5 = this.fex.yT().mLiveInfo.room_id + "";
                    str6 = this.fex.yT().mLiveInfo.user_name;
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
        if (this.fzi != null && this.fzi.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.fzi.getVideoPath();
                String b = com.baidu.live.o.h.b(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.fzi.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + b);
                }
                if (!com.baidu.live.o.h.ah(videoPath, b)) {
                    if (!TbadkCoreApplication.getInst().isTieba() || !z || !com.baidu.live.o.h.ag(videoPath, b)) {
                        if (!z && !alaLiveRoomBlurPageLayout.bC(this.fzi)) {
                            ((ViewGroup) this.fzi.getParent()).removeView(this.fzi);
                            alaLiveRoomBlurPageLayout.a(this.fzi, null, false);
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                        }
                        if (!this.isBackGround) {
                            this.fzi.g(alaLiveInfoData);
                            return;
                        } else {
                            this.fzi.setPlayLiveInfo(alaLiveInfoData);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.fzi.bts();
        } else if (this.fzi != null && this.fzi.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.fzi, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.isBackGround) {
                    this.fzi.g(alaLiveInfoData);
                } else {
                    this.fzi.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.fzi != null) {
            this.fzi.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.v(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.w(this.mTbPageContext.getPageActivity());
                int aN = p.aN(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = aN + i;
                } else {
                    dimensionPixelSize = aN + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void bsY() {
        this.fzl = true;
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
                this.fzd.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.fzd.setBackgroundColor(0);
            }
        } else {
            this.fzd.setBackgroundColor(0);
        }
        int i2 = this.fzi.getLayoutParams().width;
        int i3 = this.fzi.getLayoutParams().height;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.feO != null) {
            this.feO.setLayoutParams(c);
        }
        if (this.fzd != null) {
            this.fzd.bh(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fzp != null) {
            this.fzp.bh(screenFullSize[0], screenFullSize[1]);
        }
        if (this.fzq != null) {
            this.fzq.j(c.width, c.height, realScreenOrientation);
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

    private void qn(int i) {
        boolean z = true;
        if (this.alp != null && this.alp.mLiveInfo != null) {
            this.fzd.setBgImageUrl(this.alp.mLiveInfo.cover, this.alp.mLiveInfo);
            this.fzf.a(this.mSelectedPosition, bsZ(), this.alp);
            this.fzf.b(this.mSelectedPosition, bta(), this.alp);
            this.fzd.requestLayout();
            this.fzd.A(i, this.alp.mLiveInfo.screen_direction == 2);
        }
        if (this.alp != null) {
            a(this.alp.mLiveInfo, false);
        }
        boolean bre = this.fzd.bre();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.alp == null || this.alp.mLiveInfo == null || this.alp.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!btk()) {
            if (this.fzi != null && this.fzi.getParent() == null) {
                this.fzd.a(this.fzi, null, false);
                if (this.alp != null && this.alp.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.isBackGround) {
                        this.fzi.g(this.alp.mLiveInfo);
                    } else {
                        this.fzi.setPlayLiveInfo(this.alp.mLiveInfo);
                    }
                }
            }
            if (bre && !btk() && this.fzq != null) {
                this.fzd.jQ(z);
                return;
            }
            return;
        }
        this.fzd.bqY();
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
            this.fex.a(alaLiveInfoData.live_id, true, this.awC, this.mForumName);
            this.fex.cX(alaLiveInfoData.live_id);
        }
    }

    public void qU(int i) {
        if (i < 0) {
            this.fex.qA(this.fex.bpT() - 1);
        } else if (i > 0) {
            this.fex.qA(this.fex.bpT() + 1);
        }
        if (this.fzq != null) {
            this.fzq.a(this.fzd);
        }
        this.fzf.a(this.mSelectedPosition, bsZ(), this.alp);
        this.fzf.b(this.mSelectedPosition, bta(), this.alp);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.fex != null) {
            int bpT = this.fex.bpT();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bpT + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.fex.bpL() != null && this.fex.bpL().size() > bpT && this.fex.bpL().get(bpT) != null) {
                AlaLiveInfoData alaLiveInfoData = this.fex.bpL().get(bpT);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fex != null) {
            AlaLiveInfoData bpW = this.fex.bpW();
            if (bpW != null) {
                bpW.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.fzd, bpW, this.fzl);
                this.fzl = false;
                if (this.fzq != null) {
                    this.fzq.a(this.mTbPageContext, this.feO, this.fzi, this.fzd, this.fex, this.awC, this.fzm, this.feS, null, this.fzB);
                    short s = 2;
                    if (bpW.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bpW, false);
            }
            f(bpW);
            this.fzd.a(this.feO, null);
            if (this.fzq != null) {
                this.fzq.bjR();
            }
            this.fex.d(bpW);
        }
    }

    private AlaLiveInfoData bsZ() {
        List<AlaLiveInfoData> bpL = this.fex.bpL();
        if (bpL == null || bpL.size() == 0) {
            if (this.alp == null) {
                return null;
            }
            return this.alp.mLiveInfo;
        }
        int bpT = this.fex.bpT();
        int size = bpL.size();
        return bpL.get(((bpT + size) - 1) % size);
    }

    private AlaLiveInfoData bta() {
        List<AlaLiveInfoData> bpL = this.fex.bpL();
        if (bpL == null || bpL.size() == 0) {
            if (this.alp == null) {
                return null;
            }
            return this.alp.mLiveInfo;
        }
        return bpL.get((this.fex.bpT() + 1) % bpL.size());
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
            kc(false);
            return;
        }
        m yT = this.fex.yT();
        y(yT);
        this.fex.bpM();
        if (this.fzl) {
            this.fex.jK(false);
        }
        this.feS = System.currentTimeMillis() / 1000;
        if (this.fzq != null) {
            this.fzq.a(this.mTbPageContext, this.feO, this.fzi, this.fzd, this.fex, this.awC, this.fzm, this.feS, this.fzn, this.fzB);
            short s = 2;
            if (yT.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bsX();
        if (yT != null && yT.mLiveInfo != null && yT.mLiveInfo.live_status == 2) {
            this.fzf.a(this.mSelectedPosition, this.fex.yT());
            d(yT, false);
            this.fzl = false;
            return;
        }
        boolean z = (this.fzq == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.fzz || !TextUtils.equals(q.Bo(), this.fzA))) {
            t.b(getPageContext());
            com.baidu.live.v.c.zx().zy();
            this.fzz = true;
            this.fzA = q.Bo();
        }
        this.fzx = false;
        if (this.fex.yT() != null && this.fex.yT().mLiveInfo != null) {
            String str2 = this.fex.yT().mLiveInfo.feed_id;
            long j = this.fex.yT().mLiveInfo.live_id;
            long j2 = this.fex.yT().mLiveInfo.user_id;
            this.fex.cX(j);
            if (z) {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                    com.baidu.live.utils.m.i(j2, j);
                }
                o.g(str2, j);
            }
        }
        if (this.fzq != null) {
            this.fzq.ja(TextUtils.equals(this.fzo, "1"));
            this.fzo = "";
        }
        if (this.fzg != null) {
            this.fzg.a(this.alp, this.fzh);
        }
        a(this.fex.yT());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.fex.yT() != null && b.this.fex.yT().mLiveInfo != null) {
                    b.this.fex.a(b.this.fex.yT().mLiveInfo.live_id, b.this.awC, b.this.feS);
                }
            }
        }, this.fex.yT().Ye);
        if (z && this.fex.yT() != null && this.fex.yT().Ya != null) {
            ap apVar = com.baidu.live.v.a.zs().axR;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && apVar != null && apVar.adg != null && apVar.adg.aeJ) {
                c(true, this.fex.yT().Ya.userId);
            }
        }
        this.fzl = false;
        if (z && this.fex.yT() != null && this.fex.yT().mLiveInfo != null && this.fex.yT().Ya != null && this.fzq != null) {
            long j3 = this.fex.yT().mLiveInfo.live_id;
            long j4 = this.fex.yT().mLiveInfo.room_id;
            String str3 = this.fex.yT().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j3;
                if (aa.sT() != null) {
                    aa.sT().a(this.mTbPageContext.getPageActivity(), j3, str4, j4, str3, this.otherParams);
                }
                if (this.fzH != null) {
                    this.fzH.b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
                }
            }
            if (e.vL() != null) {
                e.vL().b(this.mTbPageContext.getPageActivity(), j3, j4, str3, this.otherParams);
            }
            if (this.fzy == null) {
                this.fzy = new com.baidu.tieba.ala.liveroom.i.a();
            }
            this.fzy.a(this.mTbPageContext.getPageActivity(), this.fex.yT(), this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btb() {
        if (this.fzj) {
            this.fzf.a(this.mSelectedPosition, bsZ(), this.alp);
            this.fzf.b(this.mSelectedPosition, bta(), this.alp);
            this.fzj = false;
        }
        if (this.fzp != null && btk()) {
            this.fzp.U(this.fex.bpN());
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
            this.mHandler.removeCallbacks(this.fzG);
            this.mHandler.postDelayed(this.fzG, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.live.data.h hVar) {
        if (hVar == null) {
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fzF);
                this.mHandler.postDelayed(this.fzF, 5000L);
                return;
            }
            return;
        }
        if (!this.fzk) {
            d(hVar);
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.fzF);
            this.mHandler.postDelayed(this.fzF, hVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btc() {
        if (this.fex.yT() != null && this.fex.yT().mLiveInfo != null) {
            this.fex.cX(this.fex.yT().mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.live_status == 2) {
            this.fzf.a(this.mSelectedPosition, this.fex.yT());
            d(mVar, false);
        } else if (mVar != null) {
            if (!this.fzk) {
                a(mVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.fzE);
                this.mHandler.postDelayed(this.fzE, mVar.Ye);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btd() {
        if (this.mTbPageContext != null && this.fex.yT() != null && this.fex.yT().mLiveInfo != null) {
            this.fex.a(this.fex.yT().mLiveInfo.live_id, this.awC, this.feS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar, boolean z) {
        View view = null;
        jb(true);
        if (!btk()) {
            this.fex.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            this.fzd.blT();
            this.fzd.bqY();
            this.fzd.brf();
            if (mVar != null && mVar.mLiveInfo != null) {
                this.fzs = mVar.mLiveInfo.live_id;
            }
            bsU();
            bte();
            btf();
            if (mVar != null) {
                if (this.fzq != null && this.fzq.bjX() != null) {
                    view = this.fzq.bjX().a(this.fzq.bjO().pageContext.getPageActivity(), mVar, z);
                }
                this.fzp.a(this.fzd, view, mVar, z, this.fex.bpN());
                if (this.fzq != null) {
                    this.fzq.jb(false);
                    this.fzq.bjS();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                this.fzd.brc();
                long j = mVar.mLiveInfo.live_id;
                long j2 = mVar.mLiveInfo.room_id;
                String str = mVar.mLiveInfo.feed_id;
                long j3 = mVar.Ya.userId;
                String str2 = mVar.Ya.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.fzw = new StayTimeBean();
                this.fzw.liveId = mVar.mLiveInfo.live_id;
                this.fzw.roomId = mVar.mLiveInfo.room_id;
                this.fzw.vid = mVar.mLiveInfo.feed_id;
                this.fzw.startTime = System.currentTimeMillis();
            }
            btm();
            if (this.fzg != null) {
                this.fzg.a(this.alp, this.fzh);
            }
        }
    }

    private void bte() {
    }

    private void btf() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.fze);
        }
    }

    public void btg() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bth();
        } else {
            bti();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.fex != null && this.fex.yT() != null) {
            alaLiveInfoData = this.fex.yT().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bth();
        } else {
            bti();
        }
        this.fze.setIsScrollable(!z && this.fzC);
        if (this.fzq != null) {
            this.fzq.onKeyboardVisibilityChanged(z);
        }
        if (this.feO != null) {
            this.feO.onKeyboardVisibilityChanged(z);
        }
    }

    public void bW(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bth();
        } else {
            bti();
        }
        this.feO.bW(realScreenOrientation);
        qn(realScreenOrientation);
        if (aa.sT() != null) {
            aa.sT().sr();
        }
        if (this.fzy != null) {
            this.fzy.sr();
        }
        if (this.fzg != null) {
            this.fzg.bW(realScreenOrientation);
        }
    }

    public void bth() {
        if (UtilHelper.canUseStyleImmersiveSticky() && this.fze != null) {
            com.baidu.live.utils.h.S(this.fze);
        }
    }

    public void bti() {
        if (this.fze != null) {
            com.baidu.live.utils.h.T(this.fze);
        }
    }

    public void onResume() {
        if (this.fex != null) {
            this.fex.bpx();
            this.fex.bpA();
        }
        if (this.fzq != null) {
            this.fzq.enterForeground();
        }
        if (this.fzy != null) {
            this.fzy.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.t.a.eH(this.mTbPageContext.getPageActivity()) && this.isBackGround) {
            this.isBackGround = false;
            btj();
        }
    }

    public void btj() {
        btd();
        btc();
        this.fex.bpM();
        this.fzi.btt();
        if (this.fzq != null) {
            this.fzq.bjW();
        }
        if (this.fex != null && this.fex.yT() != null && this.fex.yT().mLiveInfo != null) {
            this.fzv.da(this.fex.yT().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.alp.mLiveInfo.live_id);
        }
    }

    public void onPause() {
        if (this.fex != null) {
            this.fex.bpy();
            this.fex.bpB();
        }
        if (this.fzq != null) {
            this.fzq.enterBackground();
        }
    }

    public void kd(boolean z) {
        this.isBackGround = true;
        ke(z);
    }

    public void ke(boolean z) {
        this.mHandler.removeCallbacks(this.fzE);
        this.mHandler.removeCallbacks(this.fzF);
        this.mHandler.removeCallbacks(this.fzG);
        if (!z) {
            this.fzi.pausePlay();
        }
        if (this.fzq != null) {
            this.fzq.bjV();
        }
        this.fzv.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (aa.sT() != null) {
                aa.sT().a(i, i2, intent, this.alp, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.fzq != null) {
            this.fzq.onActivityResult(i, i2, intent);
        }
    }

    public boolean btk() {
        return this.fzp != null && this.fzp.beK();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fzM != null) {
            MessageManager.getInstance().unRegisterListener(this.fzM);
        }
        if (this.fzN != null) {
            MessageManager.getInstance().unRegisterListener(this.fzN);
        }
        MessageManager.getInstance().unRegisterListener(this.fzO);
        MessageManager.getInstance().unRegisterListener(this.fgD);
        MessageManager.getInstance().unRegisterListener(this.fgC);
        MessageManager.getInstance().unRegisterListener(this.fzP);
        MessageManager.getInstance().unRegisterListener(this.fzQ);
        MessageManager.getInstance().unRegisterListener(this.fzR);
        if (this.fzH != null) {
            this.fzH.release();
        }
        if (this.fzi != null) {
            this.fzi.kf(true);
        }
        if (this.fzg != null) {
            this.fzg.onDestory();
        }
        this.fzh = null;
        if (this.fzq != null) {
            this.fzq.onDestroy();
        }
        if (this.fzf != null) {
            this.fzf.onDestroy();
        }
        this.fzd.blT();
        if (this.fzd != null) {
            this.fzd.release();
            this.fzd = null;
        }
        if (this.fzp != null) {
            this.fzp.onDestroy();
            this.fzp = null;
        }
        if (this.fzw != null && this.fex != null && this.fex.yT() != null) {
            long j = this.fex.yT().mLiveInfo.live_id;
            if (this.fzw.liveId == j && this.fzw.startTime > 0) {
                this.fzw.endTime = System.currentTimeMillis();
                long j2 = this.fzw.endTime - this.fzw.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.fzw.roomId + "", this.fzw.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.fzw = null;
        }
        if (this.feO != null) {
            this.feO.brh();
            this.feO = null;
        }
        if (this.fex != null) {
            this.fex.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        com.baidu.live.utils.m.Bj();
        r.sC().release();
    }

    public String xC() {
        return this.otherParams;
    }

    public void btl() {
        if (this.fzt != null) {
            this.otherParams = this.fzt.toString();
            if (this.fex != null) {
                this.fex.setOtherParams(this.otherParams);
            }
            if (this.fzq != null) {
                this.fzq.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            this.fzp.setOtherParams(this.otherParams);
        }
    }

    public void btm() {
        if (this.fzt != null) {
            String optString = this.fzt.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.fzt.put("tab", "live_jump");
                        this.fzt.put("tag", "");
                        this.fzt.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.fzt.put("tab", "liveroom");
                        this.fzt.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                btl();
            }
        }
    }

    private void c(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.vJ();
        }
        bVar.D(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void btn() {
        if (!btp()) {
            if (this.mNetChangedDialog == null) {
                this.mNetChangedDialog = new BdAlertDialog(getPageContext().getPageActivity());
                this.mNetChangedDialog.setCanceledOnTouchOutside(false);
                this.mNetChangedDialog.setMessage(getPageContext().getResources().getString(a.i.ala_create_not_wifi));
                this.mNetChangedDialog.setPositiveButton(getPageContext().getResources().getString(a.i.sdk_liveroom_attention_guide_btn_text), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.13
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog) {
                        b.this.btq();
                        b.this.mNetChangedDialog.dismiss();
                    }
                });
                this.mNetChangedDialog = this.mNetChangedDialog.create(this.mTbPageContext);
                this.mNetChangedDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.player.b.14
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i == 4 && keyEvent.getRepeatCount() == 0) {
                            b.this.btq();
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

    public void bto() {
        if (this.mNetChangedDialog != null) {
            this.mNetChangedDialog.dismiss();
        }
    }

    public boolean btp() {
        return this.mNetChangedDialog != null && this.mNetChangedDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btq() {
        onStart();
        btr();
    }

    public void btr() {
        t.sO();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fzq.d(s);
        } else {
            this.fzq.e(s);
        }
    }
}
