package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a bTc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bTc = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void ic(int i) {
        FrsActivity frsActivity;
        frsActivity = this.bTc.bST;
        frsActivity.Za().hR(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean id(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bTc.bST;
        if (frsActivity != null) {
            frsActivity2 = this.bTc.bST;
            return (frsActivity2.Zs() && i == 1) ? false : true;
        }
        return true;
    }
}
