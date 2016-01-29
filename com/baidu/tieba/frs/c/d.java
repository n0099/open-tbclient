package com.baidu.tieba.frs.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements HorizontalTabView.a {
    final /* synthetic */ a bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bpO = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void gN(int i) {
        o oVar;
        oVar = this.bpO.bpI;
        oVar.gZ(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean gO(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bpO.bot;
        if (frsActivity != null) {
            frsActivity2 = this.bpO.bot;
            return (frsActivity2.Pl() && i == 1) ? false : true;
        }
        return true;
    }
}
