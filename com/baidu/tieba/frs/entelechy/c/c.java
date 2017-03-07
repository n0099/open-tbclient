package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a bTo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bTo = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void hZ(int i) {
        FrsActivity frsActivity;
        frsActivity = this.bTo.bTf;
        frsActivity.YE().hO(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean ia(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bTo.bTf;
        if (frsActivity != null) {
            frsActivity2 = this.bTo.bTf;
            return (frsActivity2.YW() && i == 1) ? false : true;
        }
        return true;
    }
}
