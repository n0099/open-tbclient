package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView bbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.bbp = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TabItemView tabItemView;
        f fVar;
        f fVar2;
        TabItemView tabItemView2;
        if (view instanceof TabItemView) {
            this.bbp.a((TabItemView) view, false);
        }
        tabItemView = this.bbp.bbh;
        if (tabItemView != null) {
            fVar = this.bbp.bbi;
            if (fVar != null) {
                fVar2 = this.bbp.bbi;
                tabItemView2 = this.bbp.bbh;
                fVar2.fP(tabItemView2.getTabId());
            }
        }
    }
}
