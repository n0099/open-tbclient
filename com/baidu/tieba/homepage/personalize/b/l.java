package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.personalize.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends cf {
    final /* synthetic */ k cxW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cxW = kVar;
    }

    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        al alVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        al alVar2;
        al alVar3;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cc.ST().cO(true);
        alVar = this.cxW.cxV;
        if (alVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.p)) {
            fVar = this.cxW.cxT;
            if (fVar != null) {
                com.baidu.tieba.card.data.p pVar = (com.baidu.tieba.card.data.p) bVar;
                if (pVar.bbo != null) {
                    if ((view.getTag() instanceof String) && pVar.Kn() != null && pVar.Kn().getId() != null && !aj.bq(com.baidu.adp.lib.g.b.c(pVar.Kn().getTid(), 0L))) {
                        aj.bp(com.baidu.adp.lib.g.b.c(pVar.Kn().getTid(), 0L));
                        fVar2 = this.cxW.cxT;
                        fVar2.a(com.baidu.adp.lib.g.b.c(pVar.Kn().getTid(), 0L), pVar.getWeight(), pVar.getSource(), pVar.SV(), pVar.SX(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new as("c11004").aa("tid", pVar.bbo.getTid()));
                        return;
                    }
                    int id = view.getId();
                    alVar2 = this.cxW.cxV;
                    if (id == alVar2.brw.getId()) {
                        if (pVar.bbo.getAuthor() != null && pVar.bbo.getAuthor().getGodUserData() != null && pVar.bbo.getAuthor().getGodUserData().getType() == 3) {
                            TiebaStatic.log(new as("c11274"));
                            return;
                        } else {
                            TiebaStatic.log(new as("c10803").s("obj_locate", 7).aa("tid", pVar.bbo.getTid()));
                            return;
                        }
                    }
                    int id2 = view.getId();
                    alVar3 = this.cxW.cxV;
                    if (id2 == alVar3.getView().getId()) {
                        TiebaStatic.log(new as("c11004").aa("tid", pVar.bbo.getTid()));
                        TiebaStatic.log(new as("c10806").s("obj_locate", 1).aa("tid", pVar.bbo.getId()));
                        return;
                    }
                    TiebaStatic.log(new as("c11004").aa("tid", pVar.bbo.getTid()));
                }
            }
        }
    }
}
