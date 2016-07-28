package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.frs.entelechy.view.r;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends bx<be> {
    final /* synthetic */ v bLm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.bLm = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, be beVar) {
        r rVar;
        r rVar2;
        bx bxVar;
        bx bxVar2;
        rVar = this.bLm.bLk;
        if (rVar != null && view != null && beVar != null) {
            if (view.getId() == u.g.card_home_page_normal_thread_user_header || view.getId() == u.g.user_name) {
                com.baidu.tieba.frs.h.b.aam().a(v.bSh, beVar, 2);
            } else if (view instanceof TbImageView) {
                bxVar = this.bLm.bLl;
                if (bxVar.aVK instanceof Boolean) {
                    bxVar2 = this.bLm.bLl;
                    if (((Boolean) bxVar2.aVK).booleanValue()) {
                        com.baidu.tieba.frs.h.b.aam().a(v.bSh, beVar, 1);
                    } else {
                        com.baidu.tieba.frs.h.b.aam().a(v.bSh, beVar, 3);
                    }
                }
                TiebaStatic.log(new ay("c11004").ab("tid", beVar.getTid()));
            } else {
                int id = view.getId();
                rVar2 = this.bLm.bLk;
                if (id == rVar2.aTa.getId()) {
                    TiebaStatic.log(new ay("c10803").s("obj_locate", 7).ab("tid", beVar.getTid()));
                } else if (view.getId() == u.g.card_home_page_normal_thread_abstract_voice) {
                    com.baidu.tieba.frs.h.b.aam().a(v.bSh, beVar, 5);
                } else {
                    com.baidu.tieba.frs.h.b.aam().a(v.bSh, beVar, 1);
                    TiebaStatic.log(new ay("c11004").ab("tid", beVar.getTid()));
                    TiebaStatic.log(new ay("c10806").s("obj_locate", 1).ab("tid", beVar.getId()));
                }
            }
        }
    }
}
