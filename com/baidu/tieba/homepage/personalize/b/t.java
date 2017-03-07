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
    final /* synthetic */ s czE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.czE = sVar;
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
        cc.Sv().cM(true);
        fVar = this.czE.czy;
        if (fVar != null && pVar != null && pVar.JN() != null && !StringUtils.isNull(pVar.JN().getTid())) {
            xVar = this.czE.czD;
            if (xVar != null) {
                xVar2 = this.czE.czD;
                if (xVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !ai.bq(com.baidu.adp.lib.g.b.c(pVar.JN().getTid(), 0L))) {
                        ai.bp(com.baidu.adp.lib.g.b.c(pVar.JN().getTid(), 0L));
                        fVar2 = this.czE.czy;
                        fVar2.a(com.baidu.adp.lib.g.b.c(pVar.JN().getTid(), 0L), pVar.getWeight(), pVar.getSource(), pVar.Sx(), pVar.Sz(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    xVar3 = this.czE.czD;
                    if (id != xVar3.getView().getId()) {
                        xVar4 = this.czE.czD;
                        if (xVar4.bbj != null) {
                            xVar10 = this.czE.czD;
                            if (xVar10.bbj.getBarNameTv() != null) {
                                int id2 = view.getId();
                                xVar11 = this.czE.czD;
                                if (id2 == xVar11.bbj.getBarNameTv().getId()) {
                                    TiebaStatic.log(pVar.SP());
                                    return;
                                }
                            }
                        }
                        xVar5 = this.czE.czD;
                        if (xVar5.bbg != null) {
                            int id3 = view.getId();
                            xVar9 = this.czE.czD;
                            if (id3 == xVar9.bbg.getId()) {
                                TiebaStatic.log(pVar.p(pVar.bbv));
                                return;
                            }
                        }
                        xVar6 = this.czE.czD;
                        if (xVar6.bbk != null) {
                            xVar7 = this.czE.czD;
                            if (xVar7.bbk.amc != null) {
                                int id4 = view.getId();
                                xVar8 = this.czE.czD;
                                if (id4 == xVar8.bbk.amc.getId()) {
                                    TiebaStatic.log(pVar.p(pVar.bbv));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(pVar.o(pVar.bbv));
                }
            }
        }
    }
}
