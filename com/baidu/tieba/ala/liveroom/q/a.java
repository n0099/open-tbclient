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
    private w aEc;
    private String bmC;
    private long hfT;
    private d.a hgd;
    private boolean hiZ;
    private long hja;
    private Handler mHandler = new Handler();
    private HttpMessageListener hjb = new HttpMessageListener(1021007) { // from class: com.baidu.tieba.ala.liveroom.q.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == a.this.unique_id) {
                if (httpResponsedMessage.hasError()) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, null);
                    return;
                }
                w GH = httpResponsedMessage instanceof AlaGetLiveInfoHttpResponseMessage ? ((AlaGetLiveInfoHttpResponseMessage) httpResponsedMessage).GH() : null;
                a.this.hja = System.currentTimeMillis();
                if (GH == null) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, GH);
                    return;
                }
                if (a.this.aEc == null) {
                    a.this.aEc = GH;
                } else if (a.this.aEc.mLiveInfo != null && GH.mLiveInfo != null && a.this.aEc.mLiveInfo.live_id != GH.mLiveInfo.live_id) {
                    a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aEc);
                    return;
                }
                if (a.this.aEc.mLiveInfo != null && GH.mLiveInfo != null && a.this.aEc.mLiveInfo.user_id == GH.mLiveInfo.user_id) {
                    if (a.this.aEc.mLiveInfo.imEffect != null && GH.mLiveInfo.imEffect == null) {
                        GH.mLiveInfo.imEffect = a.this.aEc.mLiveInfo.imEffect;
                    }
                    if (a.this.aEc.mLiveInfo.mLiveCloseData != null && GH.mLiveInfo.mLiveCloseData == null) {
                        GH.mLiveInfo.mLiveCloseData = a.this.aEc.mLiveInfo.mLiveCloseData;
                    }
                    if (a.this.aEc.mLiveInfo.mAlaLiveSwitchData != null && GH.mLiveInfo.mAlaLiveSwitchData == null) {
                        GH.mLiveInfo.mAlaLiveSwitchData = a.this.aEc.mLiveInfo.mAlaLiveSwitchData;
                    }
                }
                a.this.aEc.mLiveInfo = GH.mLiveInfo;
                a.this.aEc.serverTime = GH.serverTime;
                a.this.aEc.aIT = GH.aIT;
                a.this.aEc.aIe = GH.aIe;
                a.this.aEc.aIf = GH.aIf;
                a.this.aEc.aIj = GH.aIj;
                a.this.aEc.aIK = GH.aIK;
                a.this.aEc.aII = GH.aII;
                a.this.aEc.aIF = GH.aIF;
                a.this.aEc.aIG = GH.aIG;
                a.this.aEc.aIH = GH.aIH;
                if (GH.aIC != null) {
                    a.this.aEc.aIC = GH.aIC;
                }
                if (GH.aIN != null && GH.aIN.aMM != null && !GH.aIN.aMM.isEmpty()) {
                    a.this.aEc.aIN = GH.aIN;
                }
                if (GH.aIA != null) {
                    if (GH.aIA.userId == 0) {
                        if (a.this.aEc.aIA == null) {
                            a.this.aEc.aIA = new AlaLiveUserInfoData();
                        }
                        a.this.aEc.aIA.throneUid = GH.aIA.throneUid;
                    } else {
                        boolean z = GH.aIA.isNewUser;
                        if (a.this.aEc.aIA != null) {
                            z = a.this.aEc.aIA.isNewUser;
                        }
                        GH.aIA.isNewUser = z;
                        a.this.aEc.aIA = GH.aIA;
                        TbadkCoreApplication.getCurrentAccountObj().setNameShow(a.this.aEc.aIA.nickName);
                    }
                }
                if (GH.aIE != null) {
                    a.this.aEc.aIE = GH.aIE;
                }
                if (GH.aII) {
                    a.this.aEc.aIJ = GH.aIJ;
                }
                a.this.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), 1, a.this.aEc);
                a.this.F(a.this.aEc);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913082, a.this.aEc));
                if (a.this.aEc != null) {
                    com.baidu.live.im.b.d.LG().U(a.this.aEc.aIJ);
                }
            }
        }
    };
    private Runnable hjc = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.a.2
        @Override // java.lang.Runnable
        public void run() {
            a.this.cdr();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void F(w wVar) {
        if (wVar != null && this.hiZ) {
            this.mHandler.removeCallbacks(this.hjc);
            this.mHandler.postDelayed(this.hjc, wVar.aIj);
        }
    }

    public void cdq() {
        this.mHandler.removeCallbacks(this.hjc);
    }

    public void a(w wVar, String str, long j) {
        this.aEc = wVar;
        this.bmC = str;
        this.hfT = j;
        if (getUniqueId() == null) {
            setUniqueId(BdUniqueId.gen());
        }
        registerListener(this.hjb);
        this.hiZ = true;
        F(this.aEc);
    }

    public void stop() {
        this.hiZ = false;
        MessageManager.getInstance().unRegisterListener(this.hjb);
        cdq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdr() {
        if (this.aEc != null && this.aEc.mLiveInfo != null) {
            a(this.aEc.mLiveInfo.live_id, this.bmC, this.hfT);
        }
    }

    public void a(long j, String str, long j2) {
        com.baidu.live.message.c cVar = new com.baidu.live.message.c();
        cVar.setLiveId(j);
        cVar.setFrom(str);
        cVar.ap(j2);
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
        this.hgd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str, int i2, Object obj) {
        if (this.hgd != null) {
            this.hgd.a(i, str, i2, obj);
        }
    }
}
