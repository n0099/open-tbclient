package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends cf<bj> {
    final /* synthetic */ s bSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.bSN = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bj bjVar) {
        if (view != null && bjVar != null) {
            if (view.getId() == w.h.frame_video) {
                com.baidu.tieba.frs.e.b.adv().a(s.cav, bjVar, 4);
            } else if (view.getId() == w.h.layout_root) {
                com.baidu.tieba.frs.e.b.adv().a(s.cav, bjVar, 1);
            } else if (view.getId() == w.h.image_user || view.getId() == w.h.user_name) {
                com.baidu.tieba.frs.e.b.adv().a(s.cav, bjVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.utils.s.a(s.cav, bjVar.so());
            }
        }
    }
}
