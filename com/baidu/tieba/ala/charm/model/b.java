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
/* loaded from: classes3.dex */
public class b extends BdBaseModel<ALaCharmCardActivity> {
    private k fAG;
    private a fAH;
    private NetMessageListener fAI;

    /* loaded from: classes3.dex */
    public interface a {
        void a(long j, k kVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2);

        void az(int i, String str);
    }

    public b(TbPageContext<ALaCharmCardActivity> tbPageContext, a aVar) {
        super(tbPageContext);
        this.fAI = new NetMessageListener(1021008, 602004) { // from class: com.baidu.tieba.ala.charm.model.b.1
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
                        j = onlineListHttpResponseMessage.bwd();
                        k bwe = onlineListHttpResponseMessage.bwe();
                        alaLiveUserInfoData = onlineListHttpResponseMessage.bwf();
                        j2 = onlineListHttpResponseMessage.bwg();
                        kVar = bwe;
                    } else {
                        kVar = null;
                        j = 0;
                    }
                    if (error == 0) {
                        b.this.fAG = kVar;
                        if (b.this.fAH != null) {
                            b.this.fAH.a(j, b.this.fAG, alaLiveUserInfoData, j2);
                        }
                    } else if (b.this.fAH != null) {
                        b.this.fAH.az(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        };
        this.fAH = aVar;
        MessageManager.getInstance().registerListener(this.fAI);
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
        MessageManager.getInstance().unRegisterListener(this.fAI);
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
