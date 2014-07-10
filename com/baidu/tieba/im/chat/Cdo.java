package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.im.chat.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo implements DialogInterface.OnClickListener {
    final /* synthetic */ TalkableActivity a;
    private final /* synthetic */ int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(TalkableActivity talkableActivity, int i) {
        this.a = talkableActivity;
        this.b = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.b(this.b);
    }
}
