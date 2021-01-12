package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.b;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.aq;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private aq icA;
    private InterfaceC0694a icB;
    private HttpMessageListener icC = new HttpMessageListener(1021065) { // from class: com.baidu.tieba.ala.tasklist.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021065 && (httpResponsedMessage instanceof LiveFlowerTaskListResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskListResponsedMessage liveFlowerTaskListResponsedMessage = (LiveFlowerTaskListResponsedMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    if (a.this.icB != null) {
                        a.this.icB.aF(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a.this.icz = liveFlowerTaskListResponsedMessage.icz;
                a.this.icA = liveFlowerTaskListResponsedMessage.icA;
                if (a.this.icB != null) {
                    a.this.icB.a(liveFlowerTaskListResponsedMessage.icz, liveFlowerTaskListResponsedMessage.icA);
                }
            }
        }
    };
    private HttpMessageListener icD = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.tasklist.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    if (a.this.icB != null) {
                        a.this.icB.aF(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a.this.icz = liveFlowerTaskRewardResponsedMessage.icz;
                a.this.icA = liveFlowerTaskRewardResponsedMessage.icA;
                a.this.cnY();
                if (a.this.icB != null) {
                    a.this.icB.a(liveFlowerTaskRewardResponsedMessage.icz, liveFlowerTaskRewardResponsedMessage.icA);
                }
            }
        }
    };
    private AlaLiveUserInfoData icz;

    /* renamed from: com.baidu.tieba.ala.tasklist.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0694a {
        void a(AlaLiveUserInfoData alaLiveUserInfoData, aq aqVar);

        void aF(int i, String str);
    }

    public a() {
        cnV();
        cnW();
        MessageManager.getInstance().registerListener(this.icC);
        MessageManager.getInstance().registerListener(this.icD);
    }

    public aq cnU() {
        return this.icA;
    }

    private void cnV() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021065, b.awi);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cnW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021066, b.awj);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskRewardResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cnX() {
        HttpMessage httpMessage = new HttpMessage(1021065);
        httpMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void wp(int i) {
        HttpMessage httpMessage = new HttpMessage(1021066);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("task_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnY() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_pickup"));
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.icC);
        MessageManager.getInstance().unRegisterListener(this.icD);
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

    public void a(InterfaceC0694a interfaceC0694a) {
        this.icB = interfaceC0694a;
    }
}
