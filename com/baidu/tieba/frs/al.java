package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tbadk.core.data.m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity, com.baidu.tbadk.core.data.m mVar) {
        this.a = frsActivity;
        this.b = mVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        ct ctVar;
        switch (i) {
            case 0:
                str = this.a.t;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    com.baidu.tbadk.core.atomData.aw awVar = new com.baidu.tbadk.core.atomData.aw(this.a);
                    com.baidu.tbadk.core.data.m mVar = this.b;
                    str2 = this.a.m;
                    z = this.a.u;
                    frsActivity.sendMessage(new CustomMessage(2004001, awVar.a(mVar, str2, null, 18003, true, false, z)));
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
        ctVar = this.a.v;
        ctVar.y();
    }
}
