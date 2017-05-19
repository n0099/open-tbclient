package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends CustomMessageListener {
    final /* synthetic */ r bPn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(r rVar, int i) {
        super(i);
        this.bPn = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.e.u uVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && this.bPn.bNT != null) {
            this.bPn.bNT.c((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
            uVar = this.bPn.bOx;
            uVar.f(this.bPn.bNT);
            dVar = this.bPn.bOz;
            dVar.a(this.bPn.bOn.getListView(), this.bPn.bNT, this.bPn.bOw.abW());
        }
    }
}
