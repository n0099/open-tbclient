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
/* loaded from: classes7.dex */
public class c {
    private ap gei;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> gej;
    private a gek;
    private HttpMessageListener gel = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.gei = getForbiddenFansResponse.getPageData();
                if (c.this.gej == null) {
                    c.this.gej = new ArrayList();
                }
                if (c.this.gei != null) {
                    if (c.this.gei.ayw() == 1) {
                        c.this.gej.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.gej.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.gek != null) {
                    c.this.gek.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.gej);
                }
            }
        }
    };

    /* loaded from: classes7.dex */
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
        MessageManager.getInstance().registerListener(this.gel);
    }

    public void bzE() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bzF() {
        if (this.gei == null || this.gei.ayy() == 1) {
            int ayw = this.gei != null ? this.gei.ayw() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, ayw);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.gei != null && this.gei.ayy() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gel);
    }

    public void a(a aVar) {
        this.gek = aVar;
    }
}
