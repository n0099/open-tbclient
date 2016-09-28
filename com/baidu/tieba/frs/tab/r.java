package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TabMenuPopView.a {
    final /* synthetic */ q cdY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cdY = qVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, dt dtVar) {
        j jVar;
        j.b bVar;
        j jVar2;
        jVar = this.cdY.cdS;
        if (jVar != null) {
            jVar2 = this.cdY.cdS;
            jVar2.afp();
        }
        bVar = this.cdY.cdV;
        bVar.iA(dtVar.bTi);
    }
}
