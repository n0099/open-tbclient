package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar;
        int i;
        anVar = this.a.t;
        if (anVar == an.NEXT) {
            FrsImageActivity frsImageActivity = this.a;
            i = this.a.v;
            frsImageActivity.e(i + 240);
        }
    }
}
