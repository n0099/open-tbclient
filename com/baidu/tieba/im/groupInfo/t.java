package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.text.ClipboardManager;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1760a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(m mVar, String str) {
        this.b = mVar;
        this.f1760a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GroupInfoActivity groupInfoActivity;
        GroupInfoActivity groupInfoActivity2;
        try {
            groupInfoActivity = this.b.f1753a;
            ((ClipboardManager) groupInfoActivity.getSystemService("clipboard")).setText(this.f1760a);
            groupInfoActivity2 = this.b.f1753a;
            groupInfoActivity2.showToast(R.string.copy_success);
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a("copy group number failed");
        }
    }
}
