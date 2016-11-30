package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.be;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends bz<com.baidu.tieba.card.data.n> {
    final /* synthetic */ c cLz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cLz = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, com.baidu.tieba.card.data.n nVar) {
        be beVar;
        be beVar2;
        be beVar3;
        be beVar4;
        be beVar5;
        be beVar6;
        be beVar7;
        be beVar8;
        be beVar9;
        be beVar10;
        be beVar11;
        be beVar12;
        bx.Pl().cw(true);
        if (view != null) {
            beVar = this.cLz.cLy;
            if (beVar != null) {
                beVar2 = this.cLz.cLy;
                if (beVar2.getView() != null) {
                    beVar3 = this.cLz.cLy;
                    if (beVar3.bdI != null && nVar != null && nVar.Jz() != null && !StringUtils.isNull(nVar.Jz().getTid())) {
                        int id = view.getId();
                        beVar4 = this.cLz.cLy;
                        if (id != beVar4.getView().getId()) {
                            beVar5 = this.cLz.cLy;
                            if (beVar5.bdI.bdQ != null) {
                                beVar11 = this.cLz.cLy;
                                if (beVar11.bdI.bdQ.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    beVar12 = this.cLz.cLy;
                                    if (id2 == beVar12.bdI.bdQ.getBarNameTv().getId()) {
                                        TiebaStatic.log(nVar.PM());
                                        return;
                                    }
                                }
                            }
                            beVar6 = this.cLz.cLy;
                            if (beVar6.bdI.bcF != null) {
                                int id3 = view.getId();
                                beVar10 = this.cLz.cLy;
                                if (id3 == beVar10.bdI.bcF.getId()) {
                                    TiebaStatic.log(nVar.PN());
                                    return;
                                }
                            }
                            beVar7 = this.cLz.cLy;
                            if (beVar7.bdI.bdu != null) {
                                beVar8 = this.cLz.cLy;
                                if (beVar8.bdI.bdu.ahV != null) {
                                    beVar9 = this.cLz.cLy;
                                    if (beVar9.bdI.bdu.ahV.getId() == view.getId()) {
                                        TiebaStatic.log(nVar.PN());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(nVar.PK());
                    }
                }
            }
        }
    }
}
