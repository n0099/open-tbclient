package com.baidu.tieba.ala.guardthrone.d;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.guardthrone.messages.AlaGuardThroneResponseMessage;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private InterfaceC0668a gTe;
    private HttpMessageListener gTf;

    /* renamed from: com.baidu.tieba.ala.guardthrone.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0668a {
        void a(com.baidu.tieba.ala.guardthrone.b.a aVar);

        void onFail(int i, String str);
    }

    public a(BdPageContext<?> bdPageContext, InterfaceC0668a interfaceC0668a) {
        super(bdPageContext);
        this.gTf = new HttpMessageListener(1021164) { // from class: com.baidu.tieba.ala.guardthrone.d.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021164 && (httpResponsedMessage instanceof AlaGuardThroneResponseMessage)) {
                    AlaGuardThroneResponseMessage alaGuardThroneResponseMessage = (AlaGuardThroneResponseMessage) httpResponsedMessage;
                    if (a.this.gTe != null) {
                        if (alaGuardThroneResponseMessage.getError() != 0 || !alaGuardThroneResponseMessage.isSuccess()) {
                            a.this.gTe.onFail(alaGuardThroneResponseMessage.getError(), alaGuardThroneResponseMessage.getErrorString());
                        } else {
                            a.this.gTe.a(alaGuardThroneResponseMessage.bWW());
                        }
                    }
                }
            }
        };
        this.gTe = interfaceC0668a;
        registerTask();
        registerListener(this.gTf);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021164, "https://tiebac.baidu.com/ala/guard/getGuardSeatInfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGuardThroneResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void eu(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(1021164);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam("anchor_id", str2);
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
        MessageManager.getInstance().unRegisterListener(this.gTf);
        MessageManager.getInstance().unRegisterTask(1021164);
    }
}
