package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a chv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.chv = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar2;
        List<bq> list;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar3;
        r rVar;
        r rVar2;
        c.b bVar;
        r rVar3;
        if (!i.gX()) {
            rVar3 = this.chv.cdv;
            rVar3.showToast(w.l.neterror);
            return;
        }
        aVar = this.chv.chq;
        if (aVar == null) {
            a aVar4 = this.chv;
            rVar2 = this.chv.cdv;
            bVar = this.chv.chu;
            aVar4.chq = new com.baidu.tieba.frs.entelechy.c.a.a.a(rVar2, bVar);
        }
        aVar2 = this.chv.chq;
        list = this.chv.chp;
        aVar2.setData(list);
        aVar3 = this.chv.chq;
        rVar = this.chv.cdv;
        aVar3.d(rVar.getPageContext()).td();
    }
}
