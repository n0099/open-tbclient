package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.frs.entelechy.view.ah;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends cf<bg> {
    final /* synthetic */ g bVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bVV = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, bg bgVar) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        if (view != null) {
            ahVar = this.bVV.bVT;
            if (ahVar != null) {
                ahVar2 = this.bVV.bVT;
                if (ahVar2.getView() != null) {
                    ahVar3 = this.bVV.bVT;
                    if (ahVar3.bXv != null && bgVar != null && !StringUtils.isNull(bgVar.getTid())) {
                        if (view.getId() == t.g.card_root_view) {
                            com.baidu.tieba.frs.g.b.aeX().a(g.cdn, bgVar, 1);
                        } else if (view.getId() == t.g.avatar || view.getId() == t.g.user_name) {
                            com.baidu.tieba.frs.g.b.aeX().a(g.cdn, bgVar, 2);
                        }
                    }
                }
            }
        }
    }
}
