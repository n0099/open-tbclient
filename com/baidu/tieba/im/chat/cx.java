package com.baidu.tieba.im.chat;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements DialogInterface.OnClickListener {
    private final /* synthetic */ int LK;
    final /* synthetic */ TalkableActivity aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(TalkableActivity talkableActivity, int i) {
        this.aRW = talkableActivity;
        this.LK = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.g.k.b((Dialog) dialogInterface, this.aRW.getPageContext());
        this.aRW.reSendMsg(this.LK);
    }
}
