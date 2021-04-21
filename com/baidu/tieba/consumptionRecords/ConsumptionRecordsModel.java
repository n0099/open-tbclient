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
    public ArrayList<d.b.j0.a0.a> f14964h;
    public d.b.j0.a0.b i;
    public b k;

    /* renamed from: e  reason: collision with root package name */
    public int f14961e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f14962f = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f14963g = 1;
    public boolean j = false;
    public HttpMessageListener l = new a(CmdConfigHttp.CMD_GET_USER_ORDER);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
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
                        ConsumptionRecordsModel.this.k.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ConsumptionRecordsModel.this.f14964h, ConsumptionRecordsModel.this.i, ConsumptionRecordsModel.this.j);
                        return;
                    }
                    return;
                }
                ConsumptionRecordsModel.s(ConsumptionRecordsModel.this);
                if (ConsumptionRecordsModel.this.k != null) {
                    ConsumptionRecordsModel.this.k.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), ConsumptionRecordsModel.this.f14964h, ConsumptionRecordsModel.this.i, ConsumptionRecordsModel.this.j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i, String str, ArrayList<d.b.j0.a0.a> arrayList, d.b.j0.a0.b bVar, boolean z);

        void b();
    }

    public ConsumptionRecordsModel(BdUniqueId bdUniqueId) {
        this.unique_id = bdUniqueId;
        registerTask();
        this.l.setSelfListener(true);
        registerListener(this.l);
    }

    public static /* synthetic */ int s(ConsumptionRecordsModel consumptionRecordsModel) {
        int i = consumptionRecordsModel.f14961e;
        consumptionRecordsModel.f14961e = i - 1;
        return i;
    }

    public final void A(ArrayList<d.b.j0.a0.a> arrayList, d.b.j0.a0.b bVar, boolean z) {
        if (bVar != null) {
            this.i = bVar;
        }
        this.j = z;
        if (arrayList == null) {
            return;
        }
        if (this.f14964h == null) {
            this.f14964h = new ArrayList<>();
        }
        if (this.f14961e == 1) {
            this.f14964h.clear();
        }
        this.f14964h.addAll(arrayList);
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

    public void setShowMember(int i) {
        this.f14963g = i;
    }

    public void setType(int i) {
        this.f14962f = i;
    }

    public void y() {
        NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
        this.f14961e = 1;
        newGetUserOrderRequestMessage.setPn(1);
        newGetUserOrderRequestMessage.setRn(10);
        newGetUserOrderRequestMessage.setOrderType(this.f14962f);
        newGetUserOrderRequestMessage.setShowMember(this.f14963g);
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
        this.f14961e++;
        NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
        newGetUserOrderRequestMessage.setPn(this.f14961e);
        newGetUserOrderRequestMessage.setRn(10);
        newGetUserOrderRequestMessage.setOrderType(this.f14962f);
        newGetUserOrderRequestMessage.setShowMember(this.f14963g);
        sendMessage(newGetUserOrderRequestMessage);
    }
}
