package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.text.ClipboardManager;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {
    final /* synthetic */ r a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(r rVar, String str) {
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
            groupInfoActivity2.showToast(com.baidu.tieba.u.copy_success);
        } catch (Exception e) {
            BdLog.e("copy group number failed");
        }
    }
}
