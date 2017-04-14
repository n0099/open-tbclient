package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bTl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bTl = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar2;
        List<bv> list;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar3;
        h hVar;
        FrsActivity frsActivity;
        c.b bVar;
        FrsActivity frsActivity2;
        if (!i.gX()) {
            frsActivity2 = this.bTl.bTd;
            frsActivity2.showToast(w.l.neterror);
            return;
        }
        aVar = this.bTl.bTg;
        if (aVar == null) {
            a aVar4 = this.bTl;
            frsActivity = this.bTl.bTd;
            bVar = this.bTl.bTk;
            aVar4.bTg = new com.baidu.tieba.frs.entelechy.c.a.a.a(frsActivity, bVar);
        }
        aVar2 = this.bTl.bTg;
        list = this.bTl.bTf;
        aVar2.setData(list);
        aVar3 = this.bTl.bTg;
        hVar = this.bTl.bTd;
        aVar3.d(hVar.getPageContext()).tT();
    }
}
