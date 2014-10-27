package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class t implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupAddressLocateActivity aUx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(GroupAddressLocateActivity groupAddressLocateActivity) {
        this.aUx = groupAddressLocateActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.aUx.setResult(0);
        this.aUx.finish();
    }
}
