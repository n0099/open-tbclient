package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.homepage.personalize.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends cd {
    final /* synthetic */ g cvv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cvv = gVar;
    }

    @Override // com.baidu.tieba.card.cd
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        al alVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        al alVar2;
        al alVar3;
        al alVar4;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        ca.To().db(true);
        alVar = this.cvv.cvt;
        if (alVar != null && view != null && (bVar instanceof com.baidu.tieba.card.data.l)) {
            fVar = this.cvv.cvu;
            if (fVar != null) {
                com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) bVar;
                if (lVar.threadData != null) {
                    if ((view.getTag() instanceof String) && lVar.JB() != null && lVar.JB().getId() != null && !am.bd(com.baidu.adp.lib.g.b.c(lVar.JB().getTid(), 0L))) {
                        am.bc(com.baidu.adp.lib.g.b.c(lVar.JB().getTid(), 0L));
                        fVar2 = this.cvv.cvu;
                        fVar2.a(com.baidu.adp.lib.g.b.c(lVar.JB().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.Tq(), lVar.Ts(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (!(view instanceof TbImageView)) {
                        alVar2 = this.cvv.cvt;
                        if (alVar2.bvt != null) {
                            int id = view.getId();
                            alVar4 = this.cvv.cvt;
                            if (id == alVar4.bvt.getId()) {
                                TiebaStatic.log(new as("c10803").s("obj_locate", 7).aa("tid", lVar.threadData.getTid()));
                                return;
                            }
                        }
                        int id2 = view.getId();
                        alVar3 = this.cvv.cvt;
                        if (id2 == alVar3.getView().getId()) {
                            TiebaStatic.log(new as("c11004").aa("tid", lVar.threadData.getTid()));
                            TiebaStatic.log(new as("c10806").s("obj_locate", 1).aa("tid", lVar.threadData.getId()));
                            return;
                        }
                        TiebaStatic.log(new as("c11004").aa("tid", lVar.threadData.getTid()));
                        return;
                    }
                    TiebaStatic.log(new as("c11004").aa("tid", lVar.threadData.getTid()));
                }
            }
        }
    }
}
