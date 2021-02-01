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
/* loaded from: classes11.dex */
public class d extends BdBaseModel implements d.a {
    private ab aDd;
    private BdPageContext<?> bkx;
    private CustomMessageListener gNg;
    private v gOJ;
    private a hGF;
    private long hJI;
    private BdUniqueId hJO;
    private Handler hJP;
    private HttpMessage hJQ;
    private final com.baidu.live.im.d hJR;
    private d.a hJS;
    private aw hJT;
    private List<AlaLiveInfoData> hJU;
    private int hJV;
    private int hJW;
    private boolean hJX;
    private int hJY;
    private int hJZ;
    private bd hJh;
    private HttpMessageListener hKA;
    private HttpMessageListener hKB;
    private com.baidu.live.liveroom.c.a hKC;
    private CustomMessageTask.CustomRunnable hKD;
    private int hKa;
    private int hKb;
    private String hKc;
    private com.baidu.live.ac.a hKd;
    private AlaGetVerifyStrategyResponseHttpMessage hKe;
    private BdAlertDialog hKf;
    private Set<Long> hKg;
    private long hKh;
    private long hKi;
    private long hKj;
    private boolean hKk;
    private boolean hKl;
    private HttpMessageListener hKm;
    private HttpMessageListener hKn;
    private HttpMessageListener hKo;
    private HttpMessageListener hKp;
    private NetMessageListener hKq;
    private HttpMessageListener hKr;
    private NetMessageListener hKs;
    private HttpMessageListener hKt;
    private HttpMessageListener hKu;
    private NetMessageListener hKv;
    private NetMessageListener hKw;
    private HttpMessageListener hKx;
    private CustomMessageListener hKy;
    private HttpMessageListener hKz;
    private HttpMessageListener hoD;
    private boolean mIsHost;
    private long mLastLiveId;
    private String mType;
    private String otherParams;

