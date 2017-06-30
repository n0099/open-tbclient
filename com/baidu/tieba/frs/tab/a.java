package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.tab.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements k.b {
    final /* synthetic */ HorizontalTabView cnV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.cnV = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.k.b
    public void jh(int i) {
        TabItemView tabItemView;
        h hVar;
        h hVar2;
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        TabItemView tabItemView2;
        tabItemView = this.cnV.cnH;
        if (tabItemView != null) {
            bzVar = this.cnV.cnT;
            if (bzVar != null) {
                bzVar2 = this.cnV.cnT;
                if (bzVar2 != null) {
                    bzVar3 = this.cnV.cnT;
                    tabItemView2 = this.cnV.cnH;
                    bzVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        hVar = this.cnV.cnI;
        if (hVar != null) {
            hVar2 = this.cnV.cnI;
            hVar2.jf(i);
        }
    }
}
