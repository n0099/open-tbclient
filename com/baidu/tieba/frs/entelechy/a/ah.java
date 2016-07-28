package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends bx<be> {
    final /* synthetic */ ag bLv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.bLv = agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, be beVar) {
        if (view != null && beVar != null) {
            if (view.getId() == u.g.frame_video) {
                com.baidu.tieba.frs.h.b.aam().a(ag.bSh, beVar, 4);
            } else if (view.getId() == u.g.layout_root) {
                com.baidu.tieba.frs.h.b.aam().a(ag.bSh, beVar, 1);
            } else if (view.getId() == u.g.image_user || view.getId() == u.g.user_name) {
                com.baidu.tieba.frs.h.b.aam().a(ag.bSh, beVar, 2);
            }
        }
    }
}
