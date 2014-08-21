package com.baidu.tieba.im.live.mylive;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MyLiveActivity myLiveActivity;
        myLiveActivity = this.a.b;
        com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, myLiveActivity);
    }
}
