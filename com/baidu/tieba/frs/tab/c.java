package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bZl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bZl = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.bZl.a((TabItemView) view, false);
        }
        gVar = this.bZl.bZb;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.iy(((TabItemView) view).getTabId())) {
                tabItemView = this.bZl.bZa;
                if (tabItemView != null) {
                    gVar2 = this.bZl.bZb;
                    tabItemView2 = this.bZl.bZa;
                    gVar2.iw(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.bZl.bZb;
            gVar3.iw(((TabItemView) view).getTabId());
        }
    }
}
