package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class r implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(GroupSettingActivity groupSettingActivity) {
        this.f1468a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.v vVar;
        com.baidu.tieba.im.model.v vVar2;
        t tVar;
        com.baidu.tieba.im.model.v vVar3;
        com.baidu.tieba.im.model.v vVar4;
        vVar = this.f1468a.d;
        if (vVar == null) {
            this.f1468a.d = new com.baidu.tieba.im.model.v();
        }
        vVar2 = this.f1468a.d;
        tVar = this.f1468a.b;
        vVar2.a(Integer.parseInt(tVar.c()));
        vVar3 = this.f1468a.d;
        vVar3.b(i);
        vVar4 = this.f1468a.d;
        vVar4.a();
    }
}
