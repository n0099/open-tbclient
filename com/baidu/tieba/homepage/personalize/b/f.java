package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aj;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.homepage.personalize.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends cd {
    final /* synthetic */ e cGs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cGs = eVar;
    }

    @Override // com.baidu.tieba.card.cd
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        aj ajVar;
        com.baidu.tieba.homepage.personalize.c.f fVar;
        aj ajVar2;
        aj ajVar3;
        com.baidu.tieba.homepage.personalize.c.f fVar2;
        cb.Oj().cr(true);
        ajVar = this.cGs.cGq;
        if (ajVar != null && view != null && (bVar instanceof com.baidu.tieba.card.data.m)) {
            fVar = this.cGs.cGr;
            if (fVar != null) {
                com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) bVar;
                if (mVar.threadData != null) {
                    if ((view.getTag() instanceof String) && mVar.Jv() != null && mVar.Jv().getId() != null && !ak.bI(com.baidu.adp.lib.h.b.c(mVar.Jv().getTid(), 0L))) {
                        ak.bH(com.baidu.adp.lib.h.b.c(mVar.Jv().getTid(), 0L));
                        fVar2 = this.cGs.cGr;
                        fVar2.a(com.baidu.adp.lib.h.b.c(mVar.Jv().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.Ok(), mVar.Om(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new ax("c11004").ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id = view.getId();
                    ajVar2 = this.cGs.cGq;
                    if (id == ajVar2.aYK.getId()) {
                        TiebaStatic.log(new ax("c10803").s("obj_locate", 7).ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    ajVar3 = this.cGs.cGq;
                    if (id2 == ajVar3.getView().getId()) {
                        TiebaStatic.log(new ax("c11004").ab("tid", mVar.threadData.getTid()));
                        TiebaStatic.log(new ax("c10806").s("obj_locate", 1).ab("tid", mVar.threadData.getId()));
                        return;
                    }
                    TiebaStatic.log(new ax("c11004").ab("tid", mVar.threadData.getTid()));
                }
            }
        }
    }
}
