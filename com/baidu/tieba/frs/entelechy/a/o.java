package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends bz<bk> {
    final /* synthetic */ n bZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bZB = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, bk bkVar) {
        if (view != null && bkVar != null) {
            if (view.getId() != r.g.frame_video) {
                if (view.getId() != r.g.layout_root) {
                    if (view.getId() != r.g.image_user && view.getId() != r.g.user_name && view.getId() != r.g.pendant_image_user) {
                        return;
                    }
                    this.bZB.a(bkVar, "c10241");
                    return;
                }
                this.bZB.a(bkVar, "c10242");
                return;
            }
            this.bZB.a(bkVar, "c11718");
        }
    }
}
