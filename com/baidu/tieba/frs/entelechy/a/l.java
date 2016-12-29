package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends cb<bg> {
    final /* synthetic */ k bEV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bEV = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
    public void a(View view, bg bgVar) {
        if (view != null && bgVar != null) {
            if (view.getId() == r.g.card_vote_header_image || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.g.b.abq().a(k.bMV, bgVar, 2);
            } else if (view.getId() == r.g.card_divider_tv) {
                com.baidu.tieba.frs.utils.s.a(k.bMV, bgVar.sc());
            } else {
                com.baidu.tieba.frs.g.b.abq().a(k.bMV, bgVar, 1);
            }
        }
    }
}
