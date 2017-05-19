package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends cd<bk> {
    final /* synthetic */ s bSM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.bSM = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bk bkVar) {
        if (view != null && bkVar != null) {
            if (view.getId() == w.h.frame_video) {
                com.baidu.tieba.frs.c.b.acs().a(s.bZb, bkVar, 4);
            } else if (view.getId() == w.h.layout_root) {
                com.baidu.tieba.frs.c.b.acs().a(s.bZb, bkVar, 1);
            } else if (view.getId() == w.h.image_user) {
                com.baidu.tieba.frs.c.b.acs().a(s.bZb, bkVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.d.o.a(s.bZb, bkVar.rW());
            }
        }
    }
}
