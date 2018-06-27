package com.baidu.tbadk.img;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class GetEmotionPidModel extends BdBaseModel {
    private a aQO;
    private final HttpMessageListener aQP = new HttpMessageListener(CmdConfigHttp.CMD_GET_PB_EMOTION_PID) { // from class: com.baidu.tbadk.img.GetEmotionPidModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003331 && (httpResponsedMessage instanceof GetEmotionPidResponseMessage) && GetEmotionPidModel.this.aQO != null) {
                GetEmotionPidResponseMessage getEmotionPidResponseMessage = (GetEmotionPidResponseMessage) httpResponsedMessage;
                if (getEmotionPidResponseMessage.getImageInfo() != null) {
                    GetEmotionPidModel.this.aQO.a(getEmotionPidResponseMessage.getImageInfo());
                } else {
                    GetEmotionPidModel.this.aQO.onFail(getEmotionPidResponseMessage.getError(), getEmotionPidResponseMessage.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar);

        void onFail(int i, String str);
    }

    public GetEmotionPidModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.aQP.setTag(getUniqueId());
        this.aQP.setSelfListener(true);
        registerListener(this.aQP);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_EMOTION_PID, TbConfig.SERVER_ADDRESS + "c/e/meme/pic2id");
        tbHttpMessageTask.setResponsedClass(GetEmotionPidResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, a aVar) {
        this.aQO = aVar;
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.onFail(0, "picUrl is empty");
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
        httpMessage.addParam("pic_url", com.baidu.tbadk.browser.d.cT(str));
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.aQP);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
        return true;
    }
}
