package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aq;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.homepage.personalize.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cd<com.baidu.tieba.card.data.l> {
    final /* synthetic */ m cvA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.cvA = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        aq aqVar;
        aq aqVar2;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        aq aqVar3;
        aq aqVar4;
        aq aqVar5;
        aq aqVar6;
        aq aqVar7;
        aq aqVar8;
        aq aqVar9;
        aq aqVar10;
        aq aqVar11;
        aq aqVar12;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        ca.To().db(true);
        if (view != null) {
            aqVar = this.cvA.cvy;
            if (aqVar != null) {
                aqVar2 = this.cvA.cvy;
                if (aqVar2.getView() != null) {
                    fVar = this.cvA.cvz;
                    if (fVar != null && lVar != null && lVar.JB() != null && !StringUtils.isNull(lVar.JB().getTid())) {
                        if ((view.getTag() instanceof String) && !am.bd(com.baidu.adp.lib.g.b.c(lVar.JB().getTid(), 0L))) {
                            am.bc(com.baidu.adp.lib.g.b.c(lVar.JB().getTid(), 0L));
                            fVar2 = this.cvA.cvz;
                            fVar2.a(com.baidu.adp.lib.g.b.c(lVar.JB().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.Tq(), lVar.Ts(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        aqVar3 = this.cvA.cvy;
                        if (id != aqVar3.getView().getId()) {
                            aqVar4 = this.cvA.cvy;
                            if (aqVar4.bvC != null) {
                                int id2 = view.getId();
                                aqVar12 = this.cvA.cvy;
                                if (id2 == aqVar12.bvC.getId()) {
                                    TiebaStatic.log(lVar.TL());
                                    return;
                                }
                            }
                            aqVar5 = this.cvA.cvy;
                            if (aqVar5.getHeaderImg() != null) {
                                int id3 = view.getId();
                                aqVar11 = this.cvA.cvy;
                                if (id3 == aqVar11.getHeaderImg().getId()) {
                                    TiebaStatic.log(lVar.TJ());
                                    return;
                                }
                            }
                            aqVar6 = this.cvA.cvy;
                            if (aqVar6.Tg() != null) {
                                int id4 = view.getId();
                                aqVar10 = this.cvA.cvy;
                                if (id4 == aqVar10.Tg().getId()) {
                                    TiebaStatic.log(lVar.TJ());
                                    return;
                                }
                            }
                            aqVar7 = this.cvA.cvy;
                            if (aqVar7.bcq != null) {
                                aqVar8 = this.cvA.cvy;
                                if (aqVar8.bcq.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    aqVar9 = this.cvA.cvy;
                                    if (id5 == aqVar9.bcq.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.TI());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(lVar.TK());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(lVar.TH());
                    }
                }
            }
        }
    }
}
