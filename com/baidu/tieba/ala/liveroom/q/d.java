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
import com.baidu.live.data.ap;
import com.baidu.live.data.aw;
import com.baidu.live.data.bl;
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
    private w aDh;
    private HttpMessageListener gTQ;
    private CustomMessageListener guJ;
    private q gwn;
    private a hlF;
    private aw hnV;
    private BdUniqueId hoE;
    private Handler hoF;
    private HttpMessage hoG;
    private final com.baidu.live.im.d hoH;
    private d.a hoI;
    private ap hoJ;
    private List<AlaLiveInfoData> hoK;
    private int hoL;
    private int hoM;
    private boolean hoN;
    private int hoO;
    private int hoP;
    private int hoQ;
    private int hoR;
    private String hoS;
    private com.baidu.live.y.a hoT;
    private AlaGetVerifyStrategyResponseHttpMessage hoU;
    private BdAlertDialog hoV;
    private Set<Long> hoW;
    private long hoX;
    private long hoY;
    private long hoZ;
    private long hoy;
    private boolean hpa;
    private boolean hpb;
    private HttpMessageListener hpc;
    private HttpMessageListener hpd;
    private HttpMessageListener hpe;
    private HttpMessageListener hpf;
    private NetMessageListener hpg;
    private HttpMessageListener hph;
    private NetMessageListener hpi;
    private HttpMessageListener hpj;
    private HttpMessageListener hpk;
    private NetMessageListener hpl;
    private NetMessageListener hpm;
    private HttpMessageListener hpn;
    private CustomMessageListener hpo;
    private HttpMessageListener hpp;
    private HttpMessageListener hpq;
    private HttpMessageListener hpr;
    private com.baidu.live.liveroom.c.a hps;
    private CustomMessageTask.CustomRunnable hpt;
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
        this.hoF = new Handler();
        this.hoL = 0;
        this.hoM = 0;
        this.hoN = true;
        this.hoO = 1;
        this.hoP = 0;
        this.hoQ = -1;
        this.hoR = 0;
        this.hoT = new com.baidu.live.y.a(0);
        this.otherParams = "";
        this.hoY = System.currentTimeMillis();
        this.hoZ = 0L;
        this.hpa = true;
        this.hpb = false;
        this.guJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.q.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aDh != null && d.this.aDh.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aDh.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.hoQ = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aDh.mLiveInfo.user_id).param("obj_param1", d.this.aDh.mLiveInfo.live_id).param("tid", d.this.aDh.mLiveInfo.thread_id));
                            d.this.hoQ = 1;
                        }
                        if (d.this.aDh != null && d.this.aDh.aHm != null) {
                            d.this.aDh.aHm.follow_status = d.this.hoQ;
                        }
                    }
                }
            }
        };
        this.hpc = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.q.d.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.bmu == 1 && alaUserAuthenVerifyInfoResponseMessage.bmt != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.bmt.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.bmt.verify_video_status == 1) {
                            d.this.hoO = 4;
                        }
                    }
                }
            }
        };
        this.hpd = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.q.d.28
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
                    d.this.hoP = alaGetVerifyStrategyResponseHttpMessage.hoe;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hoa);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hoc);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hof);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hoc != 1 || alaGetVerifyStrategyResponseHttpMessage.hoa != 1 || alaGetVerifyStrategyResponseHttpMessage.hof != 1 || alaGetVerifyStrategyResponseHttpMessage.hoh != 1) {
                            d.this.hoU = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hof != 1) {
                                d.this.hoF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cfA();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hoc != 1 || alaGetVerifyStrategyResponseHttpMessage.hoa != 1) {
                                d.this.hoF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ex(alaGetVerifyStrategyResponseHttpMessage.hoi, alaGetVerifyStrategyResponseHttpMessage.hoj);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hoh != 1) {
                                d.this.hoF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cfD();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.hoU = null;
                    }
                }
            }
        };
        this.hpe = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.q.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.hpf = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.q.d.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cfj;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.cfh() == 1 || masterIdentityResponseMessage.cfi() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cfj())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cfj());
                            jSONObject.put("content_type", "custom_master_identity");
                            cfj = jSONObject.toString();
                        } catch (JSONException e) {
                            cfj = masterIdentityResponseMessage.cfj();
                            e.printStackTrace();
                        }
                        d.this.hoH.a(27, cfj, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.hpg = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.q.d.31
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.hph = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.q.d.32
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.hoN = false;
                }
            }
        };
        this.hpi = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.q.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aDh = alaEnterLiveHttpResonseMessage.Gz();
                        d.this.hnV = alaEnterLiveHttpResonseMessage.cfb();
                        d.this.hoH.setAlaLiveShowData(d.this.aDh);
                    }
                    if (d.this.aDh != null && d.this.aDh.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.cgJ().fb(d.this.aDh.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aDh.mLiveInfo.live_id);
                    }
                    if (d.this.aDh != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aDh.aHG != null) {
                            if (d.this.aDh.aHG.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aDh.aHG.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aDh.aHG.nickName);
                            if (!TextUtils.isEmpty(d.this.aDh.aHG.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aDh.aHG.portrait);
                            }
                        }
                        if (d.this.aDh.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aDh.mLiveSdkInfo.tbs);
                            com.baidu.live.d.Aq().putString("ala_account_user_tbs", d.this.aDh.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aDh != null) {
                        if (d.this.hoK.size() <= 0) {
                            d.this.hoK.add(d.this.aDh.mLiveInfo);
                            d.this.hoW.add(Long.valueOf(d.this.aDh.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aDh.mLiveInfo);
                        if (d.this.hoH != null) {
                            d.this.hoH.Q(d.this.aDh.aHP);
                        }
                    }
                    if (d.this.aDh != null && d.this.aDh.aHm != null) {
                        d.this.hoQ = d.this.aDh.aHm.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aDh);
                    if (d.this.aDh != null && d.this.aDh.mLiveInfo != null) {
                        d.this.cfR();
                    }
                    if (d.this.aDh != null) {
                        d.this.aDh.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aDh));
                        com.baidu.live.im.b.d.Lx().U(d.this.aDh.aHP);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aDh != null && d.this.aDh.mLiveInfo != null) {
                            long j2 = d.this.aDh.mLiveInfo.live_id;
                            long j3 = d.this.aDh.mLiveInfo.room_id;
                            String str = d.this.aDh.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aDh.aHk != null) {
                                long j4 = d.this.aDh.aHk.userId;
                                str2 = d.this.aDh.aHk.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && d.this.aDh != null && d.this.aDh.mLiveInfo != null) {
                        long j5 = d.this.aDh.mLiveInfo.live_id;
                        long j6 = d.this.aDh.mLiveInfo.room_id;
                        String str3 = d.this.aDh.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aDh.aHk != null) {
                            j = d.this.aDh.aHk.userId;
                            str4 = d.this.aDh.aHk.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.hoM + "");
                    }
                    if (d.this.aDh != null && d.this.aDh.mLiveInfo != null) {
                        if (!com.baidu.tieba.ala.liveroom.performancewatchtask.b.cgg().cgf()) {
                            try {
                                if (d.this.aDh.mLiveInfo.isPubShow && TbadkCoreApplication.getCurrentAccount() != null) {
                                    com.baidu.live.view.a.VO().iG(String.valueOf(d.this.aDh.mLiveInfo.user_id));
                                    com.baidu.tieba.ala.liveroom.performancewatchtask.b.cgg().a(d.this.mPageContext, d.this.aDh.mLiveInfo.live_id, Long.parseLong(TbadkCoreApplication.getCurrentAccount()), d.this.aDh.mLiveInfo, d.this.mType);
                                }
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                        com.baidu.tieba.ala.liveroom.performancewatchtask.b.cgg().nI(false);
                    }
                }
            }
        };
        this.hpj = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.q.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    q qVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        qVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bQJ();
                    }
                    if (qVar != null) {
                        d.this.gwn = qVar;
                    }
                    if (d.this.aDh != null && d.this.aDh.aHm != null) {
                        if (d.this.hoQ == -1) {
                            d.this.hoQ = d.this.aDh.aHm.follow_status;
                        }
                        if (d.this.aDh.aHm.follow_status != d.this.hoQ) {
                            d.this.aDh.aHm.follow_status = d.this.hoQ;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.gwn);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.gwn));
                }
            }
        };
        this.hpk = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.q.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cfg = alaUserLiveMarkInfoResponseMessage.cfg();
                        d.this.hoH.Q(cfg);
                        if (d.this.aDh != null) {
                            d.this.aDh.aHP = cfg;
                            com.baidu.live.im.b.d.Lx().U(d.this.aDh.aHP);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aDh));
                        }
                    }
                }
            }
        };
        this.hpl = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.q.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    w Gz = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).Gz() : null;
                    d.this.hoy = System.currentTimeMillis();
                    if (Gz == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, Gz);
                        return;
                    }
                    if (d.this.aDh == null) {
                        d.this.aDh = Gz;
                        d.this.hoH.setAlaLiveShowData(d.this.aDh);
                    } else if (d.this.aDh.mLiveInfo != null && Gz.mLiveInfo != null && d.this.aDh.mLiveInfo.live_id != Gz.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aDh);
                        return;
                    }
                    if (d.this.aDh.mLiveInfo != null && Gz.mLiveInfo != null && d.this.aDh.mLiveInfo.user_id == Gz.mLiveInfo.user_id) {
                        if (d.this.aDh.mLiveInfo.imEffect != null && Gz.mLiveInfo.imEffect == null) {
                            Gz.mLiveInfo.imEffect = d.this.aDh.mLiveInfo.imEffect;
                        }
                        if (d.this.aDh.mLiveInfo.mLiveCloseData != null && Gz.mLiveInfo.mLiveCloseData == null) {
                            Gz.mLiveInfo.mLiveCloseData = d.this.aDh.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aDh.mLiveInfo.mAlaLiveSwitchData != null && Gz.mLiveInfo.mAlaLiveSwitchData == null) {
                            Gz.mLiveInfo.mAlaLiveSwitchData = d.this.aDh.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aDh.mLiveInfo = Gz.mLiveInfo;
                    d.this.aDh.serverTime = Gz.serverTime;
                    d.this.aDh.aIb = Gz.aIb;
                    if (Gz.aHk != null && Gz.aHk.userId != 0) {
                        d.this.aDh.aHk = Gz.aHk;
                    }
                    d.this.aDh.aHl = Gz.aHl;
                    d.this.aDh.aHp = Gz.aHp;
                    d.this.aDh.aHQ = Gz.aHQ;
                    d.this.aDh.aHO = Gz.aHO;
                    d.this.aDh.aHL = Gz.aHL;
                    d.this.aDh.aHM = Gz.aHM;
                    d.this.aDh.aHN = Gz.aHN;
                    if (Gz.aHI != null) {
                        d.this.aDh.aHI = Gz.aHI;
                    }
                    d.this.aDh.aIi = Gz.aIi;
                    if (Gz.aHT != null && Gz.aHT.aMd != null && !Gz.aHT.aMd.isEmpty()) {
                        d.this.aDh.aHT = Gz.aHT;
                    }
                    if (Gz.aHG != null) {
                        if (Gz.aHG.userId == 0) {
                            if (d.this.aDh.aHG == null) {
                                d.this.aDh.aHG = new AlaLiveUserInfoData();
                            }
                            d.this.aDh.aHG.throneUid = Gz.aHG.throneUid;
                        } else {
                            boolean z = Gz.aHG.isNewUser;
                            if (d.this.aDh.aHG != null) {
                                z = d.this.aDh.aHG.isNewUser;
                            }
                            Gz.aHG.isNewUser = z;
                            d.this.aDh.aHG = Gz.aHG;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aDh.aHG.nickName);
                        }
                    }
                    if (Gz.aHK != null) {
                        d.this.aDh.aHK = Gz.aHK;
                    }
                    if (Gz.aHO) {
                        d.this.aDh.aHP = Gz.aHP;
                        if (d.this.hoH != null) {
                            d.this.hoH.Q(Gz.aHP);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aDh.mLiveInfo != null) {
                        int i = d.this.aDh.mLiveInfo.backstage_type;
                        if (d.this.hoH != null) {
                            d.this.hoH.hA(String.valueOf(i));
                        }
                    }
                    if (d.this.hoH != null) {
                        d.this.hoH.setAlaLiveShowData(d.this.aDh);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aDh);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aDh));
                    if (d.this.aDh != null) {
                        com.baidu.live.im.b.d.Lx().U(d.this.aDh.aHP);
                    }
                }
            }
        };
        this.hpm = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.q.d.6
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
                    if (list != null && list.size() > 0 && d.this.hoK != null && d.this.hoK.size() > 0) {
                        for (int size = d.this.hoK.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.hoK.get(size)).live_id != d.this.aDh.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.hoK.get(size)).getLiveID()))) {
                                d.this.hoK.remove(size);
                            }
                        }
                    }
                    if (d.this.aDh != null) {
                        d.this.h(d.this.aDh.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.gTQ = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.q.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.hpn = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.q.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.hoG = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.hoJ = alaUpdateLiveTbResponseMessage.cff();
                    if (d.this.hoJ != null) {
                        if (d.this.hoJ.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hoJ.aMi);
                                jSONObject2.put("user_verify", d.this.hoJ.aMk);
                                jSONObject2.put("certify", d.this.hoJ.aMm);
                                if (d.this.hoJ.mLiveSdkInfo != null && d.this.hoJ.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, d.this.hoJ.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hoJ.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hoJ.aMi != 1 || d.this.hoJ.aMk != 1) {
                            d.this.hoF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cfB();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.hoJ.aHk != null) {
                            d.this.hoH.Q(d.this.hoJ.aHk.live_mark_info_new);
                        }
                        if (d.this.hoJ.mErrorCode != 0) {
                            if (d.this.hoJ.mErrorCode == 220012) {
                                d.this.b(d.this.hoJ.mErrorCode, d.this.hoJ.mErrorMsg, 6, d.this.aDh);
                                return;
                            }
                        } else {
                            d.this.aDh = new w();
                            d.this.hoH.setAlaLiveShowData(d.this.aDh);
                            d.this.aDh.mLiveInfo = d.this.hoJ.mLiveInfo;
                            d.this.aDh.aHk = d.this.hoJ.aHk;
                            d.this.aDh.mLiveSdkInfo = d.this.hoJ.mLiveSdkInfo;
                            d.this.aDh.aHR = d.this.hoJ.aHR;
                            d.this.aDh.aHP = d.this.hoJ.aHk.live_mark_info_new;
                            d.this.aDh.aHM = d.this.hoJ.aHM;
                            if (d.this.hoJ.aHk != null && d.this.hoJ.aHk.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.hoJ.aHk.levelId);
                            }
                            d.this.aDh.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aDh));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aDh);
                    if (d.this.hoJ != null && d.this.hoJ.mLiveInfo != null) {
                        d.this.cfR();
                    }
                    if (d.this.aDh != null && d.this.aDh.mLiveInfo != null) {
                        d.this.t(d.this.aDh.mLiveInfo.user_id, d.this.aDh.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.hpo = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.q.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.hoH.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.hpp = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.q.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.o.b)) {
                    com.baidu.live.o.b bVar = (com.baidu.live.o.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.boh != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.boh.hI(bVar.contentType);
                        } else {
                            bVar.boh.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hpq = new HttpMessageListener(1021125) { // from class: com.baidu.tieba.ala.liveroom.q.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetUserInfoHttpResponseMessage)) {
                    GetUserInfoHttpResponseMessage getUserInfoHttpResponseMessage = (GetUserInfoHttpResponseMessage) httpResponsedMessage;
                    if (d.this.aDh != null && d.this.aDh.aHG != null && getUserInfoHttpResponseMessage.userId == d.this.aDh.aHG.userId && !TextUtils.isEmpty(getUserInfoHttpResponseMessage.userName)) {
                        d.this.aDh.aHG.nickName = getUserInfoHttpResponseMessage.userName;
                    }
                }
            }
        };
        this.hpr = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.q.d.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                t tVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        tVar = null;
                    } else {
                        tVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).cfd();
                    }
                    if (tVar != null && !ListUtils.isEmpty(tVar.aHz)) {
                        d.this.hpa = tVar.aHy;
                        d.this.hoL = tVar.pn + 1;
                        s sVar = tVar.aHz.get(tVar.aHz.size() - 1);
                        if (sVar != null) {
                            d.this.mLastLiveId = sVar.mLiveInfo.live_id;
                        }
                        d.this.a(tVar);
                        if (d.this.aDh != null) {
                            d.this.h(d.this.aDh.mLiveInfo);
                        }
                        d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, tVar);
                    }
                }
            }
        };
        this.hps = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.q.d.25
        };
        this.hpt = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.hoy));
            }
        };
        this.mPageContext = bdPageContext;
        this.hoH = new com.baidu.live.im.d(bdPageContext, false, this);
        this.hoK = new ArrayList();
        this.hoW = new HashSet();
        initTasks();
        registerListener(this.hpl);
        registerListener(this.hpj);
        registerListener(this.hpi);
        registerListener(this.hpg);
        this.hoE = BdUniqueId.gen();
        this.hpr.setTag(this.hoE);
        registerListener(this.hpr);
        registerListener(this.hpm);
        registerListener(this.hph);
        registerListener(this.hpn);
        registerListener(this.gTQ);
        registerListener(this.hpd);
        registerListener(this.hpe);
        registerListener(this.hpc);
        registerListener(this.guJ);
        registerListener(this.hpk);
        registerListener(this.hpf);
        registerListener(this.hpo);
        registerListener(this.hpp);
        registerListener(this.hpq);
        MessageManager.getInstance().addMessageRule(this.hoT);
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
        this.hoy = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.hpt);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        cfo();
        cfp();
        cfq();
        cfr();
        cfu();
        cfv();
    }

    public void setIsMixLive(boolean z) {
        this.hpb = z;
    }

    private void cfo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cfp() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void cfq() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void cfr() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void cfs() {
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

    public void cft() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void cfu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cfv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cfw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.o.b) && d.this.aDh != null && d.this.aDh.mLiveInfo != null) {
                    com.baidu.live.o.b bVar = (com.baidu.live.o.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aDh.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.bog != null) {
                        httpMessage.addParam("ext_data", bVar.bog.toString());
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

    public void cfx() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void t(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cfy() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    public void ew(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void cfz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void cfA() {
        if (this.hoV != null) {
            this.hoV.dismiss();
            this.hoV = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_auth);
        this.hoV = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hoV.setAutoNight(false);
        this.hoV.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hoV.setPositiveButton(this.mPageContext.getString(a.h.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cfz();
                    d.this.GM();
                }
            });
            this.hoV.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GM();
                }
            });
        } else {
            this.hoV.setPositiveButton(this.mPageContext.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GM();
                }
            });
        }
        this.hoV.setCancelable(false);
        this.hoV.setCanceledOnTouchOutside(false);
        this.hoV.setTitleShowCenter(true);
        this.hoV.setMessageShowCenter(true);
        this.hoV.isShowTitleAndMessage();
        this.hoV.create(this.mPageContext);
        this.hoV.show();
    }

    public void ex(String str, String str2) {
        if (this.hoV != null) {
            this.hoV.dismiss();
            this.hoV = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_permission);
        this.hoV = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hoV.setAutoNight(false);
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.hoV.setTitle(str);
        } else if (StringUtils.isNull(str2)) {
            str2 = string;
        }
        this.hoV.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hoV.setPositiveButton(this.mPageContext.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GM();
                }
            });
        } else {
            this.hoV.setPositiveButton(this.mPageContext.getString(a.h.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.aa.a.Ph().bms.aKW;
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
                    d.this.GM();
                }
            });
            this.hoV.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.GM();
                }
            });
        }
        this.hoV.setCancelable(false);
        this.hoV.setCanceledOnTouchOutside(false);
        this.hoV.setTitleShowCenter(true);
        this.hoV.setMessageShowCenter(true);
        this.hoV.isShowTitleAndMessage();
        this.hoV.create(this.mPageContext);
        this.hoV.show();
    }

    public void cfB() {
        if (this.hoV != null) {
            this.hoV.dismiss();
            this.hoV = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_permission_tip);
        this.hoV = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hoV.setAutoNight(false);
        this.hoV.setMessage(string);
        this.hoV.setPositiveButton(this.mPageContext.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hoV.setCancelable(false);
        this.hoV.setCanceledOnTouchOutside(false);
        this.hoV.isShowTitleAndMessage();
        this.hoV.create(this.mPageContext);
        this.hoV.show();
    }

    public void cfC() {
        if (this.hoV != null) {
            this.hoV.dismiss();
            this.hoV = null;
        }
        if (this.hoU != null) {
            a(this.hoU);
        }
    }

    public void cfD() {
        if (this.hoV != null) {
            this.hoV.dismiss();
            this.hoV = null;
        }
        String string = this.mPageContext.getString(a.h.dialog_msg_to_user_info);
        this.hoV = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hoV.setAutoNight(false);
        this.hoV.setMessage(string);
        this.hoV.setPositiveButton(this.mPageContext.getString(a.h.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.20
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
                d.this.GM();
            }
        });
        this.hoV.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.GM();
            }
        });
        this.hoV.setCancelable(false);
        this.hoV.setCanceledOnTouchOutside(false);
        this.hoV.setTitleShowCenter(true);
        this.hoV.setMessageShowCenter(true);
        this.hoV.isShowTitleAndMessage();
        this.hoV.create(this.mPageContext);
        this.hoV.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.h.ala_live_no_permission_tip);
        this.hoV = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hoV.setAutoNight(false);
        this.hoV.setMessage(string);
        this.hoV.setPositiveButton(this.mPageContext.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hoV.setCancelable(false);
        this.hoV.setCanceledOnTouchOutside(false);
        this.hoV.isShowTitleAndMessage();
        this.hoV.create(this.mPageContext);
        this.hoV.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.hoU = null;
        this.hoV = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM() {
        if (this.hoV != null) {
            this.hoV.dismiss();
            this.hoV = null;
        }
        this.hoU = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hlF != null) {
            this.hlF.a(i, str, i2, obj);
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
        cVar.aB(j2);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void cfE() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public void v(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021077);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("net_status", i);
        sendMessage(httpMessage);
    }

    public void wC(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void u(long j, long j2) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c();
        cVar.setLiveId(j);
        cVar.aB(j2);
        cVar.setParams();
        sendMessage(cVar);
    }

    public ap cfF() {
        return this.hoJ;
    }

    public w Gz() {
        return this.aDh;
    }

    public aw cfb() {
        return this.hnV;
    }

    public List<AlaLiveInfoData> cfG() {
        return this.hoK;
    }

    public q bQJ() {
        return this.gwn;
    }

    public void cB(List<Long> list) {
        if (!this.hpb) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
                com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
                if (this.aDh != null && this.aDh.mLiveInfo != null) {
                    aVar.setAudienceCount(this.aDh.mLiveInfo.audience_count);
                }
                aVar.setListIds(list);
                aVar.setParams();
                sendMessage(aVar);
            }
        }
    }

    public void cfH() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hoK) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cB(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar) {
        if (tVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.hoK.size() == 1 && this.hoK.get(0).live_id == this.aDh.mLiveInfo.live_id) {
                    if (c(tVar) != null) {
                        this.hoK.clear();
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
        for (s sVar : tVar.aHz) {
            if (sVar != null && sVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hoK) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == sVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hoK.add(sVar.mLiveInfo);
                }
            }
        }
        if (this.hoK.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hoK.size() - 200; size < this.hoK.size(); size++) {
                arrayList.add(this.hoK.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hoK.clear();
                this.hoK.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(t tVar) {
        if (ListUtils.isEmpty(tVar.aHz)) {
            return null;
        }
        for (s sVar : tVar.aHz) {
            if (sVar != null && sVar.mLiveInfo != null && sVar.mLiveInfo.live_id == this.aDh.mLiveInfo.live_id) {
                return sVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cfI() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hoK)) {
            return null;
        }
        if (this.hoW.isEmpty()) {
            arrayList.addAll(this.hoK);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hoK.size()) {
                    break;
                }
                if ((this.aDh == null || this.aDh.mLiveInfo == null || this.aDh.mLiveInfo.live_id != this.hoK.get(i2).live_id) && !this.hoW.contains(Long.valueOf(this.hoK.get(i2).live_id))) {
                    arrayList.add(this.hoK.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hoW.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hoW.size() >= this.hoK.size() - 4) {
                nG(false);
            }
        }
    }

    public void wD(int i) {
        this.hoR = i;
    }

    public void nG(boolean z) {
        if (!this.hpb) {
            if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.MP().MN()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hoX > 500) {
                    this.hoX = currentTimeMillis;
                    com.baidu.live.liveroom.c.d.MP().MR().a("tieba", this.hoL, 20, this.hps);
                    return;
                }
                return;
            }
            nH(z);
        }
    }

    private void nH(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hoZ >= 1800000) {
                this.hoY = currentTimeMillis;
                this.hpa = true;
            }
            if (this.hpa) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hoL);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hoY);
                httpMessage.setTag(this.hoE);
                sendMessage(httpMessage);
                this.hoZ = currentTimeMillis;
            }
        }
    }

    public void ey(String str, String str2) {
        this.hoH.bW(true);
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
        aVar.Av(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.HN("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        cfT();
    }

    public void ar(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.Av(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        cfT();
    }

    public void HO(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        cfT();
    }

    public void eZ(long j) {
        this.hoH.bW(false);
        this.hoX = 0L;
        this.hoS = null;
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
        if (!cfJ()) {
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
            httpMessage.addParam("is_prettify", bl.b(com.baidu.live.aa.a.Ph().bsh) ? 1 : 2);
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

    private boolean cfJ() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void cfK() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aDh == null) {
            this.aDh = new w(alaLiveInfoCoreData);
            this.hoH.setAlaLiveShowData(this.aDh);
        }
        this.mLastLiveId = this.aDh.mLiveInfo.live_id;
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
        if (this.aDh == null) {
            this.aDh = new w();
        }
        this.aDh.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aDh.aHk = alaLivePersonData.mUserData;
        this.aDh.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aDh.aHk != null && this.hoH != null) {
            this.hoH.Q(this.aDh.aHk.live_mark_info_new);
        }
        this.aDh.isHost = true;
        this.aDh.aHS = true;
        if (this.hoH != null) {
            this.hoH.setAlaLiveShowData(this.aDh);
        }
        cfR();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aDh));
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
        this.hoF.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hpr);
        MessageManager.getInstance().removeMessageRule(this.hoT);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.hoH.bW(true);
        this.hoI = null;
        this.mPageContext = null;
    }

    public void wE(int i) {
        this.hoM = i;
        if (this.hoK.size() == 0) {
            this.hoM = 0;
        } else if (this.hoM < 0) {
            this.hoM = this.hoK.size() + this.hoM;
        } else {
            this.hoM %= this.hoK.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hoK.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hoK.size()) {
                    if (this.hoK.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hoM = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cfL() {
        long j;
        if (this.aDh == null || this.aDh.mLiveInfo == null || this.hoK.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hoK.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDh.mLiveInfo.live_id;
    }

    public boolean cfM() {
        long j;
        if (this.aDh == null || this.aDh.mLiveInfo == null || this.hoK.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hoK.get(this.hoK.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDh.mLiveInfo.live_id;
    }

    public int cfN() {
        return this.hoM;
    }

    public int cfO() {
        return this.hoO;
    }

    public boolean cfP() {
        return this.hoP == 1;
    }

    public AlaLiveInfoData cfQ() {
        if (this.hoM >= this.hoK.size()) {
            this.hoM = this.hoK.size() - 1;
        }
        if (this.hoM < 0) {
            this.hoM = 0;
        }
        if (this.hoK.size() <= this.hoM) {
            if (this.aDh != null) {
                return this.aDh.mLiveInfo;
            }
            return null;
        }
        return this.hoK.get(this.hoM);
    }

    public void a(a aVar) {
        this.hlF = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.hoI != null) {
            this.hoI.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void t(com.baidu.live.im.data.a aVar) {
        if (this.aDh != null && this.aDh.mLiveInfo.live_type == 1) {
            I(aVar);
        }
        if (this.hoI != null) {
            this.hoI.t(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void I(com.baidu.live.im.data.a aVar) {
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
            nG(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void KC() {
        if (this.hoI != null) {
            this.hoI.KC();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aDh);
        if (this.aDh != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aDh.aHk;
            } else {
                alaLiveUserInfoData = this.aDh.aHG;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aDh.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aDh != null && this.aDh.aHG != null && this.aDh.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aDh.aHG.throneUid;
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
                this.hoH.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void cfR() {
        this.hoH.e(String.valueOf(this.aDh.mLiveInfo.getGroupID()), String.valueOf(this.aDh.mLiveInfo.getLastMsgID()), String.valueOf(this.aDh.mLiveInfo.getUserID()), String.valueOf(this.aDh.mLiveInfo.getLiveID()), this.aDh.mLiveInfo.appId);
    }

    public com.baidu.live.im.d cfS() {
        return this.hoH;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void cfT() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aDh != null) {
            try {
                if (this.aDh.mLiveSdkInfo != null && this.aDh.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, this.aDh.mLiveSdkInfo.mCastIds.chatMCastId);
                    jSONObject2.put("ensure_mcast_id", this.aDh.mLiveSdkInfo.mCastIds.ensureMCastId);
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

    public String cfU() {
        return this.hoS;
    }

    public void Hm(String str) {
        this.hoS = str;
    }

    public void HP(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                this.mType = new JSONObject(str).optString(AlaLastLiveroomInfo.KEY_LAST_FROM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
