package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends ci<bl> {
    final /* synthetic */ p bYC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bYC = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bl blVar) {
        if (view != null && blVar != null) {
            if (view.getId() == w.h.frame_video) {
                com.baidu.tieba.frs.d.b.adw().a(p.cfm, blVar, 4);
            } else if (view.getId() == w.h.layout_root) {
                com.baidu.tieba.frs.d.b.adw().a(p.cfm, blVar, 1);
            } else if (view.getId() == w.h.image_user) {
                com.baidu.tieba.frs.d.b.adw().a(p.cfm, blVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.e.o.a(p.cfm, blVar.rS());
            }
        }
    }
}
