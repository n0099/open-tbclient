package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bmg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.bmg = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        TabItemView tabItemView2;
        if (view instanceof TabItemView) {
            this.bmg.a((TabItemView) view, false);
        }
        tabItemView = this.bmg.blY;
        if (tabItemView != null) {
            gVar = this.bmg.blZ;
            if (gVar != null) {
                gVar2 = this.bmg.blZ;
                tabItemView2 = this.bmg.blY;
                gVar2.gn(tabItemView2.getTabId());
            }
        }
    }
}
