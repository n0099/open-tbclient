package com.baidu.tieba.ala.liveroom.m;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.liveroom.messages.AlaDiversionInfoResponseMessage;
/* loaded from: classes3.dex */
public class d extends BdBaseModel {
    private a gaY;
    private HttpMessageListener gaZ;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.liveroom.data.c cVar);

        void aP(int i, String str);
    }

    public d(BdPageContext<?> bdPageContext, a aVar) {
        super(bdPageContext);
        this.gaZ = new HttpMessageListener(1021181) { // from class: com.baidu.tieba.ala.liveroom.m.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021181 && (httpResponsedMessage instanceof AlaDiversionInfoResponseMessage)) {
                    AlaDiversionInfoResponseMessage alaDiversionInfoResponseMessage = (AlaDiversionInfoResponseMessage) httpResponsedMessage;
                    if (d.this.gaY != null) {
                        if (alaDiversionInfoResponseMessage.getError() != 0 || !alaDiversionInfoResponseMessage.isSuccess()) {
                            d.this.gaY.aP(alaDiversionInfoResponseMessage.getError(), alaDiversionInfoResponseMessage.getErrorString());
                        } else {
                            d.this.gaY.a(alaDiversionInfoResponseMessage.bEE());
                        }
                    }
                }
            }
        };
        this.gaY = aVar;
        initTasks();
        registerListener(this.gaZ);
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021181, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getDiversionInfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaDiversionInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void f(String str, String str2, long j) {
        HttpMessage httpMessage = new HttpMessage(1021181);
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
