package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cf<bh> {
    final /* synthetic */ o bLG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bLG = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bh bhVar) {
        com.baidu.tieba.frs.entelechy.view.t tVar;
        com.baidu.tieba.frs.entelechy.view.t tVar2;
        cf cfVar;
        cf cfVar2;
        tVar = this.bLG.bLD;
        if (tVar != null && view != null && bhVar != null) {
            if (view.getId() == r.h.card_home_page_normal_thread_user_header || view.getId() == r.h.user_name) {
                com.baidu.tieba.frs.e.b.acx().a(o.bTj, bhVar, 2);
            } else if (view.getId() == r.h.card_divider_tv) {
                com.baidu.tieba.frs.utils.s.a(o.bTj, bhVar.rU());
            } else if (view instanceof TbImageView) {
                cfVar = this.bLG.aUz;
                if (cfVar.aJK instanceof Boolean) {
                    cfVar2 = this.bLG.aUz;
                    if (((Boolean) cfVar2.aJK).booleanValue()) {
                        com.baidu.tieba.frs.e.b.acx().a(o.bTj, bhVar, 1);
                    } else {
                        com.baidu.tieba.frs.e.b.acx().a(o.bTj, bhVar, 3);
                    }
                }
                TiebaStatic.log(new ar("c11004").ab("tid", bhVar.getTid()));
            } else {
                int id = view.getId();
                tVar2 = this.bLG.bLD;
                if (id == tVar2.bkM.getId()) {
                    TiebaStatic.log(new ar("c10803").s("obj_locate", 7).ab("tid", bhVar.getTid()));
                } else if (view.getId() == r.h.card_home_page_normal_thread_abstract_voice) {
                    com.baidu.tieba.frs.e.b.acx().a(o.bTj, bhVar, 5);
                } else {
                    com.baidu.tieba.frs.e.b.acx().a(o.bTj, bhVar, 1);
                    TiebaStatic.log(new ar("c11004").ab("tid", bhVar.getTid()));
                    TiebaStatic.log(new ar("c10806").s("obj_locate", 1).ab("tid", bhVar.getId()));
                }
            }
        }
    }
}
