package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.homepage.personalize.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends cd<com.baidu.tieba.card.data.n> {
    final /* synthetic */ s cvF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.cvF = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, com.baidu.tieba.card.data.n nVar) {
        com.baidu.tieba.homepage.personalize.model.f fVar;
        com.baidu.tieba.card.u uVar;
        com.baidu.tieba.card.u uVar2;
        com.baidu.tieba.card.u uVar3;
        com.baidu.tieba.card.u uVar4;
        com.baidu.tieba.card.u uVar5;
        com.baidu.tieba.card.u uVar6;
        com.baidu.tieba.card.u uVar7;
        com.baidu.tieba.card.u uVar8;
        com.baidu.tieba.card.u uVar9;
        com.baidu.tieba.card.u uVar10;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        ca.To().db(true);
        fVar = this.cvF.cvz;
        if (fVar != null && nVar != null && nVar.JB() != null && !StringUtils.isNull(nVar.JB().getTid())) {
            uVar = this.cvF.cvE;
            if (uVar != null) {
                uVar2 = this.cvF.cvE;
                if (uVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !am.bd(com.baidu.adp.lib.g.b.c(nVar.JB().getTid(), 0L))) {
                        am.bc(com.baidu.adp.lib.g.b.c(nVar.JB().getTid(), 0L));
                        fVar2 = this.cvF.cvz;
                        fVar2.a(com.baidu.adp.lib.g.b.c(nVar.JB().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Tq(), nVar.Ts(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    uVar3 = this.cvF.cvE;
                    if (id != uVar3.getView().getId()) {
                        uVar4 = this.cvF.cvE;
                        if (uVar4.bcq != null) {
                            uVar9 = this.cvF.cvE;
                            if (uVar9.bcq.getBarNameTv() != null) {
                                int id2 = view.getId();
                                uVar10 = this.cvF.cvE;
                                if (id2 == uVar10.bcq.getBarNameTv().getId()) {
                                    TiebaStatic.log(nVar.TI());
                                    return;
                                }
                            }
                        }
                        uVar5 = this.cvF.cvE;
                        if (uVar5.getHeaderImg() != null) {
                            int id3 = view.getId();
                            uVar8 = this.cvF.cvE;
                            if (id3 == uVar8.getHeaderImg().getId()) {
                                TiebaStatic.log(nVar.u(nVar.bcB));
                                return;
                            }
                        }
                        uVar6 = this.cvF.cvE;
                        if (uVar6.Tg() != null) {
                            int id4 = view.getId();
                            uVar7 = this.cvF.cvE;
                            if (id4 == uVar7.Tg().getId()) {
                                TiebaStatic.log(nVar.u(nVar.bcB));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(nVar.t(nVar.bcB));
                }
            }
        }
    }
}
