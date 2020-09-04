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
/* loaded from: classes17.dex */
public class c {
    private av hNP;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> hNQ;
    private a hNR;
    private HttpMessageListener hNS = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.hNP = getForbiddenFansResponse.getPageData();
                if (c.this.hNQ == null) {
                    c.this.hNQ = new ArrayList();
                }
                if (c.this.hNP != null) {
                    if (c.this.hNP.bds() == 1) {
                        c.this.hNQ.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.hNQ.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.hNR != null) {
                    c.this.hNR.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.hNQ);
                }
            }
        }
    };

    /* loaded from: classes17.dex */
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
        MessageManager.getInstance().registerListener(this.hNS);
    }

    public void cka() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void ckb() {
        if (this.hNP == null || this.hNP.bdu() == 1) {
            int bds = this.hNP != null ? this.hNP.bds() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bds);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.hNP != null && this.hNP.bdu() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hNS);
    }

    public void a(a aVar) {
        this.hNR = aVar;
    }
}
