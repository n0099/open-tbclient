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
import com.baidu.live.data.g;
import com.baidu.live.data.h;
import com.baidu.live.data.i;
import com.baidu.live.data.k;
import com.baidu.live.im.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.message.AlaUserAuthenVerifyInfoResponseMessage;
import com.baidu.live.q.a;
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
    private k aio;
    private HttpMessageListener eJq;
    private a eYC;
    private CustomMessageListener eqb;
    private g ers;
    private HttpMessageListener fbA;
    private HttpMessageListener fbB;
    private NetMessageListener fbC;
    private HttpMessageListener fbD;
    private NetMessageListener fbE;
    private HttpMessageListener fbF;
    private HttpMessageListener fbG;
    private NetMessageListener fbH;
    private NetMessageListener fbI;
    private HttpMessageListener fbJ;
    private CustomMessageListener fbK;
    private HttpMessageListener fbL;
    private com.baidu.live.liveroom.b.a fbM;
    private BdUniqueId fbe;
    private Handler fbf;
    private HttpMessage fbg;
    private d fbh;
    private d.a fbi;
    private com.baidu.tieba.ala.liveroom.data.g fbj;
    private List<AlaLiveInfoData> fbk;
    private int fbl;
    private long fbm;
    private int fbn;
    private boolean fbo;
    private int fbp;
    private int fbq;
    private String fbr;
    private int fbs;
    private int fbt;
    private com.baidu.live.p.a fbu;
    private AlaGetVerifyStrategyResponseHttpMessage fbv;
    private BdAlertDialog fbw;
    private Set<Long> fbx;
    private HttpMessageListener fby;
    private CustomMessageListener fbz;
    private boolean mIsHost;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.fbf = new Handler();
        this.fbl = 0;
        this.fbn = 0;
        this.fbo = true;
        this.fbp = 1;
        this.fbq = 0;
        this.fbs = -1;
        this.fbt = 0;
        this.fbu = new com.baidu.live.p.a(0);
        this.otherParams = "";
        this.eqb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.aio != null && c.this.aio.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.aio.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.fbs = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.aio.mLiveInfo.user_id).param("obj_param1", c.this.aio.mLiveInfo.live_id).param("tid", c.this.aio.mLiveInfo.thread_id));
                            c.this.fbs = 1;
                        }
                        if (c.this.aio != null && c.this.aio.VR != null) {
                            c.this.aio.VR.follow_status = c.this.fbs;
                        }
                    }
                }
            }
        };
        this.fby = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.m.c.18
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.arG == 1 && alaUserAuthenVerifyInfoResponseMessage.arF != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.arF.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.arF.verify_video_status == 1) {
                            c.this.fbp = 4;
                        }
                    }
                }
            }
        };
        this.fbz = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.m.c.19
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    try {
                        JSONObject optJSONObject = new JSONObject((String) customResponsedMessage.getData()).optJSONObject("result").optJSONObject("zbwhitelistapi").optJSONObject("data");
                        boolean optBoolean = optJSONObject.optBoolean("inwhite");
                        int optInt = optJSONObject.optInt("is_verified");
                        c.this.fbr = optJSONObject.optString("cmd");
                        if (optInt != 1) {
                            c.this.fbf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.19.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bmM();
                                }
                            }, 200L);
                        } else if (!optBoolean) {
                            c.this.fbf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.19.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bmN();
                                }
                            }, 200L);
                        } else {
                            c.this.bmK();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.fbA = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.m.c.20
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
                    c.this.fbq = alaGetVerifyStrategyResponseHttpMessage.faL;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.faJ == 1 && alaGetVerifyStrategyResponseHttpMessage.faH == 1) {
                            c.this.fbv = null;
                            return;
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan()) && alaGetVerifyStrategyResponseHttpMessage.faJ == 1 && alaGetVerifyStrategyResponseHttpMessage.faH == 1 && alaGetVerifyStrategyResponseHttpMessage.faM == 1) {
                        c.this.fbv = null;
                        return;
                    }
                    c.this.fbv = alaGetVerifyStrategyResponseHttpMessage;
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.faJ != 1 || alaGetVerifyStrategyResponseHttpMessage.faH != 1) {
                            c.this.fbf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bmN();
                                }
                            }, 200L);
                        }
                    } else if (!TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isHaokan()) {
                        c.this.fbf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.5
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bmP();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.faM != 1) {
                        c.this.fbf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.3
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bmM();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.faJ != 1 || alaGetVerifyStrategyResponseHttpMessage.faH != 1) {
                        c.this.fbf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.20.4
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bmN();
                            }
                        }, 200L);
                    }
                }
            }
        };
        this.fbB = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.m.c.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if (masterIdentityResponseMessage.bmx() == 1 || masterIdentityResponseMessage.bmy() == 1) {
                        c.this.fbh.a(13, masterIdentityResponseMessage.bmz(), (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.fbC = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.m.c.22
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.fbD = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.m.c.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.fbo = false;
                }
            }
        };
        this.fbE = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.m.c.24
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        c.this.aio = ((AlaEnterLiveHttpResonseMessage) responsedMessage).wf();
                        if (c.this.fbh != null) {
                            c.this.fbh.d(c.this.aio);
                        }
                    }
                    if (c.this.aio != null && c.this.aio.mLiveInfo != null) {
                        com.baidu.tieba.ala.liveroom.task.c.bnQ().cR(c.this.aio.mLiveInfo.live_id);
                        LiveTimerManager.getInstance().start(c.this.aio.mLiveInfo.live_id);
                    }
                    if (c.this.aio != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.aio.Wc != null) {
                            if (c.this.aio.Wc.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.aio.Wc.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aio.Wc.nickName);
                            if (!TextUtils.isEmpty(c.this.aio.Wc.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.aio.Wc.portrait);
                            }
                        }
                        if (c.this.aio.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.aio.mLiveSdkInfo.tbs);
                            com.baidu.live.c.oI().putString("ala_account_user_tbs", c.this.aio.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.aio != null) {
                        if (c.this.fbk.size() <= 0) {
                            c.this.fbk.add(c.this.aio.mLiveInfo);
                            c.this.fbx.add(Long.valueOf(c.this.aio.mLiveInfo.getLiveID()));
                        }
                        c.this.d(c.this.aio.mLiveInfo);
                        c.this.fbh.A(c.this.aio.Wg);
                    }
                    if (c.this.aio != null && c.this.aio.VR != null) {
                        c.this.fbs = c.this.aio.VR.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.aio);
                    if (c.this.aio != null && c.this.aio.mLiveInfo != null) {
                        c.this.ab(String.valueOf(c.this.aio.mLiveInfo.getGroupID()), String.valueOf(c.this.aio.mLiveInfo.getLastMsgID()), String.valueOf(c.this.aio.mLiveInfo.getUserID()));
                    }
                    if (c.this.aio != null) {
                        c.this.aio.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aio));
                        com.baidu.live.im.k.uF().D(c.this.aio.Wg);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.aio != null && c.this.aio.mLiveInfo != null) {
                            long j2 = c.this.aio.mLiveInfo.live_id;
                            long j3 = c.this.aio.mLiveInfo.room_id;
                            String str = c.this.aio.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.aio.VP != null) {
                                long j4 = c.this.aio.VP.userId;
                                str2 = c.this.aio.VP.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.aio != null && c.this.aio.mLiveInfo != null) {
                        long j5 = c.this.aio.mLiveInfo.live_id;
                        long j6 = c.this.aio.mLiveInfo.room_id;
                        String str3 = c.this.aio.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.aio.VP != null) {
                            j = c.this.aio.VP.userId;
                            str4 = c.this.aio.VP.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.fbn + "");
                    }
                }
            }
        };
        this.fbF = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.m.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    g gVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        gVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bbm();
                    }
                    if (gVar != null) {
                        c.this.ers = gVar;
                    }
                    if (c.this.aio != null && c.this.aio.VR != null) {
                        if (c.this.fbs == -1) {
                            c.this.fbs = c.this.aio.VR.follow_status;
                        }
                        if (c.this.aio.VR.follow_status != c.this.fbs) {
                            c.this.aio.VR.follow_status = c.this.fbs;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.ers);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.ers));
                }
            }
        };
        this.fbG = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.m.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> bmw = alaUserLiveMarkInfoResponseMessage.bmw();
                        c.this.fbh.A(bmw);
                        if (c.this.aio != null) {
                            c.this.aio.Wg = bmw;
                            com.baidu.live.im.k.uF().D(c.this.aio.Wg);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.aio));
                        }
                    }
                }
            }
        };
        this.fbH = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.m.c.4
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        if (BdNetTypeUtil.isNetWorkAvailable()) {
                        }
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    k wf = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).wf() : null;
                    if (wf == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, wf);
                        return;
                    }
                    if (c.this.aio == null) {
                        c.this.aio = wf;
                        if (c.this.fbh != null) {
                            c.this.fbh.d(c.this.aio);
                        }
                    }
                    if (c.this.aio.mLiveInfo != null && wf.mLiveInfo != null && c.this.aio.mLiveInfo.user_id == wf.mLiveInfo.user_id) {
                        if (c.this.aio.mLiveInfo.imEffect != null && wf.mLiveInfo.imEffect == null) {
                            wf.mLiveInfo.imEffect = c.this.aio.mLiveInfo.imEffect;
                        }
                        if (c.this.aio.mLiveInfo.mLiveCloseData != null && wf.mLiveInfo.mLiveCloseData == null) {
                            wf.mLiveInfo.mLiveCloseData = c.this.aio.mLiveInfo.mLiveCloseData;
                        }
                        if (c.this.aio.mLiveInfo.mAlaLiveSwitchData != null && wf.mLiveInfo.mAlaLiveSwitchData == null) {
                            wf.mLiveInfo.mAlaLiveSwitchData = c.this.aio.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    c.this.aio.mLiveInfo = wf.mLiveInfo;
                    c.this.aio.VP = wf.VP;
                    c.this.aio.VQ = wf.VQ;
                    c.this.aio.VT = wf.VT;
                    c.this.aio.Wh = wf.Wh;
                    c.this.aio.Wf = wf.Wf;
                    c.this.aio.We = wf.We;
                    if (wf.Wk != null) {
                        c.this.aio.Wk = wf.Wk;
                    }
                    if (wf.Wc != null) {
                        if (wf.Wc.userId == 0) {
                            if (c.this.aio.Wc == null) {
                                c.this.aio.Wc = new AlaLiveUserInfoData();
                            }
                            c.this.aio.Wc.throneUid = wf.Wc.throneUid;
                        } else {
                            boolean z = wf.Wc.isNewUser;
                            if (c.this.aio.Wc != null) {
                                z = c.this.aio.Wc.isNewUser;
                            }
                            wf.Wc.isNewUser = z;
                            c.this.aio.Wc = wf.Wc;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.aio.Wc.nickName);
                        }
                    }
                    if (wf.Wf) {
                        c.this.aio.Wg = wf.Wg;
                        c.this.fbh.A(wf.Wg);
                    }
                    if (!c.this.mIsHost) {
                        c.this.fbh.dx(String.valueOf(c.this.aio.mLiveInfo.backstage_type));
                    }
                    if (c.this.fbh != null) {
                        c.this.fbh.d(c.this.aio);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.aio);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.aio));
                    if (c.this.aio != null) {
                        com.baidu.live.im.k.uF().D(c.this.aio.Wg);
                    }
                }
            }
        };
        this.fbI = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.m.c.5
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
                    if (list != null && list.size() > 0 && c.this.fbk != null && c.this.fbk.size() > 0) {
                        for (int size = c.this.fbk.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.fbk.get(size)).live_id != c.this.aio.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.fbk.get(size)).getLiveID()))) {
                                c.this.fbk.remove(size);
                            }
                        }
                    }
                    if (c.this.aio != null) {
                        c.this.d(c.this.aio.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.eJq = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.m.c.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.fbJ = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.m.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (!httpResponsedMessage.hasError() || BdNetTypeUtil.isNetWorkAvailable()) {
                    }
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.fbg = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.fbj = alaUpdateLiveTbResponseMessage.bmv();
                    if (c.this.fbj != null) {
                        if (c.this.fbj.eVf != 1 || c.this.fbj.eVh != 1) {
                            c.this.fbf.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bmO();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.fbj.VP != null) {
                            c.this.fbh.A(c.this.fbj.VP.live_mark_info_new);
                        }
                        if (c.this.fbj.mErrorCode != 0) {
                            if (c.this.fbj.mErrorCode == 220012) {
                                c.this.b(c.this.fbj.mErrorCode, c.this.fbj.mErrorMsg, 6, c.this.aio);
                                return;
                            }
                        } else {
                            c.this.aio = new k();
                            if (c.this.fbh != null) {
                                c.this.fbh.d(c.this.aio);
                            }
                            c.this.aio.mLiveInfo = c.this.fbj.mLiveInfo;
                            c.this.aio.VP = c.this.fbj.VP;
                            c.this.aio.mLiveSdkInfo = c.this.fbj.mLiveSdkInfo;
                            c.this.aio.Wi = c.this.fbj.Wi;
                            c.this.aio.Wg = c.this.fbj.VP.live_mark_info_new;
                            if (c.this.fbj.VP != null && c.this.fbj.VP.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.fbj.VP.levelId);
                            }
                            c.this.aio.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.aio));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.aio);
                    if (c.this.fbj != null && c.this.fbj.mLiveInfo != null) {
                        c.this.ab(String.valueOf(c.this.fbj.mLiveInfo.getGroupID()), String.valueOf(c.this.fbj.mLiveInfo.getLastMsgID()), String.valueOf(c.this.fbj.mLiveInfo.getUserID()));
                    }
                    if (c.this.aio != null && c.this.aio.mLiveInfo != null) {
                        c.this.w(c.this.aio.mLiveInfo.user_id, c.this.aio.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.fbK = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.m.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.fbh.a(13, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.fbL = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.m.c.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                i iVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        iVar = null;
                    } else {
                        iVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).bmt();
                    }
                    if (iVar != null && !ListUtils.isEmpty(iVar.VV)) {
                        c.this.fbl = iVar.pn + 1;
                        h hVar = iVar.VV.get(iVar.VV.size() - 1);
                        if (hVar != null) {
                            c.this.fbm = hVar.mLiveInfo.live_id;
                        }
                        c.this.a(iVar);
                        if (c.this.aio != null) {
                            c.this.d(c.this.aio.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, iVar);
                    }
                }
            }
        };
        this.fbM = new com.baidu.live.liveroom.b.a() { // from class: com.baidu.tieba.ala.liveroom.m.c.17
        };
        this.mPageContext = bdPageContext;
        this.fbh = new d(bdPageContext, false, this);
        this.fbk = new ArrayList();
        this.fbx = new HashSet();
        initTasks();
        registerListener(this.fbH);
        registerListener(this.fbF);
        registerListener(this.fbE);
        registerListener(this.fbC);
        this.fbe = BdUniqueId.gen();
        this.fbL.setTag(this.fbe);
        registerListener(this.fbL);
        registerListener(this.fbI);
        registerListener(this.fbD);
        registerListener(this.fbJ);
        registerListener(this.eJq);
        registerListener(this.fbA);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.fbz);
        }
        registerListener(this.fby);
        registerListener(this.eqb);
        registerListener(this.fbG);
        registerListener(this.fbB);
        registerListener(this.fbK);
        MessageManager.getInstance().addMessageRule(this.fbu);
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
        bmC();
        bmD();
        bmE();
        bmF();
        bmI();
    }

    private void bmC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bmD() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void bmE() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void bmF() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void bmG() {
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

    public void bmH() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void bmI() {
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

    public void bmJ() {
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

    public void bmK() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
    }

    public void bmL() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bmM() {
        if (this.fbw != null) {
            this.fbw.dismiss();
            this.fbw = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.fbw = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fbw.setAutoNight(false);
        this.fbw.setMessage(string);
        this.fbw.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.bmL();
                c.this.wN();
            }
        });
        this.fbw.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.wN();
            }
        });
        this.fbw.setCancelable(false);
        this.fbw.setCanceledOnTouchOutside(false);
        this.fbw.setTitleShowCenter(true);
        this.fbw.setMessageShowCenter(true);
        this.fbw.isShowTitleAndMessage();
        this.fbw.create(this.mPageContext);
        this.fbw.show();
    }

    public void bmN() {
        if (this.fbw != null) {
            this.fbw.dismiss();
            this.fbw = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.fbw = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fbw.setAutoNight(false);
        this.fbw.setMessage(string);
        this.fbw.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (TbadkCoreApplication.getInst().isTieba()) {
                    String str = com.baidu.live.r.a.wA().arE.Yn;
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
                c.this.wN();
            }
        });
        this.fbw.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.wN();
            }
        });
        this.fbw.setCancelable(false);
        this.fbw.setCanceledOnTouchOutside(false);
        this.fbw.setTitleShowCenter(true);
        this.fbw.setMessageShowCenter(true);
        this.fbw.isShowTitleAndMessage();
        this.fbw.create(this.mPageContext);
        this.fbw.show();
    }

    public void bmO() {
        if (this.fbw != null) {
            this.fbw.dismiss();
            this.fbw = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fbw = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fbw.setAutoNight(false);
        this.fbw.setMessage(string);
        this.fbw.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.14
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fbw.setCancelable(false);
        this.fbw.setCanceledOnTouchOutside(false);
        this.fbw.isShowTitleAndMessage();
        this.fbw.create(this.mPageContext);
        this.fbw.show();
    }

    public void bmP() {
        if (this.fbw != null) {
            this.fbw.dismiss();
            this.fbw = null;
        }
        if (this.fbv != null) {
            a(this.fbv);
        }
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fbw = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fbw.setAutoNight(false);
        this.fbw.setMessage(string);
        this.fbw.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.15
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fbw.setCancelable(false);
        this.fbw.setCanceledOnTouchOutside(false);
        this.fbw.isShowTitleAndMessage();
        this.fbw.create(this.mPageContext);
        this.fbw.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.fbv = null;
        this.fbw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wN() {
        if (this.fbw != null) {
            this.fbw.dismiss();
            this.fbw = null;
        }
        this.fbv = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.eYC != null) {
            this.eYC.a(i, str, i2, obj);
        }
    }

    public void cP(long j) {
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

    public void bmQ() {
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

    public void qk(int i) {
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

    public com.baidu.tieba.ala.liveroom.data.g bmR() {
        return this.fbj;
    }

    public k wf() {
        return this.aio;
    }

    public List<AlaLiveInfoData> bmS() {
        return this.fbk;
    }

    public g bbm() {
        return this.ers;
    }

    public void bF(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.aio != null && this.aio.mLiveInfo != null) {
                aVar.setAudienceCount(this.aio.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bmT() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.fbk) {
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
                if (this.fbk.size() == 1 && this.fbk.get(0).live_id == this.aio.mLiveInfo.live_id) {
                    if (c(iVar) != null) {
                        this.fbk.clear();
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
        for (h hVar : iVar.VV) {
            if (hVar != null && hVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.fbk) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == hVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.fbk.add(hVar.mLiveInfo);
                }
            }
        }
        if (this.fbk.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.fbk.size() - 200; size < this.fbk.size(); size++) {
                arrayList.add(this.fbk.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.fbk.clear();
                this.fbk.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(i iVar) {
        if (ListUtils.isEmpty(iVar.VV)) {
            return null;
        }
        for (h hVar : iVar.VV) {
            if (hVar != null && hVar.mLiveInfo != null && hVar.mLiveInfo.live_id == this.aio.mLiveInfo.live_id) {
                return hVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bmU() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.fbk)) {
            return null;
        }
        if (this.fbx.isEmpty()) {
            arrayList.addAll(this.fbk);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fbk.size()) {
                    break;
                }
                if ((this.aio == null || this.aio.mLiveInfo == null || this.aio.mLiveInfo.live_id != this.fbk.get(i2).live_id) && !this.fbx.contains(Long.valueOf(this.fbk.get(i2).live_id))) {
                    arrayList.add(this.fbk.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void c(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.fbx.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.fbx.size() >= this.fbk.size() - 4) {
                jv(false);
            }
        }
    }

    public void ql(int i) {
        this.fbt = i;
    }

    public int bmV() {
        return this.fbt;
    }

    public void jv(boolean z) {
        if (com.baidu.live.liveroom.b.d.vZ().vX()) {
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && 1 != this.fbt) {
                jw(z);
                return;
            } else {
                com.baidu.live.liveroom.b.d.vZ().wb().a("tieba", this.fbl, 20, this.fbM);
                return;
            }
        }
        jw(z);
    }

    private void jw(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.fbl);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.fbm);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.fbe);
            sendMessage(httpMessage);
        }
    }

    public void cK(String str, String str2) {
        this.fbh.ub();
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
        aVar.sk(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void aa(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.sk(str2);
        aVar.yG(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void yH(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.dC(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void cQ(long j) {
        this.fbh.ub();
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
        if (!bmW()) {
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

    private boolean bmW() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bmX() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.aio == null) {
            this.aio = new k(alaLiveInfoCoreData);
            if (this.fbh != null) {
                this.fbh.d(this.aio);
            }
        }
        this.fbm = this.aio.mLiveInfo.live_id;
    }

    public void h(String str, boolean z, boolean z2) {
        HttpMessage httpMessage = new HttpMessage(1021040);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("is_cancel", z ? 1 : 0);
        httpMessage.addParam("is_success", z2 ? 1 : 0);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void f(AlaLivePersonData alaLivePersonData) {
        if (this.aio == null) {
            this.aio = new k();
            if (this.fbh != null) {
                this.fbh.d(this.aio);
            }
        }
        this.aio.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.aio.VP = alaLivePersonData.mUserData;
        this.aio.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.aio.VP != null) {
            this.fbh.A(this.aio.VP.live_mark_info_new);
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
        this.fbf.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.fbL);
        MessageManager.getInstance().removeMessageRule(this.fbu);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        this.fbh.ub();
        this.fbi = null;
        this.mPageContext = null;
    }

    public void qm(int i) {
        this.fbn = i;
        if (this.fbk.size() == 0) {
            this.fbn = 0;
        } else if (this.fbn < 0) {
            this.fbn = this.fbk.size() + this.fbn;
        } else {
            this.fbn %= this.fbk.size();
        }
    }

    public void d(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.fbk.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fbk.size()) {
                    if (this.fbk.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.fbn = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bmY() {
        long j;
        if (this.fbk.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.fbk.get(0);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.aio.mLiveInfo.live_id;
        }
        return true;
    }

    public boolean bmZ() {
        long j;
        if (this.fbk.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.fbk.get(this.fbk.size() - 1);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.aio.mLiveInfo.live_id;
        }
        return true;
    }

    public int bna() {
        return this.fbn;
    }

    public int bnb() {
        return this.fbp;
    }

    public boolean bnc() {
        return this.fbq == 1;
    }

    public AlaLiveInfoData bnd() {
        if (this.fbn >= this.fbk.size()) {
            this.fbn = this.fbk.size() - 1;
        }
        if (this.fbn < 0) {
            this.fbn = 0;
        }
        if (this.fbk.size() <= this.fbn) {
            if (this.aio != null) {
                return this.aio.mLiveInfo;
            }
            return null;
        }
        return this.fbk.get(this.fbn);
    }

    public void a(a aVar) {
        this.eYC = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void c(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.fbi != null) {
            this.fbi.c(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void g(com.baidu.live.im.data.a aVar) {
        if (this.aio != null && this.aio.mLiveInfo.live_type == 1) {
            t(aVar);
        }
        if (this.fbi != null) {
            this.fbi.g(aVar);
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
            jv(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void ud() {
        if (this.fbi != null) {
            this.fbi.ud();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.aio != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.aio.VP;
            } else {
                alaLiveUserInfoData = this.aio.Wc;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.aio.mLiveInfo.imEffect;
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aio != null && this.aio.Wc != null && this.aio.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.aio.Wc.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr == null || strArr.length != 2) {
                            strArr = new String[2];
                        }
                        strArr[0] = "guard_seat_effect";
                    }
                }
                this.fbh.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr);
            }
        }
    }

    public void ab(String str, String str2, String str3) {
        this.fbh.e(String.valueOf(this.aio.mLiveInfo.getGroupID()), String.valueOf(this.aio.mLiveInfo.getLastMsgID()), String.valueOf(this.aio.mLiveInfo.getUserID()), String.valueOf(this.aio.mLiveInfo.getLiveID()), this.aio.mLiveInfo.appId);
    }

    public d bne() {
        return this.fbh;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
