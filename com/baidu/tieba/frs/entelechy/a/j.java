package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends cb<bg> {
    final /* synthetic */ i bET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bET = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
    public void a(View view, bg bgVar) {
        com.baidu.tieba.frs.entelechy.view.am amVar;
        com.baidu.tieba.frs.entelechy.view.am amVar2;
        com.baidu.tieba.frs.entelechy.view.am amVar3;
        if (view != null) {
            amVar = this.bET.bER;
            if (amVar != null) {
                amVar2 = this.bET.bER;
                if (amVar2.getView() != null) {
                    amVar3 = this.bET.bER;
                    if (amVar3.bGu != null && bgVar != null && !StringUtils.isNull(bgVar.getTid())) {
                        if (view.getId() == r.g.card_root_view) {
                            com.baidu.tieba.frs.g.b.abq().a(i.bMV, bgVar, 1);
                        } else if (view.getId() == r.g.avatar || view.getId() == r.g.user_name) {
                            com.baidu.tieba.frs.g.b.abq().a(i.bMV, bgVar, 2);
                        } else if (view.getId() == r.g.card_divider_tv) {
                            com.baidu.tieba.frs.utils.s.a(i.bMV, bgVar.sc());
                        }
                    }
                }
            }
        }
    }
}
