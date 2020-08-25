package com.baidu.tieba.ala.liveroom.p;

import android.os.Handler;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.r;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.p.d;
/* loaded from: classes7.dex */
public class a extends BdBaseModel {
    private r aAh;
    private String bev;
    private long gCf;
    private d.a gCp;
    private boolean gFh;
    private long gFi;
    private Handler mHandler = new Handler();
    private HttpMessageListener gFj = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.p.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                r LC = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).LC() : null;
                a.this.gFi = System.currentTimeMillis();
                if (LC == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, LC);
                    return;
                }
                if (a.this.aAh == null) {
                    a.this.aAh = LC;
                } else if (a.this.aAh.mLiveInfo != null && LC.mLiveInfo != null && a.this.aAh.mLiveInfo.live_id != LC.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aAh);
                    return;
                }
                if (a.this.aAh.mLiveInfo != null && LC.mLiveInfo != null && a.this.aAh.mLiveInfo.user_id == LC.mLiveInfo.user_id) {
                    if (a.this.aAh.mLiveInfo.imEffect != null && LC.mLiveInfo.imEffect == null) {
                        LC.mLiveInfo.imEffect = a.this.aAh.mLiveInfo.imEffect;
                    }
                    if (a.this.aAh.mLiveInfo.mLiveCloseData != null && LC.mLiveInfo.mLiveCloseData == null) {
                        LC.mLiveInfo.mLiveCloseData = a.this.aAh.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aAh.mLiveInfo.mAlaLiveSwitchData != null && LC.mLiveInfo.mAlaLiveSwitchData == null) {
                        LC.mLiveInfo.mAlaLiveSwitchData = a.this.aAh.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aAh.mLiveInfo = LC.mLiveInfo;
                a.this.aAh.aEr = LC.aEr;
                a.this.aAh.aDE = LC.aDE;
                a.this.aAh.aDF = LC.aDF;
                a.this.aAh.aDI = LC.aDI;
                a.this.aAh.aEj = LC.aEj;
                a.this.aAh.aEh = LC.aEh;
                a.this.aAh.aEg = LC.aEg;
                if (LC.aEn != null && LC.aEn.aHG != null && !LC.aEn.aHG.isEmpty()) {
                    a.this.aAh.aEn = LC.aEn;
                }
                if (LC.aEd != null) {
                    if (LC.aEd.userId == 0) {
                        if (a.this.aAh.aEd == null) {
                            a.this.aAh.aEd = new AlaLiveUserInfoData();
                        }
                        a.this.aAh.aEd.throneUid = LC.aEd.throneUid;
                    } else {
                        boolean z = LC.aEd.isNewUser;
                        if (a.this.aAh.aEd != null) {
                            z = a.this.aAh.aEd.isNewUser;
                        }
                        LC.aEd.isNewUser = z;
                        a.this.aAh.aEd = LC.aEd;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aAh.aEd.nickName);
                    }
                }
                if (LC.aEf != null) {
                    a.this.aAh.aEf = LC.aEf;
                }
                if (LC.aEh) {
                    a.this.aAh.aEi = LC.aEi;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aAh);
                a.this.y(a.this.aAh);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aAh));
                if (a.this.aAh != null) {
                    com.baidu.live.im.b.d.JD().O(a.this.aAh.aEi);
                }
            }
        }
    };
    private Runnable gFk = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bVh();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void y(r rVar) {
        if (rVar != null && this.gFh) {
            this.mHandler.removeCallbacks(this.gFk);
            this.mHandler.postDelayed(this.gFk, rVar.aDI);
        }
    }

    public void bVg() {
        this.mHandler.removeCallbacks(this.gFk);
    }

    public void a(r rVar, String str, long j) {
        this.aAh = rVar;
        this.bev = str;
        this.gCf = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.gFj);
        this.gFh = true;
        y(this.aAh);
    }

    public void stop() {
        this.gFh = false;
        MessageManager.getInstance().unRegisterListener(this.gFj);
        bVg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVh() {
        if (this.aAh != null && this.aAh.mLiveInfo != null) {
            a(this.aAh.mLiveInfo.live_id, this.bev, this.gCf);
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
        this.gCp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.gCp != null) {
            this.gCp.a(i, str, i2, obj);
        }
    }
}
