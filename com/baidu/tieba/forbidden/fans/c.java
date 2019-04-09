package com.baidu.tieba.forbidden.fans;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.an;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c {
    private an eTW;
    private ArrayList<com.baidu.tieba.forbidden.fans.a> eTX;
    private a eTY;
    private HttpMessageListener eTZ = new HttpMessageListener(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS) { // from class: com.baidu.tieba.forbidden.fans.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof GetForbiddenFansResponse) {
                GetForbiddenFansResponse getForbiddenFansResponse = (GetForbiddenFansResponse) httpResponsedMessage;
                c.this.eTW = getForbiddenFansResponse.getPageData();
                if (c.this.eTX == null) {
                    c.this.eTX = new ArrayList();
                }
                if (c.this.eTW != null) {
                    if (c.this.eTW.XF() == 1) {
                        c.this.eTX.clear();
                    }
                    if (getForbiddenFansResponse.getFansList() != null) {
                        c.this.eTX.addAll(getForbiddenFansResponse.getFansList());
                    }
                }
                if (c.this.eTY != null) {
                    c.this.eTY.a(getForbiddenFansResponse.getError(), getForbiddenFansResponse.getErrorString(), c.this.eTX);
                }
            }
        }
    };

    /* loaded from: classes5.dex */
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
        MessageManager.getInstance().registerListener(this.eTZ);
    }

    public void baO() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
        httpMessage.addParam("rn", 20);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void baP() {
        if (this.eTW == null || this.eTW.XH() == 1) {
            int XF = this.eTW != null ? this.eTW.XF() + 1 : 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MY_FORBIDDEN_FANS);
            httpMessage.addParam("rn", 20);
            httpMessage.addParam(Config.PACKAGE_NAME, XF);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public boolean hasMore() {
        return this.eTW != null && this.eTW.XH() == 1;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.eTZ);
    }

    public void a(a aVar) {
        this.eTY = aVar;
    }
}
