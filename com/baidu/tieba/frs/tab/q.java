package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fu;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements TabMenuPopView.a {
    final /* synthetic */ p buv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.buv = pVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, fu fuVar) {
        i iVar;
        i.b bVar;
        i iVar2;
        iVar = this.buv.bup;
        if (iVar != null) {
            iVar2 = this.buv.bup;
            iVar2.Tt();
        }
        bVar = this.buv.bus;
        bVar.he(fuVar.bqM);
    }
}
