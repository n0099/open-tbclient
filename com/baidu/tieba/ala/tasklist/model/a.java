package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
/* loaded from: classes3.dex */
public class a extends BdBaseModel<AlaTaskListActivity> {
    private AlaLiveUserInfoData gue;
    private ab guf;
    private InterfaceC0592a gug;
    private HttpMessageListener guh;
    private HttpMessageListener gui;

    /* renamed from: com.baidu.tieba.ala.tasklist.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0592a {
        void a(AlaLiveUserInfoData alaLiveUserInfoData, ab abVar);

        void al(int i, String str);
    }

    public a(TbPageContext<AlaTaskListActivity> tbPageContext) {
        super(tbPageContext);
        this.guh = new HttpMessageListener(1021065) { // from class: com.baidu.tieba.ala.tasklist.model.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021065 && (httpResponsedMessage instanceof AlaTaskListHttpResponsedMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaTaskListHttpResponsedMessage alaTaskListHttpResponsedMessage = (AlaTaskListHttpResponsedMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.gug != null) {
                            a.this.gug.al(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.gue = alaTaskListHttpResponsedMessage.gue;
                    a.this.guf = alaTaskListHttpResponsedMessage.guf;
                    if (a.this.gug != null) {
                        a.this.gug.a(alaTaskListHttpResponsedMessage.gue, alaTaskListHttpResponsedMessage.guf);
                    }
                }
            }
        };
        this.gui = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.tasklist.model.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof AlaTaskRewardHttpResponsedMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    AlaTaskRewardHttpResponsedMessage alaTaskRewardHttpResponsedMessage = (AlaTaskRewardHttpResponsedMessage) httpResponsedMessage;
                    if (statusCode != 200 || error != 0) {
                        if (a.this.gug != null) {
                            a.this.gug.al(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    a.this.gue = alaTaskRewardHttpResponsedMessage.gue;
                    a.this.guf = alaTaskRewardHttpResponsedMessage.guf;
                    a.this.bJG();
                    if (a.this.gug != null) {
                        a.this.gug.a(alaTaskRewardHttpResponsedMessage.gue, alaTaskRewardHttpResponsedMessage.guf);
                    }
                }
            }
        };
        bJD();
        bJE();
        MessageManager.getInstance().registerListener(this.guh);
        MessageManager.getInstance().registerListener(this.gui);
    }

    public ab bJC() {
        return this.guf;
    }

    private void bJD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021065, com.baidu.live.a.asl);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTaskListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void bJE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021066, com.baidu.live.a.asn);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaTaskRewardHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void bJF() {
        HttpMessage httpMessage = new HttpMessage(1021065);
        httpMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void rT(int i) {
        HttpMessage httpMessage = new HttpMessage(1021066);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("task_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJG() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_pickup"));
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.guh);
        MessageManager.getInstance().unRegisterListener(this.gui);
        MessageManager.getInstance().unRegisterTask(1021065);
        MessageManager.getInstance().unRegisterTask(1021066);
        cancelMessage();
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

    public void a(InterfaceC0592a interfaceC0592a) {
        this.gug = interfaceC0592a;
    }
}
