package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView cbC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.cbC = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.cbC.a((TabItemView) view, false);
        }
        gVar = this.cbC.cbs;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.iE(((TabItemView) view).getTabId())) {
                tabItemView = this.cbC.cbr;
                if (tabItemView != null) {
                    gVar2 = this.cbC.cbs;
                    tabItemView2 = this.cbC.cbr;
                    gVar2.iC(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.cbC.cbs;
            gVar3.iC(((TabItemView) view).getTabId());
        }
    }
}
