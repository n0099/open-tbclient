package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bh implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.bt btVar;
        com.baidu.tieba.im.model.bt btVar2;
        bo boVar;
        com.baidu.tieba.im.model.bt btVar3;
        com.baidu.tieba.im.model.bt btVar4;
        btVar = this.a.d;
        if (btVar == null) {
            this.a.d = new com.baidu.tieba.im.model.bt();
        }
        btVar2 = this.a.d;
        boVar = this.a.b;
        btVar2.a(Integer.parseInt(boVar.b()));
        btVar3 = this.a.d;
        btVar3.b(i);
        btVar4 = this.a.d;
        btVar4.a();
    }
}
