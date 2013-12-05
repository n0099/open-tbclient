package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bh implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1566a;
    final /* synthetic */ MsglistActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(MsglistActivity msglistActivity, int i) {
        this.b = msglistActivity;
        this.f1566a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.b.a(this.f1566a);
    }
}
