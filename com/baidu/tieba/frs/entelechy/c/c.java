package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a bVt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bVt = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void ii(int i) {
        FrsActivity frsActivity;
        frsActivity = this.bVt.bVk;
        frsActivity.aab().hX(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean ij(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bVt.bVk;
        if (frsActivity != null) {
            frsActivity2 = this.bVt.bVk;
            return (frsActivity2.aat() && i == 1) ? false : true;
        }
        return true;
    }
}
