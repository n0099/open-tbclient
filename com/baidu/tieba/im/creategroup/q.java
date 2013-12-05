package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class q implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupAddressLocateActivity f1633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.f1633a = groupAddressLocateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1633a.setResult(0);
        this.f1633a.finish();
    }
}
