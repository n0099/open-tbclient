package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends cd<bk> {
    final /* synthetic */ z bSW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.bSW = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bk bkVar) {
        cd cdVar;
        cd cdVar2;
        if (view != null && bkVar != null) {
            if (view.getId() == w.h.card_home_page_normal_thread_user_header) {
                com.baidu.tieba.frs.c.b.acs().a(z.bZb, bkVar, 2);
            } else if (view.getId() == w.h.card_divider_tv) {
                com.baidu.tieba.frs.d.o.a(z.bZb, bkVar.rW());
            } else if (view instanceof TbImageView) {
                cdVar = this.bSW.bbX;
                if (cdVar.aQe instanceof Boolean) {
                    cdVar2 = this.bSW.bbX;
                    if (((Boolean) cdVar2.aQe).booleanValue()) {
                        com.baidu.tieba.frs.c.b.acs().a(z.bZb, bkVar, 1);
                    } else {
                        com.baidu.tieba.frs.c.b.acs().a(z.bZb, bkVar, 3);
                    }
                }
            } else if (view.getId() == w.h.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.c.b.acs().a(z.bZb, bkVar, 5);
            } else {
                com.baidu.tieba.frs.c.b.acs().a(z.bZb, bkVar, 1);
            }
        }
    }
}
