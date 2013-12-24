package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class y implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.aj ajVar;
        com.baidu.tieba.im.model.aj ajVar2;
        aa aaVar;
        com.baidu.tieba.im.model.aj ajVar3;
        com.baidu.tieba.im.model.aj ajVar4;
        ajVar = this.a.d;
        if (ajVar == null) {
            this.a.d = new com.baidu.tieba.im.model.aj();
        }
        ajVar2 = this.a.d;
        aaVar = this.a.b;
        ajVar2.a(Integer.parseInt(aaVar.c()));
        ajVar3 = this.a.d;
        ajVar3.b(i);
        ajVar4 = this.a.d;
        ajVar4.a();
    }
}
