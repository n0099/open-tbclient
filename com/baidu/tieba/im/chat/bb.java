package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bb implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1522a;
    final /* synthetic */ MsglistActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(MsglistActivity msglistActivity, int i) {
        this.b = msglistActivity;
        this.f1522a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.b.b(this.f1522a);
    }
}
