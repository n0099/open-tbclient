package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.tab.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements j.a {
    final /* synthetic */ HorizontalTabView cdC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.cdC = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.j.a
    public void a(TabItemView tabItemView) {
        this.cdC.a(tabItemView, false);
    }
}
