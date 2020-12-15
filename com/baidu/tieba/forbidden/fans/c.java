package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class c {
    private ax iNS;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> iNT;
    private a iNU;
    private HttpMessageListener iNV = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.iNS = getForbiddenFansResponse.getPageData();
                if (c.this.iNT == null) {
                    c.this.iNT = new ArrayList();
                }
                if (c.this.iNS != null) {
                    if (c.this.iNS.bnD() == 1) {
                        c.this.iNT.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.iNT.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.iNU != null) {
                    c.this.iNU.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.iNT);
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
        MessageManager.getInstance().registerListener(this.iNV);
    }

    public void cAm() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cAn() {
        if (this.iNS == null || this.iNS.bnF() == 1) {
            int bnD = this.iNS != null ? this.iNS.bnD() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bnD);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.iNS != null && this.iNS.bnF() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iNV);
    }

    public void a(a aVar) {
        this.iNU = aVar;
    }
}
