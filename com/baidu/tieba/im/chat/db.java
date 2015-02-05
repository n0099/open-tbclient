package com.baidu.tieba.im.chat;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements DialogInterface.OnClickListener {
    private final /* synthetic */ int Mb;
    final /* synthetic */ TalkableActivity aTe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(TalkableActivity talkableActivity, int i) {
        this.aTe = talkableActivity;
        this.Mb = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.g.k.b((Dialog) dialogInterface, this.aTe.getPageContext());
        this.aTe.deleteMsg(this.Mb);
    }
}
