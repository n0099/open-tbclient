package com.baidu.tieba.ala.liveroom.n;

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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.aj;
import com.baidu.live.data.az;
import com.baidu.live.data.k;
import com.baidu.live.data.n;
import com.baidu.live.data.q;
import com.baidu.live.im.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.m;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.message.AlaUserAuthenVerifyInfoResponseMessage;
import com.baidu.live.sdk.a;
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
    private q aLQ;
    private k fAG;
    private HttpMessageListener fTb;
    private CustomMessageListener fzf;
    private a gkz;
    private aj gmN;
    private String gnA;
    private int gnB;
    private int gnC;
    private String gnD;
    private com.baidu.live.u.a gnE;
    private AlaGetVerifyStrategyResponseHttpMessage gnF;
    private BdAlertDialog gnG;
    private Set<Long> gnH;
    private long gnI;
    private long gnJ;
    private HttpMessageListener gnK;
    private CustomMessageListener gnL;
    private HttpMessageListener gnM;
    private HttpMessageListener gnN;
    private HttpMessageListener gnO;
    private NetMessageListener gnP;
    private HttpMessageListener gnQ;
    private NetMessageListener gnR;
    private HttpMessageListener gnS;
    private HttpMessageListener gnT;
    private NetMessageListener gnU;
    private NetMessageListener gnV;
    private HttpMessageListener gnW;
    private CustomMessageListener gnX;
    private HttpMessageListener gnY;
    private HttpMessageListener gnZ;
    private BdUniqueId gno;
    private Handler gnp;
    private HttpMessage gnq;
    private final com.baidu.live.im.d gnr;
    private d.a gns;
    private h gnt;
    private List<AlaLiveInfoData> gnu;
    private int gnv;
    private int gnw;
    private boolean gnx;
    private int gny;
    private int gnz;
    private com.baidu.live.liveroom.c.a goa;
    private CustomMessageTask.CustomRunnable gob;
    private boolean mIsHost;
    private long mLastLiveId;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.gnp = new Handler();
        this.gnv = 0;
        this.gnw = 0;
        this.gnx = true;
        this.gny = 1;
        this.gnz = 0;
        this.gnB = -1;
        this.gnC = 0;
        this.gnE = new com.baidu.live.u.a(0);
        this.otherParams = "";
        this.fzf = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.n.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.aLQ != null && c.this.aLQ.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.aLQ.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.gnB = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.aLQ.mLiveInfo.user_id).param("obj_param1", c.this.aLQ.mLiveInfo.live_id).param("tid", c.this.aLQ.mLiveInfo.thread_id));
                            c.this.gnB = 1;
                        }
                        if (c.this.aLQ != null && c.this.aLQ.axr != null) {
                            c.this.aLQ.axr.follow_status = c.this.gnB;
                        }
                    }
                }
            }
        };
        this.gnK = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.n.c.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.aZr == 1 && alaUserAuthenVerifyInfoResponseMessage.aZq != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.aZq.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.aZq.verify_video_status == 1) {
                            c.this.gny = 4;
                        }
                    }
                }
            }
        };
        this.gnL = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.n.c.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                JSONObject jSONObject;
                boolean z = false;
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject((String) customResponsedMessage.getData());
                        JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                        if (optJSONObject != null) {
                            jSONObject = optJSONObject.optJSONObject("zbwhitelistapi");
                            JSONObject optJSONObject2 = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                            if (optJSONObject2 != null) {
                                z = optJSONObject2.optBoolean("inwhite");
                                i = optJSONObject2.optInt("is_verified");
                                c.this.gnA = optJSONObject2.optString("cmd");
                            } else {
                                i = 0;
                            }
                        } else {
                            i = 0;
                            jSONObject = null;
                        }
                        String optString = jSONObject2.optString(BdStatsConstant.StatsType.ERROR);
                        c.this.y(jSONObject, optString);
                        if (!TextUtils.isEmpty(optString)) {
                            BdUtilHelper.showToast(c.this.mPageContext.getPageActivity(), a.i.sdk_neterror);
                        } else if (i != 1) {
                            c.this.gnp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.28.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bIm();
                                }
                            }, 200L);
                        } else if (!z) {
                            c.this.gnp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.28.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bIn();
                                }
                            }, 200L);
                        } else {
                            c.this.bIk();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.gnM = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.n.c.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1003303);
                        }
                    });
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    c.this.gnz = alaGetVerifyStrategyResponseHttpMessage.gmV;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.gmR);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.gmT);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.gmW);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (alaGetVerifyStrategyResponseHttpMessage.gmT == 1 && alaGetVerifyStrategyResponseHttpMessage.gmR == 1 && alaGetVerifyStrategyResponseHttpMessage.gmY == 1) {
                                c.this.gnF = null;
                                return;
                            }
                        } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && alaGetVerifyStrategyResponseHttpMessage.gmT == 1 && alaGetVerifyStrategyResponseHttpMessage.gmR == 1 && alaGetVerifyStrategyResponseHttpMessage.gmW == 1 && alaGetVerifyStrategyResponseHttpMessage.gmY == 1) {
                            c.this.gnF = null;
                            return;
                        }
                        c.this.gnF = alaGetVerifyStrategyResponseHttpMessage;
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (alaGetVerifyStrategyResponseHttpMessage.gmT != 1 || alaGetVerifyStrategyResponseHttpMessage.gmR != 1) {
                                c.this.gnp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.29.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.bIn();
                                    }
                                }, 200L);
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gmY != 1) {
                                c.this.gnp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.29.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.bIq();
                                    }
                                }, 200L);
                            }
                        } else if (!TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isOther()) {
                            c.this.gnp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.29.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bIp();
                                }
                            }, 200L);
                        } else if (alaGetVerifyStrategyResponseHttpMessage.gmW != 1) {
                            c.this.gnp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.29.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bIm();
                                }
                            }, 200L);
                        } else if (alaGetVerifyStrategyResponseHttpMessage.gmT != 1 || alaGetVerifyStrategyResponseHttpMessage.gmR != 1) {
                            c.this.gnp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.29.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bIn();
                                }
                            }, 200L);
                        } else if (alaGetVerifyStrategyResponseHttpMessage.gmY != 1) {
                            c.this.gnp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.29.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bIq();
                                }
                            }, 200L);
                        }
                    }
                }
            }
        };
        this.gnN = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.n.c.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.gnO = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.n.c.31
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String bHW;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.bHU() == 1 || masterIdentityResponseMessage.bHV() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.bHW())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.bHW());
                            jSONObject.put("content_type", "custom_master_identity");
                            bHW = jSONObject.toString();
                        } catch (JSONException e) {
                            bHW = masterIdentityResponseMessage.bHW();
                            e.printStackTrace();
                        }
                        c.this.gnr.a(27, bHW, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.gnP = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.n.c.32
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.gnQ = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.n.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.gnx = false;
                }
            }
        };
        this.gnR = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.n.c.3
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        c.this.aLQ = alaEnterLiveHttpResonseMessage.FU();
                        c.this.gmN = alaEnterLiveHttpResonseMessage.bHO();
                        c.this.gnr.e(c.this.aLQ);
                    }
                    if (c.this.aLQ != null && c.this.aLQ.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.bJy().dL(c.this.aLQ.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(c.this.aLQ.mLiveInfo.live_id);
                    }
                    if (c.this.aLQ != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.aLQ.axI != null) {
                            if (c.this.aLQ.axI.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.aLQ.axI.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aLQ.axI.nickName);
                            if (!TextUtils.isEmpty(c.this.aLQ.axI.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.aLQ.axI.portrait);
                            }
                        }
                        if (c.this.aLQ.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.aLQ.mLiveSdkInfo.tbs);
                            com.baidu.live.c.vf().putString("ala_account_user_tbs", c.this.aLQ.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.aLQ != null) {
                        if (c.this.gnu.size() <= 0) {
                            c.this.gnu.add(c.this.aLQ.mLiveInfo);
                            c.this.gnH.add(Long.valueOf(c.this.aLQ.mLiveInfo.getLiveID()));
                        }
                        c.this.h(c.this.aLQ.mLiveInfo);
                        if (c.this.gnr != null) {
                            c.this.gnr.I(c.this.aLQ.axN);
                        }
                    }
                    if (c.this.aLQ != null && c.this.aLQ.axr != null) {
                        c.this.gnB = c.this.aLQ.axr.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.aLQ);
                    if (c.this.aLQ != null && c.this.aLQ.mLiveInfo != null) {
                        c.this.bIF();
                    }
                    if (c.this.aLQ != null) {
                        c.this.aLQ.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aLQ));
                        m.Dm().L(c.this.aLQ.axN);
                    }
                    c.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.aLQ != null && c.this.aLQ.mLiveInfo != null) {
                            long j2 = c.this.aLQ.mLiveInfo.live_id;
                            long j3 = c.this.aLQ.mLiveInfo.room_id;
                            String str = c.this.aLQ.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.aLQ.axp != null) {
                                long j4 = c.this.aLQ.axp.userId;
                                str2 = c.this.aLQ.axp.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.aLQ != null && c.this.aLQ.mLiveInfo != null) {
                        long j5 = c.this.aLQ.mLiveInfo.live_id;
                        long j6 = c.this.aLQ.mLiveInfo.room_id;
                        String str3 = c.this.aLQ.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.aLQ.axp != null) {
                            j = c.this.aLQ.axp.userId;
                            str4 = c.this.aLQ.axp.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.gnw + "");
                    }
                }
            }
        };
        this.gnS = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.n.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    k kVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        kVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bwe();
                    }
                    if (kVar != null) {
                        c.this.fAG = kVar;
                    }
                    if (c.this.aLQ != null && c.this.aLQ.axr != null) {
                        if (c.this.gnB == -1) {
                            c.this.gnB = c.this.aLQ.axr.follow_status;
                        }
                        if (c.this.aLQ.axr.follow_status != c.this.gnB) {
                            c.this.aLQ.axr.follow_status = c.this.gnB;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.fAG);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.fAG));
                }
            }
        };
        this.gnT = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.n.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> bHT = alaUserLiveMarkInfoResponseMessage.bHT();
                        c.this.gnr.I(bHT);
                        if (c.this.aLQ != null) {
                            c.this.aLQ.axN = bHT;
                            m.Dm().L(c.this.aLQ.axN);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.aLQ));
                        }
                    }
                }
            }
        };
        this.gnU = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.n.c.6
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    q FU = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).FU() : null;
                    c.this.gnJ = System.currentTimeMillis();
                    if (FU == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, FU);
                        return;
                    }
                    if (c.this.aLQ == null) {
                        c.this.aLQ = FU;
                        c.this.gnr.e(c.this.aLQ);
                    } else if (c.this.aLQ.mLiveInfo != null && FU.mLiveInfo != null && c.this.aLQ.mLiveInfo.live_id != FU.mLiveInfo.live_id) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.aLQ);
                        return;
                    }
                    if (c.this.aLQ.mLiveInfo != null && FU.mLiveInfo != null && c.this.aLQ.mLiveInfo.user_id == FU.mLiveInfo.user_id) {
                        if (c.this.aLQ.mLiveInfo.imEffect != null && FU.mLiveInfo.imEffect == null) {
                            FU.mLiveInfo.imEffect = c.this.aLQ.mLiveInfo.imEffect;
                        }
                        if (c.this.aLQ.mLiveInfo.mLiveCloseData != null && FU.mLiveInfo.mLiveCloseData == null) {
                            FU.mLiveInfo.mLiveCloseData = c.this.aLQ.mLiveInfo.mLiveCloseData;
                        }
                        if (c.this.aLQ.mLiveInfo.mAlaLiveSwitchData != null && FU.mLiveInfo.mAlaLiveSwitchData == null) {
                            FU.mLiveInfo.mAlaLiveSwitchData = c.this.aLQ.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    c.this.aLQ.mLiveInfo = FU.mLiveInfo;
                    c.this.aLQ.axp = FU.axp;
                    c.this.aLQ.axq = FU.axq;
                    c.this.aLQ.axt = FU.axt;
                    c.this.aLQ.axO = FU.axO;
                    c.this.aLQ.axM = FU.axM;
                    c.this.aLQ.axL = FU.axL;
                    if (FU.axS != null && FU.axS.aBj != null && !FU.axS.aBj.isEmpty()) {
                        c.this.aLQ.axS = FU.axS;
                    }
                    if (FU.axI != null) {
                        if (FU.axI.userId == 0) {
                            if (c.this.aLQ.axI == null) {
                                c.this.aLQ.axI = new AlaLiveUserInfoData();
                            }
                            c.this.aLQ.axI.throneUid = FU.axI.throneUid;
                        } else {
                            boolean z = FU.axI.isNewUser;
                            if (c.this.aLQ.axI != null) {
                                z = c.this.aLQ.axI.isNewUser;
                            }
                            FU.axI.isNewUser = z;
                            c.this.aLQ.axI = FU.axI;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aLQ.axI.nickName);
                        }
                    }
                    if (FU.axK != null) {
                        c.this.aLQ.axK = FU.axK;
                    }
                    if (FU.axM) {
                        c.this.aLQ.axN = FU.axN;
                        if (c.this.gnr != null) {
                            c.this.gnr.I(FU.axN);
                        }
                    }
                    if (!c.this.mIsHost && c.this.aLQ.mLiveInfo != null) {
                        int i = c.this.aLQ.mLiveInfo.backstage_type;
                        if (c.this.gnr != null) {
                            c.this.gnr.ft(String.valueOf(i));
                        }
                    }
                    if (c.this.gnr != null) {
                        c.this.gnr.e(c.this.aLQ);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.aLQ);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.aLQ));
                    if (c.this.aLQ != null) {
                        m.Dm().L(c.this.aLQ.axN);
                    }
                }
            }
        };
        this.gnV = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.n.c.7
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
                    if (list != null && list.size() > 0 && c.this.gnu != null && c.this.gnu.size() > 0) {
                        for (int size = c.this.gnu.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.gnu.get(size)).live_id != c.this.aLQ.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.gnu.get(size)).getLiveID()))) {
                                c.this.gnu.remove(size);
                            }
                        }
                    }
                    if (c.this.aLQ != null) {
                        c.this.h(c.this.aLQ.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.fTb = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.n.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.gnW = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.n.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.gnq = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.gnt = alaUpdateLiveTbResponseMessage.bHS();
                    if (c.this.gnt != null) {
                        if (c.this.gnt.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, c.this.gnt.ggD);
                                jSONObject2.put("user_verify", c.this.gnt.ggF);
                                jSONObject2.put("certify", c.this.gnt.ggH);
                                if (c.this.gnt.mLiveSdkInfo != null && c.this.gnt.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put("chat_mcast_id", c.this.gnt.mLiveSdkInfo.mCastIds.axB);
                                    jSONObject2.put("ensure_mcast_id", c.this.gnt.mLiveSdkInfo.mCastIds.axC);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (c.this.gnt.ggD != 1 || c.this.gnt.ggF != 1) {
                            c.this.gnp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bIo();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.gnt.axp != null) {
                            c.this.gnr.I(c.this.gnt.axp.live_mark_info_new);
                        }
                        if (c.this.gnt.mErrorCode != 0) {
                            if (c.this.gnt.mErrorCode == 220012) {
                                c.this.b(c.this.gnt.mErrorCode, c.this.gnt.mErrorMsg, 6, c.this.aLQ);
                                return;
                            }
                        } else {
                            c.this.aLQ = new q();
                            c.this.gnr.e(c.this.aLQ);
                            c.this.aLQ.mLiveInfo = c.this.gnt.mLiveInfo;
                            c.this.aLQ.axp = c.this.gnt.axp;
                            c.this.aLQ.mLiveSdkInfo = c.this.gnt.mLiveSdkInfo;
                            c.this.aLQ.axP = c.this.gnt.axP;
                            c.this.aLQ.axN = c.this.gnt.axp.live_mark_info_new;
                            if (c.this.gnt.axp != null && c.this.gnt.axp.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.gnt.axp.levelId);
                            }
                            c.this.aLQ.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aLQ));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.aLQ);
                    if (c.this.gnt != null && c.this.gnt.mLiveInfo != null) {
                        c.this.bIF();
                    }
                    if (c.this.aLQ != null && c.this.aLQ.mLiveInfo != null) {
                        c.this.x(c.this.aLQ.mLiveInfo.user_id, c.this.aLQ.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.gnX = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.n.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.gnr.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.gnY = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.n.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.m.b)) {
                    com.baidu.live.m.b bVar = (com.baidu.live.m.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.baZ != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.baZ.fC(bVar.contentType);
                        } else {
                            bVar.baZ.b(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.gnZ = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.n.c.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                n nVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        nVar = null;
                    } else {
                        nVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).bHQ();
                    }
                    if (nVar != null && !ListUtils.isEmpty(nVar.axA)) {
                        c.this.gnv = nVar.pn + 1;
                        com.baidu.live.data.m mVar = nVar.axA.get(nVar.axA.size() - 1);
                        if (mVar != null) {
                            c.this.mLastLiveId = mVar.mLiveInfo.live_id;
                        }
                        c.this.a(nVar);
                        if (c.this.aLQ != null) {
                            c.this.h(c.this.aLQ.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, nVar);
                    }
                }
            }
        };
        this.goa = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.n.c.25
        };
        this.gob = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(c.this.gnJ));
            }
        };
        this.mPageContext = bdPageContext;
        this.gnr = new com.baidu.live.im.d(bdPageContext, false, this);
        this.gnu = new ArrayList();
        this.gnH = new HashSet();
        initTasks();
        registerListener(this.gnU);
        registerListener(this.gnS);
        registerListener(this.gnR);
        registerListener(this.gnP);
        this.gno = BdUniqueId.gen();
        this.gnZ.setTag(this.gno);
        registerListener(this.gnZ);
        registerListener(this.gnV);
        registerListener(this.gnQ);
        registerListener(this.gnW);
        registerListener(this.fTb);
        registerListener(this.gnM);
        registerListener(this.gnN);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.gnL);
        }
        registerListener(this.gnK);
        registerListener(this.fzf);
        registerListener(this.gnT);
        registerListener(this.gnO);
        registerListener(this.gnX);
        registerListener(this.gnY);
        MessageManager.getInstance().addMessageRule(this.gnE);
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
        this.gnJ = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.gob);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bHZ();
        bIa();
        bIb();
        bIc();
        bIf();
        bIg();
    }

    private void bHZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bIa() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void bIb() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void bIc() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void bId() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.n.c.12
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

    public void bIe() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void bIf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bIg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "/ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bIh() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.n.c.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.m.b) && c.this.aLQ != null && c.this.aLQ.mLiveInfo != null) {
                    com.baidu.live.m.b bVar = (com.baidu.live.m.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", c.this.aLQ.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.baY != null) {
                        httpMessage.addParam("ext_data", bVar.baY.toString());
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

    public void bIi() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void x(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bIj() {
        bII();
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

    public void bIk() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null));
    }

    public void dM(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void bIl() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bIm() {
        if (this.gnG != null) {
            this.gnG.dismiss();
            this.gnG = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.gnG = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gnG.setAutoNight(false);
        this.gnG.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.gnG.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.bIl();
                    c.this.yY();
                }
            });
            this.gnG.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.yY();
                }
            });
        } else {
            this.gnG.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.yY();
                }
            });
        }
        this.gnG.setCancelable(false);
        this.gnG.setCanceledOnTouchOutside(false);
        this.gnG.setTitleShowCenter(true);
        this.gnG.setMessageShowCenter(true);
        this.gnG.isShowTitleAndMessage();
        this.gnG.create(this.mPageContext);
        this.gnG.show();
    }

    public void bIn() {
        if (this.gnG != null) {
            this.gnG.dismiss();
            this.gnG = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.gnG = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gnG.setAutoNight(false);
        this.gnG.setMessage(string);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gnG.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.yY();
                }
            });
        } else {
            this.gnG.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str = com.baidu.live.v.a.Hm().aZp.aAl;
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
                    c.this.yY();
                }
            });
            this.gnG.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.yY();
                }
            });
        }
        this.gnG.setCancelable(false);
        this.gnG.setCanceledOnTouchOutside(false);
        this.gnG.setTitleShowCenter(true);
        this.gnG.setMessageShowCenter(true);
        this.gnG.isShowTitleAndMessage();
        this.gnG.create(this.mPageContext);
        this.gnG.show();
    }

    public void bIo() {
        if (this.gnG != null) {
            this.gnG.dismiss();
            this.gnG = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gnG = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gnG.setAutoNight(false);
        this.gnG.setMessage(string);
        this.gnG.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.gnG.setCancelable(false);
        this.gnG.setCanceledOnTouchOutside(false);
        this.gnG.isShowTitleAndMessage();
        this.gnG.create(this.mPageContext);
        this.gnG.show();
    }

    public void bIp() {
        if (this.gnG != null) {
            this.gnG.dismiss();
            this.gnG = null;
        }
        if (this.gnF != null) {
            a(this.gnF);
        }
    }

    public void bIq() {
        if (this.gnG != null) {
            this.gnG.dismiss();
            this.gnG = null;
        }
        String string = this.mPageContext.getString(a.i.dialog_msg_to_user_info);
        this.gnG = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gnG.setAutoNight(false);
        this.gnG.setMessage(string);
        this.gnG.setPositiveButton(this.mPageContext.getString(a.i.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.20
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
                c.this.yY();
            }
        });
        this.gnG.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.yY();
            }
        });
        this.gnG.setCancelable(false);
        this.gnG.setCanceledOnTouchOutside(false);
        this.gnG.setTitleShowCenter(true);
        this.gnG.setMessageShowCenter(true);
        this.gnG.isShowTitleAndMessage();
        this.gnG.create(this.mPageContext);
        this.gnG.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gnG = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gnG.setAutoNight(false);
        this.gnG.setMessage(string);
        this.gnG.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.c.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.gnG.setCancelable(false);
        this.gnG.setCanceledOnTouchOutside(false);
        this.gnG.isShowTitleAndMessage();
        this.gnG.create(this.mPageContext);
        this.gnG.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.gnF = null;
        this.gnG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yY() {
        if (this.gnG != null) {
            this.gnG.dismiss();
            this.gnG = null;
        }
        this.gnF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.gkz != null) {
            this.gkz.a(i, str, i2, obj);
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

    public void bIr() {
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

    public void rS(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void y(long j, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.an(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public h bIs() {
        return this.gnt;
    }

    public q FU() {
        return this.aLQ;
    }

    public aj bHO() {
        return this.gmN;
    }

    public List<AlaLiveInfoData> bIt() {
        return this.gnu;
    }

    public k bwe() {
        return this.fAG;
    }

    public void bV(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
                aVar.setAudienceCount(this.aLQ.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bIu() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.gnu) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        bV(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
                if (this.gnu.size() == 1 && this.gnu.get(0).live_id == this.aLQ.mLiveInfo.live_id) {
                    if (c(nVar) != null) {
                        this.gnu.clear();
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
        for (com.baidu.live.data.m mVar : nVar.axA) {
            if (mVar != null && mVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.gnu) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == mVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.gnu.add(mVar.mLiveInfo);
                }
            }
        }
        if (this.gnu.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.gnu.size() - 200; size < this.gnu.size(); size++) {
                arrayList.add(this.gnu.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.gnu.clear();
                this.gnu.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(n nVar) {
        if (ListUtils.isEmpty(nVar.axA)) {
            return null;
        }
        for (com.baidu.live.data.m mVar : nVar.axA) {
            if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.live_id == this.aLQ.mLiveInfo.live_id) {
                return mVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bIv() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.gnu)) {
            return null;
        }
        if (this.gnH.isEmpty()) {
            arrayList.addAll(this.gnu);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gnu.size()) {
                    break;
                }
                if ((this.aLQ == null || this.aLQ.mLiveInfo == null || this.aLQ.mLiveInfo.live_id != this.gnu.get(i2).live_id) && !this.gnH.contains(Long.valueOf(this.gnu.get(i2).live_id))) {
                    arrayList.add(this.gnu.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.gnH.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.gnH.size() >= this.gnu.size() - 4) {
                lr(false);
            }
        }
    }

    public void rT(int i) {
        this.gnC = i;
    }

    public int bIw() {
        return this.gnC;
    }

    public void lr(boolean z) {
        if (com.baidu.live.liveroom.c.d.Fw().Fu()) {
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && 1 != this.gnC) {
                ls(z);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gnI > 500) {
                this.gnI = currentTimeMillis;
                com.baidu.live.liveroom.c.d.Fw().Fy().a("tieba", this.gnv, 20, this.goa);
                return;
            }
            return;
        }
        ls(z);
    }

    private void ls(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.gnv);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.mLastLiveId);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.gno);
            sendMessage(httpMessage);
        }
    }

    public void dN(String str, String str2) {
        this.gnr.Cz();
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
        aVar.vQ(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
        bIH();
    }

    public void ag(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.vQ(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        bIH();
    }

    public void Db(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.fy(str);
        aVar.setParams();
        sendMessage(aVar);
        bIH();
    }

    public void dJ(long j) {
        this.gnr.Cz();
        this.gnI = 0L;
        this.gnD = null;
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
        if (!bIx()) {
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
            httpMessage.addParam("ar_sdk_version", TbConfig.AR_SDK_VERSION);
            httpMessage.addParam("is_prettify", az.b(com.baidu.live.v.a.Hm().bdV) ? 1 : 2);
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

    private boolean bIx() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bIy() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aLQ == null) {
            this.aLQ = new q(alaLiveInfoCoreData);
            this.gnr.e(this.aLQ);
        }
        this.mLastLiveId = this.aLQ.mLiveInfo.live_id;
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
        if (this.aLQ == null) {
            this.aLQ = new q();
        }
        this.aLQ.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aLQ.axp = alaLivePersonData.mUserData;
        this.aLQ.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aLQ.axp != null && this.gnr != null) {
            this.gnr.I(this.aLQ.axp.live_mark_info_new);
        }
        this.aLQ.isHost = true;
        this.aLQ.axQ = true;
        if (this.gnr != null) {
            this.gnr.e(this.aLQ);
        }
        bIF();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aLQ));
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
        this.gnp.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.gnZ);
        MessageManager.getInstance().removeMessageRule(this.gnE);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.gnr.Cz();
        this.gns = null;
        this.mPageContext = null;
    }

    public void rU(int i) {
        this.gnw = i;
        if (this.gnu.size() == 0) {
            this.gnw = 0;
        } else if (this.gnw < 0) {
            this.gnw = this.gnu.size() + this.gnw;
        } else {
            this.gnw %= this.gnu.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.gnu.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gnu.size()) {
                    if (this.gnu.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.gnw = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bIz() {
        long j;
        if (this.aLQ == null || this.aLQ.mLiveInfo == null || this.gnu.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gnu.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aLQ.mLiveInfo.live_id;
    }

    public boolean bIA() {
        long j;
        if (this.aLQ == null || this.aLQ.mLiveInfo == null || this.gnu.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gnu.get(this.gnu.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aLQ.mLiveInfo.live_id;
    }

    public int bIB() {
        return this.gnw;
    }

    public int bIC() {
        return this.gny;
    }

    public boolean bID() {
        return this.gnz == 1;
    }

    public AlaLiveInfoData bIE() {
        if (this.gnw >= this.gnu.size()) {
            this.gnw = this.gnu.size() - 1;
        }
        if (this.gnw < 0) {
            this.gnw = 0;
        }
        if (this.gnu.size() <= this.gnw) {
            if (this.aLQ != null) {
                return this.aLQ.mLiveInfo;
            }
            return null;
        }
        return this.gnu.get(this.gnw);
    }

    public void a(a aVar) {
        this.gkz = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.gns != null) {
            this.gns.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void k(com.baidu.live.im.data.a aVar) {
        if (this.aLQ != null && this.aLQ.mLiveInfo.live_type == 1) {
            z(aVar);
        }
        if (this.gns != null) {
            this.gns.k(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void z(com.baidu.live.im.data.a aVar) {
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
            lr(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void CC() {
        if (this.gns != null) {
            this.gns.CC();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aLQ);
        if (this.aLQ != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aLQ.axp;
            } else {
                alaLiveUserInfoData = this.aLQ.axI;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aLQ.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aLQ != null && this.aLQ.axI != null && this.aLQ.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aLQ.axI.throneUid;
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
                this.gnr.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void bIF() {
        this.gnr.e(String.valueOf(this.aLQ.mLiveInfo.getGroupID()), String.valueOf(this.aLQ.mLiveInfo.getLastMsgID()), String.valueOf(this.aLQ.mLiveInfo.getUserID()), String.valueOf(this.aLQ.mLiveInfo.getLiveID()), this.aLQ.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bIG() {
        return this.gnr;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bIH() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aLQ != null) {
            try {
                if (this.aLQ.mLiveSdkInfo != null && this.aLQ.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put("chat_mcast_id", this.aLQ.mLiveSdkInfo.mCastIds.axB);
                    jSONObject2.put("ensure_mcast_id", this.aLQ.mLiveSdkInfo.mCastIds.axC);
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

    private void bII() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_QM_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(JSONObject jSONObject, String str) {
        if (!TextUtils.isEmpty(str)) {
            JsonHttpResponsedMessage jsonHttpResponsedMessage = new JsonHttpResponsedMessage(-1);
            jsonHttpResponsedMessage.setStatusCode(0, "net error");
            jsonHttpResponsedMessage.setError(-1);
            jsonHttpResponsedMessage.setErrorString("net error");
            jsonHttpResponsedMessage.setException(str);
            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_QM_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), jsonHttpResponsedMessage, true);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (this.aLQ != null && jSONObject != null) {
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
        String str2 = UbcStatConstant.ContentType.UBC_TYPE_QM_STRATEGY_SUCC;
        if (jSONObject == null || jSONObject.optInt("status") != 0) {
            str2 = UbcStatConstant.ContentType.UBC_TYPE_QM_STRATEGY;
        }
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject2), null, true);
    }

    public String bIJ() {
        return this.gnD;
    }

    public void CD(String str) {
        this.gnD = str;
    }
}
