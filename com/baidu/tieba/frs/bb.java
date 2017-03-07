package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ ax bOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ax axVar) {
        this.bOZ = axVar;
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
        view2 = this.bOZ.bON;
        if (view2 != null) {
            view3 = this.bOZ.bON;
            if (view3.getLayoutParams() != null && i2 != i4) {
                view4 = this.bOZ.bON;
                view4.getLayoutParams().height = i2;
                view5 = this.bOZ.bON;
                view6 = this.bOZ.bON;
                view5.setLayoutParams(view6.getLayoutParams());
            }
        }
        frsActivity = this.bOZ.bOq;
        if (frsActivity.Yq() != null) {
            frsActivity2 = this.bOZ.bOq;
            frsActivity2.Yq().p(view, i2);
        }
    }
}
