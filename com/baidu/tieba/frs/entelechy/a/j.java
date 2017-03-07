package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends cf<bj> {
    final /* synthetic */ i bSs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bSs = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bj bjVar) {
        com.baidu.tieba.frs.entelechy.view.am amVar;
        com.baidu.tieba.frs.entelechy.view.am amVar2;
        com.baidu.tieba.frs.entelechy.view.am amVar3;
        if (view != null) {
            amVar = this.bSs.bSq;
            if (amVar != null) {
                amVar2 = this.bSs.bSq;
                if (amVar2.getView() != null) {
                    amVar3 = this.bSs.bSq;
                    if (amVar3.bTR != null && bjVar != null && !StringUtils.isNull(bjVar.getTid())) {
                        if (view.getId() == w.h.card_root_view) {
                            com.baidu.tieba.frs.e.b.adv().a(i.cav, bjVar, 1);
                        } else if (view.getId() == w.h.avatar || view.getId() == w.h.user_name) {
                            com.baidu.tieba.frs.e.b.adv().a(i.cav, bjVar, 2);
                        } else if (view.getId() == w.h.card_divider_tv) {
                            com.baidu.tieba.frs.utils.s.a(i.cav, bjVar.so());
                        }
                    }
                }
            }
        }
    }
}
