package com.baidu.tieba.im.chat;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements DialogInterface.OnClickListener {
    final /* synthetic */ TalkableActivity aQq;
    private final /* synthetic */ int aQs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(TalkableActivity talkableActivity, int i) {
        this.aQq = talkableActivity;
        this.aQs = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.aQq);
        this.aQq.reSendMsg(this.aQs);
    }
}
