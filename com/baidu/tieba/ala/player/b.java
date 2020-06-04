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
    private String fHR;
    private com.baidu.tieba.ala.liveroom.m.c fWT;
    private boolean fXa;
    private AlaLiveView fXk;
    private long fXo;
    private c.a fXy;
    private int fYI;
    private Runnable fYZ;
    private HttpMessageListener fZd;
    private HttpMessageListener fZe;
    private a gsO;
    private AlaLiveRoomBlurPageLayout gsP;
    private AlaLoopViewPager gsQ;
    private AlaLoopViewPagerAdapter gsR;
    private com.baidu.tieba.ala.liveroom.d.a gsS;
    private com.baidu.tieba.ala.liveroom.d.b gsT;
    private SdkLivePlayer gsU;
    private boolean gsV;
    private boolean gsW;
    private boolean gsX;
    private ArrayList<AlaBroadcastGiftToastData> gsY;
    private String gsZ;
    HttpMessageListener gtA;
    CustomMessageListener gtB;
    CustomMessageListener gtC;
    CustomMessageListener gtD;
    CustomMessageListener gtE;
    private CustomMessageListener gtF;
    private com.baidu.tieba.ala.endliveroom.a gta;
    private com.baidu.tieba.ala.liveroom.c.c gtb;
    private String gtc;
    private long gtd;
    private JSONObject gte;
    private boolean gtf;
    private com.baidu.tieba.ala.liveroom.task.c gtg;
    private StayTimeBean gth;
    private boolean gti;
    private boolean gtj;
    private com.baidu.tieba.ala.liveroom.i.a gtk;
    private com.baidu.tieba.ala.liveroom.t.b gtl;
    private boolean gtm;
    private boolean gtn;
    private String gto;
    private boolean gtp;
    private ay gtq;
    private boolean gtr;
    private boolean gts;
    private Runnable gtt;
    private Runnable gtu;
    private Runnable gtv;
    private com.baidu.live.x.c gtw;
    private com.baidu.live.o.a gtx;
    com.baidu.live.liveroom.a.b gty;
    ViewPager.OnPageChangeListener gtz;
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
        this.gsV = true;
        this.fXo = 0L;
        this.gsW = false;
        this.fXa = true;
        this.aWu = "";
        this.mForumName = "";
        this.isBackGround = false;
        this.gsX = false;
        this.gsZ = "0";
        this.mHandler = new Handler();
        this.gtd = -1L;
        this.otherParams = "";
        this.gtf = false;
        this.gtg = com.baidu.tieba.ala.liveroom.task.c.bGq();
        this.gti = false;
        this.gtj = false;
        this.gtn = false;
        this.gtp = false;
        this.gts = false;
        this.gtt = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bJg();
            }
        };
        this.gtu = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.bJf();
            }
        };
        this.gtv = new Runnable() { // from class: com.baidu.tieba.ala.player.b.13
            @Override // java.lang.Runnable
            public void run() {
                b.this.fWT.bFn();
            }
        };
        this.fYI = 5000;
        this.bgd = new com.baidu.live.o.b() { // from class: com.baidu.tieba.ala.player.b.14
            @Override // com.baidu.live.o.b
            public void bG(int i) {
                if (b.this.gsP != null) {
                    if (ListUtils.getCount(b.this.gsU.getAlaLiveInfoDataList()) < 2) {
                        b.this.gsP.bGP();
                    } else {
                        b.this.gsP.bGQ();
                    }
                }
                if (b.this.gtb != null) {
                    b.this.gtb.bG(i);
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.bJq();
                }
            }
        };
        this.gtx = new com.baidu.live.o.a() { // from class: com.baidu.tieba.ala.player.b.15
            @Override // com.baidu.live.o.a
            public void bV(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && b.this.gsU != null) {
                    if (z) {
                        if (!b.this.gsU.isPlaying()) {
                            b.this.gsU.bJs();
                        }
                    } else if (b.this.gsU.isPlaying()) {
                        b.this.gsU.avT();
                    }
                }
            }
        };
        this.gty = new com.baidu.live.liveroom.a.b() { // from class: com.baidu.tieba.ala.player.b.17
            @Override // com.baidu.live.liveroom.a.b
            public void bO(boolean z) {
                if (z || b.this.gtb == null || b.this.gtb.bzn()) {
                    b.this.lC(true);
                    b.this.bwr();
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
                b.this.gsU.bJr();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.isBackGround) {
                    if (b.this.isBackGround) {
                        b.this.gsU.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.gsU.ab(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void e(boolean z, boolean z2) {
                if (b.this.gsQ != null) {
                    b.this.gsQ.setIsScrollable(b.this.gtr && z);
                    b.this.gsQ.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.b
            public void bQ(boolean z) {
                boolean z2 = true;
                if (!z || b.this.bJn()) {
                    if (b.this.gsP != null) {
                        b.this.gsP.bGS();
                        return;
                    }
                    return;
                }
                if (b.this.fWT.Fk().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.gsP != null) {
                    b.this.gsP.lr(z2);
                }
            }
        };
        this.gtz = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.18
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.fXk != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.gsQ.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.fXa || ListUtils.getCount(b.this.fWT.bFm()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && b.this.fWT.bFp() == 1) {
                            if (!b.this.fWT.bFs() || i2 >= 0) {
                                if (b.this.fWT.bFt() && i2 > 0) {
                                    b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    b.this.gsQ.setCurrentItem(b.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                b.this.gsQ.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        b.this.fWT.cancelLoadData();
                        b.this.mHandler.removeCallbacksAndMessages(null);
                        b.this.kw(true);
                        b.this.gsP.bGN();
                        b.this.gsP.Jh();
                        b.this.gsP.bGO();
                        if (b.this.fWT.Fk() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(b.this.fWT.Fk().mLiveInfo.live_id + "", b.this.fWT.Fk().mLiveInfo.room_id + "", b.this.fWT.Fk().avj.userId + "", b.this.fWT.Fk().avj.userName, System.currentTimeMillis(), b.this.fWT.Fk().mLiveInfo.feed_id, b.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(b.this.fWT.Fk().mLiveInfo.live_id + "", b.this.fWT.Fk().mLiveInfo.room_id + "", b.this.fWT.Fk().avj.userId + "", b.this.fWT.Fk().avj.userName, System.currentTimeMillis(), b.this.fWT.Fk().mLiveInfo.feed_id, b.this.otherParams);
                            }
                        }
                        if (b.this.gth != null) {
                            long j = b.this.fWT.Fk().mLiveInfo.live_id;
                            if (b.this.gth.liveId == j && b.this.gth.startTime > 0) {
                                b.this.gth.endTime = System.currentTimeMillis();
                                long j2 = b.this.gth.endTime - b.this.gth.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.gth.roomId + "", b.this.gth.vid, j2 / 1000, b.this.otherParams);
                            }
                            b.this.gth = null;
                        }
                        b.this.bJp();
                        if (b.this.gtw != null) {
                            b.this.gtw.release();
                        }
                        b.this.mSelectedPosition = i;
                        b.this.gsP = b.this.gsR.rd(b.this.mSelectedPosition);
                        b.this.gsP.bGR();
                        b.this.rS(i2);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.gsQ.setCurrentItem(b.this.mSelectedPosition);
                        b.this.fWT.f(b.this.fWT.bFx());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.uN().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.fXy = new c.a() { // from class: com.baidu.tieba.ala.player.b.19
            @Override // com.baidu.tieba.ala.liveroom.m.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.y(b.this.fWT.Fk());
                } else if (i2 == 2) {
                    b.this.f(b.this.fWT.btj());
                } else if (i2 == 3) {
                    b.this.aV(i, str);
                } else if (i2 == 4) {
                    b.this.ay(obj);
                } else if (i2 == 5) {
                    b.this.bJe();
                }
            }
        };
        this.fYZ = new Runnable() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                    if (b.this.fWT != null && b.this.fWT.Fk() != null) {
                        Log.i("eventpolling", "@@@ polling run live_id=" + b.this.fWT.Fk().mLiveInfo.live_id + ", hd=" + b.this.mHandler + ",vc=" + b.this);
                        m.k(b.this.fWT.Fk().mLiveInfo.user_id, b.this.fWT.Fk().mLiveInfo.live_id);
                    }
                    if (b.this.mHandler != null) {
                        b.this.mHandler.postDelayed(b.this.fYZ, b.this.fYI);
                    }
                }
            }
        };
        this.gtA = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bGo() != null && b.this.mTbPageContext != null) {
                        b.this.gtg.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bGo());
                    }
                }
            }
        };
        this.gtB = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.5
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
        this.gtC = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.fWT != null && b.this.fWT.Fk() != null && b.this.fWT.Fk().mLiveInfo != null) {
                    long j = b.this.fWT.Fk().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.gtw != null) {
                        b.this.gtw.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.fZe = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.fWT.Fk().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aWM != null && !eventPollingHttpResponseMessage.aWM.isEmpty() && b.this.fWT != null && b.this.fWT.Fk() != null && b.this.fWT.Fk().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        for (int i = 0; i < eventPollingHttpResponseMessage.aWM.size(); i++) {
                            am amVar = eventPollingHttpResponseMessage.aWM.get(i);
                            if (j == amVar.liveId && j2 - amVar.createTime <= 60 && !m.i(amVar.liveId, amVar.id)) {
                                m.a(amVar, b.this.fWT.Fk().mLiveInfo, false);
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
                    b.this.fYI = i2 * 1000;
                }
            }
        };
        this.fZd = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.player.b.8
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
                        if (httpResponsedMessage.hasError() && b.this.fWT != null && b.this.fWT.Fk() != null && b.this.fWT.Fk().mLiveInfo != null) {
                            AlaStatsItem alaStatsItem = new AlaStatsItem();
                            alaStatsItem.addValue(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, Long.valueOf(b.this.fWT.Fk().mLiveInfo.live_id));
                            alaStatsItem.addValue("feedid", hVar.aEX);
                            alaStatsItem.addValue("err", Integer.valueOf(httpResponsedMessage.getError()));
                            alaStatsItem.addValue(BaseJsonData.TAG_ERRMSG, httpResponsedMessage.getErrorString());
                            alaStatsItem.addValue("logid", Long.valueOf(getVideoGoodsListHttpResponseMessage.getLogId()));
                            AlaStatManager.getInstance().debug("livegoodlist_getfail", alaStatsItem);
                        }
                        if (b.this.fWT != null && b.this.fWT.Fk() != null) {
                            long j = b.this.fWT.Fk().mLiveInfo.live_id;
                            if (j != hVar.liveId) {
                                b.this.a(httpResponsedMessage, "data_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST);
                                return;
                            }
                            getVideoGoodsListHttpResponseMessage.liveId = j;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913111, getVideoGoodsListHttpResponseMessage));
                            if (!b.this.gti) {
                                b.this.gti = true;
                                String str = "goods_task_" + j;
                                ax axVar = com.baidu.live.v.a.Ge().aYP;
                                long j2 = (axVar == null || axVar.aAM == null) ? 10L : axVar.aAM.aCB;
                                if (j2 <= 0) {
                                    j2 = 10;
                                }
                                LiveTimerManager.getInstance().addLiveTimerTask(str, j, new OnLiveTimerListener() { // from class: com.baidu.tieba.ala.player.b.8.1
                                    @Override // com.baidu.live.tbadk.timer.OnLiveTimerListener
                                    public void onComplete(boolean z) {
                                        if (b.this.fWT != null && b.this.fWT.Fk() != null && b.this.fWT.Fk().mLiveInfo.live_id != o.bfr) {
                                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913112, b.this.fWT.Fk().mLiveInfo));
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
        this.gtD = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.fWT != null && b.this.fWT.Fk() != null && b.this.fWT.Fk().avC != null) {
                        if (l.longValue() == b.this.fWT.Fk().avC.userId) {
                            b.this.fWT.Fk().avC.isNewUser = false;
                            if (b.this.gtk != null) {
                                b.this.gtk.r(b.this.fWT.Fk());
                            }
                        }
                    }
                }
            }
        };
        this.gtE = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.q.a)) {
                    com.baidu.tieba.ala.liveroom.q.a aVar2 = (com.baidu.tieba.ala.liveroom.q.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String vX = aVar2.vX();
                    if (b.this.mTbPageContext != null && b.this.fWT != null && b.this.fWT.Fk() != null && b.this.fWT.Fk().avC != null) {
                        if (valueOf.longValue() == b.this.fWT.Fk().avC.userId && com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAG != null && com.baidu.live.v.a.Ge().aYP.aAG.wt()) {
                            g.qW(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, vX));
                        }
                    }
                }
            }
        };
        this.gtF = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.gtt != null) {
                    b.this.mHandler.removeCallbacks(b.this.gtt);
                }
                b.this.bJg();
            }
        };
        this.fXo = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.gsO = aVar;
        this.gsV = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
        if (runTask != null) {
            this.gtw = (com.baidu.live.x.c) runTask.getData();
        }
        this.fWT = new com.baidu.tieba.ala.liveroom.m.c(getPageContext());
        this.fWT.a(this.fXy);
        this.gta = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.gtA);
        MessageManager.getInstance().registerListener(this.gtB);
        MessageManager.getInstance().registerListener(this.gtC);
        MessageManager.getInstance().registerListener(this.fZe);
        MessageManager.getInstance().registerListener(this.fZd);
        MessageManager.getInstance().registerListener(this.gtD);
        MessageManager.getInstance().registerListener(this.gtE);
        MessageManager.getInstance().registerListener(this.gtF);
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
                        this.gsY = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.gsY.add(alaBroadcastGiftToastData);
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
        this.gtc = intent.getStringExtra("room_id");
        this.aWv = intent.getLongExtra("live_id", 0L);
        this.gtf = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.fWT.b((AlaLiveInfoCoreData) serializableExtra);
            this.gtf = true;
        }
        Q(intent);
        this.gtr = this.gtq == null || !this.gtq.aAW;
        this.gta.setOtherParams(this.otherParams);
        this.gsX = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bIR();
        bIQ();
    }

    private void Q(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.fHR = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.gte = new JSONObject(stringExtra);
                if (this.gte != null) {
                    String optString = this.gte.optString("enterRoomId");
                    String optString2 = this.gte.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.gtc, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.aWv + "", optString2))) {
                        String optString3 = this.gte.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.gte.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.gtf) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.aWv;
                            alaLiveInfoCoreData.screenDirection = this.gte.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString4, alaLiveInfoCoreData);
                            this.fWT.b(alaLiveInfoCoreData);
                            this.gtf = true;
                        }
                    }
                    String optString5 = this.gte.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.gtq = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.fHR = jSONObject.optString("live_back_scheme");
                        this.gtq = new ay();
                        this.gtq.aAW = jSONObject.optInt("is_hot") == 1;
                        if (this.gtq.aAW) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.gtq.aAX = jSONObject.optString("task_id");
                        this.gtq.aAV = !TextUtils.isEmpty(this.gtq.aAX);
                        this.gtq.aAY = jSONObject.optInt("task_type");
                        this.gtq.aAZ = jSONObject.optInt("task_im_count");
                        this.gtq.aBa = jSONObject.optLong("task_gift_total_price");
                        this.gtq.aBb = jSONObject.optLong("task_watch_time");
                        this.gtq.aBc = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                        String optString6 = jSONObject.optString("back_app_scheme");
                        String optString7 = jSONObject.optString("back_app_icon");
                        String optString8 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString6) && !TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                            this.gsT = new com.baidu.tieba.ala.liveroom.d.b();
                            this.gsT.setScheme(optString6);
                            this.gsT.setImageUrl(optString7);
                            this.gsT.setTitle(optString8);
                        }
                    }
                    this.gsZ = this.gte.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gte.remove("cover");
                    this.gte.remove("live_url");
                    this.gte.remove("enterRoomId");
                    this.gte.remove("enterLiveId");
                    this.gte.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gte.remove("extra");
                    this.otherParams = this.gte.toString();
                    this.fWT.setOtherParams(this.otherParams);
                    this.gte.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.gte.optString("from");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.gte.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.gte.optString("source");
                    }
                    this.gts = "mobilebaidu_subscription".equals(str);
                    int optInt = this.gte.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.fWT.rv(optInt);
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

    public void bIQ() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.fWT.af(this.uk, this.aWu, this.mForumName);
        } else if (this.fWT.Fk() != null && this.fWT.Fk().mLiveInfo != null && this.fWT.Fk().mLiveInfo.live_id > 0) {
            this.fWT.a(this.fWT.Fk().mLiveInfo.live_id, false, this.aWu, this.mForumName);
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
            this.fWT.af(this.uk, this.aWu, this.mForumName);
        } else if (!TextUtils.isEmpty(this.gtc)) {
            this.fWT.CB(this.gtc);
        } else if (this.aWv > 0) {
            this.fWT.a(this.aWv, false, this.aWu, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            lC(false);
        }
    }

    private void bIR() {
        this.fXa = true;
        this.gsW = false;
        bIS();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        this.gtb = new com.baidu.tieba.ala.liveroom.c.c();
        this.gtb.a(this.gty);
        this.gtb.setOtherParams(this.otherParams);
        this.gtb.kr(this.gts);
        bIU();
        bIT();
    }

    private void bIS() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.gsQ = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.gsQ.setOnPageChangeListener(this.gtz);
        this.gsQ.setBoundaryCaching(true);
        this.gsQ.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.gsR = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.gsR.bCF();
        this.gsP = this.gsR.rc(this.mSelectedPosition);
        this.gsR.a(this.mSelectedPosition, this.fWT.Fk());
        this.gsQ.setAdapter(this.gsR);
        this.gsQ.setCurrentItem(this.mSelectedPosition);
        this.gsQ.setIsScrollable(this.gtr);
    }

    private void c(Rect rect) {
        this.gsU = SdkLivePlayer.eC(getPageContext().getPageActivity());
        if (this.gsU == null) {
            this.gsQ.setIsScrollable(false);
            if (this.fWT != null) {
                this.fWT.cancelLoadData();
            }
            bCI();
            return;
        }
        if (this.gsX) {
            this.gsQ.setIsScrollable(false);
        }
        this.gsU.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.gsU.setIPlayerCallBack(this.bgd);
        this.gsU.setIPlayerAudioFocusCallBack(this.gtx);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gsP.a(this.gsU, layoutParams, true);
    }

    private void bIT() {
        this.gsS = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext);
    }

    private void bCI() {
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
        this.fXk = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.fXk.setSwipeClearEnable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gsP.a(this.fXk, layoutParams);
    }

    private void bIU() {
        if (this.fWT != null && this.fWT.Fk() != null) {
            this.aJj = this.fWT.Fk();
            if (this.aJj.mLiveInfo != null) {
                a(this.aJj.mLiveInfo, this.gtf);
                if (this.aJj.mLiveInfo != null && this.aJj.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.isBackGround);
                    }
                    if (!this.isBackGround) {
                        this.gsU.b(this.aJj.mLiveInfo);
                    } else {
                        this.gsU.setPlayLiveInfo(this.aJj.mLiveInfo);
                    }
                    if (this.gtb != null) {
                        this.gtb.a(this.mTbPageContext, this.fXk, this.gsU, this.gsP, this.fWT, this.aWu, this.gsX, this.fXo, this.gsY, this.gtq);
                        j(this.aJj.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private void bIV() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.gsX || !this.gtr) {
                this.gsQ.setIsScrollable(false);
            } else {
                this.gsQ.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && ((this.gtb == null || !this.gtb.onKeyDown(i, keyEvent)) && (this.gtb == null || !this.gtb.bzm()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bIV();
            } else if (this.gtb == null || this.gtb.bzn()) {
                lC(true);
                bwr();
            }
        }
        return true;
    }

    public void bwr() {
        if (!TextUtils.isEmpty(this.fHR)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.fHR);
                this.fHR = null;
            }
        }
    }

    public void lC(boolean z) {
        K(z, false);
    }

    public void K(boolean z, boolean z2) {
        kw(!z);
        if (this.gsU != null) {
            this.gsU.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        bIX();
        long j = -1;
        if (this.fWT != null && this.fWT.bFx() != null) {
            j = this.fWT.bFx().room_id;
        }
        this.gsO.a(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void kw(boolean z) {
        AlaLiveInfoData bFx;
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        if (ac.yz() != null) {
            ac.yz().yy();
        }
        if (this.gtw != null) {
            this.gtw.release();
        }
        if (this.gtk != null) {
            this.gtk.release();
        }
        this.gtq = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.fWT != null && (bFx = this.fWT.bFx()) != null) {
            this.fWT.dG(bFx.live_id);
        }
        this.gtg.stopRecord();
        LiveTimerManager.getInstance().stop();
        bIW();
        if (this.gsU != null) {
            this.gsU.bW(z);
        }
        if (this.gtb != null) {
            this.gtb.kw(z);
        }
        this.gti = false;
        this.gtj = false;
        o.bfr = 0L;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
    }

    private void bIW() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bIX() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(q qVar) {
        if (qVar != null) {
            this.aJj = qVar;
            if (this.gtb != null) {
                this.gtb.a(qVar);
            }
        }
    }

    private void c(k kVar) {
        if (this.gtb != null) {
            this.gtb.c(kVar);
        }
    }

    private void x(q qVar) {
        this.aJj = qVar;
    }

    private void bIY() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.gsQ.setIsScrollable(false);
            this.gtr = false;
        }
        if (this.aJj != null) {
            a(this.aJj.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.gsP.a(this.fXk, null);
            a(this.gsP, this.aJj.mLiveInfo, this.fXa);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aJj.mLiveInfo.live_id), String.valueOf(this.aJj.mLiveInfo.room_id), String.valueOf(this.aJj.mLiveInfo.feed_id), bIZ());
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.fXa = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.fWT != null && this.fWT.Fk() != null && this.fWT.Fk().mLiveInfo != null) {
                    j = this.fWT.Fk().mLiveInfo.live_id;
                    str2 = this.fWT.Fk().mLiveInfo.room_id + "";
                    str = this.fWT.Fk().mLiveInfo.feed_id;
                } else {
                    if (this.aWv > 0) {
                        j2 = this.aWv;
                    }
                    if (!TextUtils.isEmpty(this.gtc)) {
                        j = j2;
                        str = "";
                        str2 = this.gtc;
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
                if (this.fWT != null && this.fWT.Fk() != null && this.fWT.Fk().mLiveInfo != null) {
                    str3 = this.fWT.Fk().mLiveInfo.feed_id;
                    str4 = this.fWT.Fk().mLiveInfo.live_id + "";
                    str5 = this.fWT.Fk().mLiveInfo.room_id + "";
                    str6 = this.fWT.Fk().mLiveInfo.user_name;
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

    private String bIZ() {
        if (this.gte == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.gte.optString("source");
            String optString2 = this.gte.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gte.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.gte.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.gte.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (this.gsU != null && this.gsU.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.gsU.getVideoPath();
                String c = com.baidu.live.o.h.c(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.gsU.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + c);
                }
                if (com.baidu.live.o.h.az(videoPath, c)) {
                    this.gsU.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && com.baidu.live.o.h.ay(videoPath, c)) {
                    this.gsU.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.bG(this.gsU)) {
                        ((ViewGroup) this.gsU.getParent()).removeView(this.gsU);
                        alaLiveRoomBlurPageLayout.a(this.gsU, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.isBackGround) {
                        this.gsU.b(alaLiveInfoData);
                        return;
                    } else {
                        this.gsU.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.gsU.bJr();
        } else if (this.gsU != null && this.gsU.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.gsU, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.isBackGround) {
                    this.gsU.b(alaLiveInfoData);
                } else {
                    this.gsU.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.gsU != null) {
            this.gsU.setLayoutParams(b);
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

    public void bJa() {
        this.fXa = true;
    }

    public boolean bJb() {
        return this.fXa;
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
                this.gsP.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.gsP.setBackgroundColor(0);
            }
        } else {
            this.gsP.setBackgroundColor(0);
        }
        int i2 = this.gsU.getLayoutParams().width;
        int i3 = this.gsU.getLayoutParams().height;
        int i4 = this.gsU.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.gsU.getLayoutParams()).topMargin : 0;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3 || b.topMargin != i4) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.fXk != null) {
            this.fXk.setLayoutParams(c);
        }
        if (this.gsP != null) {
            this.gsP.bp(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gta != null) {
            this.gta.bp(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gtb != null) {
            this.gtb.l(c.width, c.height, realScreenOrientation);
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

    private void rj(int i) {
        boolean z = true;
        if (this.aJj != null && this.aJj.mLiveInfo != null) {
            this.gsP.setBgImageUrl(this.aJj.mLiveInfo.cover, this.aJj.mLiveInfo);
            this.gsR.a(this.mSelectedPosition, bJc(), this.aJj);
            this.gsR.b(this.mSelectedPosition, bJd(), this.aJj);
            this.gsP.requestLayout();
            this.gsP.G(i, this.aJj.mLiveInfo.screen_direction == 2);
        }
        if (this.aJj != null) {
            a(this.aJj.mLiveInfo, false);
        }
        boolean bGT = this.gsP.bGT();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.aJj == null || this.aJj.mLiveInfo == null || this.aJj.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!bJn()) {
            if (this.gsU != null && this.gsU.getParent() == null) {
                this.gsP.a(this.gsU, null, false);
                if (this.aJj != null && this.aJj.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.isBackGround) {
                        this.gsU.b(this.aJj.mLiveInfo);
                    } else {
                        this.gsU.setPlayLiveInfo(this.aJj.mLiveInfo);
                    }
                }
            }
            if (bGT && !bJn() && this.gtb != null) {
                this.gsP.lr(z);
                return;
            }
            return;
        }
        this.gsP.bGN();
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
            this.fWT.a(alaLiveInfoData.live_id, true, this.aWu, this.mForumName);
        }
    }

    public void rS(int i) {
        if (i < 0) {
            this.fWT.rw(this.fWT.bFu() - 1);
        } else if (i > 0) {
            this.fWT.rw(this.fWT.bFu() + 1);
        }
        if (this.gtb != null) {
            this.gtb.a(this.gsP);
        }
        this.gsR.a(this.mSelectedPosition, bJc(), this.aJj);
        this.gsR.b(this.mSelectedPosition, bJd(), this.aJj);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.fWT != null) {
            int bFu = this.fWT.bFu();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bFu + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.fWT.bFm() != null && this.fWT.bFm().size() > bFu && this.fWT.bFm().get(bFu) != null) {
                AlaLiveInfoData alaLiveInfoData = this.fWT.bFm().get(bFu);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fWT != null) {
            AlaLiveInfoData bFx = this.fWT.bFx();
            if (bFx != null) {
                bFx.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.gsP, bFx, this.fXa);
                this.fXa = false;
                if (this.gtb != null) {
                    this.gtb.a(this.mTbPageContext, this.fXk, this.gsU, this.gsP, this.fWT, this.aWu, this.gsX, this.fXo, null, this.gtq);
                    short s = 2;
                    if (bFx.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bFx, false);
            }
            h(bFx);
            this.gsP.a(this.fXk, null);
            if (this.gtb != null) {
                this.gtb.bzk();
            }
            this.fWT.f(bFx);
        }
    }

    private AlaLiveInfoData bJc() {
        List<AlaLiveInfoData> bFm = this.fWT.bFm();
        if (bFm == null || bFm.size() == 0) {
            if (this.aJj == null) {
                return null;
            }
            return this.aJj.mLiveInfo;
        }
        int bFu = this.fWT.bFu();
        int size = bFm.size();
        return bFm.get(((bFu + size) - 1) % size);
    }

    private AlaLiveInfoData bJd() {
        List<AlaLiveInfoData> bFm = this.fWT.bFm();
        if (bFm == null || bFm.size() == 0) {
            if (this.aJj == null) {
                return null;
            }
            return this.aJj.mLiveInfo;
        }
        return bFm.get((this.fWT.bFu() + 1) % bFm.size());
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
        q Fk = this.fWT.Fk();
        x(Fk);
        this.fWT.bFn();
        if (this.fXa) {
            this.fWT.lh(false);
        }
        this.fXo = System.currentTimeMillis() / 1000;
        if (this.gtb != null) {
            this.gtb.a(this.mTbPageContext, this.fXk, this.gsU, this.gsP, this.fWT, this.aWu, this.gsX, this.fXo, this.gsY, this.gtq);
            short s = 2;
            if (Fk.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bIY();
        if (Fk != null && Fk.mLiveInfo != null && Fk.mLiveInfo.live_status == 2) {
            this.gsR.a(this.mSelectedPosition, this.fWT.Fk());
            d(Fk, false);
            this.fXa = false;
            return;
        }
        boolean z = (this.gtb == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.gtn || !TextUtils.equals(com.baidu.live.utils.q.Ie(), this.gto))) {
            v.b(getPageContext(), false);
            com.baidu.live.v.c.Gj().Gk();
            this.gtn = true;
            this.gto = com.baidu.live.utils.q.Ie();
        }
        if (!this.gtp) {
            this.gtp = true;
            com.baidu.live.entereffect.a.wD().aZ(false);
        }
        this.gti = false;
        if (this.fWT.Fk() != null && this.fWT.Fk().mLiveInfo != null) {
            this.fWT.f(this.fWT.Fk().mLiveInfo.live_id, !this.gtj);
            this.gtj = true;
        }
        if (this.gtb != null) {
            this.gtb.kv(TextUtils.equals(this.gsZ, "1"));
            this.gsZ = "";
        }
        if (z && this.fWT.Fk() != null && this.fWT.Fk().mLiveInfo != null) {
            String str2 = this.fWT.Fk().mLiveInfo.feed_id;
            long j = this.fWT.Fk().mLiveInfo.live_id;
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                Log.i("eventpolling", "@@@ polling init live_id=" + j + ", hd=" + this.mHandler + ",vc=" + this);
                this.mHandler.post(this.fYZ);
            }
        }
        if (this.gsS != null) {
            this.gsS.a(this.aJj, this.gsT);
        }
        a(this.fWT.Fk());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.fWT.Fk() != null && b.this.fWT.Fk().mLiveInfo != null) {
                    b.this.fWT.a(b.this.fWT.Fk().mLiveInfo.live_id, b.this.aWu, b.this.fXo);
                }
            }
        }, this.fWT.Fk().avn);
        if (z && this.fWT.Fk() != null && this.fWT.Fk().avj != null) {
            ax axVar = com.baidu.live.v.a.Ge().aYP;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && axVar != null && axVar.aAL != null && axVar.aAL.aCu) {
                c(true, this.fWT.Fk().avj.userId);
            }
        }
        this.fXa = false;
        if (z && this.fWT.Fk() != null && this.fWT.Fk().mLiveInfo != null && this.fWT.Fk().avj != null && this.gtb != null) {
            long j2 = this.fWT.Fk().mLiveInfo.live_id;
            long j3 = this.fWT.Fk().mLiveInfo.room_id;
            String str3 = this.fWT.Fk().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j2;
                if (ac.yz() != null) {
                    ac.yz().a(this.mTbPageContext.getPageActivity(), j2, str4, j3, str3, this.otherParams);
                }
                if (this.gtw != null) {
                    this.gtw.b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
                }
            }
            if (e.BG() != null) {
                e.BG().b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
            }
            if (this.gtk == null) {
                this.gtk = new com.baidu.tieba.ala.liveroom.i.a();
            }
            this.gtk.a(this.mTbPageContext.getPageActivity(), this.fWT.Fk(), this.otherParams);
        }
        if (this.gtl == null) {
            this.gtl = new com.baidu.tieba.ala.liveroom.t.b(this.mTbPageContext);
        }
        if (z && this.fWT.Fk() != null && this.fWT.Fk().avC != null && !this.gtm) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.gtl.a(this.fWT.Fk(), this.fWT.Fk().avC.userId);
                this.gtm = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJe() {
        if (this.gsV) {
            this.gsR.a(this.mSelectedPosition, bJc(), this.aJj);
            this.gsR.b(this.mSelectedPosition, bJd(), this.aJj);
            this.gsV = false;
        }
        if (this.gta != null && bJn()) {
            this.gta.V(this.fWT.bFo());
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
            this.mHandler.removeCallbacks(this.gtv);
            this.mHandler.postDelayed(this.gtv, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (kVar == null) {
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.gtu);
                this.mHandler.postDelayed(this.gtu, 5000L);
                return;
            }
            return;
        }
        if (!this.gsW) {
            c(kVar);
        }
        if (!this.isBackGround) {
            this.mHandler.removeCallbacks(this.gtu);
            this.mHandler.postDelayed(this.gtu, kVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJf() {
        if (this.fWT.Fk() != null && this.fWT.Fk().mLiveInfo != null) {
            this.fWT.f(this.fWT.Fk().mLiveInfo.live_id, !this.gtj);
            this.gtj = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.live_status == 2) {
            this.gsR.a(this.mSelectedPosition, this.fWT.Fk());
            d(qVar, false);
        } else if (qVar != null) {
            if (!this.gsW) {
                a(qVar);
            }
            if (!this.isBackGround) {
                this.mHandler.removeCallbacks(this.gtt);
                this.mHandler.postDelayed(this.gtt, qVar.avn);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJg() {
        if (this.mTbPageContext != null && this.fWT.Fk() != null && this.fWT.Fk().mLiveInfo != null) {
            this.fWT.a(this.fWT.Fk().mLiveInfo.live_id, this.aWu, this.fXo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(q qVar, boolean z) {
        View view = null;
        kw(true);
        if (!bJn()) {
            this.fWT.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.gsP != null) {
                this.gsP.Jh();
                this.gsP.bGN();
                this.gsP.bGU();
            }
            if (qVar != null && qVar.mLiveInfo != null) {
                this.gtd = qVar.mLiveInfo.live_id;
            }
            bIV();
            bJh();
            bJi();
            if (qVar != null) {
                if (this.gtb != null && this.gtb.bzq() != null) {
                    view = this.gtb.bzq().a(this.gtb.bzh().pageContext.getPageActivity(), qVar, z);
                }
                if (this.gsP != null) {
                    this.gta.a(this.gsP, view, qVar, z, this.fWT.bFo());
                }
                if (this.gtb != null) {
                    this.gtb.kw(false);
                    this.gtb.bzl();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.gsP != null) {
                    this.gsP.bGR();
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
                this.gth = new StayTimeBean();
                this.gth.liveId = qVar.mLiveInfo.live_id;
                this.gth.roomId = qVar.mLiveInfo.room_id;
                this.gth.vid = qVar.mLiveInfo.feed_id;
                this.gth.startTime = System.currentTimeMillis();
            }
            bJp();
            if (this.gsS != null) {
                this.gsS.a(this.aJj, this.gsT);
            }
        }
    }

    private void bJh() {
    }

    private void bJi() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.gsQ);
        }
    }

    public void bJj() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bJk();
        } else {
            bJl();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.fWT != null && this.fWT.Fk() != null) {
            alaLiveInfoData = this.fWT.Fk().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bJk();
        } else {
            bJl();
        }
        this.gsQ.setIsScrollable(!z && this.gtr);
        if (this.gtb != null) {
            this.gtb.onKeyboardVisibilityChanged(z);
        }
        if (this.fXk != null) {
            this.fXk.onKeyboardVisibilityChanged(z);
        }
    }

    public void cu(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bJk();
        } else {
            bJl();
        }
        this.fXk.cu(realScreenOrientation);
        rj(realScreenOrientation);
        if (ac.yz() != null) {
            ac.yz().ya();
        }
        if (this.gtk != null) {
            this.gtk.ya();
        }
        if (this.gsS != null) {
            this.gsS.cu(realScreenOrientation);
        }
    }

    public void bJk() {
        if (this.gsQ != null) {
            com.baidu.live.utils.h.T(this.gsQ);
        }
    }

    public void bJl() {
        if (this.gsQ != null) {
            com.baidu.live.utils.h.U(this.gsQ);
        }
    }

    public void onResume() {
        if (this.fWT != null) {
            this.fWT.bEW();
            this.fWT.bFa();
        }
        if (this.gtb != null) {
            this.gtb.enterForeground();
        }
        if (this.gtk != null) {
            this.gtk.onResume();
        }
        if (this.gtl != null) {
            this.gtl.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.u.a.eA(this.mTbPageContext.getPageActivity())) {
            if (this.isBackGround) {
                this.isBackGround = false;
                bJm();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void bJm() {
        bJg();
        bJf();
        this.fWT.bFn();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            this.gsU.bJs();
        } else if (!this.gsU.isPlaying()) {
            this.gsU.bJs();
        }
        if (this.gtb != null) {
            this.gtb.bzp();
        }
        if (this.fWT != null && this.fWT.Fk() != null && this.fWT.Fk().mLiveInfo != null) {
            this.gtg.dJ(this.fWT.Fk().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aJj.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.fWT != null) {
            this.fWT.bEX();
            this.fWT.bFb();
        }
        if (this.gtb != null) {
            this.gtb.enterBackground();
        }
    }

    public void lD(boolean z) {
        this.isBackGround = true;
        lE(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void lE(boolean z) {
        this.mHandler.removeCallbacks(this.gtt);
        this.mHandler.removeCallbacks(this.gtu);
        this.mHandler.removeCallbacks(this.gtv);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            this.gsU.avT();
        } else if (!z) {
            this.gsU.avT();
        }
        if (this.gtb != null) {
            this.gtb.bzo();
        }
        this.gtg.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ac.yz() != null) {
                ac.yz().a(i, i2, intent, this.aJj, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.gtb != null) {
            this.gtb.onActivityResult(i, i2, intent);
        }
    }

    public boolean bJn() {
        return this.gta != null && this.gta.btS();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gtA != null) {
            MessageManager.getInstance().unRegisterListener(this.gtA);
        }
        if (this.gtB != null) {
            MessageManager.getInstance().unRegisterListener(this.gtB);
        }
        MessageManager.getInstance().unRegisterListener(this.gtC);
        MessageManager.getInstance().unRegisterListener(this.fZe);
        MessageManager.getInstance().unRegisterListener(this.fZd);
        MessageManager.getInstance().unRegisterListener(this.gtD);
        MessageManager.getInstance().unRegisterListener(this.gtE);
        MessageManager.getInstance().unRegisterListener(this.gtF);
        if (this.gtw != null) {
            this.gtw.release();
        }
        if (this.gsU != null) {
            this.gsU.bW(true);
        }
        if (this.gsS != null) {
            this.gsS.onDestory();
        }
        if (this.gsT != null) {
            this.gsT.reset();
        }
        if (this.gtb != null) {
            this.gtb.onDestroy();
        }
        if (this.gsR != null) {
            this.gsR.onDestroy();
        }
        this.gsP.Jh();
        if (this.gsP != null) {
            this.gsP.release();
            this.gsP = null;
        }
        if (this.gta != null) {
            this.gta.onDestroy();
        }
        if (this.gth != null && this.fWT != null && this.fWT.Fk() != null) {
            long j = this.fWT.Fk().mLiveInfo.live_id;
            if (this.gth.liveId == j && this.gth.startTime > 0) {
                this.gth.endTime = System.currentTimeMillis();
                long j2 = this.gth.endTime - this.gth.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.gth.roomId + "", this.gth.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.gth = null;
        }
        if (this.fXk != null) {
            this.fXk.bGW();
            this.fXk = null;
        }
        if (this.fWT != null) {
            this.fWT.destory();
        }
        ILiveGoodsLogger.displayStoreIconMap.clear();
        ILiveGoodsLogger.displayGoodsListMap.clear();
        ILiveGoodsLogger.displayGoodsGuideMap.clear();
        m.HZ();
        com.baidu.live.entereffect.a.wD().release();
        t.yl().release();
        if (this.gtl != null) {
            this.gtl.release();
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String DN() {
        return this.otherParams;
    }

    public void bJo() {
        if (this.gte != null) {
            this.otherParams = this.gte.toString();
            if (this.fWT != null) {
                this.fWT.setOtherParams(this.otherParams);
            }
            if (this.gtb != null) {
                this.gtb.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.gta != null) {
                this.gta.setOtherParams(this.otherParams);
            }
        }
    }

    public void bJp() {
        if (this.gte != null) {
            String optString = this.gte.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gte.put("tab", "live_jump");
                        this.gte.put("tag", "");
                        this.gte.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.gte.put("tab", "liveroom");
                        this.gte.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bJo();
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

    public void bJq() {
        v.yv();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gtb.d(s);
        } else {
            this.gtb.e(s);
        }
    }
}
