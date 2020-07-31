package com.baidu.tieba.ala.charm.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
/* loaded from: classes4.dex */
public class b extends BdBaseModel<ALaCharmCardActivity> {
    private k fFQ;
    private a fFR;
    private NetMessageListener fFS;

    /* loaded from: classes4.dex */
    public interface a {
        void a(long j, k kVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2);

        void aB(int i, String str);
    }

    public b(TbPageContext<ALaCharmCardActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.fFS = new NetMessageListener(1021008, 602004) { // from class: com.baidu.tieba.ala.charm.model.b.1
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                k kVar;
                long j;
                long j2 = 0;
                AlaLiveUserInfoData alaLiveUserInfoData = null;
                if (responsedMessage != null && (responsedMessage instanceof OnlineListHttpResponseMessage)) {
                    int error = responsedMessage.getError();
                    if (responsedMessage instanceof OnlineListHttpResponseMessage) {
                        OnlineListHttpResponseMessage onlineListHttpResponseMessage = (OnlineListHttpResponseMessage) responsedMessage;
                        j = onlineListHttpResponseMessage.bzr();
                        k bzs = onlineListHttpResponseMessage.bzs();
                        alaLiveUserInfoData = onlineListHttpResponseMessage.bzt();
                        j2 = onlineListHttpResponseMessage.bzu();
                        kVar = bzs;
                    } else {
                        kVar = null;
                        j = 0;
                    }
                    if (error == 0) {
                        b.this.fFQ = kVar;
                        if (b.this.fFR != null) {
                            b.this.fFR.a(j, b.this.fFQ, alaLiveUserInfoData, j2);
                        }
                    } else if (b.this.fFR != null) {
                        b.this.fFR.aB(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        };
        this.fFR = aVar;
        MessageManager.getInstance().registerListener(this.fFS);
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
        MessageManager.getInstance().unRegisterListener(this.fFS);
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
