package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.b;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ao;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private AlaLiveUserInfoData hUK;
    private ao hUL;
    private InterfaceC0719a hUM;
    private HttpMessageListener hUN = new HttpMessageListener(1021065) { // from class: com.baidu.tieba.ala.tasklist.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021065 && (httpResponsedMessage instanceof LiveFlowerTaskListResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskListResponsedMessage liveFlowerTaskListResponsedMessage = (LiveFlowerTaskListResponsedMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    if (a.this.hUM != null) {
                        a.this.hUM.aC(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a.this.hUK = liveFlowerTaskListResponsedMessage.hUK;
                a.this.hUL = liveFlowerTaskListResponsedMessage.hUL;
                if (a.this.hUM != null) {
                    a.this.hUM.a(liveFlowerTaskListResponsedMessage.hUK, liveFlowerTaskListResponsedMessage.hUL);
                }
            }
        }
    };
    private HttpMessageListener hUO = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.tasklist.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    if (a.this.hUM != null) {
                        a.this.hUM.aC(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a.this.hUK = liveFlowerTaskRewardResponsedMessage.hUK;
                a.this.hUL = liveFlowerTaskRewardResponsedMessage.hUL;
                a.this.coW();
                if (a.this.hUM != null) {
                    a.this.hUM.a(liveFlowerTaskRewardResponsedMessage.hUK, liveFlowerTaskRewardResponsedMessage.hUL);
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.tasklist.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0719a {
        void a(AlaLiveUserInfoData alaLiveUserInfoData, ao aoVar);

        void aC(int i, String str);
    }

    public a() {
        coT();
        coU();
        MessageManager.getInstance().registerListener(this.hUN);
        MessageManager.getInstance().registerListener(this.hUO);
    }

    public ao coS() {
        return this.hUL;
    }

    private void coT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021065, b.aAE);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void coU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021066, b.aAF);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskRewardResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void coV() {
        HttpMessage httpMessage = new HttpMessage(1021065);
        httpMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void xI(int i) {
        HttpMessage httpMessage = new HttpMessage(1021066);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("task_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coW() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_pickup"));
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hUN);
        MessageManager.getInstance().unRegisterListener(this.hUO);
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

    public void a(InterfaceC0719a interfaceC0719a) {
        this.hUM = interfaceC0719a;
    }
}
