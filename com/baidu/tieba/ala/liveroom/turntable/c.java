package com.baidu.tieba.ala.liveroom.turntable;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.turntable.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
/* loaded from: classes6.dex */
public class c implements a {
    private a.InterfaceC0371a eoh;
    private HttpMessageListener eoi;

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void a(a.InterfaceC0371a interfaceC0371a) {
        this.eoh = interfaceC0371a;
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void ud(String str) {
        aWe();
        com.baidu.tieba.ala.liveroom.turntable.lucky.d dVar = new com.baidu.tieba.ala.liveroom.turntable.lucky.d();
        dVar.cK(str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void release() {
        this.eoh = null;
        unRegisterListener();
    }

    private void aWe() {
        if (this.eoi == null) {
            this.eoi = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.liveroom.turntable.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (c.this.eoh != null && (httpResponsedMessage instanceof TurnTableLuckyMomentsResponseMessage) && !((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).hasError() && httpResponsedMessage.getError() == 0) {
                        c.this.eoh.a(((com.baidu.tieba.ala.liveroom.turntable.lucky.d) httpResponsedMessage.getOrginalMessage()).getLiveId(), ((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).eoL);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.eoi);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.eoi);
    }
}
