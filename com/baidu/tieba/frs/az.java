package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i = this.a.i;
        if (i > 240) {
            FrsImageActivity frsImageActivity = this.a;
            i2 = this.a.i;
            frsImageActivity.c(i2 - 240);
        }
    }
}
