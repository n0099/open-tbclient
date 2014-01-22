package com.baidu.tieba.im.chat.snapGroup;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements DialogInterface.OnClickListener {
    final /* synthetic */ SnapGroupChatView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SnapGroupChatView snapGroupChatView) {
        this.a = snapGroupChatView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.a.j;
        alertDialog.dismiss();
    }
}
