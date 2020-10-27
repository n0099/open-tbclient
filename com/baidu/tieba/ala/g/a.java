package com.baidu.tieba.ala.g;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.messages.AcceptPkResponseMessage;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private HttpMessageListener messageListener;

    /* renamed from: com.baidu.tieba.ala.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0632a {
        void bk(int i, String str);

        void eI(long j);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void v(long j, long j2) {
        HttpMessage httpMessage = new HttpMessage(1021211);
        httpMessage.addParam("anchor_id", j);
        httpMessage.addParam("rival_anchor_id", j2);
        sendMessage(httpMessage);
    }

    public void a(InterfaceC0632a interfaceC0632a) {
        cgh();
        b(interfaceC0632a);
    }

    private void b(final InterfaceC0632a interfaceC0632a) {
        this.messageListener = new HttpMessageListener(1021211) { // from class: com.baidu.tieba.ala.g.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021211 && (httpResponsedMessage instanceof AcceptPkResponseMessage)) {
                    AcceptPkResponseMessage acceptPkResponseMessage = (AcceptPkResponseMessage) httpResponsedMessage;
                    if (acceptPkResponseMessage.getError() != 0 || !acceptPkResponseMessage.isSuccess()) {
                        interfaceC0632a.bk(acceptPkResponseMessage.getError(), acceptPkResponseMessage.getErrorString());
                        return;
                    }
                    interfaceC0632a.eI(acceptPkResponseMessage.cgd());
                    AlaStatsItem alaStatsItem = new AlaStatsItem();
                    alaStatsItem.addValue("pkId", Long.valueOf(acceptPkResponseMessage.cgd()));
                    alaStatsItem.addValue("lodId", Long.valueOf(acceptPkResponseMessage.getLogId()));
                    alaStatsItem.addValue(BaseJsonData.TAG_ERRNO, Integer.valueOf(acceptPkResponseMessage.getError()));
                    AlaStatManager.getInstance().debug("pk_competition_accept_pk", alaStatsItem);
                }
            }
        };
        registerListener(this.messageListener);
    }

    private void cgh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021211, TbConfig.SERVER_ADDRESS + "ala/pksolo/acceptPk");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(AcceptPkResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void cgi() {
        MessageManager.getInstance().unRegisterListener(this.messageListener);
        MessageManager.getInstance().unRegisterTask(1021211);
    }
}
