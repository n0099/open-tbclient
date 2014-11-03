package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class s implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupAddressLocateActivity aUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aUL = groupAddressLocateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.aUL.Md();
    }
}
