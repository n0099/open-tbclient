package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.write.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            ba.a(this.a);
        } else if (i == 1) {
            ba.b(this.a);
        }
    }
}
