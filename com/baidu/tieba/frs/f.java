package com.baidu.tieba.frs;

import android.content.DialogInterface;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements DialogInterface.OnClickListener {
    final /* synthetic */ com.baidu.tieba.data.bb a;
    final /* synthetic */ FrsActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity, com.baidu.tieba.data.bb bbVar) {
        this.b = frsActivity;
        this.a = bbVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        String str2;
        boolean z;
        bk bkVar;
        switch (i) {
            case 0:
                str = this.b.l;
                if (str != null) {
                    FrsActivity frsActivity = this.b;
                    com.baidu.tieba.data.bb bbVar = this.a;
                    str2 = this.b.f;
                    z = this.b.m;
                    NewPbActivity.a(frsActivity, bbVar, str2, null, 18003, true, false, z);
                    break;
                }
                break;
            case 1:
                this.b.c(this.a);
                break;
            case 2:
                this.b.d(this.a);
                break;
        }
        com.baidu.tieba.util.bq au = TiebaApplication.h().au();
        if (au != null && !au.b(this.a.a())) {
            au.a(this.a.a());
        }
        bkVar = this.b.n;
        bkVar.r();
    }
}
