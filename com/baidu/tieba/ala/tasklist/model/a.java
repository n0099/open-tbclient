package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ae;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes7.dex */
public class a extends BdBaseModel {
    private AlaLiveUserInfoData gZj;
    private ae gZk;
    private InterfaceC0660a gZl;
    private HttpMessageListener gZm = new HttpMessageListener(1021065) { // from class: com.baidu.tieba.ala.tasklist.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021065 && (httpResponsedMessage instanceof LiveFlowerTaskListResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskListResponsedMessage liveFlowerTaskListResponsedMessage = (LiveFlowerTaskListResponsedMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    if (a.this.gZl != null) {
                        a.this.gZl.am(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a.this.gZj = liveFlowerTaskListResponsedMessage.gZj;
                a.this.gZk = liveFlowerTaskListResponsedMessage.gZk;
                if (a.this.gZl != null) {
                    a.this.gZl.a(liveFlowerTaskListResponsedMessage.gZj, liveFlowerTaskListResponsedMessage.gZk);
                }
            }
        }
    };
    private HttpMessageListener gZn = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.tasklist.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    if (a.this.gZl != null) {
                        a.this.gZl.am(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a.this.gZj = liveFlowerTaskRewardResponsedMessage.gZj;
                a.this.gZk = liveFlowerTaskRewardResponsedMessage.gZk;
                a.this.cad();
                if (a.this.gZl != null) {
                    a.this.gZl.a(liveFlowerTaskRewardResponsedMessage.gZj, liveFlowerTaskRewardResponsedMessage.gZk);
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.tasklist.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0660a {
        void a(AlaLiveUserInfoData alaLiveUserInfoData, ae aeVar);

        void am(int i, String str);
    }

    public a() {
        caa();
        cab();
        MessageManager.getInstance().registerListener(this.gZm);
        MessageManager.getInstance().registerListener(this.gZn);
    }

    public ae bZZ() {
        return this.gZk;
    }

    private void caa() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021065, com.baidu.live.a.ayC);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cab() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021066, com.baidu.live.a.ayD);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskRewardResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cac() {
        HttpMessage httpMessage = new HttpMessage(1021065);
        httpMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void uY(int i) {
        HttpMessage httpMessage = new HttpMessage(1021066);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("task_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cad() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_pickup"));
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gZm);
        MessageManager.getInstance().unRegisterListener(this.gZn);
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

    public void a(InterfaceC0660a interfaceC0660a) {
        this.gZl = interfaceC0660a;
    }
}
