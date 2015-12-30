package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {
    final /* synthetic */ HorizontalTabView bmg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bmg = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.i.a
    public void gp(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        eu euVar;
        eu euVar2;
        eu euVar3;
        TabItemView tabItemView2;
        tabItemView = this.bmg.blY;
        if (tabItemView != null) {
            euVar = this.bmg.bme;
            if (euVar != null) {
                euVar2 = this.bmg.bme;
                if (euVar2 != null) {
                    euVar3 = this.bmg.bme;
                    tabItemView2 = this.bmg.blY;
                    euVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.bmg.blZ;
        if (gVar != null) {
            gVar2 = this.bmg.blZ;
            gVar2.go(i);
        }
    }
}
