package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends ci<bm> {
    final /* synthetic */ k cgt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.cgt = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bm bmVar) {
        if (view != null && bmVar != null) {
            if (view.getId() == w.h.card_vote_header_image) {
                com.baidu.tieba.frs.d.b.aho().a(k.cnC, bmVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.e.o.a(k.cnC, bmVar.rP());
            } else {
                com.baidu.tieba.frs.d.b.aho().a(k.cnC, bmVar, 1);
            }
        }
    }
}
