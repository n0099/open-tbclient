package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements bx<com.baidu.tieba.card.a.m> {
    final /* synthetic */ l cry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.cry = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, com.baidu.tieba.card.a.m mVar) {
        au auVar;
        au auVar2;
        com.baidu.tieba.homepage.personalize.b.f fVar;
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
        com.baidu.tieba.homepage.personalize.b.f fVar2;
        bw.Lg().cj(true);
        if (view != null) {
            auVar = this.cry.crv;
            if (auVar != null) {
                auVar2 = this.cry.crv;
                if (auVar2.getView() != null) {
                    fVar = this.cry.crw;
                    if (fVar != null && mVar != null && mVar.Ix() != null && !StringUtils.isNull(mVar.Ix().getTid())) {
                        if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.r.br(com.baidu.adp.lib.h.b.c(mVar.Ix().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.r.bq(com.baidu.adp.lib.h.b.c(mVar.Ix().getTid(), 0L));
                            fVar2 = this.cry.crw;
                            fVar2.a(com.baidu.adp.lib.h.b.c(mVar.Ix().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.Lh(), mVar.Lj(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        auVar3 = this.cry.crv;
                        if (id != auVar3.getView().getId()) {
                            auVar4 = this.cry.crv;
                            if (auVar4.aTL != null) {
                                int id2 = view.getId();
                                auVar13 = this.cry.crv;
                                if (id2 == auVar13.aTL.getId()) {
                                    TiebaStatic.log(mVar.LA());
                                    return;
                                }
                            }
                            auVar5 = this.cry.crv;
                            if (auVar5.aTK != null) {
                                int id3 = view.getId();
                                auVar12 = this.cry.crv;
                                if (id3 == auVar12.aTK.getId()) {
                                    TiebaStatic.log(mVar.Ly());
                                    return;
                                }
                            }
                            auVar6 = this.cry.crv;
                            if (auVar6.aTM != null) {
                                auVar10 = this.cry.crv;
                                if (auVar10.aTM.aee != null) {
                                    int id4 = view.getId();
                                    auVar11 = this.cry.crv;
                                    if (id4 == auVar11.aTM.aee.getId()) {
                                        TiebaStatic.log(mVar.Ly());
                                        return;
                                    }
                                }
                            }
                            auVar7 = this.cry.crv;
                            if (auVar7.aSl != null) {
                                auVar8 = this.cry.crv;
                                if (auVar8.aSl.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    auVar9 = this.cry.crv;
                                    if (id5 == auVar9.aSl.getBarNameTv().getId()) {
                                        TiebaStatic.log(mVar.Lx());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(mVar.Lz());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(mVar.Lw());
                    }
                }
            }
        }
    }
}
