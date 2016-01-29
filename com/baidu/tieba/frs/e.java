package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.Iterator;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(FrsActivity frsActivity, int i) {
        super(i);
        this.bgz = frsActivity;
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
                this.bgz.bfP = true;
                this.bgz.refresh();
            } else if (aVar2.type == 2) {
                Iterator<com.baidu.adp.widget.ListView.u> it = this.bgz.bfD.Qi().getDatas().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        cVar = null;
                        break;
                    }
                    com.baidu.adp.widget.ListView.u next = it.next();
                    if (next instanceof com.baidu.tbadk.core.data.c) {
                        cVar = (com.baidu.tbadk.core.data.c) next;
                        if (aVar2.tag != null && aVar2.tag.equals(cVar.UM)) {
                            break;
                        }
                    }
                }
                if (cVar != null) {
                    cVar.UN = false;
                    this.bgz.bfD.Qi().getDatas().remove(cVar);
                    oVar = this.bgz.bfF;
                    int rI = oVar.aoE().getAdKillerData().rI();
                    int i = rI > 0 ? rI - 1 : 0;
                    oVar2 = this.bgz.bfF;
                    oVar2.aoE().getAdKillerData().bE(i);
                    aVar = this.bgz.bfS;
                    oVar3 = this.bgz.bfF;
                    aVar.d(oVar3);
                    this.bgz.bfD.Qi().notifyDataSetChanged();
                }
            }
        }
    }
}
