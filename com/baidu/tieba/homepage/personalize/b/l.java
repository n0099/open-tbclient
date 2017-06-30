package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.am;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.homepage.personalize.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends ci {
    final /* synthetic */ k cJM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cJM = kVar;
    }

    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        am amVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        am amVar2;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cf.VN().cw(true);
        amVar = this.cJM.cJL;
        if (amVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.n)) {
            fVar = this.cJM.cJJ;
            if (fVar != null) {
                com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                if (nVar.bai != null) {
                    if ((view.getTag() instanceof String) && nVar.Mv() != null && nVar.Mv().getId() != null && !ay.bu(com.baidu.adp.lib.g.b.c(nVar.Mv().getTid(), 0L))) {
                        ay.bt(com.baidu.adp.lib.g.b.c(nVar.Mv().getTid(), 0L));
                        fVar2 = this.cJM.cJJ;
                        fVar2.a(com.baidu.adp.lib.g.b.c(nVar.Mv().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.VS(), nVar.VU(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new au("c11004").Z("tid", nVar.bai.getTid()));
                        return;
                    }
                    int id = view.getId();
                    amVar2 = this.cJM.cJL;
                    if (id == amVar2.getView().getId()) {
                        if (nVar.bai.sv() != null && nVar.bai.sv().channelId > 0) {
                            nVar.v("c11929", true);
                        }
                        TiebaStatic.log(new au("c11004").Z("tid", nVar.bai.getTid()));
                        TiebaStatic.log(new au("c10806").r("obj_locate", 1).Z("tid", nVar.bai.getId()));
                        return;
                    }
                    TiebaStatic.log(new au("c11004").Z("tid", nVar.bai.getTid()));
                }
            }
        }
    }
}
