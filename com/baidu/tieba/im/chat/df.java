package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df implements DialogInterface.OnClickListener {
    final /* synthetic */ TalkableActivity a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(TalkableActivity talkableActivity, int i) {
        this.a = talkableActivity;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.a(this.b);
    }
}
