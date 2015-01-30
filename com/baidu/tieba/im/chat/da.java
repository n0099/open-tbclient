package com.baidu.tieba.im.chat;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements DialogInterface.OnClickListener {
    private final /* synthetic */ int Me;
    final /* synthetic */ TalkableActivity aTf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(TalkableActivity talkableActivity, int i) {
        this.aTf = talkableActivity;
        this.Me = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.g.k.b((Dialog) dialogInterface, this.aTf.getPageContext());
        this.aTf.reSendMsg(this.Me);
    }
}
