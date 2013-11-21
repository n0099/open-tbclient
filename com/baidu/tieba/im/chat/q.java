package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class q implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1550a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(GroupSettingActivity groupSettingActivity) {
        this.f1550a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.v vVar;
        com.baidu.tieba.im.model.v vVar2;
        s sVar;
        com.baidu.tieba.im.model.v vVar3;
        com.baidu.tieba.im.model.v vVar4;
        vVar = this.f1550a.d;
        if (vVar == null) {
            this.f1550a.d = new com.baidu.tieba.im.model.v();
        }
        vVar2 = this.f1550a.d;
        sVar = this.f1550a.b;
        vVar2.a(Integer.parseInt(sVar.c()));
        vVar3 = this.f1550a.d;
        vVar3.b(i);
        vVar4 = this.f1550a.d;
        vVar4.a();
    }
}