    /* loaded from: classes11.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public d(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.hJP = new Handler();
        this.hJV = 0;
        this.hJW = 0;
        this.hJX = true;
        this.hJY = 1;
        this.hJZ = 0;
        this.hKa = -1;
        this.hKb = 0;
        this.hKd = new com.baidu.live.ac.a(0);
        this.otherParams = "";
        this.hKi = System.currentTimeMillis();
        this.hKj = 0L;
        this.hKk = true;
        this.hKl = false;
        this.gNg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.n.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aDd != null && d.this.aDd.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aDd.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.hKa = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aDd.mLiveInfo.user_id).param("obj_param1", d.this.aDd.mLiveInfo.live_id).param("tid", d.this.aDd.mLiveInfo.thread_id));
                            d.this.hKa = 1;
                        }
                        if (d.this.aDd != null && d.this.aDd.aIf != null) {
                            d.this.aDd.aIf.follow_status = d.this.hKa;
                        }
                    }
                }
            }
        };
        this.hKm = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.n.d.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.buZ == 1 && alaUserAuthenVerifyInfoResponseMessage.buY != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.buY.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.buY.verify_video_status == 1) {
                            d.this.hJY = 4;
                        }
                    }
                }
            }
        };
        this.hKn = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.n.d.28
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
                    d.this.hJZ = alaGetVerifyStrategyResponseHttpMessage.hJo;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, "author_liveroom", ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hJk);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hJm);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hJp);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, "author_liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hJm != 1 || alaGetVerifyStrategyResponseHttpMessage.hJk != 1 || alaGetVerifyStrategyResponseHttpMessage.hJp != 1 || alaGetVerifyStrategyResponseHttpMessage.hJr != 1) {
                            d.this.hKe = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hJp != 1) {
                                d.this.hJP.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.28.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cjj();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hJm != 1 || alaGetVerifyStrategyResponseHttpMessage.hJk != 1) {
                                d.this.hJP.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.28.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ez(alaGetVerifyStrategyResponseHttpMessage.hJs, alaGetVerifyStrategyResponseHttpMessage.hJt);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hJr != 1) {
                                d.this.hJP.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.28.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cjm();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.hKe = null;
                    }
                }
            }
        };
        this.hKo = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.n.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.hKp = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.n.d.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String ciS;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.ciQ() == 1 || masterIdentityResponseMessage.ciR() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.ciS())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.ciS());
                            jSONObject.put("content_type", "custom_master_identity");
                            ciS = jSONObject.toString();
                        } catch (JSONException e) {
                            ciS = masterIdentityResponseMessage.ciS();
                            e.printStackTrace();
                        }
                        d.this.hJR.a(27, ciS, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.hKq = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.n.d.31
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.hKr = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.n.d.32
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.hJX = false;
                }
            }
        };
        this.hKs = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.n.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aDd = alaEnterLiveHttpResonseMessage.Fm();
                        d.this.hJh = alaEnterLiveHttpResonseMessage.ciK();
                        d.this.hJR.setAlaLiveShowData(d.this.aDd);
                    }
                    if (d.this.aDd != null && d.this.aDd.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.ckA().fK(d.this.aDd.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aDd.mLiveInfo.live_id);
                        try {
                            com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(d.this.aDd.mLiveInfo.live_id)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (d.this.aDd != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aDd.aIz != null) {
                            if (d.this.aDd.aIz.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aDd.aIz.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aDd.aIz.nickName);
                            if (!TextUtils.isEmpty(d.this.aDd.aIz.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aDd.aIz.portrait);
                            }
                            com.baidu.live.view.a.Xo().ik(String.valueOf(d.this.aDd.mLiveInfo.user_id));
                        }
                        if (d.this.aDd.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aDd.mLiveSdkInfo.tbs);
                            com.baidu.live.d.xc().putString("ala_account_user_tbs", d.this.aDd.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aDd != null) {
                        if (d.this.hJU.size() <= 0) {
                            d.this.hJU.add(d.this.aDd.mLiveInfo);
                            d.this.hKg.add(Long.valueOf(d.this.aDd.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aDd.mLiveInfo);
                        if (d.this.hJR != null) {
                            d.this.hJR.S(d.this.aDd.aIK);
                        }
                    }
                    if (d.this.aDd != null && d.this.aDd.aIf != null) {
                        d.this.hKa = d.this.aDd.aIf.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aDd);
                    if (d.this.aDd != null && d.this.aDd.mLiveInfo != null) {
                        d.this.cjA();
                    }
                    if (d.this.aDd != null) {
                        d.this.aDd.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aDd));
                        com.baidu.live.im.b.d.KN().W(d.this.aDd.aIK);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aDd != null && d.this.aDd.mLiveInfo != null) {
                            long j2 = d.this.aDd.mLiveInfo.live_id;
                            long j3 = d.this.aDd.mLiveInfo.room_id;
                            String str = d.this.aDd.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aDd.aId != null) {
                                long j4 = d.this.aDd.aId.userId;
                                str2 = d.this.aDd.aId.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && d.this.aDd != null && d.this.aDd.mLiveInfo != null) {
                        long j5 = d.this.aDd.mLiveInfo.live_id;
                        long j6 = d.this.aDd.mLiveInfo.room_id;
                        String str3 = d.this.aDd.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aDd.aId != null) {
                            j = d.this.aDd.aId.userId;
                            str4 = d.this.aDd.aId.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.hJW + "");
                    }
                    if (d.this.aDd != null && d.this.aDd.mLiveInfo != null) {
                        if (!com.baidu.tieba.ala.liveroom.performancewatchtask.b.cjY().cjX()) {
                            try {
                                if (d.this.aDd.mLiveInfo.isPubShow && TbadkCoreApplication.getCurrentAccount() != null) {
                                    com.baidu.live.view.a.Xo().ik(String.valueOf(d.this.aDd.mLiveInfo.user_id));
                                    com.baidu.tieba.ala.liveroom.performancewatchtask.b.cjY().a(d.this.bkx, d.this.aDd.mLiveInfo.live_id, Long.parseLong(TbadkCoreApplication.getCurrentAccount()), d.this.aDd.mLiveInfo, d.this.mType);
                                }
                            } catch (NumberFormatException e2) {
                                e2.printStackTrace();
                            }
                        }
                        com.baidu.tieba.ala.liveroom.performancewatchtask.b.cjY().oI(false);
                    }
                    com.baidu.live.d.xc().putLong("show_enter_live_timestamp", System.currentTimeMillis() / 1000);
                }
            }
        };
        this.hKt = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.n.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    v vVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        vVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bTK();
                    }
                    if (vVar != null) {
                        d.this.gOJ = vVar;
                    }
                    if (d.this.aDd != null && d.this.aDd.aIf != null) {
                        if (d.this.hKa == -1) {
                            d.this.hKa = d.this.aDd.aIf.follow_status;
                        }
                        if (d.this.aDd.aIf.follow_status != d.this.hKa) {
                            d.this.aDd.aIf.follow_status = d.this.hKa;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.gOJ);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.gOJ));
                }
            }
        };
        this.hKu = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.n.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> ciP = alaUserLiveMarkInfoResponseMessage.ciP();
                        d.this.hJR.S(ciP);
                        if (d.this.aDd != null) {
                            d.this.aDd.aIK = ciP;
                            com.baidu.live.im.b.d.KN().W(d.this.aDd.aIK);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aDd));
                        }
                    }
                }
            }
        };
        this.hKv = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.n.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    ab Fm = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).Fm() : null;
                    d.this.hJI = System.currentTimeMillis();
                    if (Fm == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, Fm);
                        return;
                    }
                    if (d.this.aDd == null) {
                        d.this.aDd = Fm;
                        d.this.hJR.setAlaLiveShowData(d.this.aDd);
                    } else if (d.this.aDd.mLiveInfo != null && Fm.mLiveInfo != null && d.this.aDd.mLiveInfo.live_id != Fm.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aDd);
                        return;
                    }
                    if (d.this.aDd.mLiveInfo != null && Fm.mLiveInfo != null && d.this.aDd.mLiveInfo.user_id == Fm.mLiveInfo.user_id) {
                        if (d.this.aDd.mLiveInfo.imEffect != null && Fm.mLiveInfo.imEffect == null) {
                            Fm.mLiveInfo.imEffect = d.this.aDd.mLiveInfo.imEffect;
                        }
                        if (d.this.aDd.mLiveInfo.mLiveCloseData != null && Fm.mLiveInfo.mLiveCloseData == null) {
                            Fm.mLiveInfo.mLiveCloseData = d.this.aDd.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aDd.mLiveInfo.mAlaLiveSwitchData != null && Fm.mLiveInfo.mAlaLiveSwitchData == null) {
                            Fm.mLiveInfo.mAlaLiveSwitchData = d.this.aDd.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aDd.mLiveInfo = Fm.mLiveInfo;
                    d.this.aDd.serverTime = Fm.serverTime;
                    d.this.aDd.aIW = Fm.aIW;
                    if (Fm.aId != null && Fm.aId.userId != 0) {
                        d.this.aDd.aId = Fm.aId;
                    }
                    d.this.aDd.aIe = Fm.aIe;
                    d.this.aDd.aIi = Fm.aIi;
                    d.this.aDd.aIL = Fm.aIL;
                    d.this.aDd.aIJ = Fm.aIJ;
                    d.this.aDd.aIE = Fm.aIE;
                    d.this.aDd.aIF = Fm.aIF;
                    d.this.aDd.aIG = Fm.aIG;
                    d.this.aDd.aIH = Fm.aIH;
                    d.this.aDd.aII = Fm.aII;
                    d.this.aDd.countDown = Fm.countDown;
                    d.this.aDd.aJq = Fm.aJq;
                    if (Fm.url != null) {
                        d.this.aDd.url = Fm.url;
                    }
                    if (Fm.aIB != null) {
                        d.this.aDd.aIB = Fm.aIB;
                    }
                    d.this.aDd.aJc = Fm.aJc;
                    if (Fm.aIO != null && Fm.aIO.aNQ != null && !Fm.aIO.aNQ.isEmpty()) {
                        String str = d.this.aDd.aIO.aNS;
                        String str2 = d.this.aDd.aIO.aNU;
                        d.this.aDd.aIO = Fm.aIO;
                        d.this.aDd.aIO.aNS = str;
                        d.this.aDd.aIO.aNU = str2;
                    }
                    if (Fm.aIz != null) {
                        if (Fm.aIz.userId == 0 || TbadkCoreApplication.getCurrentAccountInfo() == null) {
                            if (d.this.aDd.aIz == null) {
                                d.this.aDd.aIz = new AlaLiveUserInfoData();
                            }
                            d.this.aDd.aIz.throneUid = Fm.aIz.throneUid;
                        } else {
                            boolean z = Fm.aIz.isNewUser;
                            if (d.this.aDd.aIz != null) {
                                z = d.this.aDd.aIz.isNewUser;
                            }
                            Fm.aIz.isNewUser = z;
                            d.this.aDd.aIz = Fm.aIz;
                            if (d.this.aDd.aIz.levelId != TbadkCoreApplication.getCurrentAccountInfo().getLiveLevel()) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aDd.aIz.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aDd.aIz.nickName);
                            if (!TextUtils.equals(d.this.aDd.aIz.portrait, TbadkCoreApplication.getCurrentAccountObj().getPortrait())) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aDd.aIz.portrait);
                            }
                        }
                    }
                    if (Fm.aIC != null) {
                        d.this.aDd.aIC = Fm.aIC;
                    }
                    if (Fm.aIJ) {
                        d.this.aDd.aIK = Fm.aIK;
                        if (d.this.hJR != null) {
                            d.this.hJR.S(Fm.aIK);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aDd.mLiveInfo != null) {
                        int i = d.this.aDd.mLiveInfo.backstage_type;
                        if (d.this.hJR != null) {
                            d.this.hJR.gY(String.valueOf(i));
                        }
                    }
                    if (d.this.hJR != null) {
                        d.this.hJR.setAlaLiveShowData(d.this.aDd);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aDd);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aDd));
                    if (d.this.aDd != null) {
                        com.baidu.live.im.b.d.KN().W(d.this.aDd.aIK);
                    }
                }
            }
        };
        this.hKw = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.n.d.6
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
                    if (list != null && list.size() > 0 && d.this.hJU != null && d.this.hJU.size() > 0) {
                        for (int size = d.this.hJU.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.hJU.get(size)).live_id != d.this.aDd.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.hJU.get(size)).getLiveID()))) {
                                d.this.hJU.remove(size);
                            }
                        }
                    }
                    if (d.this.aDd != null) {
                        d.this.h(d.this.aDd.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hoD = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.n.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.hKx = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.n.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", "author_liveroom", ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.hJQ = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.hJT = alaUpdateLiveTbResponseMessage.ciO();
                    if (d.this.hJT != null) {
                        if (d.this.hJT.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hJT.aOd);
                                jSONObject2.put("user_verify", d.this.hJT.aOf);
                                jSONObject2.put("certify", d.this.hJT.aOh);
                                if (d.this.hJT.mLiveSdkInfo != null && d.this.hJT.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, d.this.hJT.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hJT.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, "author_liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hJT.aOd != 1 || d.this.hJT.aOf != 1) {
                            d.this.hJP.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cjk();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.hJT.aId != null) {
                            d.this.hJR.S(d.this.hJT.aId.live_mark_info_new);
                        }
                        if (d.this.hJT.mErrorCode != 0) {
                            if (d.this.hJT.mErrorCode == 220012) {
                                d.this.b(d.this.hJT.mErrorCode, d.this.hJT.mErrorMsg, 6, d.this.aDd);
                                return;
                            }
                        } else {
                            d.this.aDd = new ab();
                            d.this.hJR.setAlaLiveShowData(d.this.aDd);
                            d.this.aDd.mLiveInfo = d.this.hJT.mLiveInfo;
                            d.this.aDd.aId = d.this.hJT.aId;
                            d.this.aDd.mLiveSdkInfo = d.this.hJT.mLiveSdkInfo;
                            d.this.aDd.aIM = d.this.hJT.aIM;
                            d.this.aDd.aIK = d.this.hJT.aId.live_mark_info_new;
                            d.this.aDd.aIF = d.this.hJT.aIF;
                            if (d.this.hJT.aId != null && d.this.hJT.aId.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.hJT.aId.levelId);
                            }
                            d.this.aDd.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aDd));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aDd);
                    if (d.this.hJT != null && d.this.hJT.mLiveInfo != null) {
                        d.this.cjA();
                    }
                    if (d.this.aDd != null && d.this.aDd.mLiveInfo != null) {
                        d.this.A(d.this.aDd.mLiveInfo.user_id, d.this.aDd.mLiveInfo.live_id);
                    }
                    com.baidu.live.d.xc().putLong("show_enter_live_timestamp", System.currentTimeMillis() / 1000);
                }
            }
        };
        this.hKy = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.n.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.hJR.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.hKz = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.n.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.q.b)) {
                    com.baidu.live.q.b bVar = (com.baidu.live.q.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.bwS != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.bwS.hl(bVar.contentType);
                        } else {
                            bVar.bwS.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hKA = new HttpMessageListener(1021125) { // from class: com.baidu.tieba.ala.liveroom.n.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetUserInfoHttpResponseMessage)) {
                    GetUserInfoHttpResponseMessage getUserInfoHttpResponseMessage = (GetUserInfoHttpResponseMessage) httpResponsedMessage;
                    if (d.this.aDd != null && d.this.aDd.aIz != null && getUserInfoHttpResponseMessage.userId == d.this.aDd.aIz.userId && !TextUtils.isEmpty(getUserInfoHttpResponseMessage.userName)) {
                        d.this.aDd.aIz.nickName = getUserInfoHttpResponseMessage.userName;
                    }
                }
            }
        };
        this.hKB = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.n.d.24
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
                        yVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).ciM();
                    }
                    if (yVar == null || ListUtils.isEmpty(yVar.aIs)) {
                        l.e(httpResponsedMessage);
                        return;
                    }
                    d.this.hKk = yVar.aIr;
                    d.this.hJV = yVar.pn + 1;
                    x xVar = yVar.aIs.get(yVar.aIs.size() - 1);
                    if (xVar != null) {
                        d.this.mLastLiveId = xVar.mLiveInfo.live_id;
                    }
                    d.this.a(yVar);
                    if (d.this.aDd != null) {
                        d.this.h(d.this.aDd.mLiveInfo);
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, yVar);
                }
            }
        };
        this.hKC = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.n.d.25
        };
        this.hKD = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.hJI));
            }
        };
        this.bkx = bdPageContext;
        this.hJR = new com.baidu.live.im.d(bdPageContext, false, this);
        this.hJU = new ArrayList();
        this.hKg = new HashSet();
        initTasks();
        registerListener(this.hKv);
        registerListener(this.hKt);
        registerListener(this.hKs);
        registerListener(this.hKq);
        this.hJO = BdUniqueId.gen();
        this.hKB.setTag(this.hJO);
        registerListener(this.hKB);
        registerListener(this.hKw);
        registerListener(this.hKr);
        registerListener(this.hKx);
        registerListener(this.hoD);
        registerListener(this.hKn);
        registerListener(this.hKo);
        registerListener(this.hKm);
        registerListener(this.gNg);
        registerListener(this.hKu);
        registerListener(this.hKp);
        registerListener(this.hKy);
        registerListener(this.hKz);
        registerListener(this.hKA);
        MessageManager.getInstance().addMessageRule(this.hKd);
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
        this.hJI = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.hKD);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        ciX();
        ciY();
        ciZ();
        cja();
        cjd();
        cje();
    }

    public void setIsMixLive(boolean z) {
        this.hKl = z;
    }

    private void ciX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void ciY() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void ciZ() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void cja() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void cjb() {
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

    public void cjc() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void cjd() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cje() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cjf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.n.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.q.b) && d.this.aDd != null && d.this.aDd.mLiveInfo != null) {
                    com.baidu.live.q.b bVar = (com.baidu.live.q.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aDd.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.bwR != null) {
                        httpMessage.addParam("ext_data", bVar.bwR.toString());
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

    public void cjg() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void A(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cjh() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, "author_liveroom", ""));
    }

    public void ey(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void cji() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.bkx.getPageActivity(), "")));
    }

    public void cjj() {
        if (this.hKf != null) {
            this.hKf.dismiss();
            this.hKf = null;
        }
        String string = this.bkx.getString(a.h.ala_live_no_auth);
        this.hKf = new BdAlertDialog(this.bkx.getPageActivity());
        this.hKf.setAutoNight(false);
        this.hKf.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hKf.setPositiveButton(this.bkx.getString(a.h.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cji();
                    d.this.FA();
                }
            });
            this.hKf.setNegativeButton(this.bkx.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FA();
                }
            });
        } else {
            this.hKf.setPositiveButton(this.bkx.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FA();
                }
            });
        }
        this.hKf.setCancelable(false);
        this.hKf.setCanceledOnTouchOutside(false);
        this.hKf.setTitleShowCenter(true);
        this.hKf.setMessageShowCenter(true);
        this.hKf.isShowTitleAndMessage();
        this.hKf.create(this.bkx);
        this.hKf.show();
    }

    public void ez(String str, String str2) {
        if (this.hKf != null) {
            this.hKf.dismiss();
            this.hKf = null;
        }
        String string = this.bkx.getString(a.h.ala_live_no_permission);
        this.hKf = new BdAlertDialog(this.bkx.getPageActivity());
        this.hKf.setAutoNight(false);
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.hKf.setTitle(str);
        } else if (StringUtils.isNull(str2)) {
            str2 = string;
        }
        this.hKf.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hKf.setPositiveButton(this.bkx.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FA();
                }
            });
        } else {
            this.hKf.setPositiveButton(this.bkx.getString(a.h.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.ae.a.Qj().buX.aMs;
                        if (!TextUtils.isEmpty(str3)) {
                            BrowserHelper.startInternalWebActivity(d.this.bkx.getPageActivity(), str3);
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
                    d.this.FA();
                }
            });
            this.hKf.setNegativeButton(this.bkx.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FA();
                }
            });
        }
        this.hKf.setCancelable(false);
        this.hKf.setCanceledOnTouchOutside(false);
        this.hKf.setTitleShowCenter(true);
        this.hKf.setMessageShowCenter(true);
        this.hKf.isShowTitleAndMessage();
        this.hKf.create(this.bkx);
        this.hKf.show();
    }

    public void cjk() {
        if (this.hKf != null) {
            this.hKf.dismiss();
            this.hKf = null;
        }
        String string = this.bkx.getString(a.h.ala_live_no_permission_tip);
        this.hKf = new BdAlertDialog(this.bkx.getPageActivity());
        this.hKf.setAutoNight(false);
        this.hKf.setMessage(string);
        this.hKf.setPositiveButton(this.bkx.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hKf.setCancelable(false);
        this.hKf.setCanceledOnTouchOutside(false);
        this.hKf.isShowTitleAndMessage();
        this.hKf.create(this.bkx);
        this.hKf.show();
    }

    public void cjl() {
        if (this.hKf != null) {
            this.hKf.dismiss();
            this.hKf = null;
        }
        if (this.hKe != null) {
            a(this.hKe);
        }
    }

    public void cjm() {
        if (this.hKf != null) {
            this.hKf.dismiss();
            this.hKf = null;
        }
        String string = this.bkx.getString(a.h.dialog_msg_to_user_info);
        this.hKf = new BdAlertDialog(this.bkx.getPageActivity());
        this.hKf.setAutoNight(false);
        this.hKf.setMessage(string);
        this.hKf.setPositiveButton(this.bkx.getString(a.h.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                IExtraParams buildParamsExtra;
                if (TbadkCoreApplication.getInst().isTieba()) {
                    IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                    if (buildJumpExtra != null) {
                        buildJumpExtra.jumpToPersonalCenter(d.this.bkx.getPageActivity(), TbadkCoreApplication.getCurrentAccountId() + "");
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
                d.this.FA();
            }
        });
        this.hKf.setNegativeButton(this.bkx.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.FA();
            }
        });
        this.hKf.setCancelable(false);
        this.hKf.setCanceledOnTouchOutside(false);
        this.hKf.setTitleShowCenter(true);
        this.hKf.setMessageShowCenter(true);
        this.hKf.isShowTitleAndMessage();
        this.hKf.create(this.bkx);
        this.hKf.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.bkx.getString(a.h.ala_live_no_permission_tip);
        this.hKf = new BdAlertDialog(this.bkx.getPageActivity());
        this.hKf.setAutoNight(false);
        this.hKf.setMessage(string);
        this.hKf.setPositiveButton(this.bkx.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.n.d.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hKf.setCancelable(false);
        this.hKf.setCanceledOnTouchOutside(false);
        this.hKf.isShowTitleAndMessage();
        this.hKf.create(this.bkx);
        this.hKf.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.bkx.getPageActivity().finish();
        this.hKe = null;
        this.hKf = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FA() {
        if (this.hKf != null) {
            this.hKf.dismiss();
            this.hKf = null;
        }
        this.hKe = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hGF != null) {
            this.hGF.a(i, str, i2, obj);
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

    public void cjn() {
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

    public void vX(int i) {
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

    public aw cjo() {
        return this.hJT;
    }

    public ab Fm() {
        return this.aDd;
    }

    public bd ciK() {
        return this.hJh;
    }

    public List<AlaLiveInfoData> cjp() {
        return this.hJU;
    }

    public v bTK() {
        return this.gOJ;
    }

    public void cH(List<Long> list) {
        if (!this.hKl) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
                com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
                if (this.aDd != null && this.aDd.mLiveInfo != null) {
                    aVar.setAudienceCount(this.aDd.mLiveInfo.audience_count);
                }
                aVar.setListIds(list);
                aVar.setParams();
                sendMessage(aVar);
            }
        }
    }

    public void cjq() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hJU) {
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
                if (this.hJU.size() == 1 && this.hJU.get(0).live_id == this.aDd.mLiveInfo.live_id) {
                    if (c(yVar) != null) {
                        this.hJU.clear();
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
        for (x xVar : yVar.aIs) {
            if (xVar != null && xVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hJU) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == xVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hJU.add(xVar.mLiveInfo);
                }
            }
        }
        if (this.hJU.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hJU.size() - 200; size < this.hJU.size(); size++) {
                arrayList.add(this.hJU.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hJU.clear();
                this.hJU.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(y yVar) {
        if (ListUtils.isEmpty(yVar.aIs)) {
            return null;
        }
        for (x xVar : yVar.aIs) {
            if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.live_id == this.aDd.mLiveInfo.live_id) {
                return xVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cjr() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hJU)) {
            return null;
        }
        if (this.hKg.isEmpty()) {
            arrayList.addAll(this.hJU);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hJU.size()) {
                    break;
                }
                if ((this.aDd == null || this.aDd.mLiveInfo == null || this.aDd.mLiveInfo.live_id != this.hJU.get(i2).live_id) && !this.hKg.contains(Long.valueOf(this.hJU.get(i2).live_id))) {
                    arrayList.add(this.hJU.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hKg.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hKg.size() >= this.hJU.size() - 4) {
                oG(false);
            }
        }
    }

    public void vY(int i) {
        this.hKb = i;
    }

    public void oG(boolean z) {
        if (!this.hKl) {
            if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.My().Mw()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hKh > 500) {
                    this.hKh = currentTimeMillis;
                    com.baidu.live.liveroom.c.d.My().MA().a("tieba", this.hJV, 20, this.hKC);
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
            if (currentTimeMillis - this.hKj >= 1800000) {
                this.hKi = currentTimeMillis;
                this.hKk = true;
            }
            if (this.hKk) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hJV);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hKi);
                httpMessage.setTag(this.hJO);
                sendMessage(httpMessage);
                this.hKj = currentTimeMillis;
            }
        }
    }

    public void eA(String str, String str2) {
        this.hJR.cj(true);
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
        aVar.Ag(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.HW("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        cjC();
    }

    public void aw(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.Ag(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        cjC();
    }

    public void HX(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        cjC();
    }

    public void fI(long j) {
        this.hJR.cj(false);
        this.hKh = 0L;
        this.hKc = null;
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
        if (!cjs()) {
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
            httpMessage.addParam("is_prettify", bt.b(com.baidu.live.ae.a.Qj().bAS) ? 1 : 2);
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
            httpMessage.addParam("im_uk", AccountManager.getUK(this.bkx.getPageActivity()));
            sendMessage(httpMessage);
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", "create_live", "author_liveroom", ""));
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                BdStatisticsManager.getInstance().newDebug("updatelive", 0L, null, "forum_name", str, "forum_id", str2, "description", str3, "is_location", Integer.valueOf(i), "lat", Double.toString(d), "lng", Double.toString(d2), "location_name", str4, "location_name_md5", str5, "is_to_tb_some", Integer.valueOf(i2), "cover", str6, "vcode", str7, "vcode_md5", str8, "is_test_live", Integer.valueOf(i3), UbcStatConstant.KEY_LIVE_TYPE, Integer.valueOf(i4), "screen_direction", Integer.valueOf(i5), "clarity", Integer.valueOf(i6), "game_id", str9, "game_name", str10);
            }
        }
    }

    private boolean cjs() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void cjt() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aDd == null) {
            this.aDd = new ab(alaLiveInfoCoreData);
            this.hJR.setAlaLiveShowData(this.aDd);
        }
        this.mLastLiveId = this.aDd.mLiveInfo.live_id;
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
        if (this.aDd == null) {
            this.aDd = new ab();
        }
        this.aDd.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aDd.aId = alaLivePersonData.mUserData;
        this.aDd.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aDd.aId != null && this.hJR != null) {
            this.hJR.S(this.aDd.aId.live_mark_info_new);
        }
        this.aDd.isHost = true;
        this.aDd.aIN = true;
        if (this.hJR != null) {
            this.hJR.setAlaLiveShowData(this.aDd);
        }
        cjA();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aDd));
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
        this.hJP.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hKB);
        MessageManager.getInstance().removeMessageRule(this.hKd);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.hJR.cj(true);
        this.hJS = null;
        this.bkx = null;
    }

    public void vZ(int i) {
        this.hJW = i;
        if (this.hJU.size() == 0) {
            this.hJW = 0;
        } else if (this.hJW < 0) {
            this.hJW = this.hJU.size() + this.hJW;
        } else {
            this.hJW %= this.hJU.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hJU.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hJU.size()) {
                    if (this.hJU.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hJW = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cju() {
        long j;
        if (this.aDd == null || this.aDd.mLiveInfo == null || this.hJU.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hJU.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDd.mLiveInfo.live_id;
    }

    public boolean cjv() {
        long j;
        if (this.aDd == null || this.aDd.mLiveInfo == null || this.hJU.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hJU.get(this.hJU.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDd.mLiveInfo.live_id;
    }

    public int cjw() {
        return this.hJW;
    }

    public int cjx() {
        return this.hJY;
    }

    public boolean cjy() {
        return this.hJZ == 1;
    }

    public AlaLiveInfoData cjz() {
        if (this.hJW >= this.hJU.size()) {
            this.hJW = this.hJU.size() - 1;
        }
        if (this.hJW < 0) {
            this.hJW = 0;
        }
        if (this.hJU.size() <= this.hJW) {
            if (this.aDd != null) {
                return this.aDd.mLiveInfo;
            }
            return null;
        }
        return this.hJU.get(this.hJW);
    }

    public void a(a aVar) {
        this.hGF = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.hJS != null) {
            this.hJS.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void t(com.baidu.live.im.data.b bVar) {
        if (this.aDd != null && this.aDd.mLiveInfo.live_type == 1) {
            Q(bVar);
        }
        if (this.hJS != null) {
            this.hJS.t(bVar);
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
    public void JE() {
        if (this.hJS != null) {
            this.hJS.JE();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void e(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        boolean z;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aDd);
        if (this.aDd != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aDd.aId;
            } else {
                alaLiveUserInfoData = this.aDd.aIz;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aDd.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (this.mIsHost || this.aDd.aIz == null || this.aDd.aIz.extInfoJson == null) {
                    z = false;
                } else {
                    z = this.aDd.aIz.extInfoJson.optInt("is_mysterious_man") == 1;
                }
                if (!z && !TbadkCoreApplication.getInst().isMobileBaidu() && this.aDd != null && this.aDd.aIz != null && this.aDd.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aDd.aIz.throneUid;
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
                this.hJR.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void cjA() {
        this.hJR.e(String.valueOf(this.aDd.mLiveInfo.getGroupID()), String.valueOf(this.aDd.mLiveInfo.getLastMsgID()), String.valueOf(this.aDd.mLiveInfo.getUserID()), String.valueOf(this.aDd.mLiveInfo.getLiveID()), this.aDd.mLiveInfo.appId);
    }

    public com.baidu.live.im.d cjB() {
        return this.hJR;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void cjC() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aDd != null) {
            try {
                if (this.aDd.mLiveSdkInfo != null && this.aDd.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, this.aDd.mLiveSdkInfo.mCastIds.chatMCastId);
                    jSONObject2.put("ensure_mcast_id", this.aDd.mLiveSdkInfo.mCastIds.ensureMCastId);
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

    public String cjD() {
        return this.hKc;
    }

    public void Hs(String str) {
        this.hKc = str;
    }

    public void HY(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                this.mType = new JSONObject(str).optString(AlaLastLiveroomInfo.KEY_LAST_FROM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
