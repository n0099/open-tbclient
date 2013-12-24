package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aa aaVar;
        aa aaVar2;
        com.baidu.tieba.ao.a(this.a, "clear_group_msg_at_gsetting");
        this.a.showLoadingDialog(this.a.getString(R.string.deleting));
        com.baidu.tieba.im.db.ad.a().a(new u(this));
        com.baidu.tieba.im.db.d a = com.baidu.tieba.im.db.d.a();
        aaVar = this.a.b;
        a.a(aaVar.c(), new v(this));
        StringBuilder append = new StringBuilder().append("clear cache by group:");
        aaVar2 = this.a.b;
        TiebaSocketLinkService.a(true, append.append(aaVar2.a()).toString());
        dialogInterface.cancel();
    }
}
