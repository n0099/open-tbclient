package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends cf<bg> {
    final /* synthetic */ t bWw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bWw = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bg bgVar) {
        com.baidu.tieba.frs.entelechy.view.t tVar;
        com.baidu.tieba.frs.entelechy.view.t tVar2;
        cf cfVar;
        cf cfVar2;
        tVar = this.bWw.bWu;
        if (tVar != null && view != null && bgVar != null) {
            if (view.getId() == t.g.card_home_page_normal_thread_user_header || view.getId() == t.g.user_name) {
                com.baidu.tieba.frs.g.b.aeX().a(t.cdn, bgVar, 2);
            } else if (view instanceof TbImageView) {
                cfVar = this.bWw.bWv;
                if (cfVar.bbn instanceof Boolean) {
                    cfVar2 = this.bWw.bWv;
                    if (((Boolean) cfVar2.bbn).booleanValue()) {
                        com.baidu.tieba.frs.g.b.aeX().a(t.cdn, bgVar, 1);
                    } else {
                        com.baidu.tieba.frs.g.b.aeX().a(t.cdn, bgVar, 3);
                    }
                }
                TiebaStatic.log(new ay("c11004").ab("tid", bgVar.getTid()));
            } else {
                int id = view.getId();
                tVar2 = this.bWw.bWu;
                if (id == tVar2.aYi.getId()) {
                    TiebaStatic.log(new ay("c10803").s("obj_locate", 7).ab("tid", bgVar.getTid()));
                } else if (view.getId() == t.g.card_home_page_normal_thread_abstract_voice) {
                    com.baidu.tieba.frs.g.b.aeX().a(t.cdn, bgVar, 5);
                } else {
                    com.baidu.tieba.frs.g.b.aeX().a(t.cdn, bgVar, 1);
                    TiebaStatic.log(new ay("c11004").ab("tid", bgVar.getTid()));
                    TiebaStatic.log(new ay("c10806").s("obj_locate", 1).ab("tid", bgVar.getId()));
                }
            }
        }
    }
}
