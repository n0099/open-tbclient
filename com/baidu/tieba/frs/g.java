package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.bf f1283a;
    final /* synthetic */ FrsActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity, com.baidu.tieba.data.bf bfVar) {
        this.b = frsActivity;
        this.f1283a = bfVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        boolean z;
        ba baVar;
        switch (i) {
            case 0:
                str = this.b.m;
                if (str != null) {
                    FrsActivity frsActivity = this.b;
                    com.baidu.tieba.data.bf bfVar = this.f1283a;
                    z = this.b.n;
                    NewPbActivity.a(frsActivity, bfVar, null, 18003, true, false, z);
                    break;
                }
                break;
            case 1:
                this.b.c(this.f1283a);
                break;
            case 2:
                this.b.d(this.f1283a);
                break;
        }
        com.baidu.tieba.util.at az = TiebaApplication.g().az();
        if (az != null && !az.b(this.f1283a.a())) {
            az.a(this.f1283a.a());
        }
        baVar = this.b.o;
        baVar.l();
    }
}
