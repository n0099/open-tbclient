package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends cf {
    final /* synthetic */ e cFE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cFE = eVar;
    }

    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        al alVar;
        com.baidu.tieba.homepage.personalize.b.f fVar;
        al alVar2;
        al alVar3;
        com.baidu.tieba.homepage.personalize.b.f fVar2;
        cd.NI().cr(true);
        alVar = this.cFE.cFC;
        if (alVar != null && view != null && (bVar instanceof com.baidu.tieba.card.data.m)) {
            fVar = this.cFE.cFD;
            if (fVar != null) {
                com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) bVar;
                if (mVar.threadData != null) {
                    if ((view.getTag() instanceof String) && mVar.Kw() != null && mVar.Kw().getId() != null && !com.baidu.tieba.homepage.personalize.y.bI(com.baidu.adp.lib.h.b.c(mVar.Kw().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.y.bH(com.baidu.adp.lib.h.b.c(mVar.Kw().getTid(), 0L));
                        fVar2 = this.cFE.cFD;
                        fVar2.a(com.baidu.adp.lib.h.b.c(mVar.Kw().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.NJ(), mVar.NL(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new ay("c11004").ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id = view.getId();
                    alVar2 = this.cFE.cFC;
                    if (id == alVar2.aYi.getId()) {
                        TiebaStatic.log(new ay("c10803").s("obj_locate", 7).ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    alVar3 = this.cFE.cFC;
                    if (id2 == alVar3.getView().getId()) {
                        TiebaStatic.log(new ay("c11004").ab("tid", mVar.threadData.getTid()));
                        TiebaStatic.log(new ay("c10806").s("obj_locate", 1).ab("tid", mVar.threadData.getId()));
                        return;
                    }
                    TiebaStatic.log(new ay("c11004").ab("tid", mVar.threadData.getTid()));
                }
            }
        }
    }
}
