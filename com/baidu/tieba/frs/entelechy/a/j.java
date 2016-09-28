package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends cd<bi> {
    final /* synthetic */ i bVX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bVX = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bi biVar) {
        if (view != null && biVar != null) {
            if (view.getId() == r.g.card_vote_header_image || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.g.b.afl().a(i.cdl, biVar, 2);
            } else {
                com.baidu.tieba.frs.g.b.afl().a(i.cdl, biVar, 1);
            }
        }
    }
}
