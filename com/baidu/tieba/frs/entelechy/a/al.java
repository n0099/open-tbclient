package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends cf<bi> {
    final /* synthetic */ ak bSS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.bSS = akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bi biVar) {
        if (view != null && biVar != null) {
            if (view.getId() == w.h.layout_root) {
                com.baidu.tieba.frs.e.b.adp().a(ak.bYW, biVar, 1);
            } else if (view.getId() == w.h.image_user) {
                com.baidu.tieba.frs.e.b.adp().a(ak.bYW, biVar, 2);
            } else if (view.getId() == w.h.header_divider) {
                com.baidu.tieba.frs.f.s.a(ak.bYW, biVar.sM());
            }
        }
    }
}
