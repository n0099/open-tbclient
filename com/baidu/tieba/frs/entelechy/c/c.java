package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a bWQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bWQ = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void ig(int i) {
        FrsActivity frsActivity;
        frsActivity = this.bWQ.bWH;
        frsActivity.abj().hX(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean ih(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bWQ.bWH;
        if (frsActivity != null) {
            frsActivity2 = this.bWQ.bWH;
            return (frsActivity2.abf() && i == 1) ? false : true;
        }
        return true;
    }
}
