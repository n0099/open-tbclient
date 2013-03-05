package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class n implements DialogInterface.OnClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.a.y yVar;
        com.baidu.tieba.a.y yVar2;
        switch (i) {
            case 0:
                yVar = this.a.r;
                if (yVar != null) {
                    yVar2 = this.a.r;
                    String b = yVar2.b();
                    if (com.baidu.tieba.c.af.d(b)) {
                        FrsActivity.a(this.a, b, "tb_forumlist");
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.a.m();
                return;
            default:
                return;
        }
    }
}
