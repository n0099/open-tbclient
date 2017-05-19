package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.tab.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements k.b {
    final /* synthetic */ HorizontalTabView bZt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bZt = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.k.b
    public void ix(int i) {
        TabItemView tabItemView;
        h hVar;
        h hVar2;
        bx bxVar;
        bx bxVar2;
        bx bxVar3;
        TabItemView tabItemView2;
        tabItemView = this.bZt.bZg;
        if (tabItemView != null) {
            bxVar = this.bZt.bZr;
            if (bxVar != null) {
                bxVar2 = this.bZt.bZr;
                if (bxVar2 != null) {
                    bxVar3 = this.bZt.bZr;
                    tabItemView2 = this.bZt.bZg;
                    bxVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        hVar = this.bZt.bZh;
        if (hVar != null) {
            hVar2 = this.bZt.bZh;
            hVar2.iv(i);
        }
    }
}
