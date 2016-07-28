package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends bx<be> {
    final /* synthetic */ i bKL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bKL = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, be beVar) {
        com.baidu.tieba.frs.entelechy.view.ae aeVar;
        com.baidu.tieba.frs.entelechy.view.ae aeVar2;
        com.baidu.tieba.frs.entelechy.view.ae aeVar3;
        if (view != null) {
            aeVar = this.bKL.bKJ;
            if (aeVar != null) {
                aeVar2 = this.bKL.bKJ;
                if (aeVar2.getView() != null) {
                    aeVar3 = this.bKL.bKJ;
                    if (aeVar3.bMd != null && beVar != null && !StringUtils.isNull(beVar.getTid())) {
                        if (view.getId() == u.g.card_root_view) {
                            com.baidu.tieba.frs.h.b.aam().a(i.bSh, beVar, 1);
                        } else if (view.getId() == u.g.avatar || view.getId() == u.g.user_name) {
                            com.baidu.tieba.frs.h.b.aam().a(i.bSh, beVar, 2);
                        }
                    }
                }
            }
        }
    }
}
