package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.adkiller.a;
import com.baidu.tieba.view.BdExpandListView;
import java.util.Iterator;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(FrsActivity frsActivity, int i) {
        super(i);
        this.bhl = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cn cnVar;
        com.baidu.tbadk.core.data.c cVar;
        cn cnVar2;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.frs.h.m mVar;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        cn cnVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        cn cnVar4;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof a)) {
            a aVar = (a) customResponsedMessage.getData();
            if (aVar.type == 1) {
                this.bhl.bgB = true;
                this.bhl.refresh();
            } else if (aVar.type == 2) {
                cnVar = this.bhl.bgo;
                Iterator<com.baidu.adp.widget.ListView.v> it = cnVar.Ra().getDatas().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        cVar = null;
                        break;
                    }
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next instanceof com.baidu.tbadk.core.data.c) {
                        cVar = (com.baidu.tbadk.core.data.c) next;
                        if (aVar.tag != null && aVar.tag.equals(cVar.Nf)) {
                            break;
                        }
                    }
                }
                if (cVar != null) {
                    cVar.Ng = false;
                    cnVar2 = this.bhl.bgo;
                    cnVar2.Ra().getDatas().remove(cVar);
                    oVar = this.bhl.bgq;
                    int oB = oVar.avD().getAdKillerData().oB();
                    int i = oB > 0 ? oB - 1 : 0;
                    oVar2 = this.bhl.bgq;
                    oVar2.avD().getAdKillerData().bp(i);
                    mVar = this.bhl.bgE;
                    oVar3 = this.bhl.bgq;
                    mVar.e(oVar3);
                    dVar = this.bhl.bgI;
                    cnVar3 = this.bhl.bgo;
                    BdExpandListView QR = cnVar3.QR();
                    oVar4 = this.bhl.bgq;
                    dVar.a(QR, oVar4);
                    cnVar4 = this.bhl.bgo;
                    cnVar4.Ra().notifyDataSetChanged();
                }
            }
        }
    }
}
