package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TabMenuPopView.a {
    final /* synthetic */ q cbi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.cbi = qVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, ct ctVar) {
        j jVar;
        j.b bVar;
        j jVar2;
        jVar = this.cbi.cbc;
        if (jVar != null) {
            jVar2 = this.cbi.cbc;
            jVar2.adz();
        }
        bVar = this.cbi.cbf;
        bVar.iy(ctVar.bPZ);
    }
}
