package com.baidu.tieba.im.chat.snapGroup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.baidu.tieba.im.chat.MsglistActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements DialogInterface.OnClickListener {
    final /* synthetic */ SnapGroupChatView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SnapGroupChatView snapGroupChatView) {
        this.a = snapGroupChatView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        MsglistActivity msglistActivity;
        alertDialog = this.a.m;
        msglistActivity = this.a.f;
        com.baidu.adp.lib.e.e.b(alertDialog, msglistActivity);
    }
}
