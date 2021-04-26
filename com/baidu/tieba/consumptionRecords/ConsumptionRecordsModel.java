package com.baidu.tieba.consumptionRecords;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ConsumptionRecordsModel extends BdBaseModel<ConsumptionRecordsActivity> {

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d.a.j0.a0.a> f15078h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.a0.b f15079i;
    public b k;

    /* renamed from: e  reason: collision with root package name */
    public int f15075e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f15076f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f15077g = 1;
    public boolean j = false;
    public HttpMessageListener l = new a(CmdConfigHttp.CMD_GET_USER_ORDER);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            if (httpResponsedMessage != null && ((z = httpResponsedMessage instanceof GetUserOrderHttpResponseMessage))) {
                if (httpResponsedMessage.getError() == 0) {
                    if (z) {
                        GetUserOrderHttpResponseMessage getUserOrderHttpResponseMessage = (GetUserOrderHttpResponseMessage) httpResponsedMessage;
                        ConsumptionRecordsModel.this.A(getUserOrderHttpResponseMessage.getOrderList(), getUserOrderHttpResponseMessage.getRecommendInfo(), getUserOrderHttpResponseMessage.getHasMore());
                    }
                    if (ConsumptionRecordsModel.this.k != null) {
                        ConsumptionRecordsModel.this.k.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ConsumptionRecordsModel.this.f15078h, ConsumptionRecordsModel.this.f15079i, ConsumptionRecordsModel.this.j);
                        return;
                    }
                    return;
                }
                ConsumptionRecordsModel.s(ConsumptionRecordsModel.this);
                if (ConsumptionRecordsModel.this.k != null) {
                    ConsumptionRecordsModel.this.k.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ConsumptionRecordsModel.this.f15078h, ConsumptionRecordsModel.this.f15079i, ConsumptionRecordsModel.this.j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, ArrayList<d.a.j0.a0.a> arrayList, d.a.j0.a0.b bVar, boolean z);

        void b();
    }

    public ConsumptionRecordsModel(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        registerTask();
        this.l.setSelfListener(true);
        registerListener(this.l);
    }

    public static /* synthetic */ int s(ConsumptionRecordsModel consumptionRecordsModel) {
        int i2 = consumptionRecordsModel.f15075e;
        consumptionRecordsModel.f15075e = i2 - 1;
        return i2;
    }

    public final void A(ArrayList<d.a.j0.a0.a> arrayList, d.a.j0.a0.b bVar, boolean z) {
        if (bVar != null) {
            this.f15079i = bVar;
        }
        this.j = z;
        if (arrayList == null) {
            return;
        }
        if (this.f15078h == null) {
            this.f15078h = new ArrayList<>();
        }
        if (this.f15075e == 1) {
            this.f15078h.clear();
        }
        this.f15078h.addAll(arrayList);
    }

    public void B(b bVar) {
        this.k = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destroy() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.l);
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_USER_ORDER, TbConfig.SERVER_ADDRESS + TbConfig.GET_USER_ORDER);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetUserOrderHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void setShowMember(int i2) {
        this.f15077g = i2;
    }

    public void setType(int i2) {
        this.f15076f = i2;
    }

    public void y() {
        NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
        this.f15075e = 1;
        newGetUserOrderRequestMessage.setPn(1);
        newGetUserOrderRequestMessage.setRn(10);
        newGetUserOrderRequestMessage.setOrderType(this.f15076f);
        newGetUserOrderRequestMessage.setShowMember(this.f15077g);
        sendMessage(newGetUserOrderRequestMessage);
    }

    public void z() {
        if (!this.j) {
            b bVar = this.k;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        this.f15075e++;
        NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
        newGetUserOrderRequestMessage.setPn(this.f15075e);
        newGetUserOrderRequestMessage.setRn(10);
        newGetUserOrderRequestMessage.setOrderType(this.f15076f);
        newGetUserOrderRequestMessage.setShowMember(this.f15077g);
        sendMessage(newGetUserOrderRequestMessage);
    }
}
