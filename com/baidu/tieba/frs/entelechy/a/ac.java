package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends bx<be> {
    final /* synthetic */ ab bLs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.bLs = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, be beVar) {
        bx bxVar;
        bx bxVar2;
        if (view != null && beVar != null) {
            if (view.getId() == u.g.card_home_page_normal_thread_user_header || view.getId() == u.g.user_name) {
                com.baidu.tieba.frs.h.b.aam().a(ab.bSh, beVar, 2);
            } else if (view instanceof TbImageView) {
                bxVar = this.bLs.bLl;
                if (bxVar.aVK instanceof Boolean) {
                    bxVar2 = this.bLs.bLl;
                    if (((Boolean) bxVar2.aVK).booleanValue()) {
                        com.baidu.tieba.frs.h.b.aam().a(ab.bSh, beVar, 1);
                    } else {
                        com.baidu.tieba.frs.h.b.aam().a(ab.bSh, beVar, 3);
                    }
                }
            } else if (view.getId() == u.g.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.h.b.aam().a(ab.bSh, beVar, 5);
            } else {
                com.baidu.tieba.frs.h.b.aam().a(ab.bSh, beVar, 1);
            }
        }
    }
}
