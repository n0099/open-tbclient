package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class s implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1605a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(GroupSettingActivity groupSettingActivity) {
        this.f1605a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.y yVar;
        com.baidu.tieba.im.model.y yVar2;
        u uVar;
        com.baidu.tieba.im.model.y yVar3;
        com.baidu.tieba.im.model.y yVar4;
        yVar = this.f1605a.d;
        if (yVar == null) {
            this.f1605a.d = new com.baidu.tieba.im.model.y();
        }
        yVar2 = this.f1605a.d;
        uVar = this.f1605a.b;
        yVar2.a(Integer.parseInt(uVar.c()));
        yVar3 = this.f1605a.d;
        yVar3.b(i);
        yVar4 = this.f1605a.d;
        yVar4.a();
    }
}
