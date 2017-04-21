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
    final /* synthetic */ m cAq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.cAq = mVar;
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
        cc.TV().cY(true);
        if (view != null) {
            auVar = this.cAq.cAo;
            if (auVar != null) {
                auVar2 = this.cAq.cAo;
                if (auVar2.getView() != null) {
                    fVar = this.cAq.cAp;
                    if (fVar != null && nVar != null && nVar.Kn() != null && !StringUtils.isNull(nVar.Kn().getTid())) {
                        if ((view.getTag() instanceof String) && !aj.bq(com.baidu.adp.lib.g.b.c(nVar.Kn().getTid(), 0L))) {
                            aj.bp(com.baidu.adp.lib.g.b.c(nVar.Kn().getTid(), 0L));
                            fVar2 = this.cAq.cAp;
                            fVar2.a(com.baidu.adp.lib.g.b.c(nVar.Kn().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.TX(), nVar.TZ(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        auVar3 = this.cAq.cAo;
                        if (id != auVar3.getView().getId()) {
                            auVar4 = this.cAq.cAo;
                            if (auVar4.bvE != null) {
                                int id2 = view.getId();
                                auVar13 = this.cAq.cAo;
                                if (id2 == auVar13.bvE.getId()) {
                                    TiebaStatic.log(nVar.Us());
                                    return;
                                }
                            }
                            auVar5 = this.cAq.cAo;
                            if (auVar5.bvD != null) {
                                int id3 = view.getId();
                                auVar12 = this.cAq.cAo;
                                if (id3 == auVar12.bvD.getId()) {
                                    TiebaStatic.log(nVar.Uq());
                                    return;
                                }
                            }
                            auVar6 = this.cAq.cAo;
                            if (auVar6.bvG != null) {
                                auVar10 = this.cAq.cAo;
                                if (auVar10.bvG.amq != null) {
                                    int id4 = view.getId();
                                    auVar11 = this.cAq.cAo;
                                    if (id4 == auVar11.bvG.amq.getId()) {
                                        TiebaStatic.log(nVar.Uq());
                                        return;
                                    }
                                }
                            }
                            auVar7 = this.cAq.cAo;
                            if (auVar7.btW != null) {
                                auVar8 = this.cAq.cAo;
                                if (auVar8.btW.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    auVar9 = this.cAq.cAo;
                                    if (id5 == auVar9.btW.getBarNameTv().getId()) {
                                        TiebaStatic.log(nVar.Up());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(nVar.Ur());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(nVar.Uo());
                    }
                }
            }
        }
    }
}
