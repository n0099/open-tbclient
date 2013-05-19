package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tieba.a.bb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity, com.baidu.tieba.a.bb bbVar) {
        this.a = frsActivity;
        this.b = bbVar;
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
                    com.baidu.tieba.a.bb bbVar = this.b;
                    z = this.a.k;
                    NewPbActivity.a(frsActivity, bbVar, null, 1800003, true, false, z);
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
        com.baidu.tieba.d.ab ap = TiebaApplication.d().ap();
        if (ap != null && !ap.b(this.b.a())) {
            ap.a(this.b.a());
        }
        baVar = this.a.l;
        baVar.k();
    }
}
