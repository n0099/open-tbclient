package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends bx<com.baidu.tieba.card.a.o> {
    final /* synthetic */ r cup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.cup = rVar;
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
        bw.Lf().cl(true);
        fVar = this.cup.cug;
        if (fVar != null && oVar != null && oVar.Iw() != null && !StringUtils.isNull(oVar.Iw().getTid())) {
            zVar = this.cup.cuo;
            if (zVar != null) {
                zVar2 = this.cup.cuo;
                if (zVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.y.bm(com.baidu.adp.lib.h.b.c(oVar.Iw().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.y.bl(com.baidu.adp.lib.h.b.c(oVar.Iw().getTid(), 0L));
                        fVar2 = this.cup.cug;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.Iw().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.Lg(), oVar.Li(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    zVar3 = this.cup.cuo;
                    if (id != zVar3.getView().getId()) {
                        zVar4 = this.cup.cuo;
                        if (zVar4.aTV != null) {
                            zVar12 = this.cup.cuo;
                            if (zVar12.aTV.getBarNameTv() != null) {
                                int id2 = view.getId();
                                zVar13 = this.cup.cuo;
                                if (id2 == zVar13.aTV.getBarNameTv().getId()) {
                                    TiebaStatic.log(oVar.Lw());
                                    return;
                                }
                            }
                        }
                        zVar5 = this.cup.cuo;
                        if (zVar5.aTU != null) {
                            int id3 = view.getId();
                            zVar11 = this.cup.cuo;
                            if (id3 == zVar11.aTU.getId()) {
                                TiebaStatic.log(oVar.Lx());
                                return;
                            }
                        }
                        zVar6 = this.cup.cuo;
                        if (zVar6.aTX != null) {
                            zVar9 = this.cup.cuo;
                            if (zVar9.aTX.aeS != null) {
                                int id4 = view.getId();
                                zVar10 = this.cup.cuo;
                                if (id4 == zVar10.aTX.aeS.getId()) {
                                    TiebaStatic.log(oVar.Lx());
                                    return;
                                }
                            }
                        }
                        zVar7 = this.cup.cuo;
                        if (zVar7.aTW != null) {
                            int id5 = view.getId();
                            zVar8 = this.cup.cuo;
                            if (id5 == zVar8.aTW.getId()) {
                                TiebaStatic.log(oVar.LF());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(oVar.Lv());
                }
            }
        }
    }
}
