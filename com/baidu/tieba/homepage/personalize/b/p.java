package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cf<com.baidu.tieba.card.data.n> {
    final /* synthetic */ m cyd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.cyd = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.n nVar) {
        au auVar;
        au auVar2;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        au auVar3;
        au auVar4;
        au auVar5;
        au auVar6;
        au auVar7;
        au auVar8;
        au auVar9;
        au auVar10;
        au auVar11;
        au auVar12;
        au auVar13;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cc.Rx().cM(true);
        if (view != null) {
            auVar = this.cyd.cyb;
            if (auVar != null) {
                auVar2 = this.cyd.cyb;
                if (auVar2.getView() != null) {
                    fVar = this.cyd.cyc;
                    if (fVar != null && nVar != null && nVar.Ji() != null && !StringUtils.isNull(nVar.Ji().getTid())) {
                        if ((view.getTag() instanceof String) && !ai.bq(com.baidu.adp.lib.g.b.c(nVar.Ji().getTid(), 0L))) {
                            ai.bp(com.baidu.adp.lib.g.b.c(nVar.Ji().getTid(), 0L));
                            fVar2 = this.cyd.cyc;
                            fVar2.a(com.baidu.adp.lib.g.b.c(nVar.Ji().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Rz(), nVar.RB(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        auVar3 = this.cyd.cyb;
                        if (id != auVar3.getView().getId()) {
                            auVar4 = this.cyd.cyb;
                            if (auVar4.bmz != null) {
                                int id2 = view.getId();
                                auVar13 = this.cyd.cyb;
                                if (id2 == auVar13.bmz.getId()) {
                                    TiebaStatic.log(nVar.RU());
                                    return;
                                }
                            }
                            auVar5 = this.cyd.cyb;
                            if (auVar5.bmy != null) {
                                int id3 = view.getId();
                                auVar12 = this.cyd.cyb;
                                if (id3 == auVar12.bmy.getId()) {
                                    TiebaStatic.log(nVar.RS());
                                    return;
                                }
                            }
                            auVar6 = this.cyd.cyb;
                            if (auVar6.bmB != null) {
                                auVar10 = this.cyd.cyb;
                                if (auVar10.bmB.agJ != null) {
                                    int id4 = view.getId();
                                    auVar11 = this.cyd.cyb;
                                    if (id4 == auVar11.bmB.agJ.getId()) {
                                        TiebaStatic.log(nVar.RS());
                                        return;
                                    }
                                }
                            }
                            auVar7 = this.cyd.cyb;
                            if (auVar7.bkU != null) {
                                auVar8 = this.cyd.cyb;
                                if (auVar8.bkU.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    auVar9 = this.cyd.cyb;
                                    if (id5 == auVar9.bkU.getBarNameTv().getId()) {
                                        TiebaStatic.log(nVar.RR());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(nVar.RT());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(nVar.RQ());
                    }
                }
            }
        }
    }
}
