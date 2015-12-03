package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.biq = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        TabItemView tabItemView2;
        if (view instanceof TabItemView) {
            this.biq.a((TabItemView) view, false);
        }
        tabItemView = this.biq.bii;
        if (tabItemView != null) {
            gVar = this.biq.bij;
            if (gVar != null) {
                gVar2 = this.biq.bij;
                tabItemView2 = this.biq.bii;
                gVar2.gu(tabItemView2.getTabId());
            }
        }
    }
}
