package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a bLG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bLG = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void hz(int i) {
        FrsActivity frsActivity;
        frsActivity = this.bLG.bLx;
        frsActivity.VZ().hq(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean hA(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bLG.bLx;
        if (frsActivity != null) {
            frsActivity2 = this.bLG.bLx;
            return (frsActivity2.VV() && i == 1) ? false : true;
        }
        return true;
    }
}
