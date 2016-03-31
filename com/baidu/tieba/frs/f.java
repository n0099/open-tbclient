package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.Iterator;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(FrsActivity frsActivity, int i) {
        super(i);
        this.blk = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.c cVar;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.tbadkCore.o oVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.adkiller.a)) {
            com.baidu.tieba.adkiller.a aVar2 = (com.baidu.tieba.adkiller.a) customResponsedMessage.getData();
            if (aVar2.type == 1) {
                this.blk.bkA = true;
                this.blk.refresh();
            } else if (aVar2.type == 2) {
                Iterator<com.baidu.adp.widget.ListView.u> it = this.blk.bko.Sb().getDatas().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        cVar = null;
                        break;
                    }
                    com.baidu.adp.widget.ListView.u next = it.next();
                    if (next instanceof com.baidu.tbadk.core.data.c) {
                        cVar = (com.baidu.tbadk.core.data.c) next;
                        if (aVar2.tag != null && aVar2.tag.equals(cVar.Sr)) {
                            break;
                        }
                    }
                }
                if (cVar != null) {
                    cVar.Ss = false;
                    this.blk.bko.Sb().getDatas().remove(cVar);
                    oVar = this.blk.bkq;
                    int rg = oVar.avu().getAdKillerData().rg();
                    int i = rg > 0 ? rg - 1 : 0;
                    oVar2 = this.blk.bkq;
                    oVar2.avu().getAdKillerData().bD(i);
                    aVar = this.blk.bkD;
                    oVar3 = this.blk.bkq;
                    aVar.d(oVar3);
                    this.blk.bko.Sb().notifyDataSetChanged();
                }
            }
        }
    }
}
