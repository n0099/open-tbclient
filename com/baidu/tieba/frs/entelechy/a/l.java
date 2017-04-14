package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends cf<bi> {
    final /* synthetic */ k bSi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bSi = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bi biVar) {
        if (view != null && biVar != null) {
            if (view.getId() == w.h.card_vote_header_image) {
                com.baidu.tieba.frs.e.b.adp().a(k.bYW, biVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.f.s.a(k.bYW, biVar.sM());
            } else {
                com.baidu.tieba.frs.e.b.adp().a(k.bYW, biVar, 1);
            }
        }
    }
}
