package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends cf<bi> {
    final /* synthetic */ z bSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.bSL = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bi biVar) {
        cf cfVar;
        cf cfVar2;
        if (view != null && biVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_header) {
                com.baidu.tieba.frs.e.b.adp().a(z.bYW, biVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.f.s.a(z.bYW, biVar.sM());
            } else if (view instanceof TbImageView) {
                cfVar = this.bSL.baF;
                if (cfVar.aPJ instanceof Boolean) {
                    cfVar2 = this.bSL.baF;
                    if (((Boolean) cfVar2.aPJ).booleanValue()) {
                        com.baidu.tieba.frs.e.b.adp().a(z.bYW, biVar, 1);
                    } else {
                        com.baidu.tieba.frs.e.b.adp().a(z.bYW, biVar, 3);
                    }
                }
            } else if (view.getId() == w.h.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.e.b.adp().a(z.bYW, biVar, 5);
            } else {
                com.baidu.tieba.frs.e.b.adp().a(z.bYW, biVar, 1);
            }
        }
    }
}
