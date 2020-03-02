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
/* loaded from: classes3.dex */
public class AlaPersonCenterModel extends BdBaseModel {
    private int akj;
    private a fuD;
    private String fuE;
    private boolean fuF;
    private final HttpMessageListener fuG;

    public AlaPersonCenterModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fuF = true;
        this.akj = 0;
        this.fuG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_USER_CENTER) { // from class: com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021001 && AlaPersonCenterModel.this.fuD != null) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    if (statusCode != 200 || !(httpResponsedMessage instanceof AlaPersonCenterResponseMessage)) {
                        AlaPersonCenterModel.this.fuD.c(statusCode, null, null);
                        return;
                    }
                    AlaPersonCenterResponseMessage alaPersonCenterResponseMessage = (AlaPersonCenterResponseMessage) httpResponsedMessage;
                    if (alaPersonCenterResponseMessage.getError() == 0) {
                        AlaPersonCenterModel.this.fuD.b(alaPersonCenterResponseMessage.getPersonCenterData(), 1);
                    } else {
                        AlaPersonCenterModel.this.fuD.c(alaPersonCenterResponseMessage.getError(), alaPersonCenterResponseMessage.getErrMsg(), null);
                    }
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_USER_CENTER, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_USER_CENTER_URL);
        tbHttpMessageTask.setResponsedClass(AlaPersonCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.fuG.setSelfListener(true);
        this.fuG.setTag(getUniqueId());
        registerListener(this.fuG);
    }

    public void setUid(String str) {
        this.fuE = str;
    }

    public void a(a aVar) {
        this.fuD = aVar;
    }

    public boolean loadData() {
        return LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_USER_CENTER);
        httpMessage.addParam("user_id", this.fuE);
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
}
