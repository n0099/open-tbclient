package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends ci<bl> {
    final /* synthetic */ aj bYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(aj ajVar) {
        this.bYV = ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bl blVar) {
        if (view != null && blVar != null) {
            if (view.getId() == w.h.layout_root) {
                com.baidu.tieba.frs.d.b.adw().a(aj.cfm, blVar, 1);
                TiebaStatic.log(new as("c12126").Z("tid", blVar.getId()).r("obj_locate", this.bYV.ZS() ? 2 : 1).f("obj_id", blVar.rM() == null ? -1L : blVar.rM().live_id).r("obj_type", 1));
            } else if (view.getId() == w.h.card_home_page_normal_thread_user_name || view.getId() == w.h.card_home_page_normal_thread_user_header) {
                com.baidu.tieba.frs.d.b.adw().a(aj.cfm, blVar, 2);
            } else if (view.getId() == w.h.header_divider) {
                com.baidu.tieba.frs.e.o.a(aj.cfm, blVar.rS());
            } else if (view.getId() == w.h.frame_video) {
                com.baidu.tieba.frs.d.b.adw().a(aj.cfm, blVar, 4);
            }
        }
    }
}
