package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tbadk.core.data.o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity, com.baidu.tbadk.core.data.o oVar) {
        this.a = frsActivity;
        this.b = oVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        cs csVar;
        switch (i) {
            case 0:
                str = this.a.u;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    com.baidu.tbadk.core.atomData.as asVar = new com.baidu.tbadk.core.atomData.as(this.a);
                    com.baidu.tbadk.core.data.o oVar = this.b;
                    str2 = this.a.n;
                    z = this.a.v;
                    frsActivity.sendMessage(new CustomMessage(2006001, asVar.a(oVar, str2, null, 18003, true, false, z)));
                    break;
                }
                break;
            case 1:
                this.a.c(this.b);
                break;
            case 2:
                this.a.d(this.b);
                break;
        }
        com.baidu.tieba.util.p C = com.baidu.tieba.ad.c().C();
        if (C != null && !C.b(this.b.k())) {
            C.a(this.b.k());
        }
        csVar = this.a.w;
        csVar.z();
    }
}
