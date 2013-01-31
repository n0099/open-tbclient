package com.baidu.tieba.c;

import android.app.Activity;
import android.content.DialogInterface;
/* loaded from: classes.dex */
class ai implements DialogInterface.OnClickListener {
    private final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(Activity activity) {
        this.a = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.a.finish();
    }
}
