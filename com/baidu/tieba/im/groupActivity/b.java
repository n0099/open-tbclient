package com.baidu.tieba.im.groupActivity;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements DialogInterface.OnClickListener {
    final /* synthetic */ CreateGroupActivityActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(CreateGroupActivityActivity createGroupActivityActivity) {
        this.a = createGroupActivityActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
