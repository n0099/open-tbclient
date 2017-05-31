package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.tab.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements k.b {
    final /* synthetic */ HorizontalTabView cfF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.cfF = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.k.b
    public void iV(int i) {
        TabItemView tabItemView;
        h hVar;
        h hVar2;
        by byVar;
        by byVar2;
        by byVar3;
        TabItemView tabItemView2;
        tabItemView = this.cfF.cfr;
        if (tabItemView != null) {
            byVar = this.cfF.cfD;
            if (byVar != null) {
                byVar2 = this.cfF.cfD;
                if (byVar2 != null) {
                    byVar3 = this.cfF.cfD;
                    tabItemView2 = this.cfF.cfr;
                    byVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        hVar = this.cfF.cfs;
        if (hVar != null) {
            hVar2 = this.cfF.cfs;
            hVar2.iT(i);
        }
    }
}
