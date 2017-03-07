package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends cf {
    final /* synthetic */ g czu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.czu = gVar;
    }

    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        ap apVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        ap apVar2;
        ap apVar3;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cc.Sv().cM(true);
        apVar = this.czu.czs;
        if (apVar != null && view != null && (bVar instanceof com.baidu.tieba.card.data.n)) {
            fVar = this.czu.czt;
            if (fVar != null) {
                com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                if (nVar.threadData != null) {
                    if ((view.getTag() instanceof String) && nVar.JN() != null && nVar.JN().getId() != null && !ai.bq(com.baidu.adp.lib.g.b.c(nVar.JN().getTid(), 0L))) {
                        ai.bp(com.baidu.adp.lib.g.b.c(nVar.JN().getTid(), 0L));
                        fVar2 = this.czu.czt;
                        fVar2.a(com.baidu.adp.lib.g.b.c(nVar.JN().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Sx(), nVar.Sz(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new as("c11004").Z("tid", nVar.threadData.getTid()));
                        return;
                    }
                    int id = view.getId();
                    apVar2 = this.czu.czs;
                    if (id == apVar2.brE.getId()) {
                        TiebaStatic.log(new as("c10803").s("obj_locate", 7).Z("tid", nVar.threadData.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    apVar3 = this.czu.czs;
                    if (id2 == apVar3.getView().getId()) {
                        TiebaStatic.log(new as("c11004").Z("tid", nVar.threadData.getTid()));
                        TiebaStatic.log(new as("c10806").s("obj_locate", 1).Z("tid", nVar.threadData.getId()));
                        return;
                    }
                    TiebaStatic.log(new as("c11004").Z("tid", nVar.threadData.getTid()));
                }
            }
        }
    }
}
