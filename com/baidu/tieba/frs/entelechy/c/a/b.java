package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bv;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bGa = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar2;
        List<bv> list;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar3;
        i iVar;
        FrsActivity frsActivity;
        c.b bVar;
        FrsActivity frsActivity2;
        if (!com.baidu.adp.lib.util.i.fZ()) {
            frsActivity2 = this.bGa.bFS;
            frsActivity2.showToast(r.j.neterror);
            return;
        }
        aVar = this.bGa.bFV;
        if (aVar == null) {
            a aVar4 = this.bGa;
            frsActivity = this.bGa.bFS;
            bVar = this.bGa.bFZ;
            aVar4.bFV = new com.baidu.tieba.frs.entelechy.c.a.a.a(frsActivity, bVar);
        }
        aVar2 = this.bGa.bFV;
        list = this.bGa.bFU;
        aVar2.setData(list);
        aVar3 = this.bGa.bFV;
        iVar = this.bGa.bFS;
        aVar3.d(iVar.getPageContext()).te();
    }
}
