package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements com.baidu.tbadk.widget.layout.i {
    final /* synthetic */ au bUk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(au auVar) {
        this.bUk = auVar;
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
        view2 = this.bUk.bTV;
        if (view2 != null) {
            view3 = this.bUk.bTV;
            if (view3.getLayoutParams() != null && i2 != i4) {
                view4 = this.bUk.bTV;
                view4.getLayoutParams().height = i2;
                view5 = this.bUk.bTV;
                view6 = this.bUk.bTV;
                view5.setLayoutParams(view6.getLayoutParams());
            }
        }
        frsActivity = this.bUk.bTA;
        if (frsActivity.abL() != null) {
            frsActivity2 = this.bUk.bTA;
            frsActivity2.abL().r(view, i2);
        }
    }
}
