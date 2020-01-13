package com.baidu.tieba.ala.liveroom.o;

import android.location.Address;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
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
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.g;
import com.baidu.live.data.i;
import com.baidu.live.data.l;
import com.baidu.live.im.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.k;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.message.AlaUserAuthenVerifyInfoResponseMessage;
import com.baidu.live.r.a;
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
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParams;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.timer.LiveTimerManager;
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
/* loaded from: classes2.dex */
public class c extends BdBaseModel implements d.a {
    private l aiW;
    private HttpMessageListener eKB;
    private CustomMessageListener ern;
    private g esD;
    private a fbe;
    private BdUniqueId fdS;
    private Handler fdT;
    private HttpMessage fdU;
    private com.baidu.live.im.d fdV;
    private d.a fdW;
    private h fdX;
    private List<AlaLiveInfoData> fdY;
    private int fdZ;
    private com.baidu.live.liveroom.b.a feA;
    private long fea;
    private int feb;
    private boolean fec;
    private int fed;
    private int fee;
    private String fef;
    private int feg;
    private int feh;
    private com.baidu.live.q.a fei;
    private AlaGetVerifyStrategyResponseHttpMessage fej;
    private BdAlertDialog fek;
    private Set<Long> fel;
    private HttpMessageListener fem;
    private CustomMessageListener fen;
    private HttpMessageListener feo;
    private HttpMessageListener fep;
    private NetMessageListener feq;
    private HttpMessageListener fer;
    private NetMessageListener fes;
    private HttpMessageListener fet;
    private HttpMessageListener feu;
    private NetMessageListener fev;
    private NetMessageListener few;
    private HttpMessageListener fex;
    private CustomMessageListener fey;
    private HttpMessageListener fez;
    private boolean mIsHost;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.fdT = new Handler();
        this.fdZ = 0;
        this.feb = 0;
        this.fec = true;
        this.fed = 1;
        this.fee = 0;
        this.feg = -1;
        this.feh = 0;
        this.fei = new com.baidu.live.q.a(0);
        this.otherParams = "";
        this.ern = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.o.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.aiW != null && c.this.aiW.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.aiW.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.feg = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.aiW.mLiveInfo.user_id).param("obj_param1", c.this.aiW.mLiveInfo.live_id).param("tid", c.this.aiW.mLiveInfo.thread_id));
                            c.this.feg = 1;
                        }
                        if (c.this.aiW != null && c.this.aiW.Wh != null) {
                            c.this.aiW.Wh.follow_status = c.this.feg;
                        }
                    }
                }
            }
        };
        this.fem = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.o.c.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.ass == 1 && alaUserAuthenVerifyInfoResponseMessage.asr != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.asr.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.asr.verify_video_status == 1) {
                            c.this.fed = 4;
                        }
                    }
                }
            }
        };
        this.fen = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.o.c.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    try {
                        JSONObject optJSONObject = new JSONObject((String) customResponsedMessage.getData()).optJSONObject("result").optJSONObject("zbwhitelistapi").optJSONObject("data");
                        boolean optBoolean = optJSONObject.optBoolean("inwhite");
                        int optInt = optJSONObject.optInt("is_verified");
                        c.this.fef = optJSONObject.optString("cmd");
                        if (optInt != 1) {
                            c.this.fdT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bnL();
                                }
                            }, 200L);
                        } else if (!optBoolean) {
                            c.this.fdT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.19.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bnM();
                                }
                            }, 200L);
                        } else {
                            c.this.bnJ();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.feo = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.o.c.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1003303);
                        }
                    });
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    c.this.fee = alaGetVerifyStrategyResponseHttpMessage.fdz;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fdx == 1 && alaGetVerifyStrategyResponseHttpMessage.fdv == 1) {
                            c.this.fej = null;
                            return;
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan()) && alaGetVerifyStrategyResponseHttpMessage.fdx == 1 && alaGetVerifyStrategyResponseHttpMessage.fdv == 1 && alaGetVerifyStrategyResponseHttpMessage.fdA == 1) {
                        c.this.fej = null;
                        return;
                    }
                    c.this.fej = alaGetVerifyStrategyResponseHttpMessage;
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fdx != 1 || alaGetVerifyStrategyResponseHttpMessage.fdv != 1) {
                            c.this.fdT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.20.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bnM();
                                }
                            }, 200L);
                        }
                    } else if (!TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isHaokan()) {
                        c.this.fdT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.20.5
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bnO();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.fdA != 1) {
                        c.this.fdT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.20.3
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bnL();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.fdx != 1 || alaGetVerifyStrategyResponseHttpMessage.fdv != 1) {
                        c.this.fdT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.20.4
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bnM();
                            }
                        }, 200L);
                    }
                }
            }
        };
        this.fep = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.o.c.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if (masterIdentityResponseMessage.bnw() == 1 || masterIdentityResponseMessage.bnx() == 1) {
                        c.this.fdV.a(13, masterIdentityResponseMessage.bny(), (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.feq = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.o.c.22
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.fer = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.o.c.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.fec = false;
                }
            }
        };
        this.fes = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.o.c.24
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        c.this.aiW = ((AlaEnterLiveHttpResonseMessage) responsedMessage).ww();
                        if (c.this.fdV != null) {
                            c.this.fdV.d(c.this.aiW);
                        }
                    }
                    if (c.this.aiW != null && c.this.aiW.mLiveInfo != null && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                        com.baidu.tieba.ala.liveroom.task.c.boQ().cW(c.this.aiW.mLiveInfo.live_id);
                        LiveTimerManager.getInstance().start(c.this.aiW.mLiveInfo.live_id);
                    }
                    if (c.this.aiW != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.aiW.Wt != null) {
                            if (c.this.aiW.Wt.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.aiW.Wt.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aiW.Wt.nickName);
                            if (!TextUtils.isEmpty(c.this.aiW.Wt.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.aiW.Wt.portrait);
                            }
                        }
                        if (c.this.aiW.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.aiW.mLiveSdkInfo.tbs);
                            com.baidu.live.c.oJ().putString("ala_account_user_tbs", c.this.aiW.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.aiW != null) {
                        if (c.this.fdY.size() <= 0) {
                            c.this.fdY.add(c.this.aiW.mLiveInfo);
                            c.this.fel.add(Long.valueOf(c.this.aiW.mLiveInfo.getLiveID()));
                        }
                        c.this.d(c.this.aiW.mLiveInfo);
                        c.this.fdV.z(c.this.aiW.Wx);
                    }
                    if (c.this.aiW != null && c.this.aiW.Wh != null) {
                        c.this.feg = c.this.aiW.Wh.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.aiW);
                    if (c.this.aiW != null && c.this.aiW.mLiveInfo != null) {
                        c.this.ac(String.valueOf(c.this.aiW.mLiveInfo.getGroupID()), String.valueOf(c.this.aiW.mLiveInfo.getLastMsgID()), String.valueOf(c.this.aiW.mLiveInfo.getUserID()));
                    }
                    if (c.this.aiW != null) {
                        c.this.aiW.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aiW));
                        k.uW().C(c.this.aiW.Wx);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.aiW != null && c.this.aiW.mLiveInfo != null) {
                            long j2 = c.this.aiW.mLiveInfo.live_id;
                            long j3 = c.this.aiW.mLiveInfo.room_id;
                            String str = c.this.aiW.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.aiW.Wf != null) {
                                long j4 = c.this.aiW.Wf.userId;
                                str2 = c.this.aiW.Wf.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.aiW != null && c.this.aiW.mLiveInfo != null) {
                        long j5 = c.this.aiW.mLiveInfo.live_id;
                        long j6 = c.this.aiW.mLiveInfo.room_id;
                        String str3 = c.this.aiW.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.aiW.Wf != null) {
                            j = c.this.aiW.Wf.userId;
                            str4 = c.this.aiW.Wf.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.feb + "");
                    }
                }
            }
        };
        this.fet = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.o.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    g gVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        gVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bbH();
                    }
                    if (gVar != null) {
                        c.this.esD = gVar;
                    }
                    if (c.this.aiW != null && c.this.aiW.Wh != null) {
                        if (c.this.feg == -1) {
                            c.this.feg = c.this.aiW.Wh.follow_status;
                        }
                        if (c.this.aiW.Wh.follow_status != c.this.feg) {
                            c.this.aiW.Wh.follow_status = c.this.feg;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.esD);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.esD));
                }
            }
        };
        this.feu = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.o.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> bnv = alaUserLiveMarkInfoResponseMessage.bnv();
                        c.this.fdV.z(bnv);
                        if (c.this.aiW != null) {
                            c.this.aiW.Wx = bnv;
                            k.uW().C(c.this.aiW.Wx);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.aiW));
                        }
                    }
                }
            }
        };
        this.fev = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.o.c.4
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                        }
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    l ww = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).ww() : null;
                    if (ww == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, ww);
                        return;
                    }
                    if (c.this.aiW == null) {
                        c.this.aiW = ww;
                        if (c.this.fdV != null) {
                            c.this.fdV.d(c.this.aiW);
                        }
                    }
                    if (c.this.aiW.mLiveInfo != null && ww.mLiveInfo != null && c.this.aiW.mLiveInfo.user_id == ww.mLiveInfo.user_id) {
                        if (c.this.aiW.mLiveInfo.imEffect != null && ww.mLiveInfo.imEffect == null) {
                            ww.mLiveInfo.imEffect = c.this.aiW.mLiveInfo.imEffect;
                        }
                        if (c.this.aiW.mLiveInfo.mLiveCloseData != null && ww.mLiveInfo.mLiveCloseData == null) {
                            ww.mLiveInfo.mLiveCloseData = c.this.aiW.mLiveInfo.mLiveCloseData;
                        }
                        if (c.this.aiW.mLiveInfo.mAlaLiveSwitchData != null && ww.mLiveInfo.mAlaLiveSwitchData == null) {
                            ww.mLiveInfo.mAlaLiveSwitchData = c.this.aiW.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    c.this.aiW.mLiveInfo = ww.mLiveInfo;
                    c.this.aiW.Wf = ww.Wf;
                    c.this.aiW.Wg = ww.Wg;
                    c.this.aiW.Wj = ww.Wj;
                    c.this.aiW.Wy = ww.Wy;
                    c.this.aiW.Ww = ww.Ww;
                    c.this.aiW.Wv = ww.Wv;
                    if (ww.WB != null && ww.WB.Zm != null && !ww.WB.Zm.isEmpty()) {
                        c.this.aiW.WB = ww.WB;
                    }
                    if (ww.Wt != null) {
                        if (ww.Wt.userId == 0) {
                            if (c.this.aiW.Wt == null) {
                                c.this.aiW.Wt = new AlaLiveUserInfoData();
                            }
                            c.this.aiW.Wt.throneUid = ww.Wt.throneUid;
                        } else {
                            boolean z = ww.Wt.isNewUser;
                            if (c.this.aiW.Wt != null) {
                                z = c.this.aiW.Wt.isNewUser;
                            }
                            ww.Wt.isNewUser = z;
                            c.this.aiW.Wt = ww.Wt;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aiW.Wt.nickName);
                        }
                    }
                    if (ww.Ww) {
                        c.this.aiW.Wx = ww.Wx;
                        c.this.fdV.z(ww.Wx);
                    }
                    if (!c.this.mIsHost) {
                        c.this.fdV.dz(String.valueOf(c.this.aiW.mLiveInfo.backstage_type));
                    }
                    if (c.this.fdV != null) {
                        c.this.fdV.d(c.this.aiW);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.aiW);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.aiW));
                    if (c.this.aiW != null) {
                        k.uW().C(c.this.aiW.Wx);
                    }
                }
            }
        };
        this.few = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.o.c.5
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
                    if (list != null && list.size() > 0 && c.this.fdY != null && c.this.fdY.size() > 0) {
                        for (int size = c.this.fdY.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.fdY.get(size)).live_id != c.this.aiW.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.fdY.get(size)).getLiveID()))) {
                                c.this.fdY.remove(size);
                            }
                        }
                    }
                    if (c.this.aiW != null) {
                        c.this.d(c.this.aiW.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.eKB = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.o.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.fex = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.o.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (!httpResponsedMessage.hasError() || BdNetTypeUtil.isNetWorkAvailable()) {
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.fdU = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.fdX = alaUpdateLiveTbResponseMessage.bnu();
                    if (c.this.fdX != null) {
                        if (c.this.fdX.eXa != 1 || c.this.fdX.eXc != 1) {
                            c.this.fdT.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.c.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bnN();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.fdX.Wf != null) {
                            c.this.fdV.z(c.this.fdX.Wf.live_mark_info_new);
                        }
                        if (c.this.fdX.mErrorCode != 0) {
                            if (c.this.fdX.mErrorCode == 220012) {
                                c.this.b(c.this.fdX.mErrorCode, c.this.fdX.mErrorMsg, 6, c.this.aiW);
                                return;
                            }
                        } else {
                            c.this.aiW = new l();
                            if (c.this.fdV != null) {
                                c.this.fdV.d(c.this.aiW);
                            }
                            c.this.aiW.mLiveInfo = c.this.fdX.mLiveInfo;
                            c.this.aiW.Wf = c.this.fdX.Wf;
                            c.this.aiW.mLiveSdkInfo = c.this.fdX.mLiveSdkInfo;
                            c.this.aiW.Wz = c.this.fdX.Wz;
                            c.this.aiW.Wx = c.this.fdX.Wf.live_mark_info_new;
                            if (c.this.fdX.Wf != null && c.this.fdX.Wf.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.fdX.Wf.levelId);
                            }
                            c.this.aiW.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aiW));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.aiW);
                    if (c.this.fdX != null && c.this.fdX.mLiveInfo != null) {
                        c.this.ac(String.valueOf(c.this.fdX.mLiveInfo.getGroupID()), String.valueOf(c.this.fdX.mLiveInfo.getLastMsgID()), String.valueOf(c.this.fdX.mLiveInfo.getUserID()));
                    }
                    if (c.this.aiW != null && c.this.aiW.mLiveInfo != null) {
                        c.this.w(c.this.aiW.mLiveInfo.user_id, c.this.aiW.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.fey = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.o.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.fdV.a(13, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.fez = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.o.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                i iVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        iVar = null;
                    } else {
                        iVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).bns();
                    }
                    if (iVar != null && !ListUtils.isEmpty(iVar.Wl)) {
                        c.this.fdZ = iVar.pn + 1;
                        com.baidu.live.data.h hVar = iVar.Wl.get(iVar.Wl.size() - 1);
                        if (hVar != null) {
                            c.this.fea = hVar.mLiveInfo.live_id;
                        }
                        c.this.a(iVar);
                        if (c.this.aiW != null) {
                            c.this.d(c.this.aiW.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, iVar);
                    }
                }
            }
        };
        this.feA = new com.baidu.live.liveroom.b.a() { // from class: com.baidu.tieba.ala.liveroom.o.c.17
        };
        this.mPageContext = bdPageContext;
        this.fdV = new com.baidu.live.im.d(bdPageContext, false, this);
        this.fdY = new ArrayList();
        this.fel = new HashSet();
        initTasks();
        registerListener(this.fev);
        registerListener(this.fet);
        registerListener(this.fes);
        registerListener(this.feq);
        this.fdS = BdUniqueId.gen();
        this.fez.setTag(this.fdS);
        registerListener(this.fez);
        registerListener(this.few);
        registerListener(this.fer);
        registerListener(this.fex);
        registerListener(this.eKB);
        registerListener(this.feo);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.fen);
        }
        registerListener(this.fem);
        registerListener(this.ern);
        registerListener(this.feu);
        registerListener(this.fep);
        registerListener(this.fey);
        MessageManager.getInstance().addMessageRule(this.fei);
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
        bnB();
        bnC();
        bnD();
        bnE();
        bnH();
    }

    private void bnB() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bnC() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void bnD() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void bnE() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void bnF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.o.c.12
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    c.this.c(customMessage.getData());
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void bnG() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void bnH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void w(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bnI() {
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

    public void bnJ() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
    }

    public void bnK() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bnL() {
        if (this.fek != null) {
            this.fek.dismiss();
            this.fek = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.fek = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fek.setAutoNight(false);
        this.fek.setMessage(string);
        this.fek.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.bnK();
                c.this.xe();
            }
        });
        this.fek.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.xe();
            }
        });
        this.fek.setCancelable(false);
        this.fek.setCanceledOnTouchOutside(false);
        this.fek.setTitleShowCenter(true);
        this.fek.setMessageShowCenter(true);
        this.fek.isShowTitleAndMessage();
        this.fek.create(this.mPageContext);
        this.fek.show();
    }

    public void bnM() {
        if (this.fek != null) {
            this.fek.dismiss();
            this.fek = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.fek = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fek.setAutoNight(false);
        this.fek.setMessage(string);
        this.fek.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (TbadkCoreApplication.getInst().isTieba()) {
                    String str = com.baidu.live.s.a.wR().asq.Yz;
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
                c.this.xe();
            }
        });
        this.fek.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.xe();
            }
        });
        this.fek.setCancelable(false);
        this.fek.setCanceledOnTouchOutside(false);
        this.fek.setTitleShowCenter(true);
        this.fek.setMessageShowCenter(true);
        this.fek.isShowTitleAndMessage();
        this.fek.create(this.mPageContext);
        this.fek.show();
    }

    public void bnN() {
        if (this.fek != null) {
            this.fek.dismiss();
            this.fek = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fek = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fek.setAutoNight(false);
        this.fek.setMessage(string);
        this.fek.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.14
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fek.setCancelable(false);
        this.fek.setCanceledOnTouchOutside(false);
        this.fek.isShowTitleAndMessage();
        this.fek.create(this.mPageContext);
        this.fek.show();
    }

    public void bnO() {
        if (this.fek != null) {
            this.fek.dismiss();
            this.fek = null;
        }
        if (this.fej != null) {
            a(this.fej);
        }
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fek = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fek.setAutoNight(false);
        this.fek.setMessage(string);
        this.fek.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.c.15
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fek.setCancelable(false);
        this.fek.setCanceledOnTouchOutside(false);
        this.fek.isShowTitleAndMessage();
        this.fek.create(this.mPageContext);
        this.fek.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.fej = null;
        this.fek = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe() {
        if (this.fek != null) {
            this.fek.dismiss();
            this.fek = null;
        }
        this.fej = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.fbe != null) {
            this.fbe.a(i, str, i2, obj);
        }
    }

    public void cU(long j) {
        com.baidu.tieba.ala.liveroom.messages.b bVar = new com.baidu.tieba.ala.liveroom.messages.b();
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.setFrom(str);
        bVar.D(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void bnP() {
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

    public void qp(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void x(long j, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.D(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public h bnQ() {
        return this.fdX;
    }

    public l ww() {
        return this.aiW;
    }

    public List<AlaLiveInfoData> bnR() {
        return this.fdY;
    }

    public g bbH() {
        return this.esD;
    }

    public void bF(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aiW != null && this.aiW.mLiveInfo != null) {
                aVar.setAudienceCount(this.aiW.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bnS() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.fdY) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        bF(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        if (iVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
                if (this.fdY.size() == 1 && this.fdY.get(0).live_id == this.aiW.mLiveInfo.live_id) {
                    if (c(iVar) != null) {
                        this.fdY.clear();
                    }
                    b(iVar);
                    return;
                }
                b(iVar);
                return;
            }
            b(iVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(i iVar) {
        boolean z;
        for (com.baidu.live.data.h hVar : iVar.Wl) {
            if (hVar != null && hVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.fdY) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == hVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.fdY.add(hVar.mLiveInfo);
                }
            }
        }
        if (this.fdY.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.fdY.size() - 200; size < this.fdY.size(); size++) {
                arrayList.add(this.fdY.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.fdY.clear();
                this.fdY.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(i iVar) {
        if (ListUtils.isEmpty(iVar.Wl)) {
            return null;
        }
        for (com.baidu.live.data.h hVar : iVar.Wl) {
            if (hVar != null && hVar.mLiveInfo != null && hVar.mLiveInfo.live_id == this.aiW.mLiveInfo.live_id) {
                return hVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bnT() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.fdY)) {
            return null;
        }
        if (this.fel.isEmpty()) {
            arrayList.addAll(this.fdY);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fdY.size()) {
                    break;
                }
                if ((this.aiW == null || this.aiW.mLiveInfo == null || this.aiW.mLiveInfo.live_id != this.fdY.get(i2).live_id) && !this.fel.contains(Long.valueOf(this.fdY.get(i2).live_id))) {
                    arrayList.add(this.fdY.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void c(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.fel.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.fel.size() >= this.fdY.size() - 4) {
                jG(false);
            }
        }
    }

    public void qq(int i) {
        this.feh = i;
    }

    public int bnU() {
        return this.feh;
    }

    public void jG(boolean z) {
        if (com.baidu.live.liveroom.b.d.wq().wo()) {
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && 1 != this.feh) {
                jH(z);
                return;
            } else {
                com.baidu.live.liveroom.b.d.wq().ws().a("tieba", this.fdZ, 20, this.feA);
                return;
            }
        }
        jH(z);
    }

    private void jH(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.fdZ);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.fea);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.fdS);
            sendMessage(httpMessage);
        }
    }

    public void cL(String str, String str2) {
        this.fdV.us();
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
        aVar.sn(str);
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
        aVar.sn(str2);
        aVar.yP(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void yQ(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.dE(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void cV(long j) {
        this.fdV.us();
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
        if (!bnV()) {
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
            httpMessage.addParam("screen_direction", i5);
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
                BdStatisticsManager.getInstance().newDebug("updatelive", 0L, null, "forum_name", str, "forum_id", str2, "description", str3, "is_location", Integer.valueOf(i), "lat", Double.toString(d), "lng", Double.toString(d2), "location_name", str4, "location_name_md5", str5, "is_to_tb_some", Integer.valueOf(i2), "cover", str6, "vcode", str7, "vcode_md5", str8, "is_test_live", Integer.valueOf(i3), "live_type", Integer.valueOf(i4), "screen_direction", Integer.valueOf(i5), "clarity", Integer.valueOf(i6), "game_id", str9, "game_name", str10);
            }
        }
    }

    private boolean bnV() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bnW() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aiW == null) {
            this.aiW = new l(alaLiveInfoCoreData);
            if (this.fdV != null) {
                this.fdV.d(this.aiW);
            }
        }
        this.fea = this.aiW.mLiveInfo.live_id;
    }

    public void h(String str, boolean z, boolean z2) {
        HttpMessage httpMessage = new HttpMessage(1021040);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("is_cancel", z ? 1 : 0);
        httpMessage.addParam("is_success", z2 ? 1 : 0);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        if (this.aiW == null) {
            this.aiW = new l();
            if (this.fdV != null) {
                this.fdV.d(this.aiW);
            }
        }
        this.aiW.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aiW.Wf = alaLivePersonData.mUserData;
        this.aiW.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aiW.Wf != null) {
            this.fdV.z(this.aiW.Wf.live_mark_info_new);
        }
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
        this.fdT.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.fez);
        MessageManager.getInstance().removeMessageRule(this.fei);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        this.fdV.us();
        this.fdW = null;
        this.mPageContext = null;
    }

    public void qr(int i) {
        this.feb = i;
        if (this.fdY.size() == 0) {
            this.feb = 0;
        } else if (this.feb < 0) {
            this.feb = this.fdY.size() + this.feb;
        } else {
            this.feb %= this.fdY.size();
        }
    }

    public void d(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.fdY.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fdY.size()) {
                    if (this.fdY.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.feb = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bnX() {
        long j;
        if (this.fdY.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.fdY.get(0);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.aiW.mLiveInfo.live_id;
        }
        return true;
    }

    public boolean bnY() {
        long j;
        if (this.fdY.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.fdY.get(this.fdY.size() - 1);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.aiW.mLiveInfo.live_id;
        }
        return true;
    }

    public int bnZ() {
        return this.feb;
    }

    public int boa() {
        return this.fed;
    }

    public boolean bob() {
        return this.fee == 1;
    }

    public AlaLiveInfoData boc() {
        if (this.feb >= this.fdY.size()) {
            this.feb = this.fdY.size() - 1;
        }
        if (this.feb < 0) {
            this.feb = 0;
        }
        if (this.fdY.size() <= this.feb) {
            if (this.aiW != null) {
                return this.aiW.mLiveInfo;
            }
            return null;
        }
        return this.fdY.get(this.feb);
    }

    public void a(a aVar) {
        this.fbe = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.fdW != null) {
            this.fdW.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void g(com.baidu.live.im.data.a aVar) {
        if (this.aiW != null && this.aiW.mLiveInfo.live_type == 1) {
            t(aVar);
        }
        if (this.fdW != null) {
            this.fdW.g(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void t(com.baidu.live.im.data.a aVar) {
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
            jG(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void uu() {
        if (this.fdW != null) {
            this.fdW.uu();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aiW != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aiW.Wf;
            } else {
                alaLiveUserInfoData = this.aiW.Wt;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aiW.mLiveInfo.imEffect;
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aiW != null && this.aiW.Wt != null && this.aiW.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aiW.Wt.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr == null || strArr.length != 2) {
                            strArr = new String[2];
                        }
                        strArr[0] = "guard_seat_effect";
                    }
                }
                this.fdV.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr);
            }
        }
    }

    public void ac(String str, String str2, String str3) {
        this.fdV.e(String.valueOf(this.aiW.mLiveInfo.getGroupID()), String.valueOf(this.aiW.mLiveInfo.getLastMsgID()), String.valueOf(this.aiW.mLiveInfo.getUserID()), String.valueOf(this.aiW.mLiveInfo.getLiveID()), this.aiW.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bod() {
        return this.fdV;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
