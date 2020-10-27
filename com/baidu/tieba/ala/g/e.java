package com.baidu.tieba.ala.g;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.message.AlaGetMyAssistWIshListResponseMessage;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e extends BdBaseModel {
    private a hrF;
    private HttpMessageListener hsJ;

    /* loaded from: classes4.dex */
    public interface a {
        void af(ArrayList<com.baidu.tieba.ala.data.f> arrayList);

        void bj(int i, String str);
    }

    public e(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.hsJ = new HttpMessageListener(1021171) { // from class: com.baidu.tieba.ala.g.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021171 && (httpResponsedMessage instanceof AlaGetMyAssistWIshListResponseMessage)) {
                    AlaGetMyAssistWIshListResponseMessage alaGetMyAssistWIshListResponseMessage = (AlaGetMyAssistWIshListResponseMessage) httpResponsedMessage;
                    if (e.this.hrF != null) {
                        if (alaGetMyAssistWIshListResponseMessage.getError() != 0 || !alaGetMyAssistWIshListResponseMessage.isSuccess()) {
                            e.this.hrF.bj(alaGetMyAssistWIshListResponseMessage.getError(), alaGetMyAssistWIshListResponseMessage.getErrorString());
                        } else {
                            e.this.hrF.af(alaGetMyAssistWIshListResponseMessage.getData());
                        }
                    }
                }
            }
        };
        this.hrF = aVar;
        cgj();
        registerListener(this.hsJ);
    }

    private void cgj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021171, TbConfig.SERVER_HOST + "liveserver/wishlist/getsupportwishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetMyAssistWIshListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void Ij(String str) {
        HttpMessage httpMessage = new HttpMessage(1021171);
        httpMessage.addParam("anchor_id", str);
        sendMessage(httpMessage);
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
        MessageManager.getInstance().unRegisterListener(this.hsJ);
        MessageManager.getInstance().unRegisterTask(1021171);
    }
}
