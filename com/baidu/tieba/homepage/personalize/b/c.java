package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bg;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends cb<com.baidu.tieba.card.data.n> {
    final /* synthetic */ b cqQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cqQ = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
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
        bz.OH().cy(true);
        if (view != null) {
            bgVar = this.cqQ.cqP;
            if (bgVar != null) {
                bgVar2 = this.cqQ.cqP;
                if (bgVar2.getView() != null) {
                    bgVar3 = this.cqQ.cqP;
                    if (bgVar3.bda != null && nVar != null && nVar.IU() != null && !StringUtils.isNull(nVar.IU().getTid())) {
                        int id = view.getId();
                        bgVar4 = this.cqQ.cqP;
                        if (id != bgVar4.getView().getId()) {
                            bgVar5 = this.cqQ.cqP;
                            if (bgVar5.bda.bdi != null) {
                                bgVar11 = this.cqQ.cqP;
                                if (bgVar11.bda.bdi.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    bgVar12 = this.cqQ.cqP;
                                    if (id2 == bgVar12.bda.bdi.getBarNameTv().getId()) {
                                        TiebaStatic.log(nVar.Pi());
                                        return;
                                    }
                                }
                            }
                            bgVar6 = this.cqQ.cqP;
                            if (bgVar6.bda.bbY != null) {
                                int id3 = view.getId();
                                bgVar10 = this.cqQ.cqP;
                                if (id3 == bgVar10.bda.bbY.getId()) {
                                    TiebaStatic.log(nVar.Pj());
                                    return;
                                }
                            }
                            bgVar7 = this.cqQ.cqP;
                            if (bgVar7.bda.bcM != null) {
                                bgVar8 = this.cqQ.cqP;
                                if (bgVar8.bda.bcM.ahw != null) {
                                    bgVar9 = this.cqQ.cqP;
                                    if (bgVar9.bda.bcM.ahw.getId() == view.getId()) {
                                        TiebaStatic.log(nVar.Pj());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(nVar.Pg());
                    }
                }
            }
        }
    }
}
