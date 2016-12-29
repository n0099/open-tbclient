package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends cb<bg> {
    final /* synthetic */ ak bFH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.bFH = akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
    public void a(View view, bg bgVar) {
        if (view != null && bgVar != null) {
            if (view.getId() == r.g.frame_video) {
                com.baidu.tieba.frs.g.b.abq().a(ak.bMV, bgVar, 4);
            } else if (view.getId() == r.g.layout_root) {
                com.baidu.tieba.frs.g.b.abq().a(ak.bMV, bgVar, 1);
            } else if (view.getId() == r.g.image_user || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.g.b.abq().a(ak.bMV, bgVar, 2);
            } else if (view.getId() == r.g.header_divider) {
                com.baidu.tieba.frs.utils.s.a(ak.bMV, bgVar.sc());
            }
        }
    }
}
