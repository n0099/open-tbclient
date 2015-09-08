package com.baidu.tieba.frs.tab;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ HorizontalTabView bbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bbl = horizontalTabView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TabItemView tabItemView;
        f fVar;
        f fVar2;
        TabItemView tabItemView2;
        if (motionEvent == null || motionEvent.getAction() != 0) {
            return false;
        }
        if (view instanceof TabItemView) {
            this.bbl.a((TabItemView) view, false);
        }
        tabItemView = this.bbl.bbd;
        if (tabItemView != null) {
            fVar = this.bbl.bbe;
            if (fVar != null) {
                fVar2 = this.bbl.bbe;
                tabItemView2 = this.bbl.bbd;
                fVar2.fK(tabItemView2.getTabId());
            }
        }
        return true;
    }
}
