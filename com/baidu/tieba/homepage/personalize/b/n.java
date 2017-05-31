package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bt;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends ci<com.baidu.tieba.card.data.l> {
    final /* synthetic */ m cBR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.cBR = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        bt btVar4;
        bt btVar5;
        bt btVar6;
        bt btVar7;
        bt btVar8;
        bt btVar9;
        bt btVar10;
        bt btVar11;
        bt btVar12;
        cf.Uw().ds(true);
        if (view != null) {
            btVar = this.cBR.cBQ;
            if (btVar != null) {
                btVar2 = this.cBR.cBQ;
                if (btVar2.getView() != null && lVar != null && lVar.LH() != null && !StringUtils.isNull(lVar.LH().getTid())) {
                    int id = view.getId();
                    btVar3 = this.cBR.cBQ;
                    if (id != btVar3.getView().getId()) {
                        btVar4 = this.cBR.cBQ;
                        if (btVar4.getHeaderImg() != null) {
                            int id2 = view.getId();
                            btVar12 = this.cBR.cBQ;
                            if (id2 == btVar12.getHeaderImg().getId()) {
                                TiebaStatic.log(lVar.ij("c12191"));
                                return;
                            }
                        }
                        btVar5 = this.cBR.cBQ;
                        if (btVar5.Ug() != null) {
                            int id3 = view.getId();
                            btVar11 = this.cBR.cBQ;
                            if (id3 == btVar11.Ug().getId()) {
                                TiebaStatic.log(lVar.ij("c12191"));
                                return;
                            }
                        }
                        btVar6 = this.cBR.cBQ;
                        if (btVar6.bdI != null) {
                            btVar9 = this.cBR.cBQ;
                            if (btVar9.bdI.getBarNameTv() != null) {
                                int id4 = view.getId();
                                btVar10 = this.cBR.cBQ;
                                if (id4 == btVar10.bdI.getBarNameTv().getId()) {
                                    TiebaStatic.log(lVar.UM());
                                    return;
                                }
                            }
                        }
                        btVar7 = this.cBR.cBQ;
                        if (btVar7.Uf() != null) {
                            int id5 = view.getId();
                            btVar8 = this.cBR.cBQ;
                            if (id5 == btVar8.Uf().getId()) {
                                TiebaStatic.log(lVar.ik("c12202"));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(lVar.ij("c12192"));
                }
            }
        }
    }
}
