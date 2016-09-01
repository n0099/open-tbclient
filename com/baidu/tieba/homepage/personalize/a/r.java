package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends cf<com.baidu.tieba.card.data.o> {
    final /* synthetic */ q cFT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cFT = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.o oVar) {
        com.baidu.tieba.homepage.personalize.b.f fVar;
        com.baidu.tieba.card.t tVar;
        com.baidu.tieba.card.t tVar2;
        com.baidu.tieba.card.t tVar3;
        com.baidu.tieba.card.t tVar4;
        com.baidu.tieba.card.t tVar5;
        com.baidu.tieba.card.t tVar6;
        com.baidu.tieba.card.t tVar7;
        com.baidu.tieba.card.t tVar8;
        com.baidu.tieba.card.t tVar9;
        com.baidu.tieba.card.t tVar10;
        com.baidu.tieba.card.t tVar11;
        com.baidu.tieba.card.t tVar12;
        com.baidu.tieba.card.t tVar13;
        com.baidu.tieba.homepage.personalize.b.f fVar2;
        cd.NI().cr(true);
        fVar = this.cFT.cFK;
        if (fVar != null && oVar != null && oVar.Kw() != null && !StringUtils.isNull(oVar.Kw().getTid())) {
            tVar = this.cFT.cFS;
            if (tVar != null) {
                tVar2 = this.cFT.cFS;
                if (tVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.y.bI(com.baidu.adp.lib.h.b.c(oVar.Kw().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.y.bH(com.baidu.adp.lib.h.b.c(oVar.Kw().getTid(), 0L));
                        fVar2 = this.cFT.cFK;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.Kw().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.NJ(), oVar.NL(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    tVar3 = this.cFT.cFS;
                    if (id != tVar3.getView().getId()) {
                        tVar4 = this.cFT.cFS;
                        if (tVar4.aZd != null) {
                            tVar12 = this.cFT.cFS;
                            if (tVar12.aZd.getBarNameTv() != null) {
                                int id2 = view.getId();
                                tVar13 = this.cFT.cFS;
                                if (id2 == tVar13.aZd.getBarNameTv().getId()) {
                                    TiebaStatic.log(oVar.Oa());
                                    return;
                                }
                            }
                        }
                        tVar5 = this.cFT.cFS;
                        if (tVar5.aZc != null) {
                            int id3 = view.getId();
                            tVar11 = this.cFT.cFS;
                            if (id3 == tVar11.aZc.getId()) {
                                TiebaStatic.log(oVar.Ob());
                                return;
                            }
                        }
                        tVar6 = this.cFT.cFS;
                        if (tVar6.aZf != null) {
                            tVar9 = this.cFT.cFS;
                            if (tVar9.aZf.ahN != null) {
                                int id4 = view.getId();
                                tVar10 = this.cFT.cFS;
                                if (id4 == tVar10.aZf.ahN.getId()) {
                                    TiebaStatic.log(oVar.Ob());
                                    return;
                                }
                            }
                        }
                        tVar7 = this.cFT.cFS;
                        if (tVar7.aZe != null) {
                            int id5 = view.getId();
                            tVar8 = this.cFT.cFS;
                            if (id5 == tVar8.aZe.getId()) {
                                TiebaStatic.log(oVar.Oj());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(oVar.NZ());
                }
            }
        }
    }
}
