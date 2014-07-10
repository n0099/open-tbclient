package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.text.ClipboardManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements DialogInterface.OnClickListener {
    final /* synthetic */ r a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar, String str) {
        this.a = rVar;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GroupInfoActivity groupInfoActivity;
        GroupInfoActivity groupInfoActivity2;
        try {
            groupInfoActivity = this.a.c;
            ((ClipboardManager) groupInfoActivity.getSystemService("clipboard")).setText(this.b);
            groupInfoActivity2 = this.a.c;
            groupInfoActivity2.showToast(com.baidu.tieba.y.copy_success);
        } catch (Exception e) {
        }
    }
}
