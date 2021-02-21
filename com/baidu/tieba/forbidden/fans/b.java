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
    private az jbr;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> jbs;
    private a jbt;
    private HttpMessageListener jbu = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                b.this.jbr = getForbiddenFansResponse.getPageData();
                if (b.this.jbs == null) {
                    b.this.jbs = new ArrayList();
                }
                if (b.this.jbr != null) {
                    if (b.this.jbr.bmD() == 1) {
                        b.this.jbs.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        b.this.jbs.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (b.this.jbt != null) {
                    b.this.jbt.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), b.this.jbs);
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
        MessageManager.getInstance().registerListener(this.jbu);
    }

    public void cAG() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cAH() {
        if (this.jbr == null || this.jbr.bmF() == 1) {
            int bmD = this.jbr != null ? this.jbr.bmD() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bmD);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.jbr != null && this.jbr.bmF() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jbu);
    }

    public void a(a aVar) {
        this.jbt = aVar;
    }
}
