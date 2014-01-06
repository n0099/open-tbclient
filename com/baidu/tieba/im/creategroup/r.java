package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class r implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupAddressLocateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.a = groupAddressLocateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.e();
    }
}
