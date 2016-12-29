package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a bFR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bFR = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void hq(int i) {
        FrsActivity frsActivity;
        frsActivity = this.bFR.bFI;
        frsActivity.Wo().hg(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean hr(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bFR.bFI;
        if (frsActivity != null) {
            frsActivity2 = this.bFR.bFI;
            return (frsActivity2.WG() && i == 1) ? false : true;
        }
        return true;
    }
}
