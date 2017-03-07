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
    final /* synthetic */ m czz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.czz = mVar;
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
        cc.Sv().cM(true);
        if (view != null) {
            auVar = this.czz.czx;
            if (auVar != null) {
                auVar2 = this.czz.czx;
                if (auVar2.getView() != null) {
                    fVar = this.czz.czy;
                    if (fVar != null && nVar != null && nVar.JN() != null && !StringUtils.isNull(nVar.JN().getTid())) {
                        if ((view.getTag() instanceof String) && !ai.bq(com.baidu.adp.lib.g.b.c(nVar.JN().getTid(), 0L))) {
                            ai.bp(com.baidu.adp.lib.g.b.c(nVar.JN().getTid(), 0L));
                            fVar2 = this.czz.czy;
                            fVar2.a(com.baidu.adp.lib.g.b.c(nVar.JN().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Sx(), nVar.Sz(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        auVar3 = this.czz.czx;
                        if (id != auVar3.getView().getId()) {
                            auVar4 = this.czz.czx;
                            if (auVar4.btu != null) {
                                int id2 = view.getId();
                                auVar13 = this.czz.czx;
                                if (id2 == auVar13.btu.getId()) {
                                    TiebaStatic.log(nVar.SS());
                                    return;
                                }
                            }
                            auVar5 = this.czz.czx;
                            if (auVar5.btt != null) {
                                int id3 = view.getId();
                                auVar12 = this.czz.czx;
                                if (id3 == auVar12.btt.getId()) {
                                    TiebaStatic.log(nVar.SQ());
                                    return;
                                }
                            }
                            auVar6 = this.czz.czx;
                            if (auVar6.btw != null) {
                                auVar10 = this.czz.czx;
                                if (auVar10.btw.amc != null) {
                                    int id4 = view.getId();
                                    auVar11 = this.czz.czx;
                                    if (id4 == auVar11.btw.amc.getId()) {
                                        TiebaStatic.log(nVar.SQ());
                                        return;
                                    }
                                }
                            }
                            auVar7 = this.czz.czx;
                            if (auVar7.brM != null) {
                                auVar8 = this.czz.czx;
                                if (auVar8.brM.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    auVar9 = this.czz.czx;
                                    if (id5 == auVar9.brM.getBarNameTv().getId()) {
                                        TiebaStatic.log(nVar.SP());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(nVar.SR());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(nVar.SO());
                    }
                }
            }
        }
    }
}
