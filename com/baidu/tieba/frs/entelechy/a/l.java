package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends ci<bl> {
    final /* synthetic */ k bYk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bYk = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bl blVar) {
        if (view != null && blVar != null) {
            if (view.getId() == w.h.card_vote_header_image) {
                com.baidu.tieba.frs.d.b.adw().a(k.cfm, blVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.e.o.a(k.cfm, blVar.rS());
            } else {
                com.baidu.tieba.frs.d.b.adw().a(k.cfm, blVar, 1);
            }
        }
    }
}
