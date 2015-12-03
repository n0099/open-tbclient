package com.baidu.tieba.gift.send;

import com.baidu.adp.base.e;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
/* loaded from: classes.dex */
public class b extends e<GiftTabActivity> {
    private a bxp;
    private com.baidu.adp.framework.listener.a bxq;
    private com.baidu.adp.framework.listener.a bxr;

    /* loaded from: classes.dex */
    public interface a {
        void Tg();

        void a(int i, String str, com.baidu.tieba.gift.send.a aVar);

        void c(int i, String str, int i2);
    }

    public b(h<GiftTabActivity> hVar) {
        super(hVar);
        this.bxq = new c(this, CmdConfigHttp.CMD_SEND_FREE_GIFT, 309050);
        this.bxr = new d(this, CmdConfigHttp.CMD_GIFT_PALCE_ORDER, 309051);
        com.baidu.tieba.tbadkCore.a.a.a(309050, SendFreeGiftSocketResponse.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309050, CmdConfigHttp.CMD_SEND_FREE_GIFT, TbConfig.SEND_FREE_GIFT, SendFreeGiftHttpResponse.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309051, PlaceOrderSocketResponse.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309051, CmdConfigHttp.CMD_GIFT_PALCE_ORDER, TbConfig.GIFT_PLACE_ORDER, PlaceOrderHttpResponse.class, false, false, false, false);
        registerListener(this.bxq);
        registerListener(this.bxr);
    }

    public void a(l lVar, int i, String str, long j, String str2, long j2, long j3) {
        if (i <= 0 || lVar == null || j <= 0 || StringUtils.isNull(str2)) {
            if (this.bxp != null) {
                this.bxp.Tg();
            }
        } else if (lVar.rS() == 5) {
            SendFreeGiftRequest sendFreeGiftRequest = new SendFreeGiftRequest();
            sendFreeGiftRequest.setGiftId(lVar.getId());
            sendFreeGiftRequest.setToUserId(j);
            sendFreeGiftRequest.setToUserName(str2);
            sendFreeGiftRequest.setSceneFrom(str);
            sendFreeGiftRequest.setSendCount(i);
            sendFreeGiftRequest.setThreadId(j2);
            sendFreeGiftRequest.setPostId(j3);
            sendMessage(sendFreeGiftRequest);
        } else {
            PlaceOrderRequest placeOrderRequest = new PlaceOrderRequest();
            placeOrderRequest.setGiftId(lVar.getId());
            placeOrderRequest.setToUserId(j);
            placeOrderRequest.setToUserName(str2);
            placeOrderRequest.setSceneFrom(str);
            placeOrderRequest.setSendCount(i);
            placeOrderRequest.setThreadId(j2);
            placeOrderRequest.setPostId(j3);
            sendMessage(placeOrderRequest);
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(a aVar) {
        this.bxp = aVar;
    }
}
