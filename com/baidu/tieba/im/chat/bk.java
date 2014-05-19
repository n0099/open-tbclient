package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
class bk implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bo boVar;
        bo boVar2;
        com.baidu.tbadk.core.g.a(this.a, "clear_group_msg_at_gsetting");
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.u.deleting));
        boVar = this.a.b;
        ImMessageCenterPojo a = com.baidu.tieba.im.b.e.a(boVar.b());
        if (a != null) {
            a.setLast_content(" ");
            a.setLast_user_name(" ");
            a.setLast_rid(0L);
        }
        com.baidu.tieba.im.i.a(new bl(this), new bm(this));
        com.baidu.adp.framework.c.c a2 = com.baidu.adp.framework.c.c.a();
        StringBuilder sb = new StringBuilder("clear cache by group:");
        boVar2 = this.a.b;
        a2.a(true, sb.append(boVar2.a()).toString());
        dialogInterface.cancel();
    }
}
