package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.mygroup.MyGroupActivity;
/* loaded from: classes.dex */
final class k implements DialogInterface.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.finish();
        MyGroupActivity.a(this.a.a);
    }
}
