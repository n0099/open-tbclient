package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1076a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(FrsImageActivity frsImageActivity) {
        this.f1076a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i = this.f1076a.j;
        if (i > 240) {
            FrsImageActivity frsImageActivity = this.f1076a;
            i2 = this.f1076a.j;
            frsImageActivity.f(i2 - 240);
        }
    }
}
