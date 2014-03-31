package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.text.ClipboardManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements DialogInterface.OnClickListener {
    final /* synthetic */ r a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(r rVar, String str) {
        this.a = rVar;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        GroupInfoActivity groupInfoActivity;
        GroupInfoActivity groupInfoActivity2;
        try {
            groupInfoActivity = this.a.d;
            ((ClipboardManager) groupInfoActivity.getSystemService("clipboard")).setText(this.b);
            groupInfoActivity2 = this.a.d;
            groupInfoActivity2.showToast(com.baidu.tieba.im.j.copy_success);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("copy group number failed");
        }
    }
}
