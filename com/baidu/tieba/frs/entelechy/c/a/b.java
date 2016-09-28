package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bWZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bWZ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar2;
        List<cy> list;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar3;
        i iVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        c.b bVar;
        FrsActivity frsActivity4;
        if (!com.baidu.adp.lib.util.i.fZ()) {
            frsActivity4 = this.bWZ.bWR;
            frsActivity4.showToast(r.j.neterror);
            return;
        }
        aVar = this.bWZ.bWU;
        if (aVar == null) {
            a aVar4 = this.bWZ;
            frsActivity3 = this.bWZ.bWR;
            bVar = this.bWZ.bWY;
            aVar4.bWU = new com.baidu.tieba.frs.entelechy.c.a.a.a(frsActivity3, bVar);
        }
        aVar2 = this.bWZ.bWU;
        list = this.bWZ.bWT;
        aVar2.setData(list);
        aVar3 = this.bWZ.bWU;
        iVar = this.bWZ.bWR;
        aVar3.d(iVar.getPageContext()).tp();
        frsActivity = this.bWZ.bWR;
        if (frsActivity.abe() != null) {
            frsActivity2 = this.bWZ.bWR;
            if (frsActivity2.abe().aMr() == null) {
            }
        }
    }
}
