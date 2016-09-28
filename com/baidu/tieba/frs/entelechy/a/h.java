package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.frs.entelechy.view.ah;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends cd<bi> {
    final /* synthetic */ g bVU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bVU = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, bi biVar) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        if (view != null) {
            ahVar = this.bVU.bVS;
            if (ahVar != null) {
                ahVar2 = this.bVU.bVS;
                if (ahVar2.getView() != null) {
                    ahVar3 = this.bVU.bVS;
                    if (ahVar3.bXq != null && biVar != null && !StringUtils.isNull(biVar.getTid())) {
                        if (view.getId() == r.g.card_root_view) {
                            com.baidu.tieba.frs.g.b.afl().a(g.cdl, biVar, 1);
                        } else if (view.getId() == r.g.avatar || view.getId() == r.g.user_name) {
                            com.baidu.tieba.frs.g.b.afl().a(g.cdl, biVar, 2);
                        }
                    }
                }
            }
        }
    }
}
