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
    private r aAh;
    private CustomMessageListener fPD;
    private k fRh;
    private a gCp;
    private am gEF;
    private int gFA;
    private int gFB;
    private String gFC;
    private com.baidu.live.v.a gFD;
    private AlaGetVerifyStrategyResponseHttpMessage gFE;
    private BdAlertDialog gFF;
    private Set<Long> gFG;
    private long gFH;
    private long gFI;
    private long gFJ;
    private boolean gFK;
    private HttpMessageListener gFL;
    private HttpMessageListener gFM;
    private HttpMessageListener gFN;
    private HttpMessageListener gFO;
    private NetMessageListener gFP;
    private HttpMessageListener gFQ;
    private NetMessageListener gFR;
    private HttpMessageListener gFS;
    private HttpMessageListener gFT;
    private NetMessageListener gFU;
    private NetMessageListener gFV;
    private HttpMessageListener gFW;
    private CustomMessageListener gFX;
    private HttpMessageListener gFY;
    private HttpMessageListener gFZ;
    private long gFi;
    private BdUniqueId gFo;
    private Handler gFp;
    private HttpMessage gFq;
    private final com.baidu.live.im.d gFr;
    private d.a gFs;
    private ag gFt;
    private List<AlaLiveInfoData> gFu;
    private int gFv;
    private int gFw;
    private boolean gFx;
    private int gFy;
    private int gFz;
    private com.baidu.live.liveroom.c.a gGa;
    private CustomMessageTask.CustomRunnable gGb;
    private HttpMessageListener gks;
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
        this.gFp = new Handler();
        this.gFv = 0;
        this.gFw = 0;
        this.gFx = true;
        this.gFy = 1;
        this.gFz = 0;
        this.gFA = -1;
        this.gFB = 0;
        this.gFD = new com.baidu.live.v.a(0);
        this.otherParams = "";
        this.gFI = System.currentTimeMillis();
        this.gFJ = 0L;
        this.gFK = true;
        this.fPD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.p.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aAh != null && d.this.aAh.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aAh.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.gFA = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aAh.mLiveInfo.user_id).param("obj_param1", d.this.aAh.mLiveInfo.live_id).param("tid", d.this.aAh.mLiveInfo.thread_id));
                            d.this.gFA = 1;
                        }
                        if (d.this.aAh != null && d.this.aAh.aDG != null) {
                            d.this.aAh.aDG.follow_status = d.this.gFA;
                        }
                    }
                }
            }
        };
        this.gFL = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.p.d.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.beJ == 1 && alaUserAuthenVerifyInfoResponseMessage.beI != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.beI.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.beI.verify_video_status == 1) {
                            d.this.gFy = 4;
                        }
                    }
                }
            }
        };
        this.gFM = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.p.d.27
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
                    d.this.gFz = alaGetVerifyStrategyResponseHttpMessage.gEO;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.gEK);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.gEM);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.gEP);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.gEM != 1 || alaGetVerifyStrategyResponseHttpMessage.gEK != 1 || alaGetVerifyStrategyResponseHttpMessage.gEP != 1 || alaGetVerifyStrategyResponseHttpMessage.gER != 1) {
                            d.this.gFE = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.gEP != 1) {
                                d.this.gFp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.27.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.bVw();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gEM != 1 || alaGetVerifyStrategyResponseHttpMessage.gEK != 1) {
                                d.this.gFp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.27.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ee(alaGetVerifyStrategyResponseHttpMessage.gES, alaGetVerifyStrategyResponseHttpMessage.gET);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gER != 1) {
                                d.this.gFp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.27.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.bVz();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.gFE = null;
                    }
                }
            }
        };
        this.gFN = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.p.d.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.gFO = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.p.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String bVf;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.bVd() == 1 || masterIdentityResponseMessage.bVe() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.bVf())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.bVf());
                            jSONObject.put("content_type", "custom_master_identity");
                            bVf = jSONObject.toString();
                        } catch (JSONException e) {
                            bVf = masterIdentityResponseMessage.bVf();
                            e.printStackTrace();
                        }
                        d.this.gFr.a(27, bVf, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.gFP = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.p.d.30
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.gFQ = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.p.d.31
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.gFx = false;
                }
            }
        };
        this.gFR = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.p.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aAh = alaEnterLiveHttpResonseMessage.LC();
                        d.this.gEF = alaEnterLiveHttpResonseMessage.bUX();
                        d.this.gFr.e(d.this.aAh);
                    }
                    if (d.this.aAh != null && d.this.aAh.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.bWB().ej(d.this.aAh.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aAh.mLiveInfo.live_id);
                    }
                    if (d.this.aAh != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aAh.aEd != null) {
                            if (d.this.aAh.aEd.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aAh.aEd.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aAh.aEd.nickName);
                            if (!TextUtils.isEmpty(d.this.aAh.aEd.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aAh.aEd.portrait);
                            }
                        }
                        if (d.this.aAh.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aAh.mLiveSdkInfo.tbs);
                            com.baidu.live.c.AD().putString("ala_account_user_tbs", d.this.aAh.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aAh != null) {
                        if (d.this.gFu.size() <= 0) {
                            d.this.gFu.add(d.this.aAh.mLiveInfo);
                            d.this.gFG.add(Long.valueOf(d.this.aAh.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aAh.mLiveInfo);
                        if (d.this.gFr != null) {
                            d.this.gFr.L(d.this.aAh.aEi);
                        }
                    }
                    if (d.this.aAh != null && d.this.aAh.aDG != null) {
                        d.this.gFA = d.this.aAh.aDG.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aAh);
                    if (d.this.aAh != null && d.this.aAh.mLiveInfo != null) {
                        d.this.bVN();
                    }
                    if (d.this.aAh != null) {
                        d.this.aAh.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aAh));
                        com.baidu.live.im.b.d.JD().O(d.this.aAh.aEi);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aAh != null && d.this.aAh.mLiveInfo != null) {
                            long j2 = d.this.aAh.mLiveInfo.live_id;
                            long j3 = d.this.aAh.mLiveInfo.room_id;
                            String str = d.this.aAh.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aAh.aDE != null) {
                                long j4 = d.this.aAh.aDE.userId;
                                str2 = d.this.aAh.aDE.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && d.this.aAh != null && d.this.aAh.mLiveInfo != null) {
                        long j5 = d.this.aAh.mLiveInfo.live_id;
                        long j6 = d.this.aAh.mLiveInfo.room_id;
                        String str3 = d.this.aAh.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aAh.aDE != null) {
                            j = d.this.aAh.aDE.userId;
                            str4 = d.this.aAh.aDE.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.gFw + "");
                    }
                }
            }
        };
        this.gFS = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.p.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    k kVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        kVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bIv();
                    }
                    if (kVar != null) {
                        d.this.fRh = kVar;
                    }
                    if (d.this.aAh != null && d.this.aAh.aDG != null) {
                        if (d.this.gFA == -1) {
                            d.this.gFA = d.this.aAh.aDG.follow_status;
                        }
                        if (d.this.aAh.aDG.follow_status != d.this.gFA) {
                            d.this.aAh.aDG.follow_status = d.this.gFA;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.fRh);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.fRh));
                }
            }
        };
        this.gFT = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.p.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> bVc = alaUserLiveMarkInfoResponseMessage.bVc();
                        d.this.gFr.L(bVc);
                        if (d.this.aAh != null) {
                            d.this.aAh.aEi = bVc;
                            com.baidu.live.im.b.d.JD().O(d.this.aAh.aEi);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aAh));
                        }
                    }
                }
            }
        };
        this.gFU = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.p.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    r LC = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).LC() : null;
                    d.this.gFi = System.currentTimeMillis();
                    if (LC == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, LC);
                        return;
                    }
                    if (d.this.aAh == null) {
                        d.this.aAh = LC;
                        d.this.gFr.e(d.this.aAh);
                    } else if (d.this.aAh.mLiveInfo != null && LC.mLiveInfo != null && d.this.aAh.mLiveInfo.live_id != LC.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aAh);
                        return;
                    }
                    if (d.this.aAh.mLiveInfo != null && LC.mLiveInfo != null && d.this.aAh.mLiveInfo.user_id == LC.mLiveInfo.user_id) {
                        if (d.this.aAh.mLiveInfo.imEffect != null && LC.mLiveInfo.imEffect == null) {
                            LC.mLiveInfo.imEffect = d.this.aAh.mLiveInfo.imEffect;
                        }
                        if (d.this.aAh.mLiveInfo.mLiveCloseData != null && LC.mLiveInfo.mLiveCloseData == null) {
                            LC.mLiveInfo.mLiveCloseData = d.this.aAh.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aAh.mLiveInfo.mAlaLiveSwitchData != null && LC.mLiveInfo.mAlaLiveSwitchData == null) {
                            LC.mLiveInfo.mAlaLiveSwitchData = d.this.aAh.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aAh.mLiveInfo = LC.mLiveInfo;
                    d.this.aAh.aEr = LC.aEr;
                    d.this.aAh.aDE = LC.aDE;
                    d.this.aAh.aDF = LC.aDF;
                    d.this.aAh.aDI = LC.aDI;
                    d.this.aAh.aEj = LC.aEj;
                    d.this.aAh.aEh = LC.aEh;
                    d.this.aAh.aEg = LC.aEg;
                    if (LC.aEn != null && LC.aEn.aHG != null && !LC.aEn.aHG.isEmpty()) {
                        d.this.aAh.aEn = LC.aEn;
                    }
                    if (LC.aEd != null) {
                        if (LC.aEd.userId == 0) {
                            if (d.this.aAh.aEd == null) {
                                d.this.aAh.aEd = new AlaLiveUserInfoData();
                            }
                            d.this.aAh.aEd.throneUid = LC.aEd.throneUid;
                        } else {
                            boolean z = LC.aEd.isNewUser;
                            if (d.this.aAh.aEd != null) {
                                z = d.this.aAh.aEd.isNewUser;
                            }
                            LC.aEd.isNewUser = z;
                            d.this.aAh.aEd = LC.aEd;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aAh.aEd.nickName);
                        }
                    }
                    if (LC.aEf != null) {
                        d.this.aAh.aEf = LC.aEf;
                    }
                    if (LC.aEh) {
                        d.this.aAh.aEi = LC.aEi;
                        if (d.this.gFr != null) {
                            d.this.gFr.L(LC.aEi);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aAh.mLiveInfo != null) {
                        int i = d.this.aAh.mLiveInfo.backstage_type;
                        if (d.this.gFr != null) {
                            d.this.gFr.gN(String.valueOf(i));
                        }
                    }
                    if (d.this.gFr != null) {
                        d.this.gFr.e(d.this.aAh);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aAh);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aAh));
                    if (d.this.aAh != null) {
                        com.baidu.live.im.b.d.JD().O(d.this.aAh.aEi);
                    }
                }
            }
        };
        this.gFV = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.p.d.6
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
                    if (list != null && list.size() > 0 && d.this.gFu != null && d.this.gFu.size() > 0) {
                        for (int size = d.this.gFu.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.gFu.get(size)).live_id != d.this.aAh.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.gFu.get(size)).getLiveID()))) {
                                d.this.gFu.remove(size);
                            }
                        }
                    }
                    if (d.this.aAh != null) {
                        d.this.h(d.this.aAh.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.gks = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.p.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.gFW = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.p.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.gFq = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.gFt = alaUpdateLiveTbResponseMessage.bVb();
                    if (d.this.gFt != null) {
                        if (d.this.gFt.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.gFt.aHL);
                                jSONObject2.put("user_verify", d.this.gFt.aHN);
                                jSONObject2.put("certify", d.this.gFt.aHP);
                                if (d.this.gFt.mLiveSdkInfo != null && d.this.gFt.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put("chat_mcast_id", d.this.gFt.mLiveSdkInfo.mCastIds.aDW);
                                    jSONObject2.put("ensure_mcast_id", d.this.gFt.mLiveSdkInfo.mCastIds.aDX);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.gFt.aHL != 1 || d.this.gFt.aHN != 1) {
                            d.this.gFp.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.bVx();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.gFt.aDE != null) {
                            d.this.gFr.L(d.this.gFt.aDE.live_mark_info_new);
                        }
                        if (d.this.gFt.mErrorCode != 0) {
                            if (d.this.gFt.mErrorCode == 220012) {
                                d.this.b(d.this.gFt.mErrorCode, d.this.gFt.mErrorMsg, 6, d.this.aAh);
                                return;
                            }
                        } else {
                            d.this.aAh = new r();
                            d.this.gFr.e(d.this.aAh);
                            d.this.aAh.mLiveInfo = d.this.gFt.mLiveInfo;
                            d.this.aAh.aDE = d.this.gFt.aDE;
                            d.this.aAh.mLiveSdkInfo = d.this.gFt.mLiveSdkInfo;
                            d.this.aAh.aEk = d.this.gFt.aEk;
                            d.this.aAh.aEi = d.this.gFt.aDE.live_mark_info_new;
                            if (d.this.gFt.aDE != null && d.this.gFt.aDE.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.gFt.aDE.levelId);
                            }
                            d.this.aAh.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aAh));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aAh);
                    if (d.this.gFt != null && d.this.gFt.mLiveInfo != null) {
                        d.this.bVN();
                    }
                    if (d.this.aAh != null && d.this.aAh.mLiveInfo != null) {
                        d.this.x(d.this.aAh.mLiveInfo.user_id, d.this.aAh.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.gFX = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.p.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.gFr.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.gFY = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.p.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.m.b)) {
                    com.baidu.live.m.b bVar = (com.baidu.live.m.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.bgv != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.bgv.gV(bVar.contentType);
                        } else {
                            bVar.bgv.b(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.gFZ = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.p.d.22
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                n nVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        nVar = null;
                    } else {
                        nVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).bUZ();
                    }
                    if (nVar != null && !ListUtils.isEmpty(nVar.aDQ)) {
                        d.this.gFK = nVar.aDP;
                        d.this.gFv = nVar.pn + 1;
                        m mVar = nVar.aDQ.get(nVar.aDQ.size() - 1);
                        if (mVar != null) {
                            d.this.mLastLiveId = mVar.mLiveInfo.live_id;
                        }
                        d.this.a(nVar);
                        if (d.this.aAh != null) {
                            d.this.h(d.this.aAh.mLiveInfo);
                        }
                        d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, nVar);
                    }
                }
            }
        };
        this.gGa = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.p.d.24
        };
        this.gGb = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.25
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.gFi));
            }
        };
        this.mPageContext = bdPageContext;
        this.gFr = new com.baidu.live.im.d(bdPageContext, false, this);
        this.gFu = new ArrayList();
        this.gFG = new HashSet();
        initTasks();
        registerListener(this.gFU);
        registerListener(this.gFS);
        registerListener(this.gFR);
        registerListener(this.gFP);
        this.gFo = BdUniqueId.gen();
        this.gFZ.setTag(this.gFo);
        registerListener(this.gFZ);
        registerListener(this.gFV);
        registerListener(this.gFQ);
        registerListener(this.gFW);
        registerListener(this.gks);
        registerListener(this.gFM);
        registerListener(this.gFN);
        registerListener(this.gFL);
        registerListener(this.fPD);
        registerListener(this.gFT);
        registerListener(this.gFO);
        registerListener(this.gFX);
        registerListener(this.gFY);
        MessageManager.getInstance().addMessageRule(this.gFD);
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
        this.gFi = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.gGb);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bVk();
        bVl();
        bVm();
        bVn();
        bVq();
        bVr();
    }

    private void bVk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bVl() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void bVm() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void bVn() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void bVo() {
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

    public void bVp() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void bVq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bVr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "/ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bVs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.m.b) && d.this.aAh != null && d.this.aAh.mLiveInfo != null) {
                    com.baidu.live.m.b bVar = (com.baidu.live.m.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aAh.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.bgu != null) {
                        httpMessage.addParam("ext_data", bVar.bgu.toString());
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

    public void bVt() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void x(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bVu() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    public void ed(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void bVv() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bVw() {
        if (this.gFF != null) {
            this.gFF.dismiss();
            this.gFF = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.gFF = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gFF.setAutoNight(false);
        this.gFF.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.gFF.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.11
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.bVv();
                    d.this.Fd();
                }
            });
            this.gFF.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Fd();
                }
            });
        } else {
            this.gFF.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Fd();
                }
            });
        }
        this.gFF.setCancelable(false);
        this.gFF.setCanceledOnTouchOutside(false);
        this.gFF.setTitleShowCenter(true);
        this.gFF.setMessageShowCenter(true);
        this.gFF.isShowTitleAndMessage();
        this.gFF.create(this.mPageContext);
        this.gFF.show();
    }

    public void ee(String str, String str2) {
        if (this.gFF != null) {
            this.gFF.dismiss();
            this.gFF = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.gFF = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gFF.setAutoNight(false);
        if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
            str2 = string;
        } else {
            this.gFF.setTitle(str);
        }
        this.gFF.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gFF.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Fd();
                }
            });
        } else {
            this.gFF.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.w.a.Nk().beH.aGI;
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
            this.gFF.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Fd();
                }
            });
        }
        this.gFF.setCancelable(false);
        this.gFF.setCanceledOnTouchOutside(false);
        this.gFF.setTitleShowCenter(true);
        this.gFF.setMessageShowCenter(true);
        this.gFF.isShowTitleAndMessage();
        this.gFF.create(this.mPageContext);
        this.gFF.show();
    }

    public void bVx() {
        if (this.gFF != null) {
            this.gFF.dismiss();
            this.gFF = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gFF = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gFF.setAutoNight(false);
        this.gFF.setMessage(string);
        this.gFF.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.gFF.setCancelable(false);
        this.gFF.setCanceledOnTouchOutside(false);
        this.gFF.isShowTitleAndMessage();
        this.gFF.create(this.mPageContext);
        this.gFF.show();
    }

    public void bVy() {
        if (this.gFF != null) {
            this.gFF.dismiss();
            this.gFF = null;
        }
        if (this.gFE != null) {
            a(this.gFE);
        }
    }

    public void bVz() {
        if (this.gFF != null) {
            this.gFF.dismiss();
            this.gFF = null;
        }
        String string = this.mPageContext.getString(a.i.dialog_msg_to_user_info);
        this.gFF = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gFF.setAutoNight(false);
        this.gFF.setMessage(string);
        this.gFF.setPositiveButton(this.mPageContext.getString(a.i.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.19
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
        this.gFF.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.Fd();
            }
        });
        this.gFF.setCancelable(false);
        this.gFF.setCanceledOnTouchOutside(false);
        this.gFF.setTitleShowCenter(true);
        this.gFF.setMessageShowCenter(true);
        this.gFF.isShowTitleAndMessage();
        this.gFF.create(this.mPageContext);
        this.gFF.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gFF = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gFF.setAutoNight(false);
        this.gFF.setMessage(string);
        this.gFF.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.gFF.setCancelable(false);
        this.gFF.setCanceledOnTouchOutside(false);
        this.gFF.isShowTitleAndMessage();
        this.gFF.create(this.mPageContext);
        this.gFF.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.gFE = null;
        this.gFF = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.gFF != null) {
            this.gFF.dismiss();
            this.gFF = null;
        }
        this.gFE = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.gCp != null) {
            this.gCp.a(i, str, i2, obj);
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

    public void bVA() {
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

    public ag bVB() {
        return this.gFt;
    }

    public r LC() {
        return this.aAh;
    }

    public am bUX() {
        return this.gEF;
    }

    public List<AlaLiveInfoData> bVC() {
        return this.gFu;
    }

    public k bIv() {
        return this.fRh;
    }

    public void cb(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aAh != null && this.aAh.mLiveInfo != null) {
                aVar.setAudienceCount(this.aAh.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bVD() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.gFu) {
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
                if (this.gFu.size() == 1 && this.gFu.get(0).live_id == this.aAh.mLiveInfo.live_id) {
                    if (c(nVar) != null) {
                        this.gFu.clear();
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
        for (m mVar : nVar.aDQ) {
            if (mVar != null && mVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.gFu) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == mVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.gFu.add(mVar.mLiveInfo);
                }
            }
        }
        if (this.gFu.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.gFu.size() - 200; size < this.gFu.size(); size++) {
                arrayList.add(this.gFu.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.gFu.clear();
                this.gFu.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(n nVar) {
        if (ListUtils.isEmpty(nVar.aDQ)) {
            return null;
        }
        for (m mVar : nVar.aDQ) {
            if (mVar != null && mVar.mLiveInfo != null && mVar.mLiveInfo.live_id == this.aAh.mLiveInfo.live_id) {
                return mVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bVE() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.gFu)) {
            return null;
        }
        if (this.gFG.isEmpty()) {
            arrayList.addAll(this.gFu);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gFu.size()) {
                    break;
                }
                if ((this.aAh == null || this.aAh.mLiveInfo == null || this.aAh.mLiveInfo.live_id != this.gFu.get(i2).live_id) && !this.gFG.contains(Long.valueOf(this.gFu.get(i2).live_id))) {
                    arrayList.add(this.gFu.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.gFG.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.gFG.size() >= this.gFu.size() - 4) {
                my(false);
            }
        }
    }

    public void uA(int i) {
        this.gFB = i;
    }

    public void my(boolean z) {
        if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.KX().KV()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gFH > 500) {
                this.gFH = currentTimeMillis;
                com.baidu.live.liveroom.c.d.KX().KZ().a("tieba", this.gFv, 20, this.gGa);
                return;
            }
            return;
        }
        mz(z);
    }

    private void mz(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gFJ >= 1800000) {
                this.gFI = currentTimeMillis;
                this.gFK = true;
            }
            if (this.gFK) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.gFv);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.gFI);
                httpMessage.setTag(this.gFo);
                sendMessage(httpMessage);
                this.gFJ = currentTimeMillis;
            }
        }
    }

    public void ef(String str, String str2) {
        this.gFr.bM(true);
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
        aVar.zl(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.Gl("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        bVP();
    }

    public void ah(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.zl(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        bVP();
    }

    public void Gm(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.gS(str);
        aVar.setParams();
        sendMessage(aVar);
        bVP();
    }

    public void ei(long j) {
        this.gFr.bM(false);
        this.gFH = 0L;
        this.gFC = null;
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
        if (!bVF()) {
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
            httpMessage.addParam("is_prettify", bc.b(com.baidu.live.w.a.Nk().bka) ? 1 : 2);
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

    private boolean bVF() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bVG() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aAh == null) {
            this.aAh = new r(alaLiveInfoCoreData);
            this.gFr.e(this.aAh);
        }
        this.mLastLiveId = this.aAh.mLiveInfo.live_id;
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
        if (this.aAh == null) {
            this.aAh = new r();
        }
        this.aAh.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aAh.aDE = alaLivePersonData.mUserData;
        this.aAh.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aAh.aDE != null && this.gFr != null) {
            this.gFr.L(this.aAh.aDE.live_mark_info_new);
        }
        this.aAh.isHost = true;
        this.aAh.aEl = true;
        if (this.gFr != null) {
            this.gFr.e(this.aAh);
        }
        bVN();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aAh));
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
        this.gFp.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.gFZ);
        MessageManager.getInstance().removeMessageRule(this.gFD);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.gFr.bM(true);
        this.gFs = null;
        this.mPageContext = null;
    }

    public void uB(int i) {
        this.gFw = i;
        if (this.gFu.size() == 0) {
            this.gFw = 0;
        } else if (this.gFw < 0) {
            this.gFw = this.gFu.size() + this.gFw;
        } else {
            this.gFw %= this.gFu.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.gFu.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gFu.size()) {
                    if (this.gFu.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.gFw = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bVH() {
        long j;
        if (this.aAh == null || this.aAh.mLiveInfo == null || this.gFu.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gFu.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aAh.mLiveInfo.live_id;
    }

    public boolean bVI() {
        long j;
        if (this.aAh == null || this.aAh.mLiveInfo == null || this.gFu.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gFu.get(this.gFu.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aAh.mLiveInfo.live_id;
    }

    public int bVJ() {
        return this.gFw;
    }

    public int bVK() {
        return this.gFy;
    }

    public boolean bVL() {
        return this.gFz == 1;
    }

    public AlaLiveInfoData bVM() {
        if (this.gFw >= this.gFu.size()) {
            this.gFw = this.gFu.size() - 1;
        }
        if (this.gFw < 0) {
            this.gFw = 0;
        }
        if (this.gFu.size() <= this.gFw) {
            if (this.aAh != null) {
                return this.aAh.mLiveInfo;
            }
            return null;
        }
        return this.gFu.get(this.gFw);
    }

    public void a(a aVar) {
        this.gCp = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.gFs != null) {
            this.gFs.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void r(com.baidu.live.im.data.a aVar) {
        if (this.aAh != null && this.aAh.mLiveInfo.live_type == 1) {
            B(aVar);
        }
        if (this.gFs != null) {
            this.gFs.r(aVar);
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
            my(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void IG() {
        if (this.gFs != null) {
            this.gFs.IG();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aAh);
        if (this.aAh != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aAh.aDE;
            } else {
                alaLiveUserInfoData = this.aAh.aEd;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aAh.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aAh != null && this.aAh.aEd != null && this.aAh.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aAh.aEd.throneUid;
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
                this.gFr.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void bVN() {
        this.gFr.e(String.valueOf(this.aAh.mLiveInfo.getGroupID()), String.valueOf(this.aAh.mLiveInfo.getLastMsgID()), String.valueOf(this.aAh.mLiveInfo.getUserID()), String.valueOf(this.aAh.mLiveInfo.getLiveID()), this.aAh.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bVO() {
        return this.gFr;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bVP() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aAh != null) {
            try {
                if (this.aAh.mLiveSdkInfo != null && this.aAh.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put("chat_mcast_id", this.aAh.mLiveSdkInfo.mCastIds.aDW);
                    jSONObject2.put("ensure_mcast_id", this.aAh.mLiveSdkInfo.mCastIds.aDX);
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

    public String bVQ() {
        return this.gFC;
    }

    public void FL(String str) {
        this.gFC = str;
    }
}
