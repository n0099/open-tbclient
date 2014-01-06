package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class s implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupAddressLocateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.a = groupAddressLocateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.setResult(0);
        this.a.finish();
    }
}
