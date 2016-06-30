package com.baidu.tieba.frs.entelechy.tabView;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.a {
    final /* synthetic */ a bKa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bKa = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void hA(int i) {
        FrsActivity frsActivity;
        frsActivity = this.bKa.bJR;
        frsActivity.VH().hr(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean hB(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bKa.bJR;
        if (frsActivity != null) {
            frsActivity2 = this.bKa.bJR;
            return (frsActivity2.VD() && i == 1) ? false : true;
        }
        return true;
    }
}
