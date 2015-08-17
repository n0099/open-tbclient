package com.baidu.tieba.frs.tab;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ HorizontalTabView baR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HorizontalTabView horizontalTabView) {
        this.baR = horizontalTabView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TabItemView tabItemView;
        f fVar;
        f fVar2;
        TabItemView tabItemView2;
        if (view instanceof TabItemView) {
            this.baR.a((TabItemView) view, false);
        }
        tabItemView = this.baR.baJ;
        if (tabItemView != null) {
            fVar = this.baR.baK;
            if (fVar != null) {
                fVar2 = this.baR.baK;
                tabItemView2 = this.baR.baJ;
                fVar2.fB(tabItemView2.getTabId());
            }
        }
    }
}
