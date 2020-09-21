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
import com.baidu.live.data.al;
import com.baidu.live.data.ar;
import com.baidu.live.data.bh;
import com.baidu.live.data.n;
import com.baidu.live.data.p;
import com.baidu.live.data.q;
import com.baidu.live.data.u;
import com.baidu.live.im.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.message.AlaUserAuthenVerifyInfoResponseMessage;
import com.baidu.live.message.GetUserInfoHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
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
    private u aAP;
    private CustomMessageListener fSS;
    private n fUw;
    private a gFS;
    private long gIK;
    private BdUniqueId gIQ;
    private Handler gIR;
    private HttpMessage gIS;
    private final com.baidu.live.im.d gIT;
    private d.a gIU;
    private al gIV;
    private List<AlaLiveInfoData> gIW;
    private int gIX;
    private int gIY;
    private boolean gIZ;
    private ar gIh;
    private HttpMessageListener gJA;
    private HttpMessageListener gJB;
    private HttpMessageListener gJC;
    private com.baidu.live.liveroom.c.a gJD;
    private CustomMessageTask.CustomRunnable gJE;
    private int gJa;
    private int gJb;
    private int gJc;
    private int gJd;
    private String gJe;
    private com.baidu.live.w.a gJf;
    private AlaGetVerifyStrategyResponseHttpMessage gJg;
    private BdAlertDialog gJh;
    private Set<Long> gJi;
    private long gJj;
    private long gJk;
    private long gJl;
    private boolean gJm;
    private HttpMessageListener gJn;
    private HttpMessageListener gJo;
    private HttpMessageListener gJp;
    private HttpMessageListener gJq;
    private NetMessageListener gJr;
    private HttpMessageListener gJs;
    private NetMessageListener gJt;
    private HttpMessageListener gJu;
    private HttpMessageListener gJv;
    private NetMessageListener gJw;
    private NetMessageListener gJx;
    private HttpMessageListener gJy;
    private CustomMessageListener gJz;
    private HttpMessageListener gnD;
    private boolean mIsHost;
    private long mLastLiveId;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public d(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.gIR = new Handler();
        this.gIX = 0;
        this.gIY = 0;
        this.gIZ = true;
        this.gJa = 1;
        this.gJb = 0;
        this.gJc = -1;
        this.gJd = 0;
        this.gJf = new com.baidu.live.w.a(0);
        this.otherParams = "";
        this.gJk = System.currentTimeMillis();
        this.gJl = 0L;
        this.gJm = true;
        this.fSS = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.q.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aAP != null && d.this.aAP.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aAP.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.gJc = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aAP.mLiveInfo.user_id).param("obj_param1", d.this.aAP.mLiveInfo.live_id).param("tid", d.this.aAP.mLiveInfo.thread_id));
                            d.this.gJc = 1;
                        }
                        if (d.this.aAP != null && d.this.aAP.aEB != null) {
                            d.this.aAP.aEB.follow_status = d.this.gJc;
                        }
                    }
                }
            }
        };
        this.gJn = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.q.d.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.bhA == 1 && alaUserAuthenVerifyInfoResponseMessage.bhz != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.bhz.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.bhz.verify_video_status == 1) {
                            d.this.gJa = 4;
                        }
                    }
                }
            }
        };
        this.gJo = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.q.d.28
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
                    d.this.gJb = alaGetVerifyStrategyResponseHttpMessage.gIq;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.gIm);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.gIo);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.gIr);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.gIo != 1 || alaGetVerifyStrategyResponseHttpMessage.gIm != 1 || alaGetVerifyStrategyResponseHttpMessage.gIr != 1 || alaGetVerifyStrategyResponseHttpMessage.gIt != 1) {
                            d.this.gJg = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.gIr != 1) {
                                d.this.gIR.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.bXh();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gIo != 1 || alaGetVerifyStrategyResponseHttpMessage.gIm != 1) {
                                d.this.gIR.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.ej(alaGetVerifyStrategyResponseHttpMessage.gIu, alaGetVerifyStrategyResponseHttpMessage.gIv);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.gIt != 1) {
                                d.this.gIR.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.28.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.bXk();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.gJg = null;
                    }
                }
            }
        };
        this.gJp = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.q.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.gJq = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.q.d.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String bWQ;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.bWO() == 1 || masterIdentityResponseMessage.bWP() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.bWQ())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.bWQ());
                            jSONObject.put("content_type", "custom_master_identity");
                            bWQ = jSONObject.toString();
                        } catch (JSONException e) {
                            bWQ = masterIdentityResponseMessage.bWQ();
                            e.printStackTrace();
                        }
                        d.this.gIT.a(27, bWQ, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.gJr = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.q.d.31
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.gJs = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.q.d.32
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.gIZ = false;
                }
            }
        };
        this.gJt = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.q.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aAP = alaEnterLiveHttpResonseMessage.Fq();
                        d.this.gIh = alaEnterLiveHttpResonseMessage.bWI();
                        d.this.gIT.f(d.this.aAP);
                    }
                    if (d.this.aAP != null && d.this.aAP.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.bYj().em(d.this.aAP.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aAP.mLiveInfo.live_id);
                    }
                    if (d.this.aAP != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aAP.aFb != null) {
                            if (d.this.aAP.aFb.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aAP.aFb.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aAP.aFb.nickName);
                            if (!TextUtils.isEmpty(d.this.aAP.aFb.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aAP.aFb.portrait);
                            }
                        }
                        if (d.this.aAP.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aAP.mLiveSdkInfo.tbs);
                            com.baidu.live.c.AR().putString("ala_account_user_tbs", d.this.aAP.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aAP != null) {
                        if (d.this.gIW.size() <= 0) {
                            d.this.gIW.add(d.this.aAP.mLiveInfo);
                            d.this.gJi.add(Long.valueOf(d.this.aAP.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aAP.mLiveInfo);
                        if (d.this.gIT != null) {
                            d.this.gIT.O(d.this.aAP.aFi);
                        }
                    }
                    if (d.this.aAP != null && d.this.aAP.aEB != null) {
                        d.this.gJc = d.this.aAP.aEB.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aAP);
                    if (d.this.aAP != null && d.this.aAP.mLiveInfo != null) {
                        d.this.bXy();
                    }
                    if (d.this.aAP != null) {
                        d.this.aAP.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aAP));
                        com.baidu.live.im.b.d.Kh().R(d.this.aAP.aFi);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aAP != null && d.this.aAP.mLiveInfo != null) {
                            long j2 = d.this.aAP.mLiveInfo.live_id;
                            long j3 = d.this.aAP.mLiveInfo.room_id;
                            String str = d.this.aAP.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aAP.aEz != null) {
                                long j4 = d.this.aAP.aEz.userId;
                                str2 = d.this.aAP.aEz.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && d.this.aAP != null && d.this.aAP.mLiveInfo != null) {
                        long j5 = d.this.aAP.mLiveInfo.live_id;
                        long j6 = d.this.aAP.mLiveInfo.room_id;
                        String str3 = d.this.aAP.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aAP.aEz != null) {
                            j = d.this.aAP.aEz.userId;
                            str4 = d.this.aAP.aEz.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.gIY + "");
                    }
                }
            }
        };
        this.gJu = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.q.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    n nVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        nVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bJE();
                    }
                    if (nVar != null) {
                        d.this.fUw = nVar;
                    }
                    if (d.this.aAP != null && d.this.aAP.aEB != null) {
                        if (d.this.gJc == -1) {
                            d.this.gJc = d.this.aAP.aEB.follow_status;
                        }
                        if (d.this.aAP.aEB.follow_status != d.this.gJc) {
                            d.this.aAP.aEB.follow_status = d.this.gJc;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.fUw);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.fUw));
                }
            }
        };
        this.gJv = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.q.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> bWN = alaUserLiveMarkInfoResponseMessage.bWN();
                        d.this.gIT.O(bWN);
                        if (d.this.aAP != null) {
                            d.this.aAP.aFi = bWN;
                            com.baidu.live.im.b.d.Kh().R(d.this.aAP.aFi);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aAP));
                        }
                    }
                }
            }
        };
        this.gJw = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.q.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    u Fq = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).Fq() : null;
                    d.this.gIK = System.currentTimeMillis();
                    if (Fq == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, Fq);
                        return;
                    }
                    if (d.this.aAP == null) {
                        d.this.aAP = Fq;
                        d.this.gIT.f(d.this.aAP);
                    } else if (d.this.aAP.mLiveInfo != null && Fq.mLiveInfo != null && d.this.aAP.mLiveInfo.live_id != Fq.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aAP);
                        return;
                    }
                    if (d.this.aAP.mLiveInfo != null && Fq.mLiveInfo != null && d.this.aAP.mLiveInfo.user_id == Fq.mLiveInfo.user_id) {
                        if (d.this.aAP.mLiveInfo.imEffect != null && Fq.mLiveInfo.imEffect == null) {
                            Fq.mLiveInfo.imEffect = d.this.aAP.mLiveInfo.imEffect;
                        }
                        if (d.this.aAP.mLiveInfo.mLiveCloseData != null && Fq.mLiveInfo.mLiveCloseData == null) {
                            Fq.mLiveInfo.mLiveCloseData = d.this.aAP.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aAP.mLiveInfo.mAlaLiveSwitchData != null && Fq.mLiveInfo.mAlaLiveSwitchData == null) {
                            Fq.mLiveInfo.mAlaLiveSwitchData = d.this.aAP.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aAP.mLiveInfo = Fq.mLiveInfo;
                    d.this.aAP.aFs = Fq.aFs;
                    d.this.aAP.aEz = Fq.aEz;
                    d.this.aAP.aEA = Fq.aEA;
                    d.this.aAP.aEE = Fq.aEE;
                    d.this.aAP.aFj = Fq.aFj;
                    d.this.aAP.aFh = Fq.aFh;
                    d.this.aAP.aFe = Fq.aFe;
                    d.this.aAP.aFf = Fq.aFf;
                    d.this.aAP.aFg = Fq.aFg;
                    if (Fq.aFm != null && Fq.aFm.aJc != null && !Fq.aFm.aJc.isEmpty()) {
                        d.this.aAP.aFm = Fq.aFm;
                    }
                    if (Fq.aFb != null) {
                        if (Fq.aFb.userId == 0) {
                            if (d.this.aAP.aFb == null) {
                                d.this.aAP.aFb = new AlaLiveUserInfoData();
                            }
                            d.this.aAP.aFb.throneUid = Fq.aFb.throneUid;
                        } else {
                            boolean z = Fq.aFb.isNewUser;
                            if (d.this.aAP.aFb != null) {
                                z = d.this.aAP.aFb.isNewUser;
                            }
                            Fq.aFb.isNewUser = z;
                            d.this.aAP.aFb = Fq.aFb;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aAP.aFb.nickName);
                        }
                    }
                    if (Fq.aFd != null) {
                        d.this.aAP.aFd = Fq.aFd;
                    }
                    if (Fq.aFh) {
                        d.this.aAP.aFi = Fq.aFi;
                        if (d.this.gIT != null) {
                            d.this.gIT.O(Fq.aFi);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aAP.mLiveInfo != null) {
                        int i = d.this.aAP.mLiveInfo.backstage_type;
                        if (d.this.gIT != null) {
                            d.this.gIT.ha(String.valueOf(i));
                        }
                    }
                    if (d.this.gIT != null) {
                        d.this.gIT.f(d.this.aAP);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aAP);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aAP));
                    if (d.this.aAP != null) {
                        com.baidu.live.im.b.d.Kh().R(d.this.aAP.aFi);
                    }
                }
            }
        };
        this.gJx = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.q.d.6
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
                    if (list != null && list.size() > 0 && d.this.gIW != null && d.this.gIW.size() > 0) {
                        for (int size = d.this.gIW.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.gIW.get(size)).live_id != d.this.aAP.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.gIW.get(size)).getLiveID()))) {
                                d.this.gIW.remove(size);
                            }
                        }
                    }
                    if (d.this.aAP != null) {
                        d.this.h(d.this.aAP.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.gnD = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.q.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.gJy = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.q.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.gIS = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.gIV = alaUpdateLiveTbResponseMessage.bWM();
                    if (d.this.gIV != null) {
                        if (d.this.gIV.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.gIV.aJh);
                                jSONObject2.put("user_verify", d.this.gIV.aJj);
                                jSONObject2.put("certify", d.this.gIV.aJl);
                                if (d.this.gIV.mLiveSdkInfo != null && d.this.gIV.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put("chat_mcast_id", d.this.gIV.mLiveSdkInfo.mCastIds.aEU);
                                    jSONObject2.put("ensure_mcast_id", d.this.gIV.mLiveSdkInfo.mCastIds.aEV);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.gIV.aJh != 1 || d.this.gIV.aJj != 1) {
                            d.this.gIR.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.bXi();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.gIV.aEz != null) {
                            d.this.gIT.O(d.this.gIV.aEz.live_mark_info_new);
                        }
                        if (d.this.gIV.mErrorCode != 0) {
                            if (d.this.gIV.mErrorCode == 220012) {
                                d.this.b(d.this.gIV.mErrorCode, d.this.gIV.mErrorMsg, 6, d.this.aAP);
                                return;
                            }
                        } else {
                            d.this.aAP = new u();
                            d.this.gIT.f(d.this.aAP);
                            d.this.aAP.mLiveInfo = d.this.gIV.mLiveInfo;
                            d.this.aAP.aEz = d.this.gIV.aEz;
                            d.this.aAP.mLiveSdkInfo = d.this.gIV.mLiveSdkInfo;
                            d.this.aAP.aFk = d.this.gIV.aFk;
                            d.this.aAP.aFi = d.this.gIV.aEz.live_mark_info_new;
                            d.this.aAP.aFf = d.this.gIV.aFf;
                            if (d.this.gIV.aEz != null && d.this.gIV.aEz.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.gIV.aEz.levelId);
                            }
                            d.this.aAP.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aAP));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aAP);
                    if (d.this.gIV != null && d.this.gIV.mLiveInfo != null) {
                        d.this.bXy();
                    }
                    if (d.this.aAP != null && d.this.aAP.mLiveInfo != null) {
                        d.this.s(d.this.aAP.mLiveInfo.user_id, d.this.aAP.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.gJz = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.q.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.gIT.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.gJA = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.q.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.n.b)) {
                    com.baidu.live.n.b bVar = (com.baidu.live.n.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.bjo != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.bjo.hj(bVar.contentType);
                        } else {
                            bVar.bjo.b(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.gJB = new HttpMessageListener(1021125) { // from class: com.baidu.tieba.ala.liveroom.q.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetUserInfoHttpResponseMessage)) {
                    GetUserInfoHttpResponseMessage getUserInfoHttpResponseMessage = (GetUserInfoHttpResponseMessage) httpResponsedMessage;
                    if (d.this.aAP != null && d.this.aAP.aFb != null && getUserInfoHttpResponseMessage.userId == d.this.aAP.aFb.userId && !TextUtils.isEmpty(getUserInfoHttpResponseMessage.userName)) {
                        d.this.aAP.aFb.nickName = getUserInfoHttpResponseMessage.userName;
                    }
                }
            }
        };
        this.gJC = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.q.d.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                q qVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        qVar = null;
                    } else {
                        qVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).bWK();
                    }
                    if (qVar != null && !ListUtils.isEmpty(qVar.aEO)) {
                        d.this.gJm = qVar.aEN;
                        d.this.gIX = qVar.pn + 1;
                        p pVar = qVar.aEO.get(qVar.aEO.size() - 1);
                        if (pVar != null) {
                            d.this.mLastLiveId = pVar.mLiveInfo.live_id;
                        }
                        d.this.a(qVar);
                        if (d.this.aAP != null) {
                            d.this.h(d.this.aAP.mLiveInfo);
                        }
                        d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, qVar);
                    }
                }
            }
        };
        this.gJD = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.q.d.25
        };
        this.gJE = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.gIK));
            }
        };
        this.mPageContext = bdPageContext;
        this.gIT = new com.baidu.live.im.d(bdPageContext, false, this);
        this.gIW = new ArrayList();
        this.gJi = new HashSet();
        initTasks();
        registerListener(this.gJw);
        registerListener(this.gJu);
        registerListener(this.gJt);
        registerListener(this.gJr);
        this.gIQ = BdUniqueId.gen();
        this.gJC.setTag(this.gIQ);
        registerListener(this.gJC);
        registerListener(this.gJx);
        registerListener(this.gJs);
        registerListener(this.gJy);
        registerListener(this.gnD);
        registerListener(this.gJo);
        registerListener(this.gJp);
        registerListener(this.gJn);
        registerListener(this.fSS);
        registerListener(this.gJv);
        registerListener(this.gJq);
        registerListener(this.gJz);
        registerListener(this.gJA);
        registerListener(this.gJB);
        MessageManager.getInstance().addMessageRule(this.gJf);
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
        this.gIK = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.gJE);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        bWV();
        bWW();
        bWX();
        bWY();
        bXb();
        bXc();
    }

    private void bWV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bWW() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void bWX() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void bWY() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void bWZ() {
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

    public void bXa() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void bXb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bXc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "/ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bXd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.q.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.n.b) && d.this.aAP != null && d.this.aAP.mLiveInfo != null) {
                    com.baidu.live.n.b bVar = (com.baidu.live.n.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aAP.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.bjn != null) {
                        httpMessage.addParam("ext_data", bVar.bjn.toString());
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

    public void bXe() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void s(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bXf() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, ""));
    }

    public void ei(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void bXg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bXh() {
        if (this.gJh != null) {
            this.gJh.dismiss();
            this.gJh = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.gJh = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gJh.setAutoNight(false);
        this.gJh.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.gJh.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.bXg();
                    d.this.FD();
                }
            });
            this.gJh.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FD();
                }
            });
        } else {
            this.gJh.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FD();
                }
            });
        }
        this.gJh.setCancelable(false);
        this.gJh.setCanceledOnTouchOutside(false);
        this.gJh.setTitleShowCenter(true);
        this.gJh.setMessageShowCenter(true);
        this.gJh.isShowTitleAndMessage();
        this.gJh.create(this.mPageContext);
        this.gJh.show();
    }

    public void ej(String str, String str2) {
        if (this.gJh != null) {
            this.gJh.dismiss();
            this.gJh = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.gJh = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gJh.setAutoNight(false);
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.gJh.setTitle(str);
        } else if (StringUtils.isNull(str2)) {
            str2 = string;
        }
        this.gJh.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gJh.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FD();
                }
            });
        } else {
            this.gJh.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.x.a.NN().bhy.aHZ;
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
                    d.this.FD();
                }
            });
            this.gJh.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.FD();
                }
            });
        }
        this.gJh.setCancelable(false);
        this.gJh.setCanceledOnTouchOutside(false);
        this.gJh.setTitleShowCenter(true);
        this.gJh.setMessageShowCenter(true);
        this.gJh.isShowTitleAndMessage();
        this.gJh.create(this.mPageContext);
        this.gJh.show();
    }

    public void bXi() {
        if (this.gJh != null) {
            this.gJh.dismiss();
            this.gJh = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gJh = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gJh.setAutoNight(false);
        this.gJh.setMessage(string);
        this.gJh.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.gJh.setCancelable(false);
        this.gJh.setCanceledOnTouchOutside(false);
        this.gJh.isShowTitleAndMessage();
        this.gJh.create(this.mPageContext);
        this.gJh.show();
    }

    public void bXj() {
        if (this.gJh != null) {
            this.gJh.dismiss();
            this.gJh = null;
        }
        if (this.gJg != null) {
            a(this.gJg);
        }
    }

    public void bXk() {
        if (this.gJh != null) {
            this.gJh.dismiss();
            this.gJh = null;
        }
        String string = this.mPageContext.getString(a.i.dialog_msg_to_user_info);
        this.gJh = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gJh.setAutoNight(false);
        this.gJh.setMessage(string);
        this.gJh.setPositiveButton(this.mPageContext.getString(a.i.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.20
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
                d.this.FD();
            }
        });
        this.gJh.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.FD();
            }
        });
        this.gJh.setCancelable(false);
        this.gJh.setCanceledOnTouchOutside(false);
        this.gJh.setTitleShowCenter(true);
        this.gJh.setMessageShowCenter(true);
        this.gJh.isShowTitleAndMessage();
        this.gJh.create(this.mPageContext);
        this.gJh.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.gJh = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.gJh.setAutoNight(false);
        this.gJh.setMessage(string);
        this.gJh.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.d.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.gJh.setCancelable(false);
        this.gJh.setCanceledOnTouchOutside(false);
        this.gJh.isShowTitleAndMessage();
        this.gJh.create(this.mPageContext);
        this.gJh.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.gJg = null;
        this.gJh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FD() {
        if (this.gJh != null) {
            this.gJh.dismiss();
            this.gJh = null;
        }
        this.gJg = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.gFS != null) {
            this.gFS.a(i, str, i2, obj);
        }
    }

    public void g(long j, boolean z) {
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
        bVar.an(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void bXl() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public void o(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021077);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("net_status", i);
        sendMessage(httpMessage);
    }

    public void uS(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void t(long j, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.an(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public al bXm() {
        return this.gIV;
    }

    public u Fq() {
        return this.aAP;
    }

    public ar bWI() {
        return this.gIh;
    }

    public List<AlaLiveInfoData> bXn() {
        return this.gIW;
    }

    public n bJE() {
        return this.fUw;
    }

    public void cg(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aAP != null && this.aAP.mLiveInfo != null) {
                aVar.setAudienceCount(this.aAP.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bXo() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.gIW) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cg(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar) {
        if (qVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
                if (this.gIW.size() == 1 && this.gIW.get(0).live_id == this.aAP.mLiveInfo.live_id) {
                    if (c(qVar) != null) {
                        this.gIW.clear();
                    }
                    b(qVar);
                    return;
                }
                b(qVar);
                return;
            }
            b(qVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(q qVar) {
        boolean z;
        for (p pVar : qVar.aEO) {
            if (pVar != null && pVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.gIW) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == pVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.gIW.add(pVar.mLiveInfo);
                }
            }
        }
        if (this.gIW.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.gIW.size() - 200; size < this.gIW.size(); size++) {
                arrayList.add(this.gIW.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.gIW.clear();
                this.gIW.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(q qVar) {
        if (ListUtils.isEmpty(qVar.aEO)) {
            return null;
        }
        for (p pVar : qVar.aEO) {
            if (pVar != null && pVar.mLiveInfo != null && pVar.mLiveInfo.live_id == this.aAP.mLiveInfo.live_id) {
                return pVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bXp() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.gIW)) {
            return null;
        }
        if (this.gJi.isEmpty()) {
            arrayList.addAll(this.gIW);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gIW.size()) {
                    break;
                }
                if ((this.aAP == null || this.aAP.mLiveInfo == null || this.aAP.mLiveInfo.live_id != this.gIW.get(i2).live_id) && !this.gJi.contains(Long.valueOf(this.gIW.get(i2).live_id))) {
                    arrayList.add(this.gIW.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.gJi.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.gJi.size() >= this.gIW.size() - 4) {
                mE(false);
            }
        }
    }

    public void uT(int i) {
        this.gJd = i;
    }

    public void mE(boolean z) {
        if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.LA().Ly()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gJj > 500) {
                this.gJj = currentTimeMillis;
                com.baidu.live.liveroom.c.d.LA().LC().a("tieba", this.gIX, 20, this.gJD);
                return;
            }
            return;
        }
        mF(z);
    }

    private void mF(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.gJl >= 1800000) {
                this.gJk = currentTimeMillis;
                this.gJm = true;
            }
            if (this.gJm) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.gIX);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.gJk);
                httpMessage.setTag(this.gIQ);
                sendMessage(httpMessage);
                this.gJl = currentTimeMillis;
            }
        }
    }

    public void ek(String str, String str2) {
        this.gIT.bO(true);
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
        aVar.zH(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.GK("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        bXA();
    }

    public void ah(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.zH(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        bXA();
    }

    public void GL(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.hg(str);
        aVar.setParams();
        sendMessage(aVar);
        bXA();
    }

    public void el(long j) {
        this.gIT.bO(false);
        this.gJj = 0L;
        this.gJe = null;
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
        if (!bXq()) {
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
            httpMessage.addParam("is_prettify", bh.b(com.baidu.live.x.a.NN().bmW) ? 1 : 2);
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
                BdStatisticsManager.getInstance().newDebug("updatelive", 0L, null, "forum_name", str, "forum_id", str2, "description", str3, "is_location", Integer.valueOf(i), "lat", Double.toString(d), "lng", Double.toString(d2), "location_name", str4, "location_name_md5", str5, "is_to_tb_some", Integer.valueOf(i2), "cover", str6, "vcode", str7, "vcode_md5", str8, "is_test_live", Integer.valueOf(i3), UbcStatConstant.KEY_LIVE_TYPE, Integer.valueOf(i4), "screen_direction", Integer.valueOf(i5), "clarity", Integer.valueOf(i6), "game_id", str9, "game_name", str10);
            }
        }
    }

    private boolean bXq() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bXr() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aAP == null) {
            this.aAP = new u(alaLiveInfoCoreData);
            this.gIT.f(this.aAP);
        }
        this.mLastLiveId = this.aAP.mLiveInfo.live_id;
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
        if (this.aAP == null) {
            this.aAP = new u();
        }
        this.aAP.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aAP.aEz = alaLivePersonData.mUserData;
        this.aAP.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aAP.aEz != null && this.gIT != null) {
            this.gIT.O(this.aAP.aEz.live_mark_info_new);
        }
        this.aAP.isHost = true;
        this.aAP.aFl = true;
        if (this.gIT != null) {
            this.gIT.f(this.aAP);
        }
        bXy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aAP));
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
        this.gIR.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.gJC);
        MessageManager.getInstance().removeMessageRule(this.gJf);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.gIT.bO(true);
        this.gIU = null;
        this.mPageContext = null;
    }

    public void uU(int i) {
        this.gIY = i;
        if (this.gIW.size() == 0) {
            this.gIY = 0;
        } else if (this.gIY < 0) {
            this.gIY = this.gIW.size() + this.gIY;
        } else {
            this.gIY %= this.gIW.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.gIW.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.gIW.size()) {
                    if (this.gIW.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.gIY = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bXs() {
        long j;
        if (this.aAP == null || this.aAP.mLiveInfo == null || this.gIW.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gIW.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aAP.mLiveInfo.live_id;
    }

    public boolean bXt() {
        long j;
        if (this.aAP == null || this.aAP.mLiveInfo == null || this.gIW.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.gIW.get(this.gIW.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aAP.mLiveInfo.live_id;
    }

    public int bXu() {
        return this.gIY;
    }

    public int bXv() {
        return this.gJa;
    }

    public boolean bXw() {
        return this.gJb == 1;
    }

    public AlaLiveInfoData bXx() {
        if (this.gIY >= this.gIW.size()) {
            this.gIY = this.gIW.size() - 1;
        }
        if (this.gIY < 0) {
            this.gIY = 0;
        }
        if (this.gIW.size() <= this.gIY) {
            if (this.aAP != null) {
                return this.aAP.mLiveInfo;
            }
            return null;
        }
        return this.gIW.get(this.gIY);
    }

    public void a(a aVar) {
        this.gFS = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.gIU != null) {
            this.gIU.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void r(com.baidu.live.im.data.a aVar) {
        if (this.aAP != null && this.aAP.mLiveInfo.live_type == 1) {
            B(aVar);
        }
        if (this.gIU != null) {
            this.gIU.r(aVar);
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
            mE(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void Jk() {
        if (this.gIU != null) {
            this.gIU.Jk();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aAP);
        if (this.aAP != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aAP.aEz;
            } else {
                alaLiveUserInfoData = this.aAP.aFb;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aAP.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aAP != null && this.aAP.aFb != null && this.aAP.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aAP.aFb.throneUid;
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
                this.gIT.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void bXy() {
        this.gIT.e(String.valueOf(this.aAP.mLiveInfo.getGroupID()), String.valueOf(this.aAP.mLiveInfo.getLastMsgID()), String.valueOf(this.aAP.mLiveInfo.getUserID()), String.valueOf(this.aAP.mLiveInfo.getLiveID()), this.aAP.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bXz() {
        return this.gIT;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void bXA() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aAP != null) {
            try {
                if (this.aAP.mLiveSdkInfo != null && this.aAP.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put("chat_mcast_id", this.aAP.mLiveSdkInfo.mCastIds.aEU);
                    jSONObject2.put("ensure_mcast_id", this.aAP.mLiveSdkInfo.mCastIds.aEV);
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

    public String bXB() {
        return this.gJe;
    }

    public void Gj(String str) {
        this.gJe = str;
    }
}
