package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends cf<bi> {
    final /* synthetic */ i bSg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bSg = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bi biVar) {
        com.baidu.tieba.frs.entelechy.view.am amVar;
        com.baidu.tieba.frs.entelechy.view.am amVar2;
        com.baidu.tieba.frs.entelechy.view.am amVar3;
        if (view != null) {
            amVar = this.bSg.bSe;
            if (amVar != null) {
                amVar2 = this.bSg.bSe;
                if (amVar2.getView() != null) {
                    amVar3 = this.bSg.bSe;
                    if (amVar3.bTF != null && biVar != null && !StringUtils.isNull(biVar.getTid())) {
                        if (view.getId() == w.h.card_root_view) {
                            com.baidu.tieba.frs.e.b.adp().a(i.bYW, biVar, 1);
                        } else if (view.getId() == w.h.avatar) {
                            com.baidu.tieba.frs.e.b.adp().a(i.bYW, biVar, 2);
                        } else if (view.getId() == w.h.card_divider_tv) {
                            com.baidu.tieba.frs.f.s.a(i.bYW, biVar.sM());
                        }
                    }
                }
            }
        }
    }
}
