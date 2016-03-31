package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.tab.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements i.a {
    final /* synthetic */ HorizontalTabView btX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.btX = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.i.a
    public void a(TabItemView tabItemView) {
        this.btX.a(tabItemView, false);
    }
}
