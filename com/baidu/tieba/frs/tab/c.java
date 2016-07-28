package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bSw = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.bSw.a((TabItemView) view, false);
        }
        gVar = this.bSw.bSm;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.hR(((TabItemView) view).getTabId())) {
                tabItemView = this.bSw.bSl;
                if (tabItemView != null) {
                    gVar2 = this.bSw.bSm;
                    tabItemView2 = this.bSw.bSl;
                    gVar2.hP(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.bSw.bSm;
            gVar3.hP(((TabItemView) view).getTabId());
        }
    }
}
