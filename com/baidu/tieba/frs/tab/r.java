package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TabMenuPopView.a {
    final /* synthetic */ q bZJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bZJ = qVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, cv cvVar) {
        j jVar;
        j.b bVar;
        j jVar2;
        jVar = this.bZJ.bZD;
        if (jVar != null) {
            jVar2 = this.bZJ.bZD;
            jVar2.adt();
        }
        bVar = this.bZJ.bZG;
        bVar.iz(cvVar.bPO);
    }
}
