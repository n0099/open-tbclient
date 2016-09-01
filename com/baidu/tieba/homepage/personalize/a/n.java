package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aq;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends cf<com.baidu.tieba.card.data.m> {
    final /* synthetic */ k cFM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.cFM = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        aq aqVar;
        aq aqVar2;
        com.baidu.tieba.homepage.personalize.b.f fVar;
        aq aqVar3;
        aq aqVar4;
        aq aqVar5;
        aq aqVar6;
        aq aqVar7;
        aq aqVar8;
        aq aqVar9;
        aq aqVar10;
        aq aqVar11;
        aq aqVar12;
        aq aqVar13;
        com.baidu.tieba.homepage.personalize.b.f fVar2;
        cd.NI().cr(true);
        if (view != null) {
            aqVar = this.cFM.cFJ;
            if (aqVar != null) {
                aqVar2 = this.cFM.cFJ;
                if (aqVar2.getView() != null) {
                    fVar = this.cFM.cFK;
                    if (fVar != null && mVar != null && mVar.Kw() != null && !StringUtils.isNull(mVar.Kw().getTid())) {
                        if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.y.bI(com.baidu.adp.lib.h.b.c(mVar.Kw().getTid(), 0L))) {
                            com.baidu.tieba.homepage.personalize.y.bH(com.baidu.adp.lib.h.b.c(mVar.Kw().getTid(), 0L));
                            fVar2 = this.cFM.cFK;
                            fVar2.a(com.baidu.adp.lib.h.b.c(mVar.Kw().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.NJ(), mVar.NL(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        aqVar3 = this.cFM.cFJ;
                        if (id != aqVar3.getView().getId()) {
                            aqVar4 = this.cFM.cFJ;
                            if (aqVar4.aZS != null) {
                                int id2 = view.getId();
                                aqVar13 = this.cFM.cFJ;
                                if (id2 == aqVar13.aZS.getId()) {
                                    TiebaStatic.log(mVar.Od());
                                    return;
                                }
                            }
                            aqVar5 = this.cFM.cFJ;
                            if (aqVar5.aZR != null) {
                                int id3 = view.getId();
                                aqVar12 = this.cFM.cFJ;
                                if (id3 == aqVar12.aZR.getId()) {
                                    TiebaStatic.log(mVar.Ob());
                                    return;
                                }
                            }
                            aqVar6 = this.cFM.cFJ;
                            if (aqVar6.aZT != null) {
                                aqVar10 = this.cFM.cFJ;
                                if (aqVar10.aZT.ahN != null) {
                                    int id4 = view.getId();
                                    aqVar11 = this.cFM.cFJ;
                                    if (id4 == aqVar11.aZT.ahN.getId()) {
                                        TiebaStatic.log(mVar.Ob());
                                        return;
                                    }
                                }
                            }
                            aqVar7 = this.cFM.cFJ;
                            if (aqVar7.aYp != null) {
                                aqVar8 = this.cFM.cFJ;
                                if (aqVar8.aYp.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    aqVar9 = this.cFM.cFJ;
                                    if (id5 == aqVar9.aYp.getBarNameTv().getId()) {
                                        TiebaStatic.log(mVar.Oa());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(mVar.Oc());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(mVar.NZ());
                    }
                }
            }
        }
    }
}
