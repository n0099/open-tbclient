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
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class GetEmotionInfosModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f13938e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f13939f = new a(CmdConfigHttp.CMD_GET_EMOTION_INFOS);

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003353 || !(httpResponsedMessage instanceof GetEmotionInfosResponseMessage) || GetEmotionInfosModel.this.f13938e == null) {
                return;
            }
            GetEmotionInfosResponseMessage getEmotionInfosResponseMessage = (GetEmotionInfosResponseMessage) httpResponsedMessage;
            if (getEmotionInfosResponseMessage.getEmotionList() != null) {
                GetEmotionInfosModel.this.f13938e.onSuccess(getEmotionInfosResponseMessage.getEmotionList());
            } else {
                GetEmotionInfosModel.this.f13938e.onFail(getEmotionInfosResponseMessage.getError(), getEmotionInfosResponseMessage.getErrorString());
            }
            GetEmotionInfosModel.this.f13938e = null;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onFail(int i, String str);

        void onSuccess(List<c> list);
    }

    public GetEmotionInfosModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f13939f.setTag(getUniqueId());
        this.f13939f.setSelfListener(true);
        registerListener(this.f13939f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f13939f);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_EMOTION_INFOS);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_INFOS, TbConfig.SERVER_ADDRESS + "c/e/meme/pic2idJson");
        tbHttpMessageTask.setResponsedClass(GetEmotionInfosResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void u(List<String> list, b bVar) {
        this.f13938e = bVar;
        if (list == null || list.isEmpty()) {
            if (bVar != null) {
                bVar.onFail(0, "list is empty");
                return;
            }
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                jSONArray.put(str);
            }
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_INFOS);
        httpMessage.addParam("pic_urls", d.b.h0.l.c.o(jSONArray.toString()));
        sendMessage(httpMessage);
    }
}
