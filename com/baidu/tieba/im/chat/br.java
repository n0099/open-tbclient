package com.baidu.tieba.im.chat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements DialogInterface.OnClickListener {
    final /* synthetic */ bp aOU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar) {
        this.aOU = bpVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        Context context;
        alertDialog = this.aOU.aOS;
        context = this.aOU.mContext;
        com.baidu.adp.lib.g.j.b(alertDialog, (Activity) context);
    }
}
