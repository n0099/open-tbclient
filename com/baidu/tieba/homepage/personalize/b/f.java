package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aj;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends bz {
    final /* synthetic */ e cLD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cLD = eVar;
    }

    @Override // com.baidu.tieba.card.bz
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        aj ajVar;
        com.baidu.tieba.homepage.personalize.c.f fVar;
        aj ajVar2;
        aj ajVar3;
        com.baidu.tieba.homepage.personalize.c.f fVar2;
        bx.Pl().cw(true);
        ajVar = this.cLD.cLB;
        if (ajVar != null && view != null && (bVar instanceof com.baidu.tieba.card.data.m)) {
            fVar = this.cLD.cLC;
            if (fVar != null) {
                com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) bVar;
                if (mVar.threadData != null) {
                    if ((view.getTag() instanceof String) && mVar.Jz() != null && mVar.Jz().getId() != null && !ai.bH(com.baidu.adp.lib.h.b.c(mVar.Jz().getTid(), 0L))) {
                        ai.bG(com.baidu.adp.lib.h.b.c(mVar.Jz().getTid(), 0L));
                        fVar2 = this.cLD.cLC;
                        fVar2.a(com.baidu.adp.lib.h.b.c(mVar.Jz().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.Pn(), mVar.Pp(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new av("c11004").ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id = view.getId();
                    ajVar2 = this.cLD.cLB;
                    if (id == ajVar2.bbT.getId()) {
                        TiebaStatic.log(new av("c10803").s("obj_locate", 7).ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    ajVar3 = this.cLD.cLB;
                    if (id2 == ajVar3.getView().getId()) {
                        TiebaStatic.log(new av("c11004").ab("tid", mVar.threadData.getTid()));
                        TiebaStatic.log(new av("c10806").s("obj_locate", 1).ab("tid", mVar.threadData.getId()));
                        return;
                    }
                    TiebaStatic.log(new av("c11004").ab("tid", mVar.threadData.getTid()));
                }
            }
        }
    }
}
