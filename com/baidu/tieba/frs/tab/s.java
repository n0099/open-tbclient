package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.tab.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements TabMenuPopView.a {
    final /* synthetic */ r bZT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.bZT = rVar;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, cm cmVar) {
        k kVar;
        k.b bVar;
        k kVar2;
        kVar = this.bZT.bZN;
        if (kVar != null) {
            kVar2 = this.bZT.bZN;
            kVar2.acx();
        }
        bVar = this.bZT.bZQ;
        bVar.ix(cmVar.bQR);
    }
}
