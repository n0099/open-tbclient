package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.text.ClipboardManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {
    final /* synthetic */ t bbH;
    private final /* synthetic */ String bbJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar, String str) {
        this.bbH = tVar;
        this.bbJ = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GroupInfoActivity groupInfoActivity;
        GroupInfoActivity groupInfoActivity2;
        try {
            groupInfoActivity = this.bbH.baF;
            ((ClipboardManager) groupInfoActivity.getSystemService("clipboard")).setText(this.bbJ);
            groupInfoActivity2 = this.bbH.baF;
            groupInfoActivity2.showToast(com.baidu.tieba.y.copy_success);
        } catch (Exception e) {
        }
    }
}
