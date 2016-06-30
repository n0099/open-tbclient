package com.baidu.tieba.frs.entelechy.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements bx<az> {
    final /* synthetic */ i bJg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bJg = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bx
    public void a(View view, az azVar) {
        com.baidu.tieba.frs.entelechy.view.ad adVar;
        com.baidu.tieba.frs.entelechy.view.ad adVar2;
        com.baidu.tieba.frs.entelechy.view.ad adVar3;
        bw.Lg().cj(true);
        if (view != null) {
            adVar = this.bJg.bJe;
            if (adVar != null) {
                adVar2 = this.bJg.bJe;
                if (adVar2.getView() != null) {
                    adVar3 = this.bJg.bJe;
                    if (adVar3.bKv == null || azVar == null || StringUtils.isNull(azVar.getTid())) {
                    }
                }
            }
        }
    }
}
