package com.baidu.tieba.ala.liveroom.turntable;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.turntable.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
/* loaded from: classes2.dex */
public class c implements a {
    private a.InterfaceC0458a fhN;
    private HttpMessageListener fhO;

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.fhN = interfaceC0458a;
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void zd(String str) {
        boT();
        com.baidu.tieba.ala.liveroom.turntable.lucky.d dVar = new com.baidu.tieba.ala.liveroom.turntable.lucky.d();
        dVar.dD(str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void release() {
        this.fhN = null;
        unRegisterListener();
    }

    private void boT() {
        if (this.fhO == null) {
            this.fhO = new HttpMessageListener(1021157) { // from class: com.baidu.tieba.ala.liveroom.turntable.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (c.this.fhN != null && (httpResponsedMessage instanceof TurnTableLuckyMomentsResponseMessage)) {
                        TurnTableLuckyMomentsResponseMessage turnTableLuckyMomentsResponseMessage = (TurnTableLuckyMomentsResponseMessage) httpResponsedMessage;
                        if (turnTableLuckyMomentsResponseMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            c.this.fhN.ax(turnTableLuckyMomentsResponseMessage.getError(), turnTableLuckyMomentsResponseMessage.getErrorString());
                        } else {
                            c.this.fhN.a(((com.baidu.tieba.ala.liveroom.turntable.lucky.d) httpResponsedMessage.getOrginalMessage()).getLiveId(), ((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).fio);
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.fhO);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.fhO);
    }
}
