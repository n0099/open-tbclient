package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.homepage.personalize.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends ci<com.baidu.tieba.card.data.l> {
    final /* synthetic */ o cJR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.cJR = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        au auVar;
        au auVar2;
        com.baidu.tieba.homepage.personalize.model.f fVar;
        au auVar3;
        au auVar4;
        au auVar5;
        au auVar6;
        au auVar7;
        au auVar8;
        au auVar9;
        au auVar10;
        au auVar11;
        au auVar12;
        au auVar13;
        au auVar14;
        com.baidu.tieba.homepage.personalize.model.f fVar2;
        cf.VN().cw(true);
        if (view != null) {
            auVar = this.cJR.cJP;
            if (auVar != null) {
                auVar2 = this.cJR.cJP;
                if (auVar2.getView() != null) {
                    fVar = this.cJR.cJQ;
                    if (fVar != null && lVar != null && lVar.Mv() != null && !StringUtils.isNull(lVar.Mv().getTid())) {
                        if ((view.getTag() instanceof String) && !ay.bu(com.baidu.adp.lib.g.b.c(lVar.Mv().getTid(), 0L))) {
                            ay.bt(com.baidu.adp.lib.g.b.c(lVar.Mv().getTid(), 0L));
                            fVar2 = this.cJR.cJQ;
                            fVar2.a(com.baidu.adp.lib.g.b.c(lVar.Mv().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.VS(), lVar.VU(), com.baidu.adp.lib.g.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        auVar3 = this.cJR.cJP;
                        if (id != auVar3.getView().getId()) {
                            auVar4 = this.cJR.cJP;
                            if (auVar4.bCj != null) {
                                int id2 = view.getId();
                                auVar14 = this.cJR.cJP;
                                if (id2 == auVar14.bCj.getId()) {
                                    TiebaStatic.log(lVar.Wg());
                                    return;
                                }
                            }
                            auVar5 = this.cJR.cJP;
                            if (auVar5.getHeaderImg() != null) {
                                int id3 = view.getId();
                                auVar13 = this.cJR.cJP;
                                if (id3 == auVar13.getHeaderImg().getId()) {
                                    TiebaStatic.log(lVar.We());
                                    return;
                                }
                            }
                            auVar6 = this.cJR.cJP;
                            if (auVar6.Vv() != null) {
                                int id4 = view.getId();
                                auVar12 = this.cJR.cJP;
                                if (id4 == auVar12.Vv().getId()) {
                                    TiebaStatic.log(lVar.We());
                                    return;
                                }
                            }
                            auVar7 = this.cJR.cJP;
                            if (auVar7.bgF != null) {
                                auVar10 = this.cJR.cJP;
                                if (auVar10.bgF.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    auVar11 = this.cJR.cJP;
                                    if (id5 == auVar11.bgF.getBarNameTv().getId()) {
                                        TiebaStatic.log(lVar.Wd());
                                        return;
                                    }
                                }
                            }
                            if (!(view instanceof TbImageView)) {
                                auVar8 = this.cJR.cJP;
                                if (auVar8.Vu() != null) {
                                    int id6 = view.getId();
                                    auVar9 = this.cJR.cJP;
                                    if (id6 == auVar9.Vu().getId()) {
                                        TiebaStatic.log(lVar.iS("c10760"));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            TiebaStatic.log(lVar.Wf());
                            return;
                        }
                        TiebaStatic.log(lVar.Wc());
                    }
                }
            }
        }
    }
}
