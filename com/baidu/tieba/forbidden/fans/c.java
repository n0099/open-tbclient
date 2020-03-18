package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class c {
    private ap gkq;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> gkr;
    private a gks;
    private HttpMessageListener gkt = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.gkq = getForbiddenFansResponse.getPageData();
                if (c.this.gkr == null) {
                    c.this.gkr = new ArrayList();
                }
                if (c.this.gkq != null) {
                    if (c.this.gkq.aBl() == 1) {
                        c.this.gkr.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.gkr.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.gks != null) {
                    c.this.gks.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.gkr);
                }
            }
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void a(int i, String str, ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList);
    }

    public c() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS, TbConfig.SERVER_ADDRESS + TbConfig.GET_FORBIDDEN_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetForbiddenFansResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gkt);
    }

    public void bCr() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bCs() {
        if (this.gkq == null || this.gkq.aBn() == 1) {
            int aBl = this.gkq != null ? this.gkq.aBl() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, aBl);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.gkq != null && this.gkq.aBn() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gkt);
    }

    public void a(a aVar) {
        this.gks = aVar;
    }
}
