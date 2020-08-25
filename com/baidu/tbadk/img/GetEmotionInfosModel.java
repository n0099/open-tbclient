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
/* loaded from: classes2.dex */
public class GetEmotionInfosModel extends BdBaseModel {
    private a eOO;
    private final HttpMessageListener eOP = new HttpMessageListener(1003353) { // from class: com.baidu.tbadk.img.GetEmotionInfosModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003353 && (httpResponsedMessage instanceof GetEmotionInfosResponseMessage) && GetEmotionInfosModel.this.eOO != null) {
                GetEmotionInfosResponseMessage getEmotionInfosResponseMessage = (GetEmotionInfosResponseMessage) httpResponsedMessage;
                if (getEmotionInfosResponseMessage.getEmotionList() != null) {
                    GetEmotionInfosModel.this.eOO.bd(getEmotionInfosResponseMessage.getEmotionList());
                } else {
                    GetEmotionInfosModel.this.eOO.onFail(getEmotionInfosResponseMessage.getError(), getEmotionInfosResponseMessage.getErrorString());
                }
                GetEmotionInfosModel.this.eOO = null;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void bd(List<c> list);

        void onFail(int i, String str);
    }

    public GetEmotionInfosModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.eOP.setTag(getUniqueId());
        this.eOP.setSelfListener(true);
        registerListener(this.eOP);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003353, TbConfig.SERVER_ADDRESS + Config.GET_EMOTION_INFOS);
        tbHttpMessageTask.setResponsedClass(GetEmotionInfosResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(List<String> list, a aVar) {
        int i = 0;
        this.eOO = aVar;
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
                httpMessage.addParam("pic_urls", com.baidu.tbadk.browser.d.yB(jSONArray.toString()));
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
        MessageManager.getInstance().unRegisterListener(this.eOP);
        MessageManager.getInstance().unRegisterTask(1003353);
        return true;
    }
}
