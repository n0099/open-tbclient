package com.baidu.tieba.ala.liveroom.m;

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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ad;
import com.baidu.live.data.j;
import com.baidu.live.data.k;
import com.baidu.live.data.n;
import com.baidu.live.im.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.m;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.message.AlaUserAuthenVerifyInfoResponseMessage;
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
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.u.a;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.liveroom.data.h;
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
/* loaded from: classes3.dex */
public class c extends BdBaseModel implements d.a {
    private n aDK;
    private a fJp;
    private ad fLG;
    private long fMA;
    private HttpMessageListener fMB;
    private CustomMessageListener fMC;
    private HttpMessageListener fMD;
    private HttpMessageListener fME;
    private NetMessageListener fMF;
    private HttpMessageListener fMG;
    private NetMessageListener fMH;
    private HttpMessageListener fMI;
    private HttpMessageListener fMJ;
    private NetMessageListener fMK;
    private NetMessageListener fML;
    private HttpMessageListener fMM;
    private CustomMessageListener fMN;
    private HttpMessageListener fMO;
    private HttpMessageListener fMP;
    private com.baidu.live.liveroom.c.a fMQ;
    private BdUniqueId fMg;
    private Handler fMh;
    private HttpMessage fMi;
    private final com.baidu.live.im.d fMj;
    private d.a fMk;
    private h fMl;
    private List<AlaLiveInfoData> fMm;
    private int fMn;
    private long fMo;
    private int fMp;
    private boolean fMq;
    private int fMr;
    private int fMs;
    private String fMt;
    private int fMu;
    private int fMv;
    private com.baidu.live.t.a fMw;
    private AlaGetVerifyStrategyResponseHttpMessage fMx;
    private BdAlertDialog fMy;
    private Set<Long> fMz;
    private CustomMessageListener fae;
    private com.baidu.live.data.h fbH;
    private HttpMessageListener ftL;
    private boolean mIsHost;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.fMh = new Handler();
        this.fMn = 0;
        this.fMp = 0;
        this.fMq = true;
        this.fMr = 1;
        this.fMs = 0;
        this.fMu = -1;
        this.fMv = 0;
        this.fMw = new com.baidu.live.t.a(0);
        this.otherParams = "";
        this.fae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.aDK != null && c.this.aDK.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.aDK.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.fMu = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.aDK.mLiveInfo.user_id).param("obj_param1", c.this.aDK.mLiveInfo.live_id).param("tid", c.this.aDK.mLiveInfo.thread_id));
                            c.this.fMu = 1;
                        }
                        if (c.this.aDK != null && c.this.aDK.aqm != null) {
                            c.this.aDK.aqm.follow_status = c.this.fMu;
                        }
                    }
                }
            }
        };
        this.fMB = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.m.c.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.aQw == 1 && alaUserAuthenVerifyInfoResponseMessage.aQv != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.aQv.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.aQv.verify_video_status == 1) {
                            c.this.fMr = 4;
                        }
                    }
                }
            }
        };
        this.fMC = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.m.c.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    try {
                        JSONObject optJSONObject = new JSONObject((String) customResponsedMessage.getData()).optJSONObject("result").optJSONObject("zbwhitelistapi").optJSONObject("data");
                        boolean optBoolean = optJSONObject.optBoolean("inwhite");
                        int optInt = optJSONObject.optInt("is_verified");
                        c.this.fMt = optJSONObject.optString("cmd");
                        if (optInt != 1) {
                            c.this.fMh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.byY();
                                }
                            }, 200L);
                        } else if (!optBoolean) {
                            c.this.fMh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.24.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.byZ();
                                }
                            }, 200L);
                        } else {
                            c.this.byW();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.fMD = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.m.c.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1003303);
                        }
                    });
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    c.this.fMs = alaGetVerifyStrategyResponseHttpMessage.fLN;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fLL == 1 && alaGetVerifyStrategyResponseHttpMessage.fLJ == 1) {
                            c.this.fMx = null;
                            return;
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && alaGetVerifyStrategyResponseHttpMessage.fLL == 1 && alaGetVerifyStrategyResponseHttpMessage.fLJ == 1 && alaGetVerifyStrategyResponseHttpMessage.fLO == 1) {
                        c.this.fMx = null;
                        return;
                    }
                    c.this.fMx = alaGetVerifyStrategyResponseHttpMessage;
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fLL != 1 || alaGetVerifyStrategyResponseHttpMessage.fLJ != 1) {
                            c.this.fMh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.byZ();
                                }
                            }, 200L);
                        }
                    } else if (!TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isOther()) {
                        c.this.fMh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.5
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bzb();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.fLO != 1) {
                        c.this.fMh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.3
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.byY();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.fLL != 1 || alaGetVerifyStrategyResponseHttpMessage.fLJ != 1) {
                        c.this.fMh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.4
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.byZ();
                            }
                        }, 200L);
                    }
                }
            }
        };
        this.fME = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.m.c.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String byJ;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.byH() == 1 || masterIdentityResponseMessage.byI() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.byJ())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.byJ());
                            jSONObject.put("content_type", "custom_master_identity");
                            byJ = jSONObject.toString();
                        } catch (JSONException e) {
                            byJ = masterIdentityResponseMessage.byJ();
                            e.printStackTrace();
                        }
                        c.this.fMj.a(27, byJ, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.fMF = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.m.c.27
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.fMG = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.m.c.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.fMq = false;
                }
            }
        };
        this.fMH = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.m.c.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        c.this.aDK = alaEnterLiveHttpResonseMessage.DM();
                        c.this.fLG = alaEnterLiveHttpResonseMessage.byC();
                        c.this.fMj.e(c.this.aDK);
                    }
                    if (c.this.aDK != null && c.this.aDK.mLiveInfo != null && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                        if (!TbadkCoreApplication.getInst().isOther()) {
                            com.baidu.tieba.ala.liveroom.task.c.bAb().dH(c.this.aDK.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(c.this.aDK.mLiveInfo.live_id);
                    }
                    if (c.this.aDK != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.aDK.aqD != null) {
                            if (c.this.aDK.aqD.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.aDK.aqD.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aDK.aqD.nickName);
                            if (!TextUtils.isEmpty(c.this.aDK.aqD.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.aDK.aqD.portrait);
                            }
                        }
                        if (c.this.aDK.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.aDK.mLiveSdkInfo.tbs);
                            com.baidu.live.c.tG().putString("ala_account_user_tbs", c.this.aDK.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.aDK != null) {
                        if (c.this.fMm.size() <= 0) {
                            c.this.fMm.add(c.this.aDK.mLiveInfo);
                            c.this.fMz.add(Long.valueOf(c.this.aDK.mLiveInfo.getLiveID()));
                        }
                        c.this.g(c.this.aDK.mLiveInfo);
                        if (c.this.fMj != null) {
                            c.this.fMj.E(c.this.aDK.aqI);
                        }
                    }
                    if (c.this.aDK != null && c.this.aDK.aqm != null) {
                        c.this.fMu = c.this.aDK.aqm.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.aDK);
                    if (c.this.aDK != null && c.this.aDK.mLiveInfo != null) {
                        c.this.bzq();
                    }
                    if (c.this.aDK != null) {
                        c.this.aDK.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aDK));
                        m.Bo().H(c.this.aDK.aqI);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.aDK != null && c.this.aDK.mLiveInfo != null) {
                            long j2 = c.this.aDK.mLiveInfo.live_id;
                            long j3 = c.this.aDK.mLiveInfo.room_id;
                            String str = c.this.aDK.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.aDK.aqk != null) {
                                long j4 = c.this.aDK.aqk.userId;
                                str2 = c.this.aDK.aqk.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.aDK != null && c.this.aDK.mLiveInfo != null) {
                        long j5 = c.this.aDK.mLiveInfo.live_id;
                        long j6 = c.this.aDK.mLiveInfo.room_id;
                        String str3 = c.this.aDK.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.aDK.aqk != null) {
                            j = c.this.aDK.aqk.userId;
                            str4 = c.this.aDK.aqk.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.fMp + "");
                    }
                }
            }
        };
        this.fMI = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.m.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    com.baidu.live.data.h hVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        hVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bnp();
                    }
                    if (hVar != null) {
                        c.this.fbH = hVar;
                    }
                    if (c.this.aDK != null && c.this.aDK.aqm != null) {
                        if (c.this.fMu == -1) {
                            c.this.fMu = c.this.aDK.aqm.follow_status;
                        }
                        if (c.this.aDK.aqm.follow_status != c.this.fMu) {
                            c.this.aDK.aqm.follow_status = c.this.fMu;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.fbH);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.fbH));
                }
            }
        };
        this.fMJ = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.m.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> byG = alaUserLiveMarkInfoResponseMessage.byG();
                        c.this.fMj.E(byG);
                        if (c.this.aDK != null) {
                            c.this.aDK.aqI = byG;
                            m.Bo().H(c.this.aDK.aqI);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.aDK));
                        }
                    }
                }
            }
        };
        this.fMK = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.m.c.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    n DM = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).DM() : null;
                    if (DM == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, DM);
                        return;
                    }
                    if (c.this.aDK == null) {
                        c.this.aDK = DM;
                        c.this.fMj.e(c.this.aDK);
                    }
                    if (c.this.aDK.mLiveInfo != null && DM.mLiveInfo != null && c.this.aDK.mLiveInfo.user_id == DM.mLiveInfo.user_id) {
                        if (c.this.aDK.mLiveInfo.imEffect != null && DM.mLiveInfo.imEffect == null) {
                            DM.mLiveInfo.imEffect = c.this.aDK.mLiveInfo.imEffect;
                        }
                        if (c.this.aDK.mLiveInfo.mLiveCloseData != null && DM.mLiveInfo.mLiveCloseData == null) {
                            DM.mLiveInfo.mLiveCloseData = c.this.aDK.mLiveInfo.mLiveCloseData;
                        }
                        if (c.this.aDK.mLiveInfo.mAlaLiveSwitchData != null && DM.mLiveInfo.mAlaLiveSwitchData == null) {
                            DM.mLiveInfo.mAlaLiveSwitchData = c.this.aDK.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    c.this.aDK.mLiveInfo = DM.mLiveInfo;
                    c.this.aDK.aqk = DM.aqk;
                    c.this.aDK.aql = DM.aql;
                    c.this.aDK.aqo = DM.aqo;
                    c.this.aDK.aqJ = DM.aqJ;
                    c.this.aDK.aqH = DM.aqH;
                    c.this.aDK.aqG = DM.aqG;
                    if (DM.aqN != null && DM.aqN.atP != null && !DM.aqN.atP.isEmpty()) {
                        c.this.aDK.aqN = DM.aqN;
                    }
                    if (DM.aqD != null) {
                        if (DM.aqD.userId == 0) {
                            if (c.this.aDK.aqD == null) {
                                c.this.aDK.aqD = new AlaLiveUserInfoData();
                            }
                            c.this.aDK.aqD.throneUid = DM.aqD.throneUid;
                        } else {
                            boolean z = DM.aqD.isNewUser;
                            if (c.this.aDK.aqD != null) {
                                z = c.this.aDK.aqD.isNewUser;
                            }
                            DM.aqD.isNewUser = z;
                            c.this.aDK.aqD = DM.aqD;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aDK.aqD.nickName);
                        }
                    }
                    if (DM.aqF != null) {
                        c.this.aDK.aqF = DM.aqF;
                    }
                    if (DM.aqH) {
                        c.this.aDK.aqI = DM.aqI;
                        if (c.this.fMj != null) {
                            c.this.fMj.E(DM.aqI);
                        }
                    }
                    if (!c.this.mIsHost && c.this.aDK.mLiveInfo != null) {
                        int i = c.this.aDK.mLiveInfo.backstage_type;
                        if (c.this.fMj != null) {
                            c.this.fMj.eC(String.valueOf(i));
                        }
                    }
                    if (c.this.fMj != null) {
                        c.this.fMj.e(c.this.aDK);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.aDK);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.aDK));
                    if (c.this.aDK != null) {
                        m.Bo().H(c.this.aDK.aqI);
                    }
                }
            }
        };
        this.fML = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.m.c.6
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
                    if (list != null && list.size() > 0 && c.this.fMm != null && c.this.fMm.size() > 0) {
                        for (int size = c.this.fMm.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.fMm.get(size)).live_id != c.this.aDK.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.fMm.get(size)).getLiveID()))) {
                                c.this.fMm.remove(size);
                            }
                        }
                    }
                    if (c.this.aDK != null) {
                        c.this.g(c.this.aDK.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.ftL = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.m.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.fMM = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.m.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.fMi = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.fMl = alaUpdateLiveTbResponseMessage.byF();
                    if (c.this.fMl != null) {
                        if (c.this.fMl.fFR != 1 || c.this.fMl.fFT != 1) {
                            c.this.fMh.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bza();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.fMl.aqk != null) {
                            c.this.fMj.E(c.this.fMl.aqk.live_mark_info_new);
                        }
                        if (c.this.fMl.mErrorCode != 0) {
                            if (c.this.fMl.mErrorCode == 220012) {
                                c.this.b(c.this.fMl.mErrorCode, c.this.fMl.mErrorMsg, 6, c.this.aDK);
                                return;
                            }
                        } else {
                            c.this.aDK = new n();
                            c.this.fMj.e(c.this.aDK);
                            c.this.aDK.mLiveInfo = c.this.fMl.mLiveInfo;
                            c.this.aDK.aqk = c.this.fMl.aqk;
                            c.this.aDK.mLiveSdkInfo = c.this.fMl.mLiveSdkInfo;
                            c.this.aDK.aqK = c.this.fMl.aqK;
                            c.this.aDK.aqI = c.this.fMl.aqk.live_mark_info_new;
                            if (c.this.fMl.aqk != null && c.this.fMl.aqk.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.fMl.aqk.levelId);
                            }
                            c.this.aDK.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aDK));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.aDK);
                    if (c.this.fMl != null && c.this.fMl.mLiveInfo != null) {
                        c.this.bzq();
                    }
                    if (c.this.aDK != null && c.this.aDK.mLiveInfo != null) {
                        c.this.x(c.this.aDK.mLiveInfo.user_id, c.this.aDK.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.fMN = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.m.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.fMj.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.fMO = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.m.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.l.b)) {
                    com.baidu.live.l.b bVar = (com.baidu.live.l.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.aRe != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.aRe.eK(bVar.contentType);
                        } else {
                            bVar.aRe.b(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.fMP = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.m.c.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                k kVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        kVar = null;
                    } else {
                        kVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).byD();
                    }
                    if (kVar != null && !ListUtils.isEmpty(kVar.aqv)) {
                        c.this.fMn = kVar.pn + 1;
                        j jVar = kVar.aqv.get(kVar.aqv.size() - 1);
                        if (jVar != null) {
                            c.this.fMo = jVar.mLiveInfo.live_id;
                        }
                        c.this.a(kVar);
                        if (c.this.aDK != null) {
                            c.this.g(c.this.aDK.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, kVar);
                    }
                }
            }
        };
        this.fMQ = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.m.c.21
        };
        this.mPageContext = bdPageContext;
        this.fMj = new com.baidu.live.im.d(bdPageContext, false, this);
        this.fMm = new ArrayList();
        this.fMz = new HashSet();
        initTasks();
        registerListener(this.fMK);
        registerListener(this.fMI);
        registerListener(this.fMH);
        registerListener(this.fMF);
        this.fMg = BdUniqueId.gen();
        this.fMP.setTag(this.fMg);
        registerListener(this.fMP);
        registerListener(this.fML);
        registerListener(this.fMG);
        registerListener(this.fMM);
        registerListener(this.ftL);
        registerListener(this.fMD);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.fMC);
        }
        registerListener(this.fMB);
        registerListener(this.fae);
        registerListener(this.fMJ);
        registerListener(this.fME);
        registerListener(this.fMN);
        registerListener(this.fMO);
        MessageManager.getInstance().addMessageRule(this.fMw);
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
        byM();
        byN();
        byO();
        byP();
        byS();
    }

    private void byM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void byN() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void byO() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void byP() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void byQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.m.c.12
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

    public void byR() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void byS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void byT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.22
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.l.b) && c.this.aDK != null && c.this.aDK.mLiveInfo != null) {
                    com.baidu.live.l.b bVar = (com.baidu.live.l.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", c.this.aDK.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.aRd != null) {
                        httpMessage.addParam("ext_data", bVar.aRd.toString());
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

    public void byU() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void x(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void byV() {
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

    public void byW() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
    }

    public void byX() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void byY() {
        if (this.fMy != null) {
            this.fMy.dismiss();
            this.fMy = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.fMy = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fMy.setAutoNight(false);
        this.fMy.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.fMy.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.11
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.byX();
                    c.this.xk();
                }
            });
            this.fMy.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.xk();
                }
            });
        } else {
            this.fMy.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.xk();
                }
            });
        }
        this.fMy.setCancelable(false);
        this.fMy.setCanceledOnTouchOutside(false);
        this.fMy.setTitleShowCenter(true);
        this.fMy.setMessageShowCenter(true);
        this.fMy.isShowTitleAndMessage();
        this.fMy.create(this.mPageContext);
        this.fMy.show();
    }

    public void byZ() {
        if (this.fMy != null) {
            this.fMy.dismiss();
            this.fMy = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.fMy = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fMy.setAutoNight(false);
        this.fMy.setMessage(string);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fMy.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.xk();
                }
            });
        } else {
            this.fMy.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str = com.baidu.live.v.a.En().aQu.asW;
                        if (!TextUtils.isEmpty(str)) {
                            BrowserHelper.startInternalWebActivity(c.this.mPageContext.getPageActivity(), str);
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
                    c.this.xk();
                }
            });
            this.fMy.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.xk();
                }
            });
        }
        this.fMy.setCancelable(false);
        this.fMy.setCanceledOnTouchOutside(false);
        this.fMy.setTitleShowCenter(true);
        this.fMy.setMessageShowCenter(true);
        this.fMy.isShowTitleAndMessage();
        this.fMy.create(this.mPageContext);
        this.fMy.show();
    }

    public void bza() {
        if (this.fMy != null) {
            this.fMy.dismiss();
            this.fMy = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fMy = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fMy.setAutoNight(false);
        this.fMy.setMessage(string);
        this.fMy.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fMy.setCancelable(false);
        this.fMy.setCanceledOnTouchOutside(false);
        this.fMy.isShowTitleAndMessage();
        this.fMy.create(this.mPageContext);
        this.fMy.show();
    }

    public void bzb() {
        if (this.fMy != null) {
            this.fMy.dismiss();
            this.fMy = null;
        }
        if (this.fMx != null) {
            a(this.fMx);
        }
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fMy = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fMy.setAutoNight(false);
        this.fMy.setMessage(string);
        this.fMy.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fMy.setCancelable(false);
        this.fMy.setCanceledOnTouchOutside(false);
        this.fMy.isShowTitleAndMessage();
        this.fMy.create(this.mPageContext);
        this.fMy.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.fMx = null;
        this.fMy = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xk() {
        if (this.fMy != null) {
            this.fMy.dismiss();
            this.fMy = null;
        }
        this.fMx = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.fJp != null) {
            this.fJp.a(i, str, i2, obj);
        }
    }

    public void dF(long j) {
        com.baidu.tieba.ala.liveroom.messages.b bVar = new com.baidu.tieba.ala.liveroom.messages.b();
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.setFrom(str);
        bVar.aj(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void bzc() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public void j(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021077);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("net_status", i);
        sendMessage(httpMessage);
    }

    public void qR(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void y(long j, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.aj(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public h bzd() {
        return this.fMl;
    }

    public n DM() {
        return this.aDK;
    }

    public ad byC() {
        return this.fLG;
    }

    public List<AlaLiveInfoData> bze() {
        return this.fMm;
    }

    public com.baidu.live.data.h bnp() {
        return this.fbH;
    }

    public void bO(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aDK != null && this.aDK.mLiveInfo != null) {
                aVar.setAudienceCount(this.aDK.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bzf() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.fMm) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        bO(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar) {
        if (kVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
                if (this.fMm.size() == 1 && this.fMm.get(0).live_id == this.aDK.mLiveInfo.live_id) {
                    if (c(kVar) != null) {
                        this.fMm.clear();
                    }
                    b(kVar);
                    return;
                }
                b(kVar);
                return;
            }
            b(kVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(k kVar) {
        boolean z;
        for (j jVar : kVar.aqv) {
            if (jVar != null && jVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.fMm) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == jVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.fMm.add(jVar.mLiveInfo);
                }
            }
        }
        if (this.fMm.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.fMm.size() - 200; size < this.fMm.size(); size++) {
                arrayList.add(this.fMm.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.fMm.clear();
                this.fMm.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(k kVar) {
        if (ListUtils.isEmpty(kVar.aqv)) {
            return null;
        }
        for (j jVar : kVar.aqv) {
            if (jVar != null && jVar.mLiveInfo != null && jVar.mLiveInfo.live_id == this.aDK.mLiveInfo.live_id) {
                return jVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bzg() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.fMm)) {
            return null;
        }
        if (this.fMz.isEmpty()) {
            arrayList.addAll(this.fMm);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fMm.size()) {
                    break;
                }
                if ((this.aDK == null || this.aDK.mLiveInfo == null || this.aDK.mLiveInfo.live_id != this.fMm.get(i2).live_id) && !this.fMz.contains(Long.valueOf(this.fMm.get(i2).live_id))) {
                    arrayList.add(this.fMm.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void f(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.fMz.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.fMz.size() >= this.fMm.size() - 4) {
                kM(false);
            }
        }
    }

    public void qS(int i) {
        this.fMv = i;
    }

    public int bzh() {
        return this.fMv;
    }

    public void kM(boolean z) {
        if (com.baidu.live.liveroom.c.d.Dp().Dn()) {
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && 1 != this.fMv) {
                kN(z);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.fMA > 500) {
                this.fMA = currentTimeMillis;
                com.baidu.live.liveroom.c.d.Dp().Dr().a("tieba", this.fMn, 20, this.fMQ);
                return;
            }
            return;
        }
        kN(z);
    }

    private void kN(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.fMn);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.fMo);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.fMg);
            sendMessage(httpMessage);
        }
    }

    public void di(String str, String str2) {
        this.fMj.AJ();
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
        aVar.tU(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void ab(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.tU(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void AT(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.eH(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void dG(long j) {
        this.fMj.AJ();
        this.fMA = 0L;
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
        if (!bzi()) {
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
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                BdStatisticsManager.getInstance().newDebug("updatelive", 0L, null, "forum_name", str, "forum_id", str2, "description", str3, "is_location", Integer.valueOf(i), "lat", Double.toString(d), "lng", Double.toString(d2), "location_name", str4, "location_name_md5", str5, "is_to_tb_some", Integer.valueOf(i2), "cover", str6, "vcode", str7, "vcode_md5", str8, "is_test_live", Integer.valueOf(i3), "live_type", Integer.valueOf(i4), AlaLiveRoomActivityConfig.SDK_EXTRA_SCREEN_DIRECTION, Integer.valueOf(i5), "clarity", Integer.valueOf(i6), "game_id", str9, "game_name", str10);
            }
        }
    }

    private boolean bzi() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bzj() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aDK == null) {
            this.aDK = new n(alaLiveInfoCoreData);
            this.fMj.e(this.aDK);
        }
        this.fMo = this.aDK.mLiveInfo.live_id;
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
        if (this.aDK == null) {
            this.aDK = new n();
        }
        this.aDK.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aDK.aqk = alaLivePersonData.mUserData;
        this.aDK.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aDK.aqk != null && this.fMj != null) {
            this.fMj.E(this.aDK.aqk.live_mark_info_new);
        }
        this.aDK.isHost = true;
        this.aDK.aqL = true;
        this.fMj.e(this.aDK);
        bzq();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aDK));
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
        this.fMh.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.fMP);
        MessageManager.getInstance().removeMessageRule(this.fMw);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        this.fMj.AJ();
        this.fMk = null;
        this.mPageContext = null;
    }

    public void qT(int i) {
        this.fMp = i;
        if (this.fMm.size() == 0) {
            this.fMp = 0;
        } else if (this.fMp < 0) {
            this.fMp = this.fMm.size() + this.fMp;
        } else {
            this.fMp %= this.fMm.size();
        }
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.fMm.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fMm.size()) {
                    if (this.fMm.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.fMp = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bzk() {
        long j;
        if (this.aDK == null || this.aDK.mLiveInfo == null || this.fMm.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.fMm.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDK.mLiveInfo.live_id;
    }

    public boolean bzl() {
        long j;
        if (this.aDK == null || this.aDK.mLiveInfo == null || this.fMm.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.fMm.get(this.fMm.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDK.mLiveInfo.live_id;
    }

    public int bzm() {
        return this.fMp;
    }

    public int bzn() {
        return this.fMr;
    }

    public boolean bzo() {
        return this.fMs == 1;
    }

    public AlaLiveInfoData bzp() {
        if (this.fMp >= this.fMm.size()) {
            this.fMp = this.fMm.size() - 1;
        }
        if (this.fMp < 0) {
            this.fMp = 0;
        }
        if (this.fMm.size() <= this.fMp) {
            if (this.aDK != null) {
                return this.aDK.mLiveInfo;
            }
            return null;
        }
        return this.fMm.get(this.fMp);
    }

    public void a(a aVar) {
        this.fJp = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.fMk != null) {
            this.fMk.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void k(com.baidu.live.im.data.a aVar) {
        if (this.aDK != null && this.aDK.mLiveInfo.live_type == 1) {
            y(aVar);
        }
        if (this.fMk != null) {
            this.fMk.k(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void y(com.baidu.live.im.data.a aVar) {
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
            kM(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void AM() {
        if (this.fMk != null) {
            this.fMk.AM();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aDK);
        if (this.aDK != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aDK.aqk;
            } else {
                alaLiveUserInfoData = this.aDK.aqD;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aDK.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aDK != null && this.aDK.aqD != null && this.aDK.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aDK.aqD.throneUid;
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
                this.fMj.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void bzq() {
        this.fMj.e(String.valueOf(this.aDK.mLiveInfo.getGroupID()), String.valueOf(this.aDK.mLiveInfo.getLastMsgID()), String.valueOf(this.aDK.mLiveInfo.getUserID()), String.valueOf(this.aDK.mLiveInfo.getLiveID()), this.aDK.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bzr() {
        return this.fMj;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
