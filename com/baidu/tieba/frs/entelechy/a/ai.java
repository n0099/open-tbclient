package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends bz<bk> {
    final /* synthetic */ ah bZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.bZW = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, bk bkVar) {
        if (view != null && bkVar != null) {
            if (view.getId() == r.g.frame_video) {
                com.baidu.tieba.frs.h.b.agV().a(ah.chm, bkVar, 4);
            } else if (view.getId() == r.g.layout_root) {
                com.baidu.tieba.frs.h.b.agV().a(ah.chm, bkVar, 1);
            } else if (view.getId() == r.g.image_user || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.h.b.agV().a(ah.chm, bkVar, 2);
            }
        }
    }
}
