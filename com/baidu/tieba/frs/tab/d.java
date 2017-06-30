package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.cp;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.b {
    final /* synthetic */ HorizontalTabView cnV;
    private final /* synthetic */ cp cnW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, cp cpVar) {
        this.cnV = horizontalTabView;
        this.cnW = cpVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (this.cnW.ceU.size() > i && this.cnW.ceU.get(i) != null) {
            cVar.dismiss();
            this.cnV.c(this.cnV.jb(this.cnW.ceU.get(i).ceQ));
        }
    }
}
