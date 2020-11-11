package com.baidu.tieba.ala.charm.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
/* loaded from: classes4.dex */
public class b extends BdBaseModel<ALaCharmCardActivity> {
    private q gwG;
    private a gwH;
    private NetMessageListener gwI;

    /* loaded from: classes4.dex */
    public interface a {
        void a(long j, q qVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2);

        void t(int i, String str);
    }

    public b(TbPageContext<ALaCharmCardActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.gwI = new NetMessageListener(1021008, 602004) { // from class: com.baidu.tieba.ala.charm.model.b.1
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                q qVar;
                long j;
                long j2 = 0;
                AlaLiveUserInfoData alaLiveUserInfoData = null;
                if (responsedMessage != null && (responsedMessage instanceof OnlineListHttpResponseMessage)) {
                    int error = responsedMessage.getError();
                    if (responsedMessage instanceof OnlineListHttpResponseMessage) {
                        OnlineListHttpResponseMessage onlineListHttpResponseMessage = (OnlineListHttpResponseMessage) responsedMessage;
                        j = onlineListHttpResponseMessage.bRp();
                        q bRq = onlineListHttpResponseMessage.bRq();
                        alaLiveUserInfoData = onlineListHttpResponseMessage.bRr();
                        j2 = onlineListHttpResponseMessage.bRs();
                        qVar = bRq;
                    } else {
                        qVar = null;
                        j = 0;
                    }
                    if (error == 0) {
                        b.this.gwG = qVar;
                        if (b.this.gwH != null) {
                            b.this.gwH.a(j, b.this.gwG, alaLiveUserInfoData, j2);
                        }
                    } else if (b.this.gwH != null) {
                        b.this.gwH.t(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        };
        this.gwH = aVar;
        MessageManager.getInstance().registerListener(this.gwI);
        com.baidu.live.tieba.f.a.a.a(1021008, "ala/live/getAudienceInfo", OnlineListHttpResponseMessage.class, false, true, true, true);
    }

    public void u(String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021008);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void v(String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021008);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gwI);
        MessageManager.getInstance().unRegisterTask(1021008);
        cancelMessage();
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }
}
