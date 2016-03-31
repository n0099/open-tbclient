package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView btX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.btX = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar;
        TabItemView tabItemView;
        g gVar2;
        TabItemView tabItemView2;
        g gVar3;
        if (view instanceof TabItemView) {
            this.btX.a((TabItemView) view, false);
        }
        gVar = this.btX.btP;
        if (gVar != null) {
            if (!(view instanceof TabItemView) || !HorizontalTabView.hd(((TabItemView) view).getTabId())) {
                tabItemView = this.btX.btO;
                if (tabItemView != null) {
                    gVar2 = this.btX.btP;
                    tabItemView2 = this.btX.btO;
                    gVar2.hb(tabItemView2.getTabId());
                    return;
                }
                return;
            }
            gVar3 = this.btX.btP;
            gVar3.hb(((TabItemView) view).getTabId());
        }
    }
}
