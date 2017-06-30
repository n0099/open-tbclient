package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bj;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends ci<com.baidu.tieba.card.data.m> {
    final /* synthetic */ b cJD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cJD = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bj bjVar5;
        bj bjVar6;
        bj bjVar7;
        bj bjVar8;
        bj bjVar9;
        bj bjVar10;
        cf.VN().cw(true);
        if (view != null) {
            bjVar = this.cJD.cJC;
            if (bjVar != null) {
                bjVar2 = this.cJD.cJC;
                if (bjVar2.getView() != null) {
                    bjVar3 = this.cJD.cJC;
                    if (bjVar3.bCz != null && mVar != null && mVar.Mv() != null && !StringUtils.isNull(mVar.Mv().getTid())) {
                        int id = view.getId();
                        bjVar4 = this.cJD.cJC;
                        if (id != bjVar4.getView().getId()) {
                            bjVar5 = this.cJD.cJC;
                            if (bjVar5.VM() != null) {
                                int id2 = view.getId();
                                bjVar10 = this.cJD.cJC;
                                if (id2 == bjVar10.VM().getId()) {
                                    TiebaStatic.log(mVar.Wk());
                                    return;
                                }
                            }
                            bjVar6 = this.cJD.cJC;
                            if (bjVar6.getHeaderImg() != null) {
                                int id3 = view.getId();
                                bjVar9 = this.cJD.cJC;
                                if (id3 == bjVar9.getHeaderImg().getId()) {
                                    TiebaStatic.log(mVar.Wl());
                                    return;
                                }
                            }
                            bjVar7 = this.cJD.cJC;
                            if (bjVar7.Vv() != null) {
                                bjVar8 = this.cJD.cJC;
                                if (bjVar8.Vv().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.Wl());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(mVar.Wi());
                    }
                }
            }
        }
    }
}
