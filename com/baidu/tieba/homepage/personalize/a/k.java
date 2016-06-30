package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements bx {
    final /* synthetic */ j crt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.crt = jVar;
    }

    @Override // com.baidu.tieba.card.bx
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        al alVar;
        com.baidu.tieba.homepage.personalize.b.f fVar;
        al alVar2;
        al alVar3;
        com.baidu.tieba.homepage.personalize.b.f fVar2;
        bw.Lg().cj(true);
        alVar = this.crt.crs;
        if (alVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.a.o)) {
            fVar = this.crt.crp;
            if (fVar != null) {
                com.baidu.tieba.card.a.o oVar = (com.baidu.tieba.card.a.o) bVar;
                if (oVar.aVc != null) {
                    if ((view.getTag() instanceof String) && oVar.Ix() != null && oVar.Ix().getId() != null && !com.baidu.tieba.homepage.personalize.r.br(com.baidu.adp.lib.h.b.c(oVar.Ix().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.r.bq(com.baidu.adp.lib.h.b.c(oVar.Ix().getTid(), 0L));
                        fVar2 = this.crt.crp;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.Ix().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.Lh(), oVar.Lj(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new ay("c11004").ab("tid", oVar.aVc.getTid()));
                        return;
                    }
                    int id = view.getId();
                    alVar2 = this.crt.crs;
                    if (id == alVar2.aSe.getId()) {
                        if (oVar.aVc.getAuthor() != null && oVar.aVc.getAuthor().getGodUserData() != null && oVar.aVc.getAuthor().getGodUserData().getType() == 3) {
                            TiebaStatic.log(new ay("c11274"));
                            return;
                        } else {
                            TiebaStatic.log(new ay("c10803").s("obj_locate", 7).ab("tid", oVar.aVc.getTid()));
                            return;
                        }
                    }
                    int id2 = view.getId();
                    alVar3 = this.crt.crs;
                    if (id2 == alVar3.getView().getId()) {
                        TiebaStatic.log(new ay("c11004").ab("tid", oVar.aVc.getTid()));
                        TiebaStatic.log(new ay("c10806").s("obj_locate", 1).ab("tid", oVar.aVc.getId()));
                        return;
                    }
                    TiebaStatic.log(new ay("c11004").ab("tid", oVar.aVc.getTid()));
                }
            }
        }
    }
}
