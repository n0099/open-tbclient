package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends cd<bi> {
    final /* synthetic */ z bWC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.bWC = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bi biVar) {
        cd cdVar;
        cd cdVar2;
        if (view != null && biVar != null) {
            if (view.getId() == r.g.card_home_page_normal_thread_user_header || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.g.b.afl().a(z.cdl, biVar, 2);
            } else if (view instanceof TbImageView) {
                cdVar = this.bWC.bWu;
                if (cdVar.bbE instanceof Boolean) {
                    cdVar2 = this.bWC.bWu;
                    if (((Boolean) cdVar2.bbE).booleanValue()) {
                        com.baidu.tieba.frs.g.b.afl().a(z.cdl, biVar, 1);
                    } else {
                        com.baidu.tieba.frs.g.b.afl().a(z.cdl, biVar, 3);
                    }
                }
            } else if (view.getId() == r.g.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.g.b.afl().a(z.cdl, biVar, 5);
            } else {
                com.baidu.tieba.frs.g.b.afl().a(z.cdl, biVar, 1);
            }
        }
    }
}
