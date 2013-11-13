package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class am implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1406a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.f1406a = akVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        i2 = this.f1406a.f1404a.B;
        if (i2 == 0) {
            DatabaseService.q();
            this.f1406a.f1404a.f();
            return;
        }
        DatabaseService.r();
        this.f1406a.f1404a.h();
    }
}
