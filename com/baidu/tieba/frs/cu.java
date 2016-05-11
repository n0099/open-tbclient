package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ cn bkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cn cnVar) {
        this.bkx = cnVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        view2 = this.bkx.bkg;
        if (view2 != null) {
            view3 = this.bkx.bkg;
            if (view3.getLayoutParams() != null && i2 != i4) {
                view4 = this.bkx.bkg;
                view4.getLayoutParams().height = i2;
                view5 = this.bkx.bkg;
                view6 = this.bkx.bkg;
                view5.setLayoutParams(view6.getLayoutParams());
            }
        }
    }
}
