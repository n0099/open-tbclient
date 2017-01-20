package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends cf<bh> {
    final /* synthetic */ w bLN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bLN = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bh bhVar) {
        if (view != null && bhVar != null) {
            if (view.getId() != r.h.frame_video) {
                if (view.getId() != r.h.layout_root) {
                    if (view.getId() != r.h.image_user && view.getId() != r.h.user_name && view.getId() != r.h.pendant_image_user) {
                        if (view.getId() == r.h.card_divider_tv) {
                            com.baidu.tieba.frs.utils.s.a(w.bTj, bhVar.rU());
                            return;
                        }
                        return;
                    }
                    this.bLN.a(bhVar, "c10241");
                    return;
                }
                this.bLN.a(bhVar, "c10242");
                return;
            }
            this.bLN.a(bhVar, "c11718");
        }
    }
}
