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
public class o extends bx<com.baidu.tieba.card.a.m> {
    final /* synthetic */ l cui;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.cui = lVar;
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
        bw.Lf().cl(true);
        if (view != null) {
            auVar = this.cui.cuf;
            if (auVar != null) {
                auVar2 = this.cui.cuf;
                if (auVar2.getView() != null) {
                    fVar = this.cui.cug;
                    if (fVar != null && mVar != null && mVar.Iw() != null && !StringUtils.isNull(mVar.Iw().getTid())) {
                        if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.y.bm(com.baidu.adp.lib.h.b.c(mVar.Iw().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.y.bl(com.baidu.adp.lib.h.b.c(mVar.Iw().getTid(), 0L));
                            fVar2 = this.cui.cug;
                            fVar2.a(com.baidu.adp.lib.h.b.c(mVar.Iw().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.Lg(), mVar.Li(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        auVar3 = this.cui.cuf;
                        if (id != auVar3.getView().getId()) {
                            auVar4 = this.cui.cuf;
                            if (auVar4.aUH != null) {
                                int id2 = view.getId();
                                auVar13 = this.cui.cuf;
                                if (id2 == auVar13.aUH.getId()) {
                                    TiebaStatic.log(mVar.Lz());
                                    return;
                                }
                            }
                            auVar5 = this.cui.cuf;
                            if (auVar5.aUG != null) {
                                int id3 = view.getId();
                                auVar12 = this.cui.cuf;
                                if (id3 == auVar12.aUG.getId()) {
                                    TiebaStatic.log(mVar.Lx());
                                    return;
                                }
                            }
                            auVar6 = this.cui.cuf;
                            if (auVar6.aUI != null) {
                                auVar10 = this.cui.cuf;
                                if (auVar10.aUI.aeS != null) {
                                    int id4 = view.getId();
                                    auVar11 = this.cui.cuf;
                                    if (id4 == auVar11.aUI.aeS.getId()) {
                                        TiebaStatic.log(mVar.Lx());
                                        return;
                                    }
                                }
                            }
                            auVar7 = this.cui.cuf;
                            if (auVar7.aTh != null) {
                                auVar8 = this.cui.cuf;
                                if (auVar8.aTh.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    auVar9 = this.cui.cuf;
                                    if (id5 == auVar9.aTh.getBarNameTv().getId()) {
                                        TiebaStatic.log(mVar.Lw());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(mVar.Ly());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(mVar.Lv());
                    }
                }
            }
        }
    }
}
