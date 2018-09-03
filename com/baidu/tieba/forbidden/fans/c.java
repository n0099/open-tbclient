package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private al dhM;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> dhN;
    private a dhO;
    private HttpMessageListener dhP = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.dhM = getForbiddenFansResponse.getPageData();
                if (c.this.dhN == null) {
                    c.this.dhN = new ArrayList();
                }
                if (c.this.dhM != null) {
                    if (c.this.dhM.up() == 1) {
                        c.this.dhN.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.dhN.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.dhO != null) {
                    c.this.dhO.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.dhN);
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
        MessageManager.getInstance().registerListener(this.dhP);
    }

    public void asN() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam(LegoListActivityConfig.RN, 20);
        httpMessage.addParam("pn", 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void asO() {
        if (this.dhM == null || this.dhM.ur() == 1) {
            int up = this.dhM != null ? this.dhM.up() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam(LegoListActivityConfig.RN, 20);
            httpMessage.addParam("pn", up);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.dhM != null && this.dhM.ur() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dhP);
    }

    public void a(a aVar) {
        this.dhO = aVar;
    }
}
