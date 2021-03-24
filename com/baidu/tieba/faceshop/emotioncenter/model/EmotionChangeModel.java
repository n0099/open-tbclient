package com.baidu.tieba.faceshop.emotioncenter.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.emotioncenter.message.EmotionCenterResponseMessage;
import d.b.i0.l0.y.d.b;
/* loaded from: classes4.dex */
public class EmotionChangeModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f15773e;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(EmotionChangeModel emotionChangeModel, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            EmotionCenterResponseMessage emotionCenterResponseMessage;
            Object extra;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003355 && (httpResponsedMessage instanceof EmotionCenterResponseMessage)) {
                b bVar = null;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof b)) {
                    bVar = (b) extra;
                }
                if (bVar == null || (emotionCenterResponseMessage = (EmotionCenterResponseMessage) httpResponsedMessage) == null) {
                    return;
                }
                bVar.B(emotionCenterResponseMessage.data);
            }
        }
    }

    public EmotionChangeModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.f15773e = new a(this, CmdConfigHttp.CMD_GET_EMOTION_EMOTION_CHANGE);
        registerTask();
        this.f15773e.setTag(getUniqueId());
        this.f15773e.setSelfListener(true);
        registerListener(this.f15773e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_CHANGE);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_CHANGE, TbConfig.SERVER_ADDRESS + "c/e/meme/dice");
        tbHttpMessageTask.setResponsedClass(EmotionCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void s(b bVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_CHANGE);
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }
}
