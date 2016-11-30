package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends bz<bk> {
    final /* synthetic */ h bZf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bZf = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, bk bkVar) {
        com.baidu.tieba.frs.entelechy.view.ag agVar;
        com.baidu.tieba.frs.entelechy.view.ag agVar2;
        com.baidu.tieba.frs.entelechy.view.ag agVar3;
        if (view != null) {
            agVar = this.bZf.bZd;
            if (agVar != null) {
                agVar2 = this.bZf.bZd;
                if (agVar2.getView() != null) {
                    agVar3 = this.bZf.bZd;
                    if (agVar3.caG != null && bkVar != null && !StringUtils.isNull(bkVar.getTid())) {
                        if (view.getId() == r.g.card_root_view) {
                            com.baidu.tieba.frs.h.b.agV().a(h.chm, bkVar, 1);
                        } else if (view.getId() == r.g.avatar || view.getId() == r.g.user_name) {
                            com.baidu.tieba.frs.h.b.agV().a(h.chm, bkVar, 2);
                        }
                    }
                }
            }
        }
    }
}
