package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView bTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bTy = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void iC(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        TabItemView tabItemView2;
        tabItemView = this.bTy.bTn;
        if (tabItemView != null) {
            cbVar = this.bTy.bTw;
            if (cbVar != null) {
                cbVar2 = this.bTy.bTw;
                if (cbVar2 != null) {
                    cbVar3 = this.bTy.bTw;
                    tabItemView2 = this.bTy.bTn;
                    cbVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.bTy.bTo;
        if (gVar != null) {
            gVar2 = this.bTy.bTo;
            gVar2.iA(i);
        }
    }
}
