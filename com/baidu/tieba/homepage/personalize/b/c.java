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
    final /* synthetic */ b cAe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cAe = bVar;
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
        cc.TV().cY(true);
        if (view != null) {
            bkVar = this.cAe.cAd;
            if (bkVar != null) {
                bkVar2 = this.cAe.cAd;
                if (bkVar2.getView() != null) {
                    bkVar3 = this.cAe.cAd;
                    if (bkVar3.bvU != null && oVar != null && oVar.Kn() != null && !StringUtils.isNull(oVar.Kn().getTid())) {
                        int id = view.getId();
                        bkVar4 = this.cAe.cAd;
                        if (id != bkVar4.getView().getId()) {
                            bkVar5 = this.cAe.cAd;
                            if (bkVar5.bvU.bwc != null) {
                                bkVar11 = this.cAe.cAd;
                                if (bkVar11.bvU.bwc.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    bkVar12 = this.cAe.cAd;
                                    if (id2 == bkVar12.bvU.bwc.getBarNameTv().getId()) {
                                        TiebaStatic.log(oVar.Uw());
                                        return;
                                    }
                                }
                            }
                            bkVar6 = this.cAe.cAd;
                            if (bkVar6.bvU.bbV != null) {
                                int id3 = view.getId();
                                bkVar10 = this.cAe.cAd;
                                if (id3 == bkVar10.bvU.bbV.getId()) {
                                    TiebaStatic.log(oVar.Ux());
                                    return;
                                }
                            }
                            bkVar7 = this.cAe.cAd;
                            if (bkVar7.bvU.bvG != null) {
                                bkVar8 = this.cAe.cAd;
                                if (bkVar8.bvU.bvG.amq != null) {
                                    bkVar9 = this.cAe.cAd;
                                    if (bkVar9.bvU.bvG.amq.getId() == view.getId()) {
                                        TiebaStatic.log(oVar.Ux());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(oVar.Uu());
                    }
                }
            }
        }
    }
}
