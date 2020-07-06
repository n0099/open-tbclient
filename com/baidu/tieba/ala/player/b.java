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
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.core.layer.LayerRootView;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.ar;
import com.baidu.live.data.bb;
import com.baidu.live.data.bc;
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.t;
import com.baidu.live.gift.v;
import com.baidu.live.guardclub.e;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.p.h;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
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
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.m;
import com.baidu.live.utils.o;
import com.baidu.live.utils.p;
import com.baidu.tieba.ala.liveroom.i.g;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPager;
import com.baidu.tieba.ala.liveroom.livepager.AlaLoopViewPagerAdapter;
import com.baidu.tieba.ala.liveroom.n.c;
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
    private q aLQ;
    private String aZd;
    private long aZe;
    private com.baidu.live.p.b blk;
    private String fTa;
    private a gFC;
    private AlaLiveRoomBlurPageLayout gFD;
    private AlaLoopViewPager gFE;
    private AlaLoopViewPagerAdapter gFF;
    private com.baidu.tieba.ala.liveroom.d.a gFG;
    private com.baidu.tieba.ala.liveroom.d.b gFH;
    private SdkLivePlayer gFI;
    private AlaLastLiveroomInfo gFJ;
    private boolean gFK;
    private boolean gFL;
    private boolean gFM;
    private boolean gFN;
    private ArrayList<AlaBroadcastGiftToastData> gFO;
    private String gFP;
    private com.baidu.tieba.ala.endliveroom.a gFQ;
    private com.baidu.tieba.ala.liveroom.c.c gFR;
    private String gFS;
    private long gFT;
    private JSONObject gFU;
    private boolean gFV;
    private com.baidu.tieba.ala.liveroom.task.c gFW;
    private StayTimeBean gFX;
    private boolean gFY;
    private com.baidu.tieba.ala.liveroom.j.a gFZ;
    private com.baidu.tieba.ala.liveroom.u.b gGa;
    private boolean gGb;
    private boolean gGc;
    private String gGd;
    private boolean gGe;
    private bc gGf;
    private boolean gGg;
    private boolean gGh;
    private Runnable gGi;
    private Runnable gGj;
    private Runnable gGk;
    private com.baidu.live.x.c gGl;
    private com.baidu.live.p.a gGm;
    com.baidu.live.liveroom.a.c gGn;
    ViewPager.OnPageChangeListener gGo;
    HttpMessageListener gGp;
    CustomMessageListener gGq;
    CustomMessageListener gGr;
    CustomMessageListener gGs;
    CustomMessageListener gGt;
    private CustomMessageListener gGu;
    private com.baidu.tieba.ala.liveroom.n.c gjQ;
    private boolean gjX;
    private AlaLiveView gkj;
    private ViewGroup gkk;
    private LayerRootView gkl;
    private long gkp;
    private c.a gkz;
    private int glI;
    private Runnable gma;
    private HttpMessageListener gmd;
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
        this.gFK = true;
        this.gkp = 0L;
        this.gFL = false;
        this.gjX = true;
        this.aZd = "";
        this.mForumName = "";
        this.gFM = false;
        this.gFN = false;
        this.gFP = "0";
        this.mHandler = new Handler();
        this.gFT = -1L;
        this.otherParams = "";
        this.gFV = false;
        this.gFW = com.baidu.tieba.ala.liveroom.task.c.bJy();
        this.gFY = false;
        this.gGc = false;
        this.gGe = false;
        this.gGh = false;
        this.gGi = new Runnable() { // from class: com.baidu.tieba.ala.player.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.bMm();
            }
        };
        this.gGj = new Runnable() { // from class: com.baidu.tieba.ala.player.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.bMl();
            }
        };
        this.gGk = new Runnable() { // from class: com.baidu.tieba.ala.player.b.12
            @Override // java.lang.Runnable
            public void run() {
                b.this.gjQ.bIu();
            }
        };
        this.glI = 5000;
        this.blk = new com.baidu.live.p.b() { // from class: com.baidu.tieba.ala.player.b.13
            @Override // com.baidu.live.p.b
            public void bL(int i) {
                if (b.this.gFD != null) {
                    if (ListUtils.getCount(b.this.gFI.getAlaLiveInfoDataList()) < 2) {
                        b.this.gFD.bJX();
                    } else {
                        b.this.gFD.bJY();
                    }
                }
                if (b.this.gFR != null) {
                    b.this.gFR.bL(i);
                }
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.bMw();
                }
            }
        };
        this.gGm = new com.baidu.live.p.a() { // from class: com.baidu.tieba.ala.player.b.14
            @Override // com.baidu.live.p.a
            public void bX(boolean z) {
                if (!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && b.this.gFI != null) {
                    if (z) {
                        if (!b.this.gFI.isPlaying()) {
                            b.this.gFI.bMy();
                        }
                    } else if (b.this.gFI.isPlaying()) {
                        b.this.gFI.awZ();
                    }
                }
            }
        };
        this.gGn = new com.baidu.live.liveroom.a.c() { // from class: com.baidu.tieba.ala.player.b.16
            @Override // com.baidu.live.liveroom.a.c
            public void bQ(boolean z) {
                if (z || b.this.gFR == null || b.this.gFR.bBZ()) {
                    b.this.lL(true);
                    b.this.bzn();
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void bR(boolean z) {
                b.this.d(b.this.aLQ, z);
            }

            @Override // com.baidu.live.liveroom.a.c
            public void j(ArrayList<AlaLiveInfoData> arrayList) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer IAlaAudienceLiveStateCallback");
                }
                b.this.gFI.bMx();
                if (arrayList != null && !arrayList.isEmpty() && !b.this.gFM) {
                    if (b.this.gFM) {
                        b.this.gFI.setPlayLiveInfo(arrayList);
                    } else {
                        b.this.gFI.ab(arrayList);
                    }
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void e(boolean z, boolean z2) {
                if (b.this.gFE != null) {
                    b.this.gFE.setIsScrollable(b.this.gGg && z);
                    b.this.gFE.setEnabled(z2);
                }
            }

            @Override // com.baidu.live.liveroom.a.c
            public void bS(boolean z) {
                boolean z2 = true;
                if (!z || b.this.bMt()) {
                    if (b.this.gFD != null) {
                        b.this.gFD.bKa();
                        return;
                    }
                    return;
                }
                if (b.this.gjQ.FU().mLiveInfo.screen_direction != 2 || UtilHelper.getRealScreenOrientation(b.this.getPageContext().getPageActivity()) != 1) {
                    z2 = false;
                }
                if (b.this.gFD != null) {
                    b.this.gFD.lz(z2);
                }
            }
        };
        this.gGo = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.ala.player.b.17
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (b.this.mTbPageContext != null && b.this.mTbPageContext.getPageActivity() != null && !b.this.mTbPageContext.getPageActivity().isFinishing() && b.this.gkj != null) {
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        b.this.mTbPageContext.showToast(a.i.sdk_neterror);
                        b.this.gFE.setCurrentItem(b.this.mSelectedPosition);
                    } else if (b.this.gjX || ListUtils.getCount(b.this.gjQ.bIt()) > 1) {
                        int i2 = (i - b.this.mSelectedPosition == 2 || i - b.this.mSelectedPosition == -1) ? -1 : 1;
                        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && b.this.gjQ.bIw() == 1) {
                            if (!b.this.gjQ.bIz() || i2 >= 0) {
                                if (b.this.gjQ.bIA() && i2 > 0) {
                                    b.this.mTbPageContext.showToast(a.i.ala_live_no_next_liveroom_tip);
                                    b.this.gFE.setCurrentItem(b.this.mSelectedPosition);
                                    return;
                                }
                            } else {
                                b.this.mTbPageContext.showToast(a.i.ala_live_no_pre_liveroom_tip);
                                b.this.gFE.setCurrentItem(b.this.mSelectedPosition);
                                return;
                            }
                        }
                        if (BdLog.isDebugMode()) {
                            BdLog.e("AlaLivePlayer onPageChanged");
                        }
                        b.this.gjQ.cancelLoadData();
                        b.this.mHandler.removeCallbacksAndMessages(null);
                        b.this.kI(true);
                        b.this.gFD.bJV();
                        b.this.gFD.Ku();
                        b.this.gFD.bJW();
                        if (b.this.gjQ.FU() != null) {
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                HKStaticManager.staticEndPlayTime(b.this.gjQ.FU().mLiveInfo.live_id + "", b.this.gjQ.FU().mLiveInfo.room_id + "", b.this.gjQ.FU().axp.userId + "", b.this.gjQ.FU().axp.userName, System.currentTimeMillis(), b.this.gjQ.FU().mLiveInfo.feed_id, b.this.otherParams);
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                QMStaticManager.staticEndPlayTime(b.this.gjQ.FU().mLiveInfo.live_id + "", b.this.gjQ.FU().mLiveInfo.room_id + "", b.this.gjQ.FU().axp.userId + "", b.this.gjQ.FU().axp.userName, System.currentTimeMillis(), b.this.gjQ.FU().mLiveInfo.feed_id, b.this.otherParams);
                            }
                        }
                        if (b.this.gFX != null) {
                            long j = b.this.gjQ.FU().mLiveInfo.live_id;
                            if (b.this.gFX.liveId == j && b.this.gFX.startTime > 0) {
                                b.this.gFX.endTime = System.currentTimeMillis();
                                long j2 = b.this.gFX.endTime - b.this.gFX.startTime;
                                if (j2 < 0) {
                                    j2 = 0;
                                }
                                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", b.this.gFX.roomId + "", b.this.gFX.vid, j2 / 1000, b.this.otherParams);
                            }
                            b.this.gFX = null;
                        }
                        b.this.bMv();
                        if (b.this.gGl != null) {
                            b.this.gGl.release();
                        }
                        b.this.mSelectedPosition = i;
                        b.this.gFD = b.this.gFF.rC(b.this.mSelectedPosition);
                        b.this.gFD.bJZ();
                        b.this.sr(i2);
                    } else {
                        b.this.mTbPageContext.showToast(a.i.ala_live_room_no_more_list);
                        b.this.gFE.setCurrentItem(b.this.mSelectedPosition);
                        b.this.gjQ.g(b.this.gjQ.bIE());
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                com.baidu.live.c.vf().putBoolean("ala_live_play_has_up_down_scrolled", true);
            }
        };
        this.gkz = new c.a() { // from class: com.baidu.tieba.ala.player.b.18
            @Override // com.baidu.tieba.ala.liveroom.n.c.a
            public void a(int i, String str, int i2, Object obj) {
                if (i2 == 1) {
                    b.this.A(b.this.gjQ.FU());
                } else if (i2 == 2) {
                    b.this.f(b.this.gjQ.bwe());
                } else if (i2 == 3) {
                    b.this.aZ(i, str);
                } else if (i2 == 4) {
                    b.this.az(obj);
                } else if (i2 == 5) {
                    b.this.bMk();
                }
            }
        };
        this.gma = new Runnable() { // from class: com.baidu.tieba.ala.player.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                    if (b.this.gjQ != null && b.this.gjQ.FU() != null) {
                        Log.i("eventpolling", "@@@ polling run live_id=" + b.this.gjQ.FU().mLiveInfo.live_id + ", hd=" + b.this.mHandler + ",vc=" + b.this);
                        m.k(b.this.gjQ.FU().mLiveInfo.user_id, b.this.gjQ.FU().mLiveInfo.live_id);
                    }
                    if (b.this.mHandler != null) {
                        b.this.mHandler.postDelayed(b.this.gma, b.this.glI);
                    }
                }
            }
        };
        this.gGp = new HttpMessageListener(1021127) { // from class: com.baidu.tieba.ala.player.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021127 && (httpResponsedMessage instanceof ActivityTaskWatchHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                    ActivityTaskWatchHttpResponseMessage activityTaskWatchHttpResponseMessage = (ActivityTaskWatchHttpResponseMessage) httpResponsedMessage;
                    if (activityTaskWatchHttpResponseMessage.bJw() != null && b.this.mTbPageContext != null) {
                        b.this.gFW.a(b.this.mTbPageContext.getPageActivity(), activityTaskWatchHttpResponseMessage.bJw());
                    }
                }
            }
        };
        this.gGq = new CustomMessageListener(2913105) { // from class: com.baidu.tieba.ala.player.b.5
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
        this.gGr = new CustomMessageListener(2913110) { // from class: com.baidu.tieba.ala.player.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mTbPageContext != null && b.this.gjQ != null && b.this.gjQ.FU() != null && b.this.gjQ.FU().mLiveInfo != null) {
                    long j = b.this.gjQ.FU().mLiveInfo.live_id;
                    int[] iArr = null;
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof int[])) {
                        iArr = (int[]) customResponsedMessage.getData();
                    }
                    if (iArr == null || iArr.length != 2) {
                        iArr = new int[]{0, 0};
                    }
                    Log.i("LiveViewContr", "@@ appearFlower IconListener coord = [" + iArr[0] + Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + "]");
                    if (b.this.gGl != null) {
                        b.this.gGl.a(b.this.mTbPageContext.getPageActivity(), j, iArr);
                    }
                }
            }
        };
        this.gmd = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.player.b.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                    EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                    long j = b.this.gjQ.FU().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aZw != null && !eventPollingHttpResponseMessage.aZw.isEmpty() && b.this.gjQ != null && b.this.gjQ.FU() != null && b.this.gjQ.FU().mLiveInfo != null) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        for (int i = 0; i < eventPollingHttpResponseMessage.aZw.size(); i++) {
                            ar arVar = eventPollingHttpResponseMessage.aZw.get(i);
                            if (j == arVar.liveId && j2 - arVar.createTime <= 60 && !m.i(arVar.liveId, arVar.id)) {
                                m.a(arVar, b.this.gjQ.FU().mLiveInfo, false);
                                if (b.this.gFR != null) {
                                    b.this.gFR.a(arVar, b.this.gjQ.FU().mLiveInfo);
                                }
                                m.j(arVar.liveId, arVar.id);
                            }
                        }
                        ar arVar2 = eventPollingHttpResponseMessage.aZw.get(eventPollingHttpResponseMessage.aZw.size() - 1);
                        if (j == arVar2.liveId) {
                            m.h(arVar2.liveId, arVar2.id);
                        }
                    }
                    int i2 = eventPollingHttpResponseMessage.aZv;
                    if (i2 <= 0) {
                        i2 = 5;
                    }
                    b.this.glI = i2 * 1000;
                }
            }
        };
        this.gGs = new CustomMessageListener(2913117) { // from class: com.baidu.tieba.ala.player.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                    Long l = (Long) customResponsedMessage.getData();
                    if (b.this.mTbPageContext != null && b.this.gjQ != null && b.this.gjQ.FU() != null && b.this.gjQ.FU().axI != null) {
                        if (l.longValue() == b.this.gjQ.FU().axI.userId) {
                            b.this.gjQ.FU().axI.isNewUser = false;
                            if (b.this.gFZ != null) {
                                b.this.gFZ.t(b.this.gjQ.FU());
                            }
                        }
                    }
                }
            }
        };
        this.gGt = new CustomMessageListener(2913127) { // from class: com.baidu.tieba.ala.player.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.ala.liveroom.r.a)) {
                    com.baidu.tieba.ala.liveroom.r.a aVar2 = (com.baidu.tieba.ala.liveroom.r.a) customResponsedMessage.getData();
                    Long valueOf = Long.valueOf(aVar2.getUserId());
                    String wv = aVar2.wv();
                    if (b.this.mTbPageContext != null && b.this.gjQ != null && b.this.gjQ.FU() != null && b.this.gjQ.FU().axI != null) {
                        if (valueOf.longValue() == b.this.gjQ.FU().axI.userId && com.baidu.live.v.a.Hm().bdV != null && com.baidu.live.v.a.Hm().bdV.aCR != null && com.baidu.live.v.a.Hm().bdV.aCR.wR()) {
                            g.rv(2913128);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913128, wv));
                        }
                    }
                }
            }
        };
        this.gGu = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.player.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.mHandler != null && b.this.gGi != null) {
                    b.this.mHandler.removeCallbacks(b.this.gGi);
                }
                b.this.bMm();
            }
        };
        this.gkp = System.currentTimeMillis() / 1000;
        this.mTbPageContext = tbPageContext;
        this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        this.gFC = aVar;
        this.gFK = true;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913136, com.baidu.live.x.c.class);
        if (runTask != null) {
            this.gGl = (com.baidu.live.x.c) runTask.getData();
        }
        this.gjQ = new com.baidu.tieba.ala.liveroom.n.c(getPageContext());
        this.gjQ.a(this.gkz);
        this.gFQ = new com.baidu.tieba.ala.endliveroom.a(this.mTbPageContext);
        MessageManager.getInstance().registerListener(this.gGp);
        MessageManager.getInstance().registerListener(this.gGq);
        MessageManager.getInstance().registerListener(this.gGr);
        MessageManager.getInstance().registerListener(this.gmd);
        MessageManager.getInstance().registerListener(this.gGs);
        MessageManager.getInstance().registerListener(this.gGt);
        MessageManager.getInstance().registerListener(this.gGu);
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
                        this.gFO = new ArrayList<>(length);
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                                alaBroadcastGiftToastData.parserJson(optJSONObject);
                                this.gFO.add(alaBroadcastGiftToastData);
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
        this.aZd = intent.getStringExtra("live_from_type");
        if (TextUtils.isEmpty(this.aZd)) {
            this.aZd = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK;
        }
        this.mUrl = intent.getStringExtra("live_entry_live_url");
        this.uk = intent.getStringExtra("uk");
        this.gFS = intent.getStringExtra("room_id");
        this.aZe = intent.getLongExtra("live_id", 0L);
        this.gFV = false;
        Serializable serializableExtra = intent.getSerializableExtra("live_info_core");
        if (serializableExtra != null && (serializableExtra instanceof AlaLiveInfoCoreData)) {
            this.gjQ.b((AlaLiveInfoCoreData) serializableExtra);
            this.gFV = true;
        }
        Q(intent);
        this.gGg = this.gGf == null || !this.gGf.aDh;
        this.gFQ.setOtherParams(this.otherParams);
        this.gFN = intent.getBooleanExtra("live_forbid_vertical_change_liveroom", false);
        bLX();
        bLW();
    }

    private void Q(Intent intent) {
        String str = null;
        try {
            AlaLiveSwitchData.isHotLive = 0;
            AlaLiveSwitchData.liveActivityType = "";
            this.fTa = null;
            String stringExtra = intent.getStringExtra("params");
            Log.i("LivePlayerActivity", "@@ params = " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.otherParams = stringExtra;
                this.gFU = new JSONObject(stringExtra);
                if (this.gFU != null) {
                    String optString = this.gFU.optString("enterRoomId");
                    String optString2 = this.gFU.optString("enterLiveId");
                    if ((!TextUtils.isEmpty(optString) && TextUtils.equals(this.gFS, optString)) || (!TextUtils.isEmpty(optString2) && TextUtils.equals(this.aZe + "", optString2))) {
                        String optString3 = this.gFU.optString("cover");
                        String decode = !TextUtils.isEmpty(optString3) ? URLDecoder.decode(optString3, "UTF-8") : optString3;
                        Log.i("LivePlayerActivity", "@@ coverUrl = " + decode);
                        String optString4 = this.gFU.optString("live_url");
                        if (!TextUtils.isEmpty(optString4)) {
                            optString4 = URLDecoder.decode(optString4, "UTF-8");
                        }
                        Log.i("LivePlayerActivity", "@@ liveUrl = " + optString4);
                        if (!this.gFV) {
                            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                            alaLiveInfoCoreData.liveID = this.aZe;
                            alaLiveInfoCoreData.screenDirection = this.gFU.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, 1);
                            if (!TextUtils.isEmpty(decode)) {
                                alaLiveInfoCoreData.liveCover = decode;
                            }
                            a(optString4, alaLiveInfoCoreData);
                            this.gjQ.b(alaLiveInfoCoreData);
                            this.gFV = true;
                        }
                    }
                    String optString5 = this.gFU.optString("extra");
                    if (TextUtils.isEmpty(optString5)) {
                        this.gGf = null;
                    } else {
                        JSONObject jSONObject = new JSONObject(optString5);
                        String optString6 = jSONObject.optString("live_active_params");
                        if (!TextUtils.isEmpty(optString6) && this.gjQ != null) {
                            this.gjQ.CD(optString6);
                        }
                        AlaLiveSwitchData.liveActivityType = jSONObject.optString(HttpRequest.SDK_LIVE_LIVE_ACTIVITY_TYPE);
                        this.fTa = jSONObject.optString("live_back_scheme");
                        this.gGf = new bc();
                        this.gGf.aDh = jSONObject.optInt("is_hot") == 1;
                        if (this.gGf.aDh) {
                            AlaLiveSwitchData.isHotLive = 1;
                        } else {
                            AlaLiveSwitchData.isHotLive = 0;
                        }
                        this.gGf.aDi = jSONObject.optString("task_id");
                        this.gGf.aDg = !TextUtils.isEmpty(this.gGf.aDi);
                        this.gGf.aDj = jSONObject.optInt("task_type");
                        this.gGf.aDk = jSONObject.optInt("task_im_count");
                        this.gGf.aDl = jSONObject.optLong("task_gift_total_price");
                        this.gGf.aDm = jSONObject.optLong("task_watch_time");
                        this.gGf.aDn = jSONObject.optString("task_activity_scheme");
                        str = jSONObject.optString("from");
                        String optString7 = jSONObject.optString("back_app_scheme");
                        String optString8 = jSONObject.optString("back_app_icon");
                        String optString9 = jSONObject.optString("back_app_text");
                        if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                            this.gFH = new com.baidu.tieba.ala.liveroom.d.b();
                            this.gFH.setScheme(optString7);
                            this.gFH.setImageUrl(optString8);
                            this.gFH.setTitle(optString9);
                        }
                    }
                    this.gFP = this.gFU.optString(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gFU.remove("cover");
                    this.gFU.remove("live_url");
                    this.gFU.remove("enterRoomId");
                    this.gFU.remove("enterLiveId");
                    this.gFU.remove(AlaLiveRoomActivityConfig.LIVE_SHOW_GITE_PANEL);
                    this.gFU.remove("extra");
                    this.otherParams = this.gFU.toString();
                    this.gjQ.setOtherParams(this.otherParams);
                    this.gFU.optString("live_enter_type");
                    if (TextUtils.isEmpty(str)) {
                        str = this.gFU.optString("from");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.gFU.optString("live_enter_type");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = this.gFU.optString("source");
                    }
                    this.gGh = "mobilebaidu_subscription".equals(str);
                    int optInt = this.gFU.optInt(AlaLiveRoomActivityConfig.SDK_EXTRA_RECOMMEND_TYPE);
                    if (!TextUtils.isEmpty(str)) {
                        TbConfig.setLiveEnterFrom(str);
                    } else {
                        TbConfig.setLiveEnterFrom(AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                    }
                    this.gjQ.rT(optInt);
                }
            } else {
                this.otherParams = "";
            }
            String stringExtra2 = intent.getStringExtra(AlaLiveRoomActivityConfig.LAST_LIVE_INFO);
            if (!StringUtils.isNull(stringExtra2)) {
                this.gFJ = new AlaLastLiveroomInfo();
                this.gFJ.parseJson(stringExtra2);
            }
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

    public void bLW() {
        if (!TextUtils.isEmpty(this.uk)) {
            this.gjQ.ag(this.uk, this.aZd, this.mForumName);
        } else if (this.gjQ.FU() != null && this.gjQ.FU().mLiveInfo != null && this.gjQ.FU().mLiveInfo.live_id > 0) {
            this.gjQ.a(this.gjQ.FU().mLiveInfo.live_id, false, this.aZd, this.mForumName);
        } else if (!TextUtils.isEmpty(this.mUrl)) {
            String lowerCase = this.mUrl.toLowerCase();
            if (lowerCase.contains("uk=")) {
                this.uk = WebviewHelper.getMatchStringFromURL(lowerCase, "uk=");
            }
            if (lowerCase.contains("from=")) {
                this.aZd = WebviewHelper.getMatchStringFromURL(lowerCase, "from=");
            }
            if (this.uk == null) {
                this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
                lL(false);
                return;
            }
            this.gjQ.ag(this.uk, this.aZd, this.mForumName);
        } else if (!TextUtils.isEmpty(this.gFS)) {
            this.gjQ.Db(this.gFS);
        } else if (this.aZe > 0) {
            this.gjQ.a(this.aZe, false, this.aZd, "");
        } else {
            this.mTbPageContext.showToast(this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_entry_live_failed));
            lL(false);
        }
    }

    private void bLX() {
        this.gjX = true;
        this.gFL = false;
        bLY();
        Rect visibilityRegion = ViewCommonUtil.getVisibilityRegion(this.mTbPageContext.getPageActivity());
        c(visibilityRegion);
        d(visibilityRegion);
        com.baidu.live.core.layer.b.wk().k(this.gkl);
        this.gFR = new com.baidu.tieba.ala.liveroom.c.c();
        this.gFR.a(this.gGn);
        this.gFR.setOtherParams(this.otherParams);
        this.gFR.kE(this.gGh);
        bMa();
        bLZ();
    }

    private void bLY() {
        TiebaInitialize.log("c11863");
        View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_main_layout, (ViewGroup) null);
        this.gFE = (AlaLoopViewPager) inflate.findViewById(a.g.ala_loop_view_pager);
        this.gFE.setOnPageChangeListener(this.gGo);
        this.gFE.setBoundaryCaching(true);
        this.gFE.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_333333));
        this.mTbPageContext.getPageActivity().addContentView(inflate, new LinearLayout.LayoutParams(-1, -1));
        this.gFF = new AlaLoopViewPagerAdapter(this.mTbPageContext);
        this.gFF.bFM();
        this.gFD = this.gFF.rB(this.mSelectedPosition);
        this.gFF.a(this.mSelectedPosition, this.gjQ.FU());
        this.gFE.setAdapter(this.gFF);
        this.gFE.setCurrentItem(this.mSelectedPosition);
        this.gFE.setIsScrollable(this.gGg);
        this.gkk = (ViewGroup) inflate.findViewById(a.g.func_view);
        this.gkl = (LayerRootView) inflate.findViewById(a.g.layer_root_view);
    }

    private void c(Rect rect) {
        this.gFI = SdkLivePlayer.eD(getPageContext().getPageActivity());
        if (this.gFI == null) {
            this.gFE.setIsScrollable(false);
            if (this.gjQ != null) {
                this.gjQ.cancelLoadData();
            }
            bFP();
            return;
        }
        if (this.gFN) {
            this.gFE.setIsScrollable(false);
        }
        this.gFI.setBackgroundColor(this.mTbPageContext.getResources().getColor(a.d.sdk_transparent));
        this.gFI.setIPlayerCallBack(this.blk);
        this.gFI.setIPlayerAudioFocusCallBack(this.gGm);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gFD.a(this.gFI, layoutParams, true);
    }

    private void bLZ() {
        this.gFG = new com.baidu.tieba.ala.liveroom.d.a(this.mTbPageContext, this.gkk);
    }

    private void bFP() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(this.mTbPageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.ala_live_create_error);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.player.b.15
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                b.this.lL(false);
            }
        });
        bdAlertDialog.create(this.mTbPageContext).show();
    }

    private void d(Rect rect) {
        this.gkj = (AlaLiveView) View.inflate(this.mTbPageContext.getPageActivity(), a.h.ala_liveroom_player_layout, null);
        this.gkj.setSwipeClearEnable(true);
        this.gkj.guc = true;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = rect.height();
        layoutParams.width = rect.width();
        this.gFD.a(this.gkj, layoutParams);
    }

    private void bMa() {
        if (this.gjQ != null && this.gjQ.FU() != null) {
            this.aLQ = this.gjQ.FU();
            if (this.aLQ.mLiveInfo != null) {
                a(this.aLQ.mLiveInfo, this.gFV);
                if (this.aLQ.mLiveInfo != null && this.aLQ.mLiveInfo.session_info != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer tryStartPlayAtInit" + this.gFM);
                    }
                    if (!this.gFM) {
                        this.gFI.c(this.aLQ.mLiveInfo);
                    } else {
                        this.gFI.setPlayLiveInfo(this.aLQ.mLiveInfo);
                    }
                    if (this.gFR != null) {
                        this.gFR.a(this.mTbPageContext, this.gkj, this.gFI, this.gFD, this.gjQ, this.aZd, this.gFN, this.gkp, this.gFO, this.gGf);
                        j(this.aLQ.mLiveInfo.screen_direction == 2 ? (short) 1 : (short) 2);
                    }
                }
            }
        }
    }

    private void bMb() {
        if (this.mTbPageContext.getPageActivity() != null) {
            if (this.gFN || !this.gGg) {
                this.gFE.setIsScrollable(false);
            } else {
                this.gFE.setIsScrollable(true);
            }
            this.mTbPageContext.getPageActivity().setRequestedOrientation(1);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !com.baidu.live.core.layer.b.wk().onBackPressed() && ((this.gFR == null || !this.gFR.onKeyDown(i, keyEvent)) && (this.gFR == null || !this.gFR.bBY()))) {
            if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
                bMb();
            } else if (this.gFR == null || this.gFR.bBZ()) {
                lL(true);
                bzn();
            }
        }
        return true;
    }

    public void bzn() {
        if (!TextUtils.isEmpty(this.fTa)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.fTa);
                this.fTa = null;
            }
        }
    }

    public void lL(boolean z) {
        L(z, false);
    }

    public void L(boolean z, boolean z2) {
        kI(!z);
        if (this.gFI != null) {
            this.gFI.destroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        bMd();
        long j = -1;
        if (this.gjQ != null && this.gjQ.bIE() != null) {
            j = this.gjQ.bIE().room_id;
        }
        this.gFC.a(z, z2, j);
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
        UbcStatisticManager.getInstance().clear();
    }

    public void kI(boolean z) {
        TbadkCoreApplication.sAlaLiveSwitchData = null;
        this.gFJ = null;
        if (ac.yZ() != null) {
            ac.yZ().yY();
        }
        if (this.gGl != null) {
            this.gGl.release();
        }
        if (this.gFZ != null) {
            this.gFZ.release();
        }
        this.gGf = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
        if (this.gjQ != null) {
            this.gjQ.CD(null);
            AlaLiveInfoData bIE = this.gjQ.bIE();
            if (bIE != null) {
                this.gjQ.dJ(bIE.live_id);
            }
        }
        this.gFW.stopRecord();
        LiveTimerManager.getInstance().stop();
        bMc();
        if (this.gFI != null) {
            this.gFI.bY(z);
        }
        if (this.gFR != null) {
            this.gFR.kI(z);
        }
        this.gFY = false;
        AlaLiveSwitchData.isHotLive = 0;
        AlaLiveSwitchData.liveActivityType = "";
        if (com.baidu.live.liveroom.a.b.Fs().aYz != null) {
            com.baidu.live.liveroom.a.b.Fs().aYz.b(this.aLQ.mLiveInfo);
        }
    }

    private void bMc() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER));
    }

    private void bMd() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913084));
    }

    private void a(q qVar) {
        if (qVar != null) {
            this.aLQ = qVar;
            if (this.gFR != null) {
                this.gFR.a(qVar);
            }
        }
    }

    private void c(k kVar) {
        if (this.gFR != null) {
            this.gFR.c(kVar);
        }
    }

    private void z(q qVar) {
        this.aLQ = qVar;
    }

    private void bMe() {
        long j;
        String str;
        String str2;
        if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            this.gFE.setIsScrollable(false);
            this.gGg = false;
        }
        if (this.aLQ != null) {
            a(this.aLQ.mLiveInfo, false);
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLivePlayer->addPlayerView used By updateLiveRoomViewAfterEnterLive");
            }
            this.gFD.a(this.gkj, null);
            a(this.gFD, this.aLQ.mLiveInfo, this.gjX);
            UbcStatisticManager.getInstance().updateLiveRoom(String.valueOf(this.aLQ.mLiveInfo.live_id), String.valueOf(this.aLQ.mLiveInfo.room_id), String.valueOf(this.aLQ.mLiveInfo.feed_id), bMf());
            if (com.baidu.live.liveroom.a.b.Fs().aYz != null) {
                com.baidu.live.liveroom.a.b.Fs().aYz.a(this.aLQ.mLiveInfo);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1391, "read", "liveroom", ""));
            this.gjX = false;
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_FIRST_PLAY);
                long j2 = -1;
                if (this.gjQ != null && this.gjQ.FU() != null && this.gjQ.FU().mLiveInfo != null) {
                    j = this.gjQ.FU().mLiveInfo.live_id;
                    str2 = this.gjQ.FU().mLiveInfo.room_id + "";
                    str = this.gjQ.FU().mLiveInfo.feed_id;
                } else {
                    if (this.aZe > 0) {
                        j2 = this.aZe;
                    }
                    if (!TextUtils.isEmpty(this.gFS)) {
                        j = j2;
                        str = "";
                        str2 = this.gFS;
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
                if (this.gjQ != null && this.gjQ.FU() != null && this.gjQ.FU().mLiveInfo != null) {
                    str3 = this.gjQ.FU().mLiveInfo.feed_id;
                    str4 = this.gjQ.FU().mLiveInfo.live_id + "";
                    str5 = this.gjQ.FU().mLiveInfo.room_id + "";
                    str6 = this.gjQ.FU().mLiveInfo.user_name;
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

    private String bMf() {
        if (this.gFU == null) {
            return null;
        }
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
            String optString = this.gFU.optString("source");
            String optString2 = this.gFU.optString("tab");
            return optString2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.gFU.optString("tag") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + optString;
        }
        String optString3 = this.gFU.optString("live_enter_type");
        if (TextUtils.isEmpty(optString3)) {
            this.gFU.optString("from");
            return optString3;
        }
        return optString3;
    }

    public void a(AlaLiveRoomBlurPageLayout alaLiveRoomBlurPageLayout, AlaLiveInfoData alaLiveInfoData, boolean z) {
        if (this.gFI != null && this.gFI.getParent() != null) {
            if (alaLiveInfoData != null) {
                String videoPath = this.gFI.getVideoPath();
                String d = h.d(alaLiveInfoData);
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,mLivePlayer.isPlaying()=" + this.gFI.isPlaying() + "|curPlayLiveUrl=" + videoPath + "|nextPlayLiveUrl=" + d);
                }
                if (h.aA(videoPath, d)) {
                    this.gFI.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else if (TbadkCoreApplication.getInst().isTieba() && z && h.az(videoPath, d)) {
                    this.gFI.setPlayLiveInfo(alaLiveInfoData);
                    return;
                } else {
                    if (!z && !alaLiveRoomBlurPageLayout.bK(this.gFI)) {
                        ((ViewGroup) this.gFI.getParent()).removeView(this.gFI);
                        alaLiveRoomBlurPageLayout.a(this.gFI, null, false);
                    }
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer onPageChange,parent not null, startLivePlay");
                    }
                    if (!this.gFM) {
                        this.gFI.c(alaLiveInfoData);
                        return;
                    } else {
                        this.gFI.setPlayLiveInfo(alaLiveInfoData);
                        return;
                    }
                }
            }
            this.gFI.bMx();
        } else if (this.gFI != null && this.gFI.getParent() == null) {
            alaLiveRoomBlurPageLayout.a(this.gFI, null, false);
            if (alaLiveInfoData != null) {
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer onPageChange,parent is null");
                }
                if (!this.gFM) {
                    this.gFI.c(alaLiveInfoData);
                } else {
                    this.gFI.setPlayLiveInfo(alaLiveInfoData);
                }
            }
        }
    }

    public void a(int[] iArr, boolean z, int i, int i2, int i3) {
        FrameLayout.LayoutParams b = b(iArr, z, i, i2, i3);
        if (this.gFI != null) {
            this.gFI.setLayoutParams(b);
        }
    }

    private FrameLayout.LayoutParams b(int[] iArr, boolean z, int i, int i2, int i3) {
        int dimensionPixelSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (z) {
            if (i2 == 1) {
                layoutParams.width = o.r(this.mTbPageContext.getPageActivity());
                layoutParams.height = o.s(this.mTbPageContext.getPageActivity());
                int az = o.az(this.mTbPageContext.getPageActivity());
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    dimensionPixelSize = az + i;
                } else {
                    dimensionPixelSize = az + this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
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

    public void bMg() {
        this.gjX = true;
    }

    public boolean bMh() {
        return this.gjX;
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
                this.gFD.setBackgroundColor(this.mTbPageContext.getPageActivity().getResources().getColor(a.d.sdk_color_2F2B3D));
            } else {
                this.gFD.setBackgroundColor(0);
            }
        } else {
            this.gFD.setBackgroundColor(0);
        }
        int i2 = this.gFI.getLayoutParams().width;
        int i3 = this.gFI.getLayoutParams().height;
        int i4 = this.gFI.getLayoutParams() instanceof FrameLayout.LayoutParams ? ((FrameLayout.LayoutParams) this.gFI.getLayoutParams()).topMargin : 0;
        FrameLayout.LayoutParams b = b(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (b.width != i2 || b.height != i3 || b.topMargin != i4) {
            a(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        }
        FrameLayout.LayoutParams c = c(screenFullSize, z2, statusBarHeight, realScreenOrientation, dip2px);
        if (this.gkj != null) {
            this.gkj.setLayoutParams(c);
        }
        if (this.gFD != null) {
            this.gFD.bt(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gFQ != null) {
            this.gFQ.bt(screenFullSize[0], screenFullSize[1]);
        }
        if (this.gFR != null) {
            this.gFR.l(c.width, c.height, realScreenOrientation);
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

    private void sq(int i) {
        boolean z = true;
        if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
            this.gFD.setBgImageUrl(this.aLQ.mLiveInfo.cover, this.aLQ.mLiveInfo);
            this.gFF.a(this.mSelectedPosition, bMi(), this.aLQ);
            this.gFF.b(this.mSelectedPosition, bMj(), this.aLQ);
            this.gFD.requestLayout();
            this.gFD.I(i, this.aLQ.mLiveInfo.screen_direction == 2);
        }
        if (this.aLQ != null) {
            a(this.aLQ.mLiveInfo, false);
        }
        boolean bKb = this.gFD.bKb();
        boolean z2 = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 1;
        if (this.aLQ == null || this.aLQ.mLiveInfo == null || this.aLQ.mLiveInfo.screen_direction != 2 || !z2) {
            z = false;
        }
        if (!bMt()) {
            if (this.gFI != null && this.gFI.getParent() == null) {
                this.gFD.a(this.gFI, null, false);
                if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer resetLiveRoomUI");
                    }
                    if (!this.gFM) {
                        this.gFI.c(this.aLQ.mLiveInfo);
                    } else {
                        this.gFI.setPlayLiveInfo(this.aLQ.mLiveInfo);
                    }
                }
            }
            if (bKb && !bMt() && this.gFR != null) {
                this.gFD.lz(z);
                return;
            }
            return;
        }
        this.gFD.bJV();
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

    private void i(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.gjQ.a(alaLiveInfoData.live_id, true, this.aZd, this.mForumName);
        }
    }

    public void sr(int i) {
        if (i < 0) {
            this.gjQ.rU(this.gjQ.bIB() - 1);
        } else if (i > 0) {
            this.gjQ.rU(this.gjQ.bIB() + 1);
        }
        if (this.gFR != null) {
            this.gFR.a(this.gFD);
        }
        this.gFF.a(this.mSelectedPosition, bMi(), this.aLQ);
        this.gFF.b(this.mSelectedPosition, bMj(), this.aLQ);
        if (TbadkCoreApplication.getInst().isQuanmin() && this.gjQ != null) {
            int bIB = this.gjQ.bIB();
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_ON_PAGE_SELECTED);
            alaStaticItem.addParams("pos", bIB + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            if (this.gjQ.bIt() != null && this.gjQ.bIt().size() > bIB && this.gjQ.bIt().get(bIB) != null) {
                AlaLiveInfoData alaLiveInfoData = this.gjQ.bIt().get(bIB);
                alaStaticItem.addParams("feed_id", alaLiveInfoData.feed_id);
                alaStaticItem.addParams("room_id", alaLiveInfoData.room_id);
                alaStaticItem.addParams("live_id", alaLiveInfoData.live_id);
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gjQ != null) {
            AlaLiveInfoData bIE = this.gjQ.bIE();
            if (bIE != null) {
                bIE.hasRead = true;
                if (BdLog.isDebugMode()) {
                    BdLog.e("AlaLivePlayer->addPlayerView used By onPageChanged()");
                }
                a(this.gFD, bIE, this.gjX);
                this.gjX = false;
                if (this.gFR != null) {
                    this.gFR.a(this.mTbPageContext, this.gkj, this.gFI, this.gFD, this.gjQ, this.aZd, this.gFN, this.gkp, null, this.gGf);
                    short s = 2;
                    if (bIE.screen_direction == 2) {
                        s = 1;
                    }
                    j(s);
                }
                a(bIE, false);
            }
            i(bIE);
            this.gFD.a(this.gkj, null);
            if (this.gFR != null) {
                this.gFR.bBW();
            }
            this.gjQ.g(bIE);
        }
    }

    private AlaLiveInfoData bMi() {
        List<AlaLiveInfoData> bIt = this.gjQ.bIt();
        if (bIt == null || bIt.size() == 0) {
            if (this.aLQ == null) {
                return null;
            }
            return this.aLQ.mLiveInfo;
        }
        int bIB = this.gjQ.bIB();
        int size = bIt.size();
        return bIt.get(((bIB + size) - 1) % size);
    }

    private AlaLiveInfoData bMj() {
        List<AlaLiveInfoData> bIt = this.gjQ.bIt();
        if (bIt == null || bIt.size() == 0) {
            if (this.aLQ == null) {
                return null;
            }
            return this.aLQ.mLiveInfo;
        }
        return bIt.get((this.gjQ.bIB() + 1) % bIt.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(int i, String str) {
        if (i != 0 && this.mTbPageContext != null) {
            if (!this.gFM) {
                if (TextUtils.isEmpty(str)) {
                    this.mTbPageContext.showToast(a.i.sdk_no_network_guide);
                } else {
                    this.mTbPageContext.showToast(str);
                    if (BdLog.isDebugMode()) {
                        BdLog.e("AlaLivePlayer " + str + "Enter Live Fail" + i);
                    }
                }
            }
            lL(false);
            return;
        }
        q FU = this.gjQ.FU();
        z(FU);
        this.gjQ.bIu();
        if (this.gjX) {
            this.gjQ.lr(false);
        }
        this.gkp = System.currentTimeMillis() / 1000;
        if (this.gFR != null) {
            this.gFR.a(this.mTbPageContext, this.gkj, this.gFI, this.gFD, this.gjQ, this.aZd, this.gFN, this.gkp, this.gFO, this.gGf);
            short s = 2;
            if (FU.mLiveInfo.screen_direction == 2) {
                s = 1;
            }
            j(s);
        }
        bMe();
        if (FU != null && FU.mLiveInfo != null && FU.mLiveInfo.live_status == 2) {
            this.gFF.a(this.mSelectedPosition, this.gjQ.FU());
            d(FU, false);
            this.gjX = false;
            return;
        }
        boolean z = (this.gFR == null || TbadkCoreApplication.getInst().isOther()) ? false : true;
        if (z && (!this.gGc || !TextUtils.equals(p.Jr(), this.gGd))) {
            v.b(getPageContext(), false);
            com.baidu.live.v.c.Hr().Hs();
            this.gGc = true;
            this.gGd = p.Jr();
        }
        if (!this.gGe) {
            this.gGe = true;
            com.baidu.live.entereffect.a.xa().aZ(false);
        }
        if (this.gjQ.FU() != null && this.gjQ.FU().mLiveInfo != null) {
            this.gjQ.f(this.gjQ.FU().mLiveInfo.live_id, !this.gFY);
            this.gFY = true;
        }
        if (this.gFR != null) {
            this.gFR.b(this.gFJ);
            this.gFR.kH(TextUtils.equals(this.gFP, "1"));
            this.gFP = "";
        }
        if (z && this.gjQ.FU() != null && this.gjQ.FU().mLiveInfo != null) {
            String str2 = this.gjQ.FU().mLiveInfo.feed_id;
            long j = this.gjQ.FU().mLiveInfo.live_id;
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                Log.i("eventpolling", "@@@ polling init live_id=" + j + ", hd=" + this.mHandler + ",vc=" + this);
                this.mHandler.post(this.gma);
            }
        }
        if (this.gFG != null) {
            this.gFG.a(this.aLQ, this.gFH);
        }
        a(this.gjQ.FU());
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.player.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.mTbPageContext != null && b.this.gjQ.FU() != null && b.this.gjQ.FU().mLiveInfo != null) {
                    b.this.gjQ.a(b.this.gjQ.FU().mLiveInfo.live_id, b.this.aZd, b.this.gkp);
                }
            }
        }, this.gjQ.FU().axt);
        if (z && this.gjQ.FU() != null && this.gjQ.FU().axp != null) {
            bb bbVar = com.baidu.live.v.a.Hm().bdV;
            if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isGuardFansUnabled()) && bbVar != null && bbVar.aCW != null && bbVar.aCW.aEL) {
                c(true, this.gjQ.FU().axp.userId);
            }
        }
        this.gjX = false;
        if (z && this.gjQ.FU() != null && this.gjQ.FU().mLiveInfo != null && this.gjQ.FU().axp != null && this.gFR != null) {
            long j2 = this.gjQ.FU().mLiveInfo.live_id;
            long j3 = this.gjQ.FU().mLiveInfo.room_id;
            String str3 = this.gjQ.FU().mLiveInfo.feed_id;
            if (!(TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isCashGiftUnabled())) {
                String str4 = "oneYuanGift_" + j2;
                if (ac.yZ() != null) {
                    ac.yZ().a(this.mTbPageContext.getPageActivity(), j2, str4, j3, str3, this.otherParams);
                }
                if (this.gGl != null) {
                    this.gGl.b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
                }
            }
            if (e.Cg() != null) {
                e.Cg().b(this.mTbPageContext.getPageActivity(), j2, j3, str3, this.otherParams);
            }
            if (this.gFZ == null) {
                this.gFZ = new com.baidu.tieba.ala.liveroom.j.a();
            }
            this.gFZ.a(this.mTbPageContext.getPageActivity(), this.gjQ.FU(), this.otherParams);
        }
        if (this.gGa == null) {
            this.gGa = new com.baidu.tieba.ala.liveroom.u.b(this.mTbPageContext);
        }
        if (z && this.gjQ.FU() != null && this.gjQ.FU().axI != null && !this.gGb) {
            TbadkCoreApplication.getInst();
            if (TbadkCoreApplication.isLogin()) {
                this.gGa.a(this.gjQ.FU(), this.gjQ.FU().axI.userId);
                this.gGb = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMk() {
        if (this.gFK) {
            this.gFF.a(this.mSelectedPosition, bMi(), this.aLQ);
            this.gFF.b(this.mSelectedPosition, bMj(), this.aLQ);
            this.gFK = false;
        }
        if (this.gFQ != null && bMt()) {
            this.gFQ.V(this.gjQ.bIv());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(Object obj) {
        long j;
        if (obj == null || !(obj instanceof Long) || ((Long) obj).longValue() < 5000) {
            j = 5000;
        } else {
            j = ((Long) obj).longValue();
        }
        if (!this.gFM) {
            this.mHandler.removeCallbacks(this.gGk);
            this.mHandler.postDelayed(this.gGk, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (kVar == null) {
            if (!this.gFM) {
                this.mHandler.removeCallbacks(this.gGj);
                this.mHandler.postDelayed(this.gGj, 5000L);
                return;
            }
            return;
        }
        if (!this.gFL) {
            c(kVar);
        }
        if (!this.gFM) {
            this.mHandler.removeCallbacks(this.gGj);
            this.mHandler.postDelayed(this.gGj, kVar.getInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMl() {
        if (this.gjQ.FU() != null && this.gjQ.FU().mLiveInfo != null) {
            this.gjQ.f(this.gjQ.FU().mLiveInfo.live_id, !this.gFY);
            this.gFY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.live_status == 2) {
            this.gFF.a(this.mSelectedPosition, this.gjQ.FU());
            d(qVar, false);
        } else if (qVar != null) {
            if (!this.gFL) {
                a(qVar);
            }
            if (!this.gFM) {
                this.mHandler.removeCallbacks(this.gGi);
                this.mHandler.postDelayed(this.gGi, qVar.axt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMm() {
        if (this.mTbPageContext != null && this.gjQ.FU() != null && this.gjQ.FU().mLiveInfo != null) {
            this.gjQ.a(this.gjQ.FU().mLiveInfo.live_id, this.aZd, this.gkp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(q qVar, boolean z) {
        View view = null;
        kI(true);
        if (!bMt()) {
            this.gjQ.cancelLoadData();
            this.mHandler.removeCallbacksAndMessages(null);
            if (this.gFD != null) {
                this.gFD.Ku();
                this.gFD.bJV();
                this.gFD.bKc();
            }
            if (qVar != null && qVar.mLiveInfo != null) {
                this.gFT = qVar.mLiveInfo.live_id;
            }
            bMb();
            bMn();
            bMo();
            if (qVar != null) {
                if (this.gFR != null && this.gFR.bCc() != null) {
                    view = this.gFR.bCc().a(this.gFR.bBT().pageContext.getPageActivity(), qVar, z);
                }
                if (this.gFD != null) {
                    this.gFQ.a(this.gFD, view, qVar, z, this.gjQ.bIv());
                }
                if (this.gFR != null) {
                    this.gFR.kI(false);
                    this.gFR.bBX();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
                }
                if (this.gFD != null) {
                    this.gFD.bJZ();
                }
                long j = qVar.mLiveInfo.live_id;
                long j2 = qVar.mLiveInfo.room_id;
                String str = qVar.mLiveInfo.feed_id;
                long j3 = qVar.axp.userId;
                String str2 = qVar.axp.userName;
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    HKStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    QMStaticManager.staticEndPlayTime(j + "", j2 + "", j3 + "", str2, System.currentTimeMillis(), str, this.otherParams);
                }
                LogManager.getLiveCloseLogger().doAccessLiveCloseGuestLog(j + "", j2 + "", str, this.otherParams);
                this.gFX = new StayTimeBean();
                this.gFX.liveId = qVar.mLiveInfo.live_id;
                this.gFX.roomId = qVar.mLiveInfo.room_id;
                this.gFX.vid = qVar.mLiveInfo.feed_id;
                this.gFX.startTime = System.currentTimeMillis();
            }
            bMv();
            if (this.gFG != null) {
                this.gFG.a(this.aLQ, this.gFH);
            }
        }
    }

    private void bMn() {
    }

    private void bMo() {
        InputMethodManager inputMethodManager;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null && (inputMethodManager = (InputMethodManager) this.mTbPageContext.getPageActivity().getSystemService("input_method")) != null && inputMethodManager.isActive()) {
            BdUtilHelper.hideSoftKeyPad(this.mContext.getPageActivity(), this.gFE);
        }
    }

    public void bMp() {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bMq();
        } else {
            bMr();
        }
        AlaLiveInfoData alaLiveInfoData = null;
        if (this.gjQ != null && this.gjQ.FU() != null) {
            alaLiveInfoData = this.gjQ.FU().mLiveInfo;
        }
        a(alaLiveInfoData, false);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity()) == 2) {
            bMq();
        } else {
            bMr();
        }
        this.gFE.setIsScrollable(!z && this.gGg);
        if (this.gFR != null) {
            this.gFR.onKeyboardVisibilityChanged(z);
        }
        if (this.gkj != null) {
            this.gkj.onKeyboardVisibilityChanged(z);
        }
    }

    public void cA(int i) {
        int realScreenOrientation = UtilHelper.getRealScreenOrientation(this.mTbPageContext.getPageActivity());
        if (realScreenOrientation == 2) {
            bMq();
        } else {
            bMr();
        }
        this.gkj.cA(realScreenOrientation);
        sq(realScreenOrientation);
        if (ac.yZ() != null) {
            ac.yZ().yA();
        }
        if (this.gFZ != null) {
            this.gFZ.yA();
        }
        if (this.gFG != null) {
            this.gFG.cA(realScreenOrientation);
        }
    }

    public void bMq() {
        if (this.gFE != null) {
            com.baidu.live.utils.h.U(this.gFE);
        }
    }

    public void bMr() {
        if (this.gFE != null) {
            com.baidu.live.utils.h.V(this.gFE);
        }
    }

    public void onResume() {
        if (this.gjQ != null) {
            this.gjQ.bId();
            this.gjQ.bIh();
        }
        if (this.gFR != null) {
            this.gFR.enterForeground();
        }
        if (this.gFZ != null) {
            this.gFZ.onResume();
        }
        if (this.gGa != null) {
            this.gGa.onResume();
        }
    }

    public void onStart() {
        if (!com.baidu.tieba.ala.liveroom.v.a.eB(this.mTbPageContext.getPageActivity())) {
            if (this.gFM) {
                this.gFM = false;
                bMs();
            }
            UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(false);
        }
    }

    public void bMs() {
        bMm();
        bMl();
        this.gjQ.bIu();
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            this.gFI.bMy();
        } else if (!this.gFI.isPlaying()) {
            this.gFI.bMy();
        }
        if (this.gFR != null) {
            this.gFR.bCb();
        }
        if (this.gjQ != null && this.gjQ.FU() != null && this.gjQ.FU().mLiveInfo != null) {
            this.gFW.dM(this.gjQ.FU().mLiveInfo.live_id);
            LiveTimerManager.getInstance().resume(this.aLQ.mLiveInfo.live_id);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913190, null));
    }

    public void onPause() {
        if (this.gjQ != null) {
            this.gjQ.bIe();
            this.gjQ.bIi();
        }
        if (this.gFR != null) {
            this.gFR.enterBackground();
        }
    }

    public void lM(boolean z) {
        this.gFM = true;
        lN(z);
        UbcStatisticManager.getInstance().liveRoomActivityBackgroundSwitch(true);
    }

    public void lN(boolean z) {
        this.mHandler.removeCallbacks(this.gGi);
        this.mHandler.removeCallbacks(this.gGj);
        this.mHandler.removeCallbacks(this.gGk);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            this.gFI.awZ();
        } else if (!z) {
            this.gFI.awZ();
        }
        if (this.gFR != null) {
            this.gFR.bCa();
        }
        this.gFW.pauseRecord();
        LiveTimerManager.getInstance().pause();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (25042 == i) {
            if (ac.yZ() != null) {
                ac.yZ().a(i, i2, intent, this.aLQ, this.otherParams);
            }
        } else if (25044 == i) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106));
        } else if (this.gFR != null) {
            this.gFR.onActivityResult(i, i2, intent);
        }
    }

    public boolean bMt() {
        return this.gFQ != null && this.gFQ.bwO();
    }

    @Override // com.baidu.live.adp.base.BdBaseView
    public void destroy() {
        super.destroy();
        com.baidu.live.core.layer.b.wk().onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.gGp != null) {
            MessageManager.getInstance().unRegisterListener(this.gGp);
        }
        if (this.gGq != null) {
            MessageManager.getInstance().unRegisterListener(this.gGq);
        }
        MessageManager.getInstance().unRegisterListener(this.gGr);
        MessageManager.getInstance().unRegisterListener(this.gmd);
        MessageManager.getInstance().unRegisterListener(this.gGs);
        MessageManager.getInstance().unRegisterListener(this.gGt);
        MessageManager.getInstance().unRegisterListener(this.gGu);
        if (this.gGl != null) {
            this.gGl.release();
        }
        if (this.gFI != null) {
            this.gFI.bY(true);
        }
        if (this.gFG != null) {
            this.gFG.onDestory();
        }
        if (this.gFH != null) {
            this.gFH.reset();
        }
        if (this.gFR != null) {
            this.gFR.onDestroy();
        }
        if (this.gFF != null) {
            this.gFF.onDestroy();
        }
        this.gFD.Ku();
        if (this.gFD != null) {
            this.gFD.release();
            this.gFD = null;
        }
        if (this.gFQ != null) {
            this.gFQ.onDestroy();
        }
        if (this.gFX != null && this.gjQ != null && this.gjQ.FU() != null) {
            long j = this.gjQ.FU().mLiveInfo.live_id;
            if (this.gFX.liveId == j && this.gFX.startTime > 0) {
                this.gFX.endTime = System.currentTimeMillis();
                long j2 = this.gFX.endTime - this.gFX.startTime;
                LogManager.getLiveCloseLogger().doNoticeStaytimeLiveCloseGuestLog(j + "", this.gFX.roomId + "", this.gFX.vid, (j2 >= 0 ? j2 : 0L) / 1000, this.otherParams);
            }
            this.gFX = null;
        }
        if (this.gkj != null) {
            this.gkj.bKe();
            this.gkj = null;
        }
        if (this.gjQ != null) {
            this.gjQ.destory();
        }
        m.Jm();
        com.baidu.live.entereffect.a.xa().release();
        t.yL().release();
        if (this.gGa != null) {
            this.gGa.release();
        }
        UbcStatisticManager.getInstance().liveRoomFlowEnd(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_FLOW, LogConfig.KEY_NOTICE, "liveroom", LogConfig.VALUE_STAYTIME));
    }

    public String Ep() {
        return this.otherParams;
    }

    public void bMu() {
        if (this.gFU != null) {
            this.otherParams = this.gFU.toString();
            if (this.gjQ != null) {
                this.gjQ.setOtherParams(this.otherParams);
            }
            if (this.gFR != null) {
                this.gFR.setOtherParams(this.otherParams);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913095, this.otherParams));
            if (this.gFQ != null) {
                this.gFQ.setOtherParams(this.otherParams);
            }
        }
    }

    public void bMv() {
        if (this.gFU != null) {
            String optString = this.gFU.optString("source");
            if (!TbadkCoreApplication.getInst().isHaokan() || (!TextUtils.isEmpty(optString) && optString.startsWith("push"))) {
                try {
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        this.gFU.put("tab", "live_jump");
                        this.gFU.put("tag", "");
                        this.gFU.put("source", "");
                    } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                        this.gFU.put("tab", "liveroom");
                        this.gFU.put("tag", "");
                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bMu();
            }
        }
    }

    private void c(boolean z, long j) {
        com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
        if (z) {
            bVar.Ce();
        }
        bVar.af(j);
        bVar.setParams();
        MessageManager.getInstance().sendMessage(bVar);
    }

    public void bMw() {
        v.yV();
    }

    private void j(short s) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gFR.d(s);
        } else {
            this.gFR.e(s);
        }
    }
}
