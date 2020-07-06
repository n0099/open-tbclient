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
/* loaded from: classes3.dex */
public class AlaUpdateMarkStatusModel extends BdBaseModel {
    private a gDt;
    private HttpMessageListener gDu = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaUpdateMarkStatusModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof AlaUpdateMarkStatusResponsedMessage) && httpResponsedMessage.getOrginalMessage() != null && AlaUpdateMarkStatusModel.this.mBdUniqueId == httpResponsedMessage.getOrginalMessage().getTag() && AlaUpdateMarkStatusModel.this.gDt != null) {
                if (httpResponsedMessage.getError() != 0 || httpResponsedMessage.hasError()) {
                    AlaUpdateMarkStatusModel.this.gDt.onResult(false, httpResponsedMessage.getErrorString());
                } else {
                    AlaUpdateMarkStatusModel.this.gDt.onResult(true, httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mBdUniqueId;
    private Context mContext;

    /* loaded from: classes3.dex */
    public interface a {
        void onResult(boolean z, String str);
    }

    public AlaUpdateMarkStatusModel(Context context) {
        this.mContext = context;
        bKM();
        initListener();
        this.mBdUniqueId = BdUniqueId.gen();
    }

    public void a(a aVar) {
        this.gDt = aVar;
    }

    public void w(boolean z, int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        httpMessage.addParam("action", z ? 1 : 2);
        httpMessage.addParam("mark_id", i);
        httpMessage.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private void bKM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_UPDATE_MARK_STATUS);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaUpdateMarkStatusResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gDu);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
        MessageManager.getInstance().unRegisterListener(this.gDu);
    }
}
