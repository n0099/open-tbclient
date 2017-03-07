package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends cf<bj> {
    final /* synthetic */ w bST;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bST = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bj bjVar) {
        if (view != null && bjVar != null) {
            if (view.getId() != w.h.frame_video) {
                if (view.getId() != w.h.layout_root) {
                    if (view.getId() != w.h.image_user && view.getId() != w.h.user_name && view.getId() != w.h.pendant_image_user) {
                        if (view.getId() == w.h.card_divider_tv) {
                            com.baidu.tieba.frs.utils.s.a(w.cav, bjVar.so());
                            return;
                        }
                        return;
                    }
                    this.bST.a(bjVar, "c10241");
                    return;
                }
                this.bST.a(bjVar, "c10242");
                return;
            }
            this.bST.a(bjVar, "c11718");
        }
    }
}
