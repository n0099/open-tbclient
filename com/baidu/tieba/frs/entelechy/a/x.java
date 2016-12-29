package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends cb<bg> {
    final /* synthetic */ w bFv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bFv = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
    public void a(View view, bg bgVar) {
        if (view != null && bgVar != null) {
            if (view.getId() != r.g.frame_video) {
                if (view.getId() != r.g.layout_root) {
                    if (view.getId() != r.g.image_user && view.getId() != r.g.user_name && view.getId() != r.g.pendant_image_user) {
                        if (view.getId() == r.g.card_divider_tv) {
                            com.baidu.tieba.frs.utils.s.a(w.bMV, bgVar.sc());
                            return;
                        }
                        return;
                    }
                    this.bFv.a(bgVar, "c10241");
                    return;
                }
                this.bFv.a(bgVar, "c10242");
                return;
            }
            this.bFv.a(bgVar, "c11718");
        }
    }
}
