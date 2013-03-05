package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.write.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bb.a(this.a);
        } else if (i == 1) {
            bb.b(this.a);
        }
    }
}
