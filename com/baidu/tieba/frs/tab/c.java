package com.baidu.tieba.frs.tab;

import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnTouchListener {
    final /* synthetic */ HorizontalTabView bbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(HorizontalTabView horizontalTabView) {
        this.bbp = horizontalTabView;
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
            return true;
        } else if (motionEvent == null || motionEvent.getAction() != 3) {
            return false;
        } else {
            iVar = this.bbp.bbg;
            if (iVar != null) {
                iVar2 = this.bbp.bbg;
                iVar2.Ni();
                return false;
            }
            return false;
        }
    }
}
