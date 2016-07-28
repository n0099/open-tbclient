package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends bx<be> {
    final /* synthetic */ k bKO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bKO = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, be beVar) {
        if (view != null && beVar != null) {
            if (view.getId() == u.g.card_vote_header_image || view.getId() == u.g.user_name) {
                com.baidu.tieba.frs.h.b.aam().a(k.bSh, beVar, 2);
            } else {
                com.baidu.tieba.frs.h.b.aam().a(k.bSh, beVar, 1);
            }
        }
    }
}
