package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ah;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends cb {
    final /* synthetic */ i cqV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cqV = iVar;
    }

    @Override // com.baidu.tieba.card.cb
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        ah ahVar;
        com.baidu.tieba.homepage.personalize.c.f fVar;
        ah ahVar2;
        ah ahVar3;
        com.baidu.tieba.homepage.personalize.c.f fVar2;
        bz.OH().cy(true);
        ahVar = this.cqV.cqU;
        if (ahVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.o)) {
            fVar = this.cqV.cqS;
            if (fVar != null) {
                com.baidu.tieba.card.data.o oVar = (com.baidu.tieba.card.data.o) bVar;
                if (oVar.beB != null) {
                    if ((view.getTag() instanceof String) && oVar.IU() != null && oVar.IU().getId() != null && !ai.bv(com.baidu.adp.lib.h.b.c(oVar.IU().getTid(), 0L))) {
                        ai.bu(com.baidu.adp.lib.h.b.c(oVar.IU().getTid(), 0L));
                        fVar2 = this.cqV.cqS;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.IU().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.OJ(), oVar.OL(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new at("c11004").ab("tid", oVar.beB.getTid()));
                        return;
                    }
                    int id = view.getId();
                    ahVar2 = this.cqV.cqU;
                    if (id == ahVar2.baZ.getId()) {
                        if (oVar.beB.getAuthor() != null && oVar.beB.getAuthor().getGodUserData() != null && oVar.beB.getAuthor().getGodUserData().getType() == 3) {
                            TiebaStatic.log(new at("c11274"));
                            return;
                        } else {
                            TiebaStatic.log(new at("c10803").s("obj_locate", 7).ab("tid", oVar.beB.getTid()));
                            return;
                        }
                    }
                    int id2 = view.getId();
                    ahVar3 = this.cqV.cqU;
                    if (id2 == ahVar3.getView().getId()) {
                        TiebaStatic.log(new at("c11004").ab("tid", oVar.beB.getTid()));
                        TiebaStatic.log(new at("c10806").s("obj_locate", 1).ab("tid", oVar.beB.getId()));
                        return;
                    }
                    TiebaStatic.log(new at("c11004").ab("tid", oVar.beB.getTid()));
                }
            }
        }
    }
}
