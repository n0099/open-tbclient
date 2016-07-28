package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bLP = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar2;
        List<dc> list;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar3;
        i iVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        c.b bVar;
        FrsActivity frsActivity4;
        if (!com.baidu.adp.lib.util.i.fe()) {
            frsActivity4 = this.bLP.bLH;
            frsActivity4.showToast(u.j.neterror);
            return;
        }
        aVar = this.bLP.bLK;
        if (aVar == null) {
            a aVar4 = this.bLP;
            frsActivity3 = this.bLP.bLH;
            bVar = this.bLP.bLO;
            aVar4.bLK = new com.baidu.tieba.frs.entelechy.c.a.a.a(frsActivity3, bVar);
        }
        aVar2 = this.bLP.bLK;
        list = this.bLP.bLJ;
        aVar2.setData(list);
        aVar3 = this.bLP.bLK;
        iVar = this.bLP.bLH;
        aVar3.d(iVar.getPageContext()).rV();
        frsActivity = this.bLP.bLH;
        if (frsActivity.VU() != null) {
            frsActivity2 = this.bLP.bLH;
            if (frsActivity2.VU().aGX() == null) {
            }
        }
    }
}
