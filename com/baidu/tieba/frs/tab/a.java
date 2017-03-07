package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView caK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.caK = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void iy(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        TabItemView tabItemView2;
        tabItemView = this.caK.caz;
        if (tabItemView != null) {
            cbVar = this.caK.caI;
            if (cbVar != null) {
                cbVar2 = this.caK.caI;
                if (cbVar2 != null) {
                    cbVar3 = this.caK.caI;
                    tabItemView2 = this.caK.caz;
                    cbVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.caK.caA;
        if (gVar != null) {
            gVar2 = this.caK.caA;
            gVar2.iw(i);
        }
    }
}
