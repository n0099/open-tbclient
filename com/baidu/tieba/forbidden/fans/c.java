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
/* loaded from: classes23.dex */
public class c {
    private av iCj;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> iCk;
    private a iCl;
    private HttpMessageListener iCm = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.iCj = getForbiddenFansResponse.getPageData();
                if (c.this.iCk == null) {
                    c.this.iCk = new ArrayList();
                }
                if (c.this.iCj != null) {
                    if (c.this.iCj.blo() == 1) {
                        c.this.iCk.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.iCk.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.iCl != null) {
                    c.this.iCl.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.iCk);
                }
            }
        }
    };

    /* loaded from: classes23.dex */
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
        MessageManager.getInstance().registerListener(this.iCm);
    }

    public void cwt() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cwu() {
        if (this.iCj == null || this.iCj.blq() == 1) {
            int blo = this.iCj != null ? this.iCj.blo() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, blo);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.iCj != null && this.iCj.blq() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iCm);
    }

    public void a(a aVar) {
        this.iCl = aVar;
    }
}
