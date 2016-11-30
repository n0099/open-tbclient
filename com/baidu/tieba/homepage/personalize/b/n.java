package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ao;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends bz<com.baidu.tieba.card.data.m> {
    final /* synthetic */ k cLL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.cLL = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        ao aoVar;
        ao aoVar2;
        com.baidu.tieba.homepage.personalize.c.f fVar;
        ao aoVar3;
        ao aoVar4;
        ao aoVar5;
        ao aoVar6;
        ao aoVar7;
        ao aoVar8;
        ao aoVar9;
        ao aoVar10;
        ao aoVar11;
        ao aoVar12;
        ao aoVar13;
        com.baidu.tieba.homepage.personalize.c.f fVar2;
        bx.Pl().cw(true);
        if (view != null) {
            aoVar = this.cLL.cLI;
            if (aoVar != null) {
                aoVar2 = this.cLL.cLI;
                if (aoVar2.getView() != null) {
                    fVar = this.cLL.cLJ;
                    if (fVar != null && mVar != null && mVar.Jz() != null && !StringUtils.isNull(mVar.Jz().getTid())) {
                        if ((view.getTag() instanceof String) && !ai.bH(com.baidu.adp.lib.h.b.c(mVar.Jz().getTid(), 0L))) {
                            ai.bG(com.baidu.adp.lib.h.b.c(mVar.Jz().getTid(), 0L));
                            fVar2 = this.cLL.cLJ;
                            fVar2.a(com.baidu.adp.lib.h.b.c(mVar.Jz().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.Pn(), mVar.Pp(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        aoVar3 = this.cLL.cLI;
                        if (id != aoVar3.getView().getId()) {
                            aoVar4 = this.cLL.cLI;
                            if (aoVar4.bds != null) {
                                int id2 = view.getId();
                                aoVar13 = this.cLL.cLI;
                                if (id2 == aoVar13.bds.getId()) {
                                    TiebaStatic.log(mVar.PI());
                                    return;
                                }
                            }
                            aoVar5 = this.cLL.cLI;
                            if (aoVar5.bdr != null) {
                                int id3 = view.getId();
                                aoVar12 = this.cLL.cLI;
                                if (id3 == aoVar12.bdr.getId()) {
                                    TiebaStatic.log(mVar.PG());
                                    return;
                                }
                            }
                            aoVar6 = this.cLL.cLI;
                            if (aoVar6.bdu != null) {
                                aoVar10 = this.cLL.cLI;
                                if (aoVar10.bdu.ahV != null) {
                                    int id4 = view.getId();
                                    aoVar11 = this.cLL.cLI;
                                    if (id4 == aoVar11.bdu.ahV.getId()) {
                                        TiebaStatic.log(mVar.PG());
                                        return;
                                    }
                                }
                            }
                            aoVar7 = this.cLL.cLI;
                            if (aoVar7.bca != null) {
                                aoVar8 = this.cLL.cLI;
                                if (aoVar8.bca.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    aoVar9 = this.cLL.cLI;
                                    if (id5 == aoVar9.bca.getBarNameTv().getId()) {
                                        TiebaStatic.log(mVar.PF());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(mVar.PH());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(mVar.PE());
                    }
                }
            }
        }
    }
}
