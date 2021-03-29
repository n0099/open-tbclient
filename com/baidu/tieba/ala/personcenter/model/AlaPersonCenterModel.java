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
    public d.b.i0.t.j.f.a f15040e;

    /* renamed from: f  reason: collision with root package name */
    public String f15041f;

    /* renamed from: g  reason: collision with root package name */
    public final HttpMessageListener f15042g;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1021001 || AlaPersonCenterModel.this.f15040e == null) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof AlaPersonCenterResponseMessage)) {
                AlaPersonCenterModel.this.f15040e.b(statusCode, null, null);
                return;
            }
            AlaPersonCenterResponseMessage alaPersonCenterResponseMessage = (AlaPersonCenterResponseMessage) httpResponsedMessage;
            if (alaPersonCenterResponseMessage.getError() == 0) {
                AlaPersonCenterModel.this.f15040e.c(alaPersonCenterResponseMessage.getPersonCenterData(), 1);
            } else {
                AlaPersonCenterModel.this.f15040e.b(alaPersonCenterResponseMessage.getError(), alaPersonCenterResponseMessage.getErrMsg(), null);
            }
        }
    }

    public AlaPersonCenterModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f15042g = new a(AlaCmdConfigHttp.CMD_ALA_USER_CENTER);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_USER_CENTER, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_USER_CENTER_URL);
        tbHttpMessageTask.setResponsedClass(AlaPersonCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f15042g.setSelfListener(true);
        this.f15042g.setTag(getUniqueId());
        registerListener(this.f15042g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_USER_CENTER);
        httpMessage.addParam("user_id", this.f15041f);
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
        this.f15041f = str;
    }

    public boolean t() {
        return LoadData();
    }

    public void u(d.b.i0.t.j.f.a aVar) {
        this.f15040e = aVar;
    }
}
