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
import com.baidu.live.data.as;
import com.baidu.live.data.az;
import com.baidu.live.data.bo;
import com.baidu.live.data.r;
import com.baidu.live.data.t;
import com.baidu.live.data.u;
import com.baidu.live.data.x;
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
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
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
import com.baidu.live.utils.l;
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
/* loaded from: classes10.dex */
public class d extends BdBaseModel implements d.a {
    private x aBr;
    private BdPageContext<?> bhf;
    private CustomMessageListener gKA;
    private r gMd;
    private a hCw;
    private az hEV;
    private BdUniqueId hFC;
    private Handler hFD;
    private HttpMessage hFE;
    private final com.baidu.live.im.d hFF;
    private d.a hFG;
    private as hFH;
    private List<AlaLiveInfoData> hFI;
    private int hFJ;
    private int hFK;
    private boolean hFL;
    private int hFM;
    private int hFN;
    private int hFO;
    private int hFP;
    private String hFQ;
    private com.baidu.live.ad.a hFR;
    private AlaGetVerifyStrategyResponseHttpMessage hFS;
    private BdAlertDialog hFT;
    private Set<Long> hFU;
    private long hFV;
    private long hFW;
    private long hFX;
    private boolean hFY;
    private boolean hFZ;
    private long hFw;
    private HttpMessageListener hGa;
    private HttpMessageListener hGb;
    private HttpMessageListener hGc;
    private HttpMessageListener hGd;
    private NetMessageListener hGe;
    private HttpMessageListener hGf;
    private NetMessageListener hGg;
    private HttpMessageListener hGh;
    private HttpMessageListener hGi;
    private NetMessageListener hGj;
    private NetMessageListener hGk;
    private HttpMessageListener hGl;
    private CustomMessageListener hGm;
    private HttpMessageListener hGn;
    private HttpMessageListener hGo;
    private HttpMessageListener hGp;
    private com.baidu.live.liveroom.c.a hGq;
    private CustomMessageTask.CustomRunnable hGr;
    private HttpMessageListener hkl;
    private boolean mIsHost;
    private long mLastLiveId;
    private String mType;
    private String otherParams;

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public d(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hFD = new Handler();
        this.hFJ = 0;
        this.hFK = 0;
        this.hFL = true;
        this.hFM = 1;
        this.hFN = 0;
        this.hFO = -1;
        this.hFP = 0;
        this.hFR = new com.baidu.live.ad.a(0);
        this.otherParams = "";
        this.hFW = System.currentTimeMillis();
        this.hFX = 0L;
        this.hFY = true;
        this.hFZ = false;
        this.gKA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.p.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aBr != null && d.this.aBr.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aBr.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.hFO = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aBr.mLiveInfo.user_id).param("obj_param1", d.this.aBr.mLiveInfo.live_id).param("tid", d.this.aBr.mLiveInfo.thread_id));
                            d.this.hFO = 1;
                        }
                        if (d.this.aBr != null && d.this.aBr.aFJ != null) {
                            d.this.aBr.aFJ.follow_status = d.this.hFO;
                        }
                    }
                }
            }
        };
        this.hGa = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.p.d.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.brw == 1 && alaUserAuthenVerifyInfoResponseMessage.brv != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.brv.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.brv.verify_video_status == 1) {
                            d.this.hFM = 4;
                        }
                    }
                }
            }
        };
        this.hGb = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.p.d.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.28.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1003303);
                        }
                    });
                    final AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    d.this.hFN = alaGetVerifyStrategyResponseHttpMessage.hFc;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, "author_liveroom", ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hEY);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hFa);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hFd);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, "author_liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hFa != 1 || alaGetVerifyStrategyResponseHttpMessage.hEY != 1 || alaGetVerifyStrategyResponseHttpMessage.hFd != 1 || alaGetVerifyStrategyResponseHttpMessage.hFf != 1) {
                            d.this.hFS = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hFd != 1) {
                                d.this.hFD.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.28.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ciq();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hFa != 1 || alaGetVerifyStrategyResponseHttpMessage.hEY != 1) {
                                d.this.hFD.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.28.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.eA(alaGetVerifyStrategyResponseHttpMessage.hFg, alaGetVerifyStrategyResponseHttpMessage.hFh);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hFf != 1) {
                                d.this.hFD.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.28.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cit();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.hFS = null;
                    }
                }
            }
        };
        this.hGc = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.p.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.hGd = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.p.d.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String chZ;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.chX() == 1 || masterIdentityResponseMessage.chY() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.chZ())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.chZ());
                            jSONObject.put("content_type", "custom_master_identity");
                            chZ = jSONObject.toString();
                        } catch (JSONException e) {
                            chZ = masterIdentityResponseMessage.chZ();
                            e.printStackTrace();
                        }
                        d.this.hFF.a(27, chZ, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.hGe = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.p.d.31
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.hGf = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.p.d.32
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.hFL = false;
                }
            }
        };
        this.hGg = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.p.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aBr = alaEnterLiveHttpResonseMessage.DW();
                        d.this.hEV = alaEnterLiveHttpResonseMessage.chR();
                        d.this.hFF.setAlaLiveShowData(d.this.aBr);
                    }
                    if (d.this.aBr != null && d.this.aBr.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.cjB().fF(d.this.aBr.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aBr.mLiveInfo.live_id);
                        try {
                            com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(d.this.aBr.mLiveInfo.live_id)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (d.this.aBr != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aBr.aGd != null) {
                            if (d.this.aBr.aGd.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aBr.aGd.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aBr.aGd.nickName);
                            if (!TextUtils.isEmpty(d.this.aBr.aGd.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aBr.aGd.portrait);
                            }
                        }
                        if (d.this.aBr.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aBr.mLiveSdkInfo.tbs);
                            com.baidu.live.d.xf().putString("ala_account_user_tbs", d.this.aBr.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aBr != null) {
                        if (d.this.hFI.size() <= 0) {
                            d.this.hFI.add(d.this.aBr.mLiveInfo);
                            d.this.hFU.add(Long.valueOf(d.this.aBr.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aBr.mLiveInfo);
                        if (d.this.hFF != null) {
                            d.this.hFF.R(d.this.aBr.aGo);
                        }
                    }
                    if (d.this.aBr != null && d.this.aBr.aFJ != null) {
                        d.this.hFO = d.this.aBr.aFJ.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aBr);
                    if (d.this.aBr != null && d.this.aBr.mLiveInfo != null) {
                        d.this.ciH();
                    }
                    if (d.this.aBr != null) {
                        d.this.aBr.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aBr));
                        com.baidu.live.im.b.d.Jp().V(d.this.aBr.aGo);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aBr != null && d.this.aBr.mLiveInfo != null) {
                            long j2 = d.this.aBr.mLiveInfo.live_id;
                            long j3 = d.this.aBr.mLiveInfo.room_id;
                            String str = d.this.aBr.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aBr.aFH != null) {
                                long j4 = d.this.aBr.aFH.userId;
                                str2 = d.this.aBr.aFH.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && d.this.aBr != null && d.this.aBr.mLiveInfo != null) {
                        long j5 = d.this.aBr.mLiveInfo.live_id;
                        long j6 = d.this.aBr.mLiveInfo.room_id;
                        String str3 = d.this.aBr.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aBr.aFH != null) {
                            j = d.this.aBr.aFH.userId;
                            str4 = d.this.aBr.aFH.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.hFK + "");
                    }
                    if (d.this.aBr != null && d.this.aBr.mLiveInfo != null) {
                        if (!com.baidu.tieba.ala.liveroom.performancewatchtask.b.ciZ().ciY()) {
                            try {
                                if (d.this.aBr.mLiveInfo.isPubShow && TbadkCoreApplication.getCurrentAccount() != null) {
                                    com.baidu.live.view.a.VF().hP(String.valueOf(d.this.aBr.mLiveInfo.user_id));
                                    com.baidu.tieba.ala.liveroom.performancewatchtask.b.ciZ().a(d.this.bhf, d.this.aBr.mLiveInfo.live_id, Long.parseLong(TbadkCoreApplication.getCurrentAccount()), d.this.aBr.mLiveInfo, d.this.mType);
                                }
                            } catch (NumberFormatException e2) {
                                e2.printStackTrace();
                            }
                        }
                        com.baidu.tieba.ala.liveroom.performancewatchtask.b.ciZ().oy(false);
                    }
                }
            }
        };
        this.hGh = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.p.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    r rVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        rVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bTh();
                    }
                    if (rVar != null) {
                        d.this.gMd = rVar;
                    }
                    if (d.this.aBr != null && d.this.aBr.aFJ != null) {
                        if (d.this.hFO == -1) {
                            d.this.hFO = d.this.aBr.aFJ.follow_status;
                        }
                        if (d.this.aBr.aFJ.follow_status != d.this.hFO) {
                            d.this.aBr.aFJ.follow_status = d.this.hFO;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.gMd);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.gMd));
                }
            }
        };
        this.hGi = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.p.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> chW = alaUserLiveMarkInfoResponseMessage.chW();
                        d.this.hFF.R(chW);
                        if (d.this.aBr != null) {
                            d.this.aBr.aGo = chW;
                            com.baidu.live.im.b.d.Jp().V(d.this.aBr.aGo);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aBr));
                        }
                    }
                }
            }
        };
        this.hGj = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.p.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    x DW = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).DW() : null;
                    d.this.hFw = System.currentTimeMillis();
                    if (DW == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, DW);
                        return;
                    }
                    if (d.this.aBr == null) {
                        d.this.aBr = DW;
                        d.this.hFF.setAlaLiveShowData(d.this.aBr);
                    } else if (d.this.aBr.mLiveInfo != null && DW.mLiveInfo != null && d.this.aBr.mLiveInfo.live_id != DW.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aBr);
                        return;
                    }
                    if (d.this.aBr.mLiveInfo != null && DW.mLiveInfo != null && d.this.aBr.mLiveInfo.user_id == DW.mLiveInfo.user_id) {
                        if (d.this.aBr.mLiveInfo.imEffect != null && DW.mLiveInfo.imEffect == null) {
                            DW.mLiveInfo.imEffect = d.this.aBr.mLiveInfo.imEffect;
                        }
                        if (d.this.aBr.mLiveInfo.mLiveCloseData != null && DW.mLiveInfo.mLiveCloseData == null) {
                            DW.mLiveInfo.mLiveCloseData = d.this.aBr.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aBr.mLiveInfo.mAlaLiveSwitchData != null && DW.mLiveInfo.mAlaLiveSwitchData == null) {
                            DW.mLiveInfo.mAlaLiveSwitchData = d.this.aBr.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aBr.mLiveInfo = DW.mLiveInfo;
                    d.this.aBr.serverTime = DW.serverTime;
                    d.this.aBr.aGA = DW.aGA;
                    if (DW.aFH != null && DW.aFH.userId != 0) {
                        d.this.aBr.aFH = DW.aFH;
                    }
                    d.this.aBr.aFI = DW.aFI;
                    d.this.aBr.aFM = DW.aFM;
                    d.this.aBr.aGp = DW.aGp;
                    d.this.aBr.aGn = DW.aGn;
                    d.this.aBr.aGi = DW.aGi;
                    d.this.aBr.aGj = DW.aGj;
                    d.this.aBr.aGk = DW.aGk;
                    d.this.aBr.aGl = DW.aGl;
                    d.this.aBr.aGm = DW.aGm;
                    d.this.aBr.countDown = DW.countDown;
                    d.this.aBr.aGS = DW.aGS;
                    if (DW.url != null) {
                        d.this.aBr.url = DW.url;
                    }
                    if (DW.aGf != null) {
                        d.this.aBr.aGf = DW.aGf;
                    }
                    d.this.aBr.aGH = DW.aGH;
                    if (DW.aGs != null && DW.aGs.aKU != null && !DW.aGs.aKU.isEmpty()) {
                        String str = d.this.aBr.aGs.aKW;
                        String str2 = d.this.aBr.aGs.aKY;
                        d.this.aBr.aGs = DW.aGs;
                        d.this.aBr.aGs.aKW = str;
                        d.this.aBr.aGs.aKY = str2;
                    }
                    if (DW.aGd != null) {
                        if (DW.aGd.userId == 0 || TbadkCoreApplication.getCurrentAccountInfo() == null) {
                            if (d.this.aBr.aGd == null) {
                                d.this.aBr.aGd = new AlaLiveUserInfoData();
                            }
                            d.this.aBr.aGd.throneUid = DW.aGd.throneUid;
                        } else {
                            boolean z = DW.aGd.isNewUser;
                            if (d.this.aBr.aGd != null) {
                                z = d.this.aBr.aGd.isNewUser;
                            }
                            DW.aGd.isNewUser = z;
                            d.this.aBr.aGd = DW.aGd;
                            if (d.this.aBr.aGd.levelId != TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel()) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aBr.aGd.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aBr.aGd.nickName);
                            if (!TextUtils.equals(d.this.aBr.aGd.portrait, TbadkCoreApplication.getCurrentAccountObj().getPortrait())) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aBr.aGd.portrait);
                            }
                        }
                    }
                    if (DW.aGg != null) {
                        d.this.aBr.aGg = DW.aGg;
                    }
                    if (DW.aGn) {
                        d.this.aBr.aGo = DW.aGo;
                        if (d.this.hFF != null) {
                            d.this.hFF.R(DW.aGo);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aBr.mLiveInfo != null) {
                        int i = d.this.aBr.mLiveInfo.backstage_type;
                        if (d.this.hFF != null) {
                            d.this.hFF.gA(String.valueOf(i));
                        }
                    }
                    if (d.this.hFF != null) {
                        d.this.hFF.setAlaLiveShowData(d.this.aBr);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aBr);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aBr));
                    if (d.this.aBr != null) {
                        com.baidu.live.im.b.d.Jp().V(d.this.aBr.aGo);
                    }
                }
            }
        };
        this.hGk = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.p.d.6
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                List<Long> list;
                if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (!(responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage)) {
                        j = 5000;
                        list = null;
                    } else {
                        AlaMGetLiveStatusHttpResponseMessage alaMGetLiveStatusHttpResponseMessage = (AlaMGetLiveStatusHttpResponseMessage) responsedMessage;
                        list = alaMGetLiveStatusHttpResponseMessage.getClosedIds();
                        long interval = alaMGetLiveStatusHttpResponseMessage.getInterval();
                        l.f(alaMGetLiveStatusHttpResponseMessage);
                        j = interval;
                    }
                    long j2 = j >= 5000 ? j : 5000L;
                    if (list != null && list.size() > 0 && d.this.hFI != null && d.this.hFI.size() > 0) {
                        for (int size = d.this.hFI.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.hFI.get(size)).live_id != d.this.aBr.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.hFI.get(size)).getLiveID()))) {
                                d.this.hFI.remove(size);
                            }
                        }
                    }
                    if (d.this.aBr != null) {
                        d.this.h(d.this.aBr.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hkl = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.p.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.hGl = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.p.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", "author_liveroom", ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.hFE = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.hFH = alaUpdateLiveTbResponseMessage.chV();
                    if (d.this.hFH != null) {
                        if (d.this.hFH.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hFH.aLh);
                                jSONObject2.put("user_verify", d.this.hFH.aLj);
                                jSONObject2.put("certify", d.this.hFH.aLl);
                                if (d.this.hFH.mLiveSdkInfo != null && d.this.hFH.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, d.this.hFH.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hFH.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, "author_liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hFH.aLh != 1 || d.this.hFH.aLj != 1) {
                            d.this.hFD.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cir();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.hFH.aFH != null) {
                            d.this.hFF.R(d.this.hFH.aFH.live_mark_info_new);
                        }
                        if (d.this.hFH.mErrorCode != 0) {
                            if (d.this.hFH.mErrorCode == 220012) {
                                d.this.b(d.this.hFH.mErrorCode, d.this.hFH.mErrorMsg, 6, d.this.aBr);
                                return;
                            }
                        } else {
                            d.this.aBr = new x();
                            d.this.hFF.setAlaLiveShowData(d.this.aBr);
                            d.this.aBr.mLiveInfo = d.this.hFH.mLiveInfo;
                            d.this.aBr.aFH = d.this.hFH.aFH;
                            d.this.aBr.mLiveSdkInfo = d.this.hFH.mLiveSdkInfo;
                            d.this.aBr.aGq = d.this.hFH.aGq;
                            d.this.aBr.aGo = d.this.hFH.aFH.live_mark_info_new;
                            d.this.aBr.aGj = d.this.hFH.aGj;
                            if (d.this.hFH.aFH != null && d.this.hFH.aFH.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.hFH.aFH.levelId);
                            }
                            d.this.aBr.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aBr));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aBr);
                    if (d.this.hFH != null && d.this.hFH.mLiveInfo != null) {
                        d.this.ciH();
                    }
                    if (d.this.aBr != null && d.this.aBr.mLiveInfo != null) {
                        d.this.w(d.this.aBr.mLiveInfo.user_id, d.this.aBr.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.hGm = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.p.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.hFF.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.hGn = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.p.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.r.b)) {
                    com.baidu.live.r.b bVar = (com.baidu.live.r.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.btp != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.btp.gM(bVar.contentType);
                        } else {
                            bVar.btp.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hGo = new HttpMessageListener(1021125) { // from class: com.baidu.tieba.ala.liveroom.p.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetUserInfoHttpResponseMessage)) {
                    GetUserInfoHttpResponseMessage getUserInfoHttpResponseMessage = (GetUserInfoHttpResponseMessage) httpResponsedMessage;
                    if (d.this.aBr != null && d.this.aBr.aGd != null && getUserInfoHttpResponseMessage.userId == d.this.aBr.aGd.userId && !TextUtils.isEmpty(getUserInfoHttpResponseMessage.userName)) {
                        d.this.aBr.aGd.nickName = getUserInfoHttpResponseMessage.userName;
                    }
                }
            }
        };
        this.hGp = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.p.d.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                u uVar;
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getError() != 0) {
                        l.e(httpResponsedMessage);
                        return;
                    }
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        uVar = null;
                    } else {
                        uVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).chT();
                    }
                    if (uVar == null || ListUtils.isEmpty(uVar.aFW)) {
                        l.e(httpResponsedMessage);
                        return;
                    }
                    d.this.hFY = uVar.aFV;
                    d.this.hFJ = uVar.pn + 1;
                    t tVar = uVar.aFW.get(uVar.aFW.size() - 1);
                    if (tVar != null) {
                        d.this.mLastLiveId = tVar.mLiveInfo.live_id;
                    }
                    d.this.a(uVar);
                    if (d.this.aBr != null) {
                        d.this.h(d.this.aBr.mLiveInfo);
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, uVar);
                }
            }
        };
        this.hGq = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.p.d.25
        };
        this.hGr = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.hFw));
            }
        };
        this.bhf = bdPageContext;
        this.hFF = new com.baidu.live.im.d(bdPageContext, false, this);
        this.hFI = new ArrayList();
        this.hFU = new HashSet();
        initTasks();
        registerListener(this.hGj);
        registerListener(this.hGh);
        registerListener(this.hGg);
        registerListener(this.hGe);
        this.hFC = BdUniqueId.gen();
        this.hGp.setTag(this.hFC);
        registerListener(this.hGp);
        registerListener(this.hGk);
        registerListener(this.hGf);
        registerListener(this.hGl);
        registerListener(this.hkl);
        registerListener(this.hGb);
        registerListener(this.hGc);
        registerListener(this.hGa);
        registerListener(this.gKA);
        registerListener(this.hGi);
        registerListener(this.hGd);
        registerListener(this.hGm);
        registerListener(this.hGn);
        registerListener(this.hGo);
        MessageManager.getInstance().addMessageRule(this.hFR);
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
        this.hFw = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.hGr);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        cie();
        cif();
        cig();
        cih();
        cik();
        cil();
    }

    public void setIsMixLive(boolean z) {
        this.hFZ = z;
    }

    private void cie() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cif() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void cig() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void cih() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void cii() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.p.d.12
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    Log.i("i", "@@@ localText lrmd run");
                    d.this.e(customMessage.getData());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void cij() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void cik() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cil() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cim() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.r.b) && d.this.aBr != null && d.this.aBr.mLiveInfo != null) {
                    com.baidu.live.r.b bVar = (com.baidu.live.r.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aBr.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.bto != null) {
                        httpMessage.addParam("ext_data", bVar.bto.toString());
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

    public void cin() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void w(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cio() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, "author_liveroom", ""));
    }

    public void ez(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void cip() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.bhf.getPageActivity(), "")));
    }

    public void ciq() {
        if (this.hFT != null) {
            this.hFT.dismiss();
            this.hFT = null;
        }
        String string = this.bhf.getString(a.h.ala_live_no_auth);
        this.hFT = new BdAlertDialog(this.bhf.getPageActivity());
        this.hFT.setAutoNight(false);
        this.hFT.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hFT.setPositiveButton(this.bhf.getString(a.h.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cip();
                    d.this.Ek();
                }
            });
            this.hFT.setNegativeButton(this.bhf.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Ek();
                }
            });
        } else {
            this.hFT.setPositiveButton(this.bhf.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Ek();
                }
            });
        }
        this.hFT.setCancelable(false);
        this.hFT.setCanceledOnTouchOutside(false);
        this.hFT.setTitleShowCenter(true);
        this.hFT.setMessageShowCenter(true);
        this.hFT.isShowTitleAndMessage();
        this.hFT.create(this.bhf);
        this.hFT.show();
    }

    public void eA(String str, String str2) {
        if (this.hFT != null) {
            this.hFT.dismiss();
            this.hFT = null;
        }
        String string = this.bhf.getString(a.h.ala_live_no_permission);
        this.hFT = new BdAlertDialog(this.bhf.getPageActivity());
        this.hFT.setAutoNight(false);
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.hFT.setTitle(str);
        } else if (StringUtils.isNull(str2)) {
            str2 = string;
        }
        this.hFT.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hFT.setPositiveButton(this.bhf.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Ek();
                }
            });
        } else {
            this.hFT.setPositiveButton(this.bhf.getString(a.h.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.af.a.OJ().bru.aJI;
                        if (!TextUtils.isEmpty(str3)) {
                            BrowserHelper.startInternalWebActivity(d.this.bhf.getPageActivity(), str3);
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
                    d.this.Ek();
                }
            });
            this.hFT.setNegativeButton(this.bhf.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Ek();
                }
            });
        }
        this.hFT.setCancelable(false);
        this.hFT.setCanceledOnTouchOutside(false);
        this.hFT.setTitleShowCenter(true);
        this.hFT.setMessageShowCenter(true);
        this.hFT.isShowTitleAndMessage();
        this.hFT.create(this.bhf);
        this.hFT.show();
    }

    public void cir() {
        if (this.hFT != null) {
            this.hFT.dismiss();
            this.hFT = null;
        }
        String string = this.bhf.getString(a.h.ala_live_no_permission_tip);
        this.hFT = new BdAlertDialog(this.bhf.getPageActivity());
        this.hFT.setAutoNight(false);
        this.hFT.setMessage(string);
        this.hFT.setPositiveButton(this.bhf.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hFT.setCancelable(false);
        this.hFT.setCanceledOnTouchOutside(false);
        this.hFT.isShowTitleAndMessage();
        this.hFT.create(this.bhf);
        this.hFT.show();
    }

    public void cis() {
        if (this.hFT != null) {
            this.hFT.dismiss();
            this.hFT = null;
        }
        if (this.hFS != null) {
            a(this.hFS);
        }
    }

    public void cit() {
        if (this.hFT != null) {
            this.hFT.dismiss();
            this.hFT = null;
        }
        String string = this.bhf.getString(a.h.dialog_msg_to_user_info);
        this.hFT = new BdAlertDialog(this.bhf.getPageActivity());
        this.hFT.setAutoNight(false);
        this.hFT.setMessage(string);
        this.hFT.setPositiveButton(this.bhf.getString(a.h.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                IExtraParams buildParamsExtra;
                if (TbadkCoreApplication.getInst().isTieba()) {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(d.this.bhf.getPageActivity(), TbadkCoreApplication.getCurrentAccountId() + "");
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
                d.this.Ek();
            }
        });
        this.hFT.setNegativeButton(this.bhf.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.Ek();
            }
        });
        this.hFT.setCancelable(false);
        this.hFT.setCanceledOnTouchOutside(false);
        this.hFT.setTitleShowCenter(true);
        this.hFT.setMessageShowCenter(true);
        this.hFT.isShowTitleAndMessage();
        this.hFT.create(this.bhf);
        this.hFT.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.bhf.getString(a.h.ala_live_no_permission_tip);
        this.hFT = new BdAlertDialog(this.bhf.getPageActivity());
        this.hFT.setAutoNight(false);
        this.hFT.setMessage(string);
        this.hFT.setPositiveButton(this.bhf.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hFT.setCancelable(false);
        this.hFT.setCanceledOnTouchOutside(false);
        this.hFT.isShowTitleAndMessage();
        this.hFT.create(this.bhf);
        this.hFT.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.bhf.getPageActivity().finish();
        this.hFS = null;
        this.hFT = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ek() {
        if (this.hFT != null) {
            this.hFT.dismiss();
            this.hFT = null;
        }
        this.hFS = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hCw != null) {
            this.hCw.a(i, str, i2, obj);
        }
    }

    public void j(long j, boolean z) {
        com.baidu.tieba.ala.liveroom.messages.b bVar = new com.baidu.tieba.ala.liveroom.messages.b();
        bVar.isFirst = z;
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c();
        cVar.setLiveId(j);
        cVar.setFrom(str);
        cVar.aZ(j2);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void ciu() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public void z(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021077);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("net_status", i);
        sendMessage(httpMessage);
    }

    public void vM(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void x(long j, long j2) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c();
        cVar.setLiveId(j);
        cVar.aZ(j2);
        cVar.setParams();
        sendMessage(cVar);
    }

    public as civ() {
        return this.hFH;
    }

    public x DW() {
        return this.aBr;
    }

    public az chR() {
        return this.hEV;
    }

    public List<AlaLiveInfoData> ciw() {
        return this.hFI;
    }

    public r bTh() {
        return this.gMd;
    }

    public void cM(List<Long> list) {
        if (!this.hFZ) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
                com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
                if (this.aBr != null && this.aBr.mLiveInfo != null) {
                    aVar.setAudienceCount(this.aBr.mLiveInfo.audience_count);
                }
                aVar.setListIds(list);
                aVar.setParams();
                sendMessage(aVar);
            }
        }
    }

    public void cix() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hFI) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cM(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar) {
        if (uVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.hFI.size() == 1 && this.hFI.get(0).live_id == this.aBr.mLiveInfo.live_id) {
                    if (c(uVar) != null) {
                        this.hFI.clear();
                    }
                    b(uVar);
                    return;
                }
                b(uVar);
                return;
            }
            b(uVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(u uVar) {
        boolean z;
        for (t tVar : uVar.aFW) {
            if (tVar != null && tVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hFI) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == tVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hFI.add(tVar.mLiveInfo);
                }
            }
        }
        if (this.hFI.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hFI.size() - 200; size < this.hFI.size(); size++) {
                arrayList.add(this.hFI.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hFI.clear();
                this.hFI.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(u uVar) {
        if (ListUtils.isEmpty(uVar.aFW)) {
            return null;
        }
        for (t tVar : uVar.aFW) {
            if (tVar != null && tVar.mLiveInfo != null && tVar.mLiveInfo.live_id == this.aBr.mLiveInfo.live_id) {
                return tVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> ciy() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hFI)) {
            return null;
        }
        if (this.hFU.isEmpty()) {
            arrayList.addAll(this.hFI);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hFI.size()) {
                    break;
                }
                if ((this.aBr == null || this.aBr.mLiveInfo == null || this.aBr.mLiveInfo.live_id != this.hFI.get(i2).live_id) && !this.hFU.contains(Long.valueOf(this.hFI.get(i2).live_id))) {
                    arrayList.add(this.hFI.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hFU.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hFU.size() >= this.hFI.size() - 4) {
                ow(false);
            }
        }
    }

    public void vN(int i) {
        this.hFP = i;
    }

    public void ow(boolean z) {
        if (!this.hFZ) {
            if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.La().KY()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hFV > 500) {
                    this.hFV = currentTimeMillis;
                    com.baidu.live.liveroom.c.d.La().Lc().a("tieba", this.hFJ, 20, this.hGq);
                    return;
                }
                return;
            }
            ox(z);
        }
    }

    private void ox(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hFX >= 1800000) {
                this.hFW = currentTimeMillis;
                this.hFY = true;
            }
            if (this.hFY) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hFJ);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hFW);
                httpMessage.setTag(this.hFC);
                sendMessage(httpMessage);
                this.hFX = currentTimeMillis;
            }
        }
    }

    public void eB(String str, String str2) {
        this.hFF.cb(true);
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
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str2);
        aVar.zP(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.Hs("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        ciJ();
    }

    public void av(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.zP(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        ciJ();
    }

    public void Ht(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        ciJ();
    }

    public void fD(long j) {
        this.hFF.cb(false);
        this.hFV = 0L;
        this.hFQ = null;
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
        if (!ciz()) {
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
            httpMessage.addParam("is_prettify", bo.b(com.baidu.live.af.a.OJ().bxp) ? 1 : 2);
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
            httpMessage.addParam("im_uk", AccountManager.getUK(this.bhf.getPageActivity()));
            sendMessage(httpMessage);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", "create_live", "author_liveroom", ""));
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                BdStatisticsManager.getInstance().newDebug("updatelive", 0L, null, "forum_name", str, "forum_id", str2, "description", str3, "is_location", Integer.valueOf(i), "lat", Double.toString(d), "lng", Double.toString(d2), "location_name", str4, "location_name_md5", str5, "is_to_tb_some", Integer.valueOf(i2), "cover", str6, "vcode", str7, "vcode_md5", str8, "is_test_live", Integer.valueOf(i3), UbcStatConstant.KEY_LIVE_TYPE, Integer.valueOf(i4), "screen_direction", Integer.valueOf(i5), "clarity", Integer.valueOf(i6), "game_id", str9, "game_name", str10);
            }
        }
    }

    private boolean ciz() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void ciA() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aBr == null) {
            this.aBr = new x(alaLiveInfoCoreData);
            this.hFF.setAlaLiveShowData(this.aBr);
        }
        this.mLastLiveId = this.aBr.mLiveInfo.live_id;
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
        if (this.aBr == null) {
            this.aBr = new x();
        }
        this.aBr.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aBr.aFH = alaLivePersonData.mUserData;
        this.aBr.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aBr.aFH != null && this.hFF != null) {
            this.hFF.R(this.aBr.aFH.live_mark_info_new);
        }
        this.aBr.isHost = true;
        this.aBr.aGr = true;
        if (this.hFF != null) {
            this.hFF.setAlaLiveShowData(this.aBr);
        }
        ciH();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aBr));
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
        this.hFD.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hGp);
        MessageManager.getInstance().removeMessageRule(this.hFR);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.hFF.cb(true);
        this.hFG = null;
        this.bhf = null;
    }

    public void vO(int i) {
        this.hFK = i;
        if (this.hFI.size() == 0) {
            this.hFK = 0;
        } else if (this.hFK < 0) {
            this.hFK = this.hFI.size() + this.hFK;
        } else {
            this.hFK %= this.hFI.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hFI.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hFI.size()) {
                    if (this.hFI.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hFK = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean ciB() {
        long j;
        if (this.aBr == null || this.aBr.mLiveInfo == null || this.hFI.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hFI.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aBr.mLiveInfo.live_id;
    }

    public boolean ciC() {
        long j;
        if (this.aBr == null || this.aBr.mLiveInfo == null || this.hFI.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hFI.get(this.hFI.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aBr.mLiveInfo.live_id;
    }

    public int ciD() {
        return this.hFK;
    }

    public int ciE() {
        return this.hFM;
    }

    public boolean ciF() {
        return this.hFN == 1;
    }

    public AlaLiveInfoData ciG() {
        if (this.hFK >= this.hFI.size()) {
            this.hFK = this.hFI.size() - 1;
        }
        if (this.hFK < 0) {
            this.hFK = 0;
        }
        if (this.hFI.size() <= this.hFK) {
            if (this.aBr != null) {
                return this.aBr.mLiveInfo;
            }
            return null;
        }
        return this.hFI.get(this.hFK);
    }

    public void a(a aVar) {
        this.hCw = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.hFG != null) {
            this.hFG.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void t(com.baidu.live.im.data.b bVar) {
        if (this.aBr != null && this.aBr.mLiveInfo.live_type == 1) {
            L(bVar);
        }
        if (this.hFG != null) {
            this.hFG.t(bVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, bVar));
        }
    }

    public void L(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject = new JSONObject(bVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        if ((bVar.getMsgType() == 12 || bVar.getMsgType() == 13) && jSONObject != null && "ss_hot_live".equals(jSONObject.optString("content_type")) && !this.mIsHost) {
            ow(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void Ig() {
        if (this.hFG != null) {
            this.hFG.Ig();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void e(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        boolean z;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aBr);
        if (this.aBr != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aBr.aFH;
            } else {
                alaLiveUserInfoData = this.aBr.aGd;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aBr.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (this.mIsHost || this.aBr.aGd == null || this.aBr.aGd.extInfoJson == null) {
                    z = false;
                } else {
                    z = this.aBr.aGd.extInfoJson.optInt("is_mysterious_man") == 1;
                }
                if (!z && !TbadkCoreApplication.getInst().isMobileBaidu() && this.aBr != null && this.aBr.aGd != null && this.aBr.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aBr.aGd.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr2 == null || strArr2.length != 2) {
                            strArr2 = new String[2];
                            strArr2[1] = "";
                        }
                        strArr2[0] = "guard_seat_effect";
                    }
                }
                String[] strArr3 = strArr2;
                if (!z && strArr3 != null && strArr3.length >= 2) {
                    if (TextUtils.equals(strArr3[0], "mysterious_man_effect")) {
                        strArr3[0] = "";
                    }
                    if (TextUtils.equals(strArr3[1], "mysterious_man_nick_name")) {
                        strArr3[1] = "";
                    }
                }
                this.hFF.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void ciH() {
        this.hFF.e(String.valueOf(this.aBr.mLiveInfo.getGroupID()), String.valueOf(this.aBr.mLiveInfo.getLastMsgID()), String.valueOf(this.aBr.mLiveInfo.getUserID()), String.valueOf(this.aBr.mLiveInfo.getLiveID()), this.aBr.mLiveInfo.appId);
    }

    public com.baidu.live.im.d ciI() {
        return this.hFF;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void ciJ() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aBr != null) {
            try {
                if (this.aBr.mLiveSdkInfo != null && this.aBr.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, this.aBr.mLiveSdkInfo.mCastIds.chatMCastId);
                    jSONObject2.put("ensure_mcast_id", this.aBr.mLiveSdkInfo.mCastIds.ensureMCastId);
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

    public String ciK() {
        return this.hFQ;
    }

    public void GO(String str) {
        this.hFQ = str;
    }

    public void Hu(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                this.mType = new JSONObject(str).optString(AlaLastLiveroomInfo.KEY_LAST_FROM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
