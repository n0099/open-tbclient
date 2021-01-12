package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class ConsumptionRecordsModel extends BdBaseModel<ConsumptionRecordsActivity> {
    private a iwV;
    private ArrayList<com.baidu.tieba.consumptionRecords.a> orderList;
    private b recommendData;
    private int currentPage = 0;
    private int type = 1;
    private int showMember = 1;
    private boolean hasMore = false;
    private HttpMessageListener mHttpMessageListener = new HttpMessageListener(1003075) { // from class: com.baidu.tieba.consumptionRecords.ConsumptionRecordsModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetUserOrderHttpResponseMessage)) {
                if (httpResponsedMessage.getError() != 0) {
                    ConsumptionRecordsModel.a(ConsumptionRecordsModel.this);
                    if (ConsumptionRecordsModel.this.iwV != null) {
                        ConsumptionRecordsModel.this.iwV.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ConsumptionRecordsModel.this.orderList, ConsumptionRecordsModel.this.recommendData, ConsumptionRecordsModel.this.hasMore);
                        return;
                    }
                    return;
                }
                if (httpResponsedMessage instanceof GetUserOrderHttpResponseMessage) {
                    GetUserOrderHttpResponseMessage getUserOrderHttpResponseMessage = (GetUserOrderHttpResponseMessage) httpResponsedMessage;
                    ConsumptionRecordsModel.this.a(getUserOrderHttpResponseMessage.getOrderList(), getUserOrderHttpResponseMessage.getRecommendInfo(), getUserOrderHttpResponseMessage.getHasMore());
                }
                if (ConsumptionRecordsModel.this.iwV != null) {
                    ConsumptionRecordsModel.this.iwV.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ConsumptionRecordsModel.this.orderList, ConsumptionRecordsModel.this.recommendData, ConsumptionRecordsModel.this.hasMore);
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, ArrayList<com.baidu.tieba.consumptionRecords.a> arrayList, b bVar, boolean z);

        void csc();
    }

    static /* synthetic */ int a(ConsumptionRecordsModel consumptionRecordsModel) {
        int i = consumptionRecordsModel.currentPage;
        consumptionRecordsModel.currentPage = i - 1;
        return i;
    }

    public ConsumptionRecordsModel(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        registerTask();
        this.mHttpMessageListener.setSelfListener(true);
        registerListener(this.mHttpMessageListener);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003075, TbConfig.SERVER_ADDRESS + TbConfig.GET_USER_ORDER);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetUserOrderHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.tieba.consumptionRecords.a> arrayList, b bVar, boolean z) {
        if (bVar != null) {
            this.recommendData = bVar;
        }
        this.hasMore = z;
        if (arrayList != null) {
            if (this.orderList == null) {
                this.orderList = new ArrayList<>();
            }
            if (this.currentPage == 1) {
                this.orderList.clear();
            }
            this.orderList.addAll(arrayList);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.mHttpMessageListener);
    }

    public void csa() {
        NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
        this.currentPage = 1;
        newGetUserOrderRequestMessage.setPn(this.currentPage);
        newGetUserOrderRequestMessage.setRn(10);
        newGetUserOrderRequestMessage.setOrderType(this.type);
        newGetUserOrderRequestMessage.setShowMember(this.showMember);
        sendMessage(newGetUserOrderRequestMessage);
    }

    public void csb() {
        if (!this.hasMore) {
            if (this.iwV != null) {
                this.iwV.csc();
                return;
            }
            return;
        }
        this.currentPage++;
        NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
        newGetUserOrderRequestMessage.setPn(this.currentPage);
        newGetUserOrderRequestMessage.setRn(10);
        newGetUserOrderRequestMessage.setOrderType(this.type);
        newGetUserOrderRequestMessage.setShowMember(this.showMember);
        sendMessage(newGetUserOrderRequestMessage);
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setShowMember(int i) {
        this.showMember = i;
    }

    public void a(a aVar) {
        this.iwV = aVar;
    }
}
