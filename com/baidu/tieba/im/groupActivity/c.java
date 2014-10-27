package com.baidu.tieba.im.groupActivity;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {
    final /* synthetic */ CreateGroupActivityActivity aYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CreateGroupActivityActivity createGroupActivityActivity) {
        this.aYA = createGroupActivityActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.aYA);
    }
}
