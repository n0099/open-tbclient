package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ax bHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ax axVar) {
        this.bHQ = axVar;
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
        view2 = this.bHQ.bHE;
        if (view2 != null) {
            view3 = this.bHQ.bHE;
            if (view3.getLayoutParams() != null && i2 != i4) {
                view4 = this.bHQ.bHE;
                view4.getLayoutParams().height = i2;
                view5 = this.bHQ.bHE;
                view6 = this.bHQ.bHE;
                view5.setLayoutParams(view6.getLayoutParams());
            }
        }
        frsActivity = this.bHQ.bHh;
        if (frsActivity.Xr() != null) {
            frsActivity2 = this.bHQ.bHh;
            frsActivity2.Xr().p(view, i2);
        }
    }
}
