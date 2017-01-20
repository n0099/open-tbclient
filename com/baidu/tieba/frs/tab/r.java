package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TabMenuPopView.a {
    final /* synthetic */ q bTW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bTW = qVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, ct ctVar) {
        j jVar;
        j.b bVar;
        j jVar2;
        jVar = this.bTW.bTQ;
        if (jVar != null) {
            jVar2 = this.bTW.bTQ;
            jVar2.acB();
        }
        bVar = this.bTW.bTT;
        bVar.iC(ctVar.bIQ);
    }
}
