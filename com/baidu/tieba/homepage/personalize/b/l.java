package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends cf {
    final /* synthetic */ k czw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.czw = kVar;
    }

    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        al alVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        al alVar2;
        al alVar3;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cc.Sv().cM(true);
        alVar = this.czw.czv;
        if (alVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.p)) {
            fVar = this.czw.czt;
            if (fVar != null) {
                com.baidu.tieba.card.data.p pVar = (com.baidu.tieba.card.data.p) bVar;
                if (pVar.bbv != null) {
                    if ((view.getTag() instanceof String) && pVar.JN() != null && pVar.JN().getId() != null && !ai.bq(com.baidu.adp.lib.g.b.c(pVar.JN().getTid(), 0L))) {
                        ai.bp(com.baidu.adp.lib.g.b.c(pVar.JN().getTid(), 0L));
                        fVar2 = this.czw.czt;
                        fVar2.a(com.baidu.adp.lib.g.b.c(pVar.JN().getTid(), 0L), pVar.getWeight(), pVar.getSource(), pVar.Sx(), pVar.Sz(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new as("c11004").Z("tid", pVar.bbv.getTid()));
                        return;
                    }
                    int id = view.getId();
                    alVar2 = this.czw.czv;
                    if (id == alVar2.brE.getId()) {
                        if (pVar.bbv.getAuthor() != null && pVar.bbv.getAuthor().getGodUserData() != null && pVar.bbv.getAuthor().getGodUserData().getType() == 3) {
                            TiebaStatic.log(new as("c11274"));
                            return;
                        } else {
                            TiebaStatic.log(new as("c10803").s("obj_locate", 7).Z("tid", pVar.bbv.getTid()));
                            return;
                        }
                    }
                    int id2 = view.getId();
                    alVar3 = this.czw.czv;
                    if (id2 == alVar3.getView().getId()) {
                        TiebaStatic.log(new as("c11004").Z("tid", pVar.bbv.getTid()));
                        TiebaStatic.log(new as("c10806").s("obj_locate", 1).Z("tid", pVar.bbv.getId()));
                        return;
                    }
                    TiebaStatic.log(new as("c11004").Z("tid", pVar.bbv.getTid()));
                }
            }
        }
    }
}
