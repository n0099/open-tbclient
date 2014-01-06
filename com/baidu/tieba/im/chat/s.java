package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.baidu.tieba.im.net.TiebaSocketLinkService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(GroupSettingActivity groupSettingActivity) {
        this.a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        z zVar;
        z zVar2;
        com.baidu.tieba.ap.a(this.a, "clear_group_msg_at_gsetting");
        this.a.showLoadingDialog(this.a.getString(R.string.deleting));
        com.baidu.tieba.im.db.ad.a().a(new t(this));
        com.baidu.tieba.im.db.d a = com.baidu.tieba.im.db.d.a();
        zVar = this.a.b;
        a.a(zVar.c(), new u(this));
        StringBuilder append = new StringBuilder().append("clear cache by group:");
        zVar2 = this.a.b;
        TiebaSocketLinkService.a(true, append.append(zVar2.a()).toString());
        dialogInterface.cancel();
    }
}
