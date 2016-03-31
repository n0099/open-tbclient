package com.baidu.tieba.frs.c;

import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements HorizontalTabView.a {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.buP = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public void hf(int i) {
        o oVar;
        oVar = this.buP.buJ;
        oVar.hs(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
    public boolean hg(int i) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.buP.bts;
        if (frsActivity != null) {
            frsActivity2 = this.buP.bts;
            return (frsActivity2.Ra() && i == 1) ? false : true;
        }
        return true;
    }
}
