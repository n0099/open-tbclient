package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.frs.tab.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements TabMenuPopView.a {
    final /* synthetic */ r cov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.cov = rVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, co coVar) {
        k kVar;
        k.b bVar;
        k kVar2;
        kVar = this.cov.cop;
        if (kVar != null) {
            kVar2 = this.cov.cop;
            kVar2.aht();
        }
        bVar = this.cov.cos;
        bVar.jh(coVar.ceQ);
    }
}
