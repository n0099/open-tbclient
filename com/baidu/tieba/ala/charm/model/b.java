package com.baidu.tieba.ala.charm.model;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.q;
import com.baidu.live.message.AlaPokeResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.charm.ALaCharmCardActivity;
/* loaded from: classes4.dex */
public class b extends BdBaseModel<ALaCharmCardActivity> {
    private q gEW;
    private a gEX;
    private InterfaceC0651b gEY;
    private NetMessageListener gEZ;
    private HttpMessageListener gFa;

    /* loaded from: classes4.dex */
    public interface a {
        void a(long j, q qVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2);

        void t(int i, String str);
    }

    /* renamed from: com.baidu.tieba.ala.charm.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0651b {
        void s(long j, int i);

        void t(int i, String str);
    }

    public b(TbPageContext<ALaCharmCardActivity> tbPageContext, a aVar, InterfaceC0651b interfaceC0651b) {
        super(tbPageContext);
        this.gEZ = new NetMessageListener(1021008, 602004) { // from class: com.baidu.tieba.ala.charm.model.b.1
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
                        j = onlineListHttpResponseMessage.bUs();
                        q bUt = onlineListHttpResponseMessage.bUt();
                        alaLiveUserInfoData = onlineListHttpResponseMessage.bUu();
                        j2 = onlineListHttpResponseMessage.bUv();
                        qVar = bUt;
                    } else {
                        qVar = null;
                        j = 0;
                    }
                    if (error == 0) {
                        b.this.gEW = qVar;
                        if (b.this.gEX != null) {
                            b.this.gEX.a(j, b.this.gEW, alaLiveUserInfoData, j2);
                        }
                    } else if (b.this.gEX != null) {
                        b.this.gEX.t(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        };
        this.gFa = new HttpMessageListener(1021227) { // from class: com.baidu.tieba.ala.charm.model.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021227 && (httpResponsedMessage instanceof AlaPokeResponseMessage)) {
                    AlaPokeResponseMessage alaPokeResponseMessage = (AlaPokeResponseMessage) httpResponsedMessage;
                    if (alaPokeResponseMessage.getError() != 0 || !alaPokeResponseMessage.isSuccess()) {
                        if (b.this.gEX != null) {
                            b.this.gEY.t(alaPokeResponseMessage.getError(), alaPokeResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    if (b.this.gEX != null) {
                        b.this.gEY.s(alaPokeResponseMessage.userId, alaPokeResponseMessage.brw);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_HOST_POKE_SUCCESS));
                }
            }
        };
        this.gEX = aVar;
        this.gEY = interfaceC0651b;
        MessageManager.getInstance().registerListener(this.gEZ);
        MessageManager.getInstance().registerListener(this.gFa);
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
        MessageManager.getInstance().unRegisterListener(this.gEZ);
        MessageManager.getInstance().unRegisterListener(this.gFa);
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
