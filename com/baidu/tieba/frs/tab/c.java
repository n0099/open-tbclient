package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView chB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.chB = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.chB.a((TabItemView) view, false);
        }
        gVar = this.chB.chr;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.iE(((TabItemView) view).getTabId())) {
                tabItemView = this.chB.chq;
                if (tabItemView != null) {
                    gVar2 = this.chB.chr;
                    tabItemView2 = this.chB.chq;
                    gVar2.iC(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.chB.chr;
            gVar3.iC(((TabItemView) view).getTabId());
        }
    }
}
