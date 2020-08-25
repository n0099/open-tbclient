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
/* loaded from: classes17.dex */
public class c {
    private av hNJ;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> hNK;
    private a hNL;
    private HttpMessageListener hNM = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.hNJ = getForbiddenFansResponse.getPageData();
                if (c.this.hNK == null) {
                    c.this.hNK = new ArrayList();
                }
                if (c.this.hNJ != null) {
                    if (c.this.hNJ.bds() == 1) {
                        c.this.hNK.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.hNK.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.hNL != null) {
                    c.this.hNL.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.hNK);
                }
            }
        }
    };

    /* loaded from: classes17.dex */
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
        MessageManager.getInstance().registerListener(this.hNM);
    }

    public void cjZ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cka() {
        if (this.hNJ == null || this.hNJ.bdu() == 1) {
            int bds = this.hNJ != null ? this.hNJ.bds() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bds);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.hNJ != null && this.hNJ.bdu() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hNM);
    }

    public void a(a aVar) {
        this.hNL = aVar;
    }
}
