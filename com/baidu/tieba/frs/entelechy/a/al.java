package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends cd<bk> {
    final /* synthetic */ ak bTd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.bTd = akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bk bkVar) {
        if (view != null && bkVar != null) {
            if (view.getId() == w.h.layout_root) {
                com.baidu.tieba.frs.c.b.acs().a(ak.bZb, bkVar, 1);
            } else if (view.getId() == w.h.image_user) {
                com.baidu.tieba.frs.c.b.acs().a(ak.bZb, bkVar, 2);
            } else if (view.getId() == w.h.header_divider) {
                com.baidu.tieba.frs.d.o.a(ak.bZb, bkVar.rW());
            }
        }
    }
}
