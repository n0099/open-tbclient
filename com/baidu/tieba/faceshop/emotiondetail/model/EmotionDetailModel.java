package com.baidu.tieba.faceshop.emotiondetail.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.emotiondetail.message.EmotionDetailResponseMessage;
/* loaded from: classes8.dex */
public class EmotionDetailModel extends BdBaseModel {
    private HttpMessageListener iUc = new HttpMessageListener(1003361) { // from class: com.baidu.tieba.faceshop.emotiondetail.model.EmotionDetailModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003361 && (httpResponsedMessage instanceof EmotionDetailResponseMessage) && EmotionDetailModel.this.mLoadDataCallBack != null) {
                EmotionDetailModel.this.mLoadDataCallBack.callback(((EmotionDetailResponseMessage) httpResponsedMessage).data);
            }
        }
    };

    public EmotionDetailModel() {
        setUniqueId(BdUniqueId.gen());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003361, TbConfig.SERVER_ADDRESS + TbConfig.EMOTION_DETAIL);
        tbHttpMessageTask.setResponsedClass(EmotionDetailResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.iUc.setTag(getUniqueId());
        this.iUc.setSelfListener(true);
        registerListener(this.iUc);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public void B(long j, int i) {
        if (j >= 0 || i >= 0) {
            HttpMessage httpMessage = new HttpMessage(1003361);
            httpMessage.addParam(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, j);
            httpMessage.addParam("pck_id", i);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(1003361);
        MessageManager.getInstance().unRegisterListener(this.iUc);
        return true;
    }
}
