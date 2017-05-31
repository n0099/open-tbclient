package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.ai;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends ci<bl> {
    final /* synthetic */ i bYi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bYi = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bl blVar) {
        ai aiVar;
        ai aiVar2;
        ai aiVar3;
        if (view != null) {
            aiVar = this.bYi.bYh;
            if (aiVar != null) {
                aiVar2 = this.bYi.bYh;
                if (aiVar2.getView() != null) {
                    aiVar3 = this.bYi.bYh;
                    if (aiVar3.bZF != null && blVar != null && !StringUtils.isNull(blVar.getTid())) {
                        if (view.getId() == w.h.card_root_view) {
                            com.baidu.tieba.frs.d.b.adw().a(i.cfm, blVar, 1);
                        } else if (view.getId() == w.h.avatar) {
                            com.baidu.tieba.frs.d.b.adw().a(i.cfm, blVar, 2);
                        } else if (view.getId() == w.h.card_divider_tv) {
                            com.baidu.tieba.frs.e.o.a(i.cfm, blVar.rS());
                        }
                    }
                }
            }
        }
    }
}
