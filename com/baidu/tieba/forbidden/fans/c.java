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
    private ap gTD;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> gTE;
    private a gTF;
    private HttpMessageListener gTG = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.gTD = getForbiddenFansResponse.getPageData();
                if (c.this.gTE == null) {
                    c.this.gTE = new ArrayList();
                }
                if (c.this.gTD != null) {
                    if (c.this.gTD.aJw() == 1) {
                        c.this.gTE.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.gTE.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.gTF != null) {
                    c.this.gTF.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.gTE);
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
        MessageManager.getInstance().registerListener(this.gTG);
    }

    public void bMQ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bMR() {
        if (this.gTD == null || this.gTD.aJy() == 1) {
            int aJw = this.gTD != null ? this.gTD.aJw() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, aJw);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.gTD != null && this.gTD.aJy() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gTG);
    }

    public void a(a aVar) {
        this.gTF = aVar;
    }
}
