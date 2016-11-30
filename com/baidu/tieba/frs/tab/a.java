package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView chB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.chB = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void iF(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        ce ceVar;
        ce ceVar2;
        ce ceVar3;
        TabItemView tabItemView2;
        tabItemView = this.chB.chq;
        if (tabItemView != null) {
            ceVar = this.chB.chz;
            if (ceVar != null) {
                ceVar2 = this.chB.chz;
                if (ceVar2 != null) {
                    ceVar3 = this.chB.chz;
                    tabItemView2 = this.chB.chq;
                    ceVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.chB.chr;
        if (gVar != null) {
            gVar2 = this.chB.chr;
            gVar2.iD(i);
        }
    }
}
