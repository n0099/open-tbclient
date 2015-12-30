package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements TabMenuPopView.a {
    final /* synthetic */ p bmF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bmF = pVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, fc fcVar) {
        i iVar;
        i.a aVar;
        i iVar2;
        iVar = this.bmF.bmz;
        if (iVar != null) {
            iVar2 = this.bmF.bmz;
            iVar2.PB();
        }
        aVar = this.bmF.bmC;
        aVar.gp(fcVar.biz);
    }
}
