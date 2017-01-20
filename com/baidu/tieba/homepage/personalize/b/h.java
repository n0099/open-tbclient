package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends cf {
    final /* synthetic */ g cxY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cxY = gVar;
    }

    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        ap apVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        ap apVar2;
        ap apVar3;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cc.Rx().cM(true);
        apVar = this.cxY.cxW;
        if (apVar != null && view != null && (bVar instanceof com.baidu.tieba.card.data.n)) {
            fVar = this.cxY.cxX;
            if (fVar != null) {
                com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                if (nVar.threadData != null) {
                    if ((view.getTag() instanceof String) && nVar.Ji() != null && nVar.Ji().getId() != null && !ai.bq(com.baidu.adp.lib.g.b.c(nVar.Ji().getTid(), 0L))) {
                        ai.bp(com.baidu.adp.lib.g.b.c(nVar.Ji().getTid(), 0L));
                        fVar2 = this.cxY.cxX;
                        fVar2.a(com.baidu.adp.lib.g.b.c(nVar.Ji().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Rz(), nVar.RB(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new ar("c11004").ab("tid", nVar.threadData.getTid()));
                        return;
                    }
                    int id = view.getId();
                    apVar2 = this.cxY.cxW;
                    if (id == apVar2.bkM.getId()) {
                        TiebaStatic.log(new ar("c10803").s("obj_locate", 7).ab("tid", nVar.threadData.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    apVar3 = this.cxY.cxW;
                    if (id2 == apVar3.getView().getId()) {
                        TiebaStatic.log(new ar("c11004").ab("tid", nVar.threadData.getTid()));
                        TiebaStatic.log(new ar("c10806").s("obj_locate", 1).ab("tid", nVar.threadData.getId()));
                        return;
                    }
                    TiebaStatic.log(new ar("c11004").ab("tid", nVar.threadData.getTid()));
                }
            }
        }
    }
}
