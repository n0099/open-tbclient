package com.baidu.tieba.im.chat;

import android.content.DialogInterface;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupSettingActivity f1600a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(GroupSettingActivity groupSettingActivity) {
        this.f1600a = groupSettingActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        u uVar;
        com.baidu.tieba.ap.a(this.f1600a, "clear_group_msg_at_gsetting");
        this.f1600a.showLoadingDialog(this.f1600a.getString(R.string.deleting));
        com.baidu.tieba.im.db.ad.a().a(new o(this));
        com.baidu.tieba.im.db.d a2 = com.baidu.tieba.im.db.d.a();
        uVar = this.f1600a.b;
        a2.a(uVar.c(), new p(this));
        dialogInterface.cancel();
    }
}
