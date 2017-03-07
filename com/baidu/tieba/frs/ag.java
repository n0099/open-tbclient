package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(FrsActivity frsActivity, int i) {
        super(i);
        this.bNU = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.v) && this.bNU.bMO != null) {
            this.bNU.bMO.c((com.baidu.tieba.tbadkCore.v) customResponsedMessage.getData());
            uVar = this.bNU.bMZ;
            uVar.h(this.bNU.bMO);
            dVar = this.bNU.bNd;
            dVar.a(this.bNU.bMN.getListView(), this.bNU.bMO, this.bNU.bMY.acX());
        }
    }
}
