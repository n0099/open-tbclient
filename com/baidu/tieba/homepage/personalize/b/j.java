package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.homepage.personalize.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends cd {
    final /* synthetic */ i cGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cGv = iVar;
    }

    @Override // com.baidu.tieba.card.cd
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        com.baidu.tieba.card.af afVar;
        com.baidu.tieba.homepage.personalize.c.f fVar;
        com.baidu.tieba.card.af afVar2;
        com.baidu.tieba.card.af afVar3;
        com.baidu.tieba.homepage.personalize.c.f fVar2;
        cb.Oj().cr(true);
        afVar = this.cGv.cGu;
        if (afVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.o)) {
            fVar = this.cGv.cGr;
            if (fVar != null) {
                com.baidu.tieba.card.data.o oVar = (com.baidu.tieba.card.data.o) bVar;
                if (oVar.bbU != null) {
                    if ((view.getTag() instanceof String) && oVar.Jv() != null && oVar.Jv().getId() != null && !ak.bI(com.baidu.adp.lib.h.b.c(oVar.Jv().getTid(), 0L))) {
                        ak.bH(com.baidu.adp.lib.h.b.c(oVar.Jv().getTid(), 0L));
                        fVar2 = this.cGv.cGr;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.Jv().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.Ok(), oVar.Om(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new ax("c11004").ab("tid", oVar.bbU.getTid()));
                        return;
                    }
                    int id = view.getId();
                    afVar2 = this.cGv.cGu;
                    if (id == afVar2.aYK.getId()) {
                        if (oVar.bbU.getAuthor() != null && oVar.bbU.getAuthor().getGodUserData() != null && oVar.bbU.getAuthor().getGodUserData().getType() == 3) {
                            TiebaStatic.log(new ax("c11274"));
                            return;
                        } else {
                            TiebaStatic.log(new ax("c10803").s("obj_locate", 7).ab("tid", oVar.bbU.getTid()));
                            return;
                        }
                    }
                    int id2 = view.getId();
                    afVar3 = this.cGv.cGu;
                    if (id2 == afVar3.getView().getId()) {
                        TiebaStatic.log(new ax("c11004").ab("tid", oVar.bbU.getTid()));
                        TiebaStatic.log(new ax("c10806").s("obj_locate", 1).ab("tid", oVar.bbU.getId()));
                        return;
                    }
                    TiebaStatic.log(new ax("c11004").ab("tid", oVar.bbU.getTid()));
                }
            }
        }
    }
}
