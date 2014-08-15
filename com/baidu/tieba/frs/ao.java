package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tbadk.core.data.n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsActivity frsActivity, com.baidu.tbadk.core.data.n nVar) {
        this.a = frsActivity;
        this.b = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        cu cuVar;
        switch (i) {
            case 0:
                str = this.a.x;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    com.baidu.tbadk.core.atomData.bb bbVar = new com.baidu.tbadk.core.atomData.bb(this.a);
                    com.baidu.tbadk.core.data.n nVar = this.b;
                    str2 = this.a.q;
                    z = this.a.y;
                    frsActivity.sendMessage(new CustomMessage(2004001, bbVar.a(nVar, str2, null, 18003, true, false, z)));
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
        com.baidu.tieba.util.p B = com.baidu.tieba.ai.c().B();
        if (B != null && this.b != null && !B.b(this.b.h())) {
            B.a(this.b.h());
        }
        cuVar = this.a.z;
        cuVar.z();
    }
}
