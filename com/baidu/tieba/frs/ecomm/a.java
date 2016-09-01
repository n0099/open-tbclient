package com.baidu.tieba.frs.ecomm;

import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
public class a extends e<FrsActivity> {
    private FrsActivity bRp;
    private InterfaceC0057a bUK;
    private HttpMessageListener bwj = new b(this, CmdConfigHttp.ECOMM_CAN_SEND_THREAD, true);

    /* renamed from: com.baidu.tieba.frs.ecomm.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0057a {
        void a(int i, String str, EcommCanSendThreadResponseMessage ecommCanSendThreadResponseMessage);
    }

    public a(FrsActivity frsActivity) {
        this.bRp = frsActivity;
        this.unique_id = this.bRp.getUniqueId();
        Ed();
        registerListener(this.bwj);
    }

    private void Ed() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.ECOMM_CAN_SEND_THREAD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.ECOMM_CAN_SEND_THREAD);
        tbHttpMessageTask.setResponsedClass(EcommCanSendThreadResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void jO(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.ECOMM_CAN_SEND_THREAD);
        httpMessage.addParam("forum_id", str);
        sendMessage(httpMessage);
    }

    public void a(InterfaceC0057a interfaceC0057a) {
        this.bUK = interfaceC0057a;
    }
}
