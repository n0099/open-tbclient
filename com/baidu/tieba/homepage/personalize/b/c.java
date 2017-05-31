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
    final /* synthetic */ b cBG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cBG = bVar;
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
        cf.Uw().ds(true);
        if (view != null) {
            bjVar = this.cBG.cBF;
            if (bjVar != null) {
                bjVar2 = this.cBG.cBF;
                if (bjVar2.getView() != null) {
                    bjVar3 = this.cBG.cBF;
                    if (bjVar3.bBG != null && mVar != null && mVar.LH() != null && !StringUtils.isNull(mVar.LH().getTid())) {
                        int id = view.getId();
                        bjVar4 = this.cBG.cBF;
                        if (id != bjVar4.getView().getId()) {
                            bjVar5 = this.cBG.cBF;
                            if (bjVar5.Uv() != null) {
                                int id2 = view.getId();
                                bjVar10 = this.cBG.cBF;
                                if (id2 == bjVar10.Uv().getId()) {
                                    TiebaStatic.log(mVar.UT());
                                    return;
                                }
                            }
                            bjVar6 = this.cBG.cBF;
                            if (bjVar6.getHeaderImg() != null) {
                                int id3 = view.getId();
                                bjVar9 = this.cBG.cBF;
                                if (id3 == bjVar9.getHeaderImg().getId()) {
                                    TiebaStatic.log(mVar.UU());
                                    return;
                                }
                            }
                            bjVar7 = this.cBG.cBF;
                            if (bjVar7.Ug() != null) {
                                bjVar8 = this.cBG.cBF;
                                if (bjVar8.Ug().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.UU());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(mVar.UR());
                    }
                }
            }
        }
    }
}
