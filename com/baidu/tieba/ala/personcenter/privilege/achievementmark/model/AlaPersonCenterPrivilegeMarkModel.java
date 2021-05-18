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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaAchievementMarkResponsedMessage;
/* loaded from: classes4.dex */
public class AlaPersonCenterPrivilegeMarkModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f14121e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f14122f = new a(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof AlaAchievementMarkResponsedMessage) || httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() != AlaPersonCenterPrivilegeMarkModel.this.unique_id) {
                return;
            }
            AlaPersonCenterPrivilegeMarkModel.this.f14121e.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), httpResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, Object obj);
    }

    public AlaPersonCenterPrivilegeMarkModel(BdUniqueId bdUniqueId, b bVar) {
        this.unique_id = bdUniqueId;
        this.f14121e = bVar;
        registerTask();
        registerListener(this.f14122f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void destory() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
        MessageManager.getInstance().unRegisterListener(this.unique_id);
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_PRIVILEGE_MARK_LIST);
        tbHttpMessageTask.setResponsedClass(AlaAchievementMarkResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void u() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_PRIVILEGE_MARK_LIST);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.setTag(this.unique_id);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
