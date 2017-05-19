package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends cd<bk> {
    final /* synthetic */ w bSS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bSS = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bk bkVar) {
        if (view != null && bkVar != null) {
            if (view.getId() != w.h.frame_video) {
                if (view.getId() != w.h.layout_root) {
                    if (view.getId() != w.h.image_user && view.getId() != w.h.pendant_image_user) {
                        if (view.getId() == w.h.card_divider_tv) {
                            com.baidu.tieba.frs.d.o.a(w.bZb, bkVar.rW());
                            return;
                        }
                        return;
                    }
                    this.bSS.a(bkVar, "c10241");
                    return;
                }
                this.bSS.a(bkVar, "c10242");
                return;
            }
            this.bSS.a(bkVar, "c11718");
        }
    }
}
