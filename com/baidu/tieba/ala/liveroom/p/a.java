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
    private r aAj;
    private String bex;
    private long gCj;
    private d.a gCt;
    private boolean gFl;
    private long gFm;
    private Handler mHandler = new Handler();
    private HttpMessageListener gFn = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.p.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                r LC = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).LC() : null;
                a.this.gFm = System.currentTimeMillis();
                if (LC == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, LC);
                    return;
                }
                if (a.this.aAj == null) {
                    a.this.aAj = LC;
                } else if (a.this.aAj.mLiveInfo != null && LC.mLiveInfo != null && a.this.aAj.mLiveInfo.live_id != LC.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aAj);
                    return;
                }
                if (a.this.aAj.mLiveInfo != null && LC.mLiveInfo != null && a.this.aAj.mLiveInfo.user_id == LC.mLiveInfo.user_id) {
                    if (a.this.aAj.mLiveInfo.imEffect != null && LC.mLiveInfo.imEffect == null) {
                        LC.mLiveInfo.imEffect = a.this.aAj.mLiveInfo.imEffect;
                    }
                    if (a.this.aAj.mLiveInfo.mLiveCloseData != null && LC.mLiveInfo.mLiveCloseData == null) {
                        LC.mLiveInfo.mLiveCloseData = a.this.aAj.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aAj.mLiveInfo.mAlaLiveSwitchData != null && LC.mLiveInfo.mAlaLiveSwitchData == null) {
                        LC.mLiveInfo.mAlaLiveSwitchData = a.this.aAj.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aAj.mLiveInfo = LC.mLiveInfo;
                a.this.aAj.aEt = LC.aEt;
                a.this.aAj.aDG = LC.aDG;
                a.this.aAj.aDH = LC.aDH;
                a.this.aAj.aDK = LC.aDK;
                a.this.aAj.aEl = LC.aEl;
                a.this.aAj.aEj = LC.aEj;
                a.this.aAj.aEi = LC.aEi;
                if (LC.aEp != null && LC.aEp.aHI != null && !LC.aEp.aHI.isEmpty()) {
                    a.this.aAj.aEp = LC.aEp;
                }
                if (LC.aEf != null) {
                    if (LC.aEf.userId == 0) {
                        if (a.this.aAj.aEf == null) {
                            a.this.aAj.aEf = new AlaLiveUserInfoData();
                        }
                        a.this.aAj.aEf.throneUid = LC.aEf.throneUid;
                    } else {
                        boolean z = LC.aEf.isNewUser;
                        if (a.this.aAj.aEf != null) {
                            z = a.this.aAj.aEf.isNewUser;
                        }
                        LC.aEf.isNewUser = z;
                        a.this.aAj.aEf = LC.aEf;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aAj.aEf.nickName);
                    }
                }
                if (LC.aEh != null) {
                    a.this.aAj.aEh = LC.aEh;
                }
                if (LC.aEj) {
                    a.this.aAj.aEk = LC.aEk;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aAj);
                a.this.y(a.this.aAj);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aAj));
                if (a.this.aAj != null) {
                    com.baidu.live.im.b.d.JD().O(a.this.aAj.aEk);
                }
            }
        }
    };
    private Runnable gFo = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.bVi();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void y(r rVar) {
        if (rVar != null && this.gFl) {
            this.mHandler.removeCallbacks(this.gFo);
            this.mHandler.postDelayed(this.gFo, rVar.aDK);
        }
    }

    public void bVh() {
        this.mHandler.removeCallbacks(this.gFo);
    }

    public void a(r rVar, String str, long j) {
        this.aAj = rVar;
        this.bex = str;
        this.gCj = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.gFn);
        this.gFl = true;
        y(this.aAj);
    }

    public void stop() {
        this.gFl = false;
        MessageManager.getInstance().unRegisterListener(this.gFn);
        bVh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVi() {
        if (this.aAj != null && this.aAj.mLiveInfo != null) {
            a(this.aAj.mLiveInfo.live_id, this.bex, this.gCj);
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
        this.gCt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.gCt != null) {
            this.gCt.a(i, str, i2, obj);
        }
    }
}
