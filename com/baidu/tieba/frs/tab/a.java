package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView cdA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.cdA = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void iA(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        TabItemView tabItemView2;
        tabItemView = this.cdA.cdp;
        if (tabItemView != null) {
            dgVar = this.cdA.cdy;
            if (dgVar != null) {
                dgVar2 = this.cdA.cdy;
                if (dgVar2 != null) {
                    dgVar3 = this.cdA.cdy;
                    tabItemView2 = this.cdA.cdp;
                    dgVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.cdA.cdq;
        if (gVar != null) {
            gVar2 = this.cdA.cdq;
            gVar2.iy(i);
        }
    }
}
