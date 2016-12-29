package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.aq;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.homepage.personalize.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends cb<com.baidu.tieba.card.data.m> {
    final /* synthetic */ k cqZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.cqZ = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        aq aqVar;
        aq aqVar2;
        com.baidu.tieba.homepage.personalize.c.f fVar;
        aq aqVar3;
        aq aqVar4;
        aq aqVar5;
        aq aqVar6;
        aq aqVar7;
        aq aqVar8;
        aq aqVar9;
        aq aqVar10;
        aq aqVar11;
        aq aqVar12;
        aq aqVar13;
        com.baidu.tieba.homepage.personalize.c.f fVar2;
        bz.OH().cy(true);
        if (view != null) {
            aqVar = this.cqZ.cqW;
            if (aqVar != null) {
                aqVar2 = this.cqZ.cqW;
                if (aqVar2.getView() != null) {
                    fVar = this.cqZ.cqX;
                    if (fVar != null && mVar != null && mVar.IU() != null && !StringUtils.isNull(mVar.IU().getTid())) {
                        if ((view.getTag() instanceof String) && !ai.bv(com.baidu.adp.lib.h.b.c(mVar.IU().getTid(), 0L))) {
                            ai.bu(com.baidu.adp.lib.h.b.c(mVar.IU().getTid(), 0L));
                            fVar2 = this.cqZ.cqX;
                            fVar2.a(com.baidu.adp.lib.h.b.c(mVar.IU().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.OJ(), mVar.OL(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
                        }
                        int id = view.getId();
                        aqVar3 = this.cqZ.cqW;
                        if (id != aqVar3.getView().getId()) {
                            aqVar4 = this.cqZ.cqW;
                            if (aqVar4.bcK != null) {
                                int id2 = view.getId();
                                aqVar13 = this.cqZ.cqW;
                                if (id2 == aqVar13.bcK.getId()) {
                                    TiebaStatic.log(mVar.Pe());
                                    return;
                                }
                            }
                            aqVar5 = this.cqZ.cqW;
                            if (aqVar5.bcJ != null) {
                                int id3 = view.getId();
                                aqVar12 = this.cqZ.cqW;
                                if (id3 == aqVar12.bcJ.getId()) {
                                    TiebaStatic.log(mVar.Pc());
                                    return;
                                }
                            }
                            aqVar6 = this.cqZ.cqW;
                            if (aqVar6.bcM != null) {
                                aqVar10 = this.cqZ.cqW;
                                if (aqVar10.bcM.ahw != null) {
                                    int id4 = view.getId();
                                    aqVar11 = this.cqZ.cqW;
                                    if (id4 == aqVar11.bcM.ahw.getId()) {
                                        TiebaStatic.log(mVar.Pc());
                                        return;
                                    }
                                }
                            }
                            aqVar7 = this.cqZ.cqW;
                            if (aqVar7.bbg != null) {
                                aqVar8 = this.cqZ.cqW;
                                if (aqVar8.bbg.getBarNameTv() != null) {
                                    int id5 = view.getId();
                                    aqVar9 = this.cqZ.cqW;
                                    if (id5 == aqVar9.bbg.getBarNameTv().getId()) {
                                        TiebaStatic.log(mVar.Pb());
                                        return;
                                    }
                                }
                            }
                            if (view instanceof TbImageView) {
                                TiebaStatic.log(mVar.Pd());
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(mVar.Pa());
                    }
                }
            }
        }
    }
}
