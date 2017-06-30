package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.homepage.personalize.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends ci {
    final /* synthetic */ g cJK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cJK = gVar;
    }

    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        ap apVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        ap apVar2;
        ap apVar3;
        ap apVar4;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cf.VN().cw(true);
        apVar = this.cJK.cJI;
        if (apVar != null && view != null && (bVar instanceof com.baidu.tieba.card.data.l)) {
            fVar = this.cJK.cJJ;
            if (fVar != null) {
                com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) bVar;
                if (lVar.threadData != null) {
                    if ((view.getTag() instanceof String) && lVar.Mv() != null && lVar.Mv().getId() != null && !ay.bu(com.baidu.adp.lib.g.b.c(lVar.Mv().getTid(), 0L))) {
                        ay.bt(com.baidu.adp.lib.g.b.c(lVar.Mv().getTid(), 0L));
                        fVar2 = this.cJK.cJJ;
                        fVar2.a(com.baidu.adp.lib.g.b.c(lVar.Mv().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.VS(), lVar.VU(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (!(view instanceof TbImageView)) {
                        apVar2 = this.cJK.cJI;
                        if (apVar2.bCa != null) {
                            int id = view.getId();
                            apVar4 = this.cJK.cJI;
                            if (id == apVar4.bCa.getId()) {
                                TiebaStatic.log(new au("c10803").r("obj_locate", 7).Z("tid", lVar.threadData.getTid()));
                                return;
                            }
                        }
                        int id2 = view.getId();
                        apVar3 = this.cJK.cJI;
                        if (id2 == apVar3.getView().getId()) {
                            TiebaStatic.log(new au("c11004").Z("tid", lVar.threadData.getTid()));
                            TiebaStatic.log(new au("c10806").r("obj_locate", 1).Z("tid", lVar.threadData.getId()));
                            return;
                        }
                        TiebaStatic.log(new au("c11004").Z("tid", lVar.threadData.getTid()));
                        return;
                    }
                    TiebaStatic.log(new au("c11004").Z("tid", lVar.threadData.getTid()));
                }
            }
        }
    }
}
