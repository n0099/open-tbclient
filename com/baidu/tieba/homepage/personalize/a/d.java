package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bg;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends cf<com.baidu.tieba.card.data.n> {
    final /* synthetic */ c cFA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cFA = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, com.baidu.tieba.card.data.n nVar) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        bg bgVar4;
        bg bgVar5;
        bg bgVar6;
        bg bgVar7;
        bg bgVar8;
        bg bgVar9;
        bg bgVar10;
        bg bgVar11;
        bg bgVar12;
        cd.NI().cr(true);
        if (view != null) {
            bgVar = this.cFA.cFz;
            if (bgVar != null) {
                bgVar2 = this.cFA.cFz;
                if (bgVar2.getView() != null) {
                    bgVar3 = this.cFA.cFz;
                    if (bgVar3.bah != null && nVar != null && nVar.Kw() != null && !StringUtils.isNull(nVar.Kw().getTid())) {
                        int id = view.getId();
                        bgVar4 = this.cFA.cFz;
                        if (id != bgVar4.getView().getId()) {
                            bgVar5 = this.cFA.cFz;
                            if (bgVar5.bah.baq != null) {
                                bgVar11 = this.cFA.cFz;
                                if (bgVar11.bah.baq.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    bgVar12 = this.cFA.cFz;
                                    if (id2 == bgVar12.bah.baq.getBarNameTv().getId()) {
                                        TiebaStatic.log(nVar.Oh());
                                        return;
                                    }
                                }
                            }
                            bgVar6 = this.cFA.cFz;
                            if (bgVar6.bah.aZc != null) {
                                int id3 = view.getId();
                                bgVar10 = this.cFA.cFz;
                                if (id3 == bgVar10.bah.aZc.getId()) {
                                    TiebaStatic.log(nVar.Oi());
                                    return;
                                }
                            }
                            bgVar7 = this.cFA.cFz;
                            if (bgVar7.bah.aZT != null) {
                                bgVar8 = this.cFA.cFz;
                                if (bgVar8.bah.aZT.ahN != null) {
                                    bgVar9 = this.cFA.cFz;
                                    if (bgVar9.bah.aZT.ahN.getId() == view.getId()) {
                                        TiebaStatic.log(nVar.Oi());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(nVar.Of());
                    }
                }
            }
        }
    }
}
