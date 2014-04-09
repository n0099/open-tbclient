package com.baidu.tieba.account;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class u implements DialogInterface.OnClickListener {
    final /* synthetic */ NotLoginGuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(NotLoginGuideActivity notLoginGuideActivity) {
        this.a = notLoginGuideActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tbadk.core.g.a(this.a, "sapi_fast_regist_click");
        SapiFastRegActivity.a(this.a, 22002);
    }
}
