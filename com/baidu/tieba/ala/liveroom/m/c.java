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
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.h;
import com.baidu.live.data.i;
import com.baidu.live.data.j;
import com.baidu.live.data.m;
import com.baidu.live.im.d;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.k;
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
import com.baidu.live.tbadk.realAuthen.RealAuthenManager;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.u.a;
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
/* loaded from: classes3.dex */
public class c extends BdBaseModel implements d.a {
    private m ald;
    private HttpMessageListener eOz;
    private CustomMessageListener evy;
    private h ewN;
    private a fep;
    private HttpMessageListener fhA;
    private NetMessageListener fhB;
    private HttpMessageListener fhC;
    private NetMessageListener fhD;
    private HttpMessageListener fhE;
    private HttpMessageListener fhF;
    private NetMessageListener fhG;
    private NetMessageListener fhH;
    private HttpMessageListener fhI;
    private CustomMessageListener fhJ;
    private HttpMessageListener fhK;
    private HttpMessageListener fhL;
    private com.baidu.live.liveroom.c.a fhM;
    private BdUniqueId fhc;
    private Handler fhd;
    private HttpMessage fhe;
    private final com.baidu.live.im.d fhf;
    private d.a fhg;
    private com.baidu.tieba.ala.liveroom.data.h fhh;
    private List<AlaLiveInfoData> fhi;
    private int fhj;
    private long fhk;
    private int fhl;
    private boolean fhm;
    private int fhn;
    private int fho;
    private String fhp;
    private int fhq;
    private int fhr;
    private com.baidu.live.t.a fhs;
    private AlaGetVerifyStrategyResponseHttpMessage fht;
    private BdAlertDialog fhu;
    private Set<Long> fhv;
    private long fhw;
    private HttpMessageListener fhx;
    private CustomMessageListener fhy;
    private HttpMessageListener fhz;
    private boolean mIsHost;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.fhd = new Handler();
        this.fhj = 0;
        this.fhl = 0;
        this.fhm = true;
        this.fhn = 1;
        this.fho = 0;
        this.fhq = -1;
        this.fhr = 0;
        this.fhs = new com.baidu.live.t.a(0);
        this.otherParams = "";
        this.evy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.ald != null && c.this.ald.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.ald.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.fhq = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.ald.mLiveInfo.user_id).param("obj_param1", c.this.ald.mLiveInfo.live_id).param("tid", c.this.ald.mLiveInfo.thread_id));
                            c.this.fhq = 1;
                        }
                        if (c.this.ald != null && c.this.ald.XS != null) {
                            c.this.ald.XS.follow_status = c.this.fhq;
                        }
                    }
                }
            }
        };
        this.fhx = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.m.c.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.awC == 1 && alaUserAuthenVerifyInfoResponseMessage.awB != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.awB.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.awB.verify_video_status == 1) {
                            c.this.fhn = 4;
                        }
                    }
                }
            }
        };
        this.fhy = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.m.c.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    try {
                        JSONObject optJSONObject = new JSONObject((String) customResponsedMessage.getData()).optJSONObject("result").optJSONObject("zbwhitelistapi").optJSONObject("data");
                        boolean optBoolean = optJSONObject.optBoolean("inwhite");
                        int optInt = optJSONObject.optInt("is_verified");
                        c.this.fhp = optJSONObject.optString("cmd");
                        if (optInt != 1) {
                            c.this.fhd.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bpx();
                                }
                            }, 200L);
                        } else if (!optBoolean) {
                            c.this.fhd.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.24.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bpy();
                                }
                            }, 200L);
                        } else {
                            c.this.bpv();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.fhz = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.m.c.25
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
                    c.this.fho = alaGetVerifyStrategyResponseHttpMessage.fgJ;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fgH == 1 && alaGetVerifyStrategyResponseHttpMessage.fgF == 1) {
                            c.this.fht = null;
                            return;
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && alaGetVerifyStrategyResponseHttpMessage.fgH == 1 && alaGetVerifyStrategyResponseHttpMessage.fgF == 1 && alaGetVerifyStrategyResponseHttpMessage.fgK == 1) {
                        c.this.fht = null;
                        return;
                    }
                    c.this.fht = alaGetVerifyStrategyResponseHttpMessage;
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fgH != 1 || alaGetVerifyStrategyResponseHttpMessage.fgF != 1) {
                            c.this.fhd.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bpy();
                                }
                            }, 200L);
                        }
                    } else if (!TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isOther()) {
                        c.this.fhd.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.5
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bpA();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.fgK != 1) {
                        c.this.fhd.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.3
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bpx();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.fgH != 1 || alaGetVerifyStrategyResponseHttpMessage.fgF != 1) {
                        c.this.fhd.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.4
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bpy();
                            }
                        }, 200L);
                    }
                }
            }
        };
        this.fhA = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.m.c.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if (masterIdentityResponseMessage.bpg() == 1 || masterIdentityResponseMessage.bph() == 1) {
                        c.this.fhf.a(13, masterIdentityResponseMessage.bpi(), (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.fhB = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.m.c.27
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.fhC = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.m.c.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.fhm = false;
                }
            }
        };
        this.fhD = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.m.c.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        c.this.ald = ((AlaEnterLiveHttpResonseMessage) responsedMessage).yN();
                        c.this.fhf.e(c.this.ald);
                    }
                    if (c.this.ald != null && c.this.ald.mLiveInfo != null && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                        if (!TbadkCoreApplication.getInst().isOther()) {
                            com.baidu.tieba.ala.liveroom.task.c.bqw().cZ(c.this.ald.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(c.this.ald.mLiveInfo.live_id);
                    }
                    if (c.this.ald != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.ald.Ye != null) {
                            if (c.this.ald.Ye.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.ald.Ye.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.ald.Ye.nickName);
                            if (!TextUtils.isEmpty(c.this.ald.Ye.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.ald.Ye.portrait);
                            }
                        }
                        if (c.this.ald.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.ald.mLiveSdkInfo.tbs);
                            com.baidu.live.c.pr().putString("ala_account_user_tbs", c.this.ald.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.ald != null) {
                        if (c.this.fhi.size() <= 0) {
                            c.this.fhi.add(c.this.ald.mLiveInfo);
                            c.this.fhv.add(Long.valueOf(c.this.ald.mLiveInfo.getLiveID()));
                        }
                        c.this.e(c.this.ald.mLiveInfo);
                        if (c.this.fhf != null) {
                            c.this.fhf.z(c.this.ald.Yi);
                        }
                    }
                    if (c.this.ald != null && c.this.ald.XS != null) {
                        c.this.fhq = c.this.ald.XS.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.ald);
                    if (c.this.ald != null && c.this.ald.mLiveInfo != null) {
                        c.this.bpP();
                    }
                    if (c.this.ald != null) {
                        c.this.ald.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.ald));
                        k.wA().C(c.this.ald.Yi);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.ald != null && c.this.ald.mLiveInfo != null) {
                            long j2 = c.this.ald.mLiveInfo.live_id;
                            long j3 = c.this.ald.mLiveInfo.room_id;
                            String str = c.this.ald.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.ald.XQ != null) {
                                long j4 = c.this.ald.XQ.userId;
                                str2 = c.this.ald.XQ.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.ald != null && c.this.ald.mLiveInfo != null) {
                        long j5 = c.this.ald.mLiveInfo.live_id;
                        long j6 = c.this.ald.mLiveInfo.room_id;
                        String str3 = c.this.ald.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.ald.XQ != null) {
                            j = c.this.ald.XQ.userId;
                            str4 = c.this.ald.XQ.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.fhl + "");
                    }
                }
            }
        };
        this.fhE = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.m.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    h hVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        hVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bdW();
                    }
                    if (hVar != null) {
                        c.this.ewN = hVar;
                    }
                    if (c.this.ald != null && c.this.ald.XS != null) {
                        if (c.this.fhq == -1) {
                            c.this.fhq = c.this.ald.XS.follow_status;
                        }
                        if (c.this.ald.XS.follow_status != c.this.fhq) {
                            c.this.ald.XS.follow_status = c.this.fhq;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.ewN);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.ewN));
                }
            }
        };
        this.fhF = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.m.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> bpf = alaUserLiveMarkInfoResponseMessage.bpf();
                        c.this.fhf.z(bpf);
                        if (c.this.ald != null) {
                            c.this.ald.Yi = bpf;
                            k.wA().C(c.this.ald.Yi);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.ald));
                        }
                    }
                }
            }
        };
        this.fhG = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.m.c.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    m yN = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).yN() : null;
                    if (yN == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, yN);
                        return;
                    }
                    if (c.this.ald == null) {
                        c.this.ald = yN;
                        c.this.fhf.e(c.this.ald);
                    }
                    if (c.this.ald.mLiveInfo != null && yN.mLiveInfo != null && c.this.ald.mLiveInfo.user_id == yN.mLiveInfo.user_id) {
                        if (c.this.ald.mLiveInfo.imEffect != null && yN.mLiveInfo.imEffect == null) {
                            yN.mLiveInfo.imEffect = c.this.ald.mLiveInfo.imEffect;
                        }
                        if (c.this.ald.mLiveInfo.mLiveCloseData != null && yN.mLiveInfo.mLiveCloseData == null) {
                            yN.mLiveInfo.mLiveCloseData = c.this.ald.mLiveInfo.mLiveCloseData;
                        }
                        if (c.this.ald.mLiveInfo.mAlaLiveSwitchData != null && yN.mLiveInfo.mAlaLiveSwitchData == null) {
                            yN.mLiveInfo.mAlaLiveSwitchData = c.this.ald.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    c.this.ald.mLiveInfo = yN.mLiveInfo;
                    c.this.ald.XQ = yN.XQ;
                    c.this.ald.XR = yN.XR;
                    c.this.ald.XU = yN.XU;
                    c.this.ald.Yj = yN.Yj;
                    c.this.ald.Yh = yN.Yh;
                    c.this.ald.Yg = yN.Yg;
                    if (yN.Yn != null && yN.Yn.abf != null && !yN.Yn.abf.isEmpty()) {
                        c.this.ald.Yn = yN.Yn;
                    }
                    if (yN.Ye != null) {
                        if (yN.Ye.userId == 0) {
                            if (c.this.ald.Ye == null) {
                                c.this.ald.Ye = new AlaLiveUserInfoData();
                            }
                            c.this.ald.Ye.throneUid = yN.Ye.throneUid;
                        } else {
                            boolean z = yN.Ye.isNewUser;
                            if (c.this.ald.Ye != null) {
                                z = c.this.ald.Ye.isNewUser;
                            }
                            yN.Ye.isNewUser = z;
                            c.this.ald.Ye = yN.Ye;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.ald.Ye.nickName);
                        }
                    }
                    if (yN.Yh) {
                        c.this.ald.Yi = yN.Yi;
                        if (c.this.fhf != null) {
                            c.this.fhf.z(yN.Yi);
                        }
                    }
                    if (!c.this.mIsHost && c.this.ald.mLiveInfo != null) {
                        int i = c.this.ald.mLiveInfo.backstage_type;
                        if (c.this.fhf != null) {
                            c.this.fhf.dK(String.valueOf(i));
                        }
                    }
                    if (c.this.fhf != null) {
                        c.this.fhf.e(c.this.ald);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.ald);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.ald));
                    if (c.this.ald != null) {
                        k.wA().C(c.this.ald.Yi);
                    }
                }
            }
        };
        this.fhH = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.m.c.6
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
                    if (list != null && list.size() > 0 && c.this.fhi != null && c.this.fhi.size() > 0) {
                        for (int size = c.this.fhi.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.fhi.get(size)).live_id != c.this.ald.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.fhi.get(size)).getLiveID()))) {
                                c.this.fhi.remove(size);
                            }
                        }
                    }
                    if (c.this.ald != null) {
                        c.this.e(c.this.ald.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.eOz = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.m.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.fhI = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.m.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.fhe = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.fhh = alaUpdateLiveTbResponseMessage.bpe();
                    if (c.this.fhh != null) {
                        if (c.this.fhh.faR != 1 || c.this.fhh.faT != 1) {
                            c.this.fhd.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bpz();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.fhh.XQ != null) {
                            c.this.fhf.z(c.this.fhh.XQ.live_mark_info_new);
                        }
                        if (c.this.fhh.mErrorCode != 0) {
                            if (c.this.fhh.mErrorCode == 220012) {
                                c.this.b(c.this.fhh.mErrorCode, c.this.fhh.mErrorMsg, 6, c.this.ald);
                                return;
                            }
                        } else {
                            c.this.ald = new m();
                            c.this.fhf.e(c.this.ald);
                            c.this.ald.mLiveInfo = c.this.fhh.mLiveInfo;
                            c.this.ald.XQ = c.this.fhh.XQ;
                            c.this.ald.mLiveSdkInfo = c.this.fhh.mLiveSdkInfo;
                            c.this.ald.Yk = c.this.fhh.Yk;
                            c.this.ald.Yi = c.this.fhh.XQ.live_mark_info_new;
                            if (c.this.fhh.XQ != null && c.this.fhh.XQ.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.fhh.XQ.levelId);
                            }
                            c.this.ald.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.ald));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.ald);
                    if (c.this.fhh != null && c.this.fhh.mLiveInfo != null) {
                        c.this.bpP();
                    }
                    if (c.this.ald != null && c.this.ald.mLiveInfo != null) {
                        c.this.w(c.this.ald.mLiveInfo.user_id, c.this.ald.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.fhJ = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.m.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.fhf.a(13, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.fhK = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.m.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.l.b)) {
                    com.baidu.live.l.b bVar = (com.baidu.live.l.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.axi != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.axi.dS(bVar.contentType);
                        } else {
                            bVar.axi.b(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.fhL = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.m.c.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                j jVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        jVar = null;
                    } else {
                        jVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).bpc();
                    }
                    if (jVar != null && !ListUtils.isEmpty(jVar.XW)) {
                        c.this.fhj = jVar.pn + 1;
                        i iVar = jVar.XW.get(jVar.XW.size() - 1);
                        if (iVar != null) {
                            c.this.fhk = iVar.mLiveInfo.live_id;
                        }
                        c.this.a(jVar);
                        if (c.this.ald != null) {
                            c.this.e(c.this.ald.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, jVar);
                    }
                }
            }
        };
        this.fhM = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.m.c.21
        };
        this.mPageContext = bdPageContext;
        this.fhf = new com.baidu.live.im.d(bdPageContext, false, this);
        this.fhi = new ArrayList();
        this.fhv = new HashSet();
        initTasks();
        registerListener(this.fhG);
        registerListener(this.fhE);
        registerListener(this.fhD);
        registerListener(this.fhB);
        this.fhc = BdUniqueId.gen();
        this.fhL.setTag(this.fhc);
        registerListener(this.fhL);
        registerListener(this.fhH);
        registerListener(this.fhC);
        registerListener(this.fhI);
        registerListener(this.eOz);
        registerListener(this.fhz);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.fhy);
        }
        registerListener(this.fhx);
        registerListener(this.evy);
        registerListener(this.fhF);
        registerListener(this.fhA);
        registerListener(this.fhJ);
        registerListener(this.fhK);
        MessageManager.getInstance().addMessageRule(this.fhs);
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
        bpl();
        bpm();
        bpn();
        bpo();
        bpr();
    }

    private void bpl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bpm() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void bpn() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void bpo() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void bpp() {
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

    public void bpq() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void bpr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bps() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.22
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.l.b) && c.this.ald != null && c.this.ald.mLiveInfo != null) {
                    com.baidu.live.l.b bVar = (com.baidu.live.l.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", c.this.ald.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.axh != null) {
                        httpMessage.addParam("ext_data", bVar.axh.toString());
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

    public void bpt() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void w(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bpu() {
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

    public void bpv() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
    }

    public void bpw() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bpx() {
        if (this.fhu != null) {
            this.fhu.dismiss();
            this.fhu = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.fhu = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fhu.setAutoNight(false);
        this.fhu.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.fhu.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.11
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.bpw();
                    c.this.sN();
                }
            });
            this.fhu.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.sN();
                }
            });
        } else {
            this.fhu.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.sN();
                }
            });
        }
        this.fhu.setCancelable(false);
        this.fhu.setCanceledOnTouchOutside(false);
        this.fhu.setTitleShowCenter(true);
        this.fhu.setMessageShowCenter(true);
        this.fhu.isShowTitleAndMessage();
        this.fhu.create(this.mPageContext);
        this.fhu.show();
    }

    public void bpy() {
        if (this.fhu != null) {
            this.fhu.dismiss();
            this.fhu = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.fhu = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fhu.setAutoNight(false);
        this.fhu.setMessage(string);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fhu.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.sN();
                }
            });
        } else {
            this.fhu.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str = com.baidu.live.v.a.zj().awA.aar;
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
                    c.this.sN();
                }
            });
            this.fhu.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.sN();
                }
            });
        }
        this.fhu.setCancelable(false);
        this.fhu.setCanceledOnTouchOutside(false);
        this.fhu.setTitleShowCenter(true);
        this.fhu.setMessageShowCenter(true);
        this.fhu.isShowTitleAndMessage();
        this.fhu.create(this.mPageContext);
        this.fhu.show();
    }

    public void bpz() {
        if (this.fhu != null) {
            this.fhu.dismiss();
            this.fhu = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fhu = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fhu.setAutoNight(false);
        this.fhu.setMessage(string);
        this.fhu.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fhu.setCancelable(false);
        this.fhu.setCanceledOnTouchOutside(false);
        this.fhu.isShowTitleAndMessage();
        this.fhu.create(this.mPageContext);
        this.fhu.show();
    }

    public void bpA() {
        if (this.fhu != null) {
            this.fhu.dismiss();
            this.fhu = null;
        }
        if (this.fht != null) {
            a(this.fht);
        }
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fhu = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fhu.setAutoNight(false);
        this.fhu.setMessage(string);
        this.fhu.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fhu.setCancelable(false);
        this.fhu.setCanceledOnTouchOutside(false);
        this.fhu.isShowTitleAndMessage();
        this.fhu.create(this.mPageContext);
        this.fhu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.fht = null;
        this.fhu = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN() {
        if (this.fhu != null) {
            this.fhu.dismiss();
            this.fhu = null;
        }
        this.fht = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.fep != null) {
            this.fep.a(i, str, i2, obj);
        }
    }

    public void cX(long j) {
        com.baidu.tieba.ala.liveroom.messages.b bVar = new com.baidu.tieba.ala.liveroom.messages.b();
        bVar.setLiveId(j);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.setFrom(str);
        bVar.H(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public void bpB() {
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

    public void qw(int i) {
        HttpMessage httpMessage = new HttpMessage(1021123);
        httpMessage.addParam("backstage_type", i);
        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
        sendMessage(httpMessage);
    }

    public void x(long j, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.H(j2);
        bVar.setParams();
        sendMessage(bVar);
    }

    public com.baidu.tieba.ala.liveroom.data.h bpC() {
        return this.fhh;
    }

    public m yN() {
        return this.ald;
    }

    public List<AlaLiveInfoData> bpD() {
        return this.fhi;
    }

    public h bdW() {
        return this.ewN;
    }

    public void bF(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.ald != null && this.ald.mLiveInfo != null) {
                aVar.setAudienceCount(this.ald.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bpE() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.fhi) {
            if (alaLiveInfoData != null) {
                arrayList.add(Long.valueOf(alaLiveInfoData.live_id));
            }
        }
        bF(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        if (jVar != null) {
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isHaokan()) {
                if (this.fhi.size() == 1 && this.fhi.get(0).live_id == this.ald.mLiveInfo.live_id) {
                    if (c(jVar) != null) {
                        this.fhi.clear();
                    }
                    b(jVar);
                    return;
                }
                b(jVar);
                return;
            }
            b(jVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(j jVar) {
        boolean z;
        for (i iVar : jVar.XW) {
            if (iVar != null && iVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.fhi) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == iVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.fhi.add(iVar.mLiveInfo);
                }
            }
        }
        if (this.fhi.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.fhi.size() - 200; size < this.fhi.size(); size++) {
                arrayList.add(this.fhi.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.fhi.clear();
                this.fhi.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(j jVar) {
        if (ListUtils.isEmpty(jVar.XW)) {
            return null;
        }
        for (i iVar : jVar.XW) {
            if (iVar != null && iVar.mLiveInfo != null && iVar.mLiveInfo.live_id == this.ald.mLiveInfo.live_id) {
                return iVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bpF() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.fhi)) {
            return null;
        }
        if (this.fhv.isEmpty()) {
            arrayList.addAll(this.fhi);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fhi.size()) {
                    break;
                }
                if ((this.ald == null || this.ald.mLiveInfo == null || this.ald.mLiveInfo.live_id != this.fhi.get(i2).live_id) && !this.fhv.contains(Long.valueOf(this.fhi.get(i2).live_id))) {
                    arrayList.add(this.fhi.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void d(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.fhv.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.fhv.size() >= this.fhi.size() - 4) {
                jI(false);
            }
        }
    }

    public void qx(int i) {
        this.fhr = i;
    }

    public int bpG() {
        return this.fhr;
    }

    public void jI(boolean z) {
        if (com.baidu.live.liveroom.c.d.yr().yp()) {
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && 1 != this.fhr) {
                jJ(z);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.fhw > 500) {
                this.fhw = currentTimeMillis;
                com.baidu.live.liveroom.c.d.yr().yt().a("tieba", this.fhj, 20, this.fhM);
                return;
            }
            return;
        }
        jJ(z);
    }

    private void jJ(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.fhj);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.fhk);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.fhc);
            sendMessage(httpMessage);
        }
    }

    public void cV(String str, String str2) {
        this.fhf.vW();
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
        aVar.sE(str);
        aVar.setLiveId(j);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void ac(String str, String str2, String str3) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.setForumName(str3);
        aVar.sE(str2);
        aVar.zh(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void zi(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.dP(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void cY(long j) {
        this.fhf.vW();
        this.fhw = 0L;
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
        if (!bpH()) {
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

    private boolean bpH() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bpI() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.ald == null) {
            this.ald = new m(alaLiveInfoCoreData);
            this.fhf.e(this.ald);
        }
        this.fhk = this.ald.mLiveInfo.live_id;
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
        if (this.ald == null) {
            this.ald = new m();
        }
        this.ald.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.ald.XQ = alaLivePersonData.mUserData;
        this.ald.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.ald.XQ != null && this.fhf != null) {
            this.fhf.z(this.ald.XQ.live_mark_info_new);
        }
        this.ald.isHost = true;
        this.ald.Yl = true;
        this.fhf.e(this.ald);
        bpP();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.ald));
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
        this.fhd.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.fhL);
        MessageManager.getInstance().removeMessageRule(this.fhs);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        this.fhf.vW();
        this.fhg = null;
        this.mPageContext = null;
    }

    public void qy(int i) {
        this.fhl = i;
        if (this.fhi.size() == 0) {
            this.fhl = 0;
        } else if (this.fhl < 0) {
            this.fhl = this.fhi.size() + this.fhl;
        } else {
            this.fhl %= this.fhi.size();
        }
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.fhi.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fhi.size()) {
                    if (this.fhi.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.fhl = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bpJ() {
        long j;
        if (this.fhi.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.fhi.get(0);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.ald.mLiveInfo.live_id;
        }
        return true;
    }

    public boolean bpK() {
        long j;
        if (this.fhi.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.fhi.get(this.fhi.size() - 1);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.ald.mLiveInfo.live_id;
        }
        return true;
    }

    public int bpL() {
        return this.fhl;
    }

    public int bpM() {
        return this.fhn;
    }

    public boolean bpN() {
        return this.fho == 1;
    }

    public AlaLiveInfoData bpO() {
        if (this.fhl >= this.fhi.size()) {
            this.fhl = this.fhi.size() - 1;
        }
        if (this.fhl < 0) {
            this.fhl = 0;
        }
        if (this.fhi.size() <= this.fhl) {
            if (this.ald != null) {
                return this.ald.mLiveInfo;
            }
            return null;
        }
        return this.fhi.get(this.fhl);
    }

    public void a(a aVar) {
        this.fep = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.fhg != null) {
            this.fhg.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void g(com.baidu.live.im.data.a aVar) {
        if (this.ald != null && this.ald.mLiveInfo.live_type == 1) {
            u(aVar);
        }
        if (this.fhg != null) {
            this.fhg.g(aVar);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913037, aVar));
        }
    }

    public void u(com.baidu.live.im.data.a aVar) {
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
            jI(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void vY() {
        if (this.fhg != null) {
            this.fhg.vY();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.ald != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.ald.XQ;
            } else {
                alaLiveUserInfoData = this.ald.Ye;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.ald.mLiveInfo.imEffect;
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.ald != null && this.ald.Ye != null && this.ald.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.ald.Ye.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr == null || strArr.length != 2) {
                            strArr = new String[2];
                        }
                        strArr[0] = "guard_seat_effect";
                    }
                }
                this.fhf.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr);
            }
        }
    }

    public void bpP() {
        this.fhf.e(String.valueOf(this.ald.mLiveInfo.getGroupID()), String.valueOf(this.ald.mLiveInfo.getLastMsgID()), String.valueOf(this.ald.mLiveInfo.getUserID()), String.valueOf(this.ald.mLiveInfo.getLiveID()), this.ald.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bpQ() {
        return this.fhf;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
