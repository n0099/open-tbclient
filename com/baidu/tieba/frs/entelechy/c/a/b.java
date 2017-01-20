package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bMr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bMr = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar2;
        List<bt> list;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar3;
        h hVar;
        FrsActivity frsActivity;
        c.b bVar;
        FrsActivity frsActivity2;
        if (!i.fX()) {
            frsActivity2 = this.bMr.bMj;
            frsActivity2.showToast(r.l.neterror);
            return;
        }
        aVar = this.bMr.bMm;
        if (aVar == null) {
            a aVar4 = this.bMr;
            frsActivity = this.bMr.bMj;
            bVar = this.bMr.bMq;
            aVar4.bMm = new com.baidu.tieba.frs.entelechy.c.a.a.a(frsActivity, bVar);
        }
        aVar2 = this.bMr.bMm;
        list = this.bMr.bMl;
        aVar2.setData(list);
        aVar3 = this.bMr.bMm;
        hVar = this.bMr.bMj;
        aVar3.d(hVar.getPageContext()).sY();
    }
}
