package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.homepage.personalize.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends ci<com.baidu.tieba.card.data.n> {
    final /* synthetic */ u cBZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.cBZ = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.n nVar) {
        com.baidu.tieba.homepage.personalize.model.f fVar;
        com.baidu.tieba.card.y yVar;
        com.baidu.tieba.card.y yVar2;
        com.baidu.tieba.card.y yVar3;
        com.baidu.tieba.card.y yVar4;
        com.baidu.tieba.card.y yVar5;
        com.baidu.tieba.card.y yVar6;
        com.baidu.tieba.card.y yVar7;
        com.baidu.tieba.card.y yVar8;
        com.baidu.tieba.card.y yVar9;
        com.baidu.tieba.card.y yVar10;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cf.Uw().ds(true);
        fVar = this.cBZ.cBT;
        if (fVar != null && nVar != null && nVar.LH() != null && !StringUtils.isNull(nVar.LH().getTid())) {
            yVar = this.cBZ.cBY;
            if (yVar != null) {
                yVar2 = this.cBZ.cBY;
                if (yVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !am.bg(com.baidu.adp.lib.g.b.c(nVar.LH().getTid(), 0L))) {
                        am.bf(com.baidu.adp.lib.g.b.c(nVar.LH().getTid(), 0L));
                        fVar2 = this.cBZ.cBT;
                        fVar2.a(com.baidu.adp.lib.g.b.c(nVar.LH().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.UB(), nVar.UD(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    yVar3 = this.cBZ.cBY;
                    if (id != yVar3.getView().getId()) {
                        yVar4 = this.cBZ.cBY;
                        if (yVar4.bdI != null) {
                            yVar9 = this.cBZ.cBY;
                            if (yVar9.bdI.getBarNameTv() != null) {
                                int id2 = view.getId();
                                yVar10 = this.cBZ.cBY;
                                if (id2 == yVar10.bdI.getBarNameTv().getId()) {
                                    TiebaStatic.log(nVar.UM());
                                    return;
                                }
                            }
                        }
                        yVar5 = this.cBZ.cBY;
                        if (yVar5.getHeaderImg() != null) {
                            int id3 = view.getId();
                            yVar8 = this.cBZ.cBY;
                            if (id3 == yVar8.getHeaderImg().getId()) {
                                TiebaStatic.log(nVar.y(nVar.aYA));
                                return;
                            }
                        }
                        yVar6 = this.cBZ.cBY;
                        if (yVar6.Ug() != null) {
                            int id4 = view.getId();
                            yVar7 = this.cBZ.cBY;
                            if (id4 == yVar7.Ug().getId()) {
                                TiebaStatic.log(nVar.y(nVar.aYA));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(nVar.x(nVar.aYA));
                }
            }
        }
    }
}
