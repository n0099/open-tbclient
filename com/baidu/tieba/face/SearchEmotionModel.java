package com.baidu.tieba.face;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class SearchEmotionModel extends BdBaseModel {
    private final HttpMessageListener aGM = new HttpMessageListener(CmdConfigHttp.CMD_SEARCH_PB_EMOTION) { // from class: com.baidu.tieba.face.SearchEmotionModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003330 && (httpResponsedMessage instanceof SearchEmotionResponseMessage) && SearchEmotionModel.this.cbv != null) {
                SearchEmotionResponseMessage searchEmotionResponseMessage = (SearchEmotionResponseMessage) httpResponsedMessage;
                if (searchEmotionResponseMessage.getData() != null) {
                    SearchEmotionModel.this.cbv.a(searchEmotionResponseMessage.getData());
                } else {
                    SearchEmotionModel.this.cbv.onFail(searchEmotionResponseMessage.getError(), searchEmotionResponseMessage.getErrorString());
                }
            }
        }
    };
    private a cbv;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.face.data.a aVar);

        void onFail(int i, String str);
    }

    public SearchEmotionModel() {
        Eo();
        this.aGM.setTag(getUniqueId());
        this.aGM.setSelfListener(true);
        registerListener(this.aGM);
    }

    private void Eo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SEARCH_PB_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/search");
        tbHttpMessageTask.setResponsedClass(SearchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, int i, int i2, a aVar) {
        this.cbv = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_PB_EMOTION);
        httpMessage.addParam("kw", str);
        httpMessage.addParam("pn", i);
        httpMessage.addParam(LegoListActivityConfig.RN, i2);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.aGM);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_SEARCH_PB_EMOTION);
        this.cbv = null;
        return true;
    }
}
