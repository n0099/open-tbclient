package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView cdA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.cdA = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.cdA.a((TabItemView) view, false);
        }
        gVar = this.cdA.cdq;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.iz(((TabItemView) view).getTabId())) {
                tabItemView = this.cdA.cdp;
                if (tabItemView != null) {
                    gVar2 = this.cdA.cdq;
                    tabItemView2 = this.cdA.cdp;
                    gVar2.ix(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.cdA.cdq;
            gVar3.ix(((TabItemView) view).getTabId());
        }
    }
}
