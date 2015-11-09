package com.baidu.tieba.frs.tab;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ HorizontalTabView bbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bbL = horizontalTabView;
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
                this.bbL.a((TabItemView) view, false);
            }
            tabItemView = this.bbL.bbD;
            if (tabItemView != null) {
                gVar = this.bbL.bbE;
                if (gVar != null) {
                    gVar2 = this.bbL.bbE;
                    tabItemView2 = this.bbL.bbD;
                    gVar2.fY(tabItemView2.getTabId());
                }
            }
            return true;
        } else if (motionEvent == null || motionEvent.getAction() != 3) {
            return false;
        } else {
            iVar = this.bbL.bbC;
            if (iVar != null) {
                iVar2 = this.bbL.bbC;
                iVar2.ND();
                return false;
            }
            return false;
        }
    }
}
