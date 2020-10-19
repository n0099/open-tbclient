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
    private int aXa;
    private a hmI;
    private String hmJ;
    private boolean hmK;
    private final HttpMessageListener hmL;

    public AlaPersonCenterModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hmK = true;
        this.aXa = 0;
        this.hmL = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_USER_CENTER) { // from class: com.baidu.tieba.ala.personcenter.model.AlaPersonCenterModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021001 && AlaPersonCenterModel.this.hmI != null) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    if (statusCode != 200 || !(httpResponsedMessage instanceof AlaPersonCenterResponseMessage)) {
                        AlaPersonCenterModel.this.hmI.c(statusCode, null, null);
                        return;
                    }
                    AlaPersonCenterResponseMessage alaPersonCenterResponseMessage = (AlaPersonCenterResponseMessage) httpResponsedMessage;
                    if (alaPersonCenterResponseMessage.getError() == 0) {
                        AlaPersonCenterModel.this.hmI.c(alaPersonCenterResponseMessage.getPersonCenterData(), 1);
                    } else {
                        AlaPersonCenterModel.this.hmI.c(alaPersonCenterResponseMessage.getError(), alaPersonCenterResponseMessage.getErrMsg(), null);
                    }
                }
            }
        };
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_USER_CENTER, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_USER_CENTER_URL);
        tbHttpMessageTask.setResponsedClass(AlaPersonCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.hmL.setSelfListener(true);
        this.hmL.setTag(getUniqueId());
        registerListener(this.hmL);
    }

    public void setUid(String str) {
        this.hmJ = str;
    }

    public void a(a aVar) {
        this.hmI = aVar;
    }

    public boolean loadData() {
        return LoadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_USER_CENTER);
        httpMessage.addParam("user_id", this.hmJ);
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
