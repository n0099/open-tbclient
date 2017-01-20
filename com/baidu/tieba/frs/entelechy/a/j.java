package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends cf<bh> {
    final /* synthetic */ i bLm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bLm = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bh bhVar) {
        com.baidu.tieba.frs.entelechy.view.am amVar;
        com.baidu.tieba.frs.entelechy.view.am amVar2;
        com.baidu.tieba.frs.entelechy.view.am amVar3;
        if (view != null) {
            amVar = this.bLm.bLk;
            if (amVar != null) {
                amVar2 = this.bLm.bLk;
                if (amVar2.getView() != null) {
                    amVar3 = this.bLm.bLk;
                    if (amVar3.bMJ != null && bhVar != null && !StringUtils.isNull(bhVar.getTid())) {
                        if (view.getId() == r.h.card_root_view) {
                            com.baidu.tieba.frs.e.b.acx().a(i.bTj, bhVar, 1);
                        } else if (view.getId() == r.h.avatar || view.getId() == r.h.user_name) {
                            com.baidu.tieba.frs.e.b.acx().a(i.bTj, bhVar, 2);
                        } else if (view.getId() == r.h.card_divider_tv) {
                            com.baidu.tieba.frs.utils.s.a(i.bTj, bhVar.rU());
                        }
                    }
                }
            }
        }
    }
}
