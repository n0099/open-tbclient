package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends cb<bg> {
    final /* synthetic */ o bFo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bFo = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
    public void a(View view, bg bgVar) {
        com.baidu.tieba.frs.entelechy.view.t tVar;
        com.baidu.tieba.frs.entelechy.view.t tVar2;
        cb cbVar;
        cb cbVar2;
        tVar = this.bFo.bFk;
        if (tVar != null && view != null && bgVar != null) {
            if (view.getId() == r.g.card_home_page_normal_thread_user_header || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.g.b.abq().a(o.bMV, bgVar, 2);
            } else if (view.getId() == r.g.card_divider_tv) {
                com.baidu.tieba.frs.utils.s.a(o.bMV, bgVar.sc());
            } else if (view instanceof TbImageView) {
                cbVar = this.bFo.bFl;
                if (cbVar.beb instanceof Boolean) {
                    cbVar2 = this.bFo.bFl;
                    if (((Boolean) cbVar2.beb).booleanValue()) {
                        com.baidu.tieba.frs.g.b.abq().a(o.bMV, bgVar, 1);
                    } else {
                        com.baidu.tieba.frs.g.b.abq().a(o.bMV, bgVar, 3);
                    }
                }
                TiebaStatic.log(new at("c11004").ab("tid", bgVar.getTid()));
            } else {
                int id = view.getId();
                tVar2 = this.bFo.bFk;
                if (id == tVar2.baZ.getId()) {
                    TiebaStatic.log(new at("c10803").s("obj_locate", 7).ab("tid", bgVar.getTid()));
                } else if (view.getId() == r.g.card_home_page_normal_thread_abstract_voice) {
                    com.baidu.tieba.frs.g.b.abq().a(o.bMV, bgVar, 5);
                } else {
                    com.baidu.tieba.frs.g.b.abq().a(o.bMV, bgVar, 1);
                    TiebaStatic.log(new at("c11004").ab("tid", bgVar.getTid()));
                    TiebaStatic.log(new at("c10806").s("obj_locate", 1).ab("tid", bgVar.getId()));
                }
            }
        }
    }
}
