package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bk;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements bx<com.baidu.tieba.card.a.n> {
    final /* synthetic */ d crm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.crm = dVar;
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
        bw.Lg().cj(true);
        if (view != null) {
            bkVar = this.crm.crl;
            if (bkVar != null) {
                bkVar2 = this.crm.crl;
                if (bkVar2.getView() != null) {
                    bkVar3 = this.crm.crl;
                    if (bkVar3.aUa != null && nVar != null && nVar.Ix() != null && !StringUtils.isNull(nVar.Ix().getTid())) {
                        int id = view.getId();
                        bkVar4 = this.crm.crl;
                        if (id != bkVar4.getView().getId()) {
                            bkVar5 = this.crm.crl;
                            if (bkVar5.aUa.aUi != null) {
                                bkVar11 = this.crm.crl;
                                if (bkVar11.aUa.aUi.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    bkVar12 = this.crm.crl;
                                    if (id2 == bkVar12.aUa.aUi.getBarNameTv().getId()) {
                                        TiebaStatic.log(nVar.LE());
                                        return;
                                    }
                                }
                            }
                            bkVar6 = this.crm.crl;
                            if (bkVar6.aUa.aSY != null) {
                                int id3 = view.getId();
                                bkVar10 = this.crm.crl;
                                if (id3 == bkVar10.aUa.aSY.getId()) {
                                    TiebaStatic.log(nVar.LF());
                                    return;
                                }
                            }
                            bkVar7 = this.crm.crl;
                            if (bkVar7.aUa.aTM != null) {
                                bkVar8 = this.crm.crl;
                                if (bkVar8.aUa.aTM.aee != null) {
                                    bkVar9 = this.crm.crl;
                                    if (bkVar9.aUa.aTM.aee.getId() == view.getId()) {
                                        TiebaStatic.log(nVar.LF());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(nVar.LC());
                    }
                }
            }
        }
    }
}
