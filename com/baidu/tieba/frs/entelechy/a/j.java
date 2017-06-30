package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.frs.entelechy.view.ai;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends ci<bm> {
    final /* synthetic */ i cgr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cgr = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, bm bmVar) {
        ai aiVar;
        ai aiVar2;
        ai aiVar3;
        if (view != null) {
            aiVar = this.cgr.cgq;
            if (aiVar != null) {
                aiVar2 = this.cgr.cgq;
                if (aiVar2.getView() != null) {
                    aiVar3 = this.cgr.cgq;
                    if (aiVar3.chO != null && bmVar != null && !StringUtils.isNull(bmVar.getTid())) {
                        if (view.getId() == w.h.card_root_view) {
                            com.baidu.tieba.frs.d.b.aho().a(i.cnC, bmVar, 1);
                        } else if (view.getId() == w.h.avatar) {
                            com.baidu.tieba.frs.d.b.aho().a(i.cnC, bmVar, 2);
                        } else if (view.getId() == w.h.card_divider_tv) {
                            com.baidu.tieba.frs.e.o.a(i.cnC, bmVar.rP());
                        }
                    }
                }
            }
        }
    }
}
