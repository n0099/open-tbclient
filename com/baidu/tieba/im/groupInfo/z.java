package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.text.ClipboardManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {
    final /* synthetic */ t bbH;
    private final /* synthetic */ String bbK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(t tVar, String str) {
        this.bbH = tVar;
        this.bbK = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GroupInfoActivity groupInfoActivity;
        GroupInfoActivity groupInfoActivity2;
        try {
            groupInfoActivity = this.bbH.baF;
            ((ClipboardManager) groupInfoActivity.getSystemService("clipboard")).setText(this.bbK);
            groupInfoActivity2 = this.bbH.baF;
            groupInfoActivity2.showToast(com.baidu.tieba.y.copy_success);
        } catch (Exception e) {
        }
    }
}
