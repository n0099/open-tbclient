package com.baidu.tieba.gift.send;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
/* loaded from: classes9.dex */
public class SendGiftModel extends BdBaseModel<GiftTabActivity> {
    private a jUo;
    private com.baidu.adp.framework.listener.a jUp;
    private com.baidu.adp.framework.listener.a jUq;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, String str, com.baidu.tieba.gift.send.a aVar);

        void c(int i, String str, int i2);

        void cPH();
    }

    public SendGiftModel(f<GiftTabActivity> fVar) {
        super(fVar);
        this.jUp = new com.baidu.adp.framework.listener.a(1003052, CmdConfigSocket.CMD_SEND_FREE_GIFT) { // from class: com.baidu.tieba.gift.send.SendGiftModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof SendFreeGiftHttpResponse) || (responsedMessage instanceof SendFreeGiftSocketResponse)) {
                        int i = 0;
                        if (responsedMessage instanceof SendFreeGiftHttpResponse) {
                            i = ((SendFreeGiftHttpResponse) responsedMessage).getFreeChance();
                        } else if (responsedMessage instanceof SendFreeGiftSocketResponse) {
                            i = ((SendFreeGiftSocketResponse) responsedMessage).getFreeChance();
                        }
                        if (SendGiftModel.this.jUo != null) {
                            SendGiftModel.this.jUo.c(responsedMessage.getError(), responsedMessage.getErrorString(), i);
                        }
                    }
                }
            }
        };
        this.jUq = new com.baidu.adp.framework.listener.a(1003053, CmdConfigSocket.CMD_GIFT_PALCE_ORDER) { // from class: com.baidu.tieba.gift.send.SendGiftModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof PlaceOrderHttpResponse) || (responsedMessage instanceof PlaceOrderSocketResponse)) {
                        com.baidu.tieba.gift.send.a aVar = null;
                        if (responsedMessage instanceof PlaceOrderHttpResponse) {
                            aVar = ((PlaceOrderHttpResponse) responsedMessage).getOrderInfo();
                        } else if (responsedMessage instanceof PlaceOrderSocketResponse) {
                            aVar = ((PlaceOrderSocketResponse) responsedMessage).getOrderInfo();
                        }
                        if (SendGiftModel.this.jUo != null) {
                            SendGiftModel.this.jUo.a(responsedMessage.getError(), responsedMessage.getErrorString(), aVar);
                        }
                    }
                }
            }
        };
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SEND_FREE_GIFT, SendFreeGiftSocketResponse.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SEND_FREE_GIFT, 1003052, TbConfig.SEND_FREE_GIFT, SendFreeGiftHttpResponse.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GIFT_PALCE_ORDER, PlaceOrderSocketResponse.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GIFT_PALCE_ORDER, 1003053, TbConfig.GIFT_PLACE_ORDER, PlaceOrderHttpResponse.class, false, false, false, false);
        registerListener(this.jUp);
        registerListener(this.jUq);
    }

    public void a(ah ahVar, int i, String str, long j, String str2, long j2, long j3) {
        if (i <= 0 || ahVar == null || j <= 0) {
            if (this.jUo != null) {
                this.jUo.cPH();
            }
        } else if (ahVar.aKj == 5) {
            SendFreeGiftRequest sendFreeGiftRequest = new SendFreeGiftRequest();
            sendFreeGiftRequest.setGiftId(ahVar.id);
            sendFreeGiftRequest.setToUserId(j);
            sendFreeGiftRequest.setToUserName(str2);
            sendFreeGiftRequest.setSceneFrom(str);
            sendFreeGiftRequest.setSendCount(i);
            sendFreeGiftRequest.setThreadId(j2);
            sendFreeGiftRequest.setPostId(j3);
            sendMessage(sendFreeGiftRequest);
        } else {
            PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
            placeOrderRequest.setGiftId(ahVar.id);
            placeOrderRequest.setToUserId(j);
            placeOrderRequest.setToUserName(str2);
            placeOrderRequest.setSceneFrom(str);
            placeOrderRequest.setSendCount(i);
            placeOrderRequest.setThreadId(j2);
            placeOrderRequest.setPostId(j3);
            placeOrderRequest.accountId = j;
            placeOrderRequest.accountType = ahVar.accountType;
            sendMessage(placeOrderRequest);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.jUo = aVar;
    }
}
