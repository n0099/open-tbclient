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
    private al dGV;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> dGW;
    private a dGX;
    private HttpMessageListener dGY = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.dGV = getForbiddenFansResponse.getPageData();
                if (c.this.dGW == null) {
                    c.this.dGW = new ArrayList();
                }
                if (c.this.dGV != null) {
                    if (c.this.dGV.za() == 1) {
                        c.this.dGW.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.dGW.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.dGX != null) {
                    c.this.dGX.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.dGW);
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
        MessageManager.getInstance().registerListener(this.dGY);
    }

    public void aAr() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void aAs() {
        if (this.dGV == null || this.dGV.zc() == 1) {
            int za = this.dGV != null ? this.dGV.za() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, za);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.dGV != null && this.dGV.zc() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dGY);
    }

    public void a(a aVar) {
        this.dGX = aVar;
    }
}
