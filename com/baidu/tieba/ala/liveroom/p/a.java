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
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private x aBr;
    private String brl;
    private long hCm;
    private d.a hCw;
    private boolean hFv;
    private long hFw;
    private Handler mHandler = new Handler();
    private HttpMessageListener hFx = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.p.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                x DW = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).DW() : null;
                a.this.hFw = System.currentTimeMillis();
                if (DW == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, DW);
                    return;
                }
                if (a.this.aBr == null) {
                    a.this.aBr = DW;
                } else if (a.this.aBr.mLiveInfo != null && DW.mLiveInfo != null && a.this.aBr.mLiveInfo.live_id != DW.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aBr);
                    return;
                }
                if (a.this.aBr.mLiveInfo != null && DW.mLiveInfo != null && a.this.aBr.mLiveInfo.user_id == DW.mLiveInfo.user_id) {
                    if (a.this.aBr.mLiveInfo.imEffect != null && DW.mLiveInfo.imEffect == null) {
                        DW.mLiveInfo.imEffect = a.this.aBr.mLiveInfo.imEffect;
                    }
                    if (a.this.aBr.mLiveInfo.mLiveCloseData != null && DW.mLiveInfo.mLiveCloseData == null) {
                        DW.mLiveInfo.mLiveCloseData = a.this.aBr.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aBr.mLiveInfo.mAlaLiveSwitchData != null && DW.mLiveInfo.mAlaLiveSwitchData == null) {
                        DW.mLiveInfo.mAlaLiveSwitchData = a.this.aBr.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aBr.mLiveInfo = DW.mLiveInfo;
                a.this.aBr.serverTime = DW.serverTime;
                a.this.aBr.aGA = DW.aGA;
                a.this.aBr.aFH = DW.aFH;
                a.this.aBr.aFI = DW.aFI;
                a.this.aBr.aFM = DW.aFM;
                a.this.aBr.aGp = DW.aGp;
                a.this.aBr.aGn = DW.aGn;
                a.this.aBr.aGi = DW.aGi;
                a.this.aBr.aGj = DW.aGj;
                a.this.aBr.aGk = DW.aGk;
                a.this.aBr.aGl = DW.aGl;
                a.this.aBr.aGm = DW.aGm;
                a.this.aBr.countDown = DW.countDown;
                if (DW.url != null) {
                    a.this.aBr.url = DW.url;
                }
                if (DW.aGf != null) {
                    a.this.aBr.aGf = DW.aGf;
                }
                if (DW.aGs != null && DW.aGs.aKU != null && !DW.aGs.aKU.isEmpty()) {
                    a.this.aBr.aGs = DW.aGs;
                }
                if (DW.aGd != null) {
                    if (DW.aGd.userId == 0) {
                        if (a.this.aBr.aGd == null) {
                            a.this.aBr.aGd = new AlaLiveUserInfoData();
                        }
                        a.this.aBr.aGd.throneUid = DW.aGd.throneUid;
                    } else {
                        boolean z = DW.aGd.isNewUser;
                        if (a.this.aBr.aGd != null) {
                            z = a.this.aBr.aGd.isNewUser;
                        }
                        DW.aGd.isNewUser = z;
                        a.this.aBr.aGd = DW.aGd;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aBr.aGd.nickName);
                    }
                }
                if (DW.aGg != null) {
                    a.this.aBr.aGg = DW.aGg;
                }
                if (DW.aGn) {
                    a.this.aBr.aGo = DW.aGo;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aBr);
                a.this.P(a.this.aBr);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aBr));
                if (a.this.aBr != null) {
                    com.baidu.live.im.b.d.Jp().V(a.this.aBr.aGo);
                }
            }
        }
    };
    private Runnable hFy = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cib();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void P(x xVar) {
        if (xVar != null && this.hFv) {
            this.mHandler.removeCallbacks(this.hFy);
            this.mHandler.postDelayed(this.hFy, xVar.aFM);
        }
    }

    public void cia() {
        this.mHandler.removeCallbacks(this.hFy);
    }

    public void a(x xVar, String str, long j) {
        this.aBr = xVar;
        this.brl = str;
        this.hCm = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.hFx);
        this.hFv = true;
        P(this.aBr);
    }

    public void stop() {
        this.hFv = false;
        MessageManager.getInstance().unRegisterListener(this.hFx);
        cia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cib() {
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            a(this.aBr.mLiveInfo.live_id, this.brl, this.hCm);
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
        this.hCw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hCw != null) {
            this.hCw.a(i, str, i2, obj);
        }
    }
}
