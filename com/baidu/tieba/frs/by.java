package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ bq bGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bq bqVar) {
        this.bGW = bqVar;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        view2 = this.bGW.bGE;
        if (view2 != null) {
            view3 = this.bGW.bGE;
            if (view3.getLayoutParams() != null && i2 != i4) {
                view4 = this.bGW.bGE;
                view4.getLayoutParams().height = i2;
                view5 = this.bGW.bGE;
                view6 = this.bGW.bGE;
                view5.setLayoutParams(view6.getLayoutParams());
            }
        }
    }
}
