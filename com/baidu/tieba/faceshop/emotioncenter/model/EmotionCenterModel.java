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
public class EmotionCenterModel extends BdBaseModel {
    private final HttpMessageListener iYI;
    private int pn;

    public EmotionCenterModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.pn = 1;
        this.iYI = new HttpMessageListener(1003354) { // from class: com.baidu.tieba.faceshop.emotioncenter.model.EmotionCenterModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                b bVar;
                EmotionCenterResponseMessage emotionCenterResponseMessage;
                Object extra;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003354 && (httpResponsedMessage instanceof EmotionCenterResponseMessage)) {
                    if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof b)) {
                        bVar = null;
                    } else {
                        bVar = (b) extra;
                    }
                    if (bVar != null && (emotionCenterResponseMessage = (EmotionCenterResponseMessage) httpResponsedMessage) != null) {
                        if (EmotionCenterModel.this.pn == 1) {
                            bVar.a(emotionCenterResponseMessage.data);
                        } else {
                            bVar.b(emotionCenterResponseMessage.data);
                        }
                    }
                }
            }
        };
        registerTask();
        this.iYI.setTag(getUniqueId());
        this.iYI.setSelfListener(true);
        registerListener(this.iYI);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003354, TbConfig.SERVER_ADDRESS + Config.EMOTION_CENTER_SHOP);
        tbHttpMessageTask.setResponsedClass(EmotionCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(b bVar) {
        this.pn = 1;
        HttpMessage httpMessage = new HttpMessage(1003354);
        httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 10);
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(1003354);
        return true;
    }

    public void b(b bVar) {
        HttpMessage httpMessage = new HttpMessage(1003354);
        int i = this.pn + 1;
        this.pn = i;
        httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, i);
        httpMessage.addParam("rn", 10);
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }
}
