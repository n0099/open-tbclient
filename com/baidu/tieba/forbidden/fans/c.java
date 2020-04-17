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
    private HttpMessageListener gTA = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.gTx = getForbiddenFansResponse.getPageData();
                if (c.this.gTy == null) {
                    c.this.gTy = new ArrayList();
                }
                if (c.this.gTx != null) {
                    if (c.this.gTx.aJy() == 1) {
                        c.this.gTy.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.gTy.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.gTz != null) {
                    c.this.gTz.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.gTy);
                }
            }
        }
    };
    private ap gTx;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> gTy;
    private a gTz;

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
        MessageManager.getInstance().registerListener(this.gTA);
    }

    public void bMR() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void bMS() {
        if (this.gTx == null || this.gTx.aJA() == 1) {
            int aJy = this.gTx != null ? this.gTx.aJy() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, aJy);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.gTx != null && this.gTx.aJA() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gTA);
    }

    public void a(a aVar) {
        this.gTz = aVar;
    }
}
