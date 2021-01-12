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
/* loaded from: classes7.dex */
public class b {
    private ax iVw;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> iVx;
    private a iVy;
    private HttpMessageListener iVz = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                b.this.iVw = getForbiddenFansResponse.getPageData();
                if (b.this.iVx == null) {
                    b.this.iVx = new ArrayList();
                }
                if (b.this.iVw != null) {
                    if (b.this.iVw.bmk() == 1) {
                        b.this.iVx.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        b.this.iVx.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (b.this.iVy != null) {
                    b.this.iVy.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), b.this.iVx);
                }
            }
        }
    };

    /* loaded from: classes7.dex */
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
        MessageManager.getInstance().registerListener(this.iVz);
    }

    public void czo() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void czp() {
        if (this.iVw == null || this.iVw.bmm() == 1) {
            int bmk = this.iVw != null ? this.iVw.bmk() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bmk);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.iVw != null && this.iVw.bmm() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iVz);
    }

    public void a(a aVar) {
        this.iVy = aVar;
    }
}
