package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ao;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.homepage.personalize.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends cd<com.baidu.tieba.card.data.m> {
    final /* synthetic */ k cGA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.cGA = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
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
        cb.Oj().cr(true);
        if (view != null) {
            aoVar = this.cGA.cGx;
            if (aoVar != null) {
                aoVar2 = this.cGA.cGx;
                if (aoVar2.getView() != null) {
                    fVar = this.cGA.cGy;
                    if (fVar != null && mVar != null && mVar.Jv() != null && !StringUtils.isNull(mVar.Jv().getTid())) {
                        if ((view.getTag() instanceof String) && !ak.bI(com.baidu.adp.lib.h.b.c(mVar.Jv().getTid(), 0L))) {
                            ak.bH(com.baidu.adp.lib.h.b.c(mVar.Jv().getTid(), 0L));
                            fVar2 = this.cGA.cGy;
                            fVar2.a(com.baidu.adp.lib.h.b.c(mVar.Jv().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.Ok(), mVar.Om(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        aoVar3 = this.cGA.cGx;
                        if (id != aoVar3.getView().getId()) {
                            aoVar4 = this.cGA.cGx;
                            if (aoVar4.baj != null) {
                                int id2 = view.getId();
                                aoVar13 = this.cGA.cGx;
                                if (id2 == aoVar13.baj.getId()) {
                                    TiebaStatic.log(mVar.OF());
                                    return;
                                }
                            }
                            aoVar5 = this.cGA.cGx;
                            if (aoVar5.bai != null) {
                                int id3 = view.getId();
                                aoVar12 = this.cGA.cGx;
                                if (id3 == aoVar12.bai.getId()) {
                                    TiebaStatic.log(mVar.OD());
                                    return;
                                }
                            }
                            aoVar6 = this.cGA.cGx;
                            if (aoVar6.bak != null) {
                                aoVar10 = this.cGA.cGx;
                                if (aoVar10.bak.ahv != null) {
                                    int id4 = view.getId();
                                    aoVar11 = this.cGA.cGx;
                                    if (id4 == aoVar11.bak.ahv.getId()) {
                                        TiebaStatic.log(mVar.OD());
                                        return;
                                    }
                                }
                            }
                            aoVar7 = this.cGA.cGx;
                            if (aoVar7.aYR != null) {
                                aoVar8 = this.cGA.cGx;
                                if (aoVar8.aYR.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    aoVar9 = this.cGA.cGx;
                                    if (id5 == aoVar9.aYR.getBarNameTv().getId()) {
                                        TiebaStatic.log(mVar.OC());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(mVar.OE());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(mVar.OB());
                    }
                }
            }
        }
    }
}
