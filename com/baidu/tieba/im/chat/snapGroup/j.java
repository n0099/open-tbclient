package com.baidu.tieba.im.chat.snapGroup;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements DialogInterface.OnClickListener {
    final /* synthetic */ SnapGroupChatView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SnapGroupChatView snapGroupChatView) {
        this.a = snapGroupChatView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.a.l;
        alertDialog.dismiss();
    }
}
