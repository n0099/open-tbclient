package com.baidu.tieba.ala.liveroom.p;

import android.os.Handler;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.x;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.p.d;
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private x aGe;
    private String bvZ;
    private long hGS;
    private d.a hHc;
    private boolean hKb;
    private long hKc;
    private Handler mHandler = new Handler();
    private HttpMessageListener hKd = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.p.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                x HR = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).HR() : null;
                a.this.hKc = System.currentTimeMillis();
                if (HR == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, HR);
                    return;
                }
                if (a.this.aGe == null) {
                    a.this.aGe = HR;
                } else if (a.this.aGe.mLiveInfo != null && HR.mLiveInfo != null && a.this.aGe.mLiveInfo.live_id != HR.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aGe);
                    return;
                }
                if (a.this.aGe.mLiveInfo != null && HR.mLiveInfo != null && a.this.aGe.mLiveInfo.user_id == HR.mLiveInfo.user_id) {
                    if (a.this.aGe.mLiveInfo.imEffect != null && HR.mLiveInfo.imEffect == null) {
                        HR.mLiveInfo.imEffect = a.this.aGe.mLiveInfo.imEffect;
                    }
                    if (a.this.aGe.mLiveInfo.mLiveCloseData != null && HR.mLiveInfo.mLiveCloseData == null) {
                        HR.mLiveInfo.mLiveCloseData = a.this.aGe.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aGe.mLiveInfo.mAlaLiveSwitchData != null && HR.mLiveInfo.mAlaLiveSwitchData == null) {
                        HR.mLiveInfo.mAlaLiveSwitchData = a.this.aGe.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aGe.mLiveInfo = HR.mLiveInfo;
                a.this.aGe.serverTime = HR.serverTime;
                a.this.aGe.aLn = HR.aLn;
                a.this.aGe.aKu = HR.aKu;
                a.this.aGe.aKv = HR.aKv;
                a.this.aGe.aKz = HR.aKz;
                a.this.aGe.aLc = HR.aLc;
                a.this.aGe.aLa = HR.aLa;
                a.this.aGe.aKV = HR.aKV;
                a.this.aGe.aKW = HR.aKW;
                a.this.aGe.aKX = HR.aKX;
                a.this.aGe.aKY = HR.aKY;
                a.this.aGe.aKZ = HR.aKZ;
                a.this.aGe.countDown = HR.countDown;
                if (HR.url != null) {
                    a.this.aGe.url = HR.url;
                }
                if (HR.aKS != null) {
                    a.this.aGe.aKS = HR.aKS;
                }
                if (HR.aLf != null && HR.aLf.aPH != null && !HR.aLf.aPH.isEmpty()) {
                    a.this.aGe.aLf = HR.aLf;
                }
                if (HR.aKQ != null) {
                    if (HR.aKQ.userId == 0) {
                        if (a.this.aGe.aKQ == null) {
                            a.this.aGe.aKQ = new AlaLiveUserInfoData();
                        }
                        a.this.aGe.aKQ.throneUid = HR.aKQ.throneUid;
                    } else {
                        boolean z = HR.aKQ.isNewUser;
                        if (a.this.aGe.aKQ != null) {
                            z = a.this.aGe.aKQ.isNewUser;
                        }
                        HR.aKQ.isNewUser = z;
                        a.this.aGe.aKQ = HR.aKQ;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aGe.aKQ.nickName);
                    }
                }
                if (HR.aKT != null) {
                    a.this.aGe.aKT = HR.aKT;
                }
                if (HR.aLa) {
                    a.this.aGe.aLb = HR.aLb;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aGe);
                a.this.P(a.this.aGe);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aGe));
                if (a.this.aGe != null) {
                    com.baidu.live.im.b.d.Nk().V(a.this.aGe.aLb);
                }
            }
        }
    };
    private Runnable hKe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.clT();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void P(x xVar) {
        if (xVar != null && this.hKb) {
            this.mHandler.removeCallbacks(this.hKe);
            this.mHandler.postDelayed(this.hKe, xVar.aKz);
        }
    }

    public void clS() {
        this.mHandler.removeCallbacks(this.hKe);
    }

    public void a(x xVar, String str, long j) {
        this.aGe = xVar;
        this.bvZ = str;
        this.hGS = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.hKd);
        this.hKb = true;
        P(this.aGe);
    }

    public void stop() {
        this.hKb = false;
        MessageManager.getInstance().unRegisterListener(this.hKd);
        clS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clT() {
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            a(this.aGe.mLiveInfo.live_id, this.bvZ, this.hGS);
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
        this.hHc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hHc != null) {
            this.hHc.a(i, str, i2, obj);
        }
    }
}
