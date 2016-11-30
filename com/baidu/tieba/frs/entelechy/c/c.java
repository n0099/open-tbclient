package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a cah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cah = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void ig(int i) {
        FrsActivity frsActivity;
        frsActivity = this.cah.bZY;
        frsActivity.abZ().hW(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean ih(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.cah.bZY;
        if (frsActivity != null) {
            frsActivity2 = this.cah.bZY;
            return (frsActivity2.acs() && i == 1) ? false : true;
        }
        return true;
    }
}
