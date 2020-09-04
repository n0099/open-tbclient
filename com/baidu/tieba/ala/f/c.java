package com.baidu.tieba.ala.f;

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
/* loaded from: classes7.dex */
public class c extends BdBaseModel {
    private long bey;
    private boolean dMN;
    private long fuN;
    private a gOq;
    private int[] gOr = {a.i.txt_feenback_reason1, a.i.txt_feenback_reason2, a.i.txt_feenback_reason3, a.i.txt_feenback_reason4, a.i.txt_feenback_reason5, a.i.txt_feenback_reason6, a.i.txt_feenback_reason7};
    private final HttpMessageListener gOs = new HttpMessageListener(1021205) { // from class: com.baidu.tieba.ala.f.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFeedBackReasonListResponse) && c.this.gOq != null) {
                List<com.baidu.tieba.ala.data.b> cd = c.this.cd(((AlaFeedBackReasonListResponse) httpResponsedMessage).bXN());
                if (!ListUtils.isEmpty(cd)) {
                    c.this.gOq.bd(cd);
                } else {
                    c.this.gOq.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private boolean mIsHost;
    private TbPageContext mPageContext;
    private long mUserId;

    /* loaded from: classes7.dex */
    public interface a {
        void bd(List<com.baidu.tieba.ala.data.b> list);

        void onFail(int i, String str);
    }

    public c(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.gOq = aVar;
        bXT();
        MessageManager.getInstance().registerListener(this.gOs);
    }

    private void bXT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021205, TbConfig.SERVER_ADDRESS + "ala/tipoff/getTipOffType");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaFeedBackReasonListResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.tieba.ala.data.b> cd(List<com.baidu.tieba.ala.data.b> list) {
        if (ListUtils.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tieba.ala.data.b bVar = list.get(i);
            if (bVar.bIL() == 1) {
                arrayList.add(bVar);
            } else if (bVar.bIL() == 0 && !this.dMN) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void bXU() {
        HttpMessage httpMessage = new HttpMessage(1021205);
        httpMessage.addParam("live_id", this.bey);
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
        MessageManager.getInstance().unRegisterListener(this.gOs);
    }

    public void b(long j, long j2, long j3, boolean z, boolean z2) {
        this.bey = j;
        this.fuN = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.dMN = z2;
    }

    public List<com.baidu.tieba.ala.data.b> bXV() {
        ArrayList arrayList = new ArrayList();
        int length = this.gOr.length;
        for (int i = 0; i < length; i++) {
            com.baidu.tieba.ala.data.b bVar = new com.baidu.tieba.ala.data.b();
            bVar.Ff(this.mPageContext.getResources().getString(this.gOr[i]));
            bVar.th(1);
            arrayList.add(bVar);
        }
        if (!this.dMN) {
            com.baidu.tieba.ala.data.b bVar2 = new com.baidu.tieba.ala.data.b();
            bVar2.Ff(this.mPageContext.getResources().getString(a.i.txt_feenback_reason8));
            bVar2.th(0);
            arrayList.add(bVar2);
        }
        return arrayList;
    }
}
