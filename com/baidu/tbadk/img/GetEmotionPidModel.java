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
import d.b.h0.b0.c;
/* loaded from: classes3.dex */
public class GetEmotionPidModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f13941e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f13942f = new a(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003331 || !(httpResponsedMessage instanceof GetEmotionPidResponseMessage) || GetEmotionPidModel.this.f13941e == null) {
                return;
            }
            GetEmotionPidResponseMessage getEmotionPidResponseMessage = (GetEmotionPidResponseMessage) httpResponsedMessage;
            if (getEmotionPidResponseMessage.getImageInfo() != null) {
                GetEmotionPidModel.this.f13941e.a(getEmotionPidResponseMessage.getImageInfo());
            } else {
                GetEmotionPidModel.this.f13941e.onFail(getEmotionPidResponseMessage.getError(), getEmotionPidResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(c cVar);

        void onFail(int i, String str);
    }

    public GetEmotionPidModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f13942f.setTag(getUniqueId());
        this.f13942f.setSelfListener(true);
        registerListener(this.f13942f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f13942f);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_EMOTION_PID, TbConfig.SERVER_ADDRESS + "c/e/meme/pic2id");
        tbHttpMessageTask.setResponsedClass(GetEmotionPidResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void t(String str, b bVar) {
        this.f13941e = bVar;
        if (TextUtils.isEmpty(str)) {
            if (bVar != null) {
                bVar.onFail(0, "picUrl is empty");
                return;
            }
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_PB_EMOTION_PID);
        httpMessage.addParam("pic_url", d.b.h0.l.c.o(str));
        sendMessage(httpMessage);
    }
}
