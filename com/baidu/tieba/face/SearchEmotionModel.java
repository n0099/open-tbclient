package com.baidu.tieba.face;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class SearchEmotionModel extends BdBaseModel {
    private final HttpMessageListener aQM = new HttpMessageListener(CmdConfigHttp.CMD_SEARCH_PB_EMOTION) { // from class: com.baidu.tieba.face.SearchEmotionModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003330 && (httpResponsedMessage instanceof SearchEmotionResponseMessage) && SearchEmotionModel.this.cSF != null) {
                SearchEmotionResponseMessage searchEmotionResponseMessage = (SearchEmotionResponseMessage) httpResponsedMessage;
                if (searchEmotionResponseMessage.getData() != null) {
                    if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                        SearchEmotionModel.this.cSF.a((String) httpResponsedMessage.getOrginalMessage().getExtra(), searchEmotionResponseMessage.getData());
                        return;
                    }
                    return;
                }
                if (!TextUtils.isEmpty(searchEmotionResponseMessage.getErrorString())) {
                    l.showToast(TbadkCoreApplication.getInst(), searchEmotionResponseMessage.getErrorString());
                }
                SearchEmotionModel.this.cSF.onFail(searchEmotionResponseMessage.getError(), searchEmotionResponseMessage.getErrorString());
            }
        }
    };
    private a cSF;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, com.baidu.tieba.face.data.a aVar);

        void onFail(int i, String str);
    }

    public SearchEmotionModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.aQM.setTag(getUniqueId());
        this.aQM.setSelfListener(true);
        registerListener(this.aQM);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SEARCH_PB_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/search");
        tbHttpMessageTask.setResponsedClass(SearchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, int i, int i2, a aVar) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            this.cSF = aVar;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_PB_EMOTION);
            httpMessage.addParam("kw", str);
            httpMessage.addParam("pn", i);
            httpMessage.addParam(LegoListActivityConfig.RN, i2);
            httpMessage.setExtra(str);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(getUniqueId());
        this.cSF = null;
        return true;
    }
}
