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
/* loaded from: classes8.dex */
public class b {
    private ax jad;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> jae;
    private a jaf;
    private HttpMessageListener jag = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                b.this.jad = getForbiddenFansResponse.getPageData();
                if (b.this.jae == null) {
                    b.this.jae = new ArrayList();
                }
                if (b.this.jad != null) {
                    if (b.this.jad.bqd() == 1) {
                        b.this.jae.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        b.this.jae.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (b.this.jaf != null) {
                    b.this.jaf.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), b.this.jae);
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void b(int i, String str, ArrayList<com.baidu.tieba.forbidden.fans.a> arrayList);
    }

    public b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS, TbConfig.SERVER_ADDRESS + TbConfig.GET_FORBIDDEN_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetForbiddenFansResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.jag);
    }

    public void cDf() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cDg() {
        if (this.jad == null || this.jad.bqf() == 1) {
            int bqd = this.jad != null ? this.jad.bqd() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bqd);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.jad != null && this.jad.bqf() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jag);
    }

    public void a(a aVar) {
        this.jaf = aVar;
    }
}
