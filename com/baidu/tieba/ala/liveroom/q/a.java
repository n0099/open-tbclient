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
    private u aDU;
    private String blg;
    private long gUg;
    private d.a gUq;
    private boolean gXj;
    private long gXk;
    private Handler mHandler = new Handler();
    private HttpMessageListener gXl = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.q.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                u Gm = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).Gm() : null;
                a.this.gXk = System.currentTimeMillis();
                if (Gm == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Gm);
                    return;
                }
                if (a.this.aDU == null) {
                    a.this.aDU = Gm;
                } else if (a.this.aDU.mLiveInfo != null && Gm.mLiveInfo != null && a.this.aDU.mLiveInfo.live_id != Gm.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDU);
                    return;
                }
                if (a.this.aDU.mLiveInfo != null && Gm.mLiveInfo != null && a.this.aDU.mLiveInfo.user_id == Gm.mLiveInfo.user_id) {
                    if (a.this.aDU.mLiveInfo.imEffect != null && Gm.mLiveInfo.imEffect == null) {
                        Gm.mLiveInfo.imEffect = a.this.aDU.mLiveInfo.imEffect;
                    }
                    if (a.this.aDU.mLiveInfo.mLiveCloseData != null && Gm.mLiveInfo.mLiveCloseData == null) {
                        Gm.mLiveInfo.mLiveCloseData = a.this.aDU.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aDU.mLiveInfo.mAlaLiveSwitchData != null && Gm.mLiveInfo.mAlaLiveSwitchData == null) {
                        Gm.mLiveInfo.mAlaLiveSwitchData = a.this.aDU.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aDU.mLiveInfo = Gm.mLiveInfo;
                a.this.aDU.aIw = Gm.aIw;
                a.this.aDU.aHD = Gm.aHD;
                a.this.aDU.aHE = Gm.aHE;
                a.this.aDU.aHI = Gm.aHI;
                a.this.aDU.aIn = Gm.aIn;
                a.this.aDU.aIl = Gm.aIl;
                a.this.aDU.aIi = Gm.aIi;
                a.this.aDU.aIj = Gm.aIj;
                if (Gm.aIq != null && Gm.aIq.aMh != null && !Gm.aIq.aMh.isEmpty()) {
                    a.this.aDU.aIq = Gm.aIq;
                }
                if (Gm.aIf != null) {
                    if (Gm.aIf.userId == 0) {
                        if (a.this.aDU.aIf == null) {
                            a.this.aDU.aIf = new AlaLiveUserInfoData();
                        }
                        a.this.aDU.aIf.throneUid = Gm.aIf.throneUid;
                    } else {
                        boolean z = Gm.aIf.isNewUser;
                        if (a.this.aDU.aIf != null) {
                            z = a.this.aDU.aIf.isNewUser;
                        }
                        Gm.aIf.isNewUser = z;
                        a.this.aDU.aIf = Gm.aIf;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aDU.aIf.nickName);
                    }
                }
                if (Gm.aIh != null) {
                    a.this.aDU.aIh = Gm.aIh;
                }
                if (Gm.aIl) {
                    a.this.aDU.aIm = Gm.aIm;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDU);
                a.this.C(a.this.aDU);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aDU));
                if (a.this.aDU != null) {
                    com.baidu.live.im.b.d.Lm().T(a.this.aDU.aIm);
                }
            }
        }
    };
    private Runnable gXm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.can();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void C(u uVar) {
        if (uVar != null && this.gXj) {
            this.mHandler.removeCallbacks(this.gXm);
            this.mHandler.postDelayed(this.gXm, uVar.aHI);
        }
    }

    public void cam() {
        this.mHandler.removeCallbacks(this.gXm);
    }

    public void a(u uVar, String str, long j) {
        this.aDU = uVar;
        this.blg = str;
        this.gUg = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.gXl);
        this.gXj = true;
        C(this.aDU);
    }

    public void stop() {
        this.gXj = false;
        MessageManager.getInstance().unRegisterListener(this.gXl);
        cam();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void can() {
        if (this.aDU != null && this.aDU.mLiveInfo != null) {
            a(this.aDU.mLiveInfo.live_id, this.blg, this.gUg);
        }
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.b bVar = new com.baidu.live.message.b();
        bVar.setLiveId(j);
        bVar.setFrom(str);
        bVar.ao(j2);
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
        this.gUq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.gUq != null) {
            this.gUq.a(i, str, i2, obj);
        }
    }
}
