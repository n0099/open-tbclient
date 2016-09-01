package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TabMenuPopView.a {
    final /* synthetic */ q cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cdZ = qVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, dt dtVar) {
        j jVar;
        j.b bVar;
        j jVar2;
        jVar = this.cdZ.cdT;
        if (jVar != null) {
            jVar2 = this.cdZ.cdT;
            jVar2.afb();
        }
        bVar = this.cdZ.cdW;
        bVar.iv(dtVar.bTp);
    }
}
