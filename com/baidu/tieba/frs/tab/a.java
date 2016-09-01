package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView cdC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.cdC = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void iv(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        TabItemView tabItemView2;
        tabItemView = this.cdC.cdr;
        if (tabItemView != null) {
            dgVar = this.cdC.cdA;
            if (dgVar != null) {
                dgVar2 = this.cdC.cdA;
                if (dgVar2 != null) {
                    dgVar3 = this.cdC.cdA;
                    tabItemView2 = this.cdC.cdr;
                    dgVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.cdC.cds;
        if (gVar != null) {
            gVar2 = this.cdC.cds;
            gVar2.it(i);
        }
    }
}
