package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends cb<bg> {
    final /* synthetic */ z bFz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.bFz = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
    public void a(View view, bg bgVar) {
        cb cbVar;
        cb cbVar2;
        if (view != null && bgVar != null) {
            if (view.getId() == r.g.card_home_page_normal_thread_user_header || view.getId() == r.g.user_name) {
                com.baidu.tieba.frs.g.b.abq().a(z.bMV, bgVar, 2);
            } else if (view.getId() == r.g.card_divider_tv) {
                com.baidu.tieba.frs.utils.s.a(z.bMV, bgVar.sc());
            } else if (view instanceof TbImageView) {
                cbVar = this.bFz.bFl;
                if (cbVar.beb instanceof Boolean) {
                    cbVar2 = this.bFz.bFl;
                    if (((Boolean) cbVar2.beb).booleanValue()) {
                        com.baidu.tieba.frs.g.b.abq().a(z.bMV, bgVar, 1);
                    } else {
                        com.baidu.tieba.frs.g.b.abq().a(z.bMV, bgVar, 3);
                    }
                }
            } else if (view.getId() == r.g.card_home_page_normal_thread_abstract_voice) {
                com.baidu.tieba.frs.g.b.abq().a(z.bMV, bgVar, 5);
            } else {
                com.baidu.tieba.frs.g.b.abq().a(z.bMV, bgVar, 1);
            }
        }
    }
}
