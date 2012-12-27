package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
class i implements DialogInterface.OnClickListener {
    final /* synthetic */ HomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(HomeActivity homeActivity) {
        this.a = homeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.a.ac acVar;
        com.baidu.tieba.a.ac acVar2;
        switch (i) {
            case 0:
                acVar = this.a.l;
                if (acVar != null) {
                    acVar2 = this.a.l;
                    String b = acVar2.b();
                    if (com.baidu.tieba.c.ad.d(b)) {
                        FrsActivity.a(this.a, b, "tb_forumlist");
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.a.j();
                return;
            default:
                return;
        }
    }
}
