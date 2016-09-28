package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.be;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends cd<com.baidu.tieba.card.data.n> {
    final /* synthetic */ c cGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cGo = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
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
        cb.Oj().cr(true);
        if (view != null) {
            beVar = this.cGo.cGn;
            if (beVar != null) {
                beVar2 = this.cGo.cGn;
                if (beVar2.getView() != null) {
                    beVar3 = this.cGo.cGn;
                    if (beVar3.baz != null && nVar != null && nVar.Jv() != null && !StringUtils.isNull(nVar.Jv().getTid())) {
                        int id = view.getId();
                        beVar4 = this.cGo.cGn;
                        if (id != beVar4.getView().getId()) {
                            beVar5 = this.cGo.cGn;
                            if (beVar5.baz.baI != null) {
                                beVar11 = this.cGo.cGn;
                                if (beVar11.baz.baI.getBarNameTv() != null) {
                                    int id2 = view.getId();
                                    beVar12 = this.cGo.cGn;
                                    if (id2 == beVar12.baz.baI.getBarNameTv().getId()) {
                                        TiebaStatic.log(nVar.OJ());
                                        return;
                                    }
                                }
                            }
                            beVar6 = this.cGo.cGn;
                            if (beVar6.baz.aZw != null) {
                                int id3 = view.getId();
                                beVar10 = this.cGo.cGn;
                                if (id3 == beVar10.baz.aZw.getId()) {
                                    TiebaStatic.log(nVar.OK());
                                    return;
                                }
                            }
                            beVar7 = this.cGo.cGn;
                            if (beVar7.baz.bak != null) {
                                beVar8 = this.cGo.cGn;
                                if (beVar8.baz.bak.ahv != null) {
                                    beVar9 = this.cGo.cGn;
                                    if (beVar9.baz.bak.ahv.getId() == view.getId()) {
                                        TiebaStatic.log(nVar.OK());
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        TiebaStatic.log(nVar.OH());
                    }
                }
            }
        }
    }
}
