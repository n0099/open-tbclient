package com.baidu.tieba.home;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class i implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f1453a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f1453a = hVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        EnterForumActivity.b = false;
    }
}
