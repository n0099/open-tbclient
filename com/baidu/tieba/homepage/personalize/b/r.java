package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends bz<com.baidu.tieba.card.data.o> {
    final /* synthetic */ q cLS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cLS = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, com.baidu.tieba.card.data.o oVar) {
        com.baidu.tieba.homepage.personalize.c.f fVar;
        com.baidu.tieba.card.r rVar;
        com.baidu.tieba.card.r rVar2;
        com.baidu.tieba.card.r rVar3;
        com.baidu.tieba.card.r rVar4;
        com.baidu.tieba.card.r rVar5;
        com.baidu.tieba.card.r rVar6;
        com.baidu.tieba.card.r rVar7;
        com.baidu.tieba.card.r rVar8;
        com.baidu.tieba.card.r rVar9;
        com.baidu.tieba.card.r rVar10;
        com.baidu.tieba.card.r rVar11;
        com.baidu.tieba.card.r rVar12;
        com.baidu.tieba.card.r rVar13;
        com.baidu.tieba.homepage.personalize.c.f fVar2;
        bx.Pl().cw(true);
        fVar = this.cLS.cLJ;
        if (fVar != null && oVar != null && oVar.Jz() != null && !StringUtils.isNull(oVar.Jz().getTid())) {
            rVar = this.cLS.cLR;
            if (rVar != null) {
                rVar2 = this.cLS.cLR;
                if (rVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !ai.bH(com.baidu.adp.lib.h.b.c(oVar.Jz().getTid(), 0L))) {
                        ai.bG(com.baidu.adp.lib.h.b.c(oVar.Jz().getTid(), 0L));
                        fVar2 = this.cLS.cLJ;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.Jz().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.Pn(), oVar.Pp(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    rVar3 = this.cLS.cLR;
                    if (id != rVar3.getView().getId()) {
                        rVar4 = this.cLS.cLR;
                        if (rVar4.bcG != null) {
                            rVar12 = this.cLS.cLR;
                            if (rVar12.bcG.getBarNameTv() != null) {
                                int id2 = view.getId();
                                rVar13 = this.cLS.cLR;
                                if (id2 == rVar13.bcG.getBarNameTv().getId()) {
                                    TiebaStatic.log(oVar.PF());
                                    return;
                                }
                            }
                        }
                        rVar5 = this.cLS.cLR;
                        if (rVar5.bcF != null) {
                            int id3 = view.getId();
                            rVar11 = this.cLS.cLR;
                            if (id3 == rVar11.bcF.getId()) {
                                TiebaStatic.log(oVar.PG());
                                return;
                            }
                        }
                        rVar6 = this.cLS.cLR;
                        if (rVar6.bcJ != null) {
                            rVar9 = this.cLS.cLR;
                            if (rVar9.bcJ.ahV != null) {
                                int id4 = view.getId();
                                rVar10 = this.cLS.cLR;
                                if (id4 == rVar10.bcJ.ahV.getId()) {
                                    TiebaStatic.log(oVar.PG());
                                    return;
                                }
                            }
                        }
                        rVar7 = this.cLS.cLR;
                        if (rVar7.bcI != null) {
                            int id5 = view.getId();
                            rVar8 = this.cLS.cLR;
                            if (id5 == rVar8.bcI.getId()) {
                                TiebaStatic.log(oVar.PO());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(oVar.PE());
                }
            }
        }
    }
}
