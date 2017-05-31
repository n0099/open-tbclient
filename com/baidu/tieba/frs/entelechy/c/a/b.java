package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.bp;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bZm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar2;
        List<bp> list;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar3;
        r rVar;
        r rVar2;
        c.b bVar;
        r rVar3;
        if (!i.gY()) {
            rVar3 = this.bZm.bVm;
            rVar3.showToast(w.l.neterror);
            return;
        }
        aVar = this.bZm.bZh;
        if (aVar == null) {
            a aVar4 = this.bZm;
            rVar2 = this.bZm.bVm;
            bVar = this.bZm.bZl;
            aVar4.bZh = new com.baidu.tieba.frs.entelechy.c.a.a.a(rVar2, bVar);
        }
        aVar2 = this.bZm.bZh;
        list = this.bZm.bZg;
        aVar2.setData(list);
        aVar3 = this.bZm.bZh;
        rVar = this.bZm.bVm;
        aVar3.d(rVar.getPageContext()).tf();
    }
}
