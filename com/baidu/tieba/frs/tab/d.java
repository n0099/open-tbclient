package com.baidu.tieba.frs.tab;

import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.co;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements c.b {
    final /* synthetic */ HorizontalTabView cfF;
    private final /* synthetic */ co cfG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(HorizontalTabView horizontalTabView, co coVar) {
        this.cfF = horizontalTabView;
        this.cfG = coVar;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        if (this.cfG.bWM.size() > i && this.cfG.bWM.get(i) != null) {
            cVar.dismiss();
            this.cfF.c(this.cfF.iP(this.cfG.bWM.get(i).bWI));
        }
    }
}
