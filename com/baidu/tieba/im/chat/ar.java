package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ar implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aw awVar;
        aw awVar2;
        aw awVar3;
        com.baidu.tieba.ai.a(this.a, "clear_group_msg_at_gsetting");
        this.a.showLoadingDialog(this.a.getString(R.string.deleting));
        com.baidu.tieba.im.db.d d = com.baidu.tieba.im.db.h.a().d();
        awVar = this.a.b;
        if (awVar != null) {
            awVar3 = this.a.b;
            ImMessageCenterPojo a = d.a(awVar3.c());
            if (a != null) {
                a.setLast_content(" ");
                a.setLast_user_name(" ");
                a.setLast_rid(0L);
                d.a(a);
            }
        }
        com.baidu.tieba.im.j.a(new as(this), new at(this));
        StringBuilder sb = new StringBuilder("clear cache by group:");
        awVar2 = this.a.b;
        TiebaSocketLinkService.a(true, sb.append(awVar2.a()).toString());
        dialogInterface.cancel();
    }
}
