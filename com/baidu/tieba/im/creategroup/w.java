package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements DialogInterface.OnClickListener {
    final /* synthetic */ v aUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.aUL = vVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.aUL.aUw;
        if (onClickListener != null) {
            onClickListener2 = this.aUL.aUw;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
