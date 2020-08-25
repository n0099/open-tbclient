package com.baidu.tieba.ala.liveroom.turntable;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.turntable.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
/* loaded from: classes7.dex */
public class c implements a {
    private a.InterfaceC0640a gJx;
    private HttpMessageListener gJy;

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void a(a.InterfaceC0640a interfaceC0640a) {
        this.gJx = interfaceC0640a;
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void Gz(String str) {
        bWE();
        com.baidu.tieba.ala.liveroom.turntable.lucky.d dVar = new com.baidu.tieba.ala.liveroom.turntable.lucky.d();
        dVar.gb(str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void release() {
        this.gJx = null;
        unRegisterListener();
    }

    private void bWE() {
        if (this.gJy == null) {
            this.gJy = new HttpMessageListener(1021157) { // from class: com.baidu.tieba.ala.liveroom.turntable.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (c.this.gJx != null && (httpResponsedMessage instanceof TurnTableLuckyMomentsResponseMessage)) {
                        TurnTableLuckyMomentsResponseMessage turnTableLuckyMomentsResponseMessage = (TurnTableLuckyMomentsResponseMessage) httpResponsedMessage;
                        if (turnTableLuckyMomentsResponseMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            c.this.gJx.aW(turnTableLuckyMomentsResponseMessage.getError(), turnTableLuckyMomentsResponseMessage.getErrorString());
                        } else {
                            c.this.gJx.a(((com.baidu.tieba.ala.liveroom.turntable.lucky.d) httpResponsedMessage.getOrginalMessage()).getLiveId(), ((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).gJY);
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gJy);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.gJy);
    }
}
