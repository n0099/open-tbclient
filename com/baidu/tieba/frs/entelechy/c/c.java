package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.b {
    final /* synthetic */ a bTm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bTm = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
    public void hY(int i) {
        r rVar;
        rVar = this.bTm.bNK;
        rVar.YZ().hN(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
    public boolean hZ(int i) {
        r rVar;
        r rVar2;
        rVar = this.bTm.bNK;
        if (rVar != null) {
            rVar2 = this.bTm.bNK;
            return (rVar2.Zr() && i == 1) ? false : true;
        }
        return true;
    }
}
