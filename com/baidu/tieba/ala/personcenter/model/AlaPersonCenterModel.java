package com.baidu.tieba.ala.personcenter.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.personcenter.messages.AlaPersonCenterResponseMessage;
/* loaded from: classes4.dex */
public class AlaPersonCenterModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.v.j.f.a f14149e;

    /* renamed from: f  reason: collision with root package name */
    public String f14150f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f14151g;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1021001 || AlaPersonCenterModel.this.f14149e == null) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof AlaPersonCenterResponseMessage)) {
                AlaPersonCenterModel.this.f14149e.b(statusCode, null, null);
                return;
            }
            AlaPersonCenterResponseMessage alaPersonCenterResponseMessage = (AlaPersonCenterResponseMessage) httpResponsedMessage;
            if (alaPersonCenterResponseMessage.getError() == 0) {
                AlaPersonCenterModel.this.f14149e.c(alaPersonCenterResponseMessage.getPersonCenterData(), 1);
            } else {
                AlaPersonCenterModel.this.f14149e.b(alaPersonCenterResponseMessage.getError(), alaPersonCenterResponseMessage.getErrMsg(), null);
            }
        }
    }

    public AlaPersonCenterModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f14151g = new a(AlaCmdConfigHttp.CMD_ALA_USER_CENTER);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_USER_CENTER, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_USER_CENTER_URL);
        tbHttpMessageTask.setResponsedClass(AlaPersonCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f14151g.setSelfListener(true);
        this.f14151g.setTag(getUniqueId());
        registerListener(this.f14151g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_USER_CENTER);
        httpMessage.addParam("user_id", this.f14150f);
        sendMessage(httpMessage);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_USER_CENTER);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_PERSON_GET_LIVES);
    }

    public void setUid(String str) {
        this.f14150f = str;
    }

    public boolean x() {
        return LoadData();
    }

    public void y(d.a.o0.v.j.f.a aVar) {
        this.f14149e = aVar;
    }
}
