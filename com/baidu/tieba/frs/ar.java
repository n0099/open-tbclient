package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends CustomMessageListener {
    final /* synthetic */ r cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(r rVar, int i) {
        super(i);
        this.cdl = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.f.m mVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && this.cdl.cbN != null) {
            this.cdl.cbN.c((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
            mVar = this.cdl.cct;
            mVar.f(this.cdl.cbN);
            dVar = this.cdl.ccu;
            dVar.a(this.cdl.ccj.getListView(), this.cdl.cbN, this.cdl.ccs.agT());
        }
    }
}
