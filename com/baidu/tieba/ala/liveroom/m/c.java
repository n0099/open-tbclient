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
    private m alp;
    private HttpMessageListener ePl;
    private CustomMessageListener ewi;
    private h exy;
    private a ffc;
    private BdUniqueId fhP;
    private Handler fhQ;
    private HttpMessage fhR;
    private final com.baidu.live.im.d fhS;
    private d.a fhT;
    private com.baidu.tieba.ala.liveroom.data.h fhU;
    private List<AlaLiveInfoData> fhV;
    private int fhW;
    private long fhX;
    private int fhY;
    private boolean fhZ;
    private HttpMessageListener fiA;
    private HttpMessageListener fiB;
    private com.baidu.live.liveroom.c.a fiC;
    private int fia;
    private int fib;
    private String fic;
    private int fie;
    private int fif;
    private com.baidu.live.t.a fig;
    private AlaGetVerifyStrategyResponseHttpMessage fih;
    private BdAlertDialog fii;
    private Set<Long> fij;
    private long fik;
    private HttpMessageListener fil;
    private CustomMessageListener fim;
    private HttpMessageListener fin;
    private HttpMessageListener fio;
    private NetMessageListener fip;
    private HttpMessageListener fiq;
    private NetMessageListener fir;
    private HttpMessageListener fis;
    private HttpMessageListener fiu;
    private NetMessageListener fiv;
    private NetMessageListener fiw;
    private HttpMessageListener fiy;
    private CustomMessageListener fiz;
    private boolean mIsHost;
    private BdPageContext<?> mPageContext;
    private String otherParams;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, String str, int i2, Object obj);
    }

    public c(BdPageContext<?> bdPageContext) {
        super(bdPageContext);
        this.fhQ = new Handler();
        this.fhW = 0;
        this.fhY = 0;
        this.fhZ = true;
        this.fia = 1;
        this.fib = 0;
        this.fie = -1;
        this.fif = 0;
        this.fig = new com.baidu.live.t.a(0);
        this.otherParams = "";
        this.ewi = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.liveroom.m.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                    if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && c.this.alp != null && c.this.alp.mLiveInfo != null && updateAttentionMessage.getData().toUid.equals(String.valueOf(c.this.alp.mLiveInfo.user_id)) && updateAttentionMessage.getData().isSucc) {
                        if (!updateAttentionMessage.getData().isAttention) {
                            c.this.fie = 0;
                        } else {
                            TiebaInitialize.log(new StatisticItem("c12835").param("obj_id", c.this.alp.mLiveInfo.user_id).param("obj_param1", c.this.alp.mLiveInfo.live_id).param("tid", c.this.alp.mLiveInfo.thread_id));
                            c.this.fie = 1;
                        }
                        if (c.this.alp != null && c.this.alp.Yc != null) {
                            c.this.alp.Yc.follow_status = c.this.fie;
                        }
                    }
                }
            }
        };
        this.fil = new HttpMessageListener(1021046) { // from class: com.baidu.tieba.ala.liveroom.m.c.23
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUserAuthenVerifyInfoResponseMessage)) {
                    AlaUserAuthenVerifyInfoResponseMessage alaUserAuthenVerifyInfoResponseMessage = (AlaUserAuthenVerifyInfoResponseMessage) httpResponsedMessage;
                    if (alaUserAuthenVerifyInfoResponseMessage.awO == 1 && alaUserAuthenVerifyInfoResponseMessage.awN != null) {
                        if (alaUserAuthenVerifyInfoResponseMessage.awN.verify_info_status == 1 || alaUserAuthenVerifyInfoResponseMessage.awN.verify_video_status == 1) {
                            c.this.fia = 4;
                        }
                    }
                }
            }
        };
        this.fim = new CustomMessageListener(2913116) { // from class: com.baidu.tieba.ala.liveroom.m.c.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    try {
                        JSONObject optJSONObject = new JSONObject((String) customResponsedMessage.getData()).optJSONObject("result").optJSONObject("zbwhitelistapi").optJSONObject("data");
                        boolean optBoolean = optJSONObject.optBoolean("inwhite");
                        int optInt = optJSONObject.optInt("is_verified");
                        c.this.fic = optJSONObject.optString("cmd");
                        if (optInt != 1) {
                            c.this.fhQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.24.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bpF();
                                }
                            }, 200L);
                        } else if (!optBoolean) {
                            c.this.fhQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.24.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bpG();
                                }
                            }, 200L);
                        } else {
                            c.this.bpD();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.fin = new HttpMessageListener(1003303) { // from class: com.baidu.tieba.ala.liveroom.m.c.25
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
                    c.this.fib = alaGetVerifyStrategyResponseHttpMessage.fhw;
                    c.this.b(alaGetVerifyStrategyResponseHttpMessage.getError(), alaGetVerifyStrategyResponseHttpMessage.getErrorString(), 7, alaGetVerifyStrategyResponseHttpMessage);
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fhu == 1 && alaGetVerifyStrategyResponseHttpMessage.fhs == 1) {
                            c.this.fih = null;
                            return;
                        }
                    } else if ((TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) && alaGetVerifyStrategyResponseHttpMessage.fhu == 1 && alaGetVerifyStrategyResponseHttpMessage.fhs == 1 && alaGetVerifyStrategyResponseHttpMessage.fhx == 1) {
                        c.this.fih = null;
                        return;
                    }
                    c.this.fih = alaGetVerifyStrategyResponseHttpMessage;
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        if (alaGetVerifyStrategyResponseHttpMessage.fhu != 1 || alaGetVerifyStrategyResponseHttpMessage.fhs != 1) {
                            c.this.fhQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bpG();
                                }
                            }, 200L);
                        }
                    } else if (!TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isOther()) {
                        c.this.fhQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.5
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bpI();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.fhx != 1) {
                        c.this.fhQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.3
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bpF();
                            }
                        }, 200L);
                    } else if (alaGetVerifyStrategyResponseHttpMessage.fhu != 1 || alaGetVerifyStrategyResponseHttpMessage.fhs != 1) {
                        c.this.fhQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.25.4
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.bpG();
                            }
                        }, 200L);
                    }
                }
            }
        };
        this.fio = new HttpMessageListener(1021131) { // from class: com.baidu.tieba.ala.liveroom.m.c.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof MasterIdentityResponseMessage)) {
                    MasterIdentityResponseMessage masterIdentityResponseMessage = (MasterIdentityResponseMessage) httpResponsedMessage;
                    if (masterIdentityResponseMessage.bpo() == 1 || masterIdentityResponseMessage.bpp() == 1) {
                        c.this.fhS.a(13, masterIdentityResponseMessage.bpq(), (com.baidu.live.data.a) null);
                    }
                }
            }
        };
        this.fip = new NetMessageListener(1021006, 602002) { // from class: com.baidu.tieba.ala.liveroom.m.c.27
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
            }
        };
        this.fiq = new HttpMessageListener(1021023) { // from class: com.baidu.tieba.ala.liveroom.m.c.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.isSuccess()) {
                    c.this.fhZ = false;
                }
            }
        };
        this.fir = new NetMessageListener(1021005, 602001) { // from class: com.baidu.tieba.ala.liveroom.m.c.2
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j = 0;
                if (responsedMessage != null && (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage instanceof AlaEnterLiveHttpResonseMessage) {
                        c.this.alp = ((AlaEnterLiveHttpResonseMessage) responsedMessage).yT();
                        c.this.fhS.e(c.this.alp);
                    }
                    if (c.this.alp != null && c.this.alp.mLiveInfo != null && (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityTaskWatchUnabled())) {
                        if (!TbadkCoreApplication.getInst().isOther()) {
                            com.baidu.tieba.ala.liveroom.task.c.bqE().cZ(c.this.alp.mLiveInfo.live_id);
                        }
                        LiveTimerManager.getInstance().start(c.this.alp.mLiveInfo.live_id);
                    }
                    if (c.this.alp != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
                        if (c.this.alp.Yo != null) {
                            if (c.this.alp.Yo.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.alp.Yo.levelId);
                            }
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.alp.Yo.nickName);
                            if (!TextUtils.isEmpty(c.this.alp.Yo.portrait)) {
                                TbadkCoreApplication.getCurrentAccountObj().setPortrait(c.this.alp.Yo.portrait);
                            }
                        }
                        if (c.this.alp.mLiveSdkInfo != null) {
                            TbadkCoreApplication.getInst().setTbs(c.this.alp.mLiveSdkInfo.tbs);
                            com.baidu.live.c.pw().putString("ala_account_user_tbs", c.this.alp.mLiveSdkInfo.tbs);
                        }
                    }
                    if (c.this.alp != null) {
                        if (c.this.fhV.size() <= 0) {
                            c.this.fhV.add(c.this.alp.mLiveInfo);
                            c.this.fij.add(Long.valueOf(c.this.alp.mLiveInfo.getLiveID()));
                        }
                        c.this.e(c.this.alp.mLiveInfo);
                        if (c.this.fhS != null) {
                            c.this.fhS.z(c.this.alp.Ys);
                        }
                    }
                    if (c.this.alp != null && c.this.alp.Yc != null) {
                        c.this.fie = c.this.alp.Yc.follow_status;
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 3, c.this.alp);
                    if (c.this.alp != null && c.this.alp.mLiveInfo != null) {
                        c.this.bpX();
                    }
                    if (c.this.alp != null) {
                        c.this.alp.isHost = false;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.alp));
                        k.wF().C(c.this.alp.Ys);
                    }
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        if (c.this.alp != null && c.this.alp.mLiveInfo != null) {
                            long j2 = c.this.alp.mLiveInfo.live_id;
                            long j3 = c.this.alp.mLiveInfo.room_id;
                            String str = c.this.alp.mLiveInfo.feed_id;
                            String str2 = "";
                            if (c.this.alp.Ya != null) {
                                long j4 = c.this.alp.Ya.userId;
                                str2 = c.this.alp.Ya.userName;
                                j = j4;
                            }
                            HKStaticManager.staticStartPlayTime(j2 + "", j3 + "", j + "", str2, System.currentTimeMillis(), str, c.this.otherParams);
                        }
                    } else if (TbadkCoreApplication.getInst().isQuanmin() && c.this.alp != null && c.this.alp.mLiveInfo != null) {
                        long j5 = c.this.alp.mLiveInfo.live_id;
                        long j6 = c.this.alp.mLiveInfo.room_id;
                        String str3 = c.this.alp.mLiveInfo.feed_id;
                        String str4 = "";
                        if (c.this.alp.Ya != null) {
                            j = c.this.alp.Ya.userId;
                            str4 = c.this.alp.Ya.userName;
                        }
                        QMStaticManager.staticStartPlayTime(j5 + "", j6 + "", j + "", str4, System.currentTimeMillis(), str3, c.this.otherParams, c.this.fhY + "");
                    }
                }
            }
        };
        this.fis = new HttpMessageListener(1021129) { // from class: com.baidu.tieba.ala.liveroom.m.c.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage)) {
                    h hVar = null;
                    if (httpResponsedMessage instanceof AlaGetAudienceHttpResponseMessage) {
                        hVar = ((AlaGetAudienceHttpResponseMessage) httpResponsedMessage).bee();
                    }
                    if (hVar != null) {
                        c.this.exy = hVar;
                    }
                    if (c.this.alp != null && c.this.alp.Yc != null) {
                        if (c.this.fie == -1) {
                            c.this.fie = c.this.alp.Yc.follow_status;
                        }
                        if (c.this.alp.Yc.follow_status != c.this.fie) {
                            c.this.alp.Yc.follow_status = c.this.fie;
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 2, c.this.exy);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913016, c.this.exy));
                }
            }
        };
        this.fiu = new HttpMessageListener(1021121) { // from class: com.baidu.tieba.ala.liveroom.m.c.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaUserLiveMarkInfoResponseMessage) {
                    AlaUserLiveMarkInfoResponseMessage alaUserLiveMarkInfoResponseMessage = (AlaUserLiveMarkInfoResponseMessage) httpResponsedMessage;
                    if (alaUserLiveMarkInfoResponseMessage.getError() == 0) {
                        List<AlaLiveMarkData> bpn = alaUserLiveMarkInfoResponseMessage.bpn();
                        c.this.fhS.z(bpn);
                        if (c.this.alp != null) {
                            c.this.alp.Ys = bpn;
                            k.wF().C(c.this.alp.Ys);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913118, c.this.alp));
                        }
                    }
                }
            }
        };
        this.fiv = new NetMessageListener(1021007, 602003) { // from class: com.baidu.tieba.ala.liveroom.m.c.5
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && (responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && responsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    if (responsedMessage.hasError()) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, null);
                        return;
                    }
                    m yT = responsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) responsedMessage).yT() : null;
                    if (yT == null) {
                        c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, yT);
                        return;
                    }
                    if (c.this.alp == null) {
                        c.this.alp = yT;
                        c.this.fhS.e(c.this.alp);
                    }
                    if (c.this.alp.mLiveInfo != null && yT.mLiveInfo != null && c.this.alp.mLiveInfo.user_id == yT.mLiveInfo.user_id) {
                        if (c.this.alp.mLiveInfo.imEffect != null && yT.mLiveInfo.imEffect == null) {
                            yT.mLiveInfo.imEffect = c.this.alp.mLiveInfo.imEffect;
                        }
                        if (c.this.alp.mLiveInfo.mLiveCloseData != null && yT.mLiveInfo.mLiveCloseData == null) {
                            yT.mLiveInfo.mLiveCloseData = c.this.alp.mLiveInfo.mLiveCloseData;
                        }
                        if (c.this.alp.mLiveInfo.mAlaLiveSwitchData != null && yT.mLiveInfo.mAlaLiveSwitchData == null) {
                            yT.mLiveInfo.mAlaLiveSwitchData = c.this.alp.mLiveInfo.mAlaLiveSwitchData;
                        }
                    }
                    c.this.alp.mLiveInfo = yT.mLiveInfo;
                    c.this.alp.Ya = yT.Ya;
                    c.this.alp.Yb = yT.Yb;
                    c.this.alp.Ye = yT.Ye;
                    c.this.alp.Yt = yT.Yt;
                    c.this.alp.Yr = yT.Yr;
                    c.this.alp.Yq = yT.Yq;
                    if (yT.Yx != null && yT.Yx.abp != null && !yT.Yx.abp.isEmpty()) {
                        c.this.alp.Yx = yT.Yx;
                    }
                    if (yT.Yo != null) {
                        if (yT.Yo.userId == 0) {
                            if (c.this.alp.Yo == null) {
                                c.this.alp.Yo = new AlaLiveUserInfoData();
                            }
                            c.this.alp.Yo.throneUid = yT.Yo.throneUid;
                        } else {
                            boolean z = yT.Yo.isNewUser;
                            if (c.this.alp.Yo != null) {
                                z = c.this.alp.Yo.isNewUser;
                            }
                            yT.Yo.isNewUser = z;
                            c.this.alp.Yo = yT.Yo;
                            TbadkCoreApplication.getCurrentAccountObj().setNameShow(c.this.alp.Yo.nickName);
                        }
                    }
                    if (yT.Yr) {
                        c.this.alp.Ys = yT.Ys;
                        if (c.this.fhS != null) {
                            c.this.fhS.z(yT.Ys);
                        }
                    }
                    if (!c.this.mIsHost && c.this.alp.mLiveInfo != null) {
                        int i = c.this.alp.mLiveInfo.backstage_type;
                        if (c.this.fhS != null) {
                            c.this.fhS.dJ(String.valueOf(i));
                        }
                    }
                    if (c.this.fhS != null) {
                        c.this.fhS.e(c.this.alp);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 1, c.this.alp);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, c.this.alp));
                    if (c.this.alp != null) {
                        k.wF().C(c.this.alp.Ys);
                    }
                }
            }
        };
        this.fiw = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.m.c.6
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
                    if (list != null && list.size() > 0 && c.this.fhV != null && c.this.fhV.size() > 0) {
                        for (int size = c.this.fhV.size() - 1; size >= 0; size--) {
                            if (((AlaLiveInfoData) c.this.fhV.get(size)).live_id != c.this.alp.mLiveInfo.live_id && list.contains(Long.valueOf(((AlaLiveInfoData) c.this.fhV.get(size)).getLiveID()))) {
                                c.this.fhV.remove(size);
                            }
                        }
                    }
                    if (c.this.alp != null) {
                        c.this.e(c.this.alp.mLiveInfo);
                    }
                    c.this.b(responsedMessage.getError(), responsedMessage.getErrorString(), 4, Long.valueOf(j2));
                }
            }
        };
        this.ePl = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.m.c.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            }
        };
        this.fiy = new HttpMessageListener(1021033) { // from class: com.baidu.tieba.ala.liveroom.m.c.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaUpdateLiveTbResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == c.this.unique_id) {
                    AlaUpdateLiveTbResponseMessage alaUpdateLiveTbResponseMessage = (AlaUpdateLiveTbResponseMessage) httpResponsedMessage;
                    c.this.fhR = (HttpMessage) alaUpdateLiveTbResponseMessage.getOrginalMessage();
                    c.this.fhU = alaUpdateLiveTbResponseMessage.bpm();
                    if (c.this.fhU != null) {
                        if (c.this.fhU.fbD != 1 || c.this.fhU.fbF != 1) {
                            c.this.fhQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    c.this.bpH();
                                }
                            }, 200L);
                            return;
                        }
                        if (c.this.fhU.Ya != null) {
                            c.this.fhS.z(c.this.fhU.Ya.live_mark_info_new);
                        }
                        if (c.this.fhU.mErrorCode != 0) {
                            if (c.this.fhU.mErrorCode == 220012) {
                                c.this.b(c.this.fhU.mErrorCode, c.this.fhU.mErrorMsg, 6, c.this.alp);
                                return;
                            }
                        } else {
                            c.this.alp = new m();
                            c.this.fhS.e(c.this.alp);
                            c.this.alp.mLiveInfo = c.this.fhU.mLiveInfo;
                            c.this.alp.Ya = c.this.fhU.Ya;
                            c.this.alp.mLiveSdkInfo = c.this.fhU.mLiveSdkInfo;
                            c.this.alp.Yu = c.this.fhU.Yu;
                            c.this.alp.Ys = c.this.fhU.Ya.live_mark_info_new;
                            if (c.this.fhU.Ya != null && c.this.fhU.Ya.levelId > 0) {
                                TbadkCoreApplication.getCurrentAccountInfo().setLiveLevel(c.this.fhU.Ya.levelId);
                            }
                            c.this.alp.isHost = true;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, c.this.alp));
                        }
                    }
                    c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 6, c.this.alp);
                    if (c.this.fhU != null && c.this.fhU.mLiveInfo != null) {
                        c.this.bpX();
                    }
                    if (c.this.alp != null && c.this.alp.mLiveInfo != null) {
                        c.this.w(c.this.alp.mLiveInfo.user_id, c.this.alp.mLiveInfo.live_id);
                    }
                }
            }
        };
        this.fiz = new CustomMessageListener(2913143) { // from class: com.baidu.tieba.ala.liveroom.m.c.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    c.this.fhS.a(13, (String) customResponsedMessage.getData(), (com.baidu.live.data.a) null);
                }
            }
        };
        this.fiA = new HttpMessageListener(1021128) { // from class: com.baidu.tieba.ala.liveroom.m.c.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof com.baidu.live.l.b)) {
                    com.baidu.live.l.b bVar = (com.baidu.live.l.b) httpResponsedMessage.getOrginalMessage().getExtra();
                    if (bVar.axu != null) {
                        if (httpResponsedMessage.getError() == 0) {
                            bVar.axu.dR(bVar.contentType);
                        } else {
                            bVar.axu.b(bVar.contentType, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        }
                    }
                }
            }
        };
        this.fiB = new HttpMessageListener(1021021) { // from class: com.baidu.tieba.ala.liveroom.m.c.20
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                j jVar;
                if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0) {
                    if (!(httpResponsedMessage instanceof AlaLiveRecommondHttpResponseMessage)) {
                        jVar = null;
                    } else {
                        jVar = ((AlaLiveRecommondHttpResponseMessage) httpResponsedMessage).bpk();
                    }
                    if (jVar != null && !ListUtils.isEmpty(jVar.Yg)) {
                        c.this.fhW = jVar.pn + 1;
                        i iVar = jVar.Yg.get(jVar.Yg.size() - 1);
                        if (iVar != null) {
                            c.this.fhX = iVar.mLiveInfo.live_id;
                        }
                        c.this.a(jVar);
                        if (c.this.alp != null) {
                            c.this.e(c.this.alp.mLiveInfo);
                        }
                        c.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 5, jVar);
                    }
                }
            }
        };
        this.fiC = new com.baidu.live.liveroom.c.a() { // from class: com.baidu.tieba.ala.liveroom.m.c.21
        };
        this.mPageContext = bdPageContext;
        this.fhS = new com.baidu.live.im.d(bdPageContext, false, this);
        this.fhV = new ArrayList();
        this.fij = new HashSet();
        initTasks();
        registerListener(this.fiv);
        registerListener(this.fis);
        registerListener(this.fir);
        registerListener(this.fip);
        this.fhP = BdUniqueId.gen();
        this.fiB.setTag(this.fhP);
        registerListener(this.fiB);
        registerListener(this.fiw);
        registerListener(this.fiq);
        registerListener(this.fiy);
        registerListener(this.ePl);
        registerListener(this.fin);
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            registerListener(this.fim);
        }
        registerListener(this.fil);
        registerListener(this.ewi);
        registerListener(this.fiu);
        registerListener(this.fio);
        registerListener(this.fiz);
        registerListener(this.fiA);
        MessageManager.getInstance().addMessageRule(this.fig);
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
        bpt();
        bpu();
        bpv();
        bpw();
        bpz();
    }

    private void bpt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021129, TbConfig.SERVER_ADDRESS + "ala/relation/getDayGuardianShipList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(AlaGetAudienceHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bpu() {
        com.baidu.live.tieba.f.a.a.a(1021005, "ala/live/enterLive", AlaEnterLiveHttpResonseMessage.class, false, true, true, true);
    }

    private void bpv() {
        com.baidu.live.tieba.f.a.a.a(1021006, "ala/live/quitLive", AlaQuitLiveHttpResponseMessage.class, false, true, true, true);
    }

    private void bpw() {
        com.baidu.live.tieba.f.a.a.a(1021121, "ala/sdk/v1/open/getUserLiveMarkInfo", AlaUserLiveMarkInfoResponseMessage.class, true, true, true, true);
    }

    public void bpx() {
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

    public void bpy() {
        MessageManager.getInstance().unRegisterTask(2913043);
    }

    private void bpz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021131, TbConfig.SERVER_ADDRESS + "ala/UGC/getUGCAnchorInfo");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(MasterIdentityResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bpA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913158, new CustomMessageTask.CustomRunnable() { // from class: com.baidu.tieba.ala.liveroom.m.c.22
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage customMessage) {
                if (customMessage != null && (customMessage.getData() instanceof com.baidu.live.l.b) && c.this.alp != null && c.this.alp.mLiveInfo != null) {
                    com.baidu.live.l.b bVar = (com.baidu.live.l.b) customMessage.getData();
                    HttpMessage httpMessage = new HttpMessage(1021128);
                    httpMessage.addParam("live_id", c.this.alp.mLiveInfo.live_id);
                    httpMessage.addParam("content_type", bVar.contentType);
                    if (bVar.axt != null) {
                        httpMessage.addParam("ext_data", bVar.axt.toString());
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

    public void bpB() {
        MessageManager.getInstance().unRegisterTask(2913158);
    }

    public void w(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021131);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("live_id", j2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bpC() {
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

    public void bpD() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1003303));
    }

    public void bpE() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FaceRecognitionActivityConfig(this.mPageContext.getPageActivity(), "")));
    }

    public void bpF() {
        if (this.fii != null) {
            this.fii.dismiss();
            this.fii = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_auth);
        this.fii = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fii.setAutoNight(false);
        this.fii.setMessage(string);
        if (TbadkCoreApplication.getInst().isRegistedIntent(FaceRecognitionActivityConfig.class) && RealAuthenManager.getInstance().getRealAuthen() != null) {
            this.fii.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_auth), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.11
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.bpE();
                    c.this.sS();
                }
            });
            this.fii.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.13
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.sS();
                }
            });
        } else {
            this.fii.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.sS();
                }
            });
        }
        this.fii.setCancelable(false);
        this.fii.setCanceledOnTouchOutside(false);
        this.fii.setTitleShowCenter(true);
        this.fii.setMessageShowCenter(true);
        this.fii.isShowTitleAndMessage();
        this.fii.create(this.mPageContext);
        this.fii.show();
    }

    public void bpG() {
        if (this.fii != null) {
            this.fii.dismiss();
            this.fii = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission);
        this.fii = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fii.setAutoNight(false);
        this.fii.setMessage(string);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fii.setPositiveButton(this.mPageContext.getString(a.i.sdk_know), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.sS();
                }
            });
        } else {
            this.fii.setPositiveButton(this.mPageContext.getString(a.i.dialog_to_appeal), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    if (TbadkCoreApplication.getInst().isTieba()) {
                        String str = com.baidu.live.v.a.zs().awM.aaB;
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
                    c.this.sS();
                }
            });
            this.fii.setNegativeButton(this.mPageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.17
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    c.this.sS();
                }
            });
        }
        this.fii.setCancelable(false);
        this.fii.setCanceledOnTouchOutside(false);
        this.fii.setTitleShowCenter(true);
        this.fii.setMessageShowCenter(true);
        this.fii.isShowTitleAndMessage();
        this.fii.create(this.mPageContext);
        this.fii.show();
    }

    public void bpH() {
        if (this.fii != null) {
            this.fii.dismiss();
            this.fii = null;
        }
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fii = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fii.setAutoNight(false);
        this.fii.setMessage(string);
        this.fii.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.18
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fii.setCancelable(false);
        this.fii.setCanceledOnTouchOutside(false);
        this.fii.isShowTitleAndMessage();
        this.fii.create(this.mPageContext);
        this.fii.show();
    }

    public void bpI() {
        if (this.fii != null) {
            this.fii.dismiss();
            this.fii = null;
        }
        if (this.fih != null) {
            a(this.fih);
        }
    }

    private void a(AlaGetVerifyStrategyResponseHttpMessage alaGetVerifyStrategyResponseHttpMessage) {
        String string = this.mPageContext.getString(a.i.ala_live_no_permission_tip);
        this.fii = new BdAlertDialog(this.mPageContext.getPageActivity());
        this.fii.setAutoNight(false);
        this.fii.setMessage(string);
        this.fii.setPositiveButton(this.mPageContext.getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.m.c.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                c.this.b(bdAlertDialog);
            }
        });
        this.fii.setCancelable(false);
        this.fii.setCanceledOnTouchOutside(false);
        this.fii.isShowTitleAndMessage();
        this.fii.create(this.mPageContext);
        this.fii.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BdAlertDialog bdAlertDialog) {
        bdAlertDialog.dismiss();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913086));
        this.mPageContext.getPageActivity().finish();
        this.fih = null;
        this.fii = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS() {
        if (this.fii != null) {
            this.fii.dismiss();
            this.fii = null;
        }
        this.fih = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.ffc != null) {
            this.ffc.a(i, str, i2, obj);
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

    public void bpJ() {
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

    public void qy(int i) {
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

    public com.baidu.tieba.ala.liveroom.data.h bpK() {
        return this.fhU;
    }

    public m yT() {
        return this.alp;
    }

    public List<AlaLiveInfoData> bpL() {
        return this.fhV;
    }

    public h bee() {
        return this.exy;
    }

    public void bF(List<Long> list) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            com.baidu.live.liveroom.messages.a aVar = new com.baidu.live.liveroom.messages.a();
            if (this.alp != null && this.alp.mLiveInfo != null) {
                aVar.setAudienceCount(this.alp.mLiveInfo.audience_count);
            }
            aVar.setListIds(list);
            aVar.setParams();
            sendMessage(aVar);
        }
    }

    public void bpM() {
        ArrayList arrayList = new ArrayList();
        for (AlaLiveInfoData alaLiveInfoData : this.fhV) {
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
                if (this.fhV.size() == 1 && this.fhV.get(0).live_id == this.alp.mLiveInfo.live_id) {
                    if (c(jVar) != null) {
                        this.fhV.clear();
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
        for (i iVar : jVar.Yg) {
            if (iVar != null && iVar.mLiveInfo != null) {
                for (AlaLiveInfoData alaLiveInfoData : this.fhV) {
                    if (alaLiveInfoData == null || alaLiveInfoData.live_id == iVar.mLiveInfo.live_id) {
                        z = false;
                        break;
                    }
                    while (r4.hasNext()) {
                    }
                }
                z = true;
                if (z) {
                    this.fhV.add(iVar.mLiveInfo);
                }
            }
        }
        if (this.fhV.size() >= 200) {
            ArrayList arrayList = new ArrayList();
            for (int size = this.fhV.size() - 200; size < this.fhV.size(); size++) {
                arrayList.add(this.fhV.get(size));
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.fhV.clear();
                this.fhV.addAll(arrayList);
                arrayList.clear();
            }
        }
    }

    private AlaLiveInfoData c(j jVar) {
        if (ListUtils.isEmpty(jVar.Yg)) {
            return null;
        }
        for (i iVar : jVar.Yg) {
            if (iVar != null && iVar.mLiveInfo != null && iVar.mLiveInfo.live_id == this.alp.mLiveInfo.live_id) {
                return iVar.mLiveInfo;
            }
        }
        return null;
    }

    public ArrayList<AlaLiveInfoData> bpN() {
        ArrayList<AlaLiveInfoData> arrayList = new ArrayList<>();
        if (ListUtils.isEmpty(this.fhV)) {
            return null;
        }
        if (this.fij.isEmpty()) {
            arrayList.addAll(this.fhV);
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.fhV.size()) {
                    break;
                }
                if ((this.alp == null || this.alp.mLiveInfo == null || this.alp.mLiveInfo.live_id != this.fhV.get(i2).live_id) && !this.fij.contains(Long.valueOf(this.fhV.get(i2).live_id))) {
                    arrayList.add(this.fhV.get(i2));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public void d(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null) {
            this.fij.add(Long.valueOf(alaLiveInfoData.getLiveID()));
            if (this.fij.size() >= this.fhV.size() - 4) {
                jK(false);
            }
        }
    }

    public void qz(int i) {
        this.fif = i;
    }

    public int bpO() {
        return this.fif;
    }

    public void jK(boolean z) {
        if (com.baidu.live.liveroom.c.d.yw().yu()) {
            if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) && 1 != this.fif) {
                jL(z);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.fik > 500) {
                this.fik = currentTimeMillis;
                com.baidu.live.liveroom.c.d.yw().yy().a("tieba", this.fhW, 20, this.fiC);
                return;
            }
            return;
        }
        jL(z);
    }

    private void jL(boolean z) {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
            HttpMessage httpMessage = new HttpMessage(1021021);
            httpMessage.addParam(Config.PACKAGE_NAME, z ? 0 : this.fhW);
            httpMessage.addParam("ps", 20);
            httpMessage.addParam("scr_w", BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            httpMessage.addParam("scr_h", BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            httpMessage.addParam("q_type", 0);
            httpMessage.addParam("scr_dip", String.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst())));
            httpMessage.addParam("forum_id", "");
            httpMessage.addParam("entry_name", "");
            httpMessage.addParam("live_id", this.fhX);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccountId());
            httpMessage.setTag(this.fhP);
            sendMessage(httpMessage);
        }
    }

    public void cU(String str, String str2) {
        this.fhS.wb();
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
        aVar.sD(str);
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
        aVar.sD(str2);
        aVar.zi(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void zj(String str) {
        Address address = BdLocationMananger.getInstance().getAddress(false);
        com.baidu.tieba.ala.liveroom.messages.a aVar = new com.baidu.tieba.ala.liveroom.messages.a();
        if (address != null) {
            aVar.c(address.getLongitude(), address.getLatitude());
        }
        aVar.dO(str);
        aVar.setParams();
        sendMessage(aVar);
    }

    public void cY(long j) {
        this.fhS.wb();
        this.fik = 0L;
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
        if (!bpP()) {
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

    private boolean bpP() {
        return !ListUtils.isEmpty(MessageManager.getInstance().findMessage(1021033, getUniqueId()));
    }

    public void bpQ() {
        MessageManager.getInstance().sendMessage(new HttpMessage(1021046));
    }

    public void b(AlaLiveInfoCoreData alaLiveInfoCoreData) {
        if (this.alp == null) {
            this.alp = new m(alaLiveInfoCoreData);
            this.fhS.e(this.alp);
        }
        this.fhX = this.alp.mLiveInfo.live_id;
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
        if (this.alp == null) {
            this.alp = new m();
        }
        this.alp.mLiveInfo = alaLivePersonData.mLiveInfo;
        this.alp.Ya = alaLivePersonData.mUserData;
        this.alp.mLiveSdkInfo = alaLivePersonData.mLiveSdkInfo;
        if (this.alp.Ya != null && this.fhS != null) {
            this.fhS.z(this.alp.Ya.live_mark_info_new);
        }
        this.alp.isHost = true;
        this.alp.Yv = true;
        this.fhS.e(this.alp);
        bpX();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913081, this.alp));
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
        this.fhQ.removeCallbacksAndMessages(null);
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.fiB);
        MessageManager.getInstance().removeMessageRule(this.fig);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        MessageManager.getInstance().unRegisterTask(1021077);
        MessageManager.getInstance().unRegisterTask(1021123);
        MessageManager.getInstance().unRegisterTask(1021163);
        MessageManager.getInstance().removeMessage(1021128, getUniqueId());
        this.fhS.wb();
        this.fhT = null;
        this.mPageContext = null;
    }

    public void qA(int i) {
        this.fhY = i;
        if (this.fhV.size() == 0) {
            this.fhY = 0;
        } else if (this.fhY < 0) {
            this.fhY = this.fhV.size() + this.fhY;
        } else {
            this.fhY %= this.fhV.size();
        }
    }

    public void e(AlaLiveInfoData alaLiveInfoData) {
        if (alaLiveInfoData != null && this.fhV.size() != 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fhV.size()) {
                    if (this.fhV.get(i2).live_id != alaLiveInfoData.live_id) {
                        i = i2 + 1;
                    } else {
                        this.fhY = i2;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean bpR() {
        long j;
        if (this.fhV.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.fhV.get(0);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.alp.mLiveInfo.live_id;
        }
        return true;
    }

    public boolean bpS() {
        long j;
        if (this.fhV.size() > 0) {
            AlaLiveInfoData alaLiveInfoData = this.fhV.get(this.fhV.size() - 1);
            if (alaLiveInfoData == null) {
                j = 0;
            } else {
                j = alaLiveInfoData.live_id;
            }
            return j == this.alp.mLiveInfo.live_id;
        }
        return true;
    }

    public int bpT() {
        return this.fhY;
    }

    public int bpU() {
        return this.fia;
    }

    public boolean bpV() {
        return this.fib == 1;
    }

    public AlaLiveInfoData bpW() {
        if (this.fhY >= this.fhV.size()) {
            this.fhY = this.fhV.size() - 1;
        }
        if (this.fhY < 0) {
            this.fhY = 0;
        }
        if (this.fhV.size() <= this.fhY) {
            if (this.alp != null) {
                return this.alp.mLiveInfo;
            }
            return null;
        }
        return this.fhV.get(this.fhY);
    }

    public void a(a aVar) {
        this.ffc = aVar;
    }

    @Override // com.baidu.live.im.d.a
    public void d(List<com.baidu.live.im.data.a> list, boolean z) {
        if (this.fhT != null) {
            this.fhT.d(list, z);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913038, list));
        }
    }

    @Override // com.baidu.live.im.d.a
    public void g(com.baidu.live.im.data.a aVar) {
        if (this.alp != null && this.alp.mLiveInfo.live_type == 1) {
            u(aVar);
        }
        if (this.fhT != null) {
            this.fhT.g(aVar);
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
            jK(true);
        }
    }

    @Override // com.baidu.live.im.d.a
    public void wd() {
        if (this.fhT != null) {
            this.fhT.wd();
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913044));
        }
    }

    public void c(ImSendMsgData imSendMsgData) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        if (this.alp != null) {
            if (this.mIsHost) {
                alaLiveUserInfoData = this.alp.Ya;
            } else {
                alaLiveUserInfoData = this.alp.Yo;
            }
            if (alaLiveUserInfoData != null) {
                String[] strArr = this.alp.mLiveInfo.imEffect;
                if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.alp != null && this.alp.Yo != null && this.alp.mLiveInfo != null) {
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    String str = this.alp.Yo.throneUid;
                    if (!TextUtils.isEmpty(currentAccount) && !TextUtils.isEmpty(str) && currentAccount.equals(str)) {
                        if (strArr == null || strArr.length != 2) {
                            strArr = new String[2];
                        }
                        strArr[0] = "guard_seat_effect";
                    }
                }
                this.fhS.a(imSendMsgData, alaLiveUserInfoData.isOfficial == 1, alaLiveUserInfoData.isAdmin == 1, alaLiveUserInfoData.levelId, this.otherParams, strArr);
            }
        }
    }

    public void bpX() {
        this.fhS.e(String.valueOf(this.alp.mLiveInfo.getGroupID()), String.valueOf(this.alp.mLiveInfo.getLastMsgID()), String.valueOf(this.alp.mLiveInfo.getUserID()), String.valueOf(this.alp.mLiveInfo.getLiveID()), this.alp.mLiveInfo.appId);
    }

    public com.baidu.live.im.d bpY() {
        return this.fhS;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
