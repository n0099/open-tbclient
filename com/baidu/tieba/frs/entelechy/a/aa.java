package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends cf<bg> {
    final /* synthetic */ z bWC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.bWC = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bg bgVar) {
        cf cfVar;
        cf cfVar2;
        if (view != null && bgVar != null) {
            if (view.getId() == t.g.card_home_page_normal_thread_user_header || view.getId() == t.g.user_name) {
                com.baidu.tieba.frs.g.b.aeX().a(z.cdn, bgVar, 2);
            } else if (view instanceof TbImageView) {
                cfVar = this.bWC.bWv;
                if (cfVar.bbn instanceof Boolean) {
                    cfVar2 = this.bWC.bWv;
                    if (((Boolean) cfVar2.bbn).booleanValue()) {
                        com.baidu.tieba.frs.g.b.aeX().a(z.cdn, bgVar, 1);
                    } else {
                        com.baidu.tieba.frs.g.b.aeX().a(z.cdn, bgVar, 3);
                    }
                }
            } else if (view.getId() == t.g.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.g.b.aeX().a(z.cdn, bgVar, 5);
            } else {
                com.baidu.tieba.frs.g.b.aeX().a(z.cdn, bgVar, 1);
            }
        }
    }
}
