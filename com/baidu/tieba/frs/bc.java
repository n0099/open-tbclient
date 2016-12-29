package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ax bAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ax axVar) {
        this.bAv = axVar;
    }

    @Override // com.baidu.tbadk.widget.layout.i
    public void a(View view, int i, int i2, int i3, int i4) {
        View view2;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        View view3;
        View view4;
        View view5;
        View view6;
        view2 = this.bAv.bAg;
        if (view2 != null) {
            view3 = this.bAv.bAg;
            if (view3.getLayoutParams() != null && i2 != i4) {
                view4 = this.bAv.bAg;
                view4.getLayoutParams().height = i2;
                view5 = this.bAv.bAg;
                view6 = this.bAv.bAg;
                view5.setLayoutParams(view6.getLayoutParams());
            }
        }
        frsActivity = this.bAv.bzH;
        if (frsActivity.Wa() != null) {
            frsActivity2 = this.bAv.bzH;
            frsActivity2.Wa().p(view, i2);
        }
    }
}
