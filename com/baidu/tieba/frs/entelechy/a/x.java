package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends cf<bi> {
    final /* synthetic */ w bUY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bUY = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bi biVar) {
        if (view != null && biVar != null) {
            if (view.getId() != w.h.frame_video) {
                if (view.getId() != w.h.layout_root) {
                    if (view.getId() != w.h.image_user && view.getId() != w.h.pendant_image_user) {
                        if (view.getId() == w.h.card_divider_tv) {
                            com.baidu.tieba.frs.f.s.a(w.cbn, biVar.sM());
                            return;
                        }
                        return;
                    }
                    this.bUY.a(biVar, "c10241");
                    return;
                }
                this.bUY.a(biVar, "c10242");
                return;
            }
            this.bUY.a(biVar, "c11718");
        }
    }
}
