package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.b;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.au;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private AlaLiveUserInfoData ihG;
    private au ihH;
    private InterfaceC0695a ihI;
    private HttpMessageListener ihJ = new HttpMessageListener(1021065) { // from class: com.baidu.tieba.ala.tasklist.model.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021065 && (httpResponsedMessage instanceof LiveFlowerTaskListResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskListResponsedMessage liveFlowerTaskListResponsedMessage = (LiveFlowerTaskListResponsedMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    if (a.this.ihI != null) {
                        a.this.ihI.aJ(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a.this.ihG = liveFlowerTaskListResponsedMessage.ihG;
                a.this.ihH = liveFlowerTaskListResponsedMessage.ihH;
                if (a.this.ihI != null) {
                    a.this.ihI.a(liveFlowerTaskListResponsedMessage.ihG, liveFlowerTaskListResponsedMessage.ihH);
                }
            }
        }
    };
    private HttpMessageListener ihK = new HttpMessageListener(1021066) { // from class: com.baidu.tieba.ala.tasklist.model.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021066 && (httpResponsedMessage instanceof LiveFlowerTaskRewardResponsedMessage)) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                LiveFlowerTaskRewardResponsedMessage liveFlowerTaskRewardResponsedMessage = (LiveFlowerTaskRewardResponsedMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    if (a.this.ihI != null) {
                        a.this.ihI.aJ(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a.this.ihG = liveFlowerTaskRewardResponsedMessage.ihG;
                a.this.ihH = liveFlowerTaskRewardResponsedMessage.ihH;
                a.this.cpk();
                if (a.this.ihI != null) {
                    a.this.ihI.a(liveFlowerTaskRewardResponsedMessage.ihG, liveFlowerTaskRewardResponsedMessage.ihH);
                }
            }
        }
    };

    /* renamed from: com.baidu.tieba.ala.tasklist.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0695a {
        void a(AlaLiveUserInfoData alaLiveUserInfoData, au auVar);

        void aJ(int i, String str);
    }

    public a() {
        cph();
        cpi();
        MessageManager.getInstance().registerListener(this.ihJ);
        MessageManager.getInstance().registerListener(this.ihK);
    }

    public au cpg() {
        return this.ihH;
    }

    private void cph() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021065, b.avX);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskListResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void cpi() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021066, b.avY);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(LiveFlowerTaskRewardResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cpj() {
        HttpMessage httpMessage = new HttpMessage(1021065);
        httpMessage.setTag(getUniqueId());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void wA(int i) {
        HttpMessage httpMessage = new HttpMessage(1021066);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("task_id", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpk() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "petal_pickup"));
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ihJ);
        MessageManager.getInstance().unRegisterListener(this.ihK);
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

    public void a(InterfaceC0695a interfaceC0695a) {
        this.ihI = interfaceC0695a;
    }
}
