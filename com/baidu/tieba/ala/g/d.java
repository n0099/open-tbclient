package com.baidu.tieba.ala.g;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.message.AlaFeedBackReasonListResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BdBaseModel {
    private boolean bGj;
    private int[] bGk = {a.h.txt_feenback_reason1, a.h.txt_feenback_reason2, a.h.txt_feenback_reason3, a.h.txt_feenback_reason4, a.h.txt_feenback_reason5, a.h.txt_feenback_reason6, a.h.txt_feenback_reason7};
    private final HttpMessageListener bGl = new HttpMessageListener(1021205) { // from class: com.baidu.tieba.ala.g.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFeedBackReasonListResponse) && d.this.hyE != null) {
                List<com.baidu.tieba.ala.data.b> ag = d.this.ag(((AlaFeedBackReasonListResponse) httpResponsedMessage).Uv());
                if (!ListUtils.isEmpty(ag)) {
                    d.this.hyE.af(ag);
                } else {
                    d.this.hyE.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private long bnV;
    private long fYr;
    private a hyE;
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private long mUserId;

    /* loaded from: classes4.dex */
    public interface a {
        void af(List<com.baidu.tieba.ala.data.b> list);

        void onFail(int i, String str);
    }

    public d(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.hyE = aVar;
        Uw();
        MessageManager.getInstance().registerListener(this.bGl);
    }

    private void Uw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021205, TbConfig.SERVER_ADDRESS + "ala/tipoff/getTipOffType");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaFeedBackReasonListResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.ala.data.b> ag(List<com.baidu.tieba.ala.data.b> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.ala.data.b bVar = list.get(i);
            if (bVar.Uu() == 1) {
                arrayList.add(bVar);
            } else if (bVar.Uu() == 0 && !this.bGj) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void Ux() {
        HttpMessage httpMessage = new HttpMessage(1021205);
        httpMessage.addParam("live_id", this.bnV);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021205);
        MessageManager.getInstance().unRegisterListener(this.bGl);
    }

    public void b(long j, long j2, long j3, boolean z, boolean z2) {
        this.bnV = j;
        this.fYr = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bGj = z2;
    }

    public List<com.baidu.tieba.ala.data.b> Uy() {
        ArrayList arrayList = new ArrayList();
        int length = this.bGk.length;
        for (int i = 0; i < length; i++) {
            com.baidu.tieba.ala.data.b bVar = new com.baidu.tieba.ala.data.b();
            bVar.iy(this.mPageContext.getResources().getString(this.bGk[i]));
            bVar.gf(1);
            arrayList.add(bVar);
        }
        if (!this.bGj) {
            com.baidu.tieba.ala.data.b bVar2 = new com.baidu.tieba.ala.data.b();
            bVar2.iy(this.mPageContext.getResources().getString(a.h.txt_feenback_reason8));
            bVar2.gf(0);
            arrayList.add(bVar2);
        }
        return arrayList;
    }
}
