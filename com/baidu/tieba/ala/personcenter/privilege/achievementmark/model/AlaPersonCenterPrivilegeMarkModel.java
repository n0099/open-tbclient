package com.baidu.tieba.ala.personcenter.privilege.achievementmark.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaAchievementMarkResponsedMessage;
/* loaded from: classes9.dex */
public class AlaPersonCenterPrivilegeMarkModel extends BdBaseModel {
    private a hWL;
    private HttpMessageListener hWZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST) { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaAchievementMarkResponsedMessage) && httpResponsedMessage.getOrginalMessage() != null && httpResponsedMessage.getOrginalMessage().getTag() == AlaPersonCenterPrivilegeMarkModel.this.unique_id) {
                AlaPersonCenterPrivilegeMarkModel.this.hWL.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, String str, Object obj);
    }

    public AlaPersonCenterPrivilegeMarkModel(BdUniqueId bdUniqueId, a aVar) {
        this.unique_id = bdUniqueId;
        this.hWL = aVar;
        registerTask();
        registerListener(this.hWZ);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_PRIVILEGE_MARK_LIST);
        tbHttpMessageTask.setResponsedClass(AlaAchievementMarkResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cml() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
        httpMessage.addParam("user_id", TbadkApplication.getCurrentAccount());
        httpMessage.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void destory() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
