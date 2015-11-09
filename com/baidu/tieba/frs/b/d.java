package com.baidu.tieba.frs.b;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements HorizontalTabView.a {
    final /* synthetic */ a bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bcD = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void gb(int i) {
        o oVar;
        oVar = this.bcD.bcx;
        oVar.gn(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean gc(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bcD.bbk;
        if (frsActivity != null) {
            frsActivity2 = this.bcD.bbk;
            return (frsActivity2.Lu() && i == 1) ? false : true;
        }
        return true;
    }
}
