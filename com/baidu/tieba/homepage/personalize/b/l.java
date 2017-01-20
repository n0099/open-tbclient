package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends cf {
    final /* synthetic */ k cya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cya = kVar;
    }

    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        al alVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        al alVar2;
        al alVar3;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cc.Rx().cM(true);
        alVar = this.cya.cxZ;
        if (alVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.p)) {
            fVar = this.cya.cxX;
            if (fVar != null) {
                com.baidu.tieba.card.data.p pVar = (com.baidu.tieba.card.data.p) bVar;
                if (pVar.aVi != null) {
                    if ((view.getTag() instanceof String) && pVar.Ji() != null && pVar.Ji().getId() != null && !ai.bq(com.baidu.adp.lib.g.b.c(pVar.Ji().getTid(), 0L))) {
                        ai.bp(com.baidu.adp.lib.g.b.c(pVar.Ji().getTid(), 0L));
                        fVar2 = this.cya.cxX;
                        fVar2.a(com.baidu.adp.lib.g.b.c(pVar.Ji().getTid(), 0L), pVar.getWeight(), pVar.getSource(), pVar.Rz(), pVar.RB(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new ar("c11004").ab("tid", pVar.aVi.getTid()));
                        return;
                    }
                    int id = view.getId();
                    alVar2 = this.cya.cxZ;
                    if (id == alVar2.bkM.getId()) {
                        if (pVar.aVi.getAuthor() != null && pVar.aVi.getAuthor().getGodUserData() != null && pVar.aVi.getAuthor().getGodUserData().getType() == 3) {
                            TiebaStatic.log(new ar("c11274"));
                            return;
                        } else {
                            TiebaStatic.log(new ar("c10803").s("obj_locate", 7).ab("tid", pVar.aVi.getTid()));
                            return;
                        }
                    }
                    int id2 = view.getId();
                    alVar3 = this.cya.cxZ;
                    if (id2 == alVar3.getView().getId()) {
                        TiebaStatic.log(new ar("c11004").ab("tid", pVar.aVi.getTid()));
                        TiebaStatic.log(new ar("c10806").s("obj_locate", 1).ab("tid", pVar.aVi.getId()));
                        return;
                    }
                    TiebaStatic.log(new ar("c11004").ab("tid", pVar.aVi.getTid()));
                }
            }
        }
    }
}
