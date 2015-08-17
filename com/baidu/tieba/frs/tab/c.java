package com.baidu.tieba.frs.tab;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ HorizontalTabView baR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.baR = horizontalTabView;
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
        return true;
    }
}
