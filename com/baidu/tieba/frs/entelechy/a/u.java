package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends ci<bm> {
    final /* synthetic */ t cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.cgR = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bm bmVar) {
        if (view != null && bmVar != null) {
            if (view.getId() != w.h.frame_video) {
                if (view.getId() != w.h.layout_root) {
                    if (view.getId() != w.h.image_user && view.getId() != w.h.pendant_image_user) {
                        if (view.getId() == w.h.card_divider_tv) {
                            com.baidu.tieba.frs.e.o.a(t.cnC, bmVar.rP());
                            return;
                        }
                        return;
                    }
                    this.cgR.b(bmVar, "c10241");
                    return;
                }
                this.cgR.b(bmVar, "c10242");
                return;
            }
            this.cgR.b(bmVar, "c11718");
        }
    }
}
