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
    final /* synthetic */ b cxR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cxR = bVar;
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
        cc.Rx().cM(true);
        if (view != null) {
            bkVar = this.cxR.cxQ;
            if (bkVar != null) {
                bkVar2 = this.cxR.cxQ;
                if (bkVar2.getView() != null) {
                    bkVar3 = this.cxR.cxQ;
                    if (bkVar3.bmP != null && oVar != null && oVar.Ji() != null && !StringUtils.isNull(oVar.Ji().getTid())) {
                        int id = view.getId();
                        bkVar4 = this.cxR.cxQ;
                        if (id != bkVar4.getView().getId()) {
                            bkVar5 = this.cxR.cxQ;
                            if (bkVar5.bmP.bmX != null) {
                                bkVar11 = this.cxR.cxQ;
                                if (bkVar11.bmP.bmX.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    bkVar12 = this.cxR.cxQ;
                                    if (id2 == bkVar12.bmP.bmX.getBarNameTv().getId()) {
                                        TiebaStatic.log(oVar.RY());
                                        return;
                                    }
                                }
                            }
                            bkVar6 = this.cxR.cxQ;
                            if (bkVar6.bmP.aUT != null) {
                                int id3 = view.getId();
                                bkVar10 = this.cxR.cxQ;
                                if (id3 == bkVar10.bmP.aUT.getId()) {
                                    TiebaStatic.log(oVar.RZ());
                                    return;
                                }
                            }
                            bkVar7 = this.cxR.cxQ;
                            if (bkVar7.bmP.bmB != null) {
                                bkVar8 = this.cxR.cxQ;
                                if (bkVar8.bmP.bmB.agJ != null) {
                                    bkVar9 = this.cxR.cxQ;
                                    if (bkVar9.bmP.bmB.agJ.getId() == view.getId()) {
                                        TiebaStatic.log(oVar.RZ());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(oVar.RW());
                    }
                }
            }
        }
    }
}
