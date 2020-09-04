package com.baidu.tieba.ala.liveroom.p;

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
import com.baidu.live.data.ag;
import com.baidu.live.data.am;
import com.baidu.live.data.bc;
import com.baidu.live.data.k;
import com.baidu.live.data.m;
import com.baidu.live.data.n;
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class d extends BdBaseModel implements d.a {
    private r aAj;
    private CustomMessageListener fPH;
    private k fRl;
    private a gCt;
    private am gEJ;
    private int gFA;
    private boolean gFB;
    private int gFC;
    private int gFD;
    private int gFE;
    private int gFF;
    private String gFG;
    private com.baidu.live.v.a gFH;
    private AlaGetVerifyStrategyResponseHttpMessage gFI;
    private BdAlertDialog gFJ;
    private Set<Long> gFK;
    private long gFL;
    private long gFM;
    private long gFN;
    private boolean gFO;
    private HttpMessageListener gFP;
    private HttpMessageListener gFQ;
    private HttpMessageListener gFR;
    private HttpMessageListener gFS;
    private NetMessageListener gFT;
    private HttpMessageListener gFU;
    private NetMessageListener gFV;
    private HttpMessageListener gFW;
    private HttpMessageListener gFX;
    private NetMessageListener gFY;
    private NetMessageListener gFZ;
    private long gFm;
    private BdUniqueId gFs;
    private Handler gFt;
    private HttpMessage gFu;
    private final com.baidu.live.im.d gFv;
    private d.a gFw;
    private ag gFx;
    private List<AlaLiveInfoData> gFy;
    private int gFz;
    private HttpMessageListener gGa;
    private CustomMessageListener gGb;
    private HttpMessageListener gGc;
    private HttpMessageListener gGd;
    private com.baidu.live.liveroom.c.a gGe;
    private CustomMessageTask.CustomRunnable gGf;
    private HttpMessageListener gkw;
    private boolean mIsHost;
    private long mLastLiveId;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes7.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public d(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.gFt = new Handler();
        this.gFz = 0;
        this.gFA = 0;
        this.gFB = true;
        this.gFC = 1;
        this.gFD = 0;
        this.gFE = -1;
        this.gFF = 0;
        this.gFH = new com.baidu.live.v.a(0);
        this.otherParams = "";
        this.gFM = System.currentTimeMillis();
        this.gFN = 0L;
        this.gFO = true;
        this.fPH = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.p.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aAj != null && d.this.aAj.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aAj.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.gFE = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aAj.mLiveInfo.user_id).param("obj_param1", d.this.aAj.mLiveInfo.live_id).param("tid", d.this.aAj.mLiveInfo.thread_id));
                            d.this.gFE = 1;
                        }
                        if (d.this.aAj != null && d.this.aAj.aDI != null) {
                            d.this.aAj.aDI.follow_status = d.this.gFE;
                        }
                    }
                }
            }
        };
        this.gFP = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.p.d.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.beL == 1 && alaUserAuthenVerifyInfoResponseMessage.beK != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.beK.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.beK.verify_video_status == 1) {
                            d.this.gFC = 4;
                        }
                    }
                }
            }
        };
        this.gFQ = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.p.d.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.27.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1003303);
                        }
                    });
                    final AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    d.this.gFD = alaGetVerifyStrategyResponseHttpMessage.gES;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.gEO);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.gEQ);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.gET);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.gEQ != 1 || alaGetVerifyStrategyResponseHttpMessage.gEO != 1 || alaGetVerifyStrategyResponseHttpMessage.gET != 1 || alaGetVerifyStrategyResponseHttpMessage.gEV != 1) {
                            d.this.gFI = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.gET != 1) {
                                d.this.gFt.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.27.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.bVx();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gEQ != 1 || alaGetVerifyStrategyResponseHttpMessage.gEO != 1) {
                                d.this.gFt.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.27.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ef(alaGetVerifyStrategyResponseHttpMessage.gEW, alaGetVerifyStrategyResponseHttpMessage.gEX);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gEV != 1) {
                                d.this.gFt.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.27.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.bVA();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.gFI = null;
                    }
                }
            }
        };
        this.gFR = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.p.d.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.gFS = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.p.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String bVg;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.bVe() == 1 || masterIdentityResponseMessage.bVf() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.bVg())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.bVg());
                            jSONObject.put("content_type", "custom_master_identity");
                            bVg = jSONObject.toString();
                        } catch (JSONException e) {
                            bVg = masterIdentityResponseMessage.bVg();
                            e.printStackTrace();
                        }
                        d.this.gFv.a(27, bVg, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.gFT = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.p.d.30
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.gFU = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.p.d.31
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.gFB = false;
                }
            }
        };
        this.gFV = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.p.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aAj = alaEnterLiveHttpResonseMessage.LC();
                        d.this.gEJ = alaEnterLiveHttpResonseMessage.bUY();
                        d.this.gFv.e(d.this.aAj);
                    }
                    if (d.this.aAj != null && d.this.aAj.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.bWC().ej(d.this.aAj.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aAj.mLiveInfo.live_id);
                    }
                    if (d.this.aAj != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aAj.aEf != null) {
                            if (d.this.aAj.aEf.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aAj.aEf.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aAj.aEf.nickName);
                            if (!TextUtils.isEmpty(d.this.aAj.aEf.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aAj.aEf.portrait);
                            }
                        }
                        if (d.this.aAj.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aAj.mLiveSdkInfo.tbs);
                            com.baidu.live.c.AD().putString("ala_account_user_tbs", d.this.aAj.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aAj != null) {
                        if (d.this.gFy.size() <= 0) {
                            d.this.gFy.add(d.this.aAj.mLiveInfo);
                            d.this.gFK.add(Long.valueOf(d.this.aAj.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aAj.mLiveInfo);
                        if (d.this.gFv != null) {
                            d.this.gFv.L(d.this.aAj.aEk);
                        }
                    }
                    if (d.this.aAj != null && d.this.aAj.aDI != null) {
                        d.this.gFE = d.this.aAj.aDI.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aAj);
                    if (d.this.aAj != null && d.this.aAj.mLiveInfo != null) {
                        d.this.bVO();
                    }
                    if (d.this.aAj != null) {
                        d.this.aAj.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aAj));
                        com.baidu.live.im.b.d.JD().O(d.this.aAj.aEk);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aAj != null && d.this.aAj.mLiveInfo != null) {
                            long j2 = d.this.aAj.mLiveInfo.live_id;
                            long j3 = d.this.aAj.mLiveInfo.room_id;
                            String str = d.this.aAj.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aAj.aDG != null) {
                                long j4 = d.this.aAj.aDG.userId;
                                str2 = d.this.aAj.aDG.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && d.this.aAj != null && d.this.aAj.mLiveInfo != null) {
                        long j5 = d.this.aAj.mLiveInfo.live_id;
                        long j6 = d.this.aAj.mLiveInfo.room_id;
                        String str3 = d.this.aAj.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aAj.aDG != null) {
                            j = d.this.aAj.aDG.userId;
                            str4 = d.this.aAj.aDG.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.gFA + "");
                    }
                }
            }
        };
        this.gFW = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.p.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    k kVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        kVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bIw();
                    }
                    if (kVar != null) {
                        d.this.fRl = kVar;
                    }
                    if (d.this.aAj != null && d.this.aAj.aDI != null) {
                        if (d.this.gFE == -1) {
                            d.this.gFE = d.this.aAj.aDI.follow_status;
                        }
                        if (d.this.aAj.aDI.follow_status != d.this.gFE) {
                            d.this.aAj.aDI.follow_status = d.this.gFE;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.fRl);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.fRl));
                }
            }
        };
        this.gFX = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.p.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> bVd = alaUserLiveMarkInfoResponseMessage.bVd();
                        d.this.gFv.L(bVd);
                        if (d.this.aAj != null) {
                            d.this.aAj.aEk = bVd;
                            com.baidu.live.im.b.d.JD().O(d.this.aAj.aEk);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aAj));
                        }
                    }
                }
            }
        };
        this.gFY = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.p.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    r LC = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).LC() : null;
                    d.this.gFm = System.currentTimeMillis();
                    if (LC == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, LC);
                        return;
                    }
                    if (d.this.aAj == null) {
                        d.this.aAj = LC;
                        d.this.gFv.e(d.this.aAj);
                    } else if (d.this.aAj.mLiveInfo != null && LC.mLiveInfo != null && d.this.aAj.mLiveInfo.live_id != LC.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aAj);
                        return;
                    }
                    if (d.this.aAj.mLiveInfo != null && LC.mLiveInfo != null && d.this.aAj.mLiveInfo.user_id == LC.mLiveInfo.user_id) {
                        if (d.this.aAj.mLiveInfo.imEffect != null && LC.mLiveInfo.imEffect == null) {
                            LC.mLiveInfo.imEffect = d.this.aAj.mLiveInfo.imEffect;
                        }
                        if (d.this.aAj.mLiveInfo.mLiveCloseData != null && LC.mLiveInfo.mLiveCloseData == null) {
                            LC.mLiveInfo.mLiveCloseData = d.this.aAj.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aAj.mLiveInfo.mAlaLiveSwitchData != null && LC.mLiveInfo.mAlaLiveSwitchData == null) {
                            LC.mLiveInfo.mAlaLiveSwitchData = d.this.aAj.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aAj.mLiveInfo = LC.mLiveInfo;
                    d.this.aAj.aEt = LC.aEt;
                    d.this.aAj.aDG = LC.aDG;
                    d.this.aAj.aDH = LC.aDH;
                    d.this.aAj.aDK = LC.aDK;
                    d.this.aAj.aEl = LC.aEl;
                    d.this.aAj.aEj = LC.aEj;
                    d.this.aAj.aEi = LC.aEi;
                    if (LC.aEp != null && LC.aEp.aHI != null && !LC.aEp.aHI.isEmpty()) {
                        d.this.aAj.aEp = LC.aEp;
                    }
                    if (LC.aEf != null) {
                        if (LC.aEf.userId == 0) {
                            if (d.this.aAj.aEf == null) {
                                d.this.aAj.aEf = new AlaLiveUserInfoData();
                            }
                            d.this.aAj.aEf.throneUid = LC.aEf.throneUid;
                        } else {
                            boolean z = LC.aEf.isNewUser;
                            if (d.this.aAj.aEf != null) {
                                z = d.this.aAj.aEf.isNewUser;
                            }
                            LC.aEf.isNewUser = z;
                            d.this.aAj.aEf = LC.aEf;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aAj.aEf.nickName);
                        }
                    }
                    if (LC.aEh != null) {
                        d.this.aAj.aEh = LC.aEh;
                    }
                    if (LC.aEj) {
                        d.this.aAj.aEk = LC.aEk;
                        if (d.this.gFv != null) {
                            d.this.gFv.L(LC.aEk);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aAj.mLiveInfo != null) {
                        int i = d.this.aAj.mLiveInfo.backstage_type;
                        if (d.this.gFv != null) {
                            d.this.gFv.gO(String.valueOf(i));
                        }
                    }
                    if (d.this.gFv != null) {
                        d.this.gFv.e(d.this.aAj);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aAj);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aAj));
                    if (d.this.aAj != null) {
                        com.baidu.live.im.b.d.JD().O(d.this.aAj.aEk);
                    }
                }
            }
        };
        this.gFZ = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.p.d.6
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
                    if (list != null && list.size() > 0 && d.this.gFy != null && d.this.gFy.size() > 0) {
                        for (int size = d.this.gFy.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.gFy.get(size)).live_id != d.this.aAj.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.gFy.get(size)).getLiveID()))) {
                                d.this.gFy.remove(size);
                            }
                        }
                    }
                    if (d.this.aAj != null) {
                        d.this.h(d.this.aAj.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.gkw = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.p.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.gGa = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.p.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.gFu = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.gFx = alaUpdateLiveTbResponseMessage.bVc();
                    if (d.this.gFx != null) {
                        if (d.this.gFx.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.gFx.aHN);
                                jSONObject2.put("user_verify", d.this.gFx.aHP);
                                jSONObject2.put("certify", d.this.gFx.aHR);
                                if (d.this.gFx.mLiveSdkInfo != null && d.this.gFx.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put("chat_mcast_id", d.this.gFx.mLiveSdkInfo.mCastIds.aDY);
                                    jSONObject2.put("ensure_mcast_id", d.this.gFx.mLiveSdkInfo.mCastIds.aDZ);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.gFx.aHN != 1 || d.this.gFx.aHP != 1) {
                            d.this.gFt.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.bVy();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.gFx.aDG != null) {
                            d.this.gFv.L(d.this.gFx.aDG.live_mark_info_new);
                        }
                        if (d.this.gFx.mErrorCode != 0) {
                            if (d.this.gFx.mErrorCode == 220012) {
                                d.this.b(d.this.gFx.mErrorCode, d.this.gFx.mErrorMsg, 6, d.this.aAj);
                                return;
                            }
                        } else {
                            d.this.aAj = new r();
                            d.this.gFv.e(d.this.aAj);
                            d.this.aAj.mLiveInfo = d.this.gFx.mLiveInfo;
                            d.this.aAj.aDG = d.this.gFx.aDG;
                            d.this.aAj.mLiveSdkInfo = d.this.gFx.mLiveSdkInfo;
                            d.this.aAj.aEm = d.this.gFx.aEm;
                            d.this.aAj.aEk = d.this.gFx.aDG.live_mark_info_new;
                            if (d.this.gFx.aDG != null && d.this.gFx.aDG.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.gFx.aDG.levelId);
                            }
                            d.this.aAj.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aAj));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aAj);
                    if (d.this.gFx != null && d.this.gFx.mLiveInfo != null) {
                        d.this.bVO();
                    }
                    if (d.this.aAj != null && d.this.aAj.mLiveInfo != null) {
                        d.this.x(d.this.aAj.mLiveInfo.user_id, d.this.aAj.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.gGb = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.p.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.gFv.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.gGc = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.p.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.m.b)) {
                    com.baidu.live.m.b bVar = (com.baidu.live.m.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.bgx != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.bgx.gW(bVar.contentType);
                        } else {
                            bVar.bgx.b(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.gGd = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.p.d.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                n nVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        nVar = null;
                    } else {
                        nVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).bVa();
                    }
                    if (nVar != null && !ListUtils.isEmpty(nVar.aDS)) {
                        d.this.gFO = nVar.aDR;
                        d.this.gFz = nVar.pn + 1;
                        m mVar = nVar.aDS.get(nVar.aDS.size() - 1);
                        if (mVar != null) {
                            d.this.mLastLiveId = mVar.mLiveInfo.live_id;
                        }
                        d.this.a(nVar);
                        if (d.this.aAj != null) {
                            d.this.h(d.this.aAj.mLiveInfo);
                        }
                        d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, nVar);
                    }
                }
            }
        };
        this.gGe = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.p.d.24
        };
        this.gGf = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.25
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.gFm));
            }
        };
        this.mPageContext = bdPageContext;
        this.gFv = new com.baidu.live.im.d(bdPageContext, false, this);
        this.gFy = new ArrayList();
        this.gFK = new HashSet();
        initTasks();
        registerListener(this.gFY);
        registerListener(this.gFW);
        registerListener(this.gFV);
        registerListener(this.gFT);
        this.gFs = BdUniqueId.gen();
        this.gGd.setTag(this.gFs);
        registerListener(this.gGd);
        registerListener(this.gFZ);
        registerListener(this.gFU);
        registerListener(this.gGa);
        registerListener(this.gkw);
        registerListener(this.gFQ);
        registerListener(this.gFR);
        registerListener(this.gFP);
        registerListener(this.fPH);
        registerListener(this.gFX);
        registerListener(this.gFS);
        registerListener(this.gGb);
        registerListener(this.gGc);
        MessageManager.getInstance().addMessageRule(this.gFH);
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
        this.gFm = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.gGf);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bVl();
        bVm();
        bVn();
        bVo();
        bVr();
        bVs();
    }

    private void bVl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bVm() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void bVn() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void bVo() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void bVp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.p.d.12
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

    public void bVq() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void bVr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bVs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "/ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bVt() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.m.b) && d.this.aAj != null && d.this.aAj.mLiveInfo != null) {
                    com.baidu.live.m.b bVar = (com.baidu.live.m.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aAj.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.bgw != null) {
                        httpMessage.addParam("ext_data", bVar.bgw.toString());
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

    public void bVu() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void x(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bVv() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    public void ee(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void bVw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bVx() {
        if (this.gFJ != null) {
            this.gFJ.dismiss();
            this.gFJ = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.gFJ = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gFJ.setAutoNight(false);
        this.gFJ.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.gFJ.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.11
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.bVw();
                    d.this.Fd();
                }
            });
            this.gFJ.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Fd();
                }
            });
        } else {
            this.gFJ.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Fd();
                }
            });
        }
        this.gFJ.setCancelable(false);
        this.gFJ.setCanceledOnTouchOutside(false);
        this.gFJ.setTitleShowCenter(true);
        this.gFJ.setMessageShowCenter(true);
        this.gFJ.isShowTitleAndMessage();
        this.gFJ.create(this.mPageContext);
        this.gFJ.show();
    }

    public void ef(String str, String str2) {
        if (this.gFJ != null) {
            this.gFJ.dismiss();
            this.gFJ = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.gFJ = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gFJ.setAutoNight(false);
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            str2 = string;
        } else {
            this.gFJ.setTitle(str);
        }
        this.gFJ.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gFJ.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Fd();
                }
            });
        } else {
            this.gFJ.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.w.a.Nk().beJ.aGK;
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
                    d.this.Fd();
                }
            });
            this.gFJ.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Fd();
                }
            });
        }
        this.gFJ.setCancelable(false);
        this.gFJ.setCanceledOnTouchOutside(false);
        this.gFJ.setTitleShowCenter(true);
        this.gFJ.setMessageShowCenter(true);
        this.gFJ.isShowTitleAndMessage();
        this.gFJ.create(this.mPageContext);
        this.gFJ.show();
    }

    public void bVy() {
        if (this.gFJ != null) {
            this.gFJ.dismiss();
            this.gFJ = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gFJ = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gFJ.setAutoNight(false);
        this.gFJ.setMessage(string);
        this.gFJ.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.gFJ.setCancelable(false);
        this.gFJ.setCanceledOnTouchOutside(false);
        this.gFJ.isShowTitleAndMessage();
        this.gFJ.create(this.mPageContext);
        this.gFJ.show();
    }

    public void bVz() {
        if (this.gFJ != null) {
            this.gFJ.dismiss();
            this.gFJ = null;
        }
        if (this.gFI != null) {
            a(this.gFI);
        }
    }

    public void bVA() {
        if (this.gFJ != null) {
            this.gFJ.dismiss();
            this.gFJ = null;
        }
        String string = this.mPageContext.getString(a.i.dialog_msg_to_user_info);
        this.gFJ = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gFJ.setAutoNight(false);
        this.gFJ.setMessage(string);
        this.gFJ.setPositiveButton(this.mPageContext.getString(a.i.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                IExtraParams buildParamsExtra;
                if (TbadkCoreApplication.getInst().isTieba()) {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(d.this.mPageContext.getPageActivity(), TbadkCoreApplication.getCurrentAccountId() + "");
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
                d.this.Fd();
            }
        });
        this.gFJ.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.Fd();
            }
        });
        this.gFJ.setCancelable(false);
        this.gFJ.setCanceledOnTouchOutside(false);
        this.gFJ.setTitleShowCenter(true);
        this.gFJ.setMessageShowCenter(true);
        this.gFJ.isShowTitleAndMessage();
        this.gFJ.create(this.mPageContext);
        this.gFJ.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gFJ = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gFJ.setAutoNight(false);
        this.gFJ.setMessage(string);
        this.gFJ.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.gFJ.setCancelable(false);
        this.gFJ.setCanceledOnTouchOutside(false);
        this.gFJ.isShowTitleAndMessage();
        this.gFJ.create(this.mPageContext);
        this.gFJ.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.gFI = null;
        this.gFJ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.gFJ != null) {
            this.gFJ.dismiss();
            this.gFJ = null;
        }
        this.gFI = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.gCt != null) {
            this.gCt.a(i, str, i2, obj);
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
        bVar.ao(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void bVB() {
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

    public void uz(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void y(long j, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.ao(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public ag bVC() {
        return this.gFx;
    }

    public r LC() {
        return this.aAj;
    }

    public am bUY() {
        return this.gEJ;
    }

    public List<AlaLiveInfoData> bVD() {
        return this.gFy;
    }

    public k bIw() {
        return this.fRl;
    }

    public void cb(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aAj != null && this.aAj.mLiveInfo != null) {
                aVar.setAudienceCount(this.aAj.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bVE() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.gFy) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cb(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar) {
        if (nVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
                if (this.gFy.size() == 1 && this.gFy.get(0).live_id == this.aAj.mLiveInfo.live_id) {
                    if (c(nVar) != null) {
                        this.gFy.clear();
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
        for (m mVar : nVar.aDS) {
            if (mVar != null && mVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.gFy) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == mVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.gFy.add(mVar.mLiveInfo);
                }
            }
        }
        if (this.gFy.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.gFy.size() - 200; size < this.gFy.size(); size++) {
                arrayList.add(this.gFy.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.gFy.clear();
                this.gFy.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(n nVar) {
        if (ListUtils.isEmpty(nVar.aDS)) {
            return null;
        }
        for (m mVar : nVar.aDS) {
            if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.live_id == this.aAj.mLiveInfo.live_id) {
                return mVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bVF() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.gFy)) {
            return null;
        }
        if (this.gFK.isEmpty()) {
            arrayList.addAll(this.gFy);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gFy.size()) {
                    break;
                }
                if ((this.aAj == null || this.aAj.mLiveInfo == null || this.aAj.mLiveInfo.live_id != this.gFy.get(i2).live_id) && !this.gFK.contains(Long.valueOf(this.gFy.get(i2).live_id))) {
                    arrayList.add(this.gFy.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.gFK.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.gFK.size() >= this.gFy.size() - 4) {
                mA(false);
            }
        }
    }

    public void uA(int i) {
        this.gFF = i;
    }

    public void mA(boolean z) {
        if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.KX().KV()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gFL > 500) {
                this.gFL = currentTimeMillis;
                com.baidu.live.liveroom.c.d.KX().KZ().a("tieba", this.gFz, 20, this.gGe);
                return;
            }
            return;
        }
        mB(z);
    }

    private void mB(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gFN >= 1800000) {
                this.gFM = currentTimeMillis;
                this.gFO = true;
            }
            if (this.gFO) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.gFz);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.gFM);
                httpMessage.setTag(this.gFs);
                sendMessage(httpMessage);
                this.gFN = currentTimeMillis;
            }
        }
    }

    public void eg(String str, String str2) {
        this.gFv.bM(true);
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
        aVar.zm(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.Gm("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        bVQ();
    }

    public void ah(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.zm(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        bVQ();
    }

    public void Gn(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.gT(str);
        aVar.setParams();
        sendMessage(aVar);
        bVQ();
    }

    public void ei(long j) {
        this.gFv.bM(false);
        this.gFL = 0L;
        this.gFG = null;
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
        if (!bVG()) {
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
            httpMessage.addParam("is_prettify", bc.b(com.baidu.live.w.a.Nk().bkd) ? 1 : 2);
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
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                BdStatisticsManager.getInstance().newDebug("updatelive", 0L, null, "forum_name", str, "forum_id", str2, "description", str3, "is_location", Integer.valueOf(i), "lat", Double.toString(d), "lng", Double.toString(d2), "location_name", str4, "location_name_md5", str5, "is_to_tb_some", Integer.valueOf(i2), "cover", str6, "vcode", str7, "vcode_md5", str8, "is_test_live", Integer.valueOf(i3), "live_type", Integer.valueOf(i4), AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, Integer.valueOf(i5), "clarity", Integer.valueOf(i6), "game_id", str9, "game_name", str10);
            }
        }
    }

    private boolean bVG() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bVH() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aAj == null) {
            this.aAj = new r(alaLiveInfoCoreData);
            this.gFv.e(this.aAj);
        }
        this.mLastLiveId = this.aAj.mLiveInfo.live_id;
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
        if (this.aAj == null) {
            this.aAj = new r();
        }
        this.aAj.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aAj.aDG = alaLivePersonData.mUserData;
        this.aAj.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aAj.aDG != null && this.gFv != null) {
            this.gFv.L(this.aAj.aDG.live_mark_info_new);
        }
        this.aAj.isHost = true;
        this.aAj.aEn = true;
        if (this.gFv != null) {
            this.gFv.e(this.aAj);
        }
        bVO();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aAj));
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
        this.gFt.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.gGd);
        MessageManager.getInstance().removeMessageRule(this.gFH);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.gFv.bM(true);
        this.gFw = null;
        this.mPageContext = null;
    }

    public void uB(int i) {
        this.gFA = i;
        if (this.gFy.size() == 0) {
            this.gFA = 0;
        } else if (this.gFA < 0) {
            this.gFA = this.gFy.size() + this.gFA;
        } else {
            this.gFA %= this.gFy.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.gFy.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gFy.size()) {
                    if (this.gFy.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.gFA = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bVI() {
        long j;
        if (this.aAj == null || this.aAj.mLiveInfo == null || this.gFy.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gFy.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aAj.mLiveInfo.live_id;
    }

    public boolean bVJ() {
        long j;
        if (this.aAj == null || this.aAj.mLiveInfo == null || this.gFy.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gFy.get(this.gFy.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aAj.mLiveInfo.live_id;
    }

    public int bVK() {
        return this.gFA;
    }

    public int bVL() {
        return this.gFC;
    }

    public boolean bVM() {
        return this.gFD == 1;
    }

    public AlaLiveInfoData bVN() {
        if (this.gFA >= this.gFy.size()) {
            this.gFA = this.gFy.size() - 1;
        }
        if (this.gFA < 0) {
            this.gFA = 0;
        }
        if (this.gFy.size() <= this.gFA) {
            if (this.aAj != null) {
                return this.aAj.mLiveInfo;
            }
            return null;
        }
        return this.gFy.get(this.gFA);
    }

    public void a(a aVar) {
        this.gCt = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.gFw != null) {
            this.gFw.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void r(com.baidu.live.im.data.a aVar) {
        if (this.aAj != null && this.aAj.mLiveInfo.live_type == 1) {
            B(aVar);
        }
        if (this.gFw != null) {
            this.gFw.r(aVar);
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
            mA(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void IG() {
        if (this.gFw != null) {
            this.gFw.IG();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aAj);
        if (this.aAj != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aAj.aDG;
            } else {
                alaLiveUserInfoData = this.aAj.aEf;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aAj.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aAj != null && this.aAj.aEf != null && this.aAj.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aAj.aEf.throneUid;
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
                this.gFv.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void bVO() {
        this.gFv.e(String.valueOf(this.aAj.mLiveInfo.getGroupID()), String.valueOf(this.aAj.mLiveInfo.getLastMsgID()), String.valueOf(this.aAj.mLiveInfo.getUserID()), String.valueOf(this.aAj.mLiveInfo.getLiveID()), this.aAj.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bVP() {
        return this.gFv;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bVQ() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aAj != null) {
            try {
                if (this.aAj.mLiveSdkInfo != null && this.aAj.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put("chat_mcast_id", this.aAj.mLiveSdkInfo.mCastIds.aDY);
                    jSONObject2.put("ensure_mcast_id", this.aAj.mLiveSdkInfo.mCastIds.aDZ);
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

    public String bVR() {
        return this.gFG;
    }

    public void FM(String str) {
        this.gFG = str;
    }
}
