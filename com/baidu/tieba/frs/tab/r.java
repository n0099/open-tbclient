package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TabMenuPopView.a {
    final /* synthetic */ q cca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cca = qVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, cv cvVar) {
        j jVar;
        j.b bVar;
        j jVar2;
        jVar = this.cca.cbU;
        if (jVar != null) {
            jVar2 = this.cca.cbU;
            jVar2.aeu();
        }
        bVar = this.cca.cbX;
        bVar.iF(cvVar.bSf);
    }
}
