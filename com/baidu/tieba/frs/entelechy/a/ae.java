package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends bz<bk> {
    final /* synthetic */ ad bZT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.bZT = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, bk bkVar) {
        bz bzVar;
        bz bzVar2;
        if (view != null && bkVar != null) {
            if (view.getId() == r.g.card_home_page_normal_thread_user_header || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.h.b.agV().a(ad.chm, bkVar, 2);
            } else if (view instanceof TbImageView) {
                bzVar = this.bZT.bZL;
                if (bzVar.beK instanceof Boolean) {
                    bzVar2 = this.bZT.bZL;
                    if (((Boolean) bzVar2.beK).booleanValue()) {
                        com.baidu.tieba.frs.h.b.agV().a(ad.chm, bkVar, 1);
                    } else {
                        com.baidu.tieba.frs.h.b.agV().a(ad.chm, bkVar, 3);
                    }
                }
            } else if (view.getId() == r.g.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.h.b.agV().a(ad.chm, bkVar, 5);
            } else {
                com.baidu.tieba.frs.h.b.agV().a(ad.chm, bkVar, 1);
            }
        }
    }
}
