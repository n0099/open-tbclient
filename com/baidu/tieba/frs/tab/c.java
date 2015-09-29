package com.baidu.tieba.frs.tab;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ HorizontalTabView bbe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bbe = horizontalTabView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        i iVar;
        i iVar2;
        TabItemView tabItemView;
        f fVar;
        f fVar2;
        TabItemView tabItemView2;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            if (view instanceof TabItemView) {
                this.bbe.a((TabItemView) view, false);
            }
            tabItemView = this.bbe.baW;
            if (tabItemView != null) {
                fVar = this.bbe.baX;
                if (fVar != null) {
                    fVar2 = this.bbe.baX;
                    tabItemView2 = this.bbe.baW;
                    fVar2.fP(tabItemView2.getTabId());
                }
            }
            return true;
        } else if (motionEvent == null || motionEvent.getAction() != 3) {
            return false;
        } else {
            iVar = this.bbe.baV;
            if (iVar != null) {
                iVar2 = this.bbe.baV;
                iVar2.Nm();
                return false;
            }
            return false;
        }
    }
}
