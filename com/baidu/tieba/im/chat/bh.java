package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class bh implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.bo boVar;
        com.baidu.tieba.im.model.bo boVar2;
        bo boVar3;
        com.baidu.tieba.im.model.bo boVar4;
        com.baidu.tieba.im.model.bo boVar5;
        boVar = this.a.d;
        if (boVar == null) {
            this.a.d = new com.baidu.tieba.im.model.bo();
        }
        boVar2 = this.a.d;
        boVar3 = this.a.b;
        boVar2.a(Integer.parseInt(boVar3.b()));
        boVar4 = this.a.d;
        boVar4.b(i);
        boVar5 = this.a.d;
        boVar5.a();
    }
}
