package com.baidu.tieba.frs.tab;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ HorizontalTabView bmg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bmg = horizontalTabView;
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
                this.bmg.a((TabItemView) view, false);
            }
            tabItemView = this.bmg.blY;
            if (tabItemView != null) {
                gVar = this.bmg.blZ;
                if (gVar != null) {
                    gVar2 = this.bmg.blZ;
                    tabItemView2 = this.bmg.blY;
                    gVar2.gn(tabItemView2.getTabId());
                }
            }
            return true;
        } else if (motionEvent == null || motionEvent.getAction() != 3) {
            return false;
        } else {
            iVar = this.bmg.blX;
            if (iVar != null) {
                iVar2 = this.bmg.blX;
                iVar2.PB();
                return false;
            }
            return false;
        }
    }
}
