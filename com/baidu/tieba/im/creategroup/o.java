package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.write.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements DialogInterface.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bz.a(this.a.a);
        } else if (i == 1) {
            bz.b(this.a.a);
        }
    }
}
