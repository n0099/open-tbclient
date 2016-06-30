package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* loaded from: classes.dex */
class ar extends CustomMessageListener {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(FrsActivity frsActivity, int i) {
        super(i);
        this.bDB = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.frs.i.p pVar3;
        com.baidu.tieba.tbadkCore.p pVar4;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        bq bqVar;
        com.baidu.tieba.tbadkCore.p pVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.z)) {
            pVar = this.bDB.bCF;
            if (pVar != null) {
                pVar2 = this.bDB.bCF;
                pVar2.c((com.baidu.tieba.tbadkCore.z) customResponsedMessage.getData());
                pVar3 = this.bDB.bCR;
                pVar4 = this.bDB.bCF;
                pVar3.f(pVar4);
                dVar = this.bDB.bCV;
                bqVar = this.bDB.bCD;
                BdTypeListView listView = bqVar.getListView();
                pVar5 = this.bDB.bCF;
                dVar.a(listView, pVar5, this.bDB.bCQ.ZK());
            }
        }
    }
}
