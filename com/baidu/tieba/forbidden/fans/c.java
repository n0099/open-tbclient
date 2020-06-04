package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ao;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class c {
    private ao hiA;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> hiB;
    private a hiC;
    private HttpMessageListener hiD = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.hiA = getForbiddenFansResponse.getPageData();
                if (c.this.hiB == null) {
                    c.this.hiB = new ArrayList();
                }
                if (c.this.hiA != null) {
                    if (c.this.hiA.aPr() == 1) {
                        c.this.hiB.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.hiB.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.hiC != null) {
                    c.this.hiC.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.hiB);
                }
            }
        }
    };

    /* loaded from: classes10.dex */
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
        MessageManager.getInstance().registerListener(this.hiD);
    }

    public void bTn() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bTo() {
        if (this.hiA == null || this.hiA.aPt() == 1) {
            int aPr = this.hiA != null ? this.hiA.aPr() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, aPr);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.hiA != null && this.hiA.aPt() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hiD);
    }

    public void a(a aVar) {
        this.hiC = aVar;
    }
}
