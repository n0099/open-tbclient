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
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class GetEmotionInfosModel extends BdBaseModel {
    private a dwy;
    private final HttpMessageListener dwz = new HttpMessageListener(1003353) { // from class: com.baidu.tbadk.img.GetEmotionInfosModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003353 && (httpResponsedMessage instanceof GetEmotionInfosResponseMessage) && GetEmotionInfosModel.this.dwy != null) {
                GetEmotionInfosResponseMessage getEmotionInfosResponseMessage = (GetEmotionInfosResponseMessage) httpResponsedMessage;
                if (getEmotionInfosResponseMessage.getEmotionList() != null) {
                    GetEmotionInfosModel.this.dwy.onSuccess(getEmotionInfosResponseMessage.getEmotionList());
                } else {
                    GetEmotionInfosModel.this.dwy.onFail(getEmotionInfosResponseMessage.getError(), getEmotionInfosResponseMessage.getErrorString());
                }
                GetEmotionInfosModel.this.dwy = null;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void onFail(int i, String str);

        void onSuccess(List<c> list);
    }

    public GetEmotionInfosModel() {
        setUniqueId(BdUniqueId.gen());
        rT();
        this.dwz.setTag(getUniqueId());
        this.dwz.setSelfListener(true);
        registerListener(this.dwz);
    }

    private void rT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003353, TbConfig.SERVER_ADDRESS + Config.GET_EMOTION_INFOS);
        tbHttpMessageTask.setResponsedClass(GetEmotionInfosResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(List<String> list, a aVar) {
        int i = 0;
        this.dwy = aVar;
        if (list == null || list.isEmpty()) {
            if (aVar != null) {
                aVar.onFail(0, "list is empty");
                return;
            }
            return;
        }
        JSONArray jSONArray = new JSONArray();
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                String str = list.get(i2);
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
                i = i2 + 1;
            } else {
                HttpMessage httpMessage = new HttpMessage(1003353);
                httpMessage.addParam("pic_urls", com.baidu.tbadk.browser.d.rR(jSONArray.toString()));
                sendMessage(httpMessage);
                return;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.dwz);
        MessageManager.getInstance().unRegisterTask(1003353);
        return true;
    }
}
