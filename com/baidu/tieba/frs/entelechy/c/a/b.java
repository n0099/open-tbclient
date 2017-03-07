package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.base.h;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bt;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bTx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bTx = aVar;
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
        if (!i.gS()) {
            frsActivity2 = this.bTx.bTp;
            frsActivity2.showToast(w.l.neterror);
            return;
        }
        aVar = this.bTx.bTs;
        if (aVar == null) {
            a aVar4 = this.bTx;
            frsActivity = this.bTx.bTp;
            bVar = this.bTx.bTw;
            aVar4.bTs = new com.baidu.tieba.frs.entelechy.c.a.a.a(frsActivity, bVar);
        }
        aVar2 = this.bTx.bTs;
        list = this.bTx.bTr;
        aVar2.setData(list);
        aVar3 = this.bTx.bTs;
        hVar = this.bTx.bTp;
        aVar3.d(hVar.getPageContext()).tv();
    }
}
