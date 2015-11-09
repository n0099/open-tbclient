package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.bbL = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        TabItemView tabItemView2;
        if (view instanceof TabItemView) {
            this.bbL.a((TabItemView) view, false);
        }
        tabItemView = this.bbL.bbD;
        if (tabItemView != null) {
            gVar = this.bbL.bbE;
            if (gVar != null) {
                gVar2 = this.bbL.bbE;
                tabItemView2 = this.bbL.bbD;
                gVar2.fY(tabItemView2.getTabId());
            }
        }
    }
}
