package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends cf<bj> {
    final /* synthetic */ ak bTe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.bTe = akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bj bjVar) {
        if (view != null && bjVar != null) {
            if (view.getId() == w.h.layout_root) {
                com.baidu.tieba.frs.e.b.adv().a(ak.cav, bjVar, 1);
            } else if (view.getId() == w.h.image_user || view.getId() == w.h.user_name) {
                com.baidu.tieba.frs.e.b.adv().a(ak.cav, bjVar, 2);
            } else if (view.getId() == w.h.header_divider) {
                com.baidu.tieba.frs.utils.s.a(ak.cav, bjVar.so());
            }
        }
    }
}
