package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class aq implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.al alVar;
        com.baidu.tieba.im.model.al alVar2;
        as asVar;
        com.baidu.tieba.im.model.al alVar3;
        com.baidu.tieba.im.model.al alVar4;
        alVar = this.a.d;
        if (alVar == null) {
            this.a.d = new com.baidu.tieba.im.model.al();
        }
        alVar2 = this.a.d;
        asVar = this.a.b;
        alVar2.a(Integer.parseInt(asVar.c()));
        alVar3 = this.a.d;
        alVar3.b(i);
        alVar4 = this.a.d;
        alVar4.a();
    }
}
