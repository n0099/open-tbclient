package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tieba.data.az b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity, com.baidu.tieba.data.az azVar) {
        this.a = frsActivity;
        this.b = azVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        br brVar;
        switch (i) {
            case 0:
                str = this.a.n;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    com.baidu.tieba.data.az azVar = this.b;
                    str2 = this.a.g;
                    z = this.a.o;
                    NewPbActivity.a(frsActivity, azVar, str2, null, 18003, true, false, z);
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
        com.baidu.tieba.util.bo at = TiebaApplication.g().at();
        if (at != null && !at.b(this.b.a())) {
            at.a(this.b.a());
        }
        brVar = this.a.p;
        brVar.r();
    }
}
