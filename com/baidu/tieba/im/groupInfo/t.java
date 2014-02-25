package com.baidu.tieba.im.groupInfo;

import android.content.DialogInterface;
import android.text.ClipboardManager;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements DialogInterface.OnClickListener {
    final /* synthetic */ m a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(m mVar, String str) {
        this.a = mVar;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        GroupInfoActivity groupInfoActivity;
        GroupInfoActivity groupInfoActivity2;
        try {
            groupInfoActivity = this.a.d;
            ((ClipboardManager) groupInfoActivity.getSystemService("clipboard")).setText(this.b);
            groupInfoActivity2 = this.a.d;
            groupInfoActivity2.showToast(R.string.copy_success);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("copy group introduction failed");
        }
    }
}
