package com.baidu.tieba.frs.tab;

import com.baidu.tieba.frs.tab.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements k.a {
    final /* synthetic */ HorizontalTabView cfF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.cfF = horizontalTabView;
    }

    @Override // com.baidu.tieba.frs.tab.k.a
    public void a(TabItemView tabItemView) {
        this.cfF.a(tabItemView, false);
    }
}
