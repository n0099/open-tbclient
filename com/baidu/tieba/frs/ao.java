package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.entelechy.c.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends CustomMessageListener {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(r rVar, int i) {
        super(i);
        this.bVb = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar3;
        if (customResponsedMessage != null) {
            dVar = this.bVb.bUm;
            if (dVar instanceof a) {
                dVar2 = this.bVb.bUm;
                if (((a) dVar2).abX() != null) {
                    dVar3 = this.bVb.bUm;
                    ((a) dVar3).abX().iS(49);
                }
            }
        }
    }
}
