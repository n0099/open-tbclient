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
    private ap gjv;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> gjw;
    private a gjx;
    private HttpMessageListener gjy = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.gjv = getForbiddenFansResponse.getPageData();
                if (c.this.gjw == null) {
                    c.this.gjw = new ArrayList();
                }
                if (c.this.gjv != null) {
                    if (c.this.gjv.aBi() == 1) {
                        c.this.gjw.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.gjw.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.gjx != null) {
                    c.this.gjx.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.gjw);
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
        MessageManager.getInstance().registerListener(this.gjy);
    }

    public void bCk() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bCl() {
        if (this.gjv == null || this.gjv.aBk() == 1) {
            int aBi = this.gjv != null ? this.gjv.aBi() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, aBi);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.gjv != null && this.gjv.aBk() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gjy);
    }

    public void a(a aVar) {
        this.gjx = aVar;
    }
}
