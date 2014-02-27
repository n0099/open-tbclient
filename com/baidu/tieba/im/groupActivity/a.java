package com.baidu.tieba.im.groupActivity;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements DialogInterface.OnClickListener {
    final /* synthetic */ CreateGroupActivityActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CreateGroupActivityActivity createGroupActivityActivity) {
        this.a = createGroupActivityActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.finish();
    }
}
