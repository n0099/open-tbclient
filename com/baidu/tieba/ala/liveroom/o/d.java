package com.baidu.tieba.ala.liveroom.o;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.liveroom.messages.AlaDiversionInfoResponseMessage;
/* loaded from: classes2.dex */
public class d extends BdBaseModel {
    private a feF;
    private HttpMessageListener feG;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tieba.ala.liveroom.data.c cVar);

        void at(int i, String str);
    }

    public d(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.feG = new HttpMessageListener(1021173) { // from class: com.baidu.tieba.ala.liveroom.o.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021173 && (httpResponsedMessage instanceof AlaDiversionInfoResponseMessage)) {
                    AlaDiversionInfoResponseMessage alaDiversionInfoResponseMessage = (AlaDiversionInfoResponseMessage) httpResponsedMessage;
                    if (d.this.feF != null) {
                        if (alaDiversionInfoResponseMessage.getError() != 0 || !alaDiversionInfoResponseMessage.isSuccess()) {
                            d.this.feF.at(alaDiversionInfoResponseMessage.getError(), alaDiversionInfoResponseMessage.getErrorString());
                        } else {
                            d.this.feF.a(alaDiversionInfoResponseMessage.bnr());
                        }
                    }
                }
            }
        };
        this.feF = aVar;
        initTasks();
        registerListener(this.feG);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021173, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getDiversionInfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaDiversionInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void f(String str, String str2, long j) {
        HttpMessage httpMessage = new HttpMessage(1021173);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("anchor_user_id", str2);
        httpMessage.addParam("enter_time", j);
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
}
