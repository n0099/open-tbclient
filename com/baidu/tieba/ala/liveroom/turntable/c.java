package com.baidu.tieba.ala.liveroom.turntable;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.turntable.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
/* loaded from: classes3.dex */
public class c implements a {
    private a.InterfaceC0573a geU;
    private HttpMessageListener geV;

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void a(a.InterfaceC0573a interfaceC0573a) {
        this.geU = interfaceC0573a;
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void CN(String str) {
        bGr();
        com.baidu.tieba.ala.liveroom.turntable.lucky.d dVar = new com.baidu.tieba.ala.liveroom.turntable.lucky.d();
        dVar.fs(str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void release() {
        this.geU = null;
        unRegisterListener();
    }

    private void bGr() {
        if (this.geV == null) {
            this.geV = new HttpMessageListener(1021157) { // from class: com.baidu.tieba.ala.liveroom.turntable.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (c.this.geU != null && (httpResponsedMessage instanceof TurnTableLuckyMomentsResponseMessage)) {
                        TurnTableLuckyMomentsResponseMessage turnTableLuckyMomentsResponseMessage = (TurnTableLuckyMomentsResponseMessage) httpResponsedMessage;
                        if (turnTableLuckyMomentsResponseMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            c.this.geU.aS(turnTableLuckyMomentsResponseMessage.getError(), turnTableLuckyMomentsResponseMessage.getErrorString());
                        } else {
                            c.this.geU.a(((com.baidu.tieba.ala.liveroom.turntable.lucky.d) httpResponsedMessage.getOrginalMessage()).getLiveId(), ((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).gfu);
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.geV);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.geV);
    }
}
