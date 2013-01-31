package com.baidu.tieba.account;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements DialogInterface.OnCancelListener {
    final /* synthetic */ RegisterActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(RegisterActivity registerActivity) {
        this.a = registerActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.a.c();
        this.a.o();
    }
}
