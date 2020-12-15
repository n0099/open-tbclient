package com.baidu.tieba.ala.liveroom.p;

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
import com.baidu.tieba.ala.liveroom.p.d;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private w aFN;
    private String brs;
    private long huW;
    private d.a hvg;
    private boolean hyd;
    private long hye;
    private Handler mHandler = new Handler();
    private HttpMessageListener hyf = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.p.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                w Iq = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).Iq() : null;
                a.this.hye = System.currentTimeMillis();
                if (Iq == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Iq);
                    return;
                }
                if (a.this.aFN == null) {
                    a.this.aFN = Iq;
                } else if (a.this.aFN.mLiveInfo != null && Iq.mLiveInfo != null && a.this.aFN.mLiveInfo.live_id != Iq.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aFN);
                    return;
                }
                if (a.this.aFN.mLiveInfo != null && Iq.mLiveInfo != null && a.this.aFN.mLiveInfo.user_id == Iq.mLiveInfo.user_id) {
                    if (a.this.aFN.mLiveInfo.imEffect != null && Iq.mLiveInfo.imEffect == null) {
                        Iq.mLiveInfo.imEffect = a.this.aFN.mLiveInfo.imEffect;
                    }
                    if (a.this.aFN.mLiveInfo.mLiveCloseData != null && Iq.mLiveInfo.mLiveCloseData == null) {
                        Iq.mLiveInfo.mLiveCloseData = a.this.aFN.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aFN.mLiveInfo.mAlaLiveSwitchData != null && Iq.mLiveInfo.mAlaLiveSwitchData == null) {
                        Iq.mLiveInfo.mAlaLiveSwitchData = a.this.aFN.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aFN.mLiveInfo = Iq.mLiveInfo;
                a.this.aFN.serverTime = Iq.serverTime;
                a.this.aFN.aKN = Iq.aKN;
                a.this.aFN.aJV = Iq.aJV;
                a.this.aFN.aJW = Iq.aJW;
                a.this.aFN.aKa = Iq.aKa;
                a.this.aFN.aKC = Iq.aKC;
                a.this.aFN.aKA = Iq.aKA;
                a.this.aFN.aKw = Iq.aKw;
                a.this.aFN.aKx = Iq.aKx;
                a.this.aFN.aKy = Iq.aKy;
                a.this.aFN.aKz = Iq.aKz;
                a.this.aFN.countDown = Iq.countDown;
                if (Iq.url != null) {
                    a.this.aFN.url = Iq.url;
                }
                if (Iq.aKt != null) {
                    a.this.aFN.aKt = Iq.aKt;
                }
                if (Iq.aKF != null && Iq.aKF.aPa != null && !Iq.aKF.aPa.isEmpty()) {
                    a.this.aFN.aKF = Iq.aKF;
                }
                if (Iq.aKr != null) {
                    if (Iq.aKr.userId == 0) {
                        if (a.this.aFN.aKr == null) {
                            a.this.aFN.aKr = new AlaLiveUserInfoData();
                        }
                        a.this.aFN.aKr.throneUid = Iq.aKr.throneUid;
                    } else {
                        boolean z = Iq.aKr.isNewUser;
                        if (a.this.aFN.aKr != null) {
                            z = a.this.aFN.aKr.isNewUser;
                        }
                        Iq.aKr.isNewUser = z;
                        a.this.aFN.aKr = Iq.aKr;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aFN.aKr.nickName);
                    }
                }
                if (Iq.aKu != null) {
                    a.this.aFN.aKu = Iq.aKu;
                }
                if (Iq.aKA) {
                    a.this.aFN.aKB = Iq.aKB;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aFN);
                a.this.P(a.this.aFN);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aFN));
                if (a.this.aFN != null) {
                    com.baidu.live.im.b.d.NK().V(a.this.aFN.aKB);
                }
            }
        }
    };
    private Runnable hyg = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cjg();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void P(w wVar) {
        if (wVar != null && this.hyd) {
            this.mHandler.removeCallbacks(this.hyg);
            this.mHandler.postDelayed(this.hyg, wVar.aKa);
        }
    }

    public void cjf() {
        this.mHandler.removeCallbacks(this.hyg);
    }

    public void a(w wVar, String str, long j) {
        this.aFN = wVar;
        this.brs = str;
        this.huW = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.hyf);
        this.hyd = true;
        P(this.aFN);
    }

    public void stop() {
        this.hyd = false;
        MessageManager.getInstance().unRegisterListener(this.hyf);
        cjf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjg() {
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            a(this.aFN.mLiveInfo.live_id, this.brs, this.huW);
        }
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c();
        cVar.setLiveId(j);
        cVar.setFrom(str);
        cVar.aZ(j2);
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
        this.hvg = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hvg != null) {
            this.hvg.a(i, str, i2, obj);
        }
    }
}
