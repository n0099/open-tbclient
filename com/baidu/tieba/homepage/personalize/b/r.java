package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.homepage.personalize.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends ci<com.baidu.tieba.card.data.l> {
    final /* synthetic */ o cBU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.cBU = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
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
        au auVar14;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cf.Uw().ds(true);
        if (view != null) {
            auVar = this.cBU.cBS;
            if (auVar != null) {
                auVar2 = this.cBU.cBS;
                if (auVar2.getView() != null) {
                    fVar = this.cBU.cBT;
                    if (fVar != null && lVar != null && lVar.LH() != null && !StringUtils.isNull(lVar.LH().getTid())) {
                        if ((view.getTag() instanceof String) && !am.bg(com.baidu.adp.lib.g.b.c(lVar.LH().getTid(), 0L))) {
                            am.bf(com.baidu.adp.lib.g.b.c(lVar.LH().getTid(), 0L));
                            fVar2 = this.cBU.cBT;
                            fVar2.a(com.baidu.adp.lib.g.b.c(lVar.LH().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.UB(), lVar.UD(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        auVar3 = this.cBU.cBS;
                        if (id != auVar3.getView().getId()) {
                            auVar4 = this.cBU.cBS;
                            if (auVar4.bBq != null) {
                                int id2 = view.getId();
                                auVar14 = this.cBU.cBS;
                                if (id2 == auVar14.bBq.getId()) {
                                    TiebaStatic.log(lVar.UP());
                                    return;
                                }
                            }
                            auVar5 = this.cBU.cBS;
                            if (auVar5.getHeaderImg() != null) {
                                int id3 = view.getId();
                                auVar13 = this.cBU.cBS;
                                if (id3 == auVar13.getHeaderImg().getId()) {
                                    TiebaStatic.log(lVar.UN());
                                    return;
                                }
                            }
                            auVar6 = this.cBU.cBS;
                            if (auVar6.Ug() != null) {
                                int id4 = view.getId();
                                auVar12 = this.cBU.cBS;
                                if (id4 == auVar12.Ug().getId()) {
                                    TiebaStatic.log(lVar.UN());
                                    return;
                                }
                            }
                            auVar7 = this.cBU.cBS;
                            if (auVar7.bdI != null) {
                                auVar10 = this.cBU.cBS;
                                if (auVar10.bdI.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    auVar11 = this.cBU.cBS;
                                    if (id5 == auVar11.bdI.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.UM());
                                        return;
                                    }
                                }
                            }
                            if (!(view instanceof TbImageView)) {
                                auVar8 = this.cBU.cBS;
                                if (auVar8.Uf() != null) {
                                    int id6 = view.getId();
                                    auVar9 = this.cBU.cBS;
                                    if (id6 == auVar9.Uf().getId()) {
                                        TiebaStatic.log(lVar.ik("c10760"));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(lVar.UO());
                            return;
                        }
                        TiebaStatic.log(lVar.UL());
                    }
                }
            }
        }
    }
}
