package com.baidu.tieba.ala.liveroom.m;

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
import com.baidu.live.data.e;
import com.baidu.live.data.f;
import com.baidu.live.data.i;
import com.baidu.live.im.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.k;
import com.baidu.live.k.a;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.message.AlaUserAuthenVerifyInfoResponseMessage;
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
import com.baidu.tieba.ala.liveroom.data.g;
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
/* loaded from: classes6.dex */
public class c extends BdBaseModel implements d.a {
    private i aaj;
    private CustomMessageListener dEn;
    private e dFo;
    private HttpMessageListener dTL;
    private a eir;
    private BdUniqueId ekN;
    private Handler ekO;
    private HttpMessage ekP;
    private d ekQ;
    private d.a ekR;
    private g ekS;
    private List<AlaLiveInfoData> ekT;
    private int ekU;
    private long ekV;
    private int ekW;
    private boolean ekX;
    private int ekY;
    private int ekZ;
    private String ela;
    private int elb;
    private int elc;
    private com.baidu.live.j.a eld;
    private AlaGetVerifyStrategyResponseHttpMessage ele;
    private BdAlertDialog elf;
    private Set<Long> elg;
    private HttpMessageListener elh;
    private CustomMessageListener eli;
    private HttpMessageListener elj;
    private HttpMessageListener elk;
    private NetMessageListener ell;
    private HttpMessageListener elm;
    private NetMessageListener eln;
    private HttpMessageListener elo;
    private HttpMessageListener elp;
    private NetMessageListener elq;
    private NetMessageListener elr;
    private HttpMessageListener els;
    private HttpMessageListener elt;
    private com.baidu.live.liveroom.b.a elu;
    private boolean mIsHost;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.ekO = new Handler();
        this.ekU = 0;
        this.ekW = 0;
        this.ekX = true;
        this.ekY = 1;
        this.ekZ = 0;
        this.elb = -1;
        this.elc = 0;
        this.eld = new com.baidu.live.j.a(0);
        this.otherParams = "";
        this.dEn = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.aaj != null && c.this.aaj.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.aaj.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.elb = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.aaj.mLiveInfo.user_id).param("obj_param1", c.this.aaj.mLiveInfo.live_id).param("tid", c.this.aaj.mLiveInfo.thread_id));
                            c.this.elb = 1;
                        }
                        if (c.this.aaj != null && c.this.aaj.OU != null) {
                            c.this.aaj.OU.follow_status = c.this.elb;
                        }
                    }
                }
            }
        };
        this.elh = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.m.c.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.ajH == 1 && alaUserAuthenVerifyInfoResponseMessage.ajG != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.ajG.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.ajG.verify_video_status == 1) {
                            c.this.ekY = 4;
                        }
                    }
                }
            }
        };
        this.eli = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.m.c.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    try {
                        JSONObject optJSONObject = new JSONObject((String) customResponsedMessage.getData()).optJSONObject("result").optJSONObject("zbwhitelistapi").optJSONObject("data");
                        boolean optBoolean = optJSONObject.optBoolean("inwhite");
                        int optInt = optJSONObject.optInt("is_verified");
                        c.this.ela = optJSONObject.optString("cmd");
                        if (optInt != 1) {
                            c.this.ekO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.tS(c.this.ela);
                                }
                            }, 200L);
                        } else if (!optBoolean) {
                            c.this.ekO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.19.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.aUV();
                                }
                            }, 200L);
                        } else {
                            c.this.aUT();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.elj = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.m.c.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetVerifyStrategyResponseHttpMessage)) {
                    SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MessageManager.getInstance().unRegisterStickyMode(1003303);
                        }
                    });
                    AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage = (AlaGetVerifyStrategyResponseHttpMessage) httpResponsedMessage;
                    c.this.ekZ = alaGetVerifyStrategyResponseHttpMessage.ekw;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (alaGetVerifyStrategyResponseHttpMessage.eku != 1 || alaGetVerifyStrategyResponseHttpMessage.eks != 1) {
                        c.this.ele = alaGetVerifyStrategyResponseHttpMessage;
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (alaGetVerifyStrategyResponseHttpMessage.eku != 1 || alaGetVerifyStrategyResponseHttpMessage.eks != 1) {
                                c.this.ekO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.aUV();
                                    }
                                }, 200L);
                                return;
                            }
                            return;
                        } else if (!TbadkCoreApplication.getInst().isTieba()) {
                            c.this.ekO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.aUX();
                                }
                            }, 200L);
                            return;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.eku != 1) {
                            c.this.ekO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.tS(c.this.ela);
                                }
                            }, 200L);
                            return;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.eks != 1) {
                            c.this.ekO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.aUV();
                                }
                            }, 200L);
                            return;
                        } else {
                            return;
                        }
                    }
                    c.this.ele = null;
                }
            }
        };
        this.elk = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.m.c.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if (masterIdentityResponseMessage.aUG() == 1 || masterIdentityResponseMessage.aUH() == 1) {
                        c.this.ekQ.a(13, masterIdentityResponseMessage.aUI(), (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.ell = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.m.c.22
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.elm = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.m.c.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.ekX = false;
                }
            }
        };
        this.eln = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.m.c.24
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        c.this.aaj = ((AlaEnterLiveHttpResonseMessage) responsedMessage).uk();
                        if (c.this.ekQ != null) {
                            c.this.ekQ.d(c.this.aaj);
                        }
                    }
                    if (c.this.aaj != null && c.this.aaj.mLiveInfo != null) {
                        com.baidu.tieba.ala.liveroom.task.c.aWb().cl(c.this.aaj.mLiveInfo.live_id);
                        LiveTimerManager.getInstance().start(c.this.aaj.mLiveInfo.live_id);
                    }
                    if (c.this.aaj != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.aaj.Pj != null) {
                            if (c.this.aaj.Pj.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.aaj.Pj.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aaj.Pj.nickName);
                            if (!TextUtils.isEmpty(c.this.aaj.Pj.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.aaj.Pj.portrait);
                            }
                        }
                        if (c.this.aaj.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.aaj.mLiveSdkInfo.tbs);
                            com.baidu.live.c.np().putString("ala_account_user_tbs", c.this.aaj.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.aaj != null) {
                        if (c.this.ekT.size() <= 0) {
                            c.this.ekT.add(c.this.aaj.mLiveInfo);
                            c.this.elg.add(Long.valueOf(c.this.aaj.mLiveInfo.getLiveID()));
                        }
                        c.this.d(c.this.aaj.mLiveInfo);
                        c.this.ekQ.C(c.this.aaj.Pl);
                    }
                    if (c.this.aaj != null && c.this.aaj.OU != null) {
                        c.this.elb = c.this.aaj.OU.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.aaj);
                    if (c.this.aaj != null && c.this.aaj.mLiveInfo != null) {
                        c.this.Q(String.valueOf(c.this.aaj.mLiveInfo.getGroupID()), String.valueOf(c.this.aaj.mLiveInfo.getLastMsgID()), String.valueOf(c.this.aaj.mLiveInfo.getUserID()));
                    }
                    if (c.this.aaj != null) {
                        c.this.aaj.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aaj));
                        k.sN().F(c.this.aaj.Pl);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.aaj != null && c.this.aaj.mLiveInfo != null) {
                            long j2 = c.this.aaj.mLiveInfo.live_id;
                            long j3 = c.this.aaj.mLiveInfo.room_id;
                            String str = c.this.aaj.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.aaj.OR != null) {
                                long j4 = c.this.aaj.OR.userId;
                                str2 = c.this.aaj.OR.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.aaj != null && c.this.aaj.mLiveInfo != null) {
                        long j5 = c.this.aaj.mLiveInfo.live_id;
                        long j6 = c.this.aaj.mLiveInfo.room_id;
                        String str3 = c.this.aaj.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.aaj.OR != null) {
                            j = c.this.aaj.OR.userId;
                            str4 = c.this.aaj.OR.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.ekW + "");
                    }
                }
            }
        };
        this.elo = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.m.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    e eVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        eVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).aKw();
                    }
                    if (eVar != null) {
                        c.this.dFo = eVar;
                    }
                    if (c.this.aaj != null && c.this.aaj.OU != null) {
                        if (c.this.elb == -1) {
                            c.this.elb = c.this.aaj.OU.follow_status;
                        }
                        if (c.this.aaj.OU.follow_status != c.this.elb) {
                            c.this.aaj.OU.follow_status = c.this.elb;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.dFo);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.dFo));
                }
            }
        };
        this.elp = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.m.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> aUF = alaUserLiveMarkInfoResponseMessage.aUF();
                        c.this.ekQ.C(aUF);
                        if (c.this.aaj != null) {
                            c.this.aaj.Pl = aUF;
                            k.sN().F(c.this.aaj.Pl);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.aaj));
                        }
                    }
                }
            }
        };
        this.elq = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.m.c.4
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                        }
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    i uk = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).uk() : null;
                    if (uk == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, uk);
                        return;
                    }
                    if (c.this.aaj == null) {
                        c.this.aaj = uk;
                        if (c.this.ekQ != null) {
                            c.this.ekQ.d(c.this.aaj);
                        }
                    }
                    if (c.this.aaj.mLiveInfo != null && uk.mLiveInfo != null && c.this.aaj.mLiveInfo.user_id == uk.mLiveInfo.user_id) {
                        if (c.this.aaj.mLiveInfo.imEffect != null && uk.mLiveInfo.imEffect == null) {
                            uk.mLiveInfo.imEffect = c.this.aaj.mLiveInfo.imEffect;
                        }
                        if (c.this.aaj.mLiveInfo.mLiveCloseData != null && uk.mLiveInfo.mLiveCloseData == null) {
                            uk.mLiveInfo.mLiveCloseData = c.this.aaj.mLiveInfo.mLiveCloseData;
                        }
                    }
                    c.this.aaj.mLiveInfo = uk.mLiveInfo;
                    c.this.aaj.OR = uk.OR;
                    c.this.aaj.OT = uk.OT;
                    c.this.aaj.OW = uk.OW;
                    c.this.aaj.Pm = uk.Pm;
                    c.this.aaj.Pk = uk.Pk;
                    if (uk.Pp != null) {
                        c.this.aaj.Pp = uk.Pp;
                    }
                    if (uk.Pj != null && uk.Pj.userId != 0) {
                        boolean z = uk.Pj.isNewUser;
                        if (c.this.aaj.Pj != null) {
                            z = c.this.aaj.Pj.isNewUser;
                        }
                        uk.Pj.isNewUser = z;
                        c.this.aaj.Pj = uk.Pj;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aaj.Pj.nickName);
                    }
                    if (uk.Pk) {
                        c.this.aaj.Pl = uk.Pl;
                        c.this.ekQ.C(uk.Pl);
                    }
                    if (!c.this.mIsHost) {
                        c.this.ekQ.cF(String.valueOf(c.this.aaj.mLiveInfo.backstage_type));
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.aaj);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.aaj));
                    if (c.this.aaj != null) {
                        k.sN().F(c.this.aaj.Pl);
                    }
                }
            }
        };
        this.elr = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.m.c.5
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
                    if (list != null && list.size() > 0 && c.this.ekT != null && c.this.ekT.size() > 0) {
                        for (int size = c.this.ekT.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.ekT.get(size)).live_id != c.this.aaj.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.ekT.get(size)).getLiveID()))) {
                                c.this.ekT.remove(size);
                            }
                        }
                    }
                    if (c.this.aaj != null) {
                        c.this.d(c.this.aaj.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.dTL = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.m.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.els = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.m.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (!httpResponsedMessage.hasError() || BdNetTypeUtil.isNetWorkAvailable()) {
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.ekP = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.ekS = alaUpdateLiveTbResponseMessage.aUE();
                    if (c.this.ekS != null) {
                        if (c.this.ekS.efl != 1 || c.this.ekS.efn != 1) {
                            c.this.ekO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.aUW();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.ekS.OR != null) {
                            c.this.ekQ.C(c.this.ekS.OR.live_mark_info_new);
                        }
                        if (c.this.ekS.mErrorCode != 0) {
                            if (c.this.ekS.mErrorCode == 220012) {
                                c.this.b(c.this.ekS.mErrorCode, c.this.ekS.mErrorMsg, 6, c.this.aaj);
                                return;
                            }
                        } else {
                            c.this.aaj = new i();
                            if (c.this.ekQ != null) {
                                c.this.ekQ.d(c.this.aaj);
                            }
                            c.this.aaj.mLiveInfo = c.this.ekS.mLiveInfo;
                            c.this.aaj.OR = c.this.ekS.OR;
                            c.this.aaj.mLiveSdkInfo = c.this.ekS.mLiveSdkInfo;
                            c.this.aaj.Pn = c.this.ekS.Pn;
                            c.this.aaj.Pl = c.this.ekS.OR.live_mark_info_new;
                            if (c.this.ekS.OR != null && c.this.ekS.OR.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.ekS.OR.levelId);
                            }
                            c.this.aaj.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aaj));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.aaj);
                    if (c.this.ekS != null && c.this.ekS.mLiveInfo != null) {
                        c.this.Q(String.valueOf(c.this.ekS.mLiveInfo.getGroupID()), String.valueOf(c.this.ekS.mLiveInfo.getLastMsgID()), String.valueOf(c.this.ekS.mLiveInfo.getUserID()));
                    }
                    if (c.this.aaj != null && c.this.aaj.mLiveInfo != null) {
                        c.this.r(c.this.aaj.mLiveInfo.user_id, c.this.aaj.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.elt = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.m.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                com.baidu.live.data.g gVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        gVar = null;
                    } else {
                        gVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).aUC();
                    }
                    if (gVar != null && !ListUtils.isEmpty(gVar.OY)) {
                        c.this.ekU = gVar.pn + 1;
                        f fVar = gVar.OY.get(gVar.OY.size() - 1);
                        if (fVar != null) {
                            c.this.ekV = fVar.mLiveInfo.live_id;
                        }
                        c.this.a(gVar);
                        if (c.this.aaj != null) {
                            c.this.d(c.this.aaj.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, gVar);
                    }
                }
            }
        };
        this.elu = new com.baidu.live.liveroom.b.a() { // from class: com.baidu.tieba.ala.liveroom.m.c.17
        };
        this.mPageContext = bdPageContext;
        this.ekQ = new d(bdPageContext, false, this);
        this.ekT = new ArrayList();
        this.elg = new HashSet();
        initTasks();
        registerListener(this.elq);
        registerListener(this.elo);
        registerListener(this.eln);
        registerListener(this.ell);
        this.ekN = BdUniqueId.gen();
        this.elt.setTag(this.ekN);
        registerListener(this.elt);
        registerListener(this.elr);
        registerListener(this.elm);
        registerListener(this.els);
        registerListener(this.dTL);
        registerListener(this.elj);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.eli);
        }
        registerListener(this.elh);
        registerListener(this.dEn);
        registerListener(this.elp);
        registerListener(this.elk);
        MessageManager.getInstance().addMessageRule(this.eld);
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
        aUL();
        aUM();
        aUN();
        aUO();
        aUR();
    }

    private void aUL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void aUM() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void aUN() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void aUO() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void aUP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913043, new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.m.c.12
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

    public void aUQ() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void aUR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void r(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aUS() {
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

    public void aUT() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
    }

    public void aUU() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void tS(final String str) {
        if (this.elf != null) {
            this.elf.dismiss();
            this.elf = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.elf = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.elf.setAutoNight(false);
        this.elf.setMessage(string);
        if (TbadkCoreApplication.getInst().isTieba()) {
            this.elf.setPositiveButton(this.mPageContext.getString(a.i.sdk_live_iknow), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.aAk();
                }
            });
        } else {
            this.elf.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (!TbadkCoreApplication.getInst().isQuanmin()) {
                        BrowserHelper.startInternalWebActivity(c.this.mPageContext.getPageActivity(), str);
                    } else {
                        c.this.aUU();
                    }
                    c.this.aAk();
                }
            });
            this.elf.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.aAk();
                }
            });
        }
        this.elf.setCancelable(false);
        this.elf.setCanceledOnTouchOutside(false);
        this.elf.setTitleShowCenter(true);
        this.elf.setMessageShowCenter(true);
        this.elf.isShowTitleAndMessage();
        this.elf.create(this.mPageContext);
        this.elf.show();
    }

    public void aUV() {
        if (this.elf != null) {
            this.elf.dismiss();
            this.elf = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.elf = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.elf.setAutoNight(false);
        this.elf.setMessage(string);
        this.elf.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (TbadkCoreApplication.getInst().isTieba()) {
                    String str = com.baidu.live.l.a.uB().ajF.Rz;
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
                c.this.aAk();
            }
        });
        this.elf.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.aAk();
            }
        });
        this.elf.setCancelable(false);
        this.elf.setCanceledOnTouchOutside(false);
        this.elf.setTitleShowCenter(true);
        this.elf.setMessageShowCenter(true);
        this.elf.isShowTitleAndMessage();
        this.elf.create(this.mPageContext);
        this.elf.show();
    }

    public void aUW() {
        if (this.elf != null) {
            this.elf.dismiss();
            this.elf = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.elf = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.elf.setAutoNight(false);
        this.elf.setMessage(string);
        this.elf.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.14
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.elf.setCancelable(false);
        this.elf.setCanceledOnTouchOutside(false);
        this.elf.isShowTitleAndMessage();
        this.elf.create(this.mPageContext);
        this.elf.show();
    }

    public void aUX() {
        if (this.elf != null) {
            this.elf.dismiss();
            this.elf = null;
        }
        if (this.ele != null) {
            a(this.ele);
        }
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.elf = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.elf.setAutoNight(false);
        this.elf.setMessage(string);
        this.elf.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.15
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.elf.setCancelable(false);
        this.elf.setCanceledOnTouchOutside(false);
        this.elf.isShowTitleAndMessage();
        this.elf.create(this.mPageContext);
        this.elf.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.ele = null;
        this.elf = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAk() {
        if (this.elf != null) {
            this.elf.dismiss();
            this.elf = null;
        }
        this.ele = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.eir != null) {
            this.eir.a(i, str, i2, obj);
        }
    }

    public void cj(long j) {
        com.baidu.tieba.ala.liveroom.messages.b bVar = new com.baidu.tieba.ala.liveroom.messages.b();
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.a aVar = new com.baidu.live.message.a();
        aVar.setLiveId(j);
        aVar.setFrom(str);
        aVar.B(j2);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void aUY() {
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

    public void nT(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void s(long j, long j2) {
        com.baidu.live.message.a aVar = new com.baidu.live.message.a();
        aVar.setLiveId(j);
        aVar.B(j2);
        aVar.setParams();
        sendMessage(aVar);
    }

    public g aUZ() {
        return this.ekS;
    }

    public i uk() {
        return this.aaj;
    }

    public List<AlaLiveInfoData> aVa() {
        return this.ekT;
    }

    public e aKw() {
        return this.dFo;
    }

    public void bG(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aaj != null && this.aaj.mLiveInfo != null) {
                aVar.setAudienceCount(this.aaj.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void aVb() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.ekT) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        bG(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.g gVar) {
        if (gVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
                if (this.ekT.size() == 1 && this.ekT.get(0).live_id == this.aaj.mLiveInfo.live_id) {
                    if (c(gVar) != null) {
                        this.ekT.clear();
                    }
                    b(gVar);
                    return;
                }
                b(gVar);
                return;
            }
            b(gVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.baidu.live.data.g gVar) {
        boolean z;
        for (f fVar : gVar.OY) {
            if (fVar != null && fVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.ekT) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == fVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.ekT.add(fVar.mLiveInfo);
                }
            }
        }
        if (this.ekT.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.ekT.size() - 200; size < this.ekT.size(); size++) {
                arrayList.add(this.ekT.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.ekT.clear();
                this.ekT.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(com.baidu.live.data.g gVar) {
        if (ListUtils.isEmpty(gVar.OY)) {
            return null;
        }
        for (f fVar : gVar.OY) {
            if (fVar != null && fVar.mLiveInfo != null && fVar.mLiveInfo.live_id == this.aaj.mLiveInfo.live_id) {
                return fVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> aVc() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.ekT)) {
            return null;
        }
        if (this.elg.isEmpty()) {
            arrayList.addAll(this.ekT);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ekT.size()) {
                    break;
                }
                if ((this.aaj == null || this.aaj.mLiveInfo == null || this.aaj.mLiveInfo.live_id != this.ekT.get(i2).live_id) && !this.elg.contains(Long.valueOf(this.ekT.get(i2).live_id))) {
                    arrayList.add(this.ekT.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void c(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.elg.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.elg.size() >= this.ekT.size() - 4) {
                ie(false);
            }
        }
    }

    public void nU(int i) {
        this.elc = i;
    }

    public int aVd() {
        return this.elc;
    }

    public void ie(boolean z) {
        if (com.baidu.live.liveroom.b.d.ue().uc()) {
            if (1 != this.elc) {
                m23if(z);
                return;
            } else {
                com.baidu.live.liveroom.b.d.ue().ug().a("tieba", this.ekU, 20, this.elu);
                return;
            }
        }
        m23if(z);
    }

    /* renamed from: if  reason: not valid java name */
    private void m23if(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.ekU);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.ekV);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.ekN);
            sendMessage(httpMessage);
        }
    }

    public void cq(String str, String str2) {
        this.ekQ.sk();
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
            aVar.d(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str2);
        aVar.mX(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void P(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.d(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.mX(str2);
        aVar.tR(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void tT(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.d(address.getLongitude(), address.getLatitude());
        }
        aVar.cL(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void ck(long j) {
        this.ekQ.sk();
        com.baidu.tieba.ala.liveroom.messages.c cVar = new com.baidu.tieba.ala.liveroom.messages.c();
        cVar.setLiveId(j);
        cVar.setParams();
        sendMessage(cVar);
    }

    public void a(String str, String str2, String str3, int i, double d, double d2, String str4, String str5, int i2, String str6, int i3, int i4, int i5, int i6, String str7, String str8) {
        a(str, str2, str3, i, d, d2, str4, str5, i2, str6, null, null, i3, i4, i5, i6, str7, str8);
    }

    public void a(String str, String str2, String str3, int i, double d, double d2, String str4, String str5, int i2, String str6, String str7, String str8, int i3, int i4, int i5, int i6, String str9, String str10) {
        this.mIsHost = true;
        if (!aVe()) {
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

    private boolean aVe() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void aVf() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aaj == null) {
            this.aaj = new i(alaLiveInfoCoreData);
            if (this.ekQ != null) {
                this.ekQ.d(this.aaj);
            }
        }
        this.ekV = this.aaj.mLiveInfo.live_id;
    }

    public void h(String str, boolean z, boolean z2) {
        HttpMessage httpMessage = new HttpMessage(1021040);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("is_cancel", z ? 1 : 0);
        httpMessage.addParam("is_success", z2 ? 1 : 0);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(AlaLivePersonData alaLivePersonData) {
        if (this.aaj == null) {
            this.aaj = new i();
            if (this.ekQ != null) {
                this.ekQ.d(this.aaj);
            }
        }
        this.aaj.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aaj.OR = alaLivePersonData.mUserData;
        this.aaj.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aaj.OR != null) {
            this.ekQ.C(this.aaj.OR.live_mark_info_new);
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
        this.ekO.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.elt);
        MessageManager.getInstance().removeMessageRule(this.eld);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        this.ekQ.sk();
        this.ekR = null;
        this.mPageContext = null;
    }

    public void nV(int i) {
        this.ekW = i;
        if (this.ekT.size() == 0) {
            this.ekW = 0;
        } else if (this.ekW < 0) {
            this.ekW = this.ekT.size() + this.ekW;
        } else {
            this.ekW %= this.ekT.size();
        }
    }

    public void d(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.ekT.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.ekT.size()) {
                    if (this.ekT.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.ekW = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean aVg() {
        long j;
        if (this.ekT.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.ekT.get(0);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.aaj.mLiveInfo.live_id;
        }
        return true;
    }

    public boolean aVh() {
        long j;
        if (this.ekT.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.ekT.get(this.ekT.size() - 1);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.aaj.mLiveInfo.live_id;
        }
        return true;
    }

    public int aVi() {
        return this.ekW;
    }

    public int aVj() {
        return this.ekY;
    }

    public boolean aVk() {
        return this.ekZ == 1;
    }

    public AlaLiveInfoData aVl() {
        if (this.ekW >= this.ekT.size()) {
            this.ekW = this.ekT.size() - 1;
        }
        if (this.ekW < 0) {
            this.ekW = 0;
        }
        if (this.ekT.size() <= this.ekW) {
            if (this.aaj != null) {
                return this.aaj.mLiveInfo;
            }
            return null;
        }
        return this.ekT.get(this.ekW);
    }

    public void a(a aVar) {
        this.eir = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.ekR != null) {
            this.ekR.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void g(com.baidu.live.im.data.a aVar) {
        if (this.aaj != null && this.aaj.mLiveInfo.live_type == 1) {
            t(aVar);
        }
        if (this.ekR != null) {
            this.ekR.g(aVar);
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
            ie(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void sm() {
        if (this.ekR != null) {
            this.ekR.sm();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aaj != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aaj.OR;
            } else {
                alaLiveUserInfoData = this.aaj.Pj;
            }
            if (alaLiveUserInfoData != null) {
                this.ekQ.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, this.aaj.mLiveInfo.imEffect);
            }
        }
    }

    public void Q(String str, String str2, String str3) {
        this.ekQ.e(String.valueOf(this.aaj.mLiveInfo.getGroupID()), String.valueOf(this.aaj.mLiveInfo.getLastMsgID()), String.valueOf(this.aaj.mLiveInfo.getUserID()), String.valueOf(this.aaj.mLiveInfo.getLiveID()), this.aaj.mLiveInfo.appId);
    }

    public d aVm() {
        return this.ekQ;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
