package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private al dwZ;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> dxa;
    private a dxb;
    private HttpMessageListener dxc = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.dwZ = getForbiddenFansResponse.getPageData();
                if (c.this.dxa == null) {
                    c.this.dxa = new ArrayList();
                }
                if (c.this.dwZ != null) {
                    if (c.this.dwZ.xJ() == 1) {
                        c.this.dxa.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.dxa.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.dxb != null) {
                    c.this.dxb.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.dxa);
                }
            }
        }
    };

    /* loaded from: classes3.dex */
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
        MessageManager.getInstance().registerListener(this.dxc);
    }

    public void axv() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void axw() {
        if (this.dwZ == null || this.dwZ.xL() == 1) {
            int xJ = this.dwZ != null ? this.dwZ.xJ() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, xJ);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.dwZ != null && this.dwZ.xL() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dxc);
    }

    public void a(a aVar) {
        this.dxb = aVar;
    }
}
