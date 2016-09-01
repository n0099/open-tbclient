package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends cf<bg> {
    final /* synthetic */ i bVY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bVY = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bg bgVar) {
        if (view != null && bgVar != null) {
            if (view.getId() == t.g.card_vote_header_image || view.getId() == t.g.user_name) {
                com.baidu.tieba.frs.g.b.aeX().a(i.cdn, bgVar, 2);
            } else {
                com.baidu.tieba.frs.g.b.aeX().a(i.cdn, bgVar, 1);
            }
        }
    }
}
