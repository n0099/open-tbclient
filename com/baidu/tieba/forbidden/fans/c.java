package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class c {
    private av hUP;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> hUQ;
    private a hUR;
    private HttpMessageListener hUS = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.hUP = getForbiddenFansResponse.getPageData();
                if (c.this.hUQ == null) {
                    c.this.hUQ = new ArrayList();
                }
                if (c.this.hUP != null) {
                    if (c.this.hUP.bem() == 1) {
                        c.this.hUQ.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.hUQ.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.hUR != null) {
                    c.this.hUR.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.hUQ);
                }
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void b(int i, String str, ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList);
    }

    public c() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS, TbConfig.SERVER_ADDRESS + TbConfig.GET_FORBIDDEN_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetForbiddenFansResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.hUS);
    }

    public void cnn() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cno() {
        if (this.hUP == null || this.hUP.beo() == 1) {
            int bem = this.hUP != null ? this.hUP.bem() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bem);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.hUP != null && this.hUP.beo() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hUS);
    }

    public void a(a aVar) {
        this.hUR = aVar;
    }
}
