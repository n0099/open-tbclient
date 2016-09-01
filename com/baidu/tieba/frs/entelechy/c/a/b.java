package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cy;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bXf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bXf = aVar;
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
            frsActivity4 = this.bXf.bWX;
            frsActivity4.showToast(t.j.neterror);
            return;
        }
        aVar = this.bXf.bXa;
        if (aVar == null) {
            a aVar4 = this.bXf;
            frsActivity3 = this.bXf.bWX;
            bVar = this.bXf.bXe;
            aVar4.bXa = new com.baidu.tieba.frs.entelechy.c.a.a.a(frsActivity3, bVar);
        }
        aVar2 = this.bXf.bXa;
        list = this.bXf.bWZ;
        aVar2.setData(list);
        aVar3 = this.bXf.bXa;
        iVar = this.bXf.bWX;
        aVar3.d(iVar.getPageContext()).ta();
        frsActivity = this.bXf.bWX;
        if (frsActivity.aaR() != null) {
            frsActivity2 = this.bXf.bWX;
            if (frsActivity2.aaR().aLP() == null) {
            }
        }
    }
}
