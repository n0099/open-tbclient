package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements j.b {
    final /* synthetic */ HorizontalTabView bZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HorizontalTabView horizontalTabView) {
        this.bZl = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.b
    public void iz(int i) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        cd cdVar;
        cd cdVar2;
        cd cdVar3;
        TabItemView tabItemView2;
        tabItemView = this.bZl.bZa;
        if (tabItemView != null) {
            cdVar = this.bZl.bZj;
            if (cdVar != null) {
                cdVar2 = this.bZl.bZj;
                if (cdVar2 != null) {
                    cdVar3 = this.bZl.bZj;
                    tabItemView2 = this.bZl.bZa;
                    cdVar3.a(tabItemView2.getTabId(), i, null);
                }
            }
        }
        gVar = this.bZl.bZb;
        if (gVar != null) {
            gVar2 = this.bZl.bZb;
            gVar2.ix(i);
        }
    }
}
