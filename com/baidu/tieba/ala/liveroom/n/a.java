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
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private ab aDd;
    private String buO;
    private long hGJ;
    private d.a hGT;
    private boolean hJV;
    private long hJW;
    private Handler mHandler = new Handler();
    private HttpMessageListener hJX = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.n.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                ab Fm = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).Fm() : null;
                a.this.hJW = System.currentTimeMillis();
                if (Fm == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, Fm);
                    return;
                }
                if (a.this.aDd == null) {
                    a.this.aDd = Fm;
                } else if (a.this.aDd.mLiveInfo != null && Fm.mLiveInfo != null && a.this.aDd.mLiveInfo.live_id != Fm.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDd);
                    return;
                }
                if (a.this.aDd.mLiveInfo != null && Fm.mLiveInfo != null && a.this.aDd.mLiveInfo.user_id == Fm.mLiveInfo.user_id) {
                    if (a.this.aDd.mLiveInfo.imEffect != null && Fm.mLiveInfo.imEffect == null) {
                        Fm.mLiveInfo.imEffect = a.this.aDd.mLiveInfo.imEffect;
                    }
                    if (a.this.aDd.mLiveInfo.mLiveCloseData != null && Fm.mLiveInfo.mLiveCloseData == null) {
                        Fm.mLiveInfo.mLiveCloseData = a.this.aDd.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aDd.mLiveInfo.mAlaLiveSwitchData != null && Fm.mLiveInfo.mAlaLiveSwitchData == null) {
                        Fm.mLiveInfo.mAlaLiveSwitchData = a.this.aDd.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aDd.mLiveInfo = Fm.mLiveInfo;
                a.this.aDd.serverTime = Fm.serverTime;
                a.this.aDd.aIW = Fm.aIW;
                a.this.aDd.aId = Fm.aId;
                a.this.aDd.aIe = Fm.aIe;
                a.this.aDd.aIi = Fm.aIi;
                a.this.aDd.aIL = Fm.aIL;
                a.this.aDd.aIJ = Fm.aIJ;
                a.this.aDd.aIE = Fm.aIE;
                a.this.aDd.aIF = Fm.aIF;
                a.this.aDd.aIG = Fm.aIG;
                a.this.aDd.aIH = Fm.aIH;
                a.this.aDd.aII = Fm.aII;
                a.this.aDd.countDown = Fm.countDown;
                if (Fm.url != null) {
                    a.this.aDd.url = Fm.url;
                }
                if (Fm.aIB != null) {
                    a.this.aDd.aIB = Fm.aIB;
                }
                if (Fm.aIO != null && Fm.aIO.aNQ != null && !Fm.aIO.aNQ.isEmpty()) {
                    a.this.aDd.aIO = Fm.aIO;
                }
                if (Fm.aIz != null) {
                    if (Fm.aIz.userId == 0) {
                        if (a.this.aDd.aIz == null) {
                            a.this.aDd.aIz = new AlaLiveUserInfoData();
                        }
                        a.this.aDd.aIz.throneUid = Fm.aIz.throneUid;
                    } else {
                        boolean z = Fm.aIz.isNewUser;
                        if (a.this.aDd.aIz != null) {
                            z = a.this.aDd.aIz.isNewUser;
                        }
                        Fm.aIz.isNewUser = z;
                        a.this.aDd.aIz = Fm.aIz;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aDd.aIz.nickName);
                    }
                }
                if (Fm.aIC != null) {
                    a.this.aDd.aIC = Fm.aIC;
                }
                if (Fm.aIJ) {
                    a.this.aDd.aIK = Fm.aIK;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aDd);
                a.this.R(a.this.aDd);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aDd));
                if (a.this.aDd != null) {
                    com.baidu.live.im.b.d.KN().W(a.this.aDd.aIK);
                }
            }
        }
    };
    private Runnable hJY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.n.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cjb();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void R(ab abVar) {
        if (abVar != null && this.hJV) {
            this.mHandler.removeCallbacks(this.hJY);
            this.mHandler.postDelayed(this.hJY, abVar.aIi);
        }
    }

    public void cja() {
        this.mHandler.removeCallbacks(this.hJY);
    }

    public void a(ab abVar, String str, long j) {
        this.aDd = abVar;
        this.buO = str;
        this.hGJ = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.hJX);
        this.hJV = true;
        R(this.aDd);
    }

    public void stop() {
        this.hJV = false;
        MessageManager.getInstance().unRegisterListener(this.hJX);
        cja();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjb() {
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            a(this.aDd.mLiveInfo.live_id, this.buO, this.hGJ);
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
        this.hGT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hGT != null) {
            this.hGT.a(i, str, i2, obj);
        }
    }
}
