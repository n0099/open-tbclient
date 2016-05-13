package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.card.by;
import com.baidu.tieba.frs.entelechy.c.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements by<ax> {
    final /* synthetic */ e boN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.boN = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.by
    public void a(View view, ax axVar) {
        af afVar;
        af afVar2;
        af afVar3;
        bx.Ki().ci(true);
        if (view != null) {
            afVar = this.boN.boL;
            if (afVar != null) {
                afVar2 = this.boN.boL;
                if (afVar2.getView() != null) {
                    afVar3 = this.boN.boL;
                    if (afVar3.bpO == null || axVar == null || StringUtils.isNull(axVar.getTid())) {
                    }
                }
            }
        }
    }
}
