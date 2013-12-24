package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.write.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements DialogInterface.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == 0) {
            bd.a(this.a.a);
        } else if (i == 1) {
            bd.b(this.a.a);
        }
    }
}
