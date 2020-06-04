package com.baidu.tieba.ala.guardthrone.d;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.guardthrone.messages.AlaGuardThroneResponseMessage;
/* loaded from: classes3.dex */
public class a extends BdBaseModel {
    private InterfaceC0548a fCp;
    private HttpMessageListener fCq;

    /* renamed from: com.baidu.tieba.ala.guardthrone.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0548a {
        void a(com.baidu.tieba.ala.guardthrone.b.a aVar);

        void onFail(int i, String str);
    }

    public a(BdPageContext<?> bdPageContext, InterfaceC0548a interfaceC0548a) {
        super(bdPageContext);
        this.fCq = new HttpMessageListener(1021164) { // from class: com.baidu.tieba.ala.guardthrone.d.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021164 && (httpResponsedMessage instanceof AlaGuardThroneResponseMessage)) {
                    AlaGuardThroneResponseMessage alaGuardThroneResponseMessage = (AlaGuardThroneResponseMessage) httpResponsedMessage;
                    if (a.this.fCp != null) {
                        if (alaGuardThroneResponseMessage.getError() != 0 || !alaGuardThroneResponseMessage.isSuccess()) {
                            a.this.fCp.onFail(alaGuardThroneResponseMessage.getError(), alaGuardThroneResponseMessage.getErrorString());
                        } else {
                            a.this.fCp.a(alaGuardThroneResponseMessage.bvp());
                        }
                    }
                }
            }
        };
        this.fCp = interfaceC0548a;
        Fv();
        registerListener(this.fCq);
    }

    private void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021164, "https://tiebac.baidu.com/ala/guard/getGuardSeatInfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGuardThroneResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void dD(String str, String str2) {
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
        MessageManager.getInstance().unRegisterListener(this.fCq);
        MessageManager.getInstance().unRegisterTask(1021164);
    }
}
