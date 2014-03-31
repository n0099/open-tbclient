package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
final class bo implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        bs bsVar;
        bs bsVar2;
        com.baidu.tbadk.core.g.a(this.a, "clear_group_msg_at_gsetting");
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.im.j.deleting));
        bsVar = this.a.b;
        ImMessageCenterPojo a = com.baidu.tieba.im.b.e.a(bsVar.b());
        if (a != null) {
            a.setLast_content(" ");
            a.setLast_user_name(" ");
            a.setLast_rid(0L);
        }
        com.baidu.tieba.im.s.a(new bp(this), new bq(this));
        com.baidu.adp.framework.e.c.a();
        StringBuilder sb = new StringBuilder("clear cache by group:");
        bsVar2 = this.a.b;
        com.baidu.adp.framework.e.c.a(true, sb.append(bsVar2.a()).toString());
        dialogInterface.cancel();
    }
}
