package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.homepage.personalize.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends ci<com.baidu.tieba.card.data.n> {
    final /* synthetic */ u cJW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.cJW = uVar;
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
        cf.VN().cw(true);
        fVar = this.cJW.cJQ;
        if (fVar != null && nVar != null && nVar.Mv() != null && !StringUtils.isNull(nVar.Mv().getTid())) {
            yVar = this.cJW.cJV;
            if (yVar != null) {
                yVar2 = this.cJW.cJV;
                if (yVar2.getView() != null) {
                    if ((view.getTag() instanceof String) && !ay.bu(com.baidu.adp.lib.g.b.c(nVar.Mv().getTid(), 0L))) {
                        ay.bt(com.baidu.adp.lib.g.b.c(nVar.Mv().getTid(), 0L));
                        fVar2 = this.cJW.cJQ;
                        fVar2.a(com.baidu.adp.lib.g.b.c(nVar.Mv().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.VS(), nVar.VU(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                    }
                    int id = view.getId();
                    yVar3 = this.cJW.cJV;
                    if (id != yVar3.getView().getId()) {
                        yVar4 = this.cJW.cJV;
                        if (yVar4.bgF != null) {
                            yVar9 = this.cJW.cJV;
                            if (yVar9.bgF.getBarNameTv() != null) {
                                int id2 = view.getId();
                                yVar10 = this.cJW.cJV;
                                if (id2 == yVar10.bgF.getBarNameTv().getId()) {
                                    TiebaStatic.log(nVar.Wd());
                                    return;
                                }
                            }
                        }
                        yVar5 = this.cJW.cJV;
                        if (yVar5.getHeaderImg() != null) {
                            int id3 = view.getId();
                            yVar8 = this.cJW.cJV;
                            if (id3 == yVar8.getHeaderImg().getId()) {
                                TiebaStatic.log(nVar.z(nVar.bai));
                                return;
                            }
                        }
                        yVar6 = this.cJW.cJV;
                        if (yVar6.Vv() != null) {
                            int id4 = view.getId();
                            yVar7 = this.cJW.cJV;
                            if (id4 == yVar7.Vv().getId()) {
                                TiebaStatic.log(nVar.z(nVar.bai));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log(nVar.y(nVar.bai));
                }
            }
        }
    }
}
