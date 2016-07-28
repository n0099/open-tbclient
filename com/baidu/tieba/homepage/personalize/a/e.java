package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bk;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends bx<com.baidu.tieba.card.a.n> {
    final /* synthetic */ d ctW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ctW = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, com.baidu.tieba.card.a.n nVar) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        bk bkVar4;
        bk bkVar5;
        bk bkVar6;
        bk bkVar7;
        bk bkVar8;
        bk bkVar9;
        bk bkVar10;
        bk bkVar11;
        bk bkVar12;
        bw.Lf().cl(true);
        if (view != null) {
            bkVar = this.ctW.ctV;
            if (bkVar != null) {
                bkVar2 = this.ctW.ctV;
                if (bkVar2.getView() != null) {
                    bkVar3 = this.ctW.ctV;
                    if (bkVar3.aUW != null && nVar != null && nVar.Iw() != null && !StringUtils.isNull(nVar.Iw().getTid())) {
                        int id = view.getId();
                        bkVar4 = this.ctW.ctV;
                        if (id != bkVar4.getView().getId()) {
                            bkVar5 = this.ctW.ctV;
                            if (bkVar5.aUW.aVe != null) {
                                bkVar11 = this.ctW.ctV;
                                if (bkVar11.aUW.aVe.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    bkVar12 = this.ctW.ctV;
                                    if (id2 == bkVar12.aUW.aVe.getBarNameTv().getId()) {
                                        TiebaStatic.log(nVar.LD());
                                        return;
                                    }
                                }
                            }
                            bkVar6 = this.ctW.ctV;
                            if (bkVar6.aUW.aTU != null) {
                                int id3 = view.getId();
                                bkVar10 = this.ctW.ctV;
                                if (id3 == bkVar10.aUW.aTU.getId()) {
                                    TiebaStatic.log(nVar.LE());
                                    return;
                                }
                            }
                            bkVar7 = this.ctW.ctV;
                            if (bkVar7.aUW.aUI != null) {
                                bkVar8 = this.ctW.ctV;
                                if (bkVar8.aUW.aUI.aeS != null) {
                                    bkVar9 = this.ctW.ctV;
                                    if (bkVar9.aUW.aUI.aeS.getId() == view.getId()) {
                                        TiebaStatic.log(nVar.LE());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(nVar.LB());
                    }
                }
            }
        }
    }
}
