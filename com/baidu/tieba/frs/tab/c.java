package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bQy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bQy = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.bQy.a((TabItemView) view, false);
        }
        gVar = this.bQy.bQo;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.hQ(((TabItemView) view).getTabId())) {
                tabItemView = this.bQy.bQn;
                if (tabItemView != null) {
                    gVar2 = this.bQy.bQo;
                    tabItemView2 = this.bQy.bQn;
                    gVar2.hO(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.bQy.bQo;
            gVar3.hO(((TabItemView) view).getTabId());
        }
    }
}
