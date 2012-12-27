package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ao aoVar;
        int i;
        aoVar = this.a.t;
        if (aoVar == ao.NEXT) {
            FrsImageActivity frsImageActivity = this.a;
            i = this.a.v;
            frsImageActivity.c(i + 240);
        }
    }
}
