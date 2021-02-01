package com.baidu.tieba.ala.liveroom.turntable;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.turntable.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
import com.baidu.tieba.ala.liveroom.turntable.lucky.d;
/* loaded from: classes11.dex */
public class c implements a {
    private a.InterfaceC0673a hOI;
    private HttpMessageListener hOJ;

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void a(a.InterfaceC0673a interfaceC0673a) {
        this.hOI = interfaceC0673a;
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void Ib(String str) {
        ckG();
        d dVar = new d();
        dVar.setLiveId(str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void release() {
        this.hOI = null;
        unRegisterListener();
    }

    private void ckG() {
        if (this.hOJ == null) {
            this.hOJ = new HttpMessageListener(1021157) { // from class: com.baidu.tieba.ala.liveroom.turntable.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (c.this.hOI != null && (httpResponsedMessage instanceof TurnTableLuckyMomentsResponseMessage)) {
                        TurnTableLuckyMomentsResponseMessage turnTableLuckyMomentsResponseMessage = (TurnTableLuckyMomentsResponseMessage) httpResponsedMessage;
                        if (turnTableLuckyMomentsResponseMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            c.this.hOI.bs(turnTableLuckyMomentsResponseMessage.getError(), turnTableLuckyMomentsResponseMessage.getErrorString());
                        } else {
                            c.this.hOI.a(((d) httpResponsedMessage.getOrginalMessage()).getLiveId(), ((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).hPd);
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hOJ);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.hOJ);
    }
}
