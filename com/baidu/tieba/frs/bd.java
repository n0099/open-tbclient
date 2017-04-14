package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ az bOO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(az azVar) {
        this.bOO = azVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        View view2;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        View view3;
        View view4;
        View view5;
        View view6;
        view2 = this.bOO.bOC;
        if (view2 != null) {
            view3 = this.bOO.bOC;
            if (view3.getLayoutParams() != null && i2 != i4) {
                view4 = this.bOO.bOC;
                view4.getLayoutParams().height = i2;
                view5 = this.bOO.bOC;
                view6 = this.bOO.bOC;
                view5.setLayoutParams(view6.getLayoutParams());
            }
        }
        frsActivity = this.bOO.bOf;
        if (frsActivity.YN() != null) {
            frsActivity2 = this.bOO.bOf;
            frsActivity2.YN().p(view, i2);
        }
    }
}
