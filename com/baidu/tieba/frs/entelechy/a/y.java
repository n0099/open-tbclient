package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends cf<bg> {
    final /* synthetic */ x bWz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bWz = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bg bgVar) {
        if (view != null && bgVar != null) {
            if (view.getId() == t.g.frame_video) {
                com.baidu.tieba.frs.g.b.aeX().a(x.cdn, bgVar, 4);
            } else if (view.getId() == t.g.layout_root) {
                com.baidu.tieba.frs.g.b.aeX().a(x.cdn, bgVar, 1);
            } else if (view.getId() == t.g.image_user || view.getId() == t.g.user_name) {
                com.baidu.tieba.frs.g.b.aeX().a(x.cdn, bgVar, 2);
            }
        }
    }
}
