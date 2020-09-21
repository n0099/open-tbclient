package com.baidu.tieba.ala.liveroom.q;

import android.os.Handler;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.u;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.q.d;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private u aAP;
    private String bhq;
    private long gFI;
    private d.a gFS;
    private boolean gIJ;
    private long gIK;
    private Handler mHandler = new Handler();
    private HttpMessageListener gIL = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.q.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                u Fq = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).Fq() : null;
                a.this.gIK = System.currentTimeMillis();
                if (Fq == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Fq);
                    return;
                }
                if (a.this.aAP == null) {
                    a.this.aAP = Fq;
                } else if (a.this.aAP.mLiveInfo != null && Fq.mLiveInfo != null && a.this.aAP.mLiveInfo.live_id != Fq.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aAP);
                    return;
                }
                if (a.this.aAP.mLiveInfo != null && Fq.mLiveInfo != null && a.this.aAP.mLiveInfo.user_id == Fq.mLiveInfo.user_id) {
                    if (a.this.aAP.mLiveInfo.imEffect != null && Fq.mLiveInfo.imEffect == null) {
                        Fq.mLiveInfo.imEffect = a.this.aAP.mLiveInfo.imEffect;
                    }
                    if (a.this.aAP.mLiveInfo.mLiveCloseData != null && Fq.mLiveInfo.mLiveCloseData == null) {
                        Fq.mLiveInfo.mLiveCloseData = a.this.aAP.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aAP.mLiveInfo.mAlaLiveSwitchData != null && Fq.mLiveInfo.mAlaLiveSwitchData == null) {
                        Fq.mLiveInfo.mAlaLiveSwitchData = a.this.aAP.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aAP.mLiveInfo = Fq.mLiveInfo;
                a.this.aAP.aFs = Fq.aFs;
                a.this.aAP.aEz = Fq.aEz;
                a.this.aAP.aEA = Fq.aEA;
                a.this.aAP.aEE = Fq.aEE;
                a.this.aAP.aFj = Fq.aFj;
                a.this.aAP.aFh = Fq.aFh;
                a.this.aAP.aFe = Fq.aFe;
                a.this.aAP.aFf = Fq.aFf;
                if (Fq.aFm != null && Fq.aFm.aJc != null && !Fq.aFm.aJc.isEmpty()) {
                    a.this.aAP.aFm = Fq.aFm;
                }
                if (Fq.aFb != null) {
                    if (Fq.aFb.userId == 0) {
                        if (a.this.aAP.aFb == null) {
                            a.this.aAP.aFb = new AlaLiveUserInfoData();
                        }
                        a.this.aAP.aFb.throneUid = Fq.aFb.throneUid;
                    } else {
                        boolean z = Fq.aFb.isNewUser;
                        if (a.this.aAP.aFb != null) {
                            z = a.this.aAP.aFb.isNewUser;
                        }
                        Fq.aFb.isNewUser = z;
                        a.this.aAP.aFb = Fq.aFb;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aAP.aFb.nickName);
                    }
                }
                if (Fq.aFd != null) {
                    a.this.aAP.aFd = Fq.aFd;
                }
                if (Fq.aFh) {
                    a.this.aAP.aFi = Fq.aFi;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aAP);
                a.this.B(a.this.aAP);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aAP));
                if (a.this.aAP != null) {
                    com.baidu.live.im.b.d.Kh().R(a.this.aAP.aFi);
                }
            }
        }
    };
    private Runnable gIM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bWS();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void B(u uVar) {
        if (uVar != null && this.gIJ) {
            this.mHandler.removeCallbacks(this.gIM);
            this.mHandler.postDelayed(this.gIM, uVar.aEE);
        }
    }

    public void bWR() {
        this.mHandler.removeCallbacks(this.gIM);
    }

    public void a(u uVar, String str, long j) {
        this.aAP = uVar;
        this.bhq = str;
        this.gFI = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.gIL);
        this.gIJ = true;
        B(this.aAP);
    }

    public void stop() {
        this.gIJ = false;
        MessageManager.getInstance().unRegisterListener(this.gIL);
        bWR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWS() {
        if (this.aAP != null && this.aAP.mLiveInfo != null) {
            a(this.aAP.mLiveInfo.live_id, this.bhq, this.gFI);
        }
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.setFrom(str);
        bVar.an(j2);
        bVar.setParams();
        sendMessage(bVar);
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
        this.gFS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.gFS != null) {
            this.gFS.a(i, str, i2, obj);
        }
    }
}
