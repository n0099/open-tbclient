package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.tab.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements TabMenuPopView.a {
    final /* synthetic */ r cgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.cgf = rVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, cn cnVar) {
        k kVar;
        k.b bVar;
        k kVar2;
        kVar = this.cgf.cfZ;
        if (kVar != null) {
            kVar2 = this.cgf.cfZ;
            kVar2.adA();
        }
        bVar = this.cgf.cgc;
        bVar.iV(cnVar.bWI);
    }
}
