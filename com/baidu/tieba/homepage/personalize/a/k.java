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
public class k extends bx {
    final /* synthetic */ j cud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.cud = jVar;
    }

    @Override // com.baidu.tieba.card.bx
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        al alVar;
        com.baidu.tieba.homepage.personalize.b.f fVar;
        al alVar2;
        al alVar3;
        com.baidu.tieba.homepage.personalize.b.f fVar2;
        bw.Lf().cl(true);
        alVar = this.cud.cuc;
        if (alVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.a.o)) {
            fVar = this.cud.ctZ;
            if (fVar != null) {
                com.baidu.tieba.card.a.o oVar = (com.baidu.tieba.card.a.o) bVar;
                if (oVar.aWa != null) {
                    if ((view.getTag() instanceof String) && oVar.Iw() != null && oVar.Iw().getId() != null && !com.baidu.tieba.homepage.personalize.y.bm(com.baidu.adp.lib.h.b.c(oVar.Iw().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.y.bl(com.baidu.adp.lib.h.b.c(oVar.Iw().getTid(), 0L));
                        fVar2 = this.cud.ctZ;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.Iw().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.Lg(), oVar.Li(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new ay("c11004").ab("tid", oVar.aWa.getTid()));
                        return;
                    }
                    int id = view.getId();
                    alVar2 = this.cud.cuc;
                    if (id == alVar2.aTa.getId()) {
                        if (oVar.aWa.getAuthor() != null && oVar.aWa.getAuthor().getGodUserData() != null && oVar.aWa.getAuthor().getGodUserData().getType() == 3) {
                            TiebaStatic.log(new ay("c11274"));
                            return;
                        } else {
                            TiebaStatic.log(new ay("c10803").s("obj_locate", 7).ab("tid", oVar.aWa.getTid()));
                            return;
                        }
                    }
                    int id2 = view.getId();
                    alVar3 = this.cud.cuc;
                    if (id2 == alVar3.getView().getId()) {
                        TiebaStatic.log(new ay("c11004").ab("tid", oVar.aWa.getTid()));
                        TiebaStatic.log(new ay("c10806").s("obj_locate", 1).ab("tid", oVar.aWa.getId()));
                        return;
                    }
                    TiebaStatic.log(new ay("c11004").ab("tid", oVar.aWa.getTid()));
                }
            }
        }
    }
}
