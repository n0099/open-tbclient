package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1331a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(FrsImageActivity frsImageActivity) {
        this.f1331a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i = this.f1331a.i;
        if (i > 240) {
            FrsImageActivity frsImageActivity = this.f1331a;
            i2 = this.f1331a.i;
            frsImageActivity.c(i2 - 240);
        }
    }
}
