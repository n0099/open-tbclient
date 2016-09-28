package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends cd<bi> {
    final /* synthetic */ ad bWF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.bWF = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bi biVar) {
        if (view != null && biVar != null) {
            if (view.getId() == r.g.frame_video) {
                com.baidu.tieba.frs.g.b.afl().a(ad.cdl, biVar, 4);
            } else if (view.getId() == r.g.layout_root) {
                com.baidu.tieba.frs.g.b.afl().a(ad.cdl, biVar, 1);
            } else if (view.getId() == r.g.image_user || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.g.b.afl().a(ad.cdl, biVar, 2);
            }
        }
    }
}
