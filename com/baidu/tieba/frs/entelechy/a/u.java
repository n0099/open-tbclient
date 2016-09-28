package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends cd<bi> {
    final /* synthetic */ t bWv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bWv = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bi biVar) {
        com.baidu.tieba.frs.entelechy.view.t tVar;
        com.baidu.tieba.frs.entelechy.view.t tVar2;
        cd cdVar;
        cd cdVar2;
        tVar = this.bWv.bWt;
        if (tVar != null && view != null && biVar != null) {
            if (view.getId() == r.g.card_home_page_normal_thread_user_header || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.g.b.afl().a(t.cdl, biVar, 2);
            } else if (view instanceof TbImageView) {
                cdVar = this.bWv.bWu;
                if (cdVar.bbE instanceof Boolean) {
                    cdVar2 = this.bWv.bWu;
                    if (((Boolean) cdVar2.bbE).booleanValue()) {
                        com.baidu.tieba.frs.g.b.afl().a(t.cdl, biVar, 1);
                    } else {
                        com.baidu.tieba.frs.g.b.afl().a(t.cdl, biVar, 3);
                    }
                }
                TiebaStatic.log(new ax("c11004").ab("tid", biVar.getTid()));
            } else {
                int id = view.getId();
                tVar2 = this.bWv.bWt;
                if (id == tVar2.aYK.getId()) {
                    TiebaStatic.log(new ax("c10803").s("obj_locate", 7).ab("tid", biVar.getTid()));
                } else if (view.getId() == r.g.card_home_page_normal_thread_abstract_voice) {
                    com.baidu.tieba.frs.g.b.afl().a(t.cdl, biVar, 5);
                } else {
                    com.baidu.tieba.frs.g.b.afl().a(t.cdl, biVar, 1);
                    TiebaStatic.log(new ax("c11004").ab("tid", biVar.getTid()));
                    TiebaStatic.log(new ax("c10806").s("obj_locate", 1).ab("tid", biVar.getId()));
                }
            }
        }
    }
}
