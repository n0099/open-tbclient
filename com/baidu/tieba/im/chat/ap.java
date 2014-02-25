package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ap implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.al alVar;
        com.baidu.tieba.im.model.al alVar2;
        aw awVar;
        com.baidu.tieba.im.model.al alVar3;
        com.baidu.tieba.im.model.al alVar4;
        alVar = this.a.d;
        if (alVar == null) {
            this.a.d = new com.baidu.tieba.im.model.al();
        }
        alVar2 = this.a.d;
        awVar = this.a.b;
        alVar2.a(Integer.parseInt(awVar.c()));
        alVar3 = this.a.d;
        alVar3.b(i);
        alVar4 = this.a.d;
        alVar4.a();
    }
}
