package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tieba.a.bc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity, com.baidu.tieba.a.bc bcVar) {
        this.a = frsActivity;
        this.b = bcVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        boolean z;
        ba baVar;
        switch (i) {
            case 0:
                str = this.a.j;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    com.baidu.tieba.a.bc bcVar = this.b;
                    z = this.a.k;
                    NewPbActivity.a(frsActivity, bcVar, null, 1800003, true, false, z);
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
        com.baidu.tieba.d.ab az = TiebaApplication.e().az();
        if (az != null && !az.b(this.b.a())) {
            az.a(this.b.a());
        }
        baVar = this.a.l;
        baVar.k();
    }
}
