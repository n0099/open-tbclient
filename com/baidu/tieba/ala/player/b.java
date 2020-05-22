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
import com.baidu.live.data.am;
import com.baidu.live.data.ax;
import com.baidu.live.data.ay;
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.t;
import com.baidu.live.gift.v;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.u.a;
import com.baidu.live.utils.m;
import com.baidu.live.utils.o;
import com.baidu.live.utils.p;
import com.baidu.tieba.ala.liveroom.h.g;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.ala.liveroom.m.c;
import com.baidu.tieba.ala.liveroom.task.ActivityTaskWatchHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveRoomBlurPageLayout;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.baidu.webkit.internal.ETAG;
import com.compatible.menukey.MenuKeyUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.PushMessageHelper;
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
    private q aJj;
    private String aWu;
    private long aWv;
    private com.baidu.live.o.b bgd;
    private String fHG;
    private com.baidu.tieba.ala.liveroom.m.c fWI;
    private boolean fWP;
    private AlaLiveView fWZ;
    private long fXd;
    private c.a fXn;
    private Runnable fYO;
    private HttpMessageListener fYS;
    private HttpMessageListener fYT;
    private int fYx;
    private a gsD;
    private AlaLiveRoomBlurPageLayout gsE;
    private AlaLoopViewPager gsF;
    private AlaLoopViewPagerAdapter gsG;
    private com.baidu.tieba.ala.liveroom.d.a gsH;
    private com.baidu.tieba.ala.liveroom.d.b gsI;
    private SdkLivePlayer gsJ;
    private boolean gsK;
    private boolean gsL;
    private boolean gsM;
    private ArrayList<AlaBroadcastGiftToastData> gsN;
    private String gsO;
    private com.baidu.tieba.ala.endliveroom.a gsP;
    private com.baidu.tieba.ala.liveroom.c.c gsQ;
    private String gsR;
    private long gsS;
    private JSONObject gsT;
    private boolean gsU;
    private com.baidu.tieba.ala.liveroom.task.c gsV;
    private StayTimeBean gsW;
    private boolean gsX;
    private boolean gsY;
    private com.baidu.tieba.ala.liveroom.i.a gsZ;
    private com.baidu.tieba.ala.liveroom.t.b gta;
    private boolean gtb;
    private boolean gtc;
    private String gtd;
    private boolean gte;
    private ay gtf;
    private boolean gtg;
    private boolean gth;
    private Runnable gti;
    private Runnable gtj;
    private Runnable gtk;
    private com.baidu.live.x.c gtl;
    private com.baidu.live.o.a gtm;
    com.baidu.live.liveroom.a.b gtn;
    ViewPager.OnPageChangeListener gto;
    HttpMessageListener gtp;
    CustomMessageListener gtq;
    CustomMessageListener gtr;
    CustomMessageListener gts;
    CustomMessageListener gtt;
    private CustomMessageListener gtu;
    private boolean isBackGround;
    private String mForumName;
    private Handler mHandler;
    private int mSelectedPosition;
    private TbPageContext mTbPageContext;
    private String mUrl;
    private String otherParams;
    private String uk;

    public b(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.mSelectedPosition = 1;
        this.gsK = true;
        this.fXd = 0L;
        this.gsL = false;
        this.fWP = true;
        this.aWu = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.gsM = false;
        this.gsO = "0";
        this.mHandler = new Handler();
        this.gsS = -1L;
        this.otherParams = "";
        this.gsU = false;
        this.gsV = com.baidu.tieba.ala.liveroom.task.c.bGo();
        this.gsX = false;
        this.gsY = false;
        this.gtc = false;
        this.gte = false;
        this.gth = false;
        this.gti = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bJe();
            }
        };
        this.gtj = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.bJd();
            }
        };
        this.gtk = new Runnable() { // from class: com.baidu.tieba.ala.player.b.13
            @Override // java.lang.Runnable
            public void run() {
                b.this.fWI.bFl();
            }
        };
        this.fYx = 5000;
        this.bgd = new com.baidu.live.o.b() { // from class: com.baidu.tieba.ala.player.b.14
            @Override // com.baidu.live.o.b
            public void bE(int i) {
                if (b.this.gsE != null) {
                    if (ListUtils.getCount(b.this.gsJ.getAlaLiveInfoDataList()) < 2) {
                        b.this.gsE.bGN();
                    } else {
                        b.this.gsE.bGO();
                    }
                }
                if (b.this.gsQ != null) {
                    b.this.gsQ.bE(i);
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.bJo();
                }
            }
        };
        this.gtm = new com.baidu.live.o.a() { // from class: com.baidu.tieba.ala.player.b.15
            @Override // com.baidu.live.o.a
            public void bV(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && b.this.gsJ != null) {
                    if (z) {
                        if (!b.this.gsJ.isPlaying()) {
                            b.this.gsJ.bJq();
                        }
                    } else if (b.this.gsJ.isPlaying()) {
                        b.this.gsJ.avT();
                    }
                }
            }
        };
        this.gtn = new com.baidu.live.liveroom.a.b() { // from class: com.baidu.tieba.ala.player.b.17
            @Override // com.baidu.live.liveroom.a.b
            public void bO(boolean z) {
                if (z || b.this.gsQ == null || b.this.gsQ.bzl()) {
                    b.this.lC(true);
                    b.this.bwp();
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bP(boolean z) {
                b.this.d(b.this.aJj, z);
            }

            @Override // com.baidu.live.liveroom.a.b
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.gsJ.bJp();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.isBackGround) {
                    if (b.this.isBackGround) {
                        b.this.gsJ.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.gsJ.ab(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void e(boolean z, boolean z2) {
                if (b.this.gsF != null) {
                    b.this.gsF.setIsScrollable(b.this.gtg && z);
                    b.this.gsF.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bQ(boolean z) {
                boolean z2 = true;
                if (!z || b.this.bJl()) {
                    if (b.this.gsE != null) {
                        b.this.gsE.bGQ();
                        return;
                    }
                    return;
                }
                if (b.this.fWI.Fk().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.gsE != null) {
                    b.this.gsE.lr(z2);
                }
            }
        };
        this.gto = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.18
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.fWZ != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.gsF.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.fWP || ListUtils.getCount(b.this.fWI.bFk()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && b.this.fWI.bFn() == 1) {
                            if (!b.this.fWI.bFq() || i2 >= 0) {
                                if (b.this.fWI.bFr() && i2 > 0) {
                                    b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    b.this.gsF.setCurrentItem(b.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                b.this.gsF.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        b.this.fWI.cancelLoadData();
                        b.this.mHandler.removeCallbacksAndMessages(null);
                        b.this.kw(true);
                        b.this.gsE.bGL();
                        b.this.gsE.Jh();
                        b.this.gsE.bGM();
                        if (b.this.fWI.Fk() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(b.this.fWI.Fk().mLiveInfo.live_id + "", b.this.fWI.Fk().mLiveInfo.room_id + "", b.this.fWI.Fk().avj.userId + "", b.this.fWI.Fk().avj.userName, System.currentTimeMillis(), b.this.fWI.Fk().mLiveInfo.feed_id, b.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(b.this.fWI.Fk().mLiveInfo.live_id + "", b.this.fWI.Fk().mLiveInfo.room_id + "", b.this.fWI.Fk().avj.userId + "", b.this.fWI.Fk().avj.userName, System.currentTimeMillis(), b.this.fWI.Fk().mLiveInfo.feed_id, b.this.otherParams);
                            }
                        }
                        if (b.this.gsW != null) {
                            long j = b.this.fWI.Fk().mLiveInfo.live_id;
                            if (b.this.gsW.liveId == j && b.this.gsW.startTime > 0) {
                                b.this.gsW.endTime = System.currentTimeMillis();
                                long j2 = b.this.gsW.endTime - b.this.gsW.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.gsW.roomId + "", b.this.gsW.vid, j2 / 1000, b.this.otherParams);
                            }
                            b.this.gsW = null;
                        }
                        b.this.bJn();
                        if (b.this.gtl != null) {
                            b.this.gtl.release();
                        }
                        b.this.mSelectedPosition = i;
                        b.this.gsE = b.this.gsG.rb(b.this.mSelectedPosition);
                        b.this.gsE.bGP();
                        b.this.rQ(i2);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.gsF.setCurrentItem(b.this.mSelectedPosition);
                        b.this.fWI.f(b.this.fWI.bFv());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.uN().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.fXn = new c.a() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.y(b.this.fWI.Fk());
                } else if (i2 == 2) {
                    b.this.f(b.this.fWI.bth());
                } else if (i2 == 3) {
                    b.this.aV(i, str);
                } else if (i2 == 4) {
                    b.this.ay(obj);
                } else if (i2 == 5) {
                    b.this.bJc();
                }
            }
        };
        this.fYO = new Runnable() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                    if (b.this.fWI != null && b.this.fWI.Fk() != null) {
                        Log.i("eventpolling", "@@@ polling run live_id=" + b.this.fWI.Fk().mLiveInfo.live_id + ", hd=" + b.this.mHandler + ",vc=" + b.this);
                        m.k(b.this.fWI.Fk().mLiveInfo.user_id, b.this.fWI.Fk().mLiveInfo.live_id);
                    }
                    if (b.this.mHandler != null) {
                        b.this.mHandler.postDelayed(b.this.fYO, b.this.fYx);
                    }
                }
            }
        };
        this.gtp = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bGm() != null && b.this.mTbPageContext != null) {
                        b.this.gsV.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bGm());
                    }
                }
            }
        };
        this.gtq = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.5
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
        this.gtr = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.fWI != null && b.this.fWI.Fk() != null && b.this.fWI.Fk().mLiveInfo != null) {
                    long j = b.this.fWI.Fk().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.gtl != null) {
                        b.this.gtl.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.fYT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.fWI.Fk().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aWM != null && !eventPollingHttpResponseMessage.aWM.isEmpty() && b.this.fWI != null && b.this.fWI.Fk() != null && b.this.fWI.Fk().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        for (int i = 0; i < eventPollingHttpResponseMessage.aWM.size(); i++) {
                            am amVar = eventPollingHttpResponseMessage.aWM.get(i);
                            if (j == amVar.liveId && j2 - amVar.createTime <= 60 && !m.i(amVar.liveId, amVar.id)) {
                                m.a(amVar, b.this.fWI.Fk().mLiveInfo, false);
                                m.j(amVar.liveId, amVar.id);
                            }
                        }
                        am amVar2 = eventPollingHttpResponseMessage.aWM.get(eventPollingHttpResponseMessage.aWM.size() - 1);
                        if (j == amVar2.liveId) {
                            m.h(amVar2.liveId, amVar2.id);
                        }
                    }
                    int i2 = eventPollingHttpResponseMessage.aWL;
                    if (i2 <= 0) {
                        i2 = 5;
                    }
                    b.this.fYx = i2 * 1000;
                }
            }
        };
        this.fYS = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                    b.this.a(httpResponsedMessage, "data_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST);
                } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    b.this.a(httpResponsedMessage, ETAG.KEY_NET_ERROR, UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST);
                } else {
                    GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                    if (getVideoGoodsListHttpResponseMessage.getOrginalMessage() != null && (getVideoGoodsListHttpResponseMessage.getOrginalMessage() instanceof h)) {
                        h hVar = (h) getVideoGoodsListHttpResponseMessage.getOrginalMessage();
                        if (httpResponsedMessage.hasError() && b.this.fWI != null && b.this.fWI.Fk() != null && b.this.fWI.Fk().mLiveInfo != null) {
                            AlaStatsItem alaStatsItem = new AlaStatsItem();
                            alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, Long.valueOf(b.this.fWI.Fk().mLiveInfo.live_id));
                            alaStatsItem.addValue("feedid", hVar.aEX);
                            alaStatsItem.addValue("err", Integer.valueOf(httpResponsedMessage.getError()));
                            alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, httpResponsedMessage.getErrorString());
                            alaStatsItem.addValue("logid", Long.valueOf(getVideoGoodsListHttpResponseMessage.getLogId()));
                            AlaStatManager.getInstance().debug("livegoodlist_getfail", alaStatsItem);
                        }
                        if (b.this.fWI != null && b.this.fWI.Fk() != null) {
                            long j = b.this.fWI.Fk().mLiveInfo.live_id;
                            if (j != hVar.liveId) {
                                b.this.a(httpResponsedMessage, "data_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST);
                                return;
                            }
                            getVideoGoodsListHttpResponseMessage.liveId = j;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                            if (!b.this.gsX) {
                                b.this.gsX = true;
                                String str = "goods_task_" + j;
                                ax axVar = com.baidu.live.v.a.Ge().aYP;
                                long j2 = (axVar == null || axVar.aAM == null) ? 10L : axVar.aAM.aCB;
                                if (j2 <= 0) {
                                    j2 = 10;
                                }
                                LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.b.8.1
                                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                    public void onComplete(boolean z) {
                                        if (b.this.fWI != null && b.this.fWI.Fk() != null && b.this.fWI.Fk().mLiveInfo.live_id != o.bfr) {
                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, b.this.fWI.Fk().mLiveInfo));
                                        }
                                    }

                                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                    public void onInterrupt() {
                                    }
                                }, j2 * 1000, true);
                            }
                        }
                    }
                    b.this.a(httpResponsedMessage, (String) null, UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST_SUCC);
                }
            }
        };
        this.gts = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.fWI != null && b.this.fWI.Fk() != null && b.this.fWI.Fk().avC != null) {
                        if (l.longValue() == b.this.fWI.Fk().avC.userId) {
                            b.this.fWI.Fk().avC.isNewUser = false;
                            if (b.this.gsZ != null) {
                                b.this.gsZ.r(b.this.fWI.Fk());
                            }
                        }
                    }
                }
            }
        };
        this.gtt = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.q.a)) {
                    com.baidu.tieba.ala.liveroom.q.a aVar2 = (com.baidu.tieba.ala.liveroom.q.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String vX = aVar2.vX();
                    if (b.this.mTbPageContext != null && b.this.fWI != null && b.this.fWI.Fk() != null && b.this.fWI.Fk().avC != null) {
                        if (valueOf.longValue() == b.this.fWI.Fk().avC.userId && com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAG != null && com.baidu.live.v.a.Ge().aYP.aAG.wt()) {
                            g.qU(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, vX));
                        }
                    }
                }
            }
        };
        this.gtu = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.gti != null) {
                    b.this.mHandler.removeCallbacks(b.this.gti);
                }
                b.this.bJe();
            }
        };
        this.fXd = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.gsD = aVar;
        this.gsK = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
        if (runTask != null) {
            this.gtl = (com.baidu.live.x.c) runTask.getData();
        }
        this.fWI = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.fWI.a(this.fXn);
        this.gsP = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.gtp);
        MessageManager.getInstance().registerListener(this.gtq);
        MessageManager.getInstance().registerListener(this.gtr);
        MessageManager.getInstance().registerListener(this.fYT);
        MessageManager.getInstance().registerListener(this.fYS);
        MessageManager.getInstance().registerListener(this.gts);
        MessageManager.getInstance().registerListener(this.gtt);
        MessageManager.getInstance().registerListener(this.gtu);
        UbcStatisticManager.getInstance().liveRoomFlowBegin(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    private void O(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlaLiveRoomActivityConfig.LIVE_BROADCAST_GIFT_TOAST_QUEUE);
            if (!StringUtils.isNull(stringExtra)) {
                try {
                    JSONArray jSONArray = new JSONArray(stringExtra);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length = jSONArray.length();
                        this.gsN = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.gsN.add(alaBroadcastGiftToastData);
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void P(Intent intent) {
        O(intent);
        this.aWu = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.aWu)) {
            this.aWu = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.gsR = intent.getStringExtra("room_id");
        this.aWv = intent.getLongExtra("live_id", 0L);
        this.gsU = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.fWI.b((AlaLiveInfoCoreData) serializableExtra);
            this.gsU = true;
        }
        Q(intent);
        this.gtg = this.gtf == null || !this.gtf.aAW;
        this.gsP.setOtherParams(this.otherParams);
        this.gsM = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bIP();
        bIO();
    }

    private void Q(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.fHG = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.gsT = new JSONObject(stringExtra);
                if (this.gsT != null) {
                    String optString = this.gsT.optString("enterRoomId");
                    String optString2 = this.gsT.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.gsR, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.aWv + "", optString2))) {
                        String optString3 = this.gsT.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.gsT.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.gsU) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.aWv;
                            alaLiveInfoCoreData.screenDirection = this.gsT.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString4, alaLiveInfoCoreData);
                            this.fWI.b(alaLiveInfoCoreData);
                            this.gsU = true;
                        }
                    }
                    String optString5 = this.gsT.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.gtf = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.fHG = jSONObject.optString("live_back_scheme");
                        this.gtf = new ay();
                        this.gtf.aAW = jSONObject.optInt("is_hot") == 1;
                        if (this.gtf.aAW) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.gtf.aAX = jSONObject.optString("task_id");
                        this.gtf.aAV = !TextUtils.isEmpty(this.gtf.aAX);
                        this.gtf.aAY = jSONObject.optInt("task_type");
                        this.gtf.aAZ = jSONObject.optInt("task_im_count");
                        this.gtf.aBa = jSONObject.optLong("task_gift_total_price");
                        this.gtf.aBb = jSONObject.optLong("task_watch_time");
                        this.gtf.aBc = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                        String optString6 = jSONObject.optString("back_app_scheme");
                        String optString7 = jSONObject.optString("back_app_icon");
                        String optString8 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            this.gsI = new com.baidu.tieba.ala.liveroom.d.b();
                            this.gsI.setScheme(optString6);
                            this.gsI.setImageUrl(optString7);
                            this.gsI.setTitle(optString8);
                        }
                    }
                    this.gsO = this.gsT.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gsT.remove("cover");
                    this.gsT.remove("live_url");
                    this.gsT.remove("enterRoomId");
                    this.gsT.remove("enterLiveId");
                    this.gsT.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gsT.remove("extra");
                    this.otherParams = this.gsT.toString();
                    this.fWI.setOtherParams(this.otherParams);
                    this.gsT.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.gsT.optString("from");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.gsT.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.gsT.optString("source");
                    }
                    this.gth = "mobilebaidu_subscription".equals(str);
                    int optInt = this.gsT.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.fWI.rt(optInt);
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

    public void bIO() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.fWI.af(this.uk, this.aWu, this.mForumName);
        } else if (this.fWI.Fk() != null && this.fWI.Fk().mLiveInfo != null && this.fWI.Fk().mLiveInfo.live_id > 0) {
            this.fWI.a(this.fWI.Fk().mLiveInfo.live_id, false, this.aWu, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.aWu = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                lC(false);
                return;
            }
            this.fWI.af(this.uk, this.aWu, this.mForumName);
        } else if (!TextUtils.isEmpty(this.gsR)) {
            this.fWI.CB(this.gsR);
        } else if (this.aWv > 0) {
            this.fWI.a(this.aWv, false, this.aWu, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            lC(false);
        }
    }

    private void bIP() {
        this.fWP = true;
        this.gsL = false;
        bIQ();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        this.gsQ = new com.baidu.tieba.ala.liveroom.c.c();
        this.gsQ.a(this.gtn);
        this.gsQ.setOtherParams(this.otherParams);
        this.gsQ.kr(this.gth);
        bIS();
        bIR();
    }

    private void bIQ() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.gsF = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.gsF.setOnPageChangeListener(this.gto);
        this.gsF.setBoundaryCaching(true);
        this.gsF.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.gsG = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.gsG.bCD();
        this.gsE = this.gsG.ra(this.mSelectedPosition);
        this.gsG.a(this.mSelectedPosition, this.fWI.Fk());
        this.gsF.setAdapter(this.gsG);
        this.gsF.setCurrentItem(this.mSelectedPosition);
        this.gsF.setIsScrollable(this.gtg);
    }

    private void c(Rect rect) {
        this.gsJ = SdkLivePlayer.eC(getPageContext().getPageActivity());
        if (this.gsJ == null) {
            this.gsF.setIsScrollable(false);
            if (this.fWI != null) {
                this.fWI.cancelLoadData();
            }
            bCG();
            return;
        }
        if (this.gsM) {
            this.gsF.setIsScrollable(false);
        }
        this.gsJ.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.gsJ.setIPlayerCallBack(this.bgd);
        this.gsJ.setIPlayerAudioFocusCallBack(this.gtm);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gsE.a(this.gsJ, layoutParams, true);
    }

    private void bIR() {
        this.gsH = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext);
    }

    private void bCG() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.16
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.lC(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.fWZ = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.fWZ.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gsE.a(this.fWZ, layoutParams);
    }

    private void bIS() {
        if (this.fWI != null && this.fWI.Fk() != null) {
            this.aJj = this.fWI.Fk();
            if (this.aJj.mLiveInfo != null) {
                a(this.aJj.mLiveInfo, this.gsU);
                if (this.aJj.mLiveInfo != null && this.aJj.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.isBackGround);
                    }
                    if (!this.isBackGround) {
                        this.gsJ.b(this.aJj.mLiveInfo);
                    } else {
                        this.gsJ.setPlayLiveInfo(this.aJj.mLiveInfo);
                    }
                    if (this.gsQ != null) {
                        this.gsQ.a(this.mTbPageContext, this.fWZ, this.gsJ, this.gsE, this.fWI, this.aWu, this.gsM, this.fXd, this.gsN, this.gtf);
                        j(this.aJj.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private void bIT() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.gsM || !this.gtg) {
                this.gsF.setIsScrollable(false);
            } else {
                this.gsF.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && ((this.gsQ == null || !this.gsQ.onKeyDown(i, keyEvent)) && (this.gsQ == null || !this.gsQ.bzk()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bIT();
            } else if (this.gsQ == null || this.gsQ.bzl()) {
                lC(true);
                bwp();
            }
        }
        return true;
    }

    public void bwp() {
        if (!TextUtils.isEmpty(this.fHG)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.fHG);
                this.fHG = null;
            }
        }
    }

    public void lC(boolean z) {
        K(z, false);
    }

    public void K(boolean z, boolean z2) {
        kw(!z);
        if (this.gsJ != null) {
            this.gsJ.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        bIV();
        long j = -1;
        if (this.fWI != null && this.fWI.bFv() != null) {
            j = this.fWI.bFv().room_id;
        }
        this.gsD.a(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void kw(boolean z) {
        AlaLiveInfoData bFv;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        if (ac.yz() != null) {
            ac.yz().yy();
        }
        if (this.gtl != null) {
            this.gtl.release();
        }
        if (this.gsZ != null) {
            this.gsZ.release();
        }
        this.gtf = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.fWI != null && (bFv = this.fWI.bFv()) != null) {
            this.fWI.dG(bFv.live_id);
        }
        this.gsV.stopRecord();
        LiveTimerManager.getInstance().stop();
        bIU();
        if (this.gsJ != null) {
            this.gsJ.bW(z);
        }
        if (this.gsQ != null) {
            this.gsQ.kw(z);
        }
        this.gsX = false;
        this.gsY = false;
        o.bfr = 0L;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
    }

    private void bIU() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bIV() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(q qVar) {
        if (qVar != null) {
            this.aJj = qVar;
            if (this.gsQ != null) {
                this.gsQ.a(qVar);
            }
        }
    }

    private void c(k kVar) {
        if (this.gsQ != null) {
            this.gsQ.c(kVar);
        }
    }

    private void x(q qVar) {
        this.aJj = qVar;
    }

    private void bIW() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.gsF.setIsScrollable(false);
            this.gtg = false;
        }
        if (this.aJj != null) {
            a(this.aJj.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.gsE.a(this.fWZ, null);
            a(this.gsE, this.aJj.mLiveInfo, this.fWP);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aJj.mLiveInfo.live_id), String.valueOf(this.aJj.mLiveInfo.room_id), String.valueOf(this.aJj.mLiveInfo.feed_id), bIX());
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.fWP = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.fWI != null && this.fWI.Fk() != null && this.fWI.Fk().mLiveInfo != null) {
                    j = this.fWI.Fk().mLiveInfo.live_id;
                    str2 = this.fWI.Fk().mLiveInfo.room_id + "";
                    str = this.fWI.Fk().mLiveInfo.feed_id;
                } else {
                    if (this.aWv > 0) {
                        j2 = this.aWv;
                    }
                    if (!TextUtils.isEmpty(this.gsR)) {
                        j = j2;
                        str = "";
                        str2 = this.gsR;
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
                if (this.fWI != null && this.fWI.Fk() != null && this.fWI.Fk().mLiveInfo != null) {
                    str3 = this.fWI.Fk().mLiveInfo.feed_id;
                    str4 = this.fWI.Fk().mLiveInfo.live_id + "";
                    str5 = this.fWI.Fk().mLiveInfo.room_id + "";
                    str6 = this.fWI.Fk().mLiveInfo.user_name;
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

    private String bIX() {
        if (this.gsT == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.gsT.optString("source");
            String optString2 = this.gsT.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gsT.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.gsT.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.gsT.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (this.gsJ != null && this.gsJ.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.gsJ.getVideoPath();
                String c = com.baidu.live.o.h.c(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.gsJ.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + c);
                }
                if (com.baidu.live.o.h.az(videoPath, c)) {
                    this.gsJ.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.o.h.ay(videoPath, c)) {
                    this.gsJ.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.bG(this.gsJ)) {
                        ((ViewGroup) this.gsJ.getParent()).removeView(this.gsJ);
                        alaLiveRoomBlurPageLayout.a(this.gsJ, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.isBackGround) {
                        this.gsJ.b(alaLiveInfoData);
                        return;
                    } else {
                        this.gsJ.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.gsJ.bJp();
        } else if (this.gsJ != null && this.gsJ.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.gsJ, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.isBackGround) {
                    this.gsJ.b(alaLiveInfoData);
                } else {
                    this.gsJ.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.gsJ != null) {
            this.gsJ.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = p.r(this.mTbPageContext.getPageActivity());
                layoutParams.height = p.s(this.mTbPageContext.getPageActivity());
                int ay = p.ay(this.mTbPageContext.getPageActivity());
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

    public void bIY() {
        this.fWP = true;
    }

    public boolean bIZ() {
        return this.fWP;
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
                this.gsE.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.gsE.setBackgroundColor(0);
            }
        } else {
            this.gsE.setBackgroundColor(0);
        }
        int i2 = this.gsJ.getLayoutParams().width;
        int i3 = this.gsJ.getLayoutParams().height;
        int i4 = this.gsJ.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.gsJ.getLayoutParams()).topMargin : 0;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3 || b.topMargin != i4) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.fWZ != null) {
            this.fWZ.setLayoutParams(c);
        }
        if (this.gsE != null) {
            this.gsE.bp(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gsP != null) {
            this.gsP.bp(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gsQ != null) {
            this.gsQ.l(c.width, c.height, realScreenOrientation);
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

    private void rh(int i) {
        boolean z = true;
        if (this.aJj != null && this.aJj.mLiveInfo != null) {
            this.gsE.setBgImageUrl(this.aJj.mLiveInfo.cover, this.aJj.mLiveInfo);
            this.gsG.a(this.mSelectedPosition, bJa(), this.aJj);
            this.gsG.b(this.mSelectedPosition, bJb(), this.aJj);
            this.gsE.requestLayout();
            this.gsE.G(i, this.aJj.mLiveInfo.screen_direction == 2);
        }
        if (this.aJj != null) {
            a(this.aJj.mLiveInfo, false);
        }
        boolean bGR = this.gsE.bGR();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.aJj == null || this.aJj.mLiveInfo == null || this.aJj.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!bJl()) {
            if (this.gsJ != null && this.gsJ.getParent() == null) {
                this.gsE.a(this.gsJ, null, false);
                if (this.aJj != null && this.aJj.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.isBackGround) {
                        this.gsJ.b(this.aJj.mLiveInfo);
                    } else {
                        this.gsJ.setPlayLiveInfo(this.aJj.mLiveInfo);
                    }
                }
            }
            if (bGR && !bJl() && this.gsQ != null) {
                this.gsE.lr(z);
                return;
            }
            return;
        }
        this.gsE.bGL();
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
            this.fWI.a(alaLiveInfoData.live_id, true, this.aWu, this.mForumName);
        }
    }

    public void rQ(int i) {
        if (i < 0) {
            this.fWI.ru(this.fWI.bFs() - 1);
        } else if (i > 0) {
            this.fWI.ru(this.fWI.bFs() + 1);
        }
        if (this.gsQ != null) {
            this.gsQ.a(this.gsE);
        }
        this.gsG.a(this.mSelectedPosition, bJa(), this.aJj);
        this.gsG.b(this.mSelectedPosition, bJb(), this.aJj);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.fWI != null) {
            int bFs = this.fWI.bFs();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bFs + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.fWI.bFk() != null && this.fWI.bFk().size() > bFs && this.fWI.bFk().get(bFs) != null) {
                AlaLiveInfoData alaLiveInfoData = this.fWI.bFk().get(bFs);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fWI != null) {
            AlaLiveInfoData bFv = this.fWI.bFv();
            if (bFv != null) {
                bFv.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.gsE, bFv, this.fWP);
                this.fWP = false;
                if (this.gsQ != null) {
                    this.gsQ.a(this.mTbPageContext, this.fWZ, this.gsJ, this.gsE, this.fWI, this.aWu, this.gsM, this.fXd, null, this.gtf);
                    short s = 2;
                    if (bFv.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bFv, false);
            }
            h(bFv);
            this.gsE.a(this.fWZ, null);
            if (this.gsQ != null) {
                this.gsQ.bzi();
            }
            this.fWI.f(bFv);
        }
    }

    private AlaLiveInfoData bJa() {
        List<AlaLiveInfoData> bFk = this.fWI.bFk();
        if (bFk == null || bFk.size() == 0) {
            if (this.aJj == null) {
                return null;
            }
            return this.aJj.mLiveInfo;
        }
        int bFs = this.fWI.bFs();
        int size = bFk.size();
        return bFk.get(((bFs + size) - 1) % size);
    }

    private AlaLiveInfoData bJb() {
        List<AlaLiveInfoData> bFk = this.fWI.bFk();
        if (bFk == null || bFk.size() == 0) {
            if (this.aJj == null) {
                return null;
            }
            return this.aJj.mLiveInfo;
        }
        return bFk.get((this.fWI.bFs() + 1) % bFk.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(int i, String str) {
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
            lC(false);
            return;
        }
        q Fk = this.fWI.Fk();
        x(Fk);
        this.fWI.bFl();
        if (this.fWP) {
            this.fWI.lh(false);
        }
        this.fXd = System.currentTimeMillis() / 1000;
        if (this.gsQ != null) {
            this.gsQ.a(this.mTbPageContext, this.fWZ, this.gsJ, this.gsE, this.fWI, this.aWu, this.gsM, this.fXd, this.gsN, this.gtf);
            short s = 2;
            if (Fk.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bIW();
        if (Fk != null && Fk.mLiveInfo != null && Fk.mLiveInfo.live_status == 2) {
            this.gsG.a(this.mSelectedPosition, this.fWI.Fk());
            d(Fk, false);
            this.fWP = false;
            return;
        }
        boolean z = (this.gsQ == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.gtc || !TextUtils.equals(com.baidu.live.utils.q.Ie(), this.gtd))) {
            v.b(getPageContext(), false);
            com.baidu.live.v.c.Gj().Gk();
            this.gtc = true;
            this.gtd = com.baidu.live.utils.q.Ie();
        }
        if (!this.gte) {
            this.gte = true;
            com.baidu.live.entereffect.a.wD().aZ(false);
        }
        this.gsX = false;
        if (this.fWI.Fk() != null && this.fWI.Fk().mLiveInfo != null) {
            this.fWI.f(this.fWI.Fk().mLiveInfo.live_id, !this.gsY);
            this.gsY = true;
        }
        if (this.gsQ != null) {
            this.gsQ.kv(TextUtils.equals(this.gsO, "1"));
            this.gsO = "";
        }
        if (z && this.fWI.Fk() != null && this.fWI.Fk().mLiveInfo != null) {
            String str2 = this.fWI.Fk().mLiveInfo.feed_id;
            long j = this.fWI.Fk().mLiveInfo.live_id;
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                Log.i("eventpolling", "@@@ polling init live_id=" + j + ", hd=" + this.mHandler + ",vc=" + this);
                this.mHandler.post(this.fYO);
            }
        }
        if (this.gsH != null) {
            this.gsH.a(this.aJj, this.gsI);
        }
        a(this.fWI.Fk());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.fWI.Fk() != null && b.this.fWI.Fk().mLiveInfo != null) {
                    b.this.fWI.a(b.this.fWI.Fk().mLiveInfo.live_id, b.this.aWu, b.this.fXd);
                }
            }
        }, this.fWI.Fk().avn);
        if (z && this.fWI.Fk() != null && this.fWI.Fk().avj != null) {
            ax axVar = com.baidu.live.v.a.Ge().aYP;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && axVar != null && axVar.aAL != null && axVar.aAL.aCu) {
                c(true, this.fWI.Fk().avj.userId);
            }
        }
        this.fWP = false;
        if (z && this.fWI.Fk() != null && this.fWI.Fk().mLiveInfo != null && this.fWI.Fk().avj != null && this.gsQ != null) {
            long j2 = this.fWI.Fk().mLiveInfo.live_id;
            long j3 = this.fWI.Fk().mLiveInfo.room_id;
            String str3 = this.fWI.Fk().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j2;
                if (ac.yz() != null) {
                    ac.yz().a(this.mTbPageContext.getPageActivity(), j2, str4, j3, str3, this.otherParams);
                }
                if (this.gtl != null) {
                    this.gtl.b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
                }
            }
            if (e.BG() != null) {
                e.BG().b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
            }
            if (this.gsZ == null) {
                this.gsZ = new com.baidu.tieba.ala.liveroom.i.a();
            }
            this.gsZ.a(this.mTbPageContext.getPageActivity(), this.fWI.Fk(), this.otherParams);
        }
        if (this.gta == null) {
            this.gta = new com.baidu.tieba.ala.liveroom.t.b(this.mTbPageContext);
        }
        if (z && this.fWI.Fk() != null && this.fWI.Fk().avC != null && !this.gtb) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.gta.a(this.fWI.Fk(), this.fWI.Fk().avC.userId);
                this.gtb = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJc() {
        if (this.gsK) {
            this.gsG.a(this.mSelectedPosition, bJa(), this.aJj);
            this.gsG.b(this.mSelectedPosition, bJb(), this.aJj);
            this.gsK = false;
        }
        if (this.gsP != null && bJl()) {
            this.gsP.V(this.fWI.bFm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.gtk);
            this.mHandler.postDelayed(this.gtk, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (kVar == null) {
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.gtj);
                this.mHandler.postDelayed(this.gtj, 5000L);
                return;
            }
            return;
        }
        if (!this.gsL) {
            c(kVar);
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.gtj);
            this.mHandler.postDelayed(this.gtj, kVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJd() {
        if (this.fWI.Fk() != null && this.fWI.Fk().mLiveInfo != null) {
            this.fWI.f(this.fWI.Fk().mLiveInfo.live_id, !this.gsY);
            this.gsY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.live_status == 2) {
            this.gsG.a(this.mSelectedPosition, this.fWI.Fk());
            d(qVar, false);
        } else if (qVar != null) {
            if (!this.gsL) {
                a(qVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.gti);
                this.mHandler.postDelayed(this.gti, qVar.avn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJe() {
        if (this.mTbPageContext != null && this.fWI.Fk() != null && this.fWI.Fk().mLiveInfo != null) {
            this.fWI.a(this.fWI.Fk().mLiveInfo.live_id, this.aWu, this.fXd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(q qVar, boolean z) {
        View view = null;
        kw(true);
        if (!bJl()) {
            this.fWI.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.gsE != null) {
                this.gsE.Jh();
                this.gsE.bGL();
                this.gsE.bGS();
            }
            if (qVar != null && qVar.mLiveInfo != null) {
                this.gsS = qVar.mLiveInfo.live_id;
            }
            bIT();
            bJf();
            bJg();
            if (qVar != null) {
                if (this.gsQ != null && this.gsQ.bzo() != null) {
                    view = this.gsQ.bzo().a(this.gsQ.bzf().pageContext.getPageActivity(), qVar, z);
                }
                if (this.gsE != null) {
                    this.gsP.a(this.gsE, view, qVar, z, this.fWI.bFm());
                }
                if (this.gsQ != null) {
                    this.gsQ.kw(false);
                    this.gsQ.bzj();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.gsE != null) {
                    this.gsE.bGP();
                }
                long j = qVar.mLiveInfo.live_id;
                long j2 = qVar.mLiveInfo.room_id;
                String str = qVar.mLiveInfo.feed_id;
                long j3 = qVar.avj.userId;
                String str2 = qVar.avj.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.gsW = new StayTimeBean();
                this.gsW.liveId = qVar.mLiveInfo.live_id;
                this.gsW.roomId = qVar.mLiveInfo.room_id;
                this.gsW.vid = qVar.mLiveInfo.feed_id;
                this.gsW.startTime = System.currentTimeMillis();
            }
            bJn();
            if (this.gsH != null) {
                this.gsH.a(this.aJj, this.gsI);
            }
        }
    }

    private void bJf() {
    }

    private void bJg() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.gsF);
        }
    }

    public void bJh() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bJi();
        } else {
            bJj();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.fWI != null && this.fWI.Fk() != null) {
            alaLiveInfoData = this.fWI.Fk().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bJi();
        } else {
            bJj();
        }
        this.gsF.setIsScrollable(!z && this.gtg);
        if (this.gsQ != null) {
            this.gsQ.onKeyboardVisibilityChanged(z);
        }
        if (this.fWZ != null) {
            this.fWZ.onKeyboardVisibilityChanged(z);
        }
    }

    public void cs(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bJi();
        } else {
            bJj();
        }
        this.fWZ.cs(realScreenOrientation);
        rh(realScreenOrientation);
        if (ac.yz() != null) {
            ac.yz().ya();
        }
        if (this.gsZ != null) {
            this.gsZ.ya();
        }
        if (this.gsH != null) {
            this.gsH.cs(realScreenOrientation);
        }
    }

    public void bJi() {
        if (this.gsF != null) {
            com.baidu.live.utils.h.T(this.gsF);
        }
    }

    public void bJj() {
        if (this.gsF != null) {
            com.baidu.live.utils.h.U(this.gsF);
        }
    }

    public void onResume() {
        if (this.fWI != null) {
            this.fWI.bEU();
            this.fWI.bEY();
        }
        if (this.gsQ != null) {
            this.gsQ.enterForeground();
        }
        if (this.gsZ != null) {
            this.gsZ.onResume();
        }
        if (this.gta != null) {
            this.gta.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.u.a.eA(this.mTbPageContext.getPageActivity())) {
            if (this.isBackGround) {
                this.isBackGround = false;
                bJk();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void bJk() {
        bJe();
        bJd();
        this.fWI.bFl();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            this.gsJ.bJq();
        } else if (!this.gsJ.isPlaying()) {
            this.gsJ.bJq();
        }
        if (this.gsQ != null) {
            this.gsQ.bzn();
        }
        if (this.fWI != null && this.fWI.Fk() != null && this.fWI.Fk().mLiveInfo != null) {
            this.gsV.dJ(this.fWI.Fk().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aJj.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.fWI != null) {
            this.fWI.bEV();
            this.fWI.bEZ();
        }
        if (this.gsQ != null) {
            this.gsQ.enterBackground();
        }
    }

    public void lD(boolean z) {
        this.isBackGround = true;
        lE(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void lE(boolean z) {
        this.mHandler.removeCallbacks(this.gti);
        this.mHandler.removeCallbacks(this.gtj);
        this.mHandler.removeCallbacks(this.gtk);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            this.gsJ.avT();
        } else if (!z) {
            this.gsJ.avT();
        }
        if (this.gsQ != null) {
            this.gsQ.bzm();
        }
        this.gsV.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ac.yz() != null) {
                ac.yz().a(i, i2, intent, this.aJj, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.gsQ != null) {
            this.gsQ.onActivityResult(i, i2, intent);
        }
    }

    public boolean bJl() {
        return this.gsP != null && this.gsP.btQ();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gtp != null) {
            MessageManager.getInstance().unRegisterListener(this.gtp);
        }
        if (this.gtq != null) {
            MessageManager.getInstance().unRegisterListener(this.gtq);
        }
        MessageManager.getInstance().unRegisterListener(this.gtr);
        MessageManager.getInstance().unRegisterListener(this.fYT);
        MessageManager.getInstance().unRegisterListener(this.fYS);
        MessageManager.getInstance().unRegisterListener(this.gts);
        MessageManager.getInstance().unRegisterListener(this.gtt);
        MessageManager.getInstance().unRegisterListener(this.gtu);
        if (this.gtl != null) {
            this.gtl.release();
        }
        if (this.gsJ != null) {
            this.gsJ.bW(true);
        }
        if (this.gsH != null) {
            this.gsH.onDestory();
        }
        if (this.gsI != null) {
            this.gsI.reset();
        }
        if (this.gsQ != null) {
            this.gsQ.onDestroy();
        }
        if (this.gsG != null) {
            this.gsG.onDestroy();
        }
        this.gsE.Jh();
        if (this.gsE != null) {
            this.gsE.release();
            this.gsE = null;
        }
        if (this.gsP != null) {
            this.gsP.onDestroy();
        }
        if (this.gsW != null && this.fWI != null && this.fWI.Fk() != null) {
            long j = this.fWI.Fk().mLiveInfo.live_id;
            if (this.gsW.liveId == j && this.gsW.startTime > 0) {
                this.gsW.endTime = System.currentTimeMillis();
                long j2 = this.gsW.endTime - this.gsW.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.gsW.roomId + "", this.gsW.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.gsW = null;
        }
        if (this.fWZ != null) {
            this.fWZ.bGU();
            this.fWZ = null;
        }
        if (this.fWI != null) {
            this.fWI.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        m.HZ();
        com.baidu.live.entereffect.a.wD().release();
        t.yl().release();
        if (this.gta != null) {
            this.gta.release();
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String DN() {
        return this.otherParams;
    }

    public void bJm() {
        if (this.gsT != null) {
            this.otherParams = this.gsT.toString();
            if (this.fWI != null) {
                this.fWI.setOtherParams(this.otherParams);
            }
            if (this.gsQ != null) {
                this.gsQ.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.gsP != null) {
                this.gsP.setOtherParams(this.otherParams);
            }
        }
    }

    public void bJn() {
        if (this.gsT != null) {
            String optString = this.gsT.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gsT.put("tab", "live_jump");
                        this.gsT.put("tag", "");
                        this.gsT.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.gsT.put("tab", "liveroom");
                        this.gsT.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bJm();
            }
        }
    }

    private void c(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.BE();
        }
        bVar.af(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject2.put(PushMessageHelper.ERROR_TYPE, str);
                jSONObject.put("result", jSONObject2);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1541", str2, "liveroom", null).setContentExt(jSONObject), httpResponsedMessage, true);
    }

    public void bJo() {
        v.yv();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gsQ.d(s);
        } else {
            this.gsQ.e(s);
        }
    }
}
