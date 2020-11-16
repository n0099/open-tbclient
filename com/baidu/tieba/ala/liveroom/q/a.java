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
    private w aDh;
    private String bml;
    private d.a hlF;
    private long hlv;
    private boolean hox;
    private long hoy;
    private Handler mHandler = new Handler();
    private HttpMessageListener hoz = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.q.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                w Gz = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).Gz() : null;
                a.this.hoy = System.currentTimeMillis();
                if (Gz == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Gz);
                    return;
                }
                if (a.this.aDh == null) {
                    a.this.aDh = Gz;
                } else if (a.this.aDh.mLiveInfo != null && Gz.mLiveInfo != null && a.this.aDh.mLiveInfo.live_id != Gz.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDh);
                    return;
                }
                if (a.this.aDh.mLiveInfo != null && Gz.mLiveInfo != null && a.this.aDh.mLiveInfo.user_id == Gz.mLiveInfo.user_id) {
                    if (a.this.aDh.mLiveInfo.imEffect != null && Gz.mLiveInfo.imEffect == null) {
                        Gz.mLiveInfo.imEffect = a.this.aDh.mLiveInfo.imEffect;
                    }
                    if (a.this.aDh.mLiveInfo.mLiveCloseData != null && Gz.mLiveInfo.mLiveCloseData == null) {
                        Gz.mLiveInfo.mLiveCloseData = a.this.aDh.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aDh.mLiveInfo.mAlaLiveSwitchData != null && Gz.mLiveInfo.mAlaLiveSwitchData == null) {
                        Gz.mLiveInfo.mAlaLiveSwitchData = a.this.aDh.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aDh.mLiveInfo = Gz.mLiveInfo;
                a.this.aDh.serverTime = Gz.serverTime;
                a.this.aDh.aIb = Gz.aIb;
                a.this.aDh.aHk = Gz.aHk;
                a.this.aDh.aHl = Gz.aHl;
                a.this.aDh.aHp = Gz.aHp;
                a.this.aDh.aHQ = Gz.aHQ;
                a.this.aDh.aHO = Gz.aHO;
                a.this.aDh.aHL = Gz.aHL;
                a.this.aDh.aHM = Gz.aHM;
                a.this.aDh.aHN = Gz.aHN;
                if (Gz.aHI != null) {
                    a.this.aDh.aHI = Gz.aHI;
                }
                if (Gz.aHT != null && Gz.aHT.aMd != null && !Gz.aHT.aMd.isEmpty()) {
                    a.this.aDh.aHT = Gz.aHT;
                }
                if (Gz.aHG != null) {
                    if (Gz.aHG.userId == 0) {
                        if (a.this.aDh.aHG == null) {
                            a.this.aDh.aHG = new AlaLiveUserInfoData();
                        }
                        a.this.aDh.aHG.throneUid = Gz.aHG.throneUid;
                    } else {
                        boolean z = Gz.aHG.isNewUser;
                        if (a.this.aDh.aHG != null) {
                            z = a.this.aDh.aHG.isNewUser;
                        }
                        Gz.aHG.isNewUser = z;
                        a.this.aDh.aHG = Gz.aHG;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aDh.aHG.nickName);
                    }
                }
                if (Gz.aHK != null) {
                    a.this.aDh.aHK = Gz.aHK;
                }
                if (Gz.aHO) {
                    a.this.aDh.aHP = Gz.aHP;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDh);
                a.this.K(a.this.aDh);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aDh));
                if (a.this.aDh != null) {
                    com.baidu.live.im.b.d.Lx().U(a.this.aDh.aHP);
                }
            }
        }
    };
    private Runnable hoA = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cfl();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void K(w wVar) {
        if (wVar != null && this.hox) {
            this.mHandler.removeCallbacks(this.hoA);
            this.mHandler.postDelayed(this.hoA, wVar.aHp);
        }
    }

    public void cfk() {
        this.mHandler.removeCallbacks(this.hoA);
    }

    public void a(w wVar, String str, long j) {
        this.aDh = wVar;
        this.bml = str;
        this.hlv = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.hoz);
        this.hox = true;
        K(this.aDh);
    }

    public void stop() {
        this.hox = false;
        MessageManager.getInstance().unRegisterListener(this.hoz);
        cfk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfl() {
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            a(this.aDh.mLiveInfo.live_id, this.bml, this.hlv);
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
        this.hlF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hlF != null) {
            this.hlF.a(i, str, i2, obj);
        }
    }
}
