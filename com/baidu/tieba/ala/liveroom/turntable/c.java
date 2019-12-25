package com.baidu.tieba.ala.liveroom.turntable;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.turntable.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
/* loaded from: classes2.dex */
public class c implements a {
    private a.InterfaceC0454a feH;
    private HttpMessageListener feI;

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void a(a.InterfaceC0454a interfaceC0454a) {
        this.feH = interfaceC0454a;
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void yU(String str) {
        bnT();
        com.baidu.tieba.ala.liveroom.turntable.lucky.d dVar = new com.baidu.tieba.ala.liveroom.turntable.lucky.d();
        dVar.dB(str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void release() {
        this.feH = null;
        unRegisterListener();
    }

    private void bnT() {
        if (this.feI == null) {
            this.feI = new HttpMessageListener(1021155) { // from class: com.baidu.tieba.ala.liveroom.turntable.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (c.this.feH != null && (httpResponsedMessage instanceof TurnTableLuckyMomentsResponseMessage) && !((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).hasError() && httpResponsedMessage.getError() == 0) {
                        c.this.feH.a(((com.baidu.tieba.ala.liveroom.turntable.lucky.d) httpResponsedMessage.getOrginalMessage()).getLiveId(), ((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).fff);
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.feI);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.feI);
    }
}
