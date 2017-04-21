package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cf<bi> {
    final /* synthetic */ o bUR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bUR = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bi biVar) {
        com.baidu.tieba.frs.entelechy.view.t tVar;
        com.baidu.tieba.frs.entelechy.view.t tVar2;
        cf cfVar;
        cf cfVar2;
        tVar = this.bUR.bUO;
        if (tVar != null && view != null && biVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_header) {
                com.baidu.tieba.frs.e.b.aeq().a(o.cbn, biVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.f.s.a(o.cbn, biVar.sM());
            } else if (view instanceof TbImageView) {
                cfVar = this.bUR.bbB;
                if (cfVar.aPL instanceof Boolean) {
                    cfVar2 = this.bUR.bbB;
                    if (((Boolean) cfVar2.aPL).booleanValue()) {
                        com.baidu.tieba.frs.e.b.aeq().a(o.cbn, biVar, 1);
                    } else {
                        com.baidu.tieba.frs.e.b.aeq().a(o.cbn, biVar, 3);
                    }
                }
                TiebaStatic.log(new as("c11004").aa("tid", biVar.getTid()));
            } else {
                int id = view.getId();
                tVar2 = this.bUR.bUO;
                if (id == tVar2.btO.getId()) {
                    TiebaStatic.log(new as("c10803").s("obj_locate", 7).aa("tid", biVar.getTid()));
                } else if (view.getId() == w.h.card_home_page_normal_thread_abstract_voice) {
                    com.baidu.tieba.frs.e.b.aeq().a(o.cbn, biVar, 5);
                } else {
                    com.baidu.tieba.frs.e.b.aeq().a(o.cbn, biVar, 1);
                    TiebaStatic.log(new as("c11004").aa("tid", biVar.getTid()));
                    TiebaStatic.log(new as("c10806").s("obj_locate", 1).aa("tid", biVar.getId()));
                }
            }
        }
    }
}
