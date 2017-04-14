package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(FrsActivity frsActivity, int i) {
        super(i);
        this.bNJ = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.g.u uVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.v) && this.bNJ.bME != null) {
            this.bNJ.bME.c((com.baidu.tieba.tbadkCore.v) customResponsedMessage.getData());
            uVar = this.bNJ.bMP;
            uVar.h(this.bNJ.bME);
            dVar = this.bNJ.bMT;
            dVar.a(this.bNJ.bMD.getListView(), this.bNJ.bME, this.bNJ.bMO.acR());
        }
    }
}
