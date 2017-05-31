package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(r rVar, int i) {
        super(i);
        this.bVb = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.t) && this.bVb.bTF != null) {
            this.bVb.bTF.c((com.baidu.tieba.tbadkCore.t) customResponsedMessage.getData());
            uVar = this.bVb.bUk;
            uVar.f(this.bVb.bTF);
            dVar = this.bVb.bUm;
            dVar.a(this.bVb.bUa.getListView(), this.bVb.bTF, this.bVb.bUj.ada());
        }
    }
}
