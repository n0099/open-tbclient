package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView cbC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.cbC = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void iF(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        cd cdVar;
        cd cdVar2;
        cd cdVar3;
        TabItemView tabItemView2;
        tabItemView = this.cbC.cbr;
        if (tabItemView != null) {
            cdVar = this.cbC.cbA;
            if (cdVar != null) {
                cdVar2 = this.cbC.cbA;
                if (cdVar2 != null) {
                    cdVar3 = this.cbC.cbA;
                    tabItemView2 = this.cbC.cbr;
                    cdVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.cbC.cbs;
        if (gVar != null) {
            gVar2 = this.cbC.cbs;
            gVar2.iD(i);
        }
    }
}
