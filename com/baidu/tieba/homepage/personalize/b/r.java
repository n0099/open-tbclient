package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends cb<com.baidu.tieba.card.data.o> {
    final /* synthetic */ q cre;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cre = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
    public void a(View view, com.baidu.tieba.card.data.o oVar) {
        com.baidu.tieba.homepage.personalize.c.f fVar;
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
        com.baidu.tieba.homepage.personalize.c.f fVar2;
        bz.OH().cy(true);
        fVar = this.cre.cqX;
        if (fVar != null && oVar != null && oVar.IU() != null && !StringUtils.isNull(oVar.IU().getTid())) {
            tVar = this.cre.crd;
            if (tVar != null) {
                tVar2 = this.cre.crd;
                if (tVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !ai.bv(com.baidu.adp.lib.h.b.c(oVar.IU().getTid(), 0L))) {
                        ai.bu(com.baidu.adp.lib.h.b.c(oVar.IU().getTid(), 0L));
                        fVar2 = this.cre.cqX;
                        fVar2.a(com.baidu.adp.lib.h.b.c(oVar.IU().getTid(), 0L), oVar.getWeight(), oVar.getSource(), oVar.OJ(), oVar.OL(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    tVar3 = this.cre.crd;
                    if (id != tVar3.getView().getId()) {
                        tVar4 = this.cre.crd;
                        if (tVar4.bbZ != null) {
                            tVar12 = this.cre.crd;
                            if (tVar12.bbZ.getBarNameTv() != null) {
                                int id2 = view.getId();
                                tVar13 = this.cre.crd;
                                if (id2 == tVar13.bbZ.getBarNameTv().getId()) {
                                    TiebaStatic.log(oVar.Pb());
                                    return;
                                }
                            }
                        }
                        tVar5 = this.cre.crd;
                        if (tVar5.bbY != null) {
                            int id3 = view.getId();
                            tVar11 = this.cre.crd;
                            if (id3 == tVar11.bbY.getId()) {
                                TiebaStatic.log(oVar.Pc());
                                return;
                            }
                        }
                        tVar6 = this.cre.crd;
                        if (tVar6.bcc != null) {
                            tVar9 = this.cre.crd;
                            if (tVar9.bcc.ahw != null) {
                                int id4 = view.getId();
                                tVar10 = this.cre.crd;
                                if (id4 == tVar10.bcc.ahw.getId()) {
                                    TiebaStatic.log(oVar.Pc());
                                    return;
                                }
                            }
                        }
                        tVar7 = this.cre.crd;
                        if (tVar7.bcb != null) {
                            int id5 = view.getId();
                            tVar8 = this.cre.crd;
                            if (id5 == tVar8.bcb.getId()) {
                                TiebaStatic.log(oVar.Pk());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(oVar.Pa());
                }
            }
        }
    }
}
