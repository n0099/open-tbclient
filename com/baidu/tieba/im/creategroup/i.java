package com.baidu.tieba.im.creategroup;

import android.content.DialogInterface;
import com.baidu.tieba.MainTabActivity;
/* loaded from: classes.dex */
class i implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.f1497a = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1497a.f1495a.finish();
        MainTabActivity.a(this.f1497a.f1495a, 1, String.valueOf(1));
    }
}
