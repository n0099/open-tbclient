package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends ci<bm> {
    final /* synthetic */ aj che;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.che = ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bm bmVar) {
        if (view != null && bmVar != null) {
            if (view.getId() == w.h.layout_root) {
                com.baidu.tieba.frs.d.b.aho().a(aj.cnC, bmVar, 1);
                TiebaStatic.log(new au("c12126").Z("tid", bmVar.getId()).r("obj_locate", this.che.adJ() ? 2 : 1).f("obj_id", bmVar.rJ() == null ? -1L : bmVar.rJ().live_id).r("obj_type", 1));
            } else if (view.getId() == w.h.card_home_page_normal_thread_user_name || view.getId() == w.h.card_home_page_normal_thread_user_header) {
                com.baidu.tieba.frs.d.b.aho().a(aj.cnC, bmVar, 2);
            } else if (view.getId() == w.h.header_divider) {
                com.baidu.tieba.frs.e.o.a(aj.cnC, bmVar.rP());
            } else if (view.getId() == w.h.frame_video) {
                com.baidu.tieba.frs.d.b.aho().a(aj.cnC, bmVar, 4);
            }
        }
    }
}
