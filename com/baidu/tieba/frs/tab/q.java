package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ek;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements TabMenuPopView.a {
    final /* synthetic */ p bcj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bcj = pVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, ek ekVar) {
        i iVar;
        i.a aVar;
        i iVar2;
        iVar = this.bcj.bcd;
        if (iVar != null) {
            iVar2 = this.bcj.bcd;
            iVar2.ND();
        }
        aVar = this.bcj.bcg;
        aVar.ga(ekVar.aYG);
    }
}
