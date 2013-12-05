package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1407a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.f1407a = frsActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1407a.y();
    }
}
