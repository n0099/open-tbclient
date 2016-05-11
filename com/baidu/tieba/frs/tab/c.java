package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bsU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bsU = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.bsU.a((TabItemView) view, false);
        }
        gVar = this.bsU.bsK;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.gM(((TabItemView) view).getTabId())) {
                tabItemView = this.bsU.bsJ;
                if (tabItemView != null) {
                    gVar2 = this.bsU.bsK;
                    tabItemView2 = this.bsU.bsJ;
                    gVar2.gK(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.bsU.bsK;
            gVar3.gK(((TabItemView) view).getTabId());
        }
    }
}
