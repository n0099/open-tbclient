package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class c {
    private ax iNQ;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> iNR;
    private a iNS;
    private HttpMessageListener iNT = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.iNQ = getForbiddenFansResponse.getPageData();
                if (c.this.iNR == null) {
                    c.this.iNR = new ArrayList();
                }
                if (c.this.iNQ != null) {
                    if (c.this.iNQ.bnD() == 1) {
                        c.this.iNR.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.iNR.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.iNS != null) {
                    c.this.iNS.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.iNR);
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
        MessageManager.getInstance().registerListener(this.iNT);
    }

    public void cAl() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cAm() {
        if (this.iNQ == null || this.iNQ.bnF() == 1) {
            int bnD = this.iNQ != null ? this.iNQ.bnD() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bnD);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.iNQ != null && this.iNQ.bnF() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iNT);
    }

    public void a(a aVar) {
        this.iNS = aVar;
    }
}
