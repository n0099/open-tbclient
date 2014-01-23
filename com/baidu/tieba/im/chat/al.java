package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        as asVar;
        as asVar2;
        com.baidu.tieba.ao.a(this.a, "clear_group_msg_at_gsetting");
        this.a.showLoadingDialog(this.a.getString(R.string.deleting));
        com.baidu.tieba.im.db.ae.a().a(new am(this));
        com.baidu.tieba.im.db.d a = com.baidu.tieba.im.db.d.a();
        asVar = this.a.b;
        a.a(asVar.c(), new an(this));
        StringBuilder append = new StringBuilder().append("clear cache by group:");
        asVar2 = this.a.b;
        TiebaSocketLinkService.a(true, append.append(asVar2.a()).toString());
        dialogInterface.cancel();
    }
}
