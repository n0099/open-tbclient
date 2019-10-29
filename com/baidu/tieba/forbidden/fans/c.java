package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c {
    private an fqD;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> fqE;
    private a fqF;
    private HttpMessageListener fqG = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.fqD = getForbiddenFansResponse.getPageData();
                if (c.this.fqE == null) {
                    c.this.fqE = new ArrayList();
                }
                if (c.this.fqD != null) {
                    if (c.this.fqD.ahy() == 1) {
                        c.this.fqE.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.fqE.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.fqF != null) {
                    c.this.fqF.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.fqE);
                }
            }
        }
    };

    /* loaded from: classes5.dex */
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
        MessageManager.getInstance().registerListener(this.fqG);
    }

    public void bil() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bim() {
        if (this.fqD == null || this.fqD.ahA() == 1) {
            int ahy = this.fqD != null ? this.fqD.ahy() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, ahy);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.fqD != null && this.fqD.ahA() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fqG);
    }

    public void a(a aVar) {
        this.fqF = aVar;
    }
}
