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
/* loaded from: classes7.dex */
public class b {
    private az jda;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> jdb;
    private a jdc;
    private HttpMessageListener jdd = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                b.this.jda = getForbiddenFansResponse.getPageData();
                if (b.this.jdb == null) {
                    b.this.jdb = new ArrayList();
                }
                if (b.this.jda != null) {
                    if (b.this.jda.bmF() == 1) {
                        b.this.jdb.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        b.this.jdb.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (b.this.jdc != null) {
                    b.this.jdc.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), b.this.jdb);
                }
            }
        }
    };

    /* loaded from: classes7.dex */
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
        MessageManager.getInstance().registerListener(this.jdd);
    }

    public void cAM() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cAN() {
        if (this.jda == null || this.jda.bmH() == 1) {
            int bmF = this.jda != null ? this.jda.bmF() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bmF);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.jda != null && this.jda.bmH() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jdd);
    }

    public void a(a aVar) {
        this.jdc = aVar;
    }
}
