package com.baidu.tieba.im.randchat;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements DialogInterface.OnClickListener {
    final /* synthetic */ WaittingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(WaittingActivity waittingActivity) {
        this.a = waittingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        WaittingActivity.f(this.a);
    }
}
