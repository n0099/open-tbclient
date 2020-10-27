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
import com.baidu.live.data.ao;
import com.baidu.live.data.au;
import com.baidu.live.data.bk;
import com.baidu.live.data.q;
import com.baidu.live.data.s;
import com.baidu.live.data.t;
import com.baidu.live.data.w;
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
    private w aEc;
    private HttpMessageListener gNK;
    private CustomMessageListener gpo;
    private q gqS;
    private a hgd;
    private au hix;
    private long hjA;
    private long hjB;
    private boolean hjC;
    private boolean hjD;
    private HttpMessageListener hjE;
    private HttpMessageListener hjF;
    private HttpMessageListener hjG;
    private HttpMessageListener hjH;
    private NetMessageListener hjI;
    private HttpMessageListener hjJ;
    private NetMessageListener hjK;
    private HttpMessageListener hjL;
    private HttpMessageListener hjM;
    private NetMessageListener hjN;
    private NetMessageListener hjO;
    private HttpMessageListener hjP;
    private CustomMessageListener hjQ;
    private HttpMessageListener hjR;
    private HttpMessageListener hjS;
    private HttpMessageListener hjT;
    private com.baidu.live.liveroom.c.a hjU;
    private CustomMessageTask.CustomRunnable hjV;
    private long hja;
    private BdUniqueId hjg;
    private Handler hjh;
    private HttpMessage hji;
    private final com.baidu.live.im.d hjj;
    private d.a hjk;
    private ao hjl;
    private List<AlaLiveInfoData> hjm;
    private int hjn;
    private int hjo;
    private boolean hjp;
    private int hjq;
    private int hjr;
    private int hjs;
    private int hjt;
    private String hju;
    private com.baidu.live.x.a hjv;
    private AlaGetVerifyStrategyResponseHttpMessage hjw;
    private BdAlertDialog hjx;
    private Set<Long> hjy;
    private long hjz;
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
        this.hjh = new Handler();
        this.hjn = 0;
        this.hjo = 0;
        this.hjp = true;
        this.hjq = 1;
        this.hjr = 0;
        this.hjs = -1;
        this.hjt = 0;
        this.hjv = new com.baidu.live.x.a(0);
        this.otherParams = "";
        this.hjA = System.currentTimeMillis();
        this.hjB = 0L;
        this.hjC = true;
        this.hjD = false;
        this.gpo = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.q.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aEc != null && d.this.aEc.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aEc.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.hjs = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aEc.mLiveInfo.user_id).param("obj_param1", d.this.aEc.mLiveInfo.live_id).param("tid", d.this.aEc.mLiveInfo.thread_id));
                            d.this.hjs = 1;
                        }
                        if (d.this.aEc != null && d.this.aEc.aIg != null) {
                            d.this.aEc.aIg.follow_status = d.this.hjs;
                        }
                    }
                }
            }
        };
        this.hjE = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.q.d.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.bmL == 1 && alaUserAuthenVerifyInfoResponseMessage.bmK != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.bmK.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.bmK.verify_video_status == 1) {
                            d.this.hjq = 4;
                        }
                    }
                }
            }
        };
        this.hjF = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.q.d.28
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
                    d.this.hjr = alaGetVerifyStrategyResponseHttpMessage.hiG;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hiC);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hiE);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hiH);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hiE != 1 || alaGetVerifyStrategyResponseHttpMessage.hiC != 1 || alaGetVerifyStrategyResponseHttpMessage.hiH != 1 || alaGetVerifyStrategyResponseHttpMessage.hiJ != 1) {
                            d.this.hjw = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hiH != 1) {
                                d.this.hjh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cdG();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hiE != 1 || alaGetVerifyStrategyResponseHttpMessage.hiC != 1) {
                                d.this.hjh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ex(alaGetVerifyStrategyResponseHttpMessage.hiK, alaGetVerifyStrategyResponseHttpMessage.hiL);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hiJ != 1) {
                                d.this.hjh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cdJ();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.hjw = null;
                    }
                }
            }
        };
        this.hjG = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.q.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.hjH = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.q.d.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cdp;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.cdn() == 1 || masterIdentityResponseMessage.cdo() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cdp())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cdp());
                            jSONObject.put("content_type", "custom_master_identity");
                            cdp = jSONObject.toString();
                        } catch (JSONException e) {
                            cdp = masterIdentityResponseMessage.cdp();
                            e.printStackTrace();
                        }
                        d.this.hjj.a(27, cdp, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.hjI = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.q.d.31
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.hjJ = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.q.d.32
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.hjp = false;
                }
            }
        };
        this.hjK = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.q.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aEc = alaEnterLiveHttpResonseMessage.GH();
                        d.this.hix = alaEnterLiveHttpResonseMessage.cdh();
                        d.this.hjj.setAlaLiveShowData(d.this.aEc);
                    }
                    if (d.this.aEc != null && d.this.aEc.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.ceN().eF(d.this.aEc.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aEc.mLiveInfo.live_id);
                    }
                    if (d.this.aEc != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aEc.aIA != null) {
                            if (d.this.aEc.aIA.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aEc.aIA.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aEc.aIA.nickName);
                            if (!TextUtils.isEmpty(d.this.aEc.aIA.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aEc.aIA.portrait);
                            }
                        }
                        if (d.this.aEc.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aEc.mLiveSdkInfo.tbs);
                            com.baidu.live.d.AZ().putString("ala_account_user_tbs", d.this.aEc.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aEc != null) {
                        if (d.this.hjm.size() <= 0) {
                            d.this.hjm.add(d.this.aEc.mLiveInfo);
                            d.this.hjy.add(Long.valueOf(d.this.aEc.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aEc.mLiveInfo);
                        if (d.this.hjj != null) {
                            d.this.hjj.Q(d.this.aEc.aIJ);
                        }
                    }
                    if (d.this.aEc != null && d.this.aEc.aIg != null) {
                        d.this.hjs = d.this.aEc.aIg.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aEc);
                    if (d.this.aEc != null && d.this.aEc.mLiveInfo != null) {
                        d.this.cdX();
                    }
                    if (d.this.aEc != null) {
                        d.this.aEc.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aEc));
                        com.baidu.live.im.b.d.LG().U(d.this.aEc.aIJ);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aEc != null && d.this.aEc.mLiveInfo != null) {
                            long j2 = d.this.aEc.mLiveInfo.live_id;
                            long j3 = d.this.aEc.mLiveInfo.room_id;
                            String str = d.this.aEc.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aEc.aIe != null) {
                                long j4 = d.this.aEc.aIe.userId;
                                str2 = d.this.aEc.aIe.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && d.this.aEc != null && d.this.aEc.mLiveInfo != null) {
                        long j5 = d.this.aEc.mLiveInfo.live_id;
                        long j6 = d.this.aEc.mLiveInfo.room_id;
                        String str3 = d.this.aEc.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aEc.aIe != null) {
                            j = d.this.aEc.aIe.userId;
                            str4 = d.this.aEc.aIe.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.hjo + "");
                    }
                    if (d.this.aEc != null && d.this.aEc.mLiveInfo != null) {
                        if (!com.baidu.tieba.ala.liveroom.performancewatchtask.b.cek().cej()) {
                            try {
                                if (d.this.aEc.mLiveInfo.isPubShow && TbadkCoreApplication.getCurrentAccount() != null) {
                                    com.baidu.live.view.a.TX().iz(String.valueOf(d.this.aEc.mLiveInfo.user_id));
                                    com.baidu.tieba.ala.liveroom.performancewatchtask.b.cek().a(d.this.mPageContext, d.this.aEc.mLiveInfo.live_id, Long.parseLong(TbadkCoreApplication.getCurrentAccount()), d.this.aEc.mLiveInfo, d.this.mType);
                                }
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                        com.baidu.tieba.ala.liveroom.performancewatchtask.b.cek().ny(false);
                    }
                }
            }
        };
        this.hjL = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.q.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    q qVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        qVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bOQ();
                    }
                    if (qVar != null) {
                        d.this.gqS = qVar;
                    }
                    if (d.this.aEc != null && d.this.aEc.aIg != null) {
                        if (d.this.hjs == -1) {
                            d.this.hjs = d.this.aEc.aIg.follow_status;
                        }
                        if (d.this.aEc.aIg.follow_status != d.this.hjs) {
                            d.this.aEc.aIg.follow_status = d.this.hjs;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.gqS);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.gqS));
                }
            }
        };
        this.hjM = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.q.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cdm = alaUserLiveMarkInfoResponseMessage.cdm();
                        d.this.hjj.Q(cdm);
                        if (d.this.aEc != null) {
                            d.this.aEc.aIJ = cdm;
                            com.baidu.live.im.b.d.LG().U(d.this.aEc.aIJ);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aEc));
                        }
                    }
                }
            }
        };
        this.hjN = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.q.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    w GH = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).GH() : null;
                    d.this.hja = System.currentTimeMillis();
                    if (GH == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, GH);
                        return;
                    }
                    if (d.this.aEc == null) {
                        d.this.aEc = GH;
                        d.this.hjj.setAlaLiveShowData(d.this.aEc);
                    } else if (d.this.aEc.mLiveInfo != null && GH.mLiveInfo != null && d.this.aEc.mLiveInfo.live_id != GH.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aEc);
                        return;
                    }
                    if (d.this.aEc.mLiveInfo != null && GH.mLiveInfo != null && d.this.aEc.mLiveInfo.user_id == GH.mLiveInfo.user_id) {
                        if (d.this.aEc.mLiveInfo.imEffect != null && GH.mLiveInfo.imEffect == null) {
                            GH.mLiveInfo.imEffect = d.this.aEc.mLiveInfo.imEffect;
                        }
                        if (d.this.aEc.mLiveInfo.mLiveCloseData != null && GH.mLiveInfo.mLiveCloseData == null) {
                            GH.mLiveInfo.mLiveCloseData = d.this.aEc.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aEc.mLiveInfo.mAlaLiveSwitchData != null && GH.mLiveInfo.mAlaLiveSwitchData == null) {
                            GH.mLiveInfo.mAlaLiveSwitchData = d.this.aEc.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aEc.mLiveInfo = GH.mLiveInfo;
                    d.this.aEc.serverTime = GH.serverTime;
                    d.this.aEc.aIT = GH.aIT;
                    if (GH.aIe != null && GH.aIe.userId != 0) {
                        d.this.aEc.aIe = GH.aIe;
                    }
                    d.this.aEc.aIf = GH.aIf;
                    d.this.aEc.aIj = GH.aIj;
                    d.this.aEc.aIK = GH.aIK;
                    d.this.aEc.aII = GH.aII;
                    d.this.aEc.aIF = GH.aIF;
                    d.this.aEc.aIG = GH.aIG;
                    d.this.aEc.aIH = GH.aIH;
                    if (GH.aIC != null) {
                        d.this.aEc.aIC = GH.aIC;
                    }
                    d.this.aEc.aJa = GH.aJa;
                    if (GH.aIN != null && GH.aIN.aMM != null && !GH.aIN.aMM.isEmpty()) {
                        d.this.aEc.aIN = GH.aIN;
                    }
                    if (GH.aIA != null) {
                        if (GH.aIA.userId == 0) {
                            if (d.this.aEc.aIA == null) {
                                d.this.aEc.aIA = new AlaLiveUserInfoData();
                            }
                            d.this.aEc.aIA.throneUid = GH.aIA.throneUid;
                        } else {
                            boolean z = GH.aIA.isNewUser;
                            if (d.this.aEc.aIA != null) {
                                z = d.this.aEc.aIA.isNewUser;
                            }
                            GH.aIA.isNewUser = z;
                            d.this.aEc.aIA = GH.aIA;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aEc.aIA.nickName);
                        }
                    }
                    if (GH.aIE != null) {
                        d.this.aEc.aIE = GH.aIE;
                    }
                    if (GH.aII) {
                        d.this.aEc.aIJ = GH.aIJ;
                        if (d.this.hjj != null) {
                            d.this.hjj.Q(GH.aIJ);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aEc.mLiveInfo != null) {
                        int i = d.this.aEc.mLiveInfo.backstage_type;
                        if (d.this.hjj != null) {
                            d.this.hjj.hz(String.valueOf(i));
                        }
                    }
                    if (d.this.hjj != null) {
                        d.this.hjj.setAlaLiveShowData(d.this.aEc);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aEc);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aEc));
                    if (d.this.aEc != null) {
                        com.baidu.live.im.b.d.LG().U(d.this.aEc.aIJ);
                    }
                }
            }
        };
        this.hjO = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.q.d.6
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
                    if (list != null && list.size() > 0 && d.this.hjm != null && d.this.hjm.size() > 0) {
                        for (int size = d.this.hjm.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.hjm.get(size)).live_id != d.this.aEc.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.hjm.get(size)).getLiveID()))) {
                                d.this.hjm.remove(size);
                            }
                        }
                    }
                    if (d.this.aEc != null) {
                        d.this.h(d.this.aEc.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.gNK = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.q.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.hjP = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.q.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.hji = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.hjl = alaUpdateLiveTbResponseMessage.cdl();
                    if (d.this.hjl != null) {
                        if (d.this.hjl.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hjl.aMR);
                                jSONObject2.put("user_verify", d.this.hjl.aMT);
                                jSONObject2.put("certify", d.this.hjl.aMV);
                                if (d.this.hjl.mLiveSdkInfo != null && d.this.hjl.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put("chat_mcast_id", d.this.hjl.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hjl.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hjl.aMR != 1 || d.this.hjl.aMT != 1) {
                            d.this.hjh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cdH();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.hjl.aIe != null) {
                            d.this.hjj.Q(d.this.hjl.aIe.live_mark_info_new);
                        }
                        if (d.this.hjl.mErrorCode != 0) {
                            if (d.this.hjl.mErrorCode == 220012) {
                                d.this.b(d.this.hjl.mErrorCode, d.this.hjl.mErrorMsg, 6, d.this.aEc);
                                return;
                            }
                        } else {
                            d.this.aEc = new w();
                            d.this.hjj.setAlaLiveShowData(d.this.aEc);
                            d.this.aEc.mLiveInfo = d.this.hjl.mLiveInfo;
                            d.this.aEc.aIe = d.this.hjl.aIe;
                            d.this.aEc.mLiveSdkInfo = d.this.hjl.mLiveSdkInfo;
                            d.this.aEc.aIL = d.this.hjl.aIL;
                            d.this.aEc.aIJ = d.this.hjl.aIe.live_mark_info_new;
                            d.this.aEc.aIG = d.this.hjl.aIG;
                            if (d.this.hjl.aIe != null && d.this.hjl.aIe.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.hjl.aIe.levelId);
                            }
                            d.this.aEc.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aEc));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aEc);
                    if (d.this.hjl != null && d.this.hjl.mLiveInfo != null) {
                        d.this.cdX();
                    }
                    if (d.this.aEc != null && d.this.aEc.mLiveInfo != null) {
                        d.this.s(d.this.aEc.mLiveInfo.user_id, d.this.aEc.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.hjQ = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.q.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.hjj.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.hjR = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.q.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.o.b)) {
                    com.baidu.live.o.b bVar = (com.baidu.live.o.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.boz != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.boz.hH(bVar.contentType);
                        } else {
                            bVar.boz.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hjS = new HttpMessageListener(1021125) { // from class: com.baidu.tieba.ala.liveroom.q.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetUserInfoHttpResponseMessage)) {
                    GetUserInfoHttpResponseMessage getUserInfoHttpResponseMessage = (GetUserInfoHttpResponseMessage) httpResponsedMessage;
                    if (d.this.aEc != null && d.this.aEc.aIA != null && getUserInfoHttpResponseMessage.userId == d.this.aEc.aIA.userId && !TextUtils.isEmpty(getUserInfoHttpResponseMessage.userName)) {
                        d.this.aEc.aIA.nickName = getUserInfoHttpResponseMessage.userName;
                    }
                }
            }
        };
        this.hjT = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.q.d.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                t tVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        tVar = null;
                    } else {
                        tVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).cdj();
                    }
                    if (tVar != null && !ListUtils.isEmpty(tVar.aIt)) {
                        d.this.hjC = tVar.aIs;
                        d.this.hjn = tVar.pn + 1;
                        s sVar = tVar.aIt.get(tVar.aIt.size() - 1);
                        if (sVar != null) {
                            d.this.mLastLiveId = sVar.mLiveInfo.live_id;
                        }
                        d.this.a(tVar);
                        if (d.this.aEc != null) {
                            d.this.h(d.this.aEc.mLiveInfo);
                        }
                        d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, tVar);
                    }
                }
            }
        };
        this.hjU = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.q.d.25
        };
        this.hjV = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.hja));
            }
        };
        this.mPageContext = bdPageContext;
        this.hjj = new com.baidu.live.im.d(bdPageContext, false, this);
        this.hjm = new ArrayList();
        this.hjy = new HashSet();
        initTasks();
        registerListener(this.hjN);
        registerListener(this.hjL);
        registerListener(this.hjK);
        registerListener(this.hjI);
        this.hjg = BdUniqueId.gen();
        this.hjT.setTag(this.hjg);
        registerListener(this.hjT);
        registerListener(this.hjO);
        registerListener(this.hjJ);
        registerListener(this.hjP);
        registerListener(this.gNK);
        registerListener(this.hjF);
        registerListener(this.hjG);
        registerListener(this.hjE);
        registerListener(this.gpo);
        registerListener(this.hjM);
        registerListener(this.hjH);
        registerListener(this.hjQ);
        registerListener(this.hjR);
        registerListener(this.hjS);
        MessageManager.getInstance().addMessageRule(this.hjv);
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
        this.hja = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.hjV);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        cdu();
        cdv();
        cdw();
        cdx();
        cdA();
        cdB();
    }

    public void setIsMixLive(boolean z) {
        this.hjD = z;
    }

    private void cdu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cdv() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void cdw() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void cdx() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void cdy() {
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

    public void cdz() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void cdA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cdB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cdC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.o.b) && d.this.aEc != null && d.this.aEc.mLiveInfo != null) {
                    com.baidu.live.o.b bVar = (com.baidu.live.o.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aEc.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.boy != null) {
                        httpMessage.addParam("ext_data", bVar.boy.toString());
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

    public void cdD() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void s(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cdE() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    public void ew(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void cdF() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void cdG() {
        if (this.hjx != null) {
            this.hjx.dismiss();
            this.hjx = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.hjx = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hjx.setAutoNight(false);
        this.hjx.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hjx.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cdF();
                    d.this.GU();
                }
            });
            this.hjx.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GU();
                }
            });
        } else {
            this.hjx.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GU();
                }
            });
        }
        this.hjx.setCancelable(false);
        this.hjx.setCanceledOnTouchOutside(false);
        this.hjx.setTitleShowCenter(true);
        this.hjx.setMessageShowCenter(true);
        this.hjx.isShowTitleAndMessage();
        this.hjx.create(this.mPageContext);
        this.hjx.show();
    }

    public void ex(String str, String str2) {
        if (this.hjx != null) {
            this.hjx.dismiss();
            this.hjx = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.hjx = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hjx.setAutoNight(false);
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.hjx.setTitle(str);
        } else if (StringUtils.isNull(str2)) {
            str2 = string;
        }
        this.hjx.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hjx.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GU();
                }
            });
        } else {
            this.hjx.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.z.a.Pq().bmJ.aLH;
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
                    d.this.GU();
                }
            });
            this.hjx.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GU();
                }
            });
        }
        this.hjx.setCancelable(false);
        this.hjx.setCanceledOnTouchOutside(false);
        this.hjx.setTitleShowCenter(true);
        this.hjx.setMessageShowCenter(true);
        this.hjx.isShowTitleAndMessage();
        this.hjx.create(this.mPageContext);
        this.hjx.show();
    }

    public void cdH() {
        if (this.hjx != null) {
            this.hjx.dismiss();
            this.hjx = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.hjx = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hjx.setAutoNight(false);
        this.hjx.setMessage(string);
        this.hjx.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hjx.setCancelable(false);
        this.hjx.setCanceledOnTouchOutside(false);
        this.hjx.isShowTitleAndMessage();
        this.hjx.create(this.mPageContext);
        this.hjx.show();
    }

    public void cdI() {
        if (this.hjx != null) {
            this.hjx.dismiss();
            this.hjx = null;
        }
        if (this.hjw != null) {
            a(this.hjw);
        }
    }

    public void cdJ() {
        if (this.hjx != null) {
            this.hjx.dismiss();
            this.hjx = null;
        }
        String string = this.mPageContext.getString(a.i.dialog_msg_to_user_info);
        this.hjx = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hjx.setAutoNight(false);
        this.hjx.setMessage(string);
        this.hjx.setPositiveButton(this.mPageContext.getString(a.i.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.20
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
                d.this.GU();
            }
        });
        this.hjx.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.GU();
            }
        });
        this.hjx.setCancelable(false);
        this.hjx.setCanceledOnTouchOutside(false);
        this.hjx.setTitleShowCenter(true);
        this.hjx.setMessageShowCenter(true);
        this.hjx.isShowTitleAndMessage();
        this.hjx.create(this.mPageContext);
        this.hjx.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.hjx = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hjx.setAutoNight(false);
        this.hjx.setMessage(string);
        this.hjx.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hjx.setCancelable(false);
        this.hjx.setCanceledOnTouchOutside(false);
        this.hjx.isShowTitleAndMessage();
        this.hjx.create(this.mPageContext);
        this.hjx.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.hjw = null;
        this.hjx = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU() {
        if (this.hjx != null) {
            this.hjx.dismiss();
            this.hjx = null;
        }
        this.hjw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hgd != null) {
            this.hgd.a(i, str, i2, obj);
        }
    }

    public void h(long j, boolean z) {
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
        cVar.ap(j2);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void cdK() {
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

    public void vR(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void t(long j, long j2) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c();
        cVar.setLiveId(j);
        cVar.ap(j2);
        cVar.setParams();
        sendMessage(cVar);
    }

    public ao cdL() {
        return this.hjl;
    }

    public w GH() {
        return this.aEc;
    }

    public au cdh() {
        return this.hix;
    }

    public List<AlaLiveInfoData> cdM() {
        return this.hjm;
    }

    public q bOQ() {
        return this.gqS;
    }

    public void ct(List<Long> list) {
        if (!this.hjD) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
                com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
                if (this.aEc != null && this.aEc.mLiveInfo != null) {
                    aVar.setAudienceCount(this.aEc.mLiveInfo.audience_count);
                }
                aVar.setListIds(list);
                aVar.setParams();
                sendMessage(aVar);
            }
        }
    }

    public void cdN() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hjm) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        ct(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar) {
        if (tVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.hjm.size() == 1 && this.hjm.get(0).live_id == this.aEc.mLiveInfo.live_id) {
                    if (c(tVar) != null) {
                        this.hjm.clear();
                    }
                    b(tVar);
                    return;
                }
                b(tVar);
                return;
            }
            b(tVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(t tVar) {
        boolean z;
        for (s sVar : tVar.aIt) {
            if (sVar != null && sVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hjm) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == sVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hjm.add(sVar.mLiveInfo);
                }
            }
        }
        if (this.hjm.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hjm.size() - 200; size < this.hjm.size(); size++) {
                arrayList.add(this.hjm.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hjm.clear();
                this.hjm.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(t tVar) {
        if (ListUtils.isEmpty(tVar.aIt)) {
            return null;
        }
        for (s sVar : tVar.aIt) {
            if (sVar != null && sVar.mLiveInfo != null && sVar.mLiveInfo.live_id == this.aEc.mLiveInfo.live_id) {
                return sVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cdO() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hjm)) {
            return null;
        }
        if (this.hjy.isEmpty()) {
            arrayList.addAll(this.hjm);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hjm.size()) {
                    break;
                }
                if ((this.aEc == null || this.aEc.mLiveInfo == null || this.aEc.mLiveInfo.live_id != this.hjm.get(i2).live_id) && !this.hjy.contains(Long.valueOf(this.hjm.get(i2).live_id))) {
                    arrayList.add(this.hjm.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hjy.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hjy.size() >= this.hjm.size() - 4) {
                nw(false);
            }
        }
    }

    public void vS(int i) {
        this.hjt = i;
    }

    public void nw(boolean z) {
        if (!this.hjD) {
            if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.MY().MW()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hjz > 500) {
                    this.hjz = currentTimeMillis;
                    com.baidu.live.liveroom.c.d.MY().Na().a("tieba", this.hjn, 20, this.hjU);
                    return;
                }
                return;
            }
            nx(z);
        }
    }

    private void nx(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hjB >= 1800000) {
                this.hjA = currentTimeMillis;
                this.hjC = true;
            }
            if (this.hjC) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hjn);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hjA);
                httpMessage.setTag(this.hjg);
                sendMessage(httpMessage);
                this.hjB = currentTimeMillis;
            }
        }
    }

    public void ey(String str, String str2) {
        this.hjj.bT(true);
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
        aVar.AM(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.HV("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        cdZ();
    }

    public void aq(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.AM(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        cdZ();
    }

    public void HW(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        cdZ();
    }

    public void eD(long j) {
        this.hjj.bT(false);
        this.hjz = 0L;
        this.hju = null;
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
        if (!cdP()) {
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
            httpMessage.addParam("is_prettify", bk.b(com.baidu.live.z.a.Pq().bsy) ? 1 : 2);
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

    private boolean cdP() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void cdQ() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aEc == null) {
            this.aEc = new w(alaLiveInfoCoreData);
            this.hjj.setAlaLiveShowData(this.aEc);
        }
        this.mLastLiveId = this.aEc.mLiveInfo.live_id;
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
        if (this.aEc == null) {
            this.aEc = new w();
        }
        this.aEc.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aEc.aIe = alaLivePersonData.mUserData;
        this.aEc.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aEc.aIe != null && this.hjj != null) {
            this.hjj.Q(this.aEc.aIe.live_mark_info_new);
        }
        this.aEc.isHost = true;
        this.aEc.aIM = true;
        if (this.hjj != null) {
            this.hjj.setAlaLiveShowData(this.aEc);
        }
        cdX();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aEc));
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
        this.hjh.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hjT);
        MessageManager.getInstance().removeMessageRule(this.hjv);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.hjj.bT(true);
        this.hjk = null;
        this.mPageContext = null;
    }

    public void vT(int i) {
        this.hjo = i;
        if (this.hjm.size() == 0) {
            this.hjo = 0;
        } else if (this.hjo < 0) {
            this.hjo = this.hjm.size() + this.hjo;
        } else {
            this.hjo %= this.hjm.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hjm.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hjm.size()) {
                    if (this.hjm.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hjo = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cdR() {
        long j;
        if (this.aEc == null || this.aEc.mLiveInfo == null || this.hjm.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hjm.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aEc.mLiveInfo.live_id;
    }

    public boolean cdS() {
        long j;
        if (this.aEc == null || this.aEc.mLiveInfo == null || this.hjm.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hjm.get(this.hjm.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aEc.mLiveInfo.live_id;
    }

    public int cdT() {
        return this.hjo;
    }

    public int cdU() {
        return this.hjq;
    }

    public boolean cdV() {
        return this.hjr == 1;
    }

    public AlaLiveInfoData cdW() {
        if (this.hjo >= this.hjm.size()) {
            this.hjo = this.hjm.size() - 1;
        }
        if (this.hjo < 0) {
            this.hjo = 0;
        }
        if (this.hjm.size() <= this.hjo) {
            if (this.aEc != null) {
                return this.aEc.mLiveInfo;
            }
            return null;
        }
        return this.hjm.get(this.hjo);
    }

    public void a(a aVar) {
        this.hgd = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.hjk != null) {
            this.hjk.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void s(com.baidu.live.im.data.a aVar) {
        if (this.aEc != null && this.aEc.mLiveInfo.live_type == 1) {
            F(aVar);
        }
        if (this.hjk != null) {
            this.hjk.s(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void F(com.baidu.live.im.data.a aVar) {
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
            nw(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void KL() {
        if (this.hjk != null) {
            this.hjk.KL();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aEc);
        if (this.aEc != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aEc.aIe;
            } else {
                alaLiveUserInfoData = this.aEc.aIA;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aEc.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aEc != null && this.aEc.aIA != null && this.aEc.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aEc.aIA.throneUid;
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
                this.hjj.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void cdX() {
        this.hjj.e(String.valueOf(this.aEc.mLiveInfo.getGroupID()), String.valueOf(this.aEc.mLiveInfo.getLastMsgID()), String.valueOf(this.aEc.mLiveInfo.getUserID()), String.valueOf(this.aEc.mLiveInfo.getLiveID()), this.aEc.mLiveInfo.appId);
    }

    public com.baidu.live.im.d cdY() {
        return this.hjj;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void cdZ() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aEc != null) {
            try {
                if (this.aEc.mLiveSdkInfo != null && this.aEc.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put("chat_mcast_id", this.aEc.mLiveSdkInfo.mCastIds.chatMCastId);
                    jSONObject2.put("ensure_mcast_id", this.aEc.mLiveSdkInfo.mCastIds.ensureMCastId);
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

    public String cea() {
        return this.hju;
    }

    public void Ht(String str) {
        this.hju = str;
    }

    public void HX(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                this.mType = new JSONObject(str).optString(AlaLastLiveroomInfo.KEY_LAST_FROM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
