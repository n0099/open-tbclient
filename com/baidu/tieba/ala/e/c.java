package com.baidu.tieba.ala.e;

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
/* loaded from: classes2.dex */
public class c extends BdBaseModel {
    private a fiD;
    private HttpMessageListener fjA;

    /* loaded from: classes2.dex */
    public interface a {
        void V(ArrayList<com.baidu.tieba.ala.data.e> arrayList);

        void as(int i, String str);
    }

    public c(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.fjA = new HttpMessageListener(1021162) { // from class: com.baidu.tieba.ala.e.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021162 && (httpResponsedMessage instanceof AlaGetMyAssistWIshListResponseMessage)) {
                    AlaGetMyAssistWIshListResponseMessage alaGetMyAssistWIshListResponseMessage = (AlaGetMyAssistWIshListResponseMessage) httpResponsedMessage;
                    if (c.this.fiD != null) {
                        if (alaGetMyAssistWIshListResponseMessage.getError() != 0 || !alaGetMyAssistWIshListResponseMessage.isSuccess()) {
                            c.this.fiD.as(alaGetMyAssistWIshListResponseMessage.getError(), alaGetMyAssistWIshListResponseMessage.getErrorString());
                        } else {
                            c.this.fiD.V(alaGetMyAssistWIshListResponseMessage.getData());
                        }
                    }
                }
            }
        };
        this.fiD = aVar;
        boX();
        registerListener(this.fjA);
    }

    private void boX() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021162, TbConfig.SERVER_HOST + "liveserver/wishlist/getsupportwishlist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetMyAssistWIshListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void yX(String str) {
        HttpMessage httpMessage = new HttpMessage(1021162);
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
        MessageManager.getInstance().unRegisterListener(this.fjA);
        MessageManager.getInstance().unRegisterTask(1021162);
    }
}
