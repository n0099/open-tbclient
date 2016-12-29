package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ l bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(l lVar, int i) {
        super(i);
        this.bqi = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Td;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.bqi.bpQ.TN();
        Td = this.bqi.Td();
        if (Td) {
            this.bqi.bpQ.TM();
            cVar = this.bqi.bpR;
            cVar.ac(this.bqi.bpQ.TR());
            cVar2 = this.bqi.bpR;
            cVar2.gG(this.bqi.bpQ.TC());
        }
        z = this.bqi.bpW;
        if (z) {
            this.bqi.bpQ.kv();
        }
    }
}
