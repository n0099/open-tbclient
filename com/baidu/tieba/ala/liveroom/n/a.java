package com.baidu.tieba.ala.liveroom.n;

import android.os.Handler;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.n.d;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private ab aED;
    private String bwo;
    private d.a hIC;
    private long hIs;
    private boolean hLE;
    private long hLF;
    private Handler mHandler = new Handler();
    private HttpMessageListener hLG = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.n.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                ab Fp = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).Fp() : null;
                a.this.hLF = System.currentTimeMillis();
                if (Fp == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Fp);
                    return;
                }
                if (a.this.aED == null) {
                    a.this.aED = Fp;
                } else if (a.this.aED.mLiveInfo != null && Fp.mLiveInfo != null && a.this.aED.mLiveInfo.live_id != Fp.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aED);
                    return;
                }
                if (a.this.aED.mLiveInfo != null && Fp.mLiveInfo != null && a.this.aED.mLiveInfo.user_id == Fp.mLiveInfo.user_id) {
                    if (a.this.aED.mLiveInfo.imEffect != null && Fp.mLiveInfo.imEffect == null) {
                        Fp.mLiveInfo.imEffect = a.this.aED.mLiveInfo.imEffect;
                    }
                    if (a.this.aED.mLiveInfo.mLiveCloseData != null && Fp.mLiveInfo.mLiveCloseData == null) {
                        Fp.mLiveInfo.mLiveCloseData = a.this.aED.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aED.mLiveInfo.mAlaLiveSwitchData != null && Fp.mLiveInfo.mAlaLiveSwitchData == null) {
                        Fp.mLiveInfo.mAlaLiveSwitchData = a.this.aED.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aED.mLiveInfo = Fp.mLiveInfo;
                a.this.aED.serverTime = Fp.serverTime;
                a.this.aED.aKw = Fp.aKw;
                a.this.aED.aJD = Fp.aJD;
                a.this.aED.aJE = Fp.aJE;
                a.this.aED.aJI = Fp.aJI;
                a.this.aED.aKl = Fp.aKl;
                a.this.aED.aKj = Fp.aKj;
                a.this.aED.aKe = Fp.aKe;
                a.this.aED.aKf = Fp.aKf;
                a.this.aED.aKg = Fp.aKg;
                a.this.aED.aKh = Fp.aKh;
                a.this.aED.aKi = Fp.aKi;
                a.this.aED.countDown = Fp.countDown;
                if (Fp.url != null) {
                    a.this.aED.url = Fp.url;
                }
                if (Fp.aKb != null) {
                    a.this.aED.aKb = Fp.aKb;
                }
                if (Fp.aKo != null && Fp.aKo.aPq != null && !Fp.aKo.aPq.isEmpty()) {
                    a.this.aED.aKo = Fp.aKo;
                }
                if (Fp.aJZ != null) {
                    if (Fp.aJZ.userId == 0) {
                        if (a.this.aED.aJZ == null) {
                            a.this.aED.aJZ = new AlaLiveUserInfoData();
                        }
                        a.this.aED.aJZ.throneUid = Fp.aJZ.throneUid;
                    } else {
                        boolean z = Fp.aJZ.isNewUser;
                        if (a.this.aED.aJZ != null) {
                            z = a.this.aED.aJZ.isNewUser;
                        }
                        Fp.aJZ.isNewUser = z;
                        a.this.aED.aJZ = Fp.aJZ;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aED.aJZ.nickName);
                    }
                }
                if (Fp.aKc != null) {
                    a.this.aED.aKc = Fp.aKc;
                }
                if (Fp.aKj) {
                    a.this.aED.aKk = Fp.aKk;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aED);
                a.this.R(a.this.aED);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aED));
                if (a.this.aED != null) {
                    com.baidu.live.im.b.d.KQ().W(a.this.aED.aKk);
                }
            }
        }
    };
    private Runnable hLH = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cjh();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ab abVar) {
        if (abVar != null && this.hLE) {
            this.mHandler.removeCallbacks(this.hLH);
            this.mHandler.postDelayed(this.hLH, abVar.aJI);
        }
    }

    public void cjg() {
        this.mHandler.removeCallbacks(this.hLH);
    }

    public void a(ab abVar, String str, long j) {
        this.aED = abVar;
        this.bwo = str;
        this.hIs = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.hLG);
        this.hLE = true;
        R(this.aED);
    }

    public void stop() {
        this.hLE = false;
        MessageManager.getInstance().unRegisterListener(this.hLG);
        cjg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjh() {
        if (this.aED != null && this.aED.mLiveInfo != null) {
            a(this.aED.mLiveInfo.live_id, this.bwo, this.hIs);
        }
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c();
        cVar.setLiveId(j);
        cVar.setFrom(str);
        cVar.bd(j2);
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
        this.hIC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hIC != null) {
            this.hIC.a(i, str, i2, obj);
        }
    }
}
