package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends cf<bi> {
    final /* synthetic */ z bVc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.bVc = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bi biVar) {
        cf cfVar;
        cf cfVar2;
        if (view != null && biVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_header) {
                com.baidu.tieba.frs.e.b.aeq().a(z.cbn, biVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.f.s.a(z.cbn, biVar.sM());
            } else if (view instanceof TbImageView) {
                cfVar = this.bVc.bbB;
                if (cfVar.aPL instanceof Boolean) {
                    cfVar2 = this.bVc.bbB;
                    if (((Boolean) cfVar2.aPL).booleanValue()) {
                        com.baidu.tieba.frs.e.b.aeq().a(z.cbn, biVar, 1);
                    } else {
                        com.baidu.tieba.frs.e.b.aeq().a(z.cbn, biVar, 3);
                    }
                }
            } else if (view.getId() == w.h.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.e.b.aeq().a(z.cbn, biVar, 5);
            } else {
                com.baidu.tieba.frs.e.b.aeq().a(z.cbn, biVar, 1);
            }
        }
    }
}
