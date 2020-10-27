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
/* loaded from: classes23.dex */
public class c {
    private av iwm;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> iwn;
    private a iwo;
    private HttpMessageListener iwp = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.iwm = getForbiddenFansResponse.getPageData();
                if (c.this.iwn == null) {
                    c.this.iwn = new ArrayList();
                }
                if (c.this.iwm != null) {
                    if (c.this.iwm.biO() == 1) {
                        c.this.iwn.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.iwn.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.iwo != null) {
                    c.this.iwo.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.iwn);
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
        MessageManager.getInstance().registerListener(this.iwp);
    }

    public void ctS() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void ctT() {
        if (this.iwm == null || this.iwm.biQ() == 1) {
            int biO = this.iwm != null ? this.iwm.biO() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, biO);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.iwm != null && this.iwm.biQ() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iwp);
    }

    public void a(a aVar) {
        this.iwo = aVar;
    }
}
