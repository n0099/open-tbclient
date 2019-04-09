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
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class GetEmotionInfosModel extends BdBaseModel {
    private a cnb;
    private final HttpMessageListener cnc = new HttpMessageListener(CmdConfigHttp.CMD_GET_EMOTION_INFOS) { // from class: com.baidu.tbadk.img.GetEmotionInfosModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003353 && (httpResponsedMessage instanceof GetEmotionInfosResponseMessage) && GetEmotionInfosModel.this.cnb != null) {
                GetEmotionInfosResponseMessage getEmotionInfosResponseMessage = (GetEmotionInfosResponseMessage) httpResponsedMessage;
                if (getEmotionInfosResponseMessage.getEmotionList() != null) {
                    GetEmotionInfosModel.this.cnb.ac(getEmotionInfosResponseMessage.getEmotionList());
                } else {
                    GetEmotionInfosModel.this.cnb.onFail(getEmotionInfosResponseMessage.getError(), getEmotionInfosResponseMessage.getErrorString());
                }
                GetEmotionInfosModel.this.cnb = null;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void ac(List<c> list);

        void onFail(int i, String str);
    }

    public GetEmotionInfosModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.cnc.setTag(getUniqueId());
        this.cnc.setSelfListener(true);
        registerListener(this.cnc);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_INFOS, TbConfig.SERVER_ADDRESS + "c/e/meme/pic2idJson");
        tbHttpMessageTask.setResponsedClass(GetEmotionInfosResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(List<String> list, a aVar) {
        int i = 0;
        this.cnb = aVar;
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
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_INFOS);
                httpMessage.addParam("pic_urls", com.baidu.tbadk.browser.d.kJ(jSONArray.toString()));
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
        MessageManager.getInstance().unRegisterListener(this.cnc);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_EMOTION_INFOS);
        return true;
    }
}
