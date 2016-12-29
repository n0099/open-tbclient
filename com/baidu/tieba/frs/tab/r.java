package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TabMenuPopView.a {
    final /* synthetic */ q bNI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bNI = qVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, cx cxVar) {
        j jVar;
        j.b bVar;
        j jVar2;
        jVar = this.bNI.bNC;
        if (jVar != null) {
            jVar2 = this.bNI.bNC;
            jVar2.abu();
        }
        bVar = this.bNI.bNF;
        bVar.hP(cxVar.bBw);
    }
}
