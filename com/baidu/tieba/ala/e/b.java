package com.baidu.tieba.ala.e;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.message.AlaSdkGetGiftListHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.utils.q;
/* loaded from: classes2.dex */
public class b extends BdBaseModel {
    private a fmH;
    private HttpMessageListener fmI = new HttpMessageListener(1021120) { // from class: com.baidu.tieba.ala.e.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSdkGetGiftListHttpResponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == b.this.getUniqueId() && b.this.fmH != null) {
                AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage = (AlaSdkGetGiftListHttpResponseMessage) httpResponsedMessage;
                if (alaSdkGetGiftListHttpResponseMessage.getError() != 0 || !alaSdkGetGiftListHttpResponseMessage.isSuccess()) {
                    b.this.fmH.onFail(alaSdkGetGiftListHttpResponseMessage.getError(), alaSdkGetGiftListHttpResponseMessage.getErrorString());
                } else {
                    b.this.fmH.b(alaSdkGetGiftListHttpResponseMessage);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes2.dex */
    public interface a {
        void b(AlaSdkGetGiftListHttpResponseMessage alaSdkGetGiftListHttpResponseMessage);

        void onFail(int i, String str);
    }

    private void qz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021120, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getGiftListBySceneFrom");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaSdkGetGiftListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public b(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.fmH = aVar;
        qz();
        registerListener(this.fmI);
    }

    public void request() {
        sendMessage(new com.baidu.live.message.e(q.yO()));
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
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fmI);
        MessageManager.getInstance().unRegisterTask(1021120);
    }
}
