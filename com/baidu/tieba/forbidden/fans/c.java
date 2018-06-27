package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private am deY;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> deZ;
    private a dfa;
    private HttpMessageListener dfb = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.deY = getForbiddenFansResponse.getPageData();
                if (c.this.deZ == null) {
                    c.this.deZ = new ArrayList();
                }
                if (c.this.deY != null) {
                    if (c.this.deY.uD() == 1) {
                        c.this.deZ.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.deZ.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.dfa != null) {
                    c.this.dfa.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.deZ);
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
        MessageManager.getInstance().registerListener(this.dfb);
    }

    public void ask() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam(LegoListActivityConfig.RN, 20);
        httpMessage.addParam("pn", 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void asl() {
        if (this.deY == null || this.deY.uF() == 1) {
            int uD = this.deY != null ? this.deY.uD() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam(LegoListActivityConfig.RN, 20);
            httpMessage.addParam("pn", uD);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.deY != null && this.deY.uF() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dfb);
    }

    public void a(a aVar) {
        this.dfa = aVar;
    }
}
