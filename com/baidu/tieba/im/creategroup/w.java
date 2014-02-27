package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w implements DialogInterface.OnClickListener {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.a = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.a.z;
        if (onClickListener != null) {
            onClickListener2 = this.a.z;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
