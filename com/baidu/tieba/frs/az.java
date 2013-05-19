package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements DialogInterface.OnClickListener {
    final /* synthetic */ ay a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar) {
        this.a = ayVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.e eVar;
        com.baidu.tieba.e eVar2;
        if (i == 0) {
            eVar2 = this.a.a;
            com.baidu.tieba.write.bb.a(eVar2);
        } else if (i == 1) {
            eVar = this.a.a;
            com.baidu.tieba.write.bb.b(eVar);
        }
    }
}
