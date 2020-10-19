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
    private av ijO;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> ijP;
    private a ijQ;
    private HttpMessageListener ijR = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.ijO = getForbiddenFansResponse.getPageData();
                if (c.this.ijP == null) {
                    c.this.ijP = new ArrayList();
                }
                if (c.this.ijO != null) {
                    if (c.this.ijO.bgV() == 1) {
                        c.this.ijP.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.ijP.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.ijQ != null) {
                    c.this.ijQ.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.ijP);
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
        MessageManager.getInstance().registerListener(this.ijR);
    }

    public void cqL() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cqM() {
        if (this.ijO == null || this.ijO.bgX() == 1) {
            int bgV = this.ijO != null ? this.ijO.bgV() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bgV);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.ijO != null && this.ijO.bgX() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ijR);
    }

    public void a(a aVar) {
        this.ijQ = aVar;
    }
}
