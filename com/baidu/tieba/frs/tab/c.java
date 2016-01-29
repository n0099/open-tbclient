package com.baidu.tieba.frs.tab;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ HorizontalTabView boV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.boV = horizontalTabView;
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
                this.boV.a((TabItemView) view, false);
            }
            tabItemView = this.boV.boN;
            if (tabItemView != null) {
                gVar = this.boV.boO;
                if (gVar != null) {
                    gVar2 = this.boV.boO;
                    tabItemView2 = this.boV.boN;
                    gVar2.gK(tabItemView2.getTabId());
                }
            }
            return true;
        } else if (motionEvent == null || motionEvent.getAction() != 3) {
            return false;
        } else {
            iVar = this.boV.boM;
            if (iVar != null) {
                iVar2 = this.boV.boM;
                iVar2.RF();
                return false;
            }
            return false;
        }
    }
}
