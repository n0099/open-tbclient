package com.baidu.tieba.ala.liveroom.o;

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
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ae;
import com.baidu.live.data.ak;
import com.baidu.live.data.ba;
import com.baidu.live.data.k;
import com.baidu.live.data.m;
import com.baidu.live.data.n;
import com.baidu.live.data.q;
import com.baidu.live.im.d;
import com.baidu.live.im.data.ImSendMsgData;
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
/* loaded from: classes4.dex */
public class c extends BdBaseModel implements d.a {
    private q avf;
    private CustomMessageListener fEm;
    private k fFQ;
    private HttpMessageListener fYu;
    private a gpy;
    private ak grL;
    private String gsA;
    private int gsB;
    private int gsC;
    private String gsD;
    private com.baidu.live.u.a gsE;
    private AlaGetVerifyStrategyResponseHttpMessage gsF;
    private BdAlertDialog gsG;
    private Set<Long> gsH;
    private long gsI;
    private long gsJ;
    private HttpMessageListener gsK;
    private CustomMessageListener gsL;
    private HttpMessageListener gsM;
    private HttpMessageListener gsN;
    private HttpMessageListener gsO;
    private NetMessageListener gsP;
    private HttpMessageListener gsQ;
    private NetMessageListener gsR;
    private HttpMessageListener gsS;
    private HttpMessageListener gsT;
    private NetMessageListener gsU;
    private NetMessageListener gsV;
    private HttpMessageListener gsW;
    private CustomMessageListener gsX;
    private HttpMessageListener gsY;
    private HttpMessageListener gsZ;
    private BdUniqueId gso;
    private Handler gsp;
    private HttpMessage gsq;
    private final com.baidu.live.im.d gsr;
    private d.a gss;
    private ae gst;
    private List<AlaLiveInfoData> gsu;
    private int gsv;
    private int gsw;
    private boolean gsx;
    private int gsy;
    private int gsz;
    private com.baidu.live.liveroom.c.a gta;
    private CustomMessageTask.CustomRunnable gtb;
    private boolean mIsHost;
    private long mLastLiveId;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.gsp = new Handler();
        this.gsv = 0;
        this.gsw = 0;
        this.gsx = true;
        this.gsy = 1;
        this.gsz = 0;
        this.gsB = -1;
        this.gsC = 0;
        this.gsE = new com.baidu.live.u.a(0);
        this.otherParams = "";
        this.fEm = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.o.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.avf != null && c.this.avf.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.avf.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.gsB = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.avf.mLiveInfo.user_id).param("obj_param1", c.this.avf.mLiveInfo.live_id).param("tid", c.this.avf.mLiveInfo.thread_id));
                            c.this.gsB = 1;
                        }
                        if (c.this.avf != null && c.this.avf.ayE != null) {
                            c.this.avf.ayE.follow_status = c.this.gsB;
                        }
                    }
                }
            }
        };
        this.gsK = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.o.c.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.aZp == 1 && alaUserAuthenVerifyInfoResponseMessage.aZo != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.aZo.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.aZo.verify_video_status == 1) {
                            c.this.gsy = 4;
                        }
                    }
                }
            }
        };
        this.gsL = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.o.c.28
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
                                c.this.gsA = optJSONObject2.optString("cmd");
                            } else {
                                i = 0;
                            }
                        } else {
                            i = 0;
                            jSONObject = null;
                        }
                        String optString = jSONObject2.optString(BdStatsConstant.StatsType.ERROR);
                        c.this.A(jSONObject, optString);
                        if (!TextUtils.isEmpty(optString)) {
                            BdUtilHelper.showToast(c.this.mPageContext.getPageActivity(), a.i.sdk_neterror);
                        } else if (i != 1) {
                            c.this.gsp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.28.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bLs();
                                }
                            }, 200L);
                        } else if (!z) {
                            c.this.gsp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.28.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.dN(null, null);
                                }
                            }, 200L);
                        } else {
                            c.this.bLq();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.gsM = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.o.c.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.29.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1003303);
                        }
                    });
                    final AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    c.this.gsz = alaGetVerifyStrategyResponseHttpMessage.grT;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.grP);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.grR);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.grU);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (alaGetVerifyStrategyResponseHttpMessage.grR == 1 && alaGetVerifyStrategyResponseHttpMessage.grP == 1 && alaGetVerifyStrategyResponseHttpMessage.grW == 1) {
                                c.this.gsF = null;
                                return;
                            }
                        } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && alaGetVerifyStrategyResponseHttpMessage.grR == 1 && alaGetVerifyStrategyResponseHttpMessage.grP == 1 && alaGetVerifyStrategyResponseHttpMessage.grU == 1 && alaGetVerifyStrategyResponseHttpMessage.grW == 1) {
                            c.this.gsF = null;
                            return;
                        }
                        c.this.gsF = alaGetVerifyStrategyResponseHttpMessage;
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (alaGetVerifyStrategyResponseHttpMessage.grR != 1 || alaGetVerifyStrategyResponseHttpMessage.grP != 1) {
                                c.this.gsp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.29.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.dN(alaGetVerifyStrategyResponseHttpMessage.grX, alaGetVerifyStrategyResponseHttpMessage.grY);
                                    }
                                }, 200L);
                            } else if (alaGetVerifyStrategyResponseHttpMessage.grW != 1) {
                                c.this.gsp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.29.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.bLv();
                                    }
                                }, 200L);
                            }
                        } else if (!TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isOther()) {
                            c.this.gsp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.29.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bLu();
                                }
                            }, 200L);
                        } else if (alaGetVerifyStrategyResponseHttpMessage.grU != 1) {
                            c.this.gsp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.29.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bLs();
                                }
                            }, 200L);
                        } else if (alaGetVerifyStrategyResponseHttpMessage.grR != 1 || alaGetVerifyStrategyResponseHttpMessage.grP != 1) {
                            c.this.gsp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.29.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.dN(alaGetVerifyStrategyResponseHttpMessage.grX, alaGetVerifyStrategyResponseHttpMessage.grY);
                                }
                            }, 200L);
                        } else if (alaGetVerifyStrategyResponseHttpMessage.grW != 1) {
                            c.this.gsp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.29.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bLv();
                                }
                            }, 200L);
                        }
                    }
                }
            }
        };
        this.gsN = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.o.c.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.gsO = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.o.c.31
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String bLc;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.bLa() == 1 || masterIdentityResponseMessage.bLb() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.bLc())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.bLc());
                            jSONObject.put("content_type", "custom_master_identity");
                            bLc = jSONObject.toString();
                        } catch (JSONException e) {
                            bLc = masterIdentityResponseMessage.bLc();
                            e.printStackTrace();
                        }
                        c.this.gsr.a(27, bLc, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.gsP = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.o.c.32
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.gsQ = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.o.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.gsx = false;
                }
            }
        };
        this.gsR = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.o.c.3
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        c.this.avf = alaEnterLiveHttpResonseMessage.FO();
                        c.this.grL = alaEnterLiveHttpResonseMessage.bKU();
                        c.this.gsr.e(c.this.avf);
                    }
                    if (c.this.avf != null && c.this.avf.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.bME().dY(c.this.avf.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(c.this.avf.mLiveInfo.live_id);
                    }
                    if (c.this.avf != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.avf.ayV != null) {
                            if (c.this.avf.ayV.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.avf.ayV.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.avf.ayV.nickName);
                            if (!TextUtils.isEmpty(c.this.avf.ayV.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.avf.ayV.portrait);
                            }
                        }
                        if (c.this.avf.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.avf.mLiveSdkInfo.tbs);
                            com.baidu.live.c.vf().putString("ala_account_user_tbs", c.this.avf.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.avf != null) {
                        if (c.this.gsu.size() <= 0) {
                            c.this.gsu.add(c.this.avf.mLiveInfo);
                            c.this.gsH.add(Long.valueOf(c.this.avf.mLiveInfo.getLiveID()));
                        }
                        c.this.h(c.this.avf.mLiveInfo);
                        if (c.this.gsr != null) {
                            c.this.gsr.K(c.this.avf.aza);
                        }
                    }
                    if (c.this.avf != null && c.this.avf.ayE != null) {
                        c.this.gsB = c.this.avf.ayE.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.avf);
                    if (c.this.avf != null && c.this.avf.mLiveInfo != null) {
                        c.this.bLK();
                    }
                    if (c.this.avf != null) {
                        c.this.avf.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.avf));
                        com.baidu.live.im.b.d.Ea().N(c.this.avf.aza);
                    }
                    c.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.avf != null && c.this.avf.mLiveInfo != null) {
                            long j2 = c.this.avf.mLiveInfo.live_id;
                            long j3 = c.this.avf.mLiveInfo.room_id;
                            String str = c.this.avf.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.avf.ayC != null) {
                                long j4 = c.this.avf.ayC.userId;
                                str2 = c.this.avf.ayC.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.avf != null && c.this.avf.mLiveInfo != null) {
                        long j5 = c.this.avf.mLiveInfo.live_id;
                        long j6 = c.this.avf.mLiveInfo.room_id;
                        String str3 = c.this.avf.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.avf.ayC != null) {
                            j = c.this.avf.ayC.userId;
                            str4 = c.this.avf.ayC.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.gsw + "");
                    }
                }
            }
        };
        this.gsS = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.o.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    k kVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        kVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bzs();
                    }
                    if (kVar != null) {
                        c.this.fFQ = kVar;
                    }
                    if (c.this.avf != null && c.this.avf.ayE != null) {
                        if (c.this.gsB == -1) {
                            c.this.gsB = c.this.avf.ayE.follow_status;
                        }
                        if (c.this.avf.ayE.follow_status != c.this.gsB) {
                            c.this.avf.ayE.follow_status = c.this.gsB;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.fFQ);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.fFQ));
                }
            }
        };
        this.gsT = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.o.c.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> bKZ = alaUserLiveMarkInfoResponseMessage.bKZ();
                        c.this.gsr.K(bKZ);
                        if (c.this.avf != null) {
                            c.this.avf.aza = bKZ;
                            com.baidu.live.im.b.d.Ea().N(c.this.avf.aza);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.avf));
                        }
                    }
                }
            }
        };
        this.gsU = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.o.c.6
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    q FO = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).FO() : null;
                    c.this.gsJ = System.currentTimeMillis();
                    if (FO == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, FO);
                        return;
                    }
                    if (c.this.avf == null) {
                        c.this.avf = FO;
                        c.this.gsr.e(c.this.avf);
                    } else if (c.this.avf.mLiveInfo != null && FO.mLiveInfo != null && c.this.avf.mLiveInfo.live_id != FO.mLiveInfo.live_id) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.avf);
                        return;
                    }
                    if (c.this.avf.mLiveInfo != null && FO.mLiveInfo != null && c.this.avf.mLiveInfo.user_id == FO.mLiveInfo.user_id) {
                        if (c.this.avf.mLiveInfo.imEffect != null && FO.mLiveInfo.imEffect == null) {
                            FO.mLiveInfo.imEffect = c.this.avf.mLiveInfo.imEffect;
                        }
                        if (c.this.avf.mLiveInfo.mLiveCloseData != null && FO.mLiveInfo.mLiveCloseData == null) {
                            FO.mLiveInfo.mLiveCloseData = c.this.avf.mLiveInfo.mLiveCloseData;
                        }
                        if (c.this.avf.mLiveInfo.mAlaLiveSwitchData != null && FO.mLiveInfo.mAlaLiveSwitchData == null) {
                            FO.mLiveInfo.mAlaLiveSwitchData = c.this.avf.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    c.this.avf.mLiveInfo = FO.mLiveInfo;
                    c.this.avf.ayC = FO.ayC;
                    c.this.avf.ayD = FO.ayD;
                    c.this.avf.ayG = FO.ayG;
                    c.this.avf.azb = FO.azb;
                    c.this.avf.ayZ = FO.ayZ;
                    c.this.avf.ayY = FO.ayY;
                    if (FO.azf != null && FO.azf.aCw != null && !FO.azf.aCw.isEmpty()) {
                        c.this.avf.azf = FO.azf;
                    }
                    if (FO.ayV != null) {
                        if (FO.ayV.userId == 0) {
                            if (c.this.avf.ayV == null) {
                                c.this.avf.ayV = new AlaLiveUserInfoData();
                            }
                            c.this.avf.ayV.throneUid = FO.ayV.throneUid;
                        } else {
                            boolean z = FO.ayV.isNewUser;
                            if (c.this.avf.ayV != null) {
                                z = c.this.avf.ayV.isNewUser;
                            }
                            FO.ayV.isNewUser = z;
                            c.this.avf.ayV = FO.ayV;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.avf.ayV.nickName);
                        }
                    }
                    if (FO.ayX != null) {
                        c.this.avf.ayX = FO.ayX;
                    }
                    if (FO.ayZ) {
                        c.this.avf.aza = FO.aza;
                        if (c.this.gsr != null) {
                            c.this.gsr.K(FO.aza);
                        }
                    }
                    if (!c.this.mIsHost && c.this.avf.mLiveInfo != null) {
                        int i = c.this.avf.mLiveInfo.backstage_type;
                        if (c.this.gsr != null) {
                            c.this.gsr.fs(String.valueOf(i));
                        }
                    }
                    if (c.this.gsr != null) {
                        c.this.gsr.e(c.this.avf);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.avf);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.avf));
                    if (c.this.avf != null) {
                        com.baidu.live.im.b.d.Ea().N(c.this.avf.aza);
                    }
                }
            }
        };
        this.gsV = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.o.c.7
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
                    if (list != null && list.size() > 0 && c.this.gsu != null && c.this.gsu.size() > 0) {
                        for (int size = c.this.gsu.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.gsu.get(size)).live_id != c.this.avf.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.gsu.get(size)).getLiveID()))) {
                                c.this.gsu.remove(size);
                            }
                        }
                    }
                    if (c.this.avf != null) {
                        c.this.h(c.this.avf.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.fYu = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.o.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.gsW = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.o.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.gsq = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.gst = alaUpdateLiveTbResponseMessage.bKY();
                    if (c.this.gst != null) {
                        if (c.this.gst.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, c.this.gst.aCB);
                                jSONObject2.put("user_verify", c.this.gst.aCD);
                                jSONObject2.put("certify", c.this.gst.aCF);
                                if (c.this.gst.mLiveSdkInfo != null && c.this.gst.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put("chat_mcast_id", c.this.gst.mLiveSdkInfo.mCastIds.ayO);
                                    jSONObject2.put("ensure_mcast_id", c.this.gst.mLiveSdkInfo.mCastIds.ayP);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (c.this.gst.aCB != 1 || c.this.gst.aCD != 1) {
                            c.this.gsp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.9.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bLt();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.gst.ayC != null) {
                            c.this.gsr.K(c.this.gst.ayC.live_mark_info_new);
                        }
                        if (c.this.gst.mErrorCode != 0) {
                            if (c.this.gst.mErrorCode == 220012) {
                                c.this.b(c.this.gst.mErrorCode, c.this.gst.mErrorMsg, 6, c.this.avf);
                                return;
                            }
                        } else {
                            c.this.avf = new q();
                            c.this.gsr.e(c.this.avf);
                            c.this.avf.mLiveInfo = c.this.gst.mLiveInfo;
                            c.this.avf.ayC = c.this.gst.ayC;
                            c.this.avf.mLiveSdkInfo = c.this.gst.mLiveSdkInfo;
                            c.this.avf.azc = c.this.gst.azc;
                            c.this.avf.aza = c.this.gst.ayC.live_mark_info_new;
                            if (c.this.gst.ayC != null && c.this.gst.ayC.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.gst.ayC.levelId);
                            }
                            c.this.avf.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.avf));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.avf);
                    if (c.this.gst != null && c.this.gst.mLiveInfo != null) {
                        c.this.bLK();
                    }
                    if (c.this.avf != null && c.this.avf.mLiveInfo != null) {
                        c.this.x(c.this.avf.mLiveInfo.user_id, c.this.avf.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.gsX = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.o.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.gsr.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.gsY = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.o.c.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.m.b)) {
                    com.baidu.live.m.b bVar = (com.baidu.live.m.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.baZ != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.baZ.fA(bVar.contentType);
                        } else {
                            bVar.baZ.b(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.gsZ = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.o.c.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                n nVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        nVar = null;
                    } else {
                        nVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).bKW();
                    }
                    if (nVar != null && !ListUtils.isEmpty(nVar.ayN)) {
                        c.this.gsv = nVar.pn + 1;
                        m mVar = nVar.ayN.get(nVar.ayN.size() - 1);
                        if (mVar != null) {
                            c.this.mLastLiveId = mVar.mLiveInfo.live_id;
                        }
                        c.this.a(nVar);
                        if (c.this.avf != null) {
                            c.this.h(c.this.avf.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, nVar);
                    }
                }
            }
        };
        this.gta = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.o.c.25
        };
        this.gtb = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(c.this.gsJ));
            }
        };
        this.mPageContext = bdPageContext;
        this.gsr = new com.baidu.live.im.d(bdPageContext, false, this);
        this.gsu = new ArrayList();
        this.gsH = new HashSet();
        initTasks();
        registerListener(this.gsU);
        registerListener(this.gsS);
        registerListener(this.gsR);
        registerListener(this.gsP);
        this.gso = BdUniqueId.gen();
        this.gsZ.setTag(this.gso);
        registerListener(this.gsZ);
        registerListener(this.gsV);
        registerListener(this.gsQ);
        registerListener(this.gsW);
        registerListener(this.fYu);
        registerListener(this.gsM);
        registerListener(this.gsN);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.gsL);
        }
        registerListener(this.gsK);
        registerListener(this.fEm);
        registerListener(this.gsT);
        registerListener(this.gsO);
        registerListener(this.gsX);
        registerListener(this.gsY);
        MessageManager.getInstance().addMessageRule(this.gsE);
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
        this.gsJ = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.gtb);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bLf();
        bLg();
        bLh();
        bLi();
        bLl();
        bLm();
    }

    private void bLf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bLg() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void bLh() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void bLi() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void bLj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.o.c.12
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

    public void bLk() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void bLl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bLm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "/ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bLn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.m.b) && c.this.avf != null && c.this.avf.mLiveInfo != null) {
                    com.baidu.live.m.b bVar = (com.baidu.live.m.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", c.this.avf.mLiveInfo.live_id);
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

    public void bLo() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void x(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bLp() {
        bLN();
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

    public void bLq() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null));
    }

    public void dM(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void bLr() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bLs() {
        if (this.gsG != null) {
            this.gsG.dismiss();
            this.gsG = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.gsG = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gsG.setAutoNight(false);
        this.gsG.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.gsG.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.bLr();
                    c.this.zA();
                }
            });
            this.gsG.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.zA();
                }
            });
        } else {
            this.gsG.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.zA();
                }
            });
        }
        this.gsG.setCancelable(false);
        this.gsG.setCanceledOnTouchOutside(false);
        this.gsG.setTitleShowCenter(true);
        this.gsG.setMessageShowCenter(true);
        this.gsG.isShowTitleAndMessage();
        this.gsG.create(this.mPageContext);
        this.gsG.show();
    }

    public void dN(String str, String str2) {
        if (this.gsG != null) {
            this.gsG.dismiss();
            this.gsG = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.gsG = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gsG.setAutoNight(false);
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            str2 = string;
        } else {
            this.gsG.setTitle(str);
        }
        this.gsG.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gsG.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.zA();
                }
            });
        } else {
            this.gsG.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.v.a.Hs().aZn.aBy;
                        if (!TextUtils.isEmpty(str3)) {
                            BrowserHelper.startInternalWebActivity(c.this.mPageContext.getPageActivity(), str3);
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
                    c.this.zA();
                }
            });
            this.gsG.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.zA();
                }
            });
        }
        this.gsG.setCancelable(false);
        this.gsG.setCanceledOnTouchOutside(false);
        this.gsG.setTitleShowCenter(true);
        this.gsG.setMessageShowCenter(true);
        this.gsG.isShowTitleAndMessage();
        this.gsG.create(this.mPageContext);
        this.gsG.show();
    }

    public void bLt() {
        if (this.gsG != null) {
            this.gsG.dismiss();
            this.gsG = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gsG = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gsG.setAutoNight(false);
        this.gsG.setMessage(string);
        this.gsG.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.gsG.setCancelable(false);
        this.gsG.setCanceledOnTouchOutside(false);
        this.gsG.isShowTitleAndMessage();
        this.gsG.create(this.mPageContext);
        this.gsG.show();
    }

    public void bLu() {
        if (this.gsG != null) {
            this.gsG.dismiss();
            this.gsG = null;
        }
        if (this.gsF != null) {
            a(this.gsF);
        }
    }

    public void bLv() {
        if (this.gsG != null) {
            this.gsG.dismiss();
            this.gsG = null;
        }
        String string = this.mPageContext.getString(a.i.dialog_msg_to_user_info);
        this.gsG = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gsG.setAutoNight(false);
        this.gsG.setMessage(string);
        this.gsG.setPositiveButton(this.mPageContext.getString(a.i.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.20
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
                c.this.zA();
            }
        });
        this.gsG.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.zA();
            }
        });
        this.gsG.setCancelable(false);
        this.gsG.setCanceledOnTouchOutside(false);
        this.gsG.setTitleShowCenter(true);
        this.gsG.setMessageShowCenter(true);
        this.gsG.isShowTitleAndMessage();
        this.gsG.create(this.mPageContext);
        this.gsG.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gsG = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gsG.setAutoNight(false);
        this.gsG.setMessage(string);
        this.gsG.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.gsG.setCancelable(false);
        this.gsG.setCanceledOnTouchOutside(false);
        this.gsG.isShowTitleAndMessage();
        this.gsG.create(this.mPageContext);
        this.gsG.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.gsF = null;
        this.gsG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA() {
        if (this.gsG != null) {
            this.gsG.dismiss();
            this.gsG = null;
        }
        this.gsF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.gpy != null) {
            this.gpy.a(i, str, i2, obj);
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

    public void bLw() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public void k(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021077);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("net_status", i);
        sendMessage(httpMessage);
    }

    public void sj(int i) {
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

    public ae bLx() {
        return this.gst;
    }

    public q FO() {
        return this.avf;
    }

    public ak bKU() {
        return this.grL;
    }

    public List<AlaLiveInfoData> bLy() {
        return this.gsu;
    }

    public k bzs() {
        return this.fFQ;
    }

    public void bZ(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.avf != null && this.avf.mLiveInfo != null) {
                aVar.setAudienceCount(this.avf.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bLz() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.gsu) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        bZ(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
                if (this.gsu.size() == 1 && this.gsu.get(0).live_id == this.avf.mLiveInfo.live_id) {
                    if (c(nVar) != null) {
                        this.gsu.clear();
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
        for (m mVar : nVar.ayN) {
            if (mVar != null && mVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.gsu) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == mVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.gsu.add(mVar.mLiveInfo);
                }
            }
        }
        if (this.gsu.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.gsu.size() - 200; size < this.gsu.size(); size++) {
                arrayList.add(this.gsu.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.gsu.clear();
                this.gsu.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(n nVar) {
        if (ListUtils.isEmpty(nVar.ayN)) {
            return null;
        }
        for (m mVar : nVar.ayN) {
            if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.live_id == this.avf.mLiveInfo.live_id) {
                return mVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bLA() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.gsu)) {
            return null;
        }
        if (this.gsH.isEmpty()) {
            arrayList.addAll(this.gsu);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gsu.size()) {
                    break;
                }
                if ((this.avf == null || this.avf.mLiveInfo == null || this.avf.mLiveInfo.live_id != this.gsu.get(i2).live_id) && !this.gsH.contains(Long.valueOf(this.gsu.get(i2).live_id))) {
                    arrayList.add(this.gsu.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.gsH.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.gsH.size() >= this.gsu.size() - 4) {
                lU(false);
            }
        }
    }

    public void sk(int i) {
        this.gsC = i;
    }

    public int bLB() {
        return this.gsC;
    }

    public void lU(boolean z) {
        if (com.baidu.live.liveroom.c.d.Fq().Fo()) {
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && 1 != this.gsC) {
                lV(z);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gsI > 500) {
                this.gsI = currentTimeMillis;
                com.baidu.live.liveroom.c.d.Fq().Fs().a("tieba", this.gsv, 20, this.gta);
                return;
            }
            return;
        }
        lV(z);
    }

    private void lV(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.gsv);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.mLastLiveId);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.gso);
            sendMessage(httpMessage);
        }
    }

    public void dO(String str, String str2) {
        this.gsr.vD();
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
        aVar.wX(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
        bLM();
    }

    public void ah(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.wX(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        bLM();
    }

    public void DN(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.fx(str);
        aVar.setParams();
        sendMessage(aVar);
        bLM();
    }

    public void dX(long j) {
        this.gsr.vD();
        this.gsI = 0L;
        this.gsD = null;
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
        if (!bLC()) {
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
            httpMessage.addParam("is_prettify", ba.b(com.baidu.live.v.a.Hs().beo) ? 1 : 2);
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

    private boolean bLC() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bLD() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.avf == null) {
            this.avf = new q(alaLiveInfoCoreData);
            this.gsr.e(this.avf);
        }
        this.mLastLiveId = this.avf.mLiveInfo.live_id;
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
        if (this.avf == null) {
            this.avf = new q();
        }
        this.avf.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.avf.ayC = alaLivePersonData.mUserData;
        this.avf.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.avf.ayC != null && this.gsr != null) {
            this.gsr.K(this.avf.ayC.live_mark_info_new);
        }
        this.avf.isHost = true;
        this.avf.azd = true;
        if (this.gsr != null) {
            this.gsr.e(this.avf);
        }
        bLK();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.avf));
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
        this.gsp.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.gsZ);
        MessageManager.getInstance().removeMessageRule(this.gsE);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.gsr.vD();
        this.gss = null;
        this.mPageContext = null;
    }

    public void sl(int i) {
        this.gsw = i;
        if (this.gsu.size() == 0) {
            this.gsw = 0;
        } else if (this.gsw < 0) {
            this.gsw = this.gsu.size() + this.gsw;
        } else {
            this.gsw %= this.gsu.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.gsu.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gsu.size()) {
                    if (this.gsu.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.gsw = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bLE() {
        long j;
        if (this.avf == null || this.avf.mLiveInfo == null || this.gsu.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gsu.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.avf.mLiveInfo.live_id;
    }

    public boolean bLF() {
        long j;
        if (this.avf == null || this.avf.mLiveInfo == null || this.gsu.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gsu.get(this.gsu.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.avf.mLiveInfo.live_id;
    }

    public int bLG() {
        return this.gsw;
    }

    public int bLH() {
        return this.gsy;
    }

    public boolean bLI() {
        return this.gsz == 1;
    }

    public AlaLiveInfoData bLJ() {
        if (this.gsw >= this.gsu.size()) {
            this.gsw = this.gsu.size() - 1;
        }
        if (this.gsw < 0) {
            this.gsw = 0;
        }
        if (this.gsu.size() <= this.gsw) {
            if (this.avf != null) {
                return this.avf.mLiveInfo;
            }
            return null;
        }
        return this.gsu.get(this.gsw);
    }

    public void a(a aVar) {
        this.gpy = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.gss != null) {
            this.gss.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void r(com.baidu.live.im.data.a aVar) {
        if (this.avf != null && this.avf.mLiveInfo.live_type == 1) {
            z(aVar);
        }
        if (this.gss != null) {
            this.gss.r(aVar);
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
            lU(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void Dd() {
        if (this.gss != null) {
            this.gss.Dd();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.avf);
        if (this.avf != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.avf.ayC;
            } else {
                alaLiveUserInfoData = this.avf.ayV;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.avf.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.avf != null && this.avf.ayV != null && this.avf.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.avf.ayV.throneUid;
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
                this.gsr.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void bLK() {
        this.gsr.e(String.valueOf(this.avf.mLiveInfo.getGroupID()), String.valueOf(this.avf.mLiveInfo.getLastMsgID()), String.valueOf(this.avf.mLiveInfo.getUserID()), String.valueOf(this.avf.mLiveInfo.getLiveID()), this.avf.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bLL() {
        return this.gsr;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bLM() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.avf != null) {
            try {
                if (this.avf.mLiveSdkInfo != null && this.avf.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put("chat_mcast_id", this.avf.mLiveSdkInfo.mCastIds.ayO);
                    jSONObject2.put("ensure_mcast_id", this.avf.mLiveSdkInfo.mCastIds.ayP);
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

    private void bLN() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_QM_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(JSONObject jSONObject, String str) {
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
        if (this.avf != null && jSONObject != null) {
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

    public String bLO() {
        return this.gsD;
    }

    public void Dp(String str) {
        this.gsD = str;
    }
}
