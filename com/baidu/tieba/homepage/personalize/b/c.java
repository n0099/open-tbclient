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
    final /* synthetic */ b cxN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cxN = bVar;
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
        cc.ST().cO(true);
        if (view != null) {
            bkVar = this.cxN.cxM;
            if (bkVar != null) {
                bkVar2 = this.cxN.cxM;
                if (bkVar2.getView() != null) {
                    bkVar3 = this.cxN.cxM;
                    if (bkVar3.btC != null && oVar != null && oVar.Kn() != null && !StringUtils.isNull(oVar.Kn().getTid())) {
                        int id = view.getId();
                        bkVar4 = this.cxN.cxM;
                        if (id != bkVar4.getView().getId()) {
                            bkVar5 = this.cxN.cxM;
                            if (bkVar5.btC.btK != null) {
                                bkVar11 = this.cxN.cxM;
                                if (bkVar11.btC.btK.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    bkVar12 = this.cxN.cxM;
                                    if (id2 == bkVar12.btC.btK.getBarNameTv().getId()) {
                                        TiebaStatic.log(oVar.Tu());
                                        return;
                                    }
                                }
                            }
                            bkVar6 = this.cxN.cxM;
                            if (bkVar6.btC.baZ != null) {
                                int id3 = view.getId();
                                bkVar10 = this.cxN.cxM;
                                if (id3 == bkVar10.btC.baZ.getId()) {
                                    TiebaStatic.log(oVar.Tv());
                                    return;
                                }
                            }
                            bkVar7 = this.cxN.cxM;
                            if (bkVar7.btC.bto != null) {
                                bkVar8 = this.cxN.cxM;
                                if (bkVar8.btC.bto.amq != null) {
                                    bkVar9 = this.cxN.cxM;
                                    if (bkVar9.btC.bto.amq.getId() == view.getId()) {
                                        TiebaStatic.log(oVar.Tv());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(oVar.Ts());
                    }
                }
            }
        }
    }
}
