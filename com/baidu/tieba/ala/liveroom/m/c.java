package com.baidu.tieba.ala.liveroom.m;

import android.location.Address;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.lbs.BdLocationMananger;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ah;
import com.baidu.live.data.k;
import com.baidu.live.data.n;
import com.baidu.live.data.q;
import com.baidu.live.im.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.m;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.message.AlaUserAuthenVerifyInfoResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.FaceRecognitionActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJump;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.messages.AlaEnterLiveHttpResonseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaGetAudienceHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaLiveRecommondHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaLiveZanHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaQuitLiveHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaUpdateLiveTbResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaUserLiveMarkInfoResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.LiveBackstageHttpResonpnseMessage;
import com.baidu.tieba.ala.liveroom.messages.MasterIdentityResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends BdBaseModel implements d.a {
    private q aJj;
    private HttpMessageListener fHH;
    private a fXn;
    private ah fZE;
    private CustomMessageListener fnH;
    private k fpj;
    private long gaA;
    private long gaB;
    private HttpMessageListener gaC;
    private CustomMessageListener gaD;
    private HttpMessageListener gaE;
    private HttpMessageListener gaF;
    private HttpMessageListener gaG;
    private NetMessageListener gaH;
    private HttpMessageListener gaI;
    private NetMessageListener gaJ;
    private HttpMessageListener gaK;
    private HttpMessageListener gaL;
    private NetMessageListener gaM;
    private NetMessageListener gaN;
    private HttpMessageListener gaO;
    private CustomMessageListener gaP;
    private HttpMessageListener gaQ;
    private HttpMessageListener gaR;
    private com.baidu.live.liveroom.c.a gaS;
    private CustomMessageTask.CustomRunnable gaT;
    private BdUniqueId gag;
    private Handler gah;
    private HttpMessage gai;
    private final com.baidu.live.im.d gaj;
    private d.a gak;
    private h gal;
    private List<AlaLiveInfoData> gam;
    private int gan;
    private long gao;
    private int gap;
    private boolean gaq;
    private int gar;
    private int gas;
    private String gat;
    private int gau;
    private int gav;
    private com.baidu.live.t.a gaw;
    private AlaGetVerifyStrategyResponseHttpMessage gax;
    private BdAlertDialog gay;
    private Set<Long> gaz;
    private boolean mIsHost;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.gah = new Handler();
        this.gan = 0;
        this.gap = 0;
        this.gaq = true;
        this.gar = 1;
        this.gas = 0;
        this.gau = -1;
        this.gav = 0;
        this.gaw = new com.baidu.live.t.a(0);
        this.otherParams = "";
        this.fnH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.aJj != null && c.this.aJj.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.aJj.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.gau = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.aJj.mLiveInfo.user_id).param("obj_param1", c.this.aJj.mLiveInfo.live_id).param("tid", c.this.aJj.mLiveInfo.thread_id));
                            c.this.gau = 1;
                        }
                        if (c.this.aJj != null && c.this.aJj.avl != null) {
                            c.this.aJj.avl.follow_status = c.this.gau;
                        }
                    }
                }
            }
        };
        this.gaC = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.m.c.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.aWH == 1 && alaUserAuthenVerifyInfoResponseMessage.aWG != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.aWG.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.aWG.verify_video_status == 1) {
                            c.this.gar = 4;
                        }
                    }
                }
            }
        };
        this.gaD = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.m.c.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    try {
                        JSONObject optJSONObject = new JSONObject((String) customResponsedMessage.getData()).optJSONObject("result").optJSONObject("zbwhitelistapi");
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                        boolean optBoolean = optJSONObject2.optBoolean("inwhite");
                        int optInt = optJSONObject2.optInt("is_verified");
                        c.this.gat = optJSONObject2.optString("cmd");
                        c.this.cW(optJSONObject);
                        if (optInt != 1) {
                            c.this.gah.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.28.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bFd();
                                }
                            }, 200L);
                        } else if (!optBoolean) {
                            c.this.gah.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.28.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bFe();
                                }
                            }, 200L);
                        } else {
                            c.this.bFb();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.gaE = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.m.c.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1003303);
                        }
                    });
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    c.this.gas = alaGetVerifyStrategyResponseHttpMessage.fZM;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.fZI);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.fZK);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.fZN);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (alaGetVerifyStrategyResponseHttpMessage.fZK == 1 && alaGetVerifyStrategyResponseHttpMessage.fZI == 1 && alaGetVerifyStrategyResponseHttpMessage.fZP == 1) {
                                c.this.gax = null;
                                return;
                            }
                        } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && alaGetVerifyStrategyResponseHttpMessage.fZK == 1 && alaGetVerifyStrategyResponseHttpMessage.fZI == 1 && alaGetVerifyStrategyResponseHttpMessage.fZN == 1 && alaGetVerifyStrategyResponseHttpMessage.fZP == 1) {
                            c.this.gax = null;
                            return;
                        }
                        c.this.gax = alaGetVerifyStrategyResponseHttpMessage;
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (alaGetVerifyStrategyResponseHttpMessage.fZK != 1 || alaGetVerifyStrategyResponseHttpMessage.fZI != 1) {
                                c.this.gah.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.29.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.bFe();
                                    }
                                }, 200L);
                            } else if (alaGetVerifyStrategyResponseHttpMessage.fZP != 1) {
                                c.this.gah.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.29.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.bFh();
                                    }
                                }, 200L);
                            }
                        } else if (!TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isOther()) {
                            c.this.gah.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.29.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bFg();
                                }
                            }, 200L);
                        } else if (alaGetVerifyStrategyResponseHttpMessage.fZN != 1) {
                            c.this.gah.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.29.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bFd();
                                }
                            }, 200L);
                        } else if (alaGetVerifyStrategyResponseHttpMessage.fZK != 1 || alaGetVerifyStrategyResponseHttpMessage.fZI != 1) {
                            c.this.gah.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.29.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bFe();
                                }
                            }, 200L);
                        } else if (alaGetVerifyStrategyResponseHttpMessage.fZP != 1) {
                            c.this.gah.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.29.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bFh();
                                }
                            }, 200L);
                        }
                    }
                }
            }
        };
        this.gaF = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.m.c.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.gaG = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.m.c.31
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String bEN;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.bEL() == 1 || masterIdentityResponseMessage.bEM() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.bEN())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.bEN());
                            jSONObject.put("content_type", "custom_master_identity");
                            bEN = jSONObject.toString();
                        } catch (JSONException e) {
                            bEN = masterIdentityResponseMessage.bEN();
                            e.printStackTrace();
                        }
                        c.this.gaj.a(27, bEN, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.gaH = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.m.c.32
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.gaI = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.m.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.gaq = false;
                }
            }
        };
        this.gaJ = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.m.c.3
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        c.this.aJj = alaEnterLiveHttpResonseMessage.Fk();
                        c.this.fZE = alaEnterLiveHttpResonseMessage.bEF();
                        c.this.gaj.e(c.this.aJj);
                    }
                    if (c.this.aJj != null && c.this.aJj.mLiveInfo != null && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                        if (!TbadkCoreApplication.getInst().isOther()) {
                            com.baidu.tieba.ala.liveroom.task.c.bGo().dI(c.this.aJj.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(c.this.aJj.mLiveInfo.live_id);
                    }
                    if (c.this.aJj != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.aJj.avC != null) {
                            if (c.this.aJj.avC.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.aJj.avC.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aJj.avC.nickName);
                            if (!TextUtils.isEmpty(c.this.aJj.avC.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.aJj.avC.portrait);
                            }
                        }
                        if (c.this.aJj.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.aJj.mLiveSdkInfo.tbs);
                            com.baidu.live.c.uN().putString("ala_account_user_tbs", c.this.aJj.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.aJj != null) {
                        if (c.this.gam.size() <= 0) {
                            c.this.gam.add(c.this.aJj.mLiveInfo);
                            c.this.gaz.add(Long.valueOf(c.this.aJj.mLiveInfo.getLiveID()));
                        }
                        c.this.g(c.this.aJj.mLiveInfo);
                        if (c.this.gaj != null) {
                            c.this.gaj.E(c.this.aJj.avH);
                        }
                    }
                    if (c.this.aJj != null && c.this.aJj.avl != null) {
                        c.this.gau = c.this.aJj.avl.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.aJj);
                    if (c.this.aJj != null && c.this.aJj.mLiveInfo != null) {
                        c.this.bFw();
                    }
                    if (c.this.aJj != null) {
                        c.this.aJj.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aJj));
                        m.CL().H(c.this.aJj.avH);
                    }
                    c.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.aJj != null && c.this.aJj.mLiveInfo != null) {
                            long j2 = c.this.aJj.mLiveInfo.live_id;
                            long j3 = c.this.aJj.mLiveInfo.room_id;
                            String str = c.this.aJj.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.aJj.avj != null) {
                                long j4 = c.this.aJj.avj.userId;
                                str2 = c.this.aJj.avj.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.aJj != null && c.this.aJj.mLiveInfo != null) {
                        long j5 = c.this.aJj.mLiveInfo.live_id;
                        long j6 = c.this.aJj.mLiveInfo.room_id;
                        String str3 = c.this.aJj.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.aJj.avj != null) {
                            j = c.this.aJj.avj.userId;
                            str4 = c.this.aJj.avj.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.gap + "");
                    }
                }
            }
        };
        this.gaK = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.m.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    k kVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        kVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bth();
                    }
                    if (kVar != null) {
                        c.this.fpj = kVar;
                    }
                    if (c.this.aJj != null && c.this.aJj.avl != null) {
                        if (c.this.gau == -1) {
                            c.this.gau = c.this.aJj.avl.follow_status;
                        }
                        if (c.this.aJj.avl.follow_status != c.this.gau) {
                            c.this.aJj.avl.follow_status = c.this.gau;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.fpj);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.fpj));
                }
            }
        };
        this.gaL = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.m.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> bEK = alaUserLiveMarkInfoResponseMessage.bEK();
                        c.this.gaj.E(bEK);
                        if (c.this.aJj != null) {
                            c.this.aJj.avH = bEK;
                            m.CL().H(c.this.aJj.avH);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.aJj));
                        }
                    }
                }
            }
        };
        this.gaM = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.m.c.6
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    q Fk = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).Fk() : null;
                    c.this.gaB = System.currentTimeMillis();
                    if (Fk == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, Fk);
                        return;
                    }
                    if (c.this.aJj == null) {
                        c.this.aJj = Fk;
                        c.this.gaj.e(c.this.aJj);
                    } else if (c.this.aJj.mLiveInfo != null && Fk.mLiveInfo != null && c.this.aJj.mLiveInfo.live_id != Fk.mLiveInfo.live_id) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.aJj);
                        return;
                    }
                    if (c.this.aJj.mLiveInfo != null && Fk.mLiveInfo != null && c.this.aJj.mLiveInfo.user_id == Fk.mLiveInfo.user_id) {
                        if (c.this.aJj.mLiveInfo.imEffect != null && Fk.mLiveInfo.imEffect == null) {
                            Fk.mLiveInfo.imEffect = c.this.aJj.mLiveInfo.imEffect;
                        }
                        if (c.this.aJj.mLiveInfo.mLiveCloseData != null && Fk.mLiveInfo.mLiveCloseData == null) {
                            Fk.mLiveInfo.mLiveCloseData = c.this.aJj.mLiveInfo.mLiveCloseData;
                        }
                        if (c.this.aJj.mLiveInfo.mAlaLiveSwitchData != null && Fk.mLiveInfo.mAlaLiveSwitchData == null) {
                            Fk.mLiveInfo.mAlaLiveSwitchData = c.this.aJj.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    c.this.aJj.mLiveInfo = Fk.mLiveInfo;
                    c.this.aJj.avj = Fk.avj;
                    c.this.aJj.avk = Fk.avk;
                    c.this.aJj.avn = Fk.avn;
                    c.this.aJj.avI = Fk.avI;
                    c.this.aJj.avG = Fk.avG;
                    c.this.aJj.avF = Fk.avF;
                    if (Fk.avM != null && Fk.avM.ayS != null && !Fk.avM.ayS.isEmpty()) {
                        c.this.aJj.avM = Fk.avM;
                    }
                    if (Fk.avC != null) {
                        if (Fk.avC.userId == 0) {
                            if (c.this.aJj.avC == null) {
                                c.this.aJj.avC = new AlaLiveUserInfoData();
                            }
                            c.this.aJj.avC.throneUid = Fk.avC.throneUid;
                        } else {
                            boolean z = Fk.avC.isNewUser;
                            if (c.this.aJj.avC != null) {
                                z = c.this.aJj.avC.isNewUser;
                            }
                            Fk.avC.isNewUser = z;
                            c.this.aJj.avC = Fk.avC;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aJj.avC.nickName);
                        }
                    }
                    if (Fk.avE != null) {
                        c.this.aJj.avE = Fk.avE;
                    }
                    if (Fk.avG) {
                        c.this.aJj.avH = Fk.avH;
                        if (c.this.gaj != null) {
                            c.this.gaj.E(Fk.avH);
                        }
                    }
                    if (!c.this.mIsHost && c.this.aJj.mLiveInfo != null) {
                        int i = c.this.aJj.mLiveInfo.backstage_type;
                        if (c.this.gaj != null) {
                            c.this.gaj.fn(String.valueOf(i));
                        }
                    }
                    if (c.this.gaj != null) {
                        c.this.gaj.e(c.this.aJj);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.aJj);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.aJj));
                    if (c.this.aJj != null) {
                        m.CL().H(c.this.aJj.avH);
                    }
                }
            }
        };
        this.gaN = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.m.c.7
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                List<Long> list;
                long j;
                if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (!(responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage)) {
                        list = null;
                        j = 5000;
                    } else {
                        AlaMGetLiveStatusHttpResponseMessage alaMGetLiveStatusHttpResponseMessage = (AlaMGetLiveStatusHttpResponseMessage) responsedMessage;
                        list = alaMGetLiveStatusHttpResponseMessage.getClosedIds();
                        j = alaMGetLiveStatusHttpResponseMessage.getInterval();
                    }
                    long j2 = j >= 5000 ? j : 5000L;
                    if (list != null && list.size() > 0 && c.this.gam != null && c.this.gam.size() > 0) {
                        for (int size = c.this.gam.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.gam.get(size)).live_id != c.this.aJj.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.gam.get(size)).getLiveID()))) {
                                c.this.gam.remove(size);
                            }
                        }
                    }
                    if (c.this.aJj != null) {
                        c.this.g(c.this.aJj.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.fHH = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.m.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.gaO = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.m.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.gai = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.gal = alaUpdateLiveTbResponseMessage.bEJ();
                    if (c.this.gal != null) {
                        if (c.this.gal.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, c.this.gal.fTL);
                                jSONObject2.put("user_verify", c.this.gal.fTN);
                                jSONObject2.put("certify", c.this.gal.fTP);
                                if (c.this.gal.mLiveSdkInfo != null && c.this.gal.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put("chat_mcast_id", c.this.gal.mLiveSdkInfo.mCastIds.avv);
                                    jSONObject2.put("ensure_mcast_id", c.this.gal.mLiveSdkInfo.mCastIds.avw);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (c.this.gal.fTL != 1 || c.this.gal.fTN != 1) {
                            c.this.gah.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bFf();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.gal.avj != null) {
                            c.this.gaj.E(c.this.gal.avj.live_mark_info_new);
                        }
                        if (c.this.gal.mErrorCode != 0) {
                            if (c.this.gal.mErrorCode == 220012) {
                                c.this.b(c.this.gal.mErrorCode, c.this.gal.mErrorMsg, 6, c.this.aJj);
                                return;
                            }
                        } else {
                            c.this.aJj = new q();
                            c.this.gaj.e(c.this.aJj);
                            c.this.aJj.mLiveInfo = c.this.gal.mLiveInfo;
                            c.this.aJj.avj = c.this.gal.avj;
                            c.this.aJj.mLiveSdkInfo = c.this.gal.mLiveSdkInfo;
                            c.this.aJj.avJ = c.this.gal.avJ;
                            c.this.aJj.avH = c.this.gal.avj.live_mark_info_new;
                            if (c.this.gal.avj != null && c.this.gal.avj.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.gal.avj.levelId);
                            }
                            c.this.aJj.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aJj));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.aJj);
                    if (c.this.gal != null && c.this.gal.mLiveInfo != null) {
                        c.this.bFw();
                    }
                    if (c.this.aJj != null && c.this.aJj.mLiveInfo != null) {
                        c.this.y(c.this.aJj.mLiveInfo.user_id, c.this.aJj.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.gaP = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.m.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.gaj.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.gaQ = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.m.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.l.b)) {
                    com.baidu.live.l.b bVar = (com.baidu.live.l.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.aYr != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.aYr.fw(bVar.contentType);
                        } else {
                            bVar.aYr.b(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.gaR = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.m.c.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                n nVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        nVar = null;
                    } else {
                        nVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).bEH();
                    }
                    if (nVar != null && !ListUtils.isEmpty(nVar.avu)) {
                        c.this.gan = nVar.pn + 1;
                        com.baidu.live.data.m mVar = nVar.avu.get(nVar.avu.size() - 1);
                        if (mVar != null) {
                            c.this.gao = mVar.mLiveInfo.live_id;
                        }
                        c.this.a(nVar);
                        if (c.this.aJj != null) {
                            c.this.g(c.this.aJj.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, nVar);
                    }
                }
            }
        };
        this.gaS = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.m.c.25
        };
        this.gaT = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(c.this.gaB));
            }
        };
        this.mPageContext = bdPageContext;
        this.gaj = new com.baidu.live.im.d(bdPageContext, false, this);
        this.gam = new ArrayList();
        this.gaz = new HashSet();
        initTasks();
        registerListener(this.gaM);
        registerListener(this.gaK);
        registerListener(this.gaJ);
        registerListener(this.gaH);
        this.gag = BdUniqueId.gen();
        this.gaR.setTag(this.gag);
        registerListener(this.gaR);
        registerListener(this.gaN);
        registerListener(this.gaI);
        registerListener(this.gaO);
        registerListener(this.fHH);
        registerListener(this.gaE);
        registerListener(this.gaF);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.gaD);
        }
        registerListener(this.gaC);
        registerListener(this.fnH);
        registerListener(this.gaL);
        registerListener(this.gaG);
        registerListener(this.gaP);
        registerListener(this.gaQ);
        MessageManager.getInstance().addMessageRule(this.gaw);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021021, TbConfig.SERVER_ADDRESS + "ala/recommend/getSwitchLives");
        tbHttpMessageTask.setResponsedClass(AlaLiveRecommondHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1021023, TbConfig.SERVER_ADDRESS + "ala/live/zan");
        tbHttpMessageTask2.setIsNeedLogin(true);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask2.setResponsedClass(AlaLiveZanHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        TbHttpMessageTask tbHttpMessageTask3 = new TbHttpMessageTask(1021033, TbConfig.SERVER_ADDRESS + "ala/live/updateLiveTb");
        tbHttpMessageTask3.setIsNeedLogin(true);
        tbHttpMessageTask3.setIsNeedTbs(true);
        tbHttpMessageTask3.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask3.setResponsedClass(AlaUpdateLiveTbResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask3);
        TbHttpMessageTask tbHttpMessageTask4 = new TbHttpMessageTask(1021077, TbConfig.SERVER_ADDRESS + "ala/live/setNetStatus");
        tbHttpMessageTask4.setIsNeedLogin(true);
        tbHttpMessageTask4.setIsNeedTbs(true);
        tbHttpMessageTask4.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask4);
        TbHttpMessageTask tbHttpMessageTask5 = new TbHttpMessageTask(1021046, "https://tiebac.baidu.com/ala/user/getVerifyInfo");
        tbHttpMessageTask5.setIsNeedLogin(true);
        tbHttpMessageTask5.setIsNeedTbs(true);
        tbHttpMessageTask5.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask5.setResponsedClass(AlaUserAuthenVerifyInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask5);
        TbHttpMessageTask tbHttpMessageTask6 = new TbHttpMessageTask(1021123, TbConfig.SERVER_ADDRESS + "ala/live/backstage");
        tbHttpMessageTask6.setIsNeedLogin(true);
        tbHttpMessageTask6.setIsNeedTbs(true);
        tbHttpMessageTask6.setResponsedClass(LiveBackstageHttpResonpnseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask6);
        this.gaB = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.gaT);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bEQ();
        bER();
        bES();
        bET();
        bEW();
        bEX();
    }

    private void bEQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bER() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void bES() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void bET() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void bEU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.m.c.12
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    Log.i("i", "@@@ localText lrmd run");
                    c.this.c(customMessage.getData());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void bEV() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void bEW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bEX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "/ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bEY() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.l.b) && c.this.aJj != null && c.this.aJj.mLiveInfo != null) {
                    com.baidu.live.l.b bVar = (com.baidu.live.l.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", c.this.aJj.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.aYq != null) {
                        httpMessage.addParam("ext_data", bVar.aYq.toString());
                    }
                    httpMessage.setExtra(bVar);
                    c.this.sendMessage(httpMessage);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void bEZ() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void y(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bFa() {
        bFz();
        IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
        if (buildParamsExtra != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put(ExtraParamsManager.KEY_PROCESS_PLUGIN_ASYNC_CALLBACK, "");
                hashMap.put("cmd", 2913116);
                buildParamsExtra.process(hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bFb() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null));
    }

    public void dH(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void bFc() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bFd() {
        if (this.gay != null) {
            this.gay.dismiss();
            this.gay = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.gay = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gay.setAutoNight(false);
        this.gay.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.gay.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.bFc();
                    c.this.yy();
                }
            });
            this.gay.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.yy();
                }
            });
        } else {
            this.gay.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.yy();
                }
            });
        }
        this.gay.setCancelable(false);
        this.gay.setCanceledOnTouchOutside(false);
        this.gay.setTitleShowCenter(true);
        this.gay.setMessageShowCenter(true);
        this.gay.isShowTitleAndMessage();
        this.gay.create(this.mPageContext);
        this.gay.show();
    }

    public void bFe() {
        if (this.gay != null) {
            this.gay.dismiss();
            this.gay = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.gay = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gay.setAutoNight(false);
        this.gay.setMessage(string);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gay.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.yy();
                }
            });
        } else {
            this.gay.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str = com.baidu.live.v.a.Ge().aWF.axW;
                        if (!TextUtils.isEmpty(str)) {
                            BrowserHelper.startInternalWebActivity(c.this.mPageContext.getPageActivity(), str);
                        }
                    } else {
                        IExtraParams buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra();
                        if (buildParamsExtra != null) {
                            try {
                                HashMap hashMap = new HashMap();
                                hashMap.put(ExtraParamsManager.KEY_GO_FEED_BACK, "");
                                buildParamsExtra.process(hashMap);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    c.this.yy();
                }
            });
            this.gay.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.yy();
                }
            });
        }
        this.gay.setCancelable(false);
        this.gay.setCanceledOnTouchOutside(false);
        this.gay.setTitleShowCenter(true);
        this.gay.setMessageShowCenter(true);
        this.gay.isShowTitleAndMessage();
        this.gay.create(this.mPageContext);
        this.gay.show();
    }

    public void bFf() {
        if (this.gay != null) {
            this.gay.dismiss();
            this.gay = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gay = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gay.setAutoNight(false);
        this.gay.setMessage(string);
        this.gay.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.gay.setCancelable(false);
        this.gay.setCanceledOnTouchOutside(false);
        this.gay.isShowTitleAndMessage();
        this.gay.create(this.mPageContext);
        this.gay.show();
    }

    public void bFg() {
        if (this.gay != null) {
            this.gay.dismiss();
            this.gay = null;
        }
        if (this.gax != null) {
            a(this.gax);
        }
    }

    public void bFh() {
        if (this.gay != null) {
            this.gay.dismiss();
            this.gay = null;
        }
        String string = this.mPageContext.getString(a.i.dialog_msg_to_user_info);
        this.gay = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gay.setAutoNight(false);
        this.gay.setMessage(string);
        this.gay.setPositiveButton(this.mPageContext.getString(a.i.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                IExtraParams buildParamsExtra;
                if (TbadkCoreApplication.getInst().isTieba()) {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(c.this.mPageContext.getPageActivity(), TbadkCoreApplication.getCurrentAccountId() + "");
                    }
                } else if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && (buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra()) != null) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(ExtraParamsManager.KEY_GO_USER_INFO, "");
                        buildParamsExtra.process(hashMap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                c.this.yy();
            }
        });
        this.gay.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.yy();
            }
        });
        this.gay.setCancelable(false);
        this.gay.setCanceledOnTouchOutside(false);
        this.gay.setTitleShowCenter(true);
        this.gay.setMessageShowCenter(true);
        this.gay.isShowTitleAndMessage();
        this.gay.create(this.mPageContext);
        this.gay.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gay = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gay.setAutoNight(false);
        this.gay.setMessage(string);
        this.gay.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.gay.setCancelable(false);
        this.gay.setCanceledOnTouchOutside(false);
        this.gay.isShowTitleAndMessage();
        this.gay.create(this.mPageContext);
        this.gay.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.gax = null;
        this.gay = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy() {
        if (this.gay != null) {
            this.gay.dismiss();
            this.gay = null;
        }
        this.gax = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.fXn != null) {
            this.fXn.a(i, str, i2, obj);
        }
    }

    public void f(long j, boolean z) {
        com.baidu.tieba.ala.liveroom.messages.b bVar = new com.baidu.tieba.ala.liveroom.messages.b();
        bVar.isFirst = z;
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.setFrom(str);
        bVar.an(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void bFi() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public void j(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021077);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("net_status", i);
        sendMessage(httpMessage);
    }

    public void rs(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void z(long j, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.an(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public h bFj() {
        return this.gal;
    }

    public q Fk() {
        return this.aJj;
    }

    public ah bEF() {
        return this.fZE;
    }

    public List<AlaLiveInfoData> bFk() {
        return this.gam;
    }

    public k bth() {
        return this.fpj;
    }

    public void bL(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aJj != null && this.aJj.mLiveInfo != null) {
                aVar.setAudienceCount(this.aJj.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bFl() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.gam) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        bL(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
                if (this.gam.size() == 1 && this.gam.get(0).live_id == this.aJj.mLiveInfo.live_id) {
                    if (c(nVar) != null) {
                        this.gam.clear();
                    }
                    b(nVar);
                    return;
                }
                b(nVar);
                return;
            }
            b(nVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(n nVar) {
        boolean z;
        for (com.baidu.live.data.m mVar : nVar.avu) {
            if (mVar != null && mVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.gam) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == mVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.gam.add(mVar.mLiveInfo);
                }
            }
        }
        if (this.gam.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.gam.size() - 200; size < this.gam.size(); size++) {
                arrayList.add(this.gam.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.gam.clear();
                this.gam.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(n nVar) {
        if (ListUtils.isEmpty(nVar.avu)) {
            return null;
        }
        for (com.baidu.live.data.m mVar : nVar.avu) {
            if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.live_id == this.aJj.mLiveInfo.live_id) {
                return mVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bFm() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.gam)) {
            return null;
        }
        if (this.gaz.isEmpty()) {
            arrayList.addAll(this.gam);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gam.size()) {
                    break;
                }
                if ((this.aJj == null || this.aJj.mLiveInfo == null || this.aJj.mLiveInfo.live_id != this.gam.get(i2).live_id) && !this.gaz.contains(Long.valueOf(this.gam.get(i2).live_id))) {
                    arrayList.add(this.gam.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void f(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.gaz.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.gaz.size() >= this.gam.size() - 4) {
                lh(false);
            }
        }
    }

    public void rt(int i) {
        this.gav = i;
    }

    public int bFn() {
        return this.gav;
    }

    public void lh(boolean z) {
        if (com.baidu.live.liveroom.c.d.EN().EL()) {
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && 1 != this.gav) {
                li(z);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gaA > 500) {
                this.gaA = currentTimeMillis;
                com.baidu.live.liveroom.c.d.EN().EP().a("tieba", this.gan, 20, this.gaS);
                return;
            }
            return;
        }
        li(z);
    }

    private void li(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.gan);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.gao);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.gag);
            sendMessage(httpMessage);
        }
    }

    public void dI(String str, String str2) {
        this.gaj.BZ();
        HttpMessage httpMessage = new HttpMessage(1021036);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("close_reason", str2);
        httpMessage.setTag(BdUniqueId.gen());
        sendMessage(httpMessage);
    }

    public void a(long j, boolean z, String str, String str2) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str2);
        aVar.vA(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
        bFy();
    }

    public void af(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.vA(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        bFy();
    }

    public void CB(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.ft(str);
        aVar.setParams();
        sendMessage(aVar);
        bFy();
    }

    public void dG(long j) {
        this.gaj.BZ();
        this.gaA = 0L;
        com.baidu.tieba.ala.liveroom.messages.c cVar = new com.baidu.tieba.ala.liveroom.messages.c();
        cVar.setLiveId(j);
        cVar.setParams();
        cVar.setTag(BdUniqueId.gen());
        sendMessage(cVar);
    }

    public void a(String str, String str2, String str3, int i, double d, double d2, String str4, String str5, int i2, String str6, int i3, int i4, int i5, int i6, String str7, String str8) {
        a(str, str2, str3, i, d, d2, str4, str5, i2, str6, null, null, i3, i4, i5, i6, str7, str8);
    }

    public void a(String str, String str2, String str3, int i, double d, double d2, String str4, String str5, int i2, String str6, String str7, String str8, int i3, int i4, int i5, int i6, String str9, String str10) {
        this.mIsHost = true;
        if (!bFo()) {
            HttpMessage httpMessage = new HttpMessage(1021033);
            httpMessage.addParam("forum_name", str);
            httpMessage.addParam("forum_id", str2);
            httpMessage.addParam("description", str3);
            httpMessage.addParam("is_location", i);
            httpMessage.addParam("lat", Double.toString(d));
            httpMessage.addParam("lng", Double.toString(d2));
            httpMessage.addParam("location_name", str4);
            httpMessage.addParam("location_name_md5", str5);
            httpMessage.addParam("is_to_tb_some", i2);
            httpMessage.addParam("cover", str6);
            httpMessage.addParam("vcode", str7);
            httpMessage.addParam("vcode_md5", str8);
            httpMessage.addParam("is_test_live", i3);
            httpMessage.addParam("live_type", i4);
            httpMessage.addParam("open_type", 2);
            httpMessage.addParam(AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, i5);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isMobileBaidu() || TbadkCoreApplication.getInst().isTieba()) {
                httpMessage.addParam("im_sdk_version", BIMManager.getVersion() + "");
                httpMessage.addParam("app_id", AccountManager.getAppid(TbadkCoreApplication.getInst().getContext()) + "");
            }
            if (i6 > 0) {
                httpMessage.addParam("clarity", i6);
            }
            if (str9 != null) {
                httpMessage.addParam("game_id", str9);
            }
            if (str10 != null) {
                httpMessage.addParam("game_name", str10);
            }
            sendMessage(httpMessage);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null));
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                BdStatisticsManager.getInstance().newDebug("updatelive", 0L, null, "forum_name", str, "forum_id", str2, "description", str3, "is_location", Integer.valueOf(i), "lat", Double.toString(d), "lng", Double.toString(d2), "location_name", str4, "location_name_md5", str5, "is_to_tb_some", Integer.valueOf(i2), "cover", str6, "vcode", str7, "vcode_md5", str8, "is_test_live", Integer.valueOf(i3), "live_type", Integer.valueOf(i4), AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, Integer.valueOf(i5), "clarity", Integer.valueOf(i6), "game_id", str9, "game_name", str10);
            }
        }
    }

    private boolean bFo() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bFp() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aJj == null) {
            this.aJj = new q(alaLiveInfoCoreData);
            this.gaj.e(this.aJj);
        }
        this.gao = this.aJj.mLiveInfo.live_id;
    }

    public void h(String str, boolean z, boolean z2) {
        HttpMessage httpMessage = new HttpMessage(1021040);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("is_cancel", z ? 1 : 0);
        httpMessage.addParam("is_success", z2 ? 1 : 0);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void h(AlaLivePersonData alaLivePersonData) {
        this.mIsHost = true;
        if (this.aJj == null) {
            this.aJj = new q();
        }
        this.aJj.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aJj.avj = alaLivePersonData.mUserData;
        this.aJj.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aJj.avj != null && this.gaj != null) {
            this.gaj.E(this.aJj.avj.live_mark_info_new);
        }
        this.aJj.isHost = true;
        this.aJj.avK = true;
        if (this.gaj != null) {
            this.gaj.e(this.aJj);
        }
        bFw();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aJj));
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void destory() {
        this.gah.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.gaR);
        MessageManager.getInstance().removeMessageRule(this.gaw);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.gaj.BZ();
        this.gak = null;
        this.mPageContext = null;
    }

    public void ru(int i) {
        this.gap = i;
        if (this.gam.size() == 0) {
            this.gap = 0;
        } else if (this.gap < 0) {
            this.gap = this.gam.size() + this.gap;
        } else {
            this.gap %= this.gam.size();
        }
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.gam.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gam.size()) {
                    if (this.gam.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.gap = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bFq() {
        long j;
        if (this.aJj == null || this.aJj.mLiveInfo == null || this.gam.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gam.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aJj.mLiveInfo.live_id;
    }

    public boolean bFr() {
        long j;
        if (this.aJj == null || this.aJj.mLiveInfo == null || this.gam.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gam.get(this.gam.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aJj.mLiveInfo.live_id;
    }

    public int bFs() {
        return this.gap;
    }

    public int bFt() {
        return this.gar;
    }

    public boolean bFu() {
        return this.gas == 1;
    }

    public AlaLiveInfoData bFv() {
        if (this.gap >= this.gam.size()) {
            this.gap = this.gam.size() - 1;
        }
        if (this.gap < 0) {
            this.gap = 0;
        }
        if (this.gam.size() <= this.gap) {
            if (this.aJj != null) {
                return this.aJj.mLiveInfo;
            }
            return null;
        }
        return this.gam.get(this.gap);
    }

    public void a(a aVar) {
        this.fXn = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.gak != null) {
            this.gak.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void k(com.baidu.live.im.data.a aVar) {
        if (this.aJj != null && this.aJj.mLiveInfo.live_type == 1) {
            y(aVar);
        }
        if (this.gak != null) {
            this.gak.k(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void y(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject = new JSONObject(aVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        if ((aVar.getMsgType() == 12 || aVar.getMsgType() == 13) && jSONObject != null && "ss_hot_live".equals(jSONObject.optString("content_type")) && !this.mIsHost) {
            lh(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void Cc() {
        if (this.gak != null) {
            this.gak.Cc();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aJj);
        if (this.aJj != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aJj.avj;
            } else {
                alaLiveUserInfoData = this.aJj.avC;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aJj.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aJj != null && this.aJj.avC != null && this.aJj.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aJj.avC.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr2 == null || strArr2.length != 2) {
                            strArr2 = new String[2];
                            strArr2[1] = "";
                        }
                        strArr2[0] = "guard_seat_effect";
                    }
                }
                String[] strArr3 = strArr2;
                Log.i("i", "@@@ localText lrmd sm sd");
                this.gaj.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void bFw() {
        this.gaj.e(String.valueOf(this.aJj.mLiveInfo.getGroupID()), String.valueOf(this.aJj.mLiveInfo.getLastMsgID()), String.valueOf(this.aJj.mLiveInfo.getUserID()), String.valueOf(this.aJj.mLiveInfo.getLiveID()), this.aJj.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bFx() {
        return this.gaj;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bFy() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aJj != null) {
            try {
                if (this.aJj.mLiveSdkInfo != null && this.aJj.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put("chat_mcast_id", this.aJj.mLiveSdkInfo.mCastIds.avv);
                    jSONObject2.put("ensure_mcast_id", this.aJj.mLiveSdkInfo.mCastIds.avw);
                }
                jSONObject.put("result", jSONObject2);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        String str = UbcStatConstant.ContentType.UBC_TYPE_ENTER_LIVE_SUCC;
        if (alaEnterLiveHttpResonseMessage != null && alaEnterLiveHttpResonseMessage.getError() != 0) {
            str = "enter_live";
        }
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_RESP, str, "liveroom", "").setContentExt(jSONObject), alaEnterLiveHttpResonseMessage, true);
    }

    private void bFz() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_QM_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (this.aJj != null && jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                boolean optBoolean = optJSONObject.optBoolean("inwhite");
                int optInt = optJSONObject.optInt("is_verified");
                jSONObject3.put("inwhite", optBoolean);
                jSONObject3.put("is_verified", optInt);
                jSONObject2.put("result", jSONObject3);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        String str = UbcStatConstant.ContentType.UBC_TYPE_QM_STRATEGY_SUCC;
        if (jSONObject == null || jSONObject.optInt("status") != 0) {
            str = UbcStatConstant.ContentType.UBC_TYPE_QM_STRATEGY;
        }
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", str, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject2), null, true);
    }
}
