package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.c {
    final /* synthetic */ a chn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.chn = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
    public void iI(int i) {
        r rVar;
        rVar = this.chn.cbE;
        rVar.adU().ix(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
    public boolean iJ(int i) {
        r rVar;
        r rVar2;
        rVar = this.chn.cbE;
        if (rVar != null) {
            rVar2 = this.chn.cbE;
            return (rVar2.ael() && i == 1) ? false : true;
        }
        return true;
    }
}
