package com.baidu.tieba.frs.tab;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ HorizontalTabView biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.biq = horizontalTabView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        i iVar;
        i iVar2;
        TabItemView tabItemView;
        g gVar;
        g gVar2;
        TabItemView tabItemView2;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            if (view instanceof TabItemView) {
                this.biq.a((TabItemView) view, false);
            }
            tabItemView = this.biq.bii;
            if (tabItemView != null) {
                gVar = this.biq.bij;
                if (gVar != null) {
                    gVar2 = this.biq.bij;
                    tabItemView2 = this.biq.bii;
                    gVar2.gu(tabItemView2.getTabId());
                }
            }
            return true;
        } else if (motionEvent == null || motionEvent.getAction() != 3) {
            return false;
        } else {
            iVar = this.biq.bih;
            if (iVar != null) {
                iVar2 = this.biq.bih;
                iVar2.Pj();
                return false;
            }
            return false;
        }
    }
}
