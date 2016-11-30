package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.frs.entelechy.view.s;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends bz<bk> {
    final /* synthetic */ x bZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.bZM = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, bk bkVar) {
        s sVar;
        s sVar2;
        bz bzVar;
        bz bzVar2;
        sVar = this.bZM.bZK;
        if (sVar != null && view != null && bkVar != null) {
            if (view.getId() == r.g.card_home_page_normal_thread_user_header || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.h.b.agV().a(x.chm, bkVar, 2);
            } else if (view instanceof TbImageView) {
                bzVar = this.bZM.bZL;
                if (bzVar.beK instanceof Boolean) {
                    bzVar2 = this.bZM.bZL;
                    if (((Boolean) bzVar2.beK).booleanValue()) {
                        com.baidu.tieba.frs.h.b.agV().a(x.chm, bkVar, 1);
                    } else {
                        com.baidu.tieba.frs.h.b.agV().a(x.chm, bkVar, 3);
                    }
                }
                TiebaStatic.log(new av("c11004").ab("tid", bkVar.getTid()));
            } else {
                int id = view.getId();
                sVar2 = this.bZM.bZK;
                if (id == sVar2.bbT.getId()) {
                    TiebaStatic.log(new av("c10803").s("obj_locate", 7).ab("tid", bkVar.getTid()));
                } else if (view.getId() == r.g.card_home_page_normal_thread_abstract_voice) {
                    com.baidu.tieba.frs.h.b.agV().a(x.chm, bkVar, 5);
                } else {
                    com.baidu.tieba.frs.h.b.agV().a(x.chm, bkVar, 1);
                    TiebaStatic.log(new av("c11004").ab("tid", bkVar.getTid()));
                    TiebaStatic.log(new av("c10806").s("obj_locate", 1).ab("tid", bkVar.getId()));
                }
            }
        }
    }
}
