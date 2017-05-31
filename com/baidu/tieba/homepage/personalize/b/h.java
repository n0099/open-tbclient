package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.homepage.personalize.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends ci {
    final /* synthetic */ g cBN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cBN = gVar;
    }

    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        ap apVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        ap apVar2;
        ap apVar3;
        ap apVar4;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cf.Uw().ds(true);
        apVar = this.cBN.cBL;
        if (apVar != null && view != null && (bVar instanceof com.baidu.tieba.card.data.l)) {
            fVar = this.cBN.cBM;
            if (fVar != null) {
                com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) bVar;
                if (lVar.threadData != null) {
                    if ((view.getTag() instanceof String) && lVar.LH() != null && lVar.LH().getId() != null && !am.bg(com.baidu.adp.lib.g.b.c(lVar.LH().getTid(), 0L))) {
                        am.bf(com.baidu.adp.lib.g.b.c(lVar.LH().getTid(), 0L));
                        fVar2 = this.cBN.cBM;
                        fVar2.a(com.baidu.adp.lib.g.b.c(lVar.LH().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.UB(), lVar.UD(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (!(view instanceof TbImageView)) {
                        apVar2 = this.cBN.cBL;
                        if (apVar2.bBh != null) {
                            int id = view.getId();
                            apVar4 = this.cBN.cBL;
                            if (id == apVar4.bBh.getId()) {
                                TiebaStatic.log(new as("c10803").r("obj_locate", 7).Z("tid", lVar.threadData.getTid()));
                                return;
                            }
                        }
                        int id2 = view.getId();
                        apVar3 = this.cBN.cBL;
                        if (id2 == apVar3.getView().getId()) {
                            TiebaStatic.log(new as("c11004").Z("tid", lVar.threadData.getTid()));
                            TiebaStatic.log(new as("c10806").r("obj_locate", 1).Z("tid", lVar.threadData.getId()));
                            return;
                        }
                        TiebaStatic.log(new as("c11004").Z("tid", lVar.threadData.getTid()));
                        return;
                    }
                    TiebaStatic.log(new as("c11004").Z("tid", lVar.threadData.getTid()));
                }
            }
        }
    }
}
