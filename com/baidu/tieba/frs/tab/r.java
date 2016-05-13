package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ft;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements TabMenuPopView.a {
    final /* synthetic */ q btr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.btr = qVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, ft ftVar) {
        j jVar;
        j.b bVar;
        j jVar2;
        jVar = this.btr.btl;
        if (jVar != null) {
            jVar2 = this.btr.btl;
            jVar2.Tz();
        }
        bVar = this.btr.bto;
        bVar.gM(ftVar.blZ);
    }
}
