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
/* loaded from: classes11.dex */
public class b extends BdBaseModel<ALaCharmCardActivity> {
    private v gOJ;
    private a gOK;
    private InterfaceC0624b gOL;
    private NetMessageListener gOM;
    private HttpMessageListener gON;

    /* loaded from: classes11.dex */
    public interface a {
        void A(int i, String str);

        void a(long j, v vVar, AlaLiveUserInfoData alaLiveUserInfoData, long j2);
    }

    /* renamed from: com.baidu.tieba.ala.charm.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0624b {
        void A(int i, String str);

        void u(long j, int i);
    }

    public b(TbPageContext<ALaCharmCardActivity> tbPageContext, a aVar, InterfaceC0624b interfaceC0624b) {
        super(tbPageContext);
        this.gOM = new NetMessageListener(1021008, 602004) { // from class: com.baidu.tieba.ala.charm.model.b.1
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
                        j2 = onlineListHttpResponseMessage.bTJ();
                        v bTK = onlineListHttpResponseMessage.bTK();
                        alaLiveUserInfoData = onlineListHttpResponseMessage.bTL();
                        j = onlineListHttpResponseMessage.bTM();
                        vVar = bTK;
                    } else {
                        j = 0;
                        alaLiveUserInfoData = null;
                        vVar = null;
                        j2 = 0;
                    }
                    if (error == 0) {
                        b.this.gOJ = vVar;
                        if (b.this.gOK != null) {
                            b.this.gOK.a(j2, b.this.gOJ, alaLiveUserInfoData, j);
                        }
                    } else if (b.this.gOK != null) {
                        b.this.gOK.A(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        };
        this.gON = new HttpMessageListener(1021227) { // from class: com.baidu.tieba.ala.charm.model.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021227 && (httpResponsedMessage instanceof AlaPokeResponseMessage)) {
                    AlaPokeResponseMessage alaPokeResponseMessage = (AlaPokeResponseMessage) httpResponsedMessage;
                    if (alaPokeResponseMessage.getError() != 0 || !alaPokeResponseMessage.isSuccess()) {
                        if (b.this.gOK != null) {
                            b.this.gOL.A(alaPokeResponseMessage.getError(), alaPokeResponseMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    if (b.this.gOK != null) {
                        b.this.gOL.u(alaPokeResponseMessage.userId, alaPokeResponseMessage.buT);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_HOST_POKE_SUCCESS));
                }
            }
        };
        this.gOK = aVar;
        this.gOL = interfaceC0624b;
        MessageManager.getInstance().registerListener(this.gOM);
        MessageManager.getInstance().registerListener(this.gON);
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
        MessageManager.getInstance().unRegisterListener(this.gOM);
        MessageManager.getInstance().unRegisterListener(this.gON);
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
