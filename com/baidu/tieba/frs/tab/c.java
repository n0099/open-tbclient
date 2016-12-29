package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bNk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bNk = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.bNk.a((TabItemView) view, false);
        }
        gVar = this.bNk.bNa;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.hO(((TabItemView) view).getTabId())) {
                tabItemView = this.bNk.bMZ;
                if (tabItemView != null) {
                    gVar2 = this.bNk.bNa;
                    tabItemView2 = this.bNk.bMZ;
                    gVar2.hM(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.bNk.bNa;
            gVar3.hM(((TabItemView) view).getTabId());
        }
    }
}
