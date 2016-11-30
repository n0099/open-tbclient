package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends bz {
    final /* synthetic */ i cLG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cLG = iVar;
    }

    @Override // com.baidu.tieba.card.bz
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        com.baidu.tieba.card.af afVar;
        com.baidu.tieba.homepage.personalize.c.f fVar;
        com.baidu.tieba.card.af afVar2;
        com.baidu.tieba.card.af afVar3;
        com.baidu.tieba.homepage.personalize.c.f fVar2;
        bx.Pl().cw(true);
        afVar = this.cLG.cLF;
        if (afVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.o)) {
            fVar = this.cLG.cLC;
            if (fVar != null) {
                com.baidu.tieba.card.data.o oVar = (com.baidu.tieba.card.data.o) bVar;
                if (oVar.beS != null) {
                    if ((view.getTag() instanceof String) && oVar.Jz() != null && oVar.Jz().getId() != null && !ai.bH(com.baidu.adp.lib.h.b.c(oVar.Jz().getTid(), 0L))) {
                        ai.bG(com.baidu.adp.lib.h.b.c(oVar.Jz().getTid(), 0L));
                        fVar2 = this.cLG.cLC;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.Jz().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.Pn(), oVar.Pp(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new av("c11004").ab("tid", oVar.beS.getTid()));
                        return;
                    }
                    int id = view.getId();
                    afVar2 = this.cLG.cLF;
                    if (id == afVar2.bbT.getId()) {
                        if (oVar.beS.getAuthor() != null && oVar.beS.getAuthor().getGodUserData() != null && oVar.beS.getAuthor().getGodUserData().getType() == 3) {
                            TiebaStatic.log(new av("c11274"));
                            return;
                        } else {
                            TiebaStatic.log(new av("c10803").s("obj_locate", 7).ab("tid", oVar.beS.getTid()));
                            return;
                        }
                    }
                    int id2 = view.getId();
                    afVar3 = this.cLG.cLF;
                    if (id2 == afVar3.getView().getId()) {
                        TiebaStatic.log(new av("c11004").ab("tid", oVar.beS.getTid()));
                        TiebaStatic.log(new av("c10806").s("obj_locate", 1).ab("tid", oVar.beS.getId()));
                        return;
                    }
                    TiebaStatic.log(new av("c11004").ab("tid", oVar.beS.getTid()));
                }
            }
        }
    }
}
