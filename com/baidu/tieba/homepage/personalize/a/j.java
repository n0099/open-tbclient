package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ah;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends cf {
    final /* synthetic */ i cFH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cFH = iVar;
    }

    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        ah ahVar;
        com.baidu.tieba.homepage.personalize.b.f fVar;
        ah ahVar2;
        ah ahVar3;
        com.baidu.tieba.homepage.personalize.b.f fVar2;
        cd.NI().cr(true);
        ahVar = this.cFH.cFG;
        if (ahVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.o)) {
            fVar = this.cFH.cFD;
            if (fVar != null) {
                com.baidu.tieba.card.data.o oVar = (com.baidu.tieba.card.data.o) bVar;
                if (oVar.bbC != null) {
                    if ((view.getTag() instanceof String) && oVar.Kw() != null && oVar.Kw().getId() != null && !com.baidu.tieba.homepage.personalize.y.bI(com.baidu.adp.lib.h.b.c(oVar.Kw().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.y.bH(com.baidu.adp.lib.h.b.c(oVar.Kw().getTid(), 0L));
                        fVar2 = this.cFH.cFD;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.Kw().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.NJ(), oVar.NL(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new ay("c11004").ab("tid", oVar.bbC.getTid()));
                        return;
                    }
                    int id = view.getId();
                    ahVar2 = this.cFH.cFG;
                    if (id == ahVar2.aYi.getId()) {
                        if (oVar.bbC.getAuthor() != null && oVar.bbC.getAuthor().getGodUserData() != null && oVar.bbC.getAuthor().getGodUserData().getType() == 3) {
                            TiebaStatic.log(new ay("c11274"));
                            return;
                        } else {
                            TiebaStatic.log(new ay("c10803").s("obj_locate", 7).ab("tid", oVar.bbC.getTid()));
                            return;
                        }
                    }
                    int id2 = view.getId();
                    ahVar3 = this.cFH.cFG;
                    if (id2 == ahVar3.getView().getId()) {
                        TiebaStatic.log(new ay("c11004").ab("tid", oVar.bbC.getTid()));
                        TiebaStatic.log(new ay("c10806").s("obj_locate", 1).ab("tid", oVar.bbC.getId()));
                        return;
                    }
                    TiebaStatic.log(new ay("c11004").ab("tid", oVar.bbC.getTid()));
                }
            }
        }
    }
}
