package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.bf;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends cd<com.baidu.tieba.card.data.m> {
    final /* synthetic */ b cvo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cvo = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        bf bfVar6;
        bf bfVar7;
        bf bfVar8;
        bf bfVar9;
        bf bfVar10;
        ca.To().db(true);
        if (view != null) {
            bfVar = this.cvo.cvn;
            if (bfVar != null) {
                bfVar2 = this.cvo.cvn;
                if (bfVar2.getView() != null) {
                    bfVar3 = this.cvo.cvn;
                    if (bfVar3.bvW != null && mVar != null && mVar.JB() != null && !StringUtils.isNull(mVar.JB().getTid())) {
                        int id = view.getId();
                        bfVar4 = this.cvo.cvn;
                        if (id != bfVar4.getView().getId()) {
                            bfVar5 = this.cvo.cvn;
                            if (bfVar5.Tn() != null) {
                                int id2 = view.getId();
                                bfVar10 = this.cvo.cvn;
                                if (id2 == bfVar10.Tn().getId()) {
                                    TiebaStatic.log(mVar.TP());
                                    return;
                                }
                            }
                            bfVar6 = this.cvo.cvn;
                            if (bfVar6.getHeaderImg() != null) {
                                int id3 = view.getId();
                                bfVar9 = this.cvo.cvn;
                                if (id3 == bfVar9.getHeaderImg().getId()) {
                                    TiebaStatic.log(mVar.TQ());
                                    return;
                                }
                            }
                            bfVar7 = this.cvo.cvn;
                            if (bfVar7.Tg() != null) {
                                bfVar8 = this.cvo.cvn;
                                if (bfVar8.Tg().getId() == view.getId()) {
                                    TiebaStatic.log(mVar.TQ());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(mVar.TN());
                    }
                }
            }
        }
    }
}
