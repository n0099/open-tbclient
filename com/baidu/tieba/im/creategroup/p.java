package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupAddressLocateActivity f1632a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.f1632a = groupAddressLocateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1632a.e();
    }
}
