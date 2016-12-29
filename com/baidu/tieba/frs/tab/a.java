package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView bNk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bNk = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void hP(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        cd cdVar;
        cd cdVar2;
        cd cdVar3;
        TabItemView tabItemView2;
        tabItemView = this.bNk.bMZ;
        if (tabItemView != null) {
            cdVar = this.bNk.bNi;
            if (cdVar != null) {
                cdVar2 = this.bNk.bNi;
                if (cdVar2 != null) {
                    cdVar3 = this.bNk.bNi;
                    tabItemView2 = this.bNk.bMZ;
                    cdVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.bNk.bNa;
        if (gVar != null) {
            gVar2 = this.bNk.bNa;
            gVar2.hN(i);
        }
    }
}
