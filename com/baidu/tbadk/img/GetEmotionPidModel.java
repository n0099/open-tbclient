package com.baidu.tbadk.img;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class GetEmotionPidModel extends BdBaseModel {
    private a cIK;
    private final HttpMessageListener cIL = new HttpMessageListener(1003331) { // from class: com.baidu.tbadk.img.GetEmotionPidModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003331 && (httpResponsedMessage instanceof GetEmotionPidResponseMessage) && GetEmotionPidModel.this.cIK != null) {
                GetEmotionPidResponseMessage getEmotionPidResponseMessage = (GetEmotionPidResponseMessage) httpResponsedMessage;
                if (getEmotionPidResponseMessage.getImageInfo() != null) {
                    GetEmotionPidModel.this.cIK.a(getEmotionPidResponseMessage.getImageInfo());
                } else {
                    GetEmotionPidModel.this.cIK.onFail(getEmotionPidResponseMessage.getError(), getEmotionPidResponseMessage.getErrorString());
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
        this.cIL.setTag(getUniqueId());
        this.cIL.setSelfListener(true);
        registerListener(this.cIL);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003331, TbConfig.SERVER_ADDRESS + Config.GET_PB_EMOTION_PID);
        tbHttpMessageTask.setResponsedClass(GetEmotionPidResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, a aVar) {
        this.cIK = aVar;
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.onFail(0, "picUrl is empty");
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(1003331);
        httpMessage.addParam("pic_url", com.baidu.tbadk.browser.d.mA(str));
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.cIL);
        MessageManager.getInstance().unRegisterTask(1003331);
        return true;
    }
}
