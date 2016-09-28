package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ bm bRV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bm bmVar) {
        this.bRV = bmVar;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        view2 = this.bRV.bRE;
        if (view2 != null) {
            view3 = this.bRV.bRE;
            if (view3.getLayoutParams() != null && i2 != i4) {
                view4 = this.bRV.bRE;
                view4.getLayoutParams().height = i2;
                view5 = this.bRV.bRE;
                view6 = this.bRV.bRE;
                view5.setLayoutParams(view6.getLayoutParams());
            }
        }
    }
}
