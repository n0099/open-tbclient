package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aw awVar;
        int i;
        awVar = this.a.h;
        if (awVar == aw.NEXT) {
            FrsImageActivity frsImageActivity = this.a;
            i = this.a.j;
            frsImageActivity.e(i + 240);
        }
    }
}
