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
    private ap gjI;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> gjJ;
    private a gjK;
    private HttpMessageListener gjL = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.gjI = getForbiddenFansResponse.getPageData();
                if (c.this.gjJ == null) {
                    c.this.gjJ = new ArrayList();
                }
                if (c.this.gjI != null) {
                    if (c.this.gjI.aBi() == 1) {
                        c.this.gjJ.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.gjJ.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.gjK != null) {
                    c.this.gjK.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.gjJ);
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
        MessageManager.getInstance().registerListener(this.gjL);
    }

    public void bCl() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bCm() {
        if (this.gjI == null || this.gjI.aBk() == 1) {
            int aBi = this.gjI != null ? this.gjI.aBi() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, aBi);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.gjI != null && this.gjI.aBk() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gjL);
    }

    public void a(a aVar) {
        this.gjK = aVar;
    }
}
