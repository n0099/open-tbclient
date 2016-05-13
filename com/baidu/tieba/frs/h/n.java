package com.baidu.tieba.frs.h;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements HorizontalTabView.a {
    final /* synthetic */ m buB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.buB = mVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void gy(int i) {
        aa aaVar;
        aaVar = this.buB.buy;
        aaVar.gU(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean gz(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.buB.bpj;
        if (frsActivity != null) {
            frsActivity2 = this.buB.bpj;
            return (frsActivity2.Qa() && i == 1) ? false : true;
        }
        return true;
    }
}
