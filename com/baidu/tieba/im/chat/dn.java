package com.baidu.tieba.im.chat;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements DialogInterface.OnClickListener {
    final /* synthetic */ TalkableActivity a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(TalkableActivity talkableActivity, int i) {
        this.a = talkableActivity;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.e.e.b((Dialog) dialogInterface, this.a);
        this.a.b(this.b);
    }
}
