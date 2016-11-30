package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TabMenuPopView.a {
    final /* synthetic */ q chZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.chZ = qVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, cx cxVar) {
        j jVar;
        j.b bVar;
        j jVar2;
        jVar = this.chZ.chT;
        if (jVar != null) {
            jVar2 = this.chZ.chT;
            jVar2.agZ();
        }
        bVar = this.chZ.chW;
        bVar.iF(cxVar.bVo);
    }
}
