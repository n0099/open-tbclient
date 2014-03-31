package com.baidu.tieba.frs;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tbadk.core.data.o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsActivity frsActivity, com.baidu.tbadk.core.data.o oVar) {
        this.a = frsActivity;
        this.b = oVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        cm cmVar;
        switch (i) {
            case 0:
                str = this.a.p;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    com.baidu.tbadk.core.b.af afVar = new com.baidu.tbadk.core.b.af(this.a);
                    com.baidu.tbadk.core.data.o oVar = this.b;
                    str2 = this.a.i;
                    z = this.a.q;
                    frsActivity.sendMessage(new com.baidu.adp.framework.message.a(2004001, afVar.a(oVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.a.b(this.b);
                break;
            case 2:
                this.a.c(this.b);
                break;
        }
        com.baidu.tieba.util.p C = com.baidu.tieba.r.c().C();
        if (C != null && !C.b(this.b.l())) {
            C.a(this.b.l());
        }
        cmVar = this.a.r;
        cmVar.x();
    }
}
