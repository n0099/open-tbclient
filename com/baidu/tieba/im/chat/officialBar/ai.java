package com.baidu.tieba.im.chat.officialBar;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ai implements DialogInterface.OnClickListener {
    final /* synthetic */ OfficialBarInfoActivity aRJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(OfficialBarInfoActivity officialBarInfoActivity) {
        this.aRJ = officialBarInfoActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
