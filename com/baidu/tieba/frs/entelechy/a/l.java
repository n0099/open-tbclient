package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends cd<bk> {
    final /* synthetic */ k bSt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bSt = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bk bkVar) {
        if (view != null && bkVar != null) {
            if (view.getId() == w.h.card_vote_header_image) {
                com.baidu.tieba.frs.c.b.acs().a(k.bZb, bkVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.d.o.a(k.bZb, bkVar.rW());
            } else {
                com.baidu.tieba.frs.c.b.acs().a(k.bZb, bkVar, 1);
            }
        }
    }
}
