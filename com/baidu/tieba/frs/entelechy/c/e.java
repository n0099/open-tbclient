package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements HorizontalTabView.b {
    final /* synthetic */ a chn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.chn = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
    public void b(j jVar) {
        r rVar;
        r rVar2;
        if (jVar != null) {
            rVar = this.chn.cbE;
            if (rVar != null) {
                rVar2 = this.chn.cbE;
                rVar2.cA(jVar.cnY == 49);
            }
        }
    }
}
