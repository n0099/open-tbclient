package com.baidu.tieba.ala.liveroom.q;

import android.os.Handler;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.w;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.q.d;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private w aES;
    private String bnW;
    private long hlO;
    private d.a hlY;
    private boolean hoQ;
    private long hoR;
    private Handler mHandler = new Handler();
    private HttpMessageListener hoS = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.q.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                w Hi = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).Hi() : null;
                a.this.hoR = System.currentTimeMillis();
                if (Hi == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Hi);
                    return;
                }
                if (a.this.aES == null) {
                    a.this.aES = Hi;
                } else if (a.this.aES.mLiveInfo != null && Hi.mLiveInfo != null && a.this.aES.mLiveInfo.live_id != Hi.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aES);
                    return;
                }
                if (a.this.aES.mLiveInfo != null && Hi.mLiveInfo != null && a.this.aES.mLiveInfo.user_id == Hi.mLiveInfo.user_id) {
                    if (a.this.aES.mLiveInfo.imEffect != null && Hi.mLiveInfo.imEffect == null) {
                        Hi.mLiveInfo.imEffect = a.this.aES.mLiveInfo.imEffect;
                    }
                    if (a.this.aES.mLiveInfo.mLiveCloseData != null && Hi.mLiveInfo.mLiveCloseData == null) {
                        Hi.mLiveInfo.mLiveCloseData = a.this.aES.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aES.mLiveInfo.mAlaLiveSwitchData != null && Hi.mLiveInfo.mAlaLiveSwitchData == null) {
                        Hi.mLiveInfo.mAlaLiveSwitchData = a.this.aES.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aES.mLiveInfo = Hi.mLiveInfo;
                a.this.aES.serverTime = Hi.serverTime;
                a.this.aES.aJM = Hi.aJM;
                a.this.aES.aIV = Hi.aIV;
                a.this.aES.aIW = Hi.aIW;
                a.this.aES.aJa = Hi.aJa;
                a.this.aES.aJB = Hi.aJB;
                a.this.aES.aJz = Hi.aJz;
                a.this.aES.aJw = Hi.aJw;
                a.this.aES.aJx = Hi.aJx;
                a.this.aES.aJy = Hi.aJy;
                if (Hi.aJt != null) {
                    a.this.aES.aJt = Hi.aJt;
                }
                if (Hi.aJE != null && Hi.aJE.aNO != null && !Hi.aJE.aNO.isEmpty()) {
                    a.this.aES.aJE = Hi.aJE;
                }
                if (Hi.aJr != null) {
                    if (Hi.aJr.userId == 0) {
                        if (a.this.aES.aJr == null) {
                            a.this.aES.aJr = new AlaLiveUserInfoData();
                        }
                        a.this.aES.aJr.throneUid = Hi.aJr.throneUid;
                    } else {
                        boolean z = Hi.aJr.isNewUser;
                        if (a.this.aES.aJr != null) {
                            z = a.this.aES.aJr.isNewUser;
                        }
                        Hi.aJr.isNewUser = z;
                        a.this.aES.aJr = Hi.aJr;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aES.aJr.nickName);
                    }
                }
                if (Hi.aJv != null) {
                    a.this.aES.aJv = Hi.aJv;
                }
                if (Hi.aJz) {
                    a.this.aES.aJA = Hi.aJA;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aES);
                a.this.K(a.this.aES);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aES));
                if (a.this.aES != null) {
                    com.baidu.live.im.b.d.Mg().U(a.this.aES.aJA);
                }
            }
        }
    };
    private Runnable hoT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cfS();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void K(w wVar) {
        if (wVar != null && this.hoQ) {
            this.mHandler.removeCallbacks(this.hoT);
            this.mHandler.postDelayed(this.hoT, wVar.aJa);
        }
    }

    public void cfR() {
        this.mHandler.removeCallbacks(this.hoT);
    }

    public void a(w wVar, String str, long j) {
        this.aES = wVar;
        this.bnW = str;
        this.hlO = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.hoS);
        this.hoQ = true;
        K(this.aES);
    }

    public void stop() {
        this.hoQ = false;
        MessageManager.getInstance().unRegisterListener(this.hoS);
        cfR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfS() {
        if (this.aES != null && this.aES.mLiveInfo != null) {
            a(this.aES.mLiveInfo.live_id, this.bnW, this.hlO);
        }
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c();
        cVar.setLiveId(j);
        cVar.setFrom(str);
        cVar.aB(j2);
        cVar.setParams();
        sendMessage(cVar);
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

    public void a(d.a aVar) {
        this.hlY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hlY != null) {
            this.hlY.a(i, str, i2, obj);
        }
    }
}
