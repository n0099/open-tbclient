package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements i.a {
    final /* synthetic */ HorizontalTabView bbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bbl = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.i.a
    public void fM(int i) {
        TabItemView tabItemView;
        f fVar;
        f fVar2;
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        TabItemView tabItemView2;
        tabItemView = this.bbl.bbd;
        if (tabItemView != null) {
            dhVar = this.bbl.bbk;
            if (dhVar != null) {
                dhVar2 = this.bbl.bbk;
                if (dhVar2 != null) {
                    dhVar3 = this.bbl.bbk;
                    tabItemView2 = this.bbl.bbd;
                    dhVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        fVar = this.bbl.bbe;
        if (fVar != null) {
            fVar2 = this.bbl.bbe;
            fVar2.fL(i);
        }
    }
}
