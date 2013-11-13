package com.baidu.tieba.account.appeal;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f1046a;
    final /* synthetic */ AppealActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AppealActivity appealActivity, boolean z) {
        this.b = appealActivity;
        this.f1046a = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.f1046a) {
            this.b.finish();
        }
    }
}
