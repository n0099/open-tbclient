package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bTy = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.bTy.a((TabItemView) view, false);
        }
        gVar = this.bTy.bTo;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.iB(((TabItemView) view).getTabId())) {
                tabItemView = this.bTy.bTn;
                if (tabItemView != null) {
                    gVar2 = this.bTy.bTo;
                    tabItemView2 = this.bTy.bTn;
                    gVar2.iz(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.bTy.bTo;
            gVar3.iz(((TabItemView) view).getTabId());
        }
    }
}
