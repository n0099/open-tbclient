package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends cf<bh> {
    final /* synthetic */ z bLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.bLR = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bh bhVar) {
        cf cfVar;
        cf cfVar2;
        if (view != null && bhVar != null) {
            if (view.getId() == r.h.card_home_page_normal_thread_user_header || view.getId() == r.h.user_name) {
                com.baidu.tieba.frs.e.b.acx().a(z.bTj, bhVar, 2);
            } else if (view.getId() == r.h.card_divider_tv) {
                com.baidu.tieba.frs.utils.s.a(z.bTj, bhVar.rU());
            } else if (view instanceof TbImageView) {
                cfVar = this.bLR.aUz;
                if (cfVar.aJK instanceof Boolean) {
                    cfVar2 = this.bLR.aUz;
                    if (((Boolean) cfVar2.aJK).booleanValue()) {
                        com.baidu.tieba.frs.e.b.acx().a(z.bTj, bhVar, 1);
                    } else {
                        com.baidu.tieba.frs.e.b.acx().a(z.bTj, bhVar, 3);
                    }
                }
            } else if (view.getId() == r.h.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.e.b.acx().a(z.bTj, bhVar, 5);
            } else {
                com.baidu.tieba.frs.e.b.acx().a(z.bTj, bhVar, 1);
            }
        }
    }
}
