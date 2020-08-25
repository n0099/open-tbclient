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
    private long bew;
    private boolean dMJ;
    private long fuJ;
    private a gOm;
    private int[] gOn = {a.i.txt_feenback_reason1, a.i.txt_feenback_reason2, a.i.txt_feenback_reason3, a.i.txt_feenback_reason4, a.i.txt_feenback_reason5, a.i.txt_feenback_reason6, a.i.txt_feenback_reason7};
    private final HttpMessageListener gOo = new HttpMessageListener(1021205) { // from class: com.baidu.tieba.ala.f.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaFeedBackReasonListResponse) && c.this.gOm != null) {
                List<com.baidu.tieba.ala.data.b> cd = c.this.cd(((AlaFeedBackReasonListResponse) httpResponsedMessage).bXM());
                if (!ListUtils.isEmpty(cd)) {
                    c.this.gOm.bd(cd);
                } else {
                    c.this.gOm.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
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
        this.gOm = aVar;
        bXS();
        MessageManager.getInstance().registerListener(this.gOo);
    }

    private void bXS() {
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
            if (bVar.bIK() == 1) {
                arrayList.add(bVar);
            } else if (bVar.bIK() == 0 && !this.dMJ) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void bXT() {
        HttpMessage httpMessage = new HttpMessage(1021205);
        httpMessage.addParam("live_id", this.bew);
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
        MessageManager.getInstance().unRegisterListener(this.gOo);
    }

    public void b(long j, long j2, long j3, boolean z, boolean z2) {
        this.bew = j;
        this.fuJ = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.dMJ = z2;
    }

    public List<com.baidu.tieba.ala.data.b> bXU() {
        ArrayList arrayList = new ArrayList();
        int length = this.gOn.length;
        for (int i = 0; i < length; i++) {
            com.baidu.tieba.ala.data.b bVar = new com.baidu.tieba.ala.data.b();
            bVar.Fe(this.mPageContext.getResources().getString(this.gOn[i]));
            bVar.th(1);
            arrayList.add(bVar);
        }
        if (!this.dMJ) {
            com.baidu.tieba.ala.data.b bVar2 = new com.baidu.tieba.ala.data.b();
            bVar2.Fe(this.mPageContext.getResources().getString(a.i.txt_feenback_reason8));
            bVar2.th(0);
            arrayList.add(bVar2);
        }
        return arrayList;
    }
}
