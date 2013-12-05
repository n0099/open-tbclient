package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ax implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1555a;
    final /* synthetic */ MsglistActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(MsglistActivity msglistActivity, int i) {
        this.b = msglistActivity;
        this.f1555a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.b.b(this.f1555a);
    }
}
