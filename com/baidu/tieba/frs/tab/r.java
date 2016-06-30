package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TabMenuPopView.a {
    final /* synthetic */ q bQV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bQV = qVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, dy dyVar) {
        j jVar;
        j.b bVar;
        j jVar2;
        jVar = this.bQV.bQP;
        if (jVar != null) {
            jVar2 = this.bQV.bQP;
            jVar2.ZO();
        }
        bVar = this.bQV.bQS;
        bVar.hR(dyVar.bGN);
    }
}
