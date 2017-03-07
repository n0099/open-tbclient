package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends cf<bj> {
    final /* synthetic */ k bSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bSu = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bj bjVar) {
        if (view != null && bjVar != null) {
            if (view.getId() == w.h.card_vote_header_image || view.getId() == w.h.user_name) {
                com.baidu.tieba.frs.e.b.adv().a(k.cav, bjVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.utils.s.a(k.cav, bjVar.so());
            } else {
                com.baidu.tieba.frs.e.b.adv().a(k.cav, bjVar, 1);
            }
        }
    }
}
