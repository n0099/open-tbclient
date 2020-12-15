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
import com.baidu.live.data.aq;
import com.baidu.live.data.ax;
import com.baidu.live.data.bm;
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
    private w aFN;
    private CustomMessageListener gDu;
    private q gEY;
    private HttpMessageListener hdf;
    private a hvg;
    private ax hxD;
    private AlaGetVerifyStrategyResponseHttpMessage hyA;
    private BdAlertDialog hyB;
    private Set<Long> hyC;
    private long hyD;
    private long hyE;
    private long hyF;
    private boolean hyG;
    private boolean hyH;
    private HttpMessageListener hyI;
    private HttpMessageListener hyJ;
    private HttpMessageListener hyK;
    private HttpMessageListener hyL;
    private NetMessageListener hyM;
    private HttpMessageListener hyN;
    private NetMessageListener hyO;
    private HttpMessageListener hyP;
    private HttpMessageListener hyQ;
    private NetMessageListener hyR;
    private NetMessageListener hyS;
    private HttpMessageListener hyT;
    private CustomMessageListener hyU;
    private HttpMessageListener hyV;
    private HttpMessageListener hyW;
    private HttpMessageListener hyX;
    private com.baidu.live.liveroom.c.a hyY;
    private CustomMessageTask.CustomRunnable hyZ;
    private long hye;
    private BdUniqueId hyk;
    private Handler hyl;
    private HttpMessage hym;
    private final com.baidu.live.im.d hyn;
    private d.a hyo;
    private aq hyp;
    private List<AlaLiveInfoData> hyq;
    private int hyr;
    private int hys;
    private boolean hyt;
    private int hyu;
    private int hyv;
    private int hyw;
    private int hyx;
    private String hyy;
    private com.baidu.live.ac.a hyz;
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
        this.hyl = new Handler();
        this.hyr = 0;
        this.hys = 0;
        this.hyt = true;
        this.hyu = 1;
        this.hyv = 0;
        this.hyw = -1;
        this.hyx = 0;
        this.hyz = new com.baidu.live.ac.a(0);
        this.otherParams = "";
        this.hyE = System.currentTimeMillis();
        this.hyF = 0L;
        this.hyG = true;
        this.hyH = false;
        this.gDu = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.p.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && d.this.aFN != null && d.this.aFN.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(d.this.aFN.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            d.this.hyw = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", d.this.aFN.mLiveInfo.user_id).param("obj_param1", d.this.aFN.mLiveInfo.live_id).param("tid", d.this.aFN.mLiveInfo.thread_id));
                            d.this.hyw = 1;
                        }
                        if (d.this.aFN != null && d.this.aFN.aJX != null) {
                            d.this.aFN.aJX.follow_status = d.this.hyw;
                        }
                    }
                }
            }
        };
        this.hyI = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.p.d.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.brC == 1 && alaUserAuthenVerifyInfoResponseMessage.brB != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.brB.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.brB.verify_video_status == 1) {
                            d.this.hyu = 4;
                        }
                    }
                }
            }
        };
        this.hyJ = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.p.d.28
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
                    d.this.hyv = alaGetVerifyStrategyResponseHttpMessage.hxK;
                    d.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, "author_liveroom", ""), httpResponsedMessage, true);
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, alaGetVerifyStrategyResponseHttpMessage.hxG);
                            jSONObject2.put("user_verify", alaGetVerifyStrategyResponseHttpMessage.hxI);
                            jSONObject2.put("certify", alaGetVerifyStrategyResponseHttpMessage.hxL);
                            jSONObject.put("result", jSONObject2);
                        } catch (JSONException e) {
                            BdLog.e(e);
                        }
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_STRATEGY_SUCC, "author_liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        if (alaGetVerifyStrategyResponseHttpMessage.hxI != 1 || alaGetVerifyStrategyResponseHttpMessage.hxG != 1 || alaGetVerifyStrategyResponseHttpMessage.hxL != 1 || alaGetVerifyStrategyResponseHttpMessage.hxN != 1) {
                            d.this.hyA = alaGetVerifyStrategyResponseHttpMessage;
                            if (alaGetVerifyStrategyResponseHttpMessage.hxL != 1) {
                                d.this.hyl.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.28.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cjv();
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hxI != 1 || alaGetVerifyStrategyResponseHttpMessage.hxG != 1) {
                                d.this.hyl.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.28.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.eC(alaGetVerifyStrategyResponseHttpMessage.hxO, alaGetVerifyStrategyResponseHttpMessage.hxP);
                                    }
                                }, 200L);
                                return;
                            } else if (alaGetVerifyStrategyResponseHttpMessage.hxN != 1) {
                                d.this.hyl.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.28.4
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        d.this.cjy();
                                    }
                                }, 200L);
                                return;
                            } else {
                                return;
                            }
                        }
                        d.this.hyA = null;
                    }
                }
            }
        };
        this.hyK = new HttpMessageListener(1021189) { // from class: com.baidu.tieba.ala.liveroom.p.d.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 10, Boolean.valueOf(httpResponsedMessage.isSuccess()));
            }
        };
        this.hyL = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.p.d.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String cje;
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if ((masterIdentityResponseMessage.cjc() == 1 || masterIdentityResponseMessage.cjd() == 1) && !TextUtils.isEmpty(masterIdentityResponseMessage.cje())) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("text", masterIdentityResponseMessage.cje());
                            jSONObject.put("content_type", "custom_master_identity");
                            cje = jSONObject.toString();
                        } catch (JSONException e) {
                            cje = masterIdentityResponseMessage.cje();
                            e.printStackTrace();
                        }
                        d.this.hyn.a(27, cje, (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.hyM = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.p.d.31
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.hyN = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.p.d.32
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    d.this.hyt = false;
                }
            }
        };
        this.hyO = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.p.d.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage = null;
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        alaEnterLiveHttpResonseMessage = (AlaEnterLiveHttpResonseMessage) responsedMessage;
                        d.this.aFN = alaEnterLiveHttpResonseMessage.Iq();
                        d.this.hxD = alaEnterLiveHttpResonseMessage.ciW();
                        d.this.hyn.setAlaLiveShowData(d.this.aFN);
                    }
                    if (d.this.aFN != null && d.this.aFN.mLiveInfo != null) {
                        if (!TbadkCoreApplication.getInst().isOther() && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                            com.baidu.tieba.ala.liveroom.task.c.ckE().fF(d.this.aFN.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(d.this.aFN.mLiveInfo.live_id);
                    }
                    if (d.this.aFN != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (d.this.aFN.aKr != null) {
                            if (d.this.aFN.aKr.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.aFN.aKr.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aFN.aKr.nickName);
                            if (!TextUtils.isEmpty(d.this.aFN.aKr.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(d.this.aFN.aKr.portrait);
                            }
                        }
                        if (d.this.aFN.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(d.this.aFN.mLiveSdkInfo.tbs);
                            com.baidu.live.d.BM().putString("ala_account_user_tbs", d.this.aFN.mLiveSdkInfo.tbs);
                        }
                    }
                    if (d.this.aFN != null) {
                        if (d.this.hyq.size() <= 0) {
                            d.this.hyq.add(d.this.aFN.mLiveInfo);
                            d.this.hyC.add(Long.valueOf(d.this.aFN.mLiveInfo.getLiveID()));
                        }
                        d.this.h(d.this.aFN.mLiveInfo);
                        if (d.this.hyn != null) {
                            d.this.hyn.R(d.this.aFN.aKB);
                        }
                    }
                    if (d.this.aFN != null && d.this.aFN.aJX != null) {
                        d.this.hyw = d.this.aFN.aJX.follow_status;
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, d.this.aFN);
                    if (d.this.aFN != null && d.this.aFN.mLiveInfo != null) {
                        d.this.cjM();
                    }
                    if (d.this.aFN != null) {
                        d.this.aFN.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aFN));
                        com.baidu.live.im.b.d.NK().V(d.this.aFN.aKB);
                    }
                    d.this.a(alaEnterLiveHttpResonseMessage);
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (d.this.aFN != null && d.this.aFN.mLiveInfo != null) {
                            long j2 = d.this.aFN.mLiveInfo.live_id;
                            long j3 = d.this.aFN.mLiveInfo.room_id;
                            String str = d.this.aFN.mLiveInfo.feed_id;
                            String str2 = "";
                            if (d.this.aFN.aJV != null) {
                                long j4 = d.this.aFN.aJV.userId;
                                str2 = d.this.aFN.aJV.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, d.this.otherParams);
                        }
                    } else if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && d.this.aFN != null && d.this.aFN.mLiveInfo != null) {
                        long j5 = d.this.aFN.mLiveInfo.live_id;
                        long j6 = d.this.aFN.mLiveInfo.room_id;
                        String str3 = d.this.aFN.mLiveInfo.feed_id;
                        String str4 = "";
                        if (d.this.aFN.aJV != null) {
                            j = d.this.aFN.aJV.userId;
                            str4 = d.this.aFN.aJV.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, d.this.otherParams, d.this.hys + "");
                    }
                    if (d.this.aFN != null && d.this.aFN.mLiveInfo != null) {
                        if (!com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckb().cka()) {
                            try {
                                if (d.this.aFN.mLiveInfo.isPubShow && TbadkCoreApplication.getCurrentAccount() != null) {
                                    com.baidu.live.view.a.Yo().jk(String.valueOf(d.this.aFN.mLiveInfo.user_id));
                                    com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckb().a(d.this.mPageContext, d.this.aFN.mLiveInfo.live_id, Long.parseLong(TbadkCoreApplication.getCurrentAccount()), d.this.aFN.mLiveInfo, d.this.mType);
                                }
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                        com.baidu.tieba.ala.liveroom.performancewatchtask.b.ckb().od(false);
                    }
                }
            }
        };
        this.hyP = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.p.d.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    q qVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        qVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bUu();
                    }
                    if (qVar != null) {
                        d.this.gEY = qVar;
                    }
                    if (d.this.aFN != null && d.this.aFN.aJX != null) {
                        if (d.this.hyw == -1) {
                            d.this.hyw = d.this.aFN.aJX.follow_status;
                        }
                        if (d.this.aFN.aJX.follow_status != d.this.hyw) {
                            d.this.aFN.aJX.follow_status = d.this.hyw;
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, d.this.gEY);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, d.this.gEY));
                }
            }
        };
        this.hyQ = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.p.d.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> cjb = alaUserLiveMarkInfoResponseMessage.cjb();
                        d.this.hyn.R(cjb);
                        if (d.this.aFN != null) {
                            d.this.aFN.aKB = cjb;
                            com.baidu.live.im.b.d.NK().V(d.this.aFN.aKB);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, d.this.aFN));
                        }
                    }
                }
            }
        };
        this.hyR = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.p.d.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    w Iq = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).Iq() : null;
                    d.this.hye = System.currentTimeMillis();
                    if (Iq == null) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, Iq);
                        return;
                    }
                    if (d.this.aFN == null) {
                        d.this.aFN = Iq;
                        d.this.hyn.setAlaLiveShowData(d.this.aFN);
                    } else if (d.this.aFN.mLiveInfo != null && Iq.mLiveInfo != null && d.this.aFN.mLiveInfo.live_id != Iq.mLiveInfo.live_id) {
                        d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aFN);
                        return;
                    }
                    if (d.this.aFN.mLiveInfo != null && Iq.mLiveInfo != null && d.this.aFN.mLiveInfo.user_id == Iq.mLiveInfo.user_id) {
                        if (d.this.aFN.mLiveInfo.imEffect != null && Iq.mLiveInfo.imEffect == null) {
                            Iq.mLiveInfo.imEffect = d.this.aFN.mLiveInfo.imEffect;
                        }
                        if (d.this.aFN.mLiveInfo.mLiveCloseData != null && Iq.mLiveInfo.mLiveCloseData == null) {
                            Iq.mLiveInfo.mLiveCloseData = d.this.aFN.mLiveInfo.mLiveCloseData;
                        }
                        if (d.this.aFN.mLiveInfo.mAlaLiveSwitchData != null && Iq.mLiveInfo.mAlaLiveSwitchData == null) {
                            Iq.mLiveInfo.mAlaLiveSwitchData = d.this.aFN.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    d.this.aFN.mLiveInfo = Iq.mLiveInfo;
                    d.this.aFN.serverTime = Iq.serverTime;
                    d.this.aFN.aKN = Iq.aKN;
                    if (Iq.aJV != null && Iq.aJV.userId != 0) {
                        d.this.aFN.aJV = Iq.aJV;
                    }
                    d.this.aFN.aJW = Iq.aJW;
                    d.this.aFN.aKa = Iq.aKa;
                    d.this.aFN.aKC = Iq.aKC;
                    d.this.aFN.aKA = Iq.aKA;
                    d.this.aFN.aKw = Iq.aKw;
                    d.this.aFN.aKx = Iq.aKx;
                    d.this.aFN.aKy = Iq.aKy;
                    d.this.aFN.aKz = Iq.aKz;
                    d.this.aFN.countDown = Iq.countDown;
                    if (Iq.url != null) {
                        d.this.aFN.url = Iq.url;
                    }
                    if (Iq.aKt != null) {
                        d.this.aFN.aKt = Iq.aKt;
                    }
                    d.this.aFN.aKU = Iq.aKU;
                    if (Iq.aKF != null && Iq.aKF.aPa != null && !Iq.aKF.aPa.isEmpty()) {
                        d.this.aFN.aKF = Iq.aKF;
                    }
                    if (Iq.aKr != null) {
                        if (Iq.aKr.userId == 0) {
                            if (d.this.aFN.aKr == null) {
                                d.this.aFN.aKr = new AlaLiveUserInfoData();
                            }
                            d.this.aFN.aKr.throneUid = Iq.aKr.throneUid;
                        } else {
                            boolean z = Iq.aKr.isNewUser;
                            if (d.this.aFN.aKr != null) {
                                z = d.this.aFN.aKr.isNewUser;
                            }
                            Iq.aKr.isNewUser = z;
                            d.this.aFN.aKr = Iq.aKr;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(d.this.aFN.aKr.nickName);
                        }
                    }
                    if (Iq.aKu != null) {
                        d.this.aFN.aKu = Iq.aKu;
                    }
                    if (Iq.aKA) {
                        d.this.aFN.aKB = Iq.aKB;
                        if (d.this.hyn != null) {
                            d.this.hyn.R(Iq.aKB);
                        }
                    }
                    if (!d.this.mIsHost && d.this.aFN.mLiveInfo != null) {
                        int i = d.this.aFN.mLiveInfo.backstage_type;
                        if (d.this.hyn != null) {
                            d.this.hyn.ia(String.valueOf(i));
                        }
                    }
                    if (d.this.hyn != null) {
                        d.this.hyn.setAlaLiveShowData(d.this.aFN);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, d.this.aFN);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, d.this.aFN));
                    if (d.this.aFN != null) {
                        com.baidu.live.im.b.d.NK().V(d.this.aFN.aKB);
                    }
                }
            }
        };
        this.hyS = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.p.d.6
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
                    if (list != null && list.size() > 0 && d.this.hyq != null && d.this.hyq.size() > 0) {
                        for (int size = d.this.hyq.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) d.this.hyq.get(size)).live_id != d.this.aFN.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) d.this.hyq.get(size)).getLiveID()))) {
                                d.this.hyq.remove(size);
                            }
                        }
                    }
                    if (d.this.aFN != null) {
                        d.this.h(d.this.aFN.mLiveInfo);
                    }
                    d.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.hdf = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.p.d.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.hyT = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.p.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == d.this.unique_id) {
                    if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", "create_live", "author_liveroom", ""), httpResponsedMessage, true);
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    d.this.hym = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    d.this.hyp = alaUpdateLiveTbResponseMessage.cja();
                    if (d.this.hyp != null) {
                        if (d.this.hyp.mErrorCode == 0) {
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put(LogConfig.VALUE_LIVE_HK_RECORD_START, d.this.hyp.aPf);
                                jSONObject2.put("user_verify", d.this.hyp.aPh);
                                jSONObject2.put("certify", d.this.hyp.aPj);
                                if (d.this.hyp.mLiveSdkInfo != null && d.this.hyp.mLiveSdkInfo.mCastIds != null) {
                                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, d.this.hyp.mLiveSdkInfo.mCastIds.chatMCastId);
                                    jSONObject2.put("ensure_mcast_id", d.this.hyp.mLiveSdkInfo.mCastIds.ensureMCastId);
                                }
                                jSONObject.put("result", jSONObject2);
                            } catch (JSONException e) {
                                BdLog.e(e);
                            }
                            UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1534", UbcStatConstant.ContentType.UBC_TYPE_CREATE_LIVE_SUCC, "author_liveroom", "").setContentExt(jSONObject), httpResponsedMessage, true);
                        }
                        if (d.this.hyp.aPf != 1 || d.this.hyp.aPh != 1) {
                            d.this.hyl.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    d.this.cjw();
                                }
                            }, 200L);
                            return;
                        }
                        if (d.this.hyp.aJV != null) {
                            d.this.hyn.R(d.this.hyp.aJV.live_mark_info_new);
                        }
                        if (d.this.hyp.mErrorCode != 0) {
                            if (d.this.hyp.mErrorCode == 220012) {
                                d.this.b(d.this.hyp.mErrorCode, d.this.hyp.mErrorMsg, 6, d.this.aFN);
                                return;
                            }
                        } else {
                            d.this.aFN = new w();
                            d.this.hyn.setAlaLiveShowData(d.this.aFN);
                            d.this.aFN.mLiveInfo = d.this.hyp.mLiveInfo;
                            d.this.aFN.aJV = d.this.hyp.aJV;
                            d.this.aFN.mLiveSdkInfo = d.this.hyp.mLiveSdkInfo;
                            d.this.aFN.aKD = d.this.hyp.aKD;
                            d.this.aFN.aKB = d.this.hyp.aJV.live_mark_info_new;
                            d.this.aFN.aKx = d.this.hyp.aKx;
                            if (d.this.hyp.aJV != null && d.this.hyp.aJV.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(d.this.hyp.aJV.levelId);
                            }
                            d.this.aFN.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, d.this.aFN));
                        }
                    }
                    d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, d.this.aFN);
                    if (d.this.hyp != null && d.this.hyp.mLiveInfo != null) {
                        d.this.cjM();
                    }
                    if (d.this.aFN != null && d.this.aFN.mLiveInfo != null) {
                        d.this.t(d.this.aFN.mLiveInfo.user_id, d.this.aFN.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.hyU = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.p.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    d.this.hyn.a(27, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.hyV = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.p.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.q.b)) {
                    com.baidu.live.q.b bVar = (com.baidu.live.q.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.btq != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.btq.il(bVar.contentType);
                        } else {
                            bVar.btq.d(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.hyW = new HttpMessageListener(1021125) { // from class: com.baidu.tieba.ala.liveroom.p.d.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetUserInfoHttpResponseMessage)) {
                    GetUserInfoHttpResponseMessage getUserInfoHttpResponseMessage = (GetUserInfoHttpResponseMessage) httpResponsedMessage;
                    if (d.this.aFN != null && d.this.aFN.aKr != null && getUserInfoHttpResponseMessage.userId == d.this.aFN.aKr.userId && !TextUtils.isEmpty(getUserInfoHttpResponseMessage.userName)) {
                        d.this.aFN.aKr.nickName = getUserInfoHttpResponseMessage.userName;
                    }
                }
            }
        };
        this.hyX = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.p.d.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                t tVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        tVar = null;
                    } else {
                        tVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).ciY();
                    }
                    if (tVar != null && !ListUtils.isEmpty(tVar.aKk)) {
                        d.this.hyG = tVar.aKj;
                        d.this.hyr = tVar.pn + 1;
                        s sVar = tVar.aKk.get(tVar.aKk.size() - 1);
                        if (sVar != null) {
                            d.this.mLastLiveId = sVar.mLiveInfo.live_id;
                        }
                        d.this.a(tVar);
                        if (d.this.aFN != null) {
                            d.this.h(d.this.aFN.mLiveInfo);
                        }
                        d.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, tVar);
                    }
                }
            }
        };
        this.hyY = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.p.d.25
        };
        this.hyZ = new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.26
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Long> run(CustomMessage customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, Long.valueOf(d.this.hye));
            }
        };
        this.mPageContext = bdPageContext;
        this.hyn = new com.baidu.live.im.d(bdPageContext, false, this);
        this.hyq = new ArrayList();
        this.hyC = new HashSet();
        initTasks();
        registerListener(this.hyR);
        registerListener(this.hyP);
        registerListener(this.hyO);
        registerListener(this.hyM);
        this.hyk = BdUniqueId.gen();
        this.hyX.setTag(this.hyk);
        registerListener(this.hyX);
        registerListener(this.hyS);
        registerListener(this.hyN);
        registerListener(this.hyT);
        registerListener(this.hdf);
        registerListener(this.hyJ);
        registerListener(this.hyK);
        registerListener(this.hyI);
        registerListener(this.gDu);
        registerListener(this.hyQ);
        registerListener(this.hyL);
        registerListener(this.hyU);
        registerListener(this.hyV);
        registerListener(this.hyW);
        MessageManager.getInstance().addMessageRule(this.hyz);
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
        this.hye = System.currentTimeMillis();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME, this.hyZ);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        cjj();
        cjk();
        cjl();
        cjm();
        cjp();
        cjq();
    }

    public void setIsMixLive(boolean z) {
        this.hyH = z;
    }

    private void cjj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cjk() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void cjl() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void cjm() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void cjn() {
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

    public void cjo() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void cjp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cjq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021189, TbConfig.SERVER_ADDRESS + "ala/tag/addAnchorCategory");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cjr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.p.d.23
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.q.b) && d.this.aFN != null && d.this.aFN.mLiveInfo != null) {
                    com.baidu.live.q.b bVar = (com.baidu.live.q.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", d.this.aFN.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.btp != null) {
                        httpMessage.addParam("ext_data", bVar.btp.toString());
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

    public void cjs() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void t(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cjt() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", UbcStatConstant.ContentType.UBC_TYPE_STRATEGY, "author_liveroom", ""));
    }

    public void eB(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021189);
        httpMessage.addParam("cat1_id", str);
        httpMessage.addParam("cat2_id", str2);
        sendMessage(httpMessage);
    }

    public void cju() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913222, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void cjv() {
        if (this.hyB != null) {
            this.hyB.dismiss();
            this.hyB = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_auth);
        this.hyB = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hyB.setAutoNight(false);
        this.hyB.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.hyB.setPositiveButton(this.mPageContext.getString(a.h.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.cju();
                    d.this.ID();
                }
            });
            this.hyB.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.ID();
                }
            });
        } else {
            this.hyB.setPositiveButton(this.mPageContext.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.ID();
                }
            });
        }
        this.hyB.setCancelable(false);
        this.hyB.setCanceledOnTouchOutside(false);
        this.hyB.setTitleShowCenter(true);
        this.hyB.setMessageShowCenter(true);
        this.hyB.isShowTitleAndMessage();
        this.hyB.create(this.mPageContext);
        this.hyB.show();
    }

    public void eC(String str, String str2) {
        if (this.hyB != null) {
            this.hyB.dismiss();
            this.hyB = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_permission);
        this.hyB = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hyB.setAutoNight(false);
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.hyB.setTitle(str);
        } else if (StringUtils.isNull(str2)) {
            str2 = string;
        }
        this.hyB.setMessage(str2);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hyB.setPositiveButton(this.mPageContext.getString(a.h.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.ID();
                }
            });
        } else {
            this.hyB.setPositiveButton(this.mPageContext.getString(a.h.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str3 = com.baidu.live.ae.a.RB().brA.aNR;
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
                    d.this.ID();
                }
            });
            this.hyB.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.18
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    d.this.ID();
                }
            });
        }
        this.hyB.setCancelable(false);
        this.hyB.setCanceledOnTouchOutside(false);
        this.hyB.setTitleShowCenter(true);
        this.hyB.setMessageShowCenter(true);
        this.hyB.isShowTitleAndMessage();
        this.hyB.create(this.mPageContext);
        this.hyB.show();
    }

    public void cjw() {
        if (this.hyB != null) {
            this.hyB.dismiss();
            this.hyB = null;
        }
        String string = this.mPageContext.getString(a.h.ala_live_no_permission_tip);
        this.hyB = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hyB.setAutoNight(false);
        this.hyB.setMessage(string);
        this.hyB.setPositiveButton(this.mPageContext.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hyB.setCancelable(false);
        this.hyB.setCanceledOnTouchOutside(false);
        this.hyB.isShowTitleAndMessage();
        this.hyB.create(this.mPageContext);
        this.hyB.show();
    }

    public void cjx() {
        if (this.hyB != null) {
            this.hyB.dismiss();
            this.hyB = null;
        }
        if (this.hyA != null) {
            a(this.hyA);
        }
    }

    public void cjy() {
        if (this.hyB != null) {
            this.hyB.dismiss();
            this.hyB = null;
        }
        String string = this.mPageContext.getString(a.h.dialog_msg_to_user_info);
        this.hyB = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hyB.setAutoNight(false);
        this.hyB.setMessage(string);
        this.hyB.setPositiveButton(this.mPageContext.getString(a.h.dialog_btn_to_user_info), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.20
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
                d.this.ID();
            }
        });
        this.hyB.setNegativeButton(this.mPageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.ID();
            }
        });
        this.hyB.setCancelable(false);
        this.hyB.setCanceledOnTouchOutside(false);
        this.hyB.setTitleShowCenter(true);
        this.hyB.setMessageShowCenter(true);
        this.hyB.isShowTitleAndMessage();
        this.hyB.create(this.mPageContext);
        this.hyB.show();
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.h.ala_live_no_permission_tip);
        this.hyB = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.hyB.setAutoNight(false);
        this.hyB.setMessage(string);
        this.hyB.setPositiveButton(this.mPageContext.getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.d.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                d.this.b(bdAlertDialog);
            }
        });
        this.hyB.setCancelable(false);
        this.hyB.setCanceledOnTouchOutside(false);
        this.hyB.isShowTitleAndMessage();
        this.hyB.create(this.mPageContext);
        this.hyB.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.hyA = null;
        this.hyB = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ID() {
        if (this.hyB != null) {
            this.hyB.dismiss();
            this.hyB = null;
        }
        this.hyA = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hvg != null) {
            this.hvg.a(i, str, i2, obj);
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
        cVar.aZ(j2);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void cjz() {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(1021121);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            sendMessage(httpMessage);
        }
    }

    public void x(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021077);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("net_status", i);
        sendMessage(httpMessage);
    }

    public void xh(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void u(long j, long j2) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c();
        cVar.setLiveId(j);
        cVar.aZ(j2);
        cVar.setParams();
        sendMessage(cVar);
    }

    public aq cjA() {
        return this.hyp;
    }

    public w Iq() {
        return this.aFN;
    }

    public ax ciW() {
        return this.hxD;
    }

    public List<AlaLiveInfoData> cjB() {
        return this.hyq;
    }

    public q bUu() {
        return this.gEY;
    }

    public void cF(List<Long> list) {
        if (!this.hyH) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
                com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
                if (this.aFN != null && this.aFN.mLiveInfo != null) {
                    aVar.setAudienceCount(this.aFN.mLiveInfo.audience_count);
                }
                aVar.setListIds(list);
                aVar.setParams();
                sendMessage(aVar);
            }
        }
    }

    public void cjC() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.hyq) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        cF(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar) {
        if (tVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isYinbo()) {
                if (this.hyq.size() == 1 && this.hyq.get(0).live_id == this.aFN.mLiveInfo.live_id) {
                    if (c(tVar) != null) {
                        this.hyq.clear();
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
        for (s sVar : tVar.aKk) {
            if (sVar != null && sVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.hyq) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == sVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.hyq.add(sVar.mLiveInfo);
                }
            }
        }
        if (this.hyq.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.hyq.size() - 200; size < this.hyq.size(); size++) {
                arrayList.add(this.hyq.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.hyq.clear();
                this.hyq.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(t tVar) {
        if (ListUtils.isEmpty(tVar.aKk)) {
            return null;
        }
        for (s sVar : tVar.aKk) {
            if (sVar != null && sVar.mLiveInfo != null && sVar.mLiveInfo.live_id == this.aFN.mLiveInfo.live_id) {
                return sVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> cjD() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.hyq)) {
            return null;
        }
        if (this.hyC.isEmpty()) {
            arrayList.addAll(this.hyq);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hyq.size()) {
                    break;
                }
                if ((this.aFN == null || this.aFN.mLiveInfo == null || this.aFN.mLiveInfo.live_id != this.hyq.get(i2).live_id) && !this.hyC.contains(Long.valueOf(this.hyq.get(i2).live_id))) {
                    arrayList.add(this.hyq.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void g(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.hyC.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.hyC.size() >= this.hyq.size() - 4) {
                ob(false);
            }
        }
    }

    public void xi(int i) {
        this.hyx = i;
    }

    public void ob(boolean z) {
        if (!this.hyH) {
            if (TbadkCoreApplication.getInst().isOther() && com.baidu.live.liveroom.c.d.Ph().Pf()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hyD > 500) {
                    this.hyD = currentTimeMillis;
                    com.baidu.live.liveroom.c.d.Ph().Pj().a("tieba", this.hyr, 20, this.hyY);
                    return;
                }
                return;
            }
            oc(z);
        }
    }

    private void oc(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hyF >= 1800000) {
                this.hyE = currentTimeMillis;
                this.hyG = true;
            }
            if (this.hyG) {
                HttpMessage httpMessage = new HttpMessage(1021021);
                httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.hyr);
                httpMessage.addParam("ps", 20);
                httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
                httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
                httpMessage.addParam("q_type", 0);
                httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
                httpMessage.addParam("forum_id", "");
                httpMessage.addParam("entry_name", "");
                httpMessage.addParam("live_id", this.mLastLiveId);
                httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
                httpMessage.addParam("slide_session_id", this.hyE);
                httpMessage.setTag(this.hyk);
                sendMessage(httpMessage);
                this.hyF = currentTimeMillis;
            }
        }
    }

    public void eD(String str, String str2) {
        this.hyn.cf(true);
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
        aVar.Bc(str);
        aVar.setLiveId(j);
        if (z && i == 1) {
            aVar.IC("1");
        }
        aVar.setParams();
        sendMessage(aVar);
        cjO();
    }

    public void at(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.Bc(str2);
        aVar.setUk(str);
        aVar.setParams();
        sendMessage(aVar);
        cjO();
    }

    public void ID(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.b(address.getLongitude(), address.getLatitude());
        }
        aVar.setRoomId(str);
        aVar.setParams();
        sendMessage(aVar);
        cjO();
    }

    public void fD(long j) {
        this.hyn.cf(false);
        this.hyD = 0L;
        this.hyy = null;
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
        if (!cjE()) {
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
            httpMessage.addParam("is_prettify", bm.b(com.baidu.live.ae.a.RB().bxq) ? 1 : 2);
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
            UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem("1526", "create_live", "author_liveroom", ""));
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                BdStatisticsManager.getInstance().newDebug("updatelive", 0L, null, "forum_name", str, "forum_id", str2, "description", str3, "is_location", Integer.valueOf(i), "lat", Double.toString(d), "lng", Double.toString(d2), "location_name", str4, "location_name_md5", str5, "is_to_tb_some", Integer.valueOf(i2), "cover", str6, "vcode", str7, "vcode_md5", str8, "is_test_live", Integer.valueOf(i3), UbcStatConstant.KEY_LIVE_TYPE, Integer.valueOf(i4), "screen_direction", Integer.valueOf(i5), "clarity", Integer.valueOf(i6), "game_id", str9, "game_name", str10);
            }
        }
    }

    private boolean cjE() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void cjF() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aFN == null) {
            this.aFN = new w(alaLiveInfoCoreData);
            this.hyn.setAlaLiveShowData(this.aFN);
        }
        this.mLastLiveId = this.aFN.mLiveInfo.live_id;
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
        if (this.aFN == null) {
            this.aFN = new w();
        }
        this.aFN.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aFN.aJV = alaLivePersonData.mUserData;
        this.aFN.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aFN.aJV != null && this.hyn != null) {
            this.hyn.R(this.aFN.aJV.live_mark_info_new);
        }
        this.aFN.isHost = true;
        this.aFN.aKE = true;
        if (this.hyn != null) {
            this.hyn.setAlaLiveShowData(this.aFN);
        }
        cjM();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.aFN));
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
        this.hyl.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.hyX);
        MessageManager.getInstance().removeMessageRule(this.hyz);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_GET_LIVE_INFO_TIME);
        this.hyn.cf(true);
        this.hyo = null;
        this.mPageContext = null;
    }

    public void xj(int i) {
        this.hys = i;
        if (this.hyq.size() == 0) {
            this.hys = 0;
        } else if (this.hys < 0) {
            this.hys = this.hyq.size() + this.hys;
        } else {
            this.hys %= this.hyq.size();
        }
    }

    public void h(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.hyq.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.hyq.size()) {
                    if (this.hyq.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.hys = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean cjG() {
        long j;
        if (this.aFN == null || this.aFN.mLiveInfo == null || this.hyq.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hyq.get(0);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aFN.mLiveInfo.live_id;
    }

    public boolean cjH() {
        long j;
        if (this.aFN == null || this.aFN.mLiveInfo == null || this.hyq.size() <= 0) {
            return true;
        }
        AlaLiveInfoData alaLiveInfoData = this.hyq.get(this.hyq.size() - 1);
        if (alaLiveInfoData == null) {
            j = 0;
        } else {
            j = alaLiveInfoData.live_id;
        }
        return j == this.aFN.mLiveInfo.live_id;
    }

    public int cjI() {
        return this.hys;
    }

    public int cjJ() {
        return this.hyu;
    }

    public boolean cjK() {
        return this.hyv == 1;
    }

    public AlaLiveInfoData cjL() {
        if (this.hys >= this.hyq.size()) {
            this.hys = this.hyq.size() - 1;
        }
        if (this.hys < 0) {
            this.hys = 0;
        }
        if (this.hyq.size() <= this.hys) {
            if (this.aFN != null) {
                return this.aFN.mLiveInfo;
            }
            return null;
        }
        return this.hyq.get(this.hys);
    }

    public void a(a aVar) {
        this.hvg = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.b> list, boolean z) {
        if (this.hyo != null) {
            this.hyo.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void t(com.baidu.live.im.data.b bVar) {
        if (this.aFN != null && this.aFN.mLiveInfo.live_type == 1) {
            J(bVar);
        }
        if (this.hyo != null) {
            this.hyo.t(bVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, bVar));
        }
    }

    public void J(com.baidu.live.im.data.b bVar) {
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
            ob(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void ME() {
        if (this.hyo != null) {
            this.hyo.ME();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void e(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        Log.i("i", "@@@ localText lrmd sm sd=" + this.aFN);
        if (this.aFN != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aFN.aJV;
            } else {
                alaLiveUserInfoData = this.aFN.aKr;
            }
            Log.i("i", "@@@ localText lrmd sm ui=" + alaLiveUserInfoData);
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aFN.mLiveInfo.imEffect;
                String[] strArr2 = null;
                if (strArr != null) {
                    strArr2 = new String[strArr.length];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                }
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aFN != null && this.aFN.aKr != null && this.aFN.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aFN.aKr.throneUid;
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
                this.hyn.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr3);
            }
        }
    }

    public void cjM() {
        this.hyn.e(String.valueOf(this.aFN.mLiveInfo.getGroupID()), String.valueOf(this.aFN.mLiveInfo.getLastMsgID()), String.valueOf(this.aFN.mLiveInfo.getUserID()), String.valueOf(this.aFN.mLiveInfo.getLiveID()), this.aFN.mLiveInfo.appId);
    }

    public com.baidu.live.im.d cjN() {
        return this.hyn;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    private void cjO() {
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_ENTER_LIVE_REQ, "enter_live", "liveroom", ""), true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaEnterLiveHttpResonseMessage alaEnterLiveHttpResonseMessage) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (this.aFN != null) {
            try {
                if (this.aFN.mLiveSdkInfo != null && this.aFN.mLiveSdkInfo.mCastIds != null) {
                    jSONObject2.put(YuyinAlaLiveRoomActivityConfig.SDK_AUDIO_ROOM_CHAT_CAST_ID, this.aFN.mLiveSdkInfo.mCastIds.chatMCastId);
                    jSONObject2.put("ensure_mcast_id", this.aFN.mLiveSdkInfo.mCastIds.ensureMCastId);
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

    public String cjP() {
        return this.hyy;
    }

    public void Ia(String str) {
        this.hyy = str;
    }

    public void IE(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                this.mType = new JSONObject(str).optString(AlaLastLiveroomInfo.KEY_LAST_FROM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
