package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView caK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.caK = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.caK.a((TabItemView) view, false);
        }
        gVar = this.caK.caA;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.ix(((TabItemView) view).getTabId())) {
                tabItemView = this.caK.caz;
                if (tabItemView != null) {
                    gVar2 = this.caK.caA;
                    tabItemView2 = this.caK.caz;
                    gVar2.iv(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.caK.caA;
            gVar3.iv(((TabItemView) view).getTabId());
        }
    }
}
