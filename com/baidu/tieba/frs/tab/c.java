package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView cdC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.cdC = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.cdC.a((TabItemView) view, false);
        }
        gVar = this.cdC.cds;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.iu(((TabItemView) view).getTabId())) {
                tabItemView = this.cdC.cdr;
                if (tabItemView != null) {
                    gVar2 = this.cdC.cds;
                    tabItemView2 = this.cdC.cdr;
                    gVar2.is(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.cdC.cds;
            gVar3.is(((TabItemView) view).getTabId());
        }
    }
}
