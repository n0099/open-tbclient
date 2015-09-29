package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.bbe = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TabItemView tabItemView;
        f fVar;
        f fVar2;
        TabItemView tabItemView2;
        if (view instanceof TabItemView) {
            this.bbe.a((TabItemView) view, false);
        }
        tabItemView = this.bbe.baW;
        if (tabItemView != null) {
            fVar = this.bbe.baX;
            if (fVar != null) {
                fVar2 = this.bbe.baX;
                tabItemView2 = this.bbe.baW;
                fVar2.fP(tabItemView2.getTabId());
            }
        }
    }
}
