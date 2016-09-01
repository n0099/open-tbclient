package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends cf<bg> {
    final /* synthetic */ ad bWF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.bWF = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bg bgVar) {
        if (view != null && bgVar != null) {
            if (view.getId() == t.g.frame_video) {
                com.baidu.tieba.frs.g.b.aeX().a(ad.cdn, bgVar, 4);
            } else if (view.getId() == t.g.layout_root) {
                com.baidu.tieba.frs.g.b.aeX().a(ad.cdn, bgVar, 1);
            } else if (view.getId() == t.g.image_user || view.getId() == t.g.user_name) {
                com.baidu.tieba.frs.g.b.aeX().a(ad.cdn, bgVar, 2);
            }
        }
    }
}
