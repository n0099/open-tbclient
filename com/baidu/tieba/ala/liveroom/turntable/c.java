package com.baidu.tieba.ala.liveroom.turntable;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.turntable.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
/* loaded from: classes4.dex */
public class c implements a {
    private a.InterfaceC0698a hCQ;
    private HttpMessageListener hCR;

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void a(a.InterfaceC0698a interfaceC0698a) {
        this.hCQ = interfaceC0698a;
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void IN(String str) {
        ckH();
        com.baidu.tieba.ala.liveroom.turntable.lucky.d dVar = new com.baidu.tieba.ala.liveroom.turntable.lucky.d();
        dVar.setLiveId(str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void release() {
        this.hCQ = null;
        unRegisterListener();
    }

    private void ckH() {
        if (this.hCR == null) {
            this.hCR = new HttpMessageListener(1021157) { // from class: com.baidu.tieba.ala.liveroom.turntable.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (c.this.hCQ != null && (httpResponsedMessage instanceof TurnTableLuckyMomentsResponseMessage)) {
                        TurnTableLuckyMomentsResponseMessage turnTableLuckyMomentsResponseMessage = (TurnTableLuckyMomentsResponseMessage) httpResponsedMessage;
                        if (turnTableLuckyMomentsResponseMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            c.this.hCQ.bk(turnTableLuckyMomentsResponseMessage.getError(), turnTableLuckyMomentsResponseMessage.getErrorString());
                        } else {
                            c.this.hCQ.a(((com.baidu.tieba.ala.liveroom.turntable.lucky.d) httpResponsedMessage.getOrginalMessage()).getLiveId(), ((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).hDp);
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.hCR);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.hCR);
    }
}
