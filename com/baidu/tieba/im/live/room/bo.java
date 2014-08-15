package com.baidu.tieba.im.live.room;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements DialogInterface.OnClickListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.a.r;
        if (onClickListener != null) {
            onClickListener2 = this.a.r;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
