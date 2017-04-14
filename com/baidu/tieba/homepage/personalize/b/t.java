package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.personalize.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends cf<com.baidu.tieba.card.data.p> {
    final /* synthetic */ s cye;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cye = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.p pVar) {
        com.baidu.tieba.homepage.personalize.model.f fVar;
        com.baidu.tieba.card.x xVar;
        com.baidu.tieba.card.x xVar2;
        com.baidu.tieba.card.x xVar3;
        com.baidu.tieba.card.x xVar4;
        com.baidu.tieba.card.x xVar5;
        com.baidu.tieba.card.x xVar6;
        com.baidu.tieba.card.x xVar7;
        com.baidu.tieba.card.x xVar8;
        com.baidu.tieba.card.x xVar9;
        com.baidu.tieba.card.x xVar10;
        com.baidu.tieba.card.x xVar11;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cc.ST().cO(true);
        fVar = this.cye.cxY;
        if (fVar != null && pVar != null && pVar.Kn() != null && !StringUtils.isNull(pVar.Kn().getTid())) {
            xVar = this.cye.cyd;
            if (xVar != null) {
                xVar2 = this.cye.cyd;
                if (xVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !aj.bq(com.baidu.adp.lib.g.b.c(pVar.Kn().getTid(), 0L))) {
                        aj.bp(com.baidu.adp.lib.g.b.c(pVar.Kn().getTid(), 0L));
                        fVar2 = this.cye.cxY;
                        fVar2.a(com.baidu.adp.lib.g.b.c(pVar.Kn().getTid(), 0L), pVar.getWeight(), pVar.getSource(), pVar.SV(), pVar.SX(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    xVar3 = this.cye.cyd;
                    if (id != xVar3.getView().getId()) {
                        xVar4 = this.cye.cyd;
                        if (xVar4.bbc != null) {
                            xVar10 = this.cye.cyd;
                            if (xVar10.bbc.getBarNameTv() != null) {
                                int id2 = view.getId();
                                xVar11 = this.cye.cyd;
                                if (id2 == xVar11.bbc.getBarNameTv().getId()) {
                                    TiebaStatic.log(pVar.Tn());
                                    return;
                                }
                            }
                        }
                        xVar5 = this.cye.cyd;
                        if (xVar5.baZ != null) {
                            int id3 = view.getId();
                            xVar9 = this.cye.cyd;
                            if (id3 == xVar9.baZ.getId()) {
                                TiebaStatic.log(pVar.p(pVar.bbo));
                                return;
                            }
                        }
                        xVar6 = this.cye.cyd;
                        if (xVar6.bbd != null) {
                            xVar7 = this.cye.cyd;
                            if (xVar7.bbd.amq != null) {
                                int id4 = view.getId();
                                xVar8 = this.cye.cyd;
                                if (id4 == xVar8.bbd.amq.getId()) {
                                    TiebaStatic.log(pVar.p(pVar.bbo));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(pVar.o(pVar.bbo));
                }
            }
        }
    }
}
