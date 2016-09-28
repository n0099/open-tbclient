package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.homepage.personalize.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends cd<com.baidu.tieba.card.data.o> {
    final /* synthetic */ q cGH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cGH = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
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
        cb.Oj().cr(true);
        fVar = this.cGH.cGy;
        if (fVar != null && oVar != null && oVar.Jv() != null && !StringUtils.isNull(oVar.Jv().getTid())) {
            rVar = this.cGH.cGG;
            if (rVar != null) {
                rVar2 = this.cGH.cGG;
                if (rVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !ak.bI(com.baidu.adp.lib.h.b.c(oVar.Jv().getTid(), 0L))) {
                        ak.bH(com.baidu.adp.lib.h.b.c(oVar.Jv().getTid(), 0L));
                        fVar2 = this.cGH.cGy;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.Jv().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.Ok(), oVar.Om(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    rVar3 = this.cGH.cGG;
                    if (id != rVar3.getView().getId()) {
                        rVar4 = this.cGH.cGG;
                        if (rVar4.aZx != null) {
                            rVar12 = this.cGH.cGG;
                            if (rVar12.aZx.getBarNameTv() != null) {
                                int id2 = view.getId();
                                rVar13 = this.cGH.cGG;
                                if (id2 == rVar13.aZx.getBarNameTv().getId()) {
                                    TiebaStatic.log(oVar.OC());
                                    return;
                                }
                            }
                        }
                        rVar5 = this.cGH.cGG;
                        if (rVar5.aZw != null) {
                            int id3 = view.getId();
                            rVar11 = this.cGH.cGG;
                            if (id3 == rVar11.aZw.getId()) {
                                TiebaStatic.log(oVar.OD());
                                return;
                            }
                        }
                        rVar6 = this.cGH.cGG;
                        if (rVar6.aZz != null) {
                            rVar9 = this.cGH.cGG;
                            if (rVar9.aZz.ahv != null) {
                                int id4 = view.getId();
                                rVar10 = this.cGH.cGG;
                                if (id4 == rVar10.aZz.ahv.getId()) {
                                    TiebaStatic.log(oVar.OD());
                                    return;
                                }
                            }
                        }
                        rVar7 = this.cGH.cGG;
                        if (rVar7.aZy != null) {
                            int id5 = view.getId();
                            rVar8 = this.cGH.cGG;
                            if (id5 == rVar8.aZy.getId()) {
                                TiebaStatic.log(oVar.OL());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(oVar.OB());
                }
            }
        }
    }
}
