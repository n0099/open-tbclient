package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1408a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.f1408a = frsActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f1408a.y();
    }
}
