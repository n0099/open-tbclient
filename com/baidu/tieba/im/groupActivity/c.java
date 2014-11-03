package com.baidu.tieba.im.groupActivity;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements DialogInterface.OnClickListener {
    final /* synthetic */ CreateGroupActivityActivity aYN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(CreateGroupActivityActivity createGroupActivityActivity) {
        this.aYN = createGroupActivityActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.adp.lib.g.j.b((Dialog) dialogInterface, this.aYN);
    }
}
