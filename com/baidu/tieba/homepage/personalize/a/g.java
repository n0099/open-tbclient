package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements bx {
    final /* synthetic */ f crq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.crq = fVar;
    }

    @Override // com.baidu.tieba.card.bx
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        ap apVar;
        com.baidu.tieba.homepage.personalize.b.f fVar;
        ap apVar2;
        ap apVar3;
        com.baidu.tieba.homepage.personalize.b.f fVar2;
        bw.Lg().cj(true);
        apVar = this.crq.cro;
        if (apVar != null && view != null && (bVar instanceof com.baidu.tieba.card.a.m)) {
            fVar = this.crq.crp;
            if (fVar != null) {
                com.baidu.tieba.card.a.m mVar = (com.baidu.tieba.card.a.m) bVar;
                if (mVar.threadData != null) {
                    if ((view.getTag() instanceof String) && mVar.Ix() != null && mVar.Ix().getId() != null && !com.baidu.tieba.homepage.personalize.r.br(com.baidu.adp.lib.h.b.c(mVar.Ix().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.r.bq(com.baidu.adp.lib.h.b.c(mVar.Ix().getTid(), 0L));
                        fVar2 = this.crq.crp;
                        fVar2.a(com.baidu.adp.lib.h.b.c(mVar.Ix().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.Lh(), mVar.Lj(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new ay("c11004").ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id = view.getId();
                    apVar2 = this.crq.cro;
                    if (id == apVar2.aSe.getId()) {
                        TiebaStatic.log(new ay("c10803").s("obj_locate", 7).ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    apVar3 = this.crq.cro;
                    if (id2 == apVar3.getView().getId()) {
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
