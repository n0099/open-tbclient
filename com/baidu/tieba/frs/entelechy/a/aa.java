package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends cf<bj> {
    final /* synthetic */ z bSX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.bSX = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bj bjVar) {
        cf cfVar;
        cf cfVar2;
        if (view != null && bjVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_header || view.getId() == w.h.user_name) {
                com.baidu.tieba.frs.e.b.adv().a(z.cav, bjVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.utils.s.a(z.cav, bjVar.so());
            } else if (view instanceof TbImageView) {
                cfVar = this.bSX.baM;
                if (cfVar.aPt instanceof Boolean) {
                    cfVar2 = this.bSX.baM;
                    if (((Boolean) cfVar2.aPt).booleanValue()) {
                        com.baidu.tieba.frs.e.b.adv().a(z.cav, bjVar, 1);
                    } else {
                        com.baidu.tieba.frs.e.b.adv().a(z.cav, bjVar, 3);
                    }
                }
            } else if (view.getId() == w.h.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.e.b.adv().a(z.cav, bjVar, 5);
            } else {
                com.baidu.tieba.frs.e.b.adv().a(z.cav, bjVar, 1);
            }
        }
    }
}
