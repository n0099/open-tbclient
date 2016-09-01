package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a bWW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bWW = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void ic(int i) {
        FrsActivity frsActivity;
        frsActivity = this.bWW.bWH;
        frsActivity.aaW().hT(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean id(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bWW.bWH;
        if (frsActivity != null) {
            frsActivity2 = this.bWW.bWH;
            return (frsActivity2.aaS() && i == 1) ? false : true;
        }
        return true;
    }
}
