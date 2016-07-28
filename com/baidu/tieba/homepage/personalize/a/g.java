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
public class g extends bx {
    final /* synthetic */ f cua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.cua = fVar;
    }

    @Override // com.baidu.tieba.card.bx
    public void a(View view, com.baidu.tieba.card.a.b bVar) {
        ap apVar;
        com.baidu.tieba.homepage.personalize.b.f fVar;
        ap apVar2;
        ap apVar3;
        com.baidu.tieba.homepage.personalize.b.f fVar2;
        bw.Lf().cl(true);
        apVar = this.cua.ctY;
        if (apVar != null && view != null && (bVar instanceof com.baidu.tieba.card.a.m)) {
            fVar = this.cua.ctZ;
            if (fVar != null) {
                com.baidu.tieba.card.a.m mVar = (com.baidu.tieba.card.a.m) bVar;
                if (mVar.threadData != null) {
                    if ((view.getTag() instanceof String) && mVar.Iw() != null && mVar.Iw().getId() != null && !com.baidu.tieba.homepage.personalize.y.bm(com.baidu.adp.lib.h.b.c(mVar.Iw().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.y.bl(com.baidu.adp.lib.h.b.c(mVar.Iw().getTid(), 0L));
                        fVar2 = this.cua.ctZ;
                        fVar2.a(com.baidu.adp.lib.h.b.c(mVar.Iw().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.Lg(), mVar.Li(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new ay("c11004").ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id = view.getId();
                    apVar2 = this.cua.ctY;
                    if (id == apVar2.aTa.getId()) {
                        TiebaStatic.log(new ay("c10803").s("obj_locate", 7).ab("tid", mVar.threadData.getTid()));
                        return;
                    }
                    int id2 = view.getId();
                    apVar3 = this.cua.ctY;
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
