package com.baidu.tieba.faceshop.emotioncenter.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.emotioncenter.a.b;
import com.baidu.tieba.faceshop.emotioncenter.message.EmotionCenterResponseMessage;
/* loaded from: classes9.dex */
public class EmotionChangeModel extends BdBaseModel {
    private final HttpMessageListener iYw;

    public EmotionChangeModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.iYw = new HttpMessageListener(1003355) { // from class: com.baidu.tieba.faceshop.emotioncenter.model.EmotionChangeModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                b bVar;
                EmotionCenterResponseMessage emotionCenterResponseMessage;
                Object extra;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003355 && (httpResponsedMessage instanceof EmotionCenterResponseMessage)) {
                    if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof b)) {
                        bVar = null;
                    } else {
                        bVar = (b) extra;
                    }
                    if (bVar != null && (emotionCenterResponseMessage = (EmotionCenterResponseMessage) httpResponsedMessage) != null) {
                        bVar.c(emotionCenterResponseMessage.data);
                    }
                }
            }
        };
        registerTask();
        this.iYw.setTag(getUniqueId());
        this.iYw.setSelfListener(true);
        registerListener(this.iYw);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003355, TbConfig.SERVER_ADDRESS + Config.EMOTION_CENTER_CHANGE);
        tbHttpMessageTask.setResponsedClass(EmotionCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void c(b bVar) {
        HttpMessage httpMessage = new HttpMessage(1003355);
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(1003355);
        return true;
    }
}
