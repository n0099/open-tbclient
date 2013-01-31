package com.baidu.tieba.c;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class aj implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
