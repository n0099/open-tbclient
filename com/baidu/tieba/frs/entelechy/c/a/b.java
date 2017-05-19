package com.baidu.tieba.frs.entelechy.c.a;

import android.view.View;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.bo;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bTu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bTu = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar2;
        List<bo> list;
        com.baidu.tieba.frs.entelechy.c.a.a.a aVar3;
        r rVar;
        r rVar2;
        c.b bVar;
        r rVar3;
        if (!i.gY()) {
            rVar3 = this.bTu.bPw;
            rVar3.showToast(w.l.neterror);
            return;
        }
        aVar = this.bTu.bTp;
        if (aVar == null) {
            a aVar4 = this.bTu;
            rVar2 = this.bTu.bPw;
            bVar = this.bTu.bTt;
            aVar4.bTp = new com.baidu.tieba.frs.entelechy.c.a.a.a(rVar2, bVar);
        }
        aVar2 = this.bTu.bTp;
        list = this.bTu.bTo;
        aVar2.setData(list);
        aVar3 = this.bTu.bTp;
        rVar = this.bTu.bPw;
        aVar3.d(rVar.getPageContext()).tg();
    }
}
