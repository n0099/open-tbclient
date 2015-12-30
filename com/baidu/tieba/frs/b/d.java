package com.baidu.tieba.frs.b;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements HorizontalTabView.a {
    final /* synthetic */ a bmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bmZ = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void gq(int i) {
        o oVar;
        oVar = this.bmZ.bmT;
        oVar.gC(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean gr(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bmZ.blE;
        if (frsActivity != null) {
            frsActivity2 = this.bmZ.blE;
            return (frsActivity2.No() && i == 1) ? false : true;
        }
        return true;
    }
}
