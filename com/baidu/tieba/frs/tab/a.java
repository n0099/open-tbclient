package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.dl;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView bSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bSw = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void hS(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        dl dlVar;
        dl dlVar2;
        dl dlVar3;
        TabItemView tabItemView2;
        tabItemView = this.bSw.bSl;
        if (tabItemView != null) {
            dlVar = this.bSw.bSu;
            if (dlVar != null) {
                dlVar2 = this.bSw.bSu;
                if (dlVar2 != null) {
                    dlVar3 = this.bSw.bSu;
                    tabItemView2 = this.bSw.bSl;
                    dlVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.bSw.bSm;
        if (gVar != null) {
            gVar2 = this.bSw.bSm;
            gVar2.hQ(i);
        }
    }
}
