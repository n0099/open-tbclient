package com.baidu.tieba.ala.personcenter.privilege.achievementmark.model;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaUpdateMarkStatusResponsedMessage;
/* loaded from: classes4.dex */
public class AlaUpdateMarkStatusModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f14719e;

    /* renamed from: f  reason: collision with root package name */
    public Context f14720f;

    /* renamed from: g  reason: collision with root package name */
    public b f14721g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f14722h = new a(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (!(httpResponsedMessage instanceof AlaUpdateMarkStatusResponsedMessage) || httpResponsedMessage.getOrginalMessage() == null || AlaUpdateMarkStatusModel.this.f14719e != httpResponsedMessage.getOrginalMessage().getTag() || AlaUpdateMarkStatusModel.this.f14721g == null) {
                return;
            }
            if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                AlaUpdateMarkStatusModel.this.f14721g.onResult(false, httpResponsedMessage.getErrorString());
            } else {
                AlaUpdateMarkStatusModel.this.f14721g.onResult(true, httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onResult(boolean z, String str);
    }

    public AlaUpdateMarkStatusModel(Context context) {
        this.f14720f = context;
        u();
        initListener();
        this.f14719e = BdUniqueId.gen();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void initListener() {
        MessageManager.getInstance().registerListener(this.f14722h);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        MessageManager.getInstance().unRegisterListener(this.f14722h);
    }

    public final void u() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_UPDATE_MARK_STATUS);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaUpdateMarkStatusResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void v(b bVar) {
        this.f14721g = bVar;
    }

    public void w(boolean z, int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("action", z ? 1 : 2);
        httpMessage.addParam("mark_id", i);
        httpMessage.setTag(this.f14719e);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
