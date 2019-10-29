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
    private i aaB;
    private CustomMessageListener dFe;
    private e dGf;
    private HttpMessageListener dUC;
    private a eji;
    private BdUniqueId elE;
    private Handler elF;
    private HttpMessage elG;
    private d elH;
    private d.a elI;
    private g elJ;
    private List<AlaLiveInfoData> elK;
    private int elL;
    private long elM;
    private int elN;
    private boolean elO;
    private int elP;
    private int elQ;
    private String elR;
    private int elS;
    private int elT;
    private com.baidu.live.j.a elU;
    private AlaGetVerifyStrategyResponseHttpMessage elV;
    private BdAlertDialog elW;
    private Set<Long> elX;
    private HttpMessageListener elY;
    private CustomMessageListener elZ;
    private HttpMessageListener ema;
    private HttpMessageListener emb;
    private NetMessageListener emc;
    private HttpMessageListener emd;
    private NetMessageListener eme;
    private HttpMessageListener emf;
    private HttpMessageListener emg;
    private NetMessageListener emh;
    private NetMessageListener emi;
    private HttpMessageListener emj;
    private HttpMessageListener emk;
    private com.baidu.live.liveroom.b.a eml;
    private boolean mIsHost;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.elF = new Handler();
        this.elL = 0;
        this.elN = 0;
        this.elO = true;
        this.elP = 1;
        this.elQ = 0;
        this.elS = -1;
        this.elT = 0;
        this.elU = new com.baidu.live.j.a(0);
        this.otherParams = "";
        this.dFe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.aaB != null && c.this.aaB.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.aaB.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.elS = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.aaB.mLiveInfo.user_id).param("obj_param1", c.this.aaB.mLiveInfo.live_id).param("tid", c.this.aaB.mLiveInfo.thread_id));
                            c.this.elS = 1;
                        }
                        if (c.this.aaB != null && c.this.aaB.Pu != null) {
                            c.this.aaB.Pu.follow_status = c.this.elS;
                        }
                    }
                }
            }
        };
        this.elY = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.m.c.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.ajZ == 1 && alaUserAuthenVerifyInfoResponseMessage.ajY != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.ajY.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.ajY.verify_video_status == 1) {
                            c.this.elP = 4;
                        }
                    }
                }
            }
        };
        this.elZ = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.m.c.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    try {
                        JSONObject optJSONObject = new JSONObject((String) customResponsedMessage.getData()).optJSONObject("result").optJSONObject("zbwhitelistapi").optJSONObject("data");
                        boolean optBoolean = optJSONObject.optBoolean("inwhite");
                        int optInt = optJSONObject.optInt("is_verified");
                        c.this.elR = optJSONObject.optString("cmd");
                        if (optInt != 1) {
                            c.this.elF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.tS(c.this.elR);
                                }
                            }, 200L);
                        } else if (!optBoolean) {
                            c.this.elF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.19.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.aUX();
                                }
                            }, 200L);
                        } else {
                            c.this.aUV();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.ema = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.m.c.20
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
                    c.this.elQ = alaGetVerifyStrategyResponseHttpMessage.eln;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (alaGetVerifyStrategyResponseHttpMessage.ell != 1 || alaGetVerifyStrategyResponseHttpMessage.elj != 1) {
                        c.this.elV = alaGetVerifyStrategyResponseHttpMessage;
                        if (TbadkCoreApplication.getInst().isQuanmin()) {
                            if (alaGetVerifyStrategyResponseHttpMessage.ell != 1 || alaGetVerifyStrategyResponseHttpMessage.elj != 1) {
                                c.this.elF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.aUX();
                                    }
                                }, 200L);
                                return;
                            }
                            return;
                        } else if (!TbadkCoreApplication.getInst().isTieba()) {
                            c.this.elF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.aUZ();
                                }
                            }, 200L);
                            return;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.ell != 1) {
                            c.this.elF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.tS(c.this.elR);
                                }
                            }, 200L);
                            return;
                        } else if (alaGetVerifyStrategyResponseHttpMessage.elj != 1) {
                            c.this.elF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.aUX();
                                }
                            }, 200L);
                            return;
                        } else {
                            return;
                        }
                    }
                    c.this.elV = null;
                }
            }
        };
        this.emb = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.m.c.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if (masterIdentityResponseMessage.aUI() == 1 || masterIdentityResponseMessage.aUJ() == 1) {
                        c.this.elH.a(13, masterIdentityResponseMessage.aUK(), (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.emc = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.m.c.22
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.emd = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.m.c.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.elO = false;
                }
            }
        };
        this.eme = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.m.c.24
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        c.this.aaB = ((AlaEnterLiveHttpResonseMessage) responsedMessage).uj();
                        if (c.this.elH != null) {
                            c.this.elH.d(c.this.aaB);
                        }
                    }
                    if (c.this.aaB != null && c.this.aaB.mLiveInfo != null) {
                        com.baidu.tieba.ala.liveroom.task.c.aWd().cm(c.this.aaB.mLiveInfo.live_id);
                        LiveTimerManager.getInstance().start(c.this.aaB.mLiveInfo.live_id);
                    }
                    if (c.this.aaB != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.aaB.PN != null) {
                            if (c.this.aaB.PN.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.aaB.PN.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aaB.PN.nickName);
                            if (!TextUtils.isEmpty(c.this.aaB.PN.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.aaB.PN.portrait);
                            }
                        }
                        if (c.this.aaB.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.aaB.mLiveSdkInfo.tbs);
                            com.baidu.live.c.np().putString("ala_account_user_tbs", c.this.aaB.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.aaB != null) {
                        if (c.this.elK.size() <= 0) {
                            c.this.elK.add(c.this.aaB.mLiveInfo);
                            c.this.elX.add(Long.valueOf(c.this.aaB.mLiveInfo.getLiveID()));
                        }
                        c.this.d(c.this.aaB.mLiveInfo);
                        c.this.elH.B(c.this.aaB.PP);
                    }
                    if (c.this.aaB != null && c.this.aaB.Pu != null) {
                        c.this.elS = c.this.aaB.Pu.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.aaB);
                    if (c.this.aaB != null && c.this.aaB.mLiveInfo != null) {
                        c.this.Q(String.valueOf(c.this.aaB.mLiveInfo.getGroupID()), String.valueOf(c.this.aaB.mLiveInfo.getLastMsgID()), String.valueOf(c.this.aaB.mLiveInfo.getUserID()));
                    }
                    if (c.this.aaB != null) {
                        c.this.aaB.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aaB));
                        k.sM().E(c.this.aaB.PP);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.aaB != null && c.this.aaB.mLiveInfo != null) {
                            long j2 = c.this.aaB.mLiveInfo.live_id;
                            long j3 = c.this.aaB.mLiveInfo.room_id;
                            String str = c.this.aaB.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.aaB.Ps != null) {
                                long j4 = c.this.aaB.Ps.userId;
                                str2 = c.this.aaB.Ps.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.aaB != null && c.this.aaB.mLiveInfo != null) {
                        long j5 = c.this.aaB.mLiveInfo.live_id;
                        long j6 = c.this.aaB.mLiveInfo.room_id;
                        String str3 = c.this.aaB.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.aaB.Ps != null) {
                            j = c.this.aaB.Ps.userId;
                            str4 = c.this.aaB.Ps.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.elN + "");
                    }
                }
            }
        };
        this.emf = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.m.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    e eVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        eVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).aKy();
                    }
                    if (eVar != null) {
                        c.this.dGf = eVar;
                    }
                    if (c.this.aaB != null && c.this.aaB.Pu != null) {
                        if (c.this.elS == -1) {
                            c.this.elS = c.this.aaB.Pu.follow_status;
                        }
                        if (c.this.aaB.Pu.follow_status != c.this.elS) {
                            c.this.aaB.Pu.follow_status = c.this.elS;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.dGf);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.dGf));
                }
            }
        };
        this.emg = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.m.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> aUH = alaUserLiveMarkInfoResponseMessage.aUH();
                        c.this.elH.B(aUH);
                        if (c.this.aaB != null) {
                            c.this.aaB.PP = aUH;
                            k.sM().E(c.this.aaB.PP);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.aaB));
                        }
                    }
                }
            }
        };
        this.emh = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.m.c.4
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                        }
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    i uj = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).uj() : null;
                    if (uj == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, uj);
                        return;
                    }
                    if (c.this.aaB == null) {
                        c.this.aaB = uj;
                        if (c.this.elH != null) {
                            c.this.elH.d(c.this.aaB);
                        }
                    }
                    if (c.this.aaB.mLiveInfo != null && uj.mLiveInfo != null && c.this.aaB.mLiveInfo.user_id == uj.mLiveInfo.user_id) {
                        if (c.this.aaB.mLiveInfo.imEffect != null && uj.mLiveInfo.imEffect == null) {
                            uj.mLiveInfo.imEffect = c.this.aaB.mLiveInfo.imEffect;
                        }
                        if (c.this.aaB.mLiveInfo.mLiveCloseData != null && uj.mLiveInfo.mLiveCloseData == null) {
                            uj.mLiveInfo.mLiveCloseData = c.this.aaB.mLiveInfo.mLiveCloseData;
                        }
                    }
                    c.this.aaB.mLiveInfo = uj.mLiveInfo;
                    c.this.aaB.Ps = uj.Ps;
                    c.this.aaB.Pt = uj.Pt;
                    c.this.aaB.Pw = uj.Pw;
                    c.this.aaB.PQ = uj.PQ;
                    c.this.aaB.PO = uj.PO;
                    if (uj.PU != null) {
                        c.this.aaB.PU = uj.PU;
                    }
                    if (uj.PN != null && uj.PN.userId != 0) {
                        boolean z = uj.PN.isNewUser;
                        if (c.this.aaB.PN != null) {
                            z = c.this.aaB.PN.isNewUser;
                        }
                        uj.PN.isNewUser = z;
                        c.this.aaB.PN = uj.PN;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aaB.PN.nickName);
                    }
                    if (uj.PO) {
                        c.this.aaB.PP = uj.PP;
                        c.this.elH.B(uj.PP);
                    }
                    if (!c.this.mIsHost) {
                        c.this.elH.cF(String.valueOf(c.this.aaB.mLiveInfo.backstage_type));
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.aaB);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.aaB));
                    if (c.this.aaB != null) {
                        k.sM().E(c.this.aaB.PP);
                    }
                }
            }
        };
        this.emi = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.m.c.5
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
                    if (list != null && list.size() > 0 && c.this.elK != null && c.this.elK.size() > 0) {
                        for (int size = c.this.elK.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.elK.get(size)).live_id != c.this.aaB.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.elK.get(size)).getLiveID()))) {
                                c.this.elK.remove(size);
                            }
                        }
                    }
                    if (c.this.aaB != null) {
                        c.this.d(c.this.aaB.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.dUC = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.m.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.emj = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.m.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (!httpResponsedMessage.hasError() || BdNetTypeUtil.isNetWorkAvailable()) {
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.elG = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.elJ = alaUpdateLiveTbResponseMessage.aUG();
                    if (c.this.elJ != null) {
                        if (c.this.elJ.egc != 1 || c.this.elJ.ege != 1) {
                            c.this.elF.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.aUY();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.elJ.Ps != null) {
                            c.this.elH.B(c.this.elJ.Ps.live_mark_info_new);
                        }
                        if (c.this.elJ.mErrorCode != 0) {
                            if (c.this.elJ.mErrorCode == 220012) {
                                c.this.b(c.this.elJ.mErrorCode, c.this.elJ.mErrorMsg, 6, c.this.aaB);
                                return;
                            }
                        } else {
                            c.this.aaB = new i();
                            if (c.this.elH != null) {
                                c.this.elH.d(c.this.aaB);
                            }
                            c.this.aaB.mLiveInfo = c.this.elJ.mLiveInfo;
                            c.this.aaB.Ps = c.this.elJ.Ps;
                            c.this.aaB.mLiveSdkInfo = c.this.elJ.mLiveSdkInfo;
                            c.this.aaB.PR = c.this.elJ.PR;
                            c.this.aaB.PP = c.this.elJ.Ps.live_mark_info_new;
                            if (c.this.elJ.Ps != null && c.this.elJ.Ps.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.elJ.Ps.levelId);
                            }
                            c.this.aaB.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aaB));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.aaB);
                    if (c.this.elJ != null && c.this.elJ.mLiveInfo != null) {
                        c.this.Q(String.valueOf(c.this.elJ.mLiveInfo.getGroupID()), String.valueOf(c.this.elJ.mLiveInfo.getLastMsgID()), String.valueOf(c.this.elJ.mLiveInfo.getUserID()));
                    }
                    if (c.this.aaB != null && c.this.aaB.mLiveInfo != null) {
                        c.this.r(c.this.aaB.mLiveInfo.user_id, c.this.aaB.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.emk = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.m.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                com.baidu.live.data.g gVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        gVar = null;
                    } else {
                        gVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).aUE();
                    }
                    if (gVar != null && !ListUtils.isEmpty(gVar.Py)) {
                        c.this.elL = gVar.pn + 1;
                        f fVar = gVar.Py.get(gVar.Py.size() - 1);
                        if (fVar != null) {
                            c.this.elM = fVar.mLiveInfo.live_id;
                        }
                        c.this.a(gVar);
                        if (c.this.aaB != null) {
                            c.this.d(c.this.aaB.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, gVar);
                    }
                }
            }
        };
        this.eml = new com.baidu.live.liveroom.b.a() { // from class: com.baidu.tieba.ala.liveroom.m.c.17
        };
        this.mPageContext = bdPageContext;
        this.elH = new d(bdPageContext, false, this);
        this.elK = new ArrayList();
        this.elX = new HashSet();
        initTasks();
        registerListener(this.emh);
        registerListener(this.emf);
        registerListener(this.eme);
        registerListener(this.emc);
        this.elE = BdUniqueId.gen();
        this.emk.setTag(this.elE);
        registerListener(this.emk);
        registerListener(this.emi);
        registerListener(this.emd);
        registerListener(this.emj);
        registerListener(this.dUC);
        registerListener(this.ema);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.elZ);
        }
        registerListener(this.elY);
        registerListener(this.dFe);
        registerListener(this.emg);
        registerListener(this.emb);
        MessageManager.getInstance().addMessageRule(this.elU);
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
        aUN();
        aUO();
        aUP();
        aUQ();
        aUT();
    }

    private void aUN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void aUO() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void aUP() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void aUQ() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void aUR() {
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

    public void aUS() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void aUT() {
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

    public void aUU() {
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

    public void aUV() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
    }

    public void aUW() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void tS(final String str) {
        if (this.elW != null) {
            this.elW.dismiss();
            this.elW = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.elW = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.elW.setAutoNight(false);
        this.elW.setMessage(string);
        if (TbadkCoreApplication.getInst().isTieba()) {
            this.elW.setPositiveButton(this.mPageContext.getString(a.i.sdk_live_iknow), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.8
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.aAm();
                }
            });
        } else {
            this.elW.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.9
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (!TbadkCoreApplication.getInst().isQuanmin()) {
                        BrowserHelper.startInternalWebActivity(c.this.mPageContext.getPageActivity(), str);
                    } else {
                        c.this.aUW();
                    }
                    c.this.aAm();
                }
            });
            this.elW.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.10
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.aAm();
                }
            });
        }
        this.elW.setCancelable(false);
        this.elW.setCanceledOnTouchOutside(false);
        this.elW.setTitleShowCenter(true);
        this.elW.setMessageShowCenter(true);
        this.elW.isShowTitleAndMessage();
        this.elW.create(this.mPageContext);
        this.elW.show();
    }

    public void aUX() {
        if (this.elW != null) {
            this.elW.dismiss();
            this.elW = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.elW = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.elW.setAutoNight(false);
        this.elW.setMessage(string);
        this.elW.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (TbadkCoreApplication.getInst().isTieba()) {
                    String str = com.baidu.live.l.a.uA().ajX.Sc;
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
                c.this.aAm();
            }
        });
        this.elW.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.aAm();
            }
        });
        this.elW.setCancelable(false);
        this.elW.setCanceledOnTouchOutside(false);
        this.elW.setTitleShowCenter(true);
        this.elW.setMessageShowCenter(true);
        this.elW.isShowTitleAndMessage();
        this.elW.create(this.mPageContext);
        this.elW.show();
    }

    public void aUY() {
        if (this.elW != null) {
            this.elW.dismiss();
            this.elW = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.elW = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.elW.setAutoNight(false);
        this.elW.setMessage(string);
        this.elW.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.14
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.elW.setCancelable(false);
        this.elW.setCanceledOnTouchOutside(false);
        this.elW.isShowTitleAndMessage();
        this.elW.create(this.mPageContext);
        this.elW.show();
    }

    public void aUZ() {
        if (this.elW != null) {
            this.elW.dismiss();
            this.elW = null;
        }
        if (this.elV != null) {
            a(this.elV);
        }
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.elW = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.elW.setAutoNight(false);
        this.elW.setMessage(string);
        this.elW.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.15
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.elW.setCancelable(false);
        this.elW.setCanceledOnTouchOutside(false);
        this.elW.isShowTitleAndMessage();
        this.elW.create(this.mPageContext);
        this.elW.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.elV = null;
        this.elW = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAm() {
        if (this.elW != null) {
            this.elW.dismiss();
            this.elW = null;
        }
        this.elV = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.eji != null) {
            this.eji.a(i, str, i2, obj);
        }
    }

    public void ck(long j) {
        com.baidu.tieba.ala.liveroom.messages.b bVar = new com.baidu.tieba.ala.liveroom.messages.b();
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.a aVar = new com.baidu.live.message.a();
        aVar.setLiveId(j);
        aVar.setFrom(str);
        aVar.C(j2);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void aVa() {
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

    public void nU(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void s(long j, long j2) {
        com.baidu.live.message.a aVar = new com.baidu.live.message.a();
        aVar.setLiveId(j);
        aVar.C(j2);
        aVar.setParams();
        sendMessage(aVar);
    }

    public g aVb() {
        return this.elJ;
    }

    public i uj() {
        return this.aaB;
    }

    public List<AlaLiveInfoData> aVc() {
        return this.elK;
    }

    public e aKy() {
        return this.dGf;
    }

    public void bG(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aaB != null && this.aaB.mLiveInfo != null) {
                aVar.setAudienceCount(this.aaB.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void aVd() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.elK) {
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
                if (this.elK.size() == 1 && this.elK.get(0).live_id == this.aaB.mLiveInfo.live_id) {
                    if (c(gVar) != null) {
                        this.elK.clear();
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
        for (f fVar : gVar.Py) {
            if (fVar != null && fVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.elK) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == fVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.elK.add(fVar.mLiveInfo);
                }
            }
        }
        if (this.elK.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.elK.size() - 200; size < this.elK.size(); size++) {
                arrayList.add(this.elK.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.elK.clear();
                this.elK.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(com.baidu.live.data.g gVar) {
        if (ListUtils.isEmpty(gVar.Py)) {
            return null;
        }
        for (f fVar : gVar.Py) {
            if (fVar != null && fVar.mLiveInfo != null && fVar.mLiveInfo.live_id == this.aaB.mLiveInfo.live_id) {
                return fVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> aVe() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.elK)) {
            return null;
        }
        if (this.elX.isEmpty()) {
            arrayList.addAll(this.elK);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.elK.size()) {
                    break;
                }
                if ((this.aaB == null || this.aaB.mLiveInfo == null || this.aaB.mLiveInfo.live_id != this.elK.get(i2).live_id) && !this.elX.contains(Long.valueOf(this.elK.get(i2).live_id))) {
                    arrayList.add(this.elK.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void c(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.elX.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.elX.size() >= this.elK.size() - 4) {
                ie(false);
            }
        }
    }

    public void nV(int i) {
        this.elT = i;
    }

    public int aVf() {
        return this.elT;
    }

    public void ie(boolean z) {
        if (com.baidu.live.liveroom.b.d.ud().ub()) {
            if (1 != this.elT) {
                m23if(z);
                return;
            } else {
                com.baidu.live.liveroom.b.d.ud().uf().a("tieba", this.elL, 20, this.eml);
                return;
            }
        }
        m23if(z);
    }

    /* renamed from: if  reason: not valid java name */
    private void m23if(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.elL);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.elM);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.elE);
            sendMessage(httpMessage);
        }
    }

    public void cq(String str, String str2) {
        this.elH.sj();
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

    public void cl(long j) {
        this.elH.sj();
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
        if (!aVg()) {
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

    private boolean aVg() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void aVh() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aaB == null) {
            this.aaB = new i(alaLiveInfoCoreData);
            if (this.elH != null) {
                this.elH.d(this.aaB);
            }
        }
        this.elM = this.aaB.mLiveInfo.live_id;
    }

    public void h(String str, boolean z, boolean z2) {
        HttpMessage httpMessage = new HttpMessage(1021040);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("is_cancel", z ? 1 : 0);
        httpMessage.addParam("is_success", z2 ? 1 : 0);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void e(AlaLivePersonData alaLivePersonData) {
        if (this.aaB == null) {
            this.aaB = new i();
            if (this.elH != null) {
                this.elH.d(this.aaB);
            }
        }
        this.aaB.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aaB.Ps = alaLivePersonData.mUserData;
        this.aaB.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aaB.Ps != null) {
            this.elH.B(this.aaB.Ps.live_mark_info_new);
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
        this.elF.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.emk);
        MessageManager.getInstance().removeMessageRule(this.elU);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        this.elH.sj();
        this.elI = null;
        this.mPageContext = null;
    }

    public void nW(int i) {
        this.elN = i;
        if (this.elK.size() == 0) {
            this.elN = 0;
        } else if (this.elN < 0) {
            this.elN = this.elK.size() + this.elN;
        } else {
            this.elN %= this.elK.size();
        }
    }

    public void d(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.elK.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.elK.size()) {
                    if (this.elK.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.elN = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean aVi() {
        long j;
        if (this.elK.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.elK.get(0);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.aaB.mLiveInfo.live_id;
        }
        return true;
    }

    public boolean aVj() {
        long j;
        if (this.elK.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.elK.get(this.elK.size() - 1);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.aaB.mLiveInfo.live_id;
        }
        return true;
    }

    public int aVk() {
        return this.elN;
    }

    public int aVl() {
        return this.elP;
    }

    public boolean aVm() {
        return this.elQ == 1;
    }

    public AlaLiveInfoData aVn() {
        if (this.elN >= this.elK.size()) {
            this.elN = this.elK.size() - 1;
        }
        if (this.elN < 0) {
            this.elN = 0;
        }
        if (this.elK.size() <= this.elN) {
            if (this.aaB != null) {
                return this.aaB.mLiveInfo;
            }
            return null;
        }
        return this.elK.get(this.elN);
    }

    public void a(a aVar) {
        this.eji = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.elI != null) {
            this.elI.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void f(com.baidu.live.im.data.a aVar) {
        if (this.aaB != null && this.aaB.mLiveInfo.live_type == 1) {
            s(aVar);
        }
        if (this.elI != null) {
            this.elI.f(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void s(com.baidu.live.im.data.a aVar) {
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
    public void sl() {
        if (this.elI != null) {
            this.elI.sl();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aaB != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aaB.Ps;
            } else {
                alaLiveUserInfoData = this.aaB.PN;
            }
            if (alaLiveUserInfoData != null) {
                this.elH.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, this.aaB.mLiveInfo.imEffect);
            }
        }
    }

    public void Q(String str, String str2, String str3) {
        this.elH.e(String.valueOf(this.aaB.mLiveInfo.getGroupID()), String.valueOf(this.aaB.mLiveInfo.getLastMsgID()), String.valueOf(this.aaB.mLiveInfo.getUserID()), String.valueOf(this.aaB.mLiveInfo.getLiveID()), this.aaB.mLiveInfo.appId);
    }

    public d aVo() {
        return this.elH;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
