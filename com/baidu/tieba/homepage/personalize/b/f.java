package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.al;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends cb {
    final /* synthetic */ e cqT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cqT = eVar;
    }

    @Override // com.baidu.tieba.card.cb
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        al alVar;
        com.baidu.tieba.homepage.personalize.c.f fVar;
        al alVar2;
        al alVar3;
        com.baidu.tieba.homepage.personalize.c.f fVar2;
        bz.OH().cy(true);
        alVar = this.cqT.cqR;
        if (alVar != null && view != null && (bVar instanceof com.baidu.tieba.card.data.m)) {
            fVar = this.cqT.cqS;
            if (fVar != null) {
                com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) bVar;
                if (mVar.threadData != null) {
                    if ((view.getTag() instanceof String) && mVar.IU() != null && mVar.IU().getId() != null && !ai.bv(com.baidu.adp.lib.h.b.c(mVar.IU().getTid(), 0L))) {
                        ai.bu(com.baidu.adp.lib.h.b.c(mVar.IU().getTid(), 0L));
                        fVar2 = this.cqT.cqS;
                        fVar2.a(com.baidu.adp.lib.h.b.c(mVar.IU().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.OJ(), mVar.OL(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new at("c11004").ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id = view.getId();
                    alVar2 = this.cqT.cqR;
                    if (id == alVar2.baZ.getId()) {
                        TiebaStatic.log(new at("c10803").s("obj_locate", 7).ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    alVar3 = this.cqT.cqR;
                    if (id2 == alVar3.getView().getId()) {
                        TiebaStatic.log(new at("c11004").ab("tid", mVar.threadData.getTid()));
                        TiebaStatic.log(new at("c10806").s("obj_locate", 1).ab("tid", mVar.threadData.getId()));
                        return;
                    }
                    TiebaStatic.log(new at("c11004").ab("tid", mVar.threadData.getTid()));
                }
            }
        }
    }
}
