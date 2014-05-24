package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bg implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.bu buVar;
        com.baidu.tieba.im.model.bu buVar2;
        bn bnVar;
        com.baidu.tieba.im.model.bu buVar3;
        com.baidu.tieba.im.model.bu buVar4;
        buVar = this.a.d;
        if (buVar == null) {
            this.a.d = new com.baidu.tieba.im.model.bu();
        }
        buVar2 = this.a.d;
        bnVar = this.a.b;
        buVar2.a(Integer.parseInt(bnVar.b()));
        buVar3 = this.a.d;
        buVar3.b(i);
        buVar4 = this.a.d;
        buVar4.a();
    }
}
