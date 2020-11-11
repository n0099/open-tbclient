package com.baidu.tieba.ala.liveroom.turntable;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.tieba.ala.liveroom.turntable.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
/* loaded from: classes4.dex */
public class c implements a {
    private a.InterfaceC0685a htD;
    private HttpMessageListener htE;

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void a(a.InterfaceC0685a interfaceC0685a) {
        this.htD = interfaceC0685a;
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void Ix(String str) {
        cht();
        com.baidu.tieba.ala.liveroom.turntable.lucky.d dVar = new com.baidu.tieba.ala.liveroom.turntable.lucky.d();
        dVar.setLiveId(str);
        MessageManager.getInstance().sendMessage(dVar);
    }

    @Override // com.baidu.tieba.ala.liveroom.turntable.a
    public void release() {
        this.htD = null;
        unRegisterListener();
    }

    private void cht() {
        if (this.htE == null) {
            this.htE = new HttpMessageListener(1021157) { // from class: com.baidu.tieba.ala.liveroom.turntable.c.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (c.this.htD != null && (httpResponsedMessage instanceof TurnTableLuckyMomentsResponseMessage)) {
                        TurnTableLuckyMomentsResponseMessage turnTableLuckyMomentsResponseMessage = (TurnTableLuckyMomentsResponseMessage) httpResponsedMessage;
                        if (turnTableLuckyMomentsResponseMessage.hasError() || httpResponsedMessage.getError() != 0) {
                            c.this.htD.bm(turnTableLuckyMomentsResponseMessage.getError(), turnTableLuckyMomentsResponseMessage.getErrorString());
                        } else {
                            c.this.htD.a(((com.baidu.tieba.ala.liveroom.turntable.lucky.d) httpResponsedMessage.getOrginalMessage()).getLiveId(), ((TurnTableLuckyMomentsResponseMessage) httpResponsedMessage).hud);
                        }
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.htE);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.htE);
    }
}
