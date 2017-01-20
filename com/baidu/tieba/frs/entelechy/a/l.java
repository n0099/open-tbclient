package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends cf<bh> {
    final /* synthetic */ k bLo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bLo = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bh bhVar) {
        if (view != null && bhVar != null) {
            if (view.getId() == r.h.card_vote_header_image || view.getId() == r.h.user_name) {
                com.baidu.tieba.frs.e.b.acx().a(k.bTj, bhVar, 2);
            } else if (view.getId() == r.h.card_divider_tv) {
                com.baidu.tieba.frs.utils.s.a(k.bTj, bhVar.rU());
            } else {
                com.baidu.tieba.frs.e.b.acx().a(k.bTj, bhVar, 1);
            }
        }
    }
}
