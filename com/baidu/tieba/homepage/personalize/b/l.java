package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.am;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends ci {
    final /* synthetic */ k cBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cBP = kVar;
    }

    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        am amVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        am amVar2;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cf.Uw().ds(true);
        amVar = this.cBP.cBO;
        if (amVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.n)) {
            fVar = this.cBP.cBM;
            if (fVar != null) {
                com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                if (nVar.aYA != null) {
                    if ((view.getTag() instanceof String) && nVar.LH() != null && nVar.LH().getId() != null && !com.baidu.tieba.homepage.personalize.am.bg(com.baidu.adp.lib.g.b.c(nVar.LH().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.am.bf(com.baidu.adp.lib.g.b.c(nVar.LH().getTid(), 0L));
                        fVar2 = this.cBP.cBM;
                        fVar2.a(com.baidu.adp.lib.g.b.c(nVar.LH().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.UB(), nVar.UD(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new as("c11004").Z("tid", nVar.aYA.getTid()));
                        return;
                    }
                    int id = view.getId();
                    amVar2 = this.cBP.cBO;
                    if (id == amVar2.getView().getId()) {
                        if (nVar.aYA.sx() != null && nVar.aYA.sx().channelId > 0) {
                            nVar.x("c11929", true);
                        }
                        TiebaStatic.log(new as("c11004").Z("tid", nVar.aYA.getTid()));
                        TiebaStatic.log(new as("c10806").r("obj_locate", 1).Z("tid", nVar.aYA.getId()));
                        return;
                    }
                    TiebaStatic.log(new as("c11004").Z("tid", nVar.aYA.getTid()));
                }
            }
        }
    }
}
