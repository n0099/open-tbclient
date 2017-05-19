package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ai;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.homepage.personalize.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends cd {
    final /* synthetic */ k cvx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cvx = kVar;
    }

    @Override // com.baidu.tieba.card.cd
    public void a(View view, com.baidu.tieba.card.data.b bVar) {
        ai aiVar;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        ai aiVar2;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        ca.To().db(true);
        aiVar = this.cvx.cvw;
        if (aiVar != null && view != null && bVar != null && (bVar instanceof com.baidu.tieba.card.data.n)) {
            fVar = this.cvx.cvu;
            if (fVar != null) {
                com.baidu.tieba.card.data.n nVar = (com.baidu.tieba.card.data.n) bVar;
                if (nVar.bcB != null) {
                    if ((view.getTag() instanceof String) && nVar.JB() != null && nVar.JB().getId() != null && !am.bd(com.baidu.adp.lib.g.b.c(nVar.JB().getTid(), 0L))) {
                        am.bc(com.baidu.adp.lib.g.b.c(nVar.JB().getTid(), 0L));
                        fVar2 = this.cvx.cvu;
                        fVar2.a(com.baidu.adp.lib.g.b.c(nVar.JB().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Tq(), nVar.Ts(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    if (view instanceof TbImageView) {
                        TiebaStatic.log(new as("c11004").aa("tid", nVar.bcB.getTid()));
                        return;
                    }
                    int id = view.getId();
                    aiVar2 = this.cvx.cvw;
                    if (id == aiVar2.getView().getId()) {
                        if (nVar.bcB.sC() != null && nVar.bcB.sC().channelId > 0) {
                            nVar.A("c11929", true);
                        }
                        TiebaStatic.log(new as("c11004").aa("tid", nVar.bcB.getTid()));
                        TiebaStatic.log(new as("c10806").s("obj_locate", 1).aa("tid", nVar.bcB.getId()));
                        return;
                    }
                    TiebaStatic.log(new as("c11004").aa("tid", nVar.bcB.getTid()));
                }
            }
        }
    }
}
