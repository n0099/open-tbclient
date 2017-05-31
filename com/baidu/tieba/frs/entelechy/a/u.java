package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends ci<bl> {
    final /* synthetic */ t bYI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bYI = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bl blVar) {
        if (view != null && blVar != null) {
            if (view.getId() != w.h.frame_video) {
                if (view.getId() != w.h.layout_root) {
                    if (view.getId() != w.h.image_user && view.getId() != w.h.pendant_image_user) {
                        if (view.getId() == w.h.card_divider_tv) {
                            com.baidu.tieba.frs.e.o.a(t.cfm, blVar.rS());
                            return;
                        }
                        return;
                    }
                    this.bYI.a(blVar, "c10241");
                    return;
                }
                this.bYI.a(blVar, "c10242");
                return;
            }
            this.bYI.a(blVar, "c11718");
        }
    }
}
