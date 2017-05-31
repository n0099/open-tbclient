package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.tab.HorizontalTabView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements HorizontalTabView.c {
    final /* synthetic */ a bZe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bZe = aVar;
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
    public void iw(int i) {
        r rVar;
        rVar = this.bZe.bTw;
        rVar.aad().il(i);
    }

    @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
    public boolean ix(int i) {
        r rVar;
        r rVar2;
        rVar = this.bZe.bTw;
        if (rVar != null) {
            rVar2 = this.bZe.bTw;
            return (rVar2.aav() && i == 1) ? false : true;
        }
        return true;
    }
}
