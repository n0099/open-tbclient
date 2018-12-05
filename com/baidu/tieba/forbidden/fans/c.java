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
    private a dDA;
    private HttpMessageListener dDB = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.dDy = getForbiddenFansResponse.getPageData();
                if (c.this.dDz == null) {
                    c.this.dDz = new ArrayList();
                }
                if (c.this.dDy != null) {
                    if (c.this.dDy.yN() == 1) {
                        c.this.dDz.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.dDz.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.dDA != null) {
                    c.this.dDA.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.dDz);
                }
            }
        }
    };
    private al dDy;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> dDz;

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
        MessageManager.getInstance().registerListener(this.dDB);
    }

    public void azf() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void azg() {
        if (this.dDy == null || this.dDy.yP() == 1) {
            int yN = this.dDy != null ? this.dDy.yN() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, yN);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.dDy != null && this.dDy.yP() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dDB);
    }

    public void a(a aVar) {
        this.dDA = aVar;
    }
}
