package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b {
    private az jbd;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> jbe;
    private a jbf;
    private HttpMessageListener jbg = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                b.this.jbd = getForbiddenFansResponse.getPageData();
                if (b.this.jbe == null) {
                    b.this.jbe = new ArrayList();
                }
                if (b.this.jbd != null) {
                    if (b.this.jbd.bmD() == 1) {
                        b.this.jbe.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        b.this.jbe.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (b.this.jbf != null) {
                    b.this.jbf.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), b.this.jbe);
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void b(int i, String str, ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList);
    }

    public b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS, TbConfig.SERVER_ADDRESS + TbConfig.GET_FORBIDDEN_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetForbiddenFansResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.jbg);
    }

    public void cAz() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cAA() {
        if (this.jbd == null || this.jbd.bmF() == 1) {
            int bmD = this.jbd != null ? this.jbd.bmD() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bmD);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.jbd != null && this.jbd.bmF() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jbg);
    }

    public void a(a aVar) {
        this.jbf = aVar;
    }
}
