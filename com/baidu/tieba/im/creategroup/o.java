package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.write.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements DialogInterface.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            by.a(this.a.a);
        } else if (i == 1) {
            by.b(this.a.a);
        }
    }
}
