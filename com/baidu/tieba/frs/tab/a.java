package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.dl;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView bQy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bQy = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void hR(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        dl dlVar;
        dl dlVar2;
        dl dlVar3;
        TabItemView tabItemView2;
        tabItemView = this.bQy.bQn;
        if (tabItemView != null) {
            dlVar = this.bQy.bQw;
            if (dlVar != null) {
                dlVar2 = this.bQy.bQw;
                if (dlVar2 != null) {
                    dlVar3 = this.bQy.bQw;
                    tabItemView2 = this.bQy.bQn;
                    dlVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.bQy.bQo;
        if (gVar != null) {
            gVar2 = this.bQy.bQo;
            gVar2.hP(i);
        }
    }
}
