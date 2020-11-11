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
    private w aES;
    private HttpMessageListener gUj;
    private CustomMessageListener gvc;
    private q gwG;
    private a hlY;
    private long hoR;
    private BdUniqueId hoX;
    private Handler hoY;
    private HttpMessage hoZ;
    private aw hoo;
    private HttpMessageListener hpA;
    private NetMessageListener hpB;
    private HttpMessageListener hpC;
    private HttpMessageListener hpD;
    private NetMessageListener hpE;
    private NetMessageListener hpF;
    private HttpMessageListener hpG;
    private CustomMessageListener hpH;
    private HttpMessageListener hpI;
    private HttpMessageListener hpJ;
    private HttpMessageListener hpK;
    private com.baidu.live.liveroom.c.a hpL;
    private CustomMessageTask.CustomRunnable hpM;
    private final com.baidu.live.im.d hpa;
    private d.a hpb;
    private ap hpc;
    private List<AlaLiveInfoData> hpd;
    private int hpe;
    private int hpf;
    private boolean hpg;
    private int hph;
    private int hpi;
    private int hpj;
    private int hpk;
    private String hpl;
    private com.baidu.live.y.a hpm;
    private AlaGetVerifyStrategyResponseHttpMessage hpn;
    private BdAlertDialog hpo;
    private Set<Long> hpp;
    private long hpq;
    private long hpr;
    private long hps;
    private boolean hpt;
    private boolean hpu;
    private HttpMessageListener hpv;
    private HttpMessageListener hpw;
    private HttpMessageListener hpx;
    private HttpMessageListener hpy;
    private NetMessageListener hpz;
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
        this.hoY = new Handler();
        this.hpe = 0;
        this.hpf = 0;
        this.hpg = true;
        this.hph = 1;
        this.hpi = 0;
        this.hpj = -1;
        this.hpk = 0;
        this.hpm = new com.baidu.live.y.a(0);
        this.otherParams = "";
        this.hpr = System.currentTimeMillis();
        this.hps = 0L;
        this.hpt = true;
        this.hpu = false;
        this.gvc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.q.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aES != null && d.this.aES.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aES.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.hpj = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aES.mLiveInfo.user_id).param("obj_param1", d.this.aES.mLiveInfo.live_id).param("tid", d.this.aES.mLiveInfo.thread_id));
                            d.this.hpj = 1;
                        }
                        if (d.this.aES != null && d.this.aES.aIX != null) {
                            d.this.aES.aIX.follow_status = d.this.hpj;
                        }
                    }
                }
            }
        };
        this.hpv = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.q.d.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.bof == 1 && alaUserAuthenVerifyInfoResponseMessage.boe != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.boe.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.boe.verify_video_status == 1) {
                            d.this.hph = 4;
                        }
                    }
                }
            }
        };
        this.hpw = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.q.d.28
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
                    d.this.hpi = alaGetVerifyStrategyResponseHttpMessage.hox;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hot);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hov);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hoy);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hov != 1 || alaGetVerifyStrategyResponseHttpMessage.hot != 1 || alaGetVerifyStrategyResponseHttpMessage.hoy != 1 || alaGetVerifyStrategyResponseHttpMessage.hoA != 1) {
                            d.this.hpn = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hoy != 1) {
                                d.this.hoY.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cgh();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hov != 1 || alaGetVerifyStrategyResponseHttpMessage.hot != 1) {
                                d.this.hoY.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ex(alaGetVerifyStrategyResponseHttpMessage.hoB, alaGetVerifyStrategyResponseHttpMessage.hoC);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hoA != 1) {
                                d.this.hoY.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cgk();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.hpn = null;
                    }
                }
            }
        };
        this.hpx = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.q.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.hpy = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.q.d.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cfQ;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.cfO() == 1 || masterIdentityResponseMessage.cfP() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cfQ())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cfQ());
                            jSONObject.put("content_type", "custom_master_identity");
                            cfQ = jSONObject.toString();
                        } catch (JSONException e) {
                            cfQ = masterIdentityResponseMessage.cfQ();
                            e.printStackTrace();
                        }
                        d.this.hpa.a(27, cfQ, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.hpz = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.q.d.31
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.hpA = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.q.d.32
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.hpg = false;
                }
            }
        };
        this.hpB = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.q.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aES = alaEnterLiveHttpResonseMessage.Hi();
                        d.this.hoo = alaEnterLiveHttpResonseMessage.cfI();
                        d.this.hpa.setAlaLiveShowData(d.this.aES);
                    }
                    if (d.this.aES != null && d.this.aES.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.chq().fb(d.this.aES.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aES.mLiveInfo.live_id);
                    }
                    if (d.this.aES != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aES.aJr != null) {
                            if (d.this.aES.aJr.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aES.aJr.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aES.aJr.nickName);
                            if (!TextUtils.isEmpty(d.this.aES.aJr.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aES.aJr.portrait);
                            }
                        }
                        if (d.this.aES.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aES.mLiveSdkInfo.tbs);
                            com.baidu.live.d.AZ().putString("ala_account_user_tbs", d.this.aES.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aES != null) {
                        if (d.this.hpd.size() <= 0) {
                            d.this.hpd.add(d.this.aES.mLiveInfo);
                            d.this.hpp.add(Long.valueOf(d.this.aES.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aES.mLiveInfo);
                        if (d.this.hpa != null) {
                            d.this.hpa.Q(d.this.aES.aJA);
                        }
                    }
                    if (d.this.aES != null && d.this.aES.aIX != null) {
                        d.this.hpj = d.this.aES.aIX.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aES);
                    if (d.this.aES != null && d.this.aES.mLiveInfo != null) {
                        d.this.cgy();
                    }
                    if (d.this.aES != null) {
                        d.this.aES.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aES));
                        com.baidu.live.im.b.d.Mg().U(d.this.aES.aJA);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aES != null && d.this.aES.mLiveInfo != null) {
                            long j2 = d.this.aES.mLiveInfo.live_id;
                            long j3 = d.this.aES.mLiveInfo.room_id;
                            String str = d.this.aES.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aES.aIV != null) {
                                long j4 = d.this.aES.aIV.userId;
                                str2 = d.this.aES.aIV.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && d.this.aES != null && d.this.aES.mLiveInfo != null) {
                        long j5 = d.this.aES.mLiveInfo.live_id;
                        long j6 = d.this.aES.mLiveInfo.room_id;
                        String str3 = d.this.aES.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aES.aIV != null) {
                            j = d.this.aES.aIV.userId;
                            str4 = d.this.aES.aIV.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.hpf + "");
                    }
                    if (d.this.aES != null && d.this.aES.mLiveInfo != null) {
                        if (!com.baidu.tieba.ala.liveroom.performancewatchtask.b.cgN().cgM()) {
                            try {
                                if (d.this.aES.mLiveInfo.isPubShow && TbadkCoreApplication.getCurrentAccount() != null) {
                                    com.baidu.live.view.a.Wx().iM(String.valueOf(d.this.aES.mLiveInfo.user_id));
                                    com.baidu.tieba.ala.liveroom.performancewatchtask.b.cgN().a(d.this.mPageContext, d.this.aES.mLiveInfo.live_id, Long.parseLong(TbadkCoreApplication.getCurrentAccount()), d.this.aES.mLiveInfo, d.this.mType);
                                }
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                        com.baidu.tieba.ala.liveroom.performancewatchtask.b.cgN().nH(false);
                    }
                }
            }
        };
        this.hpC = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.q.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    q qVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        qVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bRq();
                    }
                    if (qVar != null) {
                        d.this.gwG = qVar;
                    }
                    if (d.this.aES != null && d.this.aES.aIX != null) {
                        if (d.this.hpj == -1) {
                            d.this.hpj = d.this.aES.aIX.follow_status;
                        }
                        if (d.this.aES.aIX.follow_status != d.this.hpj) {
                            d.this.aES.aIX.follow_status = d.this.hpj;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.gwG);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.gwG));
                }
            }
        };
        this.hpD = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.q.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cfN = alaUserLiveMarkInfoResponseMessage.cfN();
                        d.this.hpa.Q(cfN);
                        if (d.this.aES != null) {
                            d.this.aES.aJA = cfN;
                            com.baidu.live.im.b.d.Mg().U(d.this.aES.aJA);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aES));
                        }
                    }
                }
            }
        };
        this.hpE = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.q.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    w Hi = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).Hi() : null;
                    d.this.hoR = System.currentTimeMillis();
                    if (Hi == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, Hi);
                        return;
                    }
                    if (d.this.aES == null) {
                        d.this.aES = Hi;
                        d.this.hpa.setAlaLiveShowData(d.this.aES);
                    } else if (d.this.aES.mLiveInfo != null && Hi.mLiveInfo != null && d.this.aES.mLiveInfo.live_id != Hi.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aES);
                        return;
                    }
                    if (d.this.aES.mLiveInfo != null && Hi.mLiveInfo != null && d.this.aES.mLiveInfo.user_id == Hi.mLiveInfo.user_id) {
                        if (d.this.aES.mLiveInfo.imEffect != null && Hi.mLiveInfo.imEffect == null) {
                            Hi.mLiveInfo.imEffect = d.this.aES.mLiveInfo.imEffect;
                        }
                        if (d.this.aES.mLiveInfo.mLiveCloseData != null && Hi.mLiveInfo.mLiveCloseData == null) {
                            Hi.mLiveInfo.mLiveCloseData = d.this.aES.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aES.mLiveInfo.mAlaLiveSwitchData != null && Hi.mLiveInfo.mAlaLiveSwitchData == null) {
                            Hi.mLiveInfo.mAlaLiveSwitchData = d.this.aES.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aES.mLiveInfo = Hi.mLiveInfo;
                    d.this.aES.serverTime = Hi.serverTime;
                    d.this.aES.aJM = Hi.aJM;
                    if (Hi.aIV != null && Hi.aIV.userId != 0) {
                        d.this.aES.aIV = Hi.aIV;
                    }
                    d.this.aES.aIW = Hi.aIW;
                    d.this.aES.aJa = Hi.aJa;
                    d.this.aES.aJB = Hi.aJB;
                    d.this.aES.aJz = Hi.aJz;
                    d.this.aES.aJw = Hi.aJw;
                    d.this.aES.aJx = Hi.aJx;
                    d.this.aES.aJy = Hi.aJy;
                    if (Hi.aJt != null) {
                        d.this.aES.aJt = Hi.aJt;
                    }
                    d.this.aES.aJT = Hi.aJT;
                    if (Hi.aJE != null && Hi.aJE.aNO != null && !Hi.aJE.aNO.isEmpty()) {
                        d.this.aES.aJE = Hi.aJE;
                    }
                    if (Hi.aJr != null) {
                        if (Hi.aJr.userId == 0) {
                            if (d.this.aES.aJr == null) {
                                d.this.aES.aJr = new AlaLiveUserInfoData();
                            }
                            d.this.aES.aJr.throneUid = Hi.aJr.throneUid;
                        } else {
                            boolean z = Hi.aJr.isNewUser;
                            if (d.this.aES.aJr != null) {
                                z = d.this.aES.aJr.isNewUser;
                            }
                            Hi.aJr.isNewUser = z;
                            d.this.aES.aJr = Hi.aJr;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aES.aJr.nickName);
                        }
                    }
                    if (Hi.aJv != null) {
                        d.this.aES.aJv = Hi.aJv;
                    }
                    if (Hi.aJz) {
                        d.this.aES.aJA = Hi.aJA;
                        if (d.this.hpa != null) {
                            d.this.hpa.Q(Hi.aJA);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aES.mLiveInfo != null) {
                        int i = d.this.aES.mLiveInfo.backstage_type;
                        if (d.this.hpa != null) {
                            d.this.hpa.hG(String.valueOf(i));
                        }
                    }
                    if (d.this.hpa != null) {
                        d.this.hpa.setAlaLiveShowData(d.this.aES);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aES);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aES));
                    if (d.this.aES != null) {
                        com.baidu.live.im.b.d.Mg().U(d.this.aES.aJA);
                    }
                }
            }
        };
        this.hpF = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.q.d.6
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
                    if (list != null && list.size() > 0 && d.this.hpd != null && d.this.hpd.size() > 0) {
                        for (int size = d.this.hpd.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.hpd.get(size)).live_id != d.this.aES.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.hpd.get(size)).getLiveID()))) {
                                d.this.hpd.remove(size);
                            }
                        }
                    }
                    if (d.this.aES != null) {
                        d.this.h(d.this.aES.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.gUj = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.q.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.hpG = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.q.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.hoZ = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.hpc = alaUpdateLiveTbResponseMessage.cfM();
                    if (d.this.hpc != null) {
                        if (d.this.hpc.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hpc.aNT);
                                jSONObject2.put("user_verify", d.this.hpc.aNV);
                                jSONObject2.put("certify", d.this.hpc.aNX);
                                if (d.this.hpc.mLiveSdkInfo != null && d.this.hpc.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, d.this.hpc.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hpc.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hpc.aNT != 1 || d.this.hpc.aNV != 1) {
                            d.this.hoY.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cgi();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.hpc.aIV != null) {
                            d.this.hpa.Q(d.this.hpc.aIV.live_mark_info_new);
                        }
                        if (d.this.hpc.mErrorCode != 0) {
                            if (d.this.hpc.mErrorCode == 220012) {
                                d.this.b(d.this.hpc.mErrorCode, d.this.hpc.mErrorMsg, 6, d.this.aES);
                                return;
                            }
                        } else {
                            d.this.aES = new w();
                            d.this.hpa.setAlaLiveShowData(d.this.aES);
                            d.this.aES.mLiveInfo = d.this.hpc.mLiveInfo;
                            d.this.aES.aIV = d.this.hpc.aIV;
                            d.this.aES.mLiveSdkInfo = d.this.hpc.mLiveSdkInfo;
                            d.this.aES.aJC = d.this.hpc.aJC;
                            d.this.aES.aJA = d.this.hpc.aIV.live_mark_info_new;
                            d.this.aES.aJx = d.this.hpc.aJx;
                            if (d.this.hpc.aIV != null && d.this.hpc.aIV.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.hpc.aIV.levelId);
                            }
                            d.this.aES.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aES));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aES);
                    if (d.this.hpc != null && d.this.hpc.mLiveInfo != null) {
                        d.this.cgy();
                    }
                    if (d.this.aES != null && d.this.aES.mLiveInfo != null) {
                        d.this.t(d.this.aES.mLiveInfo.user_id, d.this.aES.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.hpH = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.q.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.hpa.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.hpI = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.q.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.o.b)) {
                    com.baidu.live.o.b bVar = (com.baidu.live.o.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.bpS != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.bpS.hO(bVar.contentType);
                        } else {
                            bVar.bpS.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hpJ = new HttpMessageListener(1021125) { // from class: com.baidu.tieba.ala.liveroom.q.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetUserInfoHttpResponseMessage)) {
                    GetUserInfoHttpResponseMessage getUserInfoHttpResponseMessage = (GetUserInfoHttpResponseMessage) httpResponsedMessage;
                    if (d.this.aES != null && d.this.aES.aJr != null && getUserInfoHttpResponseMessage.userId == d.this.aES.aJr.userId && !TextUtils.isEmpty(getUserInfoHttpResponseMessage.userName)) {
                        d.this.aES.aJr.nickName = getUserInfoHttpResponseMessage.userName;
                    }
                }
            }
        };
        this.hpK = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.q.d.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                t tVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        tVar = null;
                    } else {
                        tVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).cfK();
                    }
                    if (tVar != null && !ListUtils.isEmpty(tVar.aJk)) {
                        d.this.hpt = tVar.aJj;
                        d.this.hpe = tVar.pn + 1;
                        s sVar = tVar.aJk.get(tVar.aJk.size() - 1);
                        if (sVar != null) {
                            d.this.mLastLiveId = sVar.mLiveInfo.live_id;
                        }
                        d.this.a(tVar);
                        if (d.this.aES != null) {
                            d.this.h(d.this.aES.mLiveInfo);
                        }
                        d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, tVar);
                    }
                }
            }
        };
        this.hpL = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.q.d.25
        };
        this.hpM = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.hoR));
            }
        };
        this.mPageContext = bdPageContext;
        this.hpa = new com.baidu.live.im.d(bdPageContext, false, this);
        this.hpd = new ArrayList();
        this.hpp = new HashSet();
        initTasks();
        registerListener(this.hpE);
        registerListener(this.hpC);
        registerListener(this.hpB);
        registerListener(this.hpz);
        this.hoX = BdUniqueId.gen();
        this.hpK.setTag(this.hoX);
        registerListener(this.hpK);
        registerListener(this.hpF);
        registerListener(this.hpA);
        registerListener(this.hpG);
        registerListener(this.gUj);
        registerListener(this.hpw);
        registerListener(this.hpx);
        registerListener(this.hpv);
        registerListener(this.gvc);
        registerListener(this.hpD);
        registerListener(this.hpy);
        registerListener(this.hpH);
        registerListener(this.hpI);
        registerListener(this.hpJ);
        MessageManager.getInstance().addMessageRule(this.hpm);
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
        this.hoR = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.hpM);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        cfV();
        cfW();
        cfX();
        cfY();
        cgb();
        cgc();
    }

    public void setIsMixLive(boolean z) {
        this.hpu = z;
    }

    private void cfV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cfW() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void cfX() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void cfY() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void cfZ() {
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

    public void cga() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void cgb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cgc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cgd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.o.b) && d.this.aES != null && d.this.aES.mLiveInfo != null) {
                    com.baidu.live.o.b bVar = (com.baidu.live.o.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aES.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.bpR != null) {
                        httpMessage.addParam("ext_data", bVar.bpR.toString());
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

    public void cge() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void t(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cgf() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    public void ew(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void cgg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void cgh() {
        if (this.hpo != null) {
            this.hpo.dismiss();
            this.hpo = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_auth);
        this.hpo = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hpo.setAutoNight(false);
        this.hpo.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hpo.setPositiveButton(this.mPageContext.getString(a.h.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cgg();
                    d.this.Hv();
                }
            });
            this.hpo.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Hv();
                }
            });
        } else {
            this.hpo.setPositiveButton(this.mPageContext.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Hv();
                }
            });
        }
        this.hpo.setCancelable(false);
        this.hpo.setCanceledOnTouchOutside(false);
        this.hpo.setTitleShowCenter(true);
        this.hpo.setMessageShowCenter(true);
        this.hpo.isShowTitleAndMessage();
        this.hpo.create(this.mPageContext);
        this.hpo.show();
    }

    public void ex(String str, String str2) {
        if (this.hpo != null) {
            this.hpo.dismiss();
            this.hpo = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_permission);
        this.hpo = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hpo.setAutoNight(false);
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.hpo.setTitle(str);
        } else if (StringUtils.isNull(str2)) {
            str2 = string;
        }
        this.hpo.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hpo.setPositiveButton(this.mPageContext.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Hv();
                }
            });
        } else {
            this.hpo.setPositiveButton(this.mPageContext.getString(a.h.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.aa.a.PQ().bod.aMH;
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
                    d.this.Hv();
                }
            });
            this.hpo.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.Hv();
                }
            });
        }
        this.hpo.setCancelable(false);
        this.hpo.setCanceledOnTouchOutside(false);
        this.hpo.setTitleShowCenter(true);
        this.hpo.setMessageShowCenter(true);
        this.hpo.isShowTitleAndMessage();
        this.hpo.create(this.mPageContext);
        this.hpo.show();
    }

    public void cgi() {
        if (this.hpo != null) {
            this.hpo.dismiss();
            this.hpo = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_permission_tip);
        this.hpo = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hpo.setAutoNight(false);
        this.hpo.setMessage(string);
        this.hpo.setPositiveButton(this.mPageContext.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hpo.setCancelable(false);
        this.hpo.setCanceledOnTouchOutside(false);
        this.hpo.isShowTitleAndMessage();
        this.hpo.create(this.mPageContext);
        this.hpo.show();
    }

    public void cgj() {
        if (this.hpo != null) {
            this.hpo.dismiss();
            this.hpo = null;
        }
        if (this.hpn != null) {
            a(this.hpn);
        }
    }

    public void cgk() {
        if (this.hpo != null) {
            this.hpo.dismiss();
            this.hpo = null;
        }
        String string = this.mPageContext.getString(a.h.dialog_msg_to_user_info);
        this.hpo = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hpo.setAutoNight(false);
        this.hpo.setMessage(string);
        this.hpo.setPositiveButton(this.mPageContext.getString(a.h.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.20
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
                d.this.Hv();
            }
        });
        this.hpo.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.Hv();
            }
        });
        this.hpo.setCancelable(false);
        this.hpo.setCanceledOnTouchOutside(false);
        this.hpo.setTitleShowCenter(true);
        this.hpo.setMessageShowCenter(true);
        this.hpo.isShowTitleAndMessage();
        this.hpo.create(this.mPageContext);
        this.hpo.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.h.ala_live_no_permission_tip);
        this.hpo = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hpo.setAutoNight(false);
        this.hpo.setMessage(string);
        this.hpo.setPositiveButton(this.mPageContext.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hpo.setCancelable(false);
        this.hpo.setCanceledOnTouchOutside(false);
        this.hpo.isShowTitleAndMessage();
        this.hpo.create(this.mPageContext);
        this.hpo.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.hpn = null;
        this.hpo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv() {
        if (this.hpo != null) {
            this.hpo.dismiss();
            this.hpo = null;
        }
        this.hpn = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hlY != null) {
            this.hlY.a(i, str, i2, obj);
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

    public void cgl() {
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

    public void we(int i) {
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

    public ap cgm() {
        return this.hpc;
    }

    public w Hi() {
        return this.aES;
    }

    public aw cfI() {
        return this.hoo;
    }

    public List<AlaLiveInfoData> cgn() {
        return this.hpd;
    }

    public q bRq() {
        return this.gwG;
    }

    public void cB(List<Long> list) {
        if (!this.hpu) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
                com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
                if (this.aES != null && this.aES.mLiveInfo != null) {
                    aVar.setAudienceCount(this.aES.mLiveInfo.audience_count);
                }
                aVar.setListIds(list);
                aVar.setParams();
                sendMessage(aVar);
            }
        }
    }

    public void cgo() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hpd) {
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
                if (this.hpd.size() == 1 && this.hpd.get(0).live_id == this.aES.mLiveInfo.live_id) {
                    if (c(tVar) != null) {
                        this.hpd.clear();
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
        for (s sVar : tVar.aJk) {
            if (sVar != null && sVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hpd) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == sVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hpd.add(sVar.mLiveInfo);
                }
            }
        }
        if (this.hpd.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hpd.size() - 200; size < this.hpd.size(); size++) {
                arrayList.add(this.hpd.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hpd.clear();
                this.hpd.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(t tVar) {
        if (ListUtils.isEmpty(tVar.aJk)) {
            return null;
        }
        for (s sVar : tVar.aJk) {
            if (sVar != null && sVar.mLiveInfo != null && sVar.mLiveInfo.live_id == this.aES.mLiveInfo.live_id) {
                return sVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cgp() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hpd)) {
            return null;
        }
        if (this.hpp.isEmpty()) {
            arrayList.addAll(this.hpd);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hpd.size()) {
                    break;
                }
                if ((this.aES == null || this.aES.mLiveInfo == null || this.aES.mLiveInfo.live_id != this.hpd.get(i2).live_id) && !this.hpp.contains(Long.valueOf(this.hpd.get(i2).live_id))) {
                    arrayList.add(this.hpd.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hpp.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hpp.size() >= this.hpd.size() - 4) {
                nF(false);
            }
        }
    }

    public void wf(int i) {
        this.hpk = i;
    }

    public void nF(boolean z) {
        if (!this.hpu) {
            if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.Ny().Nw()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hpq > 500) {
                    this.hpq = currentTimeMillis;
                    com.baidu.live.liveroom.c.d.Ny().NA().a("tieba", this.hpe, 20, this.hpL);
                    return;
                }
                return;
            }
            nG(z);
        }
    }

    private void nG(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hps >= 1800000) {
                this.hpr = currentTimeMillis;
                this.hpt = true;
            }
            if (this.hpt) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hpe);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hpr);
                httpMessage.setTag(this.hoX);
                sendMessage(httpMessage);
                this.hps = currentTimeMillis;
            }
        }
    }

    public void ey(String str, String str2) {
        this.hpa.bU(true);
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
        aVar.Ba(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.Im("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        cgA();
    }

    public void ar(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.Ba(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        cgA();
    }

    public void In(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        cgA();
    }

    public void eZ(long j) {
        this.hpa.bU(false);
        this.hpq = 0L;
        this.hpl = null;
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
        if (!cgq()) {
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
            httpMessage.addParam("is_prettify", bl.b(com.baidu.live.aa.a.PQ().btT) ? 1 : 2);
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

    private boolean cgq() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void cgr() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aES == null) {
            this.aES = new w(alaLiveInfoCoreData);
            this.hpa.setAlaLiveShowData(this.aES);
        }
        this.mLastLiveId = this.aES.mLiveInfo.live_id;
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
        if (this.aES == null) {
            this.aES = new w();
        }
        this.aES.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aES.aIV = alaLivePersonData.mUserData;
        this.aES.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aES.aIV != null && this.hpa != null) {
            this.hpa.Q(this.aES.aIV.live_mark_info_new);
        }
        this.aES.isHost = true;
        this.aES.aJD = true;
        if (this.hpa != null) {
            this.hpa.setAlaLiveShowData(this.aES);
        }
        cgy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aES));
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
        this.hoY.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hpK);
        MessageManager.getInstance().removeMessageRule(this.hpm);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.hpa.bU(true);
        this.hpb = null;
        this.mPageContext = null;
    }

    public void wg(int i) {
        this.hpf = i;
        if (this.hpd.size() == 0) {
            this.hpf = 0;
        } else if (this.hpf < 0) {
            this.hpf = this.hpd.size() + this.hpf;
        } else {
            this.hpf %= this.hpd.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hpd.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hpd.size()) {
                    if (this.hpd.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hpf = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cgs() {
        long j;
        if (this.aES == null || this.aES.mLiveInfo == null || this.hpd.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hpd.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aES.mLiveInfo.live_id;
    }

    public boolean cgt() {
        long j;
        if (this.aES == null || this.aES.mLiveInfo == null || this.hpd.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hpd.get(this.hpd.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aES.mLiveInfo.live_id;
    }

    public int cgu() {
        return this.hpf;
    }

    public int cgv() {
        return this.hph;
    }

    public boolean cgw() {
        return this.hpi == 1;
    }

    public AlaLiveInfoData cgx() {
        if (this.hpf >= this.hpd.size()) {
            this.hpf = this.hpd.size() - 1;
        }
        if (this.hpf < 0) {
            this.hpf = 0;
        }
        if (this.hpd.size() <= this.hpf) {
            if (this.aES != null) {
                return this.aES.mLiveInfo;
            }
            return null;
        }
        return this.hpd.get(this.hpf);
    }

    public void a(a aVar) {
        this.hlY = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.hpb != null) {
            this.hpb.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void t(com.baidu.live.im.data.a aVar) {
        if (this.aES != null && this.aES.mLiveInfo.live_type == 1) {
            I(aVar);
        }
        if (this.hpb != null) {
            this.hpb.t(aVar);
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
            nF(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void Ll() {
        if (this.hpb != null) {
            this.hpb.Ll();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aES);
        if (this.aES != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aES.aIV;
            } else {
                alaLiveUserInfoData = this.aES.aJr;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aES.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aES != null && this.aES.aJr != null && this.aES.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aES.aJr.throneUid;
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
                this.hpa.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void cgy() {
        this.hpa.e(String.valueOf(this.aES.mLiveInfo.getGroupID()), String.valueOf(this.aES.mLiveInfo.getLastMsgID()), String.valueOf(this.aES.mLiveInfo.getUserID()), String.valueOf(this.aES.mLiveInfo.getLiveID()), this.aES.mLiveInfo.appId);
    }

    public com.baidu.live.im.d cgz() {
        return this.hpa;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void cgA() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aES != null) {
            try {
                if (this.aES.mLiveSdkInfo != null && this.aES.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, this.aES.mLiveSdkInfo.mCastIds.chatMCastId);
                    jSONObject2.put("ensure_mcast_id", this.aES.mLiveSdkInfo.mCastIds.ensureMCastId);
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

    public String cgB() {
        return this.hpl;
    }

    public void HL(String str) {
        this.hpl = str;
    }

    public void Io(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                this.mType = new JSONObject(str).optString(AlaLastLiveroomInfo.KEY_LAST_FROM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
