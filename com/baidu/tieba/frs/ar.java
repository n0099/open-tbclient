package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1261a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(FrsImageActivity frsImageActivity) {
        this.f1261a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i = this.f1261a.j;
        if (i > 240) {
            FrsImageActivity frsImageActivity = this.f1261a;
            i2 = this.f1261a.j;
            frsImageActivity.f(i2 - 240);
        }
    }
}
