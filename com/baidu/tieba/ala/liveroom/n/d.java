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
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.data.aw;
import com.baidu.live.data.bd;
import com.baidu.live.data.bt;
import com.baidu.live.data.v;
import com.baidu.live.data.x;
import com.baidu.live.data.y;
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
    private ab aED;
    private BdPageContext<?> blX;
    private CustomMessageListener gPd;
    private v gQG;
    private a hIC;
    private long hLF;
    private BdUniqueId hLL;
    private Handler hLM;
    private HttpMessage hLN;
    private final com.baidu.live.im.d hLO;
    private d.a hLP;
    private aw hLQ;
    private List<AlaLiveInfoData> hLR;
    private int hLS;
    private int hLT;
    private boolean hLU;
    private int hLV;
    private int hLW;
    private int hLX;
    private int hLY;
    private String hLZ;
    private bd hLe;
    private CustomMessageTask.CustomRunnable hMA;
    private com.baidu.live.ac.a hMa;
    private AlaGetVerifyStrategyResponseHttpMessage hMb;
    private BdAlertDialog hMc;
    private Set<Long> hMd;
    private long hMe;
    private long hMf;
    private long hMg;
    private boolean hMh;
    private boolean hMi;
    private HttpMessageListener hMj;
    private HttpMessageListener hMk;
    private HttpMessageListener hMl;
    private HttpMessageListener hMm;
    private NetMessageListener hMn;
    private HttpMessageListener hMo;
    private NetMessageListener hMp;
    private HttpMessageListener hMq;
    private HttpMessageListener hMr;
    private NetMessageListener hMs;
    private NetMessageListener hMt;
    private HttpMessageListener hMu;
    private CustomMessageListener hMv;
    private HttpMessageListener hMw;
    private HttpMessageListener hMx;
    private HttpMessageListener hMy;
    private com.baidu.live.liveroom.c.a hMz;
    private HttpMessageListener hqA;
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
        this.hLM = new Handler();
        this.hLS = 0;
        this.hLT = 0;
        this.hLU = true;
        this.hLV = 1;
        this.hLW = 0;
        this.hLX = -1;
        this.hLY = 0;
        this.hMa = new com.baidu.live.ac.a(0);
        this.otherParams = "";
        this.hMf = System.currentTimeMillis();
        this.hMg = 0L;
        this.hMh = true;
        this.hMi = false;
        this.gPd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.n.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aED != null && d.this.aED.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aED.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.hLX = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aED.mLiveInfo.user_id).param("obj_param1", d.this.aED.mLiveInfo.live_id).param("tid", d.this.aED.mLiveInfo.thread_id));
                            d.this.hLX = 1;
                        }
                        if (d.this.aED != null && d.this.aED.aJF != null) {
                            d.this.aED.aJF.follow_status = d.this.hLX;
                        }
                    }
                }
            }
        };
        this.hMj = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.n.d.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.bwz == 1 && alaUserAuthenVerifyInfoResponseMessage.bwy != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.bwy.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.bwy.verify_video_status == 1) {
                            d.this.hLV = 4;
                        }
                    }
                }
            }
        };
        this.hMk = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.n.d.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.28.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1003303);
                        }
                    });
                    final AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    d.this.hLW = alaGetVerifyStrategyResponseHttpMessage.hLl;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, "author_liveroom", ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hLh);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hLj);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hLm);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, "author_liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hLj != 1 || alaGetVerifyStrategyResponseHttpMessage.hLh != 1 || alaGetVerifyStrategyResponseHttpMessage.hLm != 1 || alaGetVerifyStrategyResponseHttpMessage.hLo != 1) {
                            d.this.hMb = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hLm != 1) {
                                d.this.hLM.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.28.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cjw();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hLj != 1 || alaGetVerifyStrategyResponseHttpMessage.hLh != 1) {
                                d.this.hLM.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.28.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ez(alaGetVerifyStrategyResponseHttpMessage.hLp, alaGetVerifyStrategyResponseHttpMessage.hLq);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hLo != 1) {
                                d.this.hLM.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.28.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cjz();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.hMb = null;
                    }
                }
            }
        };
        this.hMl = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.n.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.hMm = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.n.d.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cjf;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.cjd() == 1 || masterIdentityResponseMessage.cje() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cjf())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cjf());
                            jSONObject.put("content_type", "custom_master_identity");
                            cjf = jSONObject.toString();
                        } catch (JSONException e) {
                            cjf = masterIdentityResponseMessage.cjf();
                            e.printStackTrace();
                        }
                        d.this.hLO.a(27, cjf, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.hMn = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.n.d.31
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.hMo = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.n.d.32
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.hLU = false;
                }
            }
        };
        this.hMp = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.n.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aED = alaEnterLiveHttpResonseMessage.Fp();
                        d.this.hLe = alaEnterLiveHttpResonseMessage.ciX();
                        d.this.hLO.setAlaLiveShowData(d.this.aED);
                    }
                    if (d.this.aED != null && d.this.aED.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.ckN().fK(d.this.aED.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aED.mLiveInfo.live_id);
                        try {
                            com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(d.this.aED.mLiveInfo.live_id)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (d.this.aED != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aED.aJZ != null) {
                            if (d.this.aED.aJZ.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aED.aJZ.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aED.aJZ.nickName);
                            if (!TextUtils.isEmpty(d.this.aED.aJZ.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aED.aJZ.portrait);
                            }
                            com.baidu.live.view.a.Xr().iq(String.valueOf(d.this.aED.mLiveInfo.user_id));
                        }
                        if (d.this.aED.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aED.mLiveSdkInfo.tbs);
                            com.baidu.live.d.xf().putString("ala_account_user_tbs", d.this.aED.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aED != null) {
                        if (d.this.hLR.size() <= 0) {
                            d.this.hLR.add(d.this.aED.mLiveInfo);
                            d.this.hMd.add(Long.valueOf(d.this.aED.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aED.mLiveInfo);
                        if (d.this.hLO != null) {
                            d.this.hLO.S(d.this.aED.aKk);
                        }
                    }
                    if (d.this.aED != null && d.this.aED.aJF != null) {
                        d.this.hLX = d.this.aED.aJF.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aED);
                    if (d.this.aED != null && d.this.aED.mLiveInfo != null) {
                        d.this.cjN();
                    }
                    if (d.this.aED != null) {
                        d.this.aED.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aED));
                        com.baidu.live.im.b.d.KQ().W(d.this.aED.aKk);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aED != null && d.this.aED.mLiveInfo != null) {
                            long j2 = d.this.aED.mLiveInfo.live_id;
                            long j3 = d.this.aED.mLiveInfo.room_id;
                            String str = d.this.aED.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aED.aJD != null) {
                                long j4 = d.this.aED.aJD.userId;
                                str2 = d.this.aED.aJD.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && d.this.aED != null && d.this.aED.mLiveInfo != null) {
                        long j5 = d.this.aED.mLiveInfo.live_id;
                        long j6 = d.this.aED.mLiveInfo.room_id;
                        String str3 = d.this.aED.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aED.aJD != null) {
                            j = d.this.aED.aJD.userId;
                            str4 = d.this.aED.aJD.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.hLT + "");
                    }
                    if (d.this.aED != null && d.this.aED.mLiveInfo != null) {
                        if (!com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckl().ckk()) {
                            try {
                                if (d.this.aED.mLiveInfo.isPubShow && TbadkCoreApplication.getCurrentAccount() != null) {
                                    com.baidu.live.view.a.Xr().iq(String.valueOf(d.this.aED.mLiveInfo.user_id));
                                    com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckl().a(d.this.blX, d.this.aED.mLiveInfo.live_id, Long.parseLong(TbadkCoreApplication.getCurrentAccount()), d.this.aED.mLiveInfo, d.this.mType);
                                }
                            } catch (NumberFormatException e2) {
                                e2.printStackTrace();
                            }
                        }
                        com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckl().oI(false);
                    }
                    com.baidu.live.d.xf().putLong("show_enter_live_timestamp", System.currentTimeMillis() / 1000);
                }
            }
        };
        this.hMq = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.n.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    v vVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        vVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bTX();
                    }
                    if (vVar != null) {
                        d.this.gQG = vVar;
                    }
                    if (d.this.aED != null && d.this.aED.aJF != null) {
                        if (d.this.hLX == -1) {
                            d.this.hLX = d.this.aED.aJF.follow_status;
                        }
                        if (d.this.aED.aJF.follow_status != d.this.hLX) {
                            d.this.aED.aJF.follow_status = d.this.hLX;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.gQG);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.gQG));
                }
            }
        };
        this.hMr = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.n.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cjc = alaUserLiveMarkInfoResponseMessage.cjc();
                        d.this.hLO.S(cjc);
                        if (d.this.aED != null) {
                            d.this.aED.aKk = cjc;
                            com.baidu.live.im.b.d.KQ().W(d.this.aED.aKk);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aED));
                        }
                    }
                }
            }
        };
        this.hMs = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.n.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    ab Fp = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).Fp() : null;
                    d.this.hLF = System.currentTimeMillis();
                    if (Fp == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, Fp);
                        return;
                    }
                    if (d.this.aED == null) {
                        d.this.aED = Fp;
                        d.this.hLO.setAlaLiveShowData(d.this.aED);
                    } else if (d.this.aED.mLiveInfo != null && Fp.mLiveInfo != null && d.this.aED.mLiveInfo.live_id != Fp.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aED);
                        return;
                    }
                    if (d.this.aED.mLiveInfo != null && Fp.mLiveInfo != null && d.this.aED.mLiveInfo.user_id == Fp.mLiveInfo.user_id) {
                        if (d.this.aED.mLiveInfo.imEffect != null && Fp.mLiveInfo.imEffect == null) {
                            Fp.mLiveInfo.imEffect = d.this.aED.mLiveInfo.imEffect;
                        }
                        if (d.this.aED.mLiveInfo.mLiveCloseData != null && Fp.mLiveInfo.mLiveCloseData == null) {
                            Fp.mLiveInfo.mLiveCloseData = d.this.aED.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aED.mLiveInfo.mAlaLiveSwitchData != null && Fp.mLiveInfo.mAlaLiveSwitchData == null) {
                            Fp.mLiveInfo.mAlaLiveSwitchData = d.this.aED.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aED.mLiveInfo = Fp.mLiveInfo;
                    d.this.aED.serverTime = Fp.serverTime;
                    d.this.aED.aKw = Fp.aKw;
                    if (Fp.aJD != null && Fp.aJD.userId != 0) {
                        d.this.aED.aJD = Fp.aJD;
                    }
                    d.this.aED.aJE = Fp.aJE;
                    d.this.aED.aJI = Fp.aJI;
                    d.this.aED.aKl = Fp.aKl;
                    d.this.aED.aKj = Fp.aKj;
                    d.this.aED.aKe = Fp.aKe;
                    d.this.aED.aKf = Fp.aKf;
                    d.this.aED.aKg = Fp.aKg;
                    d.this.aED.aKh = Fp.aKh;
                    d.this.aED.aKi = Fp.aKi;
                    d.this.aED.countDown = Fp.countDown;
                    d.this.aED.aKQ = Fp.aKQ;
                    if (Fp.url != null) {
                        d.this.aED.url = Fp.url;
                    }
                    if (Fp.aKb != null) {
                        d.this.aED.aKb = Fp.aKb;
                    }
                    d.this.aED.aKC = Fp.aKC;
                    if (Fp.aKo != null && Fp.aKo.aPq != null && !Fp.aKo.aPq.isEmpty()) {
                        String str = d.this.aED.aKo.aPs;
                        String str2 = d.this.aED.aKo.aPu;
                        d.this.aED.aKo = Fp.aKo;
                        d.this.aED.aKo.aPs = str;
                        d.this.aED.aKo.aPu = str2;
                    }
                    if (Fp.aJZ != null) {
                        if (Fp.aJZ.userId == 0 || TbadkCoreApplication.getCurrentAccountInfo() == null) {
                            if (d.this.aED.aJZ == null) {
                                d.this.aED.aJZ = new AlaLiveUserInfoData();
                            }
                            d.this.aED.aJZ.throneUid = Fp.aJZ.throneUid;
                        } else {
                            boolean z = Fp.aJZ.isNewUser;
                            if (d.this.aED.aJZ != null) {
                                z = d.this.aED.aJZ.isNewUser;
                            }
                            Fp.aJZ.isNewUser = z;
                            d.this.aED.aJZ = Fp.aJZ;
                            if (d.this.aED.aJZ.levelId != TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel()) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aED.aJZ.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aED.aJZ.nickName);
                            if (!TextUtils.equals(d.this.aED.aJZ.portrait, TbadkCoreApplication.getCurrentAccountObj().getPortrait())) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aED.aJZ.portrait);
                            }
                        }
                    }
                    if (Fp.aKc != null) {
                        d.this.aED.aKc = Fp.aKc;
                    }
                    if (Fp.aKj) {
                        d.this.aED.aKk = Fp.aKk;
                        if (d.this.hLO != null) {
                            d.this.hLO.S(Fp.aKk);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aED.mLiveInfo != null) {
                        int i = d.this.aED.mLiveInfo.backstage_type;
                        if (d.this.hLO != null) {
                            d.this.hLO.he(String.valueOf(i));
                        }
                    }
                    if (d.this.hLO != null) {
                        d.this.hLO.setAlaLiveShowData(d.this.aED);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aED);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aED));
                    if (d.this.aED != null) {
                        com.baidu.live.im.b.d.KQ().W(d.this.aED.aKk);
                    }
                }
            }
        };
        this.hMt = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.n.d.6
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
                    if (list != null && list.size() > 0 && d.this.hLR != null && d.this.hLR.size() > 0) {
                        for (int size = d.this.hLR.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.hLR.get(size)).live_id != d.this.aED.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.hLR.get(size)).getLiveID()))) {
                                d.this.hLR.remove(size);
                            }
                        }
                    }
                    if (d.this.aED != null) {
                        d.this.h(d.this.aED.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hqA = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.n.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.hMu = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.n.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", "author_liveroom", ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.hLN = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.hLQ = alaUpdateLiveTbResponseMessage.cjb();
                    if (d.this.hLQ != null) {
                        if (d.this.hLQ.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hLQ.aPD);
                                jSONObject2.put("user_verify", d.this.hLQ.aPF);
                                jSONObject2.put("certify", d.this.hLQ.aPH);
                                if (d.this.hLQ.mLiveSdkInfo != null && d.this.hLQ.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, d.this.hLQ.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hLQ.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, "author_liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hLQ.aPD != 1 || d.this.hLQ.aPF != 1) {
                            d.this.hLM.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cjx();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.hLQ.aJD != null) {
                            d.this.hLO.S(d.this.hLQ.aJD.live_mark_info_new);
                        }
                        if (d.this.hLQ.mErrorCode != 0) {
                            if (d.this.hLQ.mErrorCode == 220012) {
                                d.this.b(d.this.hLQ.mErrorCode, d.this.hLQ.mErrorMsg, 6, d.this.aED);
                                return;
                            }
                        } else {
                            d.this.aED = new ab();
                            d.this.hLO.setAlaLiveShowData(d.this.aED);
                            d.this.aED.mLiveInfo = d.this.hLQ.mLiveInfo;
                            d.this.aED.aJD = d.this.hLQ.aJD;
                            d.this.aED.mLiveSdkInfo = d.this.hLQ.mLiveSdkInfo;
                            d.this.aED.aKm = d.this.hLQ.aKm;
                            d.this.aED.aKk = d.this.hLQ.aJD.live_mark_info_new;
                            d.this.aED.aKf = d.this.hLQ.aKf;
                            if (d.this.hLQ.aJD != null && d.this.hLQ.aJD.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.hLQ.aJD.levelId);
                            }
                            d.this.aED.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aED));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aED);
                    if (d.this.hLQ != null && d.this.hLQ.mLiveInfo != null) {
                        d.this.cjN();
                    }
                    if (d.this.aED != null && d.this.aED.mLiveInfo != null) {
                        d.this.A(d.this.aED.mLiveInfo.user_id, d.this.aED.mLiveInfo.live_id);
                    }
                    com.baidu.live.d.xf().putLong("show_enter_live_timestamp", System.currentTimeMillis() / 1000);
                }
            }
        };
        this.hMv = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.n.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.hLO.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.hMw = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.n.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.q.b)) {
                    com.baidu.live.q.b bVar = (com.baidu.live.q.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.bys != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.bys.hr(bVar.contentType);
                        } else {
                            bVar.bys.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hMx = new HttpMessageListener(1021125) { // from class: com.baidu.tieba.ala.liveroom.n.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetUserInfoHttpResponseMessage)) {
                    GetUserInfoHttpResponseMessage getUserInfoHttpResponseMessage = (GetUserInfoHttpResponseMessage) httpResponsedMessage;
                    if (d.this.aED != null && d.this.aED.aJZ != null && getUserInfoHttpResponseMessage.userId == d.this.aED.aJZ.userId && !TextUtils.isEmpty(getUserInfoHttpResponseMessage.userName)) {
                        d.this.aED.aJZ.nickName = getUserInfoHttpResponseMessage.userName;
                    }
                }
            }
        };
        this.hMy = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.n.d.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                y yVar;
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage.getError() != 0) {
                        l.e(httpResponsedMessage);
                        return;
                    }
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        yVar = null;
                    } else {
                        yVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).ciZ();
                    }
                    if (yVar == null || ListUtils.isEmpty(yVar.aJS)) {
                        l.e(httpResponsedMessage);
                        return;
                    }
                    d.this.hMh = yVar.aJR;
                    d.this.hLS = yVar.pn + 1;
                    x xVar = yVar.aJS.get(yVar.aJS.size() - 1);
                    if (xVar != null) {
                        d.this.mLastLiveId = xVar.mLiveInfo.live_id;
                    }
                    d.this.a(yVar);
                    if (d.this.aED != null) {
                        d.this.h(d.this.aED.mLiveInfo);
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, yVar);
                }
            }
        };
        this.hMz = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.n.d.25
        };
        this.hMA = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.hLF));
            }
        };
        this.blX = bdPageContext;
        this.hLO = new com.baidu.live.im.d(bdPageContext, false, this);
        this.hLR = new ArrayList();
        this.hMd = new HashSet();
        initTasks();
        registerListener(this.hMs);
        registerListener(this.hMq);
        registerListener(this.hMp);
        registerListener(this.hMn);
        this.hLL = BdUniqueId.gen();
        this.hMy.setTag(this.hLL);
        registerListener(this.hMy);
        registerListener(this.hMt);
        registerListener(this.hMo);
        registerListener(this.hMu);
        registerListener(this.hqA);
        registerListener(this.hMk);
        registerListener(this.hMl);
        registerListener(this.hMj);
        registerListener(this.gPd);
        registerListener(this.hMr);
        registerListener(this.hMm);
        registerListener(this.hMv);
        registerListener(this.hMw);
        registerListener(this.hMx);
        MessageManager.getInstance().addMessageRule(this.hMa);
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
        this.hLF = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.hMA);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        cjk();
        cjl();
        cjm();
        cjn();
        cjq();
        cjr();
    }

    public void setIsMixLive(boolean z) {
        this.hMi = z;
    }

    private void cjk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cjl() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void cjm() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void cjn() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void cjo() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.n.d.12
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

    public void cjp() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void cjq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cjr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cjs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.q.b) && d.this.aED != null && d.this.aED.mLiveInfo != null) {
                    com.baidu.live.q.b bVar = (com.baidu.live.q.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aED.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.byr != null) {
                        httpMessage.addParam("ext_data", bVar.byr.toString());
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

    public void cjt() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void A(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cju() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, "author_liveroom", ""));
    }

    public void ey(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void cjv() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.blX.getPageActivity(), "")));
    }

    public void cjw() {
        if (this.hMc != null) {
            this.hMc.dismiss();
            this.hMc = null;
        }
        String string = this.blX.getString(a.h.ala_live_no_auth);
        this.hMc = new BdAlertDialog(this.blX.getPageActivity());
        this.hMc.setAutoNight(false);
        this.hMc.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hMc.setPositiveButton(this.blX.getString(a.h.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cjv();
                    d.this.FD();
                }
            });
            this.hMc.setNegativeButton(this.blX.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FD();
                }
            });
        } else {
            this.hMc.setPositiveButton(this.blX.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FD();
                }
            });
        }
        this.hMc.setCancelable(false);
        this.hMc.setCanceledOnTouchOutside(false);
        this.hMc.setTitleShowCenter(true);
        this.hMc.setMessageShowCenter(true);
        this.hMc.isShowTitleAndMessage();
        this.hMc.create(this.blX);
        this.hMc.show();
    }

    public void ez(String str, String str2) {
        if (this.hMc != null) {
            this.hMc.dismiss();
            this.hMc = null;
        }
        String string = this.blX.getString(a.h.ala_live_no_permission);
        this.hMc = new BdAlertDialog(this.blX.getPageActivity());
        this.hMc.setAutoNight(false);
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.hMc.setTitle(str);
        } else if (StringUtils.isNull(str2)) {
            str2 = string;
        }
        this.hMc.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hMc.setPositiveButton(this.blX.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FD();
                }
            });
        } else {
            this.hMc.setPositiveButton(this.blX.getString(a.h.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.ae.a.Qm().bwx.aNS;
                        if (!TextUtils.isEmpty(str3)) {
                            BrowserHelper.startInternalWebActivity(d.this.blX.getPageActivity(), str3);
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
                    d.this.FD();
                }
            });
            this.hMc.setNegativeButton(this.blX.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FD();
                }
            });
        }
        this.hMc.setCancelable(false);
        this.hMc.setCanceledOnTouchOutside(false);
        this.hMc.setTitleShowCenter(true);
        this.hMc.setMessageShowCenter(true);
        this.hMc.isShowTitleAndMessage();
        this.hMc.create(this.blX);
        this.hMc.show();
    }

    public void cjx() {
        if (this.hMc != null) {
            this.hMc.dismiss();
            this.hMc = null;
        }
        String string = this.blX.getString(a.h.ala_live_no_permission_tip);
        this.hMc = new BdAlertDialog(this.blX.getPageActivity());
        this.hMc.setAutoNight(false);
        this.hMc.setMessage(string);
        this.hMc.setPositiveButton(this.blX.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hMc.setCancelable(false);
        this.hMc.setCanceledOnTouchOutside(false);
        this.hMc.isShowTitleAndMessage();
        this.hMc.create(this.blX);
        this.hMc.show();
    }

    public void cjy() {
        if (this.hMc != null) {
            this.hMc.dismiss();
            this.hMc = null;
        }
        if (this.hMb != null) {
            a(this.hMb);
        }
    }

    public void cjz() {
        if (this.hMc != null) {
            this.hMc.dismiss();
            this.hMc = null;
        }
        String string = this.blX.getString(a.h.dialog_msg_to_user_info);
        this.hMc = new BdAlertDialog(this.blX.getPageActivity());
        this.hMc.setAutoNight(false);
        this.hMc.setMessage(string);
        this.hMc.setPositiveButton(this.blX.getString(a.h.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                IExtraParams buildParamsExtra;
                if (TbadkCoreApplication.getInst().isTieba()) {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(d.this.blX.getPageActivity(), TbadkCoreApplication.getCurrentAccountId() + "");
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
                d.this.FD();
            }
        });
        this.hMc.setNegativeButton(this.blX.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.FD();
            }
        });
        this.hMc.setCancelable(false);
        this.hMc.setCanceledOnTouchOutside(false);
        this.hMc.setTitleShowCenter(true);
        this.hMc.setMessageShowCenter(true);
        this.hMc.isShowTitleAndMessage();
        this.hMc.create(this.blX);
        this.hMc.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.blX.getString(a.h.ala_live_no_permission_tip);
        this.hMc = new BdAlertDialog(this.blX.getPageActivity());
        this.hMc.setAutoNight(false);
        this.hMc.setMessage(string);
        this.hMc.setPositiveButton(this.blX.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hMc.setCancelable(false);
        this.hMc.setCanceledOnTouchOutside(false);
        this.hMc.isShowTitleAndMessage();
        this.hMc.create(this.blX);
        this.hMc.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.blX.getPageActivity().finish();
        this.hMb = null;
        this.hMc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        if (this.hMc != null) {
            this.hMc.dismiss();
            this.hMc = null;
        }
        this.hMb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hIC != null) {
            this.hIC.a(i, str, i2, obj);
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
        cVar.bd(j2);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void cjA() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public void x(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021077);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK, i);
        sendMessage(httpMessage);
    }

    public void vZ(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void B(long j, long j2) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c();
        cVar.setLiveId(j);
        cVar.bd(j2);
        cVar.setParams();
        sendMessage(cVar);
    }

    public aw cjB() {
        return this.hLQ;
    }

    public ab Fp() {
        return this.aED;
    }

    public bd ciX() {
        return this.hLe;
    }

    public List<AlaLiveInfoData> cjC() {
        return this.hLR;
    }

    public v bTX() {
        return this.gQG;
    }

    public void cH(List<Long> list) {
        if (!this.hMi) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
                com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
                if (this.aED != null && this.aED.mLiveInfo != null) {
                    aVar.setAudienceCount(this.aED.mLiveInfo.audience_count);
                }
                aVar.setListIds(list);
                aVar.setParams();
                sendMessage(aVar);
            }
        }
    }

    public void cjD() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hLR) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cH(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar) {
        if (yVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.hLR.size() == 1 && this.hLR.get(0).live_id == this.aED.mLiveInfo.live_id) {
                    if (c(yVar) != null) {
                        this.hLR.clear();
                    }
                    b(yVar);
                    return;
                }
                b(yVar);
                return;
            }
            b(yVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(y yVar) {
        boolean z;
        for (x xVar : yVar.aJS) {
            if (xVar != null && xVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hLR) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == xVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hLR.add(xVar.mLiveInfo);
                }
            }
        }
        if (this.hLR.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hLR.size() - 200; size < this.hLR.size(); size++) {
                arrayList.add(this.hLR.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hLR.clear();
                this.hLR.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(y yVar) {
        if (ListUtils.isEmpty(yVar.aJS)) {
            return null;
        }
        for (x xVar : yVar.aJS) {
            if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.live_id == this.aED.mLiveInfo.live_id) {
                return xVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cjE() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hLR)) {
            return null;
        }
        if (this.hMd.isEmpty()) {
            arrayList.addAll(this.hLR);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hLR.size()) {
                    break;
                }
                if ((this.aED == null || this.aED.mLiveInfo == null || this.aED.mLiveInfo.live_id != this.hLR.get(i2).live_id) && !this.hMd.contains(Long.valueOf(this.hLR.get(i2).live_id))) {
                    arrayList.add(this.hLR.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hMd.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hMd.size() >= this.hLR.size() - 4) {
                oG(false);
            }
        }
    }

    public void wa(int i) {
        this.hLY = i;
    }

    public void oG(boolean z) {
        if (!this.hMi) {
            if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.MB().Mz()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hMe > 500) {
                    this.hMe = currentTimeMillis;
                    com.baidu.live.liveroom.c.d.MB().MD().a("tieba", this.hLS, 20, this.hMz);
                    return;
                }
                return;
            }
            oH(z);
        }
    }

    private void oH(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hMg >= 1800000) {
                this.hMf = currentTimeMillis;
                this.hMh = true;
            }
            if (this.hMh) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hLS);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hMf);
                httpMessage.setTag(this.hLL);
                sendMessage(httpMessage);
                this.hMg = currentTimeMillis;
            }
        }
    }

    public void eA(String str, String str2) {
        this.hLO.cj(true);
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
        aVar.An(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.Ig("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        cjP();
    }

    public void aw(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.An(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        cjP();
    }

    public void Ih(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        cjP();
    }

    public void fI(long j) {
        this.hLO.cj(false);
        this.hMe = 0L;
        this.hLZ = null;
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
        if (!cjF()) {
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
            httpMessage.addParam("is_prettify", bt.b(com.baidu.live.ae.a.Qm().bCs) ? 1 : 2);
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
            httpMessage.addParam("im_uk", AccountManager.getUK(this.blX.getPageActivity()));
            sendMessage(httpMessage);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", "create_live", "author_liveroom", ""));
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                BdStatisticsManager.getInstance().newDebug("updatelive", 0L, null, "forum_name", str, "forum_id", str2, "description", str3, "is_location", Integer.valueOf(i), "lat", Double.toString(d), "lng", Double.toString(d2), "location_name", str4, "location_name_md5", str5, "is_to_tb_some", Integer.valueOf(i2), "cover", str6, "vcode", str7, "vcode_md5", str8, "is_test_live", Integer.valueOf(i3), UbcStatConstant.KEY_LIVE_TYPE, Integer.valueOf(i4), "screen_direction", Integer.valueOf(i5), "clarity", Integer.valueOf(i6), "game_id", str9, "game_name", str10);
            }
        }
    }

    private boolean cjF() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void cjG() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aED == null) {
            this.aED = new ab(alaLiveInfoCoreData);
            this.hLO.setAlaLiveShowData(this.aED);
        }
        this.mLastLiveId = this.aED.mLiveInfo.live_id;
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
        if (this.aED == null) {
            this.aED = new ab();
        }
        this.aED.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aED.aJD = alaLivePersonData.mUserData;
        this.aED.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aED.aJD != null && this.hLO != null) {
            this.hLO.S(this.aED.aJD.live_mark_info_new);
        }
        this.aED.isHost = true;
        this.aED.aKn = true;
        if (this.hLO != null) {
            this.hLO.setAlaLiveShowData(this.aED);
        }
        cjN();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aED));
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
        this.hLM.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hMy);
        MessageManager.getInstance().removeMessageRule(this.hMa);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.hLO.cj(true);
        this.hLP = null;
        this.blX = null;
    }

    public void wb(int i) {
        this.hLT = i;
        if (this.hLR.size() == 0) {
            this.hLT = 0;
        } else if (this.hLT < 0) {
            this.hLT = this.hLR.size() + this.hLT;
        } else {
            this.hLT %= this.hLR.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hLR.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hLR.size()) {
                    if (this.hLR.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hLT = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cjH() {
        long j;
        if (this.aED == null || this.aED.mLiveInfo == null || this.hLR.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hLR.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aED.mLiveInfo.live_id;
    }

    public boolean cjI() {
        long j;
        if (this.aED == null || this.aED.mLiveInfo == null || this.hLR.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hLR.get(this.hLR.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aED.mLiveInfo.live_id;
    }

    public int cjJ() {
        return this.hLT;
    }

    public int cjK() {
        return this.hLV;
    }

    public boolean cjL() {
        return this.hLW == 1;
    }

    public AlaLiveInfoData cjM() {
        if (this.hLT >= this.hLR.size()) {
            this.hLT = this.hLR.size() - 1;
        }
        if (this.hLT < 0) {
            this.hLT = 0;
        }
        if (this.hLR.size() <= this.hLT) {
            if (this.aED != null) {
                return this.aED.mLiveInfo;
            }
            return null;
        }
        return this.hLR.get(this.hLT);
    }

    public void a(a aVar) {
        this.hIC = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.hLP != null) {
            this.hLP.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void t(com.baidu.live.im.data.b bVar) {
        if (this.aED != null && this.aED.mLiveInfo.live_type == 1) {
            Q(bVar);
        }
        if (this.hLP != null) {
            this.hLP.t(bVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, bVar));
        }
    }

    public void Q(com.baidu.live.im.data.b bVar) {
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
            oG(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void JH() {
        if (this.hLP != null) {
            this.hLP.JH();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void e(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        boolean z;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aED);
        if (this.aED != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aED.aJD;
            } else {
                alaLiveUserInfoData = this.aED.aJZ;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aED.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (this.mIsHost || this.aED.aJZ == null || this.aED.aJZ.extInfoJson == null) {
                    z = false;
                } else {
                    z = this.aED.aJZ.extInfoJson.optInt("is_mysterious_man") == 1;
                }
                if (!z && !TbadkCoreApplication.getInst().isMobileBaidu() && this.aED != null && this.aED.aJZ != null && this.aED.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aED.aJZ.throneUid;
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
                this.hLO.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void cjN() {
        this.hLO.e(String.valueOf(this.aED.mLiveInfo.getGroupID()), String.valueOf(this.aED.mLiveInfo.getLastMsgID()), String.valueOf(this.aED.mLiveInfo.getUserID()), String.valueOf(this.aED.mLiveInfo.getLiveID()), this.aED.mLiveInfo.appId);
    }

    public com.baidu.live.im.d cjO() {
        return this.hLO;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void cjP() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aED != null) {
            try {
                if (this.aED.mLiveSdkInfo != null && this.aED.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, this.aED.mLiveSdkInfo.mCastIds.chatMCastId);
                    jSONObject2.put("ensure_mcast_id", this.aED.mLiveSdkInfo.mCastIds.ensureMCastId);
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

    public String cjQ() {
        return this.hLZ;
    }

    public void HC(String str) {
        this.hLZ = str;
    }

    public void Ii(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                this.mType = new JSONObject(str).optString(AlaLastLiveroomInfo.KEY_LAST_FROM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
