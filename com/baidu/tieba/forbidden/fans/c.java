package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class c {
    private aw iCY;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> iCZ;
    private a iDa;
    private HttpMessageListener iDb = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.iCY = getForbiddenFansResponse.getPageData();
                if (c.this.iCZ == null) {
                    c.this.iCZ = new ArrayList();
                }
                if (c.this.iCY != null) {
                    if (c.this.iCY.bkq() == 1) {
                        c.this.iCZ.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.iCZ.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.iDa != null) {
                    c.this.iDa.b(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.iCZ);
                }
            }
        }
    };

    /* loaded from: classes22.dex */
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
        MessageManager.getInstance().registerListener(this.iDb);
    }

    public void cvW() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void cvX() {
        if (this.iCY == null || this.iCY.bks() == 1) {
            int bkq = this.iCY != null ? this.iCY.bkq() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, bkq);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.iCY != null && this.iCY.bks() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iDb);
    }

    public void a(a aVar) {
        this.iDa = aVar;
    }
}
