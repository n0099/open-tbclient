package com.baidu.tieba.faceshop.emotiondetail.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.emotiondetail.message.EmotionDetailResponseMessage;
/* loaded from: classes4.dex */
public class EmotionDetailModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public HttpMessageListener f14855e = new a(CmdConfigHttp.CMD_EMOTION_DETAIL);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003361 || !(httpResponsedMessage instanceof EmotionDetailResponseMessage) || EmotionDetailModel.this.mLoadDataCallBack == null) {
                return;
            }
            EmotionDetailModel.this.mLoadDataCallBack.c(((EmotionDetailResponseMessage) httpResponsedMessage).data);
        }
    }

    public EmotionDetailModel() {
        setUniqueId(BdUniqueId.gen());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_EMOTION_DETAIL, TbConfig.SERVER_ADDRESS + TbConfig.EMOTION_DETAIL);
        tbHttpMessageTask.setResponsedClass(EmotionDetailResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.f14855e.setTag(getUniqueId());
        this.f14855e.setSelfListener(true);
        registerListener(this.f14855e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_EMOTION_DETAIL);
        MessageManager.getInstance().unRegisterListener(this.f14855e);
        return true;
    }

    public void u(long j, int i2) {
        if (j >= 0 || i2 >= 0) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_EMOTION_DETAIL);
            httpMessage.addParam(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY, j);
            httpMessage.addParam("pck_id", i2);
            sendMessage(httpMessage);
        }
    }
}
