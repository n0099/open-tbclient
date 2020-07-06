package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class c {
    private at huJ;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> huK;
    private a huL;
    private HttpMessageListener huM = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.huJ = getForbiddenFansResponse.getPageData();
                if (c.this.huK == null) {
                    c.this.huK = new ArrayList();
                }
                if (c.this.huJ != null) {
                    if (c.this.huJ.aRd() == 1) {
                        c.this.huK.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.huK.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.huL != null) {
                    c.this.huL.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.huK);
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
        MessageManager.getInstance().registerListener(this.huM);
    }

    public void bWk() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bWl() {
        if (this.huJ == null || this.huJ.aRf() == 1) {
            int aRd = this.huJ != null ? this.huJ.aRd() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, aRd);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.huJ != null && this.huJ.aRf() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.huM);
    }

    public void a(a aVar) {
        this.huL = aVar;
    }
}
