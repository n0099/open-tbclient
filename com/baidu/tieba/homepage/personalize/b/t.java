package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends cf<com.baidu.tieba.card.data.p> {
    final /* synthetic */ s cyi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cyi = sVar;
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
        cc.Rx().cM(true);
        fVar = this.cyi.cyc;
        if (fVar != null && pVar != null && pVar.Ji() != null && !StringUtils.isNull(pVar.Ji().getTid())) {
            xVar = this.cyi.cyh;
            if (xVar != null) {
                xVar2 = this.cyi.cyh;
                if (xVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !ai.bq(com.baidu.adp.lib.g.b.c(pVar.Ji().getTid(), 0L))) {
                        ai.bp(com.baidu.adp.lib.g.b.c(pVar.Ji().getTid(), 0L));
                        fVar2 = this.cyi.cyc;
                        fVar2.a(com.baidu.adp.lib.g.b.c(pVar.Ji().getTid(), 0L), pVar.getWeight(), pVar.getSource(), pVar.Rz(), pVar.RB(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    xVar3 = this.cyi.cyh;
                    if (id != xVar3.getView().getId()) {
                        xVar4 = this.cyi.cyh;
                        if (xVar4.aUW != null) {
                            xVar10 = this.cyi.cyh;
                            if (xVar10.aUW.getBarNameTv() != null) {
                                int id2 = view.getId();
                                xVar11 = this.cyi.cyh;
                                if (id2 == xVar11.aUW.getBarNameTv().getId()) {
                                    TiebaStatic.log(pVar.RR());
                                    return;
                                }
                            }
                        }
                        xVar5 = this.cyi.cyh;
                        if (xVar5.aUT != null) {
                            int id3 = view.getId();
                            xVar9 = this.cyi.cyh;
                            if (id3 == xVar9.aUT.getId()) {
                                TiebaStatic.log(pVar.p(pVar.aVi));
                                return;
                            }
                        }
                        xVar6 = this.cyi.cyh;
                        if (xVar6.aUX != null) {
                            xVar7 = this.cyi.cyh;
                            if (xVar7.aUX.agJ != null) {
                                int id4 = view.getId();
                                xVar8 = this.cyi.cyh;
                                if (id4 == xVar8.aUX.agJ.getId()) {
                                    TiebaStatic.log(pVar.p(pVar.aVi));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(pVar.o(pVar.aVi));
                }
            }
        }
    }
}
