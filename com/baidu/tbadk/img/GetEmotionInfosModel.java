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
/* loaded from: classes.dex */
public class GetEmotionInfosModel extends BdBaseModel {
    private a aGd;
    private final HttpMessageListener aGe = new HttpMessageListener(CmdConfigHttp.CMD_GET_EMOTION_INFOS) { // from class: com.baidu.tbadk.img.GetEmotionInfosModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003353 && (httpResponsedMessage instanceof GetEmotionInfosResponseMessage) && GetEmotionInfosModel.this.aGd != null) {
                GetEmotionInfosResponseMessage getEmotionInfosResponseMessage = (GetEmotionInfosResponseMessage) httpResponsedMessage;
                if (getEmotionInfosResponseMessage.getEmotionList() != null) {
                    GetEmotionInfosModel.this.aGd.B(getEmotionInfosResponseMessage.getEmotionList());
                } else {
                    GetEmotionInfosModel.this.aGd.onFail(getEmotionInfosResponseMessage.getError(), getEmotionInfosResponseMessage.getErrorString());
                }
                GetEmotionInfosModel.this.aGd = null;
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void B(List<c> list);

        void onFail(int i, String str);
    }

    public GetEmotionInfosModel() {
        setUniqueId(BdUniqueId.gen());
        El();
        this.aGe.setTag(getUniqueId());
        this.aGe.setSelfListener(true);
        registerListener(this.aGe);
    }

    private void El() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_EMOTION_INFOS, TbConfig.SERVER_ADDRESS + "c/e/meme/pic2idBatch");
        tbHttpMessageTask.setResponsedClass(GetEmotionInfosResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(List<String> list, a aVar) {
        int i = 0;
        this.aGd = aVar;
        if (list == null || list.isEmpty()) {
            if (aVar != null) {
                aVar.onFail(0, "list is empty");
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                String str = list.get(i2);
                if (!TextUtils.isEmpty(str)) {
                    sb.append(com.baidu.tbadk.browser.d.cc(str));
                    if (i2 < list.size() - 1) {
                        sb.append("_");
                    }
                }
                i = i2 + 1;
            } else {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_EMOTION_INFOS);
                httpMessage.addParam("pic_urls", sb.toString());
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
        MessageManager.getInstance().unRegisterListener(this.aGe);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_EMOTION_INFOS);
        return true;
    }
}
