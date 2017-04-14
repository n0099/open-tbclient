package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.homepage.personalize.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cf<com.baidu.tieba.card.data.n> {
    final /* synthetic */ m cxZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.cxZ = mVar;
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
        cc.ST().cO(true);
        if (view != null) {
            auVar = this.cxZ.cxX;
            if (auVar != null) {
                auVar2 = this.cxZ.cxX;
                if (auVar2.getView() != null) {
                    fVar = this.cxZ.cxY;
                    if (fVar != null && nVar != null && nVar.Kn() != null && !StringUtils.isNull(nVar.Kn().getTid())) {
                        if ((view.getTag() instanceof String) && !aj.bq(com.baidu.adp.lib.g.b.c(nVar.Kn().getTid(), 0L))) {
                            aj.bp(com.baidu.adp.lib.g.b.c(nVar.Kn().getTid(), 0L));
                            fVar2 = this.cxZ.cxY;
                            fVar2.a(com.baidu.adp.lib.g.b.c(nVar.Kn().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.SV(), nVar.SX(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        auVar3 = this.cxZ.cxX;
                        if (id != auVar3.getView().getId()) {
                            auVar4 = this.cxZ.cxX;
                            if (auVar4.btl != null) {
                                int id2 = view.getId();
                                auVar13 = this.cxZ.cxX;
                                if (id2 == auVar13.btl.getId()) {
                                    TiebaStatic.log(nVar.Tq());
                                    return;
                                }
                            }
                            auVar5 = this.cxZ.cxX;
                            if (auVar5.btk != null) {
                                int id3 = view.getId();
                                auVar12 = this.cxZ.cxX;
                                if (id3 == auVar12.btk.getId()) {
                                    TiebaStatic.log(nVar.To());
                                    return;
                                }
                            }
                            auVar6 = this.cxZ.cxX;
                            if (auVar6.bto != null) {
                                auVar10 = this.cxZ.cxX;
                                if (auVar10.bto.amq != null) {
                                    int id4 = view.getId();
                                    auVar11 = this.cxZ.cxX;
                                    if (id4 == auVar11.bto.amq.getId()) {
                                        TiebaStatic.log(nVar.To());
                                        return;
                                    }
                                }
                            }
                            auVar7 = this.cxZ.cxX;
                            if (auVar7.brE != null) {
                                auVar8 = this.cxZ.cxX;
                                if (auVar8.brE.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    auVar9 = this.cxZ.cxX;
                                    if (id5 == auVar9.brE.getBarNameTv().getId()) {
                                        TiebaStatic.log(nVar.Tn());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(nVar.Tp());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(nVar.Tm());
                    }
                }
            }
        }
    }
}
