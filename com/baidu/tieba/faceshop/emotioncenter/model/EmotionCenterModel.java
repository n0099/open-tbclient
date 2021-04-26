package com.baidu.tieba.faceshop.emotioncenter.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.emotioncenter.message.EmotionCenterResponseMessage;
import d.a.j0.l0.y.d.b;
/* loaded from: classes4.dex */
public class EmotionCenterModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public int f15595e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f15596f;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            EmotionCenterResponseMessage emotionCenterResponseMessage;
            Object extra;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003354 && (httpResponsedMessage instanceof EmotionCenterResponseMessage)) {
                b bVar = null;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof b)) {
                    bVar = (b) extra;
                }
                if (bVar == null || (emotionCenterResponseMessage = (EmotionCenterResponseMessage) httpResponsedMessage) == null) {
                    return;
                }
                if (EmotionCenterModel.this.f15595e == 1) {
                    bVar.h0(emotionCenterResponseMessage.data);
                } else {
                    bVar.T(emotionCenterResponseMessage.data);
                }
            }
        }
    }

    public EmotionCenterModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        this.f15595e = 1;
        this.f15596f = new a(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
        registerTask();
        this.f15596f.setTag(getUniqueId());
        this.f15596f.setSelfListener(true);
        registerListener(this.f15596f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP, TbConfig.SERVER_ADDRESS + "c/e/meme/shop");
        tbHttpMessageTask.setResponsedClass(EmotionCenterResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void t(b bVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
        int i2 = this.f15595e + 1;
        this.f15595e = i2;
        httpMessage.addParam(Config.PACKAGE_NAME, i2);
        httpMessage.addParam("rn", 10);
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }

    public void u(b bVar) {
        this.f15595e = 1;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_EMOTION_SHOP);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 10);
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }
}
