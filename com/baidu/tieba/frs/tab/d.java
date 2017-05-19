package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.cn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.b {
    final /* synthetic */ HorizontalTabView bZt;
    private final /* synthetic */ cn bZu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, cn cnVar) {
        this.bZt = horizontalTabView;
        this.bZu = cnVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (this.bZu.bQV.size() > i && this.bZu.bQV.get(i) != null) {
            cVar.dismiss();
            this.bZt.b(this.bZt.ir(this.bZu.bQV.get(i).bQR));
        }
    }
}
