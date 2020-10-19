package com.baidu.tieba.ala.liveroom.q;

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
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.al;
import com.baidu.live.data.ar;
import com.baidu.live.data.bh;
import com.baidu.live.data.n;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.data.u;
import com.baidu.live.im.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.message.AlaUserAuthenVerifyInfoResponseMessage;
import com.baidu.live.message.GetUserInfoHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
public class d extends BdBaseModel implements d.a {
    private u aDU;
    private HttpMessageListener gBW;
    private a gUq;
    private ar gWH;
    private int gXA;
    private int gXB;
    private int gXC;
    private int gXD;
    private String gXE;
    private com.baidu.live.w.a gXF;
    private AlaGetVerifyStrategyResponseHttpMessage gXG;
    private BdAlertDialog gXH;
    private Set<Long> gXI;
    private long gXJ;
    private long gXK;
    private long gXL;
    private boolean gXM;
    private boolean gXN;
    private HttpMessageListener gXO;
    private HttpMessageListener gXP;
    private HttpMessageListener gXQ;
    private HttpMessageListener gXR;
    private NetMessageListener gXS;
    private HttpMessageListener gXT;
    private NetMessageListener gXU;
    private HttpMessageListener gXV;
    private HttpMessageListener gXW;
    private NetMessageListener gXX;
    private NetMessageListener gXY;
    private HttpMessageListener gXZ;
    private long gXk;
    private BdUniqueId gXq;
    private Handler gXr;
    private HttpMessage gXs;
    private final com.baidu.live.im.d gXt;
    private d.a gXu;
    private al gXv;
    private List<AlaLiveInfoData> gXw;
    private int gXx;
    private int gXy;
    private boolean gXz;
    private CustomMessageListener gYa;
    private HttpMessageListener gYb;
    private HttpMessageListener gYc;
    private HttpMessageListener gYd;
    private com.baidu.live.liveroom.c.a gYe;
    private CustomMessageTask.CustomRunnable gYf;
    private CustomMessageListener gfl;
    private n ggP;
    private boolean mIsHost;
    private long mLastLiveId;
    private BdPageContext<?> mPageContext;
    private String mType;
    private String otherParams;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public d(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.gXr = new Handler();
        this.gXx = 0;
        this.gXy = 0;
        this.gXz = true;
        this.gXA = 1;
        this.gXB = 0;
        this.gXC = -1;
        this.gXD = 0;
        this.gXF = new com.baidu.live.w.a(0);
        this.otherParams = "";
        this.gXK = System.currentTimeMillis();
        this.gXL = 0L;
        this.gXM = true;
        this.gXN = false;
        this.gfl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.q.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aDU != null && d.this.aDU.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aDU.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.gXC = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aDU.mLiveInfo.user_id).param("obj_param1", d.this.aDU.mLiveInfo.live_id).param("tid", d.this.aDU.mLiveInfo.thread_id));
                            d.this.gXC = 1;
                        }
                        if (d.this.aDU != null && d.this.aDU.aHF != null) {
                            d.this.aDU.aHF.follow_status = d.this.gXC;
                        }
                    }
                }
            }
        };
        this.gXO = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.q.d.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.blq == 1 && alaUserAuthenVerifyInfoResponseMessage.blp != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.blp.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.blp.verify_video_status == 1) {
                            d.this.gXA = 4;
                        }
                    }
                }
            }
        };
        this.gXP = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.q.d.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1003303);
                        }
                    });
                    final AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    d.this.gXB = alaGetVerifyStrategyResponseHttpMessage.gWQ;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.gWM);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.gWO);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.gWR);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.gWO != 1 || alaGetVerifyStrategyResponseHttpMessage.gWM != 1 || alaGetVerifyStrategyResponseHttpMessage.gWR != 1 || alaGetVerifyStrategyResponseHttpMessage.gWT != 1) {
                            d.this.gXG = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.gWR != 1) {
                                d.this.gXr.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.caC();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gWO != 1 || alaGetVerifyStrategyResponseHttpMessage.gWM != 1) {
                                d.this.gXr.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.eq(alaGetVerifyStrategyResponseHttpMessage.gWU, alaGetVerifyStrategyResponseHttpMessage.gWV);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gWT != 1) {
                                d.this.gXr.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.caF();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.gXG = null;
                    }
                }
            }
        };
        this.gXQ = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.q.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.gXR = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.q.d.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cal;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.caj() == 1 || masterIdentityResponseMessage.cak() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cal())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cal());
                            jSONObject.put("content_type", "custom_master_identity");
                            cal = jSONObject.toString();
                        } catch (JSONException e) {
                            cal = masterIdentityResponseMessage.cal();
                            e.printStackTrace();
                        }
                        d.this.gXt.a(27, cal, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.gXS = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.q.d.31
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.gXT = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.q.d.32
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.gXz = false;
                }
            }
        };
        this.gXU = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.q.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aDU = alaEnterLiveHttpResonseMessage.Gm();
                        d.this.gWH = alaEnterLiveHttpResonseMessage.cad();
                        d.this.gXt.g(d.this.aDU);
                    }
                    if (d.this.aDU != null && d.this.aDU.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.cbJ().eD(d.this.aDU.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aDU.mLiveInfo.live_id);
                    }
                    if (d.this.aDU != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aDU.aIf != null) {
                            if (d.this.aDU.aIf.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aDU.aIf.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aDU.aIf.nickName);
                            if (!TextUtils.isEmpty(d.this.aDU.aIf.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aDU.aIf.portrait);
                            }
                        }
                        if (d.this.aDU.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aDU.mLiveSdkInfo.tbs);
                            com.baidu.live.c.AZ().putString("ala_account_user_tbs", d.this.aDU.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aDU != null) {
                        if (d.this.gXw.size() <= 0) {
                            d.this.gXw.add(d.this.aDU.mLiveInfo);
                            d.this.gXI.add(Long.valueOf(d.this.aDU.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aDU.mLiveInfo);
                        if (d.this.gXt != null) {
                            d.this.gXt.Q(d.this.aDU.aIm);
                        }
                    }
                    if (d.this.aDU != null && d.this.aDU.aHF != null) {
                        d.this.gXC = d.this.aDU.aHF.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aDU);
                    if (d.this.aDU != null && d.this.aDU.mLiveInfo != null) {
                        d.this.caT();
                    }
                    if (d.this.aDU != null) {
                        d.this.aDU.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aDU));
                        com.baidu.live.im.b.d.Lm().T(d.this.aDU.aIm);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aDU != null && d.this.aDU.mLiveInfo != null) {
                            long j2 = d.this.aDU.mLiveInfo.live_id;
                            long j3 = d.this.aDU.mLiveInfo.room_id;
                            String str = d.this.aDU.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aDU.aHD != null) {
                                long j4 = d.this.aDU.aHD.userId;
                                str2 = d.this.aDU.aHD.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && d.this.aDU != null && d.this.aDU.mLiveInfo != null) {
                        long j5 = d.this.aDU.mLiveInfo.live_id;
                        long j6 = d.this.aDU.mLiveInfo.room_id;
                        String str3 = d.this.aDU.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aDU.aHD != null) {
                            j = d.this.aDU.aHD.userId;
                            str4 = d.this.aDU.aHD.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.gXy + "");
                    }
                    if (d.this.aDU != null && d.this.aDU.mLiveInfo != null) {
                        if (!com.baidu.tieba.ala.liveroom.performancewatchtask.b.cbg().cbf()) {
                            try {
                                if (d.this.aDU.mLiveInfo.isPubShow && TbadkCoreApplication.getCurrentAccount() != null) {
                                    com.baidu.live.view.a.SY().io(String.valueOf(d.this.aDU.mLiveInfo.user_id));
                                    com.baidu.tieba.ala.liveroom.performancewatchtask.b.cbg().a(d.this.mPageContext, d.this.aDU.mLiveInfo.live_id, Long.parseLong(TbadkCoreApplication.getCurrentAccount()), d.this.aDU.mLiveInfo, d.this.mType);
                                }
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                        com.baidu.tieba.ala.liveroom.performancewatchtask.b.cbg().ni(false);
                    }
                }
            }
        };
        this.gXV = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.q.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    n nVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        nVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bMo();
                    }
                    if (nVar != null) {
                        d.this.ggP = nVar;
                    }
                    if (d.this.aDU != null && d.this.aDU.aHF != null) {
                        if (d.this.gXC == -1) {
                            d.this.gXC = d.this.aDU.aHF.follow_status;
                        }
                        if (d.this.aDU.aHF.follow_status != d.this.gXC) {
                            d.this.aDU.aHF.follow_status = d.this.gXC;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.ggP);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.ggP));
                }
            }
        };
        this.gXW = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.q.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cai = alaUserLiveMarkInfoResponseMessage.cai();
                        d.this.gXt.Q(cai);
                        if (d.this.aDU != null) {
                            d.this.aDU.aIm = cai;
                            com.baidu.live.im.b.d.Lm().T(d.this.aDU.aIm);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aDU));
                        }
                    }
                }
            }
        };
        this.gXX = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.q.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    u Gm = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).Gm() : null;
                    d.this.gXk = System.currentTimeMillis();
                    if (Gm == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, Gm);
                        return;
                    }
                    if (d.this.aDU == null) {
                        d.this.aDU = Gm;
                        d.this.gXt.g(d.this.aDU);
                    } else if (d.this.aDU.mLiveInfo != null && Gm.mLiveInfo != null && d.this.aDU.mLiveInfo.live_id != Gm.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aDU);
                        return;
                    }
                    if (d.this.aDU.mLiveInfo != null && Gm.mLiveInfo != null && d.this.aDU.mLiveInfo.user_id == Gm.mLiveInfo.user_id) {
                        if (d.this.aDU.mLiveInfo.imEffect != null && Gm.mLiveInfo.imEffect == null) {
                            Gm.mLiveInfo.imEffect = d.this.aDU.mLiveInfo.imEffect;
                        }
                        if (d.this.aDU.mLiveInfo.mLiveCloseData != null && Gm.mLiveInfo.mLiveCloseData == null) {
                            Gm.mLiveInfo.mLiveCloseData = d.this.aDU.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aDU.mLiveInfo.mAlaLiveSwitchData != null && Gm.mLiveInfo.mAlaLiveSwitchData == null) {
                            Gm.mLiveInfo.mAlaLiveSwitchData = d.this.aDU.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aDU.mLiveInfo = Gm.mLiveInfo;
                    d.this.aDU.aIw = Gm.aIw;
                    if (Gm.aHD != null && Gm.aHD.userId != 0) {
                        d.this.aDU.aHD = Gm.aHD;
                    }
                    d.this.aDU.aHE = Gm.aHE;
                    d.this.aDU.aHI = Gm.aHI;
                    d.this.aDU.aIn = Gm.aIn;
                    d.this.aDU.aIl = Gm.aIl;
                    d.this.aDU.aIi = Gm.aIi;
                    d.this.aDU.aIj = Gm.aIj;
                    d.this.aDU.aIk = Gm.aIk;
                    if (Gm.aIq != null && Gm.aIq.aMh != null && !Gm.aIq.aMh.isEmpty()) {
                        d.this.aDU.aIq = Gm.aIq;
                    }
                    if (Gm.aIf != null) {
                        if (Gm.aIf.userId == 0) {
                            if (d.this.aDU.aIf == null) {
                                d.this.aDU.aIf = new AlaLiveUserInfoData();
                            }
                            d.this.aDU.aIf.throneUid = Gm.aIf.throneUid;
                        } else {
                            boolean z = Gm.aIf.isNewUser;
                            if (d.this.aDU.aIf != null) {
                                z = d.this.aDU.aIf.isNewUser;
                            }
                            Gm.aIf.isNewUser = z;
                            d.this.aDU.aIf = Gm.aIf;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aDU.aIf.nickName);
                        }
                    }
                    if (Gm.aIh != null) {
                        d.this.aDU.aIh = Gm.aIh;
                    }
                    if (Gm.aIl) {
                        d.this.aDU.aIm = Gm.aIm;
                        if (d.this.gXt != null) {
                            d.this.gXt.Q(Gm.aIm);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aDU.mLiveInfo != null) {
                        int i = d.this.aDU.mLiveInfo.backstage_type;
                        if (d.this.gXt != null) {
                            d.this.gXt.hr(String.valueOf(i));
                        }
                    }
                    if (d.this.gXt != null) {
                        d.this.gXt.g(d.this.aDU);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aDU);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aDU));
                    if (d.this.aDU != null) {
                        com.baidu.live.im.b.d.Lm().T(d.this.aDU.aIm);
                    }
                }
            }
        };
        this.gXY = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.q.d.6
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                List<Long> list;
                long j;
                if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (!(responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage)) {
                        list = null;
                        j = 5000;
                    } else {
                        AlaMGetLiveStatusHttpResponseMessage alaMGetLiveStatusHttpResponseMessage = (AlaMGetLiveStatusHttpResponseMessage) responsedMessage;
                        list = alaMGetLiveStatusHttpResponseMessage.getClosedIds();
                        j = alaMGetLiveStatusHttpResponseMessage.getInterval();
                    }
                    long j2 = j >= 5000 ? j : 5000L;
                    if (list != null && list.size() > 0 && d.this.gXw != null && d.this.gXw.size() > 0) {
                        for (int size = d.this.gXw.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.gXw.get(size)).live_id != d.this.aDU.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.gXw.get(size)).getLiveID()))) {
                                d.this.gXw.remove(size);
                            }
                        }
                    }
                    if (d.this.aDU != null) {
                        d.this.h(d.this.aDU.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.gBW = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.q.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.gXZ = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.q.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.gXs = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.gXv = alaUpdateLiveTbResponseMessage.cah();
                    if (d.this.gXv != null) {
                        if (d.this.gXv.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.gXv.aMm);
                                jSONObject2.put("user_verify", d.this.gXv.aMo);
                                jSONObject2.put("certify", d.this.gXv.aMq);
                                if (d.this.gXv.mLiveSdkInfo != null && d.this.gXv.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put("chat_mcast_id", d.this.gXv.mLiveSdkInfo.mCastIds.aHY);
                                    jSONObject2.put("ensure_mcast_id", d.this.gXv.mLiveSdkInfo.mCastIds.aHZ);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.gXv.aMm != 1 || d.this.gXv.aMo != 1) {
                            d.this.gXr.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.caD();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.gXv.aHD != null) {
                            d.this.gXt.Q(d.this.gXv.aHD.live_mark_info_new);
                        }
                        if (d.this.gXv.mErrorCode != 0) {
                            if (d.this.gXv.mErrorCode == 220012) {
                                d.this.b(d.this.gXv.mErrorCode, d.this.gXv.mErrorMsg, 6, d.this.aDU);
                                return;
                            }
                        } else {
                            d.this.aDU = new u();
                            d.this.gXt.g(d.this.aDU);
                            d.this.aDU.mLiveInfo = d.this.gXv.mLiveInfo;
                            d.this.aDU.aHD = d.this.gXv.aHD;
                            d.this.aDU.mLiveSdkInfo = d.this.gXv.mLiveSdkInfo;
                            d.this.aDU.aIo = d.this.gXv.aIo;
                            d.this.aDU.aIm = d.this.gXv.aHD.live_mark_info_new;
                            d.this.aDU.aIj = d.this.gXv.aIj;
                            if (d.this.gXv.aHD != null && d.this.gXv.aHD.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.gXv.aHD.levelId);
                            }
                            d.this.aDU.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aDU));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aDU);
                    if (d.this.gXv != null && d.this.gXv.mLiveInfo != null) {
                        d.this.caT();
                    }
                    if (d.this.aDU != null && d.this.aDU.mLiveInfo != null) {
                        d.this.s(d.this.aDU.mLiveInfo.user_id, d.this.aDU.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.gYa = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.q.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.gXt.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.gYb = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.q.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.n.b)) {
                    com.baidu.live.n.b bVar = (com.baidu.live.n.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.bnb != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.bnb.hA(bVar.contentType);
                        } else {
                            bVar.bnb.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.gYc = new HttpMessageListener(1021125) { // from class: com.baidu.tieba.ala.liveroom.q.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetUserInfoHttpResponseMessage)) {
                    GetUserInfoHttpResponseMessage getUserInfoHttpResponseMessage = (GetUserInfoHttpResponseMessage) httpResponsedMessage;
                    if (d.this.aDU != null && d.this.aDU.aIf != null && getUserInfoHttpResponseMessage.userId == d.this.aDU.aIf.userId && !TextUtils.isEmpty(getUserInfoHttpResponseMessage.userName)) {
                        d.this.aDU.aIf.nickName = getUserInfoHttpResponseMessage.userName;
                    }
                }
            }
        };
        this.gYd = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.q.d.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q qVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        qVar = null;
                    } else {
                        qVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).caf();
                    }
                    if (qVar != null && !ListUtils.isEmpty(qVar.aHS)) {
                        d.this.gXM = qVar.aHR;
                        d.this.gXx = qVar.pn + 1;
                        p pVar = qVar.aHS.get(qVar.aHS.size() - 1);
                        if (pVar != null) {
                            d.this.mLastLiveId = pVar.mLiveInfo.live_id;
                        }
                        d.this.a(qVar);
                        if (d.this.aDU != null) {
                            d.this.h(d.this.aDU.mLiveInfo);
                        }
                        d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, qVar);
                    }
                }
            }
        };
        this.gYe = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.q.d.25
        };
        this.gYf = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.gXk));
            }
        };
        this.mPageContext = bdPageContext;
        this.gXt = new com.baidu.live.im.d(bdPageContext, false, this);
        this.gXw = new ArrayList();
        this.gXI = new HashSet();
        initTasks();
        registerListener(this.gXX);
        registerListener(this.gXV);
        registerListener(this.gXU);
        registerListener(this.gXS);
        this.gXq = BdUniqueId.gen();
        this.gYd.setTag(this.gXq);
        registerListener(this.gYd);
        registerListener(this.gXY);
        registerListener(this.gXT);
        registerListener(this.gXZ);
        registerListener(this.gBW);
        registerListener(this.gXP);
        registerListener(this.gXQ);
        registerListener(this.gXO);
        registerListener(this.gfl);
        registerListener(this.gXW);
        registerListener(this.gXR);
        registerListener(this.gYa);
        registerListener(this.gYb);
        registerListener(this.gYc);
        MessageManager.getInstance().addMessageRule(this.gXF);
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
        this.gXk = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.gYf);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        caq();
        car();
        cas();
        cat();
        caw();
        cax();
    }

    public void setIsMixLive(boolean z) {
        this.gXN = z;
    }

    private void caq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void car() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void cas() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void cat() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void cau() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.q.d.12
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    Log.i("i", "@@@ localText lrmd run");
                    d.this.c(customMessage.getData());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void cav() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void caw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cax() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cay() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.n.b) && d.this.aDU != null && d.this.aDU.mLiveInfo != null) {
                    com.baidu.live.n.b bVar = (com.baidu.live.n.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aDU.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.bna != null) {
                        httpMessage.addParam("ext_data", bVar.bna.toString());
                    }
                    httpMessage.setExtra(bVar);
                    d.this.sendMessage(httpMessage);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void caz() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void s(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void caA() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    public void ep(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void caB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void caC() {
        if (this.gXH != null) {
            this.gXH.dismiss();
            this.gXH = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.gXH = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gXH.setAutoNight(false);
        this.gXH.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.gXH.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.caB();
                    d.this.Gz();
                }
            });
            this.gXH.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Gz();
                }
            });
        } else {
            this.gXH.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Gz();
                }
            });
        }
        this.gXH.setCancelable(false);
        this.gXH.setCanceledOnTouchOutside(false);
        this.gXH.setTitleShowCenter(true);
        this.gXH.setMessageShowCenter(true);
        this.gXH.isShowTitleAndMessage();
        this.gXH.create(this.mPageContext);
        this.gXH.show();
    }

    public void eq(String str, String str2) {
        if (this.gXH != null) {
            this.gXH.dismiss();
            this.gXH = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.gXH = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gXH.setAutoNight(false);
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.gXH.setTitle(str);
        } else if (StringUtils.isNull(str2)) {
            str2 = string;
        }
        this.gXH.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gXH.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Gz();
                }
            });
        } else {
            this.gXH.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.x.a.OS().blo.aLd;
                        if (!TextUtils.isEmpty(str3)) {
                            BrowserHelper.startInternalWebActivity(d.this.mPageContext.getPageActivity(), str3);
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
                    d.this.Gz();
                }
            });
            this.gXH.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Gz();
                }
            });
        }
        this.gXH.setCancelable(false);
        this.gXH.setCanceledOnTouchOutside(false);
        this.gXH.setTitleShowCenter(true);
        this.gXH.setMessageShowCenter(true);
        this.gXH.isShowTitleAndMessage();
        this.gXH.create(this.mPageContext);
        this.gXH.show();
    }

    public void caD() {
        if (this.gXH != null) {
            this.gXH.dismiss();
            this.gXH = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gXH = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gXH.setAutoNight(false);
        this.gXH.setMessage(string);
        this.gXH.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.gXH.setCancelable(false);
        this.gXH.setCanceledOnTouchOutside(false);
        this.gXH.isShowTitleAndMessage();
        this.gXH.create(this.mPageContext);
        this.gXH.show();
    }

    public void caE() {
        if (this.gXH != null) {
            this.gXH.dismiss();
            this.gXH = null;
        }
        if (this.gXG != null) {
            a(this.gXG);
        }
    }

    public void caF() {
        if (this.gXH != null) {
            this.gXH.dismiss();
            this.gXH = null;
        }
        String string = this.mPageContext.getString(a.i.dialog_msg_to_user_info);
        this.gXH = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gXH.setAutoNight(false);
        this.gXH.setMessage(string);
        this.gXH.setPositiveButton(this.mPageContext.getString(a.i.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                IExtraParams buildParamsExtra;
                if (TbadkCoreApplication.getInst().isTieba()) {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(d.this.mPageContext.getPageActivity(), TbadkCoreApplication.getCurrentAccountId() + "");
                    }
                } else if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && (buildParamsExtra = ExtraParamsManager.getInstance().buildParamsExtra()) != null) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(ExtraParamsManager.KEY_GO_USER_INFO, "");
                        buildParamsExtra.process(hashMap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                d.this.Gz();
            }
        });
        this.gXH.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.Gz();
            }
        });
        this.gXH.setCancelable(false);
        this.gXH.setCanceledOnTouchOutside(false);
        this.gXH.setTitleShowCenter(true);
        this.gXH.setMessageShowCenter(true);
        this.gXH.isShowTitleAndMessage();
        this.gXH.create(this.mPageContext);
        this.gXH.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gXH = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gXH.setAutoNight(false);
        this.gXH.setMessage(string);
        this.gXH.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.gXH.setCancelable(false);
        this.gXH.setCanceledOnTouchOutside(false);
        this.gXH.isShowTitleAndMessage();
        this.gXH.create(this.mPageContext);
        this.gXH.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.gXG = null;
        this.gXH = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gz() {
        if (this.gXH != null) {
            this.gXH.dismiss();
            this.gXH = null;
        }
        this.gXG = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.gUq != null) {
            this.gUq.a(i, str, i2, obj);
        }
    }

    public void g(long j, boolean z) {
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
        bVar.ao(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void caG() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public void r(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021077);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("net_status", i);
        sendMessage(httpMessage);
    }

    public void vx(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void t(long j, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.ao(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public al caH() {
        return this.gXv;
    }

    public u Gm() {
        return this.aDU;
    }

    public ar cad() {
        return this.gWH;
    }

    public List<AlaLiveInfoData> caI() {
        return this.gXw;
    }

    public n bMo() {
        return this.ggP;
    }

    public void cj(List<Long> list) {
        if (!this.gXN) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
                com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
                if (this.aDU != null && this.aDU.mLiveInfo != null) {
                    aVar.setAudienceCount(this.aDU.mLiveInfo.audience_count);
                }
                aVar.setListIds(list);
                aVar.setParams();
                sendMessage(aVar);
            }
        }
    }

    public void caJ() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.gXw) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cj(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar) {
        if (qVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.gXw.size() == 1 && this.gXw.get(0).live_id == this.aDU.mLiveInfo.live_id) {
                    if (c(qVar) != null) {
                        this.gXw.clear();
                    }
                    b(qVar);
                    return;
                }
                b(qVar);
                return;
            }
            b(qVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(q qVar) {
        boolean z;
        for (p pVar : qVar.aHS) {
            if (pVar != null && pVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.gXw) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == pVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.gXw.add(pVar.mLiveInfo);
                }
            }
        }
        if (this.gXw.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.gXw.size() - 200; size < this.gXw.size(); size++) {
                arrayList.add(this.gXw.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.gXw.clear();
                this.gXw.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(q qVar) {
        if (ListUtils.isEmpty(qVar.aHS)) {
            return null;
        }
        for (p pVar : qVar.aHS) {
            if (pVar != null && pVar.mLiveInfo != null && pVar.mLiveInfo.live_id == this.aDU.mLiveInfo.live_id) {
                return pVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> caK() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.gXw)) {
            return null;
        }
        if (this.gXI.isEmpty()) {
            arrayList.addAll(this.gXw);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gXw.size()) {
                    break;
                }
                if ((this.aDU == null || this.aDU.mLiveInfo == null || this.aDU.mLiveInfo.live_id != this.gXw.get(i2).live_id) && !this.gXI.contains(Long.valueOf(this.gXw.get(i2).live_id))) {
                    arrayList.add(this.gXw.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.gXI.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.gXI.size() >= this.gXw.size() - 4) {
                ng(false);
            }
        }
    }

    public void vy(int i) {
        this.gXD = i;
    }

    public void ng(boolean z) {
        if (!this.gXN) {
            if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.ME().MC()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gXJ > 500) {
                    this.gXJ = currentTimeMillis;
                    com.baidu.live.liveroom.c.d.ME().MG().a("tieba", this.gXx, 20, this.gYe);
                    return;
                }
                return;
            }
            nh(z);
        }
    }

    private void nh(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gXL >= 1800000) {
                this.gXK = currentTimeMillis;
                this.gXM = true;
            }
            if (this.gXM) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.gXx);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.gXK);
                httpMessage.setTag(this.gXq);
                sendMessage(httpMessage);
                this.gXL = currentTimeMillis;
            }
        }
    }

    public void er(String str, String str2) {
        this.gXt.bR(true);
        HttpMessage httpMessage = new HttpMessage(1021036);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("close_reason", str2);
        httpMessage.setTag(BdUniqueId.gen());
        sendMessage(httpMessage);
    }

    public void a(long j, boolean z, String str, String str2) {
        a(j, z, str, str2, 0);
    }

    public void a(long j, boolean z, String str, String str2, int i) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str2);
        aVar.At(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.Hw("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        caV();
    }

    public void aj(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.At(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        caV();
    }

    public void Hx(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.hx(str);
        aVar.setParams();
        sendMessage(aVar);
        caV();
    }

    public void eB(long j) {
        this.gXt.bR(false);
        this.gXJ = 0L;
        this.gXE = null;
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
        if (!caL()) {
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
            httpMessage.addParam(UbcStatConstant.KEY_LIVE_TYPE, i4);
            httpMessage.addParam("open_type", 2);
            httpMessage.addParam("screen_direction", i5);
            httpMessage.addParam("ar_sdk_version", TbConfig.AR_SDK_VERSION);
            httpMessage.addParam("is_prettify", bh.b(com.baidu.live.x.a.OS().bqJ) ? 1 : 2);
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isMobileBaidu() || TbadkCoreApplication.getInst().isTieba()) {
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
            httpMessage.addParam("im_uk", AccountManager.getUK(this.mPageContext.getPageActivity()));
            sendMessage(httpMessage);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                BdStatisticsManager.getInstance().newDebug("updatelive", 0L, null, "forum_name", str, "forum_id", str2, "description", str3, "is_location", Integer.valueOf(i), "lat", Double.toString(d), "lng", Double.toString(d2), "location_name", str4, "location_name_md5", str5, "is_to_tb_some", Integer.valueOf(i2), "cover", str6, "vcode", str7, "vcode_md5", str8, "is_test_live", Integer.valueOf(i3), UbcStatConstant.KEY_LIVE_TYPE, Integer.valueOf(i4), "screen_direction", Integer.valueOf(i5), "clarity", Integer.valueOf(i6), "game_id", str9, "game_name", str10);
            }
        }
    }

    private boolean caL() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void caM() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aDU == null) {
            this.aDU = new u(alaLiveInfoCoreData);
            this.gXt.g(this.aDU);
        }
        this.mLastLiveId = this.aDU.mLiveInfo.live_id;
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
        if (this.aDU == null) {
            this.aDU = new u();
        }
        this.aDU.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aDU.aHD = alaLivePersonData.mUserData;
        this.aDU.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aDU.aHD != null && this.gXt != null) {
            this.gXt.Q(this.aDU.aHD.live_mark_info_new);
        }
        this.aDU.isHost = true;
        this.aDU.aIp = true;
        if (this.gXt != null) {
            this.gXt.g(this.aDU);
        }
        caT();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aDU));
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
        this.gXr.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.gYd);
        MessageManager.getInstance().removeMessageRule(this.gXF);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.gXt.bR(true);
        this.gXu = null;
        this.mPageContext = null;
    }

    public void vz(int i) {
        this.gXy = i;
        if (this.gXw.size() == 0) {
            this.gXy = 0;
        } else if (this.gXy < 0) {
            this.gXy = this.gXw.size() + this.gXy;
        } else {
            this.gXy %= this.gXw.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.gXw.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gXw.size()) {
                    if (this.gXw.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.gXy = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean caN() {
        long j;
        if (this.aDU == null || this.aDU.mLiveInfo == null || this.gXw.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gXw.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDU.mLiveInfo.live_id;
    }

    public boolean caO() {
        long j;
        if (this.aDU == null || this.aDU.mLiveInfo == null || this.gXw.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gXw.get(this.gXw.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDU.mLiveInfo.live_id;
    }

    public int caP() {
        return this.gXy;
    }

    public int caQ() {
        return this.gXA;
    }

    public boolean caR() {
        return this.gXB == 1;
    }

    public AlaLiveInfoData caS() {
        if (this.gXy >= this.gXw.size()) {
            this.gXy = this.gXw.size() - 1;
        }
        if (this.gXy < 0) {
            this.gXy = 0;
        }
        if (this.gXw.size() <= this.gXy) {
            if (this.aDU != null) {
                return this.aDU.mLiveInfo;
            }
            return null;
        }
        return this.gXw.get(this.gXy);
    }

    public void a(a aVar) {
        this.gUq = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.gXu != null) {
            this.gXu.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void r(com.baidu.live.im.data.a aVar) {
        if (this.aDU != null && this.aDU.mLiveInfo.live_type == 1) {
            B(aVar);
        }
        if (this.gXu != null) {
            this.gXu.r(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void B(com.baidu.live.im.data.a aVar) {
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
            ng(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void Kr() {
        if (this.gXu != null) {
            this.gXu.Kr();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aDU);
        if (this.aDU != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aDU.aHD;
            } else {
                alaLiveUserInfoData = this.aDU.aIf;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aDU.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aDU != null && this.aDU.aIf != null && this.aDU.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aDU.aIf.throneUid;
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
                this.gXt.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void caT() {
        this.gXt.e(String.valueOf(this.aDU.mLiveInfo.getGroupID()), String.valueOf(this.aDU.mLiveInfo.getLastMsgID()), String.valueOf(this.aDU.mLiveInfo.getUserID()), String.valueOf(this.aDU.mLiveInfo.getLiveID()), this.aDU.mLiveInfo.appId);
    }

    public com.baidu.live.im.d caU() {
        return this.gXt;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void caV() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aDU != null) {
            try {
                if (this.aDU.mLiveSdkInfo != null && this.aDU.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put("chat_mcast_id", this.aDU.mLiveSdkInfo.mCastIds.aHY);
                    jSONObject2.put("ensure_mcast_id", this.aDU.mLiveSdkInfo.mCastIds.aHZ);
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

    public String caW() {
        return this.gXE;
    }

    public void GV(String str) {
        this.gXE = str;
    }

    public void Hy(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                this.mType = new JSONObject(str).optString(AlaLastLiveroomInfo.KEY_LAST_FROM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
