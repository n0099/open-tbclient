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
    final /* synthetic */ s cAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cAv = sVar;
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
        cc.TV().cY(true);
        fVar = this.cAv.cAp;
        if (fVar != null && pVar != null && pVar.Kn() != null && !StringUtils.isNull(pVar.Kn().getTid())) {
            xVar = this.cAv.cAu;
            if (xVar != null) {
                xVar2 = this.cAv.cAu;
                if (xVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !aj.bq(com.baidu.adp.lib.g.b.c(pVar.Kn().getTid(), 0L))) {
                        aj.bp(com.baidu.adp.lib.g.b.c(pVar.Kn().getTid(), 0L));
                        fVar2 = this.cAv.cAp;
                        fVar2.a(com.baidu.adp.lib.g.b.c(pVar.Kn().getTid(), 0L), pVar.getWeight(), pVar.getSource(), pVar.TX(), pVar.TZ(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    xVar3 = this.cAv.cAu;
                    if (id != xVar3.getView().getId()) {
                        xVar4 = this.cAv.cAu;
                        if (xVar4.bbY != null) {
                            xVar10 = this.cAv.cAu;
                            if (xVar10.bbY.getBarNameTv() != null) {
                                int id2 = view.getId();
                                xVar11 = this.cAv.cAu;
                                if (id2 == xVar11.bbY.getBarNameTv().getId()) {
                                    TiebaStatic.log(pVar.Up());
                                    return;
                                }
                            }
                        }
                        xVar5 = this.cAv.cAu;
                        if (xVar5.bbV != null) {
                            int id3 = view.getId();
                            xVar9 = this.cAv.cAu;
                            if (id3 == xVar9.bbV.getId()) {
                                TiebaStatic.log(pVar.p(pVar.bck));
                                return;
                            }
                        }
                        xVar6 = this.cAv.cAu;
                        if (xVar6.bbZ != null) {
                            xVar7 = this.cAv.cAu;
                            if (xVar7.bbZ.amq != null) {
                                int id4 = view.getId();
                                xVar8 = this.cAv.cAu;
                                if (id4 == xVar8.bbZ.amq.getId()) {
                                    TiebaStatic.log(pVar.p(pVar.bck));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(pVar.o(pVar.bck));
                }
            }
        }
    }
}
