package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {
    final /* synthetic */ FrsActivity a;
    private final /* synthetic */ com.baidu.tieba.data.ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity, com.baidu.tieba.data.ba baVar) {
        this.a = frsActivity;
        this.b = baVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        boolean z;
        az azVar;
        switch (i) {
            case 0:
                str = this.a.j;
                if (str != null) {
                    FrsActivity frsActivity = this.a;
                    com.baidu.tieba.data.ba baVar = this.b;
                    z = this.a.k;
                    NewPbActivity.a(frsActivity, baVar, null, 1800003, true, false, z);
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
        com.baidu.tieba.util.w aA = TiebaApplication.f().aA();
        if (aA != null && !aA.b(this.b.a())) {
            aA.a(this.b.a());
        }
        azVar = this.a.l;
        azVar.k();
    }
}
