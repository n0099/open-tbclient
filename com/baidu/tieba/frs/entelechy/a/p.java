package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cf<bj> {
    final /* synthetic */ o bSM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bSM = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bj bjVar) {
        com.baidu.tieba.frs.entelechy.view.t tVar;
        com.baidu.tieba.frs.entelechy.view.t tVar2;
        cf cfVar;
        cf cfVar2;
        tVar = this.bSM.bSJ;
        if (tVar != null && view != null && bjVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_header || view.getId() == w.h.user_name) {
                com.baidu.tieba.frs.e.b.adv().a(o.cav, bjVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.utils.s.a(o.cav, bjVar.so());
            } else if (view instanceof TbImageView) {
                cfVar = this.bSM.baM;
                if (cfVar.aPt instanceof Boolean) {
                    cfVar2 = this.bSM.baM;
                    if (((Boolean) cfVar2.aPt).booleanValue()) {
                        com.baidu.tieba.frs.e.b.adv().a(o.cav, bjVar, 1);
                    } else {
                        com.baidu.tieba.frs.e.b.adv().a(o.cav, bjVar, 3);
                    }
                }
                TiebaStatic.log(new as("c11004").Z("tid", bjVar.getTid()));
            } else {
                int id = view.getId();
                tVar2 = this.bSM.bSJ;
                if (id == tVar2.brE.getId()) {
                    TiebaStatic.log(new as("c10803").s("obj_locate", 7).Z("tid", bjVar.getTid()));
                } else if (view.getId() == w.h.card_home_page_normal_thread_abstract_voice) {
                    com.baidu.tieba.frs.e.b.adv().a(o.cav, bjVar, 5);
                } else {
                    com.baidu.tieba.frs.e.b.adv().a(o.cav, bjVar, 1);
                    TiebaStatic.log(new as("c11004").Z("tid", bjVar.getTid()));
                    TiebaStatic.log(new as("c10806").s("obj_locate", 1).Z("tid", bjVar.getId()));
                }
            }
        }
    }
}
