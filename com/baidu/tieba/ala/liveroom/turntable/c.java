package com.baidu.tieba.ala.liveroom.turntable;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.turntable.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
import com.baidu.tieba.ala.liveroom.turntable.lucky.d;
/* loaded from: classes10.dex */
public class c implements a {
    private a.InterfaceC0680a hQF;
    private HttpMessageListener hQG;

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void a(a.InterfaceC0680a interfaceC0680a) {
        this.hQF = interfaceC0680a;
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void Il(String str) {
        ckT();
        d dVar = new d();
        dVar.setLiveId(str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void release() {
        this.hQF = null;
        unRegisterListener();
    }

    private void ckT() {
        if (this.hQG == null) {
            this.hQG = new HttpMessageListener(1021157) { // from class: com.baidu.tieba.ala.liveroom.turntable.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (c.this.hQF != null && (httpResponsedMessage instanceof TurnTableLuckyMomentsResponseMessage)) {
                        TurnTableLuckyMomentsResponseMessage turnTableLuckyMomentsResponseMessage = (TurnTableLuckyMomentsResponseMessage) httpResponsedMessage;
                        if (turnTableLuckyMomentsResponseMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            c.this.hQF.bs(turnTableLuckyMomentsResponseMessage.getError(), turnTableLuckyMomentsResponseMessage.getErrorString());
                        } else {
                            c.this.hQF.a(((d) httpResponsedMessage.getOrginalMessage()).getLiveId(), ((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).hRa);
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hQG);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.hQG);
    }
}
