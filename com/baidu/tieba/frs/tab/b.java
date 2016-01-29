package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView boV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.boV = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        TabItemView tabItemView2;
        if (view instanceof TabItemView) {
            this.boV.a((TabItemView) view, false);
        }
        tabItemView = this.boV.boN;
        if (tabItemView != null) {
            gVar = this.boV.boO;
            if (gVar != null) {
                gVar2 = this.boV.boO;
                tabItemView2 = this.boV.boN;
                gVar2.gK(tabItemView2.getTabId());
            }
        }
    }
}
