package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bw;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a caq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.caq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar2;
        List<bw> list;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar3;
        i iVar;
        FrsActivity frsActivity;
        c.b bVar;
        FrsActivity frsActivity2;
        if (!com.baidu.adp.lib.util.i.fZ()) {
            frsActivity2 = this.caq.cai;
            frsActivity2.showToast(r.j.neterror);
            return;
        }
        aVar = this.caq.cal;
        if (aVar == null) {
            a aVar4 = this.caq;
            frsActivity = this.caq.cai;
            bVar = this.caq.cap;
            aVar4.cal = new com.baidu.tieba.frs.entelechy.c.a.a.a(frsActivity, bVar);
        }
        aVar2 = this.caq.cal;
        list = this.caq.cak;
        aVar2.setData(list);
        aVar3 = this.caq.cal;
        iVar = this.caq.cai;
        aVar3.d(iVar.getPageContext()).tt();
    }
}
