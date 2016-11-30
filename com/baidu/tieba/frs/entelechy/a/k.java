package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends bz<bk> {
    final /* synthetic */ j bZi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bZi = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, bk bkVar) {
        if (view != null && bkVar != null) {
            if (view.getId() == r.g.card_vote_header_image || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.h.b.agV().a(j.chm, bkVar, 2);
            } else {
                com.baidu.tieba.frs.h.b.agV().a(j.chm, bkVar, 1);
            }
        }
    }
}
