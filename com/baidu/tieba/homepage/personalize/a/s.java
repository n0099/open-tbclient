package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements bx<com.baidu.tieba.card.a.o> {
    final /* synthetic */ r crF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.crF = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, com.baidu.tieba.card.a.o oVar) {
        com.baidu.tieba.homepage.personalize.b.f fVar;
        com.baidu.tieba.card.z zVar;
        com.baidu.tieba.card.z zVar2;
        com.baidu.tieba.card.z zVar3;
        com.baidu.tieba.card.z zVar4;
        com.baidu.tieba.card.z zVar5;
        com.baidu.tieba.card.z zVar6;
        com.baidu.tieba.card.z zVar7;
        com.baidu.tieba.card.z zVar8;
        com.baidu.tieba.card.z zVar9;
        com.baidu.tieba.card.z zVar10;
        com.baidu.tieba.card.z zVar11;
        com.baidu.tieba.card.z zVar12;
        com.baidu.tieba.card.z zVar13;
        com.baidu.tieba.homepage.personalize.b.f fVar2;
        bw.Lg().cj(true);
        fVar = this.crF.crw;
        if (fVar != null && oVar != null && oVar.Ix() != null && !StringUtils.isNull(oVar.Ix().getTid())) {
            zVar = this.crF.crE;
            if (zVar != null) {
                zVar2 = this.crF.crE;
                if (zVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.r.br(com.baidu.adp.lib.h.b.c(oVar.Ix().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.r.bq(com.baidu.adp.lib.h.b.c(oVar.Ix().getTid(), 0L));
                        fVar2 = this.crF.crw;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.Ix().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.Lh(), oVar.Lj(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    zVar3 = this.crF.crE;
                    if (id != zVar3.getView().getId()) {
                        zVar4 = this.crF.crE;
                        if (zVar4.aSZ != null) {
                            zVar12 = this.crF.crE;
                            if (zVar12.aSZ.getBarNameTv() != null) {
                                int id2 = view.getId();
                                zVar13 = this.crF.crE;
                                if (id2 == zVar13.aSZ.getBarNameTv().getId()) {
                                    TiebaStatic.log(oVar.Lx());
                                    return;
                                }
                            }
                        }
                        zVar5 = this.crF.crE;
                        if (zVar5.aSY != null) {
                            int id3 = view.getId();
                            zVar11 = this.crF.crE;
                            if (id3 == zVar11.aSY.getId()) {
                                TiebaStatic.log(oVar.Ly());
                                return;
                            }
                        }
                        zVar6 = this.crF.crE;
                        if (zVar6.aTb != null) {
                            zVar9 = this.crF.crE;
                            if (zVar9.aTb.aee != null) {
                                int id4 = view.getId();
                                zVar10 = this.crF.crE;
                                if (id4 == zVar10.aTb.aee.getId()) {
                                    TiebaStatic.log(oVar.Ly());
                                    return;
                                }
                            }
                        }
                        zVar7 = this.crF.crE;
                        if (zVar7.aTa != null) {
                            int id5 = view.getId();
                            zVar8 = this.crF.crE;
                            if (id5 == zVar8.aTa.getId()) {
                                TiebaStatic.log(oVar.LG());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(oVar.Lw());
                }
            }
        }
    }
}
