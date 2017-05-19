package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.ai;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends cd<bk> {
    final /* synthetic */ i bSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bSr = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bk bkVar) {
        ai aiVar;
        ai aiVar2;
        ai aiVar3;
        if (view != null) {
            aiVar = this.bSr.bSp;
            if (aiVar != null) {
                aiVar2 = this.bSr.bSp;
                if (aiVar2.getView() != null) {
                    aiVar3 = this.bSr.bSp;
                    if (aiVar3.bTN != null && bkVar != null && !StringUtils.isNull(bkVar.getTid())) {
                        if (view.getId() == w.h.card_root_view) {
                            com.baidu.tieba.frs.c.b.acs().a(i.bZb, bkVar, 1);
                        } else if (view.getId() == w.h.avatar) {
                            com.baidu.tieba.frs.c.b.acs().a(i.bZb, bkVar, 2);
                        } else if (view.getId() == w.h.card_divider_tv) {
                            com.baidu.tieba.frs.d.o.a(i.bZb, bkVar.rW());
                        }
                    }
                }
            }
        }
    }
}
