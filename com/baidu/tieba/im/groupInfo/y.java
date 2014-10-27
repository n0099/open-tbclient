package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.text.ClipboardManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {
    final /* synthetic */ s bbt;
    private final /* synthetic */ String bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(s sVar, String str) {
        this.bbt = sVar;
        this.bbw = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GroupInfoActivity groupInfoActivity;
        GroupInfoActivity groupInfoActivity2;
        try {
            groupInfoActivity = this.bbt.baq;
            ((ClipboardManager) groupInfoActivity.getSystemService("clipboard")).setText(this.bbw);
            groupInfoActivity2 = this.bbt.baq;
            groupInfoActivity2.showToast(com.baidu.tieba.y.copy_success);
        } catch (Exception e) {
        }
    }
}
