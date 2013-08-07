package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsImageActivity frsImageActivity) {
        this.f1060a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i = this.f1060a.j;
        if (i > 240) {
            FrsImageActivity frsImageActivity = this.f1060a;
            i2 = this.f1060a.j;
            frsImageActivity.f(i2 - 240);
        }
    }
}
