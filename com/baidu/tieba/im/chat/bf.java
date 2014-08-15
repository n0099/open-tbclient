package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bf implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.ax axVar;
        com.baidu.tieba.im.model.ax axVar2;
        bm bmVar;
        com.baidu.tieba.im.model.ax axVar3;
        com.baidu.tieba.im.model.ax axVar4;
        axVar = this.a.d;
        if (axVar == null) {
            this.a.d = new com.baidu.tieba.im.model.ax(this.a);
        }
        axVar2 = this.a.d;
        bmVar = this.a.b;
        axVar2.a(Integer.parseInt(bmVar.b()));
        axVar3 = this.a.d;
        axVar3.b(i);
        axVar4 = this.a.d;
        axVar4.a();
    }
}
