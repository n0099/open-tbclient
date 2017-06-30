package com.baidu.tbadk.img;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.j;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class GetEmotionPidModel extends BdBaseModel {
    private a aEo;
    private final HttpMessageListener aEp = new d(this, CmdConfigHttp.CMD_GET_PB_EMOTION_PID);

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar);

        void onFail(int i, String str);
    }

    public GetEmotionPidModel() {
        DU();
        this.aEp.setTag(getUniqueId());
        this.aEp.setSelfListener(true);
        registerListener(this.aEp);
    }

    private void DU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_EMOTION_PID, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/meme/pic2id");
        tbHttpMessageTask.setResponsedClass(GetEmotionPidResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, a aVar) {
        this.aEo = aVar;
        if (TextUtils.isEmpty(str)) {
            if (aVar != null) {
                aVar.onFail(0, "picUrl is empty");
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
        httpMessage.addParam("pic_url", j.bY(str));
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.aEp);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
        return true;
    }
}
