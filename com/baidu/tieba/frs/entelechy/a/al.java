package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends cf<bh> {
    final /* synthetic */ ak bLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.bLY = akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bh bhVar) {
        if (view != null && bhVar != null) {
            if (view.getId() == r.h.layout_root) {
                com.baidu.tieba.frs.e.b.acx().a(ak.bTj, bhVar, 1);
            } else if (view.getId() == r.h.image_user || view.getId() == r.h.user_name) {
                com.baidu.tieba.frs.e.b.acx().a(ak.bTj, bhVar, 2);
            } else if (view.getId() == r.h.header_divider) {
                com.baidu.tieba.frs.utils.s.a(ak.bTj, bhVar.rU());
            }
        }
    }
}
