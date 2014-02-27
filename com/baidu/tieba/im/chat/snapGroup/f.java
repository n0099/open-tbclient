package com.baidu.tieba.im.chat.snapGroup;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements DialogInterface.OnCancelListener {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SnapGroupChatActivity snapGroupChatActivity) {
        this.a = snapGroupChatActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.im.model.c cVar;
        cVar = this.a.p;
        cVar.b();
    }
}
