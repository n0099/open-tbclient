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
    final /* synthetic */ m cJO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.cJO = mVar;
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
        cf.VN().cw(true);
        if (view != null) {
            btVar = this.cJO.cJN;
            if (btVar != null) {
                btVar2 = this.cJO.cJN;
                if (btVar2.getView() != null && lVar != null && lVar.Mv() != null && !StringUtils.isNull(lVar.Mv().getTid())) {
                    int id = view.getId();
                    btVar3 = this.cJO.cJN;
                    if (id != btVar3.getView().getId()) {
                        btVar4 = this.cJO.cJN;
                        if (btVar4.getHeaderImg() != null) {
                            int id2 = view.getId();
                            btVar12 = this.cJO.cJN;
                            if (id2 == btVar12.getHeaderImg().getId()) {
                                TiebaStatic.log(lVar.iR("c12191"));
                                return;
                            }
                        }
                        btVar5 = this.cJO.cJN;
                        if (btVar5.Vv() != null) {
                            int id3 = view.getId();
                            btVar11 = this.cJO.cJN;
                            if (id3 == btVar11.Vv().getId()) {
                                TiebaStatic.log(lVar.iR("c12191"));
                                return;
                            }
                        }
                        btVar6 = this.cJO.cJN;
                        if (btVar6.bgF != null) {
                            btVar9 = this.cJO.cJN;
                            if (btVar9.bgF.getBarNameTv() != null) {
                                int id4 = view.getId();
                                btVar10 = this.cJO.cJN;
                                if (id4 == btVar10.bgF.getBarNameTv().getId()) {
                                    TiebaStatic.log(lVar.Wd());
                                    return;
                                }
                            }
                        }
                        btVar7 = this.cJO.cJN;
                        if (btVar7.Vu() != null) {
                            int id5 = view.getId();
                            btVar8 = this.cJO.cJN;
                            if (id5 == btVar8.Vu().getId()) {
                                TiebaStatic.log(lVar.iS("c12202"));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(lVar.iR("c12192"));
                }
            }
        }
    }
}
