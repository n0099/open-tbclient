package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cd<bk> {
    final /* synthetic */ o bSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bSL = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bk bkVar) {
        com.baidu.tieba.frs.entelechy.view.q qVar;
        com.baidu.tieba.frs.entelechy.view.q qVar2;
        cd cdVar;
        cd cdVar2;
        qVar = this.bSL.bSI;
        if (qVar != null && view != null && bkVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_header) {
                com.baidu.tieba.frs.c.b.acs().a(o.bZb, bkVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.d.o.a(o.bZb, bkVar.rW());
            } else if (view instanceof TbImageView) {
                cdVar = this.bSL.bbX;
                if (cdVar.aQe instanceof Boolean) {
                    cdVar2 = this.bSL.bbX;
                    if (((Boolean) cdVar2.aQe).booleanValue()) {
                        com.baidu.tieba.frs.c.b.acs().a(o.bZb, bkVar, 1);
                    } else {
                        com.baidu.tieba.frs.c.b.acs().a(o.bZb, bkVar, 3);
                    }
                }
                TiebaStatic.log(new as("c11004").aa("tid", bkVar.getTid()));
            } else {
                int id = view.getId();
                qVar2 = this.bSL.bSI;
                if (id == qVar2.bvt.getId()) {
                    TiebaStatic.log(new as("c10803").s("obj_locate", 7).aa("tid", bkVar.getTid()));
                } else if (view.getId() == w.h.card_home_page_normal_thread_abstract_voice) {
                    com.baidu.tieba.frs.c.b.acs().a(o.bZb, bkVar, 5);
                } else {
                    com.baidu.tieba.frs.c.b.acs().a(o.bZb, bkVar, 1);
                    TiebaStatic.log(new as("c11004").aa("tid", bkVar.getTid()));
                    TiebaStatic.log(new as("c10806").s("obj_locate", 1).aa("tid", bkVar.getId()));
                }
            }
        }
    }
}
