package com.baidu.tieba.frs.b;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements HorizontalTabView.a {
    final /* synthetic */ a bji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bji = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void gx(int i) {
        o oVar;
        oVar = this.bji.bjc;
        oVar.gJ(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean gy(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bji.bhN;
        if (frsActivity != null) {
            frsActivity2 = this.bji.bhN;
            return (frsActivity2.MU() && i == 1) ? false : true;
        }
        return true;
    }
}
