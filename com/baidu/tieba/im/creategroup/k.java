package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.mygroup.MyGroupActivity;
/* loaded from: classes.dex */
class k implements DialogInterface.OnClickListener {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.a = iVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.a.finish();
        MyGroupActivity.a(this.a.a);
    }
}
