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
    final /* synthetic */ a bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bVC = aVar;
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
        if (!i.gY()) {
            frsActivity2 = this.bVC.bVu;
            frsActivity2.showToast(w.l.neterror);
            return;
        }
        aVar = this.bVC.bVx;
        if (aVar == null) {
            a aVar4 = this.bVC;
            frsActivity = this.bVC.bVu;
            bVar = this.bVC.bVB;
            aVar4.bVx = new com.baidu.tieba.frs.entelechy.c.a.a.a(frsActivity, bVar);
        }
        aVar2 = this.bVC.bVx;
        list = this.bVC.bVw;
        aVar2.setData(list);
        aVar3 = this.bVC.bVx;
        hVar = this.bVC.bVu;
        aVar3.d(hVar.getPageContext()).tT();
    }
}
