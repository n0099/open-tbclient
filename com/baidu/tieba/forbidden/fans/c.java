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
    private ap gjt;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> gju;
    private a gjv;
    private HttpMessageListener gjw = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.gjt = getForbiddenFansResponse.getPageData();
                if (c.this.gju == null) {
                    c.this.gju = new ArrayList();
                }
                if (c.this.gjt != null) {
                    if (c.this.gjt.aBg() == 1) {
                        c.this.gju.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.gju.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.gjv != null) {
                    c.this.gjv.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.gju);
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
        MessageManager.getInstance().registerListener(this.gjw);
    }

    public void bCi() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bCj() {
        if (this.gjt == null || this.gjt.aBi() == 1) {
            int aBg = this.gjt != null ? this.gjt.aBg() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, aBg);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.gjt != null && this.gjt.aBi() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gjw);
    }

    public void a(a aVar) {
        this.gjv = aVar;
    }
}
