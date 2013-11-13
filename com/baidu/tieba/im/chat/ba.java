package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ba implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1521a;
    final /* synthetic */ MsglistActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(MsglistActivity msglistActivity, int i) {
        this.b = msglistActivity;
        this.f1521a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.b.a(this.f1521a);
    }
}
