package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class d {
    private BdUniqueId aqU;
    private HttpMessageListener aqW = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getOrginalMessage() != null) {
                boolean z = httpResponsedMessage.getOrginalMessage().getTag() == d.this.aqU;
                if (d.this.dfd != null) {
                    d.this.dfd.d(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), z);
                }
            }
        }
    };
    private a dfd;
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void d(int i, String str, boolean z);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aqU = bdUniqueId;
        this.aqW.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.aqW);
        registerTask();
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS, TbConfig.SERVER_ADDRESS + TbConfig.REMOVE_MULTI_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void asm() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_REMOVE_ALL_FORBIDDEN_FANS);
        httpMessage.setTag(this.aqU);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.dfd = aVar;
    }
}
