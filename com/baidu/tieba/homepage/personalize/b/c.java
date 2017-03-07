package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bk;
import com.baidu.tieba.card.cc;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends cf<com.baidu.tieba.card.data.o> {
    final /* synthetic */ b czn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.czn = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.o oVar) {
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
        cc.Sv().cM(true);
        if (view != null) {
            bkVar = this.czn.czm;
            if (bkVar != null) {
                bkVar2 = this.czn.czm;
                if (bkVar2.getView() != null) {
                    bkVar3 = this.czn.czm;
                    if (bkVar3.btK != null && oVar != null && oVar.JN() != null && !StringUtils.isNull(oVar.JN().getTid())) {
                        int id = view.getId();
                        bkVar4 = this.czn.czm;
                        if (id != bkVar4.getView().getId()) {
                            bkVar5 = this.czn.czm;
                            if (bkVar5.btK.btS != null) {
                                bkVar11 = this.czn.czm;
                                if (bkVar11.btK.btS.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    bkVar12 = this.czn.czm;
                                    if (id2 == bkVar12.btK.btS.getBarNameTv().getId()) {
                                        TiebaStatic.log(oVar.SW());
                                        return;
                                    }
                                }
                            }
                            bkVar6 = this.czn.czm;
                            if (bkVar6.btK.bbg != null) {
                                int id3 = view.getId();
                                bkVar10 = this.czn.czm;
                                if (id3 == bkVar10.btK.bbg.getId()) {
                                    TiebaStatic.log(oVar.SX());
                                    return;
                                }
                            }
                            bkVar7 = this.czn.czm;
                            if (bkVar7.btK.btw != null) {
                                bkVar8 = this.czn.czm;
                                if (bkVar8.btK.btw.amc != null) {
                                    bkVar9 = this.czn.czm;
                                    if (bkVar9.btK.btw.amc.getId() == view.getId()) {
                                        TiebaStatic.log(oVar.SX());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(oVar.SU());
                    }
                }
            }
        }
    }
}
