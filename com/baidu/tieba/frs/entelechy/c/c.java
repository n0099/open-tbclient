package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a bMi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bMi = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void id(int i) {
        FrsActivity frsActivity;
        frsActivity = this.bMi.bLZ;
        frsActivity.XF().hS(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean ie(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bMi.bLZ;
        if (frsActivity != null) {
            frsActivity2 = this.bMi.bLZ;
            return (frsActivity2.XX() && i == 1) ? false : true;
        }
        return true;
    }
}
