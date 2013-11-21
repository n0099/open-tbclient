package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.text.ClipboardManager;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1693a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(n nVar, String str) {
        this.b = nVar;
        this.f1693a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GroupInfoActivity groupInfoActivity;
        GroupInfoActivity groupInfoActivity2;
        try {
            groupInfoActivity = this.b.f1687a;
            ((ClipboardManager) groupInfoActivity.getSystemService("clipboard")).setText(this.f1693a);
            groupInfoActivity2 = this.b.f1687a;
            groupInfoActivity2.showToast(R.string.copy_success);
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a("copy group introduction failed");
        }
    }
}
