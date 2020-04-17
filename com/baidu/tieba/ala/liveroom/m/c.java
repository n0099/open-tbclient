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
    private n aDE;
    private CustomMessageListener eZZ;
    private a fJk;
    private ad fLB;
    private NetMessageListener fMA;
    private HttpMessageListener fMB;
    private NetMessageListener fMC;
    private HttpMessageListener fMD;
    private HttpMessageListener fME;
    private NetMessageListener fMF;
    private NetMessageListener fMG;
    private HttpMessageListener fMH;
    private CustomMessageListener fMI;
    private HttpMessageListener fMJ;
    private HttpMessageListener fMK;
    private com.baidu.live.liveroom.c.a fML;
    private BdUniqueId fMb;
    private Handler fMc;
    private HttpMessage fMd;
    private final com.baidu.live.im.d fMe;
    private d.a fMf;
    private h fMg;
    private List<AlaLiveInfoData> fMh;
    private int fMi;
    private long fMj;
    private int fMk;
    private boolean fMl;
    private int fMm;
    private int fMn;
    private String fMo;
    private int fMp;
    private int fMq;
    private com.baidu.live.t.a fMr;
    private AlaGetVerifyStrategyResponseHttpMessage fMs;
    private BdAlertDialog fMt;
    private Set<Long> fMu;
    private long fMv;
    private HttpMessageListener fMw;
    private CustomMessageListener fMx;
    private HttpMessageListener fMy;
    private HttpMessageListener fMz;
    private com.baidu.live.data.h fbC;
    private HttpMessageListener ftG;
    private boolean mIsHost;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.fMc = new Handler();
        this.fMi = 0;
        this.fMk = 0;
        this.fMl = true;
        this.fMm = 1;
        this.fMn = 0;
        this.fMp = -1;
        this.fMq = 0;
        this.fMr = new com.baidu.live.t.a(0);
        this.otherParams = "";
        this.eZZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.aDE != null && c.this.aDE.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.aDE.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.fMp = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.aDE.mLiveInfo.user_id).param("obj_param1", c.this.aDE.mLiveInfo.live_id).param("tid", c.this.aDE.mLiveInfo.thread_id));
                            c.this.fMp = 1;
                        }
                        if (c.this.aDE != null && c.this.aDE.aqg != null) {
                            c.this.aDE.aqg.follow_status = c.this.fMp;
                        }
                    }
                }
            }
        };
        this.fMw = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.m.c.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.aQr == 1 && alaUserAuthenVerifyInfoResponseMessage.aQq != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.aQq.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.aQq.verify_video_status == 1) {
                            c.this.fMm = 4;
                        }
                    }
                }
            }
        };
        this.fMx = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.m.c.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    try {
                        JSONObject optJSONObject = new JSONObject((String) customResponsedMessage.getData()).optJSONObject("result").optJSONObject("zbwhitelistapi").optJSONObject("data");
                        boolean optBoolean = optJSONObject.optBoolean("inwhite");
                        int optInt = optJSONObject.optInt("is_verified");
                        c.this.fMo = optJSONObject.optString("cmd");
                        if (optInt != 1) {
                            c.this.fMc.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bza();
                                }
                            }, 200L);
                        } else if (!optBoolean) {
                            c.this.fMc.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.24.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bzb();
                                }
                            }, 200L);
                        } else {
                            c.this.byY();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.fMy = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.m.c.25
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
                    c.this.fMn = alaGetVerifyStrategyResponseHttpMessage.fLI;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fLG == 1 && alaGetVerifyStrategyResponseHttpMessage.fLE == 1) {
                            c.this.fMs = null;
                            return;
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && alaGetVerifyStrategyResponseHttpMessage.fLG == 1 && alaGetVerifyStrategyResponseHttpMessage.fLE == 1 && alaGetVerifyStrategyResponseHttpMessage.fLJ == 1) {
                        c.this.fMs = null;
                        return;
                    }
                    c.this.fMs = alaGetVerifyStrategyResponseHttpMessage;
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fLG != 1 || alaGetVerifyStrategyResponseHttpMessage.fLE != 1) {
                            c.this.fMc.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bzb();
                                }
                            }, 200L);
                        }
                    } else if (!TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isOther()) {
                        c.this.fMc.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.5
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bzd();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.fLJ != 1) {
                        c.this.fMc.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.3
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bza();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.fLG != 1 || alaGetVerifyStrategyResponseHttpMessage.fLE != 1) {
                        c.this.fMc.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.4
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bzb();
                            }
                        }, 200L);
                    }
                }
            }
        };
        this.fMz = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.m.c.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String byL;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.byJ() == 1 || masterIdentityResponseMessage.byK() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.byL())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.byL());
                            jSONObject.put("content_type", "custom_master_identity");
                            byL = jSONObject.toString();
                        } catch (JSONException e) {
                            byL = masterIdentityResponseMessage.byL();
                            e.printStackTrace();
                        }
                        c.this.fMe.a(27, byL, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.fMA = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.m.c.27
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.fMB = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.m.c.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.fMl = false;
                }
            }
        };
        this.fMC = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.m.c.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        c.this.aDE = alaEnterLiveHttpResonseMessage.DN();
                        c.this.fLB = alaEnterLiveHttpResonseMessage.byE();
                        c.this.fMe.e(c.this.aDE);
                    }
                    if (c.this.aDE != null && c.this.aDE.mLiveInfo != null && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                        if (!TbadkCoreApplication.getInst().isOther()) {
                            com.baidu.tieba.ala.liveroom.task.c.bAd().dH(c.this.aDE.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(c.this.aDE.mLiveInfo.live_id);
                    }
                    if (c.this.aDE != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.aDE.aqx != null) {
                            if (c.this.aDE.aqx.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.aDE.aqx.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aDE.aqx.nickName);
                            if (!TextUtils.isEmpty(c.this.aDE.aqx.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.aDE.aqx.portrait);
                            }
                        }
                        if (c.this.aDE.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.aDE.mLiveSdkInfo.tbs);
                            com.baidu.live.c.tH().putString("ala_account_user_tbs", c.this.aDE.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.aDE != null) {
                        if (c.this.fMh.size() <= 0) {
                            c.this.fMh.add(c.this.aDE.mLiveInfo);
                            c.this.fMu.add(Long.valueOf(c.this.aDE.mLiveInfo.getLiveID()));
                        }
                        c.this.g(c.this.aDE.mLiveInfo);
                        if (c.this.fMe != null) {
                            c.this.fMe.E(c.this.aDE.aqC);
                        }
                    }
                    if (c.this.aDE != null && c.this.aDE.aqg != null) {
                        c.this.fMp = c.this.aDE.aqg.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.aDE);
                    if (c.this.aDE != null && c.this.aDE.mLiveInfo != null) {
                        c.this.bzs();
                    }
                    if (c.this.aDE != null) {
                        c.this.aDE.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aDE));
                        m.Bp().H(c.this.aDE.aqC);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.aDE != null && c.this.aDE.mLiveInfo != null) {
                            long j2 = c.this.aDE.mLiveInfo.live_id;
                            long j3 = c.this.aDE.mLiveInfo.room_id;
                            String str = c.this.aDE.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.aDE.aqe != null) {
                                long j4 = c.this.aDE.aqe.userId;
                                str2 = c.this.aDE.aqe.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.aDE != null && c.this.aDE.mLiveInfo != null) {
                        long j5 = c.this.aDE.mLiveInfo.live_id;
                        long j6 = c.this.aDE.mLiveInfo.room_id;
                        String str3 = c.this.aDE.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.aDE.aqe != null) {
                            j = c.this.aDE.aqe.userId;
                            str4 = c.this.aDE.aqe.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.fMk + "");
                    }
                }
            }
        };
        this.fMD = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.m.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    com.baidu.live.data.h hVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        hVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bnr();
                    }
                    if (hVar != null) {
                        c.this.fbC = hVar;
                    }
                    if (c.this.aDE != null && c.this.aDE.aqg != null) {
                        if (c.this.fMp == -1) {
                            c.this.fMp = c.this.aDE.aqg.follow_status;
                        }
                        if (c.this.aDE.aqg.follow_status != c.this.fMp) {
                            c.this.aDE.aqg.follow_status = c.this.fMp;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.fbC);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.fbC));
                }
            }
        };
        this.fME = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.m.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> byI = alaUserLiveMarkInfoResponseMessage.byI();
                        c.this.fMe.E(byI);
                        if (c.this.aDE != null) {
                            c.this.aDE.aqC = byI;
                            m.Bp().H(c.this.aDE.aqC);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.aDE));
                        }
                    }
                }
            }
        };
        this.fMF = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.m.c.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    n DN = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).DN() : null;
                    if (DN == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, DN);
                        return;
                    }
                    if (c.this.aDE == null) {
                        c.this.aDE = DN;
                        c.this.fMe.e(c.this.aDE);
                    }
                    if (c.this.aDE.mLiveInfo != null && DN.mLiveInfo != null && c.this.aDE.mLiveInfo.user_id == DN.mLiveInfo.user_id) {
                        if (c.this.aDE.mLiveInfo.imEffect != null && DN.mLiveInfo.imEffect == null) {
                            DN.mLiveInfo.imEffect = c.this.aDE.mLiveInfo.imEffect;
                        }
                        if (c.this.aDE.mLiveInfo.mLiveCloseData != null && DN.mLiveInfo.mLiveCloseData == null) {
                            DN.mLiveInfo.mLiveCloseData = c.this.aDE.mLiveInfo.mLiveCloseData;
                        }
                        if (c.this.aDE.mLiveInfo.mAlaLiveSwitchData != null && DN.mLiveInfo.mAlaLiveSwitchData == null) {
                            DN.mLiveInfo.mAlaLiveSwitchData = c.this.aDE.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    c.this.aDE.mLiveInfo = DN.mLiveInfo;
                    c.this.aDE.aqe = DN.aqe;
                    c.this.aDE.aqf = DN.aqf;
                    c.this.aDE.aqi = DN.aqi;
                    c.this.aDE.aqD = DN.aqD;
                    c.this.aDE.aqB = DN.aqB;
                    c.this.aDE.aqA = DN.aqA;
                    if (DN.aqH != null && DN.aqH.atJ != null && !DN.aqH.atJ.isEmpty()) {
                        c.this.aDE.aqH = DN.aqH;
                    }
                    if (DN.aqx != null) {
                        if (DN.aqx.userId == 0) {
                            if (c.this.aDE.aqx == null) {
                                c.this.aDE.aqx = new AlaLiveUserInfoData();
                            }
                            c.this.aDE.aqx.throneUid = DN.aqx.throneUid;
                        } else {
                            boolean z = DN.aqx.isNewUser;
                            if (c.this.aDE.aqx != null) {
                                z = c.this.aDE.aqx.isNewUser;
                            }
                            DN.aqx.isNewUser = z;
                            c.this.aDE.aqx = DN.aqx;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aDE.aqx.nickName);
                        }
                    }
                    if (DN.aqz != null) {
                        c.this.aDE.aqz = DN.aqz;
                    }
                    if (DN.aqB) {
                        c.this.aDE.aqC = DN.aqC;
                        if (c.this.fMe != null) {
                            c.this.fMe.E(DN.aqC);
                        }
                    }
                    if (!c.this.mIsHost && c.this.aDE.mLiveInfo != null) {
                        int i = c.this.aDE.mLiveInfo.backstage_type;
                        if (c.this.fMe != null) {
                            c.this.fMe.eC(String.valueOf(i));
                        }
                    }
                    if (c.this.fMe != null) {
                        c.this.fMe.e(c.this.aDE);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.aDE);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.aDE));
                    if (c.this.aDE != null) {
                        m.Bp().H(c.this.aDE.aqC);
                    }
                }
            }
        };
        this.fMG = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.m.c.6
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
                    if (list != null && list.size() > 0 && c.this.fMh != null && c.this.fMh.size() > 0) {
                        for (int size = c.this.fMh.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.fMh.get(size)).live_id != c.this.aDE.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.fMh.get(size)).getLiveID()))) {
                                c.this.fMh.remove(size);
                            }
                        }
                    }
                    if (c.this.aDE != null) {
                        c.this.g(c.this.aDE.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.ftG = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.m.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.fMH = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.m.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.fMd = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.fMg = alaUpdateLiveTbResponseMessage.byH();
                    if (c.this.fMg != null) {
                        if (c.this.fMg.fFM != 1 || c.this.fMg.fFO != 1) {
                            c.this.fMc.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bzc();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.fMg.aqe != null) {
                            c.this.fMe.E(c.this.fMg.aqe.live_mark_info_new);
                        }
                        if (c.this.fMg.mErrorCode != 0) {
                            if (c.this.fMg.mErrorCode == 220012) {
                                c.this.b(c.this.fMg.mErrorCode, c.this.fMg.mErrorMsg, 6, c.this.aDE);
                                return;
                            }
                        } else {
                            c.this.aDE = new n();
                            c.this.fMe.e(c.this.aDE);
                            c.this.aDE.mLiveInfo = c.this.fMg.mLiveInfo;
                            c.this.aDE.aqe = c.this.fMg.aqe;
                            c.this.aDE.mLiveSdkInfo = c.this.fMg.mLiveSdkInfo;
                            c.this.aDE.aqE = c.this.fMg.aqE;
                            c.this.aDE.aqC = c.this.fMg.aqe.live_mark_info_new;
                            if (c.this.fMg.aqe != null && c.this.fMg.aqe.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.fMg.aqe.levelId);
                            }
                            c.this.aDE.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aDE));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.aDE);
                    if (c.this.fMg != null && c.this.fMg.mLiveInfo != null) {
                        c.this.bzs();
                    }
                    if (c.this.aDE != null && c.this.aDE.mLiveInfo != null) {
                        c.this.x(c.this.aDE.mLiveInfo.user_id, c.this.aDE.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.fMI = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.m.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.fMe.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.fMJ = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.m.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.l.b)) {
                    com.baidu.live.l.b bVar = (com.baidu.live.l.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.aQZ != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.aQZ.eK(bVar.contentType);
                        } else {
                            bVar.aQZ.b(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.fMK = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.m.c.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                k kVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        kVar = null;
                    } else {
                        kVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).byF();
                    }
                    if (kVar != null && !ListUtils.isEmpty(kVar.aqp)) {
                        c.this.fMi = kVar.pn + 1;
                        j jVar = kVar.aqp.get(kVar.aqp.size() - 1);
                        if (jVar != null) {
                            c.this.fMj = jVar.mLiveInfo.live_id;
                        }
                        c.this.a(kVar);
                        if (c.this.aDE != null) {
                            c.this.g(c.this.aDE.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, kVar);
                    }
                }
            }
        };
        this.fML = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.m.c.21
        };
        this.mPageContext = bdPageContext;
        this.fMe = new com.baidu.live.im.d(bdPageContext, false, this);
        this.fMh = new ArrayList();
        this.fMu = new HashSet();
        initTasks();
        registerListener(this.fMF);
        registerListener(this.fMD);
        registerListener(this.fMC);
        registerListener(this.fMA);
        this.fMb = BdUniqueId.gen();
        this.fMK.setTag(this.fMb);
        registerListener(this.fMK);
        registerListener(this.fMG);
        registerListener(this.fMB);
        registerListener(this.fMH);
        registerListener(this.ftG);
        registerListener(this.fMy);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.fMx);
        }
        registerListener(this.fMw);
        registerListener(this.eZZ);
        registerListener(this.fME);
        registerListener(this.fMz);
        registerListener(this.fMI);
        registerListener(this.fMJ);
        MessageManager.getInstance().addMessageRule(this.fMr);
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
        byO();
        byP();
        byQ();
        byR();
        byU();
    }

    private void byO() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void byP() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void byQ() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void byR() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void byS() {
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

    public void byT() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void byU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void byV() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.22
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.l.b) && c.this.aDE != null && c.this.aDE.mLiveInfo != null) {
                    com.baidu.live.l.b bVar = (com.baidu.live.l.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", c.this.aDE.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.aQY != null) {
                        httpMessage.addParam("ext_data", bVar.aQY.toString());
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

    public void byW() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void x(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void byX() {
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

    public void byY() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
    }

    public void byZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bza() {
        if (this.fMt != null) {
            this.fMt.dismiss();
            this.fMt = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.fMt = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fMt.setAutoNight(false);
        this.fMt.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.fMt.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.11
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.byZ();
                    c.this.xl();
                }
            });
            this.fMt.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.xl();
                }
            });
        } else {
            this.fMt.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.xl();
                }
            });
        }
        this.fMt.setCancelable(false);
        this.fMt.setCanceledOnTouchOutside(false);
        this.fMt.setTitleShowCenter(true);
        this.fMt.setMessageShowCenter(true);
        this.fMt.isShowTitleAndMessage();
        this.fMt.create(this.mPageContext);
        this.fMt.show();
    }

    public void bzb() {
        if (this.fMt != null) {
            this.fMt.dismiss();
            this.fMt = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.fMt = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fMt.setAutoNight(false);
        this.fMt.setMessage(string);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fMt.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.xl();
                }
            });
        } else {
            this.fMt.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str = com.baidu.live.v.a.Eo().aQp.asQ;
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
                    c.this.xl();
                }
            });
            this.fMt.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.xl();
                }
            });
        }
        this.fMt.setCancelable(false);
        this.fMt.setCanceledOnTouchOutside(false);
        this.fMt.setTitleShowCenter(true);
        this.fMt.setMessageShowCenter(true);
        this.fMt.isShowTitleAndMessage();
        this.fMt.create(this.mPageContext);
        this.fMt.show();
    }

    public void bzc() {
        if (this.fMt != null) {
            this.fMt.dismiss();
            this.fMt = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fMt = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fMt.setAutoNight(false);
        this.fMt.setMessage(string);
        this.fMt.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fMt.setCancelable(false);
        this.fMt.setCanceledOnTouchOutside(false);
        this.fMt.isShowTitleAndMessage();
        this.fMt.create(this.mPageContext);
        this.fMt.show();
    }

    public void bzd() {
        if (this.fMt != null) {
            this.fMt.dismiss();
            this.fMt = null;
        }
        if (this.fMs != null) {
            a(this.fMs);
        }
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fMt = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fMt.setAutoNight(false);
        this.fMt.setMessage(string);
        this.fMt.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fMt.setCancelable(false);
        this.fMt.setCanceledOnTouchOutside(false);
        this.fMt.isShowTitleAndMessage();
        this.fMt.create(this.mPageContext);
        this.fMt.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.fMs = null;
        this.fMt = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl() {
        if (this.fMt != null) {
            this.fMt.dismiss();
            this.fMt = null;
        }
        this.fMs = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.fJk != null) {
            this.fJk.a(i, str, i2, obj);
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

    public void bze() {
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

    public h bzf() {
        return this.fMg;
    }

    public n DN() {
        return this.aDE;
    }

    public ad byE() {
        return this.fLB;
    }

    public List<AlaLiveInfoData> bzg() {
        return this.fMh;
    }

    public com.baidu.live.data.h bnr() {
        return this.fbC;
    }

    public void bO(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aDE != null && this.aDE.mLiveInfo != null) {
                aVar.setAudienceCount(this.aDE.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bzh() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.fMh) {
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
                if (this.fMh.size() == 1 && this.fMh.get(0).live_id == this.aDE.mLiveInfo.live_id) {
                    if (c(kVar) != null) {
                        this.fMh.clear();
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
        for (j jVar : kVar.aqp) {
            if (jVar != null && jVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.fMh) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == jVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.fMh.add(jVar.mLiveInfo);
                }
            }
        }
        if (this.fMh.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.fMh.size() - 200; size < this.fMh.size(); size++) {
                arrayList.add(this.fMh.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.fMh.clear();
                this.fMh.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(k kVar) {
        if (ListUtils.isEmpty(kVar.aqp)) {
            return null;
        }
        for (j jVar : kVar.aqp) {
            if (jVar != null && jVar.mLiveInfo != null && jVar.mLiveInfo.live_id == this.aDE.mLiveInfo.live_id) {
                return jVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bzi() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.fMh)) {
            return null;
        }
        if (this.fMu.isEmpty()) {
            arrayList.addAll(this.fMh);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fMh.size()) {
                    break;
                }
                if ((this.aDE == null || this.aDE.mLiveInfo == null || this.aDE.mLiveInfo.live_id != this.fMh.get(i2).live_id) && !this.fMu.contains(Long.valueOf(this.fMh.get(i2).live_id))) {
                    arrayList.add(this.fMh.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void f(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.fMu.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.fMu.size() >= this.fMh.size() - 4) {
                kM(false);
            }
        }
    }

    public void qS(int i) {
        this.fMq = i;
    }

    public int bzj() {
        return this.fMq;
    }

    public void kM(boolean z) {
        if (com.baidu.live.liveroom.c.d.Dq().Do()) {
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && 1 != this.fMq) {
                kN(z);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.fMv > 500) {
                this.fMv = currentTimeMillis;
                com.baidu.live.liveroom.c.d.Dq().Ds().a("tieba", this.fMi, 20, this.fML);
                return;
            }
            return;
        }
        kN(z);
    }

    private void kN(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.fMi);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.fMj);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.fMb);
            sendMessage(httpMessage);
        }
    }

    public void di(String str, String str2) {
        this.fMe.AK();
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
        aVar.tR(str);
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
        aVar.tR(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void AQ(String str) {
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
        this.fMe.AK();
        this.fMv = 0L;
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
        if (!bzk()) {
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

    private boolean bzk() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bzl() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aDE == null) {
            this.aDE = new n(alaLiveInfoCoreData);
            this.fMe.e(this.aDE);
        }
        this.fMj = this.aDE.mLiveInfo.live_id;
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
        if (this.aDE == null) {
            this.aDE = new n();
        }
        this.aDE.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aDE.aqe = alaLivePersonData.mUserData;
        this.aDE.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aDE.aqe != null && this.fMe != null) {
            this.fMe.E(this.aDE.aqe.live_mark_info_new);
        }
        this.aDE.isHost = true;
        this.aDE.aqF = true;
        this.fMe.e(this.aDE);
        bzs();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aDE));
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
        this.fMc.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.fMK);
        MessageManager.getInstance().removeMessageRule(this.fMr);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        this.fMe.AK();
        this.fMf = null;
        this.mPageContext = null;
    }

    public void qT(int i) {
        this.fMk = i;
        if (this.fMh.size() == 0) {
            this.fMk = 0;
        } else if (this.fMk < 0) {
            this.fMk = this.fMh.size() + this.fMk;
        } else {
            this.fMk %= this.fMh.size();
        }
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.fMh.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fMh.size()) {
                    if (this.fMh.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.fMk = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bzm() {
        long j;
        if (this.aDE == null || this.aDE.mLiveInfo == null || this.fMh.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.fMh.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDE.mLiveInfo.live_id;
    }

    public boolean bzn() {
        long j;
        if (this.aDE == null || this.aDE.mLiveInfo == null || this.fMh.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.fMh.get(this.fMh.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aDE.mLiveInfo.live_id;
    }

    public int bzo() {
        return this.fMk;
    }

    public int bzp() {
        return this.fMm;
    }

    public boolean bzq() {
        return this.fMn == 1;
    }

    public AlaLiveInfoData bzr() {
        if (this.fMk >= this.fMh.size()) {
            this.fMk = this.fMh.size() - 1;
        }
        if (this.fMk < 0) {
            this.fMk = 0;
        }
        if (this.fMh.size() <= this.fMk) {
            if (this.aDE != null) {
                return this.aDE.mLiveInfo;
            }
            return null;
        }
        return this.fMh.get(this.fMk);
    }

    public void a(a aVar) {
        this.fJk = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.fMf != null) {
            this.fMf.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void k(com.baidu.live.im.data.a aVar) {
        if (this.aDE != null && this.aDE.mLiveInfo.live_type == 1) {
            y(aVar);
        }
        if (this.fMf != null) {
            this.fMf.k(aVar);
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
    public void AN() {
        if (this.fMf != null) {
            this.fMf.AN();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aDE);
        if (this.aDE != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aDE.aqe;
            } else {
                alaLiveUserInfoData = this.aDE.aqx;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aDE.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aDE != null && this.aDE.aqx != null && this.aDE.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aDE.aqx.throneUid;
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
                this.fMe.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void bzs() {
        this.fMe.e(String.valueOf(this.aDE.mLiveInfo.getGroupID()), String.valueOf(this.aDE.mLiveInfo.getLastMsgID()), String.valueOf(this.aDE.mLiveInfo.getUserID()), String.valueOf(this.aDE.mLiveInfo.getLiveID()), this.aDE.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bzt() {
        return this.fMe;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
