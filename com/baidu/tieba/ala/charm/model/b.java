package com.baidu.tieba.ala.charm.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.v;
import com.baidu.live.message.AlaPokeResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
/* loaded from: classes10.dex */
public class b extends BdBaseModel<ALaCharmCardActivity> {
    private v gQG;
    private a gQH;
    private InterfaceC0631b gQI;
    private NetMessageListener gQJ;
    private HttpMessageListener gQK;

    /* loaded from: classes10.dex */
    public interface a {
        void A(int i, String str);

        void a(long j, v vVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2);
    }

    /* renamed from: com.baidu.tieba.ala.charm.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0631b {
        void A(int i, String str);

        void u(long j, int i);
    }

    public b(TbPageContext<ALaCharmCardActivity> tbPageContext, a aVar, InterfaceC0631b interfaceC0631b) {
        super(tbPageContext);
        this.gQJ = new NetMessageListener(1021008, 602004) { // from class: com.baidu.tieba.ala.charm.model.b.1
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                AlaLiveUserInfoData alaLiveUserInfoData;
                v vVar;
                long j2;
                if (responsedMessage != null && (responsedMessage instanceof OnlineListHttpResponseMessage)) {
                    int error = responsedMessage.getError();
                    if (responsedMessage instanceof OnlineListHttpResponseMessage) {
                        OnlineListHttpResponseMessage onlineListHttpResponseMessage = (OnlineListHttpResponseMessage) responsedMessage;
                        j2 = onlineListHttpResponseMessage.bTW();
                        v bTX = onlineListHttpResponseMessage.bTX();
                        alaLiveUserInfoData = onlineListHttpResponseMessage.bTY();
                        j = onlineListHttpResponseMessage.bTZ();
                        vVar = bTX;
                    } else {
                        j = 0;
                        alaLiveUserInfoData = null;
                        vVar = null;
                        j2 = 0;
                    }
                    if (error == 0) {
                        b.this.gQG = vVar;
                        if (b.this.gQH != null) {
                            b.this.gQH.a(j2, b.this.gQG, alaLiveUserInfoData, j);
                        }
                    } else if (b.this.gQH != null) {
                        b.this.gQH.A(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        };
        this.gQK = new HttpMessageListener(1021227) { // from class: com.baidu.tieba.ala.charm.model.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021227 && (httpResponsedMessage instanceof AlaPokeResponseMessage)) {
                    AlaPokeResponseMessage alaPokeResponseMessage = (AlaPokeResponseMessage) httpResponsedMessage;
                    if (alaPokeResponseMessage.getError() != 0 || !alaPokeResponseMessage.isSuccess()) {
                        if (b.this.gQH != null) {
                            b.this.gQI.A(alaPokeResponseMessage.getError(), alaPokeResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    if (b.this.gQH != null) {
                        b.this.gQI.u(alaPokeResponseMessage.userId, alaPokeResponseMessage.bwt);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_HOST_POKE_SUCCESS));
                }
            }
        };
        this.gQH = aVar;
        this.gQI = interfaceC0631b;
        MessageManager.getInstance().registerListener(this.gQJ);
        MessageManager.getInstance().registerListener(this.gQK);
        com.baidu.live.tieba.f.a.a.a(1021008, "ala/live/getAudienceInfo", OnlineListHttpResponseMessage.class, false, true, true, true);
    }

    public void v(String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021008);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void w(String str, int i, int i2) {
        HttpMessage httpMessage = new HttpMessage(1021008);
        httpMessage.addParam("live_id", str);
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        httpMessage.addParam("ps", i2);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gQJ);
        MessageManager.getInstance().unRegisterListener(this.gQK);
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
