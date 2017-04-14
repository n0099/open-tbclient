package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.entelechy.c.a;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(FrsActivity frsActivity, int i) {
        super(i);
        this.bNJ = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.entelechy.b.d dVar;
        com.baidu.tieba.frs.entelechy.b.d dVar2;
        com.baidu.tieba.frs.entelechy.b.d dVar3;
        if (customResponsedMessage != null) {
            dVar = this.bNJ.bMT;
            if (dVar instanceof a) {
                dVar2 = this.bNJ.bMT;
                if (((a) dVar2).abL() != null) {
                    dVar3 = this.bNJ.bMT;
                    ((a) dVar3).abL().iw(49);
                }
            }
        }
    }
}
