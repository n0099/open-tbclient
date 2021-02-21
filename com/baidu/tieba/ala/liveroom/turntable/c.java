package com.baidu.tieba.ala.liveroom.turntable;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.turntable.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
import com.baidu.tieba.ala.liveroom.turntable.lucky.d;
/* loaded from: classes11.dex */
public class c implements a {
    private a.InterfaceC0674a hOW;
    private HttpMessageListener hOX;

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void a(a.InterfaceC0674a interfaceC0674a) {
        this.hOW = interfaceC0674a;
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void Ic(String str) {
        ckN();
        d dVar = new d();
        dVar.setLiveId(str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void release() {
        this.hOW = null;
        unRegisterListener();
    }

    private void ckN() {
        if (this.hOX == null) {
            this.hOX = new HttpMessageListener(1021157) { // from class: com.baidu.tieba.ala.liveroom.turntable.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (c.this.hOW != null && (httpResponsedMessage instanceof TurnTableLuckyMomentsResponseMessage)) {
                        TurnTableLuckyMomentsResponseMessage turnTableLuckyMomentsResponseMessage = (TurnTableLuckyMomentsResponseMessage) httpResponsedMessage;
                        if (turnTableLuckyMomentsResponseMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            c.this.hOW.bs(turnTableLuckyMomentsResponseMessage.getError(), turnTableLuckyMomentsResponseMessage.getErrorString());
                        } else {
                            c.this.hOW.a(((d) httpResponsedMessage.getOrginalMessage()).getLiveId(), ((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).hPr);
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hOX);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.hOX);
    }
}
