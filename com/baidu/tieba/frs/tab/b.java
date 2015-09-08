package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.bbl = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TabItemView tabItemView;
        f fVar;
        f fVar2;
        TabItemView tabItemView2;
        if (view instanceof TabItemView) {
            this.bbl.a((TabItemView) view, false);
        }
        tabItemView = this.bbl.bbd;
        if (tabItemView != null) {
            fVar = this.bbl.bbe;
            if (fVar != null) {
                fVar2 = this.bbl.bbe;
                tabItemView2 = this.bbl.bbd;
                fVar2.fK(tabItemView2.getTabId());
            }
        }
    }
}
