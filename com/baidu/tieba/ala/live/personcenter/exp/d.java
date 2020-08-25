package com.baidu.tieba.ala.live.personcenter.exp;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.message.AlaGetUserInfoHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes7.dex */
public class d extends BdBaseModel {
    private a ghj;
    private HttpMessageListener ghk = new HttpMessageListener(1021039) { // from class: com.baidu.tieba.ala.live.personcenter.exp.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaGetUserInfoHttpResponseMessage) && d.this.ghj != null) {
                if (httpResponsedMessage.getError() != 0 || !httpResponsedMessage.isSuccess()) {
                    d.this.ghj.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    return;
                }
                AlaLivePersonData LD = ((AlaGetUserInfoHttpResponseMessage) httpResponsedMessage).LD();
                if (LD == null || LD.mUserData == null) {
                    d.this.ghj.onFail(901, "");
                } else {
                    d.this.ghj.b(LD);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes7.dex */
    public interface a {
        void b(AlaLivePersonData alaLivePersonData);

        void onFail(int i, String str);
    }

    public d(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.ghj = aVar;
        bLA();
        registerListener(this.ghk);
    }

    private void bLA() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021039, TbConfig.SERVER_ADDRESS + "ala/user/getUserInfoSDK");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetUserInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void LW() {
        HttpMessage httpMessage = new HttpMessage(1021039);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("meta_key", "");
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1021039);
        MessageManager.getInstance().unRegisterListener(this.ghk);
    }
}
