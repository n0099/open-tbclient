package com.baidu.tieba.gift.send;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
import d.a.c.a.f;
import d.a.n0.r.q.i0;
/* loaded from: classes4.dex */
public class SendGiftModel extends BdBaseModel<GiftTabActivity> {

    /* renamed from: e  reason: collision with root package name */
    public c f16224e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f16225f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f16226g;

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof SendFreeGiftHttpResponse;
            if (z || (responsedMessage instanceof SendFreeGiftSocketResponse)) {
                int i2 = 0;
                if (z) {
                    i2 = ((SendFreeGiftHttpResponse) responsedMessage).getFreeChance();
                } else if (responsedMessage instanceof SendFreeGiftSocketResponse) {
                    i2 = ((SendFreeGiftSocketResponse) responsedMessage).getFreeChance();
                }
                if (SendGiftModel.this.f16224e != null) {
                    SendGiftModel.this.f16224e.c(responsedMessage.getError(), responsedMessage.getErrorString(), i2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PlaceOrderHttpResponse;
            if (z || (responsedMessage instanceof PlaceOrderSocketResponse)) {
                d.a.o0.v0.d.a aVar = null;
                if (z) {
                    aVar = ((PlaceOrderHttpResponse) responsedMessage).getOrderInfo();
                } else if (responsedMessage instanceof PlaceOrderSocketResponse) {
                    aVar = ((PlaceOrderSocketResponse) responsedMessage).getOrderInfo();
                }
                if (SendGiftModel.this.f16224e != null) {
                    SendGiftModel.this.f16224e.a(responsedMessage.getError(), responsedMessage.getErrorString(), aVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(int i2, String str, d.a.o0.v0.d.a aVar);

        void b();

        void c(int i2, String str, int i3);
    }

    public SendGiftModel(f<GiftTabActivity> fVar) {
        super(fVar);
        this.f16225f = new a(CmdConfigHttp.CMD_SEND_FREE_GIFT, 309050);
        this.f16226g = new b(CmdConfigHttp.CMD_GIFT_PALCE_ORDER, 309051);
        d.a.o0.e3.d0.a.h(309050, SendFreeGiftSocketResponse.class, false, false);
        d.a.o0.e3.d0.a.c(309050, CmdConfigHttp.CMD_SEND_FREE_GIFT, TbConfig.SEND_FREE_GIFT, SendFreeGiftHttpResponse.class, false, false, false, false);
        d.a.o0.e3.d0.a.h(309051, PlaceOrderSocketResponse.class, false, false);
        d.a.o0.e3.d0.a.c(309051, CmdConfigHttp.CMD_GIFT_PALCE_ORDER, TbConfig.GIFT_PLACE_ORDER, PlaceOrderHttpResponse.class, false, false, false, false);
        registerListener(this.f16225f);
        registerListener(this.f16226g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void x(i0 i0Var, int i2, String str, long j, String str2, long j2, long j3) {
        if (i2 > 0 && i0Var != null && j > 0) {
            if (i0Var.f53831f == 5) {
                SendFreeGiftRequest sendFreeGiftRequest = new SendFreeGiftRequest();
                sendFreeGiftRequest.setGiftId(i0Var.f53826a);
                sendFreeGiftRequest.setToUserId(j);
                sendFreeGiftRequest.setToUserName(str2);
                sendFreeGiftRequest.setSceneFrom(str);
                sendFreeGiftRequest.setSendCount(i2);
                sendFreeGiftRequest.setThreadId(j2);
                sendFreeGiftRequest.setPostId(j3);
                sendMessage(sendFreeGiftRequest);
                return;
            }
            PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
            placeOrderRequest.setGiftId(i0Var.f53826a);
            placeOrderRequest.setToUserId(j);
            placeOrderRequest.setToUserName(str2);
            placeOrderRequest.setSceneFrom(str);
            placeOrderRequest.setSendCount(i2);
            placeOrderRequest.setThreadId(j2);
            placeOrderRequest.setPostId(j3);
            placeOrderRequest.accountId = j;
            placeOrderRequest.accountType = i0Var.r;
            placeOrderRequest.currency = i0Var.s;
            sendMessage(placeOrderRequest);
            return;
        }
        c cVar = this.f16224e;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void y(c cVar) {
        this.f16224e = cVar;
    }
}
