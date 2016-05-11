package com.baidu.tieba.frs.entelechy.tabView;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a bps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bps = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void gz(int i) {
        FrsActivity frsActivity;
        frsActivity = this.bps.bpj;
        frsActivity.Qe().gV(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean gA(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bps.bpj;
        if (frsActivity != null) {
            frsActivity2 = this.bps.bpj;
            return (frsActivity2.Qa() && i == 1) ? false : true;
        }
        return true;
    }
}
