package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tbadk.core.data.n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity, com.baidu.tbadk.core.data.n nVar) {
        this.a = frsActivity;
        this.b = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        ct ctVar;
        switch (i) {
            case 0:
                str = this.a.u;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    com.baidu.tbadk.core.atomData.ar arVar = new com.baidu.tbadk.core.atomData.ar(this.a);
                    com.baidu.tbadk.core.data.n nVar = this.b;
                    str2 = this.a.n;
                    z = this.a.v;
                    frsActivity.sendMessage(new CustomMessage(2006001, arVar.a(nVar, str2, null, 18003, true, false, z)));
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
        com.baidu.tieba.util.p C = com.baidu.tieba.ai.c().C();
        if (C != null && !C.b(this.b.p())) {
            C.a(this.b.p());
        }
        ctVar = this.a.w;
        ctVar.z();
    }
}
