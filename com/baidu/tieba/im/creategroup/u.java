package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s f1637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.f1637a = sVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.f1637a.y;
        if (onClickListener != null) {
            onClickListener2 = this.f1637a.y;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
