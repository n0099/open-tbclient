package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements TabMenuPopView.a {
    final /* synthetic */ p biO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.biO = pVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, fc fcVar) {
        i iVar;
        i.a aVar;
        i iVar2;
        iVar = this.biO.biI;
        if (iVar != null) {
            iVar2 = this.biO.biI;
            iVar2.Pj();
        }
        aVar = this.biO.biL;
        aVar.gw(fcVar.beF);
    }
}
