package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class bl implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.bn bnVar;
        com.baidu.tieba.im.model.bn bnVar2;
        bs bsVar;
        com.baidu.tieba.im.model.bn bnVar3;
        com.baidu.tieba.im.model.bn bnVar4;
        bnVar = this.a.d;
        if (bnVar == null) {
            this.a.d = new com.baidu.tieba.im.model.bn();
        }
        bnVar2 = this.a.d;
        bsVar = this.a.b;
        bnVar2.a(Integer.parseInt(bsVar.b()));
        bnVar3 = this.a.d;
        bnVar3.b(i);
        bnVar4 = this.a.d;
        bnVar4.a();
    }
}
