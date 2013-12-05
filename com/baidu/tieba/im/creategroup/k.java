package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.im.mygroup.MyGroupActivity;
/* loaded from: classes.dex */
class k implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1627a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.f1627a = iVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1627a.f1625a.finish();
        MyGroupActivity.a(this.f1627a.f1625a);
    }
}
